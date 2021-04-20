package com.baidu.platform.base;

import com.baidu.mapapi.search.core.SearchResult;
/* loaded from: classes2.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f9374a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchResult f9375b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f9376c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f9377d;

    public c(a aVar, d dVar, SearchResult searchResult, Object obj) {
        this.f9377d = aVar;
        this.f9374a = dVar;
        this.f9375b = searchResult;
        this.f9376c = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f9374a != null) {
            this.f9377d.f9366a.lock();
            try {
                this.f9374a.a(this.f9375b, this.f9376c);
            } finally {
                this.f9377d.f9366a.unlock();
            }
        }
    }
}
