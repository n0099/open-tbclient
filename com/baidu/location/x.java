package com.baidu.location;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class x extends ArrayList {

    /* renamed from: if  reason: not valid java name */
    private static final long f116if = 1;
    private int a;

    public x(int i) {
        this.a = 0;
        this.a = i;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        if (size() == this.a) {
            remove(0);
        }
        add(size(), obj);
        return true;
    }
}
