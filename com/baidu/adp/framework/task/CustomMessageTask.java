package com.baidu.adp.framework.task;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class CustomMessageTask extends MessageTask {
    private CustomRunnable<?> a;
    private TASK_TYPE b;
    private boolean c;
    private BdAsyncTaskParallel d;

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
        this.a = null;
        this.b = TASK_TYPE.ASYNCHRONIZED;
        this.c = false;
        this.d = null;
        this.a = customRunnable;
    }

    public CustomRunnable<?> a() {
        return this.a;
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        return FrameHelper.d(this.mCmd);
    }

    public TASK_TYPE b() {
        return this.b;
    }

    public void a(TASK_TYPE task_type) {
        this.b = task_type;
    }

    public boolean c() {
        return this.c;
    }

    public BdAsyncTaskParallel d() {
        return this.d;
    }

    public void a(BdAsyncTaskParallel bdAsyncTaskParallel) {
        this.d = bdAsyncTaskParallel;
    }
}
