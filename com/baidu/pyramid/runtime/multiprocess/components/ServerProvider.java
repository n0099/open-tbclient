package com.baidu.pyramid.runtime.multiprocess.components;

import com.baidu.pyramid.runtime.multiprocess.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes14.dex */
public class ServerProvider extends DispatchableContentProvider {
    public static String aev() {
        return e.getAppContext().getPackageName() + ".provider.ipc.server";
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected String aes() {
        return aev();
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected List<a> aet() {
        List<a> jA = com.baidu.pyramid.runtime.multiprocess.a.a.jA(aes());
        if (jA == null) {
            jA = new ArrayList<>();
        }
        jA.add(0, new com.baidu.pyramid.runtime.multiprocess.internal.a());
        return jA;
    }
}
