package com.baidu.tbadk.core.frameworkData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.adp.lib.util.f;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class a {
    private Context a;
    private Intent b;
    private IntentAction c = IntentAction.Activity;
    private int d;

    public a(Context context) {
        this.a = null;
        this.b = null;
        if (context == null) {
            throw new InvalidParameterException("ActivitySwitch context null");
        }
        this.a = context;
        this.b = new Intent();
    }

    public final Context c() {
        return this.a;
    }

    public final Intent d() {
        return this.b;
    }

    public boolean a() {
        return true;
    }

    public final void a(IntentAction intentAction) {
        this.c = intentAction;
    }

    public final void a(int i) {
        this.d = i;
    }

    public final void e() {
        if (a()) {
            if (this.c == IntentAction.Activity) {
                f();
            } else if (this.c == IntentAction.ActivityForResult) {
                b(this.d);
            } else if (this.c == IntentAction.StartService) {
                this.a.startService(this.b);
            } else if (this.c == IntentAction.StopService) {
                this.a.stopService(this.b);
            }
        }
    }

    public final void f() {
        this.a.startActivity(this.b);
    }

    public final void b(int i) {
        if (this.a instanceof Activity) {
            ((Activity) this.a).startActivityForResult(this.b, i);
        } else {
            f.b("mContext invalid");
        }
    }
}
