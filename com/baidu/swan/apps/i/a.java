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
    public String blC;
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
    public String email;
    public String nickName;
    public String remark;
    public String title;
    public String url;

    public boolean isValid() {
        return !TextUtils.isEmpty(this.blF);
    }

    public static a ag(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.blC = jSONObject.optString("photoFilePath");
            aVar.nickName = jSONObject.optString("nickName");
            aVar.blD = jSONObject.optString("lastName");
            aVar.blE = jSONObject.optString("middleName");
            aVar.blF = jSONObject.optString("firstName");
            aVar.remark = jSONObject.optString("remark");
            aVar.blG = jSONObject.optString("mobilePhoneNumber");
            aVar.blH = jSONObject.optString("weChatNumber");
            aVar.blI = jSONObject.optString("addressCountry");
            aVar.blJ = jSONObject.optString("addressState");
            aVar.blK = jSONObject.optString("addressCity");
            aVar.blL = jSONObject.optString("addressStreet");
            aVar.blM = jSONObject.optString("addressPostalCode");
            aVar.blN = jSONObject.optString("organization");
            aVar.title = jSONObject.optString("title");
            aVar.blO = jSONObject.optString("workFaxNumber");
            aVar.blP = jSONObject.optString("workPhoneNumber");
            aVar.blQ = jSONObject.optString("hostNumber");
            aVar.email = jSONObject.optString(NotificationCompat.CATEGORY_EMAIL);
            aVar.url = jSONObject.optString("url");
            aVar.blR = jSONObject.optString("workAddressCountry");
            aVar.blS = jSONObject.optString("workAddressState");
            aVar.blT = jSONObject.optString("workAddressCity");
            aVar.blU = jSONObject.optString("workAddressStreet");
            aVar.blV = jSONObject.optString("workAddressPostalCode");
            aVar.blW = jSONObject.optString("homeFaxNumber");
            aVar.blX = jSONObject.optString("homePhoneNumber");
            aVar.blY = jSONObject.optString("homeAddressCountry");
            aVar.blZ = jSONObject.optString("homeAddressState");
            aVar.bma = jSONObject.optString("homeAddressCity");
            aVar.bmb = jSONObject.optString("homeAddressStreet");
            aVar.bmc = jSONObject.optString("homeAddressPostalCode");
        }
        return aVar;
    }

    public String getDisplayName() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.blD)) {
            sb.append(this.blD);
        }
        if (!TextUtils.isEmpty(this.blE)) {
            sb.append(this.blE);
        }
        if (!TextUtils.isEmpty(this.blF)) {
            sb.append(this.blF);
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
        contentValues.put("data1", this.blG);
        return contentValues;
    }

    public ContentValues My() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.blX);
        return contentValues;
    }

    public ContentValues Mz() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", this.blP);
        return contentValues;
    }

    public ContentValues MA() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 10);
        contentValues.put("data1", this.blQ);
        return contentValues;
    }

    public ContentValues MB() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 5);
        contentValues.put("data1", this.blW);
        return contentValues;
    }

    public ContentValues MC() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 4);
        contentValues.put("data1", this.blO);
        return contentValues;
    }

    public ContentValues MD() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/im");
        contentValues.put("data5", (Integer) (-1));
        contentValues.put("data6", AppRuntime.getAppContext().getString(a.h.aiapps_cantact_wechat_lable));
        contentValues.put("data1", this.blH);
        return contentValues;
    }

    public ContentValues ME() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/organization");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.blN);
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
        contentValues.put("data9", this.blM);
        return contentValues;
    }

    public ContentValues MH() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", MK());
        contentValues.put("data9", this.blV);
        return contentValues;
    }

    public ContentValues MI() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", MJ());
        contentValues.put("data9", this.bmc);
        return contentValues;
    }

    public String MJ() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.blY)) {
            sb.append(this.blY);
        }
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
            sb.append(HanziToPinyin.Token.SEPARATOR).append(this.bmc);
        }
        return sb.toString();
    }

    public String MK() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.blR)) {
            sb.append(this.blR);
        }
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
            sb.append(HanziToPinyin.Token.SEPARATOR).append(this.blV);
        }
        return sb.toString();
    }

    public String ML() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.blI)) {
            sb.append(this.blI);
        }
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
            sb.append(HanziToPinyin.Token.SEPARATOR).append(this.blM);
        }
        return sb.toString();
    }
}
