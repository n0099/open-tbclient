package com.baidu.live.tbadk.plugins;

import android.content.Context;
import android.graphics.Bitmap;
/* loaded from: classes6.dex */
public interface MotuPlugin {
    Bitmap createOneKeyFilterAndApply(Context context, String str, Bitmap bitmap);

    void init(Context context);

    void startActivity(Context context, int i, String str);
}
