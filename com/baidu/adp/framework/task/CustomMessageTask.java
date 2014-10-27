package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class CustomMessageTask extends MessageTask {
    private CustomRunnable<?> de;
    private TASK_TYPE df;
    private boolean dg;
    private BdAsyncTaskParallel dh;

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
        this.de = null;
        this.df = TASK_TYPE.ASYNCHRONIZED;
        this.dg = false;
        this.dh = null;
        this.de = customRunnable;
    }

    public CustomRunnable<?> ba() {
        return this.de;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.g(this.mCmd);
    }

    public TASK_TYPE bb() {
        return this.df;
    }

    public void a(TASK_TYPE task_type) {
        this.df = task_type;
    }

    public boolean bc() {
        return this.dg;
    }

    public BdAsyncTaskParallel bd() {
        return this.dh;
    }

    public void a(BdAsyncTaskParallel bdAsyncTaskParallel) {
        this.dh = bdAsyncTaskParallel;
    }
}
