package com.baidu.pyramid.runtime.multiprocess.components;

import com.baidu.pyramid.runtime.multiprocess.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ServerProvider extends DispatchableContentProvider {
    public static String Ap() {
        return e.getAppContext().getPackageName() + ".provider.ipc.server";
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected String Am() {
        return Ap();
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected List<a> An() {
        List<a> dL = com.baidu.pyramid.runtime.multiprocess.a.a.dL(Am());
        if (dL == null) {
            dL = new ArrayList<>();
        }
        dL.add(0, new com.baidu.pyramid.runtime.multiprocess.internal.a());
        return dL;
    }
}
