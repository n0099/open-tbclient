package com.baidu.pass.biometrics.face.liveness.a;

import com.baidu.pass.biometrics.base.dto.PassBiometricDto;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f3995a = null;

    /* renamed from: b  reason: collision with root package name */
    public static final String f3996b = "request_data";
    private HashMap<String, PassBiometricDto> c = new HashMap<>();

    private a() {
    }

    public static a a() {
        if (f3995a == null) {
            f3995a = new a();
        }
        return f3995a;
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
