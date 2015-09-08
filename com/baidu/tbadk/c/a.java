package com.baidu.tbadk.c;

import android.content.Context;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {
    private ArrayList<c> SP;
    private Context api;

    public ArrayList<c> As() {
        return this.SP;
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.SP.add(cVar);
        }
    }

    public Context getContext() {
        return this.api;
    }
}
