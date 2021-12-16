package c.a.r0.f1.q.b.d;

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
    public int f12572e;

    /* renamed from: f  reason: collision with root package name */
    public int f12573f;

    /* renamed from: g  reason: collision with root package name */
    public int f12574g;

    /* renamed from: h  reason: collision with root package name */
    public final WheelView f12575h;

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
        this.f12575h = wheelView;
        this.f12574g = i2;
        this.f12572e = Integer.MAX_VALUE;
        this.f12573f = 0;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f12572e == Integer.MAX_VALUE) {
                this.f12572e = this.f12574g;
            }
            int i2 = this.f12572e;
            int i3 = (int) (i2 * 0.1f);
            this.f12573f = i3;
            if (i3 == 0) {
                if (i2 < 0) {
                    this.f12573f = -1;
                } else {
                    this.f12573f = 1;
                }
            }
            if (Math.abs(this.f12572e) <= 1) {
                this.f12575h.cancelFuture();
                this.f12575h.getHandler().sendEmptyMessage(3000);
                return;
            }
            WheelView wheelView = this.f12575h;
            wheelView.setTotalScrollY(wheelView.getTotalScrollY() + this.f12573f);
            if (!this.f12575h.isLoop()) {
                float itemHeight = this.f12575h.getItemHeight();
                float itemsCount = ((this.f12575h.getItemsCount() - 1) - this.f12575h.getInitPosition()) * itemHeight;
                if (this.f12575h.getTotalScrollY() <= (-this.f12575h.getInitPosition()) * itemHeight || this.f12575h.getTotalScrollY() >= itemsCount) {
                    WheelView wheelView2 = this.f12575h;
                    wheelView2.setTotalScrollY(wheelView2.getTotalScrollY() - this.f12573f);
                    this.f12575h.cancelFuture();
                    this.f12575h.getHandler().sendEmptyMessage(3000);
                    return;
                }
            }
            this.f12575h.getHandler().sendEmptyMessage(1000);
            this.f12572e -= this.f12573f;
        }
    }
}
