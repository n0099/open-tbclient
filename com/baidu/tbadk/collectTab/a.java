package com.baidu.tbadk.collectTab;

import android.content.Context;
import com.baidu.tbadk.mainTab.b;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class a {
    private ArrayList<b> anW = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.Oh() != null) {
            Iterator<b> it = this.anW.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.Oh() != null && next.Oh().type == bVar.Oh().type) {
                    return;
                }
            }
            this.anW.add(bVar);
        }
    }

    public ArrayList<b> getList() {
        return this.anW;
    }

    public Context getContext() {
        return this.mContext;
    }
}
