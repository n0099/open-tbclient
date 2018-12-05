package com.baidu.pyramid.runtime.multiprocess.components;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class ServerProvider extends DispatchableContentProvider {
    public static String uZ() {
        return "com.baidu.tieba.provider.ipc.server";
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected String getAuthority() {
        return uZ();
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected List<a> uY() {
        List<a> dt = com.baidu.pyramid.runtime.multiprocess.a.a.dt(getAuthority());
        if (dt == null) {
            dt = new ArrayList<>();
        }
        dt.add(0, new com.baidu.pyramid.runtime.multiprocess.internal.a());
        return dt;
    }
}
