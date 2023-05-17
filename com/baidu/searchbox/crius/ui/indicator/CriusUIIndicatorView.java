package com.baidu.searchbox.crius.ui.indicator;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.baidu.crius.CriusNode;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.crius.parser.CriusData;
import com.baidu.searchbox.crius.ui.CriusUI;
/* loaded from: classes3.dex */
public class CriusUIIndicatorView extends CriusUI<SwiperIndicatorView> {
    public SwiperIndicatorView mIndicatorView;
    public ViewPager mRelatedVp;

    public CriusUIIndicatorView(Context context, CriusData criusData) {
        super(context, criusData);
    }

    private ViewPager getRelatedViewPager() {
        CriusData criusData = this.renderObject.parent;
        if (criusData != null && criusData.children != null) {
            for (int i = 0; i < criusData.children.size(); i++) {
                CriusData criusData2 = criusData.children.get(i);
                if (TextUtils.equals(NativeConstants.TYPE_SWIPER, criusData2.type) && TextUtils.equals(this.renderObject.indicatorAttrs.swiperId, criusData2.swiperAttrs.id)) {
                    return (ViewPager) criusData2.getUI().getView();
                }
            }
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.crius.ui.CriusUI
    public SwiperIndicatorView createView(Context context) {
        ViewPager relatedViewPager = getRelatedViewPager();
        this.mRelatedVp = relatedViewPager;
        if (relatedViewPager == null) {
            return null;
        }
        SwiperIndicatorView swiperIndicatorView = new SwiperIndicatorView(context);
        this.mIndicatorView = swiperIndicatorView;
        swiperIndicatorView.setRenderData(this.renderObject);
        this.mIndicatorView.attachViewPager(this.mRelatedVp);
        return this.mIndicatorView;
    }

    @Override // com.baidu.searchbox.crius.ui.CriusUI, com.baidu.searchbox.crius.ui.RenderImplInterface
    public void layout(float f, float f2) {
        CriusData criusData = this.renderObject;
        if (criusData != null && criusData.parent != null) {
            if (criusData.indicatorAttrs.isHorizontalCenter) {
                if (getView().getVisibility() == 8) {
                    return;
                }
                CriusData criusData2 = this.renderObject;
                CriusNode criusNode = criusData2.criusNode;
                CriusData criusData3 = criusData2.parent;
                View view2 = (View) criusNode.getData();
                float layoutWidth = criusData3.criusNode.getLayoutWidth();
                view2.measure(View.MeasureSpec.makeMeasureSpec(Math.round(criusNode.getLayoutWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.round(criusNode.getLayoutHeight()), 1073741824));
                int round = Math.round(f + ((layoutWidth - view2.getMeasuredWidth()) / 2.0f));
                int round2 = Math.round(f2 + criusNode.getLayoutY());
                view2.layout(round, round2, view2.getMeasuredWidth() + round, view2.getMeasuredHeight() + round2);
                return;
            }
            super.layout(f, f2);
            return;
        }
        super.layout(f, f2);
    }
}
