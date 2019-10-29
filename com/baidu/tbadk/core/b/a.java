package com.baidu.tbadk.core.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
public abstract class a {
    public BdUniqueId bWy;
    public HttpResponsedMessage bWz;

    private a() {
    }

    /* renamed from: com.baidu.tbadk.core.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0281a extends a {
        public long channelId;

        public C0281a() {
            super();
        }

        public static C0281a a(long j, BdUniqueId bdUniqueId) {
            C0281a c0281a = new C0281a();
            c0281a.channelId = j;
            c0281a.bWy = bdUniqueId;
            return c0281a;
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
            cVar.bWy = bdUniqueId;
            return cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends a {
        public boolean bWA;
        public long channelId;
        public boolean isOpen;

        public b() {
            super();
        }

        public static b a(long j, boolean z, BdUniqueId bdUniqueId) {
            b bVar = new b();
            bVar.channelId = j;
            bVar.bWy = bdUniqueId;
            bVar.isOpen = z;
            return bVar;
        }
    }
}
