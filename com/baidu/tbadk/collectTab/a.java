package com.baidu.tbadk.collectTab;

import android.content.Context;
import com.baidu.tbadk.mainTab.b;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class a {
    private ArrayList<b> abF = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.Jo() != null) {
            Iterator<b> it = this.abF.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.Jo() != null && next.Jo().type == bVar.Jo().type) {
                    return;
                }
            }
            this.abF.add(bVar);
        }
    }

    public ArrayList<b> sF() {
        return this.abF;
    }

    public Context getContext() {
        return this.mContext;
    }
}
