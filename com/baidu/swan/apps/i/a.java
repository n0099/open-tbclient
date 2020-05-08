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
    public String bKA;
    public String bKB;
    public String bKC;
    public String bKD;
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
    public String bKz;
    public String email;
    public String nickName;
    public String remark;
    public String title;
    public String url;

    public boolean isValid() {
        return !TextUtils.isEmpty(this.bKg);
    }

    public static a ar(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.bKd = jSONObject.optString("photoFilePath");
            aVar.nickName = jSONObject.optString("nickName");
            aVar.bKe = jSONObject.optString("lastName");
            aVar.bKf = jSONObject.optString("middleName");
            aVar.bKg = jSONObject.optString("firstName");
            aVar.remark = jSONObject.optString("remark");
            aVar.bKh = jSONObject.optString("mobilePhoneNumber");
            aVar.bKi = jSONObject.optString("weChatNumber");
            aVar.bKj = jSONObject.optString("addressCountry");
            aVar.bKk = jSONObject.optString("addressState");
            aVar.bKl = jSONObject.optString("addressCity");
            aVar.bKm = jSONObject.optString("addressStreet");
            aVar.bKn = jSONObject.optString("addressPostalCode");
            aVar.bKo = jSONObject.optString("organization");
            aVar.title = jSONObject.optString("title");
            aVar.bKp = jSONObject.optString("workFaxNumber");
            aVar.bKq = jSONObject.optString("workPhoneNumber");
            aVar.bKr = jSONObject.optString("hostNumber");
            aVar.email = jSONObject.optString(NotificationCompat.CATEGORY_EMAIL);
            aVar.url = jSONObject.optString("url");
            aVar.bKs = jSONObject.optString("workAddressCountry");
            aVar.bKt = jSONObject.optString("workAddressState");
            aVar.bKu = jSONObject.optString("workAddressCity");
            aVar.bKv = jSONObject.optString("workAddressStreet");
            aVar.bKw = jSONObject.optString("workAddressPostalCode");
            aVar.bKx = jSONObject.optString("homeFaxNumber");
            aVar.bKy = jSONObject.optString("homePhoneNumber");
            aVar.bKz = jSONObject.optString("homeAddressCountry");
            aVar.bKA = jSONObject.optString("homeAddressState");
            aVar.bKB = jSONObject.optString("homeAddressCity");
            aVar.bKC = jSONObject.optString("homeAddressStreet");
            aVar.bKD = jSONObject.optString("homeAddressPostalCode");
        }
        return aVar;
    }

    public String getDisplayName() {
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
        return sb.toString();
    }

    public ContentValues Uk() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/nickname");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.nickName);
        return contentValues;
    }

    public ContentValues Ul() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/note");
        contentValues.put("data1", this.remark);
        return contentValues;
    }

    public ContentValues Um() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", this.bKh);
        return contentValues;
    }

    public ContentValues Un() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.bKy);
        return contentValues;
    }

    public ContentValues Uo() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", this.bKq);
        return contentValues;
    }

    public ContentValues Up() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 10);
        contentValues.put("data1", this.bKr);
        return contentValues;
    }

    public ContentValues Uq() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 5);
        contentValues.put("data1", this.bKx);
        return contentValues;
    }

    public ContentValues Ur() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 4);
        contentValues.put("data1", this.bKp);
        return contentValues;
    }

    public ContentValues Us() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/im");
        contentValues.put("data5", (Integer) (-1));
        contentValues.put("data6", AppRuntime.getAppContext().getString(a.h.aiapps_cantact_wechat_lable));
        contentValues.put("data1", this.bKi);
        return contentValues;
    }

    public ContentValues Ut() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/organization");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.bKo);
        contentValues.put("data4", this.title);
        return contentValues;
    }

    public ContentValues Uu() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/website");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.url);
        return contentValues;
    }

    public ContentValues Uv() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", UA());
        contentValues.put("data9", this.bKn);
        return contentValues;
    }

    public ContentValues Uw() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", Uz());
        contentValues.put("data9", this.bKw);
        return contentValues;
    }

    public ContentValues Ux() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", Uy());
        contentValues.put("data9", this.bKD);
        return contentValues;
    }

    public String Uy() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.bKz)) {
            sb.append(this.bKz);
        }
        if (!TextUtils.isEmpty(this.bKA)) {
            sb.append(this.bKA);
        }
        if (!TextUtils.isEmpty(this.bKB)) {
            sb.append(this.bKB);
        }
        if (!TextUtils.isEmpty(this.bKC)) {
            sb.append(this.bKC);
        }
        if (!TextUtils.isEmpty(this.bKD)) {
            sb.append(" ").append(this.bKD);
        }
        return sb.toString();
    }

    public String Uz() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.bKs)) {
            sb.append(this.bKs);
        }
        if (!TextUtils.isEmpty(this.bKt)) {
            sb.append(this.bKt);
        }
        if (!TextUtils.isEmpty(this.bKu)) {
            sb.append(this.bKu);
        }
        if (!TextUtils.isEmpty(this.bKv)) {
            sb.append(this.bKv);
        }
        if (!TextUtils.isEmpty(this.bKw)) {
            sb.append(" ").append(this.bKw);
        }
        return sb.toString();
    }

    public String UA() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.bKj)) {
            sb.append(this.bKj);
        }
        if (!TextUtils.isEmpty(this.bKk)) {
            sb.append(this.bKk);
        }
        if (!TextUtils.isEmpty(this.bKl)) {
            sb.append(this.bKl);
        }
        if (!TextUtils.isEmpty(this.bKm)) {
            sb.append(this.bKm);
        }
        if (!TextUtils.isEmpty(this.bKn)) {
            sb.append(" ").append(this.bKn);
        }
        return sb.toString();
    }
}
