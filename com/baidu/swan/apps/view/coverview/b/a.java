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
    public JSONObject bwd;
    public CoverViewHelper.Type bwe;

    public a(String str) {
        super("viewId", str);
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        super.parseFromJson(jSONObject);
        this.bwd = jSONObject.optJSONObject("transition");
        if (this.aXJ != null && this.aET != null) {
            this.aXJ.bV(this.aET.optBoolean("fixed", false));
        }
    }

    public void a(a aVar, com.baidu.swan.apps.view.container.c.a aVar2) {
        if (aVar != null && aVar2 != null) {
            if (!TextUtils.equals(this.id, aVar.id)) {
                aVar2.fH(63);
            } else if (aVar.bwd != null) {
                aVar2.fH(4);
            } else {
                if (this.aXJ != null && !this.aXJ.equals(aVar.aXJ)) {
                    aVar2.fH(1);
                }
                if (aVar.hidden != this.hidden) {
                    aVar2.fH(8);
                }
                if (aVar.aET != null && (this.aET == null || !TextUtils.equals(this.aET.toString(), aVar.aET.toString()))) {
                    aVar2.fH(2);
                }
                if (!TextUtils.equals(this.aXE, aVar.aXE) && (TextUtils.equals(this.aXE, "scroll") || TextUtils.equals(aVar.aXE, "scroll"))) {
                    aVar2.fH(16);
                }
                if (!TextUtils.equals(this.aXE, aVar.aXE) || (TextUtils.equals(aVar.aXE, "scroll") && this.aXD != aVar.aXD)) {
                    aVar2.fH(32);
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
        return "CoverViewModel{slaveId='" + this.aXH + "', viewId='" + this.id + "', parentId='" + this.aXI + "', hidden=" + this.hidden + ", position=" + this.aXJ + ", styleData=" + this.aET + ", animData=" + this.bwd + ", type=" + this.bwe + '}';
    }
}
