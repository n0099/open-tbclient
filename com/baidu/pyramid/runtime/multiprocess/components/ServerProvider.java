package com.baidu.pyramid.runtime.multiprocess.components;

import com.baidu.pyramid.runtime.multiprocess.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class ServerProvider extends DispatchableContentProvider {
    public static String Wz() {
        return e.getAppContext().getPackageName() + ".provider.ipc.server";
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected String Ww() {
        return Wz();
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected List<a> Wx() {
        List<a> ir = com.baidu.pyramid.runtime.multiprocess.a.a.ir(Ww());
        if (ir == null) {
            ir = new ArrayList<>();
        }
        ir.add(0, new com.baidu.pyramid.runtime.multiprocess.internal.a());
        return ir;
    }
}
