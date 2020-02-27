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
    public String blB;
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
    public String email;
    public String nickName;
    public String remark;
    public String title;
    public String url;

    public boolean isValid() {
        return !TextUtils.isEmpty(this.blE);
    }

    public static a ag(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.blB = jSONObject.optString("photoFilePath");
            aVar.nickName = jSONObject.optString("nickName");
            aVar.blC = jSONObject.optString("lastName");
            aVar.blD = jSONObject.optString("middleName");
            aVar.blE = jSONObject.optString("firstName");
            aVar.remark = jSONObject.optString("remark");
            aVar.blF = jSONObject.optString("mobilePhoneNumber");
            aVar.blG = jSONObject.optString("weChatNumber");
            aVar.blH = jSONObject.optString("addressCountry");
            aVar.blI = jSONObject.optString("addressState");
            aVar.blJ = jSONObject.optString("addressCity");
            aVar.blK = jSONObject.optString("addressStreet");
            aVar.blL = jSONObject.optString("addressPostalCode");
            aVar.blM = jSONObject.optString("organization");
            aVar.title = jSONObject.optString("title");
            aVar.blN = jSONObject.optString("workFaxNumber");
            aVar.blO = jSONObject.optString("workPhoneNumber");
            aVar.blP = jSONObject.optString("hostNumber");
            aVar.email = jSONObject.optString(NotificationCompat.CATEGORY_EMAIL);
            aVar.url = jSONObject.optString("url");
            aVar.blQ = jSONObject.optString("workAddressCountry");
            aVar.blR = jSONObject.optString("workAddressState");
            aVar.blS = jSONObject.optString("workAddressCity");
            aVar.blT = jSONObject.optString("workAddressStreet");
            aVar.blU = jSONObject.optString("workAddressPostalCode");
            aVar.blV = jSONObject.optString("homeFaxNumber");
            aVar.blW = jSONObject.optString("homePhoneNumber");
            aVar.blX = jSONObject.optString("homeAddressCountry");
            aVar.blY = jSONObject.optString("homeAddressState");
            aVar.blZ = jSONObject.optString("homeAddressCity");
            aVar.bma = jSONObject.optString("homeAddressStreet");
            aVar.bmb = jSONObject.optString("homeAddressPostalCode");
        }
        return aVar;
    }

    public String getDisplayName() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.blC)) {
            sb.append(this.blC);
        }
        if (!TextUtils.isEmpty(this.blD)) {
            sb.append(this.blD);
        }
        if (!TextUtils.isEmpty(this.blE)) {
            sb.append(this.blE);
        }
        return sb.toString();
    }

    public ContentValues Mt() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/nickname");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.nickName);
        return contentValues;
    }

    public ContentValues Mu() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/note");
        contentValues.put("data1", this.remark);
        return contentValues;
    }

    public ContentValues Mv() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", this.blF);
        return contentValues;
    }

    public ContentValues Mw() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.blW);
        return contentValues;
    }

    public ContentValues Mx() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", this.blO);
        return contentValues;
    }

    public ContentValues My() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 10);
        contentValues.put("data1", this.blP);
        return contentValues;
    }

    public ContentValues Mz() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 5);
        contentValues.put("data1", this.blV);
        return contentValues;
    }

    public ContentValues MA() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 4);
        contentValues.put("data1", this.blN);
        return contentValues;
    }

    public ContentValues MB() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/im");
        contentValues.put("data5", (Integer) (-1));
        contentValues.put("data6", AppRuntime.getAppContext().getString(a.h.aiapps_cantact_wechat_lable));
        contentValues.put("data1", this.blG);
        return contentValues;
    }

    public ContentValues MC() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/organization");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.blM);
        contentValues.put("data4", this.title);
        return contentValues;
    }

    public ContentValues MD() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/website");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.url);
        return contentValues;
    }

    public ContentValues ME() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", MJ());
        contentValues.put("data9", this.blL);
        return contentValues;
    }

    public ContentValues MF() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", MI());
        contentValues.put("data9", this.blU);
        return contentValues;
    }

    public ContentValues MG() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", MH());
        contentValues.put("data9", this.bmb);
        return contentValues;
    }

    public String MH() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.blX)) {
            sb.append(this.blX);
        }
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
            sb.append(HanziToPinyin.Token.SEPARATOR).append(this.bmb);
        }
        return sb.toString();
    }

    public String MI() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.blQ)) {
            sb.append(this.blQ);
        }
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
            sb.append(HanziToPinyin.Token.SEPARATOR).append(this.blU);
        }
        return sb.toString();
    }

    public String MJ() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.blH)) {
            sb.append(this.blH);
        }
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
            sb.append(HanziToPinyin.Token.SEPARATOR).append(this.blL);
        }
        return sb.toString();
    }
}
