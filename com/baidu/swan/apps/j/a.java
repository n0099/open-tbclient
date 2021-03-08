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
    public String cQA;
    public String cQB;
    public String cQC;
    public String cQD;
    public String cQE;
    public String cQF;
    public String cQG;
    public String cQH;
    public String cQI;
    public String cQJ;
    public String cQK;
    public String cQL;
    public String cQM;
    public String cQN;
    public String cQn;
    public String cQo;
    public String cQp;
    public String cQq;
    public String cQr;
    public String cQs;
    public String cQt;
    public String cQu;
    public String cQv;
    public String cQw;
    public String cQx;
    public String cQy;
    public String cQz;
    public String email;
    public String nickName;
    public String remark;
    public String title;
    public String url;

    public boolean isValid() {
        return !TextUtils.isEmpty(this.cQq);
    }

    public static a bl(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.cQn = jSONObject.optString("photoFilePath");
            aVar.nickName = jSONObject.optString("nickName");
            aVar.cQo = jSONObject.optString("lastName");
            aVar.cQp = jSONObject.optString("middleName");
            aVar.cQq = jSONObject.optString("firstName");
            aVar.remark = jSONObject.optString("remark");
            aVar.cQr = jSONObject.optString("mobilePhoneNumber");
            aVar.cQs = jSONObject.optString("weChatNumber");
            aVar.cQt = jSONObject.optString("addressCountry");
            aVar.cQu = jSONObject.optString("addressState");
            aVar.cQv = jSONObject.optString("addressCity");
            aVar.cQw = jSONObject.optString("addressStreet");
            aVar.cQx = jSONObject.optString("addressPostalCode");
            aVar.cQy = jSONObject.optString("organization");
            aVar.title = jSONObject.optString("title");
            aVar.cQz = jSONObject.optString("workFaxNumber");
            aVar.cQA = jSONObject.optString("workPhoneNumber");
            aVar.cQB = jSONObject.optString("hostNumber");
            aVar.email = jSONObject.optString(NotificationCompat.CATEGORY_EMAIL);
            aVar.url = jSONObject.optString("url");
            aVar.cQC = jSONObject.optString("workAddressCountry");
            aVar.cQD = jSONObject.optString("workAddressState");
            aVar.cQE = jSONObject.optString("workAddressCity");
            aVar.cQF = jSONObject.optString("workAddressStreet");
            aVar.cQG = jSONObject.optString("workAddressPostalCode");
            aVar.cQH = jSONObject.optString("homeFaxNumber");
            aVar.cQI = jSONObject.optString("homePhoneNumber");
            aVar.cQJ = jSONObject.optString("homeAddressCountry");
            aVar.cQK = jSONObject.optString("homeAddressState");
            aVar.cQL = jSONObject.optString("homeAddressCity");
            aVar.cQM = jSONObject.optString("homeAddressStreet");
            aVar.cQN = jSONObject.optString("homeAddressPostalCode");
        }
        return aVar;
    }

    public String getDisplayName() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.cQo)) {
            sb.append(this.cQo);
        }
        if (!TextUtils.isEmpty(this.cQp)) {
            sb.append(this.cQp);
        }
        if (!TextUtils.isEmpty(this.cQq)) {
            sb.append(this.cQq);
        }
        return sb.toString();
    }

    public ContentValues amR() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/nickname");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.nickName);
        return contentValues;
    }

    public ContentValues amS() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/note");
        contentValues.put("data1", this.remark);
        return contentValues;
    }

    public ContentValues amT() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", this.cQr);
        return contentValues;
    }

    public ContentValues amU() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.cQI);
        return contentValues;
    }

    public ContentValues amV() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", this.cQA);
        return contentValues;
    }

    public ContentValues amW() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 10);
        contentValues.put("data1", this.cQB);
        return contentValues;
    }

    public ContentValues amX() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 5);
        contentValues.put("data1", this.cQH);
        return contentValues;
    }

    public ContentValues amY() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 4);
        contentValues.put("data1", this.cQz);
        return contentValues;
    }

    public ContentValues amZ() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/im");
        contentValues.put("data5", (Integer) (-1));
        contentValues.put("data6", AppRuntime.getAppContext().getString(a.h.aiapps_cantact_wechat_lable));
        contentValues.put("data1", this.cQs);
        return contentValues;
    }

    public ContentValues ana() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/organization");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.cQy);
        contentValues.put("data4", this.title);
        return contentValues;
    }

    public ContentValues anb() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/website");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.url);
        return contentValues;
    }

    public ContentValues anc() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", anh());
        contentValues.put("data9", this.cQx);
        return contentValues;
    }

    public ContentValues and() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", ang());
        contentValues.put("data9", this.cQG);
        return contentValues;
    }

    public ContentValues ane() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", anf());
        contentValues.put("data9", this.cQN);
        return contentValues;
    }

    public String anf() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.cQJ)) {
            sb.append(this.cQJ);
        }
        if (!TextUtils.isEmpty(this.cQK)) {
            sb.append(this.cQK);
        }
        if (!TextUtils.isEmpty(this.cQL)) {
            sb.append(this.cQL);
        }
        if (!TextUtils.isEmpty(this.cQM)) {
            sb.append(this.cQM);
        }
        if (!TextUtils.isEmpty(this.cQN)) {
            sb.append(" ").append(this.cQN);
        }
        return sb.toString();
    }

    public String ang() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.cQC)) {
            sb.append(this.cQC);
        }
        if (!TextUtils.isEmpty(this.cQD)) {
            sb.append(this.cQD);
        }
        if (!TextUtils.isEmpty(this.cQE)) {
            sb.append(this.cQE);
        }
        if (!TextUtils.isEmpty(this.cQF)) {
            sb.append(this.cQF);
        }
        if (!TextUtils.isEmpty(this.cQG)) {
            sb.append(" ").append(this.cQG);
        }
        return sb.toString();
    }

    public String anh() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.cQt)) {
            sb.append(this.cQt);
        }
        if (!TextUtils.isEmpty(this.cQu)) {
            sb.append(this.cQu);
        }
        if (!TextUtils.isEmpty(this.cQv)) {
            sb.append(this.cQv);
        }
        if (!TextUtils.isEmpty(this.cQw)) {
            sb.append(this.cQw);
        }
        if (!TextUtils.isEmpty(this.cQx)) {
            sb.append(" ").append(this.cQx);
        }
        return sb.toString();
    }
}
