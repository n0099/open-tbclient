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
    private HashMap<BdUniqueId, e<T, V>> ahS = new HashMap<>();
    private List<u> mListData = new ArrayList();
    private List<View> ahT = new ArrayList();
    private int mChildCount = 0;

    public void a(Context context, e<T, V> eVar) {
        if (eVar != null && eVar.getType() != null) {
            this.ahS.put(eVar.getType(), eVar);
        }
    }

    public a(Context context) {
        this.context = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        e<T, V> eVar;
        C0044a E = E(view);
        if (E != null && E.xq() != null && E.xq().getType() != null && (eVar = this.ahS.get(E.xq().getType())) != null && eVar.xs() != null) {
            eVar.xs().c(E, E.xq());
        }
    }

    public void setDatas(List<u> list) {
        if (list != null && list.size() > 0) {
            destory();
            this.mListData = list;
            if (this.ahT == null) {
                this.ahT = new ArrayList();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mListData.size()) {
                    u uVar = this.mListData.get(i2);
                    if (uVar != null) {
                        View a = a(uVar);
                        a.setOnClickListener(this);
                        this.ahT.add(a);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private View a(u uVar) {
        e<T, V> eVar = this.ahS.get(uVar.getType());
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
        if (this.ahT.size() > 0 && i >= 0 && i < this.ahT.size() && (view = this.ahT.get(i)) != null) {
            viewGroup.removeView(view);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i >= this.mListData.size()) {
            return null;
        }
        View dm = dm(i);
        if (dm != null && dm.getParent() != viewGroup) {
            viewGroup.addView(dm);
            return dm;
        }
        return dm;
    }

    public View dm(int i) {
        if (i >= this.ahT.size() || i >= this.mListData.size()) {
            return null;
        }
        View view = this.ahT.get(i);
        C0044a E = E(view);
        if (E != null && E.xq() == null) {
            a((C0044a) view.getTag(), this.mListData.get(i));
            return view;
        }
        return view;
    }

    private void a(C0044a c0044a, u uVar) {
        e<T, V> eVar;
        if (c0044a != null && uVar != null && (eVar = this.ahS.get(uVar.getType())) != null) {
            c0044a.b(uVar);
            eVar.a((ViewGroup) null, (ViewGroup) c0044a, (C0044a) uVar);
        }
    }

    private C0044a E(View view) {
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
        if (this.ahT != null) {
            for (View view : this.ahT) {
                C0044a E = E(view);
                if (E != null && E.xq() != null && (eVar = this.ahS.get(E.xq().getType())) != null) {
                    eVar.b(E, E.xq());
                }
            }
            this.ahT.clear();
            this.ahT = null;
        }
        if (this.mListData != null) {
            this.mListData.clear();
        }
    }

    public void db(int i) {
        e<T, V> eVar;
        if (this.ahT != null) {
            for (View view : this.ahT) {
                C0044a E = E(view);
                if (E != null && E.xq() != null && (eVar = this.ahS.get(E.xq().getType())) != null) {
                    eVar.a(i, (int) E, (C0044a) E.xq());
                }
            }
        }
    }

    /* renamed from: com.baidu.tbadk.core.view.viewpager.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0044a {
        public int ahU = 3;
        private u ahV = null;
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

        public u xq() {
            return this.ahV;
        }

        public void b(u uVar) {
            this.ahV = uVar;
        }
    }
}
