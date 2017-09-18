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
    private HashMap<BdUniqueId, c<T, V>> apO = new HashMap<>();
    private List<f> mListData = new ArrayList();
    private List<View> apP = new ArrayList();
    private int mChildCount = 0;

    public void a(Context context, c<T, V> cVar) {
        if (cVar != null && cVar.getType() != null) {
            this.apO.put(cVar.getType(), cVar);
        }
    }

    public b(Context context) {
        this.context = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c<T, V> cVar;
        a I = I(view);
        if (I != null && I.xu() != null && I.xu().getType() != null && (cVar = this.apO.get(I.xu().getType())) != null && cVar.xv() != null) {
            cVar.xv().c(I, I.xu());
        }
    }

    public void setDatas(List<f> list) {
        if (list != null && list.size() > 0) {
            destory();
            this.mListData = list;
            if (this.apP == null) {
                this.apP = new ArrayList();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mListData.size()) {
                    f fVar = this.mListData.get(i2);
                    if (fVar != null) {
                        View a2 = a(fVar);
                        a2.setOnClickListener(this);
                        this.apP.add(a2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private View a(f fVar) {
        c<T, V> cVar = this.apO.get(fVar.getType());
        if (cVar != null) {
            V c = cVar.c(null);
            if (BdBaseApplication.getInst().isDebugMode()) {
                BdLog.i("ViewPager View is creating " + c.getClass().getName());
            }
            if (c != null) {
                c.b(fVar);
                cVar.a(null, c, fVar);
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
        if (this.apP.size() > 0 && i >= 0 && i < this.apP.size() && (view = this.apP.get(i)) != null) {
            viewGroup.removeView(view);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i >= this.mListData.size()) {
            return null;
        }
        View dy = dy(i);
        if (dy != null && dy.getParent() != viewGroup) {
            viewGroup.addView(dy);
            return dy;
        }
        return dy;
    }

    public View dy(int i) {
        if (i >= this.apP.size() || i >= this.mListData.size()) {
            return null;
        }
        View view = this.apP.get(i);
        a I = I(view);
        if (I != null && I.xu() == null) {
            a((a) view.getTag(), this.mListData.get(i));
            return view;
        }
        return view;
    }

    private void a(a aVar, f fVar) {
        c<T, V> cVar;
        if (aVar != null && fVar != null && (cVar = this.apO.get(fVar.getType())) != null) {
            aVar.b(fVar);
            cVar.a(null, aVar, fVar);
        }
    }

    private a I(View view) {
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
        if (this.apP != null) {
            for (View view : this.apP) {
                a I = I(view);
                if (I != null && I.xu() != null && (cVar = this.apO.get(I.xu().getType())) != null) {
                    cVar.b(I, I.xu());
                }
            }
            this.apP.clear();
            this.apP = null;
        }
        if (this.mListData != null) {
            this.mListData.clear();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int apQ = 3;
        private f apR = null;
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

        public f xu() {
            return this.apR;
        }

        public void b(f fVar) {
            this.apR = fVar;
        }
    }
}
