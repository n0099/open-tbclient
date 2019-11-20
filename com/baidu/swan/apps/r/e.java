package com.baidu.swan.apps.r;

import android.widget.EditText;
import com.baidu.swan.apps.r.b;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static b.a aRw;

    public static void a(b.a aVar) {
        aRw = aVar;
    }

    public static void a(EditText editText, int i) {
        if (editText != null && aRw != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("value", editText.getText());
                jSONObject.put("eventName", "change");
                jSONObject.put("cursorOffset", editText.getText().length());
                jSONObject.put("keyCode", i);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            aRw.d(String.valueOf(editText.getTag()), jSONObject);
        }
    }

    public static void b(EditText editText, int i) {
        a(editText, AddFriendActivityConfig.TYPE_FOCUS, i);
    }

    public static void c(EditText editText, int i) {
        a(editText, "blur", i);
    }

    public static void d(EditText editText, int i) {
        a(editText, "confirm", i);
    }

    private static void a(EditText editText, String str, int i) {
        if (editText != null && aRw != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("value", editText.getText());
                jSONObject.put("eventName", str);
                jSONObject.put("cursorOffset", editText.getText().length());
                jSONObject.put("keyboardHeight", i);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            aRw.d(String.valueOf(editText.getTag()), jSONObject);
        }
    }
}
