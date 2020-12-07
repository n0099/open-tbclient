package com.baidu.platform.base;

import com.baidu.mapapi.search.core.SearchResult;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f2816a;
    final /* synthetic */ SearchResult b;
    final /* synthetic */ Object c;
    final /* synthetic */ a d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, d dVar, SearchResult searchResult, Object obj) {
        this.d = aVar;
        this.f2816a = dVar;
        this.b = searchResult;
        this.c = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f2816a != null) {
            this.d.f2814a.lock();
            try {
                this.f2816a.a(this.b, this.c);
            } finally {
                this.d.f2814a.unlock();
            }
        }
    }
}
