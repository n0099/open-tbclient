package com.baidu.pass.biometrics.face.liveness.a;

import com.baidu.pass.biometrics.base.dto.PassBiometricDto;
import java.util.HashMap;
/* loaded from: classes14.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f2775a = null;
    public static final String b = "request_data";
    private HashMap<String, PassBiometricDto> c = new HashMap<>();

    private a() {
    }

    public static a a() {
        if (f2775a == null) {
            f2775a = new a();
        }
        return f2775a;
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
