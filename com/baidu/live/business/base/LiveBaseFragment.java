package com.baidu.live.business.base;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import c.a.v.b.d.a;
import c.a.v.b.d.c.b;
import c.a.v.f.c.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.business.model.data.LiveFeedWrapData;
import com.baidu.live.business.model.data.LiveTabEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public abstract class LiveBaseFragment extends Fragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LiveTabEntity a;

    /* renamed from: b  reason: collision with root package name */
    public LiveFeedWrapData f25728b;

    /* renamed from: c  reason: collision with root package name */
    public b f25729c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f25730d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f25731e;

    /* renamed from: f  reason: collision with root package name */
    public a f25732f;

    /* renamed from: g  reason: collision with root package name */
    public int f25733g;

    /* renamed from: h  reason: collision with root package name */
    public String f25734h;
    public String i;
    public String j;
    public String k;
    public int l;
    public String m;

    public LiveBaseFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f25731e = true;
        this.f25733g = 1;
        this.i = "";
        this.j = "";
        this.k = "";
        this.m = "";
    }

    public int C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            RecyclerView.LayoutManager layoutManager = D0().getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                return ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
            }
            if (layoutManager instanceof StaggeredGridLayoutManager) {
                int[] findLastVisibleItemPositions = ((StaggeredGridLayoutManager) layoutManager).findLastVisibleItemPositions(null);
                return Math.max(findLastVisibleItemPositions[0], findLastVisibleItemPositions[1]);
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public abstract RecyclerView D0();

    public boolean E0(String str, String str2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, str, str2, i)) == null) {
            if (str == null) {
                str = "";
            }
            if (str2 == null) {
                str2 = "";
            }
            return (str + "_" + str2 + "_" + i).equals(this.m);
        }
        return invokeLLI.booleanValue;
    }

    public abstract void F0(boolean z);

    public void G0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            F0(z);
        }
    }

    public boolean H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            this.l = 0;
            String str = this.m;
            if (str.equals(this.i + "_" + this.k + "_" + this.l)) {
                return false;
            }
            this.m = this.i + "_" + this.k + "_" + this.l;
            this.f25734h = "";
            this.f25733g = 1;
            c.a.v.b.d.b.b(8);
            a aVar = this.f25732f;
            if (aVar != null) {
                aVar.h(c.a.v.b.d.b.a(), this.f25734h, this.l, this.i, this.j, this.k, this.f25733g);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            this.l = 0;
            String str = this.m;
            if (str.equals(this.i + "_" + this.k + "_" + this.l)) {
                return false;
            }
            this.m = this.i + "_" + this.k + "_" + this.l;
            this.f25734h = "";
            this.f25733g = 1;
            c.a.v.b.d.b.b(10);
            a aVar = this.f25732f;
            if (aVar != null) {
                aVar.h(c.a.v.b.d.b.a(), this.f25734h, this.l, this.i, this.j, this.k, this.f25733g);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            this.l = 0;
            String str = this.m;
            if (str.equals(this.i + "_" + this.k + "_" + this.l)) {
                return false;
            }
            this.m = this.i + "_" + this.k + "_" + this.l;
            this.f25734h = "";
            this.f25733g = 1;
            c.a.v.b.d.b.b(11);
            a aVar = this.f25732f;
            if (aVar != null) {
                aVar.h(c.a.v.b.d.b.a(), this.f25734h, this.l, this.i, this.j, this.k, this.f25733g);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void K0(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.f25729c = bVar;
        }
    }

    public void L0(LiveFeedWrapData liveFeedWrapData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, liveFeedWrapData) == null) {
            this.f25728b = liveFeedWrapData;
        }
    }

    public void loadMore() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.l = 1;
            String str = this.m;
            if (str.equals(this.i + "_" + this.k + "_" + this.l)) {
                return;
            }
            this.m = this.i + "_" + this.k + "_" + this.l;
            this.f25733g = this.f25733g + 1;
            c.a.v.b.d.b.b(8);
            a aVar = this.f25732f;
            if (aVar != null) {
                aVar.h(c.a.v.b.d.b.a(), this.f25734h, this.l, this.i, this.j, this.k, this.f25733g);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDestroy();
            this.f25728b = null;
            d.a().e(this);
        }
    }
}
