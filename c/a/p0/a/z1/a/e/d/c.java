package c.a.p0.a.z1.a.e.d;

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

    /* renamed from: e  reason: collision with root package name */
    public int f9993e;

    /* renamed from: f  reason: collision with root package name */
    public int f9994f;

    /* renamed from: g  reason: collision with root package name */
    public int f9995g;

    /* renamed from: h  reason: collision with root package name */
    public final WheelView3d f9996h;

    public c(WheelView3d wheelView3d, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wheelView3d, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f9996h = wheelView3d;
        this.f9995g = i2;
        this.f9993e = Integer.MAX_VALUE;
        this.f9994f = 0;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f9993e == Integer.MAX_VALUE) {
                this.f9993e = this.f9995g;
            }
            int i2 = this.f9993e;
            int i3 = (int) (i2 * 0.1f);
            this.f9994f = i3;
            if (i3 == 0) {
                if (i2 < 0) {
                    this.f9994f = -1;
                } else {
                    this.f9994f = 1;
                }
            }
            if (Math.abs(this.f9993e) <= 1) {
                this.f9996h.cancelFuture();
                this.f9996h.getHandler().sendEmptyMessage(3000);
                return;
            }
            WheelView3d wheelView3d = this.f9996h;
            wheelView3d.setTotalScrollY(wheelView3d.getTotalScrollY() + this.f9994f);
            if (!this.f9996h.isLoop()) {
                float itemHeight = this.f9996h.getItemHeight();
                float itemsCount = ((this.f9996h.getItemsCount() - 1) - this.f9996h.getInitPosition()) * itemHeight;
                if (this.f9996h.getTotalScrollY() <= (-this.f9996h.getInitPosition()) * itemHeight || this.f9996h.getTotalScrollY() >= itemsCount) {
                    WheelView3d wheelView3d2 = this.f9996h;
                    wheelView3d2.setTotalScrollY(wheelView3d2.getTotalScrollY() - this.f9994f);
                    this.f9996h.cancelFuture();
                    this.f9996h.getHandler().sendEmptyMessage(3000);
                    return;
                }
            }
            this.f9996h.getHandler().sendEmptyMessage(1000);
            this.f9993e -= this.f9994f;
        }
    }
}
