package c.a.n0.a.z1.a.e.d;

import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.TimerTask;
/* loaded from: classes.dex */
public final class a extends TimerTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public float f9707e;

    /* renamed from: f  reason: collision with root package name */
    public final float f9708f;

    /* renamed from: g  reason: collision with root package name */
    public final WheelView3d f9709g;

    public a(WheelView3d wheelView3d, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wheelView3d, Float.valueOf(f2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f9709g = wheelView3d;
        this.f9708f = f2;
        this.f9707e = 2.1474836E9f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f9707e == 2.1474836E9f) {
                if (Math.abs(this.f9708f) > 2000.0f) {
                    this.f9707e = this.f9708f <= 0.0f ? -2000.0f : 2000.0f;
                } else {
                    this.f9707e = this.f9708f;
                }
            }
            if (Math.abs(this.f9707e) >= 0.0f && Math.abs(this.f9707e) <= 20.0f) {
                this.f9709g.cancelFuture();
                this.f9709g.getHandler().sendEmptyMessage(2000);
                return;
            }
            WheelView3d wheelView3d = this.f9709g;
            float f2 = (int) (this.f9707e / 100.0f);
            wheelView3d.setTotalScrollY(wheelView3d.getTotalScrollY() - f2);
            if (!this.f9709g.isLoop()) {
                float itemHeight = this.f9709g.getItemHeight();
                float f3 = (-this.f9709g.getInitPosition()) * itemHeight;
                float itemsCount = ((this.f9709g.getItemsCount() - 1) - this.f9709g.getInitPosition()) * itemHeight;
                double d2 = itemHeight * 0.25d;
                if (this.f9709g.getTotalScrollY() - d2 < f3) {
                    f3 = this.f9709g.getTotalScrollY() + f2;
                } else if (this.f9709g.getTotalScrollY() + d2 > itemsCount) {
                    itemsCount = this.f9709g.getTotalScrollY() + f2;
                }
                if (this.f9709g.getTotalScrollY() <= f3) {
                    this.f9707e = 40.0f;
                    this.f9709g.setTotalScrollY((int) f3);
                } else if (this.f9709g.getTotalScrollY() >= itemsCount) {
                    this.f9709g.setTotalScrollY((int) itemsCount);
                    this.f9707e = -40.0f;
                }
            }
            float f4 = this.f9707e;
            if (f4 < 0.0f) {
                this.f9707e = f4 + 20.0f;
            } else {
                this.f9707e = f4 - 20.0f;
            }
            this.f9709g.getHandler().sendEmptyMessage(1000);
        }
    }
}
