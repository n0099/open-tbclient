package com.baidu.android.defense.push;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class n {
    protected JSONObject b;
    protected boolean c;
    protected Context d;

    public n() {
        this.b = null;
        this.c = true;
        this.d = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public n(String str, Context context) {
        this.b = null;
        this.c = true;
        this.d = null;
        if (TextUtils.isEmpty(str)) {
            this.c = false;
            return;
        }
        this.d = context.getApplicationContext();
        try {
            this.b = new JSONObject(str);
        } catch (JSONException e) {
            this.c = false;
        }
    }

    public abstract boolean b();
}
