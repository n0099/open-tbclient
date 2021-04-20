package com.baidu.fsg.face.base;

import android.content.Context;
import com.baidu.fsg.face.base.dto.SapiBiometricDto;
/* loaded from: classes2.dex */
public class c extends d {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5627a = "1.3.7";

    /* renamed from: b  reason: collision with root package name */
    public static final int f5628b = 32;

    /* renamed from: c  reason: collision with root package name */
    public static c f5629c;

    public static c a() {
        if (f5629c == null) {
            synchronized (c.class) {
                if (f5629c == null) {
                    f5629c = new c();
                }
            }
        }
        return f5629c;
    }

    private b c() {
        return new b() { // from class: com.baidu.fsg.face.base.c.1
            @Override // com.baidu.fsg.face.base.b
            public void execute(e eVar, com.baidu.fsg.face.base.a.a aVar, SapiBiometricDto sapiBiometricDto, Context context) {
                com.baidu.fsg.face.base.d.d.d(d.class.getSimpleName(), "ERROR with implement Biometric!");
            }
        };
    }

    @Override // com.baidu.fsg.face.base.d
    public b a(int i) {
        try {
            return (b) Class.forName(a.a(i)).getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e2) {
            com.baidu.fsg.face.base.d.d.a(e2);
            return c();
        }
    }
}
