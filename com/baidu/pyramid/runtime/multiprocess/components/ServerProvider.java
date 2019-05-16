package com.baidu.pyramid.runtime.multiprocess.components;

import com.baidu.pyramid.runtime.multiprocess.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ServerProvider extends DispatchableContentProvider {
    public static String uQ() {
        return e.getAppContext().getPackageName() + ".provider.ipc.server";
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected String getAuthority() {
        return uQ();
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected List<a> uO() {
        List<a> cV = com.baidu.pyramid.runtime.multiprocess.a.a.cV(getAuthority());
        if (cV == null) {
            cV = new ArrayList<>();
        }
        cV.add(0, new com.baidu.pyramid.runtime.multiprocess.internal.a());
        return cV;
    }
}
