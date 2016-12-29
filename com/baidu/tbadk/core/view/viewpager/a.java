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
    private HashMap<BdUniqueId, e<T, V>> ahZ = new HashMap<>();
    private List<v> mListData = new ArrayList();
    private List<View> aia = new ArrayList();
    private int mChildCount = 0;

    public void a(Context context, e<T, V> eVar) {
        if (eVar != null && eVar.getType() != null) {
            this.ahZ.put(eVar.getType(), eVar);
        }
    }

    public a(Context context) {
        this.context = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        e<T, V> eVar;
        C0036a H = H(view);
        if (H != null && H.wK() != null && H.wK().getType() != null && (eVar = this.ahZ.get(H.wK().getType())) != null && eVar.wO() != null) {
            eVar.wO().c(H, H.wK());
        }
    }

    public void setDatas(List<v> list) {
        if (list != null && list.size() > 0) {
            destory();
            this.mListData = list;
            if (this.aia == null) {
                this.aia = new ArrayList();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mListData.size()) {
                    v vVar = this.mListData.get(i2);
                    if (vVar != null) {
                        View a = a(vVar);
                        a.setOnClickListener(this);
                        this.aia.add(a);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private View a(v vVar) {
        e<T, V> eVar = this.ahZ.get(vVar.getType());
        if (eVar != null) {
            V c = eVar.c(null);
            if (BdBaseApplication.getInst().isDebugMode()) {
                BdLog.i("ViewPager View is creating " + c.getClass().getName());
            }
            if (c != null) {
                c.b(vVar);
                eVar.a((ViewGroup) null, (ViewGroup) c, (V) vVar);
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
        if (this.aia.size() > 0 && i >= 0 && i < this.aia.size() && (view = this.aia.get(i)) != null) {
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
        if (i >= this.aia.size() || i >= this.mListData.size()) {
            return null;
        }
        View view = this.aia.get(i);
        C0036a H = H(view);
        if (H != null && H.wK() == null) {
            a((C0036a) view.getTag(), this.mListData.get(i));
            return view;
        }
        return view;
    }

    private void a(C0036a c0036a, v vVar) {
        e<T, V> eVar;
        if (c0036a != null && vVar != null && (eVar = this.ahZ.get(vVar.getType())) != null) {
            c0036a.b(vVar);
            eVar.a((ViewGroup) null, (ViewGroup) c0036a, (C0036a) vVar);
        }
    }

    private C0036a H(View view) {
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
        e<T, V> eVar;
        if (this.aia != null) {
            for (View view : this.aia) {
                C0036a H = H(view);
                if (H != null && H.wK() != null && (eVar = this.ahZ.get(H.wK().getType())) != null) {
                    eVar.b(H, H.wK());
                }
            }
            this.aia.clear();
            this.aia = null;
        }
        if (this.mListData != null) {
            this.mListData.clear();
        }
    }

    public void df(int i) {
        e<T, V> eVar;
        if (this.aia != null) {
            for (View view : this.aia) {
                C0036a H = H(view);
                if (H != null && H.wK() != null && (eVar = this.ahZ.get(H.wK().getType())) != null) {
                    eVar.a(i, (int) H, (C0036a) H.wK());
                }
            }
        }
    }

    /* renamed from: com.baidu.tbadk.core.view.viewpager.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0036a {
        public int aib = 3;
        private v aic = null;
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

        public v wK() {
            return this.aic;
        }

        public void b(v vVar) {
            this.aic = vVar;
        }

        public void df(int i) {
        }
    }
}
