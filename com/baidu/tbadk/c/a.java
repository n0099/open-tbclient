package com.baidu.tbadk.c;

import android.content.Context;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {
    private ArrayList<c> SD;
    private Context anO;

    public ArrayList<c> Af() {
        return this.SD;
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.SD.add(cVar);
        }
    }

    public Context getContext() {
        return this.anO;
    }
}
