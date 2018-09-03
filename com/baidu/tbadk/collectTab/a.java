package com.baidu.tbadk.collectTab;

import android.content.Context;
import com.baidu.tbadk.mainTab.b;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class a {
    private ArrayList<b> abG = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.Jo() != null) {
            Iterator<b> it = this.abG.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.Jo() != null && next.Jo().type == bVar.Jo().type) {
                    return;
                }
            }
            this.abG.add(bVar);
        }
    }

    public ArrayList<b> sE() {
        return this.abG;
    }

    public Context getContext() {
        return this.mContext;
    }
}
