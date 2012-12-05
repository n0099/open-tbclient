package cn.jingling.lib.filters.onekey;

import android.content.Context;
import android.graphics.Bitmap;
import cn.jingling.lib.filters.OneKeyFilter;
import cn.jingling.lib.filters.global.BetterSkin;
/* loaded from: classes.dex */
public class Skin extends OneKeyFilter {
    @Override // cn.jingling.lib.filters.OneKeyFilter
    public Bitmap apply(Context cx, Bitmap bm) {
        BetterSkin skin = new BetterSkin();
        skin.setup(cx, bm);
        Bitmap bitmap = skin.apply(cx, 90);
        skin.release();
        return bitmap;
    }
}
