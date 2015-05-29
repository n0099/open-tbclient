package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class CustomMessageTask extends MessageTask {
    private CustomRunnable<?> qI;
    private TASK_TYPE qJ;
    private boolean qK;
    private BdAsyncTaskParallel qL;

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
        this.qI = null;
        this.qJ = TASK_TYPE.ASYNCHRONIZED;
        this.qK = false;
        this.qL = null;
        this.qI = customRunnable;
    }

    public CustomRunnable<?> fa() {
        return this.qI;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.u(this.mCmd);
    }

    public TASK_TYPE fb() {
        return this.qJ;
    }

    public void a(TASK_TYPE task_type) {
        this.qJ = task_type;
    }

    public boolean fc() {
        return this.qK;
    }

    public BdAsyncTaskParallel fd() {
        return this.qL;
    }

    public void a(BdAsyncTaskParallel bdAsyncTaskParallel) {
        this.qL = bdAsyncTaskParallel;
    }
}
