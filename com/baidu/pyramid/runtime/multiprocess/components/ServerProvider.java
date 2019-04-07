package com.baidu.pyramid.runtime.multiprocess.components;

import com.baidu.pyramid.runtime.multiprocess.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ServerProvider extends DispatchableContentProvider {
    public static String uf() {
        return f.getAppContext().getPackageName() + ".provider.ipc.server";
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected String getAuthority() {
        return uf();
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected List<a> ud() {
        List<a> di = com.baidu.pyramid.runtime.multiprocess.a.a.di(getAuthority());
        if (di == null) {
            di = new ArrayList<>();
        }
        di.add(0, new com.baidu.pyramid.runtime.multiprocess.internal.a());
        return di;
    }
}
