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
import android.os.Handler;
import android.os.Message;
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
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.g;
import com.baidu.adp.base.h;
import com.baidu.adp.base.j;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.c;
import com.baidu.adp.widget.ListView.w;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
/* loaded from: classes.dex */
public class PluginBaseActivity extends PluginContextWrapper implements ComponentCallbacks, Handler.Callback, KeyEvent.Callback, LayoutInflater.Factory, View.OnCreateContextMenuListener, h, j {
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

    public PluginBaseActivity() {
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
        return ((com.baidu.adp.plugin.a.a) parent).getTarget();
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.mProxyActivity.proxyAddContentView(view, layoutParams);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i) {
        Plugin plugin2;
        String pluginPackageName = getPluginPackageName();
        PluginSetting findPluginSetting = c.jY().findPluginSetting(pluginPackageName);
        if (findPluginSetting == null || !findPluginSetting.isThird || ((plugin2 = PluginCenter.getInstance().getPlugin(pluginPackageName)) != null && plugin2.remapStartServiceIntent(intent))) {
            return this.mProxyActivity.proxyBindService(intent, serviceConnection, i);
        }
        return false;
    }

    public void closeContextMenu() {
        this.mProxyActivity.proxyCloseContextMenu();
    }

    public void closeOptionsMenu() {
        this.mProxyActivity.proxyCloseOptionsMenu();
    }

    public PendingIntent createPendingResult(int i, Intent intent, int i2) {
        return this.mProxyActivity.proxyCreatePendingResult(i, intent, i2);
    }

