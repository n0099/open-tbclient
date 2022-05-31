package com.baidu.live.business.base;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.business.model.data.LiveFeedWrapData;
import com.baidu.live.business.model.data.LiveTabEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a80;
import com.repackage.b80;
import com.repackage.d80;
import com.repackage.t90;
/* loaded from: classes2.dex */
public abstract class LiveBaseFragment extends Fragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LiveTabEntity a;
    public LiveFeedWrapData b;
    public d80 c;
    public boolean d;
    public boolean e;
    public a80 f;
    public int g;
    public String h;
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
        this.e = true;
        this.g = 1;
        this.i = "";
        this.j = "";
        this.k = "";
        this.m = "";
    }

    public int E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            RecyclerView.LayoutManager layoutManager = F0().getLayoutManager();
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

    public abstract RecyclerView F0();

    public boolean G0(String str, String str2, int i) {
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

    public abstract void H0(boolean z);

    public void I0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            H0(z);
        }
    }

    public boolean J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            this.l = 0;
            String str = this.m;
            if (str.equals(this.i + "_" + this.k + "_" + this.l)) {
                return false;
            }
            this.m = this.i + "_" + this.k + "_" + this.l;
            this.h = "";
            this.g = 1;
            b80.b(8);
            a80 a80Var = this.f;
            if (a80Var != null) {
                a80Var.h(b80.a(), this.h, this.l, this.i, this.j, this.k, this.g);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            this.l = 0;
            String str = this.m;
            if (str.equals(this.i + "_" + this.k + "_" + this.l)) {
                return false;
            }
            this.m = this.i + "_" + this.k + "_" + this.l;
            this.h = "";
            this.g = 1;
            b80.b(10);
            a80 a80Var = this.f;
            if (a80Var != null) {
                a80Var.h(b80.a(), this.h, this.l, this.i, this.j, this.k, this.g);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            this.l = 0;
            String str = this.m;
            if (str.equals(this.i + "_" + this.k + "_" + this.l)) {
                return false;
            }
            this.m = this.i + "_" + this.k + "_" + this.l;
            this.h = "";
            this.g = 1;
            b80.b(11);
            a80 a80Var = this.f;
            if (a80Var != null) {
                a80Var.h(b80.a(), this.h, this.l, this.i, this.j, this.k, this.g);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void M0(d80 d80Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, d80Var) == null) {
            this.c = d80Var;
        }
    }

    public void N0(LiveFeedWrapData liveFeedWrapData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, liveFeedWrapData) == null) {
            this.b = liveFeedWrapData;
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
            this.g = this.g + 1;
            b80.b(8);
            a80 a80Var = this.f;
            if (a80Var != null) {
                a80Var.h(b80.a(), this.h, this.l, this.i, this.j, this.k, this.g);
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
            this.b = null;
            t90.a().e(this);
        }
    }
}
