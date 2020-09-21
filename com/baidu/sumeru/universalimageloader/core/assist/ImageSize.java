package com.baidu.sumeru.universalimageloader.core.assist;
/* loaded from: classes9.dex */
public class ImageSize {
    private static final String SEPARATOR = "x";
    private static final int TO_STRING_MAX_LENGHT = 9;
    private final int height;
    private final int width;

    public ImageSize(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public ImageSize(int i, int i2, int i3) {
        if (i3 % 180 == 0) {
            this.width = i;
            this.height = i2;
            return;
        }
        this.width = i2;
        this.height = i;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public ImageSize scaleDown(int i) {
        return new ImageSize(this.width / i, this.height / i);
    }

    public ImageSize scale(float f) {
        return new ImageSize((int) (this.width * f), (int) (this.height * f));
    }

    public String toString() {
        return new StringBuilder(9).append(this.width).append("x").append(this.height).toString();
    }
}
