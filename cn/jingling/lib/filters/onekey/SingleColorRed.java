package cn.jingling.lib.filters.onekey;

import cn.jingling.lib.filters.CMTProcessor;
/* loaded from: classes.dex */
public class SingleColorRed extends SingleColor {
    @Override // cn.jingling.lib.filters.onekey.SingleColor
    public void singleColorEffect(int[] iArr, int i, int i2, float[] fArr) {
        CMTProcessor.singleColorEffect(iArr, i, i2, fArr, 1.0f, 0.0f, 0.0f, 0.25f, 0.35f);
    }
}
