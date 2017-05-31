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
    private HashMap<BdUniqueId, c<T, V>> amY = new HashMap<>();
    private List<v> mListData = new ArrayList();
    private List<View> amZ = new ArrayList();
    private int mChildCount = 0;

    public void a(Context context, c<T, V> cVar) {
        if (cVar != null && cVar.getType() != null) {
            this.amY.put(cVar.getType(), cVar);
        }
    }

    public b(Context context) {
        this.context = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c<T, V> cVar;
        a C = C(view);
        if (C != null && C.wH() != null && C.wH().getType() != null && (cVar = this.amY.get(C.wH().getType())) != null && cVar.wI() != null) {
            cVar.wI().c(C, C.wH());
        }
    }

    public void setDatas(List<v> list) {
        if (list != null && list.size() > 0) {
            destory();
            this.mListData = list;
            if (this.amZ == null) {
                this.amZ = new ArrayList();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mListData.size()) {
                    v vVar = this.mListData.get(i2);
                    if (vVar != null) {
                        View a2 = a(vVar);
                        a2.setOnClickListener(this);
                        this.amZ.add(a2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private View a(v vVar) {
        c<T, V> cVar = this.amY.get(vVar.getType());
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
        if (this.amZ.size() > 0 && i >= 0 && i < this.amZ.size() && (view = this.amZ.get(i)) != null) {
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
        if (i >= this.amZ.size() || i >= this.mListData.size()) {
            return null;
        }
        View view = this.amZ.get(i);
        a C = C(view);
        if (C != null && C.wH() == null) {
            a((a) view.getTag(), this.mListData.get(i));
            return view;
        }
        return view;
    }

    private void a(a aVar, v vVar) {
        c<T, V> cVar;
        if (aVar != null && vVar != null && (cVar = this.amY.get(vVar.getType())) != null) {
            aVar.b(vVar);
            cVar.a(null, aVar, vVar);
        }
    }

    private a C(View view) {
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
        if (this.amZ != null) {
            for (View view : this.amZ) {
                a C = C(view);
                if (C != null && C.wH() != null && (cVar = this.amY.get(C.wH().getType())) != null) {
                    cVar.b(C, C.wH());
                }
            }
            this.amZ.clear();
            this.amZ = null;
        }
        if (this.mListData != null) {
            this.mListData.clear();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int ana = 3;
        private v anb = null;
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

        public v wH() {
            return this.anb;
        }

        public void b(v vVar) {
            this.anb = vVar;
        }
    }
}
