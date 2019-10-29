package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class BdBaseViewPagerAdapter<T extends m, V extends a> extends PagerAdapter implements View.OnClickListener {
    private Context context;
    private HashMap<BdUniqueId, c<T, V>> csV = new HashMap<>();
    private List<m> mListData = new ArrayList();
    private List<View> csW = new ArrayList();
    private int mChildCount = 0;

    public void a(Context context, c<T, V> cVar) {
        if (cVar != null && cVar.getType() != null) {
            this.csV.put(cVar.getType(), cVar);
        }
    }

    public BdBaseViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c<T, V> cVar;
        a ba = ba(view);
        if (ba != null && ba.aom() != null && ba.aom().getType() != null && (cVar = this.csV.get(ba.aom().getType())) != null && cVar.aoq() != null) {
            cVar.aoq().c(ba, ba.aom());
        }
    }

    public void setDatas(List<m> list) {
        if (list != null && list.size() > 0) {
            destory();
            this.mListData = list;
            if (this.csW == null) {
                this.csW = new ArrayList();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mListData.size()) {
                    m mVar = this.mListData.get(i2);
                    if (mVar != null) {
                        View a2 = a(mVar);
                        a2.setOnClickListener(this);
                        this.csW.add(a2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private View a(m mVar) {
        c<T, V> cVar = this.csV.get(mVar.getType());
        if (cVar != null) {
            V p = cVar.p(null);
            if (BdBaseApplication.getInst().isDebugMode()) {
                BdLog.i("ViewPager View is creating " + p.getClass().getName());
            }
            if (p != null) {
                p.b(mVar);
                cVar.a(null, p, mVar);
                return p.getView();
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
        if (this.csW.size() > 0 && i >= 0 && i < this.csW.size() && (view = this.csW.get(i)) != null) {
            viewGroup.removeView(view);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i >= this.mListData.size()) {
            return null;
        }
        View iX = iX(i);
        if (iX != null && iX.getParent() != viewGroup) {
            viewGroup.addView(iX);
            return iX;
        }
        return iX;
    }

    public View iX(int i) {
        if (i >= this.csW.size() || i >= this.mListData.size()) {
            return null;
        }
        View view = this.csW.get(i);
        a ba = ba(view);
        if (ba != null && ba.aom() == null) {
            a((a) view.getTag(), this.mListData.get(i));
            return view;
        }
        return view;
    }

    private void a(a aVar, m mVar) {
        c<T, V> cVar;
        if (aVar != null && mVar != null && (cVar = this.csV.get(mVar.getType())) != null) {
            aVar.b(mVar);
            cVar.a(null, aVar, mVar);
        }
    }

    private a ba(View view) {
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
        if (this.csW != null) {
            for (View view : this.csW) {
                a ba = ba(view);
                if (ba != null && ba.aom() != null && (cVar = this.csV.get(ba.aom().getType())) != null) {
                    cVar.b(ba, ba.aom());
                }
            }
            this.csW.clear();
            this.csW = null;
        }
        if (this.mListData != null) {
            this.mListData.clear();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int csX = 3;
        private m csY = null;
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

        public m aom() {
            return this.csY;
        }

        public void b(m mVar) {
            this.csY = mVar;
        }
    }
}
