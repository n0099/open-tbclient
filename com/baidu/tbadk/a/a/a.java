package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class a {
    public abstract void a(com.baidu.tbadk.a.e eVar);

    public abstract com.baidu.tbadk.a.e bhA();

    public abstract BdUniqueId bhy();

    public abstract ArrayList<String> bhz();

    public static void be(List<q> list) {
        if (list != null) {
            HashMap hashMap = new HashMap(com.baidu.tbadk.a.d.bgX());
            for (q qVar : list) {
                if (qVar instanceof com.baidu.tbadk.core.data.a) {
                    com.baidu.tbadk.core.data.a aVar = (com.baidu.tbadk.core.data.a) qVar;
                    for (Map.Entry entry : hashMap.entrySet()) {
                        aVar.a((BdUniqueId) entry.getKey(), (com.baidu.tbadk.a.e) entry.getValue());
                    }
                }
            }
        }
    }

    public static void a(g... gVarArr) {
        if (gVarArr != null) {
            HashMap hashMap = new HashMap(com.baidu.tbadk.a.d.bgX());
            for (g gVar : gVarArr) {
                if (gVar != null) {
                    for (Map.Entry entry : hashMap.entrySet()) {
                        gVar.a((BdUniqueId) entry.getKey(), (com.baidu.tbadk.a.e) entry.getValue());
                    }
                }
            }
        }
    }
}
