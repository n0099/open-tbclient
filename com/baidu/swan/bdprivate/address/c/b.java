package com.baidu.swan.bdprivate.address.c;

import android.text.TextUtils;
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
    public String cBD;
    public String cBE;
    public d cBF;
    public d cBG;
    public d cBH;
    public String cBI;
    public String cBJ;
    public boolean cBK;
    public String id;
    public String userName;

    public static b bn(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        bVar.id = jSONObject.optString("id");
        bVar.userName = jSONObject.optString("name");
        bVar.cBD = jSONObject.optString("phone");
        bVar.cBE = jSONObject.optString("phone_cipher");
        JSONObject optJSONObject = jSONObject.optJSONObject("l1");
        if (optJSONObject != null) {
            bVar.cBF = d.bo(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("l2");
        if (optJSONObject2 != null) {
            bVar.cBG = d.bo(optJSONObject2);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("l3");
        if (optJSONObject3 != null) {
            bVar.cBH = d.bo(optJSONObject3);
        }
        bVar.cBI = jSONObject.optString("street");
        bVar.cBJ = jSONObject.optString("zipcode");
        bVar.cBK = TextUtils.equals(jSONObject.optString("default"), "1");
        return bVar;
    }

    public static b r(Map<String, Object> map) {
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
            bVar.cBD = String.valueOf(map.get("phone"));
        }
        if (map.containsKey("street")) {
            bVar.cBI = String.valueOf(map.get("street"));
        }
        if (map.containsKey("zipcode")) {
            bVar.cBJ = String.valueOf(map.get("zipcode"));
        }
        if (map.containsKey("l1")) {
            Object obj = map.get("l1");
            if (obj instanceof d) {
                bVar.cBF = (d) obj;
            }
        }
        if (map.containsKey("l2")) {
            Object obj2 = map.get("l2");
            if (obj2 instanceof d) {
                bVar.cBG = (d) obj2;
            }
        }
        if (map.containsKey("l3")) {
            Object obj3 = map.get("l3");
            if (obj3 instanceof d) {
                bVar.cBH = (d) obj3;
            }
        }
        return bVar;
    }

    public static Map<String, Boolean> b(b bVar) {
        HashMap hashMap = new HashMap(4);
        if (bVar != null) {
            hashMap.put("name", Boolean.valueOf(!TextUtils.isEmpty(bVar.userName)));
            hashMap.put("phone", Boolean.valueOf(!TextUtils.isEmpty(bVar.cBD)));
            hashMap.put("region", Boolean.valueOf(!TextUtils.isEmpty(bVar.aqA())));
            hashMap.put("street", Boolean.valueOf(TextUtils.isEmpty(bVar.cBI) ? false : true));
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
            if (!TextUtils.isEmpty(bVar.cBD)) {
                jSONObject.put("phone", bVar.cBD);
            }
            if (!TextUtils.isEmpty(bVar.cBE)) {
                jSONObject.put("phone_cipher", bVar.cBE);
            }
            JSONObject a = d.a(bVar.cBF);
            if (a != null) {
                jSONObject.put("l1", a);
            }
            JSONObject a2 = d.a(bVar.cBG);
            if (a2 != null) {
                jSONObject.put("l2", a2);
            }
            JSONObject a3 = d.a(bVar.cBH);
            if (a3 != null) {
                jSONObject.put("l3", a3);
            }
            if (!TextUtils.isEmpty(bVar.cBI)) {
                jSONObject.put("street", bVar.cBI);
            }
            if (!TextUtils.isEmpty(bVar.cBJ)) {
                jSONObject.put("zipcode", bVar.cBJ);
            }
            jSONObject.put("default", bVar.cBK);
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
            if (!TextUtils.isEmpty(bVar.cBJ)) {
                jSONObject.put("postalCode", bVar.cBJ);
            }
            if (bVar.cBF != null && !TextUtils.isEmpty(bVar.cBF.name)) {
                jSONObject.put("provinceName", bVar.cBF.name);
            }
            if (bVar.cBG != null && !TextUtils.isEmpty(bVar.cBG.name)) {
                jSONObject.put("cityName", bVar.cBG.name);
            }
            if (bVar.cBH != null && !TextUtils.isEmpty(bVar.cBH.name)) {
                jSONObject.put("countyName", bVar.cBH.name);
            }
            if (bVar.cBH != null && !TextUtils.isEmpty(bVar.cBH.code)) {
                jSONObject.put("nationalCode", bVar.cBH.code);
            }
            if (!TextUtils.isEmpty(bVar.cBI)) {
                jSONObject.put("detailInfo", bVar.cBI);
            }
            if (!TextUtils.isEmpty(bVar.cBD)) {
                jSONObject.put("telNumber", bVar.cBD);
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
        a aVar2 = new a("联系电话", bVar.cBD, "手机号码或座机");
        aVar2.type = "phone";
        aVar2.cBC = true;
        arrayList.add(aVar2);
        a aVar3 = new a("所在地区", bVar.aqA(), "地区选择");
        aVar3.type = "region";
        arrayList.add(aVar3);
        a aVar4 = new a("详细地址", bVar.cBI, "街道门牌信息");
        aVar4.type = "street";
        arrayList.add(aVar4);
        a aVar5 = new a("邮政编码", bVar.cBJ, "邮政编码");
        aVar5.type = "zipcode";
        aVar5.cBC = true;
        arrayList.add(aVar5);
        return arrayList;
    }

    private String aqA() {
        StringBuilder sb = new StringBuilder();
        if (this.cBF != null && !TextUtils.isEmpty(this.cBF.name)) {
            sb.append(this.cBF.name);
        }
        if (this.cBG != null && !TextUtils.isEmpty(this.cBG.name)) {
            sb.append(" " + this.cBG.name);
        }
        if (this.cBH != null && !TextUtils.isEmpty(this.cBH.name)) {
            sb.append(" " + this.cBH.name);
        }
        return sb.toString();
    }

    public String aqB() {
        StringBuilder sb = new StringBuilder();
        sb.append(aqA());
        sb.append(" " + this.cBI);
        return sb.toString();
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.userName) || TextUtils.isEmpty(this.cBD) || TextUtils.isEmpty(aqA()) || TextUtils.isEmpty(this.cBI) || this.cBD.length() != 11 || !this.cBD.startsWith("1")) ? false : true;
    }

    public static boolean os(String str) {
        if (!TextUtils.isEmpty(str) && str.length() == 11 && str.startsWith("1")) {
            return ou(str);
        }
        return false;
    }

    public void f(b bVar) {
        if (bVar != null) {
            if (!TextUtils.isEmpty(bVar.userName)) {
                this.userName = bVar.userName;
            }
            if (!TextUtils.isEmpty(bVar.cBD)) {
                this.cBD = bVar.cBD;
            }
            if (!TextUtils.isEmpty(bVar.cBE)) {
                this.cBE = bVar.cBE;
            }
            if (!TextUtils.isEmpty(bVar.cBI)) {
                this.cBI = bVar.cBI;
            }
            if (!TextUtils.isEmpty(bVar.cBJ)) {
                this.cBJ = bVar.cBJ;
            }
            if (bVar.cBF != null && bVar.cBF.isValid()) {
                this.cBF = bVar.cBF;
            }
            if (bVar.cBG != null && bVar.cBG.isValid()) {
                this.cBG = bVar.cBG;
            }
            if (bVar.cBH != null && bVar.cBH.isValid()) {
                this.cBH = bVar.cBH;
            }
        }
    }

    public static boolean ot(String str) {
        return str.length() == 6 && ou(str);
    }

    public static boolean ou(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public void aqC() {
        if (os(this.cBD)) {
            this.cBE = this.cBD.substring(0, 3) + "*****" + this.cBD.substring(8);
        }
    }
}
