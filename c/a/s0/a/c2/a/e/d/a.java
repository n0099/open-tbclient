package c.a.s0.a.c2.a.e.d;

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
    public float f5650e;

    /* renamed from: f  reason: collision with root package name */
    public final float f5651f;

    /* renamed from: g  reason: collision with root package name */
    public final WheelView3d f5652g;

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
        this.f5652g = wheelView3d;
        this.f5651f = f2;
        this.f5650e = 2.1474836E9f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f5650e == 2.1474836E9f) {
                if (Math.abs(this.f5651f) > 2000.0f) {
                    this.f5650e = this.f5651f <= 0.0f ? -2000.0f : 2000.0f;
                } else {
                    this.f5650e = this.f5651f;
                }
            }
            if (Math.abs(this.f5650e) >= 0.0f && Math.abs(this.f5650e) <= 20.0f) {
                this.f5652g.cancelFuture();
                this.f5652g.getHandler().sendEmptyMessage(2000);
                return;
            }
            WheelView3d wheelView3d = this.f5652g;
            float f2 = (int) (this.f5650e / 100.0f);
            wheelView3d.setTotalScrollY(wheelView3d.getTotalScrollY() - f2);
            if (!this.f5652g.isLoop()) {
                float itemHeight = this.f5652g.getItemHeight();
                float f3 = (-this.f5652g.getInitPosition()) * itemHeight;
                float itemsCount = ((this.f5652g.getItemsCount() - 1) - this.f5652g.getInitPosition()) * itemHeight;
                double d2 = itemHeight * 0.25d;
                if (this.f5652g.getTotalScrollY() - d2 < f3) {
                    f3 = this.f5652g.getTotalScrollY() + f2;
                } else if (this.f5652g.getTotalScrollY() + d2 > itemsCount) {
                    itemsCount = this.f5652g.getTotalScrollY() + f2;
                }
                if (this.f5652g.getTotalScrollY() <= f3) {
                    this.f5650e = 40.0f;
                    this.f5652g.setTotalScrollY((int) f3);
                } else if (this.f5652g.getTotalScrollY() >= itemsCount) {
                    this.f5652g.setTotalScrollY((int) itemsCount);
                    this.f5650e = -40.0f;
                }
            }
            float f4 = this.f5650e;
            if (f4 < 0.0f) {
                this.f5650e = f4 + 20.0f;
            } else {
                this.f5650e = f4 - 20.0f;
            }
            this.f5652g.getHandler().sendEmptyMessage(1000);
        }
    }
}
