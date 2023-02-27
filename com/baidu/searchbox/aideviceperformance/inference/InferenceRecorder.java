package com.baidu.searchbox.aideviceperformance.inference;

import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class InferenceRecorder {
    public static final String TAG = "InferenceRecorder";
    public static volatile InferenceRecorder mInstance;
    public Map<String, Integer> mInferenceMap = new HashMap();
    public int mCount = 0;

    public static InferenceRecorder getInstance() {
        if (mInstance == null) {
            synchronized (InferenceRecorder.class) {
                if (mInstance == null) {
                    mInstance = new InferenceRecorder();
                }
            }
        }
        return mInstance;
    }

    public synchronized boolean isInferencing() {
        boolean z;
        if (this.mCount > 0) {
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public synchronized void inferenceStart(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int i = 0;
        if (this.mInferenceMap.containsKey(str)) {
            i = this.mInferenceMap.get(str).intValue();
        }
        this.mInferenceMap.put(str, Integer.valueOf(i + 1));
        this.mCount++;
    }

    public synchronized void inferenceStop(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.mInferenceMap.containsKey(str)) {
            int intValue = this.mInferenceMap.get(str).intValue();
            if (intValue > 0 && this.mCount > 0) {
                int i = intValue - 1;
                if (i == 0) {
                    this.mInferenceMap.remove(str);
                } else {
                    this.mInferenceMap.put(str, Integer.valueOf(i));
                }
                this.mCount--;
            }
            if (InferenceConfig.DEBUG) {
                Log.e(TAG, "Inference count error mCount=" + this.mCount + ", count is " + intValue + " for " + str);
            }
        }
    }
}
