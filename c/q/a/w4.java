package c.q.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.views.CircleProgressbar;
/* loaded from: classes3.dex */
public class w4 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ CircleProgressbar f29165e;

    public w4(CircleProgressbar circleProgressbar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {circleProgressbar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f29165e = circleProgressbar;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0050  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        CircleProgressbar circleProgressbar;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f29165e.removeCallbacks(this);
            int ordinal = this.f29165e.f59418i.ordinal();
            if (ordinal == 0) {
                circleProgressbar = this.f29165e;
                i2 = circleProgressbar.f59417h + 1;
            } else {
                if (ordinal == 1) {
                    circleProgressbar = this.f29165e;
                    i2 = circleProgressbar.f59417h - 1;
                }
                CircleProgressbar circleProgressbar2 = this.f29165e;
                i3 = circleProgressbar2.f59417h;
                if (i3 < 0 && i3 <= 100) {
                    y5 y5Var = circleProgressbar2.l;
                    if (y5Var != null) {
                        y5Var.a(circleProgressbar2.m, i3);
                    }
                    this.f29165e.invalidate();
                    CircleProgressbar circleProgressbar3 = this.f29165e;
                    circleProgressbar3.postDelayed(circleProgressbar3.n, circleProgressbar3.f59419j / 100);
                    return;
                }
                CircleProgressbar circleProgressbar4 = this.f29165e;
                int i4 = circleProgressbar4.f59417h;
                circleProgressbar4.f59417h = i4 <= 100 ? i4 < 0 ? 0 : i4 : 100;
            }
            circleProgressbar.f59417h = i2;
            CircleProgressbar circleProgressbar22 = this.f29165e;
            i3 = circleProgressbar22.f59417h;
            if (i3 < 0) {
            }
            CircleProgressbar circleProgressbar42 = this.f29165e;
            int i42 = circleProgressbar42.f59417h;
            circleProgressbar42.f59417h = i42 <= 100 ? i42 < 0 ? 0 : i42 : 100;
        }
    }
}
