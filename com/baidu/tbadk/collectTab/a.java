package com.baidu.tbadk.collectTab;

import android.content.Context;
import com.baidu.tbadk.mainTab.b;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class a {
    private ArrayList<b> bDl = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.aug() != null) {
            Iterator<b> it = this.bDl.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.aug() != null && next.aug().type == bVar.aug().type) {
                    return;
                }
            }
            this.bDl.add(bVar);
        }
    }

    public ArrayList<b> getList() {
        return this.bDl;
    }

    public Context getContext() {
        return this.mContext;
    }
}
