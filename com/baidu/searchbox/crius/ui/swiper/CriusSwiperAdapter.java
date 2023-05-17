package com.baidu.searchbox.crius.ui.swiper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.crius.parser.CriusData;
import com.baidu.searchbox.crius.ui.CriusUI;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b!\u0010\"J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0014\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/baidu/searchbox/crius/ui/swiper/CriusSwiperAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "Lcom/baidu/searchbox/crius/parser/CriusData;", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "", "index", "", "appendChildAt", "(Lcom/baidu/searchbox/crius/parser/CriusData;I)V", "Landroid/view/ViewGroup;", "container", CriusAttrConstants.POSITION, "", "object", "destroyItem", "(Landroid/view/ViewGroup;ILjava/lang/Object;)V", "getCount", "()I", "getItemPosition", "(Ljava/lang/Object;)I", "instantiateItem", "(Landroid/view/ViewGroup;I)Ljava/lang/Object;", "Landroid/view/View;", "view", "", "isViewFromObject", "(Landroid/view/View;Ljava/lang/Object;)Z", "Landroid/content/Context;", "context", "Landroid/content/Context;", "Lcom/baidu/searchbox/crius/ui/swiper/SwiperItemHelper;", "itemHelper", "Lcom/baidu/searchbox/crius/ui/swiper/SwiperItemHelper;", "<init>", "(Landroid/content/Context;Lcom/baidu/searchbox/crius/ui/swiper/SwiperItemHelper;)V", "lib-crius_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class CriusSwiperAdapter extends PagerAdapter {
    public final Context context;
    public final SwiperItemHelper itemHelper;

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object object) {
        Intrinsics.checkNotNullParameter(object, "object");
        return -2;
    }

    public CriusSwiperAdapter(Context context, SwiperItemHelper itemHelper) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(itemHelper, "itemHelper");
        this.context = context;
        this.itemHelper = itemHelper;
    }

    public final void appendChildAt(CriusData child, int i) {
        Intrinsics.checkNotNullParameter(child, "child");
        SwiperItemHelper swiperItemHelper = this.itemHelper;
        if (swiperItemHelper != null) {
            if (i < 0) {
                i = swiperItemHelper.getItemCount();
            }
            swiperItemHelper.appendChildAt(child, i);
        }
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup container, int i) {
        Intrinsics.checkNotNullParameter(container, "container");
        CriusData node = this.itemHelper.getNode(i);
        Intrinsics.checkNotNullExpressionValue(node, "itemHelper.getNode(position)");
        CriusUI ui = node.getUI();
        Intrinsics.checkNotNullExpressionValue(ui, "ui");
        container.addView(ui.getView(), new ViewGroup.LayoutParams(-1, -1));
        View view2 = ui.getView();
        Intrinsics.checkNotNullExpressionValue(view2, "ui.view");
        return view2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view2, Object object) {
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(object, "object");
        return Intrinsics.areEqual(view2, object);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup container, int i, Object object) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(object, "object");
        container.removeView((View) object);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.itemHelper.getItemCount();
    }
}
