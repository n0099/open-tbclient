package com.baidu.tbadk.collectTab;

import android.content.Context;
import com.baidu.tbadk.mainTab.b;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class a {
    private ArrayList<b> bxQ = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.aNy() != null) {
            Iterator<b> it = this.bxQ.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.aNy() != null && next.aNy().type == bVar.aNy().type) {
                    return;
                }
            }
            this.bxQ.add(bVar);
        }
    }

    public ArrayList<b> getList() {
        return this.bxQ;
    }

    public Context getContext() {
        return this.mContext;
    }
}
