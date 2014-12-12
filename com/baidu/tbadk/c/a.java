package com.baidu.tbadk.c;

import android.content.Context;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {
    private Context WA;
    private ArrayList<c> WB;

    public ArrayList<c> uA() {
        return this.WB;
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.WB.add(cVar);
        }
    }

    public Context getContext() {
        return this.WA;
    }
}
