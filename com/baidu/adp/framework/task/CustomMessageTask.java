package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class CustomMessageTask extends MessageTask {
    private CustomRunnable<?> fk;
    private TASK_TYPE fl;
    private boolean fm;
    private BdAsyncTaskParallel fn;

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
        this.fk = null;
        this.fl = TASK_TYPE.ASYNCHRONIZED;
        this.fm = false;
        this.fn = null;
        this.fk = customRunnable;
    }

    public CustomRunnable<?> bB() {
        return this.fk;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.s(this.mCmd);
    }

    public TASK_TYPE bC() {
        return this.fl;
    }

    public void a(TASK_TYPE task_type) {
        this.fl = task_type;
    }

    public boolean bD() {
        return this.fm;
    }

    public BdAsyncTaskParallel bE() {
        return this.fn;
    }

    public void a(BdAsyncTaskParallel bdAsyncTaskParallel) {
        this.fn = bdAsyncTaskParallel;
    }
}
