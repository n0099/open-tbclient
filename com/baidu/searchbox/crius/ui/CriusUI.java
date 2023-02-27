package com.baidu.searchbox.crius.ui;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.crius.CriusNode;
import com.baidu.searchbox.crius.CriusRuntime;
import com.baidu.searchbox.crius.parser.CriusData;
/* loaded from: classes2.dex */
public abstract class CriusUI<T extends View> implements RenderImplInterface {
    public static final String TAG = "CriusUI";
    public T mView;
    public CriusData renderObject;

    public abstract T createView(Context context);

    @Override // com.baidu.searchbox.crius.ui.RenderImplInterface
    public void insertChild(CriusData criusData, int i) {
    }

    @Override // com.baidu.searchbox.crius.ui.RenderImplInterface
    public void removeChild(CriusData criusData) {
    }

    public CriusUI(Context context, CriusData criusData) {
        this.renderObject = criusData;
        this.mView = createView(context);
    }

    private void setHScrollChildLp() {
        int layoutWidth = (int) this.renderObject.criusNode.getLayoutWidth();
        int layoutHeight = (int) this.renderObject.criusNode.getLayoutHeight();
        ViewGroup.LayoutParams layoutParams = this.mView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = layoutWidth;
            layoutParams.height = layoutHeight;
            return;
        }
        this.mView.setLayoutParams(new RecyclerView.LayoutParams(layoutWidth, layoutHeight));
    }

    public void clear() {
        this.mView = null;
    }

    public T getView() {
        return this.mView;
    }

    public void setViewLp() {
        CriusData criusData;
        CriusData criusData2 = this.renderObject;
        if (criusData2 != null && (criusData = criusData2.parent) != null && criusData.isHScroll()) {
            setHScrollChildLp();
        }
    }

    @Nullable
    public View getChildAt(int i) {
        T t = this.mView;
        if (t instanceof ViewGroup) {
            return ((ViewGroup) t).getChildAt(i);
        }
        return null;
    }

    @Override // com.baidu.searchbox.crius.ui.RenderImplInterface
    public void layout(float f, float f2) {
        CriusData criusData = this.renderObject.parent;
        if (criusData != null && criusData.isSwiper()) {
            if (CriusRuntime.DEBUG) {
                Log.d(TAG, "#layoutExp#, parent is swiper, layout nothing...");
                return;
            }
            return;
        }
        CriusData criusData2 = this.renderObject.parent;
        if (criusData2 != null && criusData2.isHScroll()) {
            if (CriusRuntime.DEBUG) {
                Log.d(TAG, "#layoutExp#, parent is RecyclerView, layout nothing...");
                return;
            }
            return;
        }
        CriusNode criusNode = this.renderObject.criusNode;
        View view2 = (View) criusNode.getData();
        if (view2 != null && view2.getVisibility() != 8) {
            int round = Math.round(f + criusNode.getLayoutX());
            int round2 = Math.round(f2 + criusNode.getLayoutY());
            view2.measure(View.MeasureSpec.makeMeasureSpec(Math.round(criusNode.getLayoutWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.round(criusNode.getLayoutHeight()), 1073741824));
            if (CriusRuntime.DEBUG) {
                Log.d(TAG, "#layoutExp#, type=" + this.renderObject.type + ", left=" + round + ", top=" + round2 + ", right=" + (view2.getMeasuredWidth() + round) + ", bottom=" + (view2.getMeasuredHeight() + round2));
            }
            view2.layout(round, round2, view2.getMeasuredWidth() + round, view2.getMeasuredHeight() + round2);
        }
    }
}
