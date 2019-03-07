package com.baidu.tbadk.core.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
public abstract class a {
    public BdUniqueId bvT;
    public HttpResponsedMessage bvU;

    private a() {
    }

    /* renamed from: com.baidu.tbadk.core.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0189a extends a {
        public long channelId;

        public C0189a() {
            super();
        }

        public static C0189a a(long j, BdUniqueId bdUniqueId) {
            C0189a c0189a = new C0189a();
            c0189a.channelId = j;
            c0189a.bvT = bdUniqueId;
            return c0189a;
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
            cVar.bvT = bdUniqueId;
            return cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends a {
        public boolean bvV;
        public long channelId;
        public boolean isOpen;

        public b() {
            super();
        }

        public static b a(long j, boolean z, BdUniqueId bdUniqueId) {
            b bVar = new b();
            bVar.channelId = j;
            bVar.bvT = bdUniqueId;
            bVar.isOpen = z;
            return bVar;
        }
    }
}
