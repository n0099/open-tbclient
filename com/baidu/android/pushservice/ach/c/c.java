package com.baidu.android.pushservice.ach.c;

import android.graphics.Region;
import com.baidu.protect.sdk.Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class c {
    public Object a;
    public Method b;
    public b c;
    public int d = 0;

    /* loaded from: classes.dex */
    public class a implements com.baidu.android.pushservice.ach.c.e.a<Object[], Object> {
        public a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.android.pushservice.ach.c.e.a
        public /* bridge */ /* synthetic */ Object a(Object[] objArr) {
            return Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15896, this, objArr);
        }

        /* renamed from: a  reason: avoid collision after fix types in other method */
        public Object a2(Object[] objArr) {
            return Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15895, this, objArr);
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(int i, Region region);
    }

    public static /* synthetic */ b a(c cVar) {
        return (b) Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15890, null, cVar);
    }

    public boolean a(b bVar) {
        return Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.z(-15889, this, bVar);
    }
}
