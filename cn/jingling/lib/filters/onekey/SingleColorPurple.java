package cn.jingling.lib.filters.onekey;

import cn.jingling.lib.filters.CMTProcessor;
/* loaded from: classes.dex */
public class SingleColorPurple extends SingleColor {
    @Override // cn.jingling.lib.filters.onekey.SingleColor
    public void singleColorEffect(int[] iArr, int i, int i2, float[] fArr) {
        CMTProcessor.singleColorEffect(iArr, i, i2, fArr, 0.5f, 0.0f, 0.5f, 0.09f, 0.15f);
    }
}
