package com.baidu.nadcore.thread.executor;

import com.baidu.nadcore.thread.task.ElasticTask;
import com.baidu.tieba.p41;
import com.baidu.tieba.r41;
import com.baidu.tieba.s41;
import com.baidu.tieba.t41;
import java.util.LinkedList;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes3.dex */
public abstract class BaseExecutorCell {
    public LinkedList<ElasticTask> a = new LinkedList<>();
    public int b;
    public ThreadPoolExecutor c;

    /* loaded from: classes3.dex */
    public enum ExecutorType {
        ARTERY,
        DREDGE_NORMAL,
        DREDGE_DISASTER,
        SERIAL
    }

    public abstract boolean a();

    public abstract String d();

    /* loaded from: classes3.dex */
    public class a implements ElasticTask.a {
        public final /* synthetic */ ElasticTask a;

        public a(ElasticTask elasticTask) {
            this.a = elasticTask;
        }

        @Override // com.baidu.nadcore.thread.task.ElasticTask.a
        public void afterExecuteTask() {
            BaseExecutorCell.this.g(this.a);
        }

        @Override // com.baidu.nadcore.thread.task.ElasticTask.a
        public void beforeExecuteTask() {
            BaseExecutorCell.this.f(this.a);
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ExecutorType.values().length];
            a = iArr;
            try {
                iArr[ExecutorType.ARTERY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ExecutorType.DREDGE_NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ExecutorType.DREDGE_DISASTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ExecutorType.SERIAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public BaseExecutorCell(int i) {
        this.b = i;
    }

    public synchronized boolean c(ElasticTask elasticTask) {
        if (!a()) {
            return false;
        }
        elasticTask.h(new a(elasticTask));
        this.a.add(elasticTask);
        this.c.execute(elasticTask);
        return true;
    }

    public synchronized void f(ElasticTask elasticTask) {
        elasticTask.g();
        h(elasticTask);
    }

    public synchronized void g(ElasticTask elasticTask) {
        elasticTask.e();
        this.a.remove(elasticTask);
    }

    public static BaseExecutorCell b(int i, ExecutorType executorType) {
        int i2 = b.a[executorType.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        return new s41(i);
                    }
                    return new t41(i);
                }
                return new r41(i);
            }
            return new s41(i);
        }
        return new p41(i);
    }

    public synchronized int e() {
        return this.a.size();
    }

    public final void h(ElasticTask elasticTask) {
        int b2 = elasticTask.b();
        Thread currentThread = Thread.currentThread();
        if (b2 == 0) {
            currentThread.setPriority(9);
        } else if (b2 == 1) {
            currentThread.setPriority(7);
        } else if (b2 == 2) {
            currentThread.setPriority(5);
        } else if (b2 == 3) {
            currentThread.setPriority(3);
        } else if (b2 == 4) {
            currentThread.setPriority(7);
        }
        currentThread.setName(elasticTask.a());
    }
}
