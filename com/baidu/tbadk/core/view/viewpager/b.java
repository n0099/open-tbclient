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
import com.baidu.tbadk.core.view.viewpager.b.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class b<T extends v, V extends a> extends PagerAdapter implements View.OnClickListener {
    private Context context;
    private HashMap<BdUniqueId, c<T, V>> anY = new HashMap<>();
    private List<v> mListData = new ArrayList();
    private List<View> anZ = new ArrayList();
    private int mChildCount = 0;

    public void a(Context context, c<T, V> cVar) {
        if (cVar != null && cVar.getType() != null) {
            this.anY.put(cVar.getType(), cVar);
        }
    }

    public b(Context context) {
        this.context = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c<T, V> cVar;
        a D = D(view);
        if (D != null && D.wZ() != null && D.wZ().getType() != null && (cVar = this.anY.get(D.wZ().getType())) != null && cVar.xa() != null) {
            cVar.xa().c(D, D.wZ());
        }
    }

    public void setDatas(List<v> list) {
        if (list != null && list.size() > 0) {
            destory();
            this.mListData = list;
            if (this.anZ == null) {
                this.anZ = new ArrayList();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mListData.size()) {
                    v vVar = this.mListData.get(i2);
                    if (vVar != null) {
                        View a2 = a(vVar);
                        a2.setOnClickListener(this);
                        this.anZ.add(a2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private View a(v vVar) {
        c<T, V> cVar = this.anY.get(vVar.getType());
        if (cVar != null) {
            V b = cVar.b(null);
            if (BdBaseApplication.getInst().isDebugMode()) {
                BdLog.i("ViewPager View is creating " + b.getClass().getName());
            }
            if (b != null) {
                b.b(vVar);
                cVar.a(null, b, vVar);
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
        if (this.anZ.size() > 0 && i >= 0 && i < this.anZ.size() && (view = this.anZ.get(i)) != null) {
            viewGroup.removeView(view);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i >= this.mListData.size()) {
            return null;
        }
        View dt = dt(i);
        if (dt != null && dt.getParent() != viewGroup) {
            viewGroup.addView(dt);
            return dt;
        }
        return dt;
    }

    public View dt(int i) {
        if (i >= this.anZ.size() || i >= this.mListData.size()) {
            return null;
        }
        View view = this.anZ.get(i);
        a D = D(view);
        if (D != null && D.wZ() == null) {
            a((a) view.getTag(), this.mListData.get(i));
            return view;
        }
        return view;
    }

    private void a(a aVar, v vVar) {
        c<T, V> cVar;
        if (aVar != null && vVar != null && (cVar = this.anY.get(vVar.getType())) != null) {
            aVar.b(vVar);
            cVar.a(null, aVar, vVar);
        }
    }

    private a D(View view) {
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
        if (this.anZ != null) {
            for (View view : this.anZ) {
                a D = D(view);
                if (D != null && D.wZ() != null && (cVar = this.anY.get(D.wZ().getType())) != null) {
                    cVar.b(D, D.wZ());
                }
            }
            this.anZ.clear();
            this.anZ = null;
        }
        if (this.mListData != null) {
            this.mListData.clear();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int aoa = 3;
        private v aob = null;
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

        public v wZ() {
            return this.aob;
        }

        public void b(v vVar) {
            this.aob = vVar;
        }
    }
}
