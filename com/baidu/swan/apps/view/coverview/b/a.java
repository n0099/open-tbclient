package com.baidu.swan.apps.view.coverview.b;

import android.support.annotation.NonNull;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.text.TextUtils;
import android.view.animation.Interpolator;
import com.baidu.swan.apps.view.coverview.subview.CoverViewHelper;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends com.baidu.swan.apps.model.a.a.a {
    public JSONObject bcH;
    public CoverViewHelper.Type bcI;

    public a(String str) {
        super("viewId", str);
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        super.parseFromJson(jSONObject);
        this.bcH = jSONObject.optJSONObject("transition");
        if (this.aDW != null && this.akZ != null) {
            this.aDW.bD(this.akZ.optBoolean("fixed", false));
        }
    }

    public void a(a aVar, com.baidu.swan.apps.view.container.c.a aVar2) {
        if (aVar != null && aVar2 != null) {
            if (!TextUtils.equals(this.id, aVar.id)) {
                aVar2.eL(63);
            } else if (aVar.bcH != null) {
                aVar2.eL(4);
            } else {
                if (this.aDW != null && !this.aDW.equals(aVar.aDW)) {
                    aVar2.eL(1);
                }
                if (aVar.hidden != this.hidden) {
                    aVar2.eL(8);
                }
                if (aVar.akZ != null && (this.akZ == null || !TextUtils.equals(this.akZ.toString(), aVar.akZ.toString()))) {
                    aVar2.eL(2);
                }
                if (!TextUtils.equals(this.aDR, aVar.aDR) && (TextUtils.equals(this.aDR, "scroll") || TextUtils.equals(aVar.aDR, "scroll"))) {
                    aVar2.eL(16);
                }
                if (!TextUtils.equals(this.aDR, aVar.aDR) || (TextUtils.equals(aVar.aDR, "scroll") && this.aDQ != aVar.aDQ)) {
                    aVar2.eL(32);
                }
            }
        }
    }

    public static Interpolator iE(@NonNull String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1965120668:
                if (str.equals("ease-in")) {
                    c = 1;
                    break;
                }
                break;
            case -1102672091:
                if (str.equals("linear")) {
                    c = 0;
                    break;
                }
                break;
            case -789192465:
                if (str.equals("ease-out")) {
                    c = 2;
                    break;
                }
                break;
            case -361990811:
                if (str.equals("ease-in-out")) {
                    c = 3;
                    break;
                }
                break;
            case 3105774:
                if (str.equals("ease")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return PathInterpolatorCompat.create(0.0f, 0.0f, 1.0f, 1.0f);
            case 1:
                return PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f);
            case 2:
                return PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
            case 3:
                return PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f);
            default:
                return PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f);
        }
    }

    public String toString() {
        return "CoverViewModel{slaveId='" + this.aDU + "', viewId='" + this.id + "', parentId='" + this.aDV + "', hidden=" + this.hidden + ", position=" + this.aDW + ", styleData=" + this.akZ + ", animData=" + this.bcH + ", type=" + this.bcI + '}';
    }
}
