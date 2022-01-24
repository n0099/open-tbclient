package com.baidu.live.business;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import c.a.x.g.g.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.business.base.LiveBaseFragment;
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
/* loaded from: classes10.dex */
public class BaiduLiveTabAdapter extends FragmentStatePagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public String f34722b;

    /* renamed from: c  reason: collision with root package name */
    public String f34723c;

    /* renamed from: d  reason: collision with root package name */
    public LiveFeedWrapData f34724d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.x.b.d.c.b f34725e;

    /* renamed from: f  reason: collision with root package name */
    public List<b> f34726f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f34727g;

    /* loaded from: classes10.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes10.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LiveTabEntity a;

        /* renamed from: b  reason: collision with root package name */
        public WeakReference<LiveSubTabFragment> f34728b;

        public b(BaiduLiveTabAdapter baiduLiveTabAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baiduLiveTabAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
    public BaiduLiveTabAdapter(FragmentManager fragmentManager, int i2, boolean z, String str, String str2) {
        super(fragmentManager);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragmentManager, Integer.valueOf(i2), Boolean.valueOf(z), str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((FragmentManager) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34727g = z;
        this.a = i2;
        this.f34722b = str;
        this.f34723c = str2;
    }

    public final b a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<b> list = this.f34726f;
            if (list == null || i2 < 0 || i2 >= list.size()) {
                return null;
            }
            return this.f34726f.get(i2);
        }
        return (b) invokeI.objValue;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i2, obj) == null) {
            super.destroyItem(viewGroup, i2, obj);
        }
    }

    public void externalRefresh(int i2, boolean z, boolean z2) {
        b a2;
        WeakReference<LiveSubTabFragment> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (a2 = a(i2)) == null || (weakReference = a2.f34728b) == null || weakReference.get() == null) {
            return;
        }
        a2.f34728b.get().refresh(z, z2);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<b> list = this.f34726f;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            List<b> list = this.f34726f;
            if (list == null || i2 >= list.size() || i2 < 0) {
                return null;
            }
            b bVar = this.f34726f.get(i2);
            WeakReference<LiveSubTabFragment> weakReference = bVar.f34728b;
            if (weakReference == null || weakReference.get() == null) {
                Bundle bundle = new Bundle();
                bundle.putInt(LiveBaseFragment.TAB_POSITION, i2);
                bundle.putBoolean(LiveBaseFragment.TAB_IS_IMMER, this.f34727g);
                bundle.putInt(LiveBaseFragment.TAB_BD_ID, this.a);
                bundle.putParcelable(LiveBaseFragment.TAB_ENTITY_ITEM, this.f34726f.get(i2).a);
                bundle.putString("source", this.f34722b);
                bundle.putString(LiveBaseFragment.SCHEME_DEF_SUB_TAB_TYPE, this.f34723c);
                LiveSubTabFragment newInstance = LiveSubTabFragment.newInstance(bundle);
                newInstance.setFeedWrapData(this.f34724d);
                newInstance.setFeedConfigData(this.f34725e);
                bVar.f34728b = new WeakReference<>(newInstance);
            }
            return bVar.f34728b.get();
        }
        return (Fragment) invokeI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            return -2;
        }
        return invokeL.intValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            List<b> list = this.f34726f;
            return list != null ? list.get(i2).a.name : "";
        }
        return (CharSequence) invokeI.objValue;
    }

    public int getPosByType(String str) {
        InterceptResult invokeL;
        LiveTabEntity liveTabEntity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (d.c(this.f34726f)) {
                return -1;
            }
            for (int i2 = 0; i2 < this.f34726f.size(); i2++) {
                b bVar = this.f34726f.get(i2);
                if (bVar != null && (liveTabEntity = bVar.a) != null && str.equals(liveTabEntity.type)) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public LiveTabEntity getSubTab(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            b bVar = (b) d.b(this.f34726f, i2);
            if (bVar != null) {
                return bVar.a;
            }
            return null;
        }
        return (LiveTabEntity) invokeI.objValue;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, viewGroup, i2)) == null) {
            Object instantiateItem = super.instantiateItem(viewGroup, i2);
            List<b> list = this.f34726f;
            if (list != null && i2 >= 0 && i2 < list.size()) {
                b bVar = this.f34726f.get(i2);
                if (bVar.f34728b == null && (instantiateItem instanceof LiveSubTabFragment)) {
                    bVar.f34728b = new WeakReference<>((LiveSubTabFragment) instantiateItem);
                }
            }
            return instantiateItem;
        }
        return invokeLI.objValue;
    }

    public void notifyFragmentNetChange(int i2) {
        b a2;
        WeakReference<LiveSubTabFragment> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || (a2 = a(i2)) == null || (weakReference = a2.f34728b) == null || weakReference.get() == null) {
            return;
        }
        a2.f34728b.get().onNetChange();
    }

    public void notifyPause(int i2) {
        b a2;
        WeakReference<LiveSubTabFragment> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || (a2 = a(i2)) == null || (weakReference = a2.f34728b) == null || weakReference.get() == null) {
            return;
        }
        a2.f34728b.get().onParentPause();
    }

    public void notifyResume(int i2) {
        b a2;
        WeakReference<LiveSubTabFragment> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (a2 = a(i2)) == null || (weakReference = a2.f34728b) == null || weakReference.get() == null) {
            return;
        }
        a2.f34728b.get().onParentResume();
    }

    public void onDarkModeChange(String str) {
        WeakReference<LiveSubTabFragment> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || d.c(this.f34726f)) {
            return;
        }
        for (b bVar : this.f34726f) {
            if (bVar != null && (weakReference = bVar.f34728b) != null && weakReference.get() != null) {
                bVar.f34728b.get().onDarkModeChange(str);
            }
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || d.c(this.f34726f)) {
            return;
        }
        this.f34726f.clear();
    }

    public void onHintLog(int i2) {
        b a2;
        WeakReference<LiveSubTabFragment> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i2) == null) || (a2 = a(i2)) == null || (weakReference = a2.f34728b) == null || weakReference.get() == null) {
            return;
        }
        a2.f34728b.get().onHintLog();
    }

    public void onShowLog(int i2) {
        b a2;
        WeakReference<LiveSubTabFragment> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048592, this, i2) == null) || (a2 = a(i2)) == null || (weakReference = a2.f34728b) == null || weakReference.get() == null) {
            return;
        }
        a2.f34728b.get().onShowLog();
    }

    public void resetFragment() {
        WeakReference<LiveSubTabFragment> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || d.c(this.f34726f)) {
            return;
        }
        for (b bVar : this.f34726f) {
            if (bVar != null && (weakReference = bVar.f34728b) != null && weakReference.get() != null) {
                bVar.f34728b.get().reset();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, parcelable, classLoader) == null) {
            try {
                super.restoreState(parcelable, classLoader);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void selectDefault(int i2) {
        List<b> list;
        b bVar;
        WeakReference<LiveSubTabFragment> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || (list = this.f34726f) == null || i2 < 0 || i2 >= list.size() || (bVar = this.f34726f.get(i2)) == null || (weakReference = bVar.f34728b) == null || weakReference.get() == null) {
            return;
        }
        bVar.f34728b.get().onFragmentShow(true);
    }

    public void setTabList(List<LiveTabEntity> list, LiveFeedWrapData liveFeedWrapData, c.a.x.b.d.c.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048596, this, list, liveFeedWrapData, bVar) == null) || d.c(list)) {
            return;
        }
        this.f34724d = liveFeedWrapData;
        this.f34725e = bVar;
        List<b> list2 = this.f34726f;
        if (list2 != null) {
            list2.clear();
        } else {
            this.f34726f = new ArrayList();
        }
        for (LiveTabEntity liveTabEntity : list) {
            b bVar2 = new b(this, null);
            bVar2.a = liveTabEntity;
            this.f34726f.add(bVar2);
        }
        notifyDataSetChanged();
    }

    public void updateTabInfo(String str, String str2, int i2) {
        b bVar;
        WeakReference<LiveSubTabFragment> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048597, this, str, str2, i2) == null) || d.c(this.f34726f) || (bVar = (b) d.b(this.f34726f, i2)) == null || (weakReference = bVar.f34728b) == null || weakReference.get() == null) {
            return;
        }
        bVar.f34728b.get().updateTabInfo(str, str2);
    }
}
