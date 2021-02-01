package com.baidu.platform.base;

import com.baidu.mapapi.search.core.SearchResult;
/* loaded from: classes4.dex */
class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f4140a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ SearchResult f4141b;
    final /* synthetic */ Object c;
    final /* synthetic */ a d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, d dVar, SearchResult searchResult, Object obj) {
        this.d = aVar;
        this.f4140a = dVar;
        this.f4141b = searchResult;
        this.c = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f4140a != null) {
            this.d.f4136a.lock();
            try {
                this.f4140a.a(this.f4141b, this.c);
            } finally {
                this.d.f4136a.unlock();
            }
        }
    }
}
