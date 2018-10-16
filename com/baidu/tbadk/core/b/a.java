package com.baidu.tbadk.core.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
public abstract class a {
    public BdUniqueId aks;
    public HttpResponsedMessage akt;

    private a() {
    }

    /* renamed from: com.baidu.tbadk.core.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0122a extends a {
        public long channelId;

        public C0122a() {
            super();
        }

        public static C0122a a(long j, BdUniqueId bdUniqueId) {
            C0122a c0122a = new C0122a();
            c0122a.channelId = j;
            c0122a.aks = bdUniqueId;
            return c0122a;
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
            cVar.aks = bdUniqueId;
            return cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends a {
        public boolean aku;
        public long channelId;
        public boolean isOpen;

        public b() {
            super();
        }

        public static b a(long j, boolean z, BdUniqueId bdUniqueId) {
            b bVar = new b();
            bVar.channelId = j;
            bVar.aks = bdUniqueId;
            bVar.isOpen = z;
            return bVar;
        }
    }
}
