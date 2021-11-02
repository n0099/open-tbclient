package com.baidu.searchbox.ui.wheelview3d.timer;

import com.baidu.searchbox.ui.wheelview3d.WheelView3d;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.TimerTask;
/* loaded from: classes7.dex */
public final class SmoothScrollTimerTask extends TimerTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int offset;
    public int realOffset;
    public int realTotalOffset;
    public final WheelView3d wheelView;

    public SmoothScrollTimerTask(WheelView3d wheelView3d, int i2) {
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
        this.wheelView = wheelView3d;
        this.offset = i2;
        this.realTotalOffset = Integer.MAX_VALUE;
        this.realOffset = 0;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.realTotalOffset == Integer.MAX_VALUE) {
                this.realTotalOffset = this.offset;
            }
            int i2 = this.realTotalOffset;
            int i3 = (int) (i2 * 0.1f);
            this.realOffset = i3;
            if (i3 == 0) {
                if (i2 < 0) {
                    this.realOffset = -1;
                } else {
                    this.realOffset = 1;
                }
            }
            if (Math.abs(this.realTotalOffset) <= 1) {
                this.wheelView.cancelFuture();
                this.wheelView.getHandler().sendEmptyMessage(3000);
                return;
            }
            WheelView3d wheelView3d = this.wheelView;
            wheelView3d.setTotalScrollY(wheelView3d.getTotalScrollY() + this.realOffset);
            if (!this.wheelView.isLoop()) {
                float itemHeight = this.wheelView.getItemHeight();
                float itemsCount = ((this.wheelView.getItemsCount() - 1) - this.wheelView.getInitPosition()) * itemHeight;
                if (this.wheelView.getTotalScrollY() <= (-this.wheelView.getInitPosition()) * itemHeight || this.wheelView.getTotalScrollY() >= itemsCount) {
                    WheelView3d wheelView3d2 = this.wheelView;
                    wheelView3d2.setTotalScrollY(wheelView3d2.getTotalScrollY() - this.realOffset);
                    this.wheelView.cancelFuture();
                    this.wheelView.getHandler().sendEmptyMessage(3000);
                    return;
                }
            }
            this.wheelView.getHandler().sendEmptyMessage(1000);
            this.realTotalOffset -= this.realOffset;
        }
    }
}
