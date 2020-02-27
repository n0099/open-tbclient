package com.baidu.android.ext.manage;

import android.support.annotation.NonNull;
import android.util.Log;
/* loaded from: classes13.dex */
public class BasePopTask implements PopFinalCheck, PopItem, Comparable<BasePopTask> {
    static boolean DEBUG = false;
    public static final int MAX_PRIORITY = 0;
    public static final int MIN_PRIORITY = 20;
    boolean isEnforce;
    boolean isEnqueue;
    boolean isResumable;
    PopFinalCheck mFinalCheck;
    PopItem mItem;
    int mPriority;
    String methodShowName;
    Object[] params;

    public int getPriority() {
        return this.mPriority;
    }

    public BasePopTask setPriority(int i) {
        int i2 = i <= 20 ? i : 20;
        if (i2 < 0) {
            i2 = 0;
        }
        this.mPriority = i2;
        return this;
    }

    public PopItem getItem() {
        return this.mItem;
    }

    public BasePopTask setItem(PopItem popItem) {
        this.mItem = popItem;
        return this;
    }

    public boolean isEnqueue() {
        return this.isEnqueue;
    }

    public BasePopTask setEnqueue(boolean z) {
        this.isEnqueue = z;
        return this;
    }

    public boolean isEnforce() {
        return this.isEnforce;
    }

    public BasePopTask setEnforce(boolean z) {
        this.isEnforce = z;
        return this;
    }

    public boolean isResumable() {
        return this.isResumable;
    }

    public BasePopTask setResumable(boolean z) {
        this.isResumable = z;
        return this;
    }

    public BasePopTask setFinalCheck(PopFinalCheck popFinalCheck) {
        this.mFinalCheck = popFinalCheck;
        return this;
    }

    public BasePopTask setShowMethodAndParams(String str, Object... objArr) {
        this.methodShowName = str;
        this.params = objArr;
        return this;
    }

    public BasePopTask(@NonNull PopItem popItem, int i, boolean z, boolean z2, boolean z3, @NonNull String str, Object... objArr) {
        this.mItem = popItem;
        this.isEnqueue = z;
        this.isEnforce = z2;
        this.isResumable = z3;
        setPriority(i);
        setShowMethodAndParams(str, objArr);
    }

    public BasePopTask(@NonNull PopItem popItem, @NonNull String str, Object... objArr) {
        this(popItem, 20, true, false, false, str, objArr);
    }

    public boolean mutexShow() {
        return mutexShow(this.methodShowName, this.params);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[SGET]}, finally: {[SGET, INVOKE, CONST_STR, CONST_STR, INVOKE, INVOKE, IF] complete} */
    @Override // com.baidu.android.ext.manage.PopItem
    public boolean mutexShow(String str, Object... objArr) {
        boolean z = false;
        try {
            if (this.mItem != null) {
                try {
                    z = this.mItem.mutexShow(this.methodShowName, objArr);
                    if (!z) {
                        if (DEBUG) {
                            Log.v(MutexPopManager.TAG, "互斥任务未传入任何参数，将直接进行下一波任务！");
                        }
                        MutexPopManager.doNextTask();
                    }
                } catch (ClassCastException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                    if (DEBUG) {
                        Log.v(MutexPopManager.TAG, "互斥任务未传入任何参数，将直接进行下一波任务！");
                    }
                    MutexPopManager.doNextTask();
                }
            }
            return z;
        } catch (Throwable th) {
            if (DEBUG) {
                Log.v(MutexPopManager.TAG, "互斥任务未传入任何参数，将直接进行下一波任务！");
            }
            MutexPopManager.doNextTask();
            throw th;
        }
    }

    @Override // com.baidu.android.ext.manage.PopItem
    public void mutexDismiss() {
        if (this.mItem != null) {
            this.mItem.mutexDismiss();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(@NonNull BasePopTask basePopTask) {
        return this.mPriority - basePopTask.mPriority;
    }

    @Override // com.baidu.android.ext.manage.PopFinalCheck
    public boolean mutexFinalCheck() {
        return this.mFinalCheck == null || this.mFinalCheck.mutexFinalCheck();
    }

    public boolean execute() {
        return MutexPopManager.execPopTask(this);
    }

    public static int getLowerPriority(int i, int i2) {
        return i > i2 ? i : i2;
    }

    public static int getHigherPriority(int i, int i2) {
        return i < i2 ? i : i2;
    }
}
