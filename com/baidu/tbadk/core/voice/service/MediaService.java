package com.baidu.tbadk.core.voice.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.IBinder;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import c.a.s0.s.k0.c.d;
import c.a.s0.s.k0.c.e;
import com.baidu.adp.base.BdBaseService;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.lang.reflect.Method;
/* loaded from: classes11.dex */
public class MediaService extends BdBaseService implements MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mCurBeginSecond;
    public int mElapsedTime;
    public String mFilePath;
    public Handler mHandler;
    public Runnable mPlayTimeThread;
    public c.a.s0.s.k0.c.c mPlayer;
    public Runnable mRecordTimeThread;
    public d mRecorder;
    public long mSeekTime;
    public long mStartRecorderTime;
    public Voice mVoice;

    /* loaded from: classes11.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MediaService f40729e;

        public a(MediaService mediaService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40729e = mediaService;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f40729e.mHandler == null) {
                return;
            }
            int g2 = this.f40729e.mPlayer.g() + this.f40729e.mCurBeginSecond;
            if (g2 != this.f40729e.mElapsedTime) {
                this.f40729e.mElapsedTime = g2;
                Intent intent = new Intent("com.baidu.playElapsedTime");
                intent.putExtra("com.baidu.msg.playElapsedTime", this.f40729e.mElapsedTime);
                this.f40729e.sendBroadcast(intent);
            }
            this.f40729e.mHandler.postDelayed(this.f40729e.mPlayTimeThread, 100L);
        }
    }

    /* loaded from: classes11.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MediaService f40730e;

        public b(MediaService mediaService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40730e = mediaService;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int currentTimeMillis = (int) (System.currentTimeMillis() - this.f40730e.mStartRecorderTime);
                if (this.f40730e.mElapsedTime != currentTimeMillis) {
                    this.f40730e.mElapsedTime = currentTimeMillis / 1000;
                    Intent intent = new Intent("com.baidu.recordElapsedTime");
                    intent.putExtra("com.baidu.msg.recordElapsedTime", this.f40730e.mElapsedTime);
                    this.f40730e.sendBroadcast(intent);
                }
                this.f40730e.mHandler.postDelayed(this.f40730e.mRecordTimeThread, 200L);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class c implements MediaPlayer.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MediaService f40731e;

        public c(MediaService mediaService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40731e = mediaService;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) || this.f40731e.mPlayer == null || this.f40731e.mVoice == null) {
                return;
            }
            this.f40731e.mPlayer.b();
            this.f40731e.stopVoice(null);
        }
    }

    public MediaService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mElapsedTime = 0;
        this.mStartRecorderTime = 0L;
        this.mHandler = new Handler();
        this.mCurBeginSecond = 0;
        this.mVoice = null;
        this.mFilePath = new String();
        this.mPlayTimeThread = new a(this);
        this.mRecordTimeThread = new b(this);
        this.mRecorder = null;
        this.mPlayer = e.i();
        this.mSeekTime = 0L;
    }

    private int getVoiceTotalTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            Voice voice = this.mVoice;
            if (voice == null) {
                return 0;
            }
            long duration = voice.getDuration();
            if (duration == 0) {
                c.a.s0.s.k0.c.c cVar = this.mPlayer;
                if (cVar instanceof e) {
                    duration = ((e) cVar).getDuration() / 1000;
                }
            }
            return (int) duration;
        }
        return invokeV.intValue;
    }

    private long getVoiceTotalTimeByMediaPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            c.a.s0.s.k0.c.c cVar = this.mPlayer;
            if (cVar instanceof e) {
                return ((e) cVar).getDuration();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public static void initBroadcastReceivers(Context context, BroadcastReceiver broadcastReceiver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, context, broadcastReceiver) == null) {
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
    }

    public static void pausePlay(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, context) == null) {
            Intent intent = new Intent();
            intent.setAction("pauseVoice");
            startMy(context, intent);
        }
    }

    private void pauseRecord(Intent intent) {
        d dVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65551, this, intent) == null) && (dVar = this.mRecorder) != null && dVar.c()) {
            this.mRecorder.b();
            this.mHandler.removeCallbacks(this.mRecordTimeThread);
            Intent intent2 = new Intent("com.baidu.recordPaused");
            intent2.putExtra("com.baidu.msg.recordElapsedTime", this.mElapsedTime);
            sendBroadcast(intent2);
            this.mStartRecorderTime = 0L;
            this.mElapsedTime = 0;
        }
    }

    private void pauseVoice(Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65552, this, intent) == null) && this.mPlayer.isPlaying()) {
            this.mPlayer.e();
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
        c.a.s0.s.k0.c.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65553, this, intent) == null) && (cVar = this.mPlayer) != null && cVar.a()) {
            this.mPlayer.h();
            this.mHandler.post(this.mPlayTimeThread);
            if (this.mPlayer.isPlaying()) {
                Intent intent2 = new Intent("com.baidu.isPlaying");
                intent2.putExtra("com.baidu.msg.isPlaying", true);
                sendBroadcast(intent2);
            }
        }
    }

    public static void preparePlay(Context context, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65554, null, context, str, i2) == null) {
            preparePlay(context, str, i2, 0);
        }
    }

    private void preparePlayer(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, this, intent) == null) {
            this.mVoice = (Voice) intent.getParcelableExtra("com.baidu.voices");
            int intExtra = intent.getIntExtra("com.baidu.msg.curr_time", 0);
            int i2 = intExtra >= 0 ? intExtra : 0;
            if (this.mVoice == null) {
                return;
            }
            setPlayerCompleteListener();
            tryPreparePlayVoices(i2);
        }
    }

    private void prepareRecorder(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, this, intent) == null) {
            String stringExtra = intent.getStringExtra("com.baidu.notePath");
            String stringExtra2 = intent.getStringExtra("filePath");
            if (PermissionUtil.checkRecodeAudio(getApplicationContext())) {
                if (stringExtra2.endsWith(".amr")) {
                    this.mRecorder = MyAudioRecorder.f(Boolean.TRUE);
                } else {
                    this.mRecorder = new c.a.s0.s.k0.c.a();
                }
                boolean z = false;
                File file = new File(stringExtra);
                this.mFilePath = stringExtra + File.separator + stringExtra2;
                if (file.exists()) {
                    if (file.isDirectory() && file.canRead() && file.canWrite()) {
                        z = this.mRecorder.d(this.mFilePath);
                    }
                } else {
                    file.mkdir();
                    if (file.isDirectory() && file.canRead() && file.canWrite()) {
                        z = this.mRecorder.d(this.mFilePath);
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
    }

    public static void seekVoice(Context context, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65558, null, context, j2) == null) {
            Intent intent = new Intent();
            intent.putExtra("com.baidu.seekTime", j2);
            intent.setAction("seekVoice");
            startMy(context, intent);
        }
    }

    private void setPlayerCompleteListener() {
        c.a.s0.s.k0.c.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65560, this) == null) && (cVar = this.mPlayer) != null && (cVar instanceof e)) {
            ((e) cVar).setOnErrorListener(this);
            ((e) this.mPlayer).setOnPreparedListener(this);
            ((e) this.mPlayer).setOnCompletionListener(new c(this));
        }
    }

    public static void startMy(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65561, null, context, intent) == null) || context == null) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, null, context) == null) {
            Intent intent = new Intent();
            intent.setAction("playVoice");
            startMy(context, intent);
        }
    }

    private void startRecord(Intent intent) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65563, this, intent) == null) || (dVar = this.mRecorder) == null) {
            return;
        }
        dVar.e();
        this.mStartRecorderTime = System.currentTimeMillis();
        this.mHandler.post(this.mRecordTimeThread);
        Intent intent2 = new Intent("com.baidu.mediaIsRecording");
        intent2.putExtra("com.baidu.msg.isRecording", true);
        sendBroadcast(intent2);
    }

    private void stopAndReplay(Intent intent) {
        c.a.s0.s.k0.c.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65564, this, intent) == null) || this.mVoice == null || (cVar = this.mPlayer) == null) {
            return;
        }
        long g2 = cVar.g();
        if (g2 < 0) {
            return;
        }
        this.mPlayer.b();
        this.mPlayer.f();
        long duration = this.mVoice.getDuration();
        if (duration <= 0 || g2 > duration) {
            return;
        }
        c.a.s0.s.k0.c.c cVar2 = this.mPlayer;
        if (cVar2 instanceof e) {
            ((e) cVar2).setOnPreparedListener(null);
        }
        if (this.mPlayer.c(this.mVoice.getName())) {
            this.mPlayer.seek((int) g2);
            playVoice(null);
        }
    }

    public static void stopAndReplayVoice(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65565, null, context) == null) {
            Intent intent = new Intent();
            intent.setAction("stopAndReplay");
            startMy(context, intent);
        }
    }

    public static void stopMy(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65566, null, context) == null) || context == null) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65567, null, context) == null) {
            Intent intent = new Intent();
            intent.setAction("stopVoice");
            startMy(context, intent);
        }
    }

    private void stopRecord(Intent intent) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65568, this, intent) == null) || (dVar = this.mRecorder) == null) {
            return;
        }
        dVar.b();
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65569, this, intent) == null) {
            this.mHandler.removeCallbacks(this.mPlayTimeThread);
            this.mElapsedTime = 0;
            this.mCurBeginSecond = 0;
            c.a.s0.s.k0.c.c cVar = this.mPlayer;
            if (cVar instanceof e) {
                ((e) cVar).setOnCompletionListener(null);
            }
            int g2 = this.mPlayer.g();
            Intent intent2 = new Intent("com.baidu.isStoped");
            intent2.putExtra("com.baidu.msg.curr_time", g2);
            sendBroadcast(intent2);
            this.mPlayer.b();
        }
    }

    private void tryPreparePlayVoices(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65570, this, j2) == null) {
            this.mSeekTime = j2;
            Voice voice = this.mVoice;
            e.i().f();
            if (!this.mPlayer.c(voice.getName()) && this.mPlayer.d() != -1) {
                Intent intent = new Intent("com.baidu.playPrepared");
                intent.putExtra("com.baidu.playPrepared_err_code", this.mPlayer.d());
                sendBroadcast(intent);
                this.mSeekTime = 0L;
            }
            this.mCurBeginSecond = 0;
        }
    }

    public static void unregisterReceiver(Context context, BroadcastReceiver broadcastReceiver) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65571, null, context, broadcastReceiver) == null) || context == null || broadcastReceiver == null) {
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
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
            return null;
        }
        return (IBinder) invokeL.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onCreate();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.removeCallbacks(this.mPlayTimeThread);
            }
            this.mHandler = null;
            this.mVoice = null;
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, mediaPlayer, i2, i3)) == null) {
            return false;
        }
        return invokeLII.booleanValue;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mediaPlayer) == null) {
            Intent intent = new Intent("com.baidu.playPrepared");
            intent.setFlags(1073741824);
            intent.putExtra("com.baidu.playPrepared_err_code", -1);
            int voiceTotalTime = getVoiceTotalTime();
            long j2 = voiceTotalTime * 1000;
            long voiceTotalTimeByMediaPlayer = getVoiceTotalTimeByMediaPlayer();
            if (voiceTotalTimeByMediaPlayer - j2 <= 1000 && voiceTotalTimeByMediaPlayer >= j2) {
                j2 = voiceTotalTimeByMediaPlayer;
            }
            intent.putExtra("com.baidu.msg.durationTime", voiceTotalTime);
            intent.putExtra("com.baidu.msg.durationTime2", j2);
            int i2 = (this.mSeekTime > 0L ? 1 : (this.mSeekTime == 0L ? 0 : -1));
            this.mSeekTime = 0L;
            sendBroadcast(intent);
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, intent, i2) == null) {
            super.onStart(intent, i2);
        }
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048582, this, intent, i2, i3)) == null) {
            if (intent == null) {
                return super.onStartCommand(intent, i2, i3);
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
                return super.onStartCommand(intent, i2, i3);
            }
            return super.onStartCommand(intent, i2, i3);
        }
        return invokeLII.intValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, intent) == null) {
            try {
                LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
            } catch (Throwable unused) {
                super.sendBroadcast(intent);
            }
        }
    }

    public static void preparePlay(Context context, String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65555, null, context, str, i2, i3) == null) {
            Intent intent = new Intent();
            intent.setAction("preparePlayer");
            Voice voice = new Voice();
            voice.setName(str);
            voice.setDuration(i2);
            intent.putExtra("com.baidu.voices", voice);
            intent.putExtra("com.baidu.msg.curr_time", i3);
            startMy(context, intent);
        }
    }

    private void seekVoice(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65559, this, intent) == null) || this.mVoice == null) {
            return;
        }
        this.mPlayer.f();
        long longExtra = intent.getLongExtra("com.baidu.seekTime", 0L);
        if (longExtra < 0) {
            return;
        }
        long duration = this.mVoice.getDuration();
        if (duration <= 0 || longExtra > duration) {
            return;
        }
        c.a.s0.s.k0.c.c cVar = this.mPlayer;
        if (cVar instanceof e) {
            ((e) cVar).setOnPreparedListener(null);
        }
        if (this.mPlayer.c(this.mVoice.getName())) {
            this.mPlayer.seek((int) longExtra);
            playVoice(null);
        }
    }
}
