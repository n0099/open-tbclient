package com.baidu.adp.plugin.pluginBase;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
/* loaded from: classes.dex */
public class c extends i implements ComponentCallbacks, KeyEvent.Callback, LayoutInflater.Factory, View.OnCreateContextMenuListener {
    public static final int DEFAULT_KEYS_DIALER = 1;
    public static final int DEFAULT_KEYS_DISABLE = 0;
    public static final int DEFAULT_KEYS_SEARCH_GLOBAL = 4;
    public static final int DEFAULT_KEYS_SEARCH_LOCAL = 3;
    public static final int DEFAULT_KEYS_SHORTCUT = 2;
    public static final int RESULT_CANCELED = 0;
    public static final int RESULT_FIRST_USER = 1;
    public static final int RESULT_OK = -1;
    private boolean bOnCreateCalled;
    private Activity mActivity;
    private com.baidu.adp.plugin.a.a mProxyActivity;

    public c() {
        super(null);
        this.mActivity = null;
        this.mProxyActivity = null;
        this.bOnCreateCalled = false;
    }

    public Activity getActivity() {
        return this.mActivity;
    }

    public void setActivityProxy(com.baidu.adp.plugin.a.a aVar) {
        this.mActivity = aVar.getActivity();
        this.mProxyActivity = aVar;
    }

    public final Context getParentEntity() {
        Activity parent = this.mActivity.getParent();
        if (parent == null || !(parent instanceof com.baidu.adp.plugin.a.a)) {
            return null;
        }
        return ((com.baidu.adp.plugin.a.a) parent).kF();
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.mProxyActivity.a(view, layoutParams);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i) {
        return this.mProxyActivity.proxyBindService(intent, serviceConnection, i);
    }

    public void closeContextMenu() {
        this.mProxyActivity.kG();
    }

    public void closeOptionsMenu() {
        this.mProxyActivity.kH();
    }

    public PendingIntent createPendingResult(int i, Intent intent, int i2) {
        return this.mProxyActivity.a(i, intent, i2);
    }

