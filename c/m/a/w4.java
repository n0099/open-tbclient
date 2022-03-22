package c.m.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.views.CircleProgressbar;
/* loaded from: classes3.dex */
public class w4 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ CircleProgressbar a;

    public w4(CircleProgressbar circleProgressbar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {circleProgressbar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = circleProgressbar;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0050  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        CircleProgressbar circleProgressbar;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.removeCallbacks(this);
            int ordinal = this.a.i.ordinal();
            if (ordinal == 0) {
                circleProgressbar = this.a;
                i = circleProgressbar.f44041h + 1;
            } else {
                if (ordinal == 1) {
                    circleProgressbar = this.a;
                    i = circleProgressbar.f44041h - 1;
                }
                CircleProgressbar circleProgressbar2 = this.a;
                i2 = circleProgressbar2.f44041h;
                if (i2 < 0 && i2 <= 100) {
                    y5 y5Var = circleProgressbar2.l;
                    if (y5Var != null) {
                        y5Var.a(circleProgressbar2.m, i2);
                    }
                    this.a.invalidate();
                    CircleProgressbar circleProgressbar3 = this.a;
                    circleProgressbar3.postDelayed(circleProgressbar3.n, circleProgressbar3.j / 100);
                    return;
                }
                CircleProgressbar circleProgressbar4 = this.a;
                int i3 = circleProgressbar4.f44041h;
                circleProgressbar4.f44041h = i3 <= 100 ? i3 < 0 ? 0 : i3 : 100;
            }
            circleProgressbar.f44041h = i;
            CircleProgressbar circleProgressbar22 = this.a;
            i2 = circleProgressbar22.f44041h;
            if (i2 < 0) {
            }
            CircleProgressbar circleProgressbar42 = this.a;
            int i32 = circleProgressbar42.f44041h;
            circleProgressbar42.f44041h = i32 <= 100 ? i32 < 0 ? 0 : i32 : 100;
        }
    }
}
