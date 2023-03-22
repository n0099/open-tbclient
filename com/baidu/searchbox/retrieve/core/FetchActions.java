package com.baidu.searchbox.retrieve.core;

import android.text.TextUtils;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.retrieve.inter.IFetchJob;
import com.baidu.searchbox.retrieve.inter.IFetchJob_FetchActions_ListProvider;
import com.baidu.tieba.bj1;
import com.baidu.tieba.dj1;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class FetchActions {
    public static final boolean DEBUG = AppConfig.isDebug();
    @Inject
    public dj1<IFetchJob> mFetchCommandList;

    public void initmFetchCommandList() {
        bj1 b = bj1.b();
        this.mFetchCommandList = b;
        b.a(new IFetchJob_FetchActions_ListProvider());
    }

    /* loaded from: classes2.dex */
    public static class Inner {
        public static final FetchActions sInstance = new FetchActions(null);
    }

    public FetchActions() {
    }

    public static FetchActions getInstance() {
        return Inner.sInstance;
    }

    public /* synthetic */ FetchActions(AnonymousClass1 anonymousClass1) {
        this();
        initmFetchCommandList();
    }

    public List<IFetchJob> getFetchCommandList() {
        List<IFetchJob> list;
        dj1<IFetchJob> dj1Var = this.mFetchCommandList;
        if (dj1Var == null || (list = dj1Var.getList()) == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        boolean z = false;
        try {
            for (IFetchJob iFetchJob : list) {
                String fetchJobType = iFetchJob.getFetchJobType();
                if (TextUtils.isEmpty(fetchJobType)) {
                    arrayList.add(iFetchJob);
                    z = true;
                    if (DEBUG) {
                        throw new RuntimeException("only debug mode has this crash ===>>>> local fetch type is null ");
                    }
                } else if (arrayList2.contains(fetchJobType)) {
                    arrayList3.add(iFetchJob);
                } else {
                    arrayList2.add(fetchJobType);
                }
            }
            if (z) {
                list.removeAll(arrayList);
            }
            return list;
        } catch (Exception e) {
            if (!DEBUG) {
                return null;
            }
            throw e;
        }
    }
}
