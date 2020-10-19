package com.baidu.down.request.taskmanager;

import android.util.Log;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes9.dex */
public class ByteArrayInfoMng {
    private static final boolean DEBUG = false;
    private static final String TAG = "ByteArrayInfoMng";
    public static int mMaxByteSize = 100;
    private boolean mAllocateMemory;
    private Queue<ByteArrayInfo> mByteArrayGetList;
    private Queue<ByteArrayInfo> mByteArrayRecycleList;
    private int mCurDataCount = 0;

    public ByteArrayInfoMng() {
        this.mByteArrayGetList = null;
        this.mByteArrayRecycleList = null;
        this.mAllocateMemory = false;
        this.mByteArrayGetList = new LinkedList();
        this.mByteArrayRecycleList = new LinkedList();
        this.mAllocateMemory = false;
    }

    public void initByteArray(int i) {
        if (!this.mAllocateMemory) {
            for (int i2 = 0; i2 < i; i2++) {
                this.mByteArrayGetList.offer(new ByteArrayInfo());
            }
            this.mCurDataCount = mMaxByteSize;
            this.mAllocateMemory = true;
        }
    }

    public void recycleByteArray() {
        this.mByteArrayGetList.clear();
        this.mByteArrayRecycleList.clear();
        this.mAllocateMemory = false;
        this.mCurDataCount = 0;
    }

    public synchronized ByteArrayInfo getByteArray() {
        ByteArrayInfo poll;
        if (this.mByteArrayGetList.size() == 0 && this.mByteArrayRecycleList.size() != 0) {
            synchronized (this.mByteArrayRecycleList) {
                this.mByteArrayGetList.addAll(this.mByteArrayRecycleList);
                this.mByteArrayRecycleList.clear();
            }
        }
        poll = this.mByteArrayGetList.poll();
        if (poll == null) {
            if (this.mCurDataCount >= mMaxByteSize * 2) {
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                poll = getByteArray();
            } else {
                poll = new ByteArrayInfo();
                this.mCurDataCount++;
            }
        }
        poll.mRecycled = false;
        return poll;
    }

    public void recycle(ByteArrayInfo byteArrayInfo) {
        if (byteArrayInfo != null && this.mByteArrayRecycleList != null) {
            synchronized (this.mByteArrayRecycleList) {
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
    }
}
