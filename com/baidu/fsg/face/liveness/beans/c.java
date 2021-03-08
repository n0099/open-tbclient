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
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1751a = "request_data";
    private static c b = null;
    private static final String d = "RIM_LIVENESS_VIDEO_PREFERENCE";
    private static final String e = "RIM_LIVENESS_VIDEO_VIDEOENCODINGBITRATE";
    private HashMap<String, SapiBiometricDto> c = new HashMap<>();

    private c() {
    }

    public static c a() {
        if (b == null) {
            b = new c();
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

    public void a(Context context, int i) {
        if (i > 0) {
            SharedPreferencesUtils.setParam(context, d, e, RimArmor.getInstance().localEncryptProxy(String.valueOf(i)));
        }
    }

    public int b(Context context) {
        String localDecryptProxy = RimArmor.getInstance().localDecryptProxy((String) SharedPreferencesUtils.getParam(context, d, e, ""));
        try {
            if (!TextUtils.isEmpty(localDecryptProxy)) {
                return Integer.parseInt(localDecryptProxy);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return 1048576;
    }
}
