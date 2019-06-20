package com.baidu.swan.apps.scheme.actions.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.res.ui.FloatButton;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a aSt;
    private FloatButton aSu;
    private JSONObject aSv;
    private String aSw = "";
    private String ama;
    private Activity mActivity;

    public static a Mf() {
        if (aSt == null) {
            synchronized (a.class) {
                if (aSt == null) {
                    aSt = new a();
                }
            }
        }
        return aSt;
    }

    private a() {
    }

    public void a(Activity activity, JSONObject jSONObject) {
        if (jSONObject != null) {
            if (DEBUG) {
                Log.i("FloatButtonGuideManager", jSONObject.toString());
            }
            this.mActivity = activity;
            this.aSw = jSONObject.optString("name");
            this.ama = ac.isAppInstalled(activity, this.aSw) ? activity.getString(a.h.swan_app_hover_button_open) : activity.getString(a.h.swan_app_hover_button_download);
            this.aSv = jSONObject.optJSONObject(UnitedSchemeConstants.UNITED_SCHEME_STYLE);
        }
    }

    public FloatButton Mg() {
        if (!(this.mActivity instanceof SwanAppActivity)) {
            return null;
        }
        if (this.aSu == null) {
            this.aSu = e(this.mActivity, (ViewGroup) this.mActivity.findViewById(16908290));
        }
        this.aSu.setFloatButtonText(this.ama);
        this.aSu.setFloatButtonDrawable(this.mActivity.getResources().getDrawable(a.e.swan_app_hover_button_shape));
        this.aSu.setFloatButtonDefaultPosition();
        this.aSu.setFloatButtonStyle(this.aSv);
        this.aSu.setVisibility(0);
        return this.aSu;
    }

    private FloatButton e(Context context, ViewGroup viewGroup) {
        if (context == null || viewGroup == null) {
            return null;
        }
        FloatButton bA = bA(context);
        viewGroup.addView(bA);
        return bA;
    }

    private FloatButton bA(Context context) {
        if (context == null) {
            return null;
        }
        return (FloatButton) LayoutInflater.from(context.getApplicationContext()).inflate(a.g.swan_app_float_button, (ViewGroup) null);
    }

    public void L(Intent intent) {
        if (intent != null && this.aSu != null) {
            String dataString = intent.getDataString();
            if (!TextUtils.isEmpty(dataString)) {
                String substring = dataString.substring(8);
                if (!TextUtils.isEmpty(substring) && substring.equals(this.aSw)) {
                    if (TextUtils.equals("android.intent.action.PACKAGE_ADDED", intent.getAction())) {
                        this.ama = this.mActivity.getResources().getString(a.h.swan_app_hover_button_open);
                    } else if (TextUtils.equals("android.intent.action.PACKAGE_REMOVED", intent.getAction())) {
                        this.ama = this.mActivity.getResources().getString(a.h.swan_app_hover_button_download);
                    }
                    this.aSu.setFloatButtonText(this.ama);
                }
            }
        }
    }

    public FloatButton Mh() {
        return this.aSu;
    }

    public void a(FloatButton floatButton) {
        this.aSu = floatButton;
    }

    public void gY(String str) {
        this.aSw = str;
    }

    public static void release() {
        if (aSt != null) {
            aSt = null;
        }
    }
}
