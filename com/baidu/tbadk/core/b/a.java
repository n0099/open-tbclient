package com.baidu.tbadk.core.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
public abstract class a {
    public BdUniqueId aJU;
    public HttpResponsedMessage aJV;

    private a() {
    }

    /* renamed from: com.baidu.tbadk.core.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0094a extends a {
        public long channelId;

        public C0094a() {
            super();
        }

        public static C0094a a(long j, BdUniqueId bdUniqueId) {
            C0094a c0094a = new C0094a();
            c0094a.channelId = j;
            c0094a.aJU = bdUniqueId;
            return c0094a;
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
            cVar.aJU = bdUniqueId;
            return cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends a {
        public boolean aJW;
        public long channelId;
        public boolean isOpen;

        public b() {
            super();
        }

        public static b a(long j, boolean z, BdUniqueId bdUniqueId) {
            b bVar = new b();
            bVar.channelId = j;
            bVar.aJU = bdUniqueId;
            bVar.isOpen = z;
            return bVar;
        }
    }
}
