package com.baidu.tbadk.c;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    private ArrayList<com.baidu.tbadk.mainTab.b> Ql = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.Fl() != null) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.Ql.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next != null && next.Fl() != null && next.Fl().type == bVar.Fl().type) {
                    return;
                }
            }
            this.Ql.add(bVar);
        }
    }

    public ArrayList<com.baidu.tbadk.mainTab.b> qe() {
        return this.Ql;
    }

    public Context getContext() {
        return this.mContext;
    }
}
