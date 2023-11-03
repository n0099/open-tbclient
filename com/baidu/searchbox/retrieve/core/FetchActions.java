package com.baidu.searchbox.retrieve.core;

import android.text.TextUtils;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.retrieve.inter.IFetchJob;
import com.baidu.searchbox.retrieve.inter.IFetchJob_FetchActions_ListProvider;
import com.baidu.tieba.nf1;
import com.baidu.tieba.pf1;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class FetchActions {
    public static final boolean DEBUG = AppConfig.isDebug();
    @Inject
    public pf1<IFetchJob> mFetchCommandList;

    public void initmFetchCommandList() {
        nf1 b = nf1.b();
        this.mFetchCommandList = b;
        b.a(new IFetchJob_FetchActions_ListProvider());
    }

    /* loaded from: classes4.dex */
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
        pf1<IFetchJob> pf1Var = this.mFetchCommandList;
        if (pf1Var == null || (list = pf1Var.getList()) == null || list.size() == 0) {
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
