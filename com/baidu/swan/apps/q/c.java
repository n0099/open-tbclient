package com.baidu.swan.apps.q;

import android.widget.EditText;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.component.components.f.a;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a.InterfaceC0390a deG;

    public static void a(a.InterfaceC0390a interfaceC0390a) {
        deG = interfaceC0390a;
    }

    public static void c(EditText editText, int i) {
        if (editText != null && deG != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("value", editText.getText());
                jSONObject.put("eventName", "change");
                jSONObject.put("cursorOffset", editText.getSelectionStart());
                jSONObject.put("keyCode", i);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            deG.f(String.valueOf(editText.getTag()), jSONObject);
        }
    }

    public static void d(EditText editText, int i) {
        a(editText, AddFriendActivityConfig.TYPE_FOCUS, i);
    }

    public static void e(EditText editText, int i) {
        a(editText, "blur", i);
    }

    public static void f(EditText editText, int i) {
        a(editText, "confirm", i);
    }

    private static void a(EditText editText, String str, int i) {
        if (editText != null && deG != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("value", editText.getText());
                jSONObject.put("eventName", str);
                jSONObject.put("cursorOffset", editText.getText().length());
                jSONObject.put("keyboardHeight", ah.R(i));
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            deG.f(String.valueOf(editText.getTag()), jSONObject);
        }
    }
}
