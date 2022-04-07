package com.baidu.ala.refresh;

import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class AlaSquareRefreshManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long[] mCurRefreshTimes;
    public Handler mHandler;
    public long[] mPageRefreshInterval;
    public RefreshRunnable[] mPageRefreshRunnables;
    public ISquareRefreshHandler mSquareRefreshHandler;

    public AlaSquareRefreshManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private boolean checkIndex(int i) {
        InterceptResult invokeI;
        long[] jArr;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i)) == null) ? i >= 0 && (jArr = this.mPageRefreshInterval) != null && jArr.length > i : invokeI.booleanValue;
    }

    private void createPageRefreshRunnables() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            long[] jArr = this.mPageRefreshInterval;
            int length = jArr.length;
            this.mPageRefreshRunnables = new RefreshRunnable[jArr.length];
            for (int i = 0; i < length; i++) {
                RefreshRunnable refreshRunnable = new RefreshRunnable(this, i, getTimeByIndex(this.mPageRefreshInterval, i));
                refreshRunnable.postDelay();
                this.mPageRefreshRunnables[i] = refreshRunnable;
            }
        }
    }

    private long getTimeByIndex(long[] jArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, this, jArr, i)) == null) {
            if (jArr == null || i < 0 || jArr.length <= i) {
                return -1L;
            }
            return jArr[i];
        }
        return invokeLI.longValue;
    }

    private void releasePageRefreshRunnables() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            int length = this.mPageRefreshRunnables.length;
            for (int i = 0; i < length; i++) {
                this.mHandler.removeCallbacks(this.mPageRefreshRunnables[i]);
            }
        }
    }

    public void init(ISquareRefreshHandler iSquareRefreshHandler, long[] jArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, iSquareRefreshHandler, jArr) == null) || iSquareRefreshHandler == null || jArr == null || jArr.length == 0) {
            return;
        }
        this.mSquareRefreshHandler = iSquareRefreshHandler;
        if (this.mHandler == null) {
            this.mHandler = new Handler();
        }
        if (this.mPageRefreshInterval != null) {
            releasePageRefreshRunnables();
        }
        this.mPageRefreshInterval = jArr;
        this.mCurRefreshTimes = new long[jArr.length];
        if (this.mPageRefreshRunnables == null) {
            createPageRefreshRunnables();
        }
    }

    public void onDestory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mHandler.removeCallbacksAndMessages(null);
            this.mPageRefreshRunnables = null;
            this.mPageRefreshInterval = null;
            this.mCurRefreshTimes = null;
        }
    }

    public void onPageForeground(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && checkIndex(i)) {
            long currentTimeMillis = System.currentTimeMillis() - this.mCurRefreshTimes[i];
            if (currentTimeMillis > this.mPageRefreshInterval[i]) {
                this.mPageRefreshRunnables[i].post();
            } else {
                this.mPageRefreshRunnables[i].postDelay(currentTimeMillis);
            }
        }
    }

    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (RefreshRunnable refreshRunnable : this.mPageRefreshRunnables) {
                this.mHandler.removeCallbacks(refreshRunnable);
            }
        }
    }

    public void reset(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && checkIndex(i)) {
            this.mHandler.removeCallbacks(this.mPageRefreshRunnables[i]);
            this.mPageRefreshRunnables[i].postDelay();
        }
    }

    /* loaded from: classes.dex */
    public class RefreshRunnable implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mIndex;
        public long mInterval;
        public final /* synthetic */ AlaSquareRefreshManager this$0;

        public RefreshRunnable(AlaSquareRefreshManager alaSquareRefreshManager, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaSquareRefreshManager, Integer.valueOf(i), Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = alaSquareRefreshManager;
            this.mIndex = 0;
            this.mInterval = 0L;
            this.mIndex = i;
            this.mInterval = j;
        }

        public void post() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.mInterval <= 0) {
                return;
            }
            this.this$0.mHandler.removeCallbacks(this);
            this.this$0.mHandler.post(this);
        }

        public void postDelay() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.mInterval <= 0) {
                return;
            }
            this.this$0.mHandler.removeCallbacks(this);
            this.this$0.mHandler.postDelayed(this, this.mInterval);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.this$0.mSquareRefreshHandler != null && this.this$0.mSquareRefreshHandler.isForeGround(this.mIndex)) {
                this.this$0.mCurRefreshTimes[this.mIndex] = System.currentTimeMillis();
                this.this$0.mSquareRefreshHandler.startRefresh(this.mIndex);
                postDelay();
            }
        }

        public void postDelay(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) || this.mInterval <= 0) {
                return;
            }
            this.this$0.mHandler.removeCallbacks(this);
            this.this$0.mHandler.postDelayed(this, j);
        }
    }
}
