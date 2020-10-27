package com.baidu.pyramid.runtime.multiprocess.components;

import com.baidu.pyramid.runtime.multiprocess.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class ServerProvider extends DispatchableContentProvider {
    public static String aaY() {
        return e.getAppContext().getPackageName() + ".provider.ipc.server";
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected String aaV() {
        return aaY();
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected List<a> aaW() {
        List<a> jG = com.baidu.pyramid.runtime.multiprocess.a.a.jG(aaV());
        if (jG == null) {
            jG = new ArrayList<>();
        }
        jG.add(0, new com.baidu.pyramid.runtime.multiprocess.internal.a());
        return jG;
    }
}
