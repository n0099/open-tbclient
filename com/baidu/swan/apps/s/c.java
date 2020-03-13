package com.baidu.swan.apps.s;

import android.widget.EditText;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.component.components.f.a;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a.InterfaceC0232a bxn;

    public static void a(a.InterfaceC0232a interfaceC0232a) {
        bxn = interfaceC0232a;
    }

    public static void a(EditText editText, int i) {
        if (editText != null && bxn != null) {
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
            bxn.b(String.valueOf(editText.getTag()), jSONObject);
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
        if (editText != null && bxn != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("value", editText.getText());
                jSONObject.put("eventName", str);
                jSONObject.put("cursorOffset", editText.getText().length());
                jSONObject.put("keyboardHeight", af.U(i));
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            bxn.b(String.valueOf(editText.getTag()), jSONObject);
        }
    }
}
