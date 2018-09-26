package com.baidu.tbadk.collectTab;

import android.content.Context;
import com.baidu.tbadk.mainTab.b;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class a {
    private ArrayList<b> aei = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.KE() != null) {
            Iterator<b> it = this.aei.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.KE() != null && next.KE().type == bVar.KE().type) {
                    return;
                }
            }
            this.aei.add(bVar);
        }
    }

    public ArrayList<b> getList() {
        return this.aei;
    }

    public Context getContext() {
        return this.mContext;
    }
}
