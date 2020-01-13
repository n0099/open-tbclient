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
/* loaded from: classes10.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String bYf;
    public String bYg;
    public d bYh;
    public d bYi;
    public d bYj;
    public String bYk;
    public String bYl;
    public boolean bYm;
    public String id;
    public String userName;

    public static b bc(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        bVar.id = jSONObject.optString("id");
        bVar.userName = jSONObject.optString("name");
        bVar.bYf = jSONObject.optString("phone");
        bVar.bYg = jSONObject.optString("phone_cipher");
        JSONObject optJSONObject = jSONObject.optJSONObject("l1");
        if (optJSONObject != null) {
            bVar.bYh = d.bd(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("l2");
        if (optJSONObject2 != null) {
            bVar.bYi = d.bd(optJSONObject2);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("l3");
        if (optJSONObject3 != null) {
            bVar.bYj = d.bd(optJSONObject3);
        }
        bVar.bYk = jSONObject.optString("street");
        bVar.bYl = jSONObject.optString("zipcode");
        bVar.bYm = TextUtils.equals(jSONObject.optString("default"), "1");
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
            bVar.bYf = String.valueOf(map.get("phone"));
        }
        if (map.containsKey("street")) {
            bVar.bYk = String.valueOf(map.get("street"));
        }
        if (map.containsKey("zipcode")) {
            bVar.bYl = String.valueOf(map.get("zipcode"));
        }
        if (map.containsKey("l1")) {
            Object obj = map.get("l1");
            if (obj instanceof d) {
                bVar.bYh = (d) obj;
            }
        }
        if (map.containsKey("l2")) {
            Object obj2 = map.get("l2");
            if (obj2 instanceof d) {
                bVar.bYi = (d) obj2;
            }
        }
        if (map.containsKey("l3")) {
            Object obj3 = map.get("l3");
            if (obj3 instanceof d) {
                bVar.bYj = (d) obj3;
            }
        }
        return bVar;
    }

    public static Map<String, Boolean> b(b bVar) {
        HashMap hashMap = new HashMap(4);
        if (bVar != null) {
            hashMap.put("name", Boolean.valueOf(!TextUtils.isEmpty(bVar.userName)));
            hashMap.put("phone", Boolean.valueOf(!TextUtils.isEmpty(bVar.bYf)));
            hashMap.put("region", Boolean.valueOf(!TextUtils.isEmpty(bVar.aga())));
            hashMap.put("street", Boolean.valueOf(TextUtils.isEmpty(bVar.bYk) ? false : true));
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
            if (!TextUtils.isEmpty(bVar.bYf)) {
                jSONObject.put("phone", bVar.bYf);
            }
            if (!TextUtils.isEmpty(bVar.bYg)) {
                jSONObject.put("phone_cipher", bVar.bYg);
            }
            JSONObject a = d.a(bVar.bYh);
            if (a != null) {
                jSONObject.put("l1", a);
            }
            JSONObject a2 = d.a(bVar.bYi);
            if (a2 != null) {
                jSONObject.put("l2", a2);
            }
            JSONObject a3 = d.a(bVar.bYj);
            if (a3 != null) {
                jSONObject.put("l3", a3);
            }
            if (!TextUtils.isEmpty(bVar.bYk)) {
                jSONObject.put("street", bVar.bYk);
            }
            if (!TextUtils.isEmpty(bVar.bYl)) {
                jSONObject.put("zipcode", bVar.bYl);
            }
            jSONObject.put("default", bVar.bYm);
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
            if (!TextUtils.isEmpty(bVar.bYl)) {
                jSONObject.put("postalCode", bVar.bYl);
            }
            if (bVar.bYh != null && !TextUtils.isEmpty(bVar.bYh.name)) {
                jSONObject.put("provinceName", bVar.bYh.name);
            }
            if (bVar.bYi != null && !TextUtils.isEmpty(bVar.bYi.name)) {
                jSONObject.put("cityName", bVar.bYi.name);
            }
            if (bVar.bYj != null && !TextUtils.isEmpty(bVar.bYj.name)) {
                jSONObject.put("countyName", bVar.bYj.name);
            }
            if (bVar.bYj != null && !TextUtils.isEmpty(bVar.bYj.code)) {
                jSONObject.put("nationalCode", bVar.bYj.code);
            }
            if (!TextUtils.isEmpty(bVar.bYk)) {
                jSONObject.put("detailInfo", bVar.bYk);
            }
            if (!TextUtils.isEmpty(bVar.bYf)) {
                jSONObject.put("telNumber", bVar.bYf);
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
        a aVar2 = new a("联系电话", bVar.bYf, "手机号码或座机");
        aVar2.type = "phone";
        aVar2.bYe = true;
        arrayList.add(aVar2);
        a aVar3 = new a("所在地区", bVar.aga(), "地区选择");
        aVar3.type = "region";
        arrayList.add(aVar3);
        a aVar4 = new a("详细地址", bVar.bYk, "街道门牌信息");
        aVar4.type = "street";
        arrayList.add(aVar4);
        a aVar5 = new a("邮政编码", bVar.bYl, "邮政编码");
        aVar5.type = "zipcode";
        aVar5.bYe = true;
        arrayList.add(aVar5);
        return arrayList;
    }

    private String aga() {
        StringBuilder sb = new StringBuilder();
        if (this.bYh != null && !TextUtils.isEmpty(this.bYh.name)) {
            sb.append(this.bYh.name);
        }
        if (this.bYi != null && !TextUtils.isEmpty(this.bYi.name)) {
            sb.append(HanziToPinyin.Token.SEPARATOR + this.bYi.name);
        }
        if (this.bYj != null && !TextUtils.isEmpty(this.bYj.name)) {
            sb.append(HanziToPinyin.Token.SEPARATOR + this.bYj.name);
        }
        return sb.toString();
    }

    public String agb() {
        StringBuilder sb = new StringBuilder();
        sb.append(aga());
        sb.append(HanziToPinyin.Token.SEPARATOR + this.bYk);
        return sb.toString();
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.userName) || TextUtils.isEmpty(this.bYf) || TextUtils.isEmpty(aga()) || TextUtils.isEmpty(this.bYk) || this.bYf.length() != 11 || !this.bYf.startsWith("1")) ? false : true;
    }

    public static boolean mP(String str) {
        if (!TextUtils.isEmpty(str) && str.length() == 11 && str.startsWith("1")) {
            return mR(str);
        }
        return false;
    }

    public void f(b bVar) {
        if (bVar != null) {
            if (!TextUtils.isEmpty(bVar.userName)) {
                this.userName = bVar.userName;
            }
            if (!TextUtils.isEmpty(bVar.bYf)) {
                this.bYf = bVar.bYf;
            }
            if (!TextUtils.isEmpty(bVar.bYg)) {
                this.bYg = bVar.bYg;
            }
            if (!TextUtils.isEmpty(bVar.bYk)) {
                this.bYk = bVar.bYk;
            }
            if (!TextUtils.isEmpty(bVar.bYl)) {
                this.bYl = bVar.bYl;
            }
            if (bVar.bYh != null && bVar.bYh.isValid()) {
                this.bYh = bVar.bYh;
            }
            if (bVar.bYi != null && bVar.bYi.isValid()) {
                this.bYi = bVar.bYi;
            }
            if (bVar.bYj != null && bVar.bYj.isValid()) {
                this.bYj = bVar.bYj;
            }
        }
    }

    public static boolean mQ(String str) {
        return str.length() == 6 && mR(str);
    }

    public static boolean mR(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public void agc() {
        if (mP(this.bYf)) {
            this.bYg = this.bYf.substring(0, 3) + "*****" + this.bYf.substring(8);
        }
    }
}
