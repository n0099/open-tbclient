package com.baidu.searchbox.v8engine.bean;

import android.graphics.Bitmap;
/* loaded from: classes2.dex */
public interface ImageBean {

    /* loaded from: classes2.dex */
    public static class ImageBitmapBean {
        private int byteCount;
        private Bitmap mBitmap;
        private long mEnginePtr;
        private int mMByteCount;
        private int mRefCount = 0;
        private final String mSrc;

        public long getEnginePtr() {
            return this.mEnginePtr;
        }

        public Bitmap getBitmap() {
            return this.mBitmap;
        }

        public ImageBitmapBean(String str, Bitmap bitmap, long j) {
            this.mSrc = str;
            this.mBitmap = bitmap;
            this.mEnginePtr = j;
            this.byteCount = bitmap.getByteCount();
            this.mMByteCount = this.byteCount / 1024;
        }

        public int getKByteCount() {
            return this.mMByteCount;
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
    }

    /* loaded from: classes2.dex */
    public static class ImageSrcBean {
        String src;

        public ImageSrcBean(String str) {
            this.src = str;
        }

        public String getSrc() {
            return this.src;
        }

        public void setSrc(String str) {
            this.src = str;
        }
    }
}
