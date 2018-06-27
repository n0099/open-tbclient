package com.baidu.tbadk.core.flow;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.r;
import com.baidu.tbadk.core.flow.a.a;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowAdapter<T extends com.baidu.tbadk.core.flow.a.a> extends PagerAdapter {
    private View.OnClickListener amj;
    private a amm;
    private Context context;
    private ArrayList<TbImageView> amh = new ArrayList<>();
    private ArrayList<T> ami = new ArrayList<>();
    private ArrayList<TbImageView> amk = new ArrayList<>();
    private ArrayList<RelativeLayout> aml = new ArrayList<>();

    public CoverFlowAdapter(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.amj = onClickListener;
    }

    public T ct(int i) {
        if (this.ami == null || this.ami.isEmpty() || i < 0 || i >= this.ami.size()) {
            return null;
        }
        return this.ami.get(i);
    }

    public void a(List<T> list, a aVar) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (list != null && !list.isEmpty()) {
            this.amm = aVar;
            this.ami.clear();
            this.ami.addAll(list);
            o(this.ami);
            int size = this.amh.size();
            int size2 = this.ami.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    TbImageView aC = aVar.aC(this.context);
                    this.amh.add(aC);
                    tbImageView = aVar.aC(this.context);
                    this.amk.add(tbImageView);
                    this.aml.add(new RelativeLayout(this.context));
                    tbImageView2 = aC;
                } else {
                    tbImageView = this.amk.get(i);
                    this.aml.get(i);
                    tbImageView2 = this.amh.get(i);
                }
                if (this.ami.get(i) != null && tbImageView2 != null) {
                    tbImageView2.startLoad(this.ami.get(i).getPicUrl(), 10, false);
                    tbImageView2.setOnClickListener(this.amj);
                    if ((this.ami.get(i) instanceof r) && !((r) this.ami.get(i)).ug()) {
                        r rVar = (r) this.ami.get(i);
                        s.b(rVar.ud(), tbImageView, rVar.ue(), l.e(this.context, d.e.ds24));
                    }
                }
            }
            int z = w.z(this.ami);
            int z2 = w.z(this.amh);
            if (z2 > z) {
                w.b(this.amh, z, z2);
            }
            int z3 = w.z(this.amk);
            if (z3 > z) {
                w.b(this.amk, z, z3);
            }
            int z4 = w.z(this.aml);
            if (z4 > z) {
                w.b(this.aml, z, z4);
            }
            notifyDataSetChanged();
        }
    }

    private void o(ArrayList<T> arrayList) {
        int size;
        if (arrayList != null && (size = arrayList.size()) > 1) {
            arrayList.add(0, arrayList.get(size - 1));
            arrayList.add(arrayList.get(0));
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.amh != null && this.amh.size() > 0) {
            return this.amh.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.amh == null) {
            return super.instantiateItem(viewGroup, i);
        }
        TbImageView tbImageView = (TbImageView) w.d(this.amh, i);
        if (tbImageView == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if ((w.d(this.ami, i) instanceof r) && !((r) w.d(this.ami, i)).ug()) {
            RelativeLayout relativeLayout = (RelativeLayout) w.d(this.aml, i);
            TbImageView tbImageView2 = (TbImageView) w.d(this.amk, i);
            relativeLayout.removeView(tbImageView2);
            if (tbImageView.getParent() != null) {
                ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
            }
            relativeLayout.addView(tbImageView, new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.amm.xA() == null) {
                layoutParams.addRule(12);
                layoutParams.addRule(9);
            } else {
                layoutParams.setMargins(0, l.e(this.context, d.e.ds220) - l.e(this.context, d.e.ds24), 0, 0);
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
        if (this.amh != null && this.amh.size() > 0) {
            Iterator<TbImageView> it = this.amh.iterator();
            while (it.hasNext()) {
                it.next().refresh();
            }
        }
    }
}
