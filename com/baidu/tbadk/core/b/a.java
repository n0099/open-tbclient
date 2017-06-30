package com.baidu.tbadk.core.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
public abstract class a {
    public BdUniqueId Sl;
    public HttpResponsedMessage Sm;

    private a() {
    }

    /* synthetic */ a(a aVar) {
        this();
    }

    /* renamed from: com.baidu.tbadk.core.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0038a extends a {
        public long channelId;

        public C0038a() {
            super(null);
        }

        public static C0038a a(long j, BdUniqueId bdUniqueId) {
            C0038a c0038a = new C0038a();
            c0038a.channelId = j;
            c0038a.Sl = bdUniqueId;
            return c0038a;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends a {
        public long channelId;

        public c() {
            super(null);
        }

        public static c b(long j, BdUniqueId bdUniqueId) {
            c cVar = new c();
            cVar.channelId = j;
            cVar.Sl = bdUniqueId;
            return cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends a {
        public boolean Sn;
        public long channelId;
        public boolean isOpen;

        public b() {
            super(null);
        }

        public static b a(long j, boolean z, BdUniqueId bdUniqueId) {
            b bVar = new b();
            bVar.channelId = j;
            bVar.Sl = bdUniqueId;
            bVar.isOpen = z;
            return bVar;
        }
    }
}
