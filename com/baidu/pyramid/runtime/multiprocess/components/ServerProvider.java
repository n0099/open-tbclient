package com.baidu.pyramid.runtime.multiprocess.components;

import com.baidu.pyramid.runtime.multiprocess.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ServerProvider extends DispatchableContentProvider {
    public static String Qo() {
        return e.getAppContext().getPackageName() + ".provider.ipc.server";
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected String Ql() {
        return Qo();
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected List<a> Qm() {
        List<a> gZ = com.baidu.pyramid.runtime.multiprocess.a.a.gZ(Ql());
        if (gZ == null) {
            gZ = new ArrayList<>();
        }
        gZ.add(0, new com.baidu.pyramid.runtime.multiprocess.internal.a());
        return gZ;
    }
}
