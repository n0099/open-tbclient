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
    public JSONObject bdf;
    public CoverViewHelper.Type bdg;

    public a(String str) {
        super("viewId", str);
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        super.parseFromJson(jSONObject);
        this.bdf = jSONObject.optJSONObject("transition");
        if (this.aEu != null && this.aly != null) {
            this.aEu.bD(this.aly.optBoolean("fixed", false));
        }
    }

    public void a(a aVar, com.baidu.swan.apps.view.container.c.a aVar2) {
        if (aVar != null && aVar2 != null) {
            if (!TextUtils.equals(this.id, aVar.id)) {
                aVar2.eM(63);
            } else if (aVar.bdf != null) {
                aVar2.eM(4);
            } else {
                if (this.aEu != null && !this.aEu.equals(aVar.aEu)) {
                    aVar2.eM(1);
                }
                if (aVar.hidden != this.hidden) {
                    aVar2.eM(8);
                }
                if (aVar.aly != null && (this.aly == null || !TextUtils.equals(this.aly.toString(), aVar.aly.toString()))) {
                    aVar2.eM(2);
                }
                if (!TextUtils.equals(this.aEp, aVar.aEp) && (TextUtils.equals(this.aEp, "scroll") || TextUtils.equals(aVar.aEp, "scroll"))) {
                    aVar2.eM(16);
                }
                if (!TextUtils.equals(this.aEp, aVar.aEp) || (TextUtils.equals(aVar.aEp, "scroll") && this.aEo != aVar.aEo)) {
                    aVar2.eM(32);
                }
            }
        }
    }

    public static Interpolator iG(@NonNull String str) {
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
        return "CoverViewModel{slaveId='" + this.aEs + "', viewId='" + this.id + "', parentId='" + this.aEt + "', hidden=" + this.hidden + ", position=" + this.aEu + ", styleData=" + this.aly + ", animData=" + this.bdf + ", type=" + this.bdg + '}';
    }
}
