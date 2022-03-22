package c.a.n0.a.s1.a.e.d;

import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.TimerTask;
/* loaded from: classes.dex */
public final class c extends TimerTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f6175b;

    /* renamed from: c  reason: collision with root package name */
    public int f6176c;

    /* renamed from: d  reason: collision with root package name */
    public final WheelView3d f6177d;

    public c(WheelView3d wheelView3d, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wheelView3d, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f6177d = wheelView3d;
        this.f6176c = i;
        this.a = Integer.MAX_VALUE;
        this.f6175b = 0;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.a == Integer.MAX_VALUE) {
                this.a = this.f6176c;
            }
            int i = this.a;
            int i2 = (int) (i * 0.1f);
            this.f6175b = i2;
            if (i2 == 0) {
                if (i < 0) {
                    this.f6175b = -1;
                } else {
                    this.f6175b = 1;
                }
            }
            if (Math.abs(this.a) <= 1) {
                this.f6177d.b();
                this.f6177d.getHandler().sendEmptyMessage(3000);
                return;
            }
            WheelView3d wheelView3d = this.f6177d;
            wheelView3d.setTotalScrollY(wheelView3d.getTotalScrollY() + this.f6175b);
            if (!this.f6177d.i()) {
                float itemHeight = this.f6177d.getItemHeight();
                float itemsCount = ((this.f6177d.getItemsCount() - 1) - this.f6177d.getInitPosition()) * itemHeight;
                if (this.f6177d.getTotalScrollY() <= (-this.f6177d.getInitPosition()) * itemHeight || this.f6177d.getTotalScrollY() >= itemsCount) {
                    WheelView3d wheelView3d2 = this.f6177d;
                    wheelView3d2.setTotalScrollY(wheelView3d2.getTotalScrollY() - this.f6175b);
                    this.f6177d.b();
                    this.f6177d.getHandler().sendEmptyMessage(3000);
                    return;
                }
            }
            this.f6177d.getHandler().sendEmptyMessage(1000);
            this.a -= this.f6175b;
        }
    }
}
