package com.alipay.sdk.packet.impl;

import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends com.alipay.sdk.packet.e {
    @Override // com.alipay.sdk.packet.e
    public JSONObject a() throws JSONException {
        return com.alipay.sdk.packet.e.a("cashier", FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT);
    }
}
