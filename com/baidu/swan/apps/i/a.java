package com.baidu.swan.apps.i;

import android.content.ContentValues;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public String aoR;
    public String aoS;
    public String aoT;
    public String aoU;
    public String aoV;
    public String aoW;
    public String aoX;
    public String aoY;
    public String aoZ;
    public String apa;
    public String apb;
    public String apc;
    public String apd;
    public String ape;
    public String apf;
    public String apg;
    public String aph;
    public String api;
    public String apj;
    public String apk;
    public String apl;
    public String apm;
    public String apn;
    public String apo;
    public String apq;
    public String apr;
    public String aps;
    public String email;
    public String nickName;
    public String remark;
    public String title;
    public String url;

    public boolean isValid() {
        return !TextUtils.isEmpty(this.aoU);
    }

    public static a u(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.aoR = jSONObject.optString("photoFilePath");
            aVar.nickName = jSONObject.optString("nickName");
            aVar.aoS = jSONObject.optString("lastName");
            aVar.aoT = jSONObject.optString("middleName");
            aVar.aoU = jSONObject.optString("firstName");
            aVar.remark = jSONObject.optString("remark");
            aVar.aoV = jSONObject.optString("mobilePhoneNumber");
            aVar.aoW = jSONObject.optString("weChatNumber");
            aVar.aoX = jSONObject.optString("addressCountry");
            aVar.aoY = jSONObject.optString("addressState");
            aVar.aoZ = jSONObject.optString("addressCity");
            aVar.apa = jSONObject.optString("addressStreet");
            aVar.apb = jSONObject.optString("addressPostalCode");
            aVar.apc = jSONObject.optString("organization");
            aVar.title = jSONObject.optString("title");
            aVar.apd = jSONObject.optString("workFaxNumber");
            aVar.ape = jSONObject.optString("workPhoneNumber");
            aVar.apf = jSONObject.optString("hostNumber");
            aVar.email = jSONObject.optString(NotificationCompat.CATEGORY_EMAIL);
            aVar.url = jSONObject.optString("url");
            aVar.apg = jSONObject.optString("workAddressCountry");
            aVar.aph = jSONObject.optString("workAddressState");
            aVar.api = jSONObject.optString("workAddressCity");
            aVar.apj = jSONObject.optString("workAddressStreet");
            aVar.apk = jSONObject.optString("workAddressPostalCode");
            aVar.apl = jSONObject.optString("homeFaxNumber");
            aVar.apm = jSONObject.optString("homePhoneNumber");
            aVar.apn = jSONObject.optString("homeAddressCountry");
            aVar.apo = jSONObject.optString("homeAddressState");
            aVar.apq = jSONObject.optString("homeAddressCity");
            aVar.apr = jSONObject.optString("homeAddressStreet");
            aVar.aps = jSONObject.optString("homeAddressPostalCode");
        }
        return aVar;
    }

    public String getDisplayName() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.aoS)) {
            sb.append(this.aoS);
        }
        if (!TextUtils.isEmpty(this.aoT)) {
            sb.append(this.aoT);
        }
        if (!TextUtils.isEmpty(this.aoU)) {
            sb.append(this.aoU);
        }
        return sb.toString();
    }

    public ContentValues yz() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/nickname");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.nickName);
        return contentValues;
    }

    public ContentValues yA() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/note");
        contentValues.put("data1", this.remark);
        return contentValues;
    }

    public ContentValues yB() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", this.aoV);
        return contentValues;
    }

    public ContentValues yC() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.apm);
        return contentValues;
    }

    public ContentValues yD() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", this.ape);
        return contentValues;
    }

    public ContentValues yE() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 10);
        contentValues.put("data1", this.apf);
        return contentValues;
    }

    public ContentValues yF() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 5);
        contentValues.put("data1", this.apl);
        return contentValues;
    }

    public ContentValues yG() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 4);
        contentValues.put("data1", this.apd);
        return contentValues;
    }

    public ContentValues yH() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/im");
        contentValues.put("data5", (Integer) (-1));
        contentValues.put("data6", AppRuntime.getAppContext().getString(a.h.aiapps_cantact_wechat_lable));
        contentValues.put("data1", this.aoW);
        return contentValues;
    }

    public ContentValues yI() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/organization");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.apc);
        contentValues.put("data4", this.title);
        return contentValues;
    }

    public ContentValues yJ() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/website");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.url);
        return contentValues;
    }

    public ContentValues yK() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", yP());
        contentValues.put("data9", this.apb);
        return contentValues;
    }

    public ContentValues yL() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", yO());
        contentValues.put("data9", this.apk);
        return contentValues;
    }

    public ContentValues yM() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", yN());
        contentValues.put("data9", this.aps);
        return contentValues;
    }

    public String yN() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.apn)) {
            sb.append(this.apn);
        }
        if (!TextUtils.isEmpty(this.apo)) {
            sb.append(this.apo);
        }
        if (!TextUtils.isEmpty(this.apq)) {
            sb.append(this.apq);
        }
        if (!TextUtils.isEmpty(this.apr)) {
            sb.append(this.apr);
        }
        if (!TextUtils.isEmpty(this.aps)) {
            sb.append(" ").append(this.aps);
        }
        return sb.toString();
    }

    public String yO() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.apg)) {
            sb.append(this.apg);
        }
        if (!TextUtils.isEmpty(this.aph)) {
            sb.append(this.aph);
        }
        if (!TextUtils.isEmpty(this.api)) {
            sb.append(this.api);
        }
        if (!TextUtils.isEmpty(this.apj)) {
            sb.append(this.apj);
        }
        if (!TextUtils.isEmpty(this.apk)) {
            sb.append(" ").append(this.apk);
        }
        return sb.toString();
    }

    public String yP() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.aoX)) {
            sb.append(this.aoX);
        }
        if (!TextUtils.isEmpty(this.aoY)) {
            sb.append(this.aoY);
        }
        if (!TextUtils.isEmpty(this.aoZ)) {
            sb.append(this.aoZ);
        }
        if (!TextUtils.isEmpty(this.apa)) {
            sb.append(this.apa);
        }
        if (!TextUtils.isEmpty(this.apb)) {
            sb.append(" ").append(this.apb);
        }
        return sb.toString();
    }
}
