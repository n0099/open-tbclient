package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter.a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import d.a.r0.r.f0.t.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class BdBaseViewPagerAdapter<T extends n, V extends a> extends PagerAdapter implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f12756e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<BdUniqueId, b<T, V>> f12757f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f12758g;

    /* renamed from: h  reason: collision with root package name */
    public List<View> f12759h;

    /* renamed from: i  reason: collision with root package name */
    public int f12760i;

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f12761e;

        /* renamed from: f  reason: collision with root package name */
        public View f12762f;

        /* renamed from: g  reason: collision with root package name */
        public n f12763g;

        public a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12761e = 3;
            this.f12762f = null;
            this.f12763g = null;
            this.f12762f = view;
            if (view != null) {
                view.setTag(this);
                return;
            }
            throw new RuntimeException("view cannt be null");
        }

        public n a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f12763g : (n) invokeV.objValue;
        }

        public View b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f12762f : (View) invokeV.objValue;
        }

        public void c(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nVar) == null) {
                this.f12763g = nVar;
            }
        }
    }

    public BdBaseViewPagerAdapter(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12757f = new HashMap<>();
        this.f12758g = new ArrayList();
        this.f12759h = new ArrayList();
        this.f12760i = 0;
        this.f12756e = context;
    }

    public final View a(n nVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, nVar)) == null) {
            b<T, V> bVar = this.f12757f.get(nVar.getType());
            if (bVar != null) {
                V c2 = bVar.c(null);
                if (BdBaseApplication.getInst().isDebugMode()) {
                    BdLog.i("ViewPager View is creating " + c2.getClass().getName());
                }
                if (c2 != null) {
                    c2.c(nVar);
                    bVar.e(null, c2, nVar);
                    return c2.b();
                }
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i2, obj) == null) || this.f12759h.size() <= 0 || i2 < 0 || i2 >= this.f12759h.size() || (view = this.f12759h.get(i2)) == null) {
            return;
        }
        viewGroup.removeView(view);
    }

    public void e() {
        b<T, V> bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            List<View> list = this.f12759h;
            if (list != null) {
                for (View view : list) {
                    a j = j(view);
                    if (j != null && j.a() != null && (bVar = this.f12757f.get(j.a().getType())) != null) {
                        bVar.d(j, j.a());
                    }
                }
                this.f12759h.clear();
                this.f12759h = null;
            }
            List<n> list2 = this.f12758g;
            if (list2 != null) {
                list2.clear();
            }
        }
    }

    public final void f(a aVar, n nVar) {
        b<T, V> bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, aVar, nVar) == null) || aVar == null || nVar == null || (bVar = this.f12757f.get(nVar.getType())) == null) {
            return;
        }
        aVar.c(nVar);
        bVar.e(null, aVar, nVar);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f12758g.size() : invokeV.intValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            int i2 = this.f12760i;
            if (i2 > 0) {
                this.f12760i = i2 - 1;
                return -2;
            }
            return super.getItemPosition(obj);
        }
        return invokeL.intValue;
    }

    public View i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (i2 >= this.f12759h.size() || i2 >= this.f12758g.size()) {
                return null;
            }
            View view = this.f12759h.get(i2);
            a j = j(view);
            if (j != null && j.a() == null) {
                f((a) view.getTag(), this.f12758g.get(i2));
            }
            return view;
        }
        return (View) invokeI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, viewGroup, i2)) == null) {
            if (i2 >= this.f12758g.size()) {
                return null;
            }
            View i3 = i(i2);
            if (i3 != null && i3.getParent() != viewGroup) {
                viewGroup.addView(i3);
            }
            return i3;
        }
        return invokeLI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, obj)) == null) ? view == obj : invokeLL.booleanValue;
    }

    public final a j(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, view)) == null) {
            if (view == null || !(view.getTag() instanceof a)) {
                return null;
            }
            return (a) view.getTag();
        }
        return (a) invokeL.objValue;
    }

    public void k(Context context, b<T, V> bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, context, bVar) == null) || bVar == null || bVar.b() == null) {
            return;
        }
        this.f12757f.put(bVar.b(), bVar);
    }

    public void l(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, list) == null) || list == null || list.size() <= 0) {
            return;
        }
        e();
        this.f12758g = list;
        if (this.f12759h == null) {
            this.f12759h = new ArrayList();
        }
        for (int i2 = 0; i2 < this.f12758g.size(); i2++) {
            n nVar = this.f12758g.get(i2);
            if (nVar != null) {
                View a2 = a(nVar);
                a2.setOnClickListener(this);
                this.f12759h.add(a2);
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f12760i = getCount();
            super.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a j;
        b<T, V> bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, view) == null) || (j = j(view)) == null || j.a() == null || j.a().getType() == null || (bVar = this.f12757f.get(j.a().getType())) == null || bVar.a() == null) {
            return;
        }
        bVar.a().a(j, j.a());
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Parcelable saveState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? super.saveState() : (Parcelable) invokeV.objValue;
    }
}
