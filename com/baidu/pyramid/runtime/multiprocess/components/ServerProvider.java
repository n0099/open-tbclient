package com.baidu.pyramid.runtime.multiprocess.components;

import com.baidu.pyramid.runtime.multiprocess.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class ServerProvider extends DispatchableContentProvider {
    public static String Zf() {
        return e.getAppContext().getPackageName() + ".provider.ipc.server";
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected String Zc() {
        return Zf();
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected List<a> Zd() {
        List<a> jn = com.baidu.pyramid.runtime.multiprocess.a.a.jn(Zc());
        if (jn == null) {
            jn = new ArrayList<>();
        }
        jn.add(0, new com.baidu.pyramid.runtime.multiprocess.internal.a());
        return jn;
    }
}
