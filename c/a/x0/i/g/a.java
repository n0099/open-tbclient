package c.a.x0.i.g;

import androidx.core.view.InputDeviceCompat;
import c.a.x0.i.c;
import c.a.x0.i.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes4.dex */
public class a extends c implements c.a.x0.l.d.j.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b F;
    public String G;
    public Thread H;
    public long I;
    public long J;

    /* renamed from: c.a.x0.i.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1421a extends c.a.x0.l.d.j.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f30835e;

        public C1421a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30835e = aVar;
        }

        @Override // c.a.x0.l.d.j.c.a, c.a.x0.l.d.j.b
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f30835e.D == null || this.f30835e.p) {
                return;
            }
            this.f30835e.D.onExceptionThrown(str);
        }

        @Override // c.a.x0.l.d.j.c.a
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.f30835e.o = true;
                if (this.f30835e.D == null || this.f30835e.p) {
                    return;
                }
                this.f30835e.D.onFinishedWriting(z);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(String str, String str2, int[] iArr) throws Exception {
        super(0, str, iArr);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, iArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (String) objArr2[1], (int[]) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.G = str2;
        this.F.e(str2);
        F(this);
    }

    @Override // c.a.x0.i.c
    public void B(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
            long j3 = j2 * 1000;
            if (j3 < 0) {
                j3 = 0;
            }
            this.I = j3;
            if (this.f30823i != null) {
                if (j3 > this.f30823i.getDuration()) {
                    j3 = this.f30823i.getDuration();
                }
                synchronized (this.f30821g) {
                    this.f30823i.seek(j3);
                }
            }
        }
    }

    @Override // c.a.x0.i.c
    public void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.o) {
            return;
        }
        long currentPosition = this.f30823i.getCurrentPosition();
        long j2 = this.I;
        long j3 = currentPosition - j2;
        long j4 = this.J;
        long duration = j4 > 0 ? j4 - j2 : this.f30823i.getDuration();
        double d2 = duration == 0 ? 0.0d : j3 / duration;
        double d3 = d2 >= 0.0d ? d2 : 0.0d;
        onProgressChanged(this.r, d3 > 1.0d ? 1.0d : d3, j3);
    }

    @Override // c.a.x0.i.c
    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.I();
            Thread thread = this.H;
            if (thread == null || !thread.isAlive()) {
                Thread thread2 = new Thread(this);
                this.H = thread2;
                thread2.start();
            }
            super.I();
        }
    }

    public void R(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
            long j3 = j2 * 1000;
            this.J = j3;
            if (this.f30823i != null) {
                if (j3 > this.f30823i.getDuration()) {
                    j3 = this.f30823i.getDuration();
                }
                synchronized (this.f30821g) {
                    this.f30823i.h(j3);
                }
            }
        }
    }

    public void S(c.a.x0.l.d.j.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.D = aVar;
            this.F.d(new C1421a(this));
        }
    }

    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.p = true;
            this.o = true;
            Thread thread = this.H;
            if (thread != null) {
                try {
                    thread.interrupt();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.H = null;
            }
            try {
                this.F.g();
            } catch (Exception e3) {
                c.a.x0.t.c.e("VideoMuxer", "cancel finishWriting error:" + e3.getMessage());
            }
        }
    }

    @Override // c.a.x0.l.d.j.b
    public void onCancel() {
        c.a.x0.l.d.j.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.D) == null) {
            return;
        }
        aVar.onCancel();
    }

    @Override // c.a.x0.l.d.j.b
    public void onExceptionThrown(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || this.D == null || this.p) {
            return;
        }
        this.D.onExceptionThrown(str);
    }

    @Override // c.a.x0.l.d.j.b
    public void onProgressChanged(int i2, double d2, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Double.valueOf(d2), Long.valueOf(j2)}) == null) || this.D == null || this.p) {
            return;
        }
        this.D.onProgressChanged(i2, d2, j2);
    }

    @Override // c.a.x0.l.d.j.b
    public void onTrackEnd(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            try {
                this.F.b();
            } catch (Exception e2) {
                c.a.x0.t.c.e("VideoMuxer", "onTrackEnd finishWriting error:" + e2.getMessage());
            }
        }
    }

    @Override // c.a.x0.i.c
    public e p() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            b bVar = new b(this.G, m(), i());
            this.F = bVar;
            return bVar;
        }
        return (e) invokeV.objValue;
    }

    @Override // c.a.x0.i.c
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    @Override // c.a.x0.i.c
    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    @Override // c.a.x0.i.c
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.H != null) {
                this.H = null;
            }
            try {
                this.F.b();
            } catch (Exception e2) {
                c.a.x0.t.c.e("VideoMuxer", "onStop finishWriting error:" + e2.getMessage());
            }
        }
    }
}
