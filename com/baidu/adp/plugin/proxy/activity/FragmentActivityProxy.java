package com.baidu.adp.plugin.proxy.activity;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.base.e;
import com.baidu.adp.base.f;
import com.baidu.adp.base.g;
import com.baidu.adp.base.h;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.a.b;
import com.baidu.adp.plugin.d;
import com.baidu.adp.plugin.pluginBase.PluginBaseFragmentActivity;
import com.baidu.adp.plugin.util.d;
import com.baidu.adp.widget.ListView.t;
import com.baidu.megapp.ma.MAFragmentActivity;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes.dex */
public class FragmentActivityProxy extends MAFragmentActivity implements Handler.Callback, f, h, b {
    protected PluginBaseFragmentActivity mEntity = null;

    public void loadEntityActivity() {
        if (this.mEntity == null && !super.isFinishing()) {
            Intent intent = getIntent();
            if (intent == null) {
                finish();
                return;
            }
            String stringExtra = intent.getStringExtra(Plugin.INTENT_EXTRA_PACKAGE_NAME);
            if (!PluginCenter.getInstance().isLoaded(stringExtra)) {
                finish();
                BdLog.e("plugin not loaded. pluginname is " + stringExtra);
                return;
            }
            try {
                String stringExtra2 = intent.getStringExtra(Plugin.INTENT_EXTRA_ACTIVITY);
                if (BdBaseApplication.getInst().getIsPluginResourcOpen()) {
                    Plugin plugin2 = PluginCenter.getInstance().getPlugin(stringExtra);
                    this.mEntity = (PluginBaseFragmentActivity) plugin2.getDexClassLoader().loadClass(stringExtra2).asSubclass(PluginBaseFragmentActivity.class).newInstance();
                    this.mEntity.setActivityProxy((b) this);
                    this.mEntity.setPluginPackageName(stringExtra);
                    setTheme(plugin2.getActivityThemeResource());
                } else {
                    this.mEntity = (PluginBaseFragmentActivity) PluginCenter.getInstance().getPlugin(stringExtra).getDexClassLoader().loadClass(stringExtra2).asSubclass(PluginBaseFragmentActivity.class).newInstance();
                    this.mEntity.setActivityProxy((b) this);
                    this.mEntity.setPluginPackageName(stringExtra);
                }
            } catch (ClassNotFoundException e) {
                BdLog.e(e);
            } catch (IllegalAccessException e2) {
                BdLog.e(e2);
            } catch (InstantiationException e3) {
                BdLog.e(e3);
            } catch (Exception e4) {
                BdLog.e(e4);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.plugin.a.a
    public PluginBaseFragmentActivity getTarget() {
        return this.mEntity;
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.mEntity != null) {
            this.mEntity.addContentView(view, layoutParams);
        } else {
            super.addContentView(view, layoutParams);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i) {
        if (this.mEntity != null) {
            return this.mEntity.bindService(intent, serviceConnection, i);
        }
        return false;
    }

    @Override // android.app.Activity
    public void closeContextMenu() {
        if (this.mEntity != null) {
            this.mEntity.closeContextMenu();
        } else {
            super.closeContextMenu();
        }
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        if (this.mEntity != null) {
            this.mEntity.closeOptionsMenu();
        } else {
            super.closeOptionsMenu();
        }
    }

    @Override // android.app.Activity
    public PendingIntent createPendingResult(int i, Intent intent, int i2) {
        return this.mEntity != null ? this.mEntity.createPendingResult(i, intent, i2) : super.createPendingResult(i, intent, i2);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.mEntity != null ? this.mEntity.dispatchGenericMotionEvent(motionEvent) : super.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.mEntity != null ? this.mEntity.dispatchKeyEvent(keyEvent) : super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.mEntity != null ? this.mEntity.dispatchKeyShortcutEvent(keyEvent) : super.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.mEntity != null ? this.mEntity.dispatchPopulateAccessibilityEvent(accessibilityEvent) : super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.mEntity != null ? this.mEntity.dispatchTouchEvent(motionEvent) : super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.mEntity != null ? this.mEntity.dispatchTrackballEvent(motionEvent) : super.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    @Override // android.app.Activity
    public View findViewById(int i) {
        return this.mEntity != null ? this.mEntity.findViewById(i) : super.findViewById(i);
    }

    @Override // android.app.Activity
    public void finish() {
        if (this.mEntity != null) {
            this.mEntity.finish();
        } else {
            super.finish();
        }
    }

    @Override // android.app.Activity
    public void finishActivity(int i) {
        if (this.mEntity != null) {
            this.mEntity.finishActivity(i);
        } else {
            super.finishActivity(i);
        }
    }

    @Override // android.app.Activity
    public void finishActivityFromChild(Activity activity, int i) {
        if (this.mEntity != null) {
            this.mEntity.finishActivityFromChild(activity, i);
        } else {
            super.finishActivityFromChild(activity, i);
        }
    }

    @Override // android.app.Activity
    public void finishFromChild(Activity activity) {
        if (this.mEntity != null) {
            this.mEntity.finishFromChild(activity);
        } else {
            super.finishFromChild(activity);
        }
    }

    @Override // com.baidu.megapp.ma.MAFragmentActivity, com.baidu.adp.plugin.a.a
    public Activity getActivity() {
        return super.getActivity();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.mEntity != null ? this.mEntity.getAssets() : super.getAssets();
    }

    @Override // android.app.Activity
    public ComponentName getCallingActivity() {
        return this.mEntity != null ? this.mEntity.getCallingActivity() : super.getCallingActivity();
    }

    @Override // android.app.Activity
    public String getCallingPackage() {
        return this.mEntity != null ? this.mEntity.getCallingPackage() : super.getCallingPackage();
    }

    @Override // android.app.Activity
    public int getChangingConfigurations() {
        return -1;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ClassLoader getClassLoader() {
        if (this.mEntity != null) {
            return this.mEntity.getClassLoader();
        }
        return null;
    }

    @Override // android.app.Activity
    public View getCurrentFocus() {
        return this.mEntity != null ? this.mEntity.getCurrentFocus() : super.getCurrentFocus();
    }

    @Override // android.app.Activity
    public Intent getIntent() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        return pluginBaseFragmentActivity != null ? pluginBaseFragmentActivity.getIntent() : super.getIntent();
    }

    @Override // android.app.Activity
    public LayoutInflater getLayoutInflater() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        return pluginBaseFragmentActivity != null ? pluginBaseFragmentActivity.getLayoutInflater() : super.getLayoutInflater();
    }

    @Override // android.app.Activity
    public String getLocalClassName() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        return pluginBaseFragmentActivity != null ? pluginBaseFragmentActivity.getLocalClassName() : super.getLocalClassName();
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return this.mEntity != null ? this.mEntity.getMenuInflater() : super.getMenuInflater();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public PackageManager getPackageManager() {
        if (this.mEntity != null) {
            return this.mEntity.getPackageManager();
        }
        return null;
    }

    @Override // android.app.Activity
    public SharedPreferences getPreferences(int i) {
        return this.mEntity != null ? this.mEntity.getPreferences(i) : super.getPreferences(i);
    }

    @Override // android.app.Activity
    public int getRequestedOrientation() {
        return this.mEntity != null ? this.mEntity.getRequestedOrientation() : super.getRequestedOrientation();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (BdBaseApplication.getInst().getIsPluginResourcOpen()) {
            if (this.mEntity != null) {
                return this.mEntity.getResources();
            }
        } else {
            Resources resources = g.lh().getResources();
            if (resources != null) {
                return resources;
            }
        }
        return super.getResources();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i) {
        if (this.mEntity != null) {
            return this.mEntity.getSharedPreferences(str, i);
        }
        return null;
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        return this.mEntity != null ? this.mEntity.getSystemService(str) : super.getSystemService(str);
    }

    @Override // android.app.Activity
    public int getTaskId() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        return pluginBaseFragmentActivity != null ? pluginBaseFragmentActivity.getTaskId() : super.getTaskId();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int getWallpaperDesiredMinimumHeight() {
        if (this.mEntity != null) {
            return this.mEntity.getWallpaperDesiredMinimumHeight();
        }
        return 0;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int getWallpaperDesiredMinimumWidth() {
        if (this.mEntity != null) {
            return this.mEntity.getWallpaperDesiredMinimumWidth();
        }
        return 0;
    }

    @Override // android.app.Activity
    public Window getWindow() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        return pluginBaseFragmentActivity != null ? pluginBaseFragmentActivity.getWindow() : super.getWindow();
    }

    @Override // android.app.Activity
    public WindowManager getWindowManager() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        return pluginBaseFragmentActivity != null ? pluginBaseFragmentActivity.getWindowManager() : super.getWindowManager();
    }

    @Override // android.app.Activity
    public boolean hasWindowFocus() {
        return this.mEntity != null ? this.mEntity.hasWindowFocus() : super.hasWindowFocus();
    }

    @Override // android.app.Activity
    public boolean isFinishing() {
        return this.mEntity != null ? this.mEntity.isFinishing() : super.isFinishing();
    }

    @Override // android.app.Activity
    public boolean isTaskRoot() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        return pluginBaseFragmentActivity != null ? pluginBaseFragmentActivity.isTaskRoot() : super.isTaskRoot();
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        return pluginBaseFragmentActivity != null ? pluginBaseFragmentActivity.moveTaskToBack(z) : super.moveTaskToBack(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.mEntity != null) {
            d.invokeMethod(this.mEntity, "onActivityResult", new Class[]{Integer.TYPE, Integer.TYPE, Intent.class}, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent});
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper
    protected void onApplyThemeResource(Resources.Theme theme, int i, boolean z) {
        if (this.mEntity != null) {
            d.invokeMethod(this.mEntity, "onApplyThemeResource", new Class[]{Resources.Theme.class, Integer.TYPE, Boolean.TYPE}, new Object[]{theme, Integer.valueOf(i), Boolean.valueOf(z)});
        } else {
            super.onApplyThemeResource(theme, i, z);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        if (this.mEntity != null) {
            this.mEntity.onAttachedToWindow();
        } else {
            super.onAttachedToWindow();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.mEntity != null) {
            this.mEntity.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    protected void onChildTitleChanged(Activity activity, CharSequence charSequence) {
        if (this.mEntity != null) {
            d.invokeMethod(this.mEntity, "onChildTitleChanged", new Class[]{Activity.class, CharSequence.class}, new Object[]{activity, charSequence});
        } else {
            super.onChildTitleChanged(activity, charSequence);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        if (this.mEntity != null) {
            this.mEntity.onConfigurationChanged(configuration);
        } else {
            super.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        if (this.mEntity != null) {
            this.mEntity.onContentChanged();
        } else {
            super.onContentChanged();
        }
    }

    @Override // android.app.Activity
    public boolean onContextItemSelected(MenuItem menuItem) {
        return this.mEntity != null ? this.mEntity.onContextItemSelected(menuItem) : super.onContextItemSelected(menuItem);
    }

    @Override // android.app.Activity
    public void onContextMenuClosed(Menu menu) {
        if (this.mEntity != null) {
            this.mEntity.onContextMenuClosed(menu);
        } else {
            super.onContextMenuClosed(menu);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        this.mEntity = null;
        loadEntityActivity();
        if (this.mEntity != null) {
            d.invokeMethod(this.mEntity, MissionEvent.MESSAGE_CREATE, new Class[]{Bundle.class}, new Object[]{bundle});
        } else {
            super.onCreate(bundle);
        }
    }

    @Override // android.app.Activity, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        if (this.mEntity != null) {
            this.mEntity.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        } else {
            super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        }
    }

    @Override // android.app.Activity
    public CharSequence onCreateDescription() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        return pluginBaseFragmentActivity != null ? pluginBaseFragmentActivity.onCreateDescription() : super.onCreateDescription();
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        return this.mEntity != null ? (Dialog) d.invokeMethod(this.mEntity, "onCreateDialog", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(i)}) : super.onCreateDialog(i);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        return this.mEntity != null ? this.mEntity.onCreatePanelMenu(i, menu) : super.onCreatePanelMenu(i, menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public View onCreatePanelView(int i) {
        return this.mEntity != null ? this.mEntity.onCreatePanelView(i) : super.onCreatePanelView(i);
    }

    @Override // android.app.Activity
    public boolean onCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        return this.mEntity != null ? this.mEntity.onCreateThumbnail(bitmap, canvas) : super.onCreateThumbnail(bitmap, canvas);
    }

    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.BaseFragmentActivityApi14, android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return this.mEntity != null ? this.mEntity.onCreateView(str, context, attributeSet) : super.onCreateView(str, context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.mEntity != null) {
            d.invokeMethod(this.mEntity, MissionEvent.MESSAGE_DESTROY, new Class[0], new Object[0]);
        } else {
            super.onDestroy();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        if (this.mEntity != null) {
            this.mEntity.onDetachedFromWindow();
        } else {
            super.onDetachedFromWindow();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.mEntity != null ? this.mEntity.onKeyDown(i, keyEvent) : super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        return this.mEntity != null ? this.mEntity.onKeyLongPress(i, keyEvent) : super.onKeyLongPress(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return this.mEntity != null ? this.mEntity.onKeyMultiple(i, i2, keyEvent) : super.onKeyMultiple(i, i2, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.mEntity != null ? this.mEntity.onKeyUp(i, keyEvent) : super.onKeyUp(i, keyEvent);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        if (this.mEntity != null) {
            this.mEntity.onLowMemory();
        } else {
            super.onLowMemory();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return this.mEntity != null ? this.mEntity.onMenuItemSelected(i, menuItem) : super.onMenuItemSelected(i, menuItem);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        return this.mEntity != null ? this.mEntity.onMenuOpened(i, menu) : super.onMenuOpened(i, menu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        if (this.mEntity != null) {
            d.invokeMethod(this.mEntity, "onNewIntent", new Class[]{Intent.class}, new Object[]{intent});
        } else {
            super.onNewIntent(intent);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return this.mEntity != null ? this.mEntity.onOptionsItemSelected(menuItem) : super.onOptionsItemSelected(menuItem);
    }

    @Override // android.app.Activity
    public void onOptionsMenuClosed(Menu menu) {
        if (this.mEntity != null) {
            this.mEntity.onOptionsMenuClosed(menu);
        } else {
            super.onOptionsMenuClosed(menu);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        if (this.mEntity != null) {
            this.mEntity.onPanelClosed(i, menu);
        } else {
            super.onPanelClosed(i, menu);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        if (this.mEntity != null) {
            d.invokeMethod(this.mEntity, MissionEvent.MESSAGE_PAUSE, new Class[0], new Object[0]);
        } else {
            super.onPause();
        }
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        if (this.mEntity != null) {
            d.invokeMethod(this.mEntity, "onPostCreate", new Class[]{Bundle.class}, new Object[]{bundle});
        } else {
            super.onPostCreate(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPostResume() {
        if (this.mEntity != null) {
            d.invokeMethod(this.mEntity, "onPostResume", new Class[0], new Object[0]);
        } else {
            super.onPostResume();
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
        if (this.mEntity != null) {
            this.mEntity.onPrepareDialog(i, dialog);
        } else {
            super.onPrepareDialog(i, dialog);
        }
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        return this.mEntity != null ? this.mEntity.onPrepareOptionsMenu(menu) : super.onPrepareOptionsMenu(menu);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        return this.mEntity != null ? this.mEntity.onPreparePanel(i, view, menu) : super.onPreparePanel(i, view, menu);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        if (this.mEntity != null) {
            d.invokeMethod(this.mEntity, "onRestart", new Class[0], new Object[0]);
        } else {
            super.onRestart();
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        if (this.mEntity != null) {
            d.invokeMethod(this.mEntity, "onRestoreInstanceState", new Class[]{Bundle.class}, new Object[]{bundle});
        } else {
            super.onRestoreInstanceState(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        if (this.mEntity != null) {
            d.invokeMethod(this.mEntity, MissionEvent.MESSAGE_RESUME, new Class[0], new Object[0]);
        } else {
            super.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (this.mEntity != null) {
            d.invokeMethod(this.mEntity, "onSaveInstanceState", new Class[]{Bundle.class}, new Object[]{bundle});
        } else {
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        return this.mEntity != null ? this.mEntity.onSearchRequested() : super.onSearchRequested();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        if (this.mEntity != null) {
            d.invokeMethod(this.mEntity, MissionEvent.MESSAGE_START, new Class[0], new Object[0]);
        } else {
            super.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        if (this.mEntity != null) {
            d.invokeMethod(this.mEntity, MissionEvent.MESSAGE_STOP, new Class[0], new Object[0]);
        } else {
            super.onStop();
        }
    }

    @Override // android.app.Activity
    protected void onTitleChanged(CharSequence charSequence, int i) {
        if (this.mEntity != null) {
            d.invokeMethod(this.mEntity, "onTitleChanged", new Class[]{CharSequence.class, Integer.TYPE}, new Object[]{charSequence, Integer.valueOf(i)});
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mEntity != null ? this.mEntity.onTouchEvent(motionEvent) : super.onTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        return this.mEntity != null ? this.mEntity.onTrackballEvent(motionEvent) : super.onTrackballEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void onUserInteraction() {
        if (this.mEntity != null) {
            this.mEntity.onUserInteraction();
        } else {
            super.onUserInteraction();
        }
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        if (this.mEntity != null) {
            this.mEntity.onWindowAttributesChanged(layoutParams);
        } else {
            super.onWindowAttributesChanged(layoutParams);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        if (this.mEntity != null) {
            this.mEntity.onWindowFocusChanged(z);
        } else {
            super.onWindowFocusChanged(z);
        }
    }

    @Override // android.app.Activity
    public void openContextMenu(View view) {
        if (this.mEntity != null) {
            this.mEntity.openContextMenu(view);
        } else {
            super.openContextMenu(view);
        }
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        if (this.mEntity != null) {
            this.mEntity.openOptionsMenu();
        } else {
            super.openOptionsMenu();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        if (this.mEntity != null) {
            this.mEntity.overridePendingTransition(i, i2);
        } else {
            super.overridePendingTransition(i, i2);
        }
    }

    @Override // android.app.Activity
    public void registerForContextMenu(View view) {
        if (this.mEntity != null) {
            this.mEntity.registerForContextMenu(view);
        } else {
            super.registerForContextMenu(view);
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        if (this.mEntity != null) {
            this.mEntity.setContentView(i);
        } else {
            super.setContentView(i);
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        if (this.mEntity != null) {
            this.mEntity.setContentView(view);
        } else {
            super.setContentView(view);
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.mEntity != null) {
            this.mEntity.setContentView(view, layoutParams);
        } else {
            super.setContentView(view, layoutParams);
        }
    }

    @Override // android.app.Activity
    public void setIntent(Intent intent) {
        if (this.mEntity != null) {
            this.mEntity.setIntent(intent);
        } else {
            super.setIntent(intent);
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i) {
        if (this.mEntity != null) {
            this.mEntity.setRequestedOrientation(i);
        } else {
            super.setRequestedOrientation(i);
        }
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        if (this.mEntity != null) {
            return this.mEntity.getTheme();
        }
        return null;
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (this.mEntity != null) {
            this.mEntity.setTheme(i);
        }
    }

    @Override // android.app.Activity
    public void setTitle(int i) {
        if (this.mEntity != null) {
            this.mEntity.setTitle(i);
        } else {
            super.setTitle(i);
        }
    }

    @Override // android.app.Activity
    public void setTitle(CharSequence charSequence) {
        if (this.mEntity != null) {
            this.mEntity.setTitle(charSequence);
        } else {
            super.setTitle(charSequence);
        }
    }

    @Override // android.app.Activity
    public void setTitleColor(int i) {
        if (this.mEntity != null) {
            this.mEntity.setTitleColor(i);
        } else {
            super.setTitleColor(i);
        }
    }

    @Override // android.app.Activity
    public void setVisible(boolean z) {
        if (this.mEntity != null) {
            this.mEntity.setVisible(z);
        } else {
            super.setVisible(z);
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        if (this.mEntity != null) {
            this.mEntity.startActivity(intent);
        } else {
            super.startActivity(intent);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i) {
        if (this.mEntity != null) {
            this.mEntity.startActivityForResult(intent, i);
        } else {
            super.startActivityForResult(intent, i);
        }
    }

    @Override // android.app.Activity
    public void startActivityFromChild(Activity activity, Intent intent, int i) {
        if (this.mEntity != null) {
            this.mEntity.startActivityFromChild(activity, intent, i);
        } else {
            super.startActivityFromChild(activity, intent, i);
        }
    }

    @Override // android.app.Activity
    public boolean startActivityIfNeeded(Intent intent, int i) {
        return this.mEntity != null ? this.mEntity.startActivityIfNeeded(intent, i) : super.startActivityIfNeeded(intent, i);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i, int i2, int i3) throws IntentSender.SendIntentException {
        if (this.mEntity != null) {
            this.mEntity.startIntentSender(intentSender, intent, i, i2, i3);
        } else {
            super.startIntentSender(intentSender, intent, i, i2, i3);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.BaseFragmentActivityApi14, android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) throws IntentSender.SendIntentException {
        if (this.mEntity != null) {
            this.mEntity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
        } else {
            super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
        }
    }

    @Override // android.app.Activity
    public void startManagingCursor(Cursor cursor) {
        if (this.mEntity != null) {
            this.mEntity.startManagingCursor(cursor);
        } else {
            super.startManagingCursor(cursor);
        }
    }

    @Override // android.app.Activity
    public boolean startNextMatchingActivity(Intent intent) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        return pluginBaseFragmentActivity != null ? pluginBaseFragmentActivity.startNextMatchingActivity(intent) : super.startNextMatchingActivity(intent);
    }

    @Override // android.app.Activity
    public void startSearch(String str, boolean z, Bundle bundle, boolean z2) {
        if (this.mEntity != null) {
            this.mEntity.startSearch(str, z, bundle, z2);
        } else {
            super.startSearch(str, z, bundle, z2);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ComponentName startService(Intent intent) {
        if (this.mEntity != null) {
            return this.mEntity.startService(intent);
        }
        return null;
    }

    @Override // android.app.Activity
    public void stopManagingCursor(Cursor cursor) {
        if (this.mEntity != null) {
            this.mEntity.stopManagingCursor(cursor);
        } else {
            super.stopManagingCursor(cursor);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean stopService(Intent intent) {
        if (this.mEntity != null) {
            return this.mEntity.stopService(intent);
        }
        return false;
    }

    @Override // android.app.Activity
    public void takeKeyEvents(boolean z) {
        if (this.mEntity != null) {
            this.mEntity.takeKeyEvents(z);
        } else {
            super.takeKeyEvents(z);
        }
    }

    @Override // android.app.Activity
    public void unregisterForContextMenu(View view) {
        if (this.mEntity != null) {
            this.mEntity.unregisterForContextMenu(view);
        } else {
            super.unregisterForContextMenu(view);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return this.mEntity != null ? this.mEntity.getApplicationContext() : super.getApplicationContext();
    }

    @Override // com.baidu.adp.plugin.a.a
    public View proxyOnCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    @Override // com.baidu.adp.plugin.a.a
    public View proxyOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(view, str, context, attributeSet);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyAddContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.addContentView(view, layoutParams);
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean proxyBindService(Intent intent, ServiceConnection serviceConnection, int i) {
        return false;
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyCloseContextMenu() {
        super.closeContextMenu();
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyCloseOptionsMenu() {
        super.closeOptionsMenu();
    }

    @Override // com.baidu.adp.plugin.a.a
    public PendingIntent proxyCreatePendingResult(int i, Intent intent, int i2) {
        return super.createPendingResult(i, intent, i2);
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean proxyDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean proxyDispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean proxyDispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean proxyDispatchTrackballEvent(MotionEvent motionEvent) {
        return super.dispatchTrackballEvent(motionEvent);
    }

    @Override // com.baidu.adp.plugin.a.a
    public View proxyFindViewById(int i) {
        return super.findViewById(i);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyFinish() {
        super.finish();
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyFinishActivity(int i) {
        super.finishActivity(i);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyFinishActivityFromChild(Activity activity, int i) {
        super.finishActivityFromChild(activity, i);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyFinishFromChild(Activity activity) {
        super.finishFromChild(activity);
    }

    @Override // com.baidu.adp.plugin.a.a
    public Context proxyGetApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // com.baidu.adp.plugin.a.a
    public ComponentName proxyGetCallingActivity() {
        return super.getCallingActivity();
    }

    @Override // com.baidu.adp.plugin.a.a
    public SharedPreferences proxyGetSharedPreferences(String str, int i) {
        return null;
    }

    @Override // com.baidu.adp.plugin.a.a
    public String proxyGetCallingPackage() {
        return super.getCallingPackage();
    }

    @Override // com.baidu.adp.plugin.a.a
    public int proxyGetChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    @Override // com.baidu.adp.plugin.a.a
    public View proxyGetCurrentFocus() {
        return super.getCurrentFocus();
    }

    @Override // com.baidu.adp.plugin.a.a
    public Intent proxyGetIntent() {
        return super.getIntent();
    }

    public Object proxyGetLastNonConfigurationInstance() {
        return super.getLastNonConfigurationInstance();
    }

    @Override // com.baidu.adp.plugin.a.a
    public LayoutInflater proxyGetLayoutInflater() {
        return super.getLayoutInflater();
    }

    @Override // com.baidu.adp.plugin.a.a
    public String proxyGetLocalClassName() {
        return super.getLocalClassName();
    }

    @Override // com.baidu.adp.plugin.a.a
    public MenuInflater proxyGetMenuInflater() {
        return super.getMenuInflater();
    }

    @Override // com.baidu.adp.plugin.a.a
    public PackageManager proxyGetPackageManager() {
        return null;
    }

    @Override // com.baidu.adp.plugin.a.a
    public SharedPreferences proxyGetPreferences(int i) {
        return super.getPreferences(i);
    }

    @Override // com.baidu.adp.plugin.a.a
    public int proxyGetRequestedOrientation() {
        return super.getRequestedOrientation();
    }

    @Override // com.baidu.adp.plugin.a.a
    public Object proxyGetSystemService(String str) {
        return super.getSystemService(str);
    }

    @Override // com.baidu.adp.plugin.a.a
    public int proxyGetTaskId() {
        return super.getTaskId();
    }

    @Override // com.baidu.adp.plugin.a.a
    public int proxyGetWallpaperDesiredMinimumHeight() {
        return 0;
    }

    @Override // com.baidu.adp.plugin.a.a
    public int proxyGetWallpaperDesiredMinimumWidth() {
        return 0;
    }

    @Override // com.baidu.adp.plugin.a.a
    public Window proxyGetWindow() {
        return super.getWindow();
    }

    @Override // com.baidu.adp.plugin.a.a
    public WindowManager proxyGetWindowManager() {
        return super.getWindowManager();
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean proxyHasWindowFocus() {
        return super.hasWindowFocus();
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean proxyIsFinishing() {
        return super.isFinishing();
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean proxyIsTaskRoot() {
        return super.isTaskRoot();
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean proxyMoveTaskToBack(boolean z) {
        return super.moveTaskToBack(z);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyOnActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyOnApplyThemeResource(Resources.Theme theme, int i, boolean z) {
        super.onApplyThemeResource(theme, i, z);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyOnAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyOnBackPressed() {
        super.onBackPressed();
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyOnChildTitleChanged(Activity activity, CharSequence charSequence) {
        super.onChildTitleChanged(activity, charSequence);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyOnConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyOnContentChanged() {
        super.onContentChanged();
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean proxyOnContextItemSelected(MenuItem menuItem) {
        return super.onContextItemSelected(menuItem);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyOnContextMenuClosed(Menu menu) {
        super.onContextMenuClosed(menu);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyOnCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyOnCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean proxyOnCreatePanelMenu(int i, Menu menu) {
        return super.onCreatePanelMenu(i, menu);
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean proxyOnCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        return super.onCreateThumbnail(bitmap, canvas);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyOnDestroy() {
        super.onDestroy();
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyOnDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean proxyOnKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean proxyOnKeyLongPress(int i, KeyEvent keyEvent) {
        return super.onKeyLongPress(i, keyEvent);
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean proxyOnKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return super.onKeyMultiple(i, i2, keyEvent);
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean proxyOnKeyUp(int i, KeyEvent keyEvent) {
        return super.onKeyUp(i, keyEvent);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyOnLowMemory() {
        super.onLowMemory();
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean proxyOnMenuItemSelected(int i, MenuItem menuItem) {
        return super.onMenuItemSelected(i, menuItem);
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean proxyOnMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean proxyOnOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyOnOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyOnPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyOnPause() {
        super.onPause();
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean proxyDispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyOnPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyOnPostResume() {
        super.onPostResume();
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyOnPrepareDialog(int i, Dialog dialog) {
        super.onPrepareDialog(i, dialog);
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean proxyOnPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean proxyOnPreparePanel(int i, View view, Menu menu) {
        return super.onPreparePanel(i, view, menu);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyOnRestart() {
        super.onRestart();
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyOnRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyOnResume() {
        super.onResume();
    }

    @Override // com.baidu.adp.plugin.a.a
    public Object proxyOnRetainNonConfigurationInstance() {
        return super.onRetainNonConfigurationInstance();
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyOnSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean proxyOnSearchRequested() {
        return super.onSearchRequested();
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyOnStart() {
        super.onStart();
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyOnStop() {
        super.onStop();
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyOnTitleChanged(CharSequence charSequence, int i) {
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean proxyOnTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean proxyOnTrackballEvent(MotionEvent motionEvent) {
        return super.onTrackballEvent(motionEvent);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyOnUserInteraction() {
        super.onUserInteraction();
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyOnWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        super.onWindowAttributesChanged(layoutParams);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyOnWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyOpenContextMenu(View view) {
        super.openContextMenu(view);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyOpenOptionsMenu() {
        super.openOptionsMenu();
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyOverridePendingTransition(int i, int i2) {
        super.overridePendingTransition(i, i2);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyRegisterForContextMenu(View view) {
        super.registerForContextMenu(view);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxySetContentView(int i) {
        super.setContentView(i);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxySetContentView(View view) {
        super.setContentView(view);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxySetContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxySetIntent(Intent intent) {
        super.setIntent(intent);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxySetRequestedOrientation(int i) {
        super.setRequestedOrientation(i);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxySetTitle(int i) {
        super.setTitle(i);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxySetTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxySetTitleColor(int i) {
        super.setTitleColor(i);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxySetVisible(boolean z) {
        super.setVisible(z);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyStartActivity(Intent intent) {
        super.startActivity(intent);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyStartActivityForResult(Intent intent, int i) {
        super.startActivityForResult(intent, i);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyStartActivityFromChild(Activity activity, Intent intent, int i) {
        super.startActivityFromChild(activity, intent, i);
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean proxyStartActivityIfNeeded(Intent intent, int i) {
        return super.startActivityIfNeeded(intent, i);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyStartIntentSender(IntentSender intentSender, Intent intent, int i, int i2, int i3) throws IntentSender.SendIntentException {
        super.startIntentSender(intentSender, intent, i, i2, i3);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyStartIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    public void proxyStartIntentSenderFromChild(Activity activity, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) throws IntentSender.SendIntentException {
        super.startIntentSenderFromChild(activity, intentSender, i, intent, i2, i3, i4);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyStartManagingCursor(Cursor cursor) {
        super.startManagingCursor(cursor);
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean proxyStartNextMatchingActivity(Intent intent) {
        return super.startNextMatchingActivity(intent);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyStartSearch(String str, boolean z, Bundle bundle, boolean z2) {
        super.startSearch(str, z, bundle, z2);
    }

    @Override // com.baidu.adp.plugin.a.a
    public ComponentName proxyStartService(Intent intent) {
        return null;
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyStopManagingCursor(Cursor cursor) {
        super.stopManagingCursor(cursor);
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean proxyStopService(Intent intent) {
        String stringExtra = intent.getStringExtra(Plugin.INTENT_EXTRA_SERVICE);
        d.a aVar = null;
        if (stringExtra != null) {
            aVar = com.baidu.adp.plugin.d.pi().cm(stringExtra);
        }
        if (aVar == null || aVar.RL == null) {
            BdLog.d("service stop error!" + intent.toString());
            return false;
        } else if (com.baidu.adp.plugin.d.pi().pj() == 1) {
            com.baidu.adp.plugin.d.pi().cn(stringExtra);
            aVar.RL.stopSelf();
            return true;
        } else {
            aVar.RL.onDestroy();
            com.baidu.adp.plugin.d.pi().cn(stringExtra);
            return true;
        }
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyTakeKeyEvents(boolean z) {
        super.takeKeyEvents(z);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyUnregisterForContextMenu(View view) {
        super.unregisterForContextMenu(view);
    }

    public void proxysetFinishOnTouchOutside(boolean z) {
        super.setFinishOnTouchOutside(z);
    }

    @Override // com.baidu.adp.plugin.a.b
    public FragmentManager proxyGetSupportFragmentManager() {
        return super.getSupportFragmentManager();
    }

    @Override // com.baidu.adp.plugin.a.b
    public void proxyOnAttachFragment(Fragment fragment) {
    }

    @Override // com.baidu.adp.plugin.a.b
    public void proxyStartActivityFromFragment(Fragment fragment, Intent intent, int i) {
    }

    @Override // com.baidu.adp.base.h
    public BdUniqueId getUniqueId() {
        if (this.mEntity != null) {
            return this.mEntity.getUniqueId();
        }
        return null;
    }

    @Override // com.baidu.adp.base.h
    public boolean isScroll() {
        if (this.mEntity != null) {
            return this.mEntity.isScroll();
        }
        return false;
    }

    @Override // com.baidu.adp.base.h
    public void setIsScroll(boolean z) {
        if (this.mEntity != null) {
            this.mEntity.setIsScroll(z);
        }
    }

    @Override // com.baidu.adp.base.h
    public void onPreLoad(t tVar) {
        if (this.mEntity != null) {
            this.mEntity.onPreLoad(tVar);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (this.mEntity != null) {
            return this.mEntity.handleMessage(message);
        }
        return false;
    }

    @Override // com.baidu.adp.base.f
    public e getPageContext() {
        if (this.mEntity == null || !(this.mEntity instanceof f)) {
            return null;
        }
        return this.mEntity.getPageContext();
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean proxyDispatchGenericMotionEvent(MotionEvent motionEvent) {
        return super.dispatchGenericMotionEvent(motionEvent);
    }
}
