package com.baidu.swan.apps.i;

import android.content.ContentValues;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public String blD;
    public String blE;
    public String blF;
    public String blG;
    public String blH;
    public String blI;
    public String blJ;
    public String blK;
    public String blL;
    public String blM;
    public String blN;
    public String blO;
    public String blP;
    public String blQ;
    public String blR;
    public String blS;
    public String blT;
    public String blU;
    public String blV;
    public String blW;
    public String blX;
    public String blY;
    public String blZ;
    public String bma;
    public String bmb;
    public String bmc;
    public String bmd;
    public String email;
    public String nickName;
    public String remark;
    public String title;
    public String url;

    public boolean isValid() {
        return !TextUtils.isEmpty(this.blG);
    }

    public static a ag(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.blD = jSONObject.optString("photoFilePath");
            aVar.nickName = jSONObject.optString("nickName");
            aVar.blE = jSONObject.optString("lastName");
            aVar.blF = jSONObject.optString("middleName");
            aVar.blG = jSONObject.optString("firstName");
            aVar.remark = jSONObject.optString("remark");
            aVar.blH = jSONObject.optString("mobilePhoneNumber");
            aVar.blI = jSONObject.optString("weChatNumber");
            aVar.blJ = jSONObject.optString("addressCountry");
            aVar.blK = jSONObject.optString("addressState");
            aVar.blL = jSONObject.optString("addressCity");
            aVar.blM = jSONObject.optString("addressStreet");
            aVar.blN = jSONObject.optString("addressPostalCode");
            aVar.blO = jSONObject.optString("organization");
            aVar.title = jSONObject.optString("title");
            aVar.blP = jSONObject.optString("workFaxNumber");
            aVar.blQ = jSONObject.optString("workPhoneNumber");
            aVar.blR = jSONObject.optString("hostNumber");
            aVar.email = jSONObject.optString(NotificationCompat.CATEGORY_EMAIL);
            aVar.url = jSONObject.optString("url");
            aVar.blS = jSONObject.optString("workAddressCountry");
            aVar.blT = jSONObject.optString("workAddressState");
            aVar.blU = jSONObject.optString("workAddressCity");
            aVar.blV = jSONObject.optString("workAddressStreet");
            aVar.blW = jSONObject.optString("workAddressPostalCode");
            aVar.blX = jSONObject.optString("homeFaxNumber");
            aVar.blY = jSONObject.optString("homePhoneNumber");
            aVar.blZ = jSONObject.optString("homeAddressCountry");
            aVar.bma = jSONObject.optString("homeAddressState");
            aVar.bmb = jSONObject.optString("homeAddressCity");
            aVar.bmc = jSONObject.optString("homeAddressStreet");
            aVar.bmd = jSONObject.optString("homeAddressPostalCode");
        }
        return aVar;
    }

    public String getDisplayName() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.blE)) {
            sb.append(this.blE);
        }
        if (!TextUtils.isEmpty(this.blF)) {
            sb.append(this.blF);
        }
        if (!TextUtils.isEmpty(this.blG)) {
            sb.append(this.blG);
        }
        return sb.toString();
    }

    public ContentValues Mv() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/nickname");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.nickName);
        return contentValues;
    }

    public ContentValues Mw() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/note");
        contentValues.put("data1", this.remark);
        return contentValues;
    }

    public ContentValues Mx() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", this.blH);
        return contentValues;
    }

    public ContentValues My() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.blY);
        return contentValues;
    }

    public ContentValues Mz() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", this.blQ);
        return contentValues;
    }

    public ContentValues MA() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 10);
        contentValues.put("data1", this.blR);
        return contentValues;
    }

    public ContentValues MB() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 5);
        contentValues.put("data1", this.blX);
        return contentValues;
    }

    public ContentValues MC() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 4);
        contentValues.put("data1", this.blP);
        return contentValues;
    }

    public ContentValues MD() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/im");
        contentValues.put("data5", (Integer) (-1));
        contentValues.put("data6", AppRuntime.getAppContext().getString(a.h.aiapps_cantact_wechat_lable));
        contentValues.put("data1", this.blI);
        return contentValues;
    }

    public ContentValues ME() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/organization");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.blO);
        contentValues.put("data4", this.title);
        return contentValues;
    }

    public ContentValues MF() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/website");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.url);
        return contentValues;
    }

    public ContentValues MG() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", ML());
        contentValues.put("data9", this.blN);
        return contentValues;
    }

    public ContentValues MH() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", MK());
        contentValues.put("data9", this.blW);
        return contentValues;
    }

    public ContentValues MI() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", MJ());
        contentValues.put("data9", this.bmd);
        return contentValues;
    }

    public String MJ() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.blZ)) {
            sb.append(this.blZ);
        }
        if (!TextUtils.isEmpty(this.bma)) {
            sb.append(this.bma);
        }
        if (!TextUtils.isEmpty(this.bmb)) {
            sb.append(this.bmb);
        }
        if (!TextUtils.isEmpty(this.bmc)) {
            sb.append(this.bmc);
        }
        if (!TextUtils.isEmpty(this.bmd)) {
            sb.append(HanziToPinyin.Token.SEPARATOR).append(this.bmd);
        }
        return sb.toString();
    }

    public String MK() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.blS)) {
            sb.append(this.blS);
        }
        if (!TextUtils.isEmpty(this.blT)) {
            sb.append(this.blT);
        }
        if (!TextUtils.isEmpty(this.blU)) {
            sb.append(this.blU);
        }
        if (!TextUtils.isEmpty(this.blV)) {
            sb.append(this.blV);
        }
        if (!TextUtils.isEmpty(this.blW)) {
            sb.append(HanziToPinyin.Token.SEPARATOR).append(this.blW);
        }
        return sb.toString();
    }

    public String ML() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.blJ)) {
            sb.append(this.blJ);
        }
        if (!TextUtils.isEmpty(this.blK)) {
            sb.append(this.blK);
        }
        if (!TextUtils.isEmpty(this.blL)) {
            sb.append(this.blL);
        }
        if (!TextUtils.isEmpty(this.blM)) {
            sb.append(this.blM);
        }
        if (!TextUtils.isEmpty(this.blN)) {
            sb.append(HanziToPinyin.Token.SEPARATOR).append(this.blN);
        }
        return sb.toString();
    }
}
