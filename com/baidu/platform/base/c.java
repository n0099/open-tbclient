package com.baidu.platform.base;

import com.baidu.mapapi.search.core.SearchResult;
/* loaded from: classes2.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f9312a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchResult f9313b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f9314c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f9315d;

    public c(a aVar, d dVar, SearchResult searchResult, Object obj) {
        this.f9315d = aVar;
        this.f9312a = dVar;
        this.f9313b = searchResult;
        this.f9314c = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f9312a != null) {
            this.f9315d.f9303a.lock();
            try {
                this.f9312a.a(this.f9313b, this.f9314c);
            } finally {
                this.f9315d.f9303a.unlock();
            }
        }
    }
}
