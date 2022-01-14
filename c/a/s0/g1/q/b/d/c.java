package c.a.s0.g1.q.b.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.TimerTask;
/* loaded from: classes6.dex */
public final class c extends TimerTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f12745e;

    /* renamed from: f  reason: collision with root package name */
    public int f12746f;

    /* renamed from: g  reason: collision with root package name */
    public int f12747g;

    /* renamed from: h  reason: collision with root package name */
    public final WheelView f12748h;

    public c(WheelView wheelView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wheelView, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12748h = wheelView;
        this.f12747g = i2;
        this.f12745e = Integer.MAX_VALUE;
        this.f12746f = 0;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f12745e == Integer.MAX_VALUE) {
                this.f12745e = this.f12747g;
            }
            int i2 = this.f12745e;
            int i3 = (int) (i2 * 0.1f);
            this.f12746f = i3;
            if (i3 == 0) {
                if (i2 < 0) {
                    this.f12746f = -1;
                } else {
                    this.f12746f = 1;
                }
            }
            if (Math.abs(this.f12745e) <= 1) {
                this.f12748h.cancelFuture();
                this.f12748h.getHandler().sendEmptyMessage(3000);
                return;
            }
            WheelView wheelView = this.f12748h;
            wheelView.setTotalScrollY(wheelView.getTotalScrollY() + this.f12746f);
            if (!this.f12748h.isLoop()) {
                float itemHeight = this.f12748h.getItemHeight();
                float itemsCount = ((this.f12748h.getItemsCount() - 1) - this.f12748h.getInitPosition()) * itemHeight;
                if (this.f12748h.getTotalScrollY() <= (-this.f12748h.getInitPosition()) * itemHeight || this.f12748h.getTotalScrollY() >= itemsCount) {
                    WheelView wheelView2 = this.f12748h;
                    wheelView2.setTotalScrollY(wheelView2.getTotalScrollY() - this.f12746f);
                    this.f12748h.cancelFuture();
                    this.f12748h.getHandler().sendEmptyMessage(3000);
                    return;
                }
            }
            this.f12748h.getHandler().sendEmptyMessage(1000);
            this.f12745e -= this.f12746f;
        }
    }
}
