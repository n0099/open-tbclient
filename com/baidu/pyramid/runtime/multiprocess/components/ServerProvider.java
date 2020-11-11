package com.baidu.pyramid.runtime.multiprocess.components;

import com.baidu.pyramid.runtime.multiprocess.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class ServerProvider extends DispatchableContentProvider {
    public static String adx() {
        return e.getAppContext().getPackageName() + ".provider.ipc.server";
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected String adu() {
        return adx();
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected List<a> adv() {
        List<a> jT = com.baidu.pyramid.runtime.multiprocess.a.a.jT(adu());
        if (jT == null) {
            jT = new ArrayList<>();
        }
        jT.add(0, new com.baidu.pyramid.runtime.multiprocess.internal.a());
        return jT;
    }
}
