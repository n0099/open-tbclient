package com.baidu.live.business.base;

import android.os.Bundle;
import androidx.annotation.Nullable;
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
import com.repackage.e80;
import com.repackage.f80;
import com.repackage.h80;
import com.repackage.x90;
/* loaded from: classes2.dex */
public abstract class LiveBaseFragment extends Fragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LiveTabEntity a;
    public LiveFeedWrapData b;
    public h80 c;
    public boolean d;
    public boolean e;
    public e80 f;
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

    public void A1(h80 h80Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, h80Var) == null) {
            this.c = h80Var;
        }
    }

    public void B1(LiveFeedWrapData liveFeedWrapData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, liveFeedWrapData) == null) {
            this.b = liveFeedWrapData;
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.l = 1;
            String str = this.m;
            if (str.equals(this.i + "_" + this.k + "_" + this.l)) {
                return;
            }
            this.m = this.i + "_" + this.k + "_" + this.l;
            this.g = this.g + 1;
            f80.b(8);
            e80 e80Var = this.f;
            if (e80Var != null) {
                e80Var.h(f80.a(), this.h, this.l, this.i, this.j, this.k, this.g);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            this.b = null;
            x90.a().e(this);
        }
    }

    public int r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            RecyclerView.LayoutManager layoutManager = s1().getLayoutManager();
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

    public abstract RecyclerView s1();

    public boolean t1(String str, String str2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048583, this, str, str2, i)) == null) {
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

    public abstract void u1(boolean z);

    public void v1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            u1(z);
        }
    }

    public boolean w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            this.l = 0;
            String str = this.m;
            if (str.equals(this.i + "_" + this.k + "_" + this.l)) {
                return false;
            }
            this.m = this.i + "_" + this.k + "_" + this.l;
            this.h = "";
            this.g = 1;
            f80.b(8);
            e80 e80Var = this.f;
            if (e80Var != null) {
                e80Var.h(f80.a(), this.h, this.l, this.i, this.j, this.k, this.g);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            this.l = 0;
            String str = this.m;
            if (str.equals(this.i + "_" + this.k + "_" + this.l)) {
                return false;
            }
            this.m = this.i + "_" + this.k + "_" + this.l;
            this.h = "";
            this.g = 1;
            f80.b(10);
            e80 e80Var = this.f;
            if (e80Var != null) {
                e80Var.h(f80.a(), this.h, this.l, this.i, this.j, this.k, this.g);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            this.l = 0;
            String str = this.m;
            if (str.equals(this.i + "_" + this.k + "_" + this.l)) {
                return false;
            }
            this.m = this.i + "_" + this.k + "_" + this.l;
            this.h = "";
            this.g = 1;
            f80.b(11);
            e80 e80Var = this.f;
            if (e80Var != null) {
                e80Var.h(f80.a(), this.h, this.l, this.i, this.j, this.k, this.g);
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
