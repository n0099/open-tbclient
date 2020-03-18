package com.baidu.pyramid.runtime.multiprocess.components;

import com.baidu.pyramid.runtime.multiprocess.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ServerProvider extends DispatchableContentProvider {
    public static String Fm() {
        return e.getAppContext().getPackageName() + ".provider.ipc.server";
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected String Fj() {
        return Fm();
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected List<a> Fk() {
        List<a> eU = com.baidu.pyramid.runtime.multiprocess.a.a.eU(Fj());
        if (eU == null) {
            eU = new ArrayList<>();
        }
        eU.add(0, new com.baidu.pyramid.runtime.multiprocess.internal.a());
        return eU;
    }
}
