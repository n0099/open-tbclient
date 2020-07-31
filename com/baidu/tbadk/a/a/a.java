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

    public abstract BdUniqueId aRS();

    public abstract ArrayList<String> aRT();

    public abstract com.baidu.tbadk.a.e aRU();

    public static void aG(List<q> list) {
        if (list != null) {
            HashMap hashMap = new HashMap(com.baidu.tbadk.a.d.aRx());
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

    public static void a(c... cVarArr) {
        if (cVarArr != null) {
            HashMap hashMap = new HashMap(com.baidu.tbadk.a.d.aRx());
            for (c cVar : cVarArr) {
                if (cVar != null) {
                    for (Map.Entry entry : hashMap.entrySet()) {
                        cVar.a((BdUniqueId) entry.getKey(), (com.baidu.tbadk.a.e) entry.getValue());
                    }
                }
            }
        }
    }
}
