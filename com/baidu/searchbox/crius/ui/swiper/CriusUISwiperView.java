package com.baidu.searchbox.crius.ui.swiper;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.baidu.crius.CriusNode;
import com.baidu.searchbox.crius.CriusRuntime;
import com.baidu.searchbox.crius.parser.CriusData;
import com.baidu.searchbox.crius.ui.CriusUI;
/* loaded from: classes2.dex */
public class CriusUISwiperView extends CriusUI<CriusSwiperView> {
    public static final String TAG = "CriusUISwiperView";
    public CriusSwiperAdapter mAdapter;
    public CriusSwiperView mCriusSwiperView;
    public SwiperItemHelper mItemHelper;

    public CriusUISwiperView(Context context, CriusData criusData) {
        super(context, criusData);
    }

    @Override // com.baidu.searchbox.crius.ui.CriusUI, com.baidu.searchbox.crius.ui.RenderImplInterface
    public void insertChild(CriusData criusData, int i) {
        this.mAdapter.appendChildAt(criusData, i);
        this.mCriusSwiperView.resetCurrentIndex();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.crius.ui.CriusUI
    public CriusSwiperView createView(Context context) {
        SwiperItemHelper swiperItemHelper = new SwiperItemHelper();
        this.mItemHelper = swiperItemHelper;
        this.mAdapter = new CriusSwiperAdapter(context, swiperItemHelper);
        CriusSwiperView criusSwiperView = new CriusSwiperView(context);
        this.mCriusSwiperView = criusSwiperView;
        criusSwiperView.init(this.renderObject.swiperAttrs);
        this.mCriusSwiperView.setAdapter(this.mAdapter);
        return this.mCriusSwiperView;
    }

    @Override // com.baidu.searchbox.crius.ui.CriusUI, com.baidu.searchbox.crius.ui.RenderImplInterface
    public void layout(float f, float f2) {
        CriusData criusData;
        CriusData criusData2 = this.renderObject;
        if (criusData2 != null && (criusData = criusData2.parent) != null) {
            if (criusData.isAlignItems("center") && this.renderObject.criusNode.getLayoutWidth() == 0.0f) {
                if (CriusRuntime.DEBUG) {
                    Log.d(TAG, "#CriusUISwiperView#, AlignItems Center, modify default layout!");
                }
                CriusNode criusNode = this.renderObject.criusNode;
                View view2 = (View) criusNode.getData();
                int round = Math.round(f);
                int round2 = Math.round(f2 + this.renderObject.criusNode.getLayoutY());
                view2.measure(View.MeasureSpec.makeMeasureSpec(Math.round(criusNode.getLayoutWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.round(criusNode.getLayoutHeight()), 1073741824));
                view2.layout(round, round2, view2.getMeasuredWidth() + round, view2.getMeasuredHeight() + round2);
                return;
            }
            super.layout(f, f2);
            return;
        }
        super.layout(f, f2);
    }
}
