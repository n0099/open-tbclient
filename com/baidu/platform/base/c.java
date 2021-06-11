package com.baidu.platform.base;

import com.baidu.mapapi.search.core.SearchResult;
/* loaded from: classes2.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f9304a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchResult f9305b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f9306c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f9307d;

    public c(a aVar, d dVar, SearchResult searchResult, Object obj) {
        this.f9307d = aVar;
        this.f9304a = dVar;
        this.f9305b = searchResult;
        this.f9306c = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f9304a != null) {
            this.f9307d.f9295a.lock();
            try {
                this.f9304a.a(this.f9305b, this.f9306c);
            } finally {
                this.f9307d.f9295a.unlock();
            }
        }
    }
}
