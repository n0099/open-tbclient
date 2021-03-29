package com.baidu.pass.biometrics.face.liveness.a;

import com.baidu.pass.biometrics.base.dto.PassBiometricDto;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f9605b = null;

    /* renamed from: c  reason: collision with root package name */
    public static final String f9606c = "request_data";

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, PassBiometricDto> f9607a = new HashMap<>();

    public static a b() {
        if (f9605b == null) {
            f9605b = new a();
        }
        return f9605b;
    }

    public PassBiometricDto a(String str) {
        HashMap<String, PassBiometricDto> hashMap = this.f9607a;
        if (hashMap != null) {
            return hashMap.get(str);
        }
        return null;
    }

    public void a(String str, PassBiometricDto passBiometricDto) {
        if (this.f9607a == null) {
            this.f9607a = new HashMap<>();
        }
        this.f9607a.put(str, passBiometricDto);
    }

    public void a() {
        HashMap<String, PassBiometricDto> hashMap = this.f9607a;
        if (hashMap != null) {
            hashMap.clear();
            this.f9607a = null;
        }
    }
}
