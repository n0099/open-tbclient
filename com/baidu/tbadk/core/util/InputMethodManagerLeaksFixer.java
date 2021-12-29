package com.baidu.tbadk.core.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import c.a.s0.n.g;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
/* loaded from: classes11.dex */
public class InputMethodManagerLeaksFixer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public InputMethodManagerLeaksFixer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void fixFocusedViewLeak(Application application) {
        InputMethodManager inputMethodManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, application) == null) || application == null || (inputMethodManager = (InputMethodManager) application.getSystemService("input_method")) == null) {
            return;
        }
        String[] strArr = {"mCurRootView", "mServedView", "mNextServedView"};
        Field[] fieldArr = new Field[3];
        for (int i2 = 0; i2 < 3; i2++) {
            try {
                fieldArr[i2] = inputMethodManager.getClass().getDeclaredField(strArr[i2]);
                if (!fieldArr[i2].isAccessible()) {
                    fieldArr[i2].setAccessible(true);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        application.registerActivityLifecycleCallbacks(new g(fieldArr, inputMethodManager) { // from class: com.baidu.tbadk.core.util.InputMethodManagerLeaksFixer.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Field[] val$field;
            public final /* synthetic */ InputMethodManager val$inputMethodManager;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fieldArr, inputMethodManager};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$field = fieldArr;
                this.val$inputMethodManager = inputMethodManager;
            }

            @Override // c.a.s0.n.g, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, activity) == null) {
                    InputMethodManagerLeaksFixer.fixInputMethodMemoryLeak(activity, this.val$field, this.val$inputMethodManager);
                }
            }
        });
    }

    public static void fixInputMethodMemoryLeak(Context context, Field[] fieldArr, InputMethodManager inputMethodManager) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, context, fieldArr, inputMethodManager) == null) || context == null || fieldArr == null || fieldArr.length <= 0 || inputMethodManager == null) {
            return;
        }
        for (Field field : fieldArr) {
            try {
                Object obj = field.get(inputMethodManager);
                if (!(obj instanceof View)) {
                    continue;
                } else if (((View) obj).getContext() != context) {
                    return;
                } else {
                    field.set(inputMethodManager, null);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
