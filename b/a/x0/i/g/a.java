package b.a.x0.i.g;

import androidx.core.view.InputDeviceCompat;
import b.a.x0.i.c;
import b.a.x0.i.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes6.dex */
public class a extends c implements b.a.x0.l.d.j.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b F;
    public String G;
    public Thread H;
    public long I;
    public long J;

    /* renamed from: b.a.x0.i.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1466a extends b.a.x0.l.d.j.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f30456e;

        public C1466a(a aVar) {
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
            this.f30456e = aVar;
        }

        @Override // b.a.x0.l.d.j.c.a, b.a.x0.l.d.j.b
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f30456e.D == null || this.f30456e.p) {
                return;
            }
            this.f30456e.D.onExceptionThrown(str);
        }

        @Override // b.a.x0.l.d.j.c.a
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.f30456e.o = true;
                if (this.f30456e.D == null || this.f30456e.p) {
                    return;
                }
                this.f30456e.D.onFinishedWriting(z);
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

    @Override // b.a.x0.i.c
    public void B(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            long j2 = j * 1000;
            if (j2 < 0) {
                j2 = 0;
            }
            this.I = j2;
            if (this.f30445i != null) {
                if (j2 > this.f30445i.getDuration()) {
                    j2 = this.f30445i.getDuration();
                }
                synchronized (this.f30443g) {
                    this.f30445i.seek(j2);
                }
            }
        }
    }

    @Override // b.a.x0.i.c
    public void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.o) {
            return;
        }
        long currentPosition = this.f30445i.getCurrentPosition();
        long j = this.I;
        long j2 = currentPosition - j;
        long j3 = this.J;
        long duration = j3 > 0 ? j3 - j : this.f30445i.getDuration();
        double d2 = duration == 0 ? 0.0d : j2 / duration;
        double d3 = d2 >= 0.0d ? d2 : 0.0d;
        onProgressChanged(this.r, d3 > 1.0d ? 1.0d : d3, j2);
    }

    @Override // b.a.x0.i.c
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

    public void R(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            long j2 = j * 1000;
            this.J = j2;
            if (this.f30445i != null) {
                if (j2 > this.f30445i.getDuration()) {
                    j2 = this.f30445i.getDuration();
                }
                synchronized (this.f30443g) {
                    this.f30445i.h(j2);
                }
            }
        }
    }

    public void S(b.a.x0.l.d.j.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.D = aVar;
            this.F.d(new C1466a(this));
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
                b.a.x0.t.c.e("VideoMuxer", "cancel finishWriting error:" + e3.getMessage());
            }
        }
    }

    @Override // b.a.x0.l.d.j.b
    public void onCancel() {
        b.a.x0.l.d.j.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.D) == null) {
            return;
        }
        aVar.onCancel();
    }

    @Override // b.a.x0.l.d.j.b
    public void onExceptionThrown(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || this.D == null || this.p) {
            return;
        }
        this.D.onExceptionThrown(str);
    }

    @Override // b.a.x0.l.d.j.b
    public void onProgressChanged(int i2, double d2, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Double.valueOf(d2), Long.valueOf(j)}) == null) || this.D == null || this.p) {
            return;
        }
        this.D.onProgressChanged(i2, d2, j);
    }

    @Override // b.a.x0.l.d.j.b
    public void onTrackEnd(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            try {
                this.F.b();
            } catch (Exception e2) {
                b.a.x0.t.c.e("VideoMuxer", "onTrackEnd finishWriting error:" + e2.getMessage());
            }
        }
    }

    @Override // b.a.x0.i.c
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

    @Override // b.a.x0.i.c
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    @Override // b.a.x0.i.c
    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    @Override // b.a.x0.i.c
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.H != null) {
                this.H = null;
            }
            try {
                this.F.b();
            } catch (Exception e2) {
                b.a.x0.t.c.e("VideoMuxer", "onStop finishWriting error:" + e2.getMessage());
            }
        }
    }
}
