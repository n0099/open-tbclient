package com.baidu.searchbox.crius.ui.recycler;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.crius.CriusNode;
import com.baidu.searchbox.crius.parser.CriusData;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/crius/ui/recycler/CriusRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/baidu/searchbox/crius/parser/CriusData;", "criusData", "Lcom/baidu/searchbox/crius/parser/CriusData;", "getCriusData", "()Lcom/baidu/searchbox/crius/parser/CriusData;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/baidu/searchbox/crius/parser/CriusData;)V", "lib-crius_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class CriusRecyclerView extends RecyclerView {
    public HashMap _$_findViewCache;
    public final CriusData criusData;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view2 = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view2 == null) {
            View findViewById = findViewById(i);
            this._$_findViewCache.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CriusRecyclerView(Context context, CriusData criusData) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(criusData, "criusData");
        this.criusData = criusData;
        CriusNode criusNode = criusData.criusNode;
        Intrinsics.checkNotNullExpressionValue(criusNode, "criusData.criusNode");
        criusNode.setData(this);
    }

    public final CriusData getCriusData() {
        return this.criusData;
    }
}
