package com.baidu.live.business;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import c.a.v.f.g.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.business.model.data.LiveFeedWrapData;
import com.baidu.live.business.model.data.LiveTabEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class BaiduLiveTabAdapter extends FragmentStatePagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public String f25676b;

    /* renamed from: c  reason: collision with root package name */
    public String f25677c;

    /* renamed from: d  reason: collision with root package name */
    public LiveFeedWrapData f25678d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.v.b.d.c.b f25679e;

    /* renamed from: f  reason: collision with root package name */
    public List<b> f25680f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f25681g;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LiveTabEntity a;

        /* renamed from: b  reason: collision with root package name */
        public WeakReference<LiveSubTabFragment> f25682b;

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
    public BaiduLiveTabAdapter(FragmentManager fragmentManager, int i, boolean z, String str, String str2) {
        super(fragmentManager);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragmentManager, Integer.valueOf(i), Boolean.valueOf(z), str, str2};
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
        this.f25681g = z;
        this.a = i;
        this.f25676b = str;
        this.f25677c = str2;
    }

    public void b(int i, boolean z, boolean z2) {
        b d2;
        WeakReference<LiveSubTabFragment> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (d2 = d(i)) == null || (weakReference = d2.f25682b) == null || weakReference.get() == null) {
            return;
        }
        d2.f25682b.get().c2(z, z2);
    }

    public LiveTabEntity c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            b bVar = (b) d.b(this.f25680f, i);
            if (bVar != null) {
                return bVar.a;
            }
            return null;
        }
        return (LiveTabEntity) invokeI.objValue;
    }

    public final b d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            List<b> list = this.f25680f;
            if (list == null || i < 0 || i >= list.size()) {
                return null;
            }
            return this.f25680f.get(i);
        }
        return (b) invokeI.objValue;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, viewGroup, i, obj) == null) {
            super.destroyItem(viewGroup, i, obj);
        }
    }

    public void e(int i) {
        b d2;
        WeakReference<LiveSubTabFragment> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i) == null) || (d2 = d(i)) == null || (weakReference = d2.f25682b) == null || weakReference.get() == null) {
            return;
        }
        d2.f25682b.get().Y1();
    }

    public void f(int i) {
        b d2;
        WeakReference<LiveSubTabFragment> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || (d2 = d(i)) == null || (weakReference = d2.f25682b) == null || weakReference.get() == null) {
            return;
        }
        d2.f25682b.get().Z1();
    }

    public void g(int i) {
        b d2;
        WeakReference<LiveSubTabFragment> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i) == null) || (d2 = d(i)) == null || (weakReference = d2.f25682b) == null || weakReference.get() == null) {
            return;
        }
        d2.f25682b.get().a2();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            List<b> list = this.f25680f;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            List<b> list = this.f25680f;
            if (list == null || i >= list.size() || i < 0) {
                return null;
            }
            b bVar = this.f25680f.get(i);
            WeakReference<LiveSubTabFragment> weakReference = bVar.f25682b;
            if (weakReference == null || weakReference.get() == null) {
                Bundle bundle = new Bundle();
                bundle.putInt("tab_position", i);
                bundle.putBoolean("tab_is_immer", this.f25681g);
                bundle.putInt("tab_bd_id", this.a);
                bundle.putParcelable("tab_entity_item", this.f25680f.get(i).a);
                bundle.putString("source", this.f25676b);
                bundle.putString("scheme_def_tab_type", this.f25677c);
                LiveSubTabFragment V1 = LiveSubTabFragment.V1(bundle);
                V1.L0(this.f25678d);
                V1.K0(this.f25679e);
                bVar.f25682b = new WeakReference<>(V1);
            }
            return bVar.f25682b.get();
        }
        return (Fragment) invokeI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) {
            return -2;
        }
        return invokeL.intValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            List<b> list = this.f25680f;
            return list != null ? list.get(i).a.name : "";
        }
        return (CharSequence) invokeI.objValue;
    }

    public void h(String str) {
        WeakReference<LiveSubTabFragment> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || d.c(this.f25680f)) {
            return;
        }
        for (b bVar : this.f25680f) {
            if (bVar != null && (weakReference = bVar.f25682b) != null && weakReference.get() != null) {
                bVar.f25682b.get().W1(str);
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || d.c(this.f25680f)) {
            return;
        }
        this.f25680f.clear();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048589, this, viewGroup, i)) == null) {
            Object instantiateItem = super.instantiateItem(viewGroup, i);
            List<b> list = this.f25680f;
            if (list != null && i >= 0 && i < list.size()) {
                b bVar = this.f25680f.get(i);
                if (bVar.f25682b == null && (instantiateItem instanceof LiveSubTabFragment)) {
                    bVar.f25682b = new WeakReference<>((LiveSubTabFragment) instantiateItem);
                }
            }
            return instantiateItem;
        }
        return invokeLI.objValue;
    }

    public void j(int i) {
        b d2;
        WeakReference<LiveSubTabFragment> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i) == null) || (d2 = d(i)) == null || (weakReference = d2.f25682b) == null || weakReference.get() == null) {
            return;
        }
        d2.f25682b.get().X1();
    }

    public void k(int i) {
        b d2;
        WeakReference<LiveSubTabFragment> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i) == null) || (d2 = d(i)) == null || (weakReference = d2.f25682b) == null || weakReference.get() == null) {
            return;
        }
        d2.f25682b.get().b2();
    }

    public void l(int i) {
        List<b> list;
        b bVar;
        WeakReference<LiveSubTabFragment> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048592, this, i) == null) || (list = this.f25680f) == null || i < 0 || i >= list.size() || (bVar = this.f25680f.get(i)) == null || (weakReference = bVar.f25682b) == null || weakReference.get() == null) {
            return;
        }
        bVar.f25682b.get().F0(true);
    }

    public void m(List<LiveTabEntity> list, LiveFeedWrapData liveFeedWrapData, c.a.v.b.d.c.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048593, this, list, liveFeedWrapData, bVar) == null) || d.c(list)) {
            return;
        }
        this.f25678d = liveFeedWrapData;
        this.f25679e = bVar;
        List<b> list2 = this.f25680f;
        if (list2 != null) {
            list2.clear();
        } else {
            this.f25680f = new ArrayList();
        }
        for (LiveTabEntity liveTabEntity : list) {
            b bVar2 = new b(this, null);
            bVar2.a = liveTabEntity;
            this.f25680f.add(bVar2);
        }
        notifyDataSetChanged();
    }

    public void n(String str, String str2, int i) {
        b bVar;
        WeakReference<LiveSubTabFragment> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048594, this, str, str2, i) == null) || d.c(this.f25680f) || (bVar = (b) d.b(this.f25680f, i)) == null || (weakReference = bVar.f25682b) == null || weakReference.get() == null) {
            return;
        }
        bVar.f25682b.get().l2(str, str2);
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, parcelable, classLoader) == null) {
            try {
                super.restoreState(parcelable, classLoader);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
