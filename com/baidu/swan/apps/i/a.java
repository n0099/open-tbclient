package com.baidu.swan.apps.i;

import android.content.ContentValues;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
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
    public String aoa;
    public String aob;
    public String aoc;
    public String aod;
    public String email;
    public String nickName;
    public String remark;
    public String title;
    public String url;

    public boolean isValid() {
        return !TextUtils.isEmpty(this.anG);
    }

    public static a z(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.anD = jSONObject.optString("photoFilePath");
            aVar.nickName = jSONObject.optString("nickName");
            aVar.anE = jSONObject.optString("lastName");
            aVar.anF = jSONObject.optString("middleName");
            aVar.anG = jSONObject.optString("firstName");
            aVar.remark = jSONObject.optString("remark");
            aVar.anH = jSONObject.optString("mobilePhoneNumber");
            aVar.anI = jSONObject.optString("weChatNumber");
            aVar.anJ = jSONObject.optString("addressCountry");
            aVar.anK = jSONObject.optString("addressState");
            aVar.anL = jSONObject.optString("addressCity");
            aVar.anM = jSONObject.optString("addressStreet");
            aVar.anN = jSONObject.optString("addressPostalCode");
            aVar.anO = jSONObject.optString("organization");
            aVar.title = jSONObject.optString("title");
            aVar.anP = jSONObject.optString("workFaxNumber");
            aVar.anQ = jSONObject.optString("workPhoneNumber");
            aVar.anR = jSONObject.optString("hostNumber");
            aVar.email = jSONObject.optString("email");
            aVar.url = jSONObject.optString("url");
            aVar.anS = jSONObject.optString("workAddressCountry");
            aVar.anT = jSONObject.optString("workAddressState");
            aVar.anU = jSONObject.optString("workAddressCity");
            aVar.anV = jSONObject.optString("workAddressStreet");
            aVar.anW = jSONObject.optString("workAddressPostalCode");
            aVar.anX = jSONObject.optString("homeFaxNumber");
            aVar.anY = jSONObject.optString("homePhoneNumber");
            aVar.anZ = jSONObject.optString("homeAddressCountry");
            aVar.aoa = jSONObject.optString("homeAddressState");
            aVar.aob = jSONObject.optString("homeAddressCity");
            aVar.aoc = jSONObject.optString("homeAddressStreet");
            aVar.aod = jSONObject.optString("homeAddressPostalCode");
        }
        return aVar;
    }

    public String getDisplayName() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.anE)) {
            sb.append(this.anE);
        }
        if (!TextUtils.isEmpty(this.anF)) {
            sb.append(this.anF);
        }
        if (!TextUtils.isEmpty(this.anG)) {
            sb.append(this.anG);
        }
        return sb.toString();
    }

    public ContentValues wY() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/nickname");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.nickName);
        return contentValues;
    }

    public ContentValues wZ() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/note");
        contentValues.put("data1", this.remark);
        return contentValues;
    }

    public ContentValues xa() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", this.anH);
        return contentValues;
    }

    public ContentValues xb() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.anY);
        return contentValues;
    }

    public ContentValues xc() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", this.anQ);
        return contentValues;
    }

    public ContentValues xd() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 10);
        contentValues.put("data1", this.anR);
        return contentValues;
    }

    public ContentValues xe() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 5);
        contentValues.put("data1", this.anX);
        return contentValues;
    }

    public ContentValues xf() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 4);
        contentValues.put("data1", this.anP);
        return contentValues;
    }

    public ContentValues xg() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/im");
        contentValues.put("data5", (Integer) (-1));
        contentValues.put("data6", AppRuntime.getAppContext().getString(a.h.aiapps_cantact_wechat_lable));
        contentValues.put("data1", this.anI);
        return contentValues;
    }

    public ContentValues xh() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/organization");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.anO);
        contentValues.put("data4", this.title);
        return contentValues;
    }

    public ContentValues xi() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/website");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.url);
        return contentValues;
    }

    public ContentValues xj() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", xo());
        contentValues.put("data9", this.anN);
        return contentValues;
    }

    public ContentValues xk() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", xn());
        contentValues.put("data9", this.anW);
        return contentValues;
    }

    public ContentValues xl() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", xm());
        contentValues.put("data9", this.aod);
        return contentValues;
    }

    public String xm() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.anZ)) {
            sb.append(this.anZ);
        }
        if (!TextUtils.isEmpty(this.aoa)) {
            sb.append(this.aoa);
        }
        if (!TextUtils.isEmpty(this.aob)) {
            sb.append(this.aob);
        }
        if (!TextUtils.isEmpty(this.aoc)) {
            sb.append(this.aoc);
        }
        if (!TextUtils.isEmpty(this.aod)) {
            sb.append(" ").append(this.aod);
        }
        return sb.toString();
    }

    public String xn() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.anS)) {
            sb.append(this.anS);
        }
        if (!TextUtils.isEmpty(this.anT)) {
            sb.append(this.anT);
        }
        if (!TextUtils.isEmpty(this.anU)) {
            sb.append(this.anU);
        }
        if (!TextUtils.isEmpty(this.anV)) {
            sb.append(this.anV);
        }
        if (!TextUtils.isEmpty(this.anW)) {
            sb.append(" ").append(this.anW);
        }
        return sb.toString();
    }

    public String xo() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.anJ)) {
            sb.append(this.anJ);
        }
        if (!TextUtils.isEmpty(this.anK)) {
            sb.append(this.anK);
        }
        if (!TextUtils.isEmpty(this.anL)) {
            sb.append(this.anL);
        }
        if (!TextUtils.isEmpty(this.anM)) {
            sb.append(this.anM);
        }
        if (!TextUtils.isEmpty(this.anN)) {
            sb.append(" ").append(this.anN);
        }
        return sb.toString();
    }
}
