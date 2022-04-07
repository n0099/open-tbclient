package com.baidu.rtc.logreport;

import android.os.Handler;
import android.os.Looper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class StuckDataCalculator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long frameStartTime;
    public SLIReportInterface mStuckEvent;
    public int stuckInterval;
    public Runnable stuckRunnable;
    public Handler stuckTimer;

    public StuckDataCalculator(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.frameStartTime = 0L;
        this.stuckTimer = null;
        this.mStuckEvent = null;
        this.stuckInterval = 600;
        this.stuckRunnable = new Runnable(this) { // from class: com.baidu.rtc.logreport.StuckDataCalculator.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ StuckDataCalculator this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.reportStuckData();
                    this.this$0.stuckTimer.postDelayed(this.this$0.stuckRunnable, 5000L);
                }
            }
        };
        this.stuckTimer = new Handler(Looper.getMainLooper());
        this.stuckInterval = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportStuckData() {
        SLIReportInterface sLIReportInterface;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.frameStartTime;
            if (currentTimeMillis - j > this.stuckInterval && (sLIReportInterface = this.mStuckEvent) != null) {
                sLIReportInterface.onStuckData(j, currentTimeMillis);
            }
            this.frameStartTime = System.currentTimeMillis();
        }
    }

    public void calculateStuck() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.frameStartTime > 0) {
                this.stuckTimer.removeCallbacks(this.stuckRunnable);
                reportStuckData();
                this.stuckTimer.postDelayed(this.stuckRunnable, 5000L);
                return;
            }
            this.stuckTimer.postDelayed(this.stuckRunnable, 5000L);
            this.frameStartTime = System.currentTimeMillis();
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.frameStartTime = 0L;
            this.stuckTimer.removeCallbacks(this.stuckRunnable);
            this.mStuckEvent = null;
        }
    }

    public void setStuckEventListener(SLIReportInterface sLIReportInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sLIReportInterface) == null) {
            this.mStuckEvent = sLIReportInterface;
        }
    }
}
