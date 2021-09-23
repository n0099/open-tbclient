package com.baidu.tbadk.core.voice;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.FieldBuilder;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.voice.service.MediaService;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Date;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes6.dex */
public class VoiceManager extends BroadcastReceiver implements SensorEventListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean BOOLEAN_SEEKTO = false;
    public static final String MI3_MODEL_NAME = "MI 3W";
    public static final int MI3_REGISTER_DELAY = 300;
    public static boolean bInitConfig = false;
    public static Integer bInitMode = null;
    public static Boolean bInitSpeakerphoneOn = null;
    public static Integer bInitVolume = null;
    public static boolean bUseMedaiPlayer = false;
    public static boolean bVoiceUseSoftDecoder = false;
    public static float eym = 0.5f;
    public transient /* synthetic */ FieldHolder $fh;
    public AudioManager audioManager;
    public boolean bAllowChangeVoiceMode;
    public boolean bFirstSetSpeaker;
    public boolean bSensorRegistered;
    public Boolean bSpeaker;
    public Boolean bSpeakerphoneOn;
    public boolean bStopAndReplay;
    public boolean b_BlUETOOTH_HEADSET_PLUG;
    public boolean b_HEADSET_PLUG;
    public TbPageContext<?> context;
    public boolean isAddScreenView;
    public VoiceData$VoiceModel mCurPlayModel;
    public Handler mHandle;
    public VoiceData$VoiceModel mNewClickModel;
    public PermissionJudgePolicy mPermissionJudgePolicy;
    public boolean mPhoneSpeaker;
    public k mPlayCall;
    public CustomResponsedMessage<c.a.r0.j3.q0.a> mRecorderManagerRespMsg;
    public c.a.e.e.l.c<c.a.q0.s.g0.b.a> mResourceCall;
    public final BroadcastReceiver mVoicePlayerReceiver;
    public Sensor proximitySensor;
    public i sNewPlayView;
    public i sPlayView;
    public View screenView;
    public SensorManager sensorManager;
    public long sensorRegisterTime;
    public Runnable setSpeakerphoneOnRunnable;
    public final Runnable startPlayRunnable;
    public CustomMessageListener stopListener;
    public Runnable stopVoiceAndRePlayRunnable;
    public final Runnable unRegistSensorRunnable;
    public WindowManager windowManager;
    public WindowManager.LayoutParams windowParams;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class PlayMode {
        public static final /* synthetic */ PlayMode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final PlayMode HEADSET;
        public static final PlayMode SPEAKER;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1450522277, "Lcom/baidu/tbadk/core/voice/VoiceManager$PlayMode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1450522277, "Lcom/baidu/tbadk/core/voice/VoiceManager$PlayMode;");
                    return;
                }
            }
            SPEAKER = new PlayMode("SPEAKER", 0);
            PlayMode playMode = new PlayMode("HEADSET", 1);
            HEADSET = playMode;
            $VALUES = new PlayMode[]{SPEAKER, playMode};
        }

        public PlayMode(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static PlayMode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (PlayMode) Enum.valueOf(PlayMode.class, str) : (PlayMode) invokeL.objValue;
        }

        public static PlayMode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (PlayMode[]) $VALUES.clone() : (PlayMode[]) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VoiceManager f48166a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(VoiceManager voiceManager, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voiceManager, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48166a = voiceManager;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean bool;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001273) {
                this.f48166a.stopPlay();
                if ((customResponsedMessage.getData() instanceof Boolean) && (bool = (Boolean) customResponsedMessage.getData()) != null && bool.booleanValue()) {
                    VoiceManager voiceManager = this.f48166a;
                    voiceManager.bSpeaker = voiceManager.isSpeakerphone();
                    this.f48166a.setSpeakerphone(false);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VoiceManager f48167e;

        public b(VoiceManager voiceManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voiceManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48167e = voiceManager;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                VoiceManager voiceManager = this.f48167e;
                voiceManager.mCurPlayModel = voiceManager.mNewClickModel;
                VoiceManager voiceManager2 = this.f48167e;
                voiceManager2.sPlayView = voiceManager2.sNewPlayView;
                this.f48167e.sNewPlayView = null;
                VoiceManager voiceManager3 = this.f48167e;
                voiceManager3.setDownloading(voiceManager3.mCurPlayModel);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends c.a.e.e.l.c<c.a.q0.s.g0.b.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VoiceManager f48168a;

        public c(VoiceManager voiceManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voiceManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48168a = voiceManager;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.l.c
        /* renamed from: a */
        public void onLoaded(c.a.q0.s.g0.b.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                super.onLoaded(aVar, str, i2);
                if (this.f48168a.mCurPlayModel == null || this.f48168a.sPlayView == null || aVar == null) {
                    return;
                }
                String str2 = aVar.f13954b;
                String str3 = aVar.f13953a;
                int i3 = aVar.f13955c;
                String str4 = aVar.f13956d;
                if (!StringUtils.isNull(str2) && !StringUtils.isNull(str3)) {
                    if (this.f48168a.mCurPlayModel.voiceId.equals(str3) && VoiceManager.isVoiceDownloading(this.f48168a.mCurPlayModel.voice_status.intValue())) {
                        VoiceManager voiceManager = this.f48168a;
                        voiceManager.setPlaying(voiceManager.mCurPlayModel, str2);
                        return;
                    }
                    return;
                }
                TiebaStatic.voiceError(1, this.f48168a.context.getString(R.string.voice_cache_error_internal), str2);
                if (i3 <= 0 || StringUtils.isNull(str4) || (i3 != 2 && i3 != 4 && i3 != 3 && i3 != 7)) {
                    this.f48168a.sPlayView.onShowErr(5, c.a.e.e.q.h.a(R.string.voice_err_load_fail));
                } else {
                    this.f48168a.sPlayView.onShowErr(5, str4);
                }
                VoiceManager voiceManager2 = this.f48168a;
                voiceManager2.setPlayWaiting(voiceManager2.mCurPlayModel);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VoiceManager f48169e;

        public d(VoiceManager voiceManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voiceManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48169e = voiceManager;
        }

        @Override // java.lang.Runnable
        public void run() {
            i playView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (playView = this.f48169e.getPlayView()) == null) {
                return;
            }
            this.f48169e.startPlay(playView);
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VoiceManager f48170e;

        public e(VoiceManager voiceManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voiceManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48170e = voiceManager;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f48170e.bSpeakerphoneOn == null) {
                return;
            }
            if (this.f48170e.bSpeakerphoneOn.booleanValue()) {
                this.f48170e.openSpeaker();
            } else {
                this.f48170e.closeSpeaker();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VoiceManager f48171e;

        public f(VoiceManager voiceManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voiceManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48171e = voiceManager;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f48171e.isPlaying()) {
                return;
            }
            this.f48171e.unRegistSensor();
        }
    }

    /* loaded from: classes6.dex */
    public class g extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VoiceManager this$0;

        public g(VoiceManager voiceManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voiceManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = voiceManager;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String a2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || this.this$0.mCurPlayModel == null || intent == null) {
                return;
            }
            String action = intent.getAction();
            if (action.equals("com.baidu.isPlaying")) {
                this.this$0.setVolumeControlStream();
                if (!intent.getBooleanExtra("com.baidu.msg.isPlaying", false) || this.this$0.mCurPlayModel == null) {
                    return;
                }
                if (this.this$0.mHandle != null) {
                    this.this$0.mHandle.removeCallbacks(this.this$0.unRegistSensorRunnable);
                }
                try {
                    this.this$0.mCurPlayModel.voice_status = 3;
                    i playView = this.this$0.getPlayView();
                    if (playView != null) {
                        playView.onRefreshByPlayStatus(this.this$0.mCurPlayModel);
                    }
                } catch (Exception e2) {
                    FieldBuilder fieldBuilder = new FieldBuilder();
                    if (this.this$0.mCurPlayModel != null) {
                        fieldBuilder.append("id", this.this$0.mCurPlayModel.getId());
                        fieldBuilder.append("from", this.this$0.mCurPlayModel.from);
                    }
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_UPDATEVIEW, "mVoicePlayerReceiver.onReceive exception: " + e2.getMessage(), fieldBuilder.toString());
                }
            } else if (action.equals("com.baidu.playElapsedTime")) {
                int intExtra = intent.getIntExtra("com.baidu.msg.playElapsedTime", 0);
                i playView2 = this.this$0.getPlayView();
                if (playView2 != null) {
                    playView2.onPlayElapse(intExtra);
                }
                if (this.this$0.mCurPlayModel != null) {
                    this.this$0.mCurPlayModel.elapse = intExtra;
                }
            } else if (action.equals("com.baidu.isStoped")) {
                i playView3 = this.this$0.getPlayView();
                if (this.this$0.mCurPlayModel != null) {
                    if (!this.this$0.bStopAndReplay) {
                        this.this$0.releaseWakeLock();
                        VoiceManager voiceManager = this.this$0;
                        voiceManager.setStatusWaiting(voiceManager.mCurPlayModel);
                        this.this$0.sPlayView = null;
                    }
                    this.this$0.mCurPlayModel = null;
                    if (!this.this$0.bStopAndReplay || playView3 == null) {
                        return;
                    }
                    VoiceData$VoiceModel voiceModel = playView3.getVoiceModel();
                    if (voiceModel != null) {
                        voiceModel.curr_time = intent.getIntExtra("com.baidu.msg.curr_time", 0);
                    }
                    if (this.this$0.mHandle != null) {
                        this.this$0.mHandle.removeCallbacks(this.this$0.stopVoiceAndRePlayRunnable);
                        this.this$0.mHandle.postDelayed(this.this$0.stopVoiceAndRePlayRunnable, 200L);
                    }
                }
            } else if (action.equals("com.baidu.playPrepared")) {
                int intExtra2 = intent.getIntExtra("com.baidu.playPrepared_err_code", -1);
                if (intExtra2 != -1) {
                    i playView4 = this.this$0.getPlayView();
                    if (playView4 != null) {
                        if (intExtra2 == 2) {
                            a2 = c.a.e.e.q.h.a(R.string.voice_err_io);
                        } else {
                            a2 = c.a.e.e.q.h.a(R.string.voice_err_play);
                        }
                        playView4.onShowErr(5, a2);
                    }
                    if (this.this$0.mCurPlayModel != null) {
                        VoiceManager voiceManager2 = this.this$0;
                        voiceManager2.setStatusWaiting(voiceManager2.mCurPlayModel);
                        this.this$0.mCurPlayModel = null;
                        return;
                    }
                    return;
                }
                long longExtra = intent.getLongExtra("com.baidu.msg.durationTime2", this.this$0.mCurPlayModel != null ? this.this$0.mCurPlayModel.duration * 1000 : 0L);
                if (longExtra > 900 && this.this$0.mCurPlayModel != null) {
                    this.this$0.mCurPlayModel.duration2 = (int) longExtra;
                }
                i playView5 = this.this$0.getPlayView();
                if (playView5 != null) {
                    playView5.onPlayPrepared();
                }
                MediaService.startPlay(context);
            } else {
                action.equalsIgnoreCase("com.baidu.recognize");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VoiceManager f48172a;

        public h(VoiceManager voiceManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voiceManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48172a = voiceManager;
        }

        public /* synthetic */ h(VoiceManager voiceManager, a aVar) {
            this(voiceManager);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't wrap try/catch for region: R(5:3|(3:4|5|6)|(5:7|8|(1:10)(1:21)|11|(1:13))|15|16) */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0095, code lost:
            if (r4 == null) goto L19;
         */
        /* JADX WARN: Removed duplicated region for block: B:44:0x009d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            FileReader fileReader;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) != null) {
                return (Void) invokeL.objValue;
            }
            FileReader fileReader2 = null;
            try {
                try {
                    fileReader = new FileReader("/sys/class/switch/h2w/state");
                } catch (Throwable th) {
                    th = th;
                    fileReader2 = fileReader;
                    if (fileReader2 != null) {
                        try {
                            fileReader2.close();
                        } catch (Exception unused) {
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e2) {
                e = e2;
                fileReader = null;
            } catch (Exception e3) {
                e = e3;
                fileReader = null;
            } catch (Throwable th2) {
                th = th2;
                if (fileReader2 != null) {
                }
                throw th;
            }
            try {
                char[] cArr = new char[1024];
                this.f48172a.b_HEADSET_PLUG = Integer.valueOf(new String(cArr, 0, fileReader.read(cArr, 0, 1024)).trim()).intValue() != 0;
                if (this.f48172a.b_HEADSET_PLUG) {
                    this.f48172a.setSpeakerphone(false);
                }
            } catch (FileNotFoundException e4) {
                e = e4;
                FieldBuilder fieldBuilder = new FieldBuilder();
                fieldBuilder.append("path", "/sys/class/switch/h2w/state");
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_HEADSET, "CheckHeadsetPlugAsyncTask exception: " + e.getMessage(), fieldBuilder.toString());
            } catch (Exception e5) {
                e = e5;
                FieldBuilder fieldBuilder2 = new FieldBuilder();
                fieldBuilder2.append("path", "/sys/class/switch/h2w/state");
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_HEADSET, "CheckHeadsetPlugAsyncTask exception: " + e.getMessage(), fieldBuilder2.toString());
                if (fileReader != null) {
                    fileReader.close();
                }
                return null;
            }
            fileReader.close();
        }
    }

    /* loaded from: classes6.dex */
    public interface i {
        i getRealView();

        VoiceData$VoiceModel getVoiceModel();

        void onPlayElapse(int i2);

        void onPlayPrepared();

        void onRefreshByPlayStatus(VoiceData$VoiceModel voiceData$VoiceModel);

        void onShowErr(int i2, String str);
    }

    /* loaded from: classes6.dex */
    public interface j {
        i getRealView(VoiceData$VoiceModel voiceData$VoiceModel);

        VoiceManager getVoiceManager();
    }

    /* loaded from: classes6.dex */
    public class k implements c.a.e.e.q.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VoiceManager f48173a;

        public k(VoiceManager voiceManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voiceManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48173a = voiceManager;
        }

        @Override // c.a.e.e.q.e
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            }
        }

        @Override // c.a.e.e.q.e
        public void c(String str, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2) == null) || this.f48173a.sPlayView == null || this.f48173a.mCurPlayModel == null) {
                return;
            }
            if (!this.f48173a.bStopAndReplay) {
                VoiceManager voiceManager = this.f48173a;
                voiceManager.setStatusWaiting(voiceManager.mCurPlayModel);
                this.f48173a.sPlayView = null;
            }
            this.f48173a.mCurPlayModel = null;
            i playView = this.f48173a.getPlayView();
            if (!this.f48173a.bStopAndReplay || playView == null) {
                this.f48173a.releaseWakeLock();
                return;
            }
            VoiceData$VoiceModel voiceModel = playView.getVoiceModel();
            if (voiceModel != null && i2 >= 0) {
                voiceModel.curr_time = i2;
            }
            if (this.f48173a.mHandle != null) {
                this.f48173a.mHandle.removeCallbacks(this.f48173a.stopVoiceAndRePlayRunnable);
                this.f48173a.mHandle.postDelayed(this.f48173a.stopVoiceAndRePlayRunnable, 10L);
            }
        }

        @Override // c.a.e.e.q.c
        public void d(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                i playView = this.f48173a.getPlayView();
                if (playView != null) {
                    playView.onPlayElapse(i2);
                }
                if (this.f48173a.mCurPlayModel != null) {
                    this.f48173a.mCurPlayModel.elapse = i2;
                }
            }
        }

        @Override // c.a.e.e.q.e
        public void error(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) {
                TiebaStatic.voiceError(i2, str, "");
                if (this.f48173a.sPlayView == null) {
                    return;
                }
                this.f48173a.sPlayView.onShowErr(i2, str);
                if (this.f48173a.mCurPlayModel != null) {
                    VoiceManager voiceManager = this.f48173a;
                    voiceManager.setStatusWaiting(voiceManager.mCurPlayModel);
                    this.f48173a.mCurPlayModel = null;
                }
                this.f48173a.releaseWakeLock();
            }
        }

        public /* synthetic */ k(VoiceManager voiceManager, a aVar) {
            this(voiceManager);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(212541526, "Lcom/baidu/tbadk/core/voice/VoiceManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(212541526, "Lcom/baidu/tbadk/core/voice/VoiceManager;");
        }
    }

    public VoiceManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.sensorRegisterTime = 0L;
        this.mRecorderManagerRespMsg = null;
        this.stopListener = new a(this, 2001273);
        this.bSensorRegistered = false;
        this.mPhoneSpeaker = false;
        this.startPlayRunnable = new b(this);
        this.mCurPlayModel = null;
        this.mNewClickModel = null;
        this.mPlayCall = null;
        this.mResourceCall = null;
        this.sensorManager = null;
        this.proximitySensor = null;
        this.bAllowChangeVoiceMode = true;
        this.bStopAndReplay = false;
        this.stopVoiceAndRePlayRunnable = new d(this);
        this.setSpeakerphoneOnRunnable = new e(this);
        this.unRegistSensorRunnable = new f(this);
        this.b_HEADSET_PLUG = false;
        this.b_BlUETOOTH_HEADSET_PLUG = false;
        this.mVoicePlayerReceiver = new g(this);
        initConfig();
        bUseMedaiPlayer = true ^ isVoiceUseSoftDecoder();
        this.mRecorderManagerRespMsg = MessageManager.getInstance().runTask(2001271, c.a.r0.j3.q0.a.class);
    }

    private void acquireWakeLock() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65560, this) != null) || this.context == null) {
        }
    }

    private void addBlackScreen() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65561, this) == null) || this.context == null) {
            return;
        }
        if (this.windowParams == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.windowParams = layoutParams;
            layoutParams.width = -1;
            layoutParams.height = -1;
        }
        if (this.screenView == null) {
            View view = new View(this.context.getPageActivity());
            this.screenView = view;
            view.setBackgroundColor(-16777216);
        }
        if (this.windowManager == null) {
            this.windowManager = (WindowManager) this.context.getContext().getSystemService("window");
        }
        if (c.a.e.e.m.g.f(this.context)) {
            try {
                if (!this.isAddScreenView) {
                    if (this.screenView.getParent() != null) {
                        this.windowManager.removeViewImmediate(this.screenView);
                    }
                    this.windowManager.addView(this.screenView, this.windowParams);
                }
            } catch (Exception unused) {
            }
            this.isAddScreenView = true;
        }
    }

    private void checkHeadsetPlug() {
        AudioManager audioManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65562, this) == null) || (audioManager = this.audioManager) == null) {
            return;
        }
        try {
            this.b_HEADSET_PLUG = audioManager.isWiredHeadsetOn();
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null) {
                this.b_BlUETOOTH_HEADSET_PLUG = 2 == defaultAdapter.getProfileConnectionState(1);
            }
            if (this.b_HEADSET_PLUG || this.b_BlUETOOTH_HEADSET_PLUG) {
                setSpeakerphone(false);
            }
        } catch (Throwable th) {
            h hVar = new h(this, null);
            hVar.setSelfExecute(true);
            hVar.execute(new Void[0]);
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_HEADSET, "checkHeadsetPlug exception: " + th.getMessage(), "");
        }
    }

    private void firstOpenSpeaker() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65563, this) == null) && this.bFirstSetSpeaker) {
            if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
                closeSpeaker();
            } else {
                openSpeaker();
            }
            this.bFirstSetSpeaker = false;
        }
    }

    public static String formatVoiceTime(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65564, null, i2)) == null) {
            StringBuffer stringBuffer = new StringBuffer(10);
            if (i2 > 0) {
                int i3 = i2 % 60;
                int i4 = i2 / 60;
                if (i4 > 0) {
                    stringBuffer.append(i4);
                    stringBuffer.append("'");
                }
                stringBuffer.append(i3);
                stringBuffer.append("\"");
                return stringBuffer.toString();
            }
            return "0\"";
        }
        return (String) invokeI.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public i getPlayView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, this)) == null) {
            i iVar = this.sPlayView;
            if (iVar == null) {
                return null;
            }
            i realView = iVar.getRealView();
            return realView == null ? this.sPlayView : realView;
        }
        return (i) invokeV.objValue;
    }

    public static synchronized void initConfig() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, null) == null) {
            synchronized (VoiceManager.class) {
                if (!bInitConfig) {
                    bVoiceUseSoftDecoder = c.a.q0.s.d0.b.j().g("voice_use_soft_decoder", c.a.e.e.q.h.b());
                }
            }
        }
    }

    public static VoiceManager instance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) ? new VoiceManager() : (VoiceManager) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Boolean isSpeakerphone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, this)) == null) {
            AudioManager audioManager = this.audioManager;
            if (audioManager == null) {
                return null;
            }
            try {
                return Boolean.valueOf(audioManager.isSpeakerphoneOn());
            } catch (Throwable th) {
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SPEAKER, "audioManager.isSpeakerphoneOn() exception: " + th.getMessage(), "");
                return null;
            }
        }
        return (Boolean) invokeV.objValue;
    }

    private boolean isSpeakerphoneOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65569, this)) == null) {
            AudioManager audioManager = this.audioManager;
            if (audioManager == null) {
                return false;
            }
            try {
                return audioManager.isSpeakerphoneOn();
            } catch (Throwable th) {
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SPEAKER, "audioManager.isSpeakerphoneOn() exception: " + th.getMessage(), "");
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean isVoiceDownloading(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65570, null, i2)) == null) ? i2 == 2 : invokeI.booleanValue;
    }

    public static boolean isVoicePlaying(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65571, null, i2)) == null) ? i2 == 3 : invokeI.booleanValue;
    }

    public static boolean isVoiceUseSoftDecoder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) ? bVoiceUseSoftDecoder : invokeV.booleanValue;
    }

    private boolean mi3Filter(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65573, this, f2)) == null) ? Build.MODEL.equals(MI3_MODEL_NAME) && this.sensorRegisterTime + 300 > new Date().getTime() : invokeF.booleanValue;
    }

    private void putPlayView(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65574, this, iVar) == null) {
            this.sPlayView = iVar;
        }
    }

    private void registPlugin(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65575, this, context) == null) {
            this.mPhoneSpeaker = isSpeakerphoneOn();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.HEADSET_PLUG");
            context.registerReceiver(this, intentFilter);
            context.registerReceiver(this, new IntentFilter("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED"));
        }
    }

    private void registSensor() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65576, this) == null) || this.bSensorRegistered || this.proximitySensor == null) {
            return;
        }
        Handler handler = this.mHandle;
        if (handler != null) {
            handler.removeCallbacks(this.unRegistSensorRunnable);
        }
        this.bSensorRegistered = true;
        this.sensorManager.registerListener(this, this.proximitySensor, 3);
        this.sensorRegisterTime = new Date().getTime();
    }

    private void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65577, this) == null) {
            stopPlay();
            restoreVoiceMode();
            TbPageContext<?> tbPageContext = this.context;
            if (tbPageContext != null && tbPageContext.getPageActivity() != null) {
                MediaService.stopMy(this.context.getPageActivity());
                unRegistPlugin(this.context.getPageActivity());
                MediaService.unregisterReceiver(this.context.getPageActivity(), this.mVoicePlayerReceiver);
            }
            this.context = null;
            if (getRecorderManager() != null) {
                getRecorderManager().release();
            }
            Handler handler = this.mHandle;
            if (handler != null) {
                handler.removeCallbacks(this.startPlayRunnable);
                this.mHandle.removeCallbacks(this.stopVoiceAndRePlayRunnable);
                this.mHandle.removeCallbacks(this.setSpeakerphoneOnRunnable);
            }
            VoiceData$VoiceModel voiceData$VoiceModel = this.mCurPlayModel;
            if (voiceData$VoiceModel != null) {
                voiceData$VoiceModel.init();
            }
            VoiceData$VoiceModel voiceData$VoiceModel2 = this.mNewClickModel;
            if (voiceData$VoiceModel2 != null) {
                voiceData$VoiceModel2.init();
            }
            this.sPlayView = null;
            this.sNewPlayView = null;
            this.mCurPlayModel = null;
            this.mNewClickModel = null;
            this.mHandle = null;
            this.audioManager = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseWakeLock() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65578, this) == null) {
            removeBlackScreen();
        }
    }

    private void saveInitVoiceStatus() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65579, this) == null) || this.audioManager == null) {
            return;
        }
        if (bInitSpeakerphoneOn == null) {
            bInitSpeakerphoneOn = Boolean.valueOf(isSpeakerphoneOn());
        }
        if (bInitMode == null) {
            bInitMode = Integer.valueOf(this.audioManager.getMode());
        }
        if (bInitVolume == null) {
            if (bInitMode.intValue() == 3) {
                bInitVolume = Integer.valueOf(this.audioManager.getStreamVolume(3));
            } else {
                bInitVolume = Integer.valueOf(this.audioManager.getStreamVolume(0));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDownloading(VoiceData$VoiceModel voiceData$VoiceModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65580, this, voiceData$VoiceModel) == null) {
            try {
                if (this.mResourceCall == null) {
                    this.mResourceCall = new c(this);
                }
                Object b2 = c.a.q0.s.g0.a.b(voiceData$VoiceModel.getId());
                if (b2 == null) {
                    b2 = c.a.e.e.l.d.h().k(voiceData$VoiceModel.getId(), 23, this.mResourceCall, 0, 0, (this.context == null || !(this.context.getOrignalPage() instanceof c.a.e.a.i)) ? null : ((c.a.e.a.i) this.context.getOrignalPage()).getUniqueId(), voiceData$VoiceModel.from);
                }
                if (voiceData$VoiceModel.isLocal && b2 == null) {
                    if (this.mPlayCall == null) {
                        this.mPlayCall = new k(this, null);
                    }
                    this.mPlayCall.error(5, c.a.e.e.q.h.a(R.string.voice_err_no_file));
                    FieldBuilder fieldBuilder = new FieldBuilder();
                    if (voiceData$VoiceModel != null) {
                        fieldBuilder.append("id", voiceData$VoiceModel.getId());
                        fieldBuilder.append("from", voiceData$VoiceModel.from);
                    }
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILE, "VoiceManager.setDownloading() error : record file not exists", fieldBuilder.toString());
                } else if (b2 != null) {
                    setPlaying(voiceData$VoiceModel, (String) b2);
                } else {
                    voiceData$VoiceModel.voice_status = 2;
                    i playView = getPlayView();
                    if (playView != null) {
                        playView.onRefreshByPlayStatus(voiceData$VoiceModel);
                    }
                }
            } catch (Exception e2) {
                FieldBuilder fieldBuilder2 = new FieldBuilder();
                if (voiceData$VoiceModel != null) {
                    fieldBuilder2.append("id", voiceData$VoiceModel.getId());
                    fieldBuilder2.append("from", voiceData$VoiceModel.from);
                }
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_DOWN, "setMsgDownloading error: " + e2.getMessage(), fieldBuilder2.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlayWaiting(VoiceData$VoiceModel voiceData$VoiceModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65581, this, voiceData$VoiceModel) == null) {
            if (bUseMedaiPlayer) {
                if (isVoicePlaying(voiceData$VoiceModel.voice_status.intValue())) {
                    setStatusWaiting(voiceData$VoiceModel);
                    MediaService.stopPlay(this.context.getPageActivity());
                    return;
                }
                setStatusWaiting(voiceData$VoiceModel);
                return;
            }
            try {
                if (isVoicePlaying(voiceData$VoiceModel.voice_status.intValue())) {
                    setStatusWaiting(voiceData$VoiceModel);
                    c.a.e.e.q.a.f();
                } else {
                    setStatusWaiting(voiceData$VoiceModel);
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                FieldBuilder fieldBuilder = new FieldBuilder();
                if (voiceData$VoiceModel != null) {
                    fieldBuilder.append("id", voiceData$VoiceModel.getId());
                    fieldBuilder.append("from", voiceData$VoiceModel.from);
                }
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_PAUSE, "VoiceManager.setPlayWaiting() error : " + e2.toString(), fieldBuilder.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlaying(VoiceData$VoiceModel voiceData$VoiceModel, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65582, this, voiceData$VoiceModel, str) == null) {
            try {
                if (this.mPlayCall == null) {
                    this.mPlayCall = new k(this, null);
                }
                if (!new File(str).exists()) {
                    this.mPlayCall.error(5, c.a.e.e.q.h.a(R.string.voice_err_no_file));
                    return;
                }
                registSensor();
                acquireWakeLock();
                firstOpenSpeaker();
                if (this.audioManager != null) {
                    if (this.audioManager.isSpeakerphoneOn()) {
                        c.a.e.e.q.h.f2607b = 3;
                    } else {
                        c.a.e.e.q.h.f2607b = 0;
                    }
                }
                setVolumeControlStream();
                if (bUseMedaiPlayer) {
                    MediaService.preparePlay(this.context.getPageActivity(), str, voiceData$VoiceModel.duration, voiceData$VoiceModel.curr_time);
                    voiceData$VoiceModel.curr_time = 0;
                    return;
                }
                boolean e2 = c.a.e.e.q.a.e(str, this.mPlayCall, voiceData$VoiceModel.curr_time);
                voiceData$VoiceModel.curr_time = 0;
                if (!e2) {
                    FieldBuilder fieldBuilder = new FieldBuilder();
                    fieldBuilder.append("file", str);
                    if (voiceData$VoiceModel != null) {
                        fieldBuilder.append("id", voiceData$VoiceModel.getId());
                        fieldBuilder.append("from", voiceData$VoiceModel.from);
                    }
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_START, "setMsgPlaying error: AmrAudioPlayer.start", fieldBuilder.toString());
                    return;
                }
                voiceData$VoiceModel.voice_status = 3;
                i playView = getPlayView();
                if (playView != null) {
                    playView.onRefreshByPlayStatus(voiceData$VoiceModel);
                }
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
                FieldBuilder fieldBuilder2 = new FieldBuilder();
                fieldBuilder2.append("file", str);
                if (voiceData$VoiceModel != null) {
                    fieldBuilder2.append("id", voiceData$VoiceModel.getId());
                    fieldBuilder2.append("from", voiceData$VoiceModel.from);
                }
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_START, "setMsgPlaying error: " + e3.getMessage(), fieldBuilder2.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSpeakerphone(boolean z) {
        AudioManager audioManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65583, this, z) == null) || (audioManager = this.audioManager) == null) {
            return;
        }
        try {
            if (audioManager.isSpeakerphoneOn() == z) {
                return;
            }
            this.audioManager.setSpeakerphoneOn(z);
        } catch (Throwable th) {
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SPEAKER, "audioManager.setSpeakerphoneOn() exception: " + th.getMessage(), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatusWaiting(VoiceData$VoiceModel voiceData$VoiceModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65584, this, voiceData$VoiceModel) == null) {
            unRegistSensorHandler();
            voiceData$VoiceModel.voice_status = 1;
            c.a.e.e.q.h.f2607b = 2;
            setVolumeControlStream();
            i playView = getPlayView();
            if (playView != null) {
                playView.onRefreshByPlayStatus(voiceData$VoiceModel);
            }
        }
    }

    public static void setVoiceUseSoftDecoder(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65585, null, z) == null) {
            bVoiceUseSoftDecoder = true;
            c.a.q0.s.d0.b.j().t("voice_use_soft_decoder", bVoiceUseSoftDecoder);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVolumeControlStream() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65586, this) == null) {
            try {
                if (this.context == null || this.context.getPageActivity() == null) {
                    return;
                }
                this.context.getPageActivity().setVolumeControlStream(c.a.e.e.q.h.f2607b);
            } catch (Exception e2) {
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_VOLUME, "setVolumeControlStream exception: " + e2.getMessage(), "");
            }
        }
    }

    private void stopVoiceAndRePlay() {
        VoiceData$VoiceModel voiceData$VoiceModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65587, this) == null) || this.context == null) {
            return;
        }
        Handler handler = this.mHandle;
        if (handler != null) {
            handler.removeCallbacks(this.stopVoiceAndRePlayRunnable);
        }
        i playView = getPlayView();
        if (this.bStopAndReplay || (voiceData$VoiceModel = this.mCurPlayModel) == null || !isVoicePlaying(voiceData$VoiceModel.voice_status.intValue()) || playView == null) {
            return;
        }
        this.bStopAndReplay = true;
        if (bUseMedaiPlayer) {
            MediaService.stopPlay(this.context.getPageActivity());
        } else {
            stopPlay();
        }
    }

    private void stopVoiceAndRePlay_new() {
        VoiceData$VoiceModel voiceData$VoiceModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65588, this) == null) || this.context == null) {
            return;
        }
        Handler handler = this.mHandle;
        if (handler != null) {
            handler.removeCallbacks(this.stopVoiceAndRePlayRunnable);
        }
        i playView = getPlayView();
        if (this.bStopAndReplay || (voiceData$VoiceModel = this.mCurPlayModel) == null || !isVoicePlaying(voiceData$VoiceModel.voice_status.intValue()) || playView == null) {
            return;
        }
        MediaService.stopAndReplayVoice(this.context.getPageActivity());
    }

    private void unRegistPlugin(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65589, this, context) == null) || context == null) {
            return;
        }
        try {
            context.unregisterReceiver(this);
            setSpeakerphone(this.mPhoneSpeaker);
            this.mHandle.removeCallbacks(this.unRegistSensorRunnable);
            unRegistSensor();
        } catch (IllegalArgumentException unused) {
        } catch (Exception e2) {
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_UNREGISTPLUGIN, "unRegistPlugin exception: " + e2.getMessage(), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unRegistSensor() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65590, this) == null) && this.bSensorRegistered) {
            try {
                if (this.sensorManager != null) {
                    this.sensorManager.unregisterListener(this, this.proximitySensor);
                    this.sensorManager.unregisterListener(this);
                }
            } catch (Exception e2) {
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_UNREGISTSENSOR, "unRegistSensor exception: " + e2.getMessage(), "");
            }
            this.bSensorRegistered = false;
        }
    }

    private void unRegistSensorHandler() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65591, this) == null) || (handler = this.mHandle) == null) {
            return;
        }
        handler.removeCallbacks(this.unRegistSensorRunnable);
        this.mHandle.postDelayed(this.unRegistSensorRunnable, 1000L);
    }

    public void closeSpeaker() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.audioManager == null) {
            return;
        }
        saveInitVoiceStatus();
        try {
            setSpeakerphone(false);
            c.a.e.e.q.h.f2607b = 0;
            stopVoiceAndRePlay();
        } catch (Exception e2) {
            e2.printStackTrace();
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SPEAKER, "closeSpeaker exception: " + e2.getMessage(), "");
        }
    }

    public void forceStop() {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (tbPageContext = this.context) == null) {
            return;
        }
        unRegistPlugin(tbPageContext.getPageActivity());
        if (bUseMedaiPlayer) {
            VoiceData$VoiceModel voiceData$VoiceModel = this.mCurPlayModel;
            if (voiceData$VoiceModel != null) {
                setStatusWaiting(voiceData$VoiceModel);
                this.mCurPlayModel = null;
            }
            MediaService.stopPlay(this.context.getPageActivity());
            return;
        }
        stopPlay();
    }

    public c.a.r0.j3.q0.a getRecorderManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            CustomResponsedMessage<c.a.r0.j3.q0.a> customResponsedMessage = this.mRecorderManagerRespMsg;
            if (customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return null;
            }
            c.a.r0.j3.q0.a data = this.mRecorderManagerRespMsg.getData();
            data.a(this.context);
            return data;
        }
        return (c.a.r0.j3.q0.a) invokeV.objValue;
    }

    public boolean isPlayDoing(VoiceData$VoiceModel voiceData$VoiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, voiceData$VoiceModel)) == null) {
            VoiceData$VoiceModel voiceData$VoiceModel2 = this.mCurPlayModel;
            return (voiceData$VoiceModel2 == null || voiceData$VoiceModel == null || voiceData$VoiceModel2 != voiceData$VoiceModel) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public boolean isPlaying(VoiceData$VoiceModel voiceData$VoiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, voiceData$VoiceModel)) == null) {
            VoiceData$VoiceModel voiceData$VoiceModel2 = this.mCurPlayModel;
            return voiceData$VoiceModel2 != null && voiceData$VoiceModel != null && voiceData$VoiceModel2.getId().equals(voiceData$VoiceModel.getId()) && isVoicePlaying(this.mCurPlayModel.voice_status.intValue());
        }
        return invokeL.booleanValue;
    }

    public void manualSetPlayMode(PlayMode playMode) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, playMode) == null) && isPlaying()) {
            if (playMode == PlayMode.HEADSET) {
                unRegistSensor();
                setSpeakerphoneOn(false);
                return;
            }
            registSensor();
            setSpeakerphoneOn(true);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, sensor, i2) == null) {
        }
    }

    public void onCreate(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tbPageContext) == null) {
            this.context = tbPageContext;
            this.mHandle = new Handler();
            this.audioManager = (AudioManager) tbPageContext.getContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            this.sensorManager = (SensorManager) TbadkCoreApplication.getInst().getSystemService("sensor");
            this.proximitySensor = TbadkCoreApplication.getInst().getDefaultSensor(8);
            this.bSpeakerphoneOn = Boolean.TRUE;
            this.mCurPlayModel = null;
            this.mNewClickModel = null;
            if (bUseMedaiPlayer) {
                MediaService.initBroadcastReceivers(tbPageContext.getPageActivity(), this.mVoicePlayerReceiver);
                try {
                    MediaService.startMy(tbPageContext.getPageActivity(), null);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            checkHeadsetPlug();
        }
    }

    public void onDestory(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, tbPageContext) == null) {
            if (this.mCurPlayModel != null) {
                c.a.e.e.l.d.h().c(this.mCurPlayModel.getId(), 23);
            }
            release();
        }
    }

    public void onPause(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, tbPageContext) == null) {
            onPause(tbPageContext, true);
            MessageManager.getInstance().unRegisterListener(this.stopListener);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, context, intent) == null) {
            if (intent.getAction().equals("android.intent.action.HEADSET_PLUG")) {
                z = intent.getIntExtra("state", 0) == 1;
                this.b_HEADSET_PLUG = z;
                if (z) {
                    setSpeakerphone(false);
                }
            } else if (intent.getAction().equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) {
                z = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1) == 2;
                this.b_BlUETOOTH_HEADSET_PLUG = z;
                if (z) {
                    setSpeakerphone(false);
                }
            }
        }
    }

    public void onResume(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, tbPageContext) == null) {
            this.bFirstSetSpeaker = true;
            registPlugin(tbPageContext.getPageActivity());
            MessageManager.getInstance().registerListener(this.stopListener);
        }
    }

    public void onSaveInstanceState(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, activity) == null) {
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, sensorEvent) == null) && sensorEvent.sensor.getType() == 8 && !this.b_HEADSET_PLUG && this.bAllowChangeVoiceMode) {
            float[] fArr = sensorEvent.values;
            if (fArr.length > 0) {
                float f2 = fArr[0];
                if (mi3Filter(f2)) {
                    return;
                }
                float f3 = eym;
                if (f2 < f3) {
                    setSpeakerphoneOn(false);
                    addBlackScreen();
                } else if (f2 > f3) {
                    removeBlackScreen();
                    setSpeakerphoneOn(true);
                }
            }
        }
    }

    public void onStart(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, tbPageContext) == null) {
        }
    }

    public void onStop(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, tbPageContext) == null) {
            forceStop();
            restoreVoiceMode();
        }
    }

    public void openSpeaker() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || this.audioManager == null || c.a.e.e.q.h.f2606a == 2) {
            return;
        }
        if (!TbadkCoreApplication.getInst().isHeadsetModeOn() && !TbadkCoreApplication.getInst().getIsPhoneCalling()) {
            try {
                saveInitVoiceStatus();
                setSpeakerphone(true);
                c.a.e.e.q.h.f2607b = 3;
                stopVoiceAndRePlay();
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SPEAKER, "openSpeaker exception: " + e2.getMessage(), "");
                return;
            }
        }
        setSpeakerphone(false);
        this.bSpeakerphoneOn = Boolean.FALSE;
    }

    public void removeBlackScreen() {
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (this.windowManager != null && (view = this.screenView) != null && this.isAddScreenView && view.getWindowToken() != null) {
                this.windowManager.removeView(this.screenView);
            }
            this.isAddScreenView = false;
        }
    }

    public void resetPlayView(i iVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, iVar) == null) && iVar != null && isPlayDoing(iVar.getVoiceModel())) {
            putPlayView(iVar);
        }
    }

    public void restoreVoiceMode() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.bStopAndReplay = false;
            if (this.audioManager == null) {
                return;
            }
            try {
                if (bInitSpeakerphoneOn == null || bInitMode == null || bInitVolume == null) {
                    return;
                }
                setSpeakerphone(bInitSpeakerphoneOn.booleanValue());
                c.a.e.e.q.h.f2607b = 3;
                bInitSpeakerphoneOn = null;
                bInitMode = null;
                bInitVolume = null;
            } catch (Exception e2) {
                e2.printStackTrace();
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SPEAKER, "restoreVoiceMode exception: " + e2.getMessage(), "");
            }
        }
    }

    public void setAllowChangeVoiceMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.bAllowChangeVoiceMode = z;
        }
    }

    public void setSpeakerphoneOn(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048599, this, z) == null) || this.audioManager == null) {
            return;
        }
        Boolean bool = this.bSpeakerphoneOn;
        if (bool == null || bool.booleanValue() != z) {
            this.bSpeakerphoneOn = Boolean.valueOf(z);
            Handler handler = this.mHandle;
            if (handler != null) {
                handler.removeCallbacks(this.setSpeakerphoneOnRunnable);
                this.mHandle.postDelayed(this.setSpeakerphoneOnRunnable, 300L);
            }
        }
    }

    public void startPlay(i iVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, iVar) == null) || iVar == null) {
            return;
        }
        if (this.mPermissionJudgePolicy == null) {
            this.mPermissionJudgePolicy = new PermissionJudgePolicy();
        }
        this.mPermissionJudgePolicy.clearRequestPermissionList();
        this.mPermissionJudgePolicy.appendRequestPermission(this.context.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        if (this.mPermissionJudgePolicy.startRequestPermission(this.context.getPageActivity())) {
            return;
        }
        Handler handler = this.mHandle;
        if (handler != null) {
            handler.removeCallbacks(this.stopVoiceAndRePlayRunnable);
        }
        this.bStopAndReplay = false;
        VoiceData$VoiceModel voiceModel = iVar.getVoiceModel();
        if (voiceModel == null) {
            return;
        }
        Boolean bool = this.bSpeaker;
        if (bool != null && bool.booleanValue()) {
            setSpeakerphone(this.bSpeaker.booleanValue());
            this.bSpeaker = null;
        }
        this.sNewPlayView = iVar;
        this.mNewClickModel = voiceModel;
        Integer num = voiceModel.voice_status;
        int intValue = num != null ? num.intValue() : 1;
        VoiceData$VoiceModel voiceData$VoiceModel = this.mCurPlayModel;
        if (voiceData$VoiceModel != null) {
            voiceData$VoiceModel.curr_time = 0;
            if (voiceData$VoiceModel == this.mNewClickModel) {
                putPlayView(iVar);
                VoiceData$VoiceModel voiceData$VoiceModel2 = this.mNewClickModel;
                this.mCurPlayModel = voiceData$VoiceModel2;
                if (intValue == 1) {
                    setDownloading(voiceData$VoiceModel2);
                    return;
                } else if (intValue == 2 || intValue == 3) {
                    setPlayWaiting(this.mCurPlayModel);
                    return;
                } else {
                    return;
                }
            }
            setPlayWaiting(voiceData$VoiceModel);
            setStatusWaiting(this.mCurPlayModel);
            Handler handler2 = this.mHandle;
            if (handler2 != null) {
                handler2.removeCallbacks(this.startPlayRunnable);
                this.mHandle.postDelayed(this.startPlayRunnable, 300L);
                return;
            }
            return;
        }
        Handler handler3 = this.mHandle;
        if (handler3 != null) {
            handler3.removeCallbacks(this.startPlayRunnable);
            this.mHandle.postDelayed(this.startPlayRunnable, 300L);
        }
    }

    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            VoiceData$VoiceModel voiceData$VoiceModel = this.mCurPlayModel;
            if (voiceData$VoiceModel != null) {
                setPlayWaiting(voiceData$VoiceModel);
            }
            if (this.bStopAndReplay) {
                return;
            }
            releaseWakeLock();
        }
    }

    public void onPause(TbPageContext<?> tbPageContext, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048587, this, tbPageContext, z) == null) && z) {
            forceStop();
        }
    }

    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            VoiceData$VoiceModel voiceData$VoiceModel = this.mCurPlayModel;
            return voiceData$VoiceModel != null && isVoicePlaying(voiceData$VoiceModel.voice_status.intValue());
        }
        return invokeV.booleanValue;
    }
}
