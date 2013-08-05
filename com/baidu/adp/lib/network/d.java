package com.baidu.adp.lib.network;

import android.content.Context;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static d f431a;
    private Context b;

    public static d a() {
        if (f431a == null) {
            f431a = new d();
        }
        return f431a;
    }

    public void a(Context context, boolean z) {
        this.b = context;
        b.f430a = z;
    }

    public e a(String str, ArrayList arrayList, String str2, byte[] bArr, int i, c cVar, a aVar) {
        try {
            return b.a(str, arrayList, str2, bArr, i, cVar, aVar);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Context b() {
        return this.b;
    }

    private d() {
    }
}
