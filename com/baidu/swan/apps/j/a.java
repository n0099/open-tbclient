package com.baidu.swan.apps.j;

import android.content.ContentValues;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public String cFA;
    public String cFB;
    public String cFC;
    public String cFD;
    public String cFE;
    public String cFF;
    public String cFG;
    public String cFH;
    public String cFI;
    public String cFJ;
    public String cFK;
    public String cFL;
    public String cFM;
    public String cFN;
    public String cFO;
    public String cFP;
    public String cFQ;
    public String cFR;
    public String cFS;
    public String cFT;
    public String cFU;
    public String cFV;
    public String cFW;
    public String cFw;
    public String cFx;
    public String cFy;
    public String cFz;
    public String email;
    public String nickName;
    public String remark;
    public String title;
    public String url;

    public boolean isValid() {
        return !TextUtils.isEmpty(this.cFz);
    }

    public static a bc(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.cFw = jSONObject.optString("photoFilePath");
            aVar.nickName = jSONObject.optString("nickName");
            aVar.cFx = jSONObject.optString("lastName");
            aVar.cFy = jSONObject.optString("middleName");
            aVar.cFz = jSONObject.optString("firstName");
            aVar.remark = jSONObject.optString("remark");
            aVar.cFA = jSONObject.optString("mobilePhoneNumber");
            aVar.cFB = jSONObject.optString("weChatNumber");
            aVar.cFC = jSONObject.optString("addressCountry");
            aVar.cFD = jSONObject.optString("addressState");
            aVar.cFE = jSONObject.optString("addressCity");
            aVar.cFF = jSONObject.optString("addressStreet");
            aVar.cFG = jSONObject.optString("addressPostalCode");
            aVar.cFH = jSONObject.optString("organization");
            aVar.title = jSONObject.optString("title");
            aVar.cFI = jSONObject.optString("workFaxNumber");
            aVar.cFJ = jSONObject.optString("workPhoneNumber");
            aVar.cFK = jSONObject.optString("hostNumber");
            aVar.email = jSONObject.optString(NotificationCompat.CATEGORY_EMAIL);
            aVar.url = jSONObject.optString("url");
            aVar.cFL = jSONObject.optString("workAddressCountry");
            aVar.cFM = jSONObject.optString("workAddressState");
            aVar.cFN = jSONObject.optString("workAddressCity");
            aVar.cFO = jSONObject.optString("workAddressStreet");
            aVar.cFP = jSONObject.optString("workAddressPostalCode");
            aVar.cFQ = jSONObject.optString("homeFaxNumber");
            aVar.cFR = jSONObject.optString("homePhoneNumber");
            aVar.cFS = jSONObject.optString("homeAddressCountry");
            aVar.cFT = jSONObject.optString("homeAddressState");
            aVar.cFU = jSONObject.optString("homeAddressCity");
            aVar.cFV = jSONObject.optString("homeAddressStreet");
            aVar.cFW = jSONObject.optString("homeAddressPostalCode");
        }
        return aVar;
    }

    public String getDisplayName() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.cFx)) {
            sb.append(this.cFx);
        }
        if (!TextUtils.isEmpty(this.cFy)) {
            sb.append(this.cFy);
        }
        if (!TextUtils.isEmpty(this.cFz)) {
            sb.append(this.cFz);
        }
        return sb.toString();
    }

    public ContentValues alP() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/nickname");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.nickName);
        return contentValues;
    }

    public ContentValues alQ() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/note");
        contentValues.put("data1", this.remark);
        return contentValues;
    }

    public ContentValues alR() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", this.cFA);
        return contentValues;
    }

    public ContentValues alS() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.cFR);
        return contentValues;
    }

    public ContentValues alT() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", this.cFJ);
        return contentValues;
    }

    public ContentValues alU() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 10);
        contentValues.put("data1", this.cFK);
        return contentValues;
    }

    public ContentValues alV() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 5);
        contentValues.put("data1", this.cFQ);
        return contentValues;
    }

    public ContentValues alW() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 4);
        contentValues.put("data1", this.cFI);
        return contentValues;
    }

    public ContentValues alX() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/im");
        contentValues.put("data5", (Integer) (-1));
        contentValues.put("data6", AppRuntime.getAppContext().getString(a.h.aiapps_cantact_wechat_lable));
        contentValues.put("data1", this.cFB);
        return contentValues;
    }

    public ContentValues alY() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/organization");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.cFH);
        contentValues.put("data4", this.title);
        return contentValues;
    }

    public ContentValues alZ() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/website");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.url);
        return contentValues;
    }

    public ContentValues ama() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", amf());
        contentValues.put("data9", this.cFG);
        return contentValues;
    }

    public ContentValues amb() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", ame());
        contentValues.put("data9", this.cFP);
        return contentValues;
    }

    public ContentValues amc() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", amd());
        contentValues.put("data9", this.cFW);
        return contentValues;
    }

    public String amd() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.cFS)) {
            sb.append(this.cFS);
        }
        if (!TextUtils.isEmpty(this.cFT)) {
            sb.append(this.cFT);
        }
        if (!TextUtils.isEmpty(this.cFU)) {
            sb.append(this.cFU);
        }
        if (!TextUtils.isEmpty(this.cFV)) {
            sb.append(this.cFV);
        }
        if (!TextUtils.isEmpty(this.cFW)) {
            sb.append(" ").append(this.cFW);
        }
        return sb.toString();
    }

    public String ame() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.cFL)) {
            sb.append(this.cFL);
        }
        if (!TextUtils.isEmpty(this.cFM)) {
            sb.append(this.cFM);
        }
        if (!TextUtils.isEmpty(this.cFN)) {
            sb.append(this.cFN);
        }
        if (!TextUtils.isEmpty(this.cFO)) {
            sb.append(this.cFO);
        }
        if (!TextUtils.isEmpty(this.cFP)) {
            sb.append(" ").append(this.cFP);
        }
        return sb.toString();
    }

    public String amf() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.cFC)) {
            sb.append(this.cFC);
        }
        if (!TextUtils.isEmpty(this.cFD)) {
            sb.append(this.cFD);
        }
        if (!TextUtils.isEmpty(this.cFE)) {
            sb.append(this.cFE);
        }
        if (!TextUtils.isEmpty(this.cFF)) {
            sb.append(this.cFF);
        }
        if (!TextUtils.isEmpty(this.cFG)) {
            sb.append(" ").append(this.cFG);
        }
        return sb.toString();
    }
}
