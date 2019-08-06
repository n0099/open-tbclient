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
    private View.OnClickListener bOA;
    private a bOD;
    private Context context;
    private ArrayList<TbImageView> bOz = new ArrayList<>();
    private ArrayList<T> dataList = new ArrayList<>();
    private ArrayList<TbImageView> bOB = new ArrayList<>();
    private ArrayList<RelativeLayout> bOC = new ArrayList<>();

    public CoverFlowAdapter(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.bOA = onClickListener;
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
            this.bOD = aVar;
            this.dataList.clear();
            this.dataList.addAll(list);
            t(this.dataList);
            int size = this.bOz.size();
            int size2 = this.dataList.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    TbImageView cm = aVar.cm(this.context);
                    this.bOz.add(cm);
                    tbImageView = aVar.cm(this.context);
                    this.bOB.add(tbImageView);
                    this.bOC.add(new RelativeLayout(this.context));
                    tbImageView2 = cm;
                } else {
                    tbImageView = this.bOB.get(i);
                    this.bOC.get(i);
                    tbImageView2 = this.bOz.get(i);
                }
                if (this.dataList.get(i) != null && tbImageView2 != null) {
                    tbImageView2.startLoad(this.dataList.get(i).getPicUrl(), 10, false);
                    tbImageView2.setOnClickListener(this.bOA);
                    if ((this.dataList.get(i) instanceof s) && !((s) this.dataList.get(i)).acU()) {
                        s sVar = (s) this.dataList.get(i);
                        com.baidu.tieba.recapp.s.b(sVar.acR(), tbImageView, sVar.acS(), l.g(this.context, R.dimen.ds24));
                    }
                }
            }
            int Z = v.Z(this.dataList);
            int Z2 = v.Z(this.bOz);
            if (Z2 > Z) {
                v.d(this.bOz, Z, Z2);
            }
            int Z3 = v.Z(this.bOB);
            if (Z3 > Z) {
                v.d(this.bOB, Z, Z3);
            }
            int Z4 = v.Z(this.bOC);
            if (Z4 > Z) {
                v.d(this.bOC, Z, Z4);
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
        if (this.bOz != null && this.bOz.size() > 0) {
            return this.bOz.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.bOz == null) {
            return super.instantiateItem(viewGroup, i);
        }
        TbImageView tbImageView = (TbImageView) v.c(this.bOz, i);
        if (tbImageView == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if ((v.c(this.dataList, i) instanceof s) && !((s) v.c(this.dataList, i)).acU()) {
            RelativeLayout relativeLayout = (RelativeLayout) v.c(this.bOC, i);
            TbImageView tbImageView2 = (TbImageView) v.c(this.bOB, i);
            relativeLayout.removeView(tbImageView2);
            if (tbImageView.getParent() != null) {
                ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
            }
            relativeLayout.addView(tbImageView, new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.bOD.ahh() == null) {
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
        if (this.bOz != null && this.bOz.size() > 0) {
            Iterator<TbImageView> it = this.bOz.iterator();
            while (it.hasNext()) {
                it.next().refresh();
            }
        }
    }
}
