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
    private HashMap<BdUniqueId, b<T, V>> fqY = new HashMap<>();
    private List<n> mListData = new ArrayList();
    private List<View> fqZ = new ArrayList();
    private int mChildCount = 0;

    public void a(Context context, b<T, V> bVar) {
        if (bVar != null && bVar.getType() != null) {
            this.fqY.put(bVar.getType(), bVar);
        }
    }

    public BdBaseViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b<T, V> bVar;
        a bL = bL(view);
        if (bL != null && bL.qx() != null && bL.qx().getType() != null && (bVar = this.fqY.get(bL.qx().getType())) != null && bVar.byW() != null) {
            bVar.byW().c(bL, bL.qx());
        }
    }

    public void setDatas(List<n> list) {
        if (list != null && list.size() > 0) {
            destory();
            this.mListData = list;
            if (this.fqZ == null) {
                this.fqZ = new ArrayList();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mListData.size()) {
                    n nVar = this.mListData.get(i2);
                    if (nVar != null) {
                        View b2 = b(nVar);
                        b2.setOnClickListener(this);
                        this.fqZ.add(b2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private View b(n nVar) {
        b<T, V> bVar = this.fqY.get(nVar.getType());
        if (bVar != null) {
            V L = bVar.L(null);
            if (BdBaseApplication.getInst().isDebugMode()) {
                BdLog.i("ViewPager View is creating " + L.getClass().getName());
            }
            if (L != null) {
                L.a(nVar);
                bVar.a(null, L, nVar);
                return L.getView();
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
        if (this.fqZ.size() > 0 && i >= 0 && i < this.fqZ.size() && (view = this.fqZ.get(i)) != null) {
            viewGroup.removeView(view);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i >= this.mListData.size()) {
            return null;
        }
        View rF = rF(i);
        if (rF != null && rF.getParent() != viewGroup) {
            viewGroup.addView(rF);
            return rF;
        }
        return rF;
    }

    public View rF(int i) {
        if (i >= this.fqZ.size() || i >= this.mListData.size()) {
            return null;
        }
        View view = this.fqZ.get(i);
        a bL = bL(view);
        if (bL != null && bL.qx() == null) {
            a((a) view.getTag(), this.mListData.get(i));
            return view;
        }
        return view;
    }

    private void a(a aVar, n nVar) {
        b<T, V> bVar;
        if (aVar != null && nVar != null && (bVar = this.fqY.get(nVar.getType())) != null) {
            aVar.a(nVar);
            bVar.a(null, aVar, nVar);
        }
    }

    private a bL(View view) {
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
        if (this.fqZ != null) {
            for (View view : this.fqZ) {
                a bL = bL(view);
                if (bL != null && bL.qx() != null && (bVar = this.fqY.get(bL.qx().getType())) != null) {
                    bVar.b(bL, bL.qx());
                }
            }
            this.fqZ.clear();
            this.fqZ = null;
        }
        if (this.mListData != null) {
            this.mListData.clear();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int akW = 3;
        private n fra = null;
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

        public n qx() {
            return this.fra;
        }

        public void a(n nVar) {
            this.fra = nVar;
        }

        public void onSkinTypeChanged(int i) {
        }
    }
}
