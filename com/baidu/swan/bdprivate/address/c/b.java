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
    public String ccj;
    public String cck;
    public d ccl;
    public d ccm;
    public d ccn;
    public String cco;
    public String ccp;
    public boolean ccq;
    public String id;
    public String userName;

    public static b bc(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        bVar.id = jSONObject.optString("id");
        bVar.userName = jSONObject.optString("name");
        bVar.ccj = jSONObject.optString("phone");
        bVar.cck = jSONObject.optString("phone_cipher");
        JSONObject optJSONObject = jSONObject.optJSONObject("l1");
        if (optJSONObject != null) {
            bVar.ccl = d.bd(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("l2");
        if (optJSONObject2 != null) {
            bVar.ccm = d.bd(optJSONObject2);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("l3");
        if (optJSONObject3 != null) {
            bVar.ccn = d.bd(optJSONObject3);
        }
        bVar.cco = jSONObject.optString("street");
        bVar.ccp = jSONObject.optString("zipcode");
        bVar.ccq = TextUtils.equals(jSONObject.optString("default"), "1");
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
            bVar.ccj = String.valueOf(map.get("phone"));
        }
        if (map.containsKey("street")) {
            bVar.cco = String.valueOf(map.get("street"));
        }
        if (map.containsKey("zipcode")) {
            bVar.ccp = String.valueOf(map.get("zipcode"));
        }
        if (map.containsKey("l1")) {
            Object obj = map.get("l1");
            if (obj instanceof d) {
                bVar.ccl = (d) obj;
            }
        }
        if (map.containsKey("l2")) {
            Object obj2 = map.get("l2");
            if (obj2 instanceof d) {
                bVar.ccm = (d) obj2;
            }
        }
        if (map.containsKey("l3")) {
            Object obj3 = map.get("l3");
            if (obj3 instanceof d) {
                bVar.ccn = (d) obj3;
            }
        }
        return bVar;
    }

    public static Map<String, Boolean> b(b bVar) {
        HashMap hashMap = new HashMap(4);
        if (bVar != null) {
            hashMap.put("name", Boolean.valueOf(!TextUtils.isEmpty(bVar.userName)));
            hashMap.put("phone", Boolean.valueOf(!TextUtils.isEmpty(bVar.ccj)));
            hashMap.put("region", Boolean.valueOf(!TextUtils.isEmpty(bVar.aio())));
            hashMap.put("street", Boolean.valueOf(TextUtils.isEmpty(bVar.cco) ? false : true));
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
            if (!TextUtils.isEmpty(bVar.ccj)) {
                jSONObject.put("phone", bVar.ccj);
            }
            if (!TextUtils.isEmpty(bVar.cck)) {
                jSONObject.put("phone_cipher", bVar.cck);
            }
            JSONObject a = d.a(bVar.ccl);
            if (a != null) {
                jSONObject.put("l1", a);
            }
            JSONObject a2 = d.a(bVar.ccm);
            if (a2 != null) {
                jSONObject.put("l2", a2);
            }
            JSONObject a3 = d.a(bVar.ccn);
            if (a3 != null) {
                jSONObject.put("l3", a3);
            }
            if (!TextUtils.isEmpty(bVar.cco)) {
                jSONObject.put("street", bVar.cco);
            }
            if (!TextUtils.isEmpty(bVar.ccp)) {
                jSONObject.put("zipcode", bVar.ccp);
            }
            jSONObject.put("default", bVar.ccq);
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
            if (!TextUtils.isEmpty(bVar.ccp)) {
                jSONObject.put("postalCode", bVar.ccp);
            }
            if (bVar.ccl != null && !TextUtils.isEmpty(bVar.ccl.name)) {
                jSONObject.put("provinceName", bVar.ccl.name);
            }
            if (bVar.ccm != null && !TextUtils.isEmpty(bVar.ccm.name)) {
                jSONObject.put("cityName", bVar.ccm.name);
            }
            if (bVar.ccn != null && !TextUtils.isEmpty(bVar.ccn.name)) {
                jSONObject.put("countyName", bVar.ccn.name);
            }
            if (bVar.ccn != null && !TextUtils.isEmpty(bVar.ccn.code)) {
                jSONObject.put("nationalCode", bVar.ccn.code);
            }
            if (!TextUtils.isEmpty(bVar.cco)) {
                jSONObject.put("detailInfo", bVar.cco);
            }
            if (!TextUtils.isEmpty(bVar.ccj)) {
                jSONObject.put("telNumber", bVar.ccj);
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
        a aVar2 = new a("联系电话", bVar.ccj, "手机号码或座机");
        aVar2.type = "phone";
        aVar2.cci = true;
        arrayList.add(aVar2);
        a aVar3 = new a("所在地区", bVar.aio(), "地区选择");
        aVar3.type = "region";
        arrayList.add(aVar3);
        a aVar4 = new a("详细地址", bVar.cco, "街道门牌信息");
        aVar4.type = "street";
        arrayList.add(aVar4);
        a aVar5 = new a("邮政编码", bVar.ccp, "邮政编码");
        aVar5.type = "zipcode";
        aVar5.cci = true;
        arrayList.add(aVar5);
        return arrayList;
    }

    private String aio() {
        StringBuilder sb = new StringBuilder();
        if (this.ccl != null && !TextUtils.isEmpty(this.ccl.name)) {
            sb.append(this.ccl.name);
        }
        if (this.ccm != null && !TextUtils.isEmpty(this.ccm.name)) {
            sb.append(HanziToPinyin.Token.SEPARATOR + this.ccm.name);
        }
        if (this.ccn != null && !TextUtils.isEmpty(this.ccn.name)) {
            sb.append(HanziToPinyin.Token.SEPARATOR + this.ccn.name);
        }
        return sb.toString();
    }

    public String aip() {
        StringBuilder sb = new StringBuilder();
        sb.append(aio());
        sb.append(HanziToPinyin.Token.SEPARATOR + this.cco);
        return sb.toString();
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.userName) || TextUtils.isEmpty(this.ccj) || TextUtils.isEmpty(aio()) || TextUtils.isEmpty(this.cco) || this.ccj.length() != 11 || !this.ccj.startsWith("1")) ? false : true;
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
            if (!TextUtils.isEmpty(bVar.ccj)) {
                this.ccj = bVar.ccj;
            }
            if (!TextUtils.isEmpty(bVar.cck)) {
                this.cck = bVar.cck;
            }
            if (!TextUtils.isEmpty(bVar.cco)) {
                this.cco = bVar.cco;
            }
            if (!TextUtils.isEmpty(bVar.ccp)) {
                this.ccp = bVar.ccp;
            }
            if (bVar.ccl != null && bVar.ccl.isValid()) {
                this.ccl = bVar.ccl;
            }
            if (bVar.ccm != null && bVar.ccm.isValid()) {
                this.ccm = bVar.ccm;
            }
            if (bVar.ccn != null && bVar.ccn.isValid()) {
                this.ccn = bVar.ccn;
            }
        }
    }

    public static boolean nf(String str) {
        return str.length() == 6 && ng(str);
    }

    public static boolean ng(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public void aiq() {
        if (ne(this.ccj)) {
            this.cck = this.ccj.substring(0, 3) + "*****" + this.ccj.substring(8);
        }
    }
}
