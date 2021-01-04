package com.baidu.live.tbadk.plugins;

import android.content.Context;
import android.graphics.Bitmap;
@Deprecated
/* loaded from: classes11.dex */
public interface MotuPlugin {
    Bitmap createOneKeyFilterAndApply(Context context, String str, Bitmap bitmap);

    void init(Context context);

    void startActivity(Context context, int i, String str);
}
