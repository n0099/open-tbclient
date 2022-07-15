package com.baidu.live.business;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.business.model.data.LiveFeedWrapData;
import com.baidu.live.business.model.data.LiveTabEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.i80;
import com.repackage.na0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class BaiduLiveTabAdapter extends FragmentStatePagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public String b;
    public String c;
    public LiveFeedWrapData d;
    public i80 e;
    public List<b> f;
    public boolean g;

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LiveTabEntity a;
        public WeakReference<LiveSubTabFragment> b;

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
        this.g = z;
        this.a = i;
        this.b = str;
        this.c = str2;
    }

    public void b(int i, boolean z, boolean z2) {
        b d;
        WeakReference<LiveSubTabFragment> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (d = d(i)) == null || (weakReference = d.b) == null || weakReference.get() == null) {
            return;
        }
        d.b.get().T2(z, z2);
    }

    public LiveTabEntity c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            b bVar = (b) na0.b(this.f, i);
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
            List<b> list = this.f;
            if (list == null || i < 0 || i >= list.size()) {
                return null;
            }
            return this.f.get(i);
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
        b d;
        WeakReference<LiveSubTabFragment> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i) == null) || (d = d(i)) == null || (weakReference = d.b) == null || weakReference.get() == null) {
            return;
        }
        d.b.get().P2();
    }

    public void f(int i) {
        b d;
        WeakReference<LiveSubTabFragment> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || (d = d(i)) == null || (weakReference = d.b) == null || weakReference.get() == null) {
            return;
        }
        d.b.get().Q2();
    }

    public void g(int i) {
        b d;
        WeakReference<LiveSubTabFragment> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i) == null) || (d = d(i)) == null || (weakReference = d.b) == null || weakReference.get() == null) {
            return;
        }
        d.b.get().R2();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            List<b> list = this.f;
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
            List<b> list = this.f;
            if (list == null || i >= list.size() || i < 0) {
                return null;
            }
            b bVar = this.f.get(i);
            WeakReference<LiveSubTabFragment> weakReference = bVar.b;
            if (weakReference == null || weakReference.get() == null) {
                Bundle bundle = new Bundle();
                bundle.putInt("tab_position", i);
                bundle.putBoolean("tab_is_immer", this.g);
                bundle.putInt("tab_bd_id", this.a);
                bundle.putParcelable("tab_entity_item", this.f.get(i).a);
                bundle.putString("source", this.b);
                bundle.putString("scheme_def_tab_type", this.c);
                LiveSubTabFragment M2 = LiveSubTabFragment.M2(bundle);
                M2.C1(this.d);
                M2.B1(this.e);
                bVar.b = new WeakReference<>(M2);
            }
            return bVar.b.get();
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
            List<b> list = this.f;
            return list != null ? list.get(i).a.name : "";
        }
        return (CharSequence) invokeI.objValue;
    }

    public void h(String str) {
        WeakReference<LiveSubTabFragment> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || na0.c(this.f)) {
            return;
        }
        for (b bVar : this.f) {
            if (bVar != null && (weakReference = bVar.b) != null && weakReference.get() != null) {
                bVar.b.get().N2(str);
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || na0.c(this.f)) {
            return;
        }
        this.f.clear();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048589, this, viewGroup, i)) == null) {
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
        return invokeLI.objValue;
    }

    public void j(int i) {
        b d;
        WeakReference<LiveSubTabFragment> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i) == null) || (d = d(i)) == null || (weakReference = d.b) == null || weakReference.get() == null) {
            return;
        }
        d.b.get().O2();
    }

    public void k(int i) {
        b d;
        WeakReference<LiveSubTabFragment> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i) == null) || (d = d(i)) == null || (weakReference = d.b) == null || weakReference.get() == null) {
            return;
        }
        d.b.get().S2();
    }

    public void l(int i) {
        List<b> list;
        b bVar;
        WeakReference<LiveSubTabFragment> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048592, this, i) == null) || (list = this.f) == null || i < 0 || i >= list.size() || (bVar = this.f.get(i)) == null || (weakReference = bVar.b) == null || weakReference.get() == null) {
            return;
        }
        bVar.b.get().v1(true);
    }

    public void m(List<LiveTabEntity> list, LiveFeedWrapData liveFeedWrapData, i80 i80Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048593, this, list, liveFeedWrapData, i80Var) == null) || na0.c(list)) {
            return;
        }
        this.d = liveFeedWrapData;
        this.e = i80Var;
        List<b> list2 = this.f;
        if (list2 != null) {
            list2.clear();
        } else {
            this.f = new ArrayList();
        }
        for (LiveTabEntity liveTabEntity : list) {
            b bVar = new b(this, null);
            bVar.a = liveTabEntity;
            this.f.add(bVar);
        }
        notifyDataSetChanged();
    }

    public void n(String str, String str2, int i) {
        b bVar;
        WeakReference<LiveSubTabFragment> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048594, this, str, str2, i) == null) || na0.c(this.f) || (bVar = (b) na0.b(this.f, i)) == null || (weakReference = bVar.b) == null || weakReference.get() == null) {
            return;
        }
        bVar.b.get().c3(str, str2);
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, parcelable, classLoader) == null) {
            try {
                super.restoreState(parcelable, classLoader);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