    public final void dismissDialog(int i) {
        this.mActivity.dismissDialog(i);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.mProxyActivity.proxyDispatchKeyEvent(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.mProxyActivity.proxyDispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.mProxyActivity.proxyDispatchTouchEvent(motionEvent);
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.mProxyActivity.proxyDispatchTrackballEvent(motionEvent);
    }

    public View findViewById(int i) {
        return this.mProxyActivity.proxyFindViewById(i);
    }

    public void finish() {
        this.mProxyActivity.proxyFinish();
    }

    public void finishActivity(int i) {
        this.mProxyActivity.proxyFinishActivity(i);
    }

    public void finishActivityFromChild(Activity activity, int i) {
        this.mProxyActivity.proxyFinishActivityFromChild(activity, i);
    }

    public void finishFromChild(Activity activity) {
        this.mProxyActivity.proxyFinishFromChild(activity);
    }

    public final Application getApplication() {
        return PluginCenter.getInstance().getPlugin(getPluginPackageName()).getApplication();
    }

    public ComponentName getCallingActivity() {
        return this.mProxyActivity.proxyGetCallingActivity();
    }

    public String getCallingPackage() {
        return this.mProxyActivity.proxyGetCallingPackage();
    }

    public int getChangingConfigurations() {
        return this.mProxyActivity.proxyGetChangingConfigurations();
    }

    public ComponentName getComponentName() {
        return this.mActivity.getComponentName();
    }

    public View getCurrentFocus() {
        return this.mProxyActivity.proxyGetCurrentFocus();
    }

    public Intent getIntent() {
        return this.mProxyActivity.proxyGetIntent();
    }

    public LayoutInflater getLayoutInflater() {
        return this.mProxyActivity.proxyGetLayoutInflater();
    }

    public String getLocalClassName() {
        return this.mProxyActivity.proxyGetLocalClassName();
    }

    public MenuInflater getMenuInflater() {
        return this.mProxyActivity.proxyGetMenuInflater();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageCodePath() {
        return PluginCenter.getInstance().getPlugin(getPluginPackageName()).getPluginApkFilePath();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageName() {
        PluginSetting findPluginSetting = c.jY().findPluginSetting(getPluginPackageName());
        return (findPluginSetting == null || !findPluginSetting.isThird) ? this.mActivity.getPackageName() : getPluginPackageName();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public PackageManager getPackageManager() {
        return this.mProxyActivity.proxyGetPackageManager();
    }

    public final Activity getParent() {
        return this.mActivity.getParent();
    }

    public SharedPreferences getPreferences(int i) {
        return this.mProxyActivity.proxyGetPreferences(i);
    }

    public int getRequestedOrientation() {
        return this.mProxyActivity.proxyGetRequestedOrientation();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        return this.mProxyActivity.proxyGetSystemService(str);
    }

    public int getTaskId() {
        return this.mProxyActivity.proxyGetTaskId();
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
        return this.mProxyActivity.proxyGetWallpaperDesiredMinimumHeight();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int getWallpaperDesiredMinimumWidth() {
        return this.mProxyActivity.proxyGetWallpaperDesiredMinimumWidth();
    }

    public Window getWindow() {
        return this.mProxyActivity.proxyGetWindow();
    }

    public WindowManager getWindowManager() {
        return this.mProxyActivity.proxyGetWindowManager();
    }

    public boolean hasWindowFocus() {
        return this.mProxyActivity.proxyHasWindowFocus();
    }

    public final boolean isChild() {
        return this.mActivity.isChild();
    }

    public boolean isFinishing() {
        return this.mProxyActivity.proxyIsFinishing();
    }

    public boolean isTaskRoot() {
        return this.mProxyActivity.proxyIsTaskRoot();
    }

    @Deprecated
    public final Cursor managedQuery(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return this.mActivity.managedQuery(uri, strArr, str, strArr2, str2);
    }

    public boolean moveTaskToBack(boolean z) {
        return this.mProxyActivity.proxyMoveTaskToBack(z);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.mProxyActivity.proxyOnActivityResult(i, i2, intent);
    }

    protected void onApplyThemeResource(Resources.Theme theme, int i, boolean z) {
        this.mProxyActivity.proxyOnApplyThemeResource(theme, i, z);
    }

    public void onAttachedToWindow() {
        this.mProxyActivity.proxyOnAttachedToWindow();
    }

    public void onBackPressed() {
        this.mProxyActivity.proxyOnBackPressed();
    }

    protected void onChildTitleChanged(Activity activity, CharSequence charSequence) {
        this.mProxyActivity.proxyOnChildTitleChanged(activity, charSequence);
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.mProxyActivity.proxyOnConfigurationChanged(configuration);
    }

    public void onContentChanged() {
        this.mProxyActivity.proxyOnContentChanged();
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return this.mProxyActivity.proxyOnContextItemSelected(menuItem);
    }

    public void onContextMenuClosed(Menu menu) {
        this.mProxyActivity.proxyOnContextMenuClosed(menu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        this.bOnCreateCalled = true;
        this.mProxyActivity.proxyOnCreate(bundle);
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.mProxyActivity.proxyOnCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public CharSequence onCreateDescription() {
        return null;
    }

    protected Dialog onCreateDialog(int i) {
        return null;
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        return this.mProxyActivity.proxyOnCreatePanelMenu(i, menu);
    }

    public View onCreatePanelView(int i) {
        return null;
    }

    public boolean onCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        return this.mProxyActivity.proxyOnCreateThumbnail(bitmap, canvas);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return this.mProxyActivity.proxyOnCreateView(str, context, attributeSet);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mProxyActivity.proxyOnCreateView(view, str, context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
        this.mProxyActivity.proxyOnDestroy();
    }

    public void onDetachedFromWindow() {
        this.mProxyActivity.proxyOnDetachedFromWindow();
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.mProxyActivity.proxyOnKeyDown(i, keyEvent);
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        return this.mProxyActivity.proxyOnKeyLongPress(i, keyEvent);
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return this.mProxyActivity.proxyOnKeyMultiple(i, i2, keyEvent);
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.mProxyActivity.proxyOnKeyUp(i, keyEvent);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mProxyActivity.proxyOnLowMemory();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return this.mProxyActivity.proxyOnMenuItemSelected(i, menuItem);
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return this.mProxyActivity.proxyOnMenuOpened(i, menu);
    }

    protected void onNewIntent(Intent intent) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return this.mProxyActivity.proxyOnOptionsItemSelected(menuItem);
    }

    public void onOptionsMenuClosed(Menu menu) {
        this.mProxyActivity.proxyOnOptionsMenuClosed(menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        this.mProxyActivity.proxyOnPanelClosed(i, menu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPause() {
        this.mProxyActivity.proxyOnPause();
    }

    protected void onPostCreate(Bundle bundle) {
        this.mProxyActivity.proxyOnPostCreate(bundle);
    }

    protected void onPostResume() {
        this.mProxyActivity.proxyOnPostResume();
    }

    public void onPrepareDialog(int i, Dialog dialog) {
        this.mProxyActivity.proxyOnPrepareDialog(i, dialog);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        return this.mProxyActivity.proxyOnPrepareOptionsMenu(menu);
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        return this.mProxyActivity.proxyOnPreparePanel(i, view, menu);
    }

    public void onRestart() {
        this.mProxyActivity.proxyOnRestart();
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        this.mProxyActivity.proxyOnRestoreInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onResume() {
        this.mProxyActivity.proxyOnResume();
    }

    public Object onRetainNonConfigurationInstance() {
        return this.mProxyActivity.proxyOnRetainNonConfigurationInstance();
    }

    protected void onSaveInstanceState(Bundle bundle) {
        this.mProxyActivity.proxyOnSaveInstanceState(bundle);
    }

    public boolean onSearchRequested() {
        return this.mProxyActivity.proxyOnSearchRequested();
    }

    protected void onStart() {
        this.mProxyActivity.proxyOnStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStop() {
        this.mProxyActivity.proxyOnStop();
    }

    protected void onTitleChanged(CharSequence charSequence, int i) {
        this.mProxyActivity.proxyOnTitleChanged(charSequence, i);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mProxyActivity.proxyOnTouchEvent(motionEvent);
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        return this.mProxyActivity.proxyOnTrackballEvent(motionEvent);
    }

    public void onUserInteraction() {
        this.mProxyActivity.proxyOnUserInteraction();
    }

    protected void onUserLeaveHint() {
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.mProxyActivity.proxyOnWindowAttributesChanged(layoutParams);
    }

    public void onWindowFocusChanged(boolean z) {
        this.mProxyActivity.proxyOnWindowFocusChanged(z);
    }

    public void openContextMenu(View view) {
        this.mProxyActivity.proxyOpenContextMenu(view);
    }

    public void openOptionsMenu() {
        this.mProxyActivity.proxyOpenOptionsMenu();
    }

    public void overridePendingTransition(int i, int i2) {
        this.mProxyActivity.proxyOverridePendingTransition(i, i2);
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
        this.mProxyActivity.proxySetContentView(i);
    }

    public void setContentView(View view) {
        this.mProxyActivity.proxySetContentView(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.mProxyActivity.proxySetContentView(view, layoutParams);
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
        this.mProxyActivity.proxySetIntent(intent);
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
        this.mProxyActivity.proxySetRequestedOrientation(i);
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
        this.mProxyActivity.proxySetTitle(i);
    }

    public void setTitle(CharSequence charSequence) {
        this.mProxyActivity.proxySetTitle(charSequence);
    }

    public void setTitleColor(int i) {
        this.mProxyActivity.proxySetTitleColor(i);
    }

    public void setVisible(boolean z) {
        this.mProxyActivity.proxySetVisible(z);
    }

    public final void setVolumeControlStream(int i) {
        this.mActivity.setVolumeControlStream(i);
    }

    public final void showDialog(int i) {
        this.mActivity.showDialog(i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        Plugin plugin2;
        String pluginPackageName = getPluginPackageName();
        PluginSetting findPluginSetting = c.jY().findPluginSetting(pluginPackageName);
        if (findPluginSetting == null || !findPluginSetting.isThird || ((plugin2 = PluginCenter.getInstance().getPlugin(pluginPackageName)) != null && plugin2.remapStartActivityIntent(intent))) {
            this.mProxyActivity.proxyStartActivity(intent);
        }
    }

    public void startActivityForResult(Intent intent, int i) {
        Plugin plugin2;
        String pluginPackageName = getPluginPackageName();
        PluginSetting findPluginSetting = c.jY().findPluginSetting(pluginPackageName);
        if (findPluginSetting == null || !findPluginSetting.isThird || ((plugin2 = PluginCenter.getInstance().getPlugin(pluginPackageName)) != null && plugin2.remapStartActivityIntent(intent))) {
            this.mProxyActivity.proxyStartActivityForResult(intent, i);
        }
    }

    public void startActivityFromChild(Activity activity, Intent intent, int i) {
        this.mProxyActivity.proxyStartActivityFromChild(activity, intent, i);
    }

    public boolean startActivityIfNeeded(Intent intent, int i) {
        return this.mProxyActivity.proxyStartActivityIfNeeded(intent, i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i, int i2, int i3) throws IntentSender.SendIntentException {
        this.mProxyActivity.proxyStartIntentSender(intentSender, intent, i, i2, i3);
    }

    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) throws IntentSender.SendIntentException {
        this.mProxyActivity.proxyStartIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    public void startManagingCursor(Cursor cursor) {
        this.mProxyActivity.proxyStartManagingCursor(cursor);
    }

    public boolean startNextMatchingActivity(Intent intent) {
        return this.mProxyActivity.proxyStartNextMatchingActivity(intent);
    }

    public void startSearch(String str, boolean z, Bundle bundle, boolean z2) {
        this.mProxyActivity.proxyStartSearch(str, z, bundle, z2);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ComponentName startService(Intent intent) {
        Plugin plugin2;
        String pluginPackageName = getPluginPackageName();
        PluginSetting findPluginSetting = c.jY().findPluginSetting(pluginPackageName);
        if (findPluginSetting == null || !findPluginSetting.isThird || ((plugin2 = PluginCenter.getInstance().getPlugin(pluginPackageName)) != null && plugin2.remapStartServiceIntent(intent))) {
            return this.mProxyActivity.proxyStartService(intent);
        }
        return null;
    }

    public void stopManagingCursor(Cursor cursor) {
        this.mProxyActivity.proxyStopManagingCursor(cursor);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean stopService(Intent intent) {
        Plugin plugin2;
        String pluginPackageName = getPluginPackageName();
        PluginSetting findPluginSetting = c.jY().findPluginSetting(pluginPackageName);
        if (findPluginSetting == null || !findPluginSetting.isThird || ((plugin2 = PluginCenter.getInstance().getPlugin(pluginPackageName)) != null && plugin2.remapStartServiceIntent(intent))) {
            return this.mProxyActivity.proxyStopService(intent);
        }
        return false;
    }

    public void takeKeyEvents(boolean z) {
        this.mProxyActivity.proxyTakeKeyEvents(z);
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
        return this.mProxyActivity.proxyDispatchKeyShortcutEvent(keyEvent);
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.mProxyActivity.proxyDispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i) {
        PluginSetting findPluginSetting = c.jY().findPluginSetting(getPluginPackageName());
        return (findPluginSetting == null || !findPluginSetting.isThird) ? this.mProxyActivity.proxyGetSharedPreferences(str, i) : this.mProxyActivity.proxyGetSharedPreferences(String.valueOf(getPluginPackageName()) + str, i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileInputStream openFileInput(String str) throws FileNotFoundException {
        PluginSetting findPluginSetting = c.jY().findPluginSetting(getPluginPackageName());
        return (findPluginSetting == null || !findPluginSetting.isThird) ? this.mActivity.openFileInput(str) : this.mActivity.openFileInput(String.valueOf(getPluginPackageName()) + str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileOutputStream openFileOutput(String str, int i) throws FileNotFoundException {
        PluginSetting findPluginSetting = c.jY().findPluginSetting(getPluginPackageName());
        return (findPluginSetting == null || !findPluginSetting.isThird) ? this.mActivity.openFileOutput(str, i) : this.mActivity.openFileOutput(String.valueOf(getPluginPackageName()) + str, i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteFile(String str) {
        PluginSetting findPluginSetting = c.jY().findPluginSetting(getPluginPackageName());
        return (findPluginSetting == null || !findPluginSetting.isThird) ? this.mActivity.deleteFile(str) : this.mActivity.deleteFile(String.valueOf(getPluginPackageName()) + str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory) {
        PluginSetting findPluginSetting = c.jY().findPluginSetting(getPluginPackageName());
        return (findPluginSetting == null || !findPluginSetting.isThird) ? this.mActivity.openOrCreateDatabase(getPluginPackageName(), i, cursorFactory) : this.mActivity.openOrCreateDatabase(String.valueOf(getPluginPackageName()) + str, i, cursorFactory);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginContextWrapper, android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return (this.bOnCreateCalled || PluginBaseActivity.class.getName().equals(getClass().getName())) ? super.getApplicationContext() : this.mProxyActivity.proxyGetApplicationContext();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteDatabase(String str) {
        PluginSetting findPluginSetting = c.jY().findPluginSetting(getPluginPackageName());
        return (findPluginSetting == null || !findPluginSetting.isThird) ? this.mActivity.deleteDatabase(str) : this.mActivity.deleteDatabase(String.valueOf(getPluginPackageName()) + str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDatabasePath(String str) {
        PluginSetting findPluginSetting = c.jY().findPluginSetting(getPluginPackageName());
        return (findPluginSetting == null || !findPluginSetting.isThird) ? this.mActivity.getDatabasePath(str) : this.mActivity.getDatabasePath(String.valueOf(getPluginPackageName()) + str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDir(String str, int i) {
        PluginSetting findPluginSetting = c.jY().findPluginSetting(getPluginPackageName());
        return (findPluginSetting == null || !findPluginSetting.isThird) ? this.mActivity.getDir(str, i) : this.mActivity.getDir(String.valueOf(getPluginPackageName()) + str, i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getFileStreamPath(String str) {
        PluginSetting findPluginSetting = c.jY().findPluginSetting(getPluginPackageName());
        return (findPluginSetting == null || !findPluginSetting.isThird) ? this.mActivity.getFileStreamPath(str) : this.mActivity.getFileStreamPath(String.valueOf(getPluginPackageName()) + str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCacheDir() {
        File cacheDir = this.mActivity.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        try {
            PluginSetting findPluginSetting = c.jY().findPluginSetting(getPluginPackageName());
            if (findPluginSetting == null || !findPluginSetting.isThird) {
                return cacheDir;
            }
            File file = new File(String.valueOf(cacheDir.getPath()) + File.separator + getPluginPackageName() + cacheDir.getName());
            if (!file.exists() || !file.isDirectory()) {
                file.mkdir();
            }
            return file;
        } catch (Exception e) {
            return null;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent) {
        sendBroadcast(intent, null);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent, String str) {
        Plugin plugin2;
        String pluginPackageName = getPluginPackageName();
        PluginSetting findPluginSetting = c.jY().findPluginSetting(pluginPackageName);
        if (findPluginSetting == null || !findPluginSetting.isThird || ((plugin2 = PluginCenter.getInstance().getPlugin(pluginPackageName)) != null && plugin2.isLoaded() && plugin2.remapBroadcastReceiver(intent))) {
            super.sendBroadcast(intent, str);
        }
    }

    @Override // com.baidu.adp.base.h
    public g getPageContext() {
        return null;
    }

    public boolean handleMessage(Message message) {
        return false;
    }

    public BdUniqueId getUniqueId() {
        return null;
    }

    public boolean isScroll() {
        return false;
    }

    public void setIsScroll(boolean z) {
    }

    public void onPreLoad(w wVar) {
    }
}
