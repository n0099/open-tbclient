package com.baidu.apollon.statistics;

import android.content.Context;
import java.util.Map;
/* loaded from: classes2.dex */
public interface SyncHttpImpl {
    public static final int GET = 0;
    public static final int POST = 1;

    boolean send(Context context, int i, String str, Map<String, String> map);
}
