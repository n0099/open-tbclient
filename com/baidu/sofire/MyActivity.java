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
import com.baidu.appsearchlib.Info;
import com.baidu.sofire.a;
import com.baidu.sofire.core.ApkInfo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class MyActivity extends Activity {
    public static Method aDP;
    public static Method aDQ;
    public static Method aDR;
    public static Method aDS;
    public static Field aFQ;
    public static Field aFR;
    public static Field aFS;
    public static Method aFT;
    public static Method aFU;
    public static Method aFV;
    public static Method l;
    private Resources aFM;
    protected boolean a = false;
    protected a aFN = new a();
    protected Activity c = null;
    protected Configuration aFO = null;
    protected ActivityInfo aFP = null;

    /* loaded from: classes.dex */
    public static class a {
        public boolean a = false;
        public String b;
        public String c;
        public String d;
        public Intent e;

        public final String toString() {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(getClass().getSimpleName()).append(": mode=").append(this.a).append(", activity=").append(this.b).append(", path=").append(this.c).append(",pkgName=").append(this.d);
                return sb.toString();
            } catch (Throwable th) {
                com.baidu.sofire.b.d.a(th);
                return "";
            }
        }
    }

    static {
        aFQ = null;
        aFR = null;
        aFS = null;
        aFT = null;
        aFU = null;
        aDP = null;
        l = null;
        aDQ = null;
        aDR = null;
        aDS = null;
        aFV = null;
        aFT = f.a((Class<?>) Activity.class, "onCreate", (Class<?>[]) new Class[]{Bundle.class});
        aFU = f.a((Class<?>) Activity.class, "onPostCreate", (Class<?>[]) new Class[]{Bundle.class});
        aDP = f.a((Class<?>) Activity.class, "onStart", (Class<?>[]) new Class[0]);
        l = f.a((Class<?>) Activity.class, "onResume", (Class<?>[]) new Class[0]);
        aDQ = f.a((Class<?>) Activity.class, "onPostResume", (Class<?>[]) new Class[0]);
        aDR = f.a((Class<?>) Activity.class, "onPause", (Class<?>[]) new Class[0]);
        aDS = f.a((Class<?>) Activity.class, "onStop", (Class<?>[]) new Class[0]);
        aFV = f.a((Class<?>) Activity.class, "onDestroy", (Class<?>[]) new Class[0]);
        aFQ = f.d(Activity.class, "mCurrentConfig");
        aFR = f.d(Activity.class, "mConfigChangeFlags");
        aFS = f.d(Activity.class, "mCalled");
    }

    private static boolean a(a aVar, Intent intent) {
        try {
            String stringExtra = intent.getStringExtra("from_plugin_package");
            String stringExtra2 = intent.getStringExtra("target_class");
            if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2)) {
                return false;
            }
            aVar.a = true;
            aVar.d = stringExtra;
            aVar.b = stringExtra2;
            aVar.e = intent;
            return true;
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
            return false;
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        ActivityInfo activityInfo;
        String str;
        int i = 0;
        try {
            com.baidu.sofire.core.e vF = com.baidu.sofire.core.e.vF();
            if (vF == null) {
                super.onCreate(bundle);
                finish();
                return;
            }
            Intent intent = getIntent();
            if ("a".equals(intent.getStringExtra(Info.kBaiduTimeKey))) {
                String stringExtra = intent.getStringExtra("c");
                Intent intent2 = new Intent();
                intent2.putExtra(Info.kBaiduTimeKey, "a");
                intent2.putExtra("c", stringExtra);
                new a.AnonymousClass1(getApplicationContext(), getIntent()).start();
            }
            a(this.aFN, intent);
            this.aFN.toString();
            if (TextUtils.isEmpty(this.aFN.d)) {
                super.onCreate(bundle);
                finish();
                return;
            }
            ApkInfo cm = vF.cm(this.aFN.d);
            if (cm == null || cm.activities == null) {
                super.onCreate(bundle);
                finish();
                return;
            }
            ActivityInfo[] activityInfoArr = cm.activities;
            int length = activityInfoArr.length;
            while (true) {
                if (i >= length) {
                    activityInfo = null;
                    break;
                }
                ActivityInfo activityInfo2 = activityInfoArr[i];
                if (activityInfo2.name.equals(this.aFN.b)) {
                    activityInfo = activityInfo2;
                    break;
                }
                i++;
            }
            if (activityInfo == null) {
                super.onCreate(bundle);
                finish();
                return;
            }
            this.aFP = activityInfo;
            int i2 = activityInfo.theme;
            if (i2 == 0) {
                i2 = cm.applicationTheme;
            }
            int i3 = i2 == 0 ? 16973829 : i2;
            setTheme(i3);
            this.a = true;
            Object newInstance = cm.classLoader.loadClass(this.aFN.b).newInstance();
            if (!(newInstance instanceof Activity)) {
                new StringBuilder().append(newInstance.toString());
                finish();
                return;
            }
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
                }
            }
            if (d2 != null) {
                d2.set(activity, null);
            }
            if (d3 != null) {
                Resources resources = getResources();
                AssetManager assetManager = new AssetManager();
                assetManager.addAssetPath(cm.pkgPath);
                new StringBuilder("p=").append(cm.pkgPath);
                this.aFM = new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                new StringBuilder("r=").append(this.aFM).append(", l=").append(activityInfo.labelRes);
                if (activityInfo.labelRes > 0) {
                    new StringBuilder().append(this.aFM.getString(activityInfo.labelRes));
                }
                d3.set(activity, this.aFM);
            }
            activity.setTheme(i3);
            activity.getTheme().applyStyle(i3, true);
            new StringBuilder().append(i3);
            Window window = activity.getWindow();
            Field d4 = f.d(window.getClass(), "mLayoutInflater");
            if (d4 != null) {
                d4.setAccessible(true);
                try {
                    d4.set(window, ((LayoutInflater) d4.get(window)).cloneInContext(activity));
                } catch (Throwable th2) {
                    th2.getMessage();
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
                }
            }
            Field d7 = f.d(Activity.class, "mComponent");
            if (d7 != null) {
                try {
                    d7.set(activity, new ComponentName(activityInfo.packageName, activityInfo.name));
                } catch (Throwable th4) {
                    th4.getMessage();
                }
            }
            Field d8 = f.d(Activity.class, "mTitle");
            if (d8 != null) {
                if (activityInfo.nonLocalizedLabel != null) {
                    str = activityInfo.nonLocalizedLabel.toString();
                } else if (activityInfo.labelRes != 0) {
                    if (this.aFM != null) {
                        new StringBuilder("p= ").append(cm.pkgPath);
                        new StringBuilder("r=").append(this.aFM).append(", l=").append(activityInfo.labelRes);
                        str = this.aFM.getString(activityInfo.labelRes);
                    } else {
                        str = null;
                    }
                } else if (activityInfo.name != null) {
                    str = activityInfo.name;
                } else {
                    str = activityInfo.packageName;
                }
                try {
                    d8.set(activity, str);
                } catch (Throwable th5) {
                    th5.getMessage();
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
                }
            }
            this.aFN.e.setExtrasClassLoader(cm.classLoader);
            activity.setIntent(this.aFN.e);
            if (this.a && aFT != null && this.c != null) {
                aFT.invoke(newInstance, bundle);
            }
            super.onCreate(bundle);
        } catch (Throwable th7) {
            com.baidu.sofire.b.d.a(th7);
        }
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        try {
            super.onPostCreate(bundle);
            if (this.a && aFU != null && this.c != null) {
                aFU.invoke(this.c, bundle);
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        try {
            super.onDestroy();
            if (this.a && aFV != null && this.c != null) {
                aFV.invoke(this.c, new Object[0]);
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        try {
            super.onPause();
            if (this.a && aDR != null && this.c != null) {
                aDR.invoke(this.c, new Object[0]);
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        try {
            super.onResume();
            if (this.a && l != null && this.c != null) {
                l.invoke(this.c, new Object[0]);
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
        }
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        try {
            super.onPostResume();
            if (this.a && aDQ != null && this.c != null) {
                aDQ.invoke(this.c, new Object[0]);
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        try {
            super.onStart();
            if (this.a && aDP != null && this.c != null) {
                aDP.invoke(this.c, new Object[0]);
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        try {
            super.onStop();
            if (this.a && aDS != null && this.c != null) {
                aDS.invoke(this.c, new Object[0]);
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        try {
            super.onConfigurationChanged(configuration);
            if (this.a && this.c != null) {
                if (!a(configuration)) {
                    aFS.setBoolean(this.c, false);
                    this.c.onConfigurationChanged(configuration);
                    boolean z = aFS.getBoolean(this.c);
                    if (0 != 0 || z) {
                        aFR.setInt(this.c, 0);
                        aFQ.set(this.c, new Configuration(configuration));
                    }
                }
                if (this.aFO != null) {
                    this.aFO.updateFrom(configuration);
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
        }
    }

    private boolean a(Configuration configuration) {
        try {
            if (this.aFO == null) {
                return false;
            }
            Configuration configuration2 = this.aFO;
            int i = this.aFP.configChanges;
            int diff = configuration2.diff(configuration);
            return diff != 0 && (diff & i) == 0;
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
            return false;
        }
    }
}
