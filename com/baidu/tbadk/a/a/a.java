package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class a {
    public abstract void a(com.baidu.tbadk.a.e eVar);

    public abstract BdUniqueId bji();

    public abstract ArrayList<String> bjj();

    public abstract com.baidu.tbadk.a.e bjk();

    public static void bo(List<com.baidu.adp.widget.ListView.n> list) {
        if (list != null) {
            HashMap hashMap = new HashMap(com.baidu.tbadk.a.d.biy());
            for (com.baidu.adp.widget.ListView.n nVar : list) {
                if (nVar instanceof com.baidu.tbadk.core.data.a) {
                    com.baidu.tbadk.core.data.a aVar = (com.baidu.tbadk.core.data.a) nVar;
                    for (Map.Entry entry : hashMap.entrySet()) {
                        aVar.a((BdUniqueId) entry.getKey(), (com.baidu.tbadk.a.e) entry.getValue());
                    }
                }
            }
        }
    }

    public static void a(i... iVarArr) {
        if (iVarArr != null) {
            HashMap hashMap = new HashMap(com.baidu.tbadk.a.d.biy());
            for (i iVar : iVarArr) {
                if (iVar != null) {
                    for (Map.Entry entry : hashMap.entrySet()) {
                        iVar.a((BdUniqueId) entry.getKey(), (com.baidu.tbadk.a.e) entry.getValue());
                    }
                }
            }
        }
    }
}
