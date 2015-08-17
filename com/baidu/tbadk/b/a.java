package com.baidu.tbadk.b;

import android.content.Context;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {
    private Context anw;
    private ArrayList<c> anx;

    public ArrayList<c> Af() {
        return this.anx;
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.anx.add(cVar);
        }
    }

    public Context getContext() {
        return this.anw;
    }
}
