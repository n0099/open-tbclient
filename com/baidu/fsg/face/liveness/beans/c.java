package com.baidu.fsg.face.liveness.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.fsg.base.armor.RimArmor;
import com.baidu.fsg.base.restnet.beans.business.core.utils.BdWalletUtils;
import com.baidu.fsg.base.restnet.fp.GetFPResponse;
import com.baidu.fsg.base.utils.JsonUtils;
import com.baidu.fsg.base.utils.SharedPreferencesUtils;
import com.baidu.fsg.face.base.dto.SapiBiometricDto;
import java.util.HashMap;
import org.json.JSONException;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5936a = "request_data";

    /* renamed from: b  reason: collision with root package name */
    public static c f5937b = null;

    /* renamed from: d  reason: collision with root package name */
    public static final String f5938d = "RIM_LIVENESS_VIDEO_PREFERENCE";

    /* renamed from: e  reason: collision with root package name */
    public static final String f5939e = "RIM_LIVENESS_VIDEO_VIDEOENCODINGBITRATE";

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, SapiBiometricDto> f5940c = new HashMap<>();

    public static c a() {
        if (f5937b == null) {
            f5937b = new c();
        }
        return f5937b;
    }

    public void b() {
        HashMap<String, SapiBiometricDto> hashMap = this.f5940c;
        if (hashMap != null) {
            hashMap.clear();
            this.f5940c = null;
        }
    }

    public SapiBiometricDto a(String str) {
        HashMap<String, SapiBiometricDto> hashMap = this.f5940c;
        if (hashMap != null) {
            return hashMap.get(str);
        }
        return null;
    }

    public int b(Context context) {
        String localDecryptProxy = RimArmor.getInstance().localDecryptProxy((String) SharedPreferencesUtils.getParam(context, f5938d, f5939e, ""));
        try {
            if (TextUtils.isEmpty(localDecryptProxy)) {
                return 1048576;
            }
            return Integer.parseInt(localDecryptProxy);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 1048576;
        }
    }

    public void a(String str, SapiBiometricDto sapiBiometricDto) {
        if (this.f5940c == null) {
            this.f5940c = new HashMap<>();
        }
        this.f5940c.put(str, sapiBiometricDto);
    }

    public GetFPResponse.LivenessConfig a(Context context) {
        String rimAllConfig = BdWalletUtils.getRimAllConfig(context.getApplicationContext());
        if (!TextUtils.isEmpty(rimAllConfig)) {
            try {
                GetFPResponse.RimConfig rimConfig = (GetFPResponse.RimConfig) JsonUtils.fromJson(rimAllConfig, GetFPResponse.RimConfig.class);
                if (rimConfig != null && rimConfig.living != null) {
                    return rimConfig.living;
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return new GetFPResponse.LivenessConfig();
    }

    public void a(Context context, int i2) {
        if (i2 > 0) {
            SharedPreferencesUtils.setParam(context, f5938d, f5939e, RimArmor.getInstance().localEncryptProxy(String.valueOf(i2)));
        }
    }
}
