package com.baidu.pyramid.runtime.multiprocess.components;

import com.baidu.pyramid.runtime.multiprocess.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ServerProvider extends DispatchableContentProvider {
    public static String Aq() {
        return e.getAppContext().getPackageName() + ".provider.ipc.server";
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected String An() {
        return Aq();
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected List<a> Ao() {
        List<a> dL = com.baidu.pyramid.runtime.multiprocess.a.a.dL(An());
        if (dL == null) {
            dL = new ArrayList<>();
        }
        dL.add(0, new com.baidu.pyramid.runtime.multiprocess.internal.a());
        return dL;
    }
}
