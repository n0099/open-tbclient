package com.baidu.swan.apps.j;

import android.content.ContentValues;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public String cgA;
    public String cgB;
    public String cgC;
    public String cgD;
    public String cgE;
    public String cgF;
    public String cgG;
    public String cgH;
    public String cgI;
    public String cgJ;
    public String cgK;
    public String cgL;
    public String cgM;
    public String cgN;
    public String cgO;
    public String cgP;
    public String cgQ;
    public String cgR;
    public String cgS;
    public String cgT;
    public String cgU;
    public String cgV;
    public String cgW;
    public String cgw;
    public String cgx;
    public String cgy;
    public String cgz;
    public String email;
    public String nickName;
    public String remark;
    public String title;
    public String url;

    public boolean isValid() {
        return !TextUtils.isEmpty(this.cgz);
    }

    public static a aS(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.cgw = jSONObject.optString("photoFilePath");
            aVar.nickName = jSONObject.optString("nickName");
            aVar.cgx = jSONObject.optString("lastName");
            aVar.cgy = jSONObject.optString("middleName");
            aVar.cgz = jSONObject.optString("firstName");
            aVar.remark = jSONObject.optString("remark");
            aVar.cgA = jSONObject.optString("mobilePhoneNumber");
            aVar.cgB = jSONObject.optString("weChatNumber");
            aVar.cgC = jSONObject.optString("addressCountry");
            aVar.cgD = jSONObject.optString("addressState");
            aVar.cgE = jSONObject.optString("addressCity");
            aVar.cgF = jSONObject.optString("addressStreet");
            aVar.cgG = jSONObject.optString("addressPostalCode");
            aVar.cgH = jSONObject.optString("organization");
            aVar.title = jSONObject.optString("title");
            aVar.cgI = jSONObject.optString("workFaxNumber");
            aVar.cgJ = jSONObject.optString("workPhoneNumber");
            aVar.cgK = jSONObject.optString("hostNumber");
            aVar.email = jSONObject.optString(NotificationCompat.CATEGORY_EMAIL);
            aVar.url = jSONObject.optString("url");
            aVar.cgL = jSONObject.optString("workAddressCountry");
            aVar.cgM = jSONObject.optString("workAddressState");
            aVar.cgN = jSONObject.optString("workAddressCity");
            aVar.cgO = jSONObject.optString("workAddressStreet");
            aVar.cgP = jSONObject.optString("workAddressPostalCode");
            aVar.cgQ = jSONObject.optString("homeFaxNumber");
            aVar.cgR = jSONObject.optString("homePhoneNumber");
            aVar.cgS = jSONObject.optString("homeAddressCountry");
            aVar.cgT = jSONObject.optString("homeAddressState");
            aVar.cgU = jSONObject.optString("homeAddressCity");
            aVar.cgV = jSONObject.optString("homeAddressStreet");
            aVar.cgW = jSONObject.optString("homeAddressPostalCode");
        }
        return aVar;
    }

    public String getDisplayName() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.cgx)) {
            sb.append(this.cgx);
        }
        if (!TextUtils.isEmpty(this.cgy)) {
            sb.append(this.cgy);
        }
        if (!TextUtils.isEmpty(this.cgz)) {
            sb.append(this.cgz);
        }
        return sb.toString();
    }

    public ContentValues afs() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/nickname");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.nickName);
        return contentValues;
    }

    public ContentValues aft() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/note");
        contentValues.put("data1", this.remark);
        return contentValues;
    }

    public ContentValues afu() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", this.cgA);
        return contentValues;
    }

    public ContentValues afv() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.cgR);
        return contentValues;
    }

    public ContentValues afw() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", this.cgJ);
        return contentValues;
    }

    public ContentValues afx() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 10);
        contentValues.put("data1", this.cgK);
        return contentValues;
    }

    public ContentValues afy() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 5);
        contentValues.put("data1", this.cgQ);
        return contentValues;
    }

    public ContentValues afz() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 4);
        contentValues.put("data1", this.cgI);
        return contentValues;
    }

    public ContentValues afA() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/im");
        contentValues.put("data5", (Integer) (-1));
        contentValues.put("data6", AppRuntime.getAppContext().getString(a.h.aiapps_cantact_wechat_lable));
        contentValues.put("data1", this.cgB);
        return contentValues;
    }

    public ContentValues afB() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/organization");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.cgH);
        contentValues.put("data4", this.title);
        return contentValues;
    }

    public ContentValues afC() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/website");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.url);
        return contentValues;
    }

    public ContentValues afD() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", afI());
        contentValues.put("data9", this.cgG);
        return contentValues;
    }

    public ContentValues afE() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", afH());
        contentValues.put("data9", this.cgP);
        return contentValues;
    }

    public ContentValues afF() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", afG());
        contentValues.put("data9", this.cgW);
        return contentValues;
    }

    public String afG() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.cgS)) {
            sb.append(this.cgS);
        }
        if (!TextUtils.isEmpty(this.cgT)) {
            sb.append(this.cgT);
        }
        if (!TextUtils.isEmpty(this.cgU)) {
            sb.append(this.cgU);
        }
        if (!TextUtils.isEmpty(this.cgV)) {
            sb.append(this.cgV);
        }
        if (!TextUtils.isEmpty(this.cgW)) {
            sb.append(" ").append(this.cgW);
        }
        return sb.toString();
    }

    public String afH() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.cgL)) {
            sb.append(this.cgL);
        }
        if (!TextUtils.isEmpty(this.cgM)) {
            sb.append(this.cgM);
        }
        if (!TextUtils.isEmpty(this.cgN)) {
            sb.append(this.cgN);
        }
        if (!TextUtils.isEmpty(this.cgO)) {
            sb.append(this.cgO);
        }
        if (!TextUtils.isEmpty(this.cgP)) {
            sb.append(" ").append(this.cgP);
        }
        return sb.toString();
    }

    public String afI() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.cgC)) {
            sb.append(this.cgC);
        }
        if (!TextUtils.isEmpty(this.cgD)) {
            sb.append(this.cgD);
        }
        if (!TextUtils.isEmpty(this.cgE)) {
            sb.append(this.cgE);
        }
        if (!TextUtils.isEmpty(this.cgF)) {
            sb.append(this.cgF);
        }
        if (!TextUtils.isEmpty(this.cgG)) {
            sb.append(" ").append(this.cgG);
        }
        return sb.toString();
    }
}
