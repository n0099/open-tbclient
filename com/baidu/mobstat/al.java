package com.baidu.mobstat;

import android.annotation.SuppressLint;
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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class al implements Window.Callback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Window.Callback f40974a;

    /* renamed from: b  reason: collision with root package name */
    public a f40975b;

    /* loaded from: classes7.dex */
    public interface a {
        void a(KeyEvent keyEvent);

        void a(MotionEvent motionEvent);
    }

    public al(Window.Callback callback, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {callback, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f40974a = callback;
        this.f40975b = aVar;
    }

    public Window.Callback a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f40974a : (Window.Callback) invokeV.objValue;
    }

    @Override // android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) ? this.f40974a.dispatchGenericMotionEvent(motionEvent) : invokeL.booleanValue;
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, keyEvent)) == null) {
            a aVar = this.f40975b;
            if (aVar != null) {
                aVar.a(keyEvent);
            }
            return this.f40974a.dispatchKeyEvent(keyEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, keyEvent)) == null) ? this.f40974a.dispatchKeyShortcutEvent(keyEvent) : invokeL.booleanValue;
    }

    @Override // android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, accessibilityEvent)) == null) ? this.f40974a.dispatchPopulateAccessibilityEvent(accessibilityEvent) : invokeL.booleanValue;
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
            a aVar = this.f40975b;
            if (aVar != null) {
                aVar.a(motionEvent);
            }
            return this.f40974a.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) ? this.f40974a.dispatchTrackballEvent(motionEvent) : invokeL.booleanValue;
    }

    @Override // android.view.Window.Callback
    public void onActionModeFinished(ActionMode actionMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, actionMode) == null) {
            this.f40974a.onActionModeFinished(actionMode);
        }
    }

    @Override // android.view.Window.Callback
    public void onActionModeStarted(ActionMode actionMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, actionMode) == null) {
            this.f40974a.onActionModeStarted(actionMode);
        }
    }

    @Override // android.view.Window.Callback
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f40974a.onAttachedToWindow();
        }
    }

    @Override // android.view.Window.Callback
    public void onContentChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f40974a.onContentChanged();
        }
    }

    @Override // android.view.Window.Callback
    public boolean onCreatePanelMenu(int i2, Menu menu) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048587, this, i2, menu)) == null) ? this.f40974a.onCreatePanelMenu(i2, menu) : invokeIL.booleanValue;
    }

    @Override // android.view.Window.Callback
    public View onCreatePanelView(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) ? this.f40974a.onCreatePanelView(i2) : (View) invokeI.objValue;
    }

    @Override // android.view.Window.Callback
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f40974a.onDetachedFromWindow();
        }
    }

    @Override // android.view.Window.Callback
    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048590, this, i2, menuItem)) == null) ? this.f40974a.onMenuItemSelected(i2, menuItem) : invokeIL.booleanValue;
    }

    @Override // android.view.Window.Callback
    public boolean onMenuOpened(int i2, Menu menu) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048591, this, i2, menu)) == null) ? this.f40974a.onMenuOpened(i2, menu) : invokeIL.booleanValue;
    }

    @Override // android.view.Window.Callback
    public void onPanelClosed(int i2, Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048592, this, i2, menu) == null) {
            this.f40974a.onPanelClosed(i2, menu);
        }
    }

    @Override // android.view.Window.Callback
    @SuppressLint({"NewApi"})
    public void onPointerCaptureChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.f40974a.onPointerCaptureChanged(z);
        }
    }

    @Override // android.view.Window.Callback
    public boolean onPreparePanel(int i2, View view, Menu menu) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeILL = interceptable.invokeILL(1048594, this, i2, view, menu)) == null) ? this.f40974a.onPreparePanel(i2, view, menu) : invokeILL.booleanValue;
    }

    @Override // android.view.Window.Callback
    @SuppressLint({"NewApi"})
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048595, this, list, menu, i2) == null) {
            this.f40974a.onProvideKeyboardShortcuts(list, menu, i2);
        }
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f40974a.onSearchRequested() : invokeV.booleanValue;
    }

    @Override // android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, layoutParams) == null) {
            this.f40974a.onWindowAttributesChanged(layoutParams);
        }
    }

    @Override // android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.f40974a.onWindowFocusChanged(z);
        }
    }

    @Override // android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, callback)) == null) ? this.f40974a.onWindowStartingActionMode(callback) : (ActionMode) invokeL.objValue;
    }

    @Override // android.view.Window.Callback
    @SuppressLint({"NewApi"})
    public boolean onSearchRequested(SearchEvent searchEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, searchEvent)) == null) ? this.f40974a.onSearchRequested(searchEvent) : invokeL.booleanValue;
    }

    @Override // android.view.Window.Callback
    @SuppressLint({"NewApi"})
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048601, this, callback, i2)) == null) ? this.f40974a.onWindowStartingActionMode(callback, i2) : (ActionMode) invokeLI.objValue;
    }
}
