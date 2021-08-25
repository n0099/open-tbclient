package c.a.p0.d1.p.b.d;

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
    public int f13325e;

    /* renamed from: f  reason: collision with root package name */
    public int f13326f;

    /* renamed from: g  reason: collision with root package name */
    public int f13327g;

    /* renamed from: h  reason: collision with root package name */
    public final WheelView f13328h;

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
        this.f13328h = wheelView;
        this.f13327g = i2;
        this.f13325e = Integer.MAX_VALUE;
        this.f13326f = 0;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f13325e == Integer.MAX_VALUE) {
                this.f13325e = this.f13327g;
            }
            int i2 = this.f13325e;
            int i3 = (int) (i2 * 0.1f);
            this.f13326f = i3;
            if (i3 == 0) {
                if (i2 < 0) {
                    this.f13326f = -1;
                } else {
                    this.f13326f = 1;
                }
            }
            if (Math.abs(this.f13325e) <= 1) {
                this.f13328h.cancelFuture();
                this.f13328h.getHandler().sendEmptyMessage(3000);
                return;
            }
            WheelView wheelView = this.f13328h;
            wheelView.setTotalScrollY(wheelView.getTotalScrollY() + this.f13326f);
            if (!this.f13328h.isLoop()) {
                float itemHeight = this.f13328h.getItemHeight();
                float itemsCount = ((this.f13328h.getItemsCount() - 1) - this.f13328h.getInitPosition()) * itemHeight;
                if (this.f13328h.getTotalScrollY() <= (-this.f13328h.getInitPosition()) * itemHeight || this.f13328h.getTotalScrollY() >= itemsCount) {
                    WheelView wheelView2 = this.f13328h;
                    wheelView2.setTotalScrollY(wheelView2.getTotalScrollY() - this.f13326f);
                    this.f13328h.cancelFuture();
                    this.f13328h.getHandler().sendEmptyMessage(3000);
                    return;
                }
            }
            this.f13328h.getHandler().sendEmptyMessage(1000);
            this.f13325e -= this.f13326f;
        }
    }
}
