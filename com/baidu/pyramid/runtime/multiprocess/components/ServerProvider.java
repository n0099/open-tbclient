package com.baidu.pyramid.runtime.multiprocess.components;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class ServerProvider extends DispatchableContentProvider {
    public static String uF() {
        return "com.baidu.tieba.provider.ipc.server";
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected String getAuthority() {
        return uF();
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected List<a> uE() {
        List<a> dk = com.baidu.pyramid.runtime.multiprocess.a.a.dk(getAuthority());
        if (dk == null) {
            dk = new ArrayList<>();
        }
        dk.add(0, new com.baidu.pyramid.runtime.multiprocess.internal.a());
        return dk;
    }
}
