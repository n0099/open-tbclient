package com.baidu.searchbox.task.async.privacy;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tieba.qj5;
import com.baidu.tieba.rj5;
import com.baidu.tieba.we1;
import com.baidu.tieba.ye1;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016R\u001e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/task/async/privacy/AsyncTaskCollector;", "Lcom/baidu/tbadk/module/home/IAsyncTaskCollector;", "()V", "asyncTaskListHolder", "Lcom/baidu/pyramid/annotation/component/ListHolder;", "getAsyncTaskListHolder", "()Lcom/baidu/pyramid/annotation/component/ListHolder;", "asyncList", "", "Lcom/baidu/searchbox/performance/speed/task/LaunchTask;", "Main_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AsyncTaskCollector implements qj5 {
    @Inject
    public final ye1<qj5> asyncTaskListHolder;

    public void initasyncTaskListHolder() {
        we1 b = we1.b();
        this.asyncTaskListHolder = b;
        b.a(new rj5());
    }

    public AsyncTaskCollector() {
        initasyncTaskListHolder();
    }

    @Override // com.baidu.tieba.qj5
    public List<LaunchTask> asyncList() {
        List<qj5> list;
        ArrayList arrayList = new ArrayList();
        ye1<qj5> ye1Var = this.asyncTaskListHolder;
        if (ye1Var != null) {
            list = ye1Var.getList();
        } else {
            list = null;
        }
        if (list != null) {
            for (qj5 qj5Var : list) {
                arrayList.addAll(qj5Var.asyncList());
            }
        }
        return arrayList;
    }

    public final ye1<qj5> getAsyncTaskListHolder() {
        return this.asyncTaskListHolder;
    }
}
