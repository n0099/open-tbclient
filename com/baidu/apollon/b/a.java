package com.baidu.apollon.b;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Set<c>> f3583a;

    /* renamed from: com.baidu.apollon.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0059a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f3584a = new a();
    }

    public static a a() {
        return C0059a.f3584a;
    }

    public void b() {
        this.f3583a.clear();
    }

    public a() {
        this.f3583a = new HashMap();
    }

    public Set<c> a(String str) {
        Set<c> set = this.f3583a.get(str);
        return set == null ? Collections.emptySet() : set;
    }

    public a a(@NonNull String str, @NonNull Set<String> set) {
        if (this.f3583a.get(str) == null) {
            this.f3583a.put(str, new HashSet());
        }
        Set<c> set2 = this.f3583a.get(str);
        for (String str2 : set) {
            set2.add(new c(str2));
        }
        return this;
    }
}
