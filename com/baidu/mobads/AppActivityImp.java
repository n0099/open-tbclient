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
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import com.baidu.mobads.AppActivity;
import com.baidu.mobads.command.XAdCommandExtraInfo;
import com.baidu.mobads.command.XAdLandingPageExtraInfo;
import com.baidu.mobads.vo.XAdInstanceInfo;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import dalvik.system.DexClassLoader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AppActivityImp {
    public static final String EXTRA_AD_INSTANCE_INFO = "EXTRA_DATA_STRING_AD";
    public static final String EXTRA_COMMAND_EXTRA_INFO = "EXTRA_DATA_STRING_COM";
    public static final String EXTRA_DATA = "EXTRA_DATA";
    public static final String EXTRA_LANDINGPAGE_EXTRA_INFO = "EXTRA_DATA_STRING";
    public static final String EXTRA_LP_FLAG = "EXTRA_LP_FLAG";
    public static final String EXTRA_LP_THEME = "theme";

    /* renamed from: b  reason: collision with root package name */
    public static boolean f8109b = false;

    /* renamed from: d  reason: collision with root package name */
    public static Class<?> f8110d;

    /* renamed from: f  reason: collision with root package name */
    public static AppActivity.ActionBarColorTheme f8111f = AppActivity.ActionBarColorTheme.ACTION_BAR_WHITE_THEME;

    /* renamed from: a  reason: collision with root package name */
    public Activity f8112a;

    /* renamed from: c  reason: collision with root package name */
    public Object f8113c;

    /* renamed from: e  reason: collision with root package name */
    public Method[] f8114e = null;

    public AppActivityImp(Activity activity) {
        this.f8112a = activity;
    }

    private Method a(String str) {
        Method[] methodArr = this.f8114e;
        if (methodArr == null) {
            return null;
        }
        for (Method method : methodArr) {
            if (method.getName().equals(str)) {
                method.setAccessible(true);
                return method;
            }
        }
        return null;
    }

    private boolean b(String str, Object... objArr) {
        try {
            com.baidu.mobads.utils.q a2 = com.baidu.mobads.utils.q.a();
            Object[] objArr2 = new Object[3];
            objArr2[0] = str;
            objArr2[1] = Integer.valueOf(objArr != null ? objArr.length : 0);
            objArr2[2] = objArr;
            a2.d(objArr2);
            Method a3 = a(str);
            if (a3 != null) {
                if (objArr != null && objArr.length != 0) {
                    return ((Boolean) a3.invoke(this.f8113c, objArr)).booleanValue();
                }
                return ((Boolean) a3.invoke(this.f8113c, new Object[0])).booleanValue();
            }
        } catch (Exception e2) {
            com.baidu.mobads.utils.q.a().d(e2);
        }
        return false;
    }

    private Object c(String str, Object... objArr) {
        try {
            com.baidu.mobads.utils.q a2 = com.baidu.mobads.utils.q.a();
            Object[] objArr2 = new Object[3];
            objArr2[0] = str;
            objArr2[1] = Integer.valueOf(objArr != null ? objArr.length : 0);
            objArr2[2] = objArr;
            a2.d(objArr2);
            Method a3 = a(str);
            if (a3 != null) {
                if (objArr != null && objArr.length != 0) {
                    return a3.invoke(this.f8113c, objArr);
                }
                return a3.invoke(this.f8113c, new Object[0]);
            }
            return null;
        } catch (Exception e2) {
            com.baidu.mobads.utils.q.a().d(e2);
            return null;
        }
    }

    public static void canLpShowWhenLocked(boolean z) {
        f8109b = z;
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
                } catch (Exception e2) {
                    com.baidu.mobads.utils.q.a().d("" + str);
                    com.baidu.mobads.utils.q.a().d(e2);
                }
            }
            return jSONObject.toString();
        } catch (Exception e3) {
            com.baidu.mobads.utils.q.a().d(e3);
            return "";
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return b("dispatchKeyEvent", keyEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return b("dispatchTouchEvent", motionEvent);
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return b("dispatchTrackballEvent", motionEvent);
    }

    public void invokeRemoteStatic(String str, Object... objArr) {
        try {
            com.baidu.mobads.utils.q a2 = com.baidu.mobads.utils.q.a();
            Object[] objArr2 = new Object[3];
            objArr2[0] = str;
            objArr2[1] = Integer.valueOf(objArr != null ? objArr.length : 0);
            objArr2[2] = objArr;
            a2.d(objArr2);
            Method a3 = a(str);
            if (a3 != null) {
                if (objArr != null && objArr.length != 0) {
                    a3.invoke(null, objArr);
                    return;
                }
                a3.invoke(null, new Object[0]);
            }
        } catch (Exception e2) {
            com.baidu.mobads.utils.q.a().d(e2);
        }
    }

    public Class<?> loadLocalApk(String str) {
        com.baidu.mobads.utils.q a2 = com.baidu.mobads.utils.q.a();
        Class<?> cls = null;
        try {
            cls = Class.forName(str, true, new DexClassLoader(com.baidu.mobads.g.g.a(this.f8112a), this.f8112a.getFilesDir().getAbsolutePath(), null, AppActivityImp.class.getClassLoader()));
        } catch (Exception e2) {
            a2.d(e2);
        }
        a2.d("jar.path=, clz=" + cls);
        return cls;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        a("onActivityResult", Integer.valueOf(i), Integer.valueOf(i2), intent);
    }

    public void onApplyThemeResource(Resources.Theme theme, int i, boolean z) {
        a("onApplyThemeResource", theme, Integer.valueOf(i), Boolean.valueOf(z));
    }

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
        return b("onContextItemSelected", menuItem);
    }

    public void onContextMenuClosed(Menu menu) {
        a("onContextMenuClosed", menu);
    }

    public void onCreate(Bundle bundle) {
        try {
            Intent intent = this.f8112a.getIntent();
            if (intent != null) {
                if (!TextUtils.isEmpty(intent.getStringExtra("privacy_link"))) {
                    a(bundle);
                    return;
                }
                intent.setExtrasClassLoader(getClass().getClassLoader());
                a(AppActivity.ActionBarColorTheme.class, f8111f, this.f8112a.getIntent().getStringExtra(EXTRA_LP_THEME));
                f8109b = intent.getBooleanExtra("showWhenLocked", true);
            }
            com.baidu.mobads.utils.f fVar = new com.baidu.mobads.utils.f();
            if (intent != null) {
                intent.putExtra("multiProcess", fVar.webviewMultiProcess(this.f8112a));
            }
            if (AppActivity.isAnti() && intent != null && intent.getParcelableExtra(EXTRA_DATA) == null) {
                XAdLandingPageExtraInfo xAdLandingPageExtraInfo = new XAdLandingPageExtraInfo((String) null, new XAdInstanceInfo(new JSONObject()));
                a(XAdLandingPageExtraInfo.class, xAdLandingPageExtraInfo, this.f8112a.getIntent().getStringExtra(EXTRA_LANDINGPAGE_EXTRA_INFO));
                a(XAdCommandExtraInfo.class, xAdLandingPageExtraInfo, this.f8112a.getIntent().getStringExtra(EXTRA_COMMAND_EXTRA_INFO));
                a(XAdInstanceInfo.class, xAdLandingPageExtraInfo.getAdInstanceInfo(), this.f8112a.getIntent().getStringExtra(EXTRA_AD_INSTANCE_INFO));
                intent.putExtra(EXTRA_DATA, xAdLandingPageExtraInfo);
            }
            DexClassLoader d2 = com.baidu.mobads.g.b.d();
            if (d2 == null) {
                f8110d = loadLocalApk("com.baidu.mobads.container.landingpage.App2Activity");
            } else {
                f8110d = Class.forName("com.baidu.mobads.container.landingpage.App2Activity", true, d2);
            }
            this.f8114e = f8110d.getDeclaredMethods();
            this.f8113c = f8110d.getConstructor(Activity.class).newInstance(this.f8112a);
            invokeRemoteStatic("canLpShowWhenLocked", Boolean.valueOf(f8109b));
            invokeRemoteStatic("setActionBarColor", Integer.valueOf(f8111f.closeColor), Integer.valueOf(f8111f.titleColor), Integer.valueOf(f8111f.progressColor), Integer.valueOf(f8111f.backgroundColor));
            com.baidu.mobads.utils.q.a().d("com.baidu.mobads.container.landingpage.App2Activity", f8110d, this.f8113c);
        } catch (Exception e2) {
            com.baidu.mobads.utils.q.a().d(e2);
        }
        a(MissionEvent.MESSAGE_CREATE, bundle);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        a("onCreateContextMenu", contextMenu, view, contextMenuInfo);
    }

    public CharSequence onCreateDescription() {
        return (CharSequence) c("onCreateDescription", new Object[0]);
    }

    public Dialog onCreateDialog(int i) {
        Dialog dialog = (Dialog) c("onCreateDialog", Integer.valueOf(i));
        if (dialog != null) {
        }
        return dialog;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return b("onCreateOptionsMenu", menu);
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        return b("onCreatePanelMenu", Integer.valueOf(i), menu);
    }

    public View onCreatePanelView(int i) {
        try {
            return (View) c("onCreatePanelView", Integer.valueOf(i));
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean onCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        return b("onCreateThumbnail", bitmap, canvas);
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        try {
            return (View) c("onCreateView", str, context, attributeSet);
        } catch (Exception unused) {
            return null;
        }
    }

    public void onDestroy() {
        if (this.f8112a != null) {
            Intent intent = new Intent();
            intent.setAction("lp_close");
            this.f8112a.sendBroadcast(intent);
        }
        a(MissionEvent.MESSAGE_DESTROY, new Object[0]);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return b("onKeyDown", Integer.valueOf(i), keyEvent);
    }

    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return b("onKeyMultiple", Integer.valueOf(i), Integer.valueOf(i2), keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return b("onKeyUp", Integer.valueOf(i), keyEvent);
    }

    public void onLowMemory() {
        a("onLowMemory", new Object[0]);
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return b("onMenuItemSelected", Integer.valueOf(i), menuItem);
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return b("onMenuOpened", Integer.valueOf(i), menu);
    }

    public void onNewIntent(Intent intent) {
        a("onNewIntent", intent);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return b("onOptionsItemSelected", menuItem);
    }

    public void onOptionsMenuClosed(Menu menu) {
        a("onOptionsMenuClosed", menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        a("onPanelClosed", Integer.valueOf(i), menu);
    }

    public void onPause() {
        a(MissionEvent.MESSAGE_PAUSE, new Object[0]);
    }

    public void onPostCreate(Bundle bundle) {
        a("onPostCreate", bundle);
    }

    public void onPostResume() {
        a("onPostResume", new Object[0]);
    }

    public void onPrepareDialog(int i, Dialog dialog) {
        a("onPrepareDialog", Integer.valueOf(i), dialog);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        return b("onPrepareOptionsMenu", menu);
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        return b("onPreparePanel", Integer.valueOf(i), view, menu);
    }

    public void onRestart() {
        a("onRestart", new Object[0]);
    }

    public void onRestoreInstanceState(Bundle bundle) {
        a("onRestoreInstanceState", bundle);
    }

    public void onResume() {
        a(MissionEvent.MESSAGE_RESUME, new Object[0]);
    }

    public Object onRetainNonConfigurationInstance() {
        return c("onRetainNonConfigurationInstance", new Object[0]);
    }

    public void onSaveInstanceState(Bundle bundle) {
        a("onSaveInstanceState", bundle);
    }

    public boolean onSearchRequested() {
        return b("onSearchRequested", new Object[0]);
    }

    public void onStart() {
        a(MissionEvent.MESSAGE_START, new Object[0]);
    }

    public void onStop() {
        a(MissionEvent.MESSAGE_STOP, new Object[0]);
    }

    public void onTitleChanged(CharSequence charSequence, int i) {
        a("onTitleChanged", charSequence, Integer.valueOf(i));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return b("onTouchEvent", motionEvent);
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        return b("onTrackballEvent", motionEvent);
    }

    public void onUserInteraction() {
        a("onUserInteraction", new Object[0]);
    }

    public void onUserLeaveHint() {
        a("onUserLeaveHint", new Object[0]);
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        a("onWindowAttributesChanged", layoutParams);
    }

    public void onWindowFocusChanged(boolean z) {
        a("onWindowFocusChanged", Boolean.valueOf(z));
    }

    public void setActivity(Activity activity) {
        this.f8112a = activity;
    }

    public AppActivityImp() {
    }

    private void a(String str, Object... objArr) {
        try {
            com.baidu.mobads.utils.q a2 = com.baidu.mobads.utils.q.a();
            Object[] objArr2 = new Object[3];
            objArr2[0] = str;
            objArr2[1] = Integer.valueOf(objArr != null ? objArr.length : 0);
            objArr2[2] = objArr;
            a2.d(objArr2);
            Method a3 = a(str);
            if (a3 != null) {
                if (objArr != null && objArr.length != 0) {
                    a3.invoke(this.f8113c, objArr);
                    return;
                }
                a3.invoke(this.f8113c, new Object[0]);
            }
        } catch (Exception e2) {
            com.baidu.mobads.utils.q.a().d(e2);
        }
    }

    private void a(Bundle bundle) {
        try {
            DexClassLoader d2 = com.baidu.mobads.g.b.d();
            if (d2 == null) {
                f8110d = loadLocalApk("com.baidu.mobads.container.landingpage.AppPriActivity");
            } else {
                f8110d = Class.forName("com.baidu.mobads.container.landingpage.AppPriActivity", true, d2);
            }
            this.f8114e = f8110d.getDeclaredMethods();
            this.f8113c = f8110d.getConstructor(Activity.class).newInstance(this.f8112a);
        } catch (Exception e2) {
            com.baidu.mobads.utils.q.a().d(e2);
        }
        a(MissionEvent.MESSAGE_CREATE, bundle);
    }

    public static void a(Class<?> cls, Object obj, String str) {
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
                } catch (Exception e2) {
                    com.baidu.mobads.utils.q.a().d("" + str2);
                    com.baidu.mobads.utils.q.a().d(e2);
                }
            }
        } catch (Exception e3) {
            com.baidu.mobads.utils.q.a().d(e3);
        }
    }

    public static boolean a(Class<?> cls) {
        if (cls == null) {
            return false;
        }
        return cls.equals(String.class) || cls.equals(Integer.class) || cls.equals(Integer.TYPE) || cls.equals(Boolean.class) || cls.equals(Boolean.TYPE) || cls.equals(Double.class) || cls.equals(Double.TYPE) || cls.equals(Long.class) || cls.equals(Long.TYPE) || cls.equals(JSONArray.class) || cls.equals(JSONObject.class);
    }
}
