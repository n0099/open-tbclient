package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class BdBaseViewPagerAdapter<T extends h, V extends a> extends PagerAdapter implements View.OnClickListener {
    private Context context;
    private HashMap<BdUniqueId, c<T, V>> ayV = new HashMap<>();
    private List<h> mListData = new ArrayList();
    private List<View> ayW = new ArrayList();
    private int mChildCount = 0;

    public void a(Context context, c<T, V> cVar) {
        if (cVar != null && cVar.getType() != null) {
            this.ayV.put(cVar.getType(), cVar);
        }
    }

    public BdBaseViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c<T, V> cVar;
        a L = L(view);
        if (L != null && L.AQ() != null && L.AQ().getType() != null && (cVar = this.ayV.get(L.AQ().getType())) != null && cVar.AU() != null) {
            cVar.AU().c(L, L.AQ());
        }
    }

    public void setDatas(List<h> list) {
        if (list != null && list.size() > 0) {
            destory();
            this.mListData = list;
            if (this.ayW == null) {
                this.ayW = new ArrayList();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mListData.size()) {
                    h hVar = this.mListData.get(i2);
                    if (hVar != null) {
                        View a2 = a(hVar);
                        a2.setOnClickListener(this);
                        this.ayW.add(a2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private View a(h hVar) {
        c<T, V> cVar = this.ayV.get(hVar.getType());
        if (cVar != null) {
            V g = cVar.g(null);
            if (BdBaseApplication.getInst().isDebugMode()) {
                BdLog.i("ViewPager View is creating " + g.getClass().getName());
            }
            if (g != null) {
                g.b(hVar);
                cVar.a(null, g, hVar);
                return g.getView();
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
        if (this.ayW.size() > 0 && i >= 0 && i < this.ayW.size() && (view = this.ayW.get(i)) != null) {
            viewGroup.removeView(view);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i >= this.mListData.size()) {
            return null;
        }
        View dG = dG(i);
        if (dG != null && dG.getParent() != viewGroup) {
            viewGroup.addView(dG);
            return dG;
        }
        return dG;
    }

    public View dG(int i) {
        if (i >= this.ayW.size() || i >= this.mListData.size()) {
            return null;
        }
        View view = this.ayW.get(i);
        a L = L(view);
        if (L != null && L.AQ() == null) {
            a((a) view.getTag(), this.mListData.get(i));
            return view;
        }
        return view;
    }

    private void a(a aVar, h hVar) {
        c<T, V> cVar;
        if (aVar != null && hVar != null && (cVar = this.ayV.get(hVar.getType())) != null) {
            aVar.b(hVar);
            cVar.a(null, aVar, hVar);
        }
    }

    private a L(View view) {
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
        if (this.ayW != null) {
            for (View view : this.ayW) {
                a L = L(view);
                if (L != null && L.AQ() != null && (cVar = this.ayV.get(L.AQ().getType())) != null) {
                    cVar.b(L, L.AQ());
                }
            }
            this.ayW.clear();
            this.ayW = null;
        }
        if (this.mListData != null) {
            this.mListData.clear();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int ayX = 3;
        private h ayY = null;
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

        public h AQ() {
            return this.ayY;
        }

        public void b(h hVar) {
            this.ayY = hVar;
        }
    }
}
