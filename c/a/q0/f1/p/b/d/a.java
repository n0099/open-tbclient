package c.a.q0.f1.p.b.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class a extends TimerTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public float f13354e;

    /* renamed from: f  reason: collision with root package name */
    public final float f13355f;

    /* renamed from: g  reason: collision with root package name */
    public final WheelView f13356g;

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
        this.f13356g = wheelView;
        this.f13355f = f2;
        this.f13354e = 2.1474836E9f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f13354e == 2.1474836E9f) {
                if (Math.abs(this.f13355f) > 2000.0f) {
                    this.f13354e = this.f13355f <= 0.0f ? -2000.0f : 2000.0f;
                } else {
                    this.f13354e = this.f13355f;
                }
            }
            if (Math.abs(this.f13354e) >= 0.0f && Math.abs(this.f13354e) <= 20.0f) {
                this.f13356g.cancelFuture();
                this.f13356g.getHandler().sendEmptyMessage(2000);
                return;
            }
            WheelView wheelView = this.f13356g;
            float f2 = (int) (this.f13354e / 100.0f);
            wheelView.setTotalScrollY(wheelView.getTotalScrollY() - f2);
            if (!this.f13356g.isLoop()) {
                float itemHeight = this.f13356g.getItemHeight();
                float f3 = (-this.f13356g.getInitPosition()) * itemHeight;
                float itemsCount = ((this.f13356g.getItemsCount() - 1) - this.f13356g.getInitPosition()) * itemHeight;
                double d2 = itemHeight * 0.25d;
                if (this.f13356g.getTotalScrollY() - d2 < f3) {
                    f3 = this.f13356g.getTotalScrollY() + f2;
                } else if (this.f13356g.getTotalScrollY() + d2 > itemsCount) {
                    itemsCount = this.f13356g.getTotalScrollY() + f2;
                }
                if (this.f13356g.getTotalScrollY() <= f3) {
                    this.f13354e = 40.0f;
                    this.f13356g.setTotalScrollY((int) f3);
                } else if (this.f13356g.getTotalScrollY() >= itemsCount) {
                    this.f13356g.setTotalScrollY((int) itemsCount);
                    this.f13354e = -40.0f;
                }
            }
            float f4 = this.f13354e;
            if (f4 < 0.0f) {
                this.f13354e = f4 + 20.0f;
            } else {
                this.f13354e = f4 - 20.0f;
            }
            this.f13356g.getHandler().sendEmptyMessage(1000);
        }
    }
}
