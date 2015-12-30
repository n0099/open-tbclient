package com.baidu.tbadk.c;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    private ArrayList<com.baidu.tbadk.mainTab.b> Ts = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.getFragmentTabStructure() != null) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.Ts.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next != null && next.getFragmentTabStructure() != null && next.getFragmentTabStructure().type == bVar.getFragmentTabStructure().type) {
                    return;
                }
            }
            this.Ts.add(bVar);
        }
    }

    public ArrayList<com.baidu.tbadk.mainTab.b> qs() {
        return this.Ts;
    }

    public Context getContext() {
        return this.mContext;
    }
}
