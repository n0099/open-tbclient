package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class CustomMessageTask extends MessageTask {
    private boolean isImme;
    private BdAsyncTaskParallel mBdAsyncTaskParallel;
    private CustomRunnable<?> mRunnable;
    private TASK_TYPE mType;

    /* loaded from: classes.dex */
    public interface CustomRunnable<T> {
        CustomResponsedMessage<?> run(CustomMessage<T> customMessage);
    }

    /* loaded from: classes.dex */
    public enum TASK_TYPE {
        SYNCHRONIZED,
        ASYNCHRONIZED;

        /* JADX DEBUG: Replace access to removed values field (ENUM$VALUES) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static TASK_TYPE[] valuesCustom() {
            TASK_TYPE[] valuesCustom = values();
            int length = valuesCustom.length;
            TASK_TYPE[] task_typeArr = new TASK_TYPE[length];
            System.arraycopy(valuesCustom, 0, task_typeArr, 0, length);
            return task_typeArr;
        }
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

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.L(this.mCmd);
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
