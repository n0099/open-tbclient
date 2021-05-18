package com.baidu.platform.base;

import com.baidu.mapapi.search.core.SearchResult;
/* loaded from: classes2.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f9347a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchResult f9348b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f9349c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f9350d;

    public c(a aVar, d dVar, SearchResult searchResult, Object obj) {
        this.f9350d = aVar;
        this.f9347a = dVar;
        this.f9348b = searchResult;
        this.f9349c = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f9347a != null) {
            this.f9350d.f9338a.lock();
            try {
                this.f9347a.a(this.f9348b, this.f9349c);
            } finally {
                this.f9350d.f9338a.unlock();
            }
        }
    }
}
