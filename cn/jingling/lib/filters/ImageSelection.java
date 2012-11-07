package cn.jingling.lib.filters;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v4.view.MotionEventCompat;
/* loaded from: classes.dex */
public class ImageSelection {
    private static /* synthetic */ int[] $SWITCH_TABLE$cn$jingling$lib$filters$ImageSelection$Align;
    private int mHeight;
    private int[] mSelection;
    private int mWidth;

    /* loaded from: classes.dex */
    public enum Align {
        CENTER,
        LEFT_TOP,
        RIGHT_BOTTOM;

        /* JADX DEBUG: Replace access to removed values field (ENUM$VALUES) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static Align[] valuesCustom() {
            Align[] valuesCustom = values();
            int length = valuesCustom.length;
            Align[] alignArr = new Align[length];
            System.arraycopy(valuesCustom, 0, alignArr, 0, length);
            return alignArr;
        }
    }

    static /* synthetic */ int[] $SWITCH_TABLE$cn$jingling$lib$filters$ImageSelection$Align() {
        int[] iArr = $SWITCH_TABLE$cn$jingling$lib$filters$ImageSelection$Align;
        if (iArr == null) {
            iArr = new int[Align.valuesCustom().length];
            try {
                iArr[Align.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Align.LEFT_TOP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Align.RIGHT_BOTTOM.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $SWITCH_TABLE$cn$jingling$lib$filters$ImageSelection$Align = iArr;
        }
        return iArr;
    }

    public ImageSelection(int width, int height) {
        this.mWidth = width;
        this.mHeight = height;
        this.mSelection = new int[this.mWidth * this.mHeight];
    }

    public ImageSelection(ImageSelection imageSelection) {
        this.mWidth = imageSelection.getWidth();
        this.mHeight = imageSelection.getHeight();
        try {
            this.mSelection = (int[]) imageSelection.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    public Bitmap getSelectedBitmap(Bitmap bm) {
        int w = bm.getWidth();
        int h = bm.getHeight();
        int[] pixels = new int[w * h];
        bm.getPixels(pixels, 0, w, 0, 0, w, h);
        for (int i = 0; i < w * h; i++) {
            int c = pixels[i];
            pixels[i] = Color.argb(this.mSelection[i], Color.red(c), Color.green(c), Color.blue(c));
        }
        Bitmap rst = Bitmap.createBitmap(pixels, w, h, bm.getConfig());
        return rst;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int[] getPixels() {
        return this.mSelection;
    }

    public void selectAll() {
        for (int i = 0; i < this.mWidth * this.mHeight; i++) {
            this.mSelection[i] = 255;
        }
    }

    public void reverse() {
        for (int i = 0; i < this.mWidth * this.mHeight; i++) {
            this.mSelection[i] = 255 - this.mSelection[i];
        }
    }

    public void setPoint(int x, int y, int value) {
        this.mSelection[(this.mWidth * y) + x] = value;
    }

    public void selectSquare(int width, int height, Align align) {
        selectSquare(width, height, align, 0, 0);
    }

    public void selectSquare(int width, int height, Align align, int roundCornerRadius, int featherSize) {
        int y;
        int x;
        switch ($SWITCH_TABLE$cn$jingling$lib$filters$ImageSelection$Align()[align.ordinal()]) {
            case 1:
                y = (this.mHeight - height) / 2;
                x = (this.mWidth - width) / 2;
                break;
            case 2:
            default:
                y = 0;
                x = 0;
                break;
            case 3:
                y = this.mHeight - height;
                x = this.mWidth - width;
                break;
        }
        for (int i = 0; i < this.mHeight; i++) {
            for (int j = 0; j < this.mWidth; j++) {
                if (i >= y && i < y + height && j >= x && j < x + width) {
                    if (isOutTheCorner(width, height, j - x, i - y, roundCornerRadius)) {
                        this.mSelection[(this.mWidth * i) + j] = 0;
                    } else {
                        this.mSelection[(this.mWidth * i) + j] = getSquareFeatherValue(width, height, j - x, i - y, featherSize);
                    }
                } else {
                    this.mSelection[(this.mWidth * i) + j] = 0;
                }
            }
        }
    }

    public void selectRound(int r, Align align) {
        selectRound(r, align, 0);
    }

    public void selectRound(int r, Align align, int featherSize) {
        int y;
        int x;
        switch ($SWITCH_TABLE$cn$jingling$lib$filters$ImageSelection$Align()[align.ordinal()]) {
            case 1:
                y = this.mHeight / 2;
                x = this.mWidth / 2;
                break;
            case 2:
            default:
                y = r;
                x = r;
                break;
            case 3:
                y = this.mHeight - r;
                x = this.mWidth - r;
                break;
        }
        selectRound(x, y, r, featherSize);
    }

    public void selectRound(int x, int y, int r, int featherSize) {
        int r2 = r * r;
        int fr2 = (r - featherSize) * (r - featherSize);
        for (int i = 0; i < this.mHeight; i++) {
            for (int j = 0; j < this.mWidth; j++) {
                int d2 = dist2(i, j, y, x);
                if (d2 < fr2) {
                    this.mSelection[(this.mWidth * i) + j] = 255;
                } else if (d2 < r2) {
                    int d = (int) Math.sqrt(d2);
                    this.mSelection[(this.mWidth * i) + j] = ((r - d) * MotionEventCompat.ACTION_MASK) / featherSize;
                } else {
                    this.mSelection[(this.mWidth * i) + j] = 0;
                }
            }
        }
    }

    private boolean isOutTheCorner(int w, int h, int x, int y, int r) {
        if (r == 0) {
            return false;
        }
        int r2 = r * r;
        if (x >= r || y >= r || dist2(x, y, r, r) <= r2) {
            if (x <= w - r || y >= r || dist2(x, y, w - r, r) <= r2) {
                if (x >= r || y <= h - r || dist2(x, y, r, h - r) <= r2) {
                    return x > w - r && y > h - r && dist2(x, y, w - r, h - r) > r2;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    private int getSquareFeatherValue(int w, int h, int x, int y, int featherSize) {
        if (featherSize == 0) {
            return MotionEventCompat.ACTION_MASK;
        }
        double rate = 1.0d;
        if (x < featherSize) {
            rate = (x * 1.0d) / featherSize;
        }
        if (x > w - featherSize) {
            rate = ((w - x) * rate) / featherSize;
        }
        if (y < featherSize) {
            rate = (y * rate) / featherSize;
        }
        if (y > h - featherSize) {
            rate = ((h - y) * rate) / featherSize;
        }
        return (int) (255.0d * rate);
    }

    private int dist2(int x1, int y1, int x2, int y2) {
        return ((x1 - x2) * (x1 - x2)) + ((y1 - y2) * (y1 - y2));
    }
}
