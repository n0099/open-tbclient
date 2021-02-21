package com.baidu.tbadk.core.flow;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.aa;
import com.baidu.tbadk.core.flow.a.a;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.h;
import com.baidu.tieba.recapp.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowAdapter<T extends com.baidu.tbadk.core.flow.a.a> extends PagerAdapter {
    private Context context;
    private View.OnClickListener eWS;
    private a eWV;
    private ArrayList<TbImageView> eWR = new ArrayList<>();
    private ArrayList<T> dataList = new ArrayList<>();
    private ArrayList<TbImageView> eWT = new ArrayList<>();
    private ArrayList<RelativeLayout> eWU = new ArrayList<>();

    public CoverFlowAdapter(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.eWS = onClickListener;
    }

    public T oo(int i) {
        if (this.dataList == null || this.dataList.isEmpty() || i < 0 || i >= this.dataList.size()) {
            return null;
        }
        return this.dataList.get(i);
    }

    public void a(List<T> list, a aVar) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (list != null && !list.isEmpty()) {
            this.eWV = aVar;
            this.dataList.clear();
            this.dataList.addAll(list);
            D(this.dataList);
            int size = this.eWR.size();
            int size2 = this.dataList.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    TbImageView V = aVar.V(this.context);
                    this.eWR.add(V);
                    tbImageView = aVar.V(this.context);
                    this.eWT.add(tbImageView);
                    this.eWU.add(new RelativeLayout(this.context));
                    tbImageView2 = V;
                } else {
                    tbImageView = this.eWT.get(i);
                    this.eWU.get(i);
                    tbImageView2 = this.eWR.get(i);
                }
                if (this.dataList.get(i) != null && tbImageView2 != null) {
                    if (this.dataList.get(i) instanceof h) {
                        tbImageView2.setImageDrawable(ap.getDrawable(Integer.valueOf(this.dataList.get(i).getPicUrl()).intValue()));
                    } else {
                        tbImageView2.startLoad(this.dataList.get(i).getPicUrl(), 10, false);
                    }
                    tbImageView2.setOnClickListener(this.eWS);
                    if ((this.dataList.get(i) instanceof aa) && !((aa) this.dataList.get(i)).blY()) {
                        aa aaVar = (aa) this.dataList.get(i);
                        t.b(aaVar.blV(), tbImageView, aaVar.blW(), l.getDimens(this.context, R.dimen.ds24));
                    }
                }
            }
            int count = y.getCount(this.dataList);
            int count2 = y.getCount(this.eWR);
            if (count2 > count) {
                y.removeSubList(this.eWR, count, count2);
            }
            int count3 = y.getCount(this.eWT);
            if (count3 > count) {
                y.removeSubList(this.eWT, count, count3);
            }
            int count4 = y.getCount(this.eWU);
            if (count4 > count) {
                y.removeSubList(this.eWU, count, count4);
            }
            notifyDataSetChanged();
        }
    }

    private void D(ArrayList<T> arrayList) {
        int size;
        if (arrayList != null && (size = arrayList.size()) > 1) {
            arrayList.add(0, arrayList.get(size - 1));
            arrayList.add(arrayList.get(0));
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (this.eWR != null && this.eWR.size() > 0) {
            return this.eWR.size();
        }
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.eWR == null) {
            return super.instantiateItem(viewGroup, i);
        }
        TbImageView tbImageView = (TbImageView) y.getItem(this.eWR, i);
        if (tbImageView == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if ((y.getItem(this.dataList, i) instanceof aa) && !((aa) y.getItem(this.dataList, i)).blY()) {
            RelativeLayout relativeLayout = (RelativeLayout) y.getItem(this.eWU, i);
            TbImageView tbImageView2 = (TbImageView) y.getItem(this.eWT, i);
            relativeLayout.removeView(tbImageView2);
            if (tbImageView.getParent() != null) {
                ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
            }
            relativeLayout.addView(tbImageView, new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.eWV.brh() == null) {
                layoutParams.addRule(12);
                layoutParams.addRule(9);
            } else {
                layoutParams.setMargins(0, l.getDimens(this.context, R.dimen.ds220) - l.getDimens(this.context, R.dimen.ds24), 0, 0);
            }
            relativeLayout.addView(tbImageView2, layoutParams);
            if (relativeLayout.getParent() == null) {
                viewGroup.addView(relativeLayout, new ViewGroup.LayoutParams(-1, -1));
            }
            tbImageView.setTag(Integer.valueOf(i));
            return relativeLayout;
        }
        if (tbImageView.getParent() != null) {
            ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
        }
        if (tbImageView.getParent() == null) {
            viewGroup.addView(tbImageView, new ViewGroup.LayoutParams(-1, -1));
        }
        tbImageView.setTag(Integer.valueOf(i));
        tbImageView.refresh();
        return tbImageView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (obj instanceof View) {
            viewGroup.removeView((View) obj);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    public void onChangeSkinType() {
        if (this.eWR != null && this.eWR.size() > 0) {
            Iterator<TbImageView> it = this.eWR.iterator();
            while (it.hasNext()) {
                it.next().refresh();
            }
        }
    }
}
