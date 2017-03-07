package com.baidu.tbadk.core.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
public abstract class a {
    public BdUniqueId SQ;
    public HttpResponsedMessage SR;

    private a() {
    }

    /* synthetic */ a(a aVar) {
        this();
    }

    /* renamed from: com.baidu.tbadk.core.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0032a extends a {
        public long channelId;

        public C0032a() {
            super(null);
        }

        public static C0032a a(long j, BdUniqueId bdUniqueId) {
            C0032a c0032a = new C0032a();
            c0032a.channelId = j;
            c0032a.SQ = bdUniqueId;
            return c0032a;
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
            cVar.SQ = bdUniqueId;
            return cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends a {
        public boolean SS;
        public long channelId;
        public boolean isOpen;

        public b() {
            super(null);
        }

        public static b a(long j, boolean z, BdUniqueId bdUniqueId) {
            b bVar = new b();
            bVar.channelId = j;
            bVar.SQ = bdUniqueId;
            bVar.isOpen = z;
            return bVar;
        }
    }
}
