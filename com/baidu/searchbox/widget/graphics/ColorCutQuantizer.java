package com.baidu.searchbox.widget.graphics;

import android.graphics.Color;
import android.support.v4.graphics.ColorUtils;
import android.util.TimingLogger;
import com.baidu.searchbox.widget.graphics.Palette;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes17.dex */
public final class ColorCutQuantizer {
    static final int COMPONENT_BLUE = -1;
    static final int COMPONENT_GREEN = -2;
    static final int COMPONENT_RED = -3;
    private static final String LOG_TAG = "ColorCutQuantizer";
    private static final boolean LOG_TIMINGS = false;
    private static final int QUANTIZE_WORD_MASK = 31;
    private static final int QUANTIZE_WORD_WIDTH = 5;
    private static final Comparator<Vbox> VBOX_COMPARATOR_VOLUME = new Comparator<Vbox>() { // from class: com.baidu.searchbox.widget.graphics.ColorCutQuantizer.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(Vbox vbox, Vbox vbox2) {
            return vbox2.getVolume() - vbox.getVolume();
        }
    };
    final int[] mColors;
    final Palette.Filter[] mFilters;
    final int[] mHistogram;
    final List<Palette.Swatch> mQuantizedColors;
    private final float[] mTempHsl = new float[3];
    final TimingLogger mTimingLogger = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorCutQuantizer(int[] iArr, int i, Palette.Filter[] filterArr) {
        this.mFilters = filterArr;
        int[] iArr2 = new int[32768];
        this.mHistogram = iArr2;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            int quantizeFromRgb888 = quantizeFromRgb888(iArr[i2]);
            iArr[i2] = quantizeFromRgb888;
            iArr2[quantizeFromRgb888] = iArr2[quantizeFromRgb888] + 1;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < iArr2.length; i4++) {
            if (iArr2[i4] > 0 && shouldIgnoreColor(i4)) {
                iArr2[i4] = 0;
            }
            if (iArr2[i4] > 0) {
                i3++;
            }
        }
        int[] iArr3 = new int[i3];
        this.mColors = iArr3;
        int i5 = 0;
        for (int i6 = 0; i6 < iArr2.length; i6++) {
            if (iArr2[i6] > 0) {
                iArr3[i5] = i6;
                i5++;
            }
        }
        if (i3 <= i) {
            this.mQuantizedColors = new ArrayList();
            for (int i7 : iArr3) {
                this.mQuantizedColors.add(new Palette.Swatch(approximateToRgb888(i7), iArr2[i7]));
            }
            return;
        }
        this.mQuantizedColors = quantizePixels(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Palette.Swatch> getQuantizedColors() {
        return this.mQuantizedColors;
    }

    private List<Palette.Swatch> quantizePixels(int i) {
        PriorityQueue<Vbox> priorityQueue = new PriorityQueue<>(i, VBOX_COMPARATOR_VOLUME);
        priorityQueue.offer(new Vbox(0, this.mColors.length - 1));
        splitBoxes(priorityQueue, i);
        return generateAverageColors(priorityQueue);
    }

    private void splitBoxes(PriorityQueue<Vbox> priorityQueue, int i) {
        Vbox poll;
        while (priorityQueue.size() < i && (poll = priorityQueue.poll()) != null && poll.canSplit()) {
            priorityQueue.offer(poll.splitBox());
            priorityQueue.offer(poll);
        }
    }

    private List<Palette.Swatch> generateAverageColors(Collection<Vbox> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (Vbox vbox : collection) {
            Palette.Swatch averageColor = vbox.getAverageColor();
            if (!shouldIgnoreColor(averageColor)) {
                arrayList.add(averageColor);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public class Vbox {
        private int mLowerIndex;
        private int mMaxBlue;
        private int mMaxGreen;
        private int mMaxRed;
        private int mMinBlue;
        private int mMinGreen;
        private int mMinRed;
        private int mPopulation;
        private int mUpperIndex;

        Vbox(int i, int i2) {
            this.mLowerIndex = i;
            this.mUpperIndex = i2;
            fitBox();
        }

        final int getVolume() {
            return ((this.mMaxRed - this.mMinRed) + 1) * ((this.mMaxGreen - this.mMinGreen) + 1) * ((this.mMaxBlue - this.mMinBlue) + 1);
        }

        final boolean canSplit() {
            return getColorCount() > 1;
        }

        final int getColorCount() {
            return (this.mUpperIndex + 1) - this.mLowerIndex;
        }

        final void fitBox() {
            int[] iArr = ColorCutQuantizer.this.mColors;
            int[] iArr2 = ColorCutQuantizer.this.mHistogram;
            int i = Integer.MIN_VALUE;
            int i2 = 0;
            int i3 = Integer.MIN_VALUE;
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MAX_VALUE;
            int i6 = Integer.MAX_VALUE;
            int i7 = Integer.MIN_VALUE;
            for (int i8 = this.mLowerIndex; i8 <= this.mUpperIndex; i8++) {
                int i9 = iArr[i8];
                i2 += iArr2[i9];
                int quantizedRed = ColorCutQuantizer.quantizedRed(i9);
                int quantizedGreen = ColorCutQuantizer.quantizedGreen(i9);
                int quantizedBlue = ColorCutQuantizer.quantizedBlue(i9);
                if (quantizedRed > i3) {
                    i3 = quantizedRed;
                }
                if (quantizedRed < i6) {
                    i6 = quantizedRed;
                }
                if (quantizedGreen > i7) {
                    i7 = quantizedGreen;
                }
                if (quantizedGreen < i5) {
                    i5 = quantizedGreen;
                }
                if (quantizedBlue > i) {
                    i = quantizedBlue;
                }
                if (quantizedBlue < i4) {
                    i4 = quantizedBlue;
                }
            }
            this.mMinRed = i6;
            this.mMaxRed = i3;
            this.mMinGreen = i5;
            this.mMaxGreen = i7;
            this.mMinBlue = i4;
            this.mMaxBlue = i;
            this.mPopulation = i2;
        }

        final Vbox splitBox() {
            if (!canSplit()) {
                throw new IllegalStateException("Can not split a box with only 1 color");
            }
            int findSplitPoint = findSplitPoint();
            Vbox vbox = new Vbox(findSplitPoint + 1, this.mUpperIndex);
            this.mUpperIndex = findSplitPoint;
            fitBox();
            return vbox;
        }

        final int getLongestColorDimension() {
            int i = this.mMaxRed - this.mMinRed;
            int i2 = this.mMaxGreen - this.mMinGreen;
            int i3 = this.mMaxBlue - this.mMinBlue;
            if (i >= i2 && i >= i3) {
                return -3;
            }
            if (i2 >= i && i2 >= i3) {
                return -2;
            }
            return -1;
        }

        final int findSplitPoint() {
            int longestColorDimension = getLongestColorDimension();
            int[] iArr = ColorCutQuantizer.this.mColors;
            int[] iArr2 = ColorCutQuantizer.this.mHistogram;
            ColorCutQuantizer.modifySignificantOctet(iArr, longestColorDimension, this.mLowerIndex, this.mUpperIndex);
            Arrays.sort(iArr, this.mLowerIndex, this.mUpperIndex + 1);
            ColorCutQuantizer.modifySignificantOctet(iArr, longestColorDimension, this.mLowerIndex, this.mUpperIndex);
            int i = this.mPopulation / 2;
            int i2 = 0;
            for (int i3 = this.mLowerIndex; i3 <= this.mUpperIndex; i3++) {
                i2 += iArr2[iArr[i3]];
                if (i2 >= i) {
                    return Math.min(this.mUpperIndex - 1, i3);
                }
            }
            return this.mLowerIndex;
        }

        final Palette.Swatch getAverageColor() {
            int i = 0;
            int[] iArr = ColorCutQuantizer.this.mColors;
            int[] iArr2 = ColorCutQuantizer.this.mHistogram;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            for (int i5 = this.mLowerIndex; i5 <= this.mUpperIndex; i5++) {
                int i6 = iArr[i5];
                int i7 = iArr2[i6];
                i += i7;
                i4 += ColorCutQuantizer.quantizedRed(i6) * i7;
                i3 += ColorCutQuantizer.quantizedGreen(i6) * i7;
                i2 += ColorCutQuantizer.quantizedBlue(i6) * i7;
            }
            return new Palette.Swatch(ColorCutQuantizer.approximateToRgb888(Math.round(i4 / i), Math.round(i3 / i), Math.round(i2 / i)), i);
        }
    }

    static void modifySignificantOctet(int[] iArr, int i, int i2, int i3) {
        switch (i) {
            case -3:
            default:
                return;
            case -2:
                while (i2 <= i3) {
                    int i4 = iArr[i2];
                    iArr[i2] = quantizedBlue(i4) | (quantizedGreen(i4) << 10) | (quantizedRed(i4) << 5);
                    i2++;
                }
                return;
            case -1:
                while (i2 <= i3) {
                    int i5 = iArr[i2];
                    iArr[i2] = quantizedRed(i5) | (quantizedBlue(i5) << 10) | (quantizedGreen(i5) << 5);
                    i2++;
                }
                return;
        }
    }

    private boolean shouldIgnoreColor(int i) {
        int approximateToRgb888 = approximateToRgb888(i);
        ColorUtils.colorToHSL(approximateToRgb888, this.mTempHsl);
        return shouldIgnoreColor(approximateToRgb888, this.mTempHsl);
    }

    private boolean shouldIgnoreColor(Palette.Swatch swatch) {
        return shouldIgnoreColor(swatch.getRgb(), swatch.getHsl());
    }

    private boolean shouldIgnoreColor(int i, float[] fArr) {
        if (this.mFilters == null || this.mFilters.length <= 0) {
            return false;
        }
        int length = this.mFilters.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (!this.mFilters[i2].isAllowed(i, fArr)) {
                return true;
            }
        }
        return false;
    }

    private static int quantizeFromRgb888(int i) {
        return (modifyWordWidth(Color.red(i), 8, 5) << 10) | (modifyWordWidth(Color.green(i), 8, 5) << 5) | modifyWordWidth(Color.blue(i), 8, 5);
    }

    static int approximateToRgb888(int i, int i2, int i3) {
        return Color.rgb(modifyWordWidth(i, 5, 8), modifyWordWidth(i2, 5, 8), modifyWordWidth(i3, 5, 8));
    }

    private static int approximateToRgb888(int i) {
        return approximateToRgb888(quantizedRed(i), quantizedGreen(i), quantizedBlue(i));
    }

    static int quantizedRed(int i) {
        return (i >> 10) & 31;
    }

    static int quantizedGreen(int i) {
        return (i >> 5) & 31;
    }

    static int quantizedBlue(int i) {
        return i & 31;
    }

    private static int modifyWordWidth(int i, int i2, int i3) {
        int i4;
        if (i3 > i2) {
            i4 = i << (i3 - i2);
        } else {
            i4 = i >> (i2 - i3);
        }
        return i4 & ((1 << i3) - 1);
    }
}
