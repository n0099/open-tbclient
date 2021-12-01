package c.a.q0.f1.q.b.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.TimerTask;
/* loaded from: classes5.dex */
public final class c extends TimerTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f12245e;

    /* renamed from: f  reason: collision with root package name */
    public int f12246f;

    /* renamed from: g  reason: collision with root package name */
    public int f12247g;

    /* renamed from: h  reason: collision with root package name */
    public final WheelView f12248h;

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
        this.f12248h = wheelView;
        this.f12247g = i2;
        this.f12245e = Integer.MAX_VALUE;
        this.f12246f = 0;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f12245e == Integer.MAX_VALUE) {
                this.f12245e = this.f12247g;
            }
            int i2 = this.f12245e;
            int i3 = (int) (i2 * 0.1f);
            this.f12246f = i3;
            if (i3 == 0) {
                if (i2 < 0) {
                    this.f12246f = -1;
                } else {
                    this.f12246f = 1;
                }
            }
            if (Math.abs(this.f12245e) <= 1) {
                this.f12248h.cancelFuture();
                this.f12248h.getHandler().sendEmptyMessage(3000);
                return;
            }
            WheelView wheelView = this.f12248h;
            wheelView.setTotalScrollY(wheelView.getTotalScrollY() + this.f12246f);
            if (!this.f12248h.isLoop()) {
                float itemHeight = this.f12248h.getItemHeight();
                float itemsCount = ((this.f12248h.getItemsCount() - 1) - this.f12248h.getInitPosition()) * itemHeight;
                if (this.f12248h.getTotalScrollY() <= (-this.f12248h.getInitPosition()) * itemHeight || this.f12248h.getTotalScrollY() >= itemsCount) {
                    WheelView wheelView2 = this.f12248h;
                    wheelView2.setTotalScrollY(wheelView2.getTotalScrollY() - this.f12246f);
                    this.f12248h.cancelFuture();
                    this.f12248h.getHandler().sendEmptyMessage(3000);
                    return;
                }
            }
            this.f12248h.getHandler().sendEmptyMessage(1000);
            this.f12245e -= this.f12246f;
        }
    }
}
