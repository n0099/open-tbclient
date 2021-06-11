package com.baidu.pass.biometrics.face.liveness.a;

import com.baidu.pass.biometrics.base.dto.PassBiometricDto;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f9083b = null;

    /* renamed from: c  reason: collision with root package name */
    public static final String f9084c = "request_data";

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, PassBiometricDto> f9085a = new HashMap<>();

    public static a b() {
        if (f9083b == null) {
            f9083b = new a();
        }
        return f9083b;
    }

    public PassBiometricDto a(String str) {
        HashMap<String, PassBiometricDto> hashMap = this.f9085a;
        if (hashMap != null) {
            return hashMap.get(str);
        }
        return null;
    }

    public void a(String str, PassBiometricDto passBiometricDto) {
        if (this.f9085a == null) {
            this.f9085a = new HashMap<>();
        }
        this.f9085a.put(str, passBiometricDto);
    }

    public void a() {
        HashMap<String, PassBiometricDto> hashMap = this.f9085a;
        if (hashMap != null) {
            hashMap.clear();
            this.f9085a = null;
        }
    }
}
