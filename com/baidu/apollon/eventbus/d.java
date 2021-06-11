package com.baidu.apollon.eventbus;

import com.baidu.apollon.eventbus.EventBus;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public EventBus.Event f3718a;

    /* renamed from: b  reason: collision with root package name */
    public g f3719b;

    public d(EventBus.Event event, g gVar) {
        this.f3718a = event;
        this.f3719b = gVar;
    }

    public static d a(g gVar, EventBus.Event event) {
        return new d(event, gVar);
    }
}
