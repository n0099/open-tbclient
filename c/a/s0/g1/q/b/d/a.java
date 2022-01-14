package c.a.s0.g1.q.b.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.TimerTask;
/* loaded from: classes6.dex */
public final class a extends TimerTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public float f12742e;

    /* renamed from: f  reason: collision with root package name */
    public final float f12743f;

    /* renamed from: g  reason: collision with root package name */
    public final WheelView f12744g;

    public a(WheelView wheelView, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wheelView, Float.valueOf(f2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12744g = wheelView;
        this.f12743f = f2;
        this.f12742e = 2.1474836E9f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f12742e == 2.1474836E9f) {
                if (Math.abs(this.f12743f) > 2000.0f) {
                    this.f12742e = this.f12743f <= 0.0f ? -2000.0f : 2000.0f;
                } else {
                    this.f12742e = this.f12743f;
                }
            }
            if (Math.abs(this.f12742e) >= 0.0f && Math.abs(this.f12742e) <= 20.0f) {
                this.f12744g.cancelFuture();
                this.f12744g.getHandler().sendEmptyMessage(2000);
                return;
            }
            WheelView wheelView = this.f12744g;
            float f2 = (int) (this.f12742e / 100.0f);
            wheelView.setTotalScrollY(wheelView.getTotalScrollY() - f2);
            if (!this.f12744g.isLoop()) {
                float itemHeight = this.f12744g.getItemHeight();
                float f3 = (-this.f12744g.getInitPosition()) * itemHeight;
                float itemsCount = ((this.f12744g.getItemsCount() - 1) - this.f12744g.getInitPosition()) * itemHeight;
                double d2 = itemHeight * 0.25d;
                if (this.f12744g.getTotalScrollY() - d2 < f3) {
                    f3 = this.f12744g.getTotalScrollY() + f2;
                } else if (this.f12744g.getTotalScrollY() + d2 > itemsCount) {
                    itemsCount = this.f12744g.getTotalScrollY() + f2;
                }
                if (this.f12744g.getTotalScrollY() <= f3) {
                    this.f12742e = 40.0f;
                    this.f12744g.setTotalScrollY((int) f3);
                } else if (this.f12744g.getTotalScrollY() >= itemsCount) {
                    this.f12744g.setTotalScrollY((int) itemsCount);
                    this.f12742e = -40.0f;
                }
            }
            float f4 = this.f12742e;
            if (f4 < 0.0f) {
                this.f12742e = f4 + 20.0f;
            } else {
                this.f12742e = f4 - 20.0f;
            }
            this.f12744g.getHandler().sendEmptyMessage(1000);
        }
    }
}
