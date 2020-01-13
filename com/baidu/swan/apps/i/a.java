package com.baidu.swan.apps.i;

import android.content.ContentValues;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public String bhA;
    public String bhB;
    public String bhC;
    public String bhD;
    public String bhE;
    public String bhF;
    public String bhG;
    public String bhH;
    public String bhI;
    public String bhJ;
    public String bhK;
    public String bhL;
    public String bhM;
    public String bhN;
    public String bhO;
    public String bhP;
    public String bhp;
    public String bhq;
    public String bhr;
    public String bhs;
    public String bht;
    public String bhu;
    public String bhv;
    public String bhw;
    public String bhx;
    public String bhy;
    public String bhz;
    public String email;
    public String nickName;
    public String remark;
    public String title;
    public String url;

    public boolean isValid() {
        return !TextUtils.isEmpty(this.bhs);
    }

    public static a ag(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.bhp = jSONObject.optString("photoFilePath");
            aVar.nickName = jSONObject.optString("nickName");
            aVar.bhq = jSONObject.optString("lastName");
            aVar.bhr = jSONObject.optString("middleName");
            aVar.bhs = jSONObject.optString("firstName");
            aVar.remark = jSONObject.optString("remark");
            aVar.bht = jSONObject.optString("mobilePhoneNumber");
            aVar.bhu = jSONObject.optString("weChatNumber");
            aVar.bhv = jSONObject.optString("addressCountry");
            aVar.bhw = jSONObject.optString("addressState");
            aVar.bhx = jSONObject.optString("addressCity");
            aVar.bhy = jSONObject.optString("addressStreet");
            aVar.bhz = jSONObject.optString("addressPostalCode");
            aVar.bhA = jSONObject.optString("organization");
            aVar.title = jSONObject.optString("title");
            aVar.bhB = jSONObject.optString("workFaxNumber");
            aVar.bhC = jSONObject.optString("workPhoneNumber");
            aVar.bhD = jSONObject.optString("hostNumber");
            aVar.email = jSONObject.optString(NotificationCompat.CATEGORY_EMAIL);
            aVar.url = jSONObject.optString("url");
            aVar.bhE = jSONObject.optString("workAddressCountry");
            aVar.bhF = jSONObject.optString("workAddressState");
            aVar.bhG = jSONObject.optString("workAddressCity");
            aVar.bhH = jSONObject.optString("workAddressStreet");
            aVar.bhI = jSONObject.optString("workAddressPostalCode");
            aVar.bhJ = jSONObject.optString("homeFaxNumber");
            aVar.bhK = jSONObject.optString("homePhoneNumber");
            aVar.bhL = jSONObject.optString("homeAddressCountry");
            aVar.bhM = jSONObject.optString("homeAddressState");
            aVar.bhN = jSONObject.optString("homeAddressCity");
            aVar.bhO = jSONObject.optString("homeAddressStreet");
            aVar.bhP = jSONObject.optString("homeAddressPostalCode");
        }
        return aVar;
    }

    public String getDisplayName() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.bhq)) {
            sb.append(this.bhq);
        }
        if (!TextUtils.isEmpty(this.bhr)) {
            sb.append(this.bhr);
        }
        if (!TextUtils.isEmpty(this.bhs)) {
            sb.append(this.bhs);
        }
        return sb.toString();
    }

    public ContentValues Ke() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/nickname");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.nickName);
        return contentValues;
    }

    public ContentValues Kf() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/note");
        contentValues.put("data1", this.remark);
        return contentValues;
    }

    public ContentValues Kg() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", this.bht);
        return contentValues;
    }

    public ContentValues Kh() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.bhK);
        return contentValues;
    }

    public ContentValues Ki() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", this.bhC);
        return contentValues;
    }

    public ContentValues Kj() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 10);
        contentValues.put("data1", this.bhD);
        return contentValues;
    }

    public ContentValues Kk() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 5);
        contentValues.put("data1", this.bhJ);
        return contentValues;
    }

    public ContentValues Kl() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 4);
        contentValues.put("data1", this.bhB);
        return contentValues;
    }

    public ContentValues Km() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/im");
        contentValues.put("data5", (Integer) (-1));
        contentValues.put("data6", AppRuntime.getAppContext().getString(a.h.aiapps_cantact_wechat_lable));
        contentValues.put("data1", this.bhu);
        return contentValues;
    }

    public ContentValues Kn() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/organization");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.bhA);
        contentValues.put("data4", this.title);
        return contentValues;
    }

    public ContentValues Ko() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/website");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.url);
        return contentValues;
    }

    public ContentValues Kp() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", Ku());
        contentValues.put("data9", this.bhz);
        return contentValues;
    }

    public ContentValues Kq() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", Kt());
        contentValues.put("data9", this.bhI);
        return contentValues;
    }

    public ContentValues Kr() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", Ks());
        contentValues.put("data9", this.bhP);
        return contentValues;
    }

    public String Ks() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.bhL)) {
            sb.append(this.bhL);
        }
        if (!TextUtils.isEmpty(this.bhM)) {
            sb.append(this.bhM);
        }
        if (!TextUtils.isEmpty(this.bhN)) {
            sb.append(this.bhN);
        }
        if (!TextUtils.isEmpty(this.bhO)) {
            sb.append(this.bhO);
        }
        if (!TextUtils.isEmpty(this.bhP)) {
            sb.append(HanziToPinyin.Token.SEPARATOR).append(this.bhP);
        }
        return sb.toString();
    }

    public String Kt() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.bhE)) {
            sb.append(this.bhE);
        }
        if (!TextUtils.isEmpty(this.bhF)) {
            sb.append(this.bhF);
        }
        if (!TextUtils.isEmpty(this.bhG)) {
            sb.append(this.bhG);
        }
        if (!TextUtils.isEmpty(this.bhH)) {
            sb.append(this.bhH);
        }
        if (!TextUtils.isEmpty(this.bhI)) {
            sb.append(HanziToPinyin.Token.SEPARATOR).append(this.bhI);
        }
        return sb.toString();
    }

    public String Ku() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.bhv)) {
            sb.append(this.bhv);
        }
        if (!TextUtils.isEmpty(this.bhw)) {
            sb.append(this.bhw);
        }
        if (!TextUtils.isEmpty(this.bhx)) {
            sb.append(this.bhx);
        }
        if (!TextUtils.isEmpty(this.bhy)) {
            sb.append(this.bhy);
        }
        if (!TextUtils.isEmpty(this.bhz)) {
            sb.append(HanziToPinyin.Token.SEPARATOR).append(this.bhz);
        }
        return sb.toString();
    }
}
