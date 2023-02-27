package com.baidu.searchbox.crius.ui.recycler;

import android.util.Log;
import android.view.View;
import com.baidu.searchbox.crius.CriusRuntime;
import com.baidu.searchbox.crius.parser.CriusData;
import com.baidu.searchbox.crius.ui.CriusUI;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\u0018\u0000B\u0007¢\u0006\u0004\b\u0016\u0010\tJ\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/crius/ui/recycler/RecyclableItemHelper;", "Lcom/baidu/searchbox/crius/parser/CriusData;", "criusData", "", "index", "", "appendChildAt", "(Lcom/baidu/searchbox/crius/parser/CriusData;I)V", "clearRenderList", "()V", "viewType", "getCriusData", "(I)Lcom/baidu/searchbox/crius/parser/CriusData;", "getItemCount", "()I", "Lcom/baidu/searchbox/crius/ui/CriusUI;", "Landroid/view/View;", "getItemUI", "(I)Lcom/baidu/searchbox/crius/ui/CriusUI;", "", "renderList", "Ljava/util/List;", "<init>", "lib-crius_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class RecyclableItemHelper {
    public final List<CriusData> renderList = new ArrayList();

    private final void clearRenderList() {
        this.renderList.clear();
    }

    public final int getItemCount() {
        return this.renderList.size();
    }

    public final void appendChildAt(CriusData criusData, int i) {
        Intrinsics.checkNotNullParameter(criusData, "criusData");
        if (i == 0 && getItemCount() > 0) {
            clearRenderList();
        }
        if (CriusRuntime.DEBUG) {
            Log.d(RecyclableItemHelperKt.TAG, "#appendChildAt# index=" + i + ", size=" + getItemCount());
        }
        this.renderList.add(i, criusData);
    }

    public final CriusData getCriusData(int i) {
        return this.renderList.get(i);
    }

    public final CriusUI<View> getItemUI(int i) {
        CriusUI<View> ui = this.renderList.get(i).getUI();
        Intrinsics.checkNotNullExpressionValue(ui, "renderList[viewType].ui");
        return ui;
    }
}
