package androidx.core.view;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class KeyEventDispatcher {
    public static /* synthetic */ Interceptable $ic;
    public static boolean sActionBarFieldsFetched;
    public static Method sActionBarOnMenuKeyMethod;
    public static boolean sDialogFieldsFetched;
    public static Field sDialogKeyListenerField;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public interface Component {
        boolean superDispatchKeyEvent(KeyEvent keyEvent);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1177354629, "Landroidx/core/view/KeyEventDispatcher;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1177354629, "Landroidx/core/view/KeyEventDispatcher;");
        }
    }

    public KeyEventDispatcher() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean actionBarOnMenuKeyEventPre28(ActionBar actionBar, KeyEvent keyEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, actionBar, keyEvent)) == null) {
            if (!sActionBarFieldsFetched) {
                try {
                    sActionBarOnMenuKeyMethod = actionBar.getClass().getMethod("onMenuKeyEvent", KeyEvent.class);
                } catch (NoSuchMethodException unused) {
                }
                sActionBarFieldsFetched = true;
            }
            Method method = sActionBarOnMenuKeyMethod;
            if (method != null) {
                try {
                    return ((Boolean) method.invoke(actionBar, keyEvent)).booleanValue();
                } catch (IllegalAccessException | InvocationTargetException unused2) {
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean activitySuperDispatchKeyEventPre28(Activity activity, KeyEvent keyEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, activity, keyEvent)) == null) {
            activity.onUserInteraction();
            Window window = activity.getWindow();
            if (window.hasFeature(8)) {
                ActionBar actionBar = activity.getActionBar();
                if (keyEvent.getKeyCode() == 82 && actionBar != null && actionBarOnMenuKeyEventPre28(actionBar, keyEvent)) {
                    return true;
                }
            }
            if (window.superDispatchKeyEvent(keyEvent)) {
                return true;
            }
            View decorView = window.getDecorView();
            if (ViewCompat.dispatchUnhandledKeyEventBeforeCallback(decorView, keyEvent)) {
                return true;
            }
            return keyEvent.dispatch(activity, decorView != null ? decorView.getKeyDispatcherState() : null, activity);
        }
        return invokeLL.booleanValue;
    }

    public static boolean dialogSuperDispatchKeyEventPre28(Dialog dialog, KeyEvent keyEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65540, null, dialog, keyEvent)) == null) {
            DialogInterface.OnKeyListener dialogKeyListenerPre28 = getDialogKeyListenerPre28(dialog);
            if (dialogKeyListenerPre28 == null || !dialogKeyListenerPre28.onKey(dialog, keyEvent.getKeyCode(), keyEvent)) {
                Window window = dialog.getWindow();
                if (window.superDispatchKeyEvent(keyEvent)) {
                    return true;
                }
                View decorView = window.getDecorView();
                if (ViewCompat.dispatchUnhandledKeyEventBeforeCallback(decorView, keyEvent)) {
                    return true;
                }
                return keyEvent.dispatch(dialog, decorView != null ? decorView.getKeyDispatcherState() : null, dialog);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean dispatchBeforeHierarchy(@NonNull View view, @NonNull KeyEvent keyEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, view, keyEvent)) == null) ? ViewCompat.dispatchUnhandledKeyEventBeforeHierarchy(view, keyEvent) : invokeLL.booleanValue;
    }

    public static boolean dispatchKeyEvent(@NonNull Component component, @Nullable View view, @Nullable Window.Callback callback, @NonNull KeyEvent keyEvent) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(AdIconUtil.BAIDU_LOGO_ID, null, component, view, callback, keyEvent)) == null) {
            if (component == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 28) {
                return component.superDispatchKeyEvent(keyEvent);
            }
            if (callback instanceof Activity) {
                return activitySuperDispatchKeyEventPre28((Activity) callback, keyEvent);
            }
            if (callback instanceof Dialog) {
                return dialogSuperDispatchKeyEventPre28((Dialog) callback, keyEvent);
            }
            return (view != null && ViewCompat.dispatchUnhandledKeyEventBeforeCallback(view, keyEvent)) || component.superDispatchKeyEvent(keyEvent);
        }
        return invokeLLLL.booleanValue;
    }

    public static DialogInterface.OnKeyListener getDialogKeyListenerPre28(Dialog dialog) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, dialog)) == null) {
            if (!sDialogFieldsFetched) {
                try {
                    Field declaredField = Dialog.class.getDeclaredField("mOnKeyListener");
                    sDialogKeyListenerField = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException unused) {
                }
                sDialogFieldsFetched = true;
            }
            Field field = sDialogKeyListenerField;
            if (field != null) {
                try {
                    return (DialogInterface.OnKeyListener) field.get(dialog);
                } catch (IllegalAccessException unused2) {
                    return null;
                }
            }
            return null;
        }
        return (DialogInterface.OnKeyListener) invokeL.objValue;
    }
}
