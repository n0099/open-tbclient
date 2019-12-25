package com.baidu.pyramid.runtime.multiprocess.components;

import com.baidu.pyramid.runtime.multiprocess.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ServerProvider extends DispatchableContentProvider {
    public static String Cn() {
        return e.getAppContext().getPackageName() + ".provider.ipc.server";
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected String Ck() {
        return Cn();
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected List<a> Cl() {
        List<a> eC = com.baidu.pyramid.runtime.multiprocess.a.a.eC(Ck());
        if (eC == null) {
            eC = new ArrayList<>();
        }
        eC.add(0, new com.baidu.pyramid.runtime.multiprocess.internal.a());
        return eC;
    }
}
