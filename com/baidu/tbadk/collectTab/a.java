package com.baidu.tbadk.collectTab;

import android.content.Context;
import com.baidu.tbadk.mainTab.b;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class a {
    private ArrayList<b> acb = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.Jt() != null) {
            Iterator<b> it = this.acb.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.Jt() != null && next.Jt().type == bVar.Jt().type) {
                    return;
                }
            }
            this.acb.add(bVar);
        }
    }

    public ArrayList<b> sT() {
        return this.acb;
    }

    public Context getContext() {
        return this.mContext;
    }
}
