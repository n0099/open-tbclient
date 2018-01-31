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
    private HashMap<BdUniqueId, c<T, V>> bdQ = new HashMap<>();
    private List<i> mListData = new ArrayList();
    private List<View> bdR = new ArrayList();
    private int mChildCount = 0;

    public void a(Context context, c<T, V> cVar) {
        if (cVar != null && cVar.getType() != null) {
            this.bdQ.put(cVar.getType(), cVar);
        }
    }

    public b(Context context) {
        this.context = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c<T, V> cVar;
        a bd = bd(view);
        if (bd != null && bd.El() != null && bd.El().getType() != null && (cVar = this.bdQ.get(bd.El().getType())) != null && cVar.Em() != null) {
            cVar.Em().c(bd, bd.El());
        }
    }

    public void setDatas(List<i> list) {
        if (list != null && list.size() > 0) {
            destory();
            this.mListData = list;
            if (this.bdR == null) {
                this.bdR = new ArrayList();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mListData.size()) {
                    i iVar = this.mListData.get(i2);
                    if (iVar != null) {
                        View a2 = a(iVar);
                        a2.setOnClickListener(this);
                        this.bdR.add(a2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private View a(i iVar) {
        c<T, V> cVar = this.bdQ.get(iVar.getType());
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
        if (this.bdR.size() > 0 && i >= 0 && i < this.bdR.size() && (view = this.bdR.get(i)) != null) {
            viewGroup.removeView(view);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i >= this.mListData.size()) {
            return null;
        }
        View gD = gD(i);
        if (gD != null && gD.getParent() != viewGroup) {
            viewGroup.addView(gD);
            return gD;
        }
        return gD;
    }

    public View gD(int i) {
        if (i >= this.bdR.size() || i >= this.mListData.size()) {
            return null;
        }
        View view = this.bdR.get(i);
        a bd = bd(view);
        if (bd != null && bd.El() == null) {
            a((a) view.getTag(), this.mListData.get(i));
            return view;
        }
        return view;
    }

    private void a(a aVar, i iVar) {
        c<T, V> cVar;
        if (aVar != null && iVar != null && (cVar = this.bdQ.get(iVar.getType())) != null) {
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
        if (this.bdR != null) {
            for (View view : this.bdR) {
                a bd = bd(view);
                if (bd != null && bd.El() != null && (cVar = this.bdQ.get(bd.El().getType())) != null) {
                    cVar.b(bd, bd.El());
                }
            }
            this.bdR.clear();
            this.bdR = null;
        }
        if (this.mListData != null) {
            this.mListData.clear();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int bdS = 3;
        private i bdT = null;
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

        public i El() {
            return this.bdT;
        }

        public void b(i iVar) {
            this.bdT = iVar;
        }
    }
}
