package com.baidu.tbadk.core.voice.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.IBinder;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.adp.base.BdBaseService;
import com.baidu.tbadk.core.util.PermissionUtil;
import d.b.h0.r.g0.c.d;
import d.b.h0.r.g0.c.e;
import java.io.File;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public class MediaService extends BdBaseService implements MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener {
    public int mElapsedTime = 0;
    public long mStartRecorderTime = 0;
    public Handler mHandler = new Handler();
    public int mCurBeginSecond = 0;
    public Voice mVoice = null;
    public String mFilePath = new String();
    public Runnable mPlayTimeThread = new a();
    public Runnable mRecordTimeThread = new b();
    public d mRecorder = null;
    public d.b.h0.r.g0.c.c mPlayer = e.i();
    public long mSeekTime = 0;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MediaService.this.mHandler == null) {
                return;
            }
            int b2 = MediaService.this.mPlayer.b() + MediaService.this.mCurBeginSecond;
            if (b2 != MediaService.this.mElapsedTime) {
                MediaService.this.mElapsedTime = b2;
                Intent intent = new Intent("com.baidu.playElapsedTime");
                intent.putExtra("com.baidu.msg.playElapsedTime", MediaService.this.mElapsedTime);
                MediaService.this.sendBroadcast(intent);
            }
            MediaService.this.mHandler.postDelayed(MediaService.this.mPlayTimeThread, 100L);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int currentTimeMillis = (int) (System.currentTimeMillis() - MediaService.this.mStartRecorderTime);
            if (MediaService.this.mElapsedTime != currentTimeMillis) {
                MediaService.this.mElapsedTime = currentTimeMillis / 1000;
                Intent intent = new Intent("com.baidu.recordElapsedTime");
                intent.putExtra("com.baidu.msg.recordElapsedTime", MediaService.this.mElapsedTime);
                MediaService.this.sendBroadcast(intent);
            }
            MediaService.this.mHandler.postDelayed(MediaService.this.mRecordTimeThread, 200L);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements MediaPlayer.OnCompletionListener {
        public c() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (MediaService.this.mPlayer == null || MediaService.this.mVoice == null) {
                return;
            }
            MediaService.this.mPlayer.a();
            MediaService.this.stopVoice(null);
        }
    }

    private int getVoiceTotalTime() {
        Voice voice = this.mVoice;
        if (voice == null) {
            return 0;
        }
        long a2 = voice.a();
        if (a2 == 0) {
            d.b.h0.r.g0.c.c cVar = this.mPlayer;
            if (cVar instanceof e) {
                a2 = ((e) cVar).getDuration() / 1000;
            }
        }
        return (int) a2;
    }

    private long getVoiceTotalTimeByMediaPlayer() {
        d.b.h0.r.g0.c.c cVar = this.mPlayer;
        if (cVar instanceof e) {
            return ((e) cVar).getDuration();
        }
        return 0L;
    }

    public static void initBroadcastReceivers(Context context, BroadcastReceiver broadcastReceiver) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.playPrepared");
        intentFilter.addAction("com.baidu.isPlaying");
        intentFilter.addAction("com.baidu.isStoped");
        intentFilter.addAction("com.baidu.playElapsedTime");
        intentFilter.addAction("com.baidu.recognize");
        try {
            LocalBroadcastManager.getInstance(context).registerReceiver(broadcastReceiver, intentFilter);
        } catch (Throwable unused) {
            context.registerReceiver(broadcastReceiver, intentFilter);
        }
    }

    public static void pausePlay(Context context) {
        Intent intent = new Intent();
        intent.setAction("pauseVoice");
        startMy(context, intent);
    }

    private void pauseRecord(Intent intent) {
        d dVar = this.mRecorder;
        if (dVar != null && dVar.d()) {
            this.mRecorder.a();
            this.mHandler.removeCallbacks(this.mRecordTimeThread);
            Intent intent2 = new Intent("com.baidu.recordPaused");
            intent2.putExtra("com.baidu.msg.recordElapsedTime", this.mElapsedTime);
            sendBroadcast(intent2);
            this.mStartRecorderTime = 0L;
            this.mElapsedTime = 0;
        }
    }

    private void pauseVoice(Intent intent) {
        if (this.mPlayer.isPlaying()) {
            this.mPlayer.g();
            this.mHandler.removeCallbacks(this.mPlayTimeThread);
            if (this.mPlayer.isPlaying()) {
                return;
            }
            Intent intent2 = new Intent("com.baidu.isPlaying");
            intent2.putExtra("com.baidu.msg.isPlaying", false);
            sendBroadcast(intent2);
        }
    }

    private void playVoice(Intent intent) {
        d.b.h0.r.g0.c.c cVar = this.mPlayer;
        if (cVar != null && cVar.f()) {
            this.mPlayer.d();
            this.mHandler.post(this.mPlayTimeThread);
            if (this.mPlayer.isPlaying()) {
                Intent intent2 = new Intent("com.baidu.isPlaying");
                intent2.putExtra("com.baidu.msg.isPlaying", true);
                sendBroadcast(intent2);
            }
        }
    }

    public static void preparePlay(Context context, String str, int i) {
        preparePlay(context, str, i, 0);
    }

    private void preparePlayer(Intent intent) {
        this.mVoice = (Voice) intent.getParcelableExtra("com.baidu.voices");
        int intExtra = intent.getIntExtra("com.baidu.msg.curr_time", 0);
        int i = intExtra >= 0 ? intExtra : 0;
        if (this.mVoice == null) {
            return;
        }
        setPlayerCompleteListener();
        tryPreparePlayVoices(i);
    }

    private void prepareRecorder(Intent intent) {
        String stringExtra = intent.getStringExtra("com.baidu.notePath");
        String stringExtra2 = intent.getStringExtra("filePath");
        if (PermissionUtil.checkRecodeAudio(getApplicationContext())) {
            if (stringExtra2.endsWith(".amr")) {
                this.mRecorder = MyAudioRecorder.f(Boolean.TRUE);
            } else {
                this.mRecorder = new d.b.h0.r.g0.c.a();
            }
            boolean z = false;
            File file = new File(stringExtra);
            this.mFilePath = stringExtra + File.separator + stringExtra2;
            if (file.exists()) {
                if (file.isDirectory() && file.canRead() && file.canWrite()) {
                    z = this.mRecorder.b(this.mFilePath);
                }
            } else {
                file.mkdir();
                if (file.isDirectory() && file.canRead() && file.canWrite()) {
                    z = this.mRecorder.b(this.mFilePath);
                }
            }
            if (z) {
                Intent intent2 = new Intent();
                intent2.setAction("com.baidu.recordPrepared");
                intent2.putExtra("com.baidu.msg.recordPrepared", true);
                intent2.putExtra("com.baidu.msg.preparedName", stringExtra2);
                sendBroadcast(intent2);
            }
        }
    }

    public static void seekVoice(Context context, long j) {
        Intent intent = new Intent();
        intent.putExtra("com.baidu.seekTime", j);
        intent.setAction("seekVoice");
        startMy(context, intent);
    }

    private void setPlayerCompleteListener() {
        d.b.h0.r.g0.c.c cVar = this.mPlayer;
        if (cVar != null && (cVar instanceof e)) {
            ((e) cVar).setOnErrorListener(this);
            ((e) this.mPlayer).setOnPreparedListener(this);
            ((e) this.mPlayer).setOnCompletionListener(new c());
        }
    }

    public static void startMy(Context context, Intent intent) {
        if (context == null) {
            return;
        }
        if (intent == null) {
            intent = new Intent();
        }
        intent.setClass(context, MediaService.class);
        try {
            context.startService(intent);
        } catch (Exception unused) {
        }
    }

    public static void startPlay(Context context) {
        Intent intent = new Intent();
        intent.setAction("playVoice");
        startMy(context, intent);
    }

    private void startRecord(Intent intent) {
        d dVar = this.mRecorder;
        if (dVar == null) {
            return;
        }
        dVar.c();
        this.mStartRecorderTime = System.currentTimeMillis();
        this.mHandler.post(this.mRecordTimeThread);
        Intent intent2 = new Intent("com.baidu.mediaIsRecording");
        intent2.putExtra("com.baidu.msg.isRecording", true);
        sendBroadcast(intent2);
    }

    private void stopAndReplay(Intent intent) {
        d.b.h0.r.g0.c.c cVar;
        if (this.mVoice == null || (cVar = this.mPlayer) == null) {
            return;
        }
        long b2 = cVar.b();
        if (b2 < 0) {
            return;
        }
        this.mPlayer.a();
        this.mPlayer.h();
        long a2 = this.mVoice.a();
        if (a2 <= 0 || b2 > a2) {
            return;
        }
        d.b.h0.r.g0.c.c cVar2 = this.mPlayer;
        if (cVar2 instanceof e) {
            ((e) cVar2).setOnPreparedListener(null);
        }
        if (this.mPlayer.c(this.mVoice.b())) {
            this.mPlayer.seek((int) b2);
            playVoice(null);
        }
    }

    public static void stopAndReplayVoice(Context context) {
        Intent intent = new Intent();
        intent.setAction("stopAndReplay");
        startMy(context, intent);
    }

    public static void stopMy(Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(context, MediaService.class);
        try {
            context.stopService(intent);
        } catch (Exception unused) {
        }
    }

    public static void stopPlay(Context context) {
        Intent intent = new Intent();
        intent.setAction("stopVoice");
        startMy(context, intent);
    }

    private void stopRecord(Intent intent) {
        d dVar = this.mRecorder;
        if (dVar == null) {
            return;
        }
        dVar.a();
        this.mHandler.removeCallbacks(this.mRecordTimeThread);
        Intent intent2 = new Intent("com.baidu.recordStopped");
        intent2.putExtra("com.baidu.msg.recordElapsedTime", this.mElapsedTime);
        File file = new File(this.mFilePath);
        if (file.exists()) {
            intent2.putExtra("com.baidu.msg.sizeofbyte", file.length());
        }
        sendBroadcast(intent2);
        this.mStartRecorderTime = 0L;
        this.mElapsedTime = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopVoice(Intent intent) {
        this.mHandler.removeCallbacks(this.mPlayTimeThread);
        this.mElapsedTime = 0;
        this.mCurBeginSecond = 0;
        d.b.h0.r.g0.c.c cVar = this.mPlayer;
        if (cVar instanceof e) {
            ((e) cVar).setOnCompletionListener(null);
        }
        int b2 = this.mPlayer.b();
        Intent intent2 = new Intent("com.baidu.isStoped");
        intent2.putExtra("com.baidu.msg.curr_time", b2);
        sendBroadcast(intent2);
        this.mPlayer.a();
    }

    private void tryPreparePlayVoices(long j) {
        this.mSeekTime = j;
        Voice voice = this.mVoice;
        e.i().h();
        if (!this.mPlayer.c(voice.b()) && this.mPlayer.e() != -1) {
            Intent intent = new Intent("com.baidu.playPrepared");
            intent.putExtra("com.baidu.playPrepared_err_code", this.mPlayer.e());
            sendBroadcast(intent);
            this.mSeekTime = 0L;
        }
        this.mCurBeginSecond = 0;
    }

    public static void unregisterReceiver(Context context, BroadcastReceiver broadcastReceiver) {
        if (context == null || broadcastReceiver == null) {
            return;
        }
        try {
            LocalBroadcastManager.getInstance(context).unregisterReceiver(broadcastReceiver);
        } catch (Throwable unused) {
            if (context == null || broadcastReceiver == null) {
                return;
            }
            context.unregisterReceiver(broadcastReceiver);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mPlayTimeThread);
        }
        this.mHandler = null;
        this.mVoice = null;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        return false;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        Intent intent = new Intent("com.baidu.playPrepared");
        intent.setFlags(1073741824);
        intent.putExtra("com.baidu.playPrepared_err_code", -1);
        int voiceTotalTime = getVoiceTotalTime();
        long j = voiceTotalTime * 1000;
        long voiceTotalTimeByMediaPlayer = getVoiceTotalTimeByMediaPlayer();
        if (voiceTotalTimeByMediaPlayer - j <= 1000 && voiceTotalTimeByMediaPlayer >= j) {
            j = voiceTotalTimeByMediaPlayer;
        }
        intent.putExtra("com.baidu.msg.durationTime", voiceTotalTime);
        intent.putExtra("com.baidu.msg.durationTime2", j);
        int i = (this.mSeekTime > 0L ? 1 : (this.mSeekTime == 0L ? 0 : -1));
        this.mSeekTime = 0L;
        sendBroadcast(intent);
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            return super.onStartCommand(intent, i, i2);
        }
        String action = intent.getAction();
        if (action != null && action.length() != 0) {
            try {
                Method declaredMethod = getClass().getDeclaredMethod(action, Intent.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(this, intent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return super.onStartCommand(intent, i, i2);
        }
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent) {
        try {
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        } catch (Throwable unused) {
            super.sendBroadcast(intent);
        }
    }

    public static void preparePlay(Context context, String str, int i, int i2) {
        Intent intent = new Intent();
        intent.setAction("preparePlayer");
        Voice voice = new Voice();
        voice.d(str);
        voice.c(i);
        intent.putExtra("com.baidu.voices", voice);
        intent.putExtra("com.baidu.msg.curr_time", i2);
        startMy(context, intent);
    }

    private void seekVoice(Intent intent) {
        if (this.mVoice == null) {
            return;
        }
        this.mPlayer.h();
        long longExtra = intent.getLongExtra("com.baidu.seekTime", 0L);
        if (longExtra < 0) {
            return;
        }
        long a2 = this.mVoice.a();
        if (a2 <= 0 || longExtra > a2) {
            return;
        }
        d.b.h0.r.g0.c.c cVar = this.mPlayer;
        if (cVar instanceof e) {
            ((e) cVar).setOnPreparedListener(null);
        }
        if (this.mPlayer.c(this.mVoice.b())) {
            this.mPlayer.seek((int) longExtra);
            playVoice(null);
        }
    }
}
