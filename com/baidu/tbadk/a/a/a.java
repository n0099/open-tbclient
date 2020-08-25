package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public abstract class a {
    public abstract void a(com.baidu.tbadk.a.e eVar);

    public abstract BdUniqueId baj();

    public abstract ArrayList<String> bak();

    public abstract com.baidu.tbadk.a.e bal();

    public static void aG(List<q> list) {
        if (list != null) {
            HashMap hashMap = new HashMap(com.baidu.tbadk.a.d.aZO());
            for (q qVar : list) {
                if (qVar instanceof AbsThreadDataSupport) {
                    AbsThreadDataSupport absThreadDataSupport = (AbsThreadDataSupport) qVar;
                    for (Map.Entry entry : hashMap.entrySet()) {
                        absThreadDataSupport.a((BdUniqueId) entry.getKey(), (com.baidu.tbadk.a.e) entry.getValue());
                    }
                }
            }
        }
    }

    public static void a(d... dVarArr) {
        if (dVarArr != null) {
            HashMap hashMap = new HashMap(com.baidu.tbadk.a.d.aZO());
            for (d dVar : dVarArr) {
                if (dVar != null) {
                    for (Map.Entry entry : hashMap.entrySet()) {
                        dVar.a((BdUniqueId) entry.getKey(), (com.baidu.tbadk.a.e) entry.getValue());
                    }
                }
            }
        }
    }
}
