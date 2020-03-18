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
    public String bme;
    public String bmf;
    public String bmg;
    public String bmh;
    public String bmi;
    public String bmj;
    public String bmk;
    public String bml;
    public String bmm;
    public String bmn;
    public String bmo;
    public String bmq;
    public String bmr;
    public String email;
    public String nickName;
    public String remark;
    public String title;
    public String url;

    public boolean isValid() {
        return !TextUtils.isEmpty(this.blT);
    }

    public static a ag(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.blQ = jSONObject.optString("photoFilePath");
            aVar.nickName = jSONObject.optString("nickName");
            aVar.blR = jSONObject.optString("lastName");
            aVar.blS = jSONObject.optString("middleName");
            aVar.blT = jSONObject.optString("firstName");
            aVar.remark = jSONObject.optString("remark");
            aVar.blU = jSONObject.optString("mobilePhoneNumber");
            aVar.blV = jSONObject.optString("weChatNumber");
            aVar.blW = jSONObject.optString("addressCountry");
            aVar.blX = jSONObject.optString("addressState");
            aVar.blY = jSONObject.optString("addressCity");
            aVar.blZ = jSONObject.optString("addressStreet");
            aVar.bma = jSONObject.optString("addressPostalCode");
            aVar.bmb = jSONObject.optString("organization");
            aVar.title = jSONObject.optString("title");
            aVar.bmc = jSONObject.optString("workFaxNumber");
            aVar.bmd = jSONObject.optString("workPhoneNumber");
            aVar.bme = jSONObject.optString("hostNumber");
            aVar.email = jSONObject.optString(NotificationCompat.CATEGORY_EMAIL);
            aVar.url = jSONObject.optString("url");
            aVar.bmf = jSONObject.optString("workAddressCountry");
            aVar.bmg = jSONObject.optString("workAddressState");
            aVar.bmh = jSONObject.optString("workAddressCity");
            aVar.bmi = jSONObject.optString("workAddressStreet");
            aVar.bmj = jSONObject.optString("workAddressPostalCode");
            aVar.bmk = jSONObject.optString("homeFaxNumber");
            aVar.bml = jSONObject.optString("homePhoneNumber");
            aVar.bmm = jSONObject.optString("homeAddressCountry");
            aVar.bmn = jSONObject.optString("homeAddressState");
            aVar.bmo = jSONObject.optString("homeAddressCity");
            aVar.bmq = jSONObject.optString("homeAddressStreet");
            aVar.bmr = jSONObject.optString("homeAddressPostalCode");
        }
        return aVar;
    }

    public String getDisplayName() {
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
        return sb.toString();
    }

    public ContentValues My() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/nickname");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.nickName);
        return contentValues;
    }

    public ContentValues Mz() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/note");
        contentValues.put("data1", this.remark);
        return contentValues;
    }

    public ContentValues MA() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", this.blU);
        return contentValues;
    }

    public ContentValues MB() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.bml);
        return contentValues;
    }

    public ContentValues MC() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", this.bmd);
        return contentValues;
    }

    public ContentValues MD() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 10);
        contentValues.put("data1", this.bme);
        return contentValues;
    }

    public ContentValues ME() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 5);
        contentValues.put("data1", this.bmk);
        return contentValues;
    }

    public ContentValues MF() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 4);
        contentValues.put("data1", this.bmc);
        return contentValues;
    }

    public ContentValues MG() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/im");
        contentValues.put("data5", (Integer) (-1));
        contentValues.put("data6", AppRuntime.getAppContext().getString(a.h.aiapps_cantact_wechat_lable));
        contentValues.put("data1", this.blV);
        return contentValues;
    }

    public ContentValues MH() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/organization");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.bmb);
        contentValues.put("data4", this.title);
        return contentValues;
    }

    public ContentValues MI() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/website");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.url);
        return contentValues;
    }

    public ContentValues MJ() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", MO());
        contentValues.put("data9", this.bma);
        return contentValues;
    }

    public ContentValues MK() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", MN());
        contentValues.put("data9", this.bmj);
        return contentValues;
    }

    public ContentValues ML() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", MM());
        contentValues.put("data9", this.bmr);
        return contentValues;
    }

    public String MM() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.bmm)) {
            sb.append(this.bmm);
        }
        if (!TextUtils.isEmpty(this.bmn)) {
            sb.append(this.bmn);
        }
        if (!TextUtils.isEmpty(this.bmo)) {
            sb.append(this.bmo);
        }
        if (!TextUtils.isEmpty(this.bmq)) {
            sb.append(this.bmq);
        }
        if (!TextUtils.isEmpty(this.bmr)) {
            sb.append(HanziToPinyin.Token.SEPARATOR).append(this.bmr);
        }
        return sb.toString();
    }

    public String MN() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.bmf)) {
            sb.append(this.bmf);
        }
        if (!TextUtils.isEmpty(this.bmg)) {
            sb.append(this.bmg);
        }
        if (!TextUtils.isEmpty(this.bmh)) {
            sb.append(this.bmh);
        }
        if (!TextUtils.isEmpty(this.bmi)) {
            sb.append(this.bmi);
        }
        if (!TextUtils.isEmpty(this.bmj)) {
            sb.append(HanziToPinyin.Token.SEPARATOR).append(this.bmj);
        }
        return sb.toString();
    }

    public String MO() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.blW)) {
            sb.append(this.blW);
        }
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
            sb.append(HanziToPinyin.Token.SEPARATOR).append(this.bma);
        }
        return sb.toString();
    }
}
