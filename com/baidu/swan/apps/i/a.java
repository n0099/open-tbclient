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
    public String bXO;
    public String bXP;
    public String bXQ;
    public String bXR;
    public String bXS;
    public String bXT;
    public String bXU;
    public String bXV;
    public String bXW;
    public String bXX;
    public String bXY;
    public String bXZ;
    public String bYa;
    public String bYb;
    public String bYc;
    public String bYd;
    public String bYe;
    public String bYf;
    public String bYg;
    public String bYh;
    public String bYi;
    public String bYj;
    public String bYk;
    public String bYl;
    public String bYm;
    public String bYn;
    public String bYo;
    public String email;
    public String nickName;
    public String remark;
    public String title;
    public String url;

    public boolean isValid() {
        return !TextUtils.isEmpty(this.bXR);
    }

    public static a aG(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.bXO = jSONObject.optString("photoFilePath");
            aVar.nickName = jSONObject.optString("nickName");
            aVar.bXP = jSONObject.optString("lastName");
            aVar.bXQ = jSONObject.optString("middleName");
            aVar.bXR = jSONObject.optString("firstName");
            aVar.remark = jSONObject.optString("remark");
            aVar.bXS = jSONObject.optString("mobilePhoneNumber");
            aVar.bXT = jSONObject.optString("weChatNumber");
            aVar.bXU = jSONObject.optString("addressCountry");
            aVar.bXV = jSONObject.optString("addressState");
            aVar.bXW = jSONObject.optString("addressCity");
            aVar.bXX = jSONObject.optString("addressStreet");
            aVar.bXY = jSONObject.optString("addressPostalCode");
            aVar.bXZ = jSONObject.optString("organization");
            aVar.title = jSONObject.optString("title");
            aVar.bYa = jSONObject.optString("workFaxNumber");
            aVar.bYb = jSONObject.optString("workPhoneNumber");
            aVar.bYc = jSONObject.optString("hostNumber");
            aVar.email = jSONObject.optString(NotificationCompat.CATEGORY_EMAIL);
            aVar.url = jSONObject.optString("url");
            aVar.bYd = jSONObject.optString("workAddressCountry");
            aVar.bYe = jSONObject.optString("workAddressState");
            aVar.bYf = jSONObject.optString("workAddressCity");
            aVar.bYg = jSONObject.optString("workAddressStreet");
            aVar.bYh = jSONObject.optString("workAddressPostalCode");
            aVar.bYi = jSONObject.optString("homeFaxNumber");
            aVar.bYj = jSONObject.optString("homePhoneNumber");
            aVar.bYk = jSONObject.optString("homeAddressCountry");
            aVar.bYl = jSONObject.optString("homeAddressState");
            aVar.bYm = jSONObject.optString("homeAddressCity");
            aVar.bYn = jSONObject.optString("homeAddressStreet");
            aVar.bYo = jSONObject.optString("homeAddressPostalCode");
        }
        return aVar;
    }

    public String getDisplayName() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.bXP)) {
            sb.append(this.bXP);
        }
        if (!TextUtils.isEmpty(this.bXQ)) {
            sb.append(this.bXQ);
        }
        if (!TextUtils.isEmpty(this.bXR)) {
            sb.append(this.bXR);
        }
        return sb.toString();
    }

    public ContentValues XW() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/nickname");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.nickName);
        return contentValues;
    }

    public ContentValues XX() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/note");
        contentValues.put("data1", this.remark);
        return contentValues;
    }

    public ContentValues XY() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", this.bXS);
        return contentValues;
    }

    public ContentValues XZ() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.bYj);
        return contentValues;
    }

    public ContentValues Ya() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", this.bYb);
        return contentValues;
    }

    public ContentValues Yb() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 10);
        contentValues.put("data1", this.bYc);
        return contentValues;
    }

    public ContentValues Yc() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 5);
        contentValues.put("data1", this.bYi);
        return contentValues;
    }

    public ContentValues Yd() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 4);
        contentValues.put("data1", this.bYa);
        return contentValues;
    }

    public ContentValues Ye() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/im");
        contentValues.put("data5", (Integer) (-1));
        contentValues.put("data6", AppRuntime.getAppContext().getString(a.h.aiapps_cantact_wechat_lable));
        contentValues.put("data1", this.bXT);
        return contentValues;
    }

    public ContentValues Yf() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/organization");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.bXZ);
        contentValues.put("data4", this.title);
        return contentValues;
    }

    public ContentValues Yg() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/website");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.url);
        return contentValues;
    }

    public ContentValues Yh() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", Ym());
        contentValues.put("data9", this.bXY);
        return contentValues;
    }

    public ContentValues Yi() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", Yl());
        contentValues.put("data9", this.bYh);
        return contentValues;
    }

    public ContentValues Yj() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", Yk());
        contentValues.put("data9", this.bYo);
        return contentValues;
    }

    public String Yk() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.bYk)) {
            sb.append(this.bYk);
        }
        if (!TextUtils.isEmpty(this.bYl)) {
            sb.append(this.bYl);
        }
        if (!TextUtils.isEmpty(this.bYm)) {
            sb.append(this.bYm);
        }
        if (!TextUtils.isEmpty(this.bYn)) {
            sb.append(this.bYn);
        }
        if (!TextUtils.isEmpty(this.bYo)) {
            sb.append(" ").append(this.bYo);
        }
        return sb.toString();
    }

    public String Yl() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.bYd)) {
            sb.append(this.bYd);
        }
        if (!TextUtils.isEmpty(this.bYe)) {
            sb.append(this.bYe);
        }
        if (!TextUtils.isEmpty(this.bYf)) {
            sb.append(this.bYf);
        }
        if (!TextUtils.isEmpty(this.bYg)) {
            sb.append(this.bYg);
        }
        if (!TextUtils.isEmpty(this.bYh)) {
            sb.append(" ").append(this.bYh);
        }
        return sb.toString();
    }

    public String Ym() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.bXU)) {
            sb.append(this.bXU);
        }
        if (!TextUtils.isEmpty(this.bXV)) {
            sb.append(this.bXV);
        }
        if (!TextUtils.isEmpty(this.bXW)) {
            sb.append(this.bXW);
        }
        if (!TextUtils.isEmpty(this.bXX)) {
            sb.append(this.bXX);
        }
        if (!TextUtils.isEmpty(this.bXY)) {
            sb.append(" ").append(this.bXY);
        }
        return sb.toString();
    }
}
