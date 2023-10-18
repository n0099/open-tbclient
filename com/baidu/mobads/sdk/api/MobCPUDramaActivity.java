package com.baidu.mobads.sdk.api;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.av;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class MobCPUDramaActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public static IActivityImpl tempActivity;
    public transient /* synthetic */ FieldHolder $fh;
    public IActivityImpl mDramaActivity;

    public MobCPUDramaActivity() {
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

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.onAttachedToWindow();
            IActivityImpl iActivityImpl = this.mDramaActivity;
            if (iActivityImpl != null) {
                iActivityImpl.onAttachedToWindow();
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            IActivityImpl iActivityImpl = this.mDramaActivity;
            if (iActivityImpl != null) {
                z = iActivityImpl.onBackPressed();
            } else {
                z = false;
            }
            if (!z) {
                super.onBackPressed();
            }
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            IActivityImpl iActivityImpl = this.mDramaActivity;
            if (iActivityImpl != null) {
                iActivityImpl.onDestroy();
                this.mDramaActivity = null;
            }
            super.onDestroy();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDetachedFromWindow();
            IActivityImpl iActivityImpl = this.mDramaActivity;
            if (iActivityImpl != null) {
                iActivityImpl.onDetachedFromWindow();
            }
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onPause();
            IActivityImpl iActivityImpl = this.mDramaActivity;
            if (iActivityImpl != null) {
                iActivityImpl.onPause();
            }
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onResume();
            IActivityImpl iActivityImpl = this.mDramaActivity;
            if (iActivityImpl != null) {
                iActivityImpl.onResume();
            }
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onStop();
            IActivityImpl iActivityImpl = this.mDramaActivity;
            if (iActivityImpl != null) {
                iActivityImpl.onStop();
            }
        }
    }

    public static void setActivityImp(IActivityImpl iActivityImpl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, iActivityImpl) == null) {
            tempActivity = iActivityImpl;
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            IActivityImpl iActivityImpl = this.mDramaActivity;
            if (iActivityImpl != null) {
                iActivityImpl.onConfigurationChanged(configuration);
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            IActivityImpl iActivityImpl = tempActivity;
            if (iActivityImpl != null && this.mDramaActivity == null) {
                this.mDramaActivity = iActivityImpl;
                tempActivity = null;
            }
            IActivityImpl iActivityImpl2 = this.mDramaActivity;
            if (iActivityImpl2 != null) {
                iActivityImpl2.setActivity(this);
                this.mDramaActivity.onCreate(bundle);
            }
            super.onCreate(bundle);
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, intent) == null) {
            super.onNewIntent(intent);
            IActivityImpl iActivityImpl = tempActivity;
            if (iActivityImpl != null && this.mDramaActivity == null) {
                this.mDramaActivity = iActivityImpl;
                tempActivity = null;
            }
            IActivityImpl iActivityImpl2 = this.mDramaActivity;
            if (iActivityImpl2 != null) {
                iActivityImpl2.onNewIntent(intent);
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            IActivityImpl iActivityImpl = this.mDramaActivity;
            if (iActivityImpl != null) {
                iActivityImpl.onSaveInstanceState(bundle);
            }
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, motionEvent)) == null) {
            IActivityImpl iActivityImpl = this.mDramaActivity;
            if (iActivityImpl != null) {
                z = iActivityImpl.onTouchEvent(motionEvent);
            } else {
                z = false;
            }
            if (z) {
                return true;
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            super.onWindowFocusChanged(z);
            IActivityImpl iActivityImpl = this.mDramaActivity;
            if (iActivityImpl != null) {
                iActivityImpl.onWindowFocusChanged(z);
            }
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048582, this, i, keyEvent)) == null) {
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048583, this, i, keyEvent)) == null) {
            return super.onKeyUp(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048592, this, i, i2) == null) {
            super.overridePendingTransition(i, i2);
            IActivityImpl iActivityImpl = this.mDramaActivity;
            if (iActivityImpl != null) {
                iActivityImpl.overridePendingTransition(i, i2);
            }
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            try {
                ClassLoader classLoader = getClass().getClassLoader();
                if (classLoader != null) {
                    bundle.setClassLoader(classLoader);
                    Bundle bundle2 = bundle.getBundle("android:viewHierarchyState");
                    if (bundle2 != null) {
                        bundle2.setClassLoader(classLoader);
                    }
                }
                super.onRestoreInstanceState(bundle);
                if (this.mDramaActivity != null) {
                    this.mDramaActivity.onRestoreInstanceState(bundle);
                }
            } catch (Throwable th) {
                av.f(th.getMessage());
            }
        }
    }
}
