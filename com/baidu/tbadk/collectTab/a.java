package com.baidu.tbadk.collectTab;

import android.content.Context;
import com.baidu.tbadk.mainTab.b;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class a {
    private ArrayList<b> TP = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(b bVar) {
        if (bVar != null && bVar.Fw() != null) {
            Iterator<b> it = this.TP.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.Fw() != null && next.Fw().type == bVar.Fw().type) {
                    return;
                }
            }
            this.TP.add(bVar);
        }
    }

    public ArrayList<b> pw() {
        return this.TP;
    }

    public Context getContext() {
        return this.mContext;
    }
}
