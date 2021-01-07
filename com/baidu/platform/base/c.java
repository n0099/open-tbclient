package com.baidu.platform.base;

import com.baidu.mapapi.search.core.SearchResult;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f4175a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ SearchResult f4176b;
    final /* synthetic */ Object c;
    final /* synthetic */ a d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, d dVar, SearchResult searchResult, Object obj) {
        this.d = aVar;
        this.f4175a = dVar;
        this.f4176b = searchResult;
        this.c = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f4175a != null) {
            this.d.f4171a.lock();
            try {
                this.f4175a.a(this.f4176b, this.c);
            } finally {
                this.d.f4171a.unlock();
            }
        }
    }
}
