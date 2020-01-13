package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class BdBaseViewPagerAdapter<T extends m, V extends a> extends PagerAdapter implements View.OnClickListener {
    private Context context;
    private HashMap<BdUniqueId, c<T, V>> dgf = new HashMap<>();
    private List<m> mListData = new ArrayList();
    private List<View> dgg = new ArrayList();
    private int mChildCount = 0;

    public void a(Context context, c<T, V> cVar) {
        if (cVar != null && cVar.getType() != null) {
            this.dgf.put(cVar.getType(), cVar);
        }
    }

    public BdBaseViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c<T, V> cVar;
        a bb = bb(view);
        if (bb != null && bb.aGg() != null && bb.aGg().getType() != null && (cVar = this.dgf.get(bb.aGg().getType())) != null && cVar.aGk() != null) {
            cVar.aGk().c(bb, bb.aGg());
        }
    }

    public void setDatas(List<m> list) {
        if (list != null && list.size() > 0) {
            destory();
            this.mListData = list;
            if (this.dgg == null) {
                this.dgg = new ArrayList();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mListData.size()) {
                    m mVar = this.mListData.get(i2);
                    if (mVar != null) {
                        View a2 = a(mVar);
                        a2.setOnClickListener(this);
                        this.dgg.add(a2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private View a(m mVar) {
        c<T, V> cVar = this.dgf.get(mVar.getType());
        if (cVar != null) {
            V s = cVar.s(null);
            if (BdBaseApplication.getInst().isDebugMode()) {
                BdLog.i("ViewPager View is creating " + s.getClass().getName());
            }
            if (s != null) {
                s.b(mVar);
                cVar.a(null, s, mVar);
                return s.getView();
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
        if (this.dgg.size() > 0 && i >= 0 && i < this.dgg.size() && (view = this.dgg.get(i)) != null) {
            viewGroup.removeView(view);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i >= this.mListData.size()) {
            return null;
        }
        View lj = lj(i);
        if (lj != null && lj.getParent() != viewGroup) {
            viewGroup.addView(lj);
            return lj;
        }
        return lj;
    }

    public View lj(int i) {
        if (i >= this.dgg.size() || i >= this.mListData.size()) {
            return null;
        }
        View view = this.dgg.get(i);
        a bb = bb(view);
        if (bb != null && bb.aGg() == null) {
            a((a) view.getTag(), this.mListData.get(i));
            return view;
        }
        return view;
    }

    private void a(a aVar, m mVar) {
        c<T, V> cVar;
        if (aVar != null && mVar != null && (cVar = this.dgf.get(mVar.getType())) != null) {
            aVar.b(mVar);
            cVar.a(null, aVar, mVar);
        }
    }

    private a bb(View view) {
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
        if (this.dgg != null) {
            for (View view : this.dgg) {
                a bb = bb(view);
                if (bb != null && bb.aGg() != null && (cVar = this.dgf.get(bb.aGg().getType())) != null) {
                    cVar.b(bb, bb.aGg());
                }
            }
            this.dgg.clear();
            this.dgg = null;
        }
        if (this.mListData != null) {
            this.mListData.clear();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int MH = 3;
        private m dgh = null;
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

        public m aGg() {
            return this.dgh;
        }

        public void b(m mVar) {
            this.dgh = mVar;
        }
    }
}
