package com.baidu.pyramid.runtime.multiprocess.components;

import com.baidu.pyramid.runtime.multiprocess.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class ServerProvider extends DispatchableContentProvider {
    public static String QD() {
        return e.getAppContext().getPackageName() + ".provider.ipc.server";
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected String QA() {
        return QD();
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected List<a> QB() {
        List<a> gX = com.baidu.pyramid.runtime.multiprocess.a.a.gX(QA());
        if (gX == null) {
            gX = new ArrayList<>();
        }
        gX.add(0, new com.baidu.pyramid.runtime.multiprocess.internal.a());
        return gX;
    }
}
