package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.view.viewpager.a.C0043a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class a<T extends u, V extends C0043a> extends PagerAdapter implements View.OnClickListener {
    private Context context;
    private HashMap<BdUniqueId, g<T, V>> afW = new HashMap<>();
    private List<u> mListData = new ArrayList();
    private List<View> afX = new ArrayList();
    private int mChildCount = 0;

    public void a(Context context, g<T, V> gVar) {
        if (gVar != null && gVar.getType() != null) {
            this.afW.put(gVar.getType(), gVar);
        }
    }

    public a(Context context) {
        this.context = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g<T, V> gVar;
        C0043a s = s(view);
        if (s != null && s.wr() != null && s.wr().getType() != null && (gVar = this.afW.get(s.wr().getType())) != null && gVar.wt() != null) {
            gVar.wt().c(s, s.wr());
        }
    }

    public void setDatas(List<u> list) {
        if (list != null && list.size() > 0) {
            destory();
            this.mListData = list;
            if (this.afX == null) {
                this.afX = new ArrayList();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mListData.size()) {
                    u uVar = this.mListData.get(i2);
                    if (uVar != null) {
                        View a = a(uVar);
                        a.setOnClickListener(this);
                        this.afX.add(a);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private View a(u uVar) {
        g<T, V> gVar = this.afW.get(uVar.getType());
        if (gVar != null) {
            V c = gVar.c(null);
            if (BdBaseApplication.getInst().isDebugMode()) {
                BdLog.i("ViewPager View is creating " + c.getClass().getName());
            }
            if (c != null) {
                c.b(uVar);
                gVar.a((ViewGroup) null, (ViewGroup) c, (V) uVar);
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
        if (this.afX.size() > 0 && i >= 0 && i < this.afX.size() && (view = this.afX.get(i)) != null) {
            viewGroup.removeView(view);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i >= this.mListData.size()) {
            return null;
        }
        View cY = cY(i);
        if (cY != null && cY.getParent() != viewGroup) {
            viewGroup.addView(cY);
            return cY;
        }
        return cY;
    }

    public View cY(int i) {
        if (i >= this.afX.size() || i >= this.mListData.size()) {
            return null;
        }
        View view = this.afX.get(i);
        C0043a s = s(view);
        if (s != null && s.wr() == null) {
            a((C0043a) view.getTag(), this.mListData.get(i));
            return view;
        }
        return view;
    }

    private void a(C0043a c0043a, u uVar) {
        g<T, V> gVar;
        if (c0043a != null && uVar != null && (gVar = this.afW.get(uVar.getType())) != null) {
            c0043a.b(uVar);
            gVar.a((ViewGroup) null, (ViewGroup) c0043a, (C0043a) uVar);
        }
    }

    private C0043a s(View view) {
        if (view == null || !(view.getTag() instanceof C0043a)) {
            return null;
        }
        return (C0043a) view.getTag();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Parcelable saveState() {
        return super.saveState();
    }

    public void destory() {
        g<T, V> gVar;
        if (this.afX != null) {
            for (View view : this.afX) {
                C0043a s = s(view);
                if (s != null && s.wr() != null && (gVar = this.afW.get(s.wr().getType())) != null) {
                    gVar.b(s, s.wr());
                }
            }
            this.afX.clear();
            this.afX = null;
        }
        if (this.mListData != null) {
            this.mListData.clear();
        }
    }

    public void cZ(int i) {
        g<T, V> gVar;
        if (this.afX != null) {
            for (View view : this.afX) {
                C0043a s = s(view);
                if (s != null && s.wr() != null && (gVar = this.afW.get(s.wr().getType())) != null) {
                    gVar.a(i, (int) s, (C0043a) s.wr());
                }
            }
        }
    }

    /* renamed from: com.baidu.tbadk.core.view.viewpager.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0043a {
        public int afY = 3;
        private u afZ = null;
        private View view;

        public C0043a(View view) {
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

        public u wr() {
            return this.afZ;
        }

        public void b(u uVar) {
            this.afZ = uVar;
        }
    }
}
