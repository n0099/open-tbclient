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
    public String ceS;
    public String ceT;
    public String ceU;
    public String ceV;
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
        return !TextUtils.isEmpty(this.cey);
    }

    public static a aP(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.cev = jSONObject.optString("photoFilePath");
            aVar.nickName = jSONObject.optString("nickName");
            aVar.cew = jSONObject.optString("lastName");
            aVar.cex = jSONObject.optString("middleName");
            aVar.cey = jSONObject.optString("firstName");
            aVar.remark = jSONObject.optString("remark");
            aVar.cez = jSONObject.optString("mobilePhoneNumber");
            aVar.ceA = jSONObject.optString("weChatNumber");
            aVar.ceB = jSONObject.optString("addressCountry");
            aVar.ceC = jSONObject.optString("addressState");
            aVar.ceD = jSONObject.optString("addressCity");
            aVar.ceE = jSONObject.optString("addressStreet");
            aVar.ceF = jSONObject.optString("addressPostalCode");
            aVar.ceG = jSONObject.optString("organization");
            aVar.title = jSONObject.optString("title");
            aVar.ceH = jSONObject.optString("workFaxNumber");
            aVar.ceI = jSONObject.optString("workPhoneNumber");
            aVar.ceJ = jSONObject.optString("hostNumber");
            aVar.email = jSONObject.optString(NotificationCompat.CATEGORY_EMAIL);
            aVar.url = jSONObject.optString("url");
            aVar.ceK = jSONObject.optString("workAddressCountry");
            aVar.ceL = jSONObject.optString("workAddressState");
            aVar.ceM = jSONObject.optString("workAddressCity");
            aVar.ceN = jSONObject.optString("workAddressStreet");
            aVar.ceO = jSONObject.optString("workAddressPostalCode");
            aVar.ceP = jSONObject.optString("homeFaxNumber");
            aVar.ceQ = jSONObject.optString("homePhoneNumber");
            aVar.ceR = jSONObject.optString("homeAddressCountry");
            aVar.ceS = jSONObject.optString("homeAddressState");
            aVar.ceT = jSONObject.optString("homeAddressCity");
            aVar.ceU = jSONObject.optString("homeAddressStreet");
            aVar.ceV = jSONObject.optString("homeAddressPostalCode");
        }
        return aVar;
    }

    public String getDisplayName() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.cew)) {
            sb.append(this.cew);
        }
        if (!TextUtils.isEmpty(this.cex)) {
            sb.append(this.cex);
        }
        if (!TextUtils.isEmpty(this.cey)) {
            sb.append(this.cey);
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
        contentValues.put("data1", this.cez);
        return contentValues;
    }

    public ContentValues aeL() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.ceQ);
        return contentValues;
    }

    public ContentValues aeM() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", this.ceI);
        return contentValues;
    }

    public ContentValues aeN() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 10);
        contentValues.put("data1", this.ceJ);
        return contentValues;
    }

    public ContentValues aeO() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 5);
        contentValues.put("data1", this.ceP);
        return contentValues;
    }

    public ContentValues aeP() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 4);
        contentValues.put("data1", this.ceH);
        return contentValues;
    }

    public ContentValues aeQ() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/im");
        contentValues.put("data5", (Integer) (-1));
        contentValues.put("data6", AppRuntime.getAppContext().getString(a.h.aiapps_cantact_wechat_lable));
        contentValues.put("data1", this.ceA);
        return contentValues;
    }

    public ContentValues aeR() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/organization");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.ceG);
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
        contentValues.put("data9", this.ceF);
        return contentValues;
    }

    public ContentValues aeU() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", aeX());
        contentValues.put("data9", this.ceO);
        return contentValues;
    }

    public ContentValues aeV() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", aeW());
        contentValues.put("data9", this.ceV);
        return contentValues;
    }

    public String aeW() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.ceR)) {
            sb.append(this.ceR);
        }
        if (!TextUtils.isEmpty(this.ceS)) {
            sb.append(this.ceS);
        }
        if (!TextUtils.isEmpty(this.ceT)) {
            sb.append(this.ceT);
        }
        if (!TextUtils.isEmpty(this.ceU)) {
            sb.append(this.ceU);
        }
        if (!TextUtils.isEmpty(this.ceV)) {
            sb.append(" ").append(this.ceV);
        }
        return sb.toString();
    }

    public String aeX() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.ceK)) {
            sb.append(this.ceK);
        }
        if (!TextUtils.isEmpty(this.ceL)) {
            sb.append(this.ceL);
        }
        if (!TextUtils.isEmpty(this.ceM)) {
            sb.append(this.ceM);
        }
        if (!TextUtils.isEmpty(this.ceN)) {
            sb.append(this.ceN);
        }
        if (!TextUtils.isEmpty(this.ceO)) {
            sb.append(" ").append(this.ceO);
        }
        return sb.toString();
    }

    public String aeY() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.ceB)) {
            sb.append(this.ceB);
        }
        if (!TextUtils.isEmpty(this.ceC)) {
            sb.append(this.ceC);
        }
        if (!TextUtils.isEmpty(this.ceD)) {
            sb.append(this.ceD);
        }
        if (!TextUtils.isEmpty(this.ceE)) {
            sb.append(this.ceE);
        }
        if (!TextUtils.isEmpty(this.ceF)) {
            sb.append(" ").append(this.ceF);
        }
        return sb.toString();
    }
}
