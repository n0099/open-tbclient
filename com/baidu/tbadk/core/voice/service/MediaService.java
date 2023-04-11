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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tieba.a75;
import com.baidu.tieba.c75;
import com.baidu.tieba.d75;
import com.baidu.tieba.e75;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public class MediaService extends BdBaseService implements MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mCurBeginSecond;
    public int mElapsedTime;
    public String mFilePath;
    public Handler mHandler;
    public Runnable mPlayTimeThread;
    public c75 mPlayer;
    public Runnable mRecordTimeThread;
    public d75 mRecorder;
    public long mSeekTime;
    public long mStartRecorderTime;
    public Voice mVoice;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
            return null;
        }
        return (IBinder) invokeL.objValue;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, mediaPlayer, i, i2)) == null) {
            return false;
        }
        return invokeLII.booleanValue;
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MediaService a;

        public a(MediaService mediaService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mediaService;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.mHandler == null) {
                return;
            }
            int f = this.a.mPlayer.f() + this.a.mCurBeginSecond;
            if (f != this.a.mElapsedTime) {
                this.a.mElapsedTime = f;
                Intent intent = new Intent("com.baidu.playElapsedTime");
                intent.putExtra("com.baidu.msg.playElapsedTime", this.a.mElapsedTime);
                this.a.sendBroadcast(intent);
            }
            this.a.mHandler.postDelayed(this.a.mPlayTimeThread, 100L);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MediaService a;

        public b(MediaService mediaService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mediaService;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int currentTimeMillis = (int) (System.currentTimeMillis() - this.a.mStartRecorderTime);
                if (this.a.mElapsedTime != currentTimeMillis) {
                    this.a.mElapsedTime = currentTimeMillis / 1000;
                    Intent intent = new Intent("com.baidu.recordElapsedTime");
                    intent.putExtra("com.baidu.msg.recordElapsedTime", this.a.mElapsedTime);
                    this.a.sendBroadcast(intent);
                }
                this.a.mHandler.postDelayed(this.a.mRecordTimeThread, 200L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements MediaPlayer.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MediaService a;

        public c(MediaService mediaService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mediaService;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, mediaPlayer) != null) || this.a.mPlayer == null || this.a.mVoice == null) {
                return;
            }
            this.a.mPlayer.a();
            this.a.stopVoice(null);
        }
    }

    public MediaService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        this.mPlayer = e75.h();
        this.mSeekTime = 0L;
    }

    public static void pausePlay(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, context) == null) {
            Intent intent = new Intent();
            intent.setAction("pauseVoice");
            startMy(context, intent);
        }
    }

    private void preparePlayer(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, this, intent) == null) {
            this.mVoice = (Voice) intent.getParcelableExtra("com.baidu.voices");
            int i = 0;
            int intExtra = intent.getIntExtra("com.baidu.msg.curr_time", 0);
            if (intExtra >= 0) {
                i = intExtra;
            }
            if (this.mVoice == null) {
                return;
            }
            setPlayerCompleteListener();
            tryPreparePlayVoices(i);
        }
    }

    public static void startPlay(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, context) == null) {
            Intent intent = new Intent();
            intent.setAction("playVoice");
            startMy(context, intent);
        }
    }

    public static void stopAndReplayVoice(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, null, context) == null) {
            Intent intent = new Intent();
            intent.setAction("stopAndReplay");
            startMy(context, intent);
        }
    }

    public static void stopMy(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65564, null, context) != null) || context == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(context, MediaService.class);
        try {
            context.stopService(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void stopPlay(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65565, null, context) == null) {
            Intent intent = new Intent();
            intent.setAction("stopVoice");
            startMy(context, intent);
        }
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

    public static void startMy(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65559, null, context, intent) != null) || context == null) {
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

    public static void unregisterReceiver(Context context, BroadcastReceiver broadcastReceiver) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65569, null, context, broadcastReceiver) == null) && context != null && broadcastReceiver != null) {
            try {
                LocalBroadcastManager.getInstance(context).unregisterReceiver(broadcastReceiver);
            } catch (Throwable unused) {
                context.unregisterReceiver(broadcastReceiver);
            }
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, intent, i) == null) {
            super.onStart(intent, i);
        }
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
                c75 c75Var = this.mPlayer;
                if (c75Var instanceof e75) {
                    duration = ((e75) c75Var).getDuration() / 1000;
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
            c75 c75Var = this.mPlayer;
            if (c75Var instanceof e75) {
                return ((e75) c75Var).getDuration();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    private void setPlayerCompleteListener() {
        c75 c75Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65558, this) == null) && (c75Var = this.mPlayer) != null && (c75Var instanceof e75)) {
            ((e75) c75Var).setOnErrorListener(this);
            ((e75) this.mPlayer).setOnPreparedListener(this);
            ((e75) this.mPlayer).setOnCompletionListener(new c(this));
        }
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

    private void pauseRecord(Intent intent) {
        d75 d75Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65551, this, intent) == null) && (d75Var = this.mRecorder) != null && d75Var.c()) {
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
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65552, this, intent) == null) && this.mPlayer.isPlaying()) {
            this.mPlayer.d();
            this.mHandler.removeCallbacks(this.mPlayTimeThread);
            if (!this.mPlayer.isPlaying()) {
                Intent intent2 = new Intent("com.baidu.isPlaying");
                intent2.putExtra("com.baidu.msg.isPlaying", false);
                sendBroadcast(intent2);
            }
        }
    }

    private void playVoice(Intent intent) {
        c75 c75Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65553, this, intent) != null) || (c75Var = this.mPlayer) == null || !c75Var.isPrepared()) {
            return;
        }
        this.mPlayer.g();
        this.mHandler.post(this.mPlayTimeThread);
        if (this.mPlayer.isPlaying()) {
            Intent intent2 = new Intent("com.baidu.isPlaying");
            intent2.putExtra("com.baidu.msg.isPlaying", true);
            sendBroadcast(intent2);
        }
    }

    private void startRecord(Intent intent) {
        d75 d75Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65561, this, intent) != null) || (d75Var = this.mRecorder) == null) {
            return;
        }
        d75Var.e();
        this.mStartRecorderTime = System.currentTimeMillis();
        this.mHandler.post(this.mRecordTimeThread);
        Intent intent2 = new Intent("com.baidu.mediaIsRecording");
        intent2.putExtra("com.baidu.msg.isRecording", true);
        sendBroadcast(intent2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopVoice(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65567, this, intent) == null) {
            this.mHandler.removeCallbacks(this.mPlayTimeThread);
            this.mElapsedTime = 0;
            this.mCurBeginSecond = 0;
            c75 c75Var = this.mPlayer;
            if (c75Var instanceof e75) {
                ((e75) c75Var).setOnCompletionListener(null);
            }
            int f = this.mPlayer.f();
            Intent intent2 = new Intent("com.baidu.isStoped");
            intent2.putExtra("com.baidu.msg.curr_time", f);
            sendBroadcast(intent2);
            this.mPlayer.a();
        }
    }

    public static void preparePlay(Context context, String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65554, null, context, str, i, i2) == null) {
            Intent intent = new Intent();
            intent.setAction("preparePlayer");
            Voice voice = new Voice();
            voice.setName(str);
            voice.setDuration(i);
            intent.putExtra("com.baidu.voices", voice);
            intent.putExtra("com.baidu.msg.curr_time", i2);
            startMy(context, intent);
        }
    }

    private void prepareRecorder(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, this, intent) == null) {
            String stringExtra = intent.getStringExtra("com.baidu.notePath");
            String stringExtra2 = intent.getStringExtra("filePath");
            if (!PermissionUtil.checkRecodeAudio(getApplicationContext())) {
                return;
            }
            if (stringExtra2.endsWith(".amr")) {
                this.mRecorder = MyAudioRecorder.f(Boolean.TRUE);
            } else {
                this.mRecorder = new a75();
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

    private void seekVoice(Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65557, this, intent) != null) || this.mVoice == null) {
            return;
        }
        this.mPlayer.e();
        long longExtra = intent.getLongExtra("com.baidu.seekTime", 0L);
        if (longExtra < 0) {
            return;
        }
        long duration = this.mVoice.getDuration();
        if (duration > 0 && longExtra <= duration) {
            c75 c75Var = this.mPlayer;
            if (c75Var instanceof e75) {
                ((e75) c75Var).setOnPreparedListener(null);
            }
            if (this.mPlayer.b(this.mVoice.getName())) {
                this.mPlayer.seek((int) longExtra);
                playVoice(null);
            }
        }
    }

    private void stopAndReplay(Intent intent) {
        c75 c75Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65562, this, intent) == null) && this.mVoice != null && (c75Var = this.mPlayer) != null) {
            long f = c75Var.f();
            if (f < 0) {
                return;
            }
            this.mPlayer.a();
            this.mPlayer.e();
            long duration = this.mVoice.getDuration();
            if (duration > 0 && f <= duration) {
                c75 c75Var2 = this.mPlayer;
                if (c75Var2 instanceof e75) {
                    ((e75) c75Var2).setOnPreparedListener(null);
                }
                if (this.mPlayer.b(this.mVoice.getName())) {
                    this.mPlayer.seek((int) f);
                    playVoice(null);
                }
            }
        }
    }

    private void stopRecord(Intent intent) {
        d75 d75Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65566, this, intent) != null) || (d75Var = this.mRecorder) == null) {
            return;
        }
        d75Var.a();
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

    private void tryPreparePlayVoices(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65568, this, j) == null) {
            this.mSeekTime = j;
            Voice voice = this.mVoice;
            e75.h().e();
            if (!this.mPlayer.b(voice.getName()) && this.mPlayer.c() != -1) {
                Intent intent = new Intent("com.baidu.playPrepared");
                intent.putExtra("com.baidu.playPrepared_err_code", this.mPlayer.c());
                sendBroadcast(intent);
                this.mSeekTime = 0L;
            }
            this.mCurBeginSecond = 0;
        }
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mediaPlayer) == null) {
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
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048582, this, intent, i, i2)) == null) {
            if (intent == null) {
                return super.onStartCommand(intent, i, i2);
            }
            String action = intent.getAction();
            if (action != null && action.length() != 0) {
                try {
                    Method declaredMethod = getClass().getDeclaredMethod(action, Intent.class);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(this, intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return super.onStartCommand(intent, i, i2);
            }
            return super.onStartCommand(intent, i, i2);
        }
        return invokeLII.intValue;
    }
}
