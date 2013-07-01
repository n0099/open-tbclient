package com.baidu.mapapi;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class MKSuggestionResult {

    /* renamed from: a  reason: collision with root package name */
    private int f518a = 0;
    private ArrayList b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ArrayList arrayList) {
        this.b = arrayList;
    }

    public ArrayList getAllSuggestions() {
        return this.b;
    }

    public MKSuggestionInfo getSuggestion(int i) {
        if (this.b == null || this.f518a <= i) {
            return null;
        }
        return (MKSuggestionInfo) this.b.get(i);
    }

    public int getSuggestionNum() {
        if (this.b != null) {
            this.f518a = this.b.size();
        } else {
            this.f518a = 0;
        }
        return this.f518a;
    }
}
