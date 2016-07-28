package com.baidu.tbadk.c;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    private ArrayList<com.baidu.tbadk.mainTab.b> Lb = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.Dl() != null) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.Lb.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next != null && next.Dl() != null && next.Dl().type == bVar.Dl().type) {
                    return;
                }
            }
            this.Lb.add(bVar);
        }
    }

    public ArrayList<com.baidu.tbadk.mainTab.b> nk() {
        return this.Lb;
    }

    public Context getContext() {
        return this.mContext;
    }
}
