package com.baidu.mobads;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
/* loaded from: classes10.dex */
public class AppActivity extends Activity {
    public static String activityName = null;
    private static ActionBarColorTheme bkO = ActionBarColorTheme.ACTION_BAR_WHITE_THEME;
    private AppActivityImp bkN = new AppActivityImp();

    public static void setActivityName(String str) {
        activityName = str;
    }

    public static boolean isAnti() {
        return !TextUtils.isEmpty(activityName);
    }

    public static Class<?> getActivityClass() {
        if (TextUtils.isEmpty(activityName)) {
            return AppActivity.class;
        }
        try {
            return Class.forName(activityName);
        } catch (Exception e) {
            com.baidu.mobads.utils.m.a().e(e);
            return AppActivity.class;
        }
    }

    /* loaded from: classes10.dex */
    public static class ActionBarColorTheme {
        private int a;
        private int b;
        private int c;
        private int d;
        public static final ActionBarColorTheme ACTION_BAR_WHITE_THEME = new ActionBarColorTheme(-5987164, -6842473, -11113262, -328966);
        public static final ActionBarColorTheme ACTION_BAR_RED_THEME = new ActionBarColorTheme(-1, -1, -12510, -1294276);
        public static final ActionBarColorTheme ACTION_BAR_GREEN_THEME = new ActionBarColorTheme(-1, -1, -11113262, -14303071);
        public static final ActionBarColorTheme ACTION_BAR_NAVYBLUE_THEME = new ActionBarColorTheme(-1, -1, 16764706, -14210226);
        public static final ActionBarColorTheme ACTION_BAR_BLUE_THEME = new ActionBarColorTheme(-1, -1, -12510, -13870424);
        public static final ActionBarColorTheme ACTION_BAR_COFFEE_THEME = new ActionBarColorTheme(-1, -1, -12510, -11255230);
        public static final ActionBarColorTheme ACTION_BAR_BLACK_THEME = new ActionBarColorTheme(-1, -1, -12510, -13749450);

        public ActionBarColorTheme(int i, int i2, int i3, int i4) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }

        public ActionBarColorTheme(ActionBarColorTheme actionBarColorTheme) {
            this.a = actionBarColorTheme.a;
            this.b = actionBarColorTheme.b;
            this.c = actionBarColorTheme.c;
            this.d = actionBarColorTheme.d;
        }

        public int getCloseColor() {
            return this.a;
        }

        public void setCloseColor(int i) {
            this.a = i;
        }

        public int getTitleColor() {
            return this.b;
        }

        public void setTitleColor(int i) {
            this.b = i;
        }

        public int getProgressColor() {
            return this.c;
        }

        public void setProgressColor(int i) {
            this.c = i;
        }

        public int getBackgroundColor() {
            return this.d;
        }

        public void setBackgroundColor(int i) {
            this.d = i;
        }

