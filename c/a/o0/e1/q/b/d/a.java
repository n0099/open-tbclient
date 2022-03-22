package c.a.o0.e1.q.b.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.TimerTask;
/* loaded from: classes2.dex */
public final class a extends TimerTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;

    /* renamed from: b  reason: collision with root package name */
    public final float f10245b;

    /* renamed from: c  reason: collision with root package name */
    public final WheelView f10246c;

    public a(WheelView wheelView, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wheelView, Float.valueOf(f2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f10246c = wheelView;
        this.f10245b = f2;
        this.a = 2.1474836E9f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.a == 2.1474836E9f) {
                if (Math.abs(this.f10245b) > 2000.0f) {
                    this.a = this.f10245b <= 0.0f ? -2000.0f : 2000.0f;
                } else {
                    this.a = this.f10245b;
                }
            }
            if (Math.abs(this.a) >= 0.0f && Math.abs(this.a) <= 20.0f) {
                this.f10246c.b();
                this.f10246c.getHandler().sendEmptyMessage(2000);
                return;
            }
            WheelView wheelView = this.f10246c;
            float f2 = (int) (this.a / 100.0f);
            wheelView.setTotalScrollY(wheelView.getTotalScrollY() - f2);
            if (!this.f10246c.i()) {
                float itemHeight = this.f10246c.getItemHeight();
                float f3 = (-this.f10246c.getInitPosition()) * itemHeight;
                float itemsCount = ((this.f10246c.getItemsCount() - 1) - this.f10246c.getInitPosition()) * itemHeight;
                double d2 = itemHeight * 0.25d;
                if (this.f10246c.getTotalScrollY() - d2 < f3) {
                    f3 = this.f10246c.getTotalScrollY() + f2;
                } else if (this.f10246c.getTotalScrollY() + d2 > itemsCount) {
                    itemsCount = this.f10246c.getTotalScrollY() + f2;
                }
                if (this.f10246c.getTotalScrollY() <= f3) {
                    this.a = 40.0f;
                    this.f10246c.setTotalScrollY((int) f3);
                } else if (this.f10246c.getTotalScrollY() >= itemsCount) {
                    this.f10246c.setTotalScrollY((int) itemsCount);
                    this.a = -40.0f;
                }
            }
            float f4 = this.a;
            if (f4 < 0.0f) {
                this.a = f4 + 20.0f;
            } else {
                this.a = f4 - 20.0f;
            }
            this.f10246c.getHandler().sendEmptyMessage(1000);
        }
    }
}
