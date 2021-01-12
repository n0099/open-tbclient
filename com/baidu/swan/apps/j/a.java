package com.baidu.swan.apps.j;

import android.content.ContentValues;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import org.json.JSONObject;
/* loaded from: classes8.dex */
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
    public String cMR;
    public String cMS;
    public String cMT;
    public String cMU;
    public String cMV;
    public String cMW;
    public String cMX;
    public String cMY;
    public String cMZ;
    public String cMz;
    public String email;
    public String nickName;
    public String remark;
    public String title;
    public String url;

    public boolean isValid() {
        return !TextUtils.isEmpty(this.cMC);
    }

    public static a bm(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.cMz = jSONObject.optString("photoFilePath");
            aVar.nickName = jSONObject.optString("nickName");
            aVar.cMA = jSONObject.optString("lastName");
            aVar.cMB = jSONObject.optString("middleName");
            aVar.cMC = jSONObject.optString("firstName");
            aVar.remark = jSONObject.optString("remark");
            aVar.cMD = jSONObject.optString("mobilePhoneNumber");
            aVar.cME = jSONObject.optString("weChatNumber");
            aVar.cMF = jSONObject.optString("addressCountry");
            aVar.cMG = jSONObject.optString("addressState");
            aVar.cMH = jSONObject.optString("addressCity");
            aVar.cMI = jSONObject.optString("addressStreet");
            aVar.cMJ = jSONObject.optString("addressPostalCode");
            aVar.cMK = jSONObject.optString("organization");
            aVar.title = jSONObject.optString("title");
            aVar.cML = jSONObject.optString("workFaxNumber");
            aVar.cMM = jSONObject.optString("workPhoneNumber");
            aVar.cMN = jSONObject.optString("hostNumber");
            aVar.email = jSONObject.optString(NotificationCompat.CATEGORY_EMAIL);
            aVar.url = jSONObject.optString("url");
            aVar.cMO = jSONObject.optString("workAddressCountry");
            aVar.cMP = jSONObject.optString("workAddressState");
            aVar.cMQ = jSONObject.optString("workAddressCity");
            aVar.cMR = jSONObject.optString("workAddressStreet");
            aVar.cMS = jSONObject.optString("workAddressPostalCode");
            aVar.cMT = jSONObject.optString("homeFaxNumber");
            aVar.cMU = jSONObject.optString("homePhoneNumber");
            aVar.cMV = jSONObject.optString("homeAddressCountry");
            aVar.cMW = jSONObject.optString("homeAddressState");
            aVar.cMX = jSONObject.optString("homeAddressCity");
            aVar.cMY = jSONObject.optString("homeAddressStreet");
            aVar.cMZ = jSONObject.optString("homeAddressPostalCode");
        }
        return aVar;
    }

    public String getDisplayName() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.cMA)) {
            sb.append(this.cMA);
        }
        if (!TextUtils.isEmpty(this.cMB)) {
            sb.append(this.cMB);
        }
        if (!TextUtils.isEmpty(this.cMC)) {
            sb.append(this.cMC);
        }
        return sb.toString();
    }

    public ContentValues amq() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/nickname");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.nickName);
        return contentValues;
    }

    public ContentValues amr() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/note");
        contentValues.put("data1", this.remark);
        return contentValues;
    }

    public ContentValues ams() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", this.cMD);
        return contentValues;
    }

    public ContentValues amt() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.cMU);
        return contentValues;
    }

    public ContentValues amu() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", this.cMM);
        return contentValues;
    }

    public ContentValues amv() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 10);
        contentValues.put("data1", this.cMN);
        return contentValues;
    }

    public ContentValues amw() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 5);
        contentValues.put("data1", this.cMT);
        return contentValues;
    }

    public ContentValues amx() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 4);
        contentValues.put("data1", this.cML);
        return contentValues;
    }

    public ContentValues amy() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/im");
        contentValues.put("data5", (Integer) (-1));
        contentValues.put("data6", AppRuntime.getAppContext().getString(a.h.aiapps_cantact_wechat_lable));
        contentValues.put("data1", this.cME);
        return contentValues;
    }

    public ContentValues amz() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/organization");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.cMK);
        contentValues.put("data4", this.title);
        return contentValues;
    }

    public ContentValues amA() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/website");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.url);
        return contentValues;
    }

    public ContentValues amB() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", amG());
        contentValues.put("data9", this.cMJ);
        return contentValues;
    }

    public ContentValues amC() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", amF());
        contentValues.put("data9", this.cMS);
        return contentValues;
    }

    public ContentValues amD() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", amE());
        contentValues.put("data9", this.cMZ);
        return contentValues;
    }

    public String amE() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.cMV)) {
            sb.append(this.cMV);
        }
        if (!TextUtils.isEmpty(this.cMW)) {
            sb.append(this.cMW);
        }
        if (!TextUtils.isEmpty(this.cMX)) {
            sb.append(this.cMX);
        }
        if (!TextUtils.isEmpty(this.cMY)) {
            sb.append(this.cMY);
        }
        if (!TextUtils.isEmpty(this.cMZ)) {
            sb.append(" ").append(this.cMZ);
        }
        return sb.toString();
    }

    public String amF() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.cMO)) {
            sb.append(this.cMO);
        }
        if (!TextUtils.isEmpty(this.cMP)) {
            sb.append(this.cMP);
        }
        if (!TextUtils.isEmpty(this.cMQ)) {
            sb.append(this.cMQ);
        }
        if (!TextUtils.isEmpty(this.cMR)) {
            sb.append(this.cMR);
        }
        if (!TextUtils.isEmpty(this.cMS)) {
            sb.append(" ").append(this.cMS);
        }
        return sb.toString();
    }

    public String amG() {
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
}
