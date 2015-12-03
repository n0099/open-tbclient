package com.baidu.adp.plugin.proxy.activity;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
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
import com.baidu.adp.base.h;
import com.baidu.adp.base.i;
import com.baidu.adp.base.j;
import com.baidu.adp.base.k;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.pluginBase.c;
import com.baidu.adp.plugin.util.f;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.megapp.ma.MAActivity;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes.dex */
public class ActivityProxy extends MAActivity implements Handler.Callback, i, k, com.baidu.adp.plugin.a.a {
    private c ER = null;

    public void mz() {
        if (this.ER == null && !super.isFinishing()) {
            Intent intent = getIntent();
            if (intent == null) {
                finish();
                return;
            }
            String stringExtra = intent.getStringExtra("intent_extra_package_name");
            if (!PluginCenter.getInstance().isLoaded(stringExtra)) {
                finish();
                BdLog.e("plugin not loaded. pluginname is " + stringExtra);
                return;
            }
            try {
                String stringExtra2 = intent.getStringExtra("intent_extra_activity");
                if (BdBaseApplication.getInst().getIsPluginResourcOpen()) {
                    com.baidu.adp.plugin.a plugin2 = PluginCenter.getInstance().getPlugin(stringExtra);
                    this.ER = (c) plugin2.ks().loadClass(stringExtra2).asSubclass(c.class).newInstance();
                    this.ER.setActivityProxy(this);
                    this.ER.setPluginPackageName(stringExtra);
                    setTheme(plugin2.kv());
                } else {
                    this.ER = (c) PluginCenter.getInstance().getPlugin(stringExtra).ks().loadClass(stringExtra2).asSubclass(c.class).newInstance();
                    this.ER.setActivityProxy(this);
                    this.ER.setPluginPackageName(stringExtra);
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

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.ER != null) {
            this.ER.addContentView(view, layoutParams);
        } else {
            super.addContentView(view, layoutParams);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i) {
        return this.ER != null ? this.ER.bindService(intent, serviceConnection, i) : super.bindService(intent, serviceConnection, i);
    }

    @Override // android.app.Activity
    public void closeContextMenu() {
        if (this.ER != null) {
            this.ER.closeContextMenu();
        } else {
            super.closeContextMenu();
        }
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        if (this.ER != null) {
            this.ER.closeOptionsMenu();
        } else {
            super.closeOptionsMenu();
        }
    }

    @Override // android.app.Activity
    public PendingIntent createPendingResult(int i, Intent intent, int i2) {
        return this.ER != null ? this.ER.createPendingResult(i, intent, i2) : super.createPendingResult(i, intent, i2);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if (this.ER != null) {
            return this.ER.dispatchGenericMotionEvent(motionEvent);
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.ER != null ? this.ER.dispatchKeyEvent(keyEvent) : super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        if (this.ER != null) {
            return this.ER.dispatchKeyShortcutEvent(keyEvent);
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.ER != null ? this.ER.dispatchPopulateAccessibilityEvent(accessibilityEvent) : super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.ER != null ? this.ER.dispatchTouchEvent(motionEvent) : super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.ER != null ? this.ER.dispatchTrackballEvent(motionEvent) : super.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    @Override // android.app.Activity
    public View findViewById(int i) {
        return this.ER != null ? this.ER.findViewById(i) : super.findViewById(i);
    }

    @Override // android.app.Activity
    public void finish() {
        if (this.ER != null) {
            this.ER.finish();
        } else {
            super.finish();
        }
    }

    @Override // android.app.Activity
    public void finishActivity(int i) {
        if (this.ER != null) {
            this.ER.finishActivity(i);
        } else {
            super.finishActivity(i);
        }
    }

    @Override // android.app.Activity
    public void finishActivityFromChild(Activity activity, int i) {
        if (this.ER != null) {
            this.ER.finishActivityFromChild(activity, i);
        } else {
            super.finishActivityFromChild(activity, i);
        }
    }

    @Override // android.app.Activity
    public void finishFromChild(Activity activity) {
        if (this.ER != null) {
            this.ER.finishFromChild(activity);
        } else {
            super.finishFromChild(activity);
        }
    }

    @Override // com.baidu.megapp.ma.MAActivity, com.baidu.adp.plugin.a.a
    public Activity getActivity() {
        return super.getActivity();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.ER != null ? this.ER.getAssets() : super.getAssets();
    }

    @Override // android.app.Activity
    public ComponentName getCallingActivity() {
        return this.ER != null ? this.ER.getCallingActivity() : super.getCallingActivity();
    }

    @Override // android.app.Activity
    public String getCallingPackage() {
        return this.ER != null ? this.ER.getCallingPackage() : super.getCallingPackage();
    }

    @Override // android.app.Activity
    public int getChangingConfigurations() {
        return -1;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ClassLoader getClassLoader() {
        return this.ER != null ? this.ER.getClassLoader() : super.getClassLoader();
    }

    @Override // android.app.Activity
    public View getCurrentFocus() {
        return this.ER != null ? this.ER.getCurrentFocus() : super.getCurrentFocus();
    }

    @Override // android.app.Activity
    public Intent getIntent() {
        c cVar = this.ER;
        return cVar != null ? cVar.getIntent() : super.getIntent();
    }

    @Override // android.app.Activity
    public LayoutInflater getLayoutInflater() {
        c cVar = this.ER;
        return cVar != null ? cVar.getLayoutInflater() : super.getLayoutInflater();
    }

    @Override // android.app.Activity
    public String getLocalClassName() {
        c cVar = this.ER;
        return cVar != null ? cVar.getLocalClassName() : super.getLocalClassName();
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return this.ER != null ? this.ER.getMenuInflater() : super.getMenuInflater();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public PackageManager getPackageManager() {
        return this.ER != null ? this.ER.getPackageManager() : super.getPackageManager();
    }

    @Override // android.app.Activity
    public SharedPreferences getPreferences(int i) {
        return this.ER != null ? this.ER.getPreferences(i) : super.getPreferences(i);
    }

    @Override // android.app.Activity
    public int getRequestedOrientation() {
        return this.ER != null ? this.ER.getRequestedOrientation() : super.getRequestedOrientation();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (BdBaseApplication.getInst().getIsPluginResourcOpen()) {
            if (this.ER != null) {
                return this.ER.getResources();
            }
        } else {
            Resources resources = j.dK().getResources();
            if (resources != null) {
                return resources;
            }
        }
        return super.getResources();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i) {
        return this.ER != null ? this.ER.getSharedPreferences(str, i) : super.getSharedPreferences(str, i);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        return this.ER != null ? this.ER.getSystemService(str) : super.getSystemService(str);
    }

    @Override // android.app.Activity
    public int getTaskId() {
        c cVar = this.ER;
        return cVar != null ? cVar.getTaskId() : super.getTaskId();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int getWallpaperDesiredMinimumHeight() {
        c cVar = this.ER;
        return cVar != null ? cVar.getWallpaperDesiredMinimumHeight() : super.getWallpaperDesiredMinimumHeight();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int getWallpaperDesiredMinimumWidth() {
        c cVar = this.ER;
        return cVar != null ? cVar.getWallpaperDesiredMinimumWidth() : super.getWallpaperDesiredMinimumWidth();
    }

    @Override // android.app.Activity
    public Window getWindow() {
        c cVar = this.ER;
        return cVar != null ? cVar.getWindow() : super.getWindow();
    }

    @Override // android.app.Activity
    public WindowManager getWindowManager() {
        c cVar = this.ER;
        return cVar != null ? cVar.getWindowManager() : super.getWindowManager();
    }

    @Override // android.app.Activity
    public boolean hasWindowFocus() {
        return this.ER != null ? this.ER.hasWindowFocus() : super.hasWindowFocus();
    }

    @Override // android.app.Activity
    public boolean isFinishing() {
        return this.ER != null ? this.ER.isFinishing() : super.isFinishing();
    }

    @Override // android.app.Activity
    public boolean isTaskRoot() {
        c cVar = this.ER;
        return cVar != null ? cVar.isTaskRoot() : super.isTaskRoot();
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        c cVar = this.ER;
        return cVar != null ? cVar.moveTaskToBack(z) : super.moveTaskToBack(z);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (this.ER != null) {
            f.a(this.ER, "onActivityResult", new Class[]{Integer.TYPE, Integer.TYPE, Intent.class}, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent});
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper
    protected void onApplyThemeResource(Resources.Theme theme, int i, boolean z) {
        if (this.ER != null) {
            f.a(this.ER, "onApplyThemeResource", new Class[]{Resources.Theme.class, Integer.TYPE, Boolean.TYPE}, new Object[]{theme, Integer.valueOf(i), Boolean.valueOf(z)});
        } else {
            super.onApplyThemeResource(theme, i, z);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        if (this.ER != null) {
            this.ER.onAttachedToWindow();
        } else {
            super.onAttachedToWindow();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.ER != null) {
            this.ER.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    protected void onChildTitleChanged(Activity activity, CharSequence charSequence) {
        if (this.ER != null) {
            f.a(this.ER, "onChildTitleChanged", new Class[]{Activity.class, CharSequence.class}, new Object[]{activity, charSequence});
        } else {
            super.onChildTitleChanged(activity, charSequence);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        if (this.ER != null) {
            this.ER.onConfigurationChanged(configuration);
        } else {
            super.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        if (this.ER != null) {
            this.ER.onContentChanged();
        } else {
            super.onContentChanged();
        }
    }

    @Override // android.app.Activity
    public boolean onContextItemSelected(MenuItem menuItem) {
        return this.ER != null ? this.ER.onContextItemSelected(menuItem) : super.onContextItemSelected(menuItem);
    }

    @Override // android.app.Activity
    public void onContextMenuClosed(Menu menu) {
        if (this.ER != null) {
            this.ER.onContextMenuClosed(menu);
        } else {
            super.onContextMenuClosed(menu);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        this.ER = null;
        mz();
        if (this.ER != null) {
            f.a(this.ER, "onCreate", new Class[]{Bundle.class}, new Object[]{bundle});
        } else {
            super.onCreate(bundle);
        }
    }

    @Override // android.app.Activity, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        if (this.ER != null) {
            this.ER.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        } else {
            super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        }
    }

    @Override // android.app.Activity
    public CharSequence onCreateDescription() {
        c cVar = this.ER;
        return cVar != null ? cVar.onCreateDescription() : super.onCreateDescription();
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        return this.ER != null ? (Dialog) f.a(this.ER, "onCreateDialog", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(i)}) : super.onCreateDialog(i);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        return this.ER != null ? this.ER.onCreatePanelMenu(i, menu) : super.onCreatePanelMenu(i, menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public View onCreatePanelView(int i) {
        return this.ER != null ? this.ER.onCreatePanelView(i) : super.onCreatePanelView(i);
    }

    @Override // android.app.Activity
    public boolean onCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        return this.ER != null ? this.ER.onCreateThumbnail(bitmap, canvas) : super.onCreateThumbnail(bitmap, canvas);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return this.ER != null ? this.ER.onCreateView(str, context, attributeSet) : super.onCreateView(str, context, attributeSet);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        if (this.ER != null) {
            f.a(this.ER, "onDestroy", new Class[0], new Object[0]);
        } else {
            super.onDestroy();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        if (this.ER != null) {
            this.ER.onDetachedFromWindow();
        } else {
            super.onDetachedFromWindow();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.ER != null ? this.ER.onKeyDown(i, keyEvent) : super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        return this.ER != null ? this.ER.onKeyLongPress(i, keyEvent) : super.onKeyLongPress(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return this.ER != null ? this.ER.onKeyMultiple(i, i2, keyEvent) : super.onKeyMultiple(i, i2, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.ER != null ? this.ER.onKeyUp(i, keyEvent) : super.onKeyUp(i, keyEvent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        if (this.ER != null) {
            this.ER.onLowMemory();
        } else {
            super.onLowMemory();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return this.ER != null ? this.ER.onMenuItemSelected(i, menuItem) : super.onMenuItemSelected(i, menuItem);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        return this.ER != null ? this.ER.onMenuOpened(i, menu) : super.onMenuOpened(i, menu);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        if (this.ER != null) {
            f.a(this.ER, "onNewIntent", new Class[]{Intent.class}, new Object[]{intent});
        } else {
            super.onNewIntent(intent);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return this.ER != null ? this.ER.onOptionsItemSelected(menuItem) : super.onOptionsItemSelected(menuItem);
    }

    @Override // android.app.Activity
    public void onOptionsMenuClosed(Menu menu) {
        if (this.ER != null) {
            this.ER.onOptionsMenuClosed(menu);
        } else {
            super.onOptionsMenuClosed(menu);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        if (this.ER != null) {
            this.ER.onPanelClosed(i, menu);
        } else {
            super.onPanelClosed(i, menu);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        if (this.ER != null) {
            f.a(this.ER, "onPause", new Class[0], new Object[0]);
        } else {
            super.onPause();
        }
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        if (this.ER != null) {
            f.a(this.ER, "onPostCreate", new Class[]{Bundle.class}, new Object[]{bundle});
        } else {
            super.onPostCreate(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        if (this.ER != null) {
            f.a(this.ER, "onPostResume", new Class[0], new Object[0]);
        } else {
            super.onPostResume();
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
        if (this.ER != null) {
            this.ER.onPrepareDialog(i, dialog);
        } else {
            super.onPrepareDialog(i, dialog);
        }
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        return this.ER != null ? this.ER.onPrepareOptionsMenu(menu) : super.onPrepareOptionsMenu(menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        return this.ER != null ? this.ER.onPreparePanel(i, view, menu) : super.onPreparePanel(i, view, menu);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        if (this.ER != null) {
            f.a(this.ER, "onRestart", new Class[0], new Object[0]);
        } else {
            super.onRestart();
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        if (this.ER != null) {
            f.a(this.ER, "onRestoreInstanceState", new Class[]{Bundle.class}, new Object[]{bundle});
        } else {
            super.onRestoreInstanceState(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        if (this.ER != null) {
            f.a(this.ER, "onResume", new Class[0], new Object[0]);
        } else {
            super.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.ER != null) {
            f.a(this.ER, "onSaveInstanceState", new Class[]{Bundle.class}, new Object[]{bundle});
        } else {
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        return this.ER != null ? this.ER.onSearchRequested() : super.onSearchRequested();
    }

    @Override // android.app.Activity
    protected void onStart() {
        if (this.ER != null) {
            f.a(this.ER, "onStart", new Class[0], new Object[0]);
        } else {
            super.onStart();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        if (this.ER != null) {
            f.a(this.ER, "onStop", new Class[0], new Object[0]);
        } else {
            super.onStop();
        }
    }

    @Override // android.app.Activity
    protected void onTitleChanged(CharSequence charSequence, int i) {
        if (this.ER != null) {
            f.a(this.ER, "onTitleChanged", new Class[]{CharSequence.class, Integer.TYPE}, new Object[]{charSequence, Integer.valueOf(i)});
        } else {
            super.onTitleChanged(charSequence, i);
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.ER != null ? this.ER.onTouchEvent(motionEvent) : super.onTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        return this.ER != null ? this.ER.onTrackballEvent(motionEvent) : super.onTrackballEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void onUserInteraction() {
        if (this.ER != null) {
            this.ER.onUserInteraction();
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
        if (this.ER != null) {
            this.ER.onWindowAttributesChanged(layoutParams);
        } else {
            super.onWindowAttributesChanged(layoutParams);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        if (this.ER != null) {
            this.ER.onWindowFocusChanged(z);
        } else {
            super.onWindowFocusChanged(z);
        }
    }

    @Override // android.app.Activity
    public void openContextMenu(View view) {
        if (this.ER != null) {
            this.ER.openContextMenu(view);
        } else {
            super.openContextMenu(view);
        }
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        if (this.ER != null) {
            this.ER.openOptionsMenu();
        } else {
            super.openOptionsMenu();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        if (this.ER != null) {
            this.ER.overridePendingTransition(i, i2);
        } else {
            super.overridePendingTransition(i, i2);
        }
    }

    @Override // com.baidu.adp.plugin.a.a
    public void a(View view, ViewGroup.LayoutParams layoutParams) {
        super.addContentView(view, layoutParams);
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean proxyBindService(Intent intent, ServiceConnection serviceConnection, int i) {
        return super.bindService(intent, serviceConnection, i);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void kH() {
        super.closeContextMenu();
    }

    @Override // com.baidu.adp.plugin.a.a
    public void kI() {
        super.closeOptionsMenu();
    }

    @Override // com.baidu.adp.plugin.a.a
    public PendingIntent a(int i, Intent intent, int i2) {
        return super.createPendingResult(i, intent, i2);
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean b(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean a(AccessibilityEvent accessibilityEvent) {
        return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean b(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean c(MotionEvent motionEvent) {
        return super.dispatchTrackballEvent(motionEvent);
    }

    @Override // com.baidu.adp.plugin.a.a
    public View ao(int i) {
        return super.findViewById(i);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void kJ() {
        super.finish();
    }

    @Override // com.baidu.adp.plugin.a.a
    public void ap(int i) {
        super.finishActivity(i);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void a(Activity activity, int i) {
        super.finishActivityFromChild(activity, i);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void m(Activity activity) {
        super.finishFromChild(activity);
    }

    @Override // com.baidu.adp.plugin.a.a
    public ComponentName kL() {
        return null;
    }

    @Override // com.baidu.adp.plugin.a.a
    public String kM() {
        return super.getCallingPackage();
    }

    @Override // com.baidu.adp.plugin.a.a
    public int kN() {
        return super.getChangingConfigurations();
    }

    @Override // com.baidu.adp.plugin.a.a
    public View kO() {
        return super.getCurrentFocus();
    }

    @Override // com.baidu.adp.plugin.a.a
    public Intent kP() {
        return super.getIntent();
    }

    @Override // com.baidu.adp.plugin.a.a
    public LayoutInflater kQ() {
        return super.getLayoutInflater();
    }

    @Override // com.baidu.adp.plugin.a.a
    public String kR() {
        return super.getLocalClassName();
    }

    @Override // com.baidu.adp.plugin.a.a
    public MenuInflater kS() {
        return super.getMenuInflater();
    }

    @Override // com.baidu.adp.plugin.a.a
    public PackageManager proxyGetPackageManager() {
        return super.getPackageManager();
    }

    @Override // com.baidu.adp.plugin.a.a
    public SharedPreferences aq(int i) {
        return super.getPreferences(i);
    }

    @Override // com.baidu.adp.plugin.a.a
    public int kT() {
        return super.getRequestedOrientation();
    }

    @Override // com.baidu.adp.plugin.a.a
    public Object be(String str) {
        return super.getSystemService(str);
    }

    @Override // com.baidu.adp.plugin.a.a
    public int kU() {
        return super.getTaskId();
    }

    @Override // com.baidu.adp.plugin.a.a
    public int kV() {
        return super.getWallpaperDesiredMinimumHeight();
    }

    @Override // com.baidu.adp.plugin.a.a
    public int kW() {
        return super.getWallpaperDesiredMinimumWidth();
    }

    @Override // com.baidu.adp.plugin.a.a
    public Window kX() {
        return super.getWindow();
    }

    @Override // com.baidu.adp.plugin.a.a
    public WindowManager kY() {
        return super.getWindowManager();
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean kZ() {
        return super.hasWindowFocus();
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean la() {
        return super.isFinishing();
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean lb() {
        return super.isTaskRoot();
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean H(boolean z) {
        return super.moveTaskToBack(z);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void a(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void a(Resources.Theme theme, int i, boolean z) {
        super.onApplyThemeResource(theme, i, z);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void lc() {
        super.onAttachedToWindow();
    }

    @Override // com.baidu.adp.plugin.a.a
    public void ld() {
        super.onBackPressed();
    }

    @Override // com.baidu.adp.plugin.a.a
    public void a(Activity activity, CharSequence charSequence) {
        super.onChildTitleChanged(activity, charSequence);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyOnConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void le() {
        super.onContentChanged();
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean a(MenuItem menuItem) {
        return super.onContextItemSelected(menuItem);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void a(Menu menu) {
        super.onContextMenuClosed(menu);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void b(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void a(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean a(int i, Menu menu) {
        return super.onCreatePanelMenu(i, menu);
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean b(Bitmap bitmap, Canvas canvas) {
        return super.onCreateThumbnail(bitmap, canvas);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyOnDestroy() {
        super.onDestroy();
    }

    @Override // com.baidu.adp.plugin.a.a
    public void lf() {
        super.onDetachedFromWindow();
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean a(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean b(int i, KeyEvent keyEvent) {
        return super.onKeyLongPress(i, keyEvent);
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean a(int i, int i2, KeyEvent keyEvent) {
        return super.onKeyMultiple(i, i2, keyEvent);
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean c(int i, KeyEvent keyEvent) {
        return super.onKeyUp(i, keyEvent);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyOnLowMemory() {
        super.onLowMemory();
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean a(int i, MenuItem menuItem) {
        return super.onMenuItemSelected(i, menuItem);
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean b(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean b(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void b(Menu menu) {
        super.onOptionsMenuClosed(menu);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void c(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void lg() {
        super.onPause();
    }

    @Override // com.baidu.adp.plugin.a.a
    public void c(Bundle bundle) {
        super.onPostCreate(bundle);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void lh() {
        super.onPostResume();
    }

    @Override // com.baidu.adp.plugin.a.a
    public void a(int i, Dialog dialog) {
        super.onPrepareDialog(i, dialog);
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean c(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean a(int i, View view, Menu menu) {
        return super.onPreparePanel(i, view, menu);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void li() {
        super.onRestart();
    }

    @Override // com.baidu.adp.plugin.a.a
    public void d(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void lj() {
        super.onResume();
    }

    @Override // com.baidu.adp.plugin.a.a
    public Object lk() {
        return super.onRetainNonConfigurationInstance();
    }

    @Override // com.baidu.adp.plugin.a.a
    public void e(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean ll() {
        return super.onSearchRequested();
    }

    @Override // com.baidu.adp.plugin.a.a
    public void lm() {
        super.onStart();
    }

    @Override // com.baidu.adp.plugin.a.a
    public void ln() {
        super.onStop();
    }

    @Override // com.baidu.adp.plugin.a.a
    public void b(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean d(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean e(MotionEvent motionEvent) {
        return super.onTrackballEvent(motionEvent);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void lo() {
        super.onUserInteraction();
    }

    @Override // com.baidu.adp.plugin.a.a
    public void a(WindowManager.LayoutParams layoutParams) {
        super.onWindowAttributesChanged(layoutParams);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void I(boolean z) {
        super.onWindowFocusChanged(z);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyOpenContextMenu(View view) {
        super.openContextMenu(view);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void lp() {
        super.openOptionsMenu();
    }

    @Override // com.baidu.adp.plugin.a.a
    public void e(int i, int i2) {
        super.overridePendingTransition(i, i2);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyRegisterForContextMenu(View view) {
        super.registerForContextMenu(view);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void ar(int i) {
        super.setContentView(i);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxySetContentView(View view) {
        super.setContentView(view);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void b(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void E(Intent intent) {
        super.setIntent(intent);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void as(int i) {
        super.setRequestedOrientation(i);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void at(int i) {
        super.setTitle(i);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void b(CharSequence charSequence) {
        super.setTitle(charSequence);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void au(int i) {
        super.setTitleColor(i);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void J(boolean z) {
        super.setVisible(z);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyStartActivity(Intent intent) {
        super.startActivity(intent);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void b(Intent intent, int i) {
        super.startActivityForResult(intent, i);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void a(Activity activity, Intent intent, int i) {
        super.startActivityFromChild(activity, intent, i);
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean c(Intent intent, int i) {
        return super.startActivityIfNeeded(intent, i);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void a(IntentSender intentSender, Intent intent, int i, int i2, int i3) {
        super.startIntentSender(intentSender, intent, i, i2, i3);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void a(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void c(Cursor cursor) {
        super.startManagingCursor(cursor);
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean F(Intent intent) {
        return super.startNextMatchingActivity(intent);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void a(String str, boolean z, Bundle bundle, boolean z2) {
        super.startSearch(str, z, bundle, z2);
    }

    @Override // com.baidu.adp.plugin.a.a
    public ComponentName proxyStartService(Intent intent) {
        return super.startService(intent);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void d(Cursor cursor) {
        super.stopManagingCursor(cursor);
    }

    @Override // com.baidu.adp.plugin.a.a
    public boolean proxyStopService(Intent intent) {
        return super.stopService(intent);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void K(boolean z) {
        super.takeKeyEvents(z);
    }

    @Override // com.baidu.adp.plugin.a.a
    public void proxyUnregisterForContextMenu(View view) {
        super.unregisterForContextMenu(view);
    }

    @Override // android.app.Activity
    public void registerForContextMenu(View view) {
        if (this.ER != null) {
            this.ER.registerForContextMenu(view);
        } else {
            super.registerForContextMenu(view);
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        if (this.ER != null) {
            this.ER.setContentView(i);
        } else {
            super.setContentView(i);
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        if (this.ER != null) {
            this.ER.setContentView(view);
        } else {
            super.setContentView(view);
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.ER != null) {
            this.ER.setContentView(view, layoutParams);
        } else {
            super.setContentView(view, layoutParams);
        }
    }

    @Override // android.app.Activity
    public void setIntent(Intent intent) {
        if (this.ER != null) {
            this.ER.setIntent(intent);
        } else {
            super.setIntent(intent);
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i) {
        if (this.ER != null) {
            this.ER.setRequestedOrientation(i);
        } else {
            super.setRequestedOrientation(i);
        }
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        return this.ER != null ? this.ER.getTheme() : super.getTheme();
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (this.ER != null) {
            this.ER.setTheme(i);
        } else {
            super.setTheme(i);
        }
    }

    @Override // android.app.Activity
    public void setTitle(int i) {
        if (this.ER != null) {
            this.ER.setTitle(i);
        } else {
            super.setTitle(i);
        }
    }

    @Override // android.app.Activity
    public void setTitle(CharSequence charSequence) {
        if (this.ER != null) {
            this.ER.setTitle(charSequence);
        } else {
            super.setTitle(charSequence);
        }
    }

    @Override // android.app.Activity
    public void setTitleColor(int i) {
        if (this.ER != null) {
            this.ER.setTitleColor(i);
        } else {
            super.setTitleColor(i);
        }
    }

    @Override // android.app.Activity
    public void setVisible(boolean z) {
        if (this.ER != null) {
            this.ER.setVisible(z);
        } else {
            super.setVisible(z);
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        if (this.ER != null) {
            this.ER.startActivity(intent);
        } else {
            super.startActivity(intent);
        }
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i) {
        if (this.ER != null) {
            this.ER.startActivityForResult(intent, i);
        } else {
            super.startActivityForResult(intent, i);
        }
    }

    @Override // android.app.Activity
    public void startActivityFromChild(Activity activity, Intent intent, int i) {
        if (this.ER != null) {
            this.ER.startActivityFromChild(activity, intent, i);
        } else {
            super.startActivityFromChild(activity, intent, i);
        }
    }

    @Override // android.app.Activity
    public boolean startActivityIfNeeded(Intent intent, int i) {
        return this.ER != null ? this.ER.startActivityIfNeeded(intent, i) : super.startActivityIfNeeded(intent, i);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i, int i2, int i3) {
        if (this.ER != null) {
            this.ER.startIntentSender(intentSender, intent, i, i2, i3);
        } else {
            super.startIntentSender(intentSender, intent, i, i2, i3);
        }
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        if (this.ER != null) {
            this.ER.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
        } else {
            super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
        }
    }

    @Override // android.app.Activity
    public void startManagingCursor(Cursor cursor) {
        if (this.ER != null) {
            this.ER.startManagingCursor(cursor);
        } else {
            super.startManagingCursor(cursor);
        }
    }

    @Override // android.app.Activity
    public boolean startNextMatchingActivity(Intent intent) {
        c cVar = this.ER;
        return cVar != null ? cVar.startNextMatchingActivity(intent) : super.startNextMatchingActivity(intent);
    }

    @Override // android.app.Activity
    public void startSearch(String str, boolean z, Bundle bundle, boolean z2) {
        if (this.ER != null) {
            this.ER.startSearch(str, z, bundle, z2);
        } else {
            super.startSearch(str, z, bundle, z2);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ComponentName startService(Intent intent) {
        return this.ER != null ? this.ER.startService(intent) : super.startService(intent);
    }

    @Override // android.app.Activity
    public void stopManagingCursor(Cursor cursor) {
        if (this.ER != null) {
            this.ER.stopManagingCursor(cursor);
        } else {
            super.stopManagingCursor(cursor);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean stopService(Intent intent) {
        return this.ER != null ? this.ER.stopService(intent) : super.stopService(intent);
    }

    @Override // android.app.Activity
    public void takeKeyEvents(boolean z) {
        if (this.ER != null) {
            this.ER.takeKeyEvents(z);
        } else {
            super.takeKeyEvents(z);
        }
    }

    @Override // android.app.Activity
    public void unregisterForContextMenu(View view) {
        if (this.ER != null) {
            this.ER.unregisterForContextMenu(view);
        } else {
            super.unregisterForContextMenu(view);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context, com.baidu.adp.plugin.a.a
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        return super.registerReceiver(broadcastReceiver, intentFilter);
    }

    @Override // android.content.ContextWrapper, android.content.Context, com.baidu.adp.plugin.a.a
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        super.unregisterReceiver(broadcastReceiver);
    }

    @Override // com.baidu.adp.plugin.a.a
    public c kG() {
        return this.ER;
    }

    @Override // com.baidu.adp.plugin.a.a
    public SharedPreferences proxyGetSharedPreferences(String str, int i) {
        return super.getSharedPreferences(str, i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return this.ER != null ? this.ER.getApplicationContext() : super.getApplicationContext();
    }

    @Override // com.baidu.adp.plugin.a.a
    public Context kK() {
        return super.getApplicationContext();
    }

    @Override // com.baidu.adp.base.k
    public BdUniqueId getUniqueId() {
        if (this.ER != null) {
            return this.ER.getUniqueId();
        }
        return null;
    }

    @Override // com.baidu.adp.base.k
    public boolean isScroll() {
        if (this.ER != null) {
            return this.ER.isScroll();
        }
        return false;
    }

    @Override // com.baidu.adp.base.k
    public void setIsScroll(boolean z) {
        if (this.ER != null) {
            this.ER.setIsScroll(z);
        }
    }

    @Override // com.baidu.adp.base.k
    public void onPreLoad(BdListView bdListView) {
        if (this.ER != null) {
            this.ER.onPreLoad(bdListView);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (this.ER != null) {
            return this.ER.handleMessage(message);
        }
        return false;
    }

    @Override // com.baidu.adp.base.i
    public h getPageContext() {
        if (this.ER == null || !(this.ER instanceof i)) {
            return null;
        }
        return this.ER.getPageContext();
    }
}
