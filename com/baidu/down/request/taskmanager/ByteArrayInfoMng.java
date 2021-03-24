package com.baidu.down.request.taskmanager;

import android.util.Log;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes2.dex */
public class ByteArrayInfoMng {
    public static final boolean DEBUG = false;
    public static final String TAG = "ByteArrayInfoMng";
    public static int mMaxByteSize = 100;
    public boolean mAllocateMemory;
    public Queue<ByteArrayInfo> mByteArrayGetList;
    public Queue<ByteArrayInfo> mByteArrayRecycleList;
    public int mCurDataCount = 0;

    public ByteArrayInfoMng() {
        this.mByteArrayGetList = null;
        this.mByteArrayRecycleList = null;
        this.mAllocateMemory = false;
        this.mByteArrayGetList = new LinkedList();
        this.mByteArrayRecycleList = new LinkedList();
        this.mAllocateMemory = false;
    }

    public synchronized ByteArrayInfo getByteArray() {
        if (this.mByteArrayGetList.size() == 0 && this.mByteArrayRecycleList.size() != 0) {
            synchronized (this.mByteArrayRecycleList) {
                this.mByteArrayGetList.addAll(this.mByteArrayRecycleList);
                this.mByteArrayRecycleList.clear();
            }
        }
        ByteArrayInfo poll = this.mByteArrayGetList.poll();
        if (poll == null) {
            if (this.mCurDataCount >= mMaxByteSize * 2) {
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                return getByteArray();
            }
            poll = new ByteArrayInfo();
            this.mCurDataCount++;
        }
        poll.mRecycled = false;
        return poll;
    }

    public void initByteArray(int i) {
        if (this.mAllocateMemory) {
            return;
        }
        for (int i2 = 0; i2 < i; i2++) {
            this.mByteArrayGetList.offer(new ByteArrayInfo());
        }
        this.mCurDataCount = mMaxByteSize;
        this.mAllocateMemory = true;
    }

    public void recycle(ByteArrayInfo byteArrayInfo) {
        Queue<ByteArrayInfo> queue;
        if (byteArrayInfo == null || (queue = this.mByteArrayRecycleList) == null) {
            return;
        }
        synchronized (queue) {
            if (byteArrayInfo.mRecycled) {
                Log.w(TAG, "### ByteArrayInfo duplicated recycled!");
            } else {
                byteArrayInfo.mRecycled = true;
                if (this.mByteArrayRecycleList != null) {
                    this.mByteArrayRecycleList.offer(byteArrayInfo);
                }
            }
        }
    }

    public void recycleByteArray() {
        this.mByteArrayGetList.clear();
        this.mByteArrayRecycleList.clear();
        this.mAllocateMemory = false;
        this.mCurDataCount = 0;
    }
}
