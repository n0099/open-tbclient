package com.baidu.platform.comapi.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes3.dex */
public class a {
    private final Map<Class<?>, CopyOnWriteArraySet<C0294a>> c = new HashMap();
    private final Map<Class<?>, Object> d = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private static final String f4380b = a.class.getName();

    /* renamed from: a  reason: collision with root package name */
    public static final a f4379a = new a();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.platform.comapi.util.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0294a implements b {

        /* renamed from: a  reason: collision with root package name */
        private final b f4383a;

        @Override // com.baidu.platform.comapi.util.a.b
        public void a(Object obj) {
            this.f4383a.a(obj);
        }

        public boolean equals(Object obj) {
            return this.f4383a.equals(obj);
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(Object obj);
    }

    private a() {
    }

    public static a a() {
        return f4379a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar, Object obj) {
        bVar.a(obj);
    }

    public void a(Object obj) {
        CopyOnWriteArraySet<C0294a> copyOnWriteArraySet;
        if (this.c.containsKey(obj.getClass())) {
            synchronized (this) {
                copyOnWriteArraySet = this.c.get(obj.getClass());
            }
            Iterator<C0294a> it = copyOnWriteArraySet.iterator();
            while (it.hasNext()) {
                j.a(new com.baidu.platform.comapi.util.b(this, it.next(), obj), 0L);
            }
        }
    }
}
