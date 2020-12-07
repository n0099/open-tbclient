package com.baidu.swan.apps.j;

import android.content.ContentValues;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class a {
    public String cMA;
    public String cMB;
    public String cMC;
    public String cMD;
    public String cME;
    public String cMF;
    public String cMG;
    public String cMH;
    public String cMI;
    public String cMJ;
    public String cMK;
    public String cML;
    public String cMM;
    public String cMN;
    public String cMO;
    public String cMP;
    public String cMQ;
    public String cMq;
    public String cMr;
    public String cMs;
    public String cMt;
    public String cMu;
    public String cMv;
    public String cMw;
    public String cMx;
    public String cMy;
    public String cMz;
    public String email;
    public String nickName;
    public String remark;
    public String title;
    public String url;

    public boolean isValid() {
        return !TextUtils.isEmpty(this.cMt);
    }

    public static a be(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.cMq = jSONObject.optString("photoFilePath");
            aVar.nickName = jSONObject.optString("nickName");
            aVar.cMr = jSONObject.optString("lastName");
            aVar.cMs = jSONObject.optString("middleName");
            aVar.cMt = jSONObject.optString("firstName");
            aVar.remark = jSONObject.optString("remark");
            aVar.cMu = jSONObject.optString("mobilePhoneNumber");
            aVar.cMv = jSONObject.optString("weChatNumber");
            aVar.cMw = jSONObject.optString("addressCountry");
            aVar.cMx = jSONObject.optString("addressState");
            aVar.cMy = jSONObject.optString("addressCity");
            aVar.cMz = jSONObject.optString("addressStreet");
            aVar.cMA = jSONObject.optString("addressPostalCode");
            aVar.cMB = jSONObject.optString("organization");
            aVar.title = jSONObject.optString("title");
            aVar.cMC = jSONObject.optString("workFaxNumber");
            aVar.cMD = jSONObject.optString("workPhoneNumber");
            aVar.cME = jSONObject.optString("hostNumber");
            aVar.email = jSONObject.optString(NotificationCompat.CATEGORY_EMAIL);
            aVar.url = jSONObject.optString("url");
            aVar.cMF = jSONObject.optString("workAddressCountry");
            aVar.cMG = jSONObject.optString("workAddressState");
            aVar.cMH = jSONObject.optString("workAddressCity");
            aVar.cMI = jSONObject.optString("workAddressStreet");
            aVar.cMJ = jSONObject.optString("workAddressPostalCode");
            aVar.cMK = jSONObject.optString("homeFaxNumber");
            aVar.cML = jSONObject.optString("homePhoneNumber");
            aVar.cMM = jSONObject.optString("homeAddressCountry");
            aVar.cMN = jSONObject.optString("homeAddressState");
            aVar.cMO = jSONObject.optString("homeAddressCity");
            aVar.cMP = jSONObject.optString("homeAddressStreet");
            aVar.cMQ = jSONObject.optString("homeAddressPostalCode");
        }
        return aVar;
    }

    public String getDisplayName() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.cMr)) {
            sb.append(this.cMr);
        }
        if (!TextUtils.isEmpty(this.cMs)) {
            sb.append(this.cMs);
        }
        if (!TextUtils.isEmpty(this.cMt)) {
            sb.append(this.cMt);
        }
        return sb.toString();
    }

    public ContentValues aoX() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/nickname");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.nickName);
        return contentValues;
    }

    public ContentValues aoY() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/note");
        contentValues.put("data1", this.remark);
        return contentValues;
    }

    public ContentValues aoZ() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", this.cMu);
        return contentValues;
    }

    public ContentValues apa() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.cML);
        return contentValues;
    }

    public ContentValues apb() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", this.cMD);
        return contentValues;
    }

    public ContentValues apc() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 10);
        contentValues.put("data1", this.cME);
        return contentValues;
    }

    public ContentValues apd() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 5);
        contentValues.put("data1", this.cMK);
        return contentValues;
    }

    public ContentValues ape() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 4);
        contentValues.put("data1", this.cMC);
        return contentValues;
    }

    public ContentValues apf() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/im");
        contentValues.put("data5", (Integer) (-1));
        contentValues.put("data6", AppRuntime.getAppContext().getString(a.h.aiapps_cantact_wechat_lable));
        contentValues.put("data1", this.cMv);
        return contentValues;
    }

    public ContentValues apg() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/organization");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.cMB);
        contentValues.put("data4", this.title);
        return contentValues;
    }

    public ContentValues aph() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/website");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.url);
        return contentValues;
    }

    public ContentValues apj() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", apo());
        contentValues.put("data9", this.cMA);
        return contentValues;
    }

    public ContentValues apk() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", apn());
        contentValues.put("data9", this.cMJ);
        return contentValues;
    }

    public ContentValues apl() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", apm());
        contentValues.put("data9", this.cMQ);
        return contentValues;
    }

    public String apm() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.cMM)) {
            sb.append(this.cMM);
        }
        if (!TextUtils.isEmpty(this.cMN)) {
            sb.append(this.cMN);
        }
        if (!TextUtils.isEmpty(this.cMO)) {
            sb.append(this.cMO);
        }
        if (!TextUtils.isEmpty(this.cMP)) {
            sb.append(this.cMP);
        }
        if (!TextUtils.isEmpty(this.cMQ)) {
            sb.append(" ").append(this.cMQ);
        }
        return sb.toString();
    }

    public String apn() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.cMF)) {
            sb.append(this.cMF);
        }
        if (!TextUtils.isEmpty(this.cMG)) {
            sb.append(this.cMG);
        }
        if (!TextUtils.isEmpty(this.cMH)) {
            sb.append(this.cMH);
        }
        if (!TextUtils.isEmpty(this.cMI)) {
            sb.append(this.cMI);
        }
        if (!TextUtils.isEmpty(this.cMJ)) {
            sb.append(" ").append(this.cMJ);
        }
        return sb.toString();
    }

    public String apo() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.cMw)) {
            sb.append(this.cMw);
        }
        if (!TextUtils.isEmpty(this.cMx)) {
            sb.append(this.cMx);
        }
        if (!TextUtils.isEmpty(this.cMy)) {
            sb.append(this.cMy);
        }
        if (!TextUtils.isEmpty(this.cMz)) {
            sb.append(this.cMz);
        }
        if (!TextUtils.isEmpty(this.cMA)) {
            sb.append(" ").append(this.cMA);
        }
        return sb.toString();
    }
}
