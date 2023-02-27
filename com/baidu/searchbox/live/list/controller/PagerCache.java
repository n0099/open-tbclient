package com.baidu.searchbox.live.list.controller;

import android.util.SparseArray;
import com.baidu.searchbox.live.data.constant.MixTagConstants;
import com.baidu.searchbox.live.list.controller.PagerController;
import com.baidu.searchbox.live.util.ListLogKt;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\b\u0018\u0000B\u0007¢\u0006\u0004\b\u0014\u0010\u0003J\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\n\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bR.\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\r0\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/live/list/controller/PagerCache;", "", "clear", "()V", "", "type", "Lcom/baidu/searchbox/live/list/controller/PagerController$PagerHolder;", "get", "(I)Lcom/baidu/searchbox/live/list/controller/PagerController$PagerHolder;", "holder", "put", "(ILcom/baidu/searchbox/live/list/controller/PagerController$PagerHolder;)V", "Landroid/util/SparseArray;", "", "cache", "Landroid/util/SparseArray;", "getCache", "()Landroid/util/SparseArray;", "setCache", "(Landroid/util/SparseArray;)V", "<init>", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class PagerCache {
    public SparseArray<List<PagerController.PagerHolder>> cache = new SparseArray<>();

    public final void clear() {
        this.cache.clear();
    }

    public final SparseArray<List<PagerController.PagerHolder>> getCache() {
        return this.cache;
    }

    public final PagerController.PagerHolder get(int i) {
        List<PagerController.PagerHolder> list = this.cache.get(i);
        if (list != null && list.size() > 0) {
            PagerController.PagerHolder pagerHolder = list.get(0);
            ListLogKt.log(MixTagConstants.MIX_PAGER, "cache hit type " + i + WebvttCueParser.CHAR_SPACE + pagerHolder);
            list.remove(pagerHolder);
            return pagerHolder;
        }
        ListLogKt.log(MixTagConstants.MIX_PAGER, "cache miss type " + i);
        return null;
    }

    public final void put(int i, PagerController.PagerHolder pagerHolder) {
        List<PagerController.PagerHolder> list = this.cache.get(i);
        if (list == null) {
            list = new ArrayList<>();
            this.cache.put(i, list);
        }
        if (list.size() >= 2) {
            return;
        }
        ListLogKt.log(MixTagConstants.MIX_PAGER, "cache add type " + i);
        list.add(pagerHolder);
    }

    public final void setCache(SparseArray<List<PagerController.PagerHolder>> sparseArray) {
        this.cache = sparseArray;
    }
}
