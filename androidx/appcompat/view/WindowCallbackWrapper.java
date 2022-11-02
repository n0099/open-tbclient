package androidx.appcompat.view;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class WindowCallbackWrapper implements Window.Callback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Window.Callback mWrapped;

    public WindowCallbackWrapper(Window.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {callback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (callback != null) {
            this.mWrapped = callback;
            return;
        }
        throw new IllegalArgumentException("Window callback may not be null");
    }

    @Override // android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            return this.mWrapped.dispatchGenericMotionEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, keyEvent)) == null) {
            return this.mWrapped.dispatchKeyEvent(keyEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, keyEvent)) == null) {
            return this.mWrapped.dispatchKeyShortcutEvent(keyEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, accessibilityEvent)) == null) {
            return this.mWrapped.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            return this.mWrapped.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
            return this.mWrapped.dispatchTrackballEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.Window.Callback
    public void onActionModeFinished(android.view.ActionMode actionMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, actionMode) == null) {
            this.mWrapped.onActionModeFinished(actionMode);
        }
    }

    @Override // android.view.Window.Callback
    public void onActionModeStarted(android.view.ActionMode actionMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, actionMode) == null) {
            this.mWrapped.onActionModeStarted(actionMode);
        }
    }

    @Override // android.view.Window.Callback
    public View onCreatePanelView(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            return this.mWrapped.onCreatePanelView(i);
        }
        return (View) invokeI.objValue;
    }

    @Override // android.view.Window.Callback
    @RequiresApi(26)
    public void onPointerCaptureChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.mWrapped.onPointerCaptureChanged(z);
        }
    }

    @Override // android.view.Window.Callback
    @RequiresApi(23)
    public boolean onSearchRequested(SearchEvent searchEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, searchEvent)) == null) {
            return this.mWrapped.onSearchRequested(searchEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, layoutParams) == null) {
            this.mWrapped.onWindowAttributesChanged(layoutParams);
        }
    }

    @Override // android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.mWrapped.onWindowFocusChanged(z);
        }
    }

    @Override // android.view.Window.Callback
    public android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, callback)) == null) {
            return this.mWrapped.onWindowStartingActionMode(callback);
        }
        return (android.view.ActionMode) invokeL.objValue;
    }

    public final Window.Callback getWrapped() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mWrapped;
        }
        return (Window.Callback) invokeV.objValue;
    }

    @Override // android.view.Window.Callback
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.mWrapped.onAttachedToWindow();
        }
    }

    @Override // android.view.Window.Callback
    public void onContentChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.mWrapped.onContentChanged();
        }
    }

    @Override // android.view.Window.Callback
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.mWrapped.onDetachedFromWindow();
        }
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.mWrapped.onSearchRequested();
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048587, this, i, menu)) == null) {
            return this.mWrapped.onCreatePanelMenu(i, menu);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048590, this, i, menuItem)) == null) {
            return this.mWrapped.onMenuItemSelected(i, menuItem);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048591, this, i, menu)) == null) {
            return this.mWrapped.onMenuOpened(i, menu);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048592, this, i, menu) == null) {
            this.mWrapped.onPanelClosed(i, menu);
        }
    }

    @Override // android.view.Window.Callback
    @RequiresApi(23)
    public android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048601, this, callback, i)) == null) {
            return this.mWrapped.onWindowStartingActionMode(callback, i);
        }
        return (android.view.ActionMode) invokeLI.objValue;
    }

    @Override // android.view.Window.Callback
    public boolean onPreparePanel(int i, View view2, Menu menu) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048594, this, i, view2, menu)) == null) {
            return this.mWrapped.onPreparePanel(i, view2, menu);
        }
        return invokeILL.booleanValue;
    }

    @Override // android.view.Window.Callback
    @RequiresApi(24)
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048595, this, list, menu, i) == null) {
            this.mWrapped.onProvideKeyboardShortcuts(list, menu, i);
        }
    }
}
