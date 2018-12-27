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
    private HashMap<BdUniqueId, c<T, V>> aLF = new HashMap<>();
    private List<h> mListData = new ArrayList();
    private List<View> aLG = new ArrayList();
    private int mChildCount = 0;

    public void a(Context context, c<T, V> cVar) {
        if (cVar != null && cVar.getType() != null) {
            this.aLF.put(cVar.getType(), cVar);
        }
    }

    public BdBaseViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c<T, V> cVar;
        a Y = Y(view);
        if (Y != null && Y.FC() != null && Y.FC().getType() != null && (cVar = this.aLF.get(Y.FC().getType())) != null && cVar.FG() != null) {
            cVar.FG().c(Y, Y.FC());
        }
    }

    public void setDatas(List<h> list) {
        if (list != null && list.size() > 0) {
            destory();
            this.mListData = list;
            if (this.aLG == null) {
                this.aLG = new ArrayList();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mListData.size()) {
                    h hVar = this.mListData.get(i2);
                    if (hVar != null) {
                        View a2 = a(hVar);
                        a2.setOnClickListener(this);
                        this.aLG.add(a2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private View a(h hVar) {
        c<T, V> cVar = this.aLF.get(hVar.getType());
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
        if (this.aLG.size() > 0 && i >= 0 && i < this.aLG.size() && (view = this.aLG.get(i)) != null) {
            viewGroup.removeView(view);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i >= this.mListData.size()) {
            return null;
        }
        View eI = eI(i);
        if (eI != null && eI.getParent() != viewGroup) {
            viewGroup.addView(eI);
            return eI;
        }
        return eI;
    }

    public View eI(int i) {
        if (i >= this.aLG.size() || i >= this.mListData.size()) {
            return null;
        }
        View view = this.aLG.get(i);
        a Y = Y(view);
        if (Y != null && Y.FC() == null) {
            a((a) view.getTag(), this.mListData.get(i));
            return view;
        }
        return view;
    }

    private void a(a aVar, h hVar) {
        c<T, V> cVar;
        if (aVar != null && hVar != null && (cVar = this.aLF.get(hVar.getType())) != null) {
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
        if (this.aLG != null) {
            for (View view : this.aLG) {
                a Y = Y(view);
                if (Y != null && Y.FC() != null && (cVar = this.aLF.get(Y.FC().getType())) != null) {
                    cVar.b(Y, Y.FC());
                }
            }
            this.aLG.clear();
            this.aLG = null;
        }
        if (this.mListData != null) {
            this.mListData.clear();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int aLH = 3;
        private h aLI = null;
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

        public h FC() {
            return this.aLI;
        }

        public void b(h hVar) {
            this.aLI = hVar;
        }
    }
}
