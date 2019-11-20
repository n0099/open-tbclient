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
/* loaded from: classes5.dex */
public class AppActivity extends Activity {
    public static String azQ = null;
    private static a azS = a.azT;
    private b azR = new b();

    public static boolean zq() {
        return !TextUtils.isEmpty(azQ);
    }

    public static Class<?> zr() {
        if (TextUtils.isEmpty(azQ)) {
            return AppActivity.class;
        }
        try {
            return Class.forName(azQ);
        } catch (Exception e) {
            com.baidu.mobads.utils.m.a().e(e);
            return AppActivity.class;
        }
    }

    /* loaded from: classes5.dex */
    public static class a {
        public static final a azT = new a(-5987164, -6842473, -11113262, -328966);
        public static final a azU = new a(-1, -1, -12510, -1294276);
        public static final a azV = new a(-1, -1, -11113262, -14303071);
        public static final a azW = new a(-1, -1, 16764706, -14210226);
        public static final a azX = new a(-1, -1, -12510, -13870424);
        public static final a azY = new a(-1, -1, -12510, -11255230);
        public static final a azZ = new a(-1, -1, -12510, -13749450);
        private int a;
        private int b;
        private int c;
        private int d;

        public a(int i, int i2, int i3, int i4) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }

        public boolean equals(Object obj) {
            a aVar = (a) obj;
            return this.d == aVar.d && this.b == aVar.b && this.a == aVar.a && this.c == aVar.c;
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (this.azR.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.azR.dispatchTouchEvent(motionEvent)) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        if (this.azR.dispatchTrackballEvent(motionEvent)) {
            return true;
        }
        return super.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        this.azR.onActivityResult(i, i2, intent);
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper
    protected void onApplyThemeResource(Resources.Theme theme, int i, boolean z) {
        this.azR.onApplyThemeResource(theme, i, z);
        super.onApplyThemeResource(theme, i, z);
    }

    @Override // android.app.Activity
    protected void onChildTitleChanged(Activity activity, CharSequence charSequence) {
        this.azR.onChildTitleChanged(activity, charSequence);
        super.onChildTitleChanged(activity, charSequence);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.azR.onConfigurationChanged(configuration);
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        this.azR.onContentChanged();
        super.onContentChanged();
    }

    @Override // android.app.Activity
    public boolean onContextItemSelected(MenuItem menuItem) {
        if (this.azR.onContextItemSelected(menuItem)) {
            return true;
        }
        return super.onContextItemSelected(menuItem);
    }

    @Override // android.app.Activity
    public void onContextMenuClosed(Menu menu) {
        this.azR.onContextMenuClosed(menu);
        super.onContextMenuClosed(menu);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.azR.setActivity(this);
            this.azR.f("setActionBarColor", Integer.valueOf(azS.a), Integer.valueOf(azS.b), Integer.valueOf(azS.c), Integer.valueOf(azS.d));
            this.azR.onCreate(bundle);
        } catch (Exception e) {
            com.baidu.mobads.utils.m.a().e(e);
        }
    }

    @Override // android.app.Activity, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        this.azR.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.app.Activity
    public CharSequence onCreateDescription() {
        CharSequence onCreateDescription = this.azR.onCreateDescription();
        return onCreateDescription != null ? onCreateDescription : super.onCreateDescription();
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        Dialog onCreateDialog = this.azR.onCreateDialog(i);
        return onCreateDialog != null ? onCreateDialog : super.onCreateDialog(i);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.azR.onCreateOptionsMenu(menu)) {
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (this.azR.onCreatePanelMenu(i, menu)) {
            return true;
        }
        return super.onCreatePanelMenu(i, menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public View onCreatePanelView(int i) {
        View onCreatePanelView = this.azR.onCreatePanelView(i);
        return onCreatePanelView != null ? onCreatePanelView : super.onCreatePanelView(i);
    }

    @Override // android.app.Activity
    public boolean onCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        if (this.azR.onCreateThumbnail(bitmap, canvas)) {
            return true;
        }
        return super.onCreateThumbnail(bitmap, canvas);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View onCreateView = this.azR.onCreateView(str, context, attributeSet);
        return onCreateView != null ? onCreateView : super.onCreateView(str, context, attributeSet);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        this.azR.onDestroy();
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.azR.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        if (this.azR.onKeyMultiple(i, i2, keyEvent)) {
            return true;
        }
        return super.onKeyMultiple(i, i2, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.azR.onKeyUp(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        this.azR.onLowMemory();
        super.onLowMemory();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (this.azR.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        return super.onMenuItemSelected(i, menuItem);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        if (this.azR.onMenuOpened(i, menu)) {
            return true;
        }
        return super.onMenuOpened(i, menu);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        this.azR.onNewIntent(intent);
        super.onNewIntent(intent);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (this.azR.onOptionsItemSelected(menuItem)) {
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.app.Activity
    public void onOptionsMenuClosed(Menu menu) {
        this.azR.onOptionsMenuClosed(menu);
        super.onOptionsMenuClosed(menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        this.azR.onPanelClosed(i, menu);
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    protected void onPause() {
        this.azR.onPause();
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.azR.onPostCreate(bundle);
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        this.azR.onPostResume();
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
        super.onPrepareDialog(i, dialog);
        this.azR.onPrepareDialog(i, dialog);
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (this.azR.onPrepareOptionsMenu(menu)) {
            return true;
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (this.azR.onPreparePanel(i, view, menu)) {
            return true;
        }
        return super.onPreparePanel(i, view, menu);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        this.azR.onRestart();
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.azR.onRestoreInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.azR.onResume();
    }

    @Override // android.app.Activity
    public Object onRetainNonConfigurationInstance() {
        Object onRetainNonConfigurationInstance = this.azR.onRetainNonConfigurationInstance();
        return onRetainNonConfigurationInstance != null ? onRetainNonConfigurationInstance : super.onRetainNonConfigurationInstance();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.azR.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        if (this.azR.onSearchRequested()) {
            return true;
        }
        return super.onSearchRequested();
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.azR.onStart();
    }

    @Override // android.app.Activity
    protected void onStop() {
        this.azR.onStop();
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        this.azR.onTitleChanged(charSequence, i);
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.azR.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (this.azR.onTrackballEvent(motionEvent)) {
            return true;
        }
        return super.onTrackballEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void onUserInteraction() {
        super.onUserInteraction();
        this.azR.onUserInteraction();
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        this.azR.onUserLeaveHint();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        super.onWindowAttributesChanged(layoutParams);
        this.azR.onWindowAttributesChanged(layoutParams);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.azR.onWindowFocusChanged(z);
    }
}
