package com.baidu.swan.games.screenrecord;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mario.audio.AudioParams;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import com.baidu.tieba.aa4;
import com.baidu.tieba.ba4;
import com.baidu.tieba.px3;
import com.baidu.tieba.rd0;
import com.baidu.tieba.td0;
import com.baidu.tieba.zc0;
import com.baidu.tieba.zo2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class GameRecorderController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AREngineDelegate a;
    public td0 b;
    public RecorderState c;
    public zc0 d;
    public long e;
    public ba4 f;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public final class RecorderState {
        public static final /* synthetic */ RecorderState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final RecorderState IDLE;
        public static final RecorderState PAUSE;
        public static final RecorderState RECORDING;
        public static final RecorderState STOP;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1480646892, "Lcom/baidu/swan/games/screenrecord/GameRecorderController$RecorderState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1480646892, "Lcom/baidu/swan/games/screenrecord/GameRecorderController$RecorderState;");
                    return;
                }
            }
            IDLE = new RecorderState("IDLE", 0);
            RECORDING = new RecorderState("RECORDING", 1);
            PAUSE = new RecorderState("PAUSE", 2);
            RecorderState recorderState = new RecorderState("STOP", 3);
            STOP = recorderState;
            $VALUES = new RecorderState[]{IDLE, RECORDING, PAUSE, recorderState};
        }

        public RecorderState(String str, int i) {
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

        public static RecorderState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (RecorderState) Enum.valueOf(RecorderState.class, str);
            }
            return (RecorderState) invokeL.objValue;
        }

        public static RecorderState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (RecorderState[]) $VALUES.clone();
            }
            return (RecorderState[]) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class a implements ba4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GameRecorderController a;

        public a(GameRecorderController gameRecorderController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameRecorderController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gameRecorderController;
        }

        @Override // com.baidu.tieba.ba4
        public void a(aa4 aa4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, aa4Var) == null) && this.a.d != null) {
                this.a.d.onAudioFrameAvailable(ByteBuffer.wrap(aa4Var.a), (int) aa4Var.b, aa4Var.c - this.a.e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GameRecorderController a;

        public b(GameRecorderController gameRecorderController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameRecorderController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gameRecorderController;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAudioPlayer.getInstance().setOnAudioRecordListener(this.a.f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements rd0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GameRecorderController a;

        public c(GameRecorderController gameRecorderController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameRecorderController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gameRecorderController;
        }

        @Override // com.baidu.tieba.rd0
        public void a(zc0 zc0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, zc0Var) != null) {
                return;
            }
            this.a.d = zc0Var;
            this.a.e = System.nanoTime();
            this.a.m();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        public d(GameRecorderController gameRecorderController, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameRecorderController, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAudioPlayer.getInstance().setAudioRecord(this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements td0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GameRecorderController a;

        public e(GameRecorderController gameRecorderController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameRecorderController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gameRecorderController;
        }

        @Override // com.baidu.tieba.td0
        public void onError(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.c = RecorderState.IDLE;
                if (this.a.b != null) {
                    this.a.b.onError(i);
                }
            }
        }

        public /* synthetic */ e(GameRecorderController gameRecorderController, a aVar) {
            this(gameRecorderController);
        }

        @Override // com.baidu.tieba.td0
        public void w(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) {
                this.a.c = RecorderState.STOP;
                this.a.n();
                if (this.a.b != null) {
                    this.a.b.w(i, str);
                }
            }
        }

        @Override // com.baidu.tieba.td0
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.c = RecorderState.PAUSE;
                if (this.a.b != null) {
                    this.a.b.onPause();
                }
            }
        }

        @Override // com.baidu.tieba.td0
        public void onResume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.c = RecorderState.RECORDING;
                if (this.a.b != null) {
                    this.a.b.onResume();
                }
            }
        }

        @Override // com.baidu.tieba.td0
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.a.c = RecorderState.RECORDING;
                if (this.a.b != null) {
                    this.a.b.onStart();
                }
            }
        }
    }

    public GameRecorderController(AREngineDelegate aREngineDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aREngineDelegate};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new a(this);
        this.a = aREngineDelegate;
        if (aREngineDelegate != null) {
            this.c = RecorderState.IDLE;
            aREngineDelegate.setGameRecordCallback(new e(this, null));
        }
        px3.h().e().post(new b(this));
    }

    public final void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            px3.h().e().post(new d(this, z));
        }
    }

    public void s(td0 td0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, td0Var) == null) {
            this.b = td0Var;
        }
    }

    public static GameRecorderController j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return new GameRecorderController(null);
        }
        return (GameRecorderController) invokeV.objValue;
    }

    public long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            AREngineDelegate aREngineDelegate = this.a;
            if (aREngineDelegate != null) {
                return aREngineDelegate.getCurrentRecordProcess();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public RecorderState l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (RecorderState) invokeV.objValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            zc0 zc0Var = this.d;
            if (zc0Var != null) {
                zc0Var.onAudioStop(true);
            }
            r(false);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            AREngineDelegate aREngineDelegate = this.a;
            if (aREngineDelegate != null) {
                aREngineDelegate.pauseRecord();
            }
            r(false);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            AREngineDelegate aREngineDelegate = this.a;
            if (aREngineDelegate != null) {
                aREngineDelegate.resumeRecord();
            }
            r(true);
        }
    }

    public void u() {
        AREngineDelegate aREngineDelegate;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (aREngineDelegate = this.a) != null) {
            aREngineDelegate.stopRecord();
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.d != null) {
                int i = SwanAudioPlayer.mSampleRate;
                int i2 = SwanAudioPlayer.mSampleBufSize;
                AudioParams audioParams = new AudioParams();
                audioParams.setSampleRate(i * 2);
                audioParams.setAudioBufferSize(i2 * 2);
                audioParams.setChannelConfig(1);
                this.d.a(true, audioParams);
            }
            r(true);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.a != null && this.b != null && (l() == RecorderState.RECORDING || l() == RecorderState.PAUSE)) {
                this.b.onError(-1);
            }
            s(null);
            this.c = RecorderState.IDLE;
        }
    }

    public void t(int i, String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048585, this, i, str) == null) && this.a != null) {
            SwanAppActivity activity = zo2.U().getActivity();
            if (activity != null && activity.i0()) {
                z = true;
            } else {
                z = false;
            }
            this.a.setAudioEngineProxy(new c(this));
            this.a.startRecord(true, i, str, z);
        }
    }
}
