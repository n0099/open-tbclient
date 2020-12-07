package com.baidu.searchbox.elasticthread.executor;

import android.support.v7.widget.ActivityChooserView;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes16.dex */
public class DredgeDisasterExecutorCell extends BaseDredgeExecutorCell {
    /* JADX INFO: Access modifiers changed from: protected */
    public DredgeDisasterExecutorCell(int i) {
        super(i);
        this.mExecutor = new ThreadPoolExecutor(0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 100L, TimeUnit.MILLISECONDS, new SynchronousQueue());
    }

    @Override // com.baidu.searchbox.elasticthread.executor.BaseExecutorCell
    protected String getTag() {
        return "ElasticDredgeDisasterCell";
    }
}
