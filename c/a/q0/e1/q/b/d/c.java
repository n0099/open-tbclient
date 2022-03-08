package c.a.q0.e1.q.b.d;

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

    /* renamed from: e  reason: collision with root package name */
    public int f12525e;

    /* renamed from: f  reason: collision with root package name */
    public int f12526f;

    /* renamed from: g  reason: collision with root package name */
    public int f12527g;

    /* renamed from: h  reason: collision with root package name */
    public final WheelView f12528h;

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
        this.f12528h = wheelView;
        this.f12527g = i2;
        this.f12525e = Integer.MAX_VALUE;
        this.f12526f = 0;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f12525e == Integer.MAX_VALUE) {
                this.f12525e = this.f12527g;
            }
            int i2 = this.f12525e;
            int i3 = (int) (i2 * 0.1f);
            this.f12526f = i3;
            if (i3 == 0) {
                if (i2 < 0) {
                    this.f12526f = -1;
                } else {
                    this.f12526f = 1;
                }
            }
            if (Math.abs(this.f12525e) <= 1) {
                this.f12528h.cancelFuture();
                this.f12528h.getHandler().sendEmptyMessage(3000);
                return;
            }
            WheelView wheelView = this.f12528h;
            wheelView.setTotalScrollY(wheelView.getTotalScrollY() + this.f12526f);
            if (!this.f12528h.isLoop()) {
                float itemHeight = this.f12528h.getItemHeight();
                float itemsCount = ((this.f12528h.getItemsCount() - 1) - this.f12528h.getInitPosition()) * itemHeight;
                if (this.f12528h.getTotalScrollY() <= (-this.f12528h.getInitPosition()) * itemHeight || this.f12528h.getTotalScrollY() >= itemsCount) {
                    WheelView wheelView2 = this.f12528h;
                    wheelView2.setTotalScrollY(wheelView2.getTotalScrollY() - this.f12526f);
                    this.f12528h.cancelFuture();
                    this.f12528h.getHandler().sendEmptyMessage(3000);
                    return;
                }
            }
            this.f12528h.getHandler().sendEmptyMessage(1000);
            this.f12525e -= this.f12526f;
        }
    }
}
