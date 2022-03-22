package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
@RequiresApi(19)
/* loaded from: classes.dex */
public final class ImmLeaksCleaner implements LifecycleEventObserver {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INIT_FAILED = 2;
    public static final int INIT_SUCCESS = 1;
    public static final int NOT_INITIALIAZED = 0;
    public static Field sHField;
    public static Field sNextServedViewField;
    public static int sReflectedFieldsInitialized;
    public static Field sServedViewField;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity mActivity;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-994655150, "Landroidx/activity/ImmLeaksCleaner;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-994655150, "Landroidx/activity/ImmLeaksCleaner;");
        }
    }

    public ImmLeaksCleaner(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mActivity = activity;
    }

    @MainThread
    public static void initializeReflectiveFields() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            try {
                sReflectedFieldsInitialized = 2;
                Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
                sServedViewField = declaredField;
                declaredField.setAccessible(true);
                Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
                sNextServedViewField = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
                sHField = declaredField3;
                declaredField3.setAccessible(true);
                sReflectedFieldsInitialized = 1;
            } catch (NoSuchFieldException unused) {
            }
        }
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, lifecycleOwner, event) == null) && event == Lifecycle.Event.ON_DESTROY) {
            if (sReflectedFieldsInitialized == 0) {
                initializeReflectiveFields();
            }
            if (sReflectedFieldsInitialized == 1) {
                InputMethodManager inputMethodManager = (InputMethodManager) this.mActivity.getSystemService("input_method");
                try {
                    Object obj = sHField.get(inputMethodManager);
                    if (obj == null) {
                        return;
                    }
                    synchronized (obj) {
                        try {
                            try {
                                View view = (View) sServedViewField.get(inputMethodManager);
                                if (view == null) {
                                    return;
                                }
                                if (view.isAttachedToWindow()) {
                                    return;
                                }
                                try {
                                    sNextServedViewField.set(inputMethodManager, null);
                                    inputMethodManager.isActive();
                                } catch (IllegalAccessException unused) {
                                }
                            } catch (ClassCastException unused2) {
                            } catch (IllegalAccessException unused3) {
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                } catch (IllegalAccessException unused4) {
                }
            }
        }
    }
}
