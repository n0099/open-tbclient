package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.view.viewpager.a.C0044a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class a<T extends u, V extends C0044a> extends PagerAdapter implements View.OnClickListener {
    private Context context;
    private HashMap<BdUniqueId, e<T, V>> aii = new HashMap<>();
    private List<u> mListData = new ArrayList();
    private List<View> aij = new ArrayList();
    private int mChildCount = 0;

    public void a(Context context, e<T, V> eVar) {
        if (eVar != null && eVar.getType() != null) {
            this.aii.put(eVar.getType(), eVar);
        }
    }

    public a(Context context) {
        this.context = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        e<T, V> eVar;
        C0044a F = F(view);
        if (F != null && F.xQ() != null && F.xQ().getType() != null && (eVar = this.aii.get(F.xQ().getType())) != null && eVar.xS() != null) {
            eVar.xS().c(F, F.xQ());
        }
    }

    public void setDatas(List<u> list) {
        if (list != null && list.size() > 0) {
            destory();
            this.mListData = list;
            if (this.aij == null) {
                this.aij = new ArrayList();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mListData.size()) {
                    u uVar = this.mListData.get(i2);
                    if (uVar != null) {
                        View a = a(uVar);
                        a.setOnClickListener(this);
                        this.aij.add(a);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private View a(u uVar) {
        e<T, V> eVar = this.aii.get(uVar.getType());
        if (eVar != null) {
            V d = eVar.d(null);
            if (BdBaseApplication.getInst().isDebugMode()) {
                BdLog.i("ViewPager View is creating " + d.getClass().getName());
            }
            if (d != null) {
                d.b(uVar);
                eVar.a((ViewGroup) null, (ViewGroup) d, (V) uVar);
                return d.getView();
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
        if (this.aij.size() > 0 && i >= 0 && i < this.aij.size() && (view = this.aij.get(i)) != null) {
            viewGroup.removeView(view);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i >= this.mListData.size()) {
            return null;
        }
        View dr = dr(i);
        if (dr != null && dr.getParent() != viewGroup) {
            viewGroup.addView(dr);
            return dr;
        }
        return dr;
    }

    public View dr(int i) {
        if (i >= this.aij.size() || i >= this.mListData.size()) {
            return null;
        }
        View view = this.aij.get(i);
        C0044a F = F(view);
        if (F != null && F.xQ() == null) {
            a((C0044a) view.getTag(), this.mListData.get(i));
            return view;
        }
        return view;
    }

    private void a(C0044a c0044a, u uVar) {
        e<T, V> eVar;
        if (c0044a != null && uVar != null && (eVar = this.aii.get(uVar.getType())) != null) {
            c0044a.b(uVar);
            eVar.a((ViewGroup) null, (ViewGroup) c0044a, (C0044a) uVar);
        }
    }

    private C0044a F(View view) {
        if (view == null || !(view.getTag() instanceof C0044a)) {
            return null;
        }
        return (C0044a) view.getTag();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Parcelable saveState() {
        return super.saveState();
    }

    public void destory() {
        e<T, V> eVar;
        if (this.aij != null) {
            for (View view : this.aij) {
                C0044a F = F(view);
                if (F != null && F.xQ() != null && (eVar = this.aii.get(F.xQ().getType())) != null) {
                    eVar.b(F, F.xQ());
                }
            }
            this.aij.clear();
            this.aij = null;
        }
        if (this.mListData != null) {
            this.mListData.clear();
        }
    }

    public void de(int i) {
        e<T, V> eVar;
        if (this.aij != null) {
            for (View view : this.aij) {
                C0044a F = F(view);
                if (F != null && F.xQ() != null && (eVar = this.aii.get(F.xQ().getType())) != null) {
                    eVar.a(i, (int) F, (C0044a) F.xQ());
                }
            }
        }
    }

    /* renamed from: com.baidu.tbadk.core.view.viewpager.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0044a {
        public int aik = 3;
        private u ail = null;
        private View view;

        public C0044a(View view) {
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

        public u xQ() {
            return this.ail;
        }

        public void b(u uVar) {
            this.ail = uVar;
        }
    }
}
