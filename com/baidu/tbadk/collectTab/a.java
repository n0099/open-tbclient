package com.baidu.tbadk.collectTab;

import android.content.Context;
import com.baidu.tbadk.mainTab.b;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes11.dex */
public class a {
    private ArrayList<b> clk = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.getFragmentTabStructure() != null) {
            Iterator<b> it = this.clk.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.getFragmentTabStructure() != null && next.getFragmentTabStructure().type == bVar.getFragmentTabStructure().type) {
                    return;
                }
            }
            this.clk.add(bVar);
        }
    }

    public ArrayList<b> getList() {
        return this.clk;
    }

    public Context getContext() {
        return this.mContext;
    }
}
