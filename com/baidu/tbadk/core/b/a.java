package com.baidu.tbadk.core.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
public abstract class a {
    public BdUniqueId Ub;
    public HttpResponsedMessage Uc;

    private a() {
    }

    /* renamed from: com.baidu.tbadk.core.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0041a extends a {
        public long channelId;

        public C0041a() {
            super();
        }

        public static C0041a a(long j, BdUniqueId bdUniqueId) {
            C0041a c0041a = new C0041a();
            c0041a.channelId = j;
            c0041a.Ub = bdUniqueId;
            return c0041a;
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
            cVar.Ub = bdUniqueId;
            return cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends a {
        public boolean Ud;
        public long channelId;
        public boolean isOpen;

        public b() {
            super();
        }

        public static b a(long j, boolean z, BdUniqueId bdUniqueId) {
            b bVar = new b();
            bVar.channelId = j;
            bVar.Ub = bdUniqueId;
            bVar.isOpen = z;
            return bVar;
        }
    }
}
