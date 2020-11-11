package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class a {
    public abstract void a(com.baidu.tbadk.a.e eVar);

    public abstract BdUniqueId bie();

    public abstract ArrayList<String> bif();

    public abstract com.baidu.tbadk.a.e big();

    public static void be(List<q> list) {
        if (list != null) {
            HashMap hashMap = new HashMap(com.baidu.tbadk.a.d.bhE());
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

    public static void a(g... gVarArr) {
        if (gVarArr != null) {
            HashMap hashMap = new HashMap(com.baidu.tbadk.a.d.bhE());
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
