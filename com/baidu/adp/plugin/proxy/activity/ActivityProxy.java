package com.baidu.adp.plugin.proxy.activity;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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
import android.os.PersistableBundle;
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
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.pluginBase.PluginBaseActivity;
import com.baidu.adp.plugin.proxy.ContentResolverProxy;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import d.a.c.a.f;
import d.a.c.a.g;
import d.a.c.a.h;
import d.a.c.a.i;
import d.a.c.h.f.a;
import d.a.c.h.k.d;
import d.a.c.k.e.q;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes.dex */
public class ActivityProxy extends Activity implements a, i, Handler.Callback, g {
    public PluginBaseActivity mEntity = null;

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            pluginBaseActivity.addContentView(view, layoutParams);
        } else {
            super.addContentView(view, layoutParams);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i2) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.bindService(intent, serviceConnection, i2);
        }
        return super.bindService(intent, serviceConnection, i2);
    }

    @Override // android.app.Activity
    public void closeContextMenu() {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            pluginBaseActivity.closeContextMenu();
        } else {
            super.closeContextMenu();
        }
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            pluginBaseActivity.closeOptionsMenu();
        } else {
            super.closeOptionsMenu();
        }
    }

    @Override // android.app.Activity
    public PendingIntent createPendingResult(int i2, Intent intent, int i3) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.createPendingResult(i2, intent, i3);
        }
        return super.createPendingResult(i2, intent, i3);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.dispatchGenericMotionEvent(motionEvent);
        }
        return super.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.dispatchKeyEvent(keyEvent);
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.dispatchKeyShortcutEvent(keyEvent);
        }
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.dispatchTrackballEvent(motionEvent);
        }
        return super.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    @Override // android.app.Activity
    public View findViewById(int i2) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.findViewById(i2);
        }
        return super.findViewById(i2);
    }

    @Override // android.app.Activity
    public void finish() {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            pluginBaseActivity.finish();
        } else {
            super.finish();
        }
    }

    @Override // android.app.Activity
    public void finishActivity(int i2) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            pluginBaseActivity.finishActivity(i2);
        } else {
            super.finishActivity(i2);
        }
    }

    @Override // android.app.Activity
    public void finishActivityFromChild(Activity activity, int i2) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            pluginBaseActivity.finishActivityFromChild(activity, i2);
        } else {
            super.finishActivityFromChild(activity, i2);
        }
    }

    @Override // android.app.Activity
    public void finishFromChild(Activity activity) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            pluginBaseActivity.finishFromChild(activity);
        } else {
            super.finishFromChild(activity);
        }
    }

    @Override // d.a.c.h.f.a
    public Activity getActivity() {
        return this;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.getApplicationContext();
        }
        return super.getApplicationContext();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.getAssets();
        }
        return super.getAssets();
    }

    @Override // android.app.Activity
    public ComponentName getCallingActivity() {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.getCallingActivity();
        }
        return super.getCallingActivity();
    }

    @Override // android.app.Activity
    public String getCallingPackage() {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.getCallingPackage();
        }
        return super.getCallingPackage();
    }

    @Override // android.app.Activity
    public int getChangingConfigurations() {
        return -1;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ClassLoader getClassLoader() {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.getClassLoader();
        }
        return super.getClassLoader();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ContentResolver getContentResolver() {
        return ContentResolverProxy.getContentResolver();
    }

    @Override // android.app.Activity
    public View getCurrentFocus() {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.getCurrentFocus();
        }
        return super.getCurrentFocus();
    }

    @Override // android.app.Activity
    public Intent getIntent() {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.getIntent();
        }
        return super.getIntent();
    }

    @Override // android.app.Activity
    public LayoutInflater getLayoutInflater() {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.getLayoutInflater();
        }
        return super.getLayoutInflater();
    }

    @Override // android.app.Activity
    public String getLocalClassName() {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.getLocalClassName();
        }
        return super.getLocalClassName();
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.getMenuInflater();
        }
        return super.getMenuInflater();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public PackageManager getPackageManager() {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.getPackageManager();
        }
        return super.getPackageManager();
    }

    @Override // d.a.c.a.g
    public f getPageContext() {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity == null || !(pluginBaseActivity instanceof g)) {
            return null;
        }
        return pluginBaseActivity.getPageContext();
    }

    @Override // android.app.Activity
    public SharedPreferences getPreferences(int i2) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.getPreferences(i2);
        }
        return super.getPreferences(i2);
    }

    @Override // android.app.Activity
    public int getRequestedOrientation() {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.getRequestedOrientation();
        }
        return super.getRequestedOrientation();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (BdBaseApplication.getInst().getIsPluginResourcOpen()) {
            PluginBaseActivity pluginBaseActivity = this.mEntity;
            if (pluginBaseActivity != null) {
                return pluginBaseActivity.getResources();
            }
        } else {
            Resources b2 = h.a().b();
            if (b2 != null) {
                return b2;
            }
        }
        return super.getResources();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i2) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.getSharedPreferences(str, i2);
        }
        return super.getSharedPreferences(str, i2);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.getSystemService(str);
        }
        return super.getSystemService(str);
    }

    @Override // d.a.c.h.f.a
    public PluginBaseActivity getTarget() {
        return this.mEntity;
    }

    @Override // android.app.Activity
    public int getTaskId() {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.getTaskId();
        }
        return super.getTaskId();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.getTheme();
        }
        return super.getTheme();
    }

    @Override // d.a.c.a.i
    public BdUniqueId getUniqueId() {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.getUniqueId();
        }
        return null;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int getWallpaperDesiredMinimumHeight() {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.getWallpaperDesiredMinimumHeight();
        }
        return super.getWallpaperDesiredMinimumHeight();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int getWallpaperDesiredMinimumWidth() {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.getWallpaperDesiredMinimumWidth();
        }
        return super.getWallpaperDesiredMinimumWidth();
    }

    @Override // android.app.Activity
    public Window getWindow() {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.getWindow();
        }
        return super.getWindow();
    }

    @Override // android.app.Activity
    public WindowManager getWindowManager() {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.getWindowManager();
        }
        return super.getWindowManager();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.handleMessage(message);
        }
        return false;
    }

    @Override // android.app.Activity
    public boolean hasWindowFocus() {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.hasWindowFocus();
        }
        return super.hasWindowFocus();
    }

    @Override // android.app.Activity
    public boolean isFinishing() {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.isFinishing();
        }
        return super.isFinishing();
    }

    @Override // d.a.c.a.i
    public boolean isScroll() {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.isScroll();
        }
        return false;
    }

    @Override // android.app.Activity
    public boolean isTaskRoot() {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.isTaskRoot();
        }
        return super.isTaskRoot();
    }

    public void loadEntityActivity() {
        if (this.mEntity != null || super.isFinishing()) {
            return;
        }
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
                PluginBaseActivity pluginBaseActivity = (PluginBaseActivity) plugin2.getDexClassLoader().loadClass(stringExtra2).asSubclass(PluginBaseActivity.class).newInstance();
                this.mEntity = pluginBaseActivity;
                pluginBaseActivity.setActivityProxy(this);
                this.mEntity.setPluginPackageName(stringExtra);
                setTheme(plugin2.getActivityThemeResource());
            } else {
                PluginBaseActivity pluginBaseActivity2 = (PluginBaseActivity) PluginCenter.getInstance().getPlugin(stringExtra).getDexClassLoader().loadClass(stringExtra2).asSubclass(PluginBaseActivity.class).newInstance();
                this.mEntity = pluginBaseActivity2;
                pluginBaseActivity2.setActivityProxy(this);
                this.mEntity.setPluginPackageName(stringExtra);
            }
        } catch (ClassNotFoundException e2) {
            BdLog.e(e2);
        } catch (IllegalAccessException e3) {
            BdLog.e(e3);
        } catch (InstantiationException e4) {
            BdLog.e(e4);
        } catch (Exception e5) {
            BdLog.e(e5);
        }
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.moveTaskToBack(z);
        }
        return super.moveTaskToBack(z);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            Class cls = Integer.TYPE;
            d.k(pluginBaseActivity, "onActivityResult", new Class[]{cls, cls, Intent.class}, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), intent});
            return;
        }
        super.onActivityResult(i2, i3, intent);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper
    public void onApplyThemeResource(Resources.Theme theme, int i2, boolean z) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            d.k(pluginBaseActivity, "onApplyThemeResource", new Class[]{Resources.Theme.class, Integer.TYPE, Boolean.TYPE}, new Object[]{theme, Integer.valueOf(i2), Boolean.valueOf(z)});
        } else {
            super.onApplyThemeResource(theme, i2, z);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            pluginBaseActivity.onAttachedToWindow();
        } else {
            super.onAttachedToWindow();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            pluginBaseActivity.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    public void onChildTitleChanged(Activity activity, CharSequence charSequence) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            d.k(pluginBaseActivity, "onChildTitleChanged", new Class[]{Activity.class, CharSequence.class}, new Object[]{activity, charSequence});
        } else {
            super.onChildTitleChanged(activity, charSequence);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            pluginBaseActivity.onConfigurationChanged(configuration);
        } else {
            super.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            pluginBaseActivity.onContentChanged();
        } else {
            super.onContentChanged();
        }
    }

    @Override // android.app.Activity
    public boolean onContextItemSelected(MenuItem menuItem) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.onContextItemSelected(menuItem);
        }
        return super.onContextItemSelected(menuItem);
    }

    @Override // android.app.Activity
    public void onContextMenuClosed(Menu menu) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            pluginBaseActivity.onContextMenuClosed(menu);
        } else {
            super.onContextMenuClosed(menu);
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle, @Nullable PersistableBundle persistableBundle) {
        d.a.c.a.a.b(this);
        super.onCreate(bundle, persistableBundle);
    }

    @Override // android.app.Activity, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            pluginBaseActivity.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        } else {
            super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        }
    }

    @Override // android.app.Activity
    public CharSequence onCreateDescription() {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.onCreateDescription();
        }
        return super.onCreateDescription();
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        return pluginBaseActivity != null ? (Dialog) d.k(pluginBaseActivity, "onCreateDialog", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(i2)}) : super.onCreateDialog(i2);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i2, Menu menu) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.onCreatePanelMenu(i2, menu);
        }
        return super.onCreatePanelMenu(i2, menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public View onCreatePanelView(int i2) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.onCreatePanelView(i2);
        }
        return super.onCreatePanelView(i2);
    }

    @Override // android.app.Activity
    public boolean onCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.onCreateThumbnail(bitmap, canvas);
        }
        return super.onCreateThumbnail(bitmap, canvas);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.onCreateView(view, str, context, attributeSet);
        }
        return super.onCreateView(view, str, context, attributeSet);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            d.k(pluginBaseActivity, MissionEvent.MESSAGE_DESTROY, new Class[0], new Object[0]);
        } else {
            super.onDestroy();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            pluginBaseActivity.onDetachedFromWindow();
        } else {
            super.onDetachedFromWindow();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.onKeyDown(i2, keyEvent);
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i2, KeyEvent keyEvent) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.onKeyLongPress(i2, keyEvent);
        }
        return super.onKeyLongPress(i2, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i2, int i3, KeyEvent keyEvent) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.onKeyMultiple(i2, i3, keyEvent);
        }
        return super.onKeyMultiple(i2, i3, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.onKeyUp(i2, keyEvent);
        }
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            pluginBaseActivity.onLowMemory();
        } else {
            super.onLowMemory();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.onMenuItemSelected(i2, menuItem);
        }
        return super.onMenuItemSelected(i2, menuItem);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i2, Menu menu) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.onMenuOpened(i2, menu);
        }
        return super.onMenuOpened(i2, menu);
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            d.k(pluginBaseActivity, "onNewIntent", new Class[]{Intent.class}, new Object[]{intent});
        } else {
            super.onNewIntent(intent);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.onOptionsItemSelected(menuItem);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.app.Activity
    public void onOptionsMenuClosed(Menu menu) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            pluginBaseActivity.onOptionsMenuClosed(menu);
        } else {
            super.onOptionsMenuClosed(menu);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i2, Menu menu) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            pluginBaseActivity.onPanelClosed(i2, menu);
        } else {
            super.onPanelClosed(i2, menu);
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            d.k(pluginBaseActivity, MissionEvent.MESSAGE_PAUSE, new Class[0], new Object[0]);
        } else {
            super.onPause();
        }
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            d.k(pluginBaseActivity, "onPostCreate", new Class[]{Bundle.class}, new Object[]{bundle});
        } else {
            super.onPostCreate(bundle);
        }
    }

    @Override // android.app.Activity
    public void onPostResume() {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            d.k(pluginBaseActivity, "onPostResume", new Class[0], new Object[0]);
        } else {
            super.onPostResume();
        }
    }

    @Override // d.a.c.a.i
    public void onPreLoad(q qVar) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            pluginBaseActivity.onPreLoad(qVar);
        }
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            pluginBaseActivity.onPrepareDialog(i2, dialog);
        } else {
            super.onPrepareDialog(i2, dialog);
        }
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.onPrepareOptionsMenu(menu);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i2, View view, Menu menu) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.onPreparePanel(i2, view, menu);
        }
        return super.onPreparePanel(i2, view, menu);
    }

    @Override // android.app.Activity
    public void onRestart() {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            d.k(pluginBaseActivity, "onRestart", new Class[0], new Object[0]);
        } else {
            super.onRestart();
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            d.k(pluginBaseActivity, "onRestoreInstanceState", new Class[]{Bundle.class}, new Object[]{bundle});
        } else {
            super.onRestoreInstanceState(bundle);
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            d.k(pluginBaseActivity, MissionEvent.MESSAGE_RESUME, new Class[0], new Object[0]);
        } else {
            super.onResume();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            d.k(pluginBaseActivity, "onSaveInstanceState", new Class[]{Bundle.class}, new Object[]{bundle});
        } else {
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.onSearchRequested();
        }
        return super.onSearchRequested();
    }

    @Override // android.app.Activity
    public void onStart() {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            d.k(pluginBaseActivity, MissionEvent.MESSAGE_START, new Class[0], new Object[0]);
        } else {
            super.onStart();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            d.k(pluginBaseActivity, MissionEvent.MESSAGE_STOP, new Class[0], new Object[0]);
        } else {
            super.onStop();
        }
    }

    @Override // android.app.Activity
    public void onTitleChanged(CharSequence charSequence, int i2) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            d.k(pluginBaseActivity, "onTitleChanged", new Class[]{CharSequence.class, Integer.TYPE}, new Object[]{charSequence, Integer.valueOf(i2)});
        } else {
            super.onTitleChanged(charSequence, i2);
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.onTrackballEvent(motionEvent);
        }
        return super.onTrackballEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void onUserInteraction() {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            pluginBaseActivity.onUserInteraction();
        } else {
            super.onUserInteraction();
        }
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        super.onUserLeaveHint();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            pluginBaseActivity.onWindowAttributesChanged(layoutParams);
        } else {
            super.onWindowAttributesChanged(layoutParams);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            pluginBaseActivity.onWindowFocusChanged(z);
        } else {
            super.onWindowFocusChanged(z);
        }
    }

    @Override // android.app.Activity
    public void openContextMenu(View view) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            pluginBaseActivity.openContextMenu(view);
        } else {
            super.openContextMenu(view);
        }
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            pluginBaseActivity.openOptionsMenu();
        } else {
            super.openOptionsMenu();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i2, int i3) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            pluginBaseActivity.overridePendingTransition(i2, i3);
        } else {
            super.overridePendingTransition(i2, i3);
        }
    }

    @Override // d.a.c.h.f.a
    public void proxyAddContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.addContentView(view, layoutParams);
    }

    @Override // d.a.c.h.f.a
    public boolean proxyBindService(Intent intent, ServiceConnection serviceConnection, int i2) {
        return super.bindService(intent, serviceConnection, i2);
    }

    @Override // d.a.c.h.f.a
    public void proxyCloseContextMenu() {
        super.closeContextMenu();
    }

    @Override // d.a.c.h.f.a
    public void proxyCloseOptionsMenu() {
        super.closeOptionsMenu();
    }

    @Override // d.a.c.h.f.a
    public PendingIntent proxyCreatePendingResult(int i2, Intent intent, int i3) {
        return super.createPendingResult(i2, intent, i3);
    }

    @Override // d.a.c.h.f.a
    public boolean proxyDispatchGenericMotionEvent(MotionEvent motionEvent) {
        return super.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // d.a.c.h.f.a
    public boolean proxyDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // d.a.c.h.f.a
    public boolean proxyDispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // d.a.c.h.f.a
    public boolean proxyDispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // d.a.c.h.f.a
    public boolean proxyDispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // d.a.c.h.f.a
    public boolean proxyDispatchTrackballEvent(MotionEvent motionEvent) {
        return super.dispatchTrackballEvent(motionEvent);
    }

    @Override // d.a.c.h.f.a
    public View proxyFindViewById(int i2) {
        return super.findViewById(i2);
    }

    @Override // d.a.c.h.f.a
    public void proxyFinish() {
        super.finish();
    }

    @Override // d.a.c.h.f.a
    public void proxyFinishActivity(int i2) {
        super.finishActivity(i2);
    }

    @Override // d.a.c.h.f.a
    public void proxyFinishActivityFromChild(Activity activity, int i2) {
        super.finishActivityFromChild(activity, i2);
    }

    @Override // d.a.c.h.f.a
    public void proxyFinishFromChild(Activity activity) {
        super.finishFromChild(activity);
    }

    @Override // d.a.c.h.f.a
    public Context proxyGetApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // d.a.c.h.f.a
    public ComponentName proxyGetCallingActivity() {
        return null;
    }

    @Override // d.a.c.h.f.a
    public String proxyGetCallingPackage() {
        return super.getCallingPackage();
    }

    @Override // d.a.c.h.f.a
    public int proxyGetChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    @Override // d.a.c.h.f.a
    public View proxyGetCurrentFocus() {
        return super.getCurrentFocus();
    }

    @Override // d.a.c.h.f.a
    public Intent proxyGetIntent() {
        return super.getIntent();
    }

    public Object proxyGetLastNonConfigurationInstance() {
        return super.getLastNonConfigurationInstance();
    }

    @Override // d.a.c.h.f.a
    public LayoutInflater proxyGetLayoutInflater() {
        return super.getLayoutInflater();
    }

    @Override // d.a.c.h.f.a
    public String proxyGetLocalClassName() {
        return super.getLocalClassName();
    }

    @Override // d.a.c.h.f.a
    public MenuInflater proxyGetMenuInflater() {
        return super.getMenuInflater();
    }

    @Override // d.a.c.h.f.a
    public PackageManager proxyGetPackageManager() {
        return super.getPackageManager();
    }

    @Override // d.a.c.h.f.a
    public SharedPreferences proxyGetPreferences(int i2) {
        return super.getPreferences(i2);
    }

    @Override // d.a.c.h.f.a
    public int proxyGetRequestedOrientation() {
        return super.getRequestedOrientation();
    }

    @Override // d.a.c.h.f.a
    public SharedPreferences proxyGetSharedPreferences(String str, int i2) {
        return super.getSharedPreferences(str, i2);
    }

    @Override // d.a.c.h.f.a
    public Object proxyGetSystemService(String str) {
        return super.getSystemService(str);
    }

    @Override // d.a.c.h.f.a
    public int proxyGetTaskId() {
        return super.getTaskId();
    }

    @Override // d.a.c.h.f.a
    public int proxyGetWallpaperDesiredMinimumHeight() {
        return super.getWallpaperDesiredMinimumHeight();
    }

    @Override // d.a.c.h.f.a
    public int proxyGetWallpaperDesiredMinimumWidth() {
        return super.getWallpaperDesiredMinimumWidth();
    }

    @Override // d.a.c.h.f.a
    public Window proxyGetWindow() {
        return super.getWindow();
    }

    @Override // d.a.c.h.f.a
    public WindowManager proxyGetWindowManager() {
        return super.getWindowManager();
    }

    @Override // d.a.c.h.f.a
    public boolean proxyHasWindowFocus() {
        return super.hasWindowFocus();
    }

    @Override // d.a.c.h.f.a
    public boolean proxyIsFinishing() {
        return super.isFinishing();
    }

    @Override // d.a.c.h.f.a
    public boolean proxyIsTaskRoot() {
        return super.isTaskRoot();
    }

    @Override // d.a.c.h.f.a
    public boolean proxyMoveTaskToBack(boolean z) {
        return super.moveTaskToBack(z);
    }

    @Override // d.a.c.h.f.a
    public void proxyOnActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }

    @Override // d.a.c.h.f.a
    public void proxyOnApplyThemeResource(Resources.Theme theme, int i2, boolean z) {
        super.onApplyThemeResource(theme, i2, z);
    }

    @Override // d.a.c.h.f.a
    public void proxyOnAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // d.a.c.h.f.a
    public void proxyOnBackPressed() {
        super.onBackPressed();
    }

    @Override // d.a.c.h.f.a
    public void proxyOnChildTitleChanged(Activity activity, CharSequence charSequence) {
        super.onChildTitleChanged(activity, charSequence);
    }

    @Override // d.a.c.h.f.a
    public void proxyOnConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // d.a.c.h.f.a
    public void proxyOnContentChanged() {
        super.onContentChanged();
    }

    @Override // d.a.c.h.f.a
    public boolean proxyOnContextItemSelected(MenuItem menuItem) {
        return super.onContextItemSelected(menuItem);
    }

    @Override // d.a.c.h.f.a
    public void proxyOnContextMenuClosed(Menu menu) {
        super.onContextMenuClosed(menu);
    }

    @Override // d.a.c.h.f.a
    public void proxyOnCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // d.a.c.h.f.a
    public void proxyOnCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // d.a.c.h.f.a
    public boolean proxyOnCreatePanelMenu(int i2, Menu menu) {
        return super.onCreatePanelMenu(i2, menu);
    }

    @Override // d.a.c.h.f.a
    public boolean proxyOnCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        return super.onCreateThumbnail(bitmap, canvas);
    }

    @Override // d.a.c.h.f.a
    public View proxyOnCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    @Override // d.a.c.h.f.a
    public void proxyOnDestroy() {
        super.onDestroy();
    }

    @Override // d.a.c.h.f.a
    public void proxyOnDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // d.a.c.h.f.a
    public boolean proxyOnKeyDown(int i2, KeyEvent keyEvent) {
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // d.a.c.h.f.a
    public boolean proxyOnKeyLongPress(int i2, KeyEvent keyEvent) {
        return super.onKeyLongPress(i2, keyEvent);
    }

    @Override // d.a.c.h.f.a
    public boolean proxyOnKeyMultiple(int i2, int i3, KeyEvent keyEvent) {
        return super.onKeyMultiple(i2, i3, keyEvent);
    }

    @Override // d.a.c.h.f.a
    public boolean proxyOnKeyUp(int i2, KeyEvent keyEvent) {
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // d.a.c.h.f.a
    public void proxyOnLowMemory() {
        super.onLowMemory();
    }

    @Override // d.a.c.h.f.a
    public boolean proxyOnMenuItemSelected(int i2, MenuItem menuItem) {
        return super.onMenuItemSelected(i2, menuItem);
    }

    @Override // d.a.c.h.f.a
    public boolean proxyOnMenuOpened(int i2, Menu menu) {
        return super.onMenuOpened(i2, menu);
    }

    @Override // d.a.c.h.f.a
    public boolean proxyOnOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // d.a.c.h.f.a
    public void proxyOnOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
    }

    @Override // d.a.c.h.f.a
    public void proxyOnPanelClosed(int i2, Menu menu) {
        super.onPanelClosed(i2, menu);
    }

    @Override // d.a.c.h.f.a
    public void proxyOnPause() {
        super.onPause();
    }

    @Override // d.a.c.h.f.a
    public void proxyOnPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
    }

    @Override // d.a.c.h.f.a
    public void proxyOnPostResume() {
        super.onPostResume();
    }

    @Override // d.a.c.h.f.a
    public void proxyOnPrepareDialog(int i2, Dialog dialog) {
        super.onPrepareDialog(i2, dialog);
    }

    @Override // d.a.c.h.f.a
    public boolean proxyOnPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // d.a.c.h.f.a
    public boolean proxyOnPreparePanel(int i2, View view, Menu menu) {
        return super.onPreparePanel(i2, view, menu);
    }

    @Override // d.a.c.h.f.a
    public void proxyOnRestart() {
        super.onRestart();
    }

    @Override // d.a.c.h.f.a
    public void proxyOnRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
    }

    @Override // d.a.c.h.f.a
    public void proxyOnResume() {
        super.onResume();
    }

    @Override // d.a.c.h.f.a
    public Object proxyOnRetainNonConfigurationInstance() {
        return super.onRetainNonConfigurationInstance();
    }

    @Override // d.a.c.h.f.a
    public void proxyOnSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // d.a.c.h.f.a
    public boolean proxyOnSearchRequested() {
        return super.onSearchRequested();
    }

    @Override // d.a.c.h.f.a
    public void proxyOnStart() {
        super.onStart();
    }

    @Override // d.a.c.h.f.a
    public void proxyOnStop() {
        super.onStop();
    }

    @Override // d.a.c.h.f.a
    public void proxyOnTitleChanged(CharSequence charSequence, int i2) {
        super.onTitleChanged(charSequence, i2);
    }

    @Override // d.a.c.h.f.a
    public boolean proxyOnTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // d.a.c.h.f.a
    public boolean proxyOnTrackballEvent(MotionEvent motionEvent) {
        return super.onTrackballEvent(motionEvent);
    }

    @Override // d.a.c.h.f.a
    public void proxyOnUserInteraction() {
        super.onUserInteraction();
    }

    @Override // d.a.c.h.f.a
    public void proxyOnWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        super.onWindowAttributesChanged(layoutParams);
    }

    @Override // d.a.c.h.f.a
    public void proxyOnWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    @Override // d.a.c.h.f.a
    public void proxyOpenContextMenu(View view) {
        super.openContextMenu(view);
    }

    @Override // d.a.c.h.f.a
    public void proxyOpenOptionsMenu() {
        super.openOptionsMenu();
    }

    @Override // d.a.c.h.f.a
    public void proxyOverridePendingTransition(int i2, int i3) {
        super.overridePendingTransition(i2, i3);
    }

    @Override // d.a.c.h.f.a
    public void proxyRegisterForContextMenu(View view) {
        super.registerForContextMenu(view);
    }

    @Override // d.a.c.h.f.a
    public void proxySetContentView(int i2) {
        super.setContentView(i2);
    }

    @Override // d.a.c.h.f.a
    public void proxySetIntent(Intent intent) {
        super.setIntent(intent);
    }

    @Override // d.a.c.h.f.a
    public void proxySetRequestedOrientation(int i2) {
        super.setRequestedOrientation(i2);
    }

    @Override // d.a.c.h.f.a
    public void proxySetTitle(int i2) {
        super.setTitle(i2);
    }

    @Override // d.a.c.h.f.a
    public void proxySetTitleColor(int i2) {
        super.setTitleColor(i2);
    }

    @Override // d.a.c.h.f.a
    public void proxySetVisible(boolean z) {
        super.setVisible(z);
    }

    @Override // d.a.c.h.f.a
    public void proxyStartActivity(Intent intent) {
        super.startActivity(intent);
    }

    @Override // d.a.c.h.f.a
    public void proxyStartActivityForResult(Intent intent, int i2) {
        super.startActivityForResult(intent, i2);
    }

    @Override // d.a.c.h.f.a
    public void proxyStartActivityFromChild(Activity activity, Intent intent, int i2) {
        super.startActivityFromChild(activity, intent, i2);
    }

    @Override // d.a.c.h.f.a
    public boolean proxyStartActivityIfNeeded(Intent intent, int i2) {
        return super.startActivityIfNeeded(intent, i2);
    }

    @Override // d.a.c.h.f.a
    public void proxyStartIntentSender(IntentSender intentSender, Intent intent, int i2, int i3, int i4) throws IntentSender.SendIntentException {
        super.startIntentSender(intentSender, intent, i2, i3, i4);
    }

    @Override // d.a.c.h.f.a
    public void proxyStartIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5);
    }

    public void proxyStartIntentSenderFromChild(Activity activity, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5) throws IntentSender.SendIntentException {
        super.startIntentSenderFromChild(activity, intentSender, i2, intent, i3, i4, i5);
    }

    @Override // d.a.c.h.f.a
    public void proxyStartManagingCursor(Cursor cursor) {
        super.startManagingCursor(cursor);
    }

    @Override // d.a.c.h.f.a
    public boolean proxyStartNextMatchingActivity(Intent intent) {
        return super.startNextMatchingActivity(intent);
    }

    @Override // d.a.c.h.f.a
    public void proxyStartSearch(String str, boolean z, Bundle bundle, boolean z2) {
        super.startSearch(str, z, bundle, z2);
    }

    @Override // d.a.c.h.f.a
    public ComponentName proxyStartService(Intent intent) {
        return super.startService(intent);
    }

    @Override // d.a.c.h.f.a
    public void proxyStopManagingCursor(Cursor cursor) {
        super.stopManagingCursor(cursor);
    }

    @Override // d.a.c.h.f.a
    public boolean proxyStopService(Intent intent) {
        return super.stopService(intent);
    }

    @Override // d.a.c.h.f.a
    public void proxyTakeKeyEvents(boolean z) {
        super.takeKeyEvents(z);
    }

    @Override // d.a.c.h.f.a
    public void proxyUnregisterForContextMenu(View view) {
        super.unregisterForContextMenu(view);
    }

    public void proxysetFinishOnTouchOutside(boolean z) {
        super.setFinishOnTouchOutside(z);
    }

    @Override // android.app.Activity
    public void registerForContextMenu(View view) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            pluginBaseActivity.registerForContextMenu(view);
        } else {
            super.registerForContextMenu(view);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context, d.a.c.h.f.a
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        return super.registerReceiver(broadcastReceiver, intentFilter);
    }

    @Override // android.app.Activity
    public void setContentView(int i2) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            pluginBaseActivity.setContentView(i2);
        } else {
            super.setContentView(i2);
        }
    }

    @Override // android.app.Activity
    public void setIntent(Intent intent) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            pluginBaseActivity.setIntent(intent);
        } else {
            super.setIntent(intent);
        }
    }

    @Override // d.a.c.a.i
    public void setIsScroll(boolean z) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            pluginBaseActivity.setIsScroll(z);
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i2) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            pluginBaseActivity.setRequestedOrientation(i2);
        } else {
            super.setRequestedOrientation(i2);
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i2) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            pluginBaseActivity.setTheme(i2);
        } else {
            super.setTheme(i2);
        }
    }

    @Override // android.app.Activity
    public void setTitle(int i2) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            pluginBaseActivity.setTitle(i2);
        } else {
            super.setTitle(i2);
        }
    }

    @Override // android.app.Activity
    public void setTitleColor(int i2) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            pluginBaseActivity.setTitleColor(i2);
        } else {
            super.setTitleColor(i2);
        }
    }

    @Override // android.app.Activity
    public void setVisible(boolean z) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            pluginBaseActivity.setVisible(z);
        } else {
            super.setVisible(z);
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            pluginBaseActivity.startActivity(intent);
        } else {
            super.startActivity(intent);
        }
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i2) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            pluginBaseActivity.startActivityForResult(intent, i2);
        } else {
            super.startActivityForResult(intent, i2);
        }
    }

    @Override // android.app.Activity
    public void startActivityFromChild(Activity activity, Intent intent, int i2) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            pluginBaseActivity.startActivityFromChild(activity, intent, i2);
        } else {
            super.startActivityFromChild(activity, intent, i2);
        }
    }

    @Override // android.app.Activity
    public boolean startActivityIfNeeded(Intent intent, int i2) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.startActivityIfNeeded(intent, i2);
        }
        return super.startActivityIfNeeded(intent, i2);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i2, int i3, int i4) throws IntentSender.SendIntentException {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            pluginBaseActivity.startIntentSender(intentSender, intent, i2, i3, i4);
        } else {
            super.startIntentSender(intentSender, intent, i2, i3, i4);
        }
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5) throws IntentSender.SendIntentException {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            pluginBaseActivity.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5);
        } else {
            super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5);
        }
    }

    @Override // android.app.Activity
    public void startManagingCursor(Cursor cursor) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            pluginBaseActivity.startManagingCursor(cursor);
        } else {
            super.startManagingCursor(cursor);
        }
    }

    @Override // android.app.Activity
    public boolean startNextMatchingActivity(Intent intent) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.startNextMatchingActivity(intent);
        }
        return super.startNextMatchingActivity(intent);
    }

    @Override // android.app.Activity
    public void startSearch(String str, boolean z, Bundle bundle, boolean z2) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            pluginBaseActivity.startSearch(str, z, bundle, z2);
        } else {
            super.startSearch(str, z, bundle, z2);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ComponentName startService(Intent intent) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.startService(intent);
        }
        return super.startService(intent);
    }

    @Override // android.app.Activity
    public void stopManagingCursor(Cursor cursor) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            pluginBaseActivity.stopManagingCursor(cursor);
        } else {
            super.stopManagingCursor(cursor);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean stopService(Intent intent) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.stopService(intent);
        }
        return super.stopService(intent);
    }

    @Override // android.app.Activity
    public void takeKeyEvents(boolean z) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            pluginBaseActivity.takeKeyEvents(z);
        } else {
            super.takeKeyEvents(z);
        }
    }

    @Override // android.app.Activity
    public void unregisterForContextMenu(View view) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            pluginBaseActivity.unregisterForContextMenu(view);
        } else {
            super.unregisterForContextMenu(view);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context, d.a.c.h.f.a
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        super.unregisterReceiver(broadcastReceiver);
    }

    @Override // d.a.c.h.f.a
    public View proxyOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(view, str, context, attributeSet);
    }

    @Override // d.a.c.h.f.a
    public void proxySetContentView(View view) {
        super.setContentView(view);
    }

    @Override // d.a.c.h.f.a
    public void proxySetTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        this.mEntity = null;
        loadEntityActivity();
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            d.k(pluginBaseActivity, MissionEvent.MESSAGE_CREATE, new Class[]{Bundle.class}, new Object[]{bundle});
        } else {
            super.onCreate(bundle);
        }
    }

    @Override // d.a.c.h.f.a
    public void proxySetContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            return pluginBaseActivity.onCreateView(str, context, attributeSet);
        }
        return super.onCreateView(str, context, attributeSet);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            pluginBaseActivity.setContentView(view);
        } else {
            super.setContentView(view);
        }
    }

    @Override // android.app.Activity
    public void setTitle(CharSequence charSequence) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            pluginBaseActivity.setTitle(charSequence);
        } else {
            super.setTitle(charSequence);
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        PluginBaseActivity pluginBaseActivity = this.mEntity;
        if (pluginBaseActivity != null) {
            pluginBaseActivity.setContentView(view, layoutParams);
        } else {
            super.setContentView(view, layoutParams);
        }
    }
}
