package com.baidu.swan.games.screenrecord;

import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.g1.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mario.audio.AudioParams;
import com.baidu.mobads.container.info.XDeviceInfo;
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
/* loaded from: classes6.dex */
public class GameRecorderController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AREngineDelegate f47049a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.x.c.c f47050b;

    /* renamed from: c  reason: collision with root package name */
    public RecorderState f47051c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.x.a.a.a f47052d;

    /* renamed from: e  reason: collision with root package name */
    public long f47053e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.l.a.b f47054f;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
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
            PAUSE = new RecorderState(XDeviceInfo.ABILITY_PAUSE, 2);
            RecorderState recorderState = new RecorderState("STOP", 3);
            STOP = recorderState;
            $VALUES = new RecorderState[]{IDLE, RECORDING, PAUSE, recorderState};
        }

        public RecorderState(String str, int i2) {
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

    /* loaded from: classes6.dex */
    public class a implements c.a.p0.l.a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GameRecorderController f47055a;

        public a(GameRecorderController gameRecorderController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameRecorderController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47055a = gameRecorderController;
        }

        @Override // c.a.p0.l.a.b
        public void a(c.a.p0.l.a.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || this.f47055a.f47052d == null) {
                return;
            }
            this.f47055a.f47052d.onAudioFrameAvailable(ByteBuffer.wrap(aVar.f11837a), (int) aVar.f11838b, aVar.f11839c - this.f47055a.f47053e);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GameRecorderController f47056e;

        public b(GameRecorderController gameRecorderController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameRecorderController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47056e = gameRecorderController;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAudioPlayer.getInstance().setOnAudioRecordListener(this.f47056e.f47054f);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements c.a.x.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GameRecorderController f47057a;

        public c(GameRecorderController gameRecorderController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameRecorderController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47057a = gameRecorderController;
        }

        @Override // c.a.x.c.a
        public void a(c.a.x.a.a.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f47057a.f47052d = aVar;
                this.f47057a.f47053e = System.nanoTime();
                this.f47057a.m();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f47058e;

        public d(GameRecorderController gameRecorderController, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameRecorderController, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47058e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAudioPlayer.getInstance().setAudioRecord(this.f47058e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements c.a.x.c.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GameRecorderController f47059e;

        public e(GameRecorderController gameRecorderController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameRecorderController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47059e = gameRecorderController;
        }

        @Override // c.a.x.c.c
        public void onError(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f47059e.f47051c = RecorderState.IDLE;
                if (this.f47059e.f47050b != null) {
                    this.f47059e.f47050b.onError(i2);
                }
            }
        }

        @Override // c.a.x.c.c
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f47059e.f47051c = RecorderState.PAUSE;
                if (this.f47059e.f47050b != null) {
                    this.f47059e.f47050b.onPause();
                }
            }
        }

        @Override // c.a.x.c.c
        public void onResume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f47059e.f47051c = RecorderState.RECORDING;
                if (this.f47059e.f47050b != null) {
                    this.f47059e.f47050b.onResume();
                }
            }
        }

        @Override // c.a.x.c.c
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f47059e.f47051c = RecorderState.RECORDING;
                if (this.f47059e.f47050b != null) {
                    this.f47059e.f47050b.onStart();
                }
            }
        }

        @Override // c.a.x.c.c
        public void w(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) {
                this.f47059e.f47051c = RecorderState.STOP;
                this.f47059e.n();
                if (this.f47059e.f47050b != null) {
                    this.f47059e.f47050b.w(i2, str);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f47054f = new a(this);
        this.f47049a = aREngineDelegate;
        if (aREngineDelegate != null) {
            this.f47051c = RecorderState.IDLE;
            aREngineDelegate.setGameRecordCallback(new e(this, null));
        }
        c.a.p0.h.c.j.b.h().e().post(new b(this));
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
            AREngineDelegate aREngineDelegate = this.f47049a;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f47051c : (RecorderState) invokeV.objValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f47052d != null) {
                int i2 = SwanAudioPlayer.mSampleRate;
                int i3 = SwanAudioPlayer.mSampleBufSize;
                AudioParams audioParams = new AudioParams();
                audioParams.setSampleRate(i2 * 2);
                audioParams.setAudioBufferSize(i3 * 2);
                audioParams.setChannelConfig(1);
                this.f47052d.a(true, audioParams);
            }
            r(true);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.x.a.a.a aVar = this.f47052d;
            if (aVar != null) {
                aVar.onAudioStop(true);
            }
            r(false);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            AREngineDelegate aREngineDelegate = this.f47049a;
            if (aREngineDelegate != null) {
                aREngineDelegate.pauseRecord();
            }
            r(false);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f47049a != null && this.f47050b != null && (l() == RecorderState.RECORDING || l() == RecorderState.PAUSE)) {
                this.f47050b.onError(-1);
            }
            s(null);
            this.f47051c = RecorderState.IDLE;
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            AREngineDelegate aREngineDelegate = this.f47049a;
            if (aREngineDelegate != null) {
                aREngineDelegate.resumeRecord();
            }
            r(true);
        }
    }

    public final void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            c.a.p0.h.c.j.b.h().e().post(new d(this, z));
        }
    }

    public void s(c.a.x.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            this.f47050b = cVar;
        }
    }

    public void t(int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048585, this, i2, str) == null) || this.f47049a == null) {
            return;
        }
        SwanAppActivity activity = f.V().getActivity();
        boolean z = activity != null && activity.isLandScape();
        this.f47049a.setAudioEngineProxy(new c(this));
        this.f47049a.startRecord(true, i2, str, z);
    }

    public void u() {
        AREngineDelegate aREngineDelegate;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (aREngineDelegate = this.f47049a) == null) {
            return;
        }
        aREngineDelegate.stopRecord();
    }
}
