package com.baidu.swan.apps.i;

import android.content.ContentValues;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public String bgA;
    public String bgB;
    public String bgC;
    public String bgD;
    public String bgE;
    public String bgF;
    public String bgG;
    public String bgH;
    public String bgI;
    public String bgJ;
    public String bgK;
    public String bgL;
    public String bgM;
    public String bgN;
    public String bgO;
    public String bgP;
    public String bgQ;
    public String bgR;
    public String bgS;
    public String bgT;
    public String bgU;
    public String bgV;
    public String bgW;
    public String bgX;
    public String bgY;
    public String bgZ;
    public String bha;
    public String email;
    public String nickName;
    public String remark;
    public String title;
    public String url;

    public boolean isValid() {
        return !TextUtils.isEmpty(this.bgD);
    }

    public static a ag(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.bgA = jSONObject.optString("photoFilePath");
            aVar.nickName = jSONObject.optString("nickName");
            aVar.bgB = jSONObject.optString("lastName");
            aVar.bgC = jSONObject.optString("middleName");
            aVar.bgD = jSONObject.optString("firstName");
            aVar.remark = jSONObject.optString("remark");
            aVar.bgE = jSONObject.optString("mobilePhoneNumber");
            aVar.bgF = jSONObject.optString("weChatNumber");
            aVar.bgG = jSONObject.optString("addressCountry");
            aVar.bgH = jSONObject.optString("addressState");
            aVar.bgI = jSONObject.optString("addressCity");
            aVar.bgJ = jSONObject.optString("addressStreet");
            aVar.bgK = jSONObject.optString("addressPostalCode");
            aVar.bgL = jSONObject.optString("organization");
            aVar.title = jSONObject.optString("title");
            aVar.bgM = jSONObject.optString("workFaxNumber");
            aVar.bgN = jSONObject.optString("workPhoneNumber");
            aVar.bgO = jSONObject.optString("hostNumber");
            aVar.email = jSONObject.optString(NotificationCompat.CATEGORY_EMAIL);
            aVar.url = jSONObject.optString("url");
            aVar.bgP = jSONObject.optString("workAddressCountry");
            aVar.bgQ = jSONObject.optString("workAddressState");
            aVar.bgR = jSONObject.optString("workAddressCity");
            aVar.bgS = jSONObject.optString("workAddressStreet");
            aVar.bgT = jSONObject.optString("workAddressPostalCode");
            aVar.bgU = jSONObject.optString("homeFaxNumber");
            aVar.bgV = jSONObject.optString("homePhoneNumber");
            aVar.bgW = jSONObject.optString("homeAddressCountry");
            aVar.bgX = jSONObject.optString("homeAddressState");
            aVar.bgY = jSONObject.optString("homeAddressCity");
            aVar.bgZ = jSONObject.optString("homeAddressStreet");
            aVar.bha = jSONObject.optString("homeAddressPostalCode");
        }
        return aVar;
    }

    public String getDisplayName() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.bgB)) {
            sb.append(this.bgB);
        }
        if (!TextUtils.isEmpty(this.bgC)) {
            sb.append(this.bgC);
        }
        if (!TextUtils.isEmpty(this.bgD)) {
            sb.append(this.bgD);
        }
        return sb.toString();
    }

    public ContentValues JI() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/nickname");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.nickName);
        return contentValues;
    }

    public ContentValues JJ() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/note");
        contentValues.put("data1", this.remark);
        return contentValues;
    }

    public ContentValues JK() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", this.bgE);
        return contentValues;
    }

    public ContentValues JL() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.bgV);
        return contentValues;
    }

    public ContentValues JM() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", this.bgN);
        return contentValues;
    }

    public ContentValues JN() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 10);
        contentValues.put("data1", this.bgO);
        return contentValues;
    }

    public ContentValues JO() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 5);
        contentValues.put("data1", this.bgU);
        return contentValues;
    }

    public ContentValues JP() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 4);
        contentValues.put("data1", this.bgM);
        return contentValues;
    }

    public ContentValues JQ() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/im");
        contentValues.put("data5", (Integer) (-1));
        contentValues.put("data6", AppRuntime.getAppContext().getString(a.h.aiapps_cantact_wechat_lable));
        contentValues.put("data1", this.bgF);
        return contentValues;
    }

    public ContentValues JR() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/organization");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.bgL);
        contentValues.put("data4", this.title);
        return contentValues;
    }

    public ContentValues JS() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/website");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.url);
        return contentValues;
    }

    public ContentValues JT() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", JY());
        contentValues.put("data9", this.bgK);
        return contentValues;
    }

    public ContentValues JU() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", JX());
        contentValues.put("data9", this.bgT);
        return contentValues;
    }

    public ContentValues JV() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", JW());
        contentValues.put("data9", this.bha);
        return contentValues;
    }

    public String JW() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.bgW)) {
            sb.append(this.bgW);
        }
        if (!TextUtils.isEmpty(this.bgX)) {
            sb.append(this.bgX);
        }
        if (!TextUtils.isEmpty(this.bgY)) {
            sb.append(this.bgY);
        }
        if (!TextUtils.isEmpty(this.bgZ)) {
            sb.append(this.bgZ);
        }
        if (!TextUtils.isEmpty(this.bha)) {
            sb.append(HanziToPinyin.Token.SEPARATOR).append(this.bha);
        }
        return sb.toString();
    }

    public String JX() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.bgP)) {
            sb.append(this.bgP);
        }
        if (!TextUtils.isEmpty(this.bgQ)) {
            sb.append(this.bgQ);
        }
        if (!TextUtils.isEmpty(this.bgR)) {
            sb.append(this.bgR);
        }
        if (!TextUtils.isEmpty(this.bgS)) {
            sb.append(this.bgS);
        }
        if (!TextUtils.isEmpty(this.bgT)) {
            sb.append(HanziToPinyin.Token.SEPARATOR).append(this.bgT);
        }
        return sb.toString();
    }

    public String JY() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.bgG)) {
            sb.append(this.bgG);
        }
        if (!TextUtils.isEmpty(this.bgH)) {
            sb.append(this.bgH);
        }
        if (!TextUtils.isEmpty(this.bgI)) {
            sb.append(this.bgI);
        }
        if (!TextUtils.isEmpty(this.bgJ)) {
            sb.append(this.bgJ);
        }
        if (!TextUtils.isEmpty(this.bgK)) {
            sb.append(HanziToPinyin.Token.SEPARATOR).append(this.bgK);
        }
        return sb.toString();
    }
}
