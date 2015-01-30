package com.baidu.tbadk.c;

import android.content.Context;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {
    private Context Xf;
    private ArrayList<c> Xg;

    public ArrayList<c> uR() {
        return this.Xg;
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.Xg.add(cVar);
        }
    }

    public Context getContext() {
        return this.Xf;
    }
}