    public final void dismissDialog(int i) {
        this.mActivity.dismissDialog(i);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.mProxyActivity.b(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.mProxyActivity.a(accessibilityEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.mProxyActivity.b(motionEvent);
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.mProxyActivity.c(motionEvent);
    }

    public View findViewById(int i) {
        return this.mProxyActivity.an(i);
    }

    public void finish() {
        this.mProxyActivity.kI();
    }

    public void finishActivity(int i) {
        this.mProxyActivity.ao(i);
    }

    public void finishActivityFromChild(Activity activity, int i) {
        this.mProxyActivity.a(activity, i);
    }

    public void finishFromChild(Activity activity) {
        this.mProxyActivity.m(activity);
    }

    public final Application getApplication() {
        return PluginCenter.getInstance().getPlugin(getPluginPackageName()).getApplication();
    }

    public ComponentName getCallingActivity() {
        return this.mProxyActivity.kK();
    }

    public String getCallingPackage() {
        return this.mProxyActivity.kL();
    }

    public int getChangingConfigurations() {
        return this.mProxyActivity.kM();
    }

    public ComponentName getComponentName() {
        return this.mActivity.getComponentName();
    }

    public View getCurrentFocus() {
        return this.mProxyActivity.kN();
    }

    public Intent getIntent() {
        return this.mProxyActivity.kO();
    }

    public LayoutInflater getLayoutInflater() {
        return this.mProxyActivity.kP();
    }

    public String getLocalClassName() {
        return this.mProxyActivity.kQ();
    }

    public MenuInflater getMenuInflater() {
        return this.mProxyActivity.kR();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageCodePath() {
        return PluginCenter.getInstance().getPlugin(getPluginPackageName()).kp();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageName() {
        return this.mActivity.getPackageName();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public PackageManager getPackageManager() {
        return this.mProxyActivity.proxyGetPackageManager();
    }

    public final Activity getParent() {
        return this.mActivity.getParent();
    }

    public SharedPreferences getPreferences(int i) {
        return this.mProxyActivity.ap(i);
    }

    public int getRequestedOrientation() {
        return this.mProxyActivity.kS();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        return this.mProxyActivity.ba(str);
    }

    public int getTaskId() {
        return this.mProxyActivity.kT();
    }

    public final CharSequence getTitle() {
        return this.mActivity.getTitle();
    }

    public final int getTitleColor() {
        return this.mActivity.getTitleColor();
    }

    public final int getVolumeControlStream() {
        return this.mActivity.getVolumeControlStream();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int getWallpaperDesiredMinimumHeight() {
        return this.mProxyActivity.kU();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int getWallpaperDesiredMinimumWidth() {
        return this.mProxyActivity.kV();
    }

    public Window getWindow() {
        return this.mProxyActivity.kW();
    }

    public WindowManager getWindowManager() {
        return this.mProxyActivity.kX();
    }

    public boolean hasWindowFocus() {
        return this.mProxyActivity.kY();
    }

    public final boolean isChild() {
        return this.mActivity.isChild();
    }

    public boolean isFinishing() {
        return this.mProxyActivity.kZ();
    }

    public boolean isTaskRoot() {
        return this.mProxyActivity.la();
    }

    @Deprecated
    public final Cursor managedQuery(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return this.mActivity.managedQuery(uri, strArr, str, strArr2, str2);
    }

    public boolean moveTaskToBack(boolean z) {
        return this.mProxyActivity.H(z);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.mProxyActivity.a(i, i2, intent);
    }

    protected void onApplyThemeResource(Resources.Theme theme, int i, boolean z) {
        this.mProxyActivity.a(theme, i, z);
    }

    public void onAttachedToWindow() {
        this.mProxyActivity.lb();
    }

    public void onBackPressed() {
        this.mProxyActivity.lc();
    }

    protected void onChildTitleChanged(Activity activity, CharSequence charSequence) {
        this.mProxyActivity.a(activity, charSequence);
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.mProxyActivity.proxyOnConfigurationChanged(configuration);
    }

    public void onContentChanged() {
        this.mProxyActivity.ld();
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return this.mProxyActivity.a(menuItem);
    }

    public void onContextMenuClosed(Menu menu) {
        this.mProxyActivity.a(menu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        this.bOnCreateCalled = true;
        this.mProxyActivity.b(bundle);
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.mProxyActivity.a(contextMenu, view, contextMenuInfo);
    }

    public CharSequence onCreateDescription() {
        return null;
    }

    protected Dialog onCreateDialog(int i) {
        return null;
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        return this.mProxyActivity.a(i, menu);
    }

    public View onCreatePanelView(int i) {
        return null;
    }

    public boolean onCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        return this.mProxyActivity.b(bitmap, canvas);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
        this.mProxyActivity.proxyOnDestroy();
    }

    public void onDetachedFromWindow() {
        this.mProxyActivity.le();
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.mProxyActivity.a(i, keyEvent);
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        return this.mProxyActivity.b(i, keyEvent);
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return this.mProxyActivity.a(i, i2, keyEvent);
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.mProxyActivity.c(i, keyEvent);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mProxyActivity.proxyOnLowMemory();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return this.mProxyActivity.a(i, menuItem);
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return this.mProxyActivity.b(i, menu);
    }

    protected void onNewIntent(Intent intent) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return this.mProxyActivity.b(menuItem);
    }

    public void onOptionsMenuClosed(Menu menu) {
        this.mProxyActivity.b(menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        this.mProxyActivity.c(i, menu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPause() {
        this.mProxyActivity.lf();
    }

    protected void onPostCreate(Bundle bundle) {
        this.mProxyActivity.c(bundle);
    }

    protected void onPostResume() {
        this.mProxyActivity.lg();
    }

    public void onPrepareDialog(int i, Dialog dialog) {
        this.mProxyActivity.a(i, dialog);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        return this.mProxyActivity.c(menu);
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        return this.mProxyActivity.a(i, view, menu);
    }

    public void onRestart() {
        this.mProxyActivity.lh();
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        this.mProxyActivity.d(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onResume() {
        this.mProxyActivity.li();
    }

    public Object onRetainNonConfigurationInstance() {
        return this.mProxyActivity.lj();
    }

    protected void onSaveInstanceState(Bundle bundle) {
        this.mProxyActivity.e(bundle);
    }

    public boolean onSearchRequested() {
        return this.mProxyActivity.lk();
    }

    protected void onStart() {
        this.mProxyActivity.ll();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStop() {
        this.mProxyActivity.lm();
    }

    protected void onTitleChanged(CharSequence charSequence, int i) {
        this.mProxyActivity.b(charSequence, i);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mProxyActivity.d(motionEvent);
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        return this.mProxyActivity.e(motionEvent);
    }

    public void onUserInteraction() {
        this.mProxyActivity.ln();
    }

    protected void onUserLeaveHint() {
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.mProxyActivity.a(layoutParams);
    }

    public void onWindowFocusChanged(boolean z) {
        this.mProxyActivity.I(z);
    }

    public void openContextMenu(View view) {
        this.mProxyActivity.proxyOpenContextMenu(view);
    }

    public void openOptionsMenu() {
        this.mProxyActivity.lo();
    }

    public void overridePendingTransition(int i, int i2) {
        this.mProxyActivity.e(i, i2);
    }

    public void registerForContextMenu(View view) {
        this.mProxyActivity.proxyRegisterForContextMenu(view);
    }

    public final void removeDialog(int i) {
        this.mActivity.removeDialog(i);
    }

    public final boolean requestWindowFeature(int i) {
        return this.mActivity.requestWindowFeature(i);
    }

    public final void runOnUiThread(Runnable runnable) {
        this.mActivity.runOnUiThread(runnable);
    }

    public void setContentView(int i) {
        this.mProxyActivity.aq(i);
    }

    public void setContentView(View view) {
        this.mProxyActivity.proxySetContentView(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.mProxyActivity.b(view, layoutParams);
    }

    public final void setDefaultKeyMode(int i) {
        this.mActivity.setDefaultKeyMode(i);
    }

    public final void setFeatureDrawable(int i, Drawable drawable) {
        this.mActivity.setFeatureDrawable(i, drawable);
    }

    public final void setFeatureDrawableAlpha(int i, int i2) {
        this.mActivity.setFeatureDrawableAlpha(i, i2);
    }

    public final void setFeatureDrawableResource(int i, int i2) {
        this.mActivity.setFeatureDrawableResource(i, i2);
    }

    public final void setFeatureDrawableUri(int i, Uri uri) {
        this.mActivity.setFeatureDrawableUri(i, uri);
    }

    public void setIntent(Intent intent) {
        this.mProxyActivity.E(intent);
    }

    public final void setProgress(int i) {
        this.mActivity.setProgress(i);
    }

    public final void setProgressBarIndeterminate(boolean z) {
        this.mActivity.setProgressBarIndeterminate(z);
    }

    public final void setProgressBarIndeterminateVisibility(boolean z) {
        this.mActivity.setProgressBarIndeterminateVisibility(z);
    }

    public final void setProgressBarVisibility(boolean z) {
        this.mActivity.setProgressBarVisibility(z);
    }

    public void setRequestedOrientation(int i) {
        this.mProxyActivity.ar(i);
    }

    public final void setResult(int i) {
        this.mActivity.setResult(i);
    }

    public final void setResult(int i, Intent intent) {
        this.mActivity.setResult(i, intent);
    }

    public final void setSecondaryProgress(int i) {
        this.mActivity.setSecondaryProgress(i);
    }

    public void setTitle(int i) {
        this.mProxyActivity.as(i);
    }

    public void setTitle(CharSequence charSequence) {
        this.mProxyActivity.b(charSequence);
    }

    public void setTitleColor(int i) {
        this.mProxyActivity.at(i);
    }

    public void setVisible(boolean z) {
        this.mProxyActivity.J(z);
    }

    public final void setVolumeControlStream(int i) {
        this.mActivity.setVolumeControlStream(i);
    }

    public final void showDialog(int i) {
        this.mActivity.showDialog(i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        com.baidu.adp.plugin.a plugin2;
        String pluginPackageName = getPluginPackageName();
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mo().findPluginSetting(pluginPackageName);
        if (findPluginSetting == null || !findPluginSetting.isThird || ((plugin2 = PluginCenter.getInstance().getPlugin(pluginPackageName)) != null && plugin2.D(intent))) {
            this.mProxyActivity.proxyStartActivity(intent);
        }
    }

    public void startActivityForResult(Intent intent, int i) {
        com.baidu.adp.plugin.a plugin2;
        String pluginPackageName = getPluginPackageName();
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mo().findPluginSetting(pluginPackageName);
        if (findPluginSetting == null || !findPluginSetting.isThird || ((plugin2 = PluginCenter.getInstance().getPlugin(pluginPackageName)) != null && plugin2.D(intent))) {
            this.mProxyActivity.b(intent, i);
        }
    }

    public void startActivityFromChild(Activity activity, Intent intent, int i) {
        this.mProxyActivity.a(activity, intent, i);
    }

    public boolean startActivityIfNeeded(Intent intent, int i) {
        return this.mProxyActivity.c(intent, i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i, int i2, int i3) {
        this.mProxyActivity.a(intentSender, intent, i, i2, i3);
    }

    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        this.mProxyActivity.a(intentSender, i, intent, i2, i3, i4);
    }

    public void startManagingCursor(Cursor cursor) {
        this.mProxyActivity.c(cursor);
    }

    public boolean startNextMatchingActivity(Intent intent) {
        return this.mProxyActivity.F(intent);
    }

    public void startSearch(String str, boolean z, Bundle bundle, boolean z2) {
        this.mProxyActivity.a(str, z, bundle, z2);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ComponentName startService(Intent intent) {
        com.baidu.adp.plugin.a plugin2;
        String pluginPackageName = getPluginPackageName();
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mo().findPluginSetting(pluginPackageName);
        if (findPluginSetting == null || !findPluginSetting.isThird || ((plugin2 = PluginCenter.getInstance().getPlugin(pluginPackageName)) != null && plugin2.C(intent))) {
            return this.mProxyActivity.proxyStartService(intent);
        }
        return null;
    }

    public void stopManagingCursor(Cursor cursor) {
        this.mProxyActivity.d(cursor);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean stopService(Intent intent) {
        return this.mProxyActivity.proxyStopService(intent);
    }

    public void takeKeyEvents(boolean z) {
        this.mProxyActivity.K(z);
    }

    public void unregisterForContextMenu(View view) {
        this.mProxyActivity.proxyUnregisterForContextMenu(view);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        return this.mProxyActivity.registerReceiver(broadcastReceiver, intentFilter);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        this.mProxyActivity.unregisterReceiver(broadcastReceiver);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return false;
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i) {
        return this.mProxyActivity.proxyGetSharedPreferences(str, i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileInputStream openFileInput(String str) {
        return this.mActivity.openFileInput(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileOutputStream openFileOutput(String str, int i) {
        return this.mActivity.openFileOutput(str, i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory) {
        return this.mActivity.openOrCreateDatabase(str, i, cursorFactory);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getFileStreamPath(String str) {
        return this.mActivity.getFileStreamPath(str);
    }

    @Override // com.baidu.adp.plugin.pluginBase.i, android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return (this.bOnCreateCalled || c.class.getName().equals(getClass().getName())) ? super.getApplicationContext() : this.mProxyActivity.kJ();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent) {
        super.sendBroadcast(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent, String str) {
        super.sendBroadcast(intent, str);
    }
}
