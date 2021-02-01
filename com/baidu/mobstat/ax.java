package com.baidu.mobstat;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ax {
    private static final ax c = new ax();

    /* renamed from: a  reason: collision with root package name */
    private boolean f3732a = false;

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f3733b;

    public static ax a() {
        return c;
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = (JSONObject) new JSONObject(str).opt("full");
                this.f3732a = (jSONObject != null ? jSONObject.optInt("close") : 0) != 0;
            } catch (Exception e) {
            }
            this.f3733b = true;
        }
    }

    public boolean b() {
        return this.f3732a;
    }
}
