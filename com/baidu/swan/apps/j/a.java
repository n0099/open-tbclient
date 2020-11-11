package com.baidu.swan.apps.j;

import android.content.ContentValues;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public String cHA;
    public String cHB;
    public String cHC;
    public String cHD;
    public String cHE;
    public String cHF;
    public String cHG;
    public String cHg;
    public String cHh;
    public String cHi;
    public String cHj;
    public String cHk;
    public String cHl;
    public String cHm;
    public String cHn;
    public String cHo;
    public String cHp;
    public String cHq;
    public String cHr;
    public String cHs;
    public String cHt;
    public String cHu;
    public String cHv;
    public String cHw;
    public String cHx;
    public String cHy;
    public String cHz;
    public String email;
    public String nickName;
    public String remark;
    public String title;
    public String url;

    public boolean isValid() {
        return !TextUtils.isEmpty(this.cHj);
    }

    public static a bi(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.cHg = jSONObject.optString("photoFilePath");
            aVar.nickName = jSONObject.optString("nickName");
            aVar.cHh = jSONObject.optString("lastName");
            aVar.cHi = jSONObject.optString("middleName");
            aVar.cHj = jSONObject.optString("firstName");
            aVar.remark = jSONObject.optString("remark");
            aVar.cHk = jSONObject.optString("mobilePhoneNumber");
            aVar.cHl = jSONObject.optString("weChatNumber");
            aVar.cHm = jSONObject.optString("addressCountry");
            aVar.cHn = jSONObject.optString("addressState");
            aVar.cHo = jSONObject.optString("addressCity");
            aVar.cHp = jSONObject.optString("addressStreet");
            aVar.cHq = jSONObject.optString("addressPostalCode");
            aVar.cHr = jSONObject.optString("organization");
            aVar.title = jSONObject.optString("title");
            aVar.cHs = jSONObject.optString("workFaxNumber");
            aVar.cHt = jSONObject.optString("workPhoneNumber");
            aVar.cHu = jSONObject.optString("hostNumber");
            aVar.email = jSONObject.optString(NotificationCompat.CATEGORY_EMAIL);
            aVar.url = jSONObject.optString("url");
            aVar.cHv = jSONObject.optString("workAddressCountry");
            aVar.cHw = jSONObject.optString("workAddressState");
            aVar.cHx = jSONObject.optString("workAddressCity");
            aVar.cHy = jSONObject.optString("workAddressStreet");
            aVar.cHz = jSONObject.optString("workAddressPostalCode");
            aVar.cHA = jSONObject.optString("homeFaxNumber");
            aVar.cHB = jSONObject.optString("homePhoneNumber");
            aVar.cHC = jSONObject.optString("homeAddressCountry");
            aVar.cHD = jSONObject.optString("homeAddressState");
            aVar.cHE = jSONObject.optString("homeAddressCity");
            aVar.cHF = jSONObject.optString("homeAddressStreet");
            aVar.cHG = jSONObject.optString("homeAddressPostalCode");
        }
        return aVar;
    }

    public String getDisplayName() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.cHh)) {
            sb.append(this.cHh);
        }
        if (!TextUtils.isEmpty(this.cHi)) {
            sb.append(this.cHi);
        }
        if (!TextUtils.isEmpty(this.cHj)) {
            sb.append(this.cHj);
        }
        return sb.toString();
    }

    public ContentValues amx() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/nickname");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.nickName);
        return contentValues;
    }

    public ContentValues amy() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/note");
        contentValues.put("data1", this.remark);
        return contentValues;
    }

    public ContentValues amz() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", this.cHk);
        return contentValues;
    }

    public ContentValues amA() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.cHB);
        return contentValues;
    }

    public ContentValues amB() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", this.cHt);
        return contentValues;
    }

    public ContentValues amC() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 10);
        contentValues.put("data1", this.cHu);
        return contentValues;
    }

    public ContentValues amD() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 5);
        contentValues.put("data1", this.cHA);
        return contentValues;
    }

    public ContentValues amE() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 4);
        contentValues.put("data1", this.cHs);
        return contentValues;
    }

    public ContentValues amF() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/im");
        contentValues.put("data5", (Integer) (-1));
        contentValues.put("data6", AppRuntime.getAppContext().getString(a.h.aiapps_cantact_wechat_lable));
        contentValues.put("data1", this.cHl);
        return contentValues;
    }

    public ContentValues amG() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/organization");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.cHr);
        contentValues.put("data4", this.title);
        return contentValues;
    }

    public ContentValues amH() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/website");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.url);
        return contentValues;
    }

    public ContentValues amI() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", amN());
        contentValues.put("data9", this.cHq);
        return contentValues;
    }

    public ContentValues amJ() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", amM());
        contentValues.put("data9", this.cHz);
        return contentValues;
    }

    public ContentValues amK() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", amL());
        contentValues.put("data9", this.cHG);
        return contentValues;
    }

    public String amL() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.cHC)) {
            sb.append(this.cHC);
        }
        if (!TextUtils.isEmpty(this.cHD)) {
            sb.append(this.cHD);
        }
        if (!TextUtils.isEmpty(this.cHE)) {
            sb.append(this.cHE);
        }
        if (!TextUtils.isEmpty(this.cHF)) {
            sb.append(this.cHF);
        }
        if (!TextUtils.isEmpty(this.cHG)) {
            sb.append(" ").append(this.cHG);
        }
        return sb.toString();
    }

    public String amM() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.cHv)) {
            sb.append(this.cHv);
        }
        if (!TextUtils.isEmpty(this.cHw)) {
            sb.append(this.cHw);
        }
        if (!TextUtils.isEmpty(this.cHx)) {
            sb.append(this.cHx);
        }
        if (!TextUtils.isEmpty(this.cHy)) {
            sb.append(this.cHy);
        }
        if (!TextUtils.isEmpty(this.cHz)) {
            sb.append(" ").append(this.cHz);
        }
        return sb.toString();
    }

    public String amN() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.cHm)) {
            sb.append(this.cHm);
        }
        if (!TextUtils.isEmpty(this.cHn)) {
            sb.append(this.cHn);
        }
        if (!TextUtils.isEmpty(this.cHo)) {
            sb.append(this.cHo);
        }
        if (!TextUtils.isEmpty(this.cHp)) {
            sb.append(this.cHp);
        }
        if (!TextUtils.isEmpty(this.cHq)) {
            sb.append(" ").append(this.cHq);
        }
        return sb.toString();
    }
}
