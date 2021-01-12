package com.baidu.pyramid.runtime.multiprocess.components;

import com.baidu.pyramid.runtime.multiprocess.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class ServerProvider extends DispatchableContentProvider {
    public static String aeb() {
        return e.getAppContext().getPackageName() + ".provider.ipc.server";
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected String adY() {
        return aeb();
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected List<a> adZ() {
        List<a> jc = com.baidu.pyramid.runtime.multiprocess.a.a.jc(adY());
        if (jc == null) {
            jc = new ArrayList<>();
        }
        jc.add(0, new com.baidu.pyramid.runtime.multiprocess.internal.a());
        return jc;
    }
}
