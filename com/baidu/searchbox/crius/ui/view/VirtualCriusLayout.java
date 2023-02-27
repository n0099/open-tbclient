package com.baidu.searchbox.crius.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.crius.CriusRuntime;
import com.baidu.searchbox.crius.parser.CriusData;
import com.baidu.searchbox.crius.parser.CriusDataFactory;
import com.baidu.searchbox.crius.ui.view.CriusLayout;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class VirtualCriusLayout extends ViewGroup {
    public final List<View> mChildren;
    public CriusData mCriusData;
    public Map<View, CriusData> mCriusDatas;

    public VirtualCriusLayout(Context context) {
        this(context, null, 0);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof CriusLayout.LayoutParams;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new CriusLayout.LayoutParams(getContext(), attributeSet);
    }

    public VirtualCriusLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void addView(View view2, CriusData criusData) {
        this.mChildren.add(view2);
        this.mCriusDatas.put(view2, criusData);
    }

    public VirtualCriusLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mChildren = new LinkedList();
        this.mCriusDatas = new HashMap();
        this.mCriusData = CriusDataFactory.create(context, this);
        CriusLayout.applyLayoutParams(new CriusLayout.LayoutParams(context, attributeSet), this.mCriusData.criusNode, this);
    }

    public void addView(View view2, int i, CriusData criusData) {
        this.mCriusDatas.put(view2, criusData);
        addView(view2, i);
    }

    public VirtualCriusLayout(Context context, CriusData criusData) {
        super(context, null, 0);
        this.mChildren = new LinkedList();
        this.mCriusDatas = new HashMap();
        this.mCriusData = criusData;
    }

    @Override // android.view.ViewGroup
    public void addView(View view2, int i, ViewGroup.LayoutParams layoutParams) {
        if (view2 instanceof VirtualCriusLayout) {
            VirtualCriusLayout virtualCriusLayout = (VirtualCriusLayout) view2;
            virtualCriusLayout.transferChildren(this);
            if (!this.mCriusDatas.containsKey(view2)) {
                CriusData criusData = virtualCriusLayout.getCriusData();
                CriusData criusData2 = this.mCriusData;
                criusData2.addChildAt(criusData, criusData2.getChildCount());
            }
        } else if (this.mCriusDatas.containsKey(view2)) {
            CriusData criusData3 = this.mCriusDatas.get(view2);
            CriusLayout.applyLayoutParams((CriusLayout.LayoutParams) view2.getLayoutParams(), criusData3.criusNode, view2);
            criusData3.criusNode.setData(view2);
            criusData3.criusNode.setMeasureFunction(new CriusLayout.ViewMeasureFunction());
            addView(view2, criusData3);
        } else {
            CriusData create = CriusDataFactory.create(getContext(), view2);
            CriusLayout.applyLayoutParams(new CriusLayout.LayoutParams(layoutParams), create.criusNode, view2);
            create.criusNode.setData(view2);
            create.criusNode.setMeasureFunction(new CriusLayout.ViewMeasureFunction());
            CriusData criusData4 = this.mCriusData;
            criusData4.addChildAt(create, criusData4.getChildCount());
            addView(view2, create);
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new CriusLayout.LayoutParams(-1, -1);
    }

    public CriusData getCriusData() {
        return this.mCriusData;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new CriusLayout.LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (!AppConfig.isDebug()) {
            return;
        }
        throw new RuntimeException("Attempting to layout a VirtualCriusLayout");
    }

    public void transferChildren(ViewGroup viewGroup) {
        if (viewGroup instanceof VirtualCriusLayout) {
            for (View view2 : this.mChildren) {
                ((VirtualCriusLayout) viewGroup).addView(view2, this.mCriusDatas.get(view2));
            }
        } else if (viewGroup instanceof CriusLayout) {
            for (View view3 : this.mChildren) {
                ((CriusLayout) viewGroup).addView(view3, this.mCriusDatas.get(view3));
            }
        } else if (CriusRuntime.DEBUG) {
            throw new RuntimeException("VirtualCriusLayout cannot transfer children to ViewGroup of type " + viewGroup.getClass().getCanonicalName() + ".  Must either be a VirtualCriusLayout or a CriusLayout.");
        }
        this.mChildren.clear();
    }
}
