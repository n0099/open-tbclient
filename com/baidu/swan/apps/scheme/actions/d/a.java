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
/* loaded from: classes3.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a cVs;
    private FloatButton cVt;
    private JSONObject cVu;
    private Activity mActivity;
    private String mApkName = "";
    private String mText;

    public static a aBG() {
        if (cVs == null) {
            synchronized (a.class) {
                if (cVs == null) {
                    cVs = new a();
                }
            }
        }
        return cVs;
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
            this.cVu = jSONObject.optJSONObject("style");
        }
    }

    public FloatButton aBH() {
        if (!(this.mActivity instanceof SwanAppActivity)) {
            return null;
        }
        if (this.cVt == null) {
            this.cVt = d(this.mActivity, (ViewGroup) this.mActivity.findViewById(16908290));
        }
        this.cVt.setFloatButtonText(this.mText);
        this.cVt.setFloatButtonDrawable(this.mActivity.getResources().getDrawable(a.e.swan_app_hover_button_shape));
        this.cVt.setFloatButtonDefaultPosition();
        this.cVt.setFloatButtonStyle(this.cVu);
        this.cVt.setVisibility(0);
        return this.cVt;
    }

    private FloatButton d(Context context, ViewGroup viewGroup) {
        if (context == null || viewGroup == null) {
            return null;
        }
        FloatButton co = co(context);
        viewGroup.addView(co);
        return co;
    }

    private FloatButton co(Context context) {
        if (context == null) {
            return null;
        }
        return (FloatButton) LayoutInflater.from(context.getApplicationContext()).inflate(a.g.swan_app_float_button, (ViewGroup) null);
    }

    public void x(Intent intent) {
        if (intent != null && this.cVt != null) {
            String dataString = intent.getDataString();
            if (!TextUtils.isEmpty(dataString)) {
                String substring = dataString.substring(8);
                if (!TextUtils.isEmpty(substring) && substring.equals(this.mApkName)) {
                    if (TextUtils.equals("android.intent.action.PACKAGE_ADDED", intent.getAction())) {
                        this.mText = this.mActivity.getResources().getString(a.h.swan_app_hover_button_open);
                    } else if (TextUtils.equals("android.intent.action.PACKAGE_REMOVED", intent.getAction())) {
                        this.mText = this.mActivity.getResources().getString(a.h.swan_app_hover_button_download);
                    }
                    this.cVt.setFloatButtonText(this.mText);
                }
            }
        }
    }

    public FloatButton aBI() {
        return this.cVt;
    }

    public void a(FloatButton floatButton) {
        this.cVt = floatButton;
    }

    public void rl(String str) {
        this.mApkName = str;
    }

    public static void release() {
        if (cVs != null) {
            cVs = null;
        }
    }
}
