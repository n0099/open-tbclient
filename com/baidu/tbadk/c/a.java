package com.baidu.tbadk.c;

import android.content.Context;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {
    private Context Xc;
    private ArrayList<c> Xd;

    public ArrayList<c> uL() {
        return this.Xd;
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.Xd.add(cVar);
        }
    }

    public Context getContext() {
        return this.Xc;
    }
}
