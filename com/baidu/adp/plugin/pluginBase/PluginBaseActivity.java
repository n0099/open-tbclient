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
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import d.a.c.a.f;
import d.a.c.a.g;
import d.a.c.a.i;
import d.a.c.h.f.a;
import d.a.c.h.j.g.d;
import d.a.c.k.e.q;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
/* loaded from: classes.dex */
public class PluginBaseActivity extends PluginContextWrapper implements LayoutInflater.Factory, KeyEvent.Callback, View.OnCreateContextMenuListener, ComponentCallbacks, i, Handler.Callback, g {
    public static final int DEFAULT_KEYS_DIALER = 1;
    public static final int DEFAULT_KEYS_DISABLE = 0;
    public static final int DEFAULT_KEYS_SEARCH_GLOBAL = 4;
    public static final int DEFAULT_KEYS_SEARCH_LOCAL = 3;
    public static final int DEFAULT_KEYS_SHORTCUT = 2;
    public static final int RESULT_CANCELED = 0;
    public static final int RESULT_FIRST_USER = 1;
    public static final int RESULT_OK = -1;
    public boolean bOnCreateCalled;
    public Activity mActivity;
    public a mProxyActivity;

    public PluginBaseActivity() {
        super(null);
        this.mActivity = null;
        this.mProxyActivity = null;
        this.bOnCreateCalled = false;
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.mProxyActivity.proxyAddContentView(view, layoutParams);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i2) {
        Plugin plugin2;
        String pluginPackageName = getPluginPackageName();
        PluginSetting h2 = d.k().h(pluginPackageName);
        if (h2 == null || !h2.isThird || ((plugin2 = PluginCenter.getInstance().getPlugin(pluginPackageName)) != null && plugin2.remapStartServiceIntent(intent))) {
            return this.mProxyActivity.proxyBindService(intent, serviceConnection, i2);
        }
        return false;
    }

    public void closeContextMenu() {
        this.mProxyActivity.proxyCloseContextMenu();
    }

    public void closeOptionsMenu() {
        this.mProxyActivity.proxyCloseOptionsMenu();
    }

