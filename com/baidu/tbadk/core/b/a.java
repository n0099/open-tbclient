package com.baidu.tbadk.core.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
public abstract class a {
    public BdUniqueId acU;
    public HttpResponsedMessage acV;

    private a() {
    }

    /* renamed from: com.baidu.tbadk.core.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0099a extends a {
        public long channelId;

        public C0099a() {
            super();
        }

        public static C0099a a(long j, BdUniqueId bdUniqueId) {
            C0099a c0099a = new C0099a();
            c0099a.channelId = j;
            c0099a.acU = bdUniqueId;
            return c0099a;
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
            cVar.acU = bdUniqueId;
            return cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends a {
        public boolean acW;
        public long channelId;
        public boolean isOpen;

        public b() {
            super();
        }

        public static b a(long j, boolean z, BdUniqueId bdUniqueId) {
            b bVar = new b();
            bVar.channelId = j;
            bVar.acU = bdUniqueId;
            bVar.isOpen = z;
            return bVar;
        }
    }
}
