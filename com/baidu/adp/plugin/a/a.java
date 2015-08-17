package com.baidu.adp.plugin.a;

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
import com.baidu.adp.plugin.pluginBase.c;
/* loaded from: classes.dex */
public interface a {
    void E(Intent intent);

    boolean F(Intent intent);

    boolean H(boolean z);

    void I(boolean z);

    void J(boolean z);

    void K(boolean z);

    PendingIntent a(int i, Intent intent, int i2);

    void a(int i, int i2, Intent intent);

    void a(int i, Dialog dialog);

    void a(Activity activity, int i);

    void a(Activity activity, Intent intent, int i);

    void a(Activity activity, CharSequence charSequence);

    void a(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4);

    void a(IntentSender intentSender, Intent intent, int i, int i2, int i3);

    void a(Resources.Theme theme, int i, boolean z);

    void a(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo);

    void a(Menu menu);

    void a(View view, ViewGroup.LayoutParams layoutParams);

    void a(WindowManager.LayoutParams layoutParams);

    void a(String str, boolean z, Bundle bundle, boolean z2);

    boolean a(int i, int i2, KeyEvent keyEvent);

    boolean a(int i, KeyEvent keyEvent);

    boolean a(int i, Menu menu);

    boolean a(int i, MenuItem menuItem);

    boolean a(int i, View view, Menu menu);

    boolean a(MenuItem menuItem);

    boolean a(AccessibilityEvent accessibilityEvent);

    View an(int i);

    void ao(int i);

    SharedPreferences ap(int i);

    void aq(int i);

    void ar(int i);

    void as(int i);

    void at(int i);

    void b(Intent intent, int i);

    void b(Bundle bundle);

    void b(Menu menu);

    void b(View view, ViewGroup.LayoutParams layoutParams);

    void b(CharSequence charSequence);

    void b(CharSequence charSequence, int i);

    boolean b(int i, KeyEvent keyEvent);

    boolean b(int i, Menu menu);

    boolean b(Bitmap bitmap, Canvas canvas);

    boolean b(KeyEvent keyEvent);

    boolean b(MenuItem menuItem);

    boolean b(MotionEvent motionEvent);

    Object bb(String str);

    void c(int i, Menu menu);

    void c(Cursor cursor);

    void c(Bundle bundle);

    boolean c(int i, KeyEvent keyEvent);

    boolean c(Intent intent, int i);

    boolean c(Menu menu);

    boolean c(MotionEvent motionEvent);

    void d(Cursor cursor);

    void d(Bundle bundle);

    boolean d(MotionEvent motionEvent);

    void e(int i, int i2);

    void e(Bundle bundle);

    boolean e(MotionEvent motionEvent);

    Activity getActivity();

    c kG();

    void kH();

    void kI();

    void kJ();

    Context kK();

    ComponentName kL();

    String kM();

    int kN();

    View kO();

    Intent kP();

    LayoutInflater kQ();

    String kR();

    MenuInflater kS();

    int kT();

    int kU();

    int kV();

    int kW();

    Window kX();

    WindowManager kY();

    boolean kZ();

    boolean la();

    boolean lb();

    void lc();

    void ld();

    void le();

    void lf();

    void lg();

    void lh();

    void li();

    void lj();

    Object lk();

    boolean ll();

    void lm();

    void ln();

    void lo();

    void lp();

    void m(Activity activity);

    boolean proxyBindService(Intent intent, ServiceConnection serviceConnection, int i);

    PackageManager proxyGetPackageManager();

    SharedPreferences proxyGetSharedPreferences(String str, int i);

    void proxyOnConfigurationChanged(Configuration configuration);

    void proxyOnDestroy();

    void proxyOnLowMemory();

    void proxyOpenContextMenu(View view);

    void proxyRegisterForContextMenu(View view);

    void proxySetContentView(View view);

    void proxyStartActivity(Intent intent);

    ComponentName proxyStartService(Intent intent);

    boolean proxyStopService(Intent intent);

    void proxyUnregisterForContextMenu(View view);

    Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter);

    void unregisterReceiver(BroadcastReceiver broadcastReceiver);
}
