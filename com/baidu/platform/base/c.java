package com.baidu.platform.base;

import com.baidu.mapapi.search.core.SearchResult;
/* loaded from: classes2.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f9247a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchResult f9248b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f9249c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f9250d;

    public c(a aVar, d dVar, SearchResult searchResult, Object obj) {
        this.f9250d = aVar;
        this.f9247a = dVar;
        this.f9248b = searchResult;
        this.f9249c = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f9247a != null) {
            this.f9250d.f9238a.lock();
            try {
                this.f9247a.a(this.f9248b, this.f9249c);
            } finally {
                this.f9250d.f9238a.unlock();
            }
        }
    }
}
