package com.baidu.fsg.face.base;

import android.content.Context;
import com.baidu.fsg.face.base.dto.SapiBiometricDto;
/* loaded from: classes6.dex */
public class c extends d {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2131a = "1.3.7";

    /* renamed from: b  reason: collision with root package name */
    public static final int f2132b = 32;
    private static c c;

    private c() {
    }

    public static c a() {
        if (c == null) {
            synchronized (c.class) {
                if (c == null) {
                    c = new c();
                }
            }
        }
        return c;
    }

    @Override // com.baidu.fsg.face.base.d
    public b a(int i) {
        try {
            return (b) Class.forName(a.a(i)).getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e) {
            com.baidu.fsg.face.base.d.d.a(e);
            return c();
        }
    }

    private b c() {
        return new b() { // from class: com.baidu.fsg.face.base.c.1
            @Override // com.baidu.fsg.face.base.b
            public void execute(e eVar, com.baidu.fsg.face.base.a.a aVar, SapiBiometricDto sapiBiometricDto, Context context) {
                com.baidu.fsg.face.base.d.d.d(d.class.getSimpleName(), "ERROR with implement Biometric!");
            }
        };
    }
}
