package com.baidu.swan.apps.i;

import android.content.ContentValues;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public String bTA;
    public String bTa;
    public String bTb;
    public String bTc;
    public String bTd;
    public String bTe;
    public String bTf;
    public String bTg;
    public String bTh;
    public String bTi;
    public String bTj;
    public String bTk;
    public String bTl;
    public String bTm;
    public String bTn;
    public String bTo;
    public String bTp;
    public String bTq;
    public String bTr;
    public String bTs;
    public String bTt;
    public String bTu;
    public String bTv;
    public String bTw;
    public String bTx;
    public String bTy;
    public String bTz;
    public String email;
    public String nickName;
    public String remark;
    public String title;
    public String url;

    public boolean isValid() {
        return !TextUtils.isEmpty(this.bTd);
    }

    public static a az(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.bTa = jSONObject.optString("photoFilePath");
            aVar.nickName = jSONObject.optString("nickName");
            aVar.bTb = jSONObject.optString("lastName");
            aVar.bTc = jSONObject.optString("middleName");
            aVar.bTd = jSONObject.optString("firstName");
            aVar.remark = jSONObject.optString("remark");
            aVar.bTe = jSONObject.optString("mobilePhoneNumber");
            aVar.bTf = jSONObject.optString("weChatNumber");
            aVar.bTg = jSONObject.optString("addressCountry");
            aVar.bTh = jSONObject.optString("addressState");
            aVar.bTi = jSONObject.optString("addressCity");
            aVar.bTj = jSONObject.optString("addressStreet");
            aVar.bTk = jSONObject.optString("addressPostalCode");
            aVar.bTl = jSONObject.optString("organization");
            aVar.title = jSONObject.optString("title");
            aVar.bTm = jSONObject.optString("workFaxNumber");
            aVar.bTn = jSONObject.optString("workPhoneNumber");
            aVar.bTo = jSONObject.optString("hostNumber");
            aVar.email = jSONObject.optString(NotificationCompat.CATEGORY_EMAIL);
            aVar.url = jSONObject.optString("url");
            aVar.bTp = jSONObject.optString("workAddressCountry");
            aVar.bTq = jSONObject.optString("workAddressState");
            aVar.bTr = jSONObject.optString("workAddressCity");
            aVar.bTs = jSONObject.optString("workAddressStreet");
            aVar.bTt = jSONObject.optString("workAddressPostalCode");
            aVar.bTu = jSONObject.optString("homeFaxNumber");
            aVar.bTv = jSONObject.optString("homePhoneNumber");
            aVar.bTw = jSONObject.optString("homeAddressCountry");
            aVar.bTx = jSONObject.optString("homeAddressState");
            aVar.bTy = jSONObject.optString("homeAddressCity");
            aVar.bTz = jSONObject.optString("homeAddressStreet");
            aVar.bTA = jSONObject.optString("homeAddressPostalCode");
        }
        return aVar;
    }

    public String getDisplayName() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.bTb)) {
            sb.append(this.bTb);
        }
        if (!TextUtils.isEmpty(this.bTc)) {
            sb.append(this.bTc);
        }
        if (!TextUtils.isEmpty(this.bTd)) {
            sb.append(this.bTd);
        }
        return sb.toString();
    }

    public ContentValues WQ() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/nickname");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.nickName);
        return contentValues;
    }

    public ContentValues WR() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/note");
        contentValues.put("data1", this.remark);
        return contentValues;
    }

    public ContentValues WS() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", this.bTe);
        return contentValues;
    }

    public ContentValues WT() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.bTv);
        return contentValues;
    }

    public ContentValues WU() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", this.bTn);
        return contentValues;
    }

    public ContentValues WV() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 10);
        contentValues.put("data1", this.bTo);
        return contentValues;
    }

    public ContentValues WW() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 5);
        contentValues.put("data1", this.bTu);
        return contentValues;
    }

    public ContentValues WX() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 4);
        contentValues.put("data1", this.bTm);
        return contentValues;
    }

    public ContentValues WY() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/im");
        contentValues.put("data5", (Integer) (-1));
        contentValues.put("data6", AppRuntime.getAppContext().getString(a.h.aiapps_cantact_wechat_lable));
        contentValues.put("data1", this.bTf);
        return contentValues;
    }

    public ContentValues WZ() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/organization");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.bTl);
        contentValues.put("data4", this.title);
        return contentValues;
    }

    public ContentValues Xa() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/website");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.url);
        return contentValues;
    }

    public ContentValues Xb() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", Xg());
        contentValues.put("data9", this.bTk);
        return contentValues;
    }

    public ContentValues Xc() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", Xf());
        contentValues.put("data9", this.bTt);
        return contentValues;
    }

    public ContentValues Xd() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", Xe());
        contentValues.put("data9", this.bTA);
        return contentValues;
    }

    public String Xe() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.bTw)) {
            sb.append(this.bTw);
        }
        if (!TextUtils.isEmpty(this.bTx)) {
            sb.append(this.bTx);
        }
        if (!TextUtils.isEmpty(this.bTy)) {
            sb.append(this.bTy);
        }
        if (!TextUtils.isEmpty(this.bTz)) {
            sb.append(this.bTz);
        }
        if (!TextUtils.isEmpty(this.bTA)) {
            sb.append(" ").append(this.bTA);
        }
        return sb.toString();
    }

    public String Xf() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.bTp)) {
            sb.append(this.bTp);
        }
        if (!TextUtils.isEmpty(this.bTq)) {
            sb.append(this.bTq);
        }
        if (!TextUtils.isEmpty(this.bTr)) {
            sb.append(this.bTr);
        }
        if (!TextUtils.isEmpty(this.bTs)) {
            sb.append(this.bTs);
        }
        if (!TextUtils.isEmpty(this.bTt)) {
            sb.append(" ").append(this.bTt);
        }
        return sb.toString();
    }

    public String Xg() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.bTg)) {
            sb.append(this.bTg);
        }
        if (!TextUtils.isEmpty(this.bTh)) {
            sb.append(this.bTh);
        }
        if (!TextUtils.isEmpty(this.bTi)) {
            sb.append(this.bTi);
        }
        if (!TextUtils.isEmpty(this.bTj)) {
            sb.append(this.bTj);
        }
        if (!TextUtils.isEmpty(this.bTk)) {
            sb.append(" ").append(this.bTk);
        }
        return sb.toString();
    }
}
