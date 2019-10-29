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
    public String aIA;
    public String aIB;
    public String aIC;
    public String aID;
    public String aIE;
    public String aIF;
    public String aIG;
    public String aIH;
    public String aII;
    public String aIi;
    public String aIj;
    public String aIk;
    public String aIl;
    public String aIm;
    public String aIn;
    public String aIo;
    public String aIp;
    public String aIq;
    public String aIr;
    public String aIs;
    public String aIt;
    public String aIu;
    public String aIv;
    public String aIw;
    public String aIx;
    public String aIy;
    public String aIz;
    public String email;
    public String nickName;
    public String remark;
    public String title;
    public String url;

    public boolean isValid() {
        return !TextUtils.isEmpty(this.aIl);
    }

    public static a S(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.aIi = jSONObject.optString("photoFilePath");
            aVar.nickName = jSONObject.optString("nickName");
            aVar.aIj = jSONObject.optString("lastName");
            aVar.aIk = jSONObject.optString("middleName");
            aVar.aIl = jSONObject.optString("firstName");
            aVar.remark = jSONObject.optString("remark");
            aVar.aIm = jSONObject.optString("mobilePhoneNumber");
            aVar.aIn = jSONObject.optString("weChatNumber");
            aVar.aIo = jSONObject.optString("addressCountry");
            aVar.aIp = jSONObject.optString("addressState");
            aVar.aIq = jSONObject.optString("addressCity");
            aVar.aIr = jSONObject.optString("addressStreet");
            aVar.aIs = jSONObject.optString("addressPostalCode");
            aVar.aIt = jSONObject.optString("organization");
            aVar.title = jSONObject.optString("title");
            aVar.aIu = jSONObject.optString("workFaxNumber");
            aVar.aIv = jSONObject.optString("workPhoneNumber");
            aVar.aIw = jSONObject.optString("hostNumber");
            aVar.email = jSONObject.optString(NotificationCompat.CATEGORY_EMAIL);
            aVar.url = jSONObject.optString("url");
            aVar.aIx = jSONObject.optString("workAddressCountry");
            aVar.aIy = jSONObject.optString("workAddressState");
            aVar.aIz = jSONObject.optString("workAddressCity");
            aVar.aIA = jSONObject.optString("workAddressStreet");
            aVar.aIB = jSONObject.optString("workAddressPostalCode");
            aVar.aIC = jSONObject.optString("homeFaxNumber");
            aVar.aID = jSONObject.optString("homePhoneNumber");
            aVar.aIE = jSONObject.optString("homeAddressCountry");
            aVar.aIF = jSONObject.optString("homeAddressState");
            aVar.aIG = jSONObject.optString("homeAddressCity");
            aVar.aIH = jSONObject.optString("homeAddressStreet");
            aVar.aII = jSONObject.optString("homeAddressPostalCode");
        }
        return aVar;
    }

    public String getDisplayName() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.aIj)) {
            sb.append(this.aIj);
        }
        if (!TextUtils.isEmpty(this.aIk)) {
            sb.append(this.aIk);
        }
        if (!TextUtils.isEmpty(this.aIl)) {
            sb.append(this.aIl);
        }
        return sb.toString();
    }

    public ContentValues Du() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/nickname");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.nickName);
        return contentValues;
    }

    public ContentValues Dv() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/note");
        contentValues.put("data1", this.remark);
        return contentValues;
    }

    public ContentValues Dw() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", this.aIm);
        return contentValues;
    }

    public ContentValues Dx() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.aID);
        return contentValues;
    }

    public ContentValues Dy() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", this.aIv);
        return contentValues;
    }

    public ContentValues Dz() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 10);
        contentValues.put("data1", this.aIw);
        return contentValues;
    }

    public ContentValues DA() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 5);
        contentValues.put("data1", this.aIC);
        return contentValues;
    }

    public ContentValues DB() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 4);
        contentValues.put("data1", this.aIu);
        return contentValues;
    }

    public ContentValues DC() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/im");
        contentValues.put("data5", (Integer) (-1));
        contentValues.put("data6", AppRuntime.getAppContext().getString(a.h.aiapps_cantact_wechat_lable));
        contentValues.put("data1", this.aIn);
        return contentValues;
    }

    public ContentValues DD() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/organization");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.aIt);
        contentValues.put("data4", this.title);
        return contentValues;
    }

    public ContentValues DE() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/website");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.url);
        return contentValues;
    }

    public ContentValues DF() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", DK());
        contentValues.put("data9", this.aIs);
        return contentValues;
    }

    public ContentValues DG() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", DJ());
        contentValues.put("data9", this.aIB);
        return contentValues;
    }

    public ContentValues DH() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", DI());
        contentValues.put("data9", this.aII);
        return contentValues;
    }

    public String DI() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.aIE)) {
            sb.append(this.aIE);
        }
        if (!TextUtils.isEmpty(this.aIF)) {
            sb.append(this.aIF);
        }
        if (!TextUtils.isEmpty(this.aIG)) {
            sb.append(this.aIG);
        }
        if (!TextUtils.isEmpty(this.aIH)) {
            sb.append(this.aIH);
        }
        if (!TextUtils.isEmpty(this.aII)) {
            sb.append(HanziToPinyin.Token.SEPARATOR).append(this.aII);
        }
        return sb.toString();
    }

    public String DJ() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.aIx)) {
            sb.append(this.aIx);
        }
        if (!TextUtils.isEmpty(this.aIy)) {
            sb.append(this.aIy);
        }
        if (!TextUtils.isEmpty(this.aIz)) {
            sb.append(this.aIz);
        }
        if (!TextUtils.isEmpty(this.aIA)) {
            sb.append(this.aIA);
        }
        if (!TextUtils.isEmpty(this.aIB)) {
            sb.append(HanziToPinyin.Token.SEPARATOR).append(this.aIB);
        }
        return sb.toString();
    }

    public String DK() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.aIo)) {
            sb.append(this.aIo);
        }
        if (!TextUtils.isEmpty(this.aIp)) {
            sb.append(this.aIp);
        }
        if (!TextUtils.isEmpty(this.aIq)) {
            sb.append(this.aIq);
        }
        if (!TextUtils.isEmpty(this.aIr)) {
            sb.append(this.aIr);
        }
        if (!TextUtils.isEmpty(this.aIs)) {
            sb.append(HanziToPinyin.Token.SEPARATOR).append(this.aIs);
        }
        return sb.toString();
    }
}
