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
    public String csN;
    public String csO;
    public String csP;
    public String csQ;
    public String csR;
    public String csS;
    public String csT;
    public String csU;
    public String csV;
    public String csW;
    public String csX;
    public String csY;
    public String csZ;
    public String cta;
    public String ctb;
    public String ctc;
    public String ctd;
    public String cte;
    public String ctf;
    public String ctg;
    public String cth;
    public String cti;
    public String ctj;
    public String ctk;
    public String ctl;
    public String ctm;
    public String ctn;
    public String email;
    public String nickName;
    public String remark;
    public String title;
    public String url;

    public boolean isValid() {
        return !TextUtils.isEmpty(this.csQ);
    }

    public static a aZ(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.csN = jSONObject.optString("photoFilePath");
            aVar.nickName = jSONObject.optString("nickName");
            aVar.csO = jSONObject.optString("lastName");
            aVar.csP = jSONObject.optString("middleName");
            aVar.csQ = jSONObject.optString("firstName");
            aVar.remark = jSONObject.optString("remark");
            aVar.csR = jSONObject.optString("mobilePhoneNumber");
            aVar.csS = jSONObject.optString("weChatNumber");
            aVar.csT = jSONObject.optString("addressCountry");
            aVar.csU = jSONObject.optString("addressState");
            aVar.csV = jSONObject.optString("addressCity");
            aVar.csW = jSONObject.optString("addressStreet");
            aVar.csX = jSONObject.optString("addressPostalCode");
            aVar.csY = jSONObject.optString("organization");
            aVar.title = jSONObject.optString("title");
            aVar.csZ = jSONObject.optString("workFaxNumber");
            aVar.cta = jSONObject.optString("workPhoneNumber");
            aVar.ctb = jSONObject.optString("hostNumber");
            aVar.email = jSONObject.optString(NotificationCompat.CATEGORY_EMAIL);
            aVar.url = jSONObject.optString("url");
            aVar.ctc = jSONObject.optString("workAddressCountry");
            aVar.ctd = jSONObject.optString("workAddressState");
            aVar.cte = jSONObject.optString("workAddressCity");
            aVar.ctf = jSONObject.optString("workAddressStreet");
            aVar.ctg = jSONObject.optString("workAddressPostalCode");
            aVar.cth = jSONObject.optString("homeFaxNumber");
            aVar.cti = jSONObject.optString("homePhoneNumber");
            aVar.ctj = jSONObject.optString("homeAddressCountry");
            aVar.ctk = jSONObject.optString("homeAddressState");
            aVar.ctl = jSONObject.optString("homeAddressCity");
            aVar.ctm = jSONObject.optString("homeAddressStreet");
            aVar.ctn = jSONObject.optString("homeAddressPostalCode");
        }
        return aVar;
    }

    public String getDisplayName() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.csO)) {
            sb.append(this.csO);
        }
        if (!TextUtils.isEmpty(this.csP)) {
            sb.append(this.csP);
        }
        if (!TextUtils.isEmpty(this.csQ)) {
            sb.append(this.csQ);
        }
        return sb.toString();
    }

    public ContentValues aid() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/nickname");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.nickName);
        return contentValues;
    }

    public ContentValues aie() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/note");
        contentValues.put("data1", this.remark);
        return contentValues;
    }

    public ContentValues aif() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", this.csR);
        return contentValues;
    }

    public ContentValues aig() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.cti);
        return contentValues;
    }

    public ContentValues aih() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", this.cta);
        return contentValues;
    }

    public ContentValues aii() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 10);
        contentValues.put("data1", this.ctb);
        return contentValues;
    }

    public ContentValues aij() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 5);
        contentValues.put("data1", this.cth);
        return contentValues;
    }

    public ContentValues aik() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 4);
        contentValues.put("data1", this.csZ);
        return contentValues;
    }

    public ContentValues ail() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/im");
        contentValues.put("data5", (Integer) (-1));
        contentValues.put("data6", AppRuntime.getAppContext().getString(a.h.aiapps_cantact_wechat_lable));
        contentValues.put("data1", this.csS);
        return contentValues;
    }

    public ContentValues aim() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/organization");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.csY);
        contentValues.put("data4", this.title);
        return contentValues;
    }

    public ContentValues ain() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/website");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.url);
        return contentValues;
    }

    public ContentValues aio() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", ait());
        contentValues.put("data9", this.csX);
        return contentValues;
    }

    public ContentValues aip() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", ais());
        contentValues.put("data9", this.ctg);
        return contentValues;
    }

    public ContentValues aiq() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", air());
        contentValues.put("data9", this.ctn);
        return contentValues;
    }

    public String air() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.ctj)) {
            sb.append(this.ctj);
        }
        if (!TextUtils.isEmpty(this.ctk)) {
            sb.append(this.ctk);
        }
        if (!TextUtils.isEmpty(this.ctl)) {
            sb.append(this.ctl);
        }
        if (!TextUtils.isEmpty(this.ctm)) {
            sb.append(this.ctm);
        }
        if (!TextUtils.isEmpty(this.ctn)) {
            sb.append(" ").append(this.ctn);
        }
        return sb.toString();
    }

    public String ais() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.ctc)) {
            sb.append(this.ctc);
        }
        if (!TextUtils.isEmpty(this.ctd)) {
            sb.append(this.ctd);
        }
        if (!TextUtils.isEmpty(this.cte)) {
            sb.append(this.cte);
        }
        if (!TextUtils.isEmpty(this.ctf)) {
            sb.append(this.ctf);
        }
        if (!TextUtils.isEmpty(this.ctg)) {
            sb.append(" ").append(this.ctg);
        }
        return sb.toString();
    }

    public String ait() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.csT)) {
            sb.append(this.csT);
        }
        if (!TextUtils.isEmpty(this.csU)) {
            sb.append(this.csU);
        }
        if (!TextUtils.isEmpty(this.csV)) {
            sb.append(this.csV);
        }
        if (!TextUtils.isEmpty(this.csW)) {
            sb.append(this.csW);
        }
        if (!TextUtils.isEmpty(this.csX)) {
            sb.append(" ").append(this.csX);
        }
        return sb.toString();
    }
}
