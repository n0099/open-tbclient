package c.a.p0.d1.p.b.d;

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
    public float f13321e;

    /* renamed from: f  reason: collision with root package name */
    public final float f13322f;

    /* renamed from: g  reason: collision with root package name */
    public final WheelView f13323g;

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
        this.f13323g = wheelView;
        this.f13322f = f2;
        this.f13321e = 2.1474836E9f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f13321e == 2.1474836E9f) {
                if (Math.abs(this.f13322f) > 2000.0f) {
                    this.f13321e = this.f13322f <= 0.0f ? -2000.0f : 2000.0f;
                } else {
                    this.f13321e = this.f13322f;
                }
            }
            if (Math.abs(this.f13321e) >= 0.0f && Math.abs(this.f13321e) <= 20.0f) {
                this.f13323g.cancelFuture();
                this.f13323g.getHandler().sendEmptyMessage(2000);
                return;
            }
            WheelView wheelView = this.f13323g;
            float f2 = (int) (this.f13321e / 100.0f);
            wheelView.setTotalScrollY(wheelView.getTotalScrollY() - f2);
            if (!this.f13323g.isLoop()) {
                float itemHeight = this.f13323g.getItemHeight();
                float f3 = (-this.f13323g.getInitPosition()) * itemHeight;
                float itemsCount = ((this.f13323g.getItemsCount() - 1) - this.f13323g.getInitPosition()) * itemHeight;
                double d2 = itemHeight * 0.25d;
                if (this.f13323g.getTotalScrollY() - d2 < f3) {
                    f3 = this.f13323g.getTotalScrollY() + f2;
                } else if (this.f13323g.getTotalScrollY() + d2 > itemsCount) {
                    itemsCount = this.f13323g.getTotalScrollY() + f2;
                }
                if (this.f13323g.getTotalScrollY() <= f3) {
                    this.f13321e = 40.0f;
                    this.f13323g.setTotalScrollY((int) f3);
                } else if (this.f13323g.getTotalScrollY() >= itemsCount) {
                    this.f13323g.setTotalScrollY((int) itemsCount);
                    this.f13321e = -40.0f;
                }
            }
            float f4 = this.f13321e;
            if (f4 < 0.0f) {
                this.f13321e = f4 + 20.0f;
            } else {
                this.f13321e = f4 - 20.0f;
            }
            this.f13323g.getHandler().sendEmptyMessage(1000);
        }
    }
}
