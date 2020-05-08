package com.baidu.pyramid.runtime.multiprocess.components;

import com.baidu.pyramid.runtime.multiprocess.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ServerProvider extends DispatchableContentProvider {
    public static String MV() {
        return e.getAppContext().getPackageName() + ".provider.ipc.server";
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected String MS() {
        return MV();
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected List<a> MT() {
        List<a> gf = com.baidu.pyramid.runtime.multiprocess.a.a.gf(MS());
        if (gf == null) {
            gf = new ArrayList<>();
        }
        gf.add(0, new com.baidu.pyramid.runtime.multiprocess.internal.a());
        return gf;
    }
}