    public PendingIntent createPendingResult(int i2, Intent intent, int i3) {
        return this.mProxyActivity.proxyCreatePendingResult(i2, intent, i3);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteDatabase(String str) {
        PluginSetting h2 = d.k().h(getPluginPackageName());
        if (h2 != null && h2.isThird) {
            Activity activity = this.mActivity;
            return activity.deleteDatabase(getPluginPackageName() + str);
        }
        return this.mActivity.deleteDatabase(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteFile(String str) {
        PluginSetting h2 = d.k().h(getPluginPackageName());
        if (h2 != null && h2.isThird) {
            Activity activity = this.mActivity;
            return activity.deleteFile(getPluginPackageName() + str);
        }
        return this.mActivity.deleteFile(str);
    }

    public final void dismissDialog(int i2) {
        this.mActivity.dismissDialog(i2);
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.mProxyActivity.proxyDispatchGenericMotionEvent(motionEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.mProxyActivity.proxyDispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.mProxyActivity.proxyDispatchKeyShortcutEvent(keyEvent);
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

    public View findViewById(int i2) {
        return this.mProxyActivity.proxyFindViewById(i2);
    }

    public void finish() {
        this.mProxyActivity.proxyFinish();
    }

    public void finishActivity(int i2) {
        this.mProxyActivity.proxyFinishActivity(i2);
    }

    public void finishActivityFromChild(Activity activity, int i2) {
        this.mProxyActivity.proxyFinishActivityFromChild(activity, i2);
    }

    public void finishFromChild(Activity activity) {
        this.mProxyActivity.proxyFinishFromChild(activity);
    }

    public Activity getActivity() {
        return this.mActivity;
    }

    public final Application getApplication() {
        return PluginCenter.getInstance().getPlugin(getPluginPackageName()).getApplication();
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginContextWrapper, android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        if (!this.bOnCreateCalled && !PluginBaseActivity.class.getName().equals(getClass().getName())) {
            return this.mProxyActivity.proxyGetApplicationContext();
        }
        return super.getApplicationContext();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCacheDir() {
        File cacheDir = this.mActivity.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        try {
            PluginSetting h2 = d.k().h(getPluginPackageName());
            if (h2 == null || !h2.isThird) {
                return cacheDir;
            }
            File file = new File(cacheDir.getPath() + File.separator + getPluginPackageName() + cacheDir.getName());
            if (!file.exists() || !file.isDirectory()) {
                file.mkdir();
            }
            return file;
        } catch (Exception unused) {
            return null;
        }
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

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDatabasePath(String str) {
        PluginSetting h2 = d.k().h(getPluginPackageName());
        if (h2 != null && h2.isThird) {
            Activity activity = this.mActivity;
            return activity.getDatabasePath(getPluginPackageName() + str);
        }
        return this.mActivity.getDatabasePath(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDir(String str, int i2) {
        PluginSetting h2 = d.k().h(getPluginPackageName());
        if (h2 != null && h2.isThird) {
            Activity activity = this.mActivity;
            return activity.getDir(getPluginPackageName() + str, i2);
        }
        return this.mActivity.getDir(str, i2);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getFileStreamPath(String str) {
        PluginSetting h2 = d.k().h(getPluginPackageName());
        if (h2 != null && h2.isThird) {
            Activity activity = this.mActivity;
            return activity.getFileStreamPath(getPluginPackageName() + str);
        }
        return this.mActivity.getFileStreamPath(str);
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
    public PackageManager getPackageManager() {
        return this.mProxyActivity.proxyGetPackageManager();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageName() {
        PluginSetting h2 = d.k().h(getPluginPackageName());
        if (h2 != null && h2.isThird) {
            return getPluginPackageName();
        }
        return this.mActivity.getPackageName();
    }

    @Override // d.a.c.a.g
    public f getPageContext() {
        return null;
    }

    public final Activity getParent() {
        return this.mActivity.getParent();
    }

    public final Context getParentEntity() {
        Activity parent = this.mActivity.getParent();
        if (parent == null || !(parent instanceof a)) {
            return null;
        }
        return ((a) parent).getTarget();
    }

    public SharedPreferences getPreferences(int i2) {
        return this.mProxyActivity.proxyGetPreferences(i2);
    }

    public int getRequestedOrientation() {
        return this.mProxyActivity.proxyGetRequestedOrientation();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i2) {
        PluginSetting h2 = d.k().h(getPluginPackageName());
        if (h2 != null && h2.isThird) {
            a aVar = this.mProxyActivity;
            return aVar.proxyGetSharedPreferences(getPluginPackageName() + str, i2);
        }
        return this.mProxyActivity.proxyGetSharedPreferences(str, i2);
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

    public BdUniqueId getUniqueId() {
        return null;
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

    public boolean handleMessage(Message message) {
        return false;
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

    public boolean isScroll() {
        return false;
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

    public void onActivityResult(int i2, int i3, Intent intent) {
        this.mProxyActivity.proxyOnActivityResult(i2, i3, intent);
    }

    public void onApplyThemeResource(Resources.Theme theme, int i2, boolean z) {
        this.mProxyActivity.proxyOnApplyThemeResource(theme, i2, z);
    }

    public void onAttachedToWindow() {
        this.mProxyActivity.proxyOnAttachedToWindow();
    }

    public void onBackPressed() {
        this.mProxyActivity.proxyOnBackPressed();
    }

    public void onChildTitleChanged(Activity activity, CharSequence charSequence) {
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

    public Dialog onCreateDialog(int i2) {
        return null;
    }

    public boolean onCreatePanelMenu(int i2, Menu menu) {
        return this.mProxyActivity.proxyOnCreatePanelMenu(i2, menu);
    }

    public View onCreatePanelView(int i2) {
        return null;
    }

    public boolean onCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        return this.mProxyActivity.proxyOnCreateThumbnail(bitmap, canvas);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return this.mProxyActivity.proxyOnCreateView(str, context, attributeSet);
    }

    public void onDestroy() {
        this.mProxyActivity.proxyOnDestroy();
    }

    public void onDetachedFromWindow() {
        this.mProxyActivity.proxyOnDetachedFromWindow();
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return this.mProxyActivity.proxyOnKeyDown(i2, keyEvent);
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i2, KeyEvent keyEvent) {
        return this.mProxyActivity.proxyOnKeyLongPress(i2, keyEvent);
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i2, int i3, KeyEvent keyEvent) {
        return this.mProxyActivity.proxyOnKeyMultiple(i2, i3, keyEvent);
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        return this.mProxyActivity.proxyOnKeyUp(i2, keyEvent);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mProxyActivity.proxyOnLowMemory();
    }

    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        return this.mProxyActivity.proxyOnMenuItemSelected(i2, menuItem);
    }

    public boolean onMenuOpened(int i2, Menu menu) {
        return this.mProxyActivity.proxyOnMenuOpened(i2, menu);
    }

    public void onNewIntent(Intent intent) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return this.mProxyActivity.proxyOnOptionsItemSelected(menuItem);
    }

    public void onOptionsMenuClosed(Menu menu) {
        this.mProxyActivity.proxyOnOptionsMenuClosed(menu);
    }

    public void onPanelClosed(int i2, Menu menu) {
        this.mProxyActivity.proxyOnPanelClosed(i2, menu);
    }

    public void onPause() {
        this.mProxyActivity.proxyOnPause();
    }

    public void onPostCreate(Bundle bundle) {
        this.mProxyActivity.proxyOnPostCreate(bundle);
    }

    public void onPostResume() {
        this.mProxyActivity.proxyOnPostResume();
    }

    public void onPreLoad(q qVar) {
    }

    public void onPrepareDialog(int i2, Dialog dialog) {
        this.mProxyActivity.proxyOnPrepareDialog(i2, dialog);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        return this.mProxyActivity.proxyOnPrepareOptionsMenu(menu);
    }

    public boolean onPreparePanel(int i2, View view, Menu menu) {
        return this.mProxyActivity.proxyOnPreparePanel(i2, view, menu);
    }

    public void onRestart() {
        this.mProxyActivity.proxyOnRestart();
    }

    public void onRestoreInstanceState(Bundle bundle) {
        this.mProxyActivity.proxyOnRestoreInstanceState(bundle);
    }

    public void onResume() {
        this.mProxyActivity.proxyOnResume();
    }

    public Object onRetainNonConfigurationInstance() {
        return this.mProxyActivity.proxyOnRetainNonConfigurationInstance();
    }

    public void onSaveInstanceState(Bundle bundle) {
        this.mProxyActivity.proxyOnSaveInstanceState(bundle);
    }

    public boolean onSearchRequested() {
        return this.mProxyActivity.proxyOnSearchRequested();
    }

    public void onStart() {
        this.mProxyActivity.proxyOnStart();
    }

    public void onStop() {
        this.mProxyActivity.proxyOnStop();
    }

    public void onTitleChanged(CharSequence charSequence, int i2) {
        this.mProxyActivity.proxyOnTitleChanged(charSequence, i2);
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

    public void onUserLeaveHint() {
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

    @Override // android.content.ContextWrapper, android.content.Context
    public FileInputStream openFileInput(String str) throws FileNotFoundException {
        PluginSetting h2 = d.k().h(getPluginPackageName());
        if (h2 != null && h2.isThird) {
            Activity activity = this.mActivity;
            return activity.openFileInput(getPluginPackageName() + str);
        }
        return this.mActivity.openFileInput(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileOutputStream openFileOutput(String str, int i2) throws FileNotFoundException {
        PluginSetting h2 = d.k().h(getPluginPackageName());
        if (h2 != null && h2.isThird) {
            Activity activity = this.mActivity;
            return activity.openFileOutput(getPluginPackageName() + str, i2);
        }
        return this.mActivity.openFileOutput(str, i2);
    }

    public void openOptionsMenu() {
        this.mProxyActivity.proxyOpenOptionsMenu();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i2, SQLiteDatabase.CursorFactory cursorFactory) {
        PluginSetting h2 = d.k().h(getPluginPackageName());
        if (h2 != null && h2.isThird) {
            Activity activity = this.mActivity;
            return activity.openOrCreateDatabase(getPluginPackageName() + str, i2, cursorFactory);
        }
        return this.mActivity.openOrCreateDatabase(getPluginPackageName(), i2, cursorFactory);
    }

    public void overridePendingTransition(int i2, int i3) {
        this.mProxyActivity.proxyOverridePendingTransition(i2, i3);
    }

    public void registerForContextMenu(View view) {
        this.mProxyActivity.proxyRegisterForContextMenu(view);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        return this.mProxyActivity.registerReceiver(broadcastReceiver, intentFilter);
    }

    public final void removeDialog(int i2) {
        this.mActivity.removeDialog(i2);
    }

    public final boolean requestWindowFeature(int i2) {
        return this.mActivity.requestWindowFeature(i2);
    }

    public final void runOnUiThread(Runnable runnable) {
        this.mActivity.runOnUiThread(runnable);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent) {
        sendBroadcast(intent, null);
    }

    public void setActivityProxy(a aVar) {
        this.mActivity = aVar.getActivity();
        this.mProxyActivity = aVar;
    }

    public void setContentView(int i2) {
        this.mProxyActivity.proxySetContentView(i2);
    }

    public final void setDefaultKeyMode(int i2) {
        this.mActivity.setDefaultKeyMode(i2);
    }

    public final void setFeatureDrawable(int i2, Drawable drawable) {
        this.mActivity.setFeatureDrawable(i2, drawable);
    }

    public final void setFeatureDrawableAlpha(int i2, int i3) {
        this.mActivity.setFeatureDrawableAlpha(i2, i3);
    }

    public final void setFeatureDrawableResource(int i2, int i3) {
        this.mActivity.setFeatureDrawableResource(i2, i3);
    }

    public final void setFeatureDrawableUri(int i2, Uri uri) {
        this.mActivity.setFeatureDrawableUri(i2, uri);
    }

    public void setIntent(Intent intent) {
        this.mProxyActivity.proxySetIntent(intent);
    }

    public void setIsScroll(boolean z) {
    }

    public final void setProgress(int i2) {
        this.mActivity.setProgress(i2);
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

    public void setRequestedOrientation(int i2) {
        this.mProxyActivity.proxySetRequestedOrientation(i2);
    }

    public final void setResult(int i2) {
        this.mActivity.setResult(i2);
    }

    public final void setSecondaryProgress(int i2) {
        this.mActivity.setSecondaryProgress(i2);
    }

    public void setTitle(int i2) {
        this.mProxyActivity.proxySetTitle(i2);
    }

    public void setTitleColor(int i2) {
        this.mProxyActivity.proxySetTitleColor(i2);
    }

    public void setVisible(boolean z) {
        this.mProxyActivity.proxySetVisible(z);
    }

    public final void setVolumeControlStream(int i2) {
        this.mActivity.setVolumeControlStream(i2);
    }

    public final void showDialog(int i2) {
        this.mActivity.showDialog(i2);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        Plugin plugin2;
        String pluginPackageName = getPluginPackageName();
        PluginSetting h2 = d.k().h(pluginPackageName);
        if (h2 == null || !h2.isThird || ((plugin2 = PluginCenter.getInstance().getPlugin(pluginPackageName)) != null && plugin2.remapStartActivityIntent(intent))) {
            this.mProxyActivity.proxyStartActivity(intent);
        }
    }

    public void startActivityForResult(Intent intent, int i2) {
        Plugin plugin2;
        String pluginPackageName = getPluginPackageName();
        PluginSetting h2 = d.k().h(pluginPackageName);
        if (h2 == null || !h2.isThird || ((plugin2 = PluginCenter.getInstance().getPlugin(pluginPackageName)) != null && plugin2.remapStartActivityIntent(intent))) {
            this.mProxyActivity.proxyStartActivityForResult(intent, i2);
        }
    }

    public void startActivityFromChild(Activity activity, Intent intent, int i2) {
        this.mProxyActivity.proxyStartActivityFromChild(activity, intent, i2);
    }

    public boolean startActivityIfNeeded(Intent intent, int i2) {
        return this.mProxyActivity.proxyStartActivityIfNeeded(intent, i2);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i2, int i3, int i4) throws IntentSender.SendIntentException {
        this.mProxyActivity.proxyStartIntentSender(intentSender, intent, i2, i3, i4);
    }

    public void startIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5) throws IntentSender.SendIntentException {
        this.mProxyActivity.proxyStartIntentSenderForResult(intentSender, i2, intent, i3, i4, i5);
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
        PluginSetting h2 = d.k().h(pluginPackageName);
        if (h2 == null || !h2.isThird || ((plugin2 = PluginCenter.getInstance().getPlugin(pluginPackageName)) != null && plugin2.remapStartServiceIntent(intent))) {
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
        PluginSetting h2 = d.k().h(pluginPackageName);
        if (h2 == null || !h2.isThird || ((plugin2 = PluginCenter.getInstance().getPlugin(pluginPackageName)) != null && plugin2.remapStartServiceIntent(intent))) {
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
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        this.mProxyActivity.unregisterReceiver(broadcastReceiver);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mProxyActivity.proxyOnCreateView(view, str, context, attributeSet);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent, String str) {
        Plugin plugin2;
        String pluginPackageName = getPluginPackageName();
        PluginSetting h2 = d.k().h(pluginPackageName);
        if (h2 == null || !h2.isThird || ((plugin2 = PluginCenter.getInstance().getPlugin(pluginPackageName)) != null && plugin2.isLoaded() && plugin2.remapBroadcastReceiver(intent))) {
            super.sendBroadcast(intent, str);
        }
    }

    public void setContentView(View view) {
        this.mProxyActivity.proxySetContentView(view);
    }

    public final void setResult(int i2, Intent intent) {
        this.mActivity.setResult(i2, intent);
    }

    public void setTitle(CharSequence charSequence) {
        this.mProxyActivity.proxySetTitle(charSequence);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.mProxyActivity.proxySetContentView(view, layoutParams);
    }
}
