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
    public String cck;
    public String ccl;
    public d ccm;
    public d ccn;
    public d cco;
    public String ccp;
    public String ccq;
    public boolean ccr;
    public String id;
    public String userName;

    public static b bc(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        bVar.id = jSONObject.optString("id");
        bVar.userName = jSONObject.optString("name");
        bVar.cck = jSONObject.optString("phone");
        bVar.ccl = jSONObject.optString("phone_cipher");
        JSONObject optJSONObject = jSONObject.optJSONObject("l1");
        if (optJSONObject != null) {
            bVar.ccm = d.bd(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("l2");
        if (optJSONObject2 != null) {
            bVar.ccn = d.bd(optJSONObject2);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("l3");
        if (optJSONObject3 != null) {
            bVar.cco = d.bd(optJSONObject3);
        }
        bVar.ccp = jSONObject.optString("street");
        bVar.ccq = jSONObject.optString("zipcode");
        bVar.ccr = TextUtils.equals(jSONObject.optString("default"), "1");
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
            bVar.cck = String.valueOf(map.get("phone"));
        }
        if (map.containsKey("street")) {
            bVar.ccp = String.valueOf(map.get("street"));
        }
        if (map.containsKey("zipcode")) {
            bVar.ccq = String.valueOf(map.get("zipcode"));
        }
        if (map.containsKey("l1")) {
            Object obj = map.get("l1");
            if (obj instanceof d) {
                bVar.ccm = (d) obj;
            }
        }
        if (map.containsKey("l2")) {
            Object obj2 = map.get("l2");
            if (obj2 instanceof d) {
                bVar.ccn = (d) obj2;
            }
        }
        if (map.containsKey("l3")) {
            Object obj3 = map.get("l3");
            if (obj3 instanceof d) {
                bVar.cco = (d) obj3;
            }
        }
        return bVar;
    }

    public static Map<String, Boolean> b(b bVar) {
        HashMap hashMap = new HashMap(4);
        if (bVar != null) {
            hashMap.put("name", Boolean.valueOf(!TextUtils.isEmpty(bVar.userName)));
            hashMap.put("phone", Boolean.valueOf(!TextUtils.isEmpty(bVar.cck)));
            hashMap.put("region", Boolean.valueOf(!TextUtils.isEmpty(bVar.aiq())));
            hashMap.put("street", Boolean.valueOf(TextUtils.isEmpty(bVar.ccp) ? false : true));
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
            if (!TextUtils.isEmpty(bVar.cck)) {
                jSONObject.put("phone", bVar.cck);
            }
            if (!TextUtils.isEmpty(bVar.ccl)) {
                jSONObject.put("phone_cipher", bVar.ccl);
            }
            JSONObject a = d.a(bVar.ccm);
            if (a != null) {
                jSONObject.put("l1", a);
            }
            JSONObject a2 = d.a(bVar.ccn);
            if (a2 != null) {
                jSONObject.put("l2", a2);
            }
            JSONObject a3 = d.a(bVar.cco);
            if (a3 != null) {
                jSONObject.put("l3", a3);
            }
            if (!TextUtils.isEmpty(bVar.ccp)) {
                jSONObject.put("street", bVar.ccp);
            }
            if (!TextUtils.isEmpty(bVar.ccq)) {
                jSONObject.put("zipcode", bVar.ccq);
            }
            jSONObject.put("default", bVar.ccr);
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
            if (!TextUtils.isEmpty(bVar.ccq)) {
                jSONObject.put("postalCode", bVar.ccq);
            }
            if (bVar.ccm != null && !TextUtils.isEmpty(bVar.ccm.name)) {
                jSONObject.put("provinceName", bVar.ccm.name);
            }
            if (bVar.ccn != null && !TextUtils.isEmpty(bVar.ccn.name)) {
                jSONObject.put("cityName", bVar.ccn.name);
            }
            if (bVar.cco != null && !TextUtils.isEmpty(bVar.cco.name)) {
                jSONObject.put("countyName", bVar.cco.name);
            }
            if (bVar.cco != null && !TextUtils.isEmpty(bVar.cco.code)) {
                jSONObject.put("nationalCode", bVar.cco.code);
            }
            if (!TextUtils.isEmpty(bVar.ccp)) {
                jSONObject.put("detailInfo", bVar.ccp);
            }
            if (!TextUtils.isEmpty(bVar.cck)) {
                jSONObject.put("telNumber", bVar.cck);
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
        a aVar2 = new a("联系电话", bVar.cck, "手机号码或座机");
        aVar2.type = "phone";
        aVar2.ccj = true;
        arrayList.add(aVar2);
        a aVar3 = new a("所在地区", bVar.aiq(), "地区选择");
        aVar3.type = "region";
        arrayList.add(aVar3);
        a aVar4 = new a("详细地址", bVar.ccp, "街道门牌信息");
        aVar4.type = "street";
        arrayList.add(aVar4);
        a aVar5 = new a("邮政编码", bVar.ccq, "邮政编码");
        aVar5.type = "zipcode";
        aVar5.ccj = true;
        arrayList.add(aVar5);
        return arrayList;
    }

    private String aiq() {
        StringBuilder sb = new StringBuilder();
        if (this.ccm != null && !TextUtils.isEmpty(this.ccm.name)) {
            sb.append(this.ccm.name);
        }
        if (this.ccn != null && !TextUtils.isEmpty(this.ccn.name)) {
            sb.append(HanziToPinyin.Token.SEPARATOR + this.ccn.name);
        }
        if (this.cco != null && !TextUtils.isEmpty(this.cco.name)) {
            sb.append(HanziToPinyin.Token.SEPARATOR + this.cco.name);
        }
        return sb.toString();
    }

    public String air() {
        StringBuilder sb = new StringBuilder();
        sb.append(aiq());
        sb.append(HanziToPinyin.Token.SEPARATOR + this.ccp);
        return sb.toString();
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.userName) || TextUtils.isEmpty(this.cck) || TextUtils.isEmpty(aiq()) || TextUtils.isEmpty(this.ccp) || this.cck.length() != 11 || !this.cck.startsWith("1")) ? false : true;
    }

    public static boolean ne(String str) {
        if (!TextUtils.isEmpty(str) && str.length() == 11 && str.startsWith("1")) {
            return ng(str);
        }
        return false;
    }

    public void f(b bVar) {
        if (bVar != null) {
            if (!TextUtils.isEmpty(bVar.userName)) {
                this.userName = bVar.userName;
            }
            if (!TextUtils.isEmpty(bVar.cck)) {
                this.cck = bVar.cck;
            }
            if (!TextUtils.isEmpty(bVar.ccl)) {
                this.ccl = bVar.ccl;
            }
            if (!TextUtils.isEmpty(bVar.ccp)) {
                this.ccp = bVar.ccp;
            }
            if (!TextUtils.isEmpty(bVar.ccq)) {
                this.ccq = bVar.ccq;
            }
            if (bVar.ccm != null && bVar.ccm.isValid()) {
                this.ccm = bVar.ccm;
            }
            if (bVar.ccn != null && bVar.ccn.isValid()) {
                this.ccn = bVar.ccn;
            }
            if (bVar.cco != null && bVar.cco.isValid()) {
                this.cco = bVar.cco;
            }
        }
    }

    public static boolean nf(String str) {
        return str.length() == 6 && ng(str);
    }

    public static boolean ng(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public void ais() {
        if (ne(this.cck)) {
            this.ccl = this.cck.substring(0, 3) + "*****" + this.cck.substring(8);
        }
    }
}
