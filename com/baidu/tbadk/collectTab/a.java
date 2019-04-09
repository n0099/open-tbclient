package com.baidu.tbadk.collectTab;

import android.content.Context;
import com.baidu.tbadk.mainTab.b;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class a {
    private ArrayList<b> buM = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.anH() != null) {
            Iterator<b> it = this.buM.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.anH() != null && next.anH().type == bVar.anH().type) {
                    return;
                }
            }
            this.buM.add(bVar);
        }
    }

    public ArrayList<b> getList() {
        return this.buM;
    }

    public Context getContext() {
        return this.mContext;
    }
}
