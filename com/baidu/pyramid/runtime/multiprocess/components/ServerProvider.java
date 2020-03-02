package com.baidu.pyramid.runtime.multiprocess.components;

import com.baidu.pyramid.runtime.multiprocess.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ServerProvider extends DispatchableContentProvider {
    public static String Fh() {
        return e.getAppContext().getPackageName() + ".provider.ipc.server";
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected String Fe() {
        return Fh();
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected List<a> Ff() {
        List<a> eV = com.baidu.pyramid.runtime.multiprocess.a.a.eV(Fe());
        if (eV == null) {
            eV = new ArrayList<>();
        }
        eV.add(0, new com.baidu.pyramid.runtime.multiprocess.internal.a());
        return eV;
    }
}
