package com.baidu.pyramid.runtime.multiprocess.components;

import com.baidu.pyramid.runtime.multiprocess.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class ServerProvider extends DispatchableContentProvider {
    public static String Xi() {
        return e.getAppContext().getPackageName() + ".provider.ipc.server";
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected String Xf() {
        return Xi();
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected List<a> Xg() {
        List<a> iL = com.baidu.pyramid.runtime.multiprocess.a.a.iL(Xf());
        if (iL == null) {
            iL = new ArrayList<>();
        }
        iL.add(0, new com.baidu.pyramid.runtime.multiprocess.internal.a());
        return iL;
    }
}
