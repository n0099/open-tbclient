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
    private HashMap<BdUniqueId, c<T, V>> aoL = new HashMap<>();
    private List<f> mListData = new ArrayList();
    private List<View> aoM = new ArrayList();
    private int mChildCount = 0;

    public void a(Context context, c<T, V> cVar) {
        if (cVar != null && cVar.getType() != null) {
            this.aoL.put(cVar.getType(), cVar);
        }
    }

    public b(Context context) {
        this.context = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c<T, V> cVar;
        a J = J(view);
        if (J != null && J.wM() != null && J.wM().getType() != null && (cVar = this.aoL.get(J.wM().getType())) != null && cVar.wN() != null) {
            cVar.wN().c(J, J.wM());
        }
    }

    public void setDatas(List<f> list) {
        if (list != null && list.size() > 0) {
            destory();
            this.mListData = list;
            if (this.aoM == null) {
                this.aoM = new ArrayList();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mListData.size()) {
                    f fVar = this.mListData.get(i2);
                    if (fVar != null) {
                        View a2 = a(fVar);
                        a2.setOnClickListener(this);
                        this.aoM.add(a2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private View a(f fVar) {
        c<T, V> cVar = this.aoL.get(fVar.getType());
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
        if (this.aoM.size() > 0 && i >= 0 && i < this.aoM.size() && (view = this.aoM.get(i)) != null) {
            viewGroup.removeView(view);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i >= this.mListData.size()) {
            return null;
        }
        View dH = dH(i);
        if (dH != null && dH.getParent() != viewGroup) {
            viewGroup.addView(dH);
            return dH;
        }
        return dH;
    }

    public View dH(int i) {
        if (i >= this.aoM.size() || i >= this.mListData.size()) {
            return null;
        }
        View view = this.aoM.get(i);
        a J = J(view);
        if (J != null && J.wM() == null) {
            a((a) view.getTag(), this.mListData.get(i));
            return view;
        }
        return view;
    }

    private void a(a aVar, f fVar) {
        c<T, V> cVar;
        if (aVar != null && fVar != null && (cVar = this.aoL.get(fVar.getType())) != null) {
            aVar.b(fVar);
            cVar.a(null, aVar, fVar);
        }
    }

    private a J(View view) {
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
        if (this.aoM != null) {
            for (View view : this.aoM) {
                a J = J(view);
                if (J != null && J.wM() != null && (cVar = this.aoL.get(J.wM().getType())) != null) {
                    cVar.b(J, J.wM());
                }
            }
            this.aoM.clear();
            this.aoM = null;
        }
        if (this.mListData != null) {
            this.mListData.clear();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int aoN = 3;
        private f aoO = null;
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

        public f wM() {
            return this.aoO;
        }

        public void b(f fVar) {
            this.aoO = fVar;
        }
    }
}
