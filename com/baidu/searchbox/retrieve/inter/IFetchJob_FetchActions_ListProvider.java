package com.baidu.searchbox.retrieve.inter;

import com.baidu.searchbox.download.center.clearcache.DiskFetchLogJob;
import com.baidu.searchbox.retrieve.file.FetchFileJob;
import com.baidu.searchbox.retrieve.log.FetchLogJob;
import com.baidu.searchbox.retrieve.timer.FetchTimerCancelJob;
import com.baidu.searchbox.retrieve.timer.FetchTimerJob;
import com.baidu.tieba.lk1;
import com.baidu.tieba.w8b;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class IFetchJob_FetchActions_ListProvider implements lk1 {
    @Override // com.baidu.tieba.lk1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new DiskFetchLogJob());
        arrayList.add(new FetchFileJob());
        arrayList.add(new FetchLogJob());
        arrayList.add(new FetchTimerCancelJob());
        arrayList.add(new FetchTimerJob());
        arrayList.add(new w8b());
        return arrayList;
    }
}
