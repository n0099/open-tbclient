package com.baidu.pyramid.runtime.multiprocess.components;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class ServerProvider extends DispatchableContentProvider {
    public static String vd() {
        return "com.baidu.tieba.provider.ipc.server";
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected String getAuthority() {
        return vd();
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected List<a> vc() {
        List<a> du = com.baidu.pyramid.runtime.multiprocess.a.a.du(getAuthority());
        if (du == null) {
            du = new ArrayList<>();
        }
        du.add(0, new com.baidu.pyramid.runtime.multiprocess.internal.a());
        return du;
    }
}
