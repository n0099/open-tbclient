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
    private View.OnClickListener bPb;
    private a bPe;
    private Context context;
    private ArrayList<TbImageView> bPa = new ArrayList<>();
    private ArrayList<T> dataList = new ArrayList<>();
    private ArrayList<TbImageView> bPc = new ArrayList<>();
    private ArrayList<RelativeLayout> bPd = new ArrayList<>();

    public CoverFlowAdapter(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.bPb = onClickListener;
    }

    public T hM(int i) {
        if (this.dataList == null || this.dataList.isEmpty() || i < 0 || i >= this.dataList.size()) {
            return null;
        }
        return this.dataList.get(i);
    }

    public void a(List<T> list, a aVar) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (list != null && !list.isEmpty()) {
            this.bPe = aVar;
            this.dataList.clear();
            this.dataList.addAll(list);
            t(this.dataList);
            int size = this.bPa.size();
            int size2 = this.dataList.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    TbImageView cm = aVar.cm(this.context);
                    this.bPa.add(cm);
                    tbImageView = aVar.cm(this.context);
                    this.bPc.add(tbImageView);
                    this.bPd.add(new RelativeLayout(this.context));
                    tbImageView2 = cm;
                } else {
                    tbImageView = this.bPc.get(i);
                    this.bPd.get(i);
                    tbImageView2 = this.bPa.get(i);
                }
                if (this.dataList.get(i) != null && tbImageView2 != null) {
                    tbImageView2.startLoad(this.dataList.get(i).getPicUrl(), 10, false);
                    tbImageView2.setOnClickListener(this.bPb);
                    if ((this.dataList.get(i) instanceof s) && !((s) this.dataList.get(i)).acY()) {
                        s sVar = (s) this.dataList.get(i);
                        com.baidu.tieba.recapp.s.b(sVar.acV(), tbImageView, sVar.acW(), l.g(this.context, R.dimen.ds24));
                    }
                }
            }
            int Z = v.Z(this.dataList);
            int Z2 = v.Z(this.bPa);
            if (Z2 > Z) {
                v.d(this.bPa, Z, Z2);
            }
            int Z3 = v.Z(this.bPc);
            if (Z3 > Z) {
                v.d(this.bPc, Z, Z3);
            }
            int Z4 = v.Z(this.bPd);
            if (Z4 > Z) {
                v.d(this.bPd, Z, Z4);
            }
            notifyDataSetChanged();
        }
    }

    private void t(ArrayList<T> arrayList) {
        int size;
        if (arrayList != null && (size = arrayList.size()) > 1) {
            arrayList.add(0, arrayList.get(size - 1));
            arrayList.add(arrayList.get(0));
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.bPa != null && this.bPa.size() > 0) {
            return this.bPa.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.bPa == null) {
            return super.instantiateItem(viewGroup, i);
        }
        TbImageView tbImageView = (TbImageView) v.c(this.bPa, i);
        if (tbImageView == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if ((v.c(this.dataList, i) instanceof s) && !((s) v.c(this.dataList, i)).acY()) {
            RelativeLayout relativeLayout = (RelativeLayout) v.c(this.bPd, i);
            TbImageView tbImageView2 = (TbImageView) v.c(this.bPc, i);
            relativeLayout.removeView(tbImageView2);
            if (tbImageView.getParent() != null) {
                ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
            }
            relativeLayout.addView(tbImageView, new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.bPe.ahl() == null) {
                layoutParams.addRule(12);
                layoutParams.addRule(9);
            } else {
                layoutParams.setMargins(0, l.g(this.context, R.dimen.ds220) - l.g(this.context, R.dimen.ds24), 0, 0);
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
        if (this.bPa != null && this.bPa.size() > 0) {
            Iterator<TbImageView> it = this.bPa.iterator();
            while (it.hasNext()) {
                it.next().refresh();
            }
        }
    }
}
