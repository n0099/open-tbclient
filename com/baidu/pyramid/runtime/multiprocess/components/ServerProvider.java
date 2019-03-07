package com.baidu.pyramid.runtime.multiprocess.components;

import com.baidu.pyramid.runtime.multiprocess.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ServerProvider extends DispatchableContentProvider {
    public static String ug() {
        return f.getAppContext().getPackageName() + ".provider.ipc.server";
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected String getAuthority() {
        return ug();
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected List<a> ue() {
        List<a> dg = com.baidu.pyramid.runtime.multiprocess.a.a.dg(getAuthority());
        if (dg == null) {
            dg = new ArrayList<>();
        }
        dg.add(0, new com.baidu.pyramid.runtime.multiprocess.internal.a());
        return dg;
    }
}
