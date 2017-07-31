package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.f;
import com.baidu.tbadk.core.view.viewpager.b.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class b<T extends f, V extends a> extends PagerAdapter implements View.OnClickListener {
    private Context context;
    private HashMap<BdUniqueId, c<T, V>> aqj = new HashMap<>();
    private List<f> mListData = new ArrayList();
    private List<View> aqk = new ArrayList();
    private int mChildCount = 0;

    public void a(Context context, c<T, V> cVar) {
        if (cVar != null && cVar.getType() != null) {
            this.aqj.put(cVar.getType(), cVar);
        }
    }

    public b(Context context) {
        this.context = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c<T, V> cVar;
        a D = D(view);
        if (D != null && D.xs() != null && D.xs().getType() != null && (cVar = this.aqj.get(D.xs().getType())) != null && cVar.xt() != null) {
            cVar.xt().c(D, D.xs());
        }
    }

    public void setDatas(List<f> list) {
        if (list != null && list.size() > 0) {
            destory();
            this.mListData = list;
            if (this.aqk == null) {
                this.aqk = new ArrayList();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mListData.size()) {
                    f fVar = this.mListData.get(i2);
                    if (fVar != null) {
                        View a2 = a(fVar);
                        a2.setOnClickListener(this);
                        this.aqk.add(a2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private View a(f fVar) {
        c<T, V> cVar = this.aqj.get(fVar.getType());
        if (cVar != null) {
            V b = cVar.b(null);
            if (BdBaseApplication.getInst().isDebugMode()) {
                BdLog.i("ViewPager View is creating " + b.getClass().getName());
            }
            if (b != null) {
                b.b(fVar);
                cVar.a(null, b, fVar);
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
        if (this.aqk.size() > 0 && i >= 0 && i < this.aqk.size() && (view = this.aqk.get(i)) != null) {
            viewGroup.removeView(view);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i >= this.mListData.size()) {
            return null;
        }
        View dx = dx(i);
        if (dx != null && dx.getParent() != viewGroup) {
            viewGroup.addView(dx);
            return dx;
        }
        return dx;
    }

    public View dx(int i) {
        if (i >= this.aqk.size() || i >= this.mListData.size()) {
            return null;
        }
        View view = this.aqk.get(i);
        a D = D(view);
        if (D != null && D.xs() == null) {
            a((a) view.getTag(), this.mListData.get(i));
            return view;
        }
        return view;
    }

    private void a(a aVar, f fVar) {
        c<T, V> cVar;
        if (aVar != null && fVar != null && (cVar = this.aqj.get(fVar.getType())) != null) {
            aVar.b(fVar);
            cVar.a(null, aVar, fVar);
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
        if (this.aqk != null) {
            for (View view : this.aqk) {
                a D = D(view);
                if (D != null && D.xs() != null && (cVar = this.aqj.get(D.xs().getType())) != null) {
                    cVar.b(D, D.xs());
                }
            }
            this.aqk.clear();
            this.aqk = null;
        }
        if (this.mListData != null) {
            this.mListData.clear();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int aql = 3;
        private f aqm = null;
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

        public f xs() {
            return this.aqm;
        }

        public void b(f fVar) {
            this.aqm = fVar;
        }
    }
}
