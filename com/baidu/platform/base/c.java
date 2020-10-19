package com.baidu.platform.base;

import com.baidu.mapapi.search.core.SearchResult;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f2812a;
    final /* synthetic */ SearchResult b;
    final /* synthetic */ Object c;
    final /* synthetic */ a d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, d dVar, SearchResult searchResult, Object obj) {
        this.d = aVar;
        this.f2812a = dVar;
        this.b = searchResult;
        this.c = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f2812a != null) {
            this.d.f2810a.lock();
            try {
                this.f2812a.a(this.b, this.c);
            } finally {
                this.d.f2810a.unlock();
            }
        }
    }
}
