package com.baidu.tbadk.collectTab;

import android.content.Context;
import com.baidu.tbadk.mainTab.b;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class a {
    private ArrayList<b> TT = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.Fy() != null) {
            Iterator<b> it = this.TT.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.Fy() != null && next.Fy().type == bVar.Fy().type) {
                    return;
                }
            }
            this.TT.add(bVar);
        }
    }

    public ArrayList<b> px() {
        return this.TT;
    }

    public Context getContext() {
        return this.mContext;
    }
}
