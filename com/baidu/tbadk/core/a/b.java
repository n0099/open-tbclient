package com.baidu.tbadk.core.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.s;
/* loaded from: classes.dex */
public class b extends CustomMessageListener {
    private static b a = null;
    private s<byte[]> A;
    private s<String> b;
    private s<String> c;
    private s<String> d;
    private s<String> e;
    private s<String> f;
    private s<String> g;
    private s<String> h;
    private s<String> i;
    private s<String> j;
    private s<String> k;
    private s<String> l;
    private s<byte[]> m;
    private s<byte[]> n;
    private s<byte[]> o;
    private s<byte[]> p;
    private s<byte[]> q;
    private s<String> r;
    private s<byte[]> s;
    private s<String> t;
    private s<String> u;
    private s<String> v;
    private s<String> w;
    private s<byte[]> x;
    private s<String> y;
    private s<String> z;

    public static b a() {
        if (a == null) {
            a = new b();
        }
        return a;
    }

    private b() {
        super(2002998);
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        MessageManager.getInstance().registerListenerFromBackground(this);
    }

    public s<String> b() {
        if (this.b == null) {
            this.b = BdCacheService.c().a("tb.pb_mark", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 50);
        }
        return this.b;
    }

    public s<String> c() {
        if (this.d == null) {
            this.d = BdCacheService.c().a("tb.pb_normal", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 1);
        }
        return this.d;
    }

    public s<String> d() {
        if (this.c == null) {
            this.c = BdCacheService.c().a("tb.pb_editor", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 50);
        }
        return this.c;
    }

    public s<byte[]> e() {
        if (this.m == null) {
            this.m = BdCacheService.c().b("tb.im_frsgroup", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 50);
        }
        return this.m;
    }

    public s<byte[]> f() {
        if (this.n == null) {
            this.n = BdCacheService.c().b("tb.live_hotlist", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 20);
        }
        return this.n;
    }

    public s<byte[]> g() {
        if (this.o == null) {
            this.o = BdCacheService.c().b("tb.live_hotlist", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 20);
        }
        return this.o;
    }

    public s<byte[]> h() {
        if (this.x == null) {
            this.x = BdCacheService.c().b("tb.im_hotgroup", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 30);
        }
        return this.x;
    }

    public s<String> i() {
        if (this.e == null) {
            this.e = BdCacheService.c().a("tb.my_pages", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 5);
        }
        return this.e;
    }

    public s<String> j() {
        if (this.r == null) {
            this.r = BdCacheService.c().a("tb.im_group_search_history", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 50);
        }
        return this.r;
    }

    public void k() {
        if (this.r != null) {
            BdCacheService.c().a(this.r);
            this.r = null;
        }
    }

    public s<String> l() {
        if (this.f == null) {
            this.f = BdCacheService.c().a("tb.my_pages", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 5);
        }
        return this.f;
    }

    public s<String> m() {
        if (this.g == null) {
            this.g = BdCacheService.c().a("tb.my_pages", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 5);
        }
        return this.g;
    }

    public s<String> n() {
        if (this.h == null) {
            this.h = BdCacheService.c().a("tb.my_bookmarks", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 3);
        }
        return this.h;
    }

    public s<String> o() {
        if (this.i == null) {
            this.i = BdCacheService.c().a("tb.my_posts", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 3);
        }
        return this.i;
    }

    public s<String> p() {
        if (this.j == null) {
            this.j = BdCacheService.c().a("tb.my_forums", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 3);
        }
        return this.j;
    }

    public s<String> q() {
        if (this.k == null) {
            this.k = BdCacheService.c().a("tb.square", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.NO_EVICT, 1);
        }
        return this.k;
    }

    public s<String> r() {
        if (this.l == null) {
            this.l = BdCacheService.c().a("tb.first_dir", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.NO_EVICT, 1);
        }
        return this.l;
    }

    public s<byte[]> s() {
        if (this.p == null) {
            this.p = BdCacheService.c().b("tb.im_groupinfo", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 50);
        }
        return this.p;
    }

    public s<byte[]> t() {
        if (this.q == null) {
            this.q = BdCacheService.c().b("tb.im_groupactivity", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 50);
        }
        return this.p;
    }

    public s<byte[]> u() {
        if (this.s == null) {
            this.s = BdCacheService.c().b("tb.im_entergroup", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 10);
        }
        return this.s;
    }

    public s<byte[]> v() {
        if (this.s == null) {
            this.s = BdCacheService.c().b("tb.im_enterforum_groupinfo", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 10);
        }
        return this.s;
    }

    public s<String> w() {
        if (this.t == null) {
            this.t = BdCacheService.c().a("tb.im_group_setting", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.NO_EVICT, 3);
        }
        return this.t;
    }

    public s<String> x() {
        if (this.u == null) {
            this.u = BdCacheService.c().a("tb.im_personal_chat_setting", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.NO_EVICT, 3);
        }
        return this.u;
    }

    public s<String> y() {
        if (this.v == null) {
            this.v = BdCacheService.c().a("tb.im_official_chat_setting", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.NO_EVICT, 3);
        }
        return this.v;
    }

    public s<String> z() {
        if (this.w == null) {
            this.w = BdCacheService.c().a("tb.pic_gif", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 50);
        }
        return this.w;
    }

    public s<String> A() {
        if (this.z == null) {
            this.z = BdCacheService.c().a("tb_face_package", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 30);
        }
        return this.z;
    }

    public s<byte[]> B() {
        if (this.A == null) {
            this.A = BdCacheService.c().b("tb.im_official_history", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 50);
        }
        return this.A;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
    }
}
