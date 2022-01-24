package c.a.s0.f1.q.b.d;

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
    public int f12856e;

    /* renamed from: f  reason: collision with root package name */
    public int f12857f;

    /* renamed from: g  reason: collision with root package name */
    public int f12858g;

    /* renamed from: h  reason: collision with root package name */
    public final WheelView f12859h;

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
        this.f12859h = wheelView;
        this.f12858g = i2;
        this.f12856e = Integer.MAX_VALUE;
        this.f12857f = 0;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f12856e == Integer.MAX_VALUE) {
                this.f12856e = this.f12858g;
            }
            int i2 = this.f12856e;
            int i3 = (int) (i2 * 0.1f);
            this.f12857f = i3;
            if (i3 == 0) {
                if (i2 < 0) {
                    this.f12857f = -1;
                } else {
                    this.f12857f = 1;
                }
            }
            if (Math.abs(this.f12856e) <= 1) {
                this.f12859h.cancelFuture();
                this.f12859h.getHandler().sendEmptyMessage(3000);
                return;
            }
            WheelView wheelView = this.f12859h;
            wheelView.setTotalScrollY(wheelView.getTotalScrollY() + this.f12857f);
            if (!this.f12859h.isLoop()) {
                float itemHeight = this.f12859h.getItemHeight();
                float itemsCount = ((this.f12859h.getItemsCount() - 1) - this.f12859h.getInitPosition()) * itemHeight;
                if (this.f12859h.getTotalScrollY() <= (-this.f12859h.getInitPosition()) * itemHeight || this.f12859h.getTotalScrollY() >= itemsCount) {
                    WheelView wheelView2 = this.f12859h;
                    wheelView2.setTotalScrollY(wheelView2.getTotalScrollY() - this.f12857f);
                    this.f12859h.cancelFuture();
                    this.f12859h.getHandler().sendEmptyMessage(3000);
                    return;
                }
            }
            this.f12859h.getHandler().sendEmptyMessage(1000);
            this.f12856e -= this.f12857f;
        }
    }
}
