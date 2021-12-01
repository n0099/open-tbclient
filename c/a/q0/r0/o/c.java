package c.a.q0.r0.o;

import android.annotation.TargetApi;
import android.view.Choreographer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@TargetApi(16)
/* loaded from: classes5.dex */
public class c implements Choreographer.FrameCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public long f12555e;

    /* renamed from: f  reason: collision with root package name */
    public long f12556f;

    /* renamed from: g  reason: collision with root package name */
    public long f12557g;

    /* renamed from: h  reason: collision with root package name */
    public int f12558h;

    /* renamed from: i  reason: collision with root package name */
    public int f12559i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f12560j;

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
        this.f12555e = 0L;
        this.f12558h = 0;
        this.f12559i = -1;
        this.f12560j = false;
    }

    public final void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
            long j3 = this.f12557g;
            if (j3 <= 0) {
                return;
            }
            long j4 = j2 - j3;
            if (j4 <= 0 || this.f12559i > 0) {
                return;
            }
            this.f12559i = (int) (60 - ((this.f12558h * 1000) / j4));
        }
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f12559i : invokeV.intValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f12557g = currentTimeMillis;
            this.f12556f = currentTimeMillis + 1000;
            this.f12555e = 0L;
            this.f12558h = 0;
            this.f12559i = -1;
            this.f12560j = false;
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f12560j = true;
            Choreographer.getInstance().removeFrameCallback(this);
            a(System.currentTimeMillis());
            this.f12558h = 0;
            this.f12557g = 0L;
        }
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j2) == null) {
            long j3 = this.f12555e;
            if (j3 != 0) {
                long j4 = (j2 - j3) / 1000000;
                if (j4 > 16 && j4 < 960) {
                    this.f12558h = (int) (this.f12558h + (j4 / 16));
                }
            }
            this.f12555e = j2;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis < this.f12556f && !this.f12560j) {
                Choreographer.getInstance().postFrameCallback(this);
                return;
            }
            a(currentTimeMillis);
            this.f12558h = 0;
            this.f12557g = 0L;
        }
    }
}
