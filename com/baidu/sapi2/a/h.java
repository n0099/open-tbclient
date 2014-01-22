package com.baidu.sapi2.a;

import android.os.Message;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
/* loaded from: classes.dex */
public class h extends i {
    protected static final int g = 100;

    public void onSuccess(JSONObject jSONObject) {
    }

    public void onSuccess(JSONArray jSONArray) {
    }

    public void onSuccess(int i, JSONObject jSONObject) {
        onSuccess(jSONObject);
    }

    public void onSuccess(int i, JSONArray jSONArray) {
        onSuccess(jSONArray);
    }

    public void onFailure(Throwable th, JSONObject jSONObject) {
    }

    public void onFailure(Throwable th, JSONArray jSONArray) {
    }

    @Override // com.baidu.sapi2.a.i
    protected void a(int i, String str) {
        if (i != 204) {
            try {
                b(b(100, new Object[]{Integer.valueOf(i), a(str)}));
                return;
            } catch (JSONException e) {
                b(e, str);
                return;
            }
        }
        b(b(100, new Object[]{Integer.valueOf(i), new JSONObject()}));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.a.i
    public void a(Message message) {
        switch (message.what) {
            case 100:
                Object[] objArr = (Object[]) message.obj;
                a(((Integer) objArr[0]).intValue(), objArr[1]);
                return;
            default:
                super.a(message);
                return;
        }
    }

    protected void a(int i, Object obj) {
        if (obj instanceof JSONObject) {
            onSuccess(i, (JSONObject) obj);
        } else if (obj instanceof JSONArray) {
            onSuccess(i, (JSONArray) obj);
        } else {
            onFailure(new JSONException("Unexpected type " + obj.getClass().getName()), (JSONObject) null);
        }
    }

    protected Object a(String str) {
        Object obj = null;
        String trim = str.trim();
        if (trim.startsWith("{") || trim.startsWith("[")) {
            obj = new JSONTokener(trim).nextValue();
        }
        return obj == null ? trim : obj;
    }

    @Override // com.baidu.sapi2.a.i
    protected void a(Throwable th, String str) {
        try {
            if (str != null) {
                Object a = a(str);
                if (a instanceof JSONObject) {
                    onFailure(th, (JSONObject) a);
                } else if (a instanceof JSONArray) {
                    onFailure(th, (JSONArray) a);
                } else {
                    onFailure(th, str);
                }
            } else {
                onFailure(th, "");
            }
        } catch (JSONException e) {
            onFailure(th, str);
        }
    }
}
