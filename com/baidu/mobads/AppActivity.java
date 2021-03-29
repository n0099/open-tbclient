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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class AppActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f8106a;
    public static String activityName;

    /* renamed from: c  reason: collision with root package name */
    public static ActionBarColorTheme f8107c = ActionBarColorTheme.ACTION_BAR_WHITE_THEME;

    /* renamed from: b  reason: collision with root package name */
    public AppActivityImp f8108b = new AppActivityImp();

    public static void canLpShowWhenLocked(boolean z) {
        f8106a = z;
        AppActivityImp.canLpShowWhenLocked(z);
    }

    public static ActionBarColorTheme getActionBarColorTheme() {
        return f8107c;
    }

    public static Class<?> getActivityClass() {
        if (TextUtils.isEmpty(activityName)) {
            return AppActivity.class;
        }
        try {
            return Class.forName(activityName);
        } catch (Exception e2) {
            com.baidu.mobads.utils.q.a().e(e2);
            return AppActivity.class;
        }
    }

    public static boolean getLpShowWhenLocked() {
        return f8106a;
    }

    public static boolean isAnti() {
        return !TextUtils.isEmpty(activityName);
    }

    public static void setActionBarColor(int i, int i2, int i3, int i4) {
        f8107c = new ActionBarColorTheme(i, i2, i3, i4);
    }

    public static void setActionBarColorTheme(ActionBarColorTheme actionBarColorTheme) {
        if (actionBarColorTheme != null) {
            f8107c = new ActionBarColorTheme(actionBarColorTheme);
        }
    }

    public static void setActivityName(String str) {
        activityName = str;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (this.f8108b.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f8108b.dispatchTouchEvent(motionEvent)) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        if (this.f8108b.dispatchTrackballEvent(motionEvent)) {
            return true;
        }
        return super.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        this.f8108b.onActivityResult(i, i2, intent);
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper
    public void onApplyThemeResource(Resources.Theme theme, int i, boolean z) {
        this.f8108b.onApplyThemeResource(theme, i, z);
        super.onApplyThemeResource(theme, i, z);
    }

    @Override // android.app.Activity
    public void onChildTitleChanged(Activity activity, CharSequence charSequence) {
        this.f8108b.onChildTitleChanged(activity, charSequence);
        super.onChildTitleChanged(activity, charSequence);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.f8108b.onConfigurationChanged(configuration);
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        this.f8108b.onContentChanged();
        super.onContentChanged();
    }

    @Override // android.app.Activity
    public boolean onContextItemSelected(MenuItem menuItem) {
        if (this.f8108b.onContextItemSelected(menuItem)) {
            return true;
        }
        return super.onContextItemSelected(menuItem);
    }

    @Override // android.app.Activity
    public void onContextMenuClosed(Menu menu) {
        this.f8108b.onContextMenuClosed(menu);
        super.onContextMenuClosed(menu);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        try {
            this.f8108b.setActivity(this);
            if (intent != null) {
                this.f8108b.onCreate(bundle);
            }
        } catch (Exception e2) {
            com.baidu.mobads.utils.q.a().e(e2);
        }
    }

    @Override // android.app.Activity, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        this.f8108b.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.app.Activity
    public CharSequence onCreateDescription() {
        CharSequence onCreateDescription = this.f8108b.onCreateDescription();
        return onCreateDescription != null ? onCreateDescription : super.onCreateDescription();
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i) {
        Dialog onCreateDialog = this.f8108b.onCreateDialog(i);
        return onCreateDialog != null ? onCreateDialog : super.onCreateDialog(i);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.f8108b.onCreateOptionsMenu(menu)) {
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (this.f8108b.onCreatePanelMenu(i, menu)) {
            return true;
        }
        return super.onCreatePanelMenu(i, menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public View onCreatePanelView(int i) {
        View onCreatePanelView = this.f8108b.onCreatePanelView(i);
        return onCreatePanelView != null ? onCreatePanelView : super.onCreatePanelView(i);
    }

    @Override // android.app.Activity
    public boolean onCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        if (this.f8108b.onCreateThumbnail(bitmap, canvas)) {
            return true;
        }
        return super.onCreateThumbnail(bitmap, canvas);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View onCreateView = this.f8108b.onCreateView(str, context, attributeSet);
        return onCreateView != null ? onCreateView : super.onCreateView(str, context, attributeSet);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        this.f8108b.onDestroy();
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f8108b.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        if (this.f8108b.onKeyMultiple(i, i2, keyEvent)) {
            return true;
        }
        return super.onKeyMultiple(i, i2, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.f8108b.onKeyUp(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        this.f8108b.onLowMemory();
        super.onLowMemory();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (this.f8108b.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        return super.onMenuItemSelected(i, menuItem);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        if (this.f8108b.onMenuOpened(i, menu)) {
            return true;
        }
        return super.onMenuOpened(i, menu);
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        this.f8108b.onNewIntent(intent);
        super.onNewIntent(intent);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (this.f8108b.onOptionsItemSelected(menuItem)) {
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.app.Activity
    public void onOptionsMenuClosed(Menu menu) {
        this.f8108b.onOptionsMenuClosed(menu);
        super.onOptionsMenuClosed(menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        this.f8108b.onPanelClosed(i, menu);
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    public void onPause() {
        this.f8108b.onPause();
        super.onPause();
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.f8108b.onPostCreate(bundle);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        this.f8108b.onPostResume();
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int i, Dialog dialog) {
        super.onPrepareDialog(i, dialog);
        this.f8108b.onPrepareDialog(i, dialog);
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (this.f8108b.onPrepareOptionsMenu(menu)) {
            return true;
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (this.f8108b.onPreparePanel(i, view, menu)) {
            return true;
        }
        return super.onPreparePanel(i, view, menu);
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        this.f8108b.onRestart();
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.f8108b.onRestoreInstanceState(bundle);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.f8108b.onResume();
    }

    @Override // android.app.Activity
    public Object onRetainNonConfigurationInstance() {
        Object onRetainNonConfigurationInstance = this.f8108b.onRetainNonConfigurationInstance();
        return onRetainNonConfigurationInstance != null ? onRetainNonConfigurationInstance : super.onRetainNonConfigurationInstance();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f8108b.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        if (this.f8108b.onSearchRequested()) {
            return true;
        }
        return super.onSearchRequested();
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        this.f8108b.onStart();
    }

    @Override // android.app.Activity
    public void onStop() {
        this.f8108b.onStop();
        super.onStop();
    }

    @Override // android.app.Activity
    public void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        this.f8108b.onTitleChanged(charSequence, i);
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f8108b.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (this.f8108b.onTrackballEvent(motionEvent)) {
            return true;
        }
        return super.onTrackballEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void onUserInteraction() {
        super.onUserInteraction();
        this.f8108b.onUserInteraction();
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        super.onUserLeaveHint();
        this.f8108b.onUserLeaveHint();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        super.onWindowAttributesChanged(layoutParams);
        this.f8108b.onWindowAttributesChanged(layoutParams);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.f8108b.onWindowFocusChanged(z);
    }

    /* loaded from: classes2.dex */
    public static class ActionBarColorTheme implements Serializable {
        public int backgroundColor;
        public int closeColor;
        public int progressColor;
        public int titleColor;
        public static final ActionBarColorTheme ACTION_BAR_WHITE_THEME = new ActionBarColorTheme(-5987164, -6842473, -11113262, SwipeRefreshLayout.CIRCLE_BG_LIGHT);
        public static final ActionBarColorTheme ACTION_BAR_RED_THEME = new ActionBarColorTheme(-1, -1, -12510, -1294276);
        public static final ActionBarColorTheme ACTION_BAR_GREEN_THEME = new ActionBarColorTheme(-1, -1, -11113262, -14303071);
        public static final ActionBarColorTheme ACTION_BAR_NAVYBLUE_THEME = new ActionBarColorTheme(-1, -1, 16764706, -14210226);
        public static final ActionBarColorTheme ACTION_BAR_BLUE_THEME = new ActionBarColorTheme(-1, -1, -12510, -13870424);
        public static final ActionBarColorTheme ACTION_BAR_COFFEE_THEME = new ActionBarColorTheme(-1, -1, -12510, -11255230);
        public static final ActionBarColorTheme ACTION_BAR_BLACK_THEME = new ActionBarColorTheme(-1, -1, -12510, -13749450);

        public ActionBarColorTheme(int i, int i2, int i3, int i4) {
            this.closeColor = i;
            this.titleColor = i2;
            this.progressColor = i3;
            this.backgroundColor = i4;
        }

        public boolean equals(Object obj) {
            ActionBarColorTheme actionBarColorTheme = (ActionBarColorTheme) obj;
            return this.backgroundColor == actionBarColorTheme.backgroundColor && this.titleColor == actionBarColorTheme.titleColor && this.closeColor == actionBarColorTheme.closeColor && this.progressColor == actionBarColorTheme.progressColor;
        }

        public int getBackgroundColor() {
            return this.backgroundColor;
        }

        public int getCloseColor() {
            return this.closeColor;
        }

        public int getProgressColor() {
            return this.progressColor;
        }

        public int getTitleColor() {
            return this.titleColor;
        }

        public void setBackgroundColor(int i) {
            this.backgroundColor = i;
        }

        public void setCloseColor(int i) {
            this.closeColor = i;
        }

        public void setProgressColor(int i) {
            this.progressColor = i;
        }

        public void setTitleColor(int i) {
            this.titleColor = i;
        }

        public ActionBarColorTheme(ActionBarColorTheme actionBarColorTheme) {
            this.closeColor = actionBarColorTheme.closeColor;
            this.titleColor = actionBarColorTheme.titleColor;
            this.progressColor = actionBarColorTheme.progressColor;
            this.backgroundColor = actionBarColorTheme.backgroundColor;
        }
    }
}
