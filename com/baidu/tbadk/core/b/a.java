package com.baidu.tbadk.core.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
public abstract class a {
    public BdUniqueId Ti;
    public HttpResponsedMessage Tj;

    private a() {
    }

    /* synthetic */ a(a aVar) {
        this();
    }

    /* renamed from: com.baidu.tbadk.core.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0031a extends a {
        public long channelId;

        public C0031a() {
            super(null);
        }

        public static C0031a a(long j, BdUniqueId bdUniqueId) {
            C0031a c0031a = new C0031a();
            c0031a.channelId = j;
            c0031a.Ti = bdUniqueId;
            return c0031a;
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
            cVar.Ti = bdUniqueId;
            return cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends a {
        public boolean Tk;
        public long channelId;
        public boolean isOpen;

        public b() {
            super(null);
        }

        public static b a(long j, boolean z, BdUniqueId bdUniqueId) {
            b bVar = new b();
            bVar.channelId = j;
            bVar.Ti = bdUniqueId;
            bVar.isOpen = z;
            return bVar;
        }
    }
}
