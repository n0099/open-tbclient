package com.baidu.tbadk.core.flow;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.flow.a.a;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.h;
import com.baidu.tieba.recapp.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowAdapter<T extends com.baidu.tbadk.core.flow.a.a> extends PagerAdapter {
    private Context context;
    private View.OnClickListener eZn;
    private a eZq;
    private ArrayList<TbImageView> eZm = new ArrayList<>();
    private ArrayList<T> dataList = new ArrayList<>();
    private ArrayList<TbImageView> eZo = new ArrayList<>();
    private ArrayList<RelativeLayout> eZp = new ArrayList<>();

    public CoverFlowAdapter(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.eZn = onClickListener;
    }

    public T pQ(int i) {
        if (this.dataList == null || this.dataList.isEmpty() || i < 0 || i >= this.dataList.size()) {
            return null;
        }
        return this.dataList.get(i);
    }

    public void a(List<T> list, a aVar) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (list != null && !list.isEmpty()) {
            this.eZq = aVar;
            this.dataList.clear();
            this.dataList.addAll(list);
            I(this.dataList);
            int size = this.eZm.size();
            int size2 = this.dataList.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    TbImageView W = aVar.W(this.context);
                    this.eZm.add(W);
                    tbImageView = aVar.W(this.context);
                    this.eZo.add(tbImageView);
                    this.eZp.add(new RelativeLayout(this.context));
                    tbImageView2 = W;
                } else {
                    tbImageView = this.eZo.get(i);
                    this.eZp.get(i);
                    tbImageView2 = this.eZm.get(i);
                }
                if (this.dataList.get(i) != null && tbImageView2 != null) {
                    if (this.dataList.get(i) instanceof h) {
                        tbImageView2.setImageDrawable(ao.getDrawable(Integer.valueOf(this.dataList.get(i).getPicUrl()).intValue()));
                    } else {
                        tbImageView2.startLoad(this.dataList.get(i).getPicUrl(), 10, false);
                    }
                    tbImageView2.setOnClickListener(this.eZn);
                    if ((this.dataList.get(i) instanceof z) && !((z) this.dataList.get(i)).bpz()) {
                        z zVar = (z) this.dataList.get(i);
                        s.b(zVar.bpw(), tbImageView, zVar.bpx(), l.getDimens(this.context, R.dimen.ds24));
                    }
                }
            }
            int count = x.getCount(this.dataList);
            int count2 = x.getCount(this.eZm);
            if (count2 > count) {
                x.removeSubList(this.eZm, count, count2);
            }
            int count3 = x.getCount(this.eZo);
            if (count3 > count) {
                x.removeSubList(this.eZo, count, count3);
            }
            int count4 = x.getCount(this.eZp);
            if (count4 > count) {
                x.removeSubList(this.eZp, count, count4);
            }
            notifyDataSetChanged();
        }
    }

    private void I(ArrayList<T> arrayList) {
        int size;
        if (arrayList != null && (size = arrayList.size()) > 1) {
            arrayList.add(0, arrayList.get(size - 1));
            arrayList.add(arrayList.get(0));
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (this.eZm != null && this.eZm.size() > 0) {
            return this.eZm.size();
        }
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.eZm == null) {
            return super.instantiateItem(viewGroup, i);
        }
        TbImageView tbImageView = (TbImageView) x.getItem(this.eZm, i);
        if (tbImageView == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if ((x.getItem(this.dataList, i) instanceof z) && !((z) x.getItem(this.dataList, i)).bpz()) {
            RelativeLayout relativeLayout = (RelativeLayout) x.getItem(this.eZp, i);
            TbImageView tbImageView2 = (TbImageView) x.getItem(this.eZo, i);
            relativeLayout.removeView(tbImageView2);
            if (tbImageView.getParent() != null) {
                ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
            }
            relativeLayout.addView(tbImageView, new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.eZq.buH() == null) {
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
        if (this.eZm != null && this.eZm.size() > 0) {
            Iterator<TbImageView> it = this.eZm.iterator();
            while (it.hasNext()) {
                it.next().refresh();
            }
        }
    }
}
