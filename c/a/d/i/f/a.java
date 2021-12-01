package c.a.d.i.f;

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
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
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
import com.baidu.adp.plugin.pluginBase.PluginBaseActivity;
/* loaded from: classes.dex */
public interface a {
    Activity getActivity();

    PluginBaseActivity getTarget();

    void proxyAddContentView(View view, ViewGroup.LayoutParams layoutParams);

    boolean proxyBindService(Intent intent, ServiceConnection serviceConnection, int i2);

    void proxyCloseContextMenu();

    void proxyCloseOptionsMenu();

    PendingIntent proxyCreatePendingResult(int i2, Intent intent, int i3);

    boolean proxyDispatchGenericMotionEvent(MotionEvent motionEvent);

    boolean proxyDispatchKeyEvent(KeyEvent keyEvent);

    boolean proxyDispatchKeyShortcutEvent(KeyEvent keyEvent);

    boolean proxyDispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent);

    boolean proxyDispatchTouchEvent(MotionEvent motionEvent);

    boolean proxyDispatchTrackballEvent(MotionEvent motionEvent);

    View proxyFindViewById(int i2);

    void proxyFinish();

    void proxyFinishActivity(int i2);

    void proxyFinishActivityFromChild(Activity activity, int i2);

    void proxyFinishFromChild(Activity activity);

    Context proxyGetApplicationContext();

    ComponentName proxyGetCallingActivity();

    String proxyGetCallingPackage();

    int proxyGetChangingConfigurations();

    View proxyGetCurrentFocus();

    Intent proxyGetIntent();

    LayoutInflater proxyGetLayoutInflater();

    String proxyGetLocalClassName();

    MenuInflater proxyGetMenuInflater();

    PackageManager proxyGetPackageManager();

    SharedPreferences proxyGetPreferences(int i2);

    int proxyGetRequestedOrientation();

    SharedPreferences proxyGetSharedPreferences(String str, int i2);

    Object proxyGetSystemService(String str);

    int proxyGetTaskId();

    int proxyGetWallpaperDesiredMinimumHeight();

    int proxyGetWallpaperDesiredMinimumWidth();

    Window proxyGetWindow();

    WindowManager proxyGetWindowManager();

    boolean proxyHasWindowFocus();

    boolean proxyIsFinishing();

    boolean proxyIsTaskRoot();

    boolean proxyMoveTaskToBack(boolean z);

    void proxyOnActivityResult(int i2, int i3, Intent intent);

    void proxyOnApplyThemeResource(Resources.Theme theme, int i2, boolean z);

    void proxyOnAttachedToWindow();

    void proxyOnBackPressed();

    void proxyOnChildTitleChanged(Activity activity, CharSequence charSequence);

    void proxyOnConfigurationChanged(Configuration configuration);

    void proxyOnContentChanged();

    boolean proxyOnContextItemSelected(MenuItem menuItem);

    void proxyOnContextMenuClosed(Menu menu);

    void proxyOnCreate(Bundle bundle);

    void proxyOnCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo);

    boolean proxyOnCreatePanelMenu(int i2, Menu menu);

    boolean proxyOnCreateThumbnail(Bitmap bitmap, Canvas canvas);

    View proxyOnCreateView(View view, String str, Context context, AttributeSet attributeSet);

    View proxyOnCreateView(String str, Context context, AttributeSet attributeSet);

    void proxyOnDestroy();

    void proxyOnDetachedFromWindow();

    boolean proxyOnKeyDown(int i2, KeyEvent keyEvent);

    boolean proxyOnKeyLongPress(int i2, KeyEvent keyEvent);

    boolean proxyOnKeyMultiple(int i2, int i3, KeyEvent keyEvent);

    boolean proxyOnKeyUp(int i2, KeyEvent keyEvent);

    void proxyOnLowMemory();

    boolean proxyOnMenuItemSelected(int i2, MenuItem menuItem);

    boolean proxyOnMenuOpened(int i2, Menu menu);

    boolean proxyOnOptionsItemSelected(MenuItem menuItem);

    void proxyOnOptionsMenuClosed(Menu menu);

    void proxyOnPanelClosed(int i2, Menu menu);

    void proxyOnPause();

    void proxyOnPostCreate(Bundle bundle);

    void proxyOnPostResume();

    void proxyOnPrepareDialog(int i2, Dialog dialog);

    boolean proxyOnPrepareOptionsMenu(Menu menu);

    boolean proxyOnPreparePanel(int i2, View view, Menu menu);

    void proxyOnRestart();

    void proxyOnRestoreInstanceState(Bundle bundle);

    void proxyOnResume();

    Object proxyOnRetainNonConfigurationInstance();

    void proxyOnSaveInstanceState(Bundle bundle);

    boolean proxyOnSearchRequested();

    void proxyOnStart();

    void proxyOnStop();

    void proxyOnTitleChanged(CharSequence charSequence, int i2);

    boolean proxyOnTouchEvent(MotionEvent motionEvent);

    boolean proxyOnTrackballEvent(MotionEvent motionEvent);

    void proxyOnUserInteraction();

    void proxyOnWindowAttributesChanged(WindowManager.LayoutParams layoutParams);

    void proxyOnWindowFocusChanged(boolean z);

    void proxyOpenContextMenu(View view);

    void proxyOpenOptionsMenu();

    void proxyOverridePendingTransition(int i2, int i3);

    void proxyRegisterForContextMenu(View view);

    void proxySetContentView(int i2);

    void proxySetContentView(View view);

    void proxySetContentView(View view, ViewGroup.LayoutParams layoutParams);

    void proxySetIntent(Intent intent);

    void proxySetRequestedOrientation(int i2);

    void proxySetTitle(int i2);

    void proxySetTitle(CharSequence charSequence);

    void proxySetTitleColor(int i2);

    void proxySetVisible(boolean z);

    void proxyStartActivity(Intent intent);

    void proxyStartActivityForResult(Intent intent, int i2);

    void proxyStartActivityFromChild(Activity activity, Intent intent, int i2);

    boolean proxyStartActivityIfNeeded(Intent intent, int i2);

    void proxyStartIntentSender(IntentSender intentSender, Intent intent, int i2, int i3, int i4) throws IntentSender.SendIntentException;

    void proxyStartIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5) throws IntentSender.SendIntentException;

    void proxyStartManagingCursor(Cursor cursor);

    boolean proxyStartNextMatchingActivity(Intent intent);

    void proxyStartSearch(String str, boolean z, Bundle bundle, boolean z2);

    ComponentName proxyStartService(Intent intent);

    void proxyStopManagingCursor(Cursor cursor);

    boolean proxyStopService(Intent intent);

    void proxyTakeKeyEvents(boolean z);

    void proxyUnregisterForContextMenu(View view);

    Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter);

    void unregisterReceiver(BroadcastReceiver broadcastReceiver);
}
