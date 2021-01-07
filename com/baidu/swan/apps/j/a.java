package com.baidu.swan.apps.j;

import android.content.ContentValues;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public String cRA;
    public String cRB;
    public String cRC;
    public String cRD;
    public String cRE;
    public String cRF;
    public String cRG;
    public String cRH;
    public String cRI;
    public String cRJ;
    public String cRK;
    public String cRL;
    public String cRl;
    public String cRm;
    public String cRn;
    public String cRo;
    public String cRp;
    public String cRq;
    public String cRr;
    public String cRs;
    public String cRt;
    public String cRu;
    public String cRv;
    public String cRw;
    public String cRx;
    public String cRy;
    public String cRz;
    public String email;
    public String nickName;
    public String remark;
    public String title;
    public String url;

    public boolean isValid() {
        return !TextUtils.isEmpty(this.cRo);
    }

    public static a bm(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.cRl = jSONObject.optString("photoFilePath");
            aVar.nickName = jSONObject.optString("nickName");
            aVar.cRm = jSONObject.optString("lastName");
            aVar.cRn = jSONObject.optString("middleName");
            aVar.cRo = jSONObject.optString("firstName");
            aVar.remark = jSONObject.optString("remark");
            aVar.cRp = jSONObject.optString("mobilePhoneNumber");
            aVar.cRq = jSONObject.optString("weChatNumber");
            aVar.cRr = jSONObject.optString("addressCountry");
            aVar.cRs = jSONObject.optString("addressState");
            aVar.cRt = jSONObject.optString("addressCity");
            aVar.cRu = jSONObject.optString("addressStreet");
            aVar.cRv = jSONObject.optString("addressPostalCode");
            aVar.cRw = jSONObject.optString("organization");
            aVar.title = jSONObject.optString("title");
            aVar.cRx = jSONObject.optString("workFaxNumber");
            aVar.cRy = jSONObject.optString("workPhoneNumber");
            aVar.cRz = jSONObject.optString("hostNumber");
            aVar.email = jSONObject.optString(NotificationCompat.CATEGORY_EMAIL);
            aVar.url = jSONObject.optString("url");
            aVar.cRA = jSONObject.optString("workAddressCountry");
            aVar.cRB = jSONObject.optString("workAddressState");
            aVar.cRC = jSONObject.optString("workAddressCity");
            aVar.cRD = jSONObject.optString("workAddressStreet");
            aVar.cRE = jSONObject.optString("workAddressPostalCode");
            aVar.cRF = jSONObject.optString("homeFaxNumber");
            aVar.cRG = jSONObject.optString("homePhoneNumber");
            aVar.cRH = jSONObject.optString("homeAddressCountry");
            aVar.cRI = jSONObject.optString("homeAddressState");
            aVar.cRJ = jSONObject.optString("homeAddressCity");
            aVar.cRK = jSONObject.optString("homeAddressStreet");
            aVar.cRL = jSONObject.optString("homeAddressPostalCode");
        }
        return aVar;
    }

    public String getDisplayName() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.cRm)) {
            sb.append(this.cRm);
        }
        if (!TextUtils.isEmpty(this.cRn)) {
            sb.append(this.cRn);
        }
        if (!TextUtils.isEmpty(this.cRo)) {
            sb.append(this.cRo);
        }
        return sb.toString();
    }

    public ContentValues aql() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/nickname");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.nickName);
        return contentValues;
    }

    public ContentValues aqm() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/note");
        contentValues.put("data1", this.remark);
        return contentValues;
    }

    public ContentValues aqn() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", this.cRp);
        return contentValues;
    }

    public ContentValues aqo() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.cRG);
        return contentValues;
    }

    public ContentValues aqp() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", this.cRy);
        return contentValues;
    }

    public ContentValues aqq() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 10);
        contentValues.put("data1", this.cRz);
        return contentValues;
    }

    public ContentValues aqr() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 5);
        contentValues.put("data1", this.cRF);
        return contentValues;
    }

    public ContentValues aqs() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 4);
        contentValues.put("data1", this.cRx);
        return contentValues;
    }

    public ContentValues aqt() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/im");
        contentValues.put("data5", (Integer) (-1));
        contentValues.put("data6", AppRuntime.getAppContext().getString(a.h.aiapps_cantact_wechat_lable));
        contentValues.put("data1", this.cRq);
        return contentValues;
    }

    public ContentValues aqu() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/organization");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.cRw);
        contentValues.put("data4", this.title);
        return contentValues;
    }

    public ContentValues aqv() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/website");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.url);
        return contentValues;
    }

    public ContentValues aqw() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", aqB());
        contentValues.put("data9", this.cRv);
        return contentValues;
    }

    public ContentValues aqx() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", aqA());
        contentValues.put("data9", this.cRE);
        return contentValues;
    }

    public ContentValues aqy() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", aqz());
        contentValues.put("data9", this.cRL);
        return contentValues;
    }

    public String aqz() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.cRH)) {
            sb.append(this.cRH);
        }
        if (!TextUtils.isEmpty(this.cRI)) {
            sb.append(this.cRI);
        }
        if (!TextUtils.isEmpty(this.cRJ)) {
            sb.append(this.cRJ);
        }
        if (!TextUtils.isEmpty(this.cRK)) {
            sb.append(this.cRK);
        }
        if (!TextUtils.isEmpty(this.cRL)) {
            sb.append(" ").append(this.cRL);
        }
        return sb.toString();
    }

    public String aqA() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.cRA)) {
            sb.append(this.cRA);
        }
        if (!TextUtils.isEmpty(this.cRB)) {
            sb.append(this.cRB);
        }
        if (!TextUtils.isEmpty(this.cRC)) {
            sb.append(this.cRC);
        }
        if (!TextUtils.isEmpty(this.cRD)) {
            sb.append(this.cRD);
        }
        if (!TextUtils.isEmpty(this.cRE)) {
            sb.append(" ").append(this.cRE);
        }
        return sb.toString();
    }

    public String aqB() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.cRr)) {
            sb.append(this.cRr);
        }
        if (!TextUtils.isEmpty(this.cRs)) {
            sb.append(this.cRs);
        }
        if (!TextUtils.isEmpty(this.cRt)) {
            sb.append(this.cRt);
        }
        if (!TextUtils.isEmpty(this.cRu)) {
            sb.append(this.cRu);
        }
        if (!TextUtils.isEmpty(this.cRv)) {
            sb.append(" ").append(this.cRv);
        }
        return sb.toString();
    }
}
