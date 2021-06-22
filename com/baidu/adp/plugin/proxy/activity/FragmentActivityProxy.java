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
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.pluginBase.PluginBaseFragmentActivity;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import d.a.c.a.a;
import d.a.c.a.f;
import d.a.c.a.g;
import d.a.c.a.h;
import d.a.c.a.i;
import d.a.c.h.d;
import d.a.c.h.f.b;
import d.a.c.h.k.d;
import d.a.c.k.e.q;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes.dex */
public class FragmentActivityProxy extends FragmentActivity implements b, i, Handler.Callback, g {
    public PluginBaseFragmentActivity mEntity = null;

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            pluginBaseFragmentActivity.addContentView(view, layoutParams);
        } else {
            super.addContentView(view, layoutParams);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i2) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.bindService(intent, serviceConnection, i2);
        }
        return false;
    }

    @Override // android.app.Activity
    public void closeContextMenu() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            pluginBaseFragmentActivity.closeContextMenu();
        } else {
            super.closeContextMenu();
        }
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            pluginBaseFragmentActivity.closeOptionsMenu();
        } else {
            super.closeOptionsMenu();
        }
    }

    @Override // android.app.Activity
    public PendingIntent createPendingResult(int i2, Intent intent, int i3) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.createPendingResult(i2, intent, i3);
        }
        return super.createPendingResult(i2, intent, i3);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.dispatchGenericMotionEvent(motionEvent);
        }
        return super.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.dispatchKeyEvent(keyEvent);
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.dispatchKeyShortcutEvent(keyEvent);
        }
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.dispatchTrackballEvent(motionEvent);
        }
        return super.dispatchTrackballEvent(motionEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    @Override // android.app.Activity
    public View findViewById(int i2) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.findViewById(i2);
        }
        return super.findViewById(i2);
    }

    @Override // android.app.Activity
    public void finish() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            pluginBaseFragmentActivity.finish();
        } else {
            super.finish();
        }
    }

    @Override // android.app.Activity
    public void finishActivity(int i2) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            pluginBaseFragmentActivity.finishActivity(i2);
        } else {
            super.finishActivity(i2);
        }
    }

    @Override // android.app.Activity
    public void finishActivityFromChild(Activity activity, int i2) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            pluginBaseFragmentActivity.finishActivityFromChild(activity, i2);
        } else {
            super.finishActivityFromChild(activity, i2);
        }
    }

    @Override // android.app.Activity
    public void finishFromChild(Activity activity) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            pluginBaseFragmentActivity.finishFromChild(activity);
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
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.getApplicationContext();
        }
        return super.getApplicationContext();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.getAssets();
        }
        return super.getAssets();
    }

    @Override // android.app.Activity
    public ComponentName getCallingActivity() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.getCallingActivity();
        }
        return super.getCallingActivity();
    }

    @Override // android.app.Activity
    public String getCallingPackage() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.getCallingPackage();
        }
        return super.getCallingPackage();
    }

    @Override // android.app.Activity
    public int getChangingConfigurations() {
        return -1;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ClassLoader getClassLoader() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.getClassLoader();
        }
        return null;
    }

    @Override // android.app.Activity
    public View getCurrentFocus() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.getCurrentFocus();
        }
        return super.getCurrentFocus();
    }

    @Override // android.app.Activity
    public Intent getIntent() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.getIntent();
        }
        return super.getIntent();
    }

    @Override // android.app.Activity
    public LayoutInflater getLayoutInflater() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.getLayoutInflater();
        }
        return super.getLayoutInflater();
    }

    @Override // android.app.Activity
    public String getLocalClassName() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.getLocalClassName();
        }
        return super.getLocalClassName();
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.getMenuInflater();
        }
        return super.getMenuInflater();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public PackageManager getPackageManager() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.getPackageManager();
        }
        return null;
    }

    @Override // d.a.c.a.g
    public f getPageContext() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity == null || !(pluginBaseFragmentActivity instanceof g)) {
            return null;
        }
        return pluginBaseFragmentActivity.getPageContext();
    }

    @Override // android.app.Activity
    public SharedPreferences getPreferences(int i2) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.getPreferences(i2);
        }
        return super.getPreferences(i2);
    }

    @Override // android.app.Activity
    public int getRequestedOrientation() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.getRequestedOrientation();
        }
        return super.getRequestedOrientation();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (BdBaseApplication.getInst().getIsPluginResourcOpen()) {
            PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
            if (pluginBaseFragmentActivity != null) {
                return pluginBaseFragmentActivity.getResources();
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
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.getSharedPreferences(str, i2);
        }
        return null;
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.getSystemService(str);
        }
        return super.getSystemService(str);
    }

    @Override // android.app.Activity
    public int getTaskId() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.getTaskId();
        }
        return super.getTaskId();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.getTheme();
        }
        return null;
    }

    @Override // d.a.c.a.i
    public BdUniqueId getUniqueId() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.getUniqueId();
        }
        return null;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int getWallpaperDesiredMinimumHeight() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.getWallpaperDesiredMinimumHeight();
        }
        return 0;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int getWallpaperDesiredMinimumWidth() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.getWallpaperDesiredMinimumWidth();
        }
        return 0;
    }

    @Override // android.app.Activity
    public Window getWindow() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.getWindow();
        }
        return super.getWindow();
    }

    @Override // android.app.Activity
    public WindowManager getWindowManager() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.getWindowManager();
        }
        return super.getWindowManager();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.handleMessage(message);
        }
        return false;
    }

    @Override // android.app.Activity
    public boolean hasWindowFocus() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.hasWindowFocus();
        }
        return super.hasWindowFocus();
    }

    @Override // android.app.Activity
    public boolean isFinishing() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.isFinishing();
        }
        return super.isFinishing();
    }

    @Override // d.a.c.a.i
    public boolean isScroll() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.isScroll();
        }
        return false;
    }

    @Override // android.app.Activity
    public boolean isTaskRoot() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.isTaskRoot();
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
                PluginBaseFragmentActivity pluginBaseFragmentActivity = (PluginBaseFragmentActivity) plugin2.getDexClassLoader().loadClass(stringExtra2).asSubclass(PluginBaseFragmentActivity.class).newInstance();
                this.mEntity = pluginBaseFragmentActivity;
                pluginBaseFragmentActivity.setActivityProxy((b) this);
                this.mEntity.setPluginPackageName(stringExtra);
                setTheme(plugin2.getActivityThemeResource());
            } else {
                PluginBaseFragmentActivity pluginBaseFragmentActivity2 = (PluginBaseFragmentActivity) PluginCenter.getInstance().getPlugin(stringExtra).getDexClassLoader().loadClass(stringExtra2).asSubclass(PluginBaseFragmentActivity.class).newInstance();
                this.mEntity = pluginBaseFragmentActivity2;
                pluginBaseFragmentActivity2.setActivityProxy((b) this);
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
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.moveTaskToBack(z);
        }
        return super.moveTaskToBack(z);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            Class cls = Integer.TYPE;
            d.k(pluginBaseFragmentActivity, "onActivityResult", new Class[]{cls, cls, Intent.class}, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), intent});
            return;
        }
        super.onActivityResult(i2, i3, intent);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper
    public void onApplyThemeResource(Resources.Theme theme, int i2, boolean z) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            d.k(pluginBaseFragmentActivity, "onApplyThemeResource", new Class[]{Resources.Theme.class, Integer.TYPE, Boolean.TYPE}, new Object[]{theme, Integer.valueOf(i2), Boolean.valueOf(z)});
        } else {
            super.onApplyThemeResource(theme, i2, z);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            pluginBaseFragmentActivity.onAttachedToWindow();
        } else {
            super.onAttachedToWindow();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            pluginBaseFragmentActivity.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    public void onChildTitleChanged(Activity activity, CharSequence charSequence) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            d.k(pluginBaseFragmentActivity, "onChildTitleChanged", new Class[]{Activity.class, CharSequence.class}, new Object[]{activity, charSequence});
        } else {
            super.onChildTitleChanged(activity, charSequence);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            pluginBaseFragmentActivity.onConfigurationChanged(configuration);
        } else {
            super.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            pluginBaseFragmentActivity.onContentChanged();
        } else {
            super.onContentChanged();
        }
    }

    @Override // android.app.Activity
    public boolean onContextItemSelected(MenuItem menuItem) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.onContextItemSelected(menuItem);
        }
        return super.onContextItemSelected(menuItem);
    }

    @Override // android.app.Activity
    public void onContextMenuClosed(Menu menu) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            pluginBaseFragmentActivity.onContextMenuClosed(menu);
        } else {
            super.onContextMenuClosed(menu);
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle, @Nullable PersistableBundle persistableBundle) {
        a.b(this);
        super.onCreate(bundle, persistableBundle);
    }

    @Override // android.app.Activity, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            pluginBaseFragmentActivity.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        } else {
            super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        }
    }

    @Override // android.app.Activity
    public CharSequence onCreateDescription() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.onCreateDescription();
        }
        return super.onCreateDescription();
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        return pluginBaseFragmentActivity != null ? (Dialog) d.k(pluginBaseFragmentActivity, "onCreateDialog", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(i2)}) : super.onCreateDialog(i2);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i2, Menu menu) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.onCreatePanelMenu(i2, menu);
        }
        return super.onCreatePanelMenu(i2, menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public View onCreatePanelView(int i2) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.onCreatePanelView(i2);
        }
        return super.onCreatePanelView(i2);
    }

    @Override // android.app.Activity
    public boolean onCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.onCreateThumbnail(bitmap, canvas);
        }
        return super.onCreateThumbnail(bitmap, canvas);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.onCreateView(str, context, attributeSet);
        }
        return super.onCreateView(str, context, attributeSet);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            d.k(pluginBaseFragmentActivity, MissionEvent.MESSAGE_DESTROY, new Class[0], new Object[0]);
        } else {
            super.onDestroy();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            pluginBaseFragmentActivity.onDetachedFromWindow();
        } else {
            super.onDetachedFromWindow();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.onKeyDown(i2, keyEvent);
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i2, KeyEvent keyEvent) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.onKeyLongPress(i2, keyEvent);
        }
        return super.onKeyLongPress(i2, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i2, int i3, KeyEvent keyEvent) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.onKeyMultiple(i2, i3, keyEvent);
        }
        return super.onKeyMultiple(i2, i3, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.onKeyUp(i2, keyEvent);
        }
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            pluginBaseFragmentActivity.onLowMemory();
        } else {
            super.onLowMemory();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.onMenuItemSelected(i2, menuItem);
        }
        return super.onMenuItemSelected(i2, menuItem);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i2, Menu menu) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.onMenuOpened(i2, menu);
        }
        return super.onMenuOpened(i2, menu);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            d.k(pluginBaseFragmentActivity, "onNewIntent", new Class[]{Intent.class}, new Object[]{intent});
        } else {
            super.onNewIntent(intent);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.onOptionsItemSelected(menuItem);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.app.Activity
    public void onOptionsMenuClosed(Menu menu) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            pluginBaseFragmentActivity.onOptionsMenuClosed(menu);
        } else {
            super.onOptionsMenuClosed(menu);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i2, Menu menu) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            pluginBaseFragmentActivity.onPanelClosed(i2, menu);
        } else {
            super.onPanelClosed(i2, menu);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            d.k(pluginBaseFragmentActivity, MissionEvent.MESSAGE_PAUSE, new Class[0], new Object[0]);
        } else {
            super.onPause();
        }
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            d.k(pluginBaseFragmentActivity, "onPostCreate", new Class[]{Bundle.class}, new Object[]{bundle});
        } else {
            super.onPostCreate(bundle);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPostResume() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            d.k(pluginBaseFragmentActivity, "onPostResume", new Class[0], new Object[0]);
        } else {
            super.onPostResume();
        }
    }

    @Override // d.a.c.a.i
    public void onPreLoad(q qVar) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            pluginBaseFragmentActivity.onPreLoad(qVar);
        }
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            pluginBaseFragmentActivity.onPrepareDialog(i2, dialog);
        } else {
            super.onPrepareDialog(i2, dialog);
        }
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.onPrepareOptionsMenu(menu);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i2, View view, Menu menu) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.onPreparePanel(i2, view, menu);
        }
        return super.onPreparePanel(i2, view, menu);
    }

    @Override // android.app.Activity
    public void onRestart() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            d.k(pluginBaseFragmentActivity, "onRestart", new Class[0], new Object[0]);
        } else {
            super.onRestart();
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            d.k(pluginBaseFragmentActivity, "onRestoreInstanceState", new Class[]{Bundle.class}, new Object[]{bundle});
        } else {
            super.onRestoreInstanceState(bundle);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            d.k(pluginBaseFragmentActivity, MissionEvent.MESSAGE_RESUME, new Class[0], new Object[0]);
        } else {
            super.onResume();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            d.k(pluginBaseFragmentActivity, "onSaveInstanceState", new Class[]{Bundle.class}, new Object[]{bundle});
        } else {
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.onSearchRequested();
        }
        return super.onSearchRequested();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            d.k(pluginBaseFragmentActivity, MissionEvent.MESSAGE_START, new Class[0], new Object[0]);
        } else {
            super.onStart();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            d.k(pluginBaseFragmentActivity, MissionEvent.MESSAGE_STOP, new Class[0], new Object[0]);
        } else {
            super.onStop();
        }
    }

    @Override // android.app.Activity
    public void onTitleChanged(CharSequence charSequence, int i2) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            d.k(pluginBaseFragmentActivity, "onTitleChanged", new Class[]{CharSequence.class, Integer.TYPE}, new Object[]{charSequence, Integer.valueOf(i2)});
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.onTrackballEvent(motionEvent);
        }
        return super.onTrackballEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void onUserInteraction() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            pluginBaseFragmentActivity.onUserInteraction();
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
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            pluginBaseFragmentActivity.onWindowAttributesChanged(layoutParams);
        } else {
            super.onWindowAttributesChanged(layoutParams);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            pluginBaseFragmentActivity.onWindowFocusChanged(z);
        } else {
            super.onWindowFocusChanged(z);
        }
    }

    @Override // android.app.Activity
    public void openContextMenu(View view) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            pluginBaseFragmentActivity.openContextMenu(view);
        } else {
            super.openContextMenu(view);
        }
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            pluginBaseFragmentActivity.openOptionsMenu();
        } else {
            super.openOptionsMenu();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i2, int i3) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            pluginBaseFragmentActivity.overridePendingTransition(i2, i3);
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
        return false;
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
        return super.getCallingActivity();
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
        return null;
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
        return null;
    }

    @Override // d.a.c.h.f.b
    public FragmentManager proxyGetSupportFragmentManager() {
        return super.getSupportFragmentManager();
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
        return 0;
    }

    @Override // d.a.c.h.f.a
    public int proxyGetWallpaperDesiredMinimumWidth() {
        return 0;
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

    @Override // d.a.c.h.f.b
    public void proxyOnAttachFragment(Fragment fragment) {
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

    @Override // d.a.c.h.f.b
    public void proxyStartActivityFromFragment(Fragment fragment, Intent intent, int i2) {
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
        return null;
    }

    @Override // d.a.c.h.f.a
    public void proxyStopManagingCursor(Cursor cursor) {
        super.stopManagingCursor(cursor);
    }

    @Override // d.a.c.h.f.a
    public boolean proxyStopService(Intent intent) {
        String stringExtra = intent.getStringExtra(Plugin.INTENT_EXTRA_SERVICE);
        d.a c2 = stringExtra != null ? d.a.c.h.d.a().c(stringExtra) : null;
        if (c2 != null && c2.f42829a != null) {
            if (d.a.c.h.d.a().b() == 1) {
                d.a.c.h.d.a().e(stringExtra);
                c2.f42829a.stopSelf();
                return true;
            }
            c2.f42829a.onDestroy();
            d.a.c.h.d.a().e(stringExtra);
            return true;
        }
        BdLog.d("service stop error!" + intent.toString());
        return false;
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
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            pluginBaseFragmentActivity.registerForContextMenu(view);
        } else {
            super.registerForContextMenu(view);
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i2) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            pluginBaseFragmentActivity.setContentView(i2);
        } else {
            super.setContentView(i2);
        }
    }

    @Override // android.app.Activity
    public void setIntent(Intent intent) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            pluginBaseFragmentActivity.setIntent(intent);
        } else {
            super.setIntent(intent);
        }
    }

    @Override // d.a.c.a.i
    public void setIsScroll(boolean z) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            pluginBaseFragmentActivity.setIsScroll(z);
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i2) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            pluginBaseFragmentActivity.setRequestedOrientation(i2);
        } else if (a.d(this) && a.a(i2)) {
        } else {
            super.setRequestedOrientation(i2);
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i2) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            pluginBaseFragmentActivity.setTheme(i2);
        }
    }

    @Override // android.app.Activity
    public void setTitle(int i2) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            pluginBaseFragmentActivity.setTitle(i2);
        } else {
            super.setTitle(i2);
        }
    }

    @Override // android.app.Activity
    public void setTitleColor(int i2) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            pluginBaseFragmentActivity.setTitleColor(i2);
        } else {
            super.setTitleColor(i2);
        }
    }

    @Override // android.app.Activity
    public void setVisible(boolean z) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            pluginBaseFragmentActivity.setVisible(z);
        } else {
            super.setVisible(z);
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            pluginBaseFragmentActivity.startActivity(intent);
        } else {
            super.startActivity(intent);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i2) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            pluginBaseFragmentActivity.startActivityForResult(intent, i2);
        } else {
            super.startActivityForResult(intent, i2);
        }
    }

    @Override // android.app.Activity
    public void startActivityFromChild(Activity activity, Intent intent, int i2) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            pluginBaseFragmentActivity.startActivityFromChild(activity, intent, i2);
        } else {
            super.startActivityFromChild(activity, intent, i2);
        }
    }

    @Override // android.app.Activity
    public boolean startActivityIfNeeded(Intent intent, int i2) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.startActivityIfNeeded(intent, i2);
        }
        return super.startActivityIfNeeded(intent, i2);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i2, int i3, int i4) throws IntentSender.SendIntentException {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            pluginBaseFragmentActivity.startIntentSender(intentSender, intent, i2, i3, i4);
        } else {
            super.startIntentSender(intentSender, intent, i2, i3, i4);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5) throws IntentSender.SendIntentException {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            pluginBaseFragmentActivity.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5);
        } else {
            super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5);
        }
    }

    @Override // android.app.Activity
    public void startManagingCursor(Cursor cursor) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            pluginBaseFragmentActivity.startManagingCursor(cursor);
        } else {
            super.startManagingCursor(cursor);
        }
    }

    @Override // android.app.Activity
    public boolean startNextMatchingActivity(Intent intent) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.startNextMatchingActivity(intent);
        }
        return super.startNextMatchingActivity(intent);
    }

    @Override // android.app.Activity
    public void startSearch(String str, boolean z, Bundle bundle, boolean z2) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            pluginBaseFragmentActivity.startSearch(str, z, bundle, z2);
        } else {
            super.startSearch(str, z, bundle, z2);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ComponentName startService(Intent intent) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.startService(intent);
        }
        return null;
    }

    @Override // android.app.Activity
    public void stopManagingCursor(Cursor cursor) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            pluginBaseFragmentActivity.stopManagingCursor(cursor);
        } else {
            super.stopManagingCursor(cursor);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean stopService(Intent intent) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            return pluginBaseFragmentActivity.stopService(intent);
        }
        return false;
    }

    @Override // android.app.Activity
    public void takeKeyEvents(boolean z) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            pluginBaseFragmentActivity.takeKeyEvents(z);
        } else {
            super.takeKeyEvents(z);
        }
    }

    @Override // android.app.Activity
    public void unregisterForContextMenu(View view) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            pluginBaseFragmentActivity.unregisterForContextMenu(view);
        } else {
            super.unregisterForContextMenu(view);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.h.f.a
    public PluginBaseFragmentActivity getTarget() {
        return this.mEntity;
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

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        this.mEntity = null;
        loadEntityActivity();
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            d.a.c.h.k.d.k(pluginBaseFragmentActivity, MissionEvent.MESSAGE_CREATE, new Class[]{Bundle.class}, new Object[]{bundle});
        } else {
            super.onCreate(bundle);
        }
    }

    @Override // d.a.c.h.f.a
    public void proxySetContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            pluginBaseFragmentActivity.setContentView(view);
        } else {
            super.setContentView(view);
        }
    }

    @Override // android.app.Activity
    public void setTitle(CharSequence charSequence) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            pluginBaseFragmentActivity.setTitle(charSequence);
        } else {
            super.setTitle(charSequence);
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        PluginBaseFragmentActivity pluginBaseFragmentActivity = this.mEntity;
        if (pluginBaseFragmentActivity != null) {
            pluginBaseFragmentActivity.setContentView(view, layoutParams);
        } else {
            super.setContentView(view, layoutParams);
        }
    }
}
