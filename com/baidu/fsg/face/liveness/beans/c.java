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
    public static final String f5879a = "request_data";

    /* renamed from: b  reason: collision with root package name */
    public static c f5880b = null;

    /* renamed from: d  reason: collision with root package name */
    public static final String f5881d = "RIM_LIVENESS_VIDEO_PREFERENCE";

    /* renamed from: e  reason: collision with root package name */
    public static final String f5882e = "RIM_LIVENESS_VIDEO_VIDEOENCODINGBITRATE";

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, SapiBiometricDto> f5883c = new HashMap<>();

    public static c a() {
        if (f5880b == null) {
            f5880b = new c();
        }
        return f5880b;
    }

    public void b() {
        HashMap<String, SapiBiometricDto> hashMap = this.f5883c;
        if (hashMap != null) {
            hashMap.clear();
            this.f5883c = null;
        }
    }

    public SapiBiometricDto a(String str) {
        HashMap<String, SapiBiometricDto> hashMap = this.f5883c;
        if (hashMap != null) {
            return hashMap.get(str);
        }
        return null;
    }

    public int b(Context context) {
        String localDecryptProxy = RimArmor.getInstance().localDecryptProxy((String) SharedPreferencesUtils.getParam(context, f5881d, f5882e, ""));
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
        if (this.f5883c == null) {
            this.f5883c = new HashMap<>();
        }
        this.f5883c.put(str, sapiBiometricDto);
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
            SharedPreferencesUtils.setParam(context, f5881d, f5882e, RimArmor.getInstance().localEncryptProxy(String.valueOf(i2)));
        }
    }
}
