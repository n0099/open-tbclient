package com.baidu.swan.bdprivate.address.c;

import android.text.TextUtils;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String bXT;
    public String bXU;
    public d bXV;
    public d bXW;
    public d bXX;
    public String bXY;
    public String bXZ;
    public boolean bYa;
    public String id;
    public String userName;

    public static b bc(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        bVar.id = jSONObject.optString("id");
        bVar.userName = jSONObject.optString("name");
        bVar.bXT = jSONObject.optString("phone");
        bVar.bXU = jSONObject.optString("phone_cipher");
        JSONObject optJSONObject = jSONObject.optJSONObject("l1");
        if (optJSONObject != null) {
            bVar.bXV = d.bd(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("l2");
        if (optJSONObject2 != null) {
            bVar.bXW = d.bd(optJSONObject2);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("l3");
        if (optJSONObject3 != null) {
            bVar.bXX = d.bd(optJSONObject3);
        }
        bVar.bXY = jSONObject.optString("street");
        bVar.bXZ = jSONObject.optString("zipcode");
        bVar.bYa = TextUtils.equals(jSONObject.optString(DefaultSharedPrefsWrapper.SP_FILE_DEFAULT), "1");
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
            bVar.bXT = String.valueOf(map.get("phone"));
        }
        if (map.containsKey("street")) {
            bVar.bXY = String.valueOf(map.get("street"));
        }
        if (map.containsKey("zipcode")) {
            bVar.bXZ = String.valueOf(map.get("zipcode"));
        }
        if (map.containsKey("l1")) {
            Object obj = map.get("l1");
            if (obj instanceof d) {
                bVar.bXV = (d) obj;
            }
        }
        if (map.containsKey("l2")) {
            Object obj2 = map.get("l2");
            if (obj2 instanceof d) {
                bVar.bXW = (d) obj2;
            }
        }
        if (map.containsKey("l3")) {
            Object obj3 = map.get("l3");
            if (obj3 instanceof d) {
                bVar.bXX = (d) obj3;
            }
        }
        return bVar;
    }

    public static Map<String, Boolean> b(b bVar) {
        HashMap hashMap = new HashMap(4);
        if (bVar != null) {
            hashMap.put("name", Boolean.valueOf(!TextUtils.isEmpty(bVar.userName)));
            hashMap.put("phone", Boolean.valueOf(!TextUtils.isEmpty(bVar.bXT)));
            hashMap.put("region", Boolean.valueOf(!TextUtils.isEmpty(bVar.afH())));
            hashMap.put("street", Boolean.valueOf(TextUtils.isEmpty(bVar.bXY) ? false : true));
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
            if (!TextUtils.isEmpty(bVar.bXT)) {
                jSONObject.put("phone", bVar.bXT);
            }
            if (!TextUtils.isEmpty(bVar.bXU)) {
                jSONObject.put("phone_cipher", bVar.bXU);
            }
            JSONObject a = d.a(bVar.bXV);
            if (a != null) {
                jSONObject.put("l1", a);
            }
            JSONObject a2 = d.a(bVar.bXW);
            if (a2 != null) {
                jSONObject.put("l2", a2);
            }
            JSONObject a3 = d.a(bVar.bXX);
            if (a3 != null) {
                jSONObject.put("l3", a3);
            }
            if (!TextUtils.isEmpty(bVar.bXY)) {
                jSONObject.put("street", bVar.bXY);
            }
            if (!TextUtils.isEmpty(bVar.bXZ)) {
                jSONObject.put("zipcode", bVar.bXZ);
            }
            jSONObject.put(DefaultSharedPrefsWrapper.SP_FILE_DEFAULT, bVar.bYa);
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
            if (!TextUtils.isEmpty(bVar.bXZ)) {
                jSONObject.put("postalCode", bVar.bXZ);
            }
            if (bVar.bXV != null && !TextUtils.isEmpty(bVar.bXV.name)) {
                jSONObject.put("provinceName", bVar.bXV.name);
            }
            if (bVar.bXW != null && !TextUtils.isEmpty(bVar.bXW.name)) {
                jSONObject.put("cityName", bVar.bXW.name);
            }
            if (bVar.bXX != null && !TextUtils.isEmpty(bVar.bXX.name)) {
                jSONObject.put("countyName", bVar.bXX.name);
            }
            if (bVar.bXX != null && !TextUtils.isEmpty(bVar.bXX.code)) {
                jSONObject.put("nationalCode", bVar.bXX.code);
            }
            if (!TextUtils.isEmpty(bVar.bXY)) {
                jSONObject.put("detailInfo", bVar.bXY);
            }
            if (!TextUtils.isEmpty(bVar.bXT)) {
                jSONObject.put("telNumber", bVar.bXT);
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
        a aVar2 = new a("联系电话", bVar.bXT, "手机号码或座机");
        aVar2.type = "phone";
        aVar2.bXS = true;
        arrayList.add(aVar2);
        a aVar3 = new a("所在地区", bVar.afH(), "地区选择");
        aVar3.type = "region";
        arrayList.add(aVar3);
        a aVar4 = new a("详细地址", bVar.bXY, "街道门牌信息");
        aVar4.type = "street";
        arrayList.add(aVar4);
        a aVar5 = new a("邮政编码", bVar.bXZ, "邮政编码");
        aVar5.type = "zipcode";
        aVar5.bXS = true;
        arrayList.add(aVar5);
        return arrayList;
    }

    private String afH() {
        StringBuilder sb = new StringBuilder();
        if (this.bXV != null && !TextUtils.isEmpty(this.bXV.name)) {
            sb.append(this.bXV.name);
        }
        if (this.bXW != null && !TextUtils.isEmpty(this.bXW.name)) {
            sb.append(HanziToPinyin.Token.SEPARATOR + this.bXW.name);
        }
        if (this.bXX != null && !TextUtils.isEmpty(this.bXX.name)) {
            sb.append(HanziToPinyin.Token.SEPARATOR + this.bXX.name);
        }
        return sb.toString();
    }

    public String afI() {
        StringBuilder sb = new StringBuilder();
        sb.append(afH());
        sb.append(HanziToPinyin.Token.SEPARATOR + this.bXY);
        return sb.toString();
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.userName) || TextUtils.isEmpty(this.bXT) || TextUtils.isEmpty(afH()) || TextUtils.isEmpty(this.bXY) || this.bXT.length() != 11 || !this.bXT.startsWith("1")) ? false : true;
    }

    public static boolean mM(String str) {
        if (!TextUtils.isEmpty(str) && str.length() == 11 && str.startsWith("1")) {
            return mO(str);
        }
        return false;
    }

    public void f(b bVar) {
        if (bVar != null) {
            if (!TextUtils.isEmpty(bVar.userName)) {
                this.userName = bVar.userName;
            }
            if (!TextUtils.isEmpty(bVar.bXT)) {
                this.bXT = bVar.bXT;
            }
            if (!TextUtils.isEmpty(bVar.bXU)) {
                this.bXU = bVar.bXU;
            }
            if (!TextUtils.isEmpty(bVar.bXY)) {
                this.bXY = bVar.bXY;
            }
            if (!TextUtils.isEmpty(bVar.bXZ)) {
                this.bXZ = bVar.bXZ;
            }
            if (bVar.bXV != null && bVar.bXV.isValid()) {
                this.bXV = bVar.bXV;
            }
            if (bVar.bXW != null && bVar.bXW.isValid()) {
                this.bXW = bVar.bXW;
            }
            if (bVar.bXX != null && bVar.bXX.isValid()) {
                this.bXX = bVar.bXX;
            }
        }
    }

    public static boolean mN(String str) {
        return str.length() == 6 && mO(str);
    }

    public static boolean mO(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public void afJ() {
        if (mM(this.bXT)) {
            this.bXU = this.bXT.substring(0, 3) + "*****" + this.bXT.substring(8);
        }
    }
}
