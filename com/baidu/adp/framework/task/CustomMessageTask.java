package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class CustomMessageTask extends MessageTask {
    public boolean isImme;
    public BdAsyncTaskParallel mBdAsyncTaskParallel;
    public CustomRunnable<?> mRunnable;
    public TASK_TYPE mType;

    /* loaded from: classes.dex */
    public interface CustomRunnable<T> {
        CustomResponsedMessage<?> run(CustomMessage<T> customMessage);
    }

    /* loaded from: classes.dex */
    public enum TASK_TYPE {
        SYNCHRONIZED,
        ASYNCHRONIZED
    }

    public CustomMessageTask(int i, CustomRunnable<?> customRunnable) {
        super(i);
        this.mRunnable = null;
        this.mType = TASK_TYPE.ASYNCHRONIZED;
        this.isImme = false;
        this.mBdAsyncTaskParallel = null;
        this.mRunnable = customRunnable;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.a(this.mCmd);
    }

    public CustomRunnable<?> getRunnable() {
        return this.mRunnable;
    }

    public BdAsyncTaskParallel getTaskParallel() {
        return this.mBdAsyncTaskParallel;
    }

    public TASK_TYPE getType() {
        return this.mType;
    }

    public boolean isImme() {
        return this.isImme;
    }

    public void setImme(boolean z) {
        this.isImme = z;
    }

    public void setTaskParallel(BdAsyncTaskParallel bdAsyncTaskParallel) {
        this.mBdAsyncTaskParallel = bdAsyncTaskParallel;
    }

    public void setType(TASK_TYPE task_type) {
        this.mType = task_type;
    }
}
