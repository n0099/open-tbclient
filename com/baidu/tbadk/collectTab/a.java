package com.baidu.tbadk.collectTab;

import android.content.Context;
import com.baidu.tbadk.mainTab.b;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class a {
    private ArrayList<b> bVG = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.avz() != null) {
            Iterator<b> it = this.bVG.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.avz() != null && next.avz().type == bVar.avz().type) {
                    return;
                }
            }
            this.bVG.add(bVar);
        }
    }

    public ArrayList<b> getList() {
        return this.bVG;
    }

    public Context getContext() {
        return this.mContext;
    }
}
