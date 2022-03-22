package com.baidu.swan.games.screenrecord;

import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.w0.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mario.audio.AudioParams;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public class GameRecorderController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AREngineDelegate a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.w.c.c f29565b;

    /* renamed from: c  reason: collision with root package name */
    public RecorderState f29566c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.w.a.a.a f29567d;

    /* renamed from: e  reason: collision with root package name */
    public long f29568e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.n0.o.a.b f29569f;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class RecorderState {
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
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (RecorderState) Enum.valueOf(RecorderState.class, str) : (RecorderState) invokeL.objValue;
        }

        public static RecorderState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (RecorderState[]) $VALUES.clone() : (RecorderState[]) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class a implements c.a.n0.o.a.b {
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

        @Override // c.a.n0.o.a.b
        public void a(c.a.n0.o.a.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || this.a.f29567d == null) {
                return;
            }
            this.a.f29567d.onAudioFrameAvailable(ByteBuffer.wrap(aVar.a), (int) aVar.f9104b, aVar.f9105c - this.a.f29568e);
        }
    }

    /* loaded from: classes4.dex */
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
                SwanAudioPlayer.getInstance().setOnAudioRecordListener(this.a.f29569f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements c.a.w.c.a {
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

        @Override // c.a.w.c.a
        public void a(c.a.w.a.a.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.a.f29567d = aVar;
                this.a.f29568e = System.nanoTime();
                this.a.m();
            }
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class e implements c.a.w.c.c {
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

        @Override // c.a.w.c.c
        public void onError(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.f29566c = RecorderState.IDLE;
                if (this.a.f29565b != null) {
                    this.a.f29565b.onError(i);
                }
            }
        }

        @Override // c.a.w.c.c
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.f29566c = RecorderState.PAUSE;
                if (this.a.f29565b != null) {
                    this.a.f29565b.onPause();
                }
            }
        }

        @Override // c.a.w.c.c
        public void onResume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.f29566c = RecorderState.RECORDING;
                if (this.a.f29565b != null) {
                    this.a.f29565b.onResume();
                }
            }
        }

        @Override // c.a.w.c.c
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.a.f29566c = RecorderState.RECORDING;
                if (this.a.f29565b != null) {
                    this.a.f29565b.onStart();
                }
            }
        }

        @Override // c.a.w.c.c
        public void x(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) {
                this.a.f29566c = RecorderState.STOP;
                this.a.n();
                if (this.a.f29565b != null) {
                    this.a.f29565b.x(i, str);
                }
            }
        }

        public /* synthetic */ e(GameRecorderController gameRecorderController, a aVar) {
            this(gameRecorderController);
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
        this.f29569f = new a(this);
        this.a = aREngineDelegate;
        if (aREngineDelegate != null) {
            this.f29566c = RecorderState.IDLE;
            aREngineDelegate.setGameRecordCallback(new e(this, null));
        }
        c.a.n0.j.c.j.b.h().e().post(new b(this));
    }

    public static GameRecorderController j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? new GameRecorderController(null) : (GameRecorderController) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f29566c : (RecorderState) invokeV.objValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f29567d != null) {
                int i = SwanAudioPlayer.mSampleRate;
                int i2 = SwanAudioPlayer.mSampleBufSize;
                AudioParams audioParams = new AudioParams();
                audioParams.setSampleRate(i * 2);
                audioParams.setAudioBufferSize(i2 * 2);
                audioParams.setChannelConfig(1);
                this.f29567d.a(true, audioParams);
            }
            r(true);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.w.a.a.a aVar = this.f29567d;
            if (aVar != null) {
                aVar.onAudioStop(true);
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

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.a != null && this.f29565b != null && (l() == RecorderState.RECORDING || l() == RecorderState.PAUSE)) {
                this.f29565b.onError(-1);
            }
            s(null);
            this.f29566c = RecorderState.IDLE;
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

    public final void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            c.a.n0.j.c.j.b.h().e().post(new d(this, z));
        }
    }

    public void s(c.a.w.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            this.f29565b = cVar;
        }
    }

    public void t(int i, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048585, this, i, str) == null) || this.a == null) {
            return;
        }
        SwanAppActivity activity = f.U().getActivity();
        boolean z = activity != null && activity.isLandScape();
        this.a.setAudioEngineProxy(new c(this));
        this.a.startRecord(true, i, str, z);
    }

    public void u() {
        AREngineDelegate aREngineDelegate;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (aREngineDelegate = this.a) == null) {
            return;
        }
        aREngineDelegate.stopRecord();
    }
}
