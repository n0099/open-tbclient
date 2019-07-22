package com.baidu.swan.apps.i;

import android.content.ContentValues;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public String aoA;
    public String aoB;
    public String aoC;
    public String aoD;
    public String aoE;
    public String aoF;
    public String aoG;
    public String aoH;
    public String aoI;
    public String aoJ;
    public String aoK;
    public String aoL;
    public String aoM;
    public String aoN;
    public String aoO;
    public String aoP;
    public String aoQ;
    public String aoR;
    public String aoS;
    public String aoT;
    public String aot;
    public String aou;
    public String aov;
    public String aow;
    public String aox;
    public String aoy;
    public String aoz;
    public String email;
    public String nickName;
    public String remark;
    public String title;
    public String url;

    public boolean isValid() {
        return !TextUtils.isEmpty(this.aow);
    }

    public static a u(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.aot = jSONObject.optString("photoFilePath");
            aVar.nickName = jSONObject.optString("nickName");
            aVar.aou = jSONObject.optString("lastName");
            aVar.aov = jSONObject.optString("middleName");
            aVar.aow = jSONObject.optString("firstName");
            aVar.remark = jSONObject.optString("remark");
            aVar.aox = jSONObject.optString("mobilePhoneNumber");
            aVar.aoy = jSONObject.optString("weChatNumber");
            aVar.aoz = jSONObject.optString("addressCountry");
            aVar.aoA = jSONObject.optString("addressState");
            aVar.aoB = jSONObject.optString("addressCity");
            aVar.aoC = jSONObject.optString("addressStreet");
            aVar.aoD = jSONObject.optString("addressPostalCode");
            aVar.aoE = jSONObject.optString("organization");
            aVar.title = jSONObject.optString("title");
            aVar.aoF = jSONObject.optString("workFaxNumber");
            aVar.aoG = jSONObject.optString("workPhoneNumber");
            aVar.aoH = jSONObject.optString("hostNumber");
            aVar.email = jSONObject.optString(NotificationCompat.CATEGORY_EMAIL);
            aVar.url = jSONObject.optString("url");
            aVar.aoI = jSONObject.optString("workAddressCountry");
            aVar.aoJ = jSONObject.optString("workAddressState");
            aVar.aoK = jSONObject.optString("workAddressCity");
            aVar.aoL = jSONObject.optString("workAddressStreet");
            aVar.aoM = jSONObject.optString("workAddressPostalCode");
            aVar.aoN = jSONObject.optString("homeFaxNumber");
            aVar.aoO = jSONObject.optString("homePhoneNumber");
            aVar.aoP = jSONObject.optString("homeAddressCountry");
            aVar.aoQ = jSONObject.optString("homeAddressState");
            aVar.aoR = jSONObject.optString("homeAddressCity");
            aVar.aoS = jSONObject.optString("homeAddressStreet");
            aVar.aoT = jSONObject.optString("homeAddressPostalCode");
        }
        return aVar;
    }

    public String getDisplayName() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.aou)) {
            sb.append(this.aou);
        }
        if (!TextUtils.isEmpty(this.aov)) {
            sb.append(this.aov);
        }
        if (!TextUtils.isEmpty(this.aow)) {
            sb.append(this.aow);
        }
        return sb.toString();
    }

    public ContentValues yv() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/nickname");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.nickName);
        return contentValues;
    }

    public ContentValues yw() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/note");
        contentValues.put("data1", this.remark);
        return contentValues;
    }

    public ContentValues yx() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", this.aox);
        return contentValues;
    }

    public ContentValues yy() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.aoO);
        return contentValues;
    }

    public ContentValues yz() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", this.aoG);
        return contentValues;
    }

    public ContentValues yA() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 10);
        contentValues.put("data1", this.aoH);
        return contentValues;
    }

    public ContentValues yB() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 5);
        contentValues.put("data1", this.aoN);
        return contentValues;
    }

    public ContentValues yC() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 4);
        contentValues.put("data1", this.aoF);
        return contentValues;
    }

    public ContentValues yD() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/im");
        contentValues.put("data5", (Integer) (-1));
        contentValues.put("data6", AppRuntime.getAppContext().getString(a.h.aiapps_cantact_wechat_lable));
        contentValues.put("data1", this.aoy);
        return contentValues;
    }

    public ContentValues yE() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/organization");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.aoE);
        contentValues.put("data4", this.title);
        return contentValues;
    }

    public ContentValues yF() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/website");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.url);
        return contentValues;
    }

    public ContentValues yG() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", yL());
        contentValues.put("data9", this.aoD);
        return contentValues;
    }

    public ContentValues yH() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", yK());
        contentValues.put("data9", this.aoM);
        return contentValues;
    }

    public ContentValues yI() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", yJ());
        contentValues.put("data9", this.aoT);
        return contentValues;
    }

    public String yJ() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.aoP)) {
            sb.append(this.aoP);
        }
        if (!TextUtils.isEmpty(this.aoQ)) {
            sb.append(this.aoQ);
        }
        if (!TextUtils.isEmpty(this.aoR)) {
            sb.append(this.aoR);
        }
        if (!TextUtils.isEmpty(this.aoS)) {
            sb.append(this.aoS);
        }
        if (!TextUtils.isEmpty(this.aoT)) {
            sb.append(" ").append(this.aoT);
        }
        return sb.toString();
    }

    public String yK() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.aoI)) {
            sb.append(this.aoI);
        }
        if (!TextUtils.isEmpty(this.aoJ)) {
            sb.append(this.aoJ);
        }
        if (!TextUtils.isEmpty(this.aoK)) {
            sb.append(this.aoK);
        }
        if (!TextUtils.isEmpty(this.aoL)) {
            sb.append(this.aoL);
        }
        if (!TextUtils.isEmpty(this.aoM)) {
            sb.append(" ").append(this.aoM);
        }
        return sb.toString();
    }

    public String yL() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.aoz)) {
            sb.append(this.aoz);
        }
        if (!TextUtils.isEmpty(this.aoA)) {
            sb.append(this.aoA);
        }
        if (!TextUtils.isEmpty(this.aoB)) {
            sb.append(this.aoB);
        }
        if (!TextUtils.isEmpty(this.aoC)) {
            sb.append(this.aoC);
        }
        if (!TextUtils.isEmpty(this.aoD)) {
            sb.append(" ").append(this.aoD);
        }
        return sb.toString();
    }
}
