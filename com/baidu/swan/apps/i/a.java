package com.baidu.swan.apps.i;

import android.content.ContentValues;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public String anA;
    public String anB;
    public String anC;
    public String anD;
    public String anE;
    public String anF;
    public String anG;
    public String anH;
    public String anI;
    public String anJ;
    public String anK;
    public String anL;
    public String anM;
    public String anN;
    public String anO;
    public String anP;
    public String anQ;
    public String anR;
    public String anS;
    public String anT;
    public String anU;
    public String anV;
    public String anW;
    public String anX;
    public String anY;
    public String anZ;
    public String anz;
    public String email;
    public String nickName;
    public String remark;
    public String title;
    public String url;

    public boolean isValid() {
        return !TextUtils.isEmpty(this.anC);
    }

    public static a z(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.anz = jSONObject.optString("photoFilePath");
            aVar.nickName = jSONObject.optString("nickName");
            aVar.anA = jSONObject.optString("lastName");
            aVar.anB = jSONObject.optString("middleName");
            aVar.anC = jSONObject.optString("firstName");
            aVar.remark = jSONObject.optString("remark");
            aVar.anD = jSONObject.optString("mobilePhoneNumber");
            aVar.anE = jSONObject.optString("weChatNumber");
            aVar.anF = jSONObject.optString("addressCountry");
            aVar.anG = jSONObject.optString("addressState");
            aVar.anH = jSONObject.optString("addressCity");
            aVar.anI = jSONObject.optString("addressStreet");
            aVar.anJ = jSONObject.optString("addressPostalCode");
            aVar.anK = jSONObject.optString("organization");
            aVar.title = jSONObject.optString("title");
            aVar.anL = jSONObject.optString("workFaxNumber");
            aVar.anM = jSONObject.optString("workPhoneNumber");
            aVar.anN = jSONObject.optString("hostNumber");
            aVar.email = jSONObject.optString("email");
            aVar.url = jSONObject.optString("url");
            aVar.anO = jSONObject.optString("workAddressCountry");
            aVar.anP = jSONObject.optString("workAddressState");
            aVar.anQ = jSONObject.optString("workAddressCity");
            aVar.anR = jSONObject.optString("workAddressStreet");
            aVar.anS = jSONObject.optString("workAddressPostalCode");
            aVar.anT = jSONObject.optString("homeFaxNumber");
            aVar.anU = jSONObject.optString("homePhoneNumber");
            aVar.anV = jSONObject.optString("homeAddressCountry");
            aVar.anW = jSONObject.optString("homeAddressState");
            aVar.anX = jSONObject.optString("homeAddressCity");
            aVar.anY = jSONObject.optString("homeAddressStreet");
            aVar.anZ = jSONObject.optString("homeAddressPostalCode");
        }
        return aVar;
    }

    public String getDisplayName() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.anA)) {
            sb.append(this.anA);
        }
        if (!TextUtils.isEmpty(this.anB)) {
            sb.append(this.anB);
        }
        if (!TextUtils.isEmpty(this.anC)) {
            sb.append(this.anC);
        }
        return sb.toString();
    }

    public ContentValues wZ() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/nickname");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.nickName);
        return contentValues;
    }

    public ContentValues xa() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/note");
        contentValues.put("data1", this.remark);
        return contentValues;
    }

    public ContentValues xb() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", this.anD);
        return contentValues;
    }

    public ContentValues xc() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.anU);
        return contentValues;
    }

    public ContentValues xd() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", this.anM);
        return contentValues;
    }

    public ContentValues xe() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 10);
        contentValues.put("data1", this.anN);
        return contentValues;
    }

    public ContentValues xf() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 5);
        contentValues.put("data1", this.anT);
        return contentValues;
    }

    public ContentValues xg() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 4);
        contentValues.put("data1", this.anL);
        return contentValues;
    }

    public ContentValues xh() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/im");
        contentValues.put("data5", (Integer) (-1));
        contentValues.put("data6", AppRuntime.getAppContext().getString(a.h.aiapps_cantact_wechat_lable));
        contentValues.put("data1", this.anE);
        return contentValues;
    }

    public ContentValues xi() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/organization");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.anK);
        contentValues.put("data4", this.title);
        return contentValues;
    }

    public ContentValues xj() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/website");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.url);
        return contentValues;
    }

    public ContentValues xk() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", xp());
        contentValues.put("data9", this.anJ);
        return contentValues;
    }

    public ContentValues xl() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", xo());
        contentValues.put("data9", this.anS);
        return contentValues;
    }

    public ContentValues xm() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", xn());
        contentValues.put("data9", this.anZ);
        return contentValues;
    }

    public String xn() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.anV)) {
            sb.append(this.anV);
        }
        if (!TextUtils.isEmpty(this.anW)) {
            sb.append(this.anW);
        }
        if (!TextUtils.isEmpty(this.anX)) {
            sb.append(this.anX);
        }
        if (!TextUtils.isEmpty(this.anY)) {
            sb.append(this.anY);
        }
        if (!TextUtils.isEmpty(this.anZ)) {
            sb.append(" ").append(this.anZ);
        }
        return sb.toString();
    }

    public String xo() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.anO)) {
            sb.append(this.anO);
        }
        if (!TextUtils.isEmpty(this.anP)) {
            sb.append(this.anP);
        }
        if (!TextUtils.isEmpty(this.anQ)) {
            sb.append(this.anQ);
        }
        if (!TextUtils.isEmpty(this.anR)) {
            sb.append(this.anR);
        }
        if (!TextUtils.isEmpty(this.anS)) {
            sb.append(" ").append(this.anS);
        }
        return sb.toString();
    }

    public String xp() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.anF)) {
            sb.append(this.anF);
        }
        if (!TextUtils.isEmpty(this.anG)) {
            sb.append(this.anG);
        }
        if (!TextUtils.isEmpty(this.anH)) {
            sb.append(this.anH);
        }
        if (!TextUtils.isEmpty(this.anI)) {
            sb.append(this.anI);
        }
        if (!TextUtils.isEmpty(this.anJ)) {
            sb.append(" ").append(this.anJ);
        }
        return sb.toString();
    }
}
