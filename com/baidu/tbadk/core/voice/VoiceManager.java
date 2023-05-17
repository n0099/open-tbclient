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
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.FieldBuilder;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.voice.service.MediaService;
import com.baidu.tieba.R;
import com.baidu.tieba.cj;
import com.baidu.tieba.ej;
import com.baidu.tieba.jj;
import com.baidu.tieba.jt9;
import com.baidu.tieba.kg;
import com.baidu.tieba.l9;
import com.baidu.tieba.lg;
import com.baidu.tieba.o65;
import com.baidu.tieba.qi;
import com.baidu.tieba.ti;
import com.baidu.tieba.ug;
import com.baidu.tieba.w85;
import com.baidu.tieba.wk5;
import com.baidu.tieba.x85;
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
import java.lang.ref.WeakReference;
import java.util.Date;
/* loaded from: classes4.dex */
public class VoiceManager extends BroadcastReceiver {
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
    public static boolean isNeedBlackScreen = true;
    public static boolean isUseMediaPlayer;
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
    public VoiceData.VoiceModel mCurPlayModel;
    public Handler mHandle;
    public VoiceData.VoiceModel mNewClickModel;
    public PermissionJudgePolicy mPermissionJudgePolicy;
    public boolean mPhoneSpeaker;
    public k mPlayCall;
    public CustomResponsedMessage<jt9> mRecorderManagerRespMsg;
    public kg<x85> mResourceCall;
    public l mSensorListener;
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

    /* loaded from: classes4.dex */
    public interface i {
        void a(int i);

        void b(VoiceData.VoiceModel voiceModel);

        void c();

        i getRealView();

        VoiceData.VoiceModel getVoiceModel();

        void onShowErr(int i, String str);
    }

    /* loaded from: classes4.dex */
    public interface j {
        i e1(VoiceData.VoiceModel voiceModel);

        VoiceManager x0();
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

