package com.baidu.platform.base;

import com.baidu.mapapi.search.core.SearchResult;
/* loaded from: classes6.dex */
class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f4137a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ SearchResult f4138b;
    final /* synthetic */ Object c;
    final /* synthetic */ a d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, d dVar, SearchResult searchResult, Object obj) {
        this.d = aVar;
        this.f4137a = dVar;
        this.f4138b = searchResult;
        this.c = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f4137a != null) {
            this.d.f4133a.lock();
            try {
                this.f4137a.a(this.f4138b, this.c);
            } finally {
                this.d.f4133a.unlock();
            }
        }
    }
}
