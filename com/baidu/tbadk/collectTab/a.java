package com.baidu.tbadk.collectTab;

import android.content.Context;
import com.baidu.tbadk.mainTab.b;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class a {
    private ArrayList<b> bBQ = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.asK() != null) {
            Iterator<b> it = this.bBQ.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.asK() != null && next.asK().type == bVar.asK().type) {
                    return;
                }
            }
            this.bBQ.add(bVar);
        }
    }

    public ArrayList<b> getList() {
        return this.bBQ;
    }

    public Context getContext() {
        return this.mContext;
    }
}
