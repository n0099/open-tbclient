package com.baidu.searchbox.ui.wheelview3d.timer;

import com.baidu.searchbox.ui.wheelview3d.WheelView3d;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.TimerTask;
/* loaded from: classes7.dex */
public final class InertiaTimerTask extends TimerTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float mCurrentVelocityY;
    public final float mFirstVelocityY;
    public final WheelView3d mWheelView;

    public InertiaTimerTask(WheelView3d wheelView3d, float f2) {
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
        this.mWheelView = wheelView3d;
        this.mFirstVelocityY = f2;
        this.mCurrentVelocityY = 2.1474836E9f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.mCurrentVelocityY == 2.1474836E9f) {
                if (Math.abs(this.mFirstVelocityY) > 2000.0f) {
                    this.mCurrentVelocityY = this.mFirstVelocityY <= 0.0f ? -2000.0f : 2000.0f;
                } else {
                    this.mCurrentVelocityY = this.mFirstVelocityY;
                }
            }
            if (Math.abs(this.mCurrentVelocityY) >= 0.0f && Math.abs(this.mCurrentVelocityY) <= 20.0f) {
                this.mWheelView.cancelFuture();
                this.mWheelView.getHandler().sendEmptyMessage(2000);
                return;
            }
            WheelView3d wheelView3d = this.mWheelView;
            float f2 = (int) (this.mCurrentVelocityY / 100.0f);
            wheelView3d.setTotalScrollY(wheelView3d.getTotalScrollY() - f2);
            if (!this.mWheelView.isLoop()) {
                float itemHeight = this.mWheelView.getItemHeight();
                float f3 = (-this.mWheelView.getInitPosition()) * itemHeight;
                float itemsCount = ((this.mWheelView.getItemsCount() - 1) - this.mWheelView.getInitPosition()) * itemHeight;
                double d2 = itemHeight * 0.25d;
                if (this.mWheelView.getTotalScrollY() - d2 < f3) {
                    f3 = this.mWheelView.getTotalScrollY() + f2;
                } else if (this.mWheelView.getTotalScrollY() + d2 > itemsCount) {
                    itemsCount = this.mWheelView.getTotalScrollY() + f2;
                }
                if (this.mWheelView.getTotalScrollY() <= f3) {
                    this.mCurrentVelocityY = 40.0f;
                    this.mWheelView.setTotalScrollY((int) f3);
                } else if (this.mWheelView.getTotalScrollY() >= itemsCount) {
                    this.mWheelView.setTotalScrollY((int) itemsCount);
                    this.mCurrentVelocityY = -40.0f;
                }
            }
            float f4 = this.mCurrentVelocityY;
            if (f4 < 0.0f) {
                this.mCurrentVelocityY = f4 + 20.0f;
            } else {
                this.mCurrentVelocityY = f4 - 20.0f;
            }
            this.mWheelView.getHandler().sendEmptyMessage(1000);
        }
    }
}
