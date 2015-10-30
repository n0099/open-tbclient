package com.baidu.tbadk.c;

import android.content.Context;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {
    private ArrayList<c> SC;
    private Context anJ;

    public ArrayList<c> Aa() {
        return this.SC;
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.SC.add(cVar);
        }
    }

    public Context getContext() {
        return this.anJ;
    }
}