        public boolean equals(Object obj) {
            ActionBarColorTheme actionBarColorTheme = (ActionBarColorTheme) obj;
            return this.d == actionBarColorTheme.d && this.b == actionBarColorTheme.b && this.a == actionBarColorTheme.a && this.c == actionBarColorTheme.c;
        }
    }

    public static ActionBarColorTheme getActionBarColorTheme() {
        return bkO;
    }

    public static void setActionBarColorTheme(ActionBarColorTheme actionBarColorTheme) {
        if (actionBarColorTheme != null) {
            bkO = new ActionBarColorTheme(actionBarColorTheme);
        }
    }

    public static void canLpShowWhenLocked(boolean z) {
        AppActivityImp.canLpShowWhenLocked(z);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (this.bkN.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.bkN.dispatchTouchEvent(motionEvent)) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        if (this.bkN.dispatchTrackballEvent(motionEvent)) {
            return true;
        }
        return super.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        this.bkN.onActivityResult(i, i2, intent);
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper
    protected void onApplyThemeResource(Resources.Theme theme, int i, boolean z) {
        this.bkN.onApplyThemeResource(theme, i, z);
        super.onApplyThemeResource(theme, i, z);
    }

    @Override // android.app.Activity
    protected void onChildTitleChanged(Activity activity, CharSequence charSequence) {
        this.bkN.onChildTitleChanged(activity, charSequence);
        super.onChildTitleChanged(activity, charSequence);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.bkN.onConfigurationChanged(configuration);
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        this.bkN.onContentChanged();
        super.onContentChanged();
    }

    @Override // android.app.Activity
    public boolean onContextItemSelected(MenuItem menuItem) {
        if (this.bkN.onContextItemSelected(menuItem)) {
            return true;
        }
        return super.onContextItemSelected(menuItem);
    }

    @Override // android.app.Activity
    public void onContextMenuClosed(Menu menu) {
        this.bkN.onContextMenuClosed(menu);
        super.onContextMenuClosed(menu);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.bkN.setActivity(this);
            this.bkN.invokeRemoteStatic("setActionBarColor", Integer.valueOf(bkO.a), Integer.valueOf(bkO.b), Integer.valueOf(bkO.c), Integer.valueOf(bkO.d));
            this.bkN.onCreate(bundle);
        } catch (Exception e) {
            com.baidu.mobads.utils.m.a().e(e);
        }
    }

    @Override // android.app.Activity, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        this.bkN.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.app.Activity
    public CharSequence onCreateDescription() {
        CharSequence onCreateDescription = this.bkN.onCreateDescription();
        return onCreateDescription != null ? onCreateDescription : super.onCreateDescription();
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        Dialog onCreateDialog = this.bkN.onCreateDialog(i);
        return onCreateDialog != null ? onCreateDialog : super.onCreateDialog(i);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.bkN.onCreateOptionsMenu(menu)) {
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (this.bkN.onCreatePanelMenu(i, menu)) {
            return true;
        }
        return super.onCreatePanelMenu(i, menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public View onCreatePanelView(int i) {
        View onCreatePanelView = this.bkN.onCreatePanelView(i);
        return onCreatePanelView != null ? onCreatePanelView : super.onCreatePanelView(i);
    }

    @Override // android.app.Activity
    public boolean onCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        if (this.bkN.onCreateThumbnail(bitmap, canvas)) {
            return true;
        }
        return super.onCreateThumbnail(bitmap, canvas);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View onCreateView = this.bkN.onCreateView(str, context, attributeSet);
        return onCreateView != null ? onCreateView : super.onCreateView(str, context, attributeSet);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        this.bkN.onDestroy();
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.bkN.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        if (this.bkN.onKeyMultiple(i, i2, keyEvent)) {
            return true;
        }
        return super.onKeyMultiple(i, i2, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.bkN.onKeyUp(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        this.bkN.onLowMemory();
        super.onLowMemory();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (this.bkN.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        return super.onMenuItemSelected(i, menuItem);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        if (this.bkN.onMenuOpened(i, menu)) {
            return true;
        }
        return super.onMenuOpened(i, menu);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        this.bkN.onNewIntent(intent);
        super.onNewIntent(intent);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (this.bkN.onOptionsItemSelected(menuItem)) {
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.app.Activity
    public void onOptionsMenuClosed(Menu menu) {
        this.bkN.onOptionsMenuClosed(menu);
        super.onOptionsMenuClosed(menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        this.bkN.onPanelClosed(i, menu);
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    protected void onPause() {
        this.bkN.onPause();
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.bkN.onPostCreate(bundle);
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        this.bkN.onPostResume();
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
        super.onPrepareDialog(i, dialog);
        this.bkN.onPrepareDialog(i, dialog);
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (this.bkN.onPrepareOptionsMenu(menu)) {
            return true;
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (this.bkN.onPreparePanel(i, view, menu)) {
            return true;
        }
        return super.onPreparePanel(i, view, menu);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        this.bkN.onRestart();
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.bkN.onRestoreInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.bkN.onResume();
    }

    @Override // android.app.Activity
    public Object onRetainNonConfigurationInstance() {
        Object onRetainNonConfigurationInstance = this.bkN.onRetainNonConfigurationInstance();
        return onRetainNonConfigurationInstance != null ? onRetainNonConfigurationInstance : super.onRetainNonConfigurationInstance();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.bkN.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        if (this.bkN.onSearchRequested()) {
            return true;
        }
        return super.onSearchRequested();
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.bkN.onStart();
    }

    @Override // android.app.Activity
    protected void onStop() {
        this.bkN.onStop();
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        this.bkN.onTitleChanged(charSequence, i);
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bkN.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (this.bkN.onTrackballEvent(motionEvent)) {
            return true;
        }
        return super.onTrackballEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void onUserInteraction() {
        super.onUserInteraction();
        this.bkN.onUserInteraction();
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        this.bkN.onUserLeaveHint();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        super.onWindowAttributesChanged(layoutParams);
        this.bkN.onWindowAttributesChanged(layoutParams);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.bkN.onWindowFocusChanged(z);
    }
}
