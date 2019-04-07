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
    public JSONObject aZg;
    public CoverViewHelper.Type aZh;

    public a(String str) {
        super("viewId", str);
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        super.parseFromJson(jSONObject);
        this.aZg = jSONObject.optJSONObject("transition");
        if (this.aBI != null && this.akk != null) {
            this.aBI.bs(this.akk.optBoolean("fixed", false));
        }
    }

    public void a(a aVar, com.baidu.swan.apps.view.container.c.a aVar2) {
        if (aVar != null && aVar2 != null) {
            if (!TextUtils.equals(this.id, aVar.id)) {
                aVar2.ew(63);
            } else if (aVar.aZg != null) {
                aVar2.ew(4);
            } else {
                if (this.aBI != null && !this.aBI.equals(aVar.aBI)) {
                    aVar2.ew(1);
                }
                if (aVar.hidden != this.hidden) {
                    aVar2.ew(8);
                }
                if (aVar.akk != null && (this.akk == null || !TextUtils.equals(this.akk.toString(), aVar.akk.toString()))) {
                    aVar2.ew(2);
                }
                if (!TextUtils.equals(this.aBD, aVar.aBD) && (TextUtils.equals(this.aBD, "scroll") || TextUtils.equals(aVar.aBD, "scroll"))) {
                    aVar2.ew(16);
                }
                if (!TextUtils.equals(this.aBD, aVar.aBD) || (TextUtils.equals(aVar.aBD, "scroll") && this.aBC != aVar.aBC)) {
                    aVar2.ew(32);
                }
            }
        }
    }

    public static Interpolator hT(@NonNull String str) {
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
        return "CoverViewModel{slaveId='" + this.aBG + "', viewId='" + this.id + "', parentId='" + this.aBH + "', hidden=" + this.hidden + ", position=" + this.aBI + ", styleData=" + this.akk + ", animData=" + this.aZg + ", type=" + this.aZh + '}';
    }
}
