package c.a.r0.a.c2.a.e.d;

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
    public float f5526e;

    /* renamed from: f  reason: collision with root package name */
    public final float f5527f;

    /* renamed from: g  reason: collision with root package name */
    public final WheelView3d f5528g;

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
        this.f5528g = wheelView3d;
        this.f5527f = f2;
        this.f5526e = 2.1474836E9f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f5526e == 2.1474836E9f) {
                if (Math.abs(this.f5527f) > 2000.0f) {
                    this.f5526e = this.f5527f <= 0.0f ? -2000.0f : 2000.0f;
                } else {
                    this.f5526e = this.f5527f;
                }
            }
            if (Math.abs(this.f5526e) >= 0.0f && Math.abs(this.f5526e) <= 20.0f) {
                this.f5528g.cancelFuture();
                this.f5528g.getHandler().sendEmptyMessage(2000);
                return;
            }
            WheelView3d wheelView3d = this.f5528g;
            float f2 = (int) (this.f5526e / 100.0f);
            wheelView3d.setTotalScrollY(wheelView3d.getTotalScrollY() - f2);
            if (!this.f5528g.isLoop()) {
                float itemHeight = this.f5528g.getItemHeight();
                float f3 = (-this.f5528g.getInitPosition()) * itemHeight;
                float itemsCount = ((this.f5528g.getItemsCount() - 1) - this.f5528g.getInitPosition()) * itemHeight;
                double d2 = itemHeight * 0.25d;
                if (this.f5528g.getTotalScrollY() - d2 < f3) {
                    f3 = this.f5528g.getTotalScrollY() + f2;
                } else if (this.f5528g.getTotalScrollY() + d2 > itemsCount) {
                    itemsCount = this.f5528g.getTotalScrollY() + f2;
                }
                if (this.f5528g.getTotalScrollY() <= f3) {
                    this.f5526e = 40.0f;
                    this.f5528g.setTotalScrollY((int) f3);
                } else if (this.f5528g.getTotalScrollY() >= itemsCount) {
                    this.f5528g.setTotalScrollY((int) itemsCount);
                    this.f5526e = -40.0f;
                }
            }
            float f4 = this.f5526e;
            if (f4 < 0.0f) {
                this.f5526e = f4 + 20.0f;
            } else {
                this.f5526e = f4 - 20.0f;
            }
            this.f5528g.getHandler().sendEmptyMessage(1000);
        }
    }
}
