package cn.jingling.lib.filters.onekey;

import android.content.Context;
import android.graphics.Bitmap;
import cn.jingling.lib.filters.OneKeyFilter;
import cn.jingling.lib.filters.global.BetterSkin;
/* loaded from: classes.dex */
public class Skin extends OneKeyFilter {
    @Override // cn.jingling.lib.filters.OneKeyFilter
    public Bitmap apply(Context context, Bitmap bitmap) {
        BetterSkin betterSkin = new BetterSkin();
        betterSkin.setup(context, bitmap);
        Bitmap apply = betterSkin.apply(context, 90);
        betterSkin.release();
        return apply;
    }
}
