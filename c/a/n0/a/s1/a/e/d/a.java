package c.a.n0.a.s1.a.e.d;

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
    public float a;

    /* renamed from: b  reason: collision with root package name */
    public final float f6173b;

    /* renamed from: c  reason: collision with root package name */
    public final WheelView3d f6174c;

    public a(WheelView3d wheelView3d, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wheelView3d, Float.valueOf(f2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f6174c = wheelView3d;
        this.f6173b = f2;
        this.a = 2.1474836E9f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.a == 2.1474836E9f) {
                if (Math.abs(this.f6173b) > 2000.0f) {
                    this.a = this.f6173b <= 0.0f ? -2000.0f : 2000.0f;
                } else {
                    this.a = this.f6173b;
                }
            }
            if (Math.abs(this.a) >= 0.0f && Math.abs(this.a) <= 20.0f) {
                this.f6174c.b();
                this.f6174c.getHandler().sendEmptyMessage(2000);
                return;
            }
            WheelView3d wheelView3d = this.f6174c;
            float f2 = (int) (this.a / 100.0f);
            wheelView3d.setTotalScrollY(wheelView3d.getTotalScrollY() - f2);
            if (!this.f6174c.i()) {
                float itemHeight = this.f6174c.getItemHeight();
                float f3 = (-this.f6174c.getInitPosition()) * itemHeight;
                float itemsCount = ((this.f6174c.getItemsCount() - 1) - this.f6174c.getInitPosition()) * itemHeight;
                double d2 = itemHeight * 0.25d;
                if (this.f6174c.getTotalScrollY() - d2 < f3) {
                    f3 = this.f6174c.getTotalScrollY() + f2;
                } else if (this.f6174c.getTotalScrollY() + d2 > itemsCount) {
                    itemsCount = this.f6174c.getTotalScrollY() + f2;
                }
                if (this.f6174c.getTotalScrollY() <= f3) {
                    this.a = 40.0f;
                    this.f6174c.setTotalScrollY((int) f3);
                } else if (this.f6174c.getTotalScrollY() >= itemsCount) {
                    this.f6174c.setTotalScrollY((int) itemsCount);
                    this.a = -40.0f;
                }
            }
            float f4 = this.a;
            if (f4 < 0.0f) {
                this.a = f4 + 20.0f;
            } else {
                this.a = f4 - 20.0f;
            }
            this.f6174c.getHandler().sendEmptyMessage(1000);
        }
    }
}
