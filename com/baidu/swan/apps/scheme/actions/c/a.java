package com.baidu.swan.apps.scheme.actions.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.res.ui.FloatButton;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a bmn;
    private FloatButton bmo;
    private JSONObject bmq;
    private String bmr = "";
    private Activity mActivity;
    private String mText;

    public static a RP() {
        if (bmn == null) {
            synchronized (a.class) {
                if (bmn == null) {
                    bmn = new a();
                }
            }
        }
        return bmn;
    }

    private a() {
    }

    public void a(Activity activity, JSONObject jSONObject) {
        if (jSONObject != null) {
            if (DEBUG) {
                Log.i("FloatButtonGuideManager", jSONObject.toString());
            }
            this.mActivity = activity;
            this.bmr = jSONObject.optString("name");
            this.mText = ac.isAppInstalled(activity, this.bmr) ? activity.getString(a.h.swan_app_hover_button_open) : activity.getString(a.h.swan_app_hover_button_download);
            this.bmq = jSONObject.optJSONObject("style");
        }
    }

    public FloatButton RQ() {
        if (!(this.mActivity instanceof SwanAppActivity)) {
            return null;
        }
        if (this.bmo == null) {
            this.bmo = e(this.mActivity, (ViewGroup) this.mActivity.findViewById(16908290));
        }
        this.bmo.setFloatButtonText(this.mText);
        this.bmo.setFloatButtonDrawable(this.mActivity.getResources().getDrawable(a.e.swan_app_hover_button_shape));
        this.bmo.setFloatButtonDefaultPosition();
        this.bmo.setFloatButtonStyle(this.bmq);
        this.bmo.setVisibility(0);
        return this.bmo;
    }

    private FloatButton e(Context context, ViewGroup viewGroup) {
        if (context == null || viewGroup == null) {
            return null;
        }
        FloatButton bB = bB(context);
        viewGroup.addView(bB);
        return bB;
    }

    private FloatButton bB(Context context) {
        if (context == null) {
            return null;
        }
        return (FloatButton) LayoutInflater.from(context.getApplicationContext()).inflate(a.g.swan_app_float_button, (ViewGroup) null);
    }

    public void R(Intent intent) {
        if (intent != null && this.bmo != null) {
            String dataString = intent.getDataString();
            if (!TextUtils.isEmpty(dataString)) {
                String substring = dataString.substring(8);
                if (!TextUtils.isEmpty(substring) && substring.equals(this.bmr)) {
                    if (TextUtils.equals("android.intent.action.PACKAGE_ADDED", intent.getAction())) {
                        this.mText = this.mActivity.getResources().getString(a.h.swan_app_hover_button_open);
                    } else if (TextUtils.equals("android.intent.action.PACKAGE_REMOVED", intent.getAction())) {
                        this.mText = this.mActivity.getResources().getString(a.h.swan_app_hover_button_download);
                    }
                    this.bmo.setFloatButtonText(this.mText);
                }
            }
        }
    }

    public FloatButton RR() {
        return this.bmo;
    }

    public void a(FloatButton floatButton) {
        this.bmo = floatButton;
    }

    public void hK(String str) {
        this.bmr = str;
    }

    public static void release() {
        if (bmn != null) {
            bmn = null;
        }
    }
}
