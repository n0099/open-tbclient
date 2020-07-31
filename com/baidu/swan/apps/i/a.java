package com.baidu.swan.apps.i;

import android.content.ContentValues;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public String bYH;
    public String bYI;
    public String bYJ;
    public String bYK;
    public String bYL;
    public String bYM;
    public String bYN;
    public String bYO;
    public String bYP;
    public String bYQ;
    public String bYR;
    public String bYS;
    public String bYT;
    public String bYU;
    public String bYV;
    public String bYW;
    public String bYX;
    public String bYY;
    public String bYZ;
    public String bZa;
    public String bZb;
    public String bZc;
    public String bZd;
    public String bZe;
    public String bZf;
    public String bZg;
    public String bZh;
    public String email;
    public String nickName;
    public String remark;
    public String title;
    public String url;

    public boolean isValid() {
        return !TextUtils.isEmpty(this.bYK);
    }

    public static a aJ(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.bYH = jSONObject.optString("photoFilePath");
            aVar.nickName = jSONObject.optString("nickName");
            aVar.bYI = jSONObject.optString("lastName");
            aVar.bYJ = jSONObject.optString("middleName");
            aVar.bYK = jSONObject.optString("firstName");
            aVar.remark = jSONObject.optString("remark");
            aVar.bYL = jSONObject.optString("mobilePhoneNumber");
            aVar.bYM = jSONObject.optString("weChatNumber");
            aVar.bYN = jSONObject.optString("addressCountry");
            aVar.bYO = jSONObject.optString("addressState");
            aVar.bYP = jSONObject.optString("addressCity");
            aVar.bYQ = jSONObject.optString("addressStreet");
            aVar.bYR = jSONObject.optString("addressPostalCode");
            aVar.bYS = jSONObject.optString("organization");
            aVar.title = jSONObject.optString("title");
            aVar.bYT = jSONObject.optString("workFaxNumber");
            aVar.bYU = jSONObject.optString("workPhoneNumber");
            aVar.bYV = jSONObject.optString("hostNumber");
            aVar.email = jSONObject.optString(NotificationCompat.CATEGORY_EMAIL);
            aVar.url = jSONObject.optString("url");
            aVar.bYW = jSONObject.optString("workAddressCountry");
            aVar.bYX = jSONObject.optString("workAddressState");
            aVar.bYY = jSONObject.optString("workAddressCity");
            aVar.bYZ = jSONObject.optString("workAddressStreet");
            aVar.bZa = jSONObject.optString("workAddressPostalCode");
            aVar.bZb = jSONObject.optString("homeFaxNumber");
            aVar.bZc = jSONObject.optString("homePhoneNumber");
            aVar.bZd = jSONObject.optString("homeAddressCountry");
            aVar.bZe = jSONObject.optString("homeAddressState");
            aVar.bZf = jSONObject.optString("homeAddressCity");
            aVar.bZg = jSONObject.optString("homeAddressStreet");
            aVar.bZh = jSONObject.optString("homeAddressPostalCode");
        }
        return aVar;
    }

    public String getDisplayName() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.bYI)) {
            sb.append(this.bYI);
        }
        if (!TextUtils.isEmpty(this.bYJ)) {
            sb.append(this.bYJ);
        }
        if (!TextUtils.isEmpty(this.bYK)) {
            sb.append(this.bYK);
        }
        return sb.toString();
    }

    public ContentValues YC() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/nickname");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.nickName);
        return contentValues;
    }

    public ContentValues YD() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/note");
        contentValues.put("data1", this.remark);
        return contentValues;
    }

    public ContentValues YE() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", this.bYL);
        return contentValues;
    }

    public ContentValues YF() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.bZc);
        return contentValues;
    }

    public ContentValues YG() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", this.bYU);
        return contentValues;
    }

    public ContentValues YH() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 10);
        contentValues.put("data1", this.bYV);
        return contentValues;
    }

    public ContentValues YI() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 5);
        contentValues.put("data1", this.bZb);
        return contentValues;
    }

    public ContentValues YJ() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 4);
        contentValues.put("data1", this.bYT);
        return contentValues;
    }

    public ContentValues YK() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/im");
        contentValues.put("data5", (Integer) (-1));
        contentValues.put("data6", AppRuntime.getAppContext().getString(a.h.aiapps_cantact_wechat_lable));
        contentValues.put("data1", this.bYM);
        return contentValues;
    }

    public ContentValues YL() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/organization");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.bYS);
        contentValues.put("data4", this.title);
        return contentValues;
    }

    public ContentValues YM() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/website");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.url);
        return contentValues;
    }

    public ContentValues YN() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", YS());
        contentValues.put("data9", this.bYR);
        return contentValues;
    }

    public ContentValues YO() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", YR());
        contentValues.put("data9", this.bZa);
        return contentValues;
    }

    public ContentValues YP() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", YQ());
        contentValues.put("data9", this.bZh);
        return contentValues;
    }

    public String YQ() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.bZd)) {
            sb.append(this.bZd);
        }
        if (!TextUtils.isEmpty(this.bZe)) {
            sb.append(this.bZe);
        }
        if (!TextUtils.isEmpty(this.bZf)) {
            sb.append(this.bZf);
        }
        if (!TextUtils.isEmpty(this.bZg)) {
            sb.append(this.bZg);
        }
        if (!TextUtils.isEmpty(this.bZh)) {
            sb.append(" ").append(this.bZh);
        }
        return sb.toString();
    }

    public String YR() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.bYW)) {
            sb.append(this.bYW);
        }
        if (!TextUtils.isEmpty(this.bYX)) {
            sb.append(this.bYX);
        }
        if (!TextUtils.isEmpty(this.bYY)) {
            sb.append(this.bYY);
        }
        if (!TextUtils.isEmpty(this.bYZ)) {
            sb.append(this.bYZ);
        }
        if (!TextUtils.isEmpty(this.bZa)) {
            sb.append(" ").append(this.bZa);
        }
        return sb.toString();
    }

    public String YS() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.bYN)) {
            sb.append(this.bYN);
        }
        if (!TextUtils.isEmpty(this.bYO)) {
            sb.append(this.bYO);
        }
        if (!TextUtils.isEmpty(this.bYP)) {
            sb.append(this.bYP);
        }
        if (!TextUtils.isEmpty(this.bYQ)) {
            sb.append(this.bYQ);
        }
        if (!TextUtils.isEmpty(this.bYR)) {
            sb.append(" ").append(this.bYR);
        }
        return sb.toString();
    }
}
