package com.baidu.tbadk.core.util;

import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Handler;
import android.widget.ImageView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.lang.ref.SoftReference;
/* loaded from: classes3.dex */
public class FramesSequenceAnimation {
    public Bitmap mBitmap;
    public BitmapFactory.Options mBitmapOptions;
    public int mDelayMillis;
    public int[] mFrames;
    public OnAnimationStoppedListener mOnAnimationStoppedListener;
    public int mRepeatTimes;
    public SoftReference<ImageView> mSoftReferenceImageView;
    public int times = 1;
    public Handler mHandler = new Handler();
    public int mIndex = -1;
    public boolean mShouldRun = false;
    public boolean mIsRunning = false;

    /* loaded from: classes3.dex */
    public interface OnAnimationStoppedListener {
        void AnimationStopped();
    }

    public FramesSequenceAnimation(ImageView imageView, int i, int i2, int i3) {
        this.mBitmap = null;
        this.mFrames = getData(i);
        this.mSoftReferenceImageView = new SoftReference<>(imageView);
        this.mDelayMillis = 1000 / i2;
        this.mRepeatTimes = i3;
        imageView.setImageResource(this.mFrames[0]);
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                this.mBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
                BitmapFactory.Options options = new BitmapFactory.Options();
                this.mBitmapOptions = options;
                options.inBitmap = this.mBitmap;
                options.inMutable = true;
                options.inSampleSize = 1;
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    public static FramesSequenceAnimation createProgressDialogAnim(ImageView imageView, int i, int i2, int i3) {
        return new FramesSequenceAnimation(imageView, i, i2, i3);
    }

    private int[] getData(int i) {
        TypedArray obtainTypedArray = TbadkCoreApplication.getInst().getResources().obtainTypedArray(i);
        int length = obtainTypedArray.length();
        int[] iArr = new int[obtainTypedArray.length()];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = obtainTypedArray.getResourceId(i2, 0);
        }
        obtainTypedArray.recycle();
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNext() {
        int i = this.mIndex + 1;
        this.mIndex = i;
        if (i + 1 >= this.mFrames.length) {
            this.times++;
        }
        if (this.mIndex >= this.mFrames.length) {
            this.mIndex = 0;
        }
        return this.mFrames[this.mIndex];
    }

    public void setOnAnimStopListener(OnAnimationStoppedListener onAnimationStoppedListener) {
        this.mOnAnimationStoppedListener = onAnimationStoppedListener;
    }

    public synchronized void start(ImageView imageView) {
        this.mShouldRun = true;
        if (this.mIsRunning) {
            return;
        }
        if (this.mSoftReferenceImageView.get() == null) {
            this.mSoftReferenceImageView = new SoftReference<>(imageView);
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.tbadk.core.util.FramesSequenceAnimation.1
            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap;
                ImageView imageView2 = (ImageView) FramesSequenceAnimation.this.mSoftReferenceImageView.get();
                if (!FramesSequenceAnimation.this.mShouldRun || imageView2 == null || FramesSequenceAnimation.this.times > FramesSequenceAnimation.this.mRepeatTimes) {
                    FramesSequenceAnimation.this.mIsRunning = false;
                    if (FramesSequenceAnimation.this.mOnAnimationStoppedListener != null) {
                        FramesSequenceAnimation.this.mOnAnimationStoppedListener.AnimationStopped();
                    }
                    if (FramesSequenceAnimation.this.mBitmap == null || FramesSequenceAnimation.this.mBitmap.isRecycled()) {
                        return;
                    }
                    FramesSequenceAnimation.this.mBitmap.recycle();
                    FramesSequenceAnimation.this.mBitmap = null;
                    return;
                }
                FramesSequenceAnimation.this.mIsRunning = true;
                FramesSequenceAnimation.this.mHandler.postDelayed(this, FramesSequenceAnimation.this.mDelayMillis);
                if (imageView2.isShown()) {
                    int next = FramesSequenceAnimation.this.getNext();
                    if (FramesSequenceAnimation.this.mBitmap != null && !FramesSequenceAnimation.this.mBitmap.isRecycled()) {
                        try {
                            bitmap = BitmapFactory.decodeResource(imageView2.getResources(), next, FramesSequenceAnimation.this.mBitmapOptions);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            bitmap = null;
                        }
                        if (bitmap != null) {
                            imageView2.setImageBitmap(bitmap);
                            return;
                        }
                        imageView2.setImageResource(next);
                        FramesSequenceAnimation.this.mBitmap.recycle();
                        FramesSequenceAnimation.this.mBitmap = null;
                        return;
                    }
                    imageView2.setImageResource(next);
                }
            }
        });
    }

    public synchronized void stop() {
        this.mShouldRun = false;
        this.mSoftReferenceImageView.clear();
        this.mIsRunning = false;
        this.mIndex = -1;
        this.times = 1;
    }
}
