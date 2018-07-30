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
    private HashMap<BdUniqueId, c<T, V>> azG = new HashMap<>();
    private List<h> mListData = new ArrayList();
    private List<View> azH = new ArrayList();
    private int mChildCount = 0;

    public void a(Context context, c<T, V> cVar) {
        if (cVar != null && cVar.getType() != null) {
            this.azG.put(cVar.getType(), cVar);
        }
    }

    public BdBaseViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c<T, V> cVar;
        a M = M(view);
        if (M != null && M.AZ() != null && M.AZ().getType() != null && (cVar = this.azG.get(M.AZ().getType())) != null && cVar.Bd() != null) {
            cVar.Bd().c(M, M.AZ());
        }
    }

    public void setDatas(List<h> list) {
        if (list != null && list.size() > 0) {
            destory();
            this.mListData = list;
            if (this.azH == null) {
                this.azH = new ArrayList();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mListData.size()) {
                    h hVar = this.mListData.get(i2);
                    if (hVar != null) {
                        View a2 = a(hVar);
                        a2.setOnClickListener(this);
                        this.azH.add(a2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private View a(h hVar) {
        c<T, V> cVar = this.azG.get(hVar.getType());
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
        if (this.azH.size() > 0 && i >= 0 && i < this.azH.size() && (view = this.azH.get(i)) != null) {
            viewGroup.removeView(view);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i >= this.mListData.size()) {
            return null;
        }
        View dK = dK(i);
        if (dK != null && dK.getParent() != viewGroup) {
            viewGroup.addView(dK);
            return dK;
        }
        return dK;
    }

    public View dK(int i) {
        if (i >= this.azH.size() || i >= this.mListData.size()) {
            return null;
        }
        View view = this.azH.get(i);
        a M = M(view);
        if (M != null && M.AZ() == null) {
            a((a) view.getTag(), this.mListData.get(i));
            return view;
        }
        return view;
    }

    private void a(a aVar, h hVar) {
        c<T, V> cVar;
        if (aVar != null && hVar != null && (cVar = this.azG.get(hVar.getType())) != null) {
            aVar.b(hVar);
            cVar.a(null, aVar, hVar);
        }
    }

    private a M(View view) {
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
        if (this.azH != null) {
            for (View view : this.azH) {
                a M = M(view);
                if (M != null && M.AZ() != null && (cVar = this.azG.get(M.AZ().getType())) != null) {
                    cVar.b(M, M.AZ());
                }
            }
            this.azH.clear();
            this.azH = null;
        }
        if (this.mListData != null) {
            this.mListData.clear();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int azI = 3;
        private h azJ = null;
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

        public h AZ() {
            return this.azJ;
        }

        public void b(h hVar) {
            this.azJ = hVar;
        }
    }
}
