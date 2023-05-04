package com.baidu.tbadk.core.util;

import android.hardware.display.DisplayManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class RefreshRateManager implements DisplayManager.DisplayListener, LifecycleObserver {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String REFRESH_START = "1";
    public static final String REFRESH_STOP = "2";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isAvailable;
    @Nullable
    public DisplayManager mDisplayManager;
    @Nullable
    public OnRefreshRateListener mOnRefreshRateListener;

    /* renamed from: com.baidu.tbadk.core.util.RefreshRateManager$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public interface OnRefreshRateListener {
        void onRefreshChanged(float f);
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayAdded(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
        }
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayRemoved(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public static class SingletonHolder {
        public static /* synthetic */ Interceptable $ic;
        public static final RefreshRateManager INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-395426730, "Lcom/baidu/tbadk/core/util/RefreshRateManager$SingletonHolder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-395426730, "Lcom/baidu/tbadk/core/util/RefreshRateManager$SingletonHolder;");
                    return;
                }
            }
            INSTANCE = new RefreshRateManager(null);
        }

        public SingletonHolder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    public RefreshRateManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isAvailable = false;
        if (TbadkApplication.getInst() != null && this.mDisplayManager == null) {
            this.mDisplayManager = (DisplayManager) TbadkApplication.getInst().getSystemService(CriusAttrConstants.DISPLAY);
        }
    }

    public /* synthetic */ RefreshRateManager(AnonymousClass1 anonymousClass1) {
        this();
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayChanged(int i) {
        DisplayManager displayManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && i == 0 && (displayManager = this.mDisplayManager) != null) {
            float refreshRate = displayManager.getDisplay(0).getRefreshRate();
            OnRefreshRateListener onRefreshRateListener = this.mOnRefreshRateListener;
            if (onRefreshRateListener != null) {
                onRefreshRateListener.onRefreshChanged(refreshRate);
            }
        }
    }

    public void setRefreshRateListener(OnRefreshRateListener onRefreshRateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onRefreshRateListener) == null) {
            this.mOnRefreshRateListener = onRefreshRateListener;
        }
    }

    @NonNull
    public static RefreshRateManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return SingletonHolder.INSTANCE;
        }
        return (RefreshRateManager) invokeV.objValue;
    }

    private void removeDisplayManager() {
        DisplayManager displayManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && (displayManager = this.mDisplayManager) != null) {
            displayManager.unregisterDisplayListener(this);
        }
    }

    public float getRefreshRate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            DisplayManager displayManager = this.mDisplayManager;
            if (displayManager != null && displayManager.getDisplay(0) != null) {
                return this.mDisplayManager.getDisplay(0).getRefreshRate();
            }
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.isAvailable) {
            start();
        }
    }

    public void start() {
        DisplayManager displayManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (displayManager = this.mDisplayManager) != null) {
            this.isAvailable = true;
            displayManager.registerDisplayListener(this, null);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.isAvailable = false;
            removeDisplayManager();
        }
    }
}
