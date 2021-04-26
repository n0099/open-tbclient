package com.baidu.pyramid.runtime.multiprocess.components;

import d.a.c0.b.a.e;
import d.a.c0.b.a.i.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class ServerProvider extends DispatchableContentProvider {
    public static String getCoreProviderAuthority() {
        return e.a().getPackageName() + ".provider.ipc.server";
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    public String getAuthority() {
        return getCoreProviderAuthority();
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    public List<a> getContentProviderDelegates() {
        List<a> a2 = d.a.c0.b.a.k.a.a(getAuthority());
        if (a2 == null) {
            a2 = new ArrayList<>();
        }
        a2.add(0, new d.a.c0.b.a.j.a());
        return a2;
    }
}
