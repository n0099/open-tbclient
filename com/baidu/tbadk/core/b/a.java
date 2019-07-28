package com.baidu.tbadk.core.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
public abstract class a {
    public BdUniqueId bEi;
    public HttpResponsedMessage bEj;

    private a() {
    }

    /* renamed from: com.baidu.tbadk.core.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0240a extends a {
        public long channelId;

        public C0240a() {
            super();
        }

        public static C0240a a(long j, BdUniqueId bdUniqueId) {
            C0240a c0240a = new C0240a();
            c0240a.channelId = j;
            c0240a.bEi = bdUniqueId;
            return c0240a;
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
            cVar.bEi = bdUniqueId;
            return cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends a {
        public boolean bEk;
        public long channelId;
        public boolean isOpen;

        public b() {
            super();
        }

        public static b a(long j, boolean z, BdUniqueId bdUniqueId) {
            b bVar = new b();
            bVar.channelId = j;
            bVar.bEi = bdUniqueId;
            bVar.isOpen = z;
            return bVar;
        }
    }
}
