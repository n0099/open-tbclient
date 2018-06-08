package com.baidu.tbadk.core.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
public abstract class a {
    public BdUniqueId ada;
    public HttpResponsedMessage adb;

    private a() {
    }

    /* renamed from: com.baidu.tbadk.core.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0101a extends a {
        public long channelId;

        public C0101a() {
            super();
        }

        public static C0101a a(long j, BdUniqueId bdUniqueId) {
            C0101a c0101a = new C0101a();
            c0101a.channelId = j;
            c0101a.ada = bdUniqueId;
            return c0101a;
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
            cVar.ada = bdUniqueId;
            return cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends a {
        public boolean adc;
        public long channelId;
        public boolean isOpen;

        public b() {
            super();
        }

        public static b a(long j, boolean z, BdUniqueId bdUniqueId) {
            b bVar = new b();
            bVar.channelId = j;
            bVar.ada = bdUniqueId;
            bVar.isOpen = z;
            return bVar;
        }
    }
}
