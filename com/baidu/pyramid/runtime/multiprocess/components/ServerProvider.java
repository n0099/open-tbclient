package com.baidu.pyramid.runtime.multiprocess.components;

import com.baidu.pyramid.runtime.multiprocess.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ServerProvider extends DispatchableContentProvider {
    public static String Pi() {
        return e.getAppContext().getPackageName() + ".provider.ipc.server";
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected String Pf() {
        return Pi();
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected List<a> Pg() {
        List<a> gR = com.baidu.pyramid.runtime.multiprocess.a.a.gR(Pf());
        if (gR == null) {
            gR = new ArrayList<>();
        }
        gR.add(0, new com.baidu.pyramid.runtime.multiprocess.internal.a());
        return gR;
    }
}
