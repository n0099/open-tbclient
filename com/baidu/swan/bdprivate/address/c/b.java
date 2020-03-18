package com.baidu.swan.bdprivate.address.c;

import android.text.TextUtils;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.tbadk.core.util.TbEnum;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public d ccA;
    public d ccB;
    public String ccC;
    public String ccD;
    public boolean ccE;
    public String ccx;
    public String ccy;
    public d ccz;
    public String id;
    public String userName;

    public static b bc(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        bVar.id = jSONObject.optString("id");
        bVar.userName = jSONObject.optString("name");
        bVar.ccx = jSONObject.optString("phone");
        bVar.ccy = jSONObject.optString("phone_cipher");
        JSONObject optJSONObject = jSONObject.optJSONObject("l1");
        if (optJSONObject != null) {
            bVar.ccz = d.bd(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("l2");
        if (optJSONObject2 != null) {
            bVar.ccA = d.bd(optJSONObject2);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("l3");
        if (optJSONObject3 != null) {
            bVar.ccB = d.bd(optJSONObject3);
        }
        bVar.ccC = jSONObject.optString("street");
        bVar.ccD = jSONObject.optString("zipcode");
        bVar.ccE = TextUtils.equals(jSONObject.optString("default"), "1");
        return bVar;
    }

    public static b t(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        b bVar = new b();
        if (map.containsKey("id")) {
            bVar.id = String.valueOf(map.get("id"));
        }
        if (map.containsKey("name")) {
            bVar.userName = String.valueOf(map.get("name"));
        }
        if (map.containsKey("phone")) {
            bVar.ccx = String.valueOf(map.get("phone"));
        }
        if (map.containsKey("street")) {
            bVar.ccC = String.valueOf(map.get("street"));
        }
        if (map.containsKey("zipcode")) {
            bVar.ccD = String.valueOf(map.get("zipcode"));
        }
        if (map.containsKey("l1")) {
            Object obj = map.get("l1");
            if (obj instanceof d) {
                bVar.ccz = (d) obj;
            }
        }
        if (map.containsKey("l2")) {
            Object obj2 = map.get("l2");
            if (obj2 instanceof d) {
                bVar.ccA = (d) obj2;
            }
        }
        if (map.containsKey("l3")) {
            Object obj3 = map.get("l3");
            if (obj3 instanceof d) {
                bVar.ccB = (d) obj3;
            }
        }
        return bVar;
    }

    public static Map<String, Boolean> b(b bVar) {
        HashMap hashMap = new HashMap(4);
        if (bVar != null) {
            hashMap.put("name", Boolean.valueOf(!TextUtils.isEmpty(bVar.userName)));
            hashMap.put("phone", Boolean.valueOf(!TextUtils.isEmpty(bVar.ccx)));
            hashMap.put("region", Boolean.valueOf(!TextUtils.isEmpty(bVar.ait())));
            hashMap.put("street", Boolean.valueOf(TextUtils.isEmpty(bVar.ccC) ? false : true));
        }
        return hashMap;
    }

    public static JSONObject c(b bVar) {
        if (bVar == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(bVar.id)) {
                jSONObject.put("id", bVar.id);
            }
            if (!TextUtils.isEmpty(bVar.userName)) {
                jSONObject.put("name", bVar.userName);
            }
            if (!TextUtils.isEmpty(bVar.ccx)) {
                jSONObject.put("phone", bVar.ccx);
            }
            if (!TextUtils.isEmpty(bVar.ccy)) {
                jSONObject.put("phone_cipher", bVar.ccy);
            }
            JSONObject a = d.a(bVar.ccz);
            if (a != null) {
                jSONObject.put("l1", a);
            }
            JSONObject a2 = d.a(bVar.ccA);
            if (a2 != null) {
                jSONObject.put("l2", a2);
            }
            JSONObject a3 = d.a(bVar.ccB);
            if (a3 != null) {
                jSONObject.put("l3", a3);
            }
            if (!TextUtils.isEmpty(bVar.ccC)) {
                jSONObject.put("street", bVar.ccC);
            }
            if (!TextUtils.isEmpty(bVar.ccD)) {
                jSONObject.put("zipcode", bVar.ccD);
            }
            jSONObject.put("default", bVar.ccE);
            return jSONObject;
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
                return null;
            }
            return null;
        }
    }

    public static JSONObject d(b bVar) {
        if (bVar == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(bVar.userName)) {
                jSONObject.put(TbEnum.SystemMessage.KEY_USER_NAME, bVar.userName);
            }
            if (!TextUtils.isEmpty(bVar.ccD)) {
                jSONObject.put("postalCode", bVar.ccD);
            }
            if (bVar.ccz != null && !TextUtils.isEmpty(bVar.ccz.name)) {
                jSONObject.put("provinceName", bVar.ccz.name);
            }
            if (bVar.ccA != null && !TextUtils.isEmpty(bVar.ccA.name)) {
                jSONObject.put("cityName", bVar.ccA.name);
            }
            if (bVar.ccB != null && !TextUtils.isEmpty(bVar.ccB.name)) {
                jSONObject.put("countyName", bVar.ccB.name);
            }
            if (bVar.ccB != null && !TextUtils.isEmpty(bVar.ccB.code)) {
                jSONObject.put("nationalCode", bVar.ccB.code);
            }
            if (!TextUtils.isEmpty(bVar.ccC)) {
                jSONObject.put("detailInfo", bVar.ccC);
            }
            if (!TextUtils.isEmpty(bVar.ccx)) {
                jSONObject.put("telNumber", bVar.ccx);
                return jSONObject;
            }
            return jSONObject;
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
                return jSONObject;
            }
            return jSONObject;
        }
    }

    public static List<a> e(b bVar) {
        if (bVar == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        a aVar = new a("收货人", bVar.userName, "姓名");
        aVar.type = "name";
        arrayList.add(aVar);
        a aVar2 = new a("联系电话", bVar.ccx, "手机号码或座机");
        aVar2.type = "phone";
        aVar2.ccw = true;
        arrayList.add(aVar2);
        a aVar3 = new a("所在地区", bVar.ait(), "地区选择");
        aVar3.type = "region";
        arrayList.add(aVar3);
        a aVar4 = new a("详细地址", bVar.ccC, "街道门牌信息");
        aVar4.type = "street";
        arrayList.add(aVar4);
        a aVar5 = new a("邮政编码", bVar.ccD, "邮政编码");
        aVar5.type = "zipcode";
        aVar5.ccw = true;
        arrayList.add(aVar5);
        return arrayList;
    }

    private String ait() {
        StringBuilder sb = new StringBuilder();
        if (this.ccz != null && !TextUtils.isEmpty(this.ccz.name)) {
            sb.append(this.ccz.name);
        }
        if (this.ccA != null && !TextUtils.isEmpty(this.ccA.name)) {
            sb.append(HanziToPinyin.Token.SEPARATOR + this.ccA.name);
        }
        if (this.ccB != null && !TextUtils.isEmpty(this.ccB.name)) {
            sb.append(HanziToPinyin.Token.SEPARATOR + this.ccB.name);
        }
        return sb.toString();
    }

    public String aiu() {
        StringBuilder sb = new StringBuilder();
        sb.append(ait());
        sb.append(HanziToPinyin.Token.SEPARATOR + this.ccC);
        return sb.toString();
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.userName) || TextUtils.isEmpty(this.ccx) || TextUtils.isEmpty(ait()) || TextUtils.isEmpty(this.ccC) || this.ccx.length() != 11 || !this.ccx.startsWith("1")) ? false : true;
    }

    public static boolean nd(String str) {
        if (!TextUtils.isEmpty(str) && str.length() == 11 && str.startsWith("1")) {
            return nf(str);
        }
        return false;
    }

    public void f(b bVar) {
        if (bVar != null) {
            if (!TextUtils.isEmpty(bVar.userName)) {
                this.userName = bVar.userName;
            }
            if (!TextUtils.isEmpty(bVar.ccx)) {
                this.ccx = bVar.ccx;
            }
            if (!TextUtils.isEmpty(bVar.ccy)) {
                this.ccy = bVar.ccy;
            }
            if (!TextUtils.isEmpty(bVar.ccC)) {
                this.ccC = bVar.ccC;
            }
            if (!TextUtils.isEmpty(bVar.ccD)) {
                this.ccD = bVar.ccD;
            }
            if (bVar.ccz != null && bVar.ccz.isValid()) {
                this.ccz = bVar.ccz;
            }
            if (bVar.ccA != null && bVar.ccA.isValid()) {
                this.ccA = bVar.ccA;
            }
            if (bVar.ccB != null && bVar.ccB.isValid()) {
                this.ccB = bVar.ccB;
            }
        }
    }

    public static boolean ne(String str) {
        return str.length() == 6 && nf(str);
    }

    public static boolean nf(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public void aiv() {
        if (nd(this.ccx)) {
            this.ccy = this.ccx.substring(0, 3) + "*****" + this.ccx.substring(8);
        }
    }
}
