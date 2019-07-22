package com.baidu.pyramid.runtime.multiprocess.components;

import com.baidu.pyramid.runtime.multiprocess.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ServerProvider extends DispatchableContentProvider {
    public static String vr() {
        return e.getAppContext().getPackageName() + ".provider.ipc.server";
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected String vo() {
        return vr();
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected List<a> vp() {
        List<a> cZ = com.baidu.pyramid.runtime.multiprocess.a.a.cZ(vo());
        if (cZ == null) {
            cZ = new ArrayList<>();
        }
        cZ.add(0, new com.baidu.pyramid.runtime.multiprocess.internal.a());
        return cZ;
    }
}
