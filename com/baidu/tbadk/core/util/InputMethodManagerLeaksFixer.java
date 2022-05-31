package com.baidu.tbadk.core.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ll4;
import java.lang.reflect.Field;
/* loaded from: classes3.dex */
public class InputMethodManagerLeaksFixer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public InputMethodManagerLeaksFixer() {
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

    public static void fixFocusedViewLeak(Application application) {
        InputMethodManager inputMethodManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, application) == null) || application == null || (inputMethodManager = (InputMethodManager) application.getSystemService("input_method")) == null) {
            return;
        }
        String[] strArr = {"mCurRootView", "mServedView", "mNextServedView"};
        Field[] fieldArr = new Field[3];
        for (int i = 0; i < 3; i++) {
            try {
                fieldArr[i] = inputMethodManager.getClass().getDeclaredField(strArr[i]);
                if (!fieldArr[i].isAccessible()) {
                    fieldArr[i].setAccessible(true);
                }
            } catch (Exception unused) {
            }
        }
        application.registerActivityLifecycleCallbacks(new ll4(fieldArr, inputMethodManager) { // from class: com.baidu.tbadk.core.util.InputMethodManagerLeaksFixer.1
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$field = fieldArr;
                this.val$inputMethodManager = inputMethodManager;
            }

            @Override // com.repackage.ll4, android.app.Application.ActivityLifecycleCallbacks
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
            if (field != null) {
                try {
                    Object obj = field.get(inputMethodManager);
                    if (!(obj instanceof View)) {
                        continue;
                    } else if (((View) obj).getContext() != context) {
                        return;
                    } else {
                        field.set(inputMethodManager, null);
                    }
                } catch (Exception unused) {
                }
            }
        }
    }
}
