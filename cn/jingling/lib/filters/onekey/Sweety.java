package cn.jingling.lib.filters.onekey;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import cn.jingling.lib.filters.CMTProcessor;
import cn.jingling.lib.filters.Curve;
import cn.jingling.lib.filters.OneKeyFilter;
/* loaded from: classes.dex */
public class Sweety extends OneKeyFilter {
    private void RGB2Lab(int[] pixels, int w, int h) {
        int[] RGB = new int[3];
        int[] Lab = new int[3];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int color = pixels[(i * w) + j];
                int alpha = (color >> 24) & MotionEventCompat.ACTION_MASK;
                RGB[0] = (color >> 16) & MotionEventCompat.ACTION_MASK;
                RGB[1] = (color >> 8) & MotionEventCompat.ACTION_MASK;
                RGB[2] = color & MotionEventCompat.ACTION_MASK;
                Lab[0] = (((RGB[0] * 13933) + (46871 * RGB[1])) + (RGB[2] * 4732)) >> 16;
                Lab[1] = (((((RGB[0] * 14503) - (RGB[1] * 22218)) + (RGB[2] * 7714)) * 377) >> 24) + AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER;
                Lab[2] = (((((RGB[0] * 12773) + (39695 * RGB[1])) - (52468 * RGB[2])) * 160) >> 24) + AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER;
                pixels[(i * w) + j] = (alpha << 24) | (Lab[0] << 16) | (Lab[1] << 8) | Lab[2];
            }
        }
    }

    private void Lab2RGB(int[] pixels, int w, int h) {
        int[] RGB = new int[3];
        int[] Lab = new int[3];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int color = pixels[(i * w) + j];
                int alpha = (color >> 24) & MotionEventCompat.ACTION_MASK;
                Lab[0] = (color >> 16) & MotionEventCompat.ACTION_MASK;
                Lab[1] = (color >> 8) & MotionEventCompat.ACTION_MASK;
                Lab[2] = color & MotionEventCompat.ACTION_MASK;
                int L1 = Lab[0];
                int a1 = (Lab[1] - 128) * 174;
                int b1 = (Lab[2] - 128) * 410;
                RGB[0] = (((100922 * a1) + (b1 * 17790)) >> 23) + L1;
                RGB[1] = L1 - (((a1 * 30176) + (b1 * 1481)) >> 23);
                RGB[2] = (((a1 * 1740) - (37719 * b1)) >> 23) + L1;
                if (RGB[0] < 0) {
                    RGB[0] = 0;
                } else if (RGB[0] > 255) {
                    RGB[0] = 255;
                }
                if (RGB[1] < 0) {
                    RGB[1] = 0;
                } else if (RGB[1] > 255) {
                    RGB[1] = 255;
                }
                if (RGB[2] < 0) {
                    RGB[2] = 0;
                } else if (RGB[2] > 255) {
                    RGB[2] = 255;
                }
                pixels[(i * w) + j] = (alpha << 24) | (RGB[0] << 16) | (RGB[1] << 8) | RGB[2];
            }
        }
    }

    @Override // cn.jingling.lib.filters.OneKeyFilter
    public Bitmap apply(Context cx, Bitmap bm) {
        int w = bm.getWidth();
        int h = bm.getHeight();
        int[] pixels = new int[w * h];
        bm.getPixels(pixels, 0, w, 0, 0, w, h);
        RGB2Lab(pixels, w, h);
        Curve curve = new Curve(cx, "curves/sweety.dat");
        CMTProcessor.curveEffect(pixels, curve.getCurveRed(), curve.getCurveGreen(), curve.getCurveBlue(), w, h);
        Lab2RGB(pixels, w, h);
        bm.setPixels(pixels, 0, w, 0, 0, w, h);
        return bm;
    }
}
