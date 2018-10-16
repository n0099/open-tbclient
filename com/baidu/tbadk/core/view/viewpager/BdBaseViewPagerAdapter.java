package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class BdBaseViewPagerAdapter<T extends h, V extends a> extends PagerAdapter implements View.OnClickListener {
    private Context context;
    private HashMap<BdUniqueId, c<T, V>> aHn = new HashMap<>();
    private List<h> mListData = new ArrayList();
    private List<View> aHo = new ArrayList();
    private int mChildCount = 0;

    public void a(Context context, c<T, V> cVar) {
        if (cVar != null && cVar.getType() != null) {
            this.aHn.put(cVar.getType(), cVar);
        }
    }

    public BdBaseViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c<T, V> cVar;
        a Y = Y(view);
        if (Y != null && Y.En() != null && Y.En().getType() != null && (cVar = this.aHn.get(Y.En().getType())) != null && cVar.Er() != null) {
            cVar.Er().c(Y, Y.En());
        }
    }

    public void setDatas(List<h> list) {
        if (list != null && list.size() > 0) {
            destory();
            this.mListData = list;
            if (this.aHo == null) {
                this.aHo = new ArrayList();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mListData.size()) {
                    h hVar = this.mListData.get(i2);
                    if (hVar != null) {
                        View a2 = a(hVar);
                        a2.setOnClickListener(this);
                        this.aHo.add(a2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private View a(h hVar) {
        c<T, V> cVar = this.aHn.get(hVar.getType());
        if (cVar != null) {
            V f = cVar.f(null);
            if (BdBaseApplication.getInst().isDebugMode()) {
                BdLog.i("ViewPager View is creating " + f.getClass().getName());
            }
            if (f != null) {
                f.b(hVar);
                cVar.a(null, f, hVar);
                return f.getView();
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
        if (this.aHo.size() > 0 && i >= 0 && i < this.aHo.size() && (view = this.aHo.get(i)) != null) {
            viewGroup.removeView(view);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i >= this.mListData.size()) {
            return null;
        }
        View ef = ef(i);
        if (ef != null && ef.getParent() != viewGroup) {
            viewGroup.addView(ef);
            return ef;
        }
        return ef;
    }

    public View ef(int i) {
        if (i >= this.aHo.size() || i >= this.mListData.size()) {
            return null;
        }
        View view = this.aHo.get(i);
        a Y = Y(view);
        if (Y != null && Y.En() == null) {
            a((a) view.getTag(), this.mListData.get(i));
            return view;
        }
        return view;
    }

    private void a(a aVar, h hVar) {
        c<T, V> cVar;
        if (aVar != null && hVar != null && (cVar = this.aHn.get(hVar.getType())) != null) {
            aVar.b(hVar);
            cVar.a(null, aVar, hVar);
        }
    }

    private a Y(View view) {
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
        if (this.aHo != null) {
            for (View view : this.aHo) {
                a Y = Y(view);
                if (Y != null && Y.En() != null && (cVar = this.aHn.get(Y.En().getType())) != null) {
                    cVar.b(Y, Y.En());
                }
            }
            this.aHo.clear();
            this.aHo = null;
        }
        if (this.mListData != null) {
            this.mListData.clear();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int aHp = 3;
        private h aHq = null;
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

        public h En() {
            return this.aHq;
        }

        public void b(h hVar) {
            this.aHq = hVar;
        }
    }
}
