package com.baidu.searchbox.retrieve.inter;

import com.baidu.searchbox.download.center.clearcache.DiskFetchLogJob;
import com.baidu.searchbox.retrieve.file.FetchFileJob;
import com.baidu.searchbox.retrieve.log.FetchLogJob;
import com.baidu.searchbox.retrieve.timer.FetchTimerCancelJob;
import com.baidu.searchbox.retrieve.timer.FetchTimerJob;
import com.baidu.tieba.bj1;
import com.baidu.tieba.x8a;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class IFetchJob_FetchActions_ListProvider implements bj1 {
    @Override // com.baidu.tieba.bj1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new DiskFetchLogJob());
        arrayList.add(new FetchFileJob());
        arrayList.add(new FetchLogJob());
        arrayList.add(new FetchTimerCancelJob());
        arrayList.add(new FetchTimerJob());
        arrayList.add(new x8a());
        return arrayList;
    }
}
