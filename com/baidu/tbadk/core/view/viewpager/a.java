package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.view.viewpager.a.C0036a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class a<T extends v, V extends C0036a> extends PagerAdapter implements View.OnClickListener {
    private Context context;
    private HashMap<BdUniqueId, b<T, V>> ahT = new HashMap<>();
    private List<v> mListData = new ArrayList();
    private List<View> ahU = new ArrayList();
    private int mChildCount = 0;

    public void a(Context context, b<T, V> bVar) {
        if (bVar != null && bVar.getType() != null) {
            this.ahT.put(bVar.getType(), bVar);
        }
    }

    public a(Context context) {
        this.context = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b<T, V> bVar;
        C0036a G = G(view);
        if (G != null && G.wV() != null && G.wV().getType() != null && (bVar = this.ahT.get(G.wV().getType())) != null && bVar.wW() != null) {
            bVar.wW().c(G, G.wV());
        }
    }

    public void setDatas(List<v> list) {
        if (list != null && list.size() > 0) {
            destory();
            this.mListData = list;
            if (this.ahU == null) {
                this.ahU = new ArrayList();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mListData.size()) {
                    v vVar = this.mListData.get(i2);
                    if (vVar != null) {
                        View a = a(vVar);
                        a.setOnClickListener(this);
                        this.ahU.add(a);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private View a(v vVar) {
        b<T, V> bVar = this.ahT.get(vVar.getType());
        if (bVar != null) {
            V c = bVar.c(null);
            if (BdBaseApplication.getInst().isDebugMode()) {
                BdLog.i("ViewPager View is creating " + c.getClass().getName());
            }
            if (c != null) {
                c.b(vVar);
                bVar.a(null, c, vVar);
                return c.getView();
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
        if (this.ahU.size() > 0 && i >= 0 && i < this.ahU.size() && (view = this.ahU.get(i)) != null) {
            viewGroup.removeView(view);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i >= this.mListData.size()) {
            return null;
        }
        View m12do = m12do(i);
        if (m12do != null && m12do.getParent() != viewGroup) {
            viewGroup.addView(m12do);
            return m12do;
        }
        return m12do;
    }

    /* renamed from: do  reason: not valid java name */
    public View m12do(int i) {
        if (i >= this.ahU.size() || i >= this.mListData.size()) {
            return null;
        }
        View view = this.ahU.get(i);
        C0036a G = G(view);
        if (G != null && G.wV() == null) {
            a((C0036a) view.getTag(), this.mListData.get(i));
            return view;
        }
        return view;
    }

    private void a(C0036a c0036a, v vVar) {
        b<T, V> bVar;
        if (c0036a != null && vVar != null && (bVar = this.ahT.get(vVar.getType())) != null) {
            c0036a.b(vVar);
            bVar.a(null, c0036a, vVar);
        }
    }

    private C0036a G(View view) {
        if (view == null || !(view.getTag() instanceof C0036a)) {
            return null;
        }
        return (C0036a) view.getTag();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Parcelable saveState() {
        return super.saveState();
    }

    public void destory() {
        b<T, V> bVar;
        if (this.ahU != null) {
            for (View view : this.ahU) {
                C0036a G = G(view);
                if (G != null && G.wV() != null && (bVar = this.ahT.get(G.wV().getType())) != null) {
                    bVar.b(G, G.wV());
                }
            }
            this.ahU.clear();
            this.ahU = null;
        }
        if (this.mListData != null) {
            this.mListData.clear();
        }
    }

    /* renamed from: com.baidu.tbadk.core.view.viewpager.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0036a {
        public int ahV = 3;
        private v ahW = null;
        private View view;

        public C0036a(View view) {
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

        public v wV() {
            return this.ahW;
        }

        public void b(v vVar) {
            this.ahW = vVar;
        }
    }
}
