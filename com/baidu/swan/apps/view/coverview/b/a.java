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
    public JSONObject bvm;
    public CoverViewHelper.Type bvn;

    public a(String str) {
        super("viewId", str);
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        super.parseFromJson(jSONObject);
        this.bvm = jSONObject.optJSONObject("transition");
        if (this.aXr != null && this.aEB != null) {
            this.aXr.bV(this.aEB.optBoolean("fixed", false));
        }
    }

    public void a(a aVar, com.baidu.swan.apps.view.container.c.a aVar2) {
        if (aVar != null && aVar2 != null) {
            if (!TextUtils.equals(this.id, aVar.id)) {
                aVar2.fG(63);
            } else if (aVar.bvm != null) {
                aVar2.fG(4);
            } else {
                if (this.aXr != null && !this.aXr.equals(aVar.aXr)) {
                    aVar2.fG(1);
                }
                if (aVar.hidden != this.hidden) {
                    aVar2.fG(8);
                }
                if (aVar.aEB != null && (this.aEB == null || !TextUtils.equals(this.aEB.toString(), aVar.aEB.toString()))) {
                    aVar2.fG(2);
                }
                if (!TextUtils.equals(this.aXm, aVar.aXm) && (TextUtils.equals(this.aXm, "scroll") || TextUtils.equals(aVar.aXm, "scroll"))) {
                    aVar2.fG(16);
                }
                if (!TextUtils.equals(this.aXm, aVar.aXm) || (TextUtils.equals(aVar.aXm, "scroll") && this.aXl != aVar.aXl)) {
                    aVar2.fG(32);
                }
            }
        }
    }

    public static Interpolator jj(@NonNull String str) {
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
        return "CoverViewModel{slaveId='" + this.aXp + "', viewId='" + this.id + "', parentId='" + this.aXq + "', hidden=" + this.hidden + ", position=" + this.aXr + ", styleData=" + this.aEB + ", animData=" + this.bvm + ", type=" + this.bvn + '}';
    }
}
