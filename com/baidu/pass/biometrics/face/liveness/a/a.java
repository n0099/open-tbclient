package com.baidu.pass.biometrics.face.liveness.a;

import com.baidu.pass.biometrics.base.dto.PassBiometricDto;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a {
    public static a b = null;
    public static final String c = "request_data";
    public HashMap<String, PassBiometricDto> a = new HashMap<>();

    public static a b() {
        if (b == null) {
            b = new a();
        }
        return b;
    }

    public void a() {
        HashMap<String, PassBiometricDto> hashMap = this.a;
        if (hashMap != null) {
            hashMap.clear();
            this.a = null;
        }
    }

    public PassBiometricDto a(String str) {
        HashMap<String, PassBiometricDto> hashMap = this.a;
        if (hashMap != null) {
            return hashMap.get(str);
        }
        return null;
    }

    public void a(String str, PassBiometricDto passBiometricDto) {
        if (this.a == null) {
            this.a = new HashMap<>();
        }
        this.a.put(str, passBiometricDto);
    }
}
