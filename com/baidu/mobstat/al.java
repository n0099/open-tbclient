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
import java.util.List;
/* loaded from: classes15.dex */
public class al implements Window.Callback {

    /* renamed from: a  reason: collision with root package name */
    private Window.Callback f3700a;

    /* renamed from: b  reason: collision with root package name */
    private a f3701b;

    /* loaded from: classes15.dex */
    public interface a {
        void a(KeyEvent keyEvent);

        void a(MotionEvent motionEvent);
    }

    public Window.Callback a() {
        return this.f3700a;
    }

    public al(Window.Callback callback, a aVar) {
        this.f3700a = callback;
        this.f3701b = aVar;
    }

    @Override // android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f3700a.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (this.f3701b != null) {
            this.f3701b.a(keyEvent);
        }
        return this.f3700a.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.f3700a.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f3700a.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f3701b != null) {
            this.f3701b.a(motionEvent);
        }
        return this.f3700a.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f3700a.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public void onActionModeFinished(ActionMode actionMode) {
        this.f3700a.onActionModeFinished(actionMode);
    }

    @Override // android.view.Window.Callback
    public void onActionModeStarted(ActionMode actionMode) {
        this.f3700a.onActionModeStarted(actionMode);
    }

    @Override // android.view.Window.Callback
    public void onAttachedToWindow() {
        this.f3700a.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public void onContentChanged() {
        this.f3700a.onContentChanged();
    }

    @Override // android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        return this.f3700a.onCreatePanelMenu(i, menu);
    }

    @Override // android.view.Window.Callback
    public View onCreatePanelView(int i) {
        return this.f3700a.onCreatePanelView(i);
    }

    @Override // android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.f3700a.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return this.f3700a.onMenuItemSelected(i, menuItem);
    }

    @Override // android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        return this.f3700a.onMenuOpened(i, menu);
    }

    @Override // android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        this.f3700a.onPanelClosed(i, menu);
    }

    @Override // android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        return this.f3700a.onPreparePanel(i, view, menu);
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested() {
        return this.f3700a.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    @SuppressLint({"NewApi"})
    public boolean onSearchRequested(SearchEvent searchEvent) {
        return this.f3700a.onSearchRequested(searchEvent);
    }

    @Override // android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.f3700a.onWindowAttributesChanged(layoutParams);
    }

    @Override // android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        this.f3700a.onWindowFocusChanged(z);
    }

    @Override // android.view.Window.Callback
    @SuppressLint({"NewApi"})
    public void onPointerCaptureChanged(boolean z) {
        this.f3700a.onPointerCaptureChanged(z);
    }

    @Override // android.view.Window.Callback
    @SuppressLint({"NewApi"})
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
        this.f3700a.onProvideKeyboardShortcuts(list, menu, i);
    }

    @Override // android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.f3700a.onWindowStartingActionMode(callback);
    }

    @Override // android.view.Window.Callback
    @SuppressLint({"NewApi"})
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        return this.f3700a.onWindowStartingActionMode(callback, i);
    }
}
