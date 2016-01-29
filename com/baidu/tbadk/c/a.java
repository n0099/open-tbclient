package com.baidu.tbadk.c;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    private ArrayList<com.baidu.tbadk.mainTab.b> SO = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.Ey() != null) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.SO.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next != null && next.Ey() != null && next.Ey().type == bVar.Ey().type) {
                    return;
                }
            }
            this.SO.add(bVar);
        }
    }

    public ArrayList<com.baidu.tbadk.mainTab.b> qN() {
        return this.SO;
    }

    public Context getContext() {
        return this.mContext;
    }
}
