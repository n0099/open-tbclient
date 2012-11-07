package cn.jingling.lib.filters.onekey;

import cn.jingling.lib.filters.CMTProcessor;
/* loaded from: classes.dex */
public class SingleColorRed extends SingleColor {
    @Override // cn.jingling.lib.filters.onekey.SingleColor
    public void singleColorEffect(int[] pixels, int w, int h, float[] matrix) {
        CMTProcessor.singleColorEffect(pixels, w, h, matrix, 1.0f, 0.0f, 0.0f, 0.25f, 0.35f);
    }
}
