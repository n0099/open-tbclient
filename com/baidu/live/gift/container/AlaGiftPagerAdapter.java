package com.baidu.live.gift.container;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import com.baidu.live.gift.container.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaGiftPagerAdapter extends PagerAdapter {
    private List<View> aXw;

    public AlaGiftPagerAdapter(List<View> list) {
        this.aXw = new ArrayList();
        this.aXw = list;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.aXw == null) {
            return 0;
        }
        return this.aXw.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (i >= 0 && i < getCount()) {
            View view = this.aXw.get(i);
            P(view);
            viewGroup.removeView(view);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        View view = this.aXw.get(i);
        viewGroup.addView(view);
        return view;
    }

    private void P(View view) {
        int i = 0;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                if (viewGroup.getChildAt(i2) instanceof GridView) {
                    GridView gridView = (GridView) viewGroup.getChildAt(i2);
                    while (true) {
                        int i3 = i;
                        if (i3 < gridView.getChildCount()) {
                            View childAt = gridView.getChildAt(i3);
                            if (childAt != null) {
                                Object tag = childAt.getTag();
                                if (tag instanceof a.C0182a) {
                                    ((a.C0182a) tag).recycle();
                                }
                            }
                            i = i3 + 1;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }
}
