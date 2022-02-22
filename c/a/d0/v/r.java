package c.a.d0.v;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.strategy.IVideoUpdateStrategy;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoAd;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class r implements p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final f f3409b;

    /* renamed from: c  reason: collision with root package name */
    public i f3410c;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public class b implements c.a.d0.v.z.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r a;

        public b(r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rVar;
        }

        @Override // c.a.d0.v.z.h
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.a.f3410c == null) {
                return;
            }
            this.a.f3410c.a(i2);
        }

        @Override // c.a.d0.v.z.h
        public void onBufferEnd() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.f3410c == null) {
                return;
            }
            this.a.f3410c.onBufferEnd();
        }

        @Override // c.a.d0.v.z.h
        public void onBufferStart() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.a.f3410c == null) {
                return;
            }
            this.a.f3410c.onBufferStart();
        }

        @Override // c.a.d0.v.z.h
        public void onEnd(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.a.f3410c == null) {
                return;
            }
            this.a.f3410c.onEnd(i2);
        }

        @Override // c.a.d0.v.z.h
        public void onError(int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIIL(1048580, this, i2, i3, str) == null) || this.a.f3410c == null) {
                return;
            }
            this.a.f3410c.onError(i2, i3, str);
        }

        @Override // c.a.d0.v.z.h
        public void onInfo(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) || this.a.f3410c == null) {
                return;
            }
            this.a.f3410c.onInfo(i2, i3);
        }

        @Override // c.a.d0.v.z.h
        public void onPause() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.a.f3410c == null) {
                return;
            }
            this.a.f3410c.onPause();
        }

        @Override // c.a.d0.v.z.h
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.a.f3410c == null) {
                return;
            }
            this.a.f3410c.onPrepared();
        }

        @Override // c.a.d0.v.z.h
        public void onResume() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.a.f3410c == null) {
                return;
            }
            this.a.f3410c.onResume();
        }

        @Override // c.a.d0.v.z.h
        public void onSeekEnd() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.a.f3410c == null) {
                return;
            }
            this.a.f3410c.onSeekEnd();
        }

        @Override // c.a.d0.v.z.h
        public void onStart() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.a.f3410c == null) {
                return;
            }
            this.a.f3410c.onStart();
        }

        @Override // c.a.d0.v.z.h
        public void onUpdateProgress(int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIII(1048587, this, i2, i3, i4) == null) || this.a.f3410c == null) {
                return;
            }
            this.a.f3410c.onUpdateProgress(i2, i3, i4);
        }

        @Override // c.a.d0.v.z.h
        public void onVideoSizeChanged(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048588, this, i2, i3) == null) || this.a.f3410c == null) {
                return;
            }
            this.a.f3410c.onVideoSizeChanged(i2, i3);
        }

        public /* synthetic */ b(r rVar, a aVar) {
            this(rVar);
        }
    }

    public r(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3409b = fVar;
        fVar.y0(new b(this, null));
    }

    @Override // c.a.d0.v.p
    public void a(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
            this.f3410c = iVar;
        }
    }

    @Override // c.a.d0.v.p
    public void attachToContainer(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup) == null) {
            this.f3409b.f(viewGroup);
        }
    }

    @Override // c.a.d0.v.h
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f3409b.D() : invokeV.intValue;
    }

    @Override // c.a.d0.v.p
    public void c(@NonNull c.a.d0.s.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, pVar) == null) {
            BdVideoSeries c2 = c.a.d0.i0.a.d.a.c(pVar.f3107g);
            IVideoUpdateStrategy n1 = this.f3409b.n1();
            if (c2 != null) {
                c2.setVideoAd(f(pVar.f3106f));
                c2.setStartPosition(n1.g() ? 0 : -1);
                c2.setPlayLoop(n1.d());
                this.f3409b.A1(c2);
            } else if (d.f()) {
                throw new IllegalArgumentException("Invalid video info");
            }
        }
    }

    @Override // c.a.d0.v.p
    public void d(@NonNull IVideoUpdateStrategy iVideoUpdateStrategy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iVideoUpdateStrategy) == null) {
            this.f3409b.z1(iVideoUpdateStrategy);
        }
    }

    public final BdVideoAd f(c.a.d0.s.r rVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, rVar)) == null) {
            if (rVar == null) {
                return null;
            }
            BdVideoAd.b bVar = new BdVideoAd.b();
            bVar.b(rVar);
            bVar.c(true);
            return bVar.a();
        }
        return (BdVideoAd) invokeL.objValue;
    }

    @Override // c.a.d0.v.h
    public boolean isPause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f3409b.W() : invokeV.booleanValue;
    }

    @Override // c.a.d0.v.h
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f3409b.Y() : invokeV.booleanValue;
    }

    @Override // c.a.d0.v.m
    public void mute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f3409b.c0(z);
        }
    }

    @Override // c.a.d0.v.m
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f3409b.e0();
        }
    }

    @Override // c.a.d0.v.p
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f3409b.g0();
        }
    }

    @Override // c.a.d0.v.m
    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f3409b.l0();
        }
    }

    @Override // c.a.d0.v.m
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f3409b.K0();
        }
    }

    @Override // c.a.d0.v.m
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f3409b.L0();
        }
    }
}
