package com.baidu.tbadk.collectTab;

import android.content.Context;
import com.baidu.tbadk.mainTab.b;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class a {
    private ArrayList<b> buI = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.anK() != null) {
            Iterator<b> it = this.buI.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.anK() != null && next.anK().type == bVar.anK().type) {
                    return;
                }
            }
            this.buI.add(bVar);
        }
    }

    public ArrayList<b> getList() {
        return this.buI;
    }

    public Context getContext() {
        return this.mContext;
    }
}
