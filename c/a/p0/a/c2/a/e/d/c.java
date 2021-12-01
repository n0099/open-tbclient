package c.a.p0.a.c2.a.e.d;

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
    public int f4485e;

    /* renamed from: f  reason: collision with root package name */
    public int f4486f;

    /* renamed from: g  reason: collision with root package name */
    public int f4487g;

    /* renamed from: h  reason: collision with root package name */
    public final WheelView3d f4488h;

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
        this.f4488h = wheelView3d;
        this.f4487g = i2;
        this.f4485e = Integer.MAX_VALUE;
        this.f4486f = 0;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f4485e == Integer.MAX_VALUE) {
                this.f4485e = this.f4487g;
            }
            int i2 = this.f4485e;
            int i3 = (int) (i2 * 0.1f);
            this.f4486f = i3;
            if (i3 == 0) {
                if (i2 < 0) {
                    this.f4486f = -1;
                } else {
                    this.f4486f = 1;
                }
            }
            if (Math.abs(this.f4485e) <= 1) {
                this.f4488h.cancelFuture();
                this.f4488h.getHandler().sendEmptyMessage(3000);
                return;
            }
            WheelView3d wheelView3d = this.f4488h;
            wheelView3d.setTotalScrollY(wheelView3d.getTotalScrollY() + this.f4486f);
            if (!this.f4488h.isLoop()) {
                float itemHeight = this.f4488h.getItemHeight();
                float itemsCount = ((this.f4488h.getItemsCount() - 1) - this.f4488h.getInitPosition()) * itemHeight;
                if (this.f4488h.getTotalScrollY() <= (-this.f4488h.getInitPosition()) * itemHeight || this.f4488h.getTotalScrollY() >= itemsCount) {
                    WheelView3d wheelView3d2 = this.f4488h;
                    wheelView3d2.setTotalScrollY(wheelView3d2.getTotalScrollY() - this.f4486f);
                    this.f4488h.cancelFuture();
                    this.f4488h.getHandler().sendEmptyMessage(3000);
                    return;
                }
            }
            this.f4488h.getHandler().sendEmptyMessage(1000);
            this.f4485e -= this.f4486f;
        }
    }
}
