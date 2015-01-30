package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class CustomMessageTask extends MessageTask {
    private CustomRunnable<?> fm;
    private TASK_TYPE fn;
    private boolean fo;
    private BdAsyncTaskParallel fp;

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
        this.fm = null;
        this.fn = TASK_TYPE.ASYNCHRONIZED;
        this.fo = false;
        this.fp = null;
        this.fm = customRunnable;
    }

    public CustomRunnable<?> bz() {
        return this.fm;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.s(this.mCmd);
    }

    public TASK_TYPE bA() {
        return this.fn;
    }

    public void a(TASK_TYPE task_type) {
        this.fn = task_type;
    }

    public boolean bB() {
        return this.fo;
    }

    public BdAsyncTaskParallel bC() {
        return this.fp;
    }

    public void a(BdAsyncTaskParallel bdAsyncTaskParallel) {
        this.fp = bdAsyncTaskParallel;
    }
}
