package com.baidu.tbadk.collectTab;

import android.content.Context;
import com.baidu.tbadk.mainTab.b;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class a {
    private ArrayList<b> bxd = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.aNf() != null) {
            Iterator<b> it = this.bxd.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.aNf() != null && next.aNf().type == bVar.aNf().type) {
                    return;
                }
            }
            this.bxd.add(bVar);
        }
    }

    public ArrayList<b> getList() {
        return this.bxd;
    }

    public Context getContext() {
        return this.mContext;
    }
}
