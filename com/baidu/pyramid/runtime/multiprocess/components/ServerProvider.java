package com.baidu.pyramid.runtime.multiprocess.components;

import com.baidu.pyramid.runtime.multiprocess.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class ServerProvider extends DispatchableContentProvider {
    public static String acO() {
        return e.getAppContext().getPackageName() + ".provider.ipc.server";
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected String acL() {
        return acO();
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected List<a> acM() {
        List<a> jN = com.baidu.pyramid.runtime.multiprocess.a.a.jN(acL());
        if (jN == null) {
            jN = new ArrayList<>();
        }
        jN.add(0, new com.baidu.pyramid.runtime.multiprocess.internal.a());
        return jN;
    }
}
