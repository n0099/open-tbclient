package c.a.r0.a.c2.a.e.d;

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
    public int f5553e;

    /* renamed from: f  reason: collision with root package name */
    public int f5554f;

    /* renamed from: g  reason: collision with root package name */
    public int f5555g;

    /* renamed from: h  reason: collision with root package name */
    public final WheelView3d f5556h;

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
        this.f5556h = wheelView3d;
        this.f5555g = i2;
        this.f5553e = Integer.MAX_VALUE;
        this.f5554f = 0;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f5553e == Integer.MAX_VALUE) {
                this.f5553e = this.f5555g;
            }
            int i2 = this.f5553e;
            int i3 = (int) (i2 * 0.1f);
            this.f5554f = i3;
            if (i3 == 0) {
                if (i2 < 0) {
                    this.f5554f = -1;
                } else {
                    this.f5554f = 1;
                }
            }
            if (Math.abs(this.f5553e) <= 1) {
                this.f5556h.cancelFuture();
                this.f5556h.getHandler().sendEmptyMessage(3000);
                return;
            }
            WheelView3d wheelView3d = this.f5556h;
            wheelView3d.setTotalScrollY(wheelView3d.getTotalScrollY() + this.f5554f);
            if (!this.f5556h.isLoop()) {
                float itemHeight = this.f5556h.getItemHeight();
                float itemsCount = ((this.f5556h.getItemsCount() - 1) - this.f5556h.getInitPosition()) * itemHeight;
                if (this.f5556h.getTotalScrollY() <= (-this.f5556h.getInitPosition()) * itemHeight || this.f5556h.getTotalScrollY() >= itemsCount) {
                    WheelView3d wheelView3d2 = this.f5556h;
                    wheelView3d2.setTotalScrollY(wheelView3d2.getTotalScrollY() - this.f5554f);
                    this.f5556h.cancelFuture();
                    this.f5556h.getHandler().sendEmptyMessage(3000);
                    return;
                }
            }
            this.f5556h.getHandler().sendEmptyMessage(1000);
            this.f5553e -= this.f5554f;
        }
    }
}
