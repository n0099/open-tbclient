package com.baidu.sapi2.biometrics.liveness.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.fsg.base.restnet.beans.business.core.utils.BdWalletUtils;
import com.baidu.fsg.base.restnet.fp.GetFPResponse;
import com.baidu.fsg.base.utils.JsonUtils;
import com.baidu.fsg.biometrics.base.dto.SapiBiometricDto;
import java.util.HashMap;
import org.json.JSONException;
/* loaded from: classes2.dex */
public class b {
    public static final String a = "request_data";
    private static b b;
    private HashMap<String, SapiBiometricDto> c = new HashMap<>();
    private GetFPResponse.LivenessConfig d;

    private b() {
    }

    public static b a() {
        if (b == null) {
            b = new b();
        }
        return b;
    }

    public SapiBiometricDto a(String str) {
        if (this.c != null) {
            return this.c.get(str);
        }
        return null;
    }

    public void a(String str, SapiBiometricDto sapiBiometricDto) {
        if (this.c == null) {
            this.c = new HashMap<>();
        }
        this.c.put(str, sapiBiometricDto);
    }

    public void b() {
        if (this.c != null) {
            this.c.clear();
            this.c = null;
        }
    }

    public GetFPResponse.LivenessConfig a(Context context) {
        if (this.d != null) {
            return this.d;
        }
        String rimAllConfig = BdWalletUtils.getRimAllConfig(context.getApplicationContext());
        if (!TextUtils.isEmpty(rimAllConfig)) {
            try {
                GetFPResponse.RimConfig rimConfig = (GetFPResponse.RimConfig) JsonUtils.fromJson(rimAllConfig, GetFPResponse.RimConfig.class);
                if (rimConfig != null && rimConfig.living != null) {
                    return rimConfig.living;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return new GetFPResponse.LivenessConfig();
    }

    public void c() {
        this.d = null;
    }
}
