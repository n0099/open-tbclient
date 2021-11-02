package b.a.q0.q0.o;

import android.annotation.TargetApi;
import android.view.Choreographer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@TargetApi(16)
/* loaded from: classes4.dex */
public class c implements Choreographer.FrameCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public long f12876e;

    /* renamed from: f  reason: collision with root package name */
    public long f12877f;

    /* renamed from: g  reason: collision with root package name */
    public long f12878g;

    /* renamed from: h  reason: collision with root package name */
    public int f12879h;

    /* renamed from: i  reason: collision with root package name */
    public int f12880i;
    public boolean j;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12876e = 0L;
        this.f12879h = 0;
        this.f12880i = -1;
        this.j = false;
    }

    public final void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            long j2 = this.f12878g;
            if (j2 <= 0) {
                return;
            }
            long j3 = j - j2;
            if (j3 <= 0 || this.f12880i > 0) {
                return;
            }
            this.f12880i = (int) (60 - ((this.f12879h * 1000) / j3));
        }
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f12880i : invokeV.intValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f12878g = currentTimeMillis;
            this.f12877f = currentTimeMillis + 1000;
            this.f12876e = 0L;
            this.f12879h = 0;
            this.f12880i = -1;
            this.j = false;
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.j = true;
            Choreographer.getInstance().removeFrameCallback(this);
            a(System.currentTimeMillis());
            this.f12879h = 0;
            this.f12878g = 0L;
        }
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            long j2 = this.f12876e;
            if (j2 != 0) {
                long j3 = (j - j2) / 1000000;
                if (j3 > 16 && j3 < 960) {
                    this.f12879h = (int) (this.f12879h + (j3 / 16));
                }
            }
            this.f12876e = j;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis < this.f12877f && !this.j) {
                Choreographer.getInstance().postFrameCallback(this);
                return;
            }
            a(currentTimeMillis);
            this.f12879h = 0;
            this.f12878g = 0L;
        }
    }
}