    public static boolean isVoiceDownloading(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65575, null, i2)) == null) ? i2 == 2 : invokeI.booleanValue;
    }

    public static boolean isVoicePlaying(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65576, null, i2)) == null) ? i2 == 3 : invokeI.booleanValue;
    }

    public void onSaveInstanceState(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, activity) == null) {
        }
    }

    public void onStart(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, tbPageContext) == null) {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
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

        public PlayMode(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (PlayMode) Enum.valueOf(PlayMode.class, str);
            }
            return (PlayMode) invokeL.objValue;
        }

        public static PlayMode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (PlayMode[]) $VALUES.clone();
            }
            return (PlayMode[]) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VoiceManager a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(VoiceManager voiceManager, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voiceManager, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = voiceManager;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean bool;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001273) {
                this.a.stopPlay();
                if ((customResponsedMessage.getData() instanceof Boolean) && (bool = (Boolean) customResponsedMessage.getData()) != null && bool.booleanValue()) {
                    VoiceManager voiceManager = this.a;
                    voiceManager.bSpeaker = voiceManager.isSpeakerphone();
                    this.a.setSpeakerphone(false);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VoiceManager a;

        public b(VoiceManager voiceManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voiceManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = voiceManager;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                VoiceManager voiceManager = this.a;
                voiceManager.setCurPlayModel(voiceManager.mNewClickModel);
                VoiceManager voiceManager2 = this.a;
                voiceManager2.sPlayView = voiceManager2.sNewPlayView;
                this.a.sNewPlayView = null;
                VoiceManager voiceManager3 = this.a;
                voiceManager3.setDownloading(voiceManager3.getCurPlayModel());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends kg<x85> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VoiceManager a;

        public c(VoiceManager voiceManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voiceManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = voiceManager;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kg
        /* renamed from: a */
        public void onLoaded(x85 x85Var, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, x85Var, str, i) == null) {
                super.onLoaded(x85Var, str, i);
                if (this.a.getCurPlayModel() == null || this.a.sPlayView == null || x85Var == null) {
                    return;
                }
                String e = x85Var.e();
                String d = x85Var.d();
                int b = x85Var.b();
                String c = x85Var.c();
                if (!StringUtils.isNull(e) && !StringUtils.isNull(d)) {
                    if (!qi.isEquals(this.a.getCurPlayModel().getVoiceId(), d) || !VoiceManager.isVoiceDownloading(this.a.getCurPlayModel().voice_status.intValue())) {
                        return;
                    }
                    VoiceManager voiceManager = this.a;
                    voiceManager.setPlaying(voiceManager.getCurPlayModel(), e);
                    return;
                }
                TiebaStatic.voiceError(1, this.a.context.getString(R.string.voice_cache_error_internal), e);
                if (b > 0 && !StringUtils.isNull(c) && (b == 2 || b == 4 || b == 3 || b == 7)) {
                    this.a.sPlayView.onShowErr(5, c);
                } else {
                    this.a.sPlayView.onShowErr(5, jj.a(R.string.voice_err_load_fail));
                }
                VoiceManager voiceManager2 = this.a;
                voiceManager2.setPlayWaiting(voiceManager2.getCurPlayModel());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VoiceManager a;

        public d(VoiceManager voiceManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voiceManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = voiceManager;
        }

        @Override // java.lang.Runnable
        public void run() {
            i playView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (playView = this.a.getPlayView()) != null) {
                this.a.startPlay(playView);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VoiceManager a;

        public e(VoiceManager voiceManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voiceManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = voiceManager;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.bSpeakerphoneOn == null) {
                return;
            }
            if (this.a.bSpeakerphoneOn.booleanValue()) {
                this.a.openSpeaker();
            } else {
                this.a.closeSpeaker();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VoiceManager a;

        public f(VoiceManager voiceManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voiceManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = voiceManager;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.isPlaying()) {
                return;
            }
            this.a.unRegistSensor();
        }
    }

    /* loaded from: classes4.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = voiceManager;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String a;
            long j;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && this.this$0.getCurPlayModel() != null && intent != null) {
                String action = intent.getAction();
                if (!action.equals("com.baidu.isPlaying")) {
                    if (action.equals("com.baidu.playElapsedTime")) {
                        int intExtra = intent.getIntExtra("com.baidu.msg.playElapsedTime", 0);
                        i playView = this.this$0.getPlayView();
                        if (playView != null) {
                            playView.a(intExtra);
                        }
                        if (this.this$0.getCurPlayModel() != null) {
                            this.this$0.getCurPlayModel().elapse = intExtra;
                            return;
                        }
                        return;
                    } else if (!action.equals("com.baidu.isStoped")) {
                        if (action.equals("com.baidu.playPrepared")) {
                            int intExtra2 = intent.getIntExtra("com.baidu.playPrepared_err_code", -1);
                            if (intExtra2 == -1) {
                                if (this.this$0.getCurPlayModel() != null) {
                                    j = this.this$0.getCurPlayModel().getDuration() * 1000;
                                } else {
                                    j = 0;
                                }
                                long longExtra = intent.getLongExtra("com.baidu.msg.durationTime2", j);
                                if (longExtra > 900 && this.this$0.getCurPlayModel() != null) {
                                    this.this$0.getCurPlayModel().duration2 = (int) longExtra;
                                }
                                i playView2 = this.this$0.getPlayView();
                                if (playView2 != null) {
                                    playView2.c();
                                }
                                MediaService.startPlay(context);
                                return;
                            }
                            i playView3 = this.this$0.getPlayView();
                            if (playView3 != null) {
                                if (intExtra2 == 2) {
                                    a = jj.a(R.string.voice_err_io);
                                } else {
                                    a = jj.a(R.string.obfuscated_res_0x7f0f17a8);
                                }
                                playView3.onShowErr(5, a);
                            }
                            if (this.this$0.getCurPlayModel() != null) {
                                VoiceManager voiceManager = this.this$0;
                                voiceManager.setStatusWaiting(voiceManager.getCurPlayModel());
                                this.this$0.setCurPlayModel(null);
                                return;
                            }
                            return;
                        }
                        action.equalsIgnoreCase("com.baidu.recognize");
                        return;
                    } else {
                        i playView4 = this.this$0.getPlayView();
                        if (this.this$0.getCurPlayModel() != null) {
                            if (!this.this$0.bStopAndReplay) {
                                this.this$0.releaseWakeLock();
                                VoiceManager voiceManager2 = this.this$0;
                                voiceManager2.setStatusWaiting(voiceManager2.getCurPlayModel());
                                this.this$0.sPlayView = null;
                            }
                            this.this$0.setCurPlayModel(null);
                            if (this.this$0.bStopAndReplay && playView4 != null) {
                                VoiceData.VoiceModel voiceModel = playView4.getVoiceModel();
                                if (voiceModel != null) {
                                    voiceModel.setCurr_time(intent.getIntExtra("com.baidu.msg.curr_time", 0));
                                }
                                if (this.this$0.mHandle != null) {
                                    this.this$0.mHandle.removeCallbacks(this.this$0.stopVoiceAndRePlayRunnable);
                                    this.this$0.mHandle.postDelayed(this.this$0.stopVoiceAndRePlayRunnable, 200L);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                this.this$0.setVolumeControlStream();
                if (!intent.getBooleanExtra("com.baidu.msg.isPlaying", false) || this.this$0.getCurPlayModel() == null) {
                    return;
                }
                if (this.this$0.mHandle != null) {
                    this.this$0.mHandle.removeCallbacks(this.this$0.unRegistSensorRunnable);
                }
                try {
                    this.this$0.getCurPlayModel().voice_status = 3;
                    i playView5 = this.this$0.getPlayView();
                    if (playView5 != null) {
                        playView5.b(this.this$0.getCurPlayModel());
                    }
                } catch (Exception e) {
                    FieldBuilder fieldBuilder = new FieldBuilder();
                    if (this.this$0.getCurPlayModel() != null) {
                        fieldBuilder.append("id", this.this$0.getCurPlayModel().getId());
                        fieldBuilder.append("from", this.this$0.getCurPlayModel().from);
                    }
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_UPDATEVIEW, "mVoicePlayerReceiver.onReceive exception: " + e.getMessage(), fieldBuilder.toString());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VoiceManager a;

        public h(VoiceManager voiceManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voiceManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = voiceManager;
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
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
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
                } catch (FileNotFoundException e) {
                    e = e;
                    fileReader = null;
                } catch (Exception e2) {
                    e = e2;
                    fileReader = null;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileReader2 != null) {
                    }
                    throw th;
                }
                try {
                    char[] cArr = new char[1024];
                    int intValue = Integer.valueOf(new String(cArr, 0, fileReader.read(cArr, 0, 1024)).trim()).intValue();
                    VoiceManager voiceManager = this.a;
                    if (intValue != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    voiceManager.b_HEADSET_PLUG = z;
                    if (this.a.b_HEADSET_PLUG) {
                        this.a.setSpeakerphone(false);
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    FieldBuilder fieldBuilder = new FieldBuilder();
                    fieldBuilder.append("path", "/sys/class/switch/h2w/state");
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_HEADSET, "CheckHeadsetPlugAsyncTask exception: " + e.getMessage(), fieldBuilder.toString());
                } catch (Exception e4) {
                    e = e4;
                    FieldBuilder fieldBuilder2 = new FieldBuilder();
                    fieldBuilder2.append("path", "/sys/class/switch/h2w/state");
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_HEADSET, "CheckHeadsetPlugAsyncTask exception: " + e.getMessage(), fieldBuilder2.toString());
                    if (fileReader != null) {
                        fileReader.close();
                    }
                    return null;
                }
                fileReader.close();
            } else {
                return (Void) invokeL.objValue;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements ej {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VoiceManager a;

        @Override // com.baidu.tieba.gj
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        public k(VoiceManager voiceManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voiceManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = voiceManager;
        }

        @Override // com.baidu.tieba.ej
        public void d(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) != null) {
                return;
            }
            i playView = this.a.getPlayView();
            if (playView != null) {
                playView.a(i);
            }
            if (this.a.getCurPlayModel() != null) {
                this.a.getCurPlayModel().elapse = i;
            }
        }

        public /* synthetic */ k(VoiceManager voiceManager, a aVar) {
            this(voiceManager);
        }

        @Override // com.baidu.tieba.gj
        public void c(String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i) == null) && this.a.sPlayView != null && this.a.getCurPlayModel() != null) {
                if (!this.a.bStopAndReplay) {
                    VoiceManager voiceManager = this.a;
                    voiceManager.setStatusWaiting(voiceManager.getCurPlayModel());
                    this.a.sPlayView = null;
                }
                this.a.setCurPlayModel(null);
                i playView = this.a.getPlayView();
                if (!this.a.bStopAndReplay || playView == null) {
                    this.a.releaseWakeLock();
                    return;
                }
                VoiceData.VoiceModel voiceModel = playView.getVoiceModel();
                if (voiceModel != null && i >= 0) {
                    voiceModel.setCurr_time(i);
                }
                if (this.a.mHandle != null) {
                    this.a.mHandle.removeCallbacks(this.a.stopVoiceAndRePlayRunnable);
                    this.a.mHandle.postDelayed(this.a.stopVoiceAndRePlayRunnable, 10L);
                }
            }
        }

        @Override // com.baidu.tieba.gj
        public void error(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
                TiebaStatic.voiceError(i, str, "");
                if (this.a.sPlayView == null) {
                    return;
                }
                this.a.sPlayView.onShowErr(i, str);
                if (this.a.getCurPlayModel() != null) {
                    VoiceManager voiceManager = this.a;
                    voiceManager.setStatusWaiting(voiceManager.getCurPlayModel());
                    this.a.setCurPlayModel(null);
                }
                this.a.releaseWakeLock();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class l implements SensorEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<VoiceManager> a;

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, sensor, i) == null) {
            }
        }

        public l(VoiceManager voiceManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voiceManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(voiceManager);
        }

        public /* synthetic */ l(VoiceManager voiceManager, a aVar) {
            this(voiceManager);
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            VoiceManager voiceManager;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sensorEvent) == null) && (voiceManager = this.a.get()) != null && sensorEvent.sensor.getType() == 8 && !voiceManager.b_HEADSET_PLUG && voiceManager.bAllowChangeVoiceMode) {
                float[] fArr = sensorEvent.values;
                if (fArr.length > 0) {
                    float f = fArr[0];
                    if (!voiceManager.mi3Filter(f) && VoiceManager.isNeedBlackScreen()) {
                        if (f < VoiceManager.eym) {
                            voiceManager.setSpeakerphoneOn(false);
                            voiceManager.addBlackScreen();
                        } else if (f > VoiceManager.eym) {
                            voiceManager.removeBlackScreen();
                            voiceManager.setSpeakerphoneOn(true);
                        }
                    }
                }
            }
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
        bUseMedaiPlayer = !isVoiceUseSoftDecoder();
        this.mRecorderManagerRespMsg = MessageManager.getInstance().runTask(2001271, jt9.class);
        this.mSensorListener = new l(this, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addBlackScreen() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65563, this) != null) || this.context == null) {
            return;
        }
        if (this.windowParams == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.windowParams = layoutParams;
            layoutParams.width = -1;
            layoutParams.height = -1;
        }
        if (this.screenView == null) {
            View view2 = new View(this.context.getPageActivity());
            this.screenView = view2;
            view2.setBackgroundColor(-16777216);
        }
        if (this.windowManager == null) {
            this.windowManager = (WindowManager) this.context.getContext().getSystemService("window");
        }
        if (!ug.f(this.context)) {
            return;
        }
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

    private void checkHeadsetPlug() {
        AudioManager audioManager;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65564, this) != null) || (audioManager = this.audioManager) == null) {
            return;
        }
        try {
            this.b_HEADSET_PLUG = audioManager.isWiredHeadsetOn();
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null) {
                if (2 == defaultAdapter.getProfileConnectionState(1)) {
                    z = true;
                } else {
                    z = false;
                }
                this.b_BlUETOOTH_HEADSET_PLUG = z;
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

    private void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65582, this) == null) {
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
            if (getCurPlayModel() != null) {
                getCurPlayModel().init();
            }
            VoiceData.VoiceModel voiceModel = this.mNewClickModel;
            if (voiceModel != null) {
                voiceModel.init();
            }
            this.sPlayView = null;
            this.sNewPlayView = null;
            setCurPlayModel(null);
            this.mNewClickModel = null;
            this.mHandle = null;
            this.audioManager = null;
        }
    }

    public void openSpeaker() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.audioManager != null && jj.a != 2) {
            if (!TbadkCoreApplication.getInst().isHeadsetModeOn() && !TbadkCoreApplication.getInst().getIsPhoneCalling()) {
                try {
                    saveInitVoiceStatus();
                    setSpeakerphone(true);
                    jj.b = 3;
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
    }

    public static String formatVoiceTime01(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65567, null, i2)) == null) {
            StringBuffer stringBuffer = new StringBuffer(10);
            if (i2 > 0) {
                stringBuffer.append(i2);
                stringBuffer.append("\"");
                return stringBuffer.toString();
            }
            return "0\"";
        }
        return (String) invokeI.objValue;
    }

    private void putPlayView(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65579, this, iVar) == null) {
            this.sPlayView = iVar;
        }
    }

    private void registPlugin(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65580, this, context) == null) {
            this.mPhoneSpeaker = isSpeakerphoneOn();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.HEADSET_PLUG");
            context.registerReceiver(this, intentFilter);
            context.registerReceiver(this, new IntentFilter("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED"));
        }
    }

    public static void setIsNeedBlackScreen(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65586, null, z) == null) {
            isNeedBlackScreen = z;
        }
    }

    public static void setIsUseMediaPlayer(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65587, null, z) == null) {
            isUseMediaPlayer = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatusWaiting(VoiceData.VoiceModel voiceModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65591, this, voiceModel) == null) {
            unRegistSensorHandler();
            voiceModel.voice_status = 1;
            jj.b = 2;
            setVolumeControlStream();
            i playView = getPlayView();
            if (playView != null) {
                playView.b(voiceModel);
            }
        }
    }

    public static void setVoiceUseSoftDecoder(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65592, null, z) == null) {
            bVoiceUseSoftDecoder = true;
            o65.m().w("voice_use_soft_decoder", bVoiceUseSoftDecoder);
        }
    }

    public boolean isPlayDoing(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, voiceModel)) == null) {
            if (getCurPlayModel() == null || voiceModel == null || getCurPlayModel() != voiceModel) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void manualSetPlayMode(PlayMode playMode) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, playMode) != null) || !isPlaying()) {
            return;
        }
        if (playMode == PlayMode.HEADSET) {
            unRegistSensor();
            setSpeakerphoneOn(false);
            return;
        }
        registSensor();
        setSpeakerphoneOn(true);
    }

    public void onDestory(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, tbPageContext) == null) {
            if (getCurPlayModel() != null) {
                lg.h().c(getCurPlayModel().getId(), 23);
            }
            release();
        }
    }

    public void onPause(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && z) {
            forceStop();
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

    public void onStop(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, tbPageContext) == null) {
            forceStop();
            restoreVoiceMode();
        }
    }

    public void resetPlayView(i iVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, iVar) == null) && iVar != null && isPlayDoing(iVar.getVoiceModel())) {
            putPlayView(iVar);
        }
    }

    public void setAllowChangeVoiceMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.bAllowChangeVoiceMode = z;
        }
    }

    public void setCurPlayModel(VoiceData.VoiceModel voiceModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, voiceModel) == null) {
            this.mCurPlayModel = voiceModel;
        }
    }

    private void acquireWakeLock() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65562, this) != null) || this.context == null) {
        }
    }

    private void firstOpenSpeaker() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65565, this) == null) && this.bFirstSetSpeaker) {
            if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
                closeSpeaker();
            } else {
                openSpeaker();
            }
            this.bFirstSetSpeaker = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public i getPlayView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, this)) == null) {
            i iVar = this.sPlayView;
            if (iVar == null) {
                return null;
            }
            i realView = iVar.getRealView();
            if (realView == null) {
                return this.sPlayView;
            }
            return realView;
        }
        return (i) invokeV.objValue;
    }

    public static synchronized void initConfig() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, null) == null) {
            synchronized (VoiceManager.class) {
                if (!bInitConfig) {
                    bVoiceUseSoftDecoder = o65.m().i("voice_use_soft_decoder", jj.b());
                }
            }
        }
    }

    public static VoiceManager instance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) {
            return new VoiceManager();
        }
        return (VoiceManager) invokeV.objValue;
    }

    public static boolean isNeedBlackScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) {
            return isNeedBlackScreen;
        }
        return invokeV.booleanValue;
    }

    public static boolean isUseMediaPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65574, null)) == null) {
            return isUseMediaPlayer;
        }
        return invokeV.booleanValue;
    }

    public static boolean isVoiceUseSoftDecoder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65577, null)) == null) {
            return bVoiceUseSoftDecoder;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseWakeLock() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65583, this) == null) {
            removeBlackScreen();
        }
    }

    private void unRegistSensorHandler() {
        Handler handler;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65598, this) == null) && (handler = this.mHandle) != null) {
            handler.removeCallbacks(this.unRegistSensorRunnable);
            this.mHandle.postDelayed(this.unRegistSensorRunnable, 1000L);
        }
    }

    public VoiceData.VoiceModel getCurPlayModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mCurPlayModel;
        }
        return (VoiceData.VoiceModel) invokeV.objValue;
    }

    public jt9 getRecorderManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            CustomResponsedMessage<jt9> customResponsedMessage = this.mRecorderManagerRespMsg;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                jt9 data = this.mRecorderManagerRespMsg.getData();
                data.a(this.context);
                return data;
            }
            return null;
        }
        return (jt9) invokeV.objValue;
    }

    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (getCurPlayModel() == null || !isVoicePlaying(getCurPlayModel().voice_status.intValue())) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            onPause(true);
            MessageManager.getInstance().unRegisterListener(this.stopListener);
        }
    }

    public void removeBlackScreen() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (this.windowManager != null && (view2 = this.screenView) != null && this.isAddScreenView && view2.getWindowToken() != null) {
                this.windowManager.removeView(this.screenView);
            }
            this.isAddScreenView = false;
        }
    }

    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (getCurPlayModel() != null) {
                setPlayWaiting(getCurPlayModel());
            }
            if (!this.bStopAndReplay) {
                releaseWakeLock();
            }
        }
    }

    public static String formatVoiceTime(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65566, null, i2)) == null) {
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
    public boolean mi3Filter(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65578, this, f2)) == null) {
            if (ti.g().equals(MI3_MODEL_NAME) && this.sensorRegisterTime + 300 > new Date().getTime()) {
                return true;
            }
            return false;
        }
        return invokeF.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSpeakerphone(boolean z) {
        AudioManager audioManager;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(65590, this, z) != null) || (audioManager = this.audioManager) == null) {
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

    private void unRegistPlugin(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65596, this, context) != null) || context == null) {
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

    public boolean isPlaying(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, voiceModel)) == null) {
            if (getCurPlayModel() == null || voiceModel == null || !getCurPlayModel().getId().equals(voiceModel.getId()) || !isVoicePlaying(getCurPlayModel().voice_status.intValue())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setSpeakerphoneOn(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048599, this, z) != null) || this.audioManager == null) {
            return;
        }
        Boolean bool = this.bSpeakerphoneOn;
        if (bool != null && bool.booleanValue() == z) {
            return;
        }
        this.bSpeakerphoneOn = Boolean.valueOf(z);
        Handler handler = this.mHandle;
        if (handler != null) {
            handler.removeCallbacks(this.setSpeakerphoneOnRunnable);
            this.mHandle.postDelayed(this.setSpeakerphoneOnRunnable, 300L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Boolean isSpeakerphone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65572, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65573, this)) == null) {
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

    private void registSensor() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65581, this) == null) && !this.bSensorRegistered && this.proximitySensor != null) {
            Handler handler = this.mHandle;
            if (handler != null) {
                handler.removeCallbacks(this.unRegistSensorRunnable);
            }
            this.sensorManager.registerListener(this.mSensorListener, this.proximitySensor, 3);
            this.bSensorRegistered = true;
            this.sensorRegisterTime = new Date().getTime();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVolumeControlStream() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65593, this) == null) {
            try {
                if (this.context != null && this.context.getPageActivity() != null) {
                    this.context.getPageActivity().setVolumeControlStream(jj.b);
                }
            } catch (Exception e2) {
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_VOLUME, "setVolumeControlStream exception: " + e2.getMessage(), "");
            }
        }
    }

    public void closeSpeaker() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.audioManager == null) {
            return;
        }
        saveInitVoiceStatus();
        try {
            setSpeakerphone(false);
            jj.b = 0;
            stopVoiceAndRePlay();
        } catch (Exception e2) {
            e2.printStackTrace();
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SPEAKER, "closeSpeaker exception: " + e2.getMessage(), "");
        }
    }

    public void forceStop() {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (tbPageContext = this.context) == null) {
            return;
        }
        unRegistPlugin(tbPageContext.getPageActivity());
        if (!bUseMedaiPlayer && !isUseMediaPlayer()) {
            stopPlay();
            return;
        }
        if (getCurPlayModel() != null) {
            setStatusWaiting(getCurPlayModel());
            setCurPlayModel(null);
        }
        MediaService.stopPlay(this.context.getPageActivity());
    }

    private void saveInitVoiceStatus() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65584, this) != null) || this.audioManager == null) {
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

    private void stopVoiceAndRePlay() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65594, this) != null) || this.context == null) {
            return;
        }
        Handler handler = this.mHandle;
        if (handler != null) {
            handler.removeCallbacks(this.stopVoiceAndRePlayRunnable);
        }
        i playView = getPlayView();
        if (!this.bStopAndReplay && getCurPlayModel() != null && isVoicePlaying(getCurPlayModel().voice_status.intValue()) && playView != null) {
            this.bStopAndReplay = true;
            if (!bUseMedaiPlayer && !isUseMediaPlayer()) {
                stopPlay();
            } else {
                MediaService.stopPlay(this.context.getPageActivity());
            }
        }
    }

    private void stopVoiceAndRePlay_new() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65595, this) != null) || this.context == null) {
            return;
        }
        Handler handler = this.mHandle;
        if (handler != null) {
            handler.removeCallbacks(this.stopVoiceAndRePlayRunnable);
        }
        i playView = getPlayView();
        if (!this.bStopAndReplay && getCurPlayModel() != null && isVoicePlaying(getCurPlayModel().voice_status.intValue()) && playView != null) {
            MediaService.stopAndReplayVoice(this.context.getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unRegistSensor() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65597, this) != null) || !this.bSensorRegistered) {
            return;
        }
        try {
            if (this.sensorManager != null) {
                this.sensorManager.unregisterListener(this.mSensorListener, this.proximitySensor);
                this.sensorManager.unregisterListener(this.mSensorListener);
            }
        } catch (Exception e2) {
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_UNREGISTSENSOR, "unRegistSensor exception: " + e2.getMessage(), "");
        }
        this.bSensorRegistered = false;
    }

    public void restoreVoiceMode() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.bStopAndReplay = false;
            if (this.audioManager == null) {
                return;
            }
            try {
                if (bInitSpeakerphoneOn != null && bInitMode != null && bInitVolume != null) {
                    setSpeakerphone(bInitSpeakerphoneOn.booleanValue());
                    jj.b = 3;
                    bInitSpeakerphoneOn = null;
                    bInitMode = null;
                    bInitVolume = null;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SPEAKER, "restoreVoiceMode exception: " + e2.getMessage(), "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDownloading(VoiceData.VoiceModel voiceModel) {
        BdUniqueId bdUniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65585, this, voiceModel) == null) {
            try {
                if (this.mResourceCall == null) {
                    this.mResourceCall = new c(this);
                }
                Object b2 = w85.b(voiceModel.getId());
                if (b2 == null) {
                    if (this.context != null && (this.context.getOrignalPage() instanceof l9)) {
                        bdUniqueId = ((l9) this.context.getOrignalPage()).getUniqueId();
                    } else {
                        bdUniqueId = null;
                    }
                    if (voiceModel.isGroupChat) {
                        b2 = lg.h().k(voiceModel.getVoiceUrl(), 23, this.mResourceCall, 0, 0, bdUniqueId, voiceModel.from);
                    } else {
                        b2 = lg.h().k(voiceModel.getId(), 23, this.mResourceCall, 0, 0, bdUniqueId, voiceModel.from);
                    }
                }
                if (voiceModel.isLocal && b2 == null) {
                    if (this.mPlayCall == null) {
                        this.mPlayCall = new k(this, null);
                    }
                    this.mPlayCall.error(5, jj.a(R.string.obfuscated_res_0x7f0f17a6));
                    FieldBuilder fieldBuilder = new FieldBuilder();
                    if (voiceModel != null) {
                        fieldBuilder.append("id", voiceModel.getId());
                        fieldBuilder.append("from", voiceModel.from);
                    }
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILE, "VoiceManager.setDownloading() error : record file not exists", fieldBuilder.toString());
                } else if (b2 != null) {
                    setPlaying(voiceModel, (String) b2);
                } else {
                    voiceModel.voice_status = 2;
                    i playView = getPlayView();
                    if (playView != null) {
                        playView.b(voiceModel);
                    }
                }
            } catch (Exception e2) {
                FieldBuilder fieldBuilder2 = new FieldBuilder();
                if (voiceModel != null) {
                    fieldBuilder2.append("id", voiceModel.getId());
                    fieldBuilder2.append("from", voiceModel.from);
                }
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_DOWN, "setMsgDownloading error: " + e2.getMessage(), fieldBuilder2.toString());
            }
        }
    }

    public void startPlay(i iVar) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048600, this, iVar) != null) || iVar == null) {
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
        VoiceData.VoiceModel voiceModel = iVar.getVoiceModel();
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
        if (num != null) {
            i2 = num.intValue();
        } else {
            i2 = 1;
        }
        wk5.b().l(true);
        wk5.b().n(true);
        if (getCurPlayModel() != null) {
            getCurPlayModel().setCurr_time(0);
            if (getCurPlayModel() == this.mNewClickModel) {
                putPlayView(iVar);
                setCurPlayModel(this.mNewClickModel);
                if (i2 != 1) {
                    if (i2 == 2 || i2 == 3) {
                        setPlayWaiting(getCurPlayModel());
                        return;
                    }
                    return;
                }
                setDownloading(getCurPlayModel());
                return;
            }
            setPlayWaiting(getCurPlayModel());
            setStatusWaiting(getCurPlayModel());
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

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlayWaiting(VoiceData.VoiceModel voiceModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65588, this, voiceModel) == null) {
            if (!bUseMedaiPlayer && !isUseMediaPlayer()) {
                try {
                    if (isVoicePlaying(voiceModel.voice_status.intValue())) {
                        setStatusWaiting(voiceModel);
                        cj.f();
                        if (wk5.b().d()) {
                            wk5.b().l(false);
                        }
                    } else {
                        setStatusWaiting(voiceModel);
                    }
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    FieldBuilder fieldBuilder = new FieldBuilder();
                    if (voiceModel != null) {
                        fieldBuilder.append("id", voiceModel.getId());
                        fieldBuilder.append("from", voiceModel.from);
                    }
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_PAUSE, "VoiceManager.setPlayWaiting() error : " + e2.toString(), fieldBuilder.toString());
                }
            } else if (isVoicePlaying(voiceModel.voice_status.intValue())) {
                setStatusWaiting(voiceModel);
                MediaService.stopPlay(this.context.getPageActivity());
            } else {
                setStatusWaiting(voiceModel);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00aa A[Catch: Exception -> 0x00ae, TRY_LEAVE, TryCatch #0 {Exception -> 0x00ae, blocks: (B:5:0x000c, B:7:0x0010, B:8:0x0018, B:10:0x0023, B:12:0x0031, B:14:0x0040, B:16:0x0048, B:17:0x004b, B:18:0x004d, B:20:0x0054, B:23:0x005b, B:25:0x006a, B:27:0x0074, B:28:0x0080, B:31:0x009e, B:33:0x00aa, B:30:0x008a), top: B:44:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setPlaying(VoiceData.VoiceModel voiceModel, String str) {
        i playView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65589, this, voiceModel, str) == null) {
            try {
                if (this.mPlayCall == null) {
                    this.mPlayCall = new k(this, null);
                }
                if (!new File(str).exists()) {
                    this.mPlayCall.error(5, jj.a(R.string.obfuscated_res_0x7f0f17a6));
                    return;
                }
                registSensor();
                acquireWakeLock();
                firstOpenSpeaker();
                if (this.audioManager != null) {
                    if (this.audioManager.isSpeakerphoneOn()) {
                        jj.b = 3;
                    } else {
                        jj.b = 0;
                    }
                }
                setVolumeControlStream();
                if (!bUseMedaiPlayer && !isUseMediaPlayer()) {
                    boolean e2 = cj.e(str, this.mPlayCall, voiceModel.getCurr_time());
                    voiceModel.setCurr_time(0);
                    if (!e2) {
                        FieldBuilder fieldBuilder = new FieldBuilder();
                        fieldBuilder.append("file", str);
                        if (voiceModel != null) {
                            fieldBuilder.append("id", voiceModel.getId());
                            fieldBuilder.append("from", voiceModel.from);
                        }
                        TiebaStatic.voiceError(TbErrInfo.ERR_VOI_START, "setMsgPlaying error: AmrAudioPlayer.start", fieldBuilder.toString());
                        return;
                    }
                    voiceModel.voice_status = 3;
                    playView = getPlayView();
                    if (playView == null) {
                        playView.b(voiceModel);
                        return;
                    }
                    return;
                }
                MediaService.preparePlay(this.context.getPageActivity(), str, voiceModel.getDuration(), voiceModel.getCurr_time());
                voiceModel.setCurr_time(0);
                voiceModel.voice_status = 3;
                playView = getPlayView();
                if (playView == null) {
                }
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
                FieldBuilder fieldBuilder2 = new FieldBuilder();
                fieldBuilder2.append("file", str);
                if (voiceModel != null) {
                    fieldBuilder2.append("id", voiceModel.getId());
                    fieldBuilder2.append("from", voiceModel.from);
                }
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_START, "setMsgPlaying error: " + e3.getMessage(), fieldBuilder2.toString());
            }
        }
    }

    public void onCreate(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tbPageContext) == null) {
            this.context = tbPageContext;
            this.mHandle = new Handler();
            this.audioManager = (AudioManager) tbPageContext.getContext().getSystemService("audio");
            this.sensorManager = (SensorManager) TbadkCoreApplication.getInst().getSystemService("sensor");
            this.proximitySensor = TbadkCoreApplication.getInst().getDefaultSensor(8);
            this.bSpeakerphoneOn = Boolean.TRUE;
            setCurPlayModel(null);
            this.mNewClickModel = null;
            if (bUseMedaiPlayer || isUseMediaPlayer()) {
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

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, context, intent) == null) {
            boolean z = true;
            if (intent.getAction().equals("android.intent.action.HEADSET_PLUG")) {
                if (intent.getIntExtra("state", 0) != 1) {
                    z = false;
                }
                this.b_HEADSET_PLUG = z;
                if (z) {
                    setSpeakerphone(false);
                }
            } else if (intent.getAction().equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) {
                if (intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1) != 2) {
                    z = false;
                }
                this.b_BlUETOOTH_HEADSET_PLUG = z;
                if (z) {
                    setSpeakerphone(false);
                }
            }
        }
    }
}
