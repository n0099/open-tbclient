package com.baidu.ar.auth;

import android.content.Context;
import java.util.Set;
/* loaded from: classes.dex */
public interface k {

    /* loaded from: classes.dex */
    public interface a {
        void a(Set<Integer> set);
    }

    void a(a aVar);

    void doAuth(Context context, IAuthCallback iAuthCallback);
}
