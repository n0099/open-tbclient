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
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.res.ui.FloatButton;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a dhA;
    private FloatButton dhB;
    private JSONObject dhC;
    private Activity mActivity;
    private String mApkName = "";
    private String mText;

    public static a aEp() {
        if (dhA == null) {
            synchronized (a.class) {
                if (dhA == null) {
                    dhA = new a();
                }
            }
        }
        return dhA;
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
            this.mText = ak.isAppInstalled(activity, this.mApkName) ? activity.getString(a.h.swan_app_hover_button_open) : activity.getString(a.h.swan_app_hover_button_download);
            this.dhC = jSONObject.optJSONObject("style");
        }
    }

    public FloatButton aEq() {
        if (!(this.mActivity instanceof SwanAppActivity)) {
            return null;
        }
        if (this.dhB == null) {
            this.dhB = d(this.mActivity, (ViewGroup) this.mActivity.findViewById(16908290));
        }
        this.dhB.setFloatButtonText(this.mText);
        this.dhB.setFloatButtonDrawable(this.mActivity.getResources().getDrawable(a.e.swan_app_hover_button_shape));
        this.dhB.setFloatButtonDefaultPosition();
        this.dhB.setFloatButtonStyle(this.dhC);
        this.dhB.setVisibility(0);
        return this.dhB;
    }

    private FloatButton d(Context context, ViewGroup viewGroup) {
        if (context == null || viewGroup == null) {
            return null;
        }
        FloatButton cu = cu(context);
        viewGroup.addView(cu);
        return cu;
    }

    private FloatButton cu(Context context) {
        if (context == null) {
            return null;
        }
        return (FloatButton) LayoutInflater.from(context.getApplicationContext()).inflate(a.g.swan_app_float_button, (ViewGroup) null);
    }

    public void x(Intent intent) {
        if (intent != null && this.dhB != null) {
            String dataString = intent.getDataString();
            if (!TextUtils.isEmpty(dataString)) {
                String substring = dataString.substring(8);
                if (!TextUtils.isEmpty(substring) && substring.equals(this.mApkName)) {
                    if (TextUtils.equals("android.intent.action.PACKAGE_ADDED", intent.getAction())) {
                        this.mText = this.mActivity.getResources().getString(a.h.swan_app_hover_button_open);
                    } else if (TextUtils.equals("android.intent.action.PACKAGE_REMOVED", intent.getAction())) {
                        this.mText = this.mActivity.getResources().getString(a.h.swan_app_hover_button_download);
                    }
                    this.dhB.setFloatButtonText(this.mText);
                }
            }
        }
    }

    public FloatButton aEr() {
        return this.dhB;
    }

    public void a(FloatButton floatButton) {
        this.dhB = floatButton;
    }

    public void rX(String str) {
        this.mApkName = str;
    }

    public static void release() {
        if (dhA != null) {
            dhA = null;
        }
    }
}
