package com.baidu.pyramid.runtime.multiprocess.components;

import com.baidu.pyramid.runtime.multiprocess.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ServerProvider extends DispatchableContentProvider {
    public static String Ff() {
        return e.getAppContext().getPackageName() + ".provider.ipc.server";
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected String Fc() {
        return Ff();
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected List<a> Fd() {
        List<a> eV = com.baidu.pyramid.runtime.multiprocess.a.a.eV(Fc());
        if (eV == null) {
            eV = new ArrayList<>();
        }
        eV.add(0, new com.baidu.pyramid.runtime.multiprocess.internal.a());
        return eV;
    }
}
