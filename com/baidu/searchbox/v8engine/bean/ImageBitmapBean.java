package com.baidu.searchbox.v8engine.bean;

import android.graphics.Bitmap;
/* loaded from: classes3.dex */
public class ImageBitmapBean {
    private static final boolean DEBUG = false;
    private static final String TAG = "ImageBitmapBean";
    private int byteCount;
    private Bitmap mBitmap;
    private int mRefCount = 0;
    private final String mSrc;

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public ImageBitmapBean(String str, Bitmap bitmap) {
        this.mSrc = str;
        this.mBitmap = bitmap;
        this.byteCount = bitmap.getByteCount();
    }

    public void increaseRefCount() {
        this.mRefCount++;
    }

    public void decreaseRefCount() {
        this.mRefCount--;
    }

    public void reset() {
        if (this.mBitmap != null) {
            this.mBitmap.recycle();
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

    public String getSrc() {
        return this.mSrc;
    }

    public int getBitmapByteCount() {
        return this.byteCount;
    }

    public int getRefCount() {
        return this.mRefCount;
    }

    public String toString() {
        return "ImageBitmapBean{mSrc='" + this.mSrc + "', mRefCount=" + this.mRefCount + ", mBitmap=" + this.mBitmap + ", byteCount=" + this.byteCount + '}';
    }
}
