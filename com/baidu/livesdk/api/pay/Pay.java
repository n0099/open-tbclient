package com.baidu.livesdk.api.pay;

import android.app.Activity;
import android.content.Context;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public interface Pay {
    public static final int CANCEL = 2;
    public static final int FAIL = 6;
    public static final int LOGIN_FAIL = 5;
    public static final int NOT_SUPPORT = 3;
    public static final int PAYING = 1;
    public static final int SUCCESS = 0;
    public static final int TOKEN_FAIL = 4;
    public static final int UNKNOWN = -1000;

    /* loaded from: classes7.dex */
    public interface PayCallback {
        void onResult(int i2, String str);
    }

    void doPolymerPay(Activity activity, JSONObject jSONObject, String[] strArr, PayCallback payCallback);

    void doPolymerPay(Map map, PayCallback payCallback);

    void onPayResult(String str, String str2, Context context, boolean z);

    void onPayResult(String str, String str2, String str3, Context context, boolean z);

    void release();
}
