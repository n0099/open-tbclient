package com.baidu.tbadk.core.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
public abstract class a {
    public BdUniqueId aIC;
    public HttpResponsedMessage aID;

    private a() {
    }

    /* renamed from: com.baidu.tbadk.core.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0071a extends a {
        public long channelId;

        public C0071a() {
            super();
        }

        public static C0071a a(long j, BdUniqueId bdUniqueId) {
            C0071a c0071a = new C0071a();
            c0071a.channelId = j;
            c0071a.aIC = bdUniqueId;
            return c0071a;
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
            cVar.aIC = bdUniqueId;
            return cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends a {
        public boolean aIE;
        public long channelId;
        public boolean isOpen;

        public b() {
            super();
        }

        public static b a(long j, boolean z, BdUniqueId bdUniqueId) {
            b bVar = new b();
            bVar.channelId = j;
            bVar.aIC = bdUniqueId;
            bVar.isOpen = z;
            return bVar;
        }
    }
}
