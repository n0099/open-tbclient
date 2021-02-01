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
    public String cON;
    public String cOO;
    public String cOP;
    public String cOQ;
    public String cOR;
    public String cOS;
    public String cOT;
    public String cOU;
    public String cOV;
    public String cOW;
    public String cOX;
    public String cOY;
    public String cOZ;
    public String cPa;
    public String cPb;
    public String cPc;
    public String cPd;
    public String cPe;
    public String cPf;
    public String cPg;
    public String cPh;
    public String cPi;
    public String cPj;
    public String cPk;
    public String cPl;
    public String cPm;
    public String cPn;
    public String email;
    public String nickName;
    public String remark;
    public String title;
    public String url;

    public boolean isValid() {
        return !TextUtils.isEmpty(this.cOQ);
    }

    public static a bj(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.cON = jSONObject.optString("photoFilePath");
            aVar.nickName = jSONObject.optString("nickName");
            aVar.cOO = jSONObject.optString("lastName");
            aVar.cOP = jSONObject.optString("middleName");
            aVar.cOQ = jSONObject.optString("firstName");
            aVar.remark = jSONObject.optString("remark");
            aVar.cOR = jSONObject.optString("mobilePhoneNumber");
            aVar.cOS = jSONObject.optString("weChatNumber");
            aVar.cOT = jSONObject.optString("addressCountry");
            aVar.cOU = jSONObject.optString("addressState");
            aVar.cOV = jSONObject.optString("addressCity");
            aVar.cOW = jSONObject.optString("addressStreet");
            aVar.cOX = jSONObject.optString("addressPostalCode");
            aVar.cOY = jSONObject.optString("organization");
            aVar.title = jSONObject.optString("title");
            aVar.cOZ = jSONObject.optString("workFaxNumber");
            aVar.cPa = jSONObject.optString("workPhoneNumber");
            aVar.cPb = jSONObject.optString("hostNumber");
            aVar.email = jSONObject.optString(NotificationCompat.CATEGORY_EMAIL);
            aVar.url = jSONObject.optString("url");
            aVar.cPc = jSONObject.optString("workAddressCountry");
            aVar.cPd = jSONObject.optString("workAddressState");
            aVar.cPe = jSONObject.optString("workAddressCity");
            aVar.cPf = jSONObject.optString("workAddressStreet");
            aVar.cPg = jSONObject.optString("workAddressPostalCode");
            aVar.cPh = jSONObject.optString("homeFaxNumber");
            aVar.cPi = jSONObject.optString("homePhoneNumber");
            aVar.cPj = jSONObject.optString("homeAddressCountry");
            aVar.cPk = jSONObject.optString("homeAddressState");
            aVar.cPl = jSONObject.optString("homeAddressCity");
            aVar.cPm = jSONObject.optString("homeAddressStreet");
            aVar.cPn = jSONObject.optString("homeAddressPostalCode");
        }
        return aVar;
    }

    public String getDisplayName() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.cOO)) {
            sb.append(this.cOO);
        }
        if (!TextUtils.isEmpty(this.cOP)) {
            sb.append(this.cOP);
        }
        if (!TextUtils.isEmpty(this.cOQ)) {
            sb.append(this.cOQ);
        }
        return sb.toString();
    }

    public ContentValues amO() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/nickname");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.nickName);
        return contentValues;
    }

    public ContentValues amP() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/note");
        contentValues.put("data1", this.remark);
        return contentValues;
    }

    public ContentValues amQ() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", this.cOR);
        return contentValues;
    }

    public ContentValues amR() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.cPi);
        return contentValues;
    }

    public ContentValues amS() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", this.cPa);
        return contentValues;
    }

    public ContentValues amT() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 10);
        contentValues.put("data1", this.cPb);
        return contentValues;
    }

    public ContentValues amU() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 5);
        contentValues.put("data1", this.cPh);
        return contentValues;
    }

    public ContentValues amV() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 4);
        contentValues.put("data1", this.cOZ);
        return contentValues;
    }

    public ContentValues amW() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/im");
        contentValues.put("data5", (Integer) (-1));
        contentValues.put("data6", AppRuntime.getAppContext().getString(a.h.aiapps_cantact_wechat_lable));
        contentValues.put("data1", this.cOS);
        return contentValues;
    }

    public ContentValues amX() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/organization");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.cOY);
        contentValues.put("data4", this.title);
        return contentValues;
    }

    public ContentValues amY() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/website");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.url);
        return contentValues;
    }

    public ContentValues amZ() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", ane());
        contentValues.put("data9", this.cOX);
        return contentValues;
    }

    public ContentValues ana() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", and());
        contentValues.put("data9", this.cPg);
        return contentValues;
    }

    public ContentValues anb() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", anc());
        contentValues.put("data9", this.cPn);
        return contentValues;
    }

    public String anc() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.cPj)) {
            sb.append(this.cPj);
        }
        if (!TextUtils.isEmpty(this.cPk)) {
            sb.append(this.cPk);
        }
        if (!TextUtils.isEmpty(this.cPl)) {
            sb.append(this.cPl);
        }
        if (!TextUtils.isEmpty(this.cPm)) {
            sb.append(this.cPm);
        }
        if (!TextUtils.isEmpty(this.cPn)) {
            sb.append(" ").append(this.cPn);
        }
        return sb.toString();
    }

    public String and() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.cPc)) {
            sb.append(this.cPc);
        }
        if (!TextUtils.isEmpty(this.cPd)) {
            sb.append(this.cPd);
        }
        if (!TextUtils.isEmpty(this.cPe)) {
            sb.append(this.cPe);
        }
        if (!TextUtils.isEmpty(this.cPf)) {
            sb.append(this.cPf);
        }
        if (!TextUtils.isEmpty(this.cPg)) {
            sb.append(" ").append(this.cPg);
        }
        return sb.toString();
    }

    public String ane() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.cOT)) {
            sb.append(this.cOT);
        }
        if (!TextUtils.isEmpty(this.cOU)) {
            sb.append(this.cOU);
        }
        if (!TextUtils.isEmpty(this.cOV)) {
            sb.append(this.cOV);
        }
        if (!TextUtils.isEmpty(this.cOW)) {
            sb.append(this.cOW);
        }
        if (!TextUtils.isEmpty(this.cOX)) {
            sb.append(" ").append(this.cOX);
        }
        return sb.toString();
    }
}
