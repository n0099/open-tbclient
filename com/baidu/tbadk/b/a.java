package com.baidu.tbadk.b;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    private ArrayList<com.baidu.tbadk.mainTab.b> SP = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.getFragmentTabStructure() != null) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.SP.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next != null && next.getFragmentTabStructure() != null && next.getFragmentTabStructure().type == bVar.getFragmentTabStructure().type) {
                    return;
                }
            }
            this.SP.add(bVar);
        }
    }

    public ArrayList<com.baidu.tbadk.mainTab.b> qD() {
        return this.SP;
    }

    public Context getContext() {
        return this.mContext;
    }
}
