package com.baidu.pyramid.runtime.multiprocess.components;

import com.baidu.pyramid.runtime.multiprocess.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ServerProvider extends DispatchableContentProvider {
    public static String vv() {
        return e.getAppContext().getPackageName() + ".provider.ipc.server";
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected String vs() {
        return vv();
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    protected List<a> vt() {
        List<a> db = com.baidu.pyramid.runtime.multiprocess.a.a.db(vs());
        if (db == null) {
            db = new ArrayList<>();
        }
        db.add(0, new com.baidu.pyramid.runtime.multiprocess.internal.a());
        return db;
    }
}
