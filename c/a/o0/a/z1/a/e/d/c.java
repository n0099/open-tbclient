package c.a.o0.a.z1.a.e.d;

import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.TimerTask;
/* loaded from: classes.dex */
public final class c extends TimerTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f9957e;

    /* renamed from: f  reason: collision with root package name */
    public int f9958f;

    /* renamed from: g  reason: collision with root package name */
    public int f9959g;

    /* renamed from: h  reason: collision with root package name */
    public final WheelView3d f9960h;

    public c(WheelView3d wheelView3d, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wheelView3d, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f9960h = wheelView3d;
        this.f9959g = i2;
        this.f9957e = Integer.MAX_VALUE;
        this.f9958f = 0;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f9957e == Integer.MAX_VALUE) {
                this.f9957e = this.f9959g;
            }
            int i2 = this.f9957e;
            int i3 = (int) (i2 * 0.1f);
            this.f9958f = i3;
            if (i3 == 0) {
                if (i2 < 0) {
                    this.f9958f = -1;
                } else {
                    this.f9958f = 1;
                }
            }
            if (Math.abs(this.f9957e) <= 1) {
                this.f9960h.cancelFuture();
                this.f9960h.getHandler().sendEmptyMessage(3000);
                return;
            }
            WheelView3d wheelView3d = this.f9960h;
            wheelView3d.setTotalScrollY(wheelView3d.getTotalScrollY() + this.f9958f);
            if (!this.f9960h.isLoop()) {
                float itemHeight = this.f9960h.getItemHeight();
                float itemsCount = ((this.f9960h.getItemsCount() - 1) - this.f9960h.getInitPosition()) * itemHeight;
                if (this.f9960h.getTotalScrollY() <= (-this.f9960h.getInitPosition()) * itemHeight || this.f9960h.getTotalScrollY() >= itemsCount) {
                    WheelView3d wheelView3d2 = this.f9960h;
                    wheelView3d2.setTotalScrollY(wheelView3d2.getTotalScrollY() - this.f9958f);
                    this.f9960h.cancelFuture();
                    this.f9960h.getHandler().sendEmptyMessage(3000);
                    return;
                }
            }
            this.f9960h.getHandler().sendEmptyMessage(1000);
            this.f9957e -= this.f9958f;
        }
    }
}
