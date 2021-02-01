package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class BdBaseViewPagerAdapter<T extends n, V extends a> extends PagerAdapter implements View.OnClickListener {
    private Context context;
    private HashMap<BdUniqueId, b<T, V>> foH = new HashMap<>();
    private List<n> mListData = new ArrayList();
    private List<View> foI = new ArrayList();
    private int mChildCount = 0;

    public void a(Context context, b<T, V> bVar) {
        if (bVar != null && bVar.getType() != null) {
            this.foH.put(bVar.getType(), bVar);
        }
    }

    public BdBaseViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b<T, V> bVar;
        a bH = bH(view);
        if (bH != null && bH.qv() != null && bH.qv().getType() != null && (bVar = this.foH.get(bH.qv().getType())) != null && bVar.bvx() != null) {
            bVar.bvx().c(bH, bH.qv());
        }
    }

    public void setDatas(List<n> list) {
        if (list != null && list.size() > 0) {
            destory();
            this.mListData = list;
            if (this.foI == null) {
                this.foI = new ArrayList();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mListData.size()) {
                    n nVar = this.mListData.get(i2);
                    if (nVar != null) {
                        View b2 = b(nVar);
                        b2.setOnClickListener(this);
                        this.foI.add(b2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private View b(n nVar) {
        b<T, V> bVar = this.foH.get(nVar.getType());
        if (bVar != null) {
            V J = bVar.J(null);
            if (BdBaseApplication.getInst().isDebugMode()) {
                BdLog.i("ViewPager View is creating " + J.getClass().getName());
            }
            if (J != null) {
                J.a(nVar);
                bVar.a(null, J, nVar);
                return J.getView();
            }
        }
        return null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.mListData.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        if (this.mChildCount > 0) {
            this.mChildCount--;
            return -2;
        }
        return super.getItemPosition(obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void notifyDataSetChanged() {
        this.mChildCount = getCount();
        super.notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        View view;
        if (this.foI.size() > 0 && i >= 0 && i < this.foI.size() && (view = this.foI.get(i)) != null) {
            viewGroup.removeView(view);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i >= this.mListData.size()) {
            return null;
        }
        View qe = qe(i);
        if (qe != null && qe.getParent() != viewGroup) {
            viewGroup.addView(qe);
            return qe;
        }
        return qe;
    }

    public View qe(int i) {
        if (i >= this.foI.size() || i >= this.mListData.size()) {
            return null;
        }
        View view = this.foI.get(i);
        a bH = bH(view);
        if (bH != null && bH.qv() == null) {
            a((a) view.getTag(), this.mListData.get(i));
            return view;
        }
        return view;
    }

    private void a(a aVar, n nVar) {
        b<T, V> bVar;
        if (aVar != null && nVar != null && (bVar = this.foH.get(nVar.getType())) != null) {
            aVar.a(nVar);
            bVar.a(null, aVar, nVar);
        }
    }

    private a bH(View view) {
        if (view == null || !(view.getTag() instanceof a)) {
            return null;
        }
        return (a) view.getTag();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Parcelable saveState() {
        return super.saveState();
    }

    public void destory() {
        b<T, V> bVar;
        if (this.foI != null) {
            for (View view : this.foI) {
                a bH = bH(view);
                if (bH != null && bH.qv() != null && (bVar = this.foH.get(bH.qv().getType())) != null) {
                    bVar.b(bH, bH.qv());
                }
            }
            this.foI.clear();
            this.foI = null;
        }
        if (this.mListData != null) {
            this.mListData.clear();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int ajU = 3;
        private n foJ = null;
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

        public n qv() {
            return this.foJ;
        }

        public void a(n nVar) {
            this.foJ = nVar;
        }

        public void onSkinTypeChanged(int i) {
        }
    }
}
