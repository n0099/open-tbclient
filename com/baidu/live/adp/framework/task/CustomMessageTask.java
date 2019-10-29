package com.baidu.live.adp.framework.task;

import com.baidu.live.adp.framework.FrameHelper;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.asynctask.BdAsyncTaskParallel;
/* loaded from: classes6.dex */
public class CustomMessageTask extends MessageTask {
    private boolean isImme;
    private BdAsyncTaskParallel mBdAsyncTaskParallel;
    private CustomRunnable<?> mRunnable;
    private TASK_TYPE mType;

    /* loaded from: classes6.dex */
    public interface CustomRunnable<T> {
        CustomResponsedMessage<?> run(CustomMessage<T> customMessage);
    }

    /* loaded from: classes6.dex */
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

    public CustomRunnable<?> getRunnable() {
        return this.mRunnable;
    }

    @Override // com.baidu.live.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.checkCustomCmd(this.mCmd);
    }

    public TASK_TYPE getType() {
        return this.mType;
    }

    public void setType(TASK_TYPE task_type) {
        this.mType = task_type;
    }

    public boolean isImme() {
        return this.isImme;
    }

    public void setImme(boolean z) {
        this.isImme = z;
    }

    public BdAsyncTaskParallel getTaskParallel() {
        return this.mBdAsyncTaskParallel;
    }

    public void setTaskParallel(BdAsyncTaskParallel bdAsyncTaskParallel) {
        this.mBdAsyncTaskParallel = bdAsyncTaskParallel;
    }
}
