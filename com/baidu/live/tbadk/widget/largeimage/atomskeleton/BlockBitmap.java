package com.baidu.live.tbadk.widget.largeimage.atomskeleton;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.baidu.live.tbadk.TbConfig;
/* loaded from: classes6.dex */
public class BlockBitmap {
    private static final String TAG = BlockBitmap.class.getSimpleName();
    private Bitmap mBitmap;
    private int mBlockSize;
    private Canvas mCanvas;
    private final Rect mDst;
    private final Position mPosition;
    private final Rect mPositionInOriginBitmap;
    private final Rect mSrc;

    public BlockBitmap(int i) {
        this.mPosition = new Position();
        this.mSrc = new Rect();
        this.mDst = new Rect();
        this.mPositionInOriginBitmap = new Rect();
        this.mBitmap = Bitmap.createBitmap(i, i, TbConfig.BitmapConfig);
        this.mBlockSize = i;
        this.mCanvas = new Canvas();
    }

    public BlockBitmap(Bitmap bitmap) {
        this.mPosition = new Position();
        this.mSrc = new Rect();
        this.mDst = new Rect();
        this.mPositionInOriginBitmap = new Rect();
        if (bitmap != null) {
            this.mBitmap = bitmap;
            this.mSrc.set(0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight());
        }
        this.mCanvas = new Canvas();
    }

    public void clearBitmap() {
        if (this.mBitmap != null && !this.mBitmap.isRecycled() && this.mBitmap.isMutable()) {
            this.mCanvas.setBitmap(this.mBitmap);
            this.mCanvas.drawColor(-1, PorterDuff.Mode.CLEAR);
        }
    }

    public boolean isSizeEqual(Rect rect) {
        return rect != null && rect.right - rect.left == this.mBlockSize && rect.bottom - rect.top == this.mBlockSize;
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public Rect getSrc() {
        return this.mSrc;
    }

    public Rect getDst() {
        return this.mDst;
    }

    public void setDstRect(int i, int i2, int i3, int i4) {
        this.mDst.set(i, i2, i3, i4);
    }

    public void setSrcRect(int i, int i2, int i3, int i4) {
        this.mSrc.set(i, i2, i3, i4);
    }

    public void setPosition(int i, int i2, int i3) {
        this.mPosition.row = i;
        this.mPosition.column = i2;
        this.mPosition.sampleScale = i3;
    }

    public Position getPosition() {
        return this.mPosition;
    }

    public Rect getPositionInOriginBitmap() {
        int i = this.mBlockSize * this.mPosition.column * this.mPosition.sampleScale;
        int i2 = this.mBlockSize * this.mPosition.row * this.mPosition.sampleScale;
        this.mPositionInOriginBitmap.set(i, i2, (this.mBlockSize * this.mPosition.sampleScale) + i, (this.mBlockSize * this.mPosition.sampleScale) + i2);
        return this.mPositionInOriginBitmap;
    }

    /* loaded from: classes6.dex */
    public static class Position {
        int column;
        int row;
        int sampleScale;

        public Position() {
        }

        public Position(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.sampleScale = i3;
        }

        public String toString() {
            return "Position{row=" + this.row + ", column=" + this.column + ", sampleScale=" + this.sampleScale + '}';
        }

        public boolean equals(Object obj) {
            if (obj instanceof Position) {
                Position position = (Position) obj;
                return this.row == position.getRow() && this.column == position.getColumn() && this.sampleScale == position.getSampleScale();
            }
            return false;
        }

        public int hashCode() {
            return (17 * (((this.row + 119) * 17) + this.column)) + (this.sampleScale * 100);
        }

        public int getRow() {
            return this.row;
        }

        public int getColumn() {
            return this.column;
        }

        public int getSampleScale() {
            return this.sampleScale;
        }
    }
}
