package com.baidu.tbadk.collectTab;

import android.content.Context;
import com.baidu.tbadk.mainTab.b;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class a {
    private ArrayList<b> bCN = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.atS() != null) {
            Iterator<b> it = this.bCN.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.atS() != null && next.atS().type == bVar.atS().type) {
                    return;
                }
            }
            this.bCN.add(bVar);
        }
    }

    public ArrayList<b> getList() {
        return this.bCN;
    }

    public Context getContext() {
        return this.mContext;
    }
}
