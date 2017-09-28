package com.baidu.sofire;

import android.R;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Window;
import com.baidu.sofire.core.ApkInfo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class MyActivity extends Activity {
    public static Method Of;
    public static Method Og;
    public static Method Oh;
    public static Method Oi;
    public static Method PA;
    public static Field Pv;
    public static Field Pw;
    public static Field Px;
    public static Method Py;
    public static Method Pz;
    public static Method l;
    private Resources Pr;
    protected boolean a = false;
    protected a Ps = new a();
    protected Activity c = null;
    protected Configuration Pt = null;
    protected ActivityInfo Pu = null;

    /* loaded from: classes.dex */
    public static class a {
        public boolean a = false;
        public String b;
        public String c;
        public String d;
        public Intent e;

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getClass().getSimpleName()).append(": mode=").append(this.a).append(", activity=").append(this.b).append(", path=").append(this.c).append(",pkgName=").append(this.d);
            return sb.toString();
        }
    }

    static {
        Pv = null;
        Pw = null;
        Px = null;
        Py = null;
        Pz = null;
        Of = null;
        l = null;
        Og = null;
        Oh = null;
        Oi = null;
        PA = null;
        Py = f.a((Class<?>) Activity.class, "onCreate", (Class<?>[]) new Class[]{Bundle.class});
        Pz = f.a((Class<?>) Activity.class, "onPostCreate", (Class<?>[]) new Class[]{Bundle.class});
        Of = f.a((Class<?>) Activity.class, "onStart", (Class<?>[]) new Class[0]);
        l = f.a((Class<?>) Activity.class, "onResume", (Class<?>[]) new Class[0]);
        Og = f.a((Class<?>) Activity.class, "onPostResume", (Class<?>[]) new Class[0]);
        Oh = f.a((Class<?>) Activity.class, "onPause", (Class<?>[]) new Class[0]);
        Oi = f.a((Class<?>) Activity.class, "onStop", (Class<?>[]) new Class[0]);
        PA = f.a((Class<?>) Activity.class, "onDestroy", (Class<?>[]) new Class[0]);
        Pv = f.d(Activity.class, "mCurrentConfig");
        Pw = f.d(Activity.class, "mConfigChangeFlags");
        Px = f.d(Activity.class, "mCalled");
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r3v9 int)] */
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        ActivityInfo activityInfo;
        String str;
        com.baidu.sofire.core.e nr = com.baidu.sofire.core.e.nr();
        if (nr == null) {
            b.a();
            super.onCreate(bundle);
            finish();
            return;
        }
        a aVar = this.Ps;
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("from_plugin_package");
        String stringExtra2 = intent.getStringExtra("target_class");
        if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
            aVar.a = true;
            aVar.d = stringExtra;
            aVar.b = stringExtra2;
            aVar.e = intent;
        }
        this.Ps.toString();
        b.a();
        if (TextUtils.isEmpty(this.Ps.d)) {
            b.a();
            super.onCreate(bundle);
            finish();
            return;
        }
        ApkInfo bT = nr.bT(this.Ps.d);
        if (bT == null || bT.activities == null) {
            b.a();
            super.onCreate(bundle);
            finish();
            return;
        }
        ActivityInfo[] activityInfoArr = bT.activities;
        int length = activityInfoArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                activityInfo = null;
                break;
            }
            ActivityInfo activityInfo2 = activityInfoArr[i];
            if (activityInfo2.name.equals(this.Ps.b)) {
                activityInfo = activityInfo2;
                break;
            }
            i++;
        }
        if (activityInfo == null) {
            b.a();
            super.onCreate(bundle);
            finish();
            return;
        }
        this.Pu = activityInfo;
        int i2 = activityInfo.theme;
        if (i2 == 0) {
            i2 = bT.applicationTheme;
        }
        int i3 = i2 == 0 ? 16973829 : i2;
        setTheme(i3);
        this.a = true;
        try {
            Object newInstance = bT.classLoader.loadClass(this.Ps.b).newInstance();
            if (!(newInstance instanceof Activity)) {
                String str2 = newInstance.toString();
                b.a();
                finish();
            } else {
                this.c = (Activity) newInstance;
                Activity activity = (Activity) newInstance;
                f.a(this, activity);
                Field d = f.d(ContextThemeWrapper.class, "mInflater");
                Field d2 = f.d(ContextThemeWrapper.class, "mTheme");
                Field d3 = f.d(ContextThemeWrapper.class, "mResources");
                if (d != null) {
                    try {
                        d.set(activity, null);
                    } catch (Throwable th) {
                        th.getMessage();
                        b.b();
                    }
                }
                if (d2 != null) {
                    d2.set(activity, null);
                }
                if (d3 != null) {
                    Resources resources = getResources();
                    AssetManager assetManager = new AssetManager();
                    assetManager.addAssetPath(bT.pkgPath);
                    String str3 = "p=" + bT.pkgPath;
                    b.a();
                    this.Pr = new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                    String str4 = "r=" + this.Pr + ", l=" + activityInfo.labelRes;
                    b.a();
                    if (activityInfo.labelRes > 0) {
                        String str5 = this.Pr.getString(activityInfo.labelRes);
                        b.a();
                    }
                    d3.set(activity, this.Pr);
                }
                activity.setTheme(i3);
                activity.getTheme().applyStyle(i3, true);
                new StringBuilder().append(i3).toString();
                b.a();
                Window window = activity.getWindow();
                Field d4 = f.d(window.getClass(), "mLayoutInflater");
                if (d4 != null) {
                    d4.setAccessible(true);
                    try {
                        d4.set(window, ((LayoutInflater) d4.get(window)).cloneInContext(activity));
                    } catch (Throwable th2) {
                        th2.getMessage();
                        b.b();
                    }
                }
                Field d5 = f.d(Window.class, "mCallback");
                if (d5 != null) {
                    try {
                        d5.set(activity.getWindow(), this.c);
                    } catch (IllegalAccessException e) {
                    } catch (IllegalArgumentException e2) {
                    }
                }
                Field d6 = f.d(Activity.class, "mActivityInfo");
                if (d6 != null) {
                    try {
                        d6.set(activity, activityInfo);
                    } catch (Throwable th3) {
                        th3.getMessage();
                        b.b();
                    }
                }
                Field d7 = f.d(Activity.class, "mComponent");
                if (d7 != null) {
                    try {
                        d7.set(activity, new ComponentName(activityInfo.packageName, activityInfo.name));
                    } catch (Throwable th4) {
                        th4.getMessage();
                        b.b();
                    }
                }
                Field d8 = f.d(Activity.class, "mTitle");
                if (d8 != null) {
                    if (activityInfo.nonLocalizedLabel != null) {
                        str = activityInfo.nonLocalizedLabel.toString();
                    } else if (activityInfo.labelRes == 0) {
                        str = activityInfo.name != null ? activityInfo.name : activityInfo.packageName;
                    } else if (this.Pr != null) {
                        String str6 = "p= " + bT.pkgPath;
                        b.a();
                        String str7 = "r=" + this.Pr + ", l=" + activityInfo.labelRes;
                        b.a();
                        str = this.Pr.getString(activityInfo.labelRes);
                    } else {
                        str = null;
                    }
                    try {
                        d8.set(activity, str);
                    } catch (Throwable th5) {
                        th5.getMessage();
                        b.b();
                    }
                }
                Window window2 = activity.getWindow();
                TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(R.styleable.Window);
                Field d9 = f.d(activity.getWindow().getClass(), "mWindowStyle");
                if (d9 != null) {
                    try {
                        d9.set(window2, obtainStyledAttributes);
                    } catch (Throwable th6) {
                        th6.getMessage();
                        b.b();
                    }
                }
                this.Ps.e.setExtrasClassLoader(bT.classLoader);
                activity.setIntent(this.Ps.e);
                if (this.a && Py != null && this.c != null) {
                    try {
                        Py.invoke(newInstance, bundle);
                    } catch (Throwable th7) {
                        th7.getMessage();
                        b.b();
                    }
                }
                super.onCreate(bundle);
                b.a();
            }
        } catch (Throwable th8) {
            th8.getMessage();
            b.b();
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        if (this.a && Pz != null && this.c != null) {
            try {
                Pz.invoke(this.c, bundle);
            } catch (Throwable th) {
                th.getMessage();
                b.b();
            }
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.a && PA != null && this.c != null) {
            try {
                PA.invoke(this.c, new Object[0]);
            } catch (Throwable th) {
                th.getMessage();
                b.b();
            }
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        if (this.a && Oh != null && this.c != null) {
            try {
                Oh.invoke(this.c, new Object[0]);
            } catch (Throwable th) {
                th.getMessage();
                b.b();
            }
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.a && l != null && this.c != null) {
            try {
                l.invoke(this.c, new Object[0]);
            } catch (Throwable th) {
                th.getMessage();
                b.b();
            }
        }
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        if (this.a && Og != null && this.c != null) {
            try {
                Og.invoke(this.c, new Object[0]);
            } catch (Throwable th) {
                th.getMessage();
                b.b();
            }
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.a && Of != null && this.c != null) {
            try {
                Of.invoke(this.c, new Object[0]);
            } catch (Throwable th) {
                th.getMessage();
                b.b();
            }
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        if (this.a && Oi != null && this.c != null) {
            try {
                Oi.invoke(this.c, new Object[0]);
            } catch (Throwable th) {
                th.getMessage();
                b.b();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0023 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    @Override // android.app.Activity, android.content.ComponentCallbacks
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onConfigurationChanged(Configuration configuration) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        super.onConfigurationChanged(configuration);
        if (this.a && this.c != null) {
            if (this.Pt != null) {
                Configuration configuration2 = this.Pt;
                int i = this.Pu.configChanges;
                int diff = configuration2.diff(configuration);
                if (diff != 0 && (diff & i) == 0) {
                    z = true;
                    if (!z) {
                        try {
                            Px.setBoolean(this.c, false);
                            z2 = false;
                        } catch (Throwable th) {
                            th.getMessage();
                            b.b();
                            z2 = true;
                        }
                        this.c.onConfigurationChanged(configuration);
                        try {
                            z3 = Px.getBoolean(this.c);
                        } catch (Throwable th2) {
                            th2.getMessage();
                            b.b();
                            z2 = true;
                        }
                        if (z2 || z3) {
                            try {
                                Pw.setInt(this.c, 0);
                            } catch (Throwable th3) {
                                th3.getMessage();
                                b.b();
                            }
                            try {
                                Pv.set(this.c, new Configuration(configuration));
                            } catch (Throwable th4) {
                                th4.getMessage();
                                b.b();
                            }
                        }
                    }
                    if (this.Pt == null) {
                        this.Pt.updateFrom(configuration);
                        return;
                    }
                    return;
                }
            }
            z = false;
            if (!z) {
            }
            if (this.Pt == null) {
            }
        }
    }
}
