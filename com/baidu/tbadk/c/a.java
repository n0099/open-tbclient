package com.baidu.tbadk.c;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    private ArrayList<com.baidu.tbadk.mainTab.b> Lc = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.Dm() != null) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.Lc.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next != null && next.Dm() != null && next.Dm().type == bVar.Dm().type) {
                    return;
                }
            }
            this.Lc.add(bVar);
        }
    }

    public ArrayList<com.baidu.tbadk.mainTab.b> nv() {
        return this.Lc;
    }

    public Context getContext() {
        return this.mContext;
    }
}
