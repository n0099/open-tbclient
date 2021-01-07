package com.baidu.pyramid.runtime.multiprocess.components;

import com.baidu.pyramid.runtime.multiprocess.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class ServerProvider extends DispatchableContentProvider {
    public static String ahV() {
        return e.getAppContext().getPackageName() + ".provider.ipc.server";
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected String ahS() {
        return ahV();
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected List<a> ahT() {
        List<a> kn = com.baidu.pyramid.runtime.multiprocess.a.a.kn(ahS());
        if (kn == null) {
            kn = new ArrayList<>();
        }
        kn.add(0, new com.baidu.pyramid.runtime.multiprocess.internal.a());
        return kn;
    }
}
