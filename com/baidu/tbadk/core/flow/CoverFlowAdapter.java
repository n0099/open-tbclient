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
import com.baidu.tieba.recapp.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowAdapter<T extends com.baidu.tbadk.core.flow.a.a> extends PagerAdapter {
    private Context context;
    private View.OnClickListener dJG;
    private a dJJ;
    private ArrayList<TbImageView> dJF = new ArrayList<>();
    private ArrayList<T> dataList = new ArrayList<>();
    private ArrayList<TbImageView> dJH = new ArrayList<>();
    private ArrayList<RelativeLayout> dJI = new ArrayList<>();

    public CoverFlowAdapter(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.dJG = onClickListener;
    }

    public T kQ(int i) {
        if (this.dataList == null || this.dataList.isEmpty() || i < 0 || i >= this.dataList.size()) {
            return null;
        }
        return this.dataList.get(i);
    }

    public void a(List<T> list, a aVar) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (list != null && !list.isEmpty()) {
            this.dJJ = aVar;
            this.dataList.clear();
            this.dataList.addAll(list);
            B(this.dataList);
            int size = this.dJF.size();
            int size2 = this.dataList.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    TbImageView dC = aVar.dC(this.context);
                    this.dJF.add(dC);
                    tbImageView = aVar.dC(this.context);
                    this.dJH.add(tbImageView);
                    this.dJI.add(new RelativeLayout(this.context));
                    tbImageView2 = dC;
                } else {
                    tbImageView = this.dJH.get(i);
                    this.dJI.get(i);
                    tbImageView2 = this.dJF.get(i);
                }
                if (this.dataList.get(i) != null && tbImageView2 != null) {
                    tbImageView2.startLoad(this.dataList.get(i).getPicUrl(), 10, false);
                    tbImageView2.setOnClickListener(this.dJG);
                    if ((this.dataList.get(i) instanceof s) && !((s) this.dataList.get(i)).aOO()) {
                        s sVar = (s) this.dataList.get(i);
                        r.b(sVar.aOL(), tbImageView, sVar.aOM(), l.getDimens(this.context, R.dimen.ds24));
                    }
                }
            }
            int count = v.getCount(this.dataList);
            int count2 = v.getCount(this.dJF);
            if (count2 > count) {
                v.removeSubList(this.dJF, count, count2);
            }
            int count3 = v.getCount(this.dJH);
            if (count3 > count) {
                v.removeSubList(this.dJH, count, count3);
            }
            int count4 = v.getCount(this.dJI);
            if (count4 > count) {
                v.removeSubList(this.dJI, count, count4);
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
        if (this.dJF != null && this.dJF.size() > 0) {
            return this.dJF.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.dJF == null) {
            return super.instantiateItem(viewGroup, i);
        }
        TbImageView tbImageView = (TbImageView) v.getItem(this.dJF, i);
        if (tbImageView == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if ((v.getItem(this.dataList, i) instanceof s) && !((s) v.getItem(this.dataList, i)).aOO()) {
            RelativeLayout relativeLayout = (RelativeLayout) v.getItem(this.dJI, i);
            TbImageView tbImageView2 = (TbImageView) v.getItem(this.dJH, i);
            relativeLayout.removeView(tbImageView2);
            if (tbImageView.getParent() != null) {
                ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
            }
            relativeLayout.addView(tbImageView, new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.dJJ.aTp() == null) {
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
        if (this.dJF != null && this.dJF.size() > 0) {
            Iterator<TbImageView> it = this.dJF.iterator();
            while (it.hasNext()) {
                it.next().refresh();
            }
        }
    }
}
