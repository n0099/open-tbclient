package com.baidu.tbadk.core.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
public abstract class a {
    public BdUniqueId NM;
    public HttpResponsedMessage NN;

    private a() {
    }

    /* synthetic */ a(a aVar) {
        this();
    }

    /* renamed from: com.baidu.tbadk.core.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0033a extends a {
        public long channelId;

        public C0033a() {
            super(null);
        }

        public static C0033a a(long j, BdUniqueId bdUniqueId) {
            C0033a c0033a = new C0033a();
            c0033a.channelId = j;
            c0033a.NM = bdUniqueId;
            return c0033a;
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
            cVar.NM = bdUniqueId;
            return cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends a {
        public long channelId;
        public boolean isOpen;

        public b() {
            super(null);
        }

        public static b a(long j, boolean z, BdUniqueId bdUniqueId) {
            b bVar = new b();
            bVar.channelId = j;
            bVar.NM = bdUniqueId;
            bVar.isOpen = z;
            return bVar;
        }
    }
}
