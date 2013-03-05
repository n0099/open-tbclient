package com.baidu.mapapi;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class MKSuggestionResult {
    private int a = 0;
    private ArrayList b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ArrayList arrayList) {
        this.b = arrayList;
    }

    public ArrayList getAllSuggestions() {
        return this.b;
    }

    public MKSuggestionInfo getSuggestion(int i) {
        if (this.b == null || this.a <= i) {
            return null;
        }
        return (MKSuggestionInfo) this.b.get(i);
    }

    public int getSuggestionNum() {
        if (this.b != null) {
            this.a = this.b.size();
        } else {
            this.a = 0;
        }
        return this.a;
    }
}
