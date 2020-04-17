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
    public d cBA;
    public d cBB;
    public String cBC;
    public String cBD;
    public boolean cBE;
    public String cBx;
    public String cBy;
    public d cBz;
    public String id;
    public String userName;

    public static b bn(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        bVar.id = jSONObject.optString("id");
        bVar.userName = jSONObject.optString("name");
        bVar.cBx = jSONObject.optString("phone");
        bVar.cBy = jSONObject.optString("phone_cipher");
        JSONObject optJSONObject = jSONObject.optJSONObject("l1");
        if (optJSONObject != null) {
            bVar.cBz = d.bo(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("l2");
        if (optJSONObject2 != null) {
            bVar.cBA = d.bo(optJSONObject2);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("l3");
        if (optJSONObject3 != null) {
            bVar.cBB = d.bo(optJSONObject3);
        }
        bVar.cBC = jSONObject.optString("street");
        bVar.cBD = jSONObject.optString("zipcode");
        bVar.cBE = TextUtils.equals(jSONObject.optString("default"), "1");
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
            bVar.cBx = String.valueOf(map.get("phone"));
        }
        if (map.containsKey("street")) {
            bVar.cBC = String.valueOf(map.get("street"));
        }
        if (map.containsKey("zipcode")) {
            bVar.cBD = String.valueOf(map.get("zipcode"));
        }
        if (map.containsKey("l1")) {
            Object obj = map.get("l1");
            if (obj instanceof d) {
                bVar.cBz = (d) obj;
            }
        }
        if (map.containsKey("l2")) {
            Object obj2 = map.get("l2");
            if (obj2 instanceof d) {
                bVar.cBA = (d) obj2;
            }
        }
        if (map.containsKey("l3")) {
            Object obj3 = map.get("l3");
            if (obj3 instanceof d) {
                bVar.cBB = (d) obj3;
            }
        }
        return bVar;
    }

    public static Map<String, Boolean> b(b bVar) {
        HashMap hashMap = new HashMap(4);
        if (bVar != null) {
            hashMap.put("name", Boolean.valueOf(!TextUtils.isEmpty(bVar.userName)));
            hashMap.put("phone", Boolean.valueOf(!TextUtils.isEmpty(bVar.cBx)));
            hashMap.put("region", Boolean.valueOf(!TextUtils.isEmpty(bVar.aqB())));
            hashMap.put("street", Boolean.valueOf(TextUtils.isEmpty(bVar.cBC) ? false : true));
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
            if (!TextUtils.isEmpty(bVar.cBx)) {
                jSONObject.put("phone", bVar.cBx);
            }
            if (!TextUtils.isEmpty(bVar.cBy)) {
                jSONObject.put("phone_cipher", bVar.cBy);
            }
            JSONObject a = d.a(bVar.cBz);
            if (a != null) {
                jSONObject.put("l1", a);
            }
            JSONObject a2 = d.a(bVar.cBA);
            if (a2 != null) {
                jSONObject.put("l2", a2);
            }
            JSONObject a3 = d.a(bVar.cBB);
            if (a3 != null) {
                jSONObject.put("l3", a3);
            }
            if (!TextUtils.isEmpty(bVar.cBC)) {
                jSONObject.put("street", bVar.cBC);
            }
            if (!TextUtils.isEmpty(bVar.cBD)) {
                jSONObject.put("zipcode", bVar.cBD);
            }
            jSONObject.put("default", bVar.cBE);
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
            if (!TextUtils.isEmpty(bVar.cBD)) {
                jSONObject.put("postalCode", bVar.cBD);
            }
            if (bVar.cBz != null && !TextUtils.isEmpty(bVar.cBz.name)) {
                jSONObject.put("provinceName", bVar.cBz.name);
            }
            if (bVar.cBA != null && !TextUtils.isEmpty(bVar.cBA.name)) {
                jSONObject.put("cityName", bVar.cBA.name);
            }
            if (bVar.cBB != null && !TextUtils.isEmpty(bVar.cBB.name)) {
                jSONObject.put("countyName", bVar.cBB.name);
            }
            if (bVar.cBB != null && !TextUtils.isEmpty(bVar.cBB.code)) {
                jSONObject.put("nationalCode", bVar.cBB.code);
            }
            if (!TextUtils.isEmpty(bVar.cBC)) {
                jSONObject.put("detailInfo", bVar.cBC);
            }
            if (!TextUtils.isEmpty(bVar.cBx)) {
                jSONObject.put("telNumber", bVar.cBx);
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
        a aVar2 = new a("联系电话", bVar.cBx, "手机号码或座机");
        aVar2.type = "phone";
        aVar2.cBw = true;
        arrayList.add(aVar2);
        a aVar3 = new a("所在地区", bVar.aqB(), "地区选择");
        aVar3.type = "region";
        arrayList.add(aVar3);
        a aVar4 = new a("详细地址", bVar.cBC, "街道门牌信息");
        aVar4.type = "street";
        arrayList.add(aVar4);
        a aVar5 = new a("邮政编码", bVar.cBD, "邮政编码");
        aVar5.type = "zipcode";
        aVar5.cBw = true;
        arrayList.add(aVar5);
        return arrayList;
    }

    private String aqB() {
        StringBuilder sb = new StringBuilder();
        if (this.cBz != null && !TextUtils.isEmpty(this.cBz.name)) {
            sb.append(this.cBz.name);
        }
        if (this.cBA != null && !TextUtils.isEmpty(this.cBA.name)) {
            sb.append(" " + this.cBA.name);
        }
        if (this.cBB != null && !TextUtils.isEmpty(this.cBB.name)) {
            sb.append(" " + this.cBB.name);
        }
        return sb.toString();
    }

    public String aqC() {
        StringBuilder sb = new StringBuilder();
        sb.append(aqB());
        sb.append(" " + this.cBC);
        return sb.toString();
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.userName) || TextUtils.isEmpty(this.cBx) || TextUtils.isEmpty(aqB()) || TextUtils.isEmpty(this.cBC) || this.cBx.length() != 11 || !this.cBx.startsWith("1")) ? false : true;
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
            if (!TextUtils.isEmpty(bVar.cBx)) {
                this.cBx = bVar.cBx;
            }
            if (!TextUtils.isEmpty(bVar.cBy)) {
                this.cBy = bVar.cBy;
            }
            if (!TextUtils.isEmpty(bVar.cBC)) {
                this.cBC = bVar.cBC;
            }
            if (!TextUtils.isEmpty(bVar.cBD)) {
                this.cBD = bVar.cBD;
            }
            if (bVar.cBz != null && bVar.cBz.isValid()) {
                this.cBz = bVar.cBz;
            }
            if (bVar.cBA != null && bVar.cBA.isValid()) {
                this.cBA = bVar.cBA;
            }
            if (bVar.cBB != null && bVar.cBB.isValid()) {
                this.cBB = bVar.cBB;
            }
        }
    }

    public static boolean ot(String str) {
        return str.length() == 6 && ou(str);
    }

    public static boolean ou(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public void aqD() {
        if (os(this.cBx)) {
            this.cBy = this.cBx.substring(0, 3) + "*****" + this.cBx.substring(8);
        }
    }
}
