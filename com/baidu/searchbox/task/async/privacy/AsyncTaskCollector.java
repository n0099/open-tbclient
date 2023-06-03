package com.baidu.searchbox.task.async.privacy;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tieba.el1;
import com.baidu.tieba.eo5;
import com.baidu.tieba.fo5;
import com.baidu.tieba.gl1;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016R\u001e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/task/async/privacy/AsyncTaskCollector;", "Lcom/baidu/tbadk/module/home/IAsyncTaskCollector;", "()V", "asyncTaskListHolder", "Lcom/baidu/pyramid/annotation/component/ListHolder;", "getAsyncTaskListHolder", "()Lcom/baidu/pyramid/annotation/component/ListHolder;", "asyncList", "", "Lcom/baidu/searchbox/performance/speed/task/LaunchTask;", "Main_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AsyncTaskCollector implements eo5 {
    @Inject
    public final gl1<eo5> asyncTaskListHolder;

    public void initasyncTaskListHolder() {
        el1 b = el1.b();
        this.asyncTaskListHolder = b;
        b.a(new fo5());
    }

    public AsyncTaskCollector() {
        initasyncTaskListHolder();
    }

    @Override // com.baidu.tieba.eo5
    public List<LaunchTask> asyncList() {
        List<eo5> list;
        ArrayList arrayList = new ArrayList();
        gl1<eo5> gl1Var = this.asyncTaskListHolder;
        if (gl1Var != null) {
            list = gl1Var.getList();
        } else {
            list = null;
        }
        if (list != null) {
            for (eo5 eo5Var : list) {
                arrayList.addAll(eo5Var.asyncList());
            }
        }
        return arrayList;
    }

    public final gl1<eo5> getAsyncTaskListHolder() {
        return this.asyncTaskListHolder;
    }
}
