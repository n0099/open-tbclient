package cn.jingling.lib.filters.onekey;

import cn.jingling.lib.filters.CMTProcessor;
/* loaded from: classes.dex */
public class SingleColorPurple extends SingleColor {
    @Override // cn.jingling.lib.filters.onekey.SingleColor
    public void singleColorEffect(int[] pixels, int w, int h, float[] matrix) {
        CMTProcessor.singleColorEffect(pixels, w, h, matrix, 0.5f, 0.0f, 0.5f, 0.09f, 0.15f);
    }
}
