package com.baidu.platform.base;

import com.baidu.mapapi.search.core.SearchResult;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f4174a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ SearchResult f4175b;
    final /* synthetic */ Object c;
    final /* synthetic */ a d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, d dVar, SearchResult searchResult, Object obj) {
        this.d = aVar;
        this.f4174a = dVar;
        this.f4175b = searchResult;
        this.c = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f4174a != null) {
            this.d.f4170a.lock();
            try {
                this.f4174a.a(this.f4175b, this.c);
            } finally {
                this.d.f4170a.unlock();
            }
        }
    }
}
