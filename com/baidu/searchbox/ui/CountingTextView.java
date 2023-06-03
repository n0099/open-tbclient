package com.baidu.searchbox.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes4.dex */
public class CountingTextView extends TextView {
    public static final int FRAME_PER_SECOND = 12;
    public static final int MSG_COUNT = 0;
    public static final int MSG_STOP = 1;
    public boolean mCounting;
    public int mCurrentValue;
    public double mDuration;
    @SuppressLint({"HandlerLeak"})
    public Handler mHandler;
    public OnCountingListener mOnCountingListener;
    public int mPositive;
    public int mStep;
    public int mTargetValue;
    public int mValue;

    /* loaded from: classes4.dex */
    public interface OnCountingListener {
        void onCountingFinished();
    }

    public CountingTextView(Context context) {
        super(context);
        this.mCounting = false;
        this.mCurrentValue = 0;
        this.mTargetValue = 0;
        this.mValue = 0;
        this.mStep = 0;
        this.mPositive = 1;
        this.mDuration = 1.0d;
        this.mHandler = new Handler() { // from class: com.baidu.searchbox.ui.CountingTextView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                boolean z = true;
                if (i != 0) {
                    if (i == 1) {
                        removeMessages(0);
                        CountingTextView.this.mCounting = false;
                        CountingTextView countingTextView = CountingTextView.this;
                        countingTextView.setText(String.valueOf(countingTextView.mTargetValue));
                        if (CountingTextView.this.mOnCountingListener != null) {
                            CountingTextView.this.mOnCountingListener.onCountingFinished();
                            return;
                        }
                        return;
                    }
                    return;
                }
                CountingTextView countingTextView2 = CountingTextView.this;
                if (countingTextView2.mPositive * CountingTextView.this.mCurrentValue >= CountingTextView.this.mTargetValue) {
                    z = false;
                }
                countingTextView2.mCounting = z;
                if (CountingTextView.this.mCounting) {
                    CountingTextView countingTextView3 = CountingTextView.this;
                    countingTextView3.setText(String.valueOf(countingTextView3.mCurrentValue));
                    CountingTextView.this.mCurrentValue += CountingTextView.this.mPositive * CountingTextView.this.mStep;
                    CountingTextView.this.mHandler.sendEmptyMessageDelayed(0, 83L);
                    return;
                }
                CountingTextView countingTextView4 = CountingTextView.this;
                countingTextView4.setText(String.valueOf(countingTextView4.mTargetValue));
                if (CountingTextView.this.mOnCountingListener != null) {
                    CountingTextView.this.mOnCountingListener.onCountingFinished();
                }
            }
        };
        init();
    }

    public void setDuration(long j) {
        if (j < 83) {
            return;
        }
        this.mDuration = j / 1000.0d;
    }

    public void setOnCountingListener(OnCountingListener onCountingListener) {
        this.mOnCountingListener = onCountingListener;
    }

    public void setTargetValue(int i) {
        this.mTargetValue = i;
        this.mValue = i;
        this.mCurrentValue = 0;
    }

    public void startCounting(boolean z) {
        int i;
        int i2;
        if (z) {
            i = 1;
        } else {
            i = -1;
        }
        this.mPositive = i;
        if (z) {
            i2 = this.mValue;
        } else {
            i2 = 0;
        }
        this.mTargetValue = i2;
        int round = (int) Math.round(this.mValue / (this.mDuration * 12.0d));
        this.mStep = round;
        if (round == 0) {
            this.mStep = 1;
        }
        this.mHandler.sendEmptyMessage(0);
    }

    public CountingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCounting = false;
        this.mCurrentValue = 0;
        this.mTargetValue = 0;
        this.mValue = 0;
        this.mStep = 0;
        this.mPositive = 1;
        this.mDuration = 1.0d;
        this.mHandler = new Handler() { // from class: com.baidu.searchbox.ui.CountingTextView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                boolean z = true;
                if (i != 0) {
                    if (i == 1) {
                        removeMessages(0);
                        CountingTextView.this.mCounting = false;
                        CountingTextView countingTextView = CountingTextView.this;
                        countingTextView.setText(String.valueOf(countingTextView.mTargetValue));
                        if (CountingTextView.this.mOnCountingListener != null) {
                            CountingTextView.this.mOnCountingListener.onCountingFinished();
                            return;
                        }
                        return;
                    }
                    return;
                }
                CountingTextView countingTextView2 = CountingTextView.this;
                if (countingTextView2.mPositive * CountingTextView.this.mCurrentValue >= CountingTextView.this.mTargetValue) {
                    z = false;
                }
                countingTextView2.mCounting = z;
                if (CountingTextView.this.mCounting) {
                    CountingTextView countingTextView3 = CountingTextView.this;
                    countingTextView3.setText(String.valueOf(countingTextView3.mCurrentValue));
                    CountingTextView.this.mCurrentValue += CountingTextView.this.mPositive * CountingTextView.this.mStep;
                    CountingTextView.this.mHandler.sendEmptyMessageDelayed(0, 83L);
                    return;
                }
                CountingTextView countingTextView4 = CountingTextView.this;
                countingTextView4.setText(String.valueOf(countingTextView4.mTargetValue));
                if (CountingTextView.this.mOnCountingListener != null) {
                    CountingTextView.this.mOnCountingListener.onCountingFinished();
                }
            }
        };
        init();
    }

    public CountingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCounting = false;
        this.mCurrentValue = 0;
        this.mTargetValue = 0;
        this.mValue = 0;
        this.mStep = 0;
        this.mPositive = 1;
        this.mDuration = 1.0d;
        this.mHandler = new Handler() { // from class: com.baidu.searchbox.ui.CountingTextView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i2 = message.what;
                boolean z = true;
                if (i2 != 0) {
                    if (i2 == 1) {
                        removeMessages(0);
                        CountingTextView.this.mCounting = false;
                        CountingTextView countingTextView = CountingTextView.this;
                        countingTextView.setText(String.valueOf(countingTextView.mTargetValue));
                        if (CountingTextView.this.mOnCountingListener != null) {
                            CountingTextView.this.mOnCountingListener.onCountingFinished();
                            return;
                        }
                        return;
                    }
                    return;
                }
                CountingTextView countingTextView2 = CountingTextView.this;
                if (countingTextView2.mPositive * CountingTextView.this.mCurrentValue >= CountingTextView.this.mTargetValue) {
                    z = false;
                }
                countingTextView2.mCounting = z;
                if (CountingTextView.this.mCounting) {
                    CountingTextView countingTextView3 = CountingTextView.this;
                    countingTextView3.setText(String.valueOf(countingTextView3.mCurrentValue));
                    CountingTextView.this.mCurrentValue += CountingTextView.this.mPositive * CountingTextView.this.mStep;
                    CountingTextView.this.mHandler.sendEmptyMessageDelayed(0, 83L);
                    return;
                }
                CountingTextView countingTextView4 = CountingTextView.this;
                countingTextView4.setText(String.valueOf(countingTextView4.mTargetValue));
                if (CountingTextView.this.mOnCountingListener != null) {
                    CountingTextView.this.mOnCountingListener.onCountingFinished();
                }
            }
        };
        init();
    }

    private void init() {
        setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/custom_font.ttf"));
    }

    public void stopCounting() {
        this.mHandler.sendEmptyMessage(1);
    }
}
