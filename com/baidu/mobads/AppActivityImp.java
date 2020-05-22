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
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import dalvik.system.DexClassLoader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AppActivityImp {
    public static final String EXTRA_AD_INSTANCE_INFO = "EXTRA_DATA_STRING_AD";
    public static final String EXTRA_COMMAND_EXTRA_INFO = "EXTRA_DATA_STRING_COM";
    public static final String EXTRA_DATA = "EXTRA_DATA";
    public static final String EXTRA_LANDINGPAGE_EXTRA_INFO = "EXTRA_DATA_STRING";
    private static Class<?> d;
    private Activity a;
    private Method[] bsl = null;
    private Object c;
    private static boolean b = false;
    private static AtomicBoolean f = new AtomicBoolean(false);

    public AppActivityImp(Activity activity) {
        this.a = activity;
    }

    public AppActivityImp() {
    }

    public void setActivity(Activity activity) {
        this.a = activity;
    }

    public static void canLpShowWhenLocked(boolean z) {
        b = z;
    }

    public static boolean isAppActivityOpening() {
        return f.get();
    }

    private Method gn(String str) {
        Method[] methodArr;
        if (this.bsl == null) {
            return null;
        }
        for (Method method : this.bsl) {
            if (method.getName().equals(str)) {
                method.setAccessible(true);
                return method;
            }
        }
        return null;
    }

    public void invokeRemoteStatic(String str, Object... objArr) {
        try {
            com.baidu.mobads.utils.m a = com.baidu.mobads.utils.m.a();
            Object[] objArr2 = new Object[3];
            objArr2[0] = str;
            objArr2[1] = Integer.valueOf(objArr != null ? objArr.length : 0);
            objArr2[2] = objArr;
            a.d(objArr2);
            Method gn = gn(str);
            if (gn != null) {
                if (objArr == null || objArr.length == 0) {
                    gn.invoke(null, new Object[0]);
                } else {
                    gn.invoke(null, objArr);
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
            Method gn = gn(str);
            if (gn != null) {
                if (objArr == null || objArr.length == 0) {
                    gn.invoke(this.c, new Object[0]);
                } else {
                    gn.invoke(this.c, objArr);
                }
            }
        } catch (Exception e) {
            com.baidu.mobads.utils.m.a().d(e);
        }
    }

    private boolean f(String str, Object... objArr) {
        try {
            com.baidu.mobads.utils.m a = com.baidu.mobads.utils.m.a();
            Object[] objArr2 = new Object[3];
            objArr2[0] = str;
            objArr2[1] = Integer.valueOf(objArr != null ? objArr.length : 0);
            objArr2[2] = objArr;
            a.d(objArr2);
            Method gn = gn(str);
            if (gn != null) {
                if (objArr == null || objArr.length == 0) {
                    return ((Boolean) gn.invoke(this.c, new Object[0])).booleanValue();
                }
                return ((Boolean) gn.invoke(this.c, objArr)).booleanValue();
            }
        } catch (Exception e) {
            com.baidu.mobads.utils.m.a().d(e);
        }
        return false;
    }

    private Object g(String str, Object... objArr) {
        try {
            com.baidu.mobads.utils.m a = com.baidu.mobads.utils.m.a();
            Object[] objArr2 = new Object[3];
            objArr2[0] = str;
            objArr2[1] = Integer.valueOf(objArr != null ? objArr.length : 0);
            objArr2[2] = objArr;
            a.d(objArr2);
            Method gn = gn(str);
            if (gn != null) {
                if (objArr == null || objArr.length == 0) {
                    return gn.invoke(this.c, new Object[0]);
                }
                return gn.invoke(this.c, objArr);
            }
        } catch (Exception e) {
            com.baidu.mobads.utils.m.a().d(e);
        }
        return null;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return f("dispatchKeyEvent", keyEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return f("dispatchTouchEvent", motionEvent);
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return f("dispatchTrackballEvent", motionEvent);
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
        return f("onContextItemSelected", menuItem);
    }

    public void onContextMenuClosed(Menu menu) {
        a("onContextMenuClosed", menu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        try {
            f.set(true);
            Intent intent = this.a.getIntent();
            if (AppActivity.isAnti() && intent.getParcelableExtra(EXTRA_DATA) == null) {
                XAdLandingPageExtraInfo xAdLandingPageExtraInfo = new XAdLandingPageExtraInfo((String) null, new XAdInstanceInfo(new JSONObject()));
                b(XAdLandingPageExtraInfo.class, xAdLandingPageExtraInfo, this.a.getIntent().getStringExtra(EXTRA_LANDINGPAGE_EXTRA_INFO));
                b(XAdCommandExtraInfo.class, xAdLandingPageExtraInfo, this.a.getIntent().getStringExtra(EXTRA_COMMAND_EXTRA_INFO));
                b(XAdInstanceInfo.class, xAdLandingPageExtraInfo.getAdInstanceInfo(), this.a.getIntent().getStringExtra(EXTRA_AD_INSTANCE_INFO));
                intent.putExtra(EXTRA_DATA, xAdLandingPageExtraInfo);
            }
            DexClassLoader d2 = com.baidu.mobads.g.b.d();
            if (d2 != null) {
                d = Class.forName("com.baidu.mobads.container.landingpage.App2Activity", true, d2);
            } else {
                d = loadLocalApk("com.baidu.mobads.container.landingpage.App2Activity");
            }
            this.bsl = d.getDeclaredMethods();
            this.c = d.getConstructor(Activity.class).newInstance(this.a);
            invokeRemoteStatic("canLpShowWhenLocked", Boolean.valueOf(b));
            com.baidu.mobads.utils.m.a().d("com.baidu.mobads.container.landingpage.App2Activity", d, this.c);
        } catch (Exception e) {
            com.baidu.mobads.utils.m.a().e(e);
        }
        a(MissionEvent.MESSAGE_CREATE, bundle);
    }

    public Class<?> loadLocalApk(String str) {
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
        return (CharSequence) g("onCreateDescription", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Dialog onCreateDialog(int i) {
        Dialog dialog = (Dialog) g("onCreateDialog", Integer.valueOf(i));
        if (dialog != null) {
        }
        return dialog;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return f("onCreateOptionsMenu", menu);
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        return f("onCreatePanelMenu", Integer.valueOf(i), menu);
    }

    public View onCreatePanelView(int i) {
        try {
            return (View) g("onCreatePanelView", Integer.valueOf(i));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean onCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        return f("onCreateThumbnail", bitmap, canvas);
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        try {
            return (View) g("onCreateView", str, context, attributeSet);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
        f.set(false);
        a(MissionEvent.MESSAGE_DESTROY, new Object[0]);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return f("onKeyDown", Integer.valueOf(i), keyEvent);
    }

    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return f("onKeyMultiple", Integer.valueOf(i), Integer.valueOf(i2), keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return f("onKeyUp", Integer.valueOf(i), keyEvent);
    }

    public void onLowMemory() {
        a("onLowMemory", new Object[0]);
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return f("onMenuItemSelected", Integer.valueOf(i), menuItem);
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return f("onMenuOpened", Integer.valueOf(i), menu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        a("onNewIntent", intent);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return f("onOptionsItemSelected", menuItem);
    }

    public void onOptionsMenuClosed(Menu menu) {
        a("onOptionsMenuClosed", menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        a("onPanelClosed", Integer.valueOf(i), menu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPause() {
        a(MissionEvent.MESSAGE_PAUSE, new Object[0]);
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
        return f("onPrepareOptionsMenu", menu);
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        return f("onPreparePanel", Integer.valueOf(i), view, menu);
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
        a(MissionEvent.MESSAGE_RESUME, new Object[0]);
    }

    public Object onRetainNonConfigurationInstance() {
        return g("onRetainNonConfigurationInstance", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        a("onSaveInstanceState", bundle);
    }

    public boolean onSearchRequested() {
        return f("onSearchRequested", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStart() {
        a(MissionEvent.MESSAGE_START, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStop() {
        a(MissionEvent.MESSAGE_STOP, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onTitleChanged(CharSequence charSequence, int i) {
        a("onTitleChanged", charSequence, Integer.valueOf(i));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return f("onTouchEvent", motionEvent);
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        return f("onTrackballEvent", motionEvent);
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

    public static String classToString(Class<?> cls, Object obj) {
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
