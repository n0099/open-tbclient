package com.baidu.pyramid.runtime.multiprocess.components;

import com.baidu.pyramid.runtime.multiprocess.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class ServerProvider extends DispatchableContentProvider {
    public static String aes() {
        return e.getAppContext().getPackageName() + ".provider.ipc.server";
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected String aep() {
        return aes();
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected List<a> aeq() {
        List<a> jt = com.baidu.pyramid.runtime.multiprocess.a.a.jt(aep());
        if (jt == null) {
            jt = new ArrayList<>();
        }
        jt.add(0, new com.baidu.pyramid.runtime.multiprocess.internal.a());
        return jt;
    }
}
