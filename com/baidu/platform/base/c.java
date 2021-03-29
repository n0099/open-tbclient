package com.baidu.platform.base;

import com.baidu.mapapi.search.core.SearchResult;
/* loaded from: classes2.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f9816a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchResult f9817b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f9818c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f9819d;

    public c(a aVar, d dVar, SearchResult searchResult, Object obj) {
        this.f9819d = aVar;
        this.f9816a = dVar;
        this.f9817b = searchResult;
        this.f9818c = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f9816a != null) {
            this.f9819d.f9808a.lock();
            try {
                this.f9816a.a(this.f9817b, this.f9818c);
            } finally {
                this.f9819d.f9808a.unlock();
            }
        }
    }
}
