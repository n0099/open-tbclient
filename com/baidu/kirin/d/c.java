package com.baidu.kirin.d;

import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public static String a(String str) {
        String next;
        int i;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String[] strArr = new String[jSONObject.length()];
            Iterator<String> keys = jSONObject.keys();
            int i2 = 0;
            while (keys.hasNext()) {
                try {
                    strArr[i2] = keys.next() + ":" + jSONObject.getString(next);
                    i = i2 + 1;
                } catch (JSONException e) {
                    e.printStackTrace();
                    i = i2;
                }
                i2 = i;
            }
            Arrays.sort(strArr);
            String str2 = strArr[0];
            for (int i3 = 1; i3 < strArr.length; i3++) {
                str2 = str2 + ", " + strArr[i3];
            }
            return str2;
        } catch (JSONException e2) {
            d.b("String to JSONObject error, return desc string!");
            e2.printStackTrace();
            return str;
        }
    }

    public static JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3 = new JSONObject();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                try {
                    jSONObject3.put(next, jSONObject.getString(next));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        Iterator<String> keys2 = jSONObject2.keys();
        while (keys2.hasNext()) {
            String next2 = keys2.next();
            try {
                try {
                    jSONObject3.put(next2, jSONObject2.getString(next2));
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        return jSONObject3;
    }
}
