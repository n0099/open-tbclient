package com.baidu.swan.apps.i;

import android.content.ContentValues;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public String anQ;
    public String anR;
    public String anS;
    public String anT;
    public String anU;
    public String anV;
    public String anW;
    public String anX;
    public String anY;
    public String anZ;
    public String aoa;
    public String aob;
    public String aoc;
    public String aod;
    public String aoe;
    public String aof;
    public String aog;
    public String aoh;
    public String aoi;
    public String aoj;
    public String aok;
    public String aol;
    public String aom;
    public String aon;
    public String aoo;
    public String aop;
    public String aoq;
    public String email;
    public String nickName;
    public String remark;
    public String title;
    public String url;

    public boolean isValid() {
        return !TextUtils.isEmpty(this.anT);
    }

    public static a u(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.anQ = jSONObject.optString("photoFilePath");
            aVar.nickName = jSONObject.optString("nickName");
            aVar.anR = jSONObject.optString("lastName");
            aVar.anS = jSONObject.optString("middleName");
            aVar.anT = jSONObject.optString("firstName");
            aVar.remark = jSONObject.optString("remark");
            aVar.anU = jSONObject.optString("mobilePhoneNumber");
            aVar.anV = jSONObject.optString("weChatNumber");
            aVar.anW = jSONObject.optString("addressCountry");
            aVar.anX = jSONObject.optString("addressState");
            aVar.anY = jSONObject.optString("addressCity");
            aVar.anZ = jSONObject.optString("addressStreet");
            aVar.aoa = jSONObject.optString("addressPostalCode");
            aVar.aob = jSONObject.optString("organization");
            aVar.title = jSONObject.optString("title");
            aVar.aoc = jSONObject.optString("workFaxNumber");
            aVar.aod = jSONObject.optString("workPhoneNumber");
            aVar.aoe = jSONObject.optString("hostNumber");
            aVar.email = jSONObject.optString("email");
            aVar.url = jSONObject.optString("url");
            aVar.aof = jSONObject.optString("workAddressCountry");
            aVar.aog = jSONObject.optString("workAddressState");
            aVar.aoh = jSONObject.optString("workAddressCity");
            aVar.aoi = jSONObject.optString("workAddressStreet");
            aVar.aoj = jSONObject.optString("workAddressPostalCode");
            aVar.aok = jSONObject.optString("homeFaxNumber");
            aVar.aol = jSONObject.optString("homePhoneNumber");
            aVar.aom = jSONObject.optString("homeAddressCountry");
            aVar.aon = jSONObject.optString("homeAddressState");
            aVar.aoo = jSONObject.optString("homeAddressCity");
            aVar.aop = jSONObject.optString("homeAddressStreet");
            aVar.aoq = jSONObject.optString("homeAddressPostalCode");
        }
        return aVar;
    }

    public String getDisplayName() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.anR)) {
            sb.append(this.anR);
        }
        if (!TextUtils.isEmpty(this.anS)) {
            sb.append(this.anS);
        }
        if (!TextUtils.isEmpty(this.anT)) {
            sb.append(this.anT);
        }
        return sb.toString();
    }

    public ContentValues xQ() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/nickname");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.nickName);
        return contentValues;
    }

    public ContentValues xR() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/note");
        contentValues.put("data1", this.remark);
        return contentValues;
    }

    public ContentValues xS() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", this.anU);
        return contentValues;
    }

    public ContentValues xT() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.aol);
        return contentValues;
    }

    public ContentValues xU() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", this.aod);
        return contentValues;
    }

    public ContentValues xV() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 10);
        contentValues.put("data1", this.aoe);
        return contentValues;
    }

    public ContentValues xW() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 5);
        contentValues.put("data1", this.aok);
        return contentValues;
    }

    public ContentValues xX() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 4);
        contentValues.put("data1", this.aoc);
        return contentValues;
    }

    public ContentValues xY() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/im");
        contentValues.put("data5", (Integer) (-1));
        contentValues.put("data6", AppRuntime.getAppContext().getString(a.h.aiapps_cantact_wechat_lable));
        contentValues.put("data1", this.anV);
        return contentValues;
    }

    public ContentValues xZ() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/organization");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.aob);
        contentValues.put("data4", this.title);
        return contentValues;
    }

    public ContentValues ya() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/website");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.url);
        return contentValues;
    }

    public ContentValues yb() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", yg());
        contentValues.put("data9", this.aoa);
        return contentValues;
    }

    public ContentValues yc() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", yf());
        contentValues.put("data9", this.aoj);
        return contentValues;
    }

    public ContentValues yd() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", ye());
        contentValues.put("data9", this.aoq);
        return contentValues;
    }

    public String ye() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.aom)) {
            sb.append(this.aom);
        }
        if (!TextUtils.isEmpty(this.aon)) {
            sb.append(this.aon);
        }
        if (!TextUtils.isEmpty(this.aoo)) {
            sb.append(this.aoo);
        }
        if (!TextUtils.isEmpty(this.aop)) {
            sb.append(this.aop);
        }
        if (!TextUtils.isEmpty(this.aoq)) {
            sb.append(" ").append(this.aoq);
        }
        return sb.toString();
    }

    public String yf() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.aof)) {
            sb.append(this.aof);
        }
        if (!TextUtils.isEmpty(this.aog)) {
            sb.append(this.aog);
        }
        if (!TextUtils.isEmpty(this.aoh)) {
            sb.append(this.aoh);
        }
        if (!TextUtils.isEmpty(this.aoi)) {
            sb.append(this.aoi);
        }
        if (!TextUtils.isEmpty(this.aoj)) {
            sb.append(" ").append(this.aoj);
        }
        return sb.toString();
    }

    public String yg() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.anW)) {
            sb.append(this.anW);
        }
        if (!TextUtils.isEmpty(this.anX)) {
            sb.append(this.anX);
        }
        if (!TextUtils.isEmpty(this.anY)) {
            sb.append(this.anY);
        }
        if (!TextUtils.isEmpty(this.anZ)) {
            sb.append(this.anZ);
        }
        if (!TextUtils.isEmpty(this.aoa)) {
            sb.append(" ").append(this.aoa);
        }
        return sb.toString();
    }
}
