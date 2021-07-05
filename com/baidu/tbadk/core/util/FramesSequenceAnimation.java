package com.baidu.tbadk.core.util;

import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Handler;
import android.widget.ImageView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.SoftReference;
/* loaded from: classes4.dex */
public class FramesSequenceAnimation {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Bitmap mBitmap;
    public BitmapFactory.Options mBitmapOptions;
    public int mDelayMillis;
    public int[] mFrames;
    public Handler mHandler;
    public int mIndex;
    public boolean mIsRunning;
    public OnAnimationStoppedListener mOnAnimationStoppedListener;
    public int mRepeatTimes;
    public boolean mShouldRun;
    public SoftReference<ImageView> mSoftReferenceImageView;
    public int times;

    /* loaded from: classes4.dex */
    public interface OnAnimationStoppedListener {
        void AnimationStopped();
    }

    public FramesSequenceAnimation(ImageView imageView, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {imageView, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.times = 1;
        this.mBitmap = null;
        this.mHandler = new Handler();
        this.mFrames = getData(i2);
        this.mIndex = -1;
        this.mSoftReferenceImageView = new SoftReference<>(imageView);
        this.mShouldRun = false;
        this.mIsRunning = false;
        this.mDelayMillis = 1000 / i3;
        this.mRepeatTimes = i4;
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

    public static FramesSequenceAnimation createProgressDialogAnim(ImageView imageView, int i2, int i3, int i4) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIII = interceptable.invokeLIII(65549, null, imageView, i2, i3, i4)) == null) ? new FramesSequenceAnimation(imageView, i2, i3, i4) : (FramesSequenceAnimation) invokeLIII.objValue;
    }

    private int[] getData(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65550, this, i2)) == null) {
            TypedArray obtainTypedArray = TbadkCoreApplication.getInst().getResources().obtainTypedArray(i2);
            int length = obtainTypedArray.length();
            int[] iArr = new int[obtainTypedArray.length()];
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = obtainTypedArray.getResourceId(i3, 0);
            }
            obtainTypedArray.recycle();
            return iArr;
        }
        return (int[]) invokeI.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            int i2 = this.mIndex + 1;
            this.mIndex = i2;
            if (i2 + 1 >= this.mFrames.length) {
                this.times++;
            }
            if (this.mIndex >= this.mFrames.length) {
                this.mIndex = 0;
            }
            return this.mFrames[this.mIndex];
        }
        return invokeV.intValue;
    }

    public void setOnAnimStopListener(OnAnimationStoppedListener onAnimationStoppedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onAnimationStoppedListener) == null) {
            this.mOnAnimationStoppedListener = onAnimationStoppedListener;
        }
    }

    public synchronized void start(ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageView) == null) {
            synchronized (this) {
                this.mShouldRun = true;
                if (this.mIsRunning) {
                    return;
                }
                if (this.mSoftReferenceImageView.get() == null) {
                    this.mSoftReferenceImageView = new SoftReference<>(imageView);
                }
                this.mHandler.post(new Runnable(this) { // from class: com.baidu.tbadk.core.util.FramesSequenceAnimation.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ FramesSequenceAnimation this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap bitmap;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            ImageView imageView2 = (ImageView) this.this$0.mSoftReferenceImageView.get();
                            if (!this.this$0.mShouldRun || imageView2 == null || this.this$0.times > this.this$0.mRepeatTimes) {
                                this.this$0.mIsRunning = false;
                                if (this.this$0.mOnAnimationStoppedListener != null) {
                                    this.this$0.mOnAnimationStoppedListener.AnimationStopped();
                                }
                                if (this.this$0.mBitmap == null || this.this$0.mBitmap.isRecycled()) {
                                    return;
                                }
                                this.this$0.mBitmap.recycle();
                                this.this$0.mBitmap = null;
                                return;
                            }
                            this.this$0.mIsRunning = true;
                            this.this$0.mHandler.postDelayed(this, this.this$0.mDelayMillis);
                            if (imageView2.isShown()) {
                                int next = this.this$0.getNext();
                                if (this.this$0.mBitmap != null && !this.this$0.mBitmap.isRecycled()) {
                                    try {
                                        bitmap = BitmapFactory.decodeResource(imageView2.getResources(), next, this.this$0.mBitmapOptions);
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                        bitmap = null;
                                    }
                                    if (bitmap != null) {
                                        imageView2.setImageBitmap(bitmap);
                                        return;
                                    }
                                    imageView2.setImageResource(next);
                                    this.this$0.mBitmap.recycle();
                                    this.this$0.mBitmap = null;
                                    return;
                                }
                                imageView2.setImageResource(next);
                            }
                        }
                    }
                });
            }
        }
    }

    public synchronized void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.mShouldRun = false;
                this.mSoftReferenceImageView.clear();
                this.mIsRunning = false;
                this.mIndex = -1;
                this.times = 1;
            }
        }
    }
}
