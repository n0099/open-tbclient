package com.baidu.platform.base;

import com.baidu.mapapi.search.core.SearchResult;
/* loaded from: classes2.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f9725a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchResult f9726b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f9727c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f9728d;

    public c(a aVar, d dVar, SearchResult searchResult, Object obj) {
        this.f9728d = aVar;
        this.f9725a = dVar;
        this.f9726b = searchResult;
        this.f9727c = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f9725a != null) {
            this.f9728d.f9717a.lock();
            try {
                this.f9725a.a(this.f9726b, this.f9727c);
            } finally {
                this.f9728d.f9717a.unlock();
            }
        }
    }
}
