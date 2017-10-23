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
    public static Method NV;
    public static Method NW;
    public static Method NX;
    public static Method NY;
    public static Field Pj;
    public static Field Pk;
    public static Field Pl;
    public static Method Pm;
    public static Method Pn;
    public static Method Po;
    public static Method l;
    private Resources Pf;
    protected boolean a = false;
    protected a Pg = new a();
    protected Activity c = null;
    protected Configuration Ph = null;
    protected ActivityInfo Pi = null;

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
        Pj = null;
        Pk = null;
        Pl = null;
        Pm = null;
        Pn = null;
        NV = null;
        l = null;
        NW = null;
        NX = null;
        NY = null;
        Po = null;
        Pm = f.a((Class<?>) Activity.class, "onCreate", (Class<?>[]) new Class[]{Bundle.class});
        Pn = f.a((Class<?>) Activity.class, "onPostCreate", (Class<?>[]) new Class[]{Bundle.class});
        NV = f.a((Class<?>) Activity.class, "onStart", (Class<?>[]) new Class[0]);
        l = f.a((Class<?>) Activity.class, "onResume", (Class<?>[]) new Class[0]);
        NW = f.a((Class<?>) Activity.class, "onPostResume", (Class<?>[]) new Class[0]);
        NX = f.a((Class<?>) Activity.class, "onPause", (Class<?>[]) new Class[0]);
        NY = f.a((Class<?>) Activity.class, "onStop", (Class<?>[]) new Class[0]);
        Po = f.a((Class<?>) Activity.class, "onDestroy", (Class<?>[]) new Class[0]);
        Pj = f.d(Activity.class, "mCurrentConfig");
        Pk = f.d(Activity.class, "mConfigChangeFlags");
        Pl = f.d(Activity.class, "mCalled");
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
        com.baidu.sofire.core.e nk = com.baidu.sofire.core.e.nk();
        if (nk == null) {
            b.a();
            super.onCreate(bundle);
            finish();
            return;
        }
        a aVar = this.Pg;
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("from_plugin_package");
        String stringExtra2 = intent.getStringExtra("target_class");
        if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
            aVar.a = true;
            aVar.d = stringExtra;
            aVar.b = stringExtra2;
            aVar.e = intent;
        }
        this.Pg.toString();
        b.a();
        if (TextUtils.isEmpty(this.Pg.d)) {
            b.a();
            super.onCreate(bundle);
            finish();
            return;
        }
        ApkInfo bS = nk.bS(this.Pg.d);
        if (bS == null || bS.activities == null) {
            b.a();
            super.onCreate(bundle);
            finish();
            return;
        }
        ActivityInfo[] activityInfoArr = bS.activities;
        int length = activityInfoArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                activityInfo = null;
                break;
            }
            ActivityInfo activityInfo2 = activityInfoArr[i];
            if (activityInfo2.name.equals(this.Pg.b)) {
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
        this.Pi = activityInfo;
        int i2 = activityInfo.theme;
        if (i2 == 0) {
            i2 = bS.applicationTheme;
        }
        int i3 = i2 == 0 ? 16973829 : i2;
        setTheme(i3);
        this.a = true;
        try {
            Object newInstance = bS.classLoader.loadClass(this.Pg.b).newInstance();
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
                    assetManager.addAssetPath(bS.pkgPath);
                    String str3 = "p=" + bS.pkgPath;
                    b.a();
                    this.Pf = new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                    String str4 = "r=" + this.Pf + ", l=" + activityInfo.labelRes;
                    b.a();
                    if (activityInfo.labelRes > 0) {
                        String str5 = this.Pf.getString(activityInfo.labelRes);
                        b.a();
                    }
                    d3.set(activity, this.Pf);
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
                    } else if (this.Pf != null) {
                        String str6 = "p= " + bS.pkgPath;
                        b.a();
                        String str7 = "r=" + this.Pf + ", l=" + activityInfo.labelRes;
                        b.a();
                        str = this.Pf.getString(activityInfo.labelRes);
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
                this.Pg.e.setExtrasClassLoader(bS.classLoader);
                activity.setIntent(this.Pg.e);
                if (this.a && Pm != null && this.c != null) {
                    try {
                        Pm.invoke(newInstance, bundle);
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
        if (this.a && Pn != null && this.c != null) {
            try {
                Pn.invoke(this.c, bundle);
            } catch (Throwable th) {
                th.getMessage();
                b.b();
            }
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.a && Po != null && this.c != null) {
            try {
                Po.invoke(this.c, new Object[0]);
            } catch (Throwable th) {
                th.getMessage();
                b.b();
            }
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        if (this.a && NX != null && this.c != null) {
            try {
                NX.invoke(this.c, new Object[0]);
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
        if (this.a && NW != null && this.c != null) {
            try {
                NW.invoke(this.c, new Object[0]);
            } catch (Throwable th) {
                th.getMessage();
                b.b();
            }
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.a && NV != null && this.c != null) {
            try {
                NV.invoke(this.c, new Object[0]);
            } catch (Throwable th) {
                th.getMessage();
                b.b();
            }
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        if (this.a && NY != null && this.c != null) {
            try {
                NY.invoke(this.c, new Object[0]);
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
            if (this.Ph != null) {
                Configuration configuration2 = this.Ph;
                int i = this.Pi.configChanges;
                int diff = configuration2.diff(configuration);
                if (diff != 0 && (diff & i) == 0) {
                    z = true;
                    if (!z) {
                        try {
                            Pl.setBoolean(this.c, false);
                            z2 = false;
                        } catch (Throwable th) {
                            th.getMessage();
                            b.b();
                            z2 = true;
                        }
                        this.c.onConfigurationChanged(configuration);
                        try {
                            z3 = Pl.getBoolean(this.c);
                        } catch (Throwable th2) {
                            th2.getMessage();
                            b.b();
                            z2 = true;
                        }
                        if (z2 || z3) {
                            try {
                                Pk.setInt(this.c, 0);
                            } catch (Throwable th3) {
                                th3.getMessage();
                                b.b();
                            }
                            try {
                                Pj.set(this.c, new Configuration(configuration));
                            } catch (Throwable th4) {
                                th4.getMessage();
                                b.b();
                            }
                        }
                    }
                    if (this.Ph == null) {
                        this.Ph.updateFrom(configuration);
                        return;
                    }
                    return;
                }
            }
            z = false;
            if (!z) {
            }
            if (this.Ph == null) {
            }
        }
    }
}
