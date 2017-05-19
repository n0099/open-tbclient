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
    private HashMap<BdUniqueId, f<T, V>> anc = new HashMap<>();
    private List<v> mListData = new ArrayList();
    private List<View> and = new ArrayList();
    private int mChildCount = 0;

    public void a(Context context, f<T, V> fVar) {
        if (fVar != null && fVar.getType() != null) {
            this.anc.put(fVar.getType(), fVar);
        }
    }

    public b(Context context) {
        this.context = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        f<T, V> fVar;
        a C = C(view);
        if (C != null && C.wL() != null && C.wL().getType() != null && (fVar = this.anc.get(C.wL().getType())) != null && fVar.wP() != null) {
            fVar.wP().c(C, C.wL());
        }
    }

    public void setDatas(List<v> list) {
        if (list != null && list.size() > 0) {
            destory();
            this.mListData = list;
            if (this.and == null) {
                this.and = new ArrayList();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mListData.size()) {
                    v vVar = this.mListData.get(i2);
                    if (vVar != null) {
                        View a2 = a(vVar);
                        a2.setOnClickListener(this);
                        this.and.add(a2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private View a(v vVar) {
        f<T, V> fVar = this.anc.get(vVar.getType());
        if (fVar != null) {
            V b = fVar.b(null);
            if (BdBaseApplication.getInst().isDebugMode()) {
                BdLog.i("ViewPager View is creating " + b.getClass().getName());
            }
            if (b != null) {
                b.b(vVar);
                fVar.a((ViewGroup) null, (ViewGroup) b, (V) vVar);
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
        if (this.and.size() > 0 && i >= 0 && i < this.and.size() && (view = this.and.get(i)) != null) {
            viewGroup.removeView(view);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i >= this.mListData.size()) {
            return null;
        }
        View dq = dq(i);
        if (dq != null && dq.getParent() != viewGroup) {
            viewGroup.addView(dq);
            return dq;
        }
        return dq;
    }

    public View dq(int i) {
        if (i >= this.and.size() || i >= this.mListData.size()) {
            return null;
        }
        View view = this.and.get(i);
        a C = C(view);
        if (C != null && C.wL() == null) {
            a((a) view.getTag(), this.mListData.get(i));
            return view;
        }
        return view;
    }

    private void a(a aVar, v vVar) {
        f<T, V> fVar;
        if (aVar != null && vVar != null && (fVar = this.anc.get(vVar.getType())) != null) {
            aVar.b(vVar);
            fVar.a((ViewGroup) null, (ViewGroup) aVar, (a) vVar);
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
        f<T, V> fVar;
        if (this.and != null) {
            for (View view : this.and) {
                a C = C(view);
                if (C != null && C.wL() != null && (fVar = this.anc.get(C.wL().getType())) != null) {
                    fVar.b(C, C.wL());
                }
            }
            this.and.clear();
            this.and = null;
        }
        if (this.mListData != null) {
            this.mListData.clear();
        }
    }

    public void db(int i) {
        f<T, V> fVar;
        if (this.and != null) {
            for (View view : this.and) {
                a C = C(view);
                if (C != null && C.wL() != null && (fVar = this.anc.get(C.wL().getType())) != null) {
                    fVar.a(i, (int) C, (a) C.wL());
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int ane = 3;
        private v anf = null;
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

        public v wL() {
            return this.anf;
        }

        public void b(v vVar) {
            this.anf = vVar;
        }

        public void db(int i) {
        }
    }
}
