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
    public String cBA;
    public String cBB;
    public String cBC;
    public String cBD;
    public String cBE;
    public String cBF;
    public String cBG;
    public String cBH;
    public String cBI;
    public String cBJ;
    public String cBK;
    public String cBL;
    public String cBM;
    public String cBN;
    public String cBn;
    public String cBo;
    public String cBp;
    public String cBq;
    public String cBr;
    public String cBs;
    public String cBt;
    public String cBu;
    public String cBv;
    public String cBw;
    public String cBx;
    public String cBy;
    public String cBz;
    public String email;
    public String nickName;
    public String remark;
    public String title;
    public String url;

    public boolean isValid() {
        return !TextUtils.isEmpty(this.cBq);
    }

    public static a bc(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.cBn = jSONObject.optString("photoFilePath");
            aVar.nickName = jSONObject.optString("nickName");
            aVar.cBo = jSONObject.optString("lastName");
            aVar.cBp = jSONObject.optString("middleName");
            aVar.cBq = jSONObject.optString("firstName");
            aVar.remark = jSONObject.optString("remark");
            aVar.cBr = jSONObject.optString("mobilePhoneNumber");
            aVar.cBs = jSONObject.optString("weChatNumber");
            aVar.cBt = jSONObject.optString("addressCountry");
            aVar.cBu = jSONObject.optString("addressState");
            aVar.cBv = jSONObject.optString("addressCity");
            aVar.cBw = jSONObject.optString("addressStreet");
            aVar.cBx = jSONObject.optString("addressPostalCode");
            aVar.cBy = jSONObject.optString("organization");
            aVar.title = jSONObject.optString("title");
            aVar.cBz = jSONObject.optString("workFaxNumber");
            aVar.cBA = jSONObject.optString("workPhoneNumber");
            aVar.cBB = jSONObject.optString("hostNumber");
            aVar.email = jSONObject.optString(NotificationCompat.CATEGORY_EMAIL);
            aVar.url = jSONObject.optString("url");
            aVar.cBC = jSONObject.optString("workAddressCountry");
            aVar.cBD = jSONObject.optString("workAddressState");
            aVar.cBE = jSONObject.optString("workAddressCity");
            aVar.cBF = jSONObject.optString("workAddressStreet");
            aVar.cBG = jSONObject.optString("workAddressPostalCode");
            aVar.cBH = jSONObject.optString("homeFaxNumber");
            aVar.cBI = jSONObject.optString("homePhoneNumber");
            aVar.cBJ = jSONObject.optString("homeAddressCountry");
            aVar.cBK = jSONObject.optString("homeAddressState");
            aVar.cBL = jSONObject.optString("homeAddressCity");
            aVar.cBM = jSONObject.optString("homeAddressStreet");
            aVar.cBN = jSONObject.optString("homeAddressPostalCode");
        }
        return aVar;
    }

    public String getDisplayName() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.cBo)) {
            sb.append(this.cBo);
        }
        if (!TextUtils.isEmpty(this.cBp)) {
            sb.append(this.cBp);
        }
        if (!TextUtils.isEmpty(this.cBq)) {
            sb.append(this.cBq);
        }
        return sb.toString();
    }

    public ContentValues ajX() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/nickname");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.nickName);
        return contentValues;
    }

    public ContentValues ajY() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/note");
        contentValues.put("data1", this.remark);
        return contentValues;
    }

    public ContentValues ajZ() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", this.cBr);
        return contentValues;
    }

    public ContentValues aka() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.cBI);
        return contentValues;
    }

    public ContentValues akb() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", this.cBA);
        return contentValues;
    }

    public ContentValues akc() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 10);
        contentValues.put("data1", this.cBB);
        return contentValues;
    }

    public ContentValues akd() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 5);
        contentValues.put("data1", this.cBH);
        return contentValues;
    }

    public ContentValues ake() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 4);
        contentValues.put("data1", this.cBz);
        return contentValues;
    }

    public ContentValues akf() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/im");
        contentValues.put("data5", (Integer) (-1));
        contentValues.put("data6", AppRuntime.getAppContext().getString(a.h.aiapps_cantact_wechat_lable));
        contentValues.put("data1", this.cBs);
        return contentValues;
    }

    public ContentValues akg() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/organization");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.cBy);
        contentValues.put("data4", this.title);
        return contentValues;
    }

    public ContentValues akh() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/website");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.url);
        return contentValues;
    }

    public ContentValues aki() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", akn());
        contentValues.put("data9", this.cBx);
        return contentValues;
    }

    public ContentValues akj() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", akm());
        contentValues.put("data9", this.cBG);
        return contentValues;
    }

    public ContentValues akk() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", akl());
        contentValues.put("data9", this.cBN);
        return contentValues;
    }

    public String akl() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.cBJ)) {
            sb.append(this.cBJ);
        }
        if (!TextUtils.isEmpty(this.cBK)) {
            sb.append(this.cBK);
        }
        if (!TextUtils.isEmpty(this.cBL)) {
            sb.append(this.cBL);
        }
        if (!TextUtils.isEmpty(this.cBM)) {
            sb.append(this.cBM);
        }
        if (!TextUtils.isEmpty(this.cBN)) {
            sb.append(" ").append(this.cBN);
        }
        return sb.toString();
    }

    public String akm() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.cBC)) {
            sb.append(this.cBC);
        }
        if (!TextUtils.isEmpty(this.cBD)) {
            sb.append(this.cBD);
        }
        if (!TextUtils.isEmpty(this.cBE)) {
            sb.append(this.cBE);
        }
        if (!TextUtils.isEmpty(this.cBF)) {
            sb.append(this.cBF);
        }
        if (!TextUtils.isEmpty(this.cBG)) {
            sb.append(" ").append(this.cBG);
        }
        return sb.toString();
    }

    public String akn() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.cBt)) {
            sb.append(this.cBt);
        }
        if (!TextUtils.isEmpty(this.cBu)) {
            sb.append(this.cBu);
        }
        if (!TextUtils.isEmpty(this.cBv)) {
            sb.append(this.cBv);
        }
        if (!TextUtils.isEmpty(this.cBw)) {
            sb.append(this.cBw);
        }
        if (!TextUtils.isEmpty(this.cBx)) {
            sb.append(" ").append(this.cBx);
        }
        return sb.toString();
    }
}
