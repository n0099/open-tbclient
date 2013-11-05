package com.baidu.android.defense.push;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected JSONObject f619a;
    protected boolean b;
    protected Context c;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(String str, Context context) {
        this.f619a = null;
        this.b = true;
        this.c = null;
        if (TextUtils.isEmpty(str)) {
            this.b = false;
            return;
        }
        this.c = context.getApplicationContext();
        try {
            this.f619a = new JSONObject(str);
        } catch (JSONException e) {
            this.b = false;
        }
    }

    public abstract boolean a();
}
