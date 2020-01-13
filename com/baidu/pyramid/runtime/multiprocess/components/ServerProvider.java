package com.baidu.pyramid.runtime.multiprocess.components;

import com.baidu.pyramid.runtime.multiprocess.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ServerProvider extends DispatchableContentProvider {
    public static String CJ() {
        return e.getAppContext().getPackageName() + ".provider.ipc.server";
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected String CG() {
        return CJ();
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected List<a> CH() {
        List<a> eF = com.baidu.pyramid.runtime.multiprocess.a.a.eF(CG());
        if (eF == null) {
            eF = new ArrayList<>();
        }
        eF.add(0, new com.baidu.pyramid.runtime.multiprocess.internal.a());
        return eF;
    }
}
