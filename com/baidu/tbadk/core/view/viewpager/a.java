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
import com.baidu.tbadk.core.view.viewpager.a.C0035a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class a<T extends v, V extends C0035a> extends PagerAdapter implements View.OnClickListener {
    private Context context;
    private HashMap<BdUniqueId, b<T, V>> aeI = new HashMap<>();
    private List<v> mListData = new ArrayList();
    private List<View> aeJ = new ArrayList();
    private int mChildCount = 0;

    public void a(Context context, b<T, V> bVar) {
        if (bVar != null && bVar.getType() != null) {
            this.aeI.put(bVar.getType(), bVar);
        }
    }

    public a(Context context) {
        this.context = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b<T, V> bVar;
        C0035a F = F(view);
        if (F != null && F.vP() != null && F.vP().getType() != null && (bVar = this.aeI.get(F.vP().getType())) != null && bVar.vQ() != null) {
            bVar.vQ().c(F, F.vP());
        }
    }

    public void setDatas(List<v> list) {
        if (list != null && list.size() > 0) {
            destory();
            this.mListData = list;
            if (this.aeJ == null) {
                this.aeJ = new ArrayList();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mListData.size()) {
                    v vVar = this.mListData.get(i2);
                    if (vVar != null) {
                        View a = a(vVar);
                        a.setOnClickListener(this);
                        this.aeJ.add(a);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private View a(v vVar) {
        b<T, V> bVar = this.aeI.get(vVar.getType());
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
        if (this.aeJ.size() > 0 && i >= 0 && i < this.aeJ.size() && (view = this.aeJ.get(i)) != null) {
            viewGroup.removeView(view);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i >= this.mListData.size()) {
            return null;
        }
        View da = da(i);
        if (da != null && da.getParent() != viewGroup) {
            viewGroup.addView(da);
            return da;
        }
        return da;
    }

    public View da(int i) {
        if (i >= this.aeJ.size() || i >= this.mListData.size()) {
            return null;
        }
        View view = this.aeJ.get(i);
        C0035a F = F(view);
        if (F != null && F.vP() == null) {
            a((C0035a) view.getTag(), this.mListData.get(i));
            return view;
        }
        return view;
    }

    private void a(C0035a c0035a, v vVar) {
        b<T, V> bVar;
        if (c0035a != null && vVar != null && (bVar = this.aeI.get(vVar.getType())) != null) {
            c0035a.b(vVar);
            bVar.a(null, c0035a, vVar);
        }
    }

    private C0035a F(View view) {
        if (view == null || !(view.getTag() instanceof C0035a)) {
            return null;
        }
        return (C0035a) view.getTag();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Parcelable saveState() {
        return super.saveState();
    }

    public void destory() {
        b<T, V> bVar;
        if (this.aeJ != null) {
            for (View view : this.aeJ) {
                C0035a F = F(view);
                if (F != null && F.vP() != null && (bVar = this.aeI.get(F.vP().getType())) != null) {
                    bVar.b(F, F.vP());
                }
            }
            this.aeJ.clear();
            this.aeJ = null;
        }
        if (this.mListData != null) {
            this.mListData.clear();
        }
    }

    /* renamed from: com.baidu.tbadk.core.view.viewpager.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0035a {
        public int aeK = 3;
        private v aeL = null;
        private View view;

        public C0035a(View view) {
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

        public v vP() {
            return this.aeL;
        }

        public void b(v vVar) {
            this.aeL = vVar;
        }
    }
}
