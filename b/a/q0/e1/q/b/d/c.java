package b.a.q0.e1.q.b.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.TimerTask;
/* loaded from: classes4.dex */
public final class c extends TimerTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f13237e;

    /* renamed from: f  reason: collision with root package name */
    public int f13238f;

    /* renamed from: g  reason: collision with root package name */
    public int f13239g;

    /* renamed from: h  reason: collision with root package name */
    public final WheelView f13240h;

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
        this.f13240h = wheelView;
        this.f13239g = i2;
        this.f13237e = Integer.MAX_VALUE;
        this.f13238f = 0;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f13237e == Integer.MAX_VALUE) {
                this.f13237e = this.f13239g;
            }
            int i2 = this.f13237e;
            int i3 = (int) (i2 * 0.1f);
            this.f13238f = i3;
            if (i3 == 0) {
                if (i2 < 0) {
                    this.f13238f = -1;
                } else {
                    this.f13238f = 1;
                }
            }
            if (Math.abs(this.f13237e) <= 1) {
                this.f13240h.cancelFuture();
                this.f13240h.getHandler().sendEmptyMessage(3000);
                return;
            }
            WheelView wheelView = this.f13240h;
            wheelView.setTotalScrollY(wheelView.getTotalScrollY() + this.f13238f);
            if (!this.f13240h.isLoop()) {
                float itemHeight = this.f13240h.getItemHeight();
                float itemsCount = ((this.f13240h.getItemsCount() - 1) - this.f13240h.getInitPosition()) * itemHeight;
                if (this.f13240h.getTotalScrollY() <= (-this.f13240h.getInitPosition()) * itemHeight || this.f13240h.getTotalScrollY() >= itemsCount) {
                    WheelView wheelView2 = this.f13240h;
                    wheelView2.setTotalScrollY(wheelView2.getTotalScrollY() - this.f13238f);
                    this.f13240h.cancelFuture();
                    this.f13240h.getHandler().sendEmptyMessage(3000);
                    return;
                }
            }
            this.f13240h.getHandler().sendEmptyMessage(1000);
            this.f13237e -= this.f13238f;
        }
    }
}
