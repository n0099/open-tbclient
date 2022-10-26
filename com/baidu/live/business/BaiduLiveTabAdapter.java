package com.baidu.live.business;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.business.LiveSubTabFragment;
import com.baidu.live.business.base.LiveBaseFragment;
import com.baidu.live.business.model.ILiveFeedModel;
import com.baidu.live.business.model.data.LiveFeedConfig;
import com.baidu.live.business.model.data.LiveFeedReserveWrapData;
import com.baidu.live.business.model.data.LiveFeedWrapData;
import com.baidu.live.business.model.data.LiveTabEntity;
import com.baidu.live.feedpage.interfaces.ILiveFeedOther;
import com.baidu.live.feedpage.interfaces.ILiveFeedRefresh;
import com.baidu.tieba.gc0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class BaiduLiveTabAdapter extends FragmentStatePagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public String b;
    public LiveFeedWrapData c;
    public LiveFeedReserveWrapData d;
    public LiveFeedConfig e;
    public List f;
    public String g;
    public String h;
    public ILiveFeedModel i;
    public LiveBaseFragment.a j;
    public LiveSubTabFragment.l k;
    public ILiveFeedOther.LiveFeedStatusListener l;

    /* loaded from: classes2.dex */
    public /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) {
            return -2;
        }
        return invokeL.intValue;
    }

    /* loaded from: classes2.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LiveTabEntity a;
        public WeakReference b;

        public b(BaiduLiveTabAdapter baiduLiveTabAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baiduLiveTabAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(BaiduLiveTabAdapter baiduLiveTabAdapter, a aVar) {
            this(baiduLiveTabAdapter);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaiduLiveTabAdapter(FragmentManager fragmentManager, int i, String str, String str2, ILiveFeedModel iLiveFeedModel, LiveBaseFragment.a aVar) {
        super(fragmentManager);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragmentManager, Integer.valueOf(i), str, str2, iLiveFeedModel, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((FragmentManager) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = str;
        this.a = i;
        this.b = str2;
        this.i = iLiveFeedModel;
        this.j = aVar;
    }

    public void b(int i, ILiveFeedOther.LiveFeedStatusListener liveFeedStatusListener) {
        WeakReference weakReference;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, liveFeedStatusListener) == null) {
            b g = g(i);
            if (g != null && (weakReference = g.b) != null && weakReference.get() != null) {
                ((LiveSubTabFragment) g.b.get()).M2(liveFeedStatusListener);
            } else {
                this.l = liveFeedStatusListener;
            }
        }
    }

    public void n(int i, ILiveFeedRefresh.OnLoadMoreListener onLoadMoreListener) {
        b g;
        WeakReference weakReference;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048594, this, i, onLoadMoreListener) == null) && (g = g(i)) != null && (weakReference = g.b) != null && weakReference.get() != null) {
            ((LiveSubTabFragment) g.b.get()).t1(onLoadMoreListener);
        }
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, parcelable, classLoader) == null) {
            try {
                super.restoreState(parcelable, classLoader);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void c(int i, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            d(i, z, z2, null);
        }
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, viewGroup, i, obj) == null) {
            super.destroyItem(viewGroup, i, obj);
        }
    }

    public void d(int i, boolean z, boolean z2, ILiveFeedRefresh.OnRefreshListener onRefreshListener) {
        b g;
        WeakReference weakReference;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), onRefreshListener}) == null) && (g = g(i)) != null && (weakReference = g.b) != null && weakReference.get() != null) {
            ((LiveSubTabFragment) g.b.get()).s3(z, z2, onRefreshListener);
        }
    }

    public int e(String str) {
        InterceptResult invokeL;
        LiveTabEntity liveTabEntity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (!gc0.c(this.f) && str != null) {
                for (int i = 0; i < this.f.size(); i++) {
                    b bVar = (b) this.f.get(i);
                    if (bVar != null && (liveTabEntity = bVar.a) != null && str.equals(liveTabEntity.type)) {
                        return i;
                    }
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public void m(String str) {
        WeakReference weakReference;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, str) == null) && !gc0.c(this.f)) {
            for (b bVar : this.f) {
                if (bVar != null && (weakReference = bVar.b) != null && weakReference.get() != null) {
                    ((LiveSubTabFragment) bVar.b.get()).i3(str);
                }
            }
        }
    }

    public void r(int i) {
        List list;
        b bVar;
        WeakReference weakReference;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048599, this, i) == null) && (list = this.f) != null && i >= 0 && i < list.size() && (bVar = (b) this.f.get(i)) != null && (weakReference = bVar.b) != null && weakReference.get() != null) {
            ((LiveSubTabFragment) bVar.b.get()).u1(true);
        }
    }

    public LiveTabEntity f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            b bVar = (b) gc0.b(this.f, i);
            if (bVar != null) {
                return bVar.a;
            }
            return null;
        }
        return (LiveTabEntity) invokeI.objValue;
    }

    public final b g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            List list = this.f;
            if (list != null && i >= 0 && i < list.size()) {
                return (b) this.f.get(i);
            }
            return null;
        }
        return (b) invokeI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            List list = this.f;
            if (list != null) {
                return ((b) list.get(i)).a.name;
            }
            return "";
        }
        return (CharSequence) invokeI.objValue;
    }

    public boolean h(int i) {
        InterceptResult invokeI;
        WeakReference weakReference;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            b g = g(i);
            if (g != null && (weakReference = g.b) != null && weakReference.get() != null) {
                return ((LiveSubTabFragment) g.b.get()).S2();
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean i(int i) {
        InterceptResult invokeI;
        WeakReference weakReference;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            b g = g(i);
            if (g != null && (weakReference = g.b) != null && weakReference.get() != null) {
                return ((LiveSubTabFragment) g.b.get()).f3();
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void j(int i) {
        b g;
        WeakReference weakReference;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048590, this, i) == null) && (g = g(i)) != null && (weakReference = g.b) != null && weakReference.get() != null) {
            ((LiveSubTabFragment) g.b.get()).o3();
        }
    }

    public void k(int i) {
        b g;
        WeakReference weakReference;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048591, this, i) == null) && (g = g(i)) != null && (weakReference = g.b) != null && weakReference.get() != null) {
            ((LiveSubTabFragment) g.b.get()).p3();
        }
    }

    public void l(int i) {
        b g;
        WeakReference weakReference;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048592, this, i) == null) && (g = g(i)) != null && (weakReference = g.b) != null && weakReference.get() != null) {
            ((LiveSubTabFragment) g.b.get()).q3();
        }
    }

    public void p(int i) {
        b g;
        WeakReference weakReference;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048597, this, i) == null) && (g = g(i)) != null && (weakReference = g.b) != null && weakReference.get() != null) {
            ((LiveSubTabFragment) g.b.get()).n3();
        }
    }

    public void q(int i) {
        b g;
        WeakReference weakReference;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048598, this, i) == null) && (g = g(i)) != null && (weakReference = g.b) != null && weakReference.get() != null) {
            ((LiveSubTabFragment) g.b.get()).r3();
        }
    }

    public void s(LiveSubTabFragment.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, lVar) == null) {
            this.k = lVar;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            List list = this.f;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (!gc0.c(this.f)) {
                this.f.clear();
            }
            notifyDataSetChanged();
        }
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            List list = this.f;
            if (list != null && i < list.size() && i >= 0) {
                b bVar = (b) this.f.get(i);
                WeakReference weakReference = bVar.b;
                if (weakReference == null || weakReference.get() == null) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("tab_position", i);
                    bundle.putString("tab_scene", this.g);
                    bundle.putInt("tab_bd_id", this.a);
                    bundle.putParcelable("tab_entity_item", ((b) this.f.get(i)).a);
                    bundle.putString("scheme_def_tab_type", this.b);
                    LiveSubTabFragment h3 = LiveSubTabFragment.h3(bundle);
                    h3.v3(this.k);
                    h3.A1(this.h);
                    h3.D1(this.c);
                    h3.C1(this.d);
                    h3.B1(this.e);
                    h3.w3(this.i);
                    h3.E1(this.j);
                    h3.M2(this.l);
                    bVar.b = new WeakReference(h3);
                }
                return (Fragment) bVar.b.get();
            }
            return null;
        }
        return (Fragment) invokeI.objValue;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048589, this, viewGroup, i)) == null) {
            Object instantiateItem = super.instantiateItem(viewGroup, i);
            List list = this.f;
            if (list != null && i >= 0 && i < list.size()) {
                b bVar = (b) this.f.get(i);
                if (bVar.b == null && (instantiateItem instanceof LiveSubTabFragment)) {
                    bVar.b = new WeakReference((LiveSubTabFragment) instantiateItem);
                }
            }
            return instantiateItem;
        }
        return invokeLI.objValue;
    }

    public void o() {
        WeakReference weakReference;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && !gc0.c(this.f)) {
            for (b bVar : this.f) {
                if (bVar != null && (weakReference = bVar.b) != null && weakReference.get() != null) {
                    ((LiveSubTabFragment) bVar.b.get()).l3();
                }
            }
        }
    }

    public void t(List list, LiveFeedWrapData liveFeedWrapData, LiveFeedConfig liveFeedConfig, LiveFeedReserveWrapData liveFeedReserveWrapData, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLLL(1048602, this, list, liveFeedWrapData, liveFeedConfig, liveFeedReserveWrapData, str) != null) || gc0.c(list)) {
            return;
        }
        this.h = str;
        this.c = liveFeedWrapData;
        this.d = liveFeedReserveWrapData;
        this.e = liveFeedConfig;
        List list2 = this.f;
        if (list2 != null) {
            list2.clear();
        } else {
            this.f = new ArrayList();
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            b bVar = new b(this, null);
            bVar.a = (LiveTabEntity) it.next();
            this.f.add(bVar);
        }
        notifyDataSetChanged();
    }

    public void u(String str, String str2, int i) {
        b bVar;
        WeakReference weakReference;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048603, this, str, str2, i) == null) && !gc0.c(this.f) && (bVar = (b) gc0.b(this.f, i)) != null && (weakReference = bVar.b) != null && weakReference.get() != null) {
            ((LiveSubTabFragment) bVar.b.get()).E3(str, str2);
        }
    }
}
