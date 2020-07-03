package com.baidu.tbadk.core.flow;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.w;
import com.baidu.tbadk.core.flow.a.a;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowAdapter<T extends com.baidu.tbadk.core.flow.a.a> extends PagerAdapter {
    private Context context;
    private View.OnClickListener dQw;
    private a dQz;
    private ArrayList<TbImageView> dQv = new ArrayList<>();
    private ArrayList<T> dataList = new ArrayList<>();
    private ArrayList<TbImageView> dQx = new ArrayList<>();
    private ArrayList<RelativeLayout> dQy = new ArrayList<>();

    public CoverFlowAdapter(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.dQw = onClickListener;
    }

    public T lg(int i) {
        if (this.dataList == null || this.dataList.isEmpty() || i < 0 || i >= this.dataList.size()) {
            return null;
        }
        return this.dataList.get(i);
    }

    public void a(List<T> list, a aVar) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (list != null && !list.isEmpty()) {
            this.dQz = aVar;
            this.dataList.clear();
            this.dataList.addAll(list);
            B(this.dataList);
            int size = this.dQv.size();
            int size2 = this.dataList.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    TbImageView S = aVar.S(this.context);
                    this.dQv.add(S);
                    tbImageView = aVar.S(this.context);
                    this.dQx.add(tbImageView);
                    this.dQy.add(new RelativeLayout(this.context));
                    tbImageView2 = S;
                } else {
                    tbImageView = this.dQx.get(i);
                    this.dQy.get(i);
                    tbImageView2 = this.dQv.get(i);
                }
                if (this.dataList.get(i) != null && tbImageView2 != null) {
                    tbImageView2.startLoad(this.dataList.get(i).getPicUrl(), 10, false);
                    tbImageView2.setOnClickListener(this.dQw);
                    if ((this.dataList.get(i) instanceof w) && !((w) this.dataList.get(i)).aQA()) {
                        w wVar = (w) this.dataList.get(i);
                        r.b(wVar.aQx(), tbImageView, wVar.aQy(), l.getDimens(this.context, R.dimen.ds24));
                    }
                }
            }
            int count = com.baidu.tbadk.core.util.w.getCount(this.dataList);
            int count2 = com.baidu.tbadk.core.util.w.getCount(this.dQv);
            if (count2 > count) {
                com.baidu.tbadk.core.util.w.removeSubList(this.dQv, count, count2);
            }
            int count3 = com.baidu.tbadk.core.util.w.getCount(this.dQx);
            if (count3 > count) {
                com.baidu.tbadk.core.util.w.removeSubList(this.dQx, count, count3);
            }
            int count4 = com.baidu.tbadk.core.util.w.getCount(this.dQy);
            if (count4 > count) {
                com.baidu.tbadk.core.util.w.removeSubList(this.dQy, count, count4);
            }
            notifyDataSetChanged();
        }
    }

    private void B(ArrayList<T> arrayList) {
        int size;
        if (arrayList != null && (size = arrayList.size()) > 1) {
            arrayList.add(0, arrayList.get(size - 1));
            arrayList.add(arrayList.get(0));
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.dQv != null && this.dQv.size() > 0) {
            return this.dQv.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.dQv == null) {
            return super.instantiateItem(viewGroup, i);
        }
        TbImageView tbImageView = (TbImageView) com.baidu.tbadk.core.util.w.getItem(this.dQv, i);
        if (tbImageView == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if ((com.baidu.tbadk.core.util.w.getItem(this.dataList, i) instanceof w) && !((w) com.baidu.tbadk.core.util.w.getItem(this.dataList, i)).aQA()) {
            RelativeLayout relativeLayout = (RelativeLayout) com.baidu.tbadk.core.util.w.getItem(this.dQy, i);
            TbImageView tbImageView2 = (TbImageView) com.baidu.tbadk.core.util.w.getItem(this.dQx, i);
            relativeLayout.removeView(tbImageView2);
            if (tbImageView.getParent() != null) {
                ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
            }
            relativeLayout.addView(tbImageView, new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.dQz.aVh() == null) {
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
        if (this.dQv != null && this.dQv.size() > 0) {
            Iterator<TbImageView> it = this.dQv.iterator();
            while (it.hasNext()) {
                it.next().refresh();
            }
        }
    }
}
