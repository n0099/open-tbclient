package com.baidu.swan.apps.scheme.actions.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.res.ui.FloatButton;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a cCD;
    private FloatButton cCE;
    private JSONObject cCF;
    private Activity mActivity;
    private String mApkName = "";
    private String mText;

    public static a apR() {
        if (cCD == null) {
            synchronized (a.class) {
                if (cCD == null) {
                    cCD = new a();
                }
            }
        }
        return cCD;
    }

    private a() {
    }

    public void a(Activity activity, JSONObject jSONObject) {
        if (jSONObject != null) {
            if (DEBUG) {
                Log.i("FloatButtonGuideManager", jSONObject.toString());
            }
            this.mActivity = activity;
            this.mApkName = jSONObject.optString("name");
            this.mText = aj.isAppInstalled(activity, this.mApkName) ? activity.getString(a.h.swan_app_hover_button_open) : activity.getString(a.h.swan_app_hover_button_download);
            this.cCF = jSONObject.optJSONObject("style");
        }
    }

    public FloatButton apS() {
        if (!(this.mActivity instanceof SwanAppActivity)) {
            return null;
        }
        if (this.cCE == null) {
            this.cCE = d(this.mActivity, (ViewGroup) this.mActivity.findViewById(16908290));
        }
        this.cCE.setFloatButtonText(this.mText);
        this.cCE.setFloatButtonDrawable(this.mActivity.getResources().getDrawable(a.e.swan_app_hover_button_shape));
        this.cCE.setFloatButtonDefaultPosition();
        this.cCE.setFloatButtonStyle(this.cCF);
        this.cCE.setVisibility(0);
        return this.cCE;
    }

    private FloatButton d(Context context, ViewGroup viewGroup) {
        if (context == null || viewGroup == null) {
            return null;
        }
        FloatButton cg = cg(context);
        viewGroup.addView(cg);
        return cg;
    }

    private FloatButton cg(Context context) {
        if (context == null) {
            return null;
        }
        return (FloatButton) LayoutInflater.from(context.getApplicationContext()).inflate(a.g.swan_app_float_button, (ViewGroup) null);
    }

    public void v(Intent intent) {
        if (intent != null && this.cCE != null) {
            String dataString = intent.getDataString();
            if (!TextUtils.isEmpty(dataString)) {
                String substring = dataString.substring(8);
                if (!TextUtils.isEmpty(substring) && substring.equals(this.mApkName)) {
                    if (TextUtils.equals("android.intent.action.PACKAGE_ADDED", intent.getAction())) {
                        this.mText = this.mActivity.getResources().getString(a.h.swan_app_hover_button_open);
                    } else if (TextUtils.equals("android.intent.action.PACKAGE_REMOVED", intent.getAction())) {
                        this.mText = this.mActivity.getResources().getString(a.h.swan_app_hover_button_download);
                    }
                    this.cCE.setFloatButtonText(this.mText);
                }
            }
        }
    }

    public FloatButton apT() {
        return this.cCE;
    }

    public void a(FloatButton floatButton) {
        this.cCE = floatButton;
    }

    public void ob(String str) {
        this.mApkName = str;
    }

    public static void release() {
        if (cCD != null) {
            cCD = null;
        }
    }
}
