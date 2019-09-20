package com.baidu.tbadk.core.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
public abstract class a {
    public BdUniqueId bEH;
    public HttpResponsedMessage bEI;

    private a() {
    }

    /* renamed from: com.baidu.tbadk.core.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0249a extends a {
        public long channelId;

        public C0249a() {
            super();
        }

        public static C0249a a(long j, BdUniqueId bdUniqueId) {
            C0249a c0249a = new C0249a();
            c0249a.channelId = j;
            c0249a.bEH = bdUniqueId;
            return c0249a;
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
            cVar.bEH = bdUniqueId;
            return cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends a {
        public boolean bEJ;
        public long channelId;
        public boolean isOpen;

        public b() {
            super();
        }

        public static b a(long j, boolean z, BdUniqueId bdUniqueId) {
            b bVar = new b();
            bVar.channelId = j;
            bVar.bEH = bdUniqueId;
            bVar.isOpen = z;
            return bVar;
        }
    }
}
