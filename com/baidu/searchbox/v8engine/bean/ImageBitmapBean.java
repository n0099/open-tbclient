package com.baidu.searchbox.v8engine.bean;

import android.graphics.Bitmap;
/* loaded from: classes4.dex */
public class ImageBitmapBean {
    public static final boolean DEBUG = false;
    public static final String TAG = "ImageBitmapBean";
    public int byteCount;
    public Bitmap mBitmap;
    public int mRefCount = 0;
    public final String mSrc;

    public ImageBitmapBean(String str, Bitmap bitmap) {
        this.mSrc = str;
        this.mBitmap = bitmap;
        this.byteCount = bitmap.getByteCount();
    }

    public void decreaseRefCount() {
        this.mRefCount--;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public int getBitmapByteCount() {
        return this.byteCount;
    }

    public int getRefCount() {
        return this.mRefCount;
    }

    public String getSrc() {
        return this.mSrc;
    }

    public void increaseRefCount() {
        this.mRefCount++;
    }

    public void reset() {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            bitmap.recycle();
            this.mBitmap = null;
        }
    }

    public boolean resetIfNoUsed() {
        if (this.mRefCount <= 0) {
            reset();
            return true;
        }
        return false;
    }

    public String toString() {
        return "ImageBitmapBean{mSrc='" + this.mSrc + "', mRefCount=" + this.mRefCount + ", mBitmap=" + this.mBitmap + ", byteCount=" + this.byteCount + '}';
    }
}
