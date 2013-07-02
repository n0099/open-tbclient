package cn.jingling.lib.filters;

import android.content.Context;
import android.graphics.Bitmap;
/* loaded from: classes.dex */
public abstract class OneKeyFilter extends Filter {
    public abstract Bitmap apply(Context context, Bitmap bitmap);
}
