package com.baidu.tbadk.core.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
public abstract class a {
    public BdUniqueId bVH;
    public HttpResponsedMessage bVI;

    private a() {
    }

    /* renamed from: com.baidu.tbadk.core.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0276a extends a {
        public long channelId;

        public C0276a() {
            super();
        }

        public static C0276a a(long j, BdUniqueId bdUniqueId) {
            C0276a c0276a = new C0276a();
            c0276a.channelId = j;
            c0276a.bVH = bdUniqueId;
            return c0276a;
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
            cVar.bVH = bdUniqueId;
            return cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends a {
        public boolean bVJ;
        public long channelId;
        public boolean isOpen;

        public b() {
            super();
        }

        public static b a(long j, boolean z, BdUniqueId bdUniqueId) {
            b bVar = new b();
            bVar.channelId = j;
            bVar.bVH = bdUniqueId;
            bVar.isOpen = z;
            return bVar;
        }
    }
}
