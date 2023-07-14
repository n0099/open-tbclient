package com.baidu.android.imsdk.shield;

import com.baidu.android.imsdk.IMListener;
import org.json.JSONObject;
/* loaded from: classes.dex */
public interface IIsAllowSendMsgListener extends IMListener {
    void onIsAllowResult(int i, String str, long j, boolean z, int i2, JSONObject jSONObject, JSONObject jSONObject2);
}
