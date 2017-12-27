package com.baidu.tbadk.core.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
public abstract class a {
    public BdUniqueId aIB;
    public HttpResponsedMessage aIC;

    private a() {
    }

    /* renamed from: com.baidu.tbadk.core.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0072a extends a {
        public long channelId;

        public C0072a() {
            super();
        }

        public static C0072a a(long j, BdUniqueId bdUniqueId) {
            C0072a c0072a = new C0072a();
            c0072a.channelId = j;
            c0072a.aIB = bdUniqueId;
            return c0072a;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends a {
        public long channelId;

        public c() {
            super();
        }

        public static c b(long j, BdUniqueId bdUniqueId) {
            c cVar = new c();
            cVar.channelId = j;
            cVar.aIB = bdUniqueId;
            return cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends a {
        public boolean aID;
        public long channelId;
        public boolean isOpen;

        public b() {
            super();
        }

        public static b a(long j, boolean z, BdUniqueId bdUniqueId) {
            b bVar = new b();
            bVar.channelId = j;
            bVar.aIB = bdUniqueId;
            bVar.isOpen = z;
            return bVar;
        }
    }
}
