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
    private HashMap<BdUniqueId, c<T, V>> aqO = new HashMap<>();
    private List<h> mListData = new ArrayList();
    private List<View> aqP = new ArrayList();
    private int mChildCount = 0;

    public void a(Context context, c<T, V> cVar) {
        if (cVar != null && cVar.getType() != null) {
            this.aqO.put(cVar.getType(), cVar);
        }
    }

    public BdBaseViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        c<T, V> cVar;
        a L = L(view2);
        if (L != null && L.xq() != null && L.xq().getType() != null && (cVar = this.aqO.get(L.xq().getType())) != null && cVar.xu() != null) {
            cVar.xu().c(L, L.xq());
        }
    }

    public void setDatas(List<h> list) {
        if (list != null && list.size() > 0) {
            destory();
            this.mListData = list;
            if (this.aqP == null) {
                this.aqP = new ArrayList();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mListData.size()) {
                    h hVar = this.mListData.get(i2);
                    if (hVar != null) {
                        View a2 = a(hVar);
                        a2.setOnClickListener(this);
                        this.aqP.add(a2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private View a(h hVar) {
        c<T, V> cVar = this.aqO.get(hVar.getType());
        if (cVar != null) {
            V h = cVar.h(null);
            if (BdBaseApplication.getInst().isDebugMode()) {
                BdLog.i("ViewPager View is creating " + h.getClass().getName());
            }
            if (h != null) {
                h.b(hVar);
                cVar.a(null, h, hVar);
                return h.getView();
            }
        }
        return null;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.mListData.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view2, Object obj) {
        return view2 == obj;
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
        View view2;
        if (this.aqP.size() > 0 && i >= 0 && i < this.aqP.size() && (view2 = this.aqP.get(i)) != null) {
            viewGroup.removeView(view2);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i >= this.mListData.size()) {
            return null;
        }
        View dE = dE(i);
        if (dE != null && dE.getParent() != viewGroup) {
            viewGroup.addView(dE);
            return dE;
        }
        return dE;
    }

    public View dE(int i) {
        if (i >= this.aqP.size() || i >= this.mListData.size()) {
            return null;
        }
        View view2 = this.aqP.get(i);
        a L = L(view2);
        if (L != null && L.xq() == null) {
            a((a) view2.getTag(), this.mListData.get(i));
            return view2;
        }
        return view2;
    }

    private void a(a aVar, h hVar) {
        c<T, V> cVar;
        if (aVar != null && hVar != null && (cVar = this.aqO.get(hVar.getType())) != null) {
            aVar.b(hVar);
            cVar.a(null, aVar, hVar);
        }
    }

    private a L(View view2) {
        if (view2 == null || !(view2.getTag() instanceof a)) {
            return null;
        }
        return (a) view2.getTag();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Parcelable saveState() {
        return super.saveState();
    }

    public void destory() {
        c<T, V> cVar;
        if (this.aqP != null) {
            for (View view2 : this.aqP) {
                a L = L(view2);
                if (L != null && L.xq() != null && (cVar = this.aqO.get(L.xq().getType())) != null) {
                    cVar.b(L, L.xq());
                }
            }
            this.aqP.clear();
            this.aqP = null;
        }
        if (this.mListData != null) {
            this.mListData.clear();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int aqQ = 3;
        private h aqR = null;

        /* renamed from: view  reason: collision with root package name */
        private View f6view;

        public a(View view2) {
            this.f6view = null;
            this.f6view = view2;
            if (this.f6view == null) {
                throw new RuntimeException("view cannt be null");
            }
            this.f6view.setTag(this);
        }

        public View getView() {
            return this.f6view;
        }

        public h xq() {
            return this.aqR;
        }

        public void b(h hVar) {
            this.aqR = hVar;
        }
    }
}
