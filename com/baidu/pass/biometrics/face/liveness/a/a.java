package com.baidu.pass.biometrics.face.liveness.a;

import com.baidu.pass.biometrics.base.dto.PassBiometricDto;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class a {
    private static a a = null;
    public static final String b = "request_data";
    private HashMap<String, PassBiometricDto> c = new HashMap<>();

    private a() {
    }

    public static a a() {
        if (a == null) {
            a = new a();
        }
        return a;
    }

    public void b() {
        HashMap<String, PassBiometricDto> hashMap = this.c;
        if (hashMap != null) {
            hashMap.clear();
            this.c = null;
        }
    }

    public PassBiometricDto a(String str) {
        HashMap<String, PassBiometricDto> hashMap = this.c;
        if (hashMap != null) {
            return hashMap.get(str);
        }
        return null;
    }

    public void a(String str, PassBiometricDto passBiometricDto) {
        if (this.c == null) {
            this.c = new HashMap<>();
        }
        this.c.put(str, passBiometricDto);
    }
}
