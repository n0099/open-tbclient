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
import com.baidu.tbadk.core.view.viewpager.a.C0034a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class a<T extends v, V extends C0034a> extends PagerAdapter implements View.OnClickListener {
    private Context context;
    private HashMap<BdUniqueId, e<T, V>> amX = new HashMap<>();
    private List<v> mListData = new ArrayList();
    private List<View> amY = new ArrayList();
    private int mChildCount = 0;

    public void a(Context context, e<T, V> eVar) {
        if (eVar != null && eVar.getType() != null) {
            this.amX.put(eVar.getType(), eVar);
        }
    }

    public a(Context context) {
        this.context = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        e<T, V> eVar;
        C0034a D = D(view);
        if (D != null && D.xx() != null && D.xx().getType() != null && (eVar = this.amX.get(D.xx().getType())) != null && eVar.xB() != null) {
            eVar.xB().c(D, D.xx());
        }
    }

    public void setDatas(List<v> list) {
        if (list != null && list.size() > 0) {
            destory();
            this.mListData = list;
            if (this.amY == null) {
                this.amY = new ArrayList();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mListData.size()) {
                    v vVar = this.mListData.get(i2);
                    if (vVar != null) {
                        View a = a(vVar);
                        a.setOnClickListener(this);
                        this.amY.add(a);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private View a(v vVar) {
        e<T, V> eVar = this.amX.get(vVar.getType());
        if (eVar != null) {
            V b = eVar.b(null);
            if (BdBaseApplication.getInst().isDebugMode()) {
                BdLog.i("ViewPager View is creating " + b.getClass().getName());
            }
            if (b != null) {
                b.b(vVar);
                eVar.a((ViewGroup) null, (ViewGroup) b, (V) vVar);
                return b.getView();
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
        if (this.amY.size() > 0 && i >= 0 && i < this.amY.size() && (view = this.amY.get(i)) != null) {
            viewGroup.removeView(view);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i >= this.mListData.size()) {
            return null;
        }
        View ds = ds(i);
        if (ds != null && ds.getParent() != viewGroup) {
            viewGroup.addView(ds);
            return ds;
        }
        return ds;
    }

    public View ds(int i) {
        if (i >= this.amY.size() || i >= this.mListData.size()) {
            return null;
        }
        View view = this.amY.get(i);
        C0034a D = D(view);
        if (D != null && D.xx() == null) {
            a((C0034a) view.getTag(), this.mListData.get(i));
            return view;
        }
        return view;
    }

    private void a(C0034a c0034a, v vVar) {
        e<T, V> eVar;
        if (c0034a != null && vVar != null && (eVar = this.amX.get(vVar.getType())) != null) {
            c0034a.b(vVar);
            eVar.a((ViewGroup) null, (ViewGroup) c0034a, (C0034a) vVar);
        }
    }

    private C0034a D(View view) {
        if (view == null || !(view.getTag() instanceof C0034a)) {
            return null;
        }
        return (C0034a) view.getTag();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Parcelable saveState() {
        return super.saveState();
    }

    public void destory() {
        e<T, V> eVar;
        if (this.amY != null) {
            for (View view : this.amY) {
                C0034a D = D(view);
                if (D != null && D.xx() != null && (eVar = this.amX.get(D.xx().getType())) != null) {
                    eVar.b(D, D.xx());
                }
            }
            this.amY.clear();
            this.amY = null;
        }
        if (this.mListData != null) {
            this.mListData.clear();
        }
    }

    public void df(int i) {
        e<T, V> eVar;
        if (this.amY != null) {
            for (View view : this.amY) {
                C0034a D = D(view);
                if (D != null && D.xx() != null && (eVar = this.amX.get(D.xx().getType())) != null) {
                    eVar.a(i, (int) D, (C0034a) D.xx());
                }
            }
        }
    }

    /* renamed from: com.baidu.tbadk.core.view.viewpager.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0034a {
        public int amZ = 3;
        private v ana = null;
        private View view;

        public C0034a(View view) {
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

        public v xx() {
            return this.ana;
        }

        public void b(v vVar) {
            this.ana = vVar;
        }

        public void df(int i) {
        }
    }
}
