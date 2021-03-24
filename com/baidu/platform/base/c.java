package com.baidu.platform.base;

import com.baidu.mapapi.search.core.SearchResult;
/* loaded from: classes2.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f9815a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchResult f9816b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f9817c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f9818d;

    public c(a aVar, d dVar, SearchResult searchResult, Object obj) {
        this.f9818d = aVar;
        this.f9815a = dVar;
        this.f9816b = searchResult;
        this.f9817c = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f9815a != null) {
            this.f9818d.f9807a.lock();
            try {
                this.f9815a.a(this.f9816b, this.f9817c);
            } finally {
                this.f9818d.f9807a.unlock();
            }
        }
    }
}
