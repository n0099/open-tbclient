package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class CustomMessageTask extends MessageTask {
    private CustomRunnable<?> qE;
    private TASK_TYPE qF;
    private boolean qG;
    private BdAsyncTaskParallel qH;

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
        this.qE = null;
        this.qF = TASK_TYPE.ASYNCHRONIZED;
        this.qG = false;
        this.qH = null;
        this.qE = customRunnable;
    }

    public CustomRunnable<?> eW() {
        return this.qE;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.t(this.mCmd);
    }

    public TASK_TYPE eX() {
        return this.qF;
    }

    public void a(TASK_TYPE task_type) {
        this.qF = task_type;
    }

    public boolean eY() {
        return this.qG;
    }

    public BdAsyncTaskParallel eZ() {
        return this.qH;
    }

    public void a(BdAsyncTaskParallel bdAsyncTaskParallel) {
        this.qH = bdAsyncTaskParallel;
    }
}
