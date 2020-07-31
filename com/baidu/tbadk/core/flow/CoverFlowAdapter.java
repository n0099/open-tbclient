package com.baidu.tbadk.core.flow;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.x;
import com.baidu.tbadk.core.flow.a.a;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowAdapter<T extends com.baidu.tbadk.core.flow.a.a> extends PagerAdapter {
    private Context context;
    private View.OnClickListener dWO;
    private a dWR;
    private ArrayList<TbImageView> dWN = new ArrayList<>();
    private ArrayList<T> dataList = new ArrayList<>();
    private ArrayList<TbImageView> dWP = new ArrayList<>();
    private ArrayList<RelativeLayout> dWQ = new ArrayList<>();

    public CoverFlowAdapter(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.dWO = onClickListener;
    }

    public T lA(int i) {
        if (this.dataList == null || this.dataList.isEmpty() || i < 0 || i >= this.dataList.size()) {
            return null;
        }
        return this.dataList.get(i);
    }

    public void a(List<T> list, a aVar) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (list != null && !list.isEmpty()) {
            this.dWR = aVar;
            this.dataList.clear();
            this.dataList.addAll(list);
            C(this.dataList);
            int size = this.dWN.size();
            int size2 = this.dataList.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    TbImageView S = aVar.S(this.context);
                    this.dWN.add(S);
                    tbImageView = aVar.S(this.context);
                    this.dWP.add(tbImageView);
                    this.dWQ.add(new RelativeLayout(this.context));
                    tbImageView2 = S;
                } else {
                    tbImageView = this.dWP.get(i);
                    this.dWQ.get(i);
                    tbImageView2 = this.dWN.get(i);
                }
                if (this.dataList.get(i) != null && tbImageView2 != null) {
                    tbImageView2.startLoad(this.dataList.get(i).getPicUrl(), 10, false);
                    tbImageView2.setOnClickListener(this.dWO);
                    if ((this.dataList.get(i) instanceof x) && !((x) this.dataList.get(i)).aUw()) {
                        x xVar = (x) this.dataList.get(i);
                        s.b(xVar.aUt(), tbImageView, xVar.aUu(), l.getDimens(this.context, R.dimen.ds24));
                    }
                }
            }
            int count = com.baidu.tbadk.core.util.x.getCount(this.dataList);
            int count2 = com.baidu.tbadk.core.util.x.getCount(this.dWN);
            if (count2 > count) {
                com.baidu.tbadk.core.util.x.removeSubList(this.dWN, count, count2);
            }
            int count3 = com.baidu.tbadk.core.util.x.getCount(this.dWP);
            if (count3 > count) {
                com.baidu.tbadk.core.util.x.removeSubList(this.dWP, count, count3);
            }
            int count4 = com.baidu.tbadk.core.util.x.getCount(this.dWQ);
            if (count4 > count) {
                com.baidu.tbadk.core.util.x.removeSubList(this.dWQ, count, count4);
            }
            notifyDataSetChanged();
        }
    }

    private void C(ArrayList<T> arrayList) {
        int size;
        if (arrayList != null && (size = arrayList.size()) > 1) {
            arrayList.add(0, arrayList.get(size - 1));
            arrayList.add(arrayList.get(0));
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.dWN != null && this.dWN.size() > 0) {
            return this.dWN.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.dWN == null) {
            return super.instantiateItem(viewGroup, i);
        }
        TbImageView tbImageView = (TbImageView) com.baidu.tbadk.core.util.x.getItem(this.dWN, i);
        if (tbImageView == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if ((com.baidu.tbadk.core.util.x.getItem(this.dataList, i) instanceof x) && !((x) com.baidu.tbadk.core.util.x.getItem(this.dataList, i)).aUw()) {
            RelativeLayout relativeLayout = (RelativeLayout) com.baidu.tbadk.core.util.x.getItem(this.dWQ, i);
            TbImageView tbImageView2 = (TbImageView) com.baidu.tbadk.core.util.x.getItem(this.dWP, i);
            relativeLayout.removeView(tbImageView2);
            if (tbImageView.getParent() != null) {
                ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
            }
            relativeLayout.addView(tbImageView, new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.dWR.aZh() == null) {
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

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (obj instanceof View) {
            viewGroup.removeView((View) obj);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    public void onChangeSkinType() {
        if (this.dWN != null && this.dWN.size() > 0) {
            Iterator<TbImageView> it = this.dWN.iterator();
            while (it.hasNext()) {
                it.next().refresh();
            }
        }
    }
}
