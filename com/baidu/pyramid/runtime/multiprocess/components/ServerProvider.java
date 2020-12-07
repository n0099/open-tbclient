package com.baidu.pyramid.runtime.multiprocess.components;

import com.baidu.pyramid.runtime.multiprocess.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class ServerProvider extends DispatchableContentProvider {
    public static String afY() {
        return e.getAppContext().getPackageName() + ".provider.ipc.server";
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected String afV() {
        return afY();
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected List<a> afW() {
        List<a> ku = com.baidu.pyramid.runtime.multiprocess.a.a.ku(afV());
        if (ku == null) {
            ku = new ArrayList<>();
        }
        ku.add(0, new com.baidu.pyramid.runtime.multiprocess.internal.a());
        return ku;
    }
}
