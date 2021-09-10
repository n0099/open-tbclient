package c.a.q0.f1.p.b.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class c extends TimerTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f13358e;

    /* renamed from: f  reason: collision with root package name */
    public int f13359f;

    /* renamed from: g  reason: collision with root package name */
    public int f13360g;

    /* renamed from: h  reason: collision with root package name */
    public final WheelView f13361h;

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
        this.f13361h = wheelView;
        this.f13360g = i2;
        this.f13358e = Integer.MAX_VALUE;
        this.f13359f = 0;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f13358e == Integer.MAX_VALUE) {
                this.f13358e = this.f13360g;
            }
            int i2 = this.f13358e;
            int i3 = (int) (i2 * 0.1f);
            this.f13359f = i3;
            if (i3 == 0) {
                if (i2 < 0) {
                    this.f13359f = -1;
                } else {
                    this.f13359f = 1;
                }
            }
            if (Math.abs(this.f13358e) <= 1) {
                this.f13361h.cancelFuture();
                this.f13361h.getHandler().sendEmptyMessage(3000);
                return;
            }
            WheelView wheelView = this.f13361h;
            wheelView.setTotalScrollY(wheelView.getTotalScrollY() + this.f13359f);
            if (!this.f13361h.isLoop()) {
                float itemHeight = this.f13361h.getItemHeight();
                float itemsCount = ((this.f13361h.getItemsCount() - 1) - this.f13361h.getInitPosition()) * itemHeight;
                if (this.f13361h.getTotalScrollY() <= (-this.f13361h.getInitPosition()) * itemHeight || this.f13361h.getTotalScrollY() >= itemsCount) {
                    WheelView wheelView2 = this.f13361h;
                    wheelView2.setTotalScrollY(wheelView2.getTotalScrollY() - this.f13359f);
                    this.f13361h.cancelFuture();
                    this.f13361h.getHandler().sendEmptyMessage(3000);
                    return;
                }
            }
            this.f13361h.getHandler().sendEmptyMessage(1000);
            this.f13358e -= this.f13359f;
        }
    }
}
