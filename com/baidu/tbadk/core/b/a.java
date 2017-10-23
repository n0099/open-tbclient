package com.baidu.tbadk.core.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
public abstract class a {
    public BdUniqueId Tf;
    public HttpResponsedMessage Tg;

    private a() {
    }

    /* renamed from: com.baidu.tbadk.core.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0045a extends a {
        public long channelId;

        public C0045a() {
            super();
        }

        public static C0045a a(long j, BdUniqueId bdUniqueId) {
            C0045a c0045a = new C0045a();
            c0045a.channelId = j;
            c0045a.Tf = bdUniqueId;
            return c0045a;
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
            cVar.Tf = bdUniqueId;
            return cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends a {
        public boolean Th;
        public long channelId;
        public boolean isOpen;

        public b() {
            super();
        }

        public static b a(long j, boolean z, BdUniqueId bdUniqueId) {
            b bVar = new b();
            bVar.channelId = j;
            bVar.Tf = bdUniqueId;
            bVar.isOpen = z;
            return bVar;
        }
    }
}
