package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class BdBaseViewPagerAdapter<T extends o, V extends a> extends PagerAdapter implements View.OnClickListener {
    private Context context;
    private HashMap<BdUniqueId, c<T, V>> dZb = new HashMap<>();
    private List<o> mListData = new ArrayList();
    private List<View> dZc = new ArrayList();
    private int mChildCount = 0;

    public void a(Context context, c<T, V> cVar) {
        if (cVar != null && cVar.getType() != null) {
            this.dZb.put(cVar.getType(), cVar);
        }
    }

    public BdBaseViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c<T, V> cVar;
        a bd = bd(view);
        if (bd != null && bd.oX() != null && bd.oX().getType() != null && (cVar = this.dZb.get(bd.oX().getType())) != null && cVar.aXh() != null) {
            cVar.aXh().c(bd, bd.oX());
        }
    }

    public void setDatas(List<o> list) {
        if (list != null && list.size() > 0) {
            destory();
            this.mListData = list;
            if (this.dZc == null) {
                this.dZc = new ArrayList();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mListData.size()) {
                    o oVar = this.mListData.get(i2);
                    if (oVar != null) {
                        View b = b(oVar);
                        b.setOnClickListener(this);
                        this.dZc.add(b);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private View b(o oVar) {
        c<T, V> cVar = this.dZb.get(oVar.getType());
        if (cVar != null) {
            V y = cVar.y(null);
            if (BdBaseApplication.getInst().isDebugMode()) {
                BdLog.i("ViewPager View is creating " + y.getClass().getName());
            }
            if (y != null) {
                y.a(oVar);
                cVar.a(null, y, oVar);
                return y.getView();
            }
        }
        return null;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.mListData.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(Object obj) {
        if (this.mChildCount > 0) {
            this.mChildCount--;
            return -2;
        }
        return super.getItemPosition(obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void notifyDataSetChanged() {
        this.mChildCount = getCount();
        super.notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        View view;
        if (this.dZc.size() > 0 && i >= 0 && i < this.dZc.size() && (view = this.dZc.get(i)) != null) {
            viewGroup.removeView(view);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i >= this.mListData.size()) {
            return null;
        }
        View mt = mt(i);
        if (mt != null && mt.getParent() != viewGroup) {
            viewGroup.addView(mt);
            return mt;
        }
        return mt;
    }

    public View mt(int i) {
        if (i >= this.dZc.size() || i >= this.mListData.size()) {
            return null;
        }
        View view = this.dZc.get(i);
        a bd = bd(view);
        if (bd != null && bd.oX() == null) {
            a((a) view.getTag(), this.mListData.get(i));
            return view;
        }
        return view;
    }

    private void a(a aVar, o oVar) {
        c<T, V> cVar;
        if (aVar != null && oVar != null && (cVar = this.dZb.get(oVar.getType())) != null) {
            aVar.a(oVar);
            cVar.a(null, aVar, oVar);
        }
    }

    private a bd(View view) {
        if (view == null || !(view.getTag() instanceof a)) {
            return null;
        }
        return (a) view.getTag();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Parcelable saveState() {
        return super.saveState();
    }

    public void destory() {
        c<T, V> cVar;
        if (this.dZc != null) {
            for (View view : this.dZc) {
                a bd = bd(view);
                if (bd != null && bd.oX() != null && (cVar = this.dZb.get(bd.oX().getType())) != null) {
                    cVar.b(bd, bd.oX());
                }
            }
            this.dZc.clear();
            this.dZc = null;
        }
        if (this.mListData != null) {
            this.mListData.clear();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int agt = 3;
        private o dZd = null;
        private View view;

        public a(View view) {
            this.view = null;
            this.view = view;
            if (this.view == null) {
                throw new RuntimeException("view cannt be null");
            }
            this.view.setTag(this);
        }

        public View getView() {
            return this.view;
        }

        public o oX() {
            return this.dZd;
        }

        public void a(o oVar) {
            this.dZd = oVar;
        }
    }
}
