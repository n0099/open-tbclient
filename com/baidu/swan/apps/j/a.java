package com.baidu.swan.apps.j;

import android.content.ContentValues;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public String ceA;
    public String ceB;
    public String ceC;
    public String ceD;
    public String ceE;
    public String ceF;
    public String ceG;
    public String ceH;
    public String ceI;
    public String ceJ;
    public String ceK;
    public String ceL;
    public String ceM;
    public String ceN;
    public String ceO;
    public String ceP;
    public String ceQ;
    public String ceR;
    public String cer;
    public String ces;
    public String cet;
    public String ceu;
    public String cev;
    public String cew;
    public String cex;
    public String cey;
    public String cez;
    public String email;
    public String nickName;
    public String remark;
    public String title;
    public String url;

    public boolean isValid() {
        return !TextUtils.isEmpty(this.ceu);
    }

    public static a aP(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.cer = jSONObject.optString("photoFilePath");
            aVar.nickName = jSONObject.optString("nickName");
            aVar.ces = jSONObject.optString("lastName");
            aVar.cet = jSONObject.optString("middleName");
            aVar.ceu = jSONObject.optString("firstName");
            aVar.remark = jSONObject.optString("remark");
            aVar.cev = jSONObject.optString("mobilePhoneNumber");
            aVar.cew = jSONObject.optString("weChatNumber");
            aVar.cex = jSONObject.optString("addressCountry");
            aVar.cey = jSONObject.optString("addressState");
            aVar.cez = jSONObject.optString("addressCity");
            aVar.ceA = jSONObject.optString("addressStreet");
            aVar.ceB = jSONObject.optString("addressPostalCode");
            aVar.ceC = jSONObject.optString("organization");
            aVar.title = jSONObject.optString("title");
            aVar.ceD = jSONObject.optString("workFaxNumber");
            aVar.ceE = jSONObject.optString("workPhoneNumber");
            aVar.ceF = jSONObject.optString("hostNumber");
            aVar.email = jSONObject.optString(NotificationCompat.CATEGORY_EMAIL);
            aVar.url = jSONObject.optString("url");
            aVar.ceG = jSONObject.optString("workAddressCountry");
            aVar.ceH = jSONObject.optString("workAddressState");
            aVar.ceI = jSONObject.optString("workAddressCity");
            aVar.ceJ = jSONObject.optString("workAddressStreet");
            aVar.ceK = jSONObject.optString("workAddressPostalCode");
            aVar.ceL = jSONObject.optString("homeFaxNumber");
            aVar.ceM = jSONObject.optString("homePhoneNumber");
            aVar.ceN = jSONObject.optString("homeAddressCountry");
            aVar.ceO = jSONObject.optString("homeAddressState");
            aVar.ceP = jSONObject.optString("homeAddressCity");
            aVar.ceQ = jSONObject.optString("homeAddressStreet");
            aVar.ceR = jSONObject.optString("homeAddressPostalCode");
        }
        return aVar;
    }

    public String getDisplayName() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.ces)) {
            sb.append(this.ces);
        }
        if (!TextUtils.isEmpty(this.cet)) {
            sb.append(this.cet);
        }
        if (!TextUtils.isEmpty(this.ceu)) {
            sb.append(this.ceu);
        }
        return sb.toString();
    }

    public ContentValues aeI() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/nickname");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.nickName);
        return contentValues;
    }

    public ContentValues aeJ() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/note");
        contentValues.put("data1", this.remark);
        return contentValues;
    }

    public ContentValues aeK() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", this.cev);
        return contentValues;
    }

    public ContentValues aeL() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.ceM);
        return contentValues;
    }

    public ContentValues aeM() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", this.ceE);
        return contentValues;
    }

    public ContentValues aeN() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 10);
        contentValues.put("data1", this.ceF);
        return contentValues;
    }

    public ContentValues aeO() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 5);
        contentValues.put("data1", this.ceL);
        return contentValues;
    }

    public ContentValues aeP() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 4);
        contentValues.put("data1", this.ceD);
        return contentValues;
    }

    public ContentValues aeQ() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/im");
        contentValues.put("data5", (Integer) (-1));
        contentValues.put("data6", AppRuntime.getAppContext().getString(a.h.aiapps_cantact_wechat_lable));
        contentValues.put("data1", this.cew);
        return contentValues;
    }

    public ContentValues aeR() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/organization");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.ceC);
        contentValues.put("data4", this.title);
        return contentValues;
    }

    public ContentValues aeS() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/website");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.url);
        return contentValues;
    }

    public ContentValues aeT() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", aeY());
        contentValues.put("data9", this.ceB);
        return contentValues;
    }

    public ContentValues aeU() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", aeX());
        contentValues.put("data9", this.ceK);
        return contentValues;
    }

    public ContentValues aeV() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", aeW());
        contentValues.put("data9", this.ceR);
        return contentValues;
    }

    public String aeW() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.ceN)) {
            sb.append(this.ceN);
        }
        if (!TextUtils.isEmpty(this.ceO)) {
            sb.append(this.ceO);
        }
        if (!TextUtils.isEmpty(this.ceP)) {
            sb.append(this.ceP);
        }
        if (!TextUtils.isEmpty(this.ceQ)) {
            sb.append(this.ceQ);
        }
        if (!TextUtils.isEmpty(this.ceR)) {
            sb.append(" ").append(this.ceR);
        }
        return sb.toString();
    }

    public String aeX() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.ceG)) {
            sb.append(this.ceG);
        }
        if (!TextUtils.isEmpty(this.ceH)) {
            sb.append(this.ceH);
        }
        if (!TextUtils.isEmpty(this.ceI)) {
            sb.append(this.ceI);
        }
        if (!TextUtils.isEmpty(this.ceJ)) {
            sb.append(this.ceJ);
        }
        if (!TextUtils.isEmpty(this.ceK)) {
            sb.append(" ").append(this.ceK);
        }
        return sb.toString();
    }

    public String aeY() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.cex)) {
            sb.append(this.cex);
        }
        if (!TextUtils.isEmpty(this.cey)) {
            sb.append(this.cey);
        }
        if (!TextUtils.isEmpty(this.cez)) {
            sb.append(this.cez);
        }
        if (!TextUtils.isEmpty(this.ceA)) {
            sb.append(this.ceA);
        }
        if (!TextUtils.isEmpty(this.ceB)) {
            sb.append(" ").append(this.ceB);
        }
        return sb.toString();
    }
}
