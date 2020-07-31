package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class BdBaseViewPagerAdapter<T extends q, V extends a> extends PagerAdapter implements View.OnClickListener {
    private Context context;
    private HashMap<BdUniqueId, c<T, V>> enW = new HashMap<>();
    private List<q> mListData = new ArrayList();
    private List<View> enX = new ArrayList();
    private int mChildCount = 0;

    public void a(Context context, c<T, V> cVar) {
        if (cVar != null && cVar.getType() != null) {
            this.enW.put(cVar.getType(), cVar);
        }
    }

    public BdBaseViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c<T, V> cVar;
        a bj = bj(view);
        if (bj != null && bj.pp() != null && bj.pp().getType() != null && (cVar = this.enW.get(bj.pp().getType())) != null && cVar.bdk() != null) {
            cVar.bdk().c(bj, bj.pp());
        }
    }

    public void setDatas(List<q> list) {
        if (list != null && list.size() > 0) {
            destory();
            this.mListData = list;
            if (this.enX == null) {
                this.enX = new ArrayList();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mListData.size()) {
                    q qVar = this.mListData.get(i2);
                    if (qVar != null) {
                        View b = b(qVar);
                        b.setOnClickListener(this);
                        this.enX.add(b);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private View b(q qVar) {
        c<T, V> cVar = this.enW.get(qVar.getType());
        if (cVar != null) {
            V B = cVar.B(null);
            if (BdBaseApplication.getInst().isDebugMode()) {
                BdLog.i("ViewPager View is creating " + B.getClass().getName());
            }
            if (B != null) {
                B.a(qVar);
                cVar.a(null, B, qVar);
                return B.getView();
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
        if (this.enX.size() > 0 && i >= 0 && i < this.enX.size() && (view = this.enX.get(i)) != null) {
            viewGroup.removeView(view);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i >= this.mListData.size()) {
            return null;
        }
        View nf = nf(i);
        if (nf != null && nf.getParent() != viewGroup) {
            viewGroup.addView(nf);
            return nf;
        }
        return nf;
    }

    public View nf(int i) {
        if (i >= this.enX.size() || i >= this.mListData.size()) {
            return null;
        }
        View view = this.enX.get(i);
        a bj = bj(view);
        if (bj != null && bj.pp() == null) {
            a((a) view.getTag(), this.mListData.get(i));
            return view;
        }
        return view;
    }

    private void a(a aVar, q qVar) {
        c<T, V> cVar;
        if (aVar != null && qVar != null && (cVar = this.enW.get(qVar.getType())) != null) {
            aVar.a(qVar);
            cVar.a(null, aVar, qVar);
        }
    }

    private a bj(View view) {
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
        if (this.enX != null) {
            for (View view : this.enX) {
                a bj = bj(view);
                if (bj != null && bj.pp() != null && (cVar = this.enW.get(bj.pp().getType())) != null) {
                    cVar.b(bj, bj.pp());
                }
            }
            this.enX.clear();
            this.enX = null;
        }
        if (this.mListData != null) {
            this.mListData.clear();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int aho = 3;
        private q enY = null;
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

        public q pp() {
            return this.enY;
        }

        public void a(q qVar) {
            this.enY = qVar;
        }
    }
}
