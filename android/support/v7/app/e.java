package android.support.v7.app;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.b;
import android.support.v7.view.SupportActionModeWrapper;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ActionMode;
import android.view.Window;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class e extends d {
    private int CF;
    private boolean CG;
    private boolean CH;
    private b CI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Context context, Window window, AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
        this.CF = -100;
        this.CH = true;
    }

    @Override // android.support.v7.app.AppCompatDelegateImplV9, android.support.v7.app.AppCompatDelegate
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null && this.CF == -100) {
            this.CF = bundle.getInt("appcompat:local_night_mode", -100);
        }
    }

    @Override // android.support.v7.app.b
    Window.Callback a(Window.Callback callback) {
        return new a(callback);
    }

    @Override // android.support.v7.app.b, android.support.v7.app.AppCompatDelegate
    public void setHandleNativeActionModesEnabled(boolean z) {
        this.CH = z;
    }

    @Override // android.support.v7.app.b, android.support.v7.app.AppCompatDelegate
    public boolean isHandleNativeActionModesEnabled() {
        return this.CH;
    }

    @Override // android.support.v7.app.b, android.support.v7.app.AppCompatDelegate
    public boolean applyDayNight() {
        boolean z = false;
        int nightMode = getNightMode();
        int ax = ax(nightMode);
        if (ax != -1) {
            z = ay(ax);
        }
        if (nightMode == 0) {
            dX();
            this.CI.setup();
        }
        this.CG = true;
        return z;
    }

    @Override // android.support.v7.app.b, android.support.v7.app.AppCompatDelegate
    public void onStart() {
        super.onStart();
        applyDayNight();
    }

    @Override // android.support.v7.app.AppCompatDelegateImplV9, android.support.v7.app.b, android.support.v7.app.AppCompatDelegate
    public void onStop() {
        super.onStop();
        if (this.CI != null) {
            this.CI.eb();
        }
    }

    @Override // android.support.v7.app.b, android.support.v7.app.AppCompatDelegate
    public void setLocalNightMode(int i) {
        switch (i) {
            case -1:
            case 0:
            case 1:
            case 2:
                if (this.CF != i) {
                    this.CF = i;
                    if (this.CG) {
                        applyDayNight();
                        return;
                    }
                    return;
                }
                return;
            default:
                Log.i("AppCompatDelegate", "setLocalNightMode() called with an unknown mode");
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int ax(int i) {
        switch (i) {
            case -100:
                return -1;
            case 0:
                dX();
                return this.CI.dZ();
            default:
                return i;
        }
    }

    private int getNightMode() {
        return this.CF != -100 ? this.CF : getDefaultNightMode();
    }

    @Override // android.support.v7.app.b, android.support.v7.app.AppCompatDelegate
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.CF != -100) {
            bundle.putInt("appcompat:local_night_mode", this.CF);
        }
    }

    @Override // android.support.v7.app.AppCompatDelegateImplV9, android.support.v7.app.b, android.support.v7.app.AppCompatDelegate
    public void onDestroy() {
        super.onDestroy();
        if (this.CI != null) {
            this.CI.eb();
        }
    }

    private boolean ay(int i) {
        Resources resources = this.mContext.getResources();
        Configuration configuration = resources.getConfiguration();
        int i2 = configuration.uiMode & 48;
        int i3 = i == 2 ? 32 : 16;
        if (i2 != i3) {
            if (dY()) {
                ((Activity) this.mContext).recreate();
            } else {
                Configuration configuration2 = new Configuration(configuration);
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                float f = configuration2.fontScale;
                configuration2.uiMode = i3 | (configuration2.uiMode & (-49));
                configuration2.fontScale = 2.0f * f;
                resources.updateConfiguration(configuration2, displayMetrics);
                configuration2.fontScale = f;
                resources.updateConfiguration(configuration2, displayMetrics);
            }
            return true;
        }
        return false;
    }

    private void dX() {
        if (this.CI == null) {
            this.CI = new b(o.W(this.mContext));
        }
    }

    private boolean dY() {
        if (this.CG && (this.mContext instanceof Activity)) {
            try {
                return (this.mContext.getPackageManager().getActivityInfo(new ComponentName(this.mContext, this.mContext.getClass()), 0).configChanges & 512) == 0;
            } catch (PackageManager.NameNotFoundException e) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e);
                return true;
            }
        }
        return false;
    }

    /* loaded from: classes2.dex */
    class a extends b.C0009b {
        /* JADX INFO: Access modifiers changed from: package-private */
        public a(Window.Callback callback) {
            super(callback);
        }

        @Override // android.support.v7.view.WindowCallbackWrapper, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return e.this.isHandleNativeActionModesEnabled() ? a(callback) : super.onWindowStartingActionMode(callback);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final ActionMode a(ActionMode.Callback callback) {
            SupportActionModeWrapper.CallbackWrapper callbackWrapper = new SupportActionModeWrapper.CallbackWrapper(e.this.mContext, callback);
            android.support.v7.view.ActionMode startSupportActionMode = e.this.startSupportActionMode(callbackWrapper);
            if (startSupportActionMode != null) {
                return callbackWrapper.getActionModeWrapper(startSupportActionMode);
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class b {
        private o CK;
        private boolean CL;
        private BroadcastReceiver CM;
        private IntentFilter CN;

        b(o oVar) {
            this.CK = oVar;
            this.CL = oVar.isNight();
        }

        final int dZ() {
            return this.CL ? 2 : 1;
        }

        final void ea() {
            boolean isNight = this.CK.isNight();
            if (isNight != this.CL) {
                this.CL = isNight;
                e.this.applyDayNight();
            }
        }

        final void setup() {
            eb();
            if (this.CM == null) {
                this.CM = new BroadcastReceiver() { // from class: android.support.v7.app.e.b.1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent) {
                        b.this.ea();
                    }
                };
            }
            if (this.CN == null) {
                this.CN = new IntentFilter();
                this.CN.addAction("android.intent.action.TIME_SET");
                this.CN.addAction("android.intent.action.TIMEZONE_CHANGED");
                this.CN.addAction("android.intent.action.TIME_TICK");
            }
            e.this.mContext.registerReceiver(this.CM, this.CN);
        }

        final void eb() {
            if (this.CM != null) {
                e.this.mContext.unregisterReceiver(this.CM);
                this.CM = null;
            }
        }
    }
}
