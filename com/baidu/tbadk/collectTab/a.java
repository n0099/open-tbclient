package com.baidu.tbadk.collectTab;

import android.content.Context;
import com.baidu.tbadk.mainTab.b;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class a {
    private ArrayList<b> anu = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.NP() != null) {
            Iterator<b> it = this.anu.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.NP() != null && next.NP().type == bVar.NP().type) {
                    return;
                }
            }
            this.anu.add(bVar);
        }
    }

    public ArrayList<b> getList() {
        return this.anu;
    }

    public Context getContext() {
        return this.mContext;
    }
}
