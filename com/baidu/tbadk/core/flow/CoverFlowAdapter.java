package com.baidu.tbadk.core.flow;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.s;
import com.baidu.tbadk.core.flow.a.a;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowAdapter<T extends com.baidu.tbadk.core.flow.a.a> extends PagerAdapter {
    private View.OnClickListener cfn;
    private a cfq;
    private Context context;
    private ArrayList<TbImageView> cfm = new ArrayList<>();
    private ArrayList<T> dataList = new ArrayList<>();
    private ArrayList<TbImageView> cfo = new ArrayList<>();
    private ArrayList<RelativeLayout> cfp = new ArrayList<>();

    public CoverFlowAdapter(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.cfn = onClickListener;
    }

    public T ig(int i) {
        if (this.dataList == null || this.dataList.isEmpty() || i < 0 || i >= this.dataList.size()) {
            return null;
        }
        return this.dataList.get(i);
    }

    public void a(List<T> list, a aVar) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (list != null && !list.isEmpty()) {
            this.cfq = aVar;
            this.dataList.clear();
            this.dataList.addAll(list);
            w(this.dataList);
            int size = this.cfm.size();
            int size2 = this.dataList.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    TbImageView cl = aVar.cl(this.context);
                    this.cfm.add(cl);
                    tbImageView = aVar.cl(this.context);
                    this.cfo.add(tbImageView);
                    this.cfp.add(new RelativeLayout(this.context));
                    tbImageView2 = cl;
                } else {
                    tbImageView = this.cfo.get(i);
                    this.cfp.get(i);
                    tbImageView2 = this.cfm.get(i);
                }
                if (this.dataList.get(i) != null && tbImageView2 != null) {
                    tbImageView2.startLoad(this.dataList.get(i).getPicUrl(), 10, false);
                    tbImageView2.setOnClickListener(this.cfn);
                    if ((this.dataList.get(i) instanceof s) && !((s) this.dataList.get(i)).ahc()) {
                        s sVar = (s) this.dataList.get(i);
                        com.baidu.tieba.recapp.s.b(sVar.agZ(), tbImageView, sVar.aha(), l.getDimens(this.context, R.dimen.ds24));
                    }
                }
            }
            int count = v.getCount(this.dataList);
            int count2 = v.getCount(this.cfm);
            if (count2 > count) {
                v.removeSubList(this.cfm, count, count2);
            }
            int count3 = v.getCount(this.cfo);
            if (count3 > count) {
                v.removeSubList(this.cfo, count, count3);
            }
            int count4 = v.getCount(this.cfp);
            if (count4 > count) {
                v.removeSubList(this.cfp, count, count4);
            }
            notifyDataSetChanged();
        }
    }

    private void w(ArrayList<T> arrayList) {
        int size;
        if (arrayList != null && (size = arrayList.size()) > 1) {
            arrayList.add(0, arrayList.get(size - 1));
            arrayList.add(arrayList.get(0));
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.cfm != null && this.cfm.size() > 0) {
            return this.cfm.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.cfm == null) {
            return super.instantiateItem(viewGroup, i);
        }
        TbImageView tbImageView = (TbImageView) v.getItem(this.cfm, i);
        if (tbImageView == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if ((v.getItem(this.dataList, i) instanceof s) && !((s) v.getItem(this.dataList, i)).ahc()) {
            RelativeLayout relativeLayout = (RelativeLayout) v.getItem(this.cfp, i);
            TbImageView tbImageView2 = (TbImageView) v.getItem(this.cfo, i);
            relativeLayout.removeView(tbImageView2);
            if (tbImageView.getParent() != null) {
                ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
            }
            relativeLayout.addView(tbImageView, new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.cfq.alg() == null) {
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
        if (this.cfm != null && this.cfm.size() > 0) {
            Iterator<TbImageView> it = this.cfm.iterator();
            while (it.hasNext()) {
                it.next().refresh();
            }
        }
    }
}
