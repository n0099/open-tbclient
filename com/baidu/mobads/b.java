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
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import com.baidu.mobads.command.XAdCommandExtraInfo;
import com.baidu.mobads.command.XAdLandingPageExtraInfo;
import com.baidu.mobads.vo.XAdInstanceInfo;
import dalvik.system.DexClassLoader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b {
    private static Class<?> d;
    private Activity a;
    private Object c;
    private Method[] e = null;
    private static boolean b = false;
    private static AtomicBoolean f = new AtomicBoolean(false);

    public void setActivity(Activity activity) {
        this.a = activity;
    }

    public static boolean ut() {
        return f.get();
    }

    private Method cN(String str) {
        Method[] methodArr;
        if (this.e == null) {
            return null;
        }
        for (Method method : this.e) {
            if (method.getName().equals(str)) {
                method.setAccessible(true);
                return method;
            }
        }
        return null;
    }

    public void g(String str, Object... objArr) {
        try {
            com.baidu.mobads.utils.m a = com.baidu.mobads.utils.m.a();
            Object[] objArr2 = new Object[3];
            objArr2[0] = str;
            objArr2[1] = Integer.valueOf(objArr != null ? objArr.length : 0);
            objArr2[2] = objArr;
            a.d(objArr2);
            Method cN = cN(str);
            if (cN != null) {
                if (objArr == null || objArr.length == 0) {
                    cN.invoke(null, new Object[0]);
                } else {
                    cN.invoke(null, objArr);
                }
            }
        } catch (Exception e) {
            com.baidu.mobads.utils.m.a().d(e);
        }
    }

    private void a(String str, Object... objArr) {
        try {
            com.baidu.mobads.utils.m a = com.baidu.mobads.utils.m.a();
            Object[] objArr2 = new Object[3];
            objArr2[0] = str;
            objArr2[1] = Integer.valueOf(objArr != null ? objArr.length : 0);
            objArr2[2] = objArr;
            a.d(objArr2);
            Method cN = cN(str);
            if (cN != null) {
                if (objArr == null || objArr.length == 0) {
                    cN.invoke(this.c, new Object[0]);
                } else {
                    cN.invoke(this.c, objArr);
                }
            }
        } catch (Exception e) {
            com.baidu.mobads.utils.m.a().d(e);
        }
    }

    private boolean h(String str, Object... objArr) {
        try {
            com.baidu.mobads.utils.m a = com.baidu.mobads.utils.m.a();
            Object[] objArr2 = new Object[3];
            objArr2[0] = str;
            objArr2[1] = Integer.valueOf(objArr != null ? objArr.length : 0);
            objArr2[2] = objArr;
            a.d(objArr2);
            Method cN = cN(str);
            if (cN != null) {
                if (objArr == null || objArr.length == 0) {
                    return ((Boolean) cN.invoke(this.c, new Object[0])).booleanValue();
                }
                return ((Boolean) cN.invoke(this.c, objArr)).booleanValue();
            }
        } catch (Exception e) {
            com.baidu.mobads.utils.m.a().d(e);
        }
        return false;
    }

    private Object j(String str, Object... objArr) {
        try {
            com.baidu.mobads.utils.m a = com.baidu.mobads.utils.m.a();
            Object[] objArr2 = new Object[3];
            objArr2[0] = str;
            objArr2[1] = Integer.valueOf(objArr != null ? objArr.length : 0);
            objArr2[2] = objArr;
            a.d(objArr2);
            Method cN = cN(str);
            if (cN != null) {
                if (objArr == null || objArr.length == 0) {
                    return cN.invoke(this.c, new Object[0]);
                }
                return cN.invoke(this.c, objArr);
            }
        } catch (Exception e) {
            com.baidu.mobads.utils.m.a().d(e);
        }
        return null;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return h("dispatchKeyEvent", keyEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return h("dispatchTouchEvent", motionEvent);
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return h("dispatchTrackballEvent", motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        a("onActivityResult", Integer.valueOf(i), Integer.valueOf(i2), intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onApplyThemeResource(Resources.Theme theme, int i, boolean z) {
        a("onApplyThemeResource", theme, Integer.valueOf(i), Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChildTitleChanged(Activity activity, CharSequence charSequence) {
        a("onChildTitleChanged", activity, charSequence);
    }

    public void onConfigurationChanged(Configuration configuration) {
        a("onConfigurationChanged", configuration);
    }

    public void onContentChanged() {
        a("onContentChanged", new Object[0]);
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return h("onContextItemSelected", menuItem);
    }

    public void onContextMenuClosed(Menu menu) {
        a("onContextMenuClosed", menu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        try {
            f.set(true);
            Intent intent = this.a.getIntent();
            if (AppActivity.ur() && intent.getParcelableExtra("EXTRA_DATA") == null) {
                XAdLandingPageExtraInfo xAdLandingPageExtraInfo = new XAdLandingPageExtraInfo((String) null, new XAdInstanceInfo(new JSONObject()));
                b(XAdLandingPageExtraInfo.class, xAdLandingPageExtraInfo, this.a.getIntent().getStringExtra("EXTRA_DATA_STRING"));
                b(XAdCommandExtraInfo.class, xAdLandingPageExtraInfo, this.a.getIntent().getStringExtra("EXTRA_DATA_STRING_COM"));
                b(XAdInstanceInfo.class, xAdLandingPageExtraInfo.getAdInstanceInfo(), this.a.getIntent().getStringExtra("EXTRA_DATA_STRING_AD"));
                intent.putExtra("EXTRA_DATA", xAdLandingPageExtraInfo);
            }
            DexClassLoader d2 = com.baidu.mobads.g.b.d();
            if (d2 != null) {
                d = Class.forName("com.baidu.mobads.container.landingpage.App2Activity", true, d2);
            } else {
                d = cO("com.baidu.mobads.container.landingpage.App2Activity");
            }
            this.e = d.getDeclaredMethods();
            this.c = d.getConstructor(Activity.class).newInstance(this.a);
            g("canLpShowWhenLocked", Boolean.valueOf(b));
            com.baidu.mobads.utils.m.a().d("com.baidu.mobads.container.landingpage.App2Activity", d, this.c);
        } catch (Exception e) {
            com.baidu.mobads.utils.m.a().e(e);
        }
        a("onCreate", bundle);
    }

    public Class<?> cO(String str) {
        Class<?> cls = null;
        com.baidu.mobads.utils.m a = com.baidu.mobads.utils.m.a();
        try {
            cls = Class.forName(str, true, new DexClassLoader(com.baidu.mobads.g.g.a(this.a), this.a.getFilesDir().getAbsolutePath(), null, getClass().getClassLoader()));
        } catch (Exception e) {
            a.e(e);
        }
        a.i("jar.path=, clz=" + cls);
        return cls;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        a("onCreateContextMenu", contextMenu, view, contextMenuInfo);
    }

    public CharSequence onCreateDescription() {
        return (CharSequence) j("onCreateDescription", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Dialog onCreateDialog(int i) {
        Dialog dialog = (Dialog) j("onCreateDialog", Integer.valueOf(i));
        if (dialog != null) {
        }
        return dialog;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return h("onCreateOptionsMenu", menu);
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        return h("onCreatePanelMenu", Integer.valueOf(i), menu);
    }

    public View onCreatePanelView(int i) {
        try {
            return (View) j("onCreatePanelView", Integer.valueOf(i));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean onCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        return h("onCreateThumbnail", bitmap, canvas);
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        try {
            return (View) j("onCreateView", str, context, attributeSet);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
        f.set(false);
        a("onDestroy", new Object[0]);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return h("onKeyDown", Integer.valueOf(i), keyEvent);
    }

    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return h("onKeyMultiple", Integer.valueOf(i), Integer.valueOf(i2), keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return h("onKeyUp", Integer.valueOf(i), keyEvent);
    }

    public void onLowMemory() {
        a("onLowMemory", new Object[0]);
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return h("onMenuItemSelected", Integer.valueOf(i), menuItem);
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return h("onMenuOpened", Integer.valueOf(i), menu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        a("onNewIntent", intent);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return h("onOptionsItemSelected", menuItem);
    }

    public void onOptionsMenuClosed(Menu menu) {
        a("onOptionsMenuClosed", menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        a("onPanelClosed", Integer.valueOf(i), menu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPause() {
        a("onPause", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPostCreate(Bundle bundle) {
        a("onPostCreate", bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPostResume() {
        a("onPostResume", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPrepareDialog(int i, Dialog dialog) {
        a("onPrepareDialog", Integer.valueOf(i), dialog);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        return h("onPrepareOptionsMenu", menu);
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        return h("onPreparePanel", Integer.valueOf(i), view, menu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onRestart() {
        a("onRestart", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        a("onRestoreInstanceState", bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onResume() {
        a("onResume", new Object[0]);
    }

    public Object onRetainNonConfigurationInstance() {
        return j("onRetainNonConfigurationInstance", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        a("onSaveInstanceState", bundle);
    }

    public boolean onSearchRequested() {
        return h("onSearchRequested", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStart() {
        a("onStart", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStop() {
        a("onStop", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onTitleChanged(CharSequence charSequence, int i) {
        a("onTitleChanged", charSequence, Integer.valueOf(i));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return h("onTouchEvent", motionEvent);
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        return h("onTrackballEvent", motionEvent);
    }

    public void onUserInteraction() {
        a("onUserInteraction", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onUserLeaveHint() {
        a("onUserLeaveHint", new Object[0]);
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        a("onWindowAttributesChanged", layoutParams);
    }

    public void onWindowFocusChanged(boolean z) {
        a("onWindowFocusChanged", Boolean.valueOf(z));
    }

    public static String a(Class<?> cls, Object obj) {
        Field[] declaredFields;
        JSONObject jSONObject = new JSONObject();
        try {
            for (Field field : cls.getDeclaredFields()) {
                String str = null;
                try {
                    field.setAccessible(true);
                    str = field.getName();
                    if (a(field.getType())) {
                        jSONObject.put(str, field.get(obj));
                    }
                } catch (Exception e) {
                    com.baidu.mobads.utils.m.a().e("" + str);
                    com.baidu.mobads.utils.m.a().e(e);
                }
            }
            return jSONObject.toString();
        } catch (Exception e2) {
            com.baidu.mobads.utils.m.a().e(e2);
            return "";
        }
    }

    private static void b(Class<?> cls, Object obj, String str) {
        Field[] declaredFields;
        try {
            JSONObject jSONObject = new JSONObject(str);
            for (Field field : cls.getDeclaredFields()) {
                String str2 = null;
                try {
                    field.setAccessible(true);
                    str2 = field.getName();
                    Class<?> type = field.getType();
                    if (!jSONObject.isNull(str2) && a(type)) {
                        field.set(obj, jSONObject.get(str2));
                    }
                } catch (Exception e) {
                    com.baidu.mobads.utils.m.a().e("" + str2);
                    com.baidu.mobads.utils.m.a().e(e);
                }
            }
        } catch (Exception e2) {
            com.baidu.mobads.utils.m.a().e(e2);
        }
    }

    private static boolean a(Class<?> cls) {
        if (cls == null) {
            return false;
        }
        return cls.equals(String.class) || cls.equals(Integer.class) || cls.equals(Integer.TYPE) || cls.equals(Boolean.class) || cls.equals(Boolean.TYPE) || cls.equals(Double.class) || cls.equals(Double.TYPE) || cls.equals(Long.class) || cls.equals(Long.TYPE) || cls.equals(JSONArray.class) || cls.equals(JSONObject.class);
    }
}
