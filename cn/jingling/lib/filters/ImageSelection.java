package cn.jingling.lib.filters;

import android.graphics.Bitmap;
import android.graphics.Color;
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

    public ImageSelection(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
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

    private int dist2(int i, int i2, int i3, int i4) {
        return ((i - i3) * (i - i3)) + ((i2 - i4) * (i2 - i4));
    }

    private int getSquareFeatherValue(int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            return 255;
        }
        double d = i3 < i5 ? (1.0d * i3) / i5 : 1.0d;
        if (i3 > i - i5) {
            d = (d * (i - i3)) / i5;
        }
        if (i4 < i5) {
            d = (d * i4) / i5;
        }
        if (i4 > i2 - i5) {
            d = (d * (i2 - i4)) / i5;
        }
        return (int) (d * 255.0d);
    }

    private boolean isOutTheCorner(int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            return false;
        }
        int i6 = i5 * i5;
        if (i3 >= i5 || i4 >= i5 || dist2(i3, i4, i5, i5) <= i6) {
            if (i3 <= i - i5 || i4 >= i5 || dist2(i3, i4, i - i5, i5) <= i6) {
                if (i3 >= i5 || i4 <= i2 - i5 || dist2(i3, i4, i5, i2 - i5) <= i6) {
                    return i3 > i - i5 && i4 > i2 - i5 && dist2(i3, i4, i - i5, i2 - i5) > i6;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int[] getPixels() {
        return this.mSelection;
    }

    public Bitmap getSelectedBitmap(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        for (int i = 0; i < width * height; i++) {
            int i2 = iArr[i];
            iArr[i] = Color.argb(this.mSelection[i], Color.red(i2), Color.green(i2), Color.blue(i2));
        }
        return Bitmap.createBitmap(iArr, width, height, bitmap.getConfig());
    }

    public int getWidth() {
        return this.mWidth;
    }

    public void reverse() {
        for (int i = 0; i < this.mWidth * this.mHeight; i++) {
            this.mSelection[i] = 255 - this.mSelection[i];
        }
    }

    public void selectAll() {
        for (int i = 0; i < this.mWidth * this.mHeight; i++) {
            this.mSelection[i] = 255;
        }
    }

    public void selectRound(int i, int i2, int i3, int i4) {
        int i5 = i3 * i3;
        int i6 = (i3 - i4) * (i3 - i4);
        for (int i7 = 0; i7 < this.mHeight; i7++) {
            for (int i8 = 0; i8 < this.mWidth; i8++) {
                int dist2 = dist2(i7, i8, i2, i);
                if (dist2 < i6) {
                    this.mSelection[(this.mWidth * i7) + i8] = 255;
                } else if (dist2 < i5) {
                    this.mSelection[(this.mWidth * i7) + i8] = ((i3 - ((int) Math.sqrt(dist2))) * 255) / i4;
                } else {
                    this.mSelection[(this.mWidth * i7) + i8] = 0;
                }
            }
        }
    }

    public void selectRound(int i, Align align) {
        selectRound(i, align, 0);
    }

    public void selectRound(int i, Align align, int i2) {
        int i3;
        int i4;
        switch ($SWITCH_TABLE$cn$jingling$lib$filters$ImageSelection$Align()[align.ordinal()]) {
            case 1:
                i3 = this.mHeight / 2;
                i4 = this.mWidth / 2;
                break;
            case 2:
            default:
                i3 = i;
                i4 = i;
                break;
            case 3:
                i3 = this.mHeight - i;
                i4 = this.mWidth - i;
                break;
        }
        selectRound(i4, i3, i, i2);
    }

    public void selectSquare(int i, int i2, Align align) {
        selectSquare(i, i2, align, 0, 0);
    }

    public void selectSquare(int i, int i2, Align align, int i3, int i4) {
        int i5;
        int i6;
        switch ($SWITCH_TABLE$cn$jingling$lib$filters$ImageSelection$Align()[align.ordinal()]) {
            case 1:
                i5 = (this.mHeight - i2) / 2;
                i6 = (this.mWidth - i) / 2;
                break;
            case 2:
            default:
                i5 = 0;
                i6 = 0;
                break;
            case 3:
                i5 = this.mHeight - i2;
                i6 = this.mWidth - i;
                break;
        }
        int i7 = 0;
        while (true) {
            int i8 = i7;
            if (i8 >= this.mHeight) {
                return;
            }
            int i9 = 0;
            while (true) {
                int i10 = i9;
                if (i10 >= this.mWidth) {
                    break;
                }
                if (i8 < i5 || i8 >= i5 + i2 || i10 < i6 || i10 >= i6 + i) {
                    this.mSelection[(this.mWidth * i8) + i10] = 0;
                } else if (isOutTheCorner(i, i2, i10 - i6, i8 - i5, i3)) {
                    this.mSelection[(this.mWidth * i8) + i10] = 0;
                } else {
                    this.mSelection[(this.mWidth * i8) + i10] = getSquareFeatherValue(i, i2, i10 - i6, i8 - i5, i4);
                }
                i9 = i10 + 1;
            }
            i7 = i8 + 1;
        }
    }

    public void setPoint(int i, int i2, int i3) {
        this.mSelection[(this.mWidth * i2) + i] = i3;
    }
}
