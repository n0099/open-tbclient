package com.baidu.tbadk.core.flow;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.r;
import com.baidu.tbadk.core.flow.a.a;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowAdapter<T extends com.baidu.tbadk.core.flow.a.a> extends PagerAdapter {
    private View.OnClickListener adI;
    private a adL;
    private Context context;
    private ArrayList<TbImageView> adG = new ArrayList<>();
    private ArrayList<T> adH = new ArrayList<>();
    private ArrayList<TbImageView> adJ = new ArrayList<>();
    private ArrayList<RelativeLayout> adK = new ArrayList<>();

    public CoverFlowAdapter(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.adI = onClickListener;
    }

    public T cq(int i) {
        if (this.adH == null || this.adH.isEmpty() || i < 0 || i >= this.adH.size()) {
            return null;
        }
        return this.adH.get(i);
    }

    public void a(List<T> list, a aVar) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (list != null && !list.isEmpty()) {
            this.adL = aVar;
            this.adH.clear();
            this.adH.addAll(list);
            k(this.adH);
            int size = this.adG.size();
            int size2 = this.adH.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    TbImageView as = aVar.as(this.context);
                    this.adG.add(as);
                    tbImageView = aVar.as(this.context);
                    this.adJ.add(tbImageView);
                    this.adK.add(new RelativeLayout(this.context));
                    tbImageView2 = as;
                } else {
                    tbImageView = this.adJ.get(i);
                    this.adK.get(i);
                    tbImageView2 = this.adG.get(i);
                }
                if (this.adH.get(i) != null && tbImageView2 != null) {
                    tbImageView2.startLoad(this.adH.get(i).getPicUrl(), 10, false);
                    tbImageView2.setOnClickListener(this.adI);
                    if ((this.adH.get(i) instanceof r) && !((r) this.adH.get(i)).qE()) {
                        r rVar = (r) this.adH.get(i);
                        s.b(rVar.qB(), tbImageView, rVar.qC(), l.e(this.context, d.e.ds24));
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    private void k(ArrayList<T> arrayList) {
        int size;
        if (arrayList != null && (size = arrayList.size()) > 1) {
            arrayList.add(0, arrayList.get(size - 1));
            arrayList.add(arrayList.get(0));
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.adG != null && this.adG.size() > 0) {
            return this.adG.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.adG == null) {
            return super.instantiateItem(viewGroup, i);
        }
        ImageView imageView = (ImageView) v.c(this.adG, i);
        if (imageView == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if ((v.c(this.adH, i) instanceof r) && !((r) v.c(this.adH, i)).qE()) {
            RelativeLayout relativeLayout = (RelativeLayout) v.c(this.adK, i);
            TbImageView tbImageView = (TbImageView) v.c(this.adJ, i);
            relativeLayout.removeView(tbImageView);
            if (imageView.getParent() != null) {
                ((ViewGroup) imageView.getParent()).removeView(imageView);
            }
            relativeLayout.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.adL.tP() == null) {
                layoutParams.addRule(12);
                layoutParams.addRule(9);
            } else {
                layoutParams.setMargins(0, l.e(this.context, d.e.ds220) - l.e(this.context, d.e.ds24), 0, 0);
            }
            relativeLayout.addView(tbImageView, layoutParams);
            if (relativeLayout.getParent() == null) {
                viewGroup.addView(relativeLayout, new ViewGroup.LayoutParams(-1, -1));
            }
            imageView.setTag(Integer.valueOf(i));
            return relativeLayout;
        }
        if (imageView.getParent() == null) {
            viewGroup.addView(imageView, new ViewGroup.LayoutParams(-1, -1));
        }
        imageView.setTag(Integer.valueOf(i));
        return imageView;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view2, Object obj) {
        return view2 == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    public void onChangeSkinType() {
        if (this.adG != null && this.adG.size() > 0) {
            Iterator<TbImageView> it = this.adG.iterator();
            while (it.hasNext()) {
                it.next().invalidate();
            }
        }
    }
}
