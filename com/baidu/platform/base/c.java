package com.baidu.platform.base;

import com.baidu.mapapi.search.core.SearchResult;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes20.dex */
public class c implements Runnable {
    final /* synthetic */ d a;
    final /* synthetic */ SearchResult b;
    final /* synthetic */ Object c;
    final /* synthetic */ a d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, d dVar, SearchResult searchResult, Object obj) {
        this.d = aVar;
        this.a = dVar;
        this.b = searchResult;
        this.c = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a != null) {
            this.d.a.lock();
            try {
                this.a.a(this.b, this.c);
            } finally {
                this.d.a.unlock();
            }
        }
    }
}
