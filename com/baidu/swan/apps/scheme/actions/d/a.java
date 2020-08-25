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
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a cTo;
    private FloatButton cTp;
    private JSONObject cTq;
    private Activity mActivity;
    private String mApkName = "";
    private String mText;

    public static a aAX() {
        if (cTo == null) {
            synchronized (a.class) {
                if (cTo == null) {
                    cTo = new a();
                }
            }
        }
        return cTo;
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
            this.cTq = jSONObject.optJSONObject("style");
        }
    }

    public FloatButton aAY() {
        if (!(this.mActivity instanceof SwanAppActivity)) {
            return null;
        }
        if (this.cTp == null) {
            this.cTp = d(this.mActivity, (ViewGroup) this.mActivity.findViewById(16908290));
        }
        this.cTp.setFloatButtonText(this.mText);
        this.cTp.setFloatButtonDrawable(this.mActivity.getResources().getDrawable(a.e.swan_app_hover_button_shape));
        this.cTp.setFloatButtonDefaultPosition();
        this.cTp.setFloatButtonStyle(this.cTq);
        this.cTp.setVisibility(0);
        return this.cTp;
    }

    private FloatButton d(Context context, ViewGroup viewGroup) {
        if (context == null || viewGroup == null) {
            return null;
        }
        FloatButton cp = cp(context);
        viewGroup.addView(cp);
        return cp;
    }

    private FloatButton cp(Context context) {
        if (context == null) {
            return null;
        }
        return (FloatButton) LayoutInflater.from(context.getApplicationContext()).inflate(a.g.swan_app_float_button, (ViewGroup) null);
    }

    public void x(Intent intent) {
        if (intent != null && this.cTp != null) {
            String dataString = intent.getDataString();
            if (!TextUtils.isEmpty(dataString)) {
                String substring = dataString.substring(8);
                if (!TextUtils.isEmpty(substring) && substring.equals(this.mApkName)) {
                    if (TextUtils.equals("android.intent.action.PACKAGE_ADDED", intent.getAction())) {
                        this.mText = this.mActivity.getResources().getString(a.h.swan_app_hover_button_open);
                    } else if (TextUtils.equals("android.intent.action.PACKAGE_REMOVED", intent.getAction())) {
                        this.mText = this.mActivity.getResources().getString(a.h.swan_app_hover_button_download);
                    }
                    this.cTp.setFloatButtonText(this.mText);
                }
            }
        }
    }

    public FloatButton aAZ() {
        return this.cTp;
    }

    public void a(FloatButton floatButton) {
        this.cTp = floatButton;
    }

    public void qR(String str) {
        this.mApkName = str;
    }

    public static void release() {
        if (cTo != null) {
            cTo = null;
        }
    }
}
