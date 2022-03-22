package c.a.v0.i.f;

import android.media.AudioTrack;
import androidx.core.view.InputDeviceCompat;
import c.a.v0.i.c;
import c.a.v0.i.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes3.dex */
public class b extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a B;
    public Thread C;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String str, int[] iArr) throws Exception {
        super(0, str, iArr);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, iArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (String) objArr2[1], (int[]) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.v0.i.c
    public void B(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            M(j * 1000, true);
        }
    }

    @Override // c.a.v0.i.c
    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Thread thread = this.C;
            if (thread == null || !thread.isAlive()) {
                Thread thread2 = new Thread(this);
                this.C = thread2;
                thread2.start();
            }
            super.I();
        }
    }

    public final void K() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (i() == 1) {
                i = 4;
            } else {
                i();
                i = 12;
            }
            int i2 = this.q;
            if (i2 != 1 && i2 != 2) {
                this.q = 2;
            }
            this.B = new a(3, m(), i, h() == 2 ? 2 : 3, AudioTrack.getMinBufferSize(m(), i, h() == 2 ? 2 : 3), 1);
        }
    }

    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            a aVar = this.B;
            return aVar != null && aVar.getState() == 1;
        }
        return invokeV.booleanValue;
    }

    public final void M(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            if (j < 0) {
                j = 0;
            }
            if (this.f21592e != null && j > this.f21592e.getDuration()) {
                j = this.f21592e.getDuration();
            }
            if (z) {
                int playState = L() ? this.B.getPlayState() : 2;
                if (playState == 2) {
                    pause();
                }
                synchronized (this.f21589b) {
                    if (L()) {
                        this.B.flush();
                    }
                    this.f21591d = 0L;
                }
                e();
                c();
                if (playState == 3) {
                    I();
                }
            }
            synchronized (this.f21590c) {
                if (this.f21592e != null) {
                    this.f21592e.seek(j);
                }
            }
        }
    }

    public void N(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            synchronized (this.f21589b) {
                if (L()) {
                    this.B.setStereoVolume(f2, f3);
                }
            }
        }
    }

    @Override // c.a.v0.i.c
    public e p() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            K();
            return this.B;
        }
        return (e) invokeV.objValue;
    }

    @Override // c.a.v0.i.c
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this.f21589b) {
                if (L() && this.B.getPlayState() != 2) {
                    this.B.pause();
                }
            }
        }
    }

    @Override // c.a.v0.i.c
    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            synchronized (this.f21589b) {
                if (L() && this.B.getPlayState() != 3) {
                    this.B.play();
                }
            }
        }
    }

    @Override // c.a.v0.i.c
    public void v() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.C == null) {
            return;
        }
        this.C = null;
    }
}
