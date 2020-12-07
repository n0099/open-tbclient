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
/* loaded from: classes25.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a dBp;
    private FloatButton dBq;
    private JSONObject dBr;
    private Activity mActivity;
    private String mApkName = "";
    private String mText;

    public static a aLj() {
        if (dBp == null) {
            synchronized (a.class) {
                if (dBp == null) {
                    dBp = new a();
                }
            }
        }
        return dBp;
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
            this.dBr = jSONObject.optJSONObject("style");
        }
    }

    public FloatButton aLk() {
        if (!(this.mActivity instanceof SwanAppActivity)) {
            return null;
        }
        if (this.dBq == null) {
            this.dBq = d(this.mActivity, (ViewGroup) this.mActivity.findViewById(16908290));
        }
        this.dBq.setFloatButtonText(this.mText);
        this.dBq.setFloatButtonDrawable(this.mActivity.getResources().getDrawable(a.e.swan_app_hover_button_shape));
        this.dBq.setFloatButtonDefaultPosition();
        this.dBq.setFloatButtonStyle(this.dBr);
        this.dBq.setVisibility(0);
        return this.dBq;
    }

    private FloatButton d(Context context, ViewGroup viewGroup) {
        if (context == null || viewGroup == null) {
            return null;
        }
        FloatButton da = da(context);
        viewGroup.addView(da);
        return da;
    }

    private FloatButton da(Context context) {
        if (context == null) {
            return null;
        }
        return (FloatButton) LayoutInflater.from(context.getApplicationContext()).inflate(a.g.swan_app_float_button, (ViewGroup) null);
    }

    public void x(Intent intent) {
        if (intent != null && this.dBq != null) {
            String dataString = intent.getDataString();
            if (!TextUtils.isEmpty(dataString)) {
                String substring = dataString.substring(8);
                if (!TextUtils.isEmpty(substring) && substring.equals(this.mApkName)) {
                    if (TextUtils.equals("android.intent.action.PACKAGE_ADDED", intent.getAction())) {
                        this.mText = this.mActivity.getResources().getString(a.h.swan_app_hover_button_open);
                    } else if (TextUtils.equals("android.intent.action.PACKAGE_REMOVED", intent.getAction())) {
                        this.mText = this.mActivity.getResources().getString(a.h.swan_app_hover_button_download);
                    }
                    this.dBq.setFloatButtonText(this.mText);
                }
            }
        }
    }

    public FloatButton aLl() {
        return this.dBq;
    }

    public void a(FloatButton floatButton) {
        this.dBq = floatButton;
    }

    public void th(String str) {
        this.mApkName = str;
    }

    public static void release() {
        if (dBp != null) {
            dBp = null;
        }
    }
}
