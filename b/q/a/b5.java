package b.q.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.views.CircleProgressbar;
/* loaded from: classes6.dex */
public class b5 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ CircleProgressbar f33262e;

    public b5(CircleProgressbar circleProgressbar) {
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
        this.f33262e = circleProgressbar;
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
            this.f33262e.removeCallbacks(this);
            int ordinal = this.f33262e.f70533i.ordinal();
            if (ordinal == 0) {
                circleProgressbar = this.f33262e;
                i2 = circleProgressbar.f70532h + 1;
            } else {
                if (ordinal == 1) {
                    circleProgressbar = this.f33262e;
                    i2 = circleProgressbar.f70532h - 1;
                }
                CircleProgressbar circleProgressbar2 = this.f33262e;
                i3 = circleProgressbar2.f70532h;
                if (i3 < 0 && i3 <= 100) {
                    d6 d6Var = circleProgressbar2.l;
                    if (d6Var != null) {
                        d6Var.a(circleProgressbar2.m, i3);
                    }
                    this.f33262e.invalidate();
                    CircleProgressbar circleProgressbar3 = this.f33262e;
                    circleProgressbar3.postDelayed(circleProgressbar3.n, circleProgressbar3.j / 100);
                    return;
                }
                CircleProgressbar circleProgressbar4 = this.f33262e;
                int i4 = circleProgressbar4.f70532h;
                circleProgressbar4.f70532h = i4 <= 100 ? i4 < 0 ? 0 : i4 : 100;
            }
            circleProgressbar.f70532h = i2;
            CircleProgressbar circleProgressbar22 = this.f33262e;
            i3 = circleProgressbar22.f70532h;
            if (i3 < 0) {
            }
            CircleProgressbar circleProgressbar42 = this.f33262e;
            int i42 = circleProgressbar42.f70532h;
            circleProgressbar42.f70532h = i42 <= 100 ? i42 < 0 ? 0 : i42 : 100;
        }
    }
}
