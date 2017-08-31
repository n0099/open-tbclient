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
    public static Method NP;
    public static Method NQ;
    public static Method NR;
    public static Method NS;
    public static Field Pg;
    public static Field Ph;
    public static Field Pi;
    public static Method Pj;
    public static Method Pk;
    public static Method Pl;
    public static Method l;
    private Resources Pc;
    protected boolean a = false;
    protected a Pd = new a();
    protected Activity c = null;
    protected Configuration Pe = null;
    protected ActivityInfo Pf = null;

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
        Pg = null;
        Ph = null;
        Pi = null;
        Pj = null;
        Pk = null;
        NP = null;
        l = null;
        NQ = null;
        NR = null;
        NS = null;
        Pl = null;
        Pj = f.a((Class<?>) Activity.class, "onCreate", (Class<?>[]) new Class[]{Bundle.class});
        Pk = f.a((Class<?>) Activity.class, "onPostCreate", (Class<?>[]) new Class[]{Bundle.class});
        NP = f.a((Class<?>) Activity.class, "onStart", (Class<?>[]) new Class[0]);
        l = f.a((Class<?>) Activity.class, "onResume", (Class<?>[]) new Class[0]);
        NQ = f.a((Class<?>) Activity.class, "onPostResume", (Class<?>[]) new Class[0]);
        NR = f.a((Class<?>) Activity.class, "onPause", (Class<?>[]) new Class[0]);
        NS = f.a((Class<?>) Activity.class, "onStop", (Class<?>[]) new Class[0]);
        Pl = f.a((Class<?>) Activity.class, "onDestroy", (Class<?>[]) new Class[0]);
        Pg = f.d(Activity.class, "mCurrentConfig");
        Ph = f.d(Activity.class, "mConfigChangeFlags");
        Pi = f.d(Activity.class, "mCalled");
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
        com.baidu.sofire.core.e np = com.baidu.sofire.core.e.np();
        if (np == null) {
            b.a();
            super.onCreate(bundle);
            finish();
            return;
        }
        a aVar = this.Pd;
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("from_plugin_package");
        String stringExtra2 = intent.getStringExtra("target_class");
        if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
            aVar.a = true;
            aVar.d = stringExtra;
            aVar.b = stringExtra2;
            aVar.e = intent;
        }
        this.Pd.toString();
        b.a();
        if (TextUtils.isEmpty(this.Pd.d)) {
            b.a();
            super.onCreate(bundle);
            finish();
            return;
        }
        ApkInfo bT = np.bT(this.Pd.d);
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
            if (activityInfo2.name.equals(this.Pd.b)) {
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
        this.Pf = activityInfo;
        int i2 = activityInfo.theme;
        if (i2 == 0) {
            i2 = bT.applicationTheme;
        }
        int i3 = i2 == 0 ? 16973829 : i2;
        setTheme(i3);
        this.a = true;
        try {
            Object newInstance = bT.classLoader.loadClass(this.Pd.b).newInstance();
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
                    this.Pc = new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                    String str4 = "r=" + this.Pc + ", l=" + activityInfo.labelRes;
                    b.a();
                    if (activityInfo.labelRes > 0) {
                        String str5 = this.Pc.getString(activityInfo.labelRes);
                        b.a();
                    }
                    d3.set(activity, this.Pc);
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
                    } else if (this.Pc != null) {
                        String str6 = "p= " + bT.pkgPath;
                        b.a();
                        String str7 = "r=" + this.Pc + ", l=" + activityInfo.labelRes;
                        b.a();
                        str = this.Pc.getString(activityInfo.labelRes);
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
                this.Pd.e.setExtrasClassLoader(bT.classLoader);
                activity.setIntent(this.Pd.e);
                if (this.a && Pj != null && this.c != null) {
                    try {
                        Pj.invoke(newInstance, bundle);
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
        if (this.a && Pk != null && this.c != null) {
            try {
                Pk.invoke(this.c, bundle);
            } catch (Throwable th) {
                th.getMessage();
                b.b();
            }
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.a && Pl != null && this.c != null) {
            try {
                Pl.invoke(this.c, new Object[0]);
            } catch (Throwable th) {
                th.getMessage();
                b.b();
            }
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        if (this.a && NR != null && this.c != null) {
            try {
                NR.invoke(this.c, new Object[0]);
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
        if (this.a && NQ != null && this.c != null) {
            try {
                NQ.invoke(this.c, new Object[0]);
            } catch (Throwable th) {
                th.getMessage();
                b.b();
            }
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.a && NP != null && this.c != null) {
            try {
                NP.invoke(this.c, new Object[0]);
            } catch (Throwable th) {
                th.getMessage();
                b.b();
            }
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        if (this.a && NS != null && this.c != null) {
            try {
                NS.invoke(this.c, new Object[0]);
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
            if (this.Pe != null) {
                Configuration configuration2 = this.Pe;
                int i = this.Pf.configChanges;
                int diff = configuration2.diff(configuration);
                if (diff != 0 && (diff & i) == 0) {
                    z = true;
                    if (!z) {
                        try {
                            Pi.setBoolean(this.c, false);
                            z2 = false;
                        } catch (Throwable th) {
                            th.getMessage();
                            b.b();
                            z2 = true;
                        }
                        this.c.onConfigurationChanged(configuration);
                        try {
                            z3 = Pi.getBoolean(this.c);
                        } catch (Throwable th2) {
                            th2.getMessage();
                            b.b();
                            z2 = true;
                        }
                        if (z2 || z3) {
                            try {
                                Ph.setInt(this.c, 0);
                            } catch (Throwable th3) {
                                th3.getMessage();
                                b.b();
                            }
                            try {
                                Pg.set(this.c, new Configuration(configuration));
                            } catch (Throwable th4) {
                                th4.getMessage();
                                b.b();
                            }
                        }
                    }
                    if (this.Pe == null) {
                        this.Pe.updateFrom(configuration);
                        return;
                    }
                    return;
                }
            }
            z = false;
            if (!z) {
            }
            if (this.Pe == null) {
            }
        }
    }
}
