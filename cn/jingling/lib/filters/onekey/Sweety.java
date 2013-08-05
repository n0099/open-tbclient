package cn.jingling.lib.filters.onekey;

import android.content.Context;
import android.graphics.Bitmap;
import cn.jingling.lib.filters.CMTProcessor;
import cn.jingling.lib.filters.Curve;
import cn.jingling.lib.filters.OneKeyFilter;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.zeus.bouncycastle.DERTags;
import com.tencent.mm.sdk.platformtools.Util;
/* loaded from: classes.dex */
public class Sweety extends OneKeyFilter {
    private void RGB2Lab(int[] iArr, int i, int i2) {
        int[] iArr2 = new int[3];
        int[] iArr3 = new int[3];
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                int i5 = iArr[(i3 * i) + i4];
                int i6 = (i5 >> 24) & Util.MASK_8BIT;
                iArr2[0] = (i5 >> 16) & Util.MASK_8BIT;
                iArr2[1] = (i5 >> 8) & Util.MASK_8BIT;
                iArr2[2] = i5 & Util.MASK_8BIT;
                iArr3[0] = (((iArr2[0] * 13933) + (46871 * iArr2[1])) + (iArr2[2] * 4732)) >> 16;
                iArr3[1] = (((((iArr2[0] * 14503) - (iArr2[1] * 22218)) + (iArr2[2] * 7714)) * 377) >> 24) + DERTags.TAGGED;
                iArr3[2] = (((((iArr2[0] * 12773) + (39695 * iArr2[1])) - (52468 * iArr2[2])) * 160) >> 24) + DERTags.TAGGED;
                iArr[(i3 * i) + i4] = (i6 << 24) | (iArr3[0] << 16) | (iArr3[1] << 8) | iArr3[2];
            }
        }
    }

    private void Lab2RGB(int[] iArr, int i, int i2) {
        int[] iArr2 = new int[3];
        int[] iArr3 = new int[3];
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                int i5 = iArr[(i3 * i) + i4];
                int i6 = (i5 >> 24) & Util.MASK_8BIT;
                iArr3[0] = (i5 >> 16) & Util.MASK_8BIT;
                iArr3[1] = (i5 >> 8) & Util.MASK_8BIT;
                iArr3[2] = i5 & Util.MASK_8BIT;
                int i7 = iArr3[0];
                int i8 = (iArr3[1] - 128) * 174;
                int i9 = (iArr3[2] - 128) * BdWebErrorView.ERROR_CODE_410;
                iArr2[0] = (((100922 * i8) + (i9 * 17790)) >> 23) + i7;
                iArr2[1] = i7 - (((i8 * 30176) + (i9 * 1481)) >> 23);
                iArr2[2] = i7 + (((i8 * 1740) - (i9 * 37719)) >> 23);
                if (iArr2[0] < 0) {
                    iArr2[0] = 0;
                } else if (iArr2[0] > 255) {
                    iArr2[0] = 255;
                }
                if (iArr2[1] < 0) {
                    iArr2[1] = 0;
                } else if (iArr2[1] > 255) {
                    iArr2[1] = 255;
                }
                if (iArr2[2] < 0) {
                    iArr2[2] = 0;
                } else if (iArr2[2] > 255) {
                    iArr2[2] = 255;
                }
                iArr[(i3 * i) + i4] = (i6 << 24) | (iArr2[0] << 16) | (iArr2[1] << 8) | iArr2[2];
            }
        }
    }

    @Override // cn.jingling.lib.filters.OneKeyFilter
    public Bitmap apply(Context context, Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        RGB2Lab(iArr, width, height);
        Curve curve = new Curve(context, "curves/sweety.dat");
        CMTProcessor.curveEffect(iArr, curve.getCurveRed(), curve.getCurveGreen(), curve.getCurveBlue(), width, height);
        Lab2RGB(iArr, width, height);
        bitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return bitmap;
    }
}
