package com.baidu.sapi2.passhost.pluginsdk.service;

import android.content.Context;
import android.util.Pair;
/* loaded from: classes.dex */
public interface ISafeService {
    Pair<Integer, Object> callSync(int i, String str, Class<?>[] clsArr, Object... objArr);

    String getCurZid(Context context);
}
