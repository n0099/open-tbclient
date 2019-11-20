package com.baidu.tbadk.collectTab;

import android.content.Context;
import com.baidu.tbadk.mainTab.b;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class a {
    private ArrayList<b> bUP = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.avx() != null) {
            Iterator<b> it = this.bUP.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.avx() != null && next.avx().type == bVar.avx().type) {
                    return;
                }
            }
            this.bUP.add(bVar);
        }
    }

    public ArrayList<b> getList() {
        return this.bUP;
    }

    public Context getContext() {
        return this.mContext;
    }
}
