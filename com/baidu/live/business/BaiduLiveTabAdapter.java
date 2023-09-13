package com.baidu.live.business;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.baidu.live.business.LiveSubTabFragment;
import com.baidu.live.business.base.LiveBaseFragment;
import com.baidu.live.business.model.ILiveFeedModel;
import com.baidu.live.business.model.data.LiveFeedConfig;
import com.baidu.live.business.model.data.LiveFeedReserveWrapData;
import com.baidu.live.business.model.data.LiveFeedWrapData;
import com.baidu.live.business.model.data.LiveTabEntity;
import com.baidu.live.feedpage.interfaces.ILiveFeedOther;
import com.baidu.live.feedpage.interfaces.ILiveFeedRefresh;
import com.baidu.tieba.uc0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class BaiduLiveTabAdapter extends FragmentStatePagerAdapter {
    public final int a;
    public String b;
    public LiveFeedWrapData c;
    public LiveFeedReserveWrapData d;
    public LiveFeedConfig e;
    public List<b> f;
    public String g;
    public String h;
    public ILiveFeedModel i;
    public LiveBaseFragment.a j;
    public LiveSubTabFragment.l k;
    public ILiveFeedOther.LiveFeedStatusListener l;

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        return -2;
    }

    /* loaded from: classes3.dex */
    public class b {
        public LiveTabEntity a;
        public WeakReference<LiveSubTabFragment> b;

        public b(BaiduLiveTabAdapter baiduLiveTabAdapter) {
        }
    }

    public BaiduLiveTabAdapter(FragmentManager fragmentManager, int i, String str, String str2, ILiveFeedModel iLiveFeedModel, LiveBaseFragment.a aVar) {
        super(fragmentManager);
        this.g = str;
        this.a = i;
        this.b = str2;
        this.i = iLiveFeedModel;
        this.j = aVar;
    }

    public void b(int i, ILiveFeedOther.LiveFeedStatusListener liveFeedStatusListener) {
        WeakReference<LiveSubTabFragment> weakReference;
        b g = g(i);
        if (g != null && (weakReference = g.b) != null && weakReference.get() != null) {
            g.b.get().r3(liveFeedStatusListener);
        } else {
            this.l = liveFeedStatusListener;
        }
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        Object instantiateItem = super.instantiateItem(viewGroup, i);
        List<b> list = this.f;
        if (list != null && i >= 0 && i < list.size()) {
            b bVar = this.f.get(i);
            if (bVar.b == null && (instantiateItem instanceof LiveSubTabFragment)) {
                bVar.b = new WeakReference<>((LiveSubTabFragment) instantiateItem);
            }
        }
        return instantiateItem;
    }

    public void n(int i, ILiveFeedRefresh.OnLoadMoreListener onLoadMoreListener) {
        WeakReference<LiveSubTabFragment> weakReference;
        b g = g(i);
        if (g != null && (weakReference = g.b) != null && weakReference.get() != null) {
            g.b.get().Z1(onLoadMoreListener);
        }
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        try {
            super.restoreState(parcelable, classLoader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void c(int i, boolean z, boolean z2) {
        d(i, z, z2, null);
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        super.destroyItem(viewGroup, i, obj);
    }

    public void u(String str, String str2, int i) {
        b bVar;
        WeakReference<LiveSubTabFragment> weakReference;
        if (!uc0.c(this.f) && (bVar = (b) uc0.b(this.f, i)) != null && (weakReference = bVar.b) != null && weakReference.get() != null) {
            bVar.b.get().j4(str, str2);
        }
    }

    public void d(int i, boolean z, boolean z2, ILiveFeedRefresh.OnRefreshListener onRefreshListener) {
        WeakReference<LiveSubTabFragment> weakReference;
        b g = g(i);
        if (g != null && (weakReference = g.b) != null && weakReference.get() != null) {
            g.b.get().X3(z, z2, onRefreshListener);
        }
    }

    public int e(String str) {
        LiveTabEntity liveTabEntity;
        if (!uc0.c(this.f) && str != null) {
            for (int i = 0; i < this.f.size(); i++) {
                b bVar = this.f.get(i);
                if (bVar != null && (liveTabEntity = bVar.a) != null && str.equals(liveTabEntity.type)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public LiveTabEntity f(int i) {
        b bVar = (b) uc0.b(this.f, i);
        if (bVar != null) {
            return bVar.a;
        }
        return null;
    }

    public final b g(int i) {
        List<b> list = this.f;
        if (list != null && i >= 0 && i < list.size()) {
            return this.f.get(i);
        }
        return null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        List<b> list = this.f;
        if (list != null) {
            return list.get(i).a.name;
        }
        return "";
    }

    public boolean h(int i) {
        WeakReference<LiveSubTabFragment> weakReference;
        b g = g(i);
        if (g != null && (weakReference = g.b) != null && weakReference.get() != null) {
            return g.b.get().x3();
        }
        return false;
    }

    public boolean i(int i) {
        WeakReference<LiveSubTabFragment> weakReference;
        b g = g(i);
        if (g != null && (weakReference = g.b) != null && weakReference.get() != null) {
            return g.b.get().K3();
        }
        return false;
    }

    public void j(int i) {
        WeakReference<LiveSubTabFragment> weakReference;
        b g = g(i);
        if (g != null && (weakReference = g.b) != null && weakReference.get() != null) {
            g.b.get().T3();
        }
    }

    public void k(int i) {
        WeakReference<LiveSubTabFragment> weakReference;
        b g = g(i);
        if (g != null && (weakReference = g.b) != null && weakReference.get() != null) {
            g.b.get().U3();
        }
    }

    public void l(int i) {
        WeakReference<LiveSubTabFragment> weakReference;
        b g = g(i);
        if (g != null && (weakReference = g.b) != null && weakReference.get() != null) {
            g.b.get().V3();
        }
    }

    public void p(int i) {
        WeakReference<LiveSubTabFragment> weakReference;
        b g = g(i);
        if (g != null && (weakReference = g.b) != null && weakReference.get() != null) {
            g.b.get().S3();
        }
    }

    public void q(int i) {
        WeakReference<LiveSubTabFragment> weakReference;
        b g = g(i);
        if (g != null && (weakReference = g.b) != null && weakReference.get() != null) {
            g.b.get().W3();
        }
    }

    public void r(int i) {
        b bVar;
        WeakReference<LiveSubTabFragment> weakReference;
        List<b> list = this.f;
        if (list != null && i >= 0 && i < list.size() && (bVar = this.f.get(i)) != null && (weakReference = bVar.b) != null && weakReference.get() != null) {
            bVar.b.get().a2(true);
        }
    }

    public void s(LiveSubTabFragment.l lVar) {
        this.k = lVar;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        List<b> list = this.f;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void onDestroy() {
        if (!uc0.c(this.f)) {
            this.f.clear();
        }
        notifyDataSetChanged();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        List<b> list = this.f;
        if (list != null && i < list.size() && i >= 0) {
            b bVar = this.f.get(i);
            WeakReference<LiveSubTabFragment> weakReference = bVar.b;
            if (weakReference == null || weakReference.get() == null) {
                Bundle bundle = new Bundle();
                bundle.putInt("tab_position", i);
                bundle.putString("tab_scene", this.g);
                bundle.putInt("tab_bd_id", this.a);
                bundle.putParcelable("tab_entity_item", this.f.get(i).a);
                bundle.putString("scheme_def_tab_type", this.b);
                LiveSubTabFragment M3 = LiveSubTabFragment.M3(bundle);
                M3.a4(this.k);
                M3.f2(this.h);
                M3.i2(this.c);
                M3.h2(this.d);
                M3.g2(this.e);
                M3.b4(this.i);
                M3.j2(this.j);
                M3.r3(this.l);
                bVar.b = new WeakReference<>(M3);
            }
            return bVar.b.get();
        }
        return null;
    }

    public void m(String str) {
        WeakReference<LiveSubTabFragment> weakReference;
        if (!uc0.c(this.f)) {
            for (b bVar : this.f) {
                if (bVar != null && (weakReference = bVar.b) != null && weakReference.get() != null) {
                    bVar.b.get().N3(str);
                }
            }
        }
    }

    public void o() {
        WeakReference<LiveSubTabFragment> weakReference;
        if (!uc0.c(this.f)) {
            for (b bVar : this.f) {
                if (bVar != null && (weakReference = bVar.b) != null && weakReference.get() != null) {
                    bVar.b.get().Q3();
                }
            }
        }
    }

    public void t(List<LiveTabEntity> list, LiveFeedWrapData liveFeedWrapData, LiveFeedConfig liveFeedConfig, LiveFeedReserveWrapData liveFeedReserveWrapData, String str) {
        if (uc0.c(list)) {
            return;
        }
        this.h = str;
        this.c = liveFeedWrapData;
        this.d = liveFeedReserveWrapData;
        this.e = liveFeedConfig;
        List<b> list2 = this.f;
        if (list2 != null) {
            list2.clear();
        } else {
            this.f = new ArrayList();
        }
        for (LiveTabEntity liveTabEntity : list) {
            b bVar = new b();
            bVar.a = liveTabEntity;
            this.f.add(bVar);
        }
        notifyDataSetChanged();
    }
}
