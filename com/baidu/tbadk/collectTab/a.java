package com.baidu.tbadk.collectTab;

import android.content.Context;
import com.baidu.tbadk.mainTab.b;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class a {
    private ArrayList<b> bBP = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.asK() != null) {
            Iterator<b> it = this.bBP.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.asK() != null && next.asK().type == bVar.asK().type) {
                    return;
                }
            }
            this.bBP.add(bVar);
        }
    }

    public ArrayList<b> getList() {
        return this.bBP;
    }

    public Context getContext() {
        return this.mContext;
    }
}
