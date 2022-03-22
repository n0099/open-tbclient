package c.a.o0.e1.q.b.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.TimerTask;
/* loaded from: classes2.dex */
public final class c extends TimerTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f10247b;

    /* renamed from: c  reason: collision with root package name */
    public int f10248c;

    /* renamed from: d  reason: collision with root package name */
    public final WheelView f10249d;

    public c(WheelView wheelView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wheelView, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f10249d = wheelView;
        this.f10248c = i;
        this.a = Integer.MAX_VALUE;
        this.f10247b = 0;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.a == Integer.MAX_VALUE) {
                this.a = this.f10248c;
            }
            int i = this.a;
            int i2 = (int) (i * 0.1f);
            this.f10247b = i2;
            if (i2 == 0) {
                if (i < 0) {
                    this.f10247b = -1;
                } else {
                    this.f10247b = 1;
                }
            }
            if (Math.abs(this.a) <= 1) {
                this.f10249d.b();
                this.f10249d.getHandler().sendEmptyMessage(3000);
                return;
            }
            WheelView wheelView = this.f10249d;
            wheelView.setTotalScrollY(wheelView.getTotalScrollY() + this.f10247b);
            if (!this.f10249d.i()) {
                float itemHeight = this.f10249d.getItemHeight();
                float itemsCount = ((this.f10249d.getItemsCount() - 1) - this.f10249d.getInitPosition()) * itemHeight;
                if (this.f10249d.getTotalScrollY() <= (-this.f10249d.getInitPosition()) * itemHeight || this.f10249d.getTotalScrollY() >= itemsCount) {
                    WheelView wheelView2 = this.f10249d;
                    wheelView2.setTotalScrollY(wheelView2.getTotalScrollY() - this.f10247b);
                    this.f10249d.b();
                    this.f10249d.getHandler().sendEmptyMessage(3000);
                    return;
                }
            }
            this.f10249d.getHandler().sendEmptyMessage(1000);
            this.a -= this.f10247b;
        }
    }
}
