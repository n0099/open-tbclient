package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.core.view.viewpager.b.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class b<T extends i, V extends a> extends PagerAdapter implements View.OnClickListener {
    private Context context;
    private HashMap<BdUniqueId, c<T, V>> bfA = new HashMap<>();
    private List<i> mListData = new ArrayList();
    private List<View> bfB = new ArrayList();
    private int mChildCount = 0;

    public void a(Context context, c<T, V> cVar) {
        if (cVar != null && cVar.getType() != null) {
            this.bfA.put(cVar.getType(), cVar);
        }
    }

    public b(Context context) {
        this.context = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c<T, V> cVar;
        a bd = bd(view);
        if (bd != null && bd.EG() != null && bd.EG().getType() != null && (cVar = this.bfA.get(bd.EG().getType())) != null && cVar.EH() != null) {
            cVar.EH().c(bd, bd.EG());
        }
    }

    public void setDatas(List<i> list) {
        if (list != null && list.size() > 0) {
            destory();
            this.mListData = list;
            if (this.bfB == null) {
                this.bfB = new ArrayList();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mListData.size()) {
                    i iVar = this.mListData.get(i2);
                    if (iVar != null) {
                        View a2 = a(iVar);
                        a2.setOnClickListener(this);
                        this.bfB.add(a2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private View a(i iVar) {
        c<T, V> cVar = this.bfA.get(iVar.getType());
        if (cVar != null) {
            V l = cVar.l(null);
            if (BdBaseApplication.getInst().isDebugMode()) {
                BdLog.i("ViewPager View is creating " + l.getClass().getName());
            }
            if (l != null) {
                l.b(iVar);
                cVar.a(null, l, iVar);
                return l.getView();
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
        if (this.bfB.size() > 0 && i >= 0 && i < this.bfB.size() && (view = this.bfB.get(i)) != null) {
            viewGroup.removeView(view);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i >= this.mListData.size()) {
            return null;
        }
        View gF = gF(i);
        if (gF != null && gF.getParent() != viewGroup) {
            viewGroup.addView(gF);
            return gF;
        }
        return gF;
    }

    public View gF(int i) {
        if (i >= this.bfB.size() || i >= this.mListData.size()) {
            return null;
        }
        View view = this.bfB.get(i);
        a bd = bd(view);
        if (bd != null && bd.EG() == null) {
            a((a) view.getTag(), this.mListData.get(i));
            return view;
        }
        return view;
    }

    private void a(a aVar, i iVar) {
        c<T, V> cVar;
        if (aVar != null && iVar != null && (cVar = this.bfA.get(iVar.getType())) != null) {
            aVar.b(iVar);
            cVar.a(null, aVar, iVar);
        }
    }

    private a bd(View view) {
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
        if (this.bfB != null) {
            for (View view : this.bfB) {
                a bd = bd(view);
                if (bd != null && bd.EG() != null && (cVar = this.bfA.get(bd.EG().getType())) != null) {
                    cVar.b(bd, bd.EG());
                }
            }
            this.bfB.clear();
            this.bfB = null;
        }
        if (this.mListData != null) {
            this.mListData.clear();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int bfC = 3;
        private i bfD = null;
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

        public i EG() {
            return this.bfD;
        }

        public void b(i iVar) {
            this.bfD = iVar;
        }
    }
}
