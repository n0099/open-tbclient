package com.baidu.platform.comapi.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes20.dex */
public class a {
    private final Map<Class<?>, CopyOnWriteArraySet<C0246a>> c = new HashMap();
    private final Map<Class<?>, Object> d = new HashMap();
    private static final String b = a.class.getName();
    public static final a a = new a();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.platform.comapi.util.a$a  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public class C0246a implements b {
        private final b a;

        @Override // com.baidu.platform.comapi.util.a.b
        public void a(Object obj) {
            this.a.a(obj);
        }

        public boolean equals(Object obj) {
            return this.a.equals(obj);
        }
    }

    /* loaded from: classes20.dex */
    public interface b {
        void a(Object obj);
    }

    private a() {
    }

    public static a a() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar, Object obj) {
        bVar.a(obj);
    }

    public void a(Object obj) {
        CopyOnWriteArraySet<C0246a> copyOnWriteArraySet;
        if (this.c.containsKey(obj.getClass())) {
            synchronized (this) {
                copyOnWriteArraySet = this.c.get(obj.getClass());
            }
            Iterator<C0246a> it = copyOnWriteArraySet.iterator();
            while (it.hasNext()) {
                j.a(new com.baidu.platform.comapi.util.b(this, it.next(), obj), 0L);
            }
        }
    }
}
