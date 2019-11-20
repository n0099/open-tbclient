package com.baidu.swan.apps.i;

import android.content.ContentValues;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public String aHQ;
    public String aHR;
    public String aHS;
    public String aHT;
    public String aHU;
    public String aHV;
    public String aHW;
    public String aHX;
    public String aHY;
    public String aHZ;
    public String aIa;
    public String aIb;
    public String aIc;
    public String aId;
    public String aIe;
    public String aIf;
    public String aIg;
    public String aIh;
    public String aIi;
    public String aIj;
    public String aIk;
    public String aIl;
    public String aIm;
    public String aIn;
    public String aIo;
    public String aIp;
    public String aIq;
    public String email;
    public String nickName;
    public String remark;
    public String title;
    public String url;

    public boolean isValid() {
        return !TextUtils.isEmpty(this.aHT);
    }

    public static a T(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.aHQ = jSONObject.optString("photoFilePath");
            aVar.nickName = jSONObject.optString("nickName");
            aVar.aHR = jSONObject.optString("lastName");
            aVar.aHS = jSONObject.optString("middleName");
            aVar.aHT = jSONObject.optString("firstName");
            aVar.remark = jSONObject.optString("remark");
            aVar.aHU = jSONObject.optString("mobilePhoneNumber");
            aVar.aHV = jSONObject.optString("weChatNumber");
            aVar.aHW = jSONObject.optString("addressCountry");
            aVar.aHX = jSONObject.optString("addressState");
            aVar.aHY = jSONObject.optString("addressCity");
            aVar.aHZ = jSONObject.optString("addressStreet");
            aVar.aIa = jSONObject.optString("addressPostalCode");
            aVar.aIb = jSONObject.optString("organization");
            aVar.title = jSONObject.optString("title");
            aVar.aIc = jSONObject.optString("workFaxNumber");
            aVar.aId = jSONObject.optString("workPhoneNumber");
            aVar.aIe = jSONObject.optString("hostNumber");
            aVar.email = jSONObject.optString(NotificationCompat.CATEGORY_EMAIL);
            aVar.url = jSONObject.optString("url");
            aVar.aIf = jSONObject.optString("workAddressCountry");
            aVar.aIg = jSONObject.optString("workAddressState");
            aVar.aIh = jSONObject.optString("workAddressCity");
            aVar.aIi = jSONObject.optString("workAddressStreet");
            aVar.aIj = jSONObject.optString("workAddressPostalCode");
            aVar.aIk = jSONObject.optString("homeFaxNumber");
            aVar.aIl = jSONObject.optString("homePhoneNumber");
            aVar.aIm = jSONObject.optString("homeAddressCountry");
            aVar.aIn = jSONObject.optString("homeAddressState");
            aVar.aIo = jSONObject.optString("homeAddressCity");
            aVar.aIp = jSONObject.optString("homeAddressStreet");
            aVar.aIq = jSONObject.optString("homeAddressPostalCode");
        }
        return aVar;
    }

    public String getDisplayName() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.aHR)) {
            sb.append(this.aHR);
        }
        if (!TextUtils.isEmpty(this.aHS)) {
            sb.append(this.aHS);
        }
        if (!TextUtils.isEmpty(this.aHT)) {
            sb.append(this.aHT);
        }
        return sb.toString();
    }

    public ContentValues Dv() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/nickname");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.nickName);
        return contentValues;
    }

    public ContentValues Dw() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/note");
        contentValues.put("data1", this.remark);
        return contentValues;
    }

    public ContentValues Dx() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", this.aHU);
        return contentValues;
    }

    public ContentValues Dy() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.aIl);
        return contentValues;
    }

    public ContentValues Dz() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", this.aId);
        return contentValues;
    }

    public ContentValues DA() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 10);
        contentValues.put("data1", this.aIe);
        return contentValues;
    }

    public ContentValues DB() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 5);
        contentValues.put("data1", this.aIk);
        return contentValues;
    }

    public ContentValues DC() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 4);
        contentValues.put("data1", this.aIc);
        return contentValues;
    }

    public ContentValues DD() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/im");
        contentValues.put("data5", (Integer) (-1));
        contentValues.put("data6", AppRuntime.getAppContext().getString(a.h.aiapps_cantact_wechat_lable));
        contentValues.put("data1", this.aHV);
        return contentValues;
    }

    public ContentValues DE() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/organization");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.aIb);
        contentValues.put("data4", this.title);
        return contentValues;
    }

    public ContentValues DF() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/website");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.url);
        return contentValues;
    }

    public ContentValues DG() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", DL());
        contentValues.put("data9", this.aIa);
        return contentValues;
    }

    public ContentValues DH() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", DK());
        contentValues.put("data9", this.aIj);
        return contentValues;
    }

    public ContentValues DI() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", DJ());
        contentValues.put("data9", this.aIq);
        return contentValues;
    }

    public String DJ() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.aIm)) {
            sb.append(this.aIm);
        }
        if (!TextUtils.isEmpty(this.aIn)) {
            sb.append(this.aIn);
        }
        if (!TextUtils.isEmpty(this.aIo)) {
            sb.append(this.aIo);
        }
        if (!TextUtils.isEmpty(this.aIp)) {
            sb.append(this.aIp);
        }
        if (!TextUtils.isEmpty(this.aIq)) {
            sb.append(HanziToPinyin.Token.SEPARATOR).append(this.aIq);
        }
        return sb.toString();
    }

    public String DK() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.aIf)) {
            sb.append(this.aIf);
        }
        if (!TextUtils.isEmpty(this.aIg)) {
            sb.append(this.aIg);
        }
        if (!TextUtils.isEmpty(this.aIh)) {
            sb.append(this.aIh);
        }
        if (!TextUtils.isEmpty(this.aIi)) {
            sb.append(this.aIi);
        }
        if (!TextUtils.isEmpty(this.aIj)) {
            sb.append(HanziToPinyin.Token.SEPARATOR).append(this.aIj);
        }
        return sb.toString();
    }

    public String DL() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.aHW)) {
            sb.append(this.aHW);
        }
        if (!TextUtils.isEmpty(this.aHX)) {
            sb.append(this.aHX);
        }
        if (!TextUtils.isEmpty(this.aHY)) {
            sb.append(this.aHY);
        }
        if (!TextUtils.isEmpty(this.aHZ)) {
            sb.append(this.aHZ);
        }
        if (!TextUtils.isEmpty(this.aIa)) {
            sb.append(HanziToPinyin.Token.SEPARATOR).append(this.aIa);
        }
        return sb.toString();
    }
}
