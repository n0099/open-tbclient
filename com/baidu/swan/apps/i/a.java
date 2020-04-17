package com.baidu.swan.apps.i;

import android.content.ContentValues;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public String bJY;
    public String bJZ;
    public String bKa;
    public String bKb;
    public String bKc;
    public String bKd;
    public String bKe;
    public String bKf;
    public String bKg;
    public String bKh;
    public String bKi;
    public String bKj;
    public String bKk;
    public String bKl;
    public String bKm;
    public String bKn;
    public String bKo;
    public String bKp;
    public String bKq;
    public String bKr;
    public String bKs;
    public String bKt;
    public String bKu;
    public String bKv;
    public String bKw;
    public String bKx;
    public String bKy;
    public String email;
    public String nickName;
    public String remark;
    public String title;
    public String url;

    public boolean isValid() {
        return !TextUtils.isEmpty(this.bKb);
    }

    public static a ar(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.bJY = jSONObject.optString("photoFilePath");
            aVar.nickName = jSONObject.optString("nickName");
            aVar.bJZ = jSONObject.optString("lastName");
            aVar.bKa = jSONObject.optString("middleName");
            aVar.bKb = jSONObject.optString("firstName");
            aVar.remark = jSONObject.optString("remark");
            aVar.bKc = jSONObject.optString("mobilePhoneNumber");
            aVar.bKd = jSONObject.optString("weChatNumber");
            aVar.bKe = jSONObject.optString("addressCountry");
            aVar.bKf = jSONObject.optString("addressState");
            aVar.bKg = jSONObject.optString("addressCity");
            aVar.bKh = jSONObject.optString("addressStreet");
            aVar.bKi = jSONObject.optString("addressPostalCode");
            aVar.bKj = jSONObject.optString("organization");
            aVar.title = jSONObject.optString("title");
            aVar.bKk = jSONObject.optString("workFaxNumber");
            aVar.bKl = jSONObject.optString("workPhoneNumber");
            aVar.bKm = jSONObject.optString("hostNumber");
            aVar.email = jSONObject.optString(NotificationCompat.CATEGORY_EMAIL);
            aVar.url = jSONObject.optString("url");
            aVar.bKn = jSONObject.optString("workAddressCountry");
            aVar.bKo = jSONObject.optString("workAddressState");
            aVar.bKp = jSONObject.optString("workAddressCity");
            aVar.bKq = jSONObject.optString("workAddressStreet");
            aVar.bKr = jSONObject.optString("workAddressPostalCode");
            aVar.bKs = jSONObject.optString("homeFaxNumber");
            aVar.bKt = jSONObject.optString("homePhoneNumber");
            aVar.bKu = jSONObject.optString("homeAddressCountry");
            aVar.bKv = jSONObject.optString("homeAddressState");
            aVar.bKw = jSONObject.optString("homeAddressCity");
            aVar.bKx = jSONObject.optString("homeAddressStreet");
            aVar.bKy = jSONObject.optString("homeAddressPostalCode");
        }
        return aVar;
    }

    public String getDisplayName() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.bJZ)) {
            sb.append(this.bJZ);
        }
        if (!TextUtils.isEmpty(this.bKa)) {
            sb.append(this.bKa);
        }
        if (!TextUtils.isEmpty(this.bKb)) {
            sb.append(this.bKb);
        }
        return sb.toString();
    }

    public ContentValues Ul() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/nickname");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.nickName);
        return contentValues;
    }

    public ContentValues Um() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/note");
        contentValues.put("data1", this.remark);
        return contentValues;
    }

    public ContentValues Un() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", this.bKc);
        return contentValues;
    }

    public ContentValues Uo() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.bKt);
        return contentValues;
    }

    public ContentValues Up() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", this.bKl);
        return contentValues;
    }

    public ContentValues Uq() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 10);
        contentValues.put("data1", this.bKm);
        return contentValues;
    }

    public ContentValues Ur() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 5);
        contentValues.put("data1", this.bKs);
        return contentValues;
    }

    public ContentValues Us() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 4);
        contentValues.put("data1", this.bKk);
        return contentValues;
    }

    public ContentValues Ut() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/im");
        contentValues.put("data5", (Integer) (-1));
        contentValues.put("data6", AppRuntime.getAppContext().getString(a.h.aiapps_cantact_wechat_lable));
        contentValues.put("data1", this.bKd);
        return contentValues;
    }

    public ContentValues Uu() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/organization");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.bKj);
        contentValues.put("data4", this.title);
        return contentValues;
    }

    public ContentValues Uv() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/website");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.url);
        return contentValues;
    }

    public ContentValues Uw() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", UB());
        contentValues.put("data9", this.bKi);
        return contentValues;
    }

    public ContentValues Ux() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", UA());
        contentValues.put("data9", this.bKr);
        return contentValues;
    }

    public ContentValues Uy() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", Uz());
        contentValues.put("data9", this.bKy);
        return contentValues;
    }

    public String Uz() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.bKu)) {
            sb.append(this.bKu);
        }
        if (!TextUtils.isEmpty(this.bKv)) {
            sb.append(this.bKv);
        }
        if (!TextUtils.isEmpty(this.bKw)) {
            sb.append(this.bKw);
        }
        if (!TextUtils.isEmpty(this.bKx)) {
            sb.append(this.bKx);
        }
        if (!TextUtils.isEmpty(this.bKy)) {
            sb.append(" ").append(this.bKy);
        }
        return sb.toString();
    }

    public String UA() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.bKn)) {
            sb.append(this.bKn);
        }
        if (!TextUtils.isEmpty(this.bKo)) {
            sb.append(this.bKo);
        }
        if (!TextUtils.isEmpty(this.bKp)) {
            sb.append(this.bKp);
        }
        if (!TextUtils.isEmpty(this.bKq)) {
            sb.append(this.bKq);
        }
        if (!TextUtils.isEmpty(this.bKr)) {
            sb.append(" ").append(this.bKr);
        }
        return sb.toString();
    }

    public String UB() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.bKe)) {
            sb.append(this.bKe);
        }
        if (!TextUtils.isEmpty(this.bKf)) {
            sb.append(this.bKf);
        }
        if (!TextUtils.isEmpty(this.bKg)) {
            sb.append(this.bKg);
        }
        if (!TextUtils.isEmpty(this.bKh)) {
            sb.append(this.bKh);
        }
        if (!TextUtils.isEmpty(this.bKi)) {
            sb.append(" ").append(this.bKi);
        }
        return sb.toString();
    }
}
