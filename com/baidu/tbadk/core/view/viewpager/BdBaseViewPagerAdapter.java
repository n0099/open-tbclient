package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import c.a.e.l.e.n;
import c.a.p0.s.f0.u.b;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class BdBaseViewPagerAdapter<T extends n, V extends a> extends PagerAdapter implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f47915e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<BdUniqueId, b<T, V>> f47916f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f47917g;

    /* renamed from: h  reason: collision with root package name */
    public List<View> f47918h;

    /* renamed from: i  reason: collision with root package name */
    public int f47919i;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f47920e;

        /* renamed from: f  reason: collision with root package name */
        public View f47921f;

        /* renamed from: g  reason: collision with root package name */
        public n f47922g;

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
            this.f47920e = 3;
            this.f47921f = null;
            this.f47922g = null;
            this.f47921f = view;
            if (view != null) {
                view.setTag(this);
                return;
            }
            throw new RuntimeException("view cannt be null");
        }

        public n a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f47922g : (n) invokeV.objValue;
        }

        public View b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f47921f : (View) invokeV.objValue;
        }

        public void c(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nVar) == null) {
                this.f47922g = nVar;
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
        this.f47916f = new HashMap<>();
        this.f47917g = new ArrayList();
        this.f47918h = new ArrayList();
        this.f47919i = 0;
        this.f47915e = context;
    }

    public final View a(n nVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, nVar)) == null) {
            b<T, V> bVar = this.f47916f.get(nVar.getType());
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

    public final void b(a aVar, n nVar) {
        b<T, V> bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, nVar) == null) || aVar == null || nVar == null || (bVar = this.f47916f.get(nVar.getType())) == null) {
            return;
        }
        aVar.c(nVar);
        bVar.e(null, aVar, nVar);
    }

    public final a c(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) {
            if (view == null || !(view.getTag() instanceof a)) {
                return null;
            }
            return (a) view.getTag();
        }
        return (a) invokeL.objValue;
    }

    public void destory() {
        b<T, V> bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            List<View> list = this.f47918h;
            if (list != null) {
                for (View view : list) {
                    a c2 = c(view);
                    if (c2 != null && c2.a() != null && (bVar = this.f47916f.get(c2.a().getType())) != null) {
                        bVar.d(c2, c2.a());
                    }
                }
                this.f47918h.clear();
                this.f47918h = null;
            }
            List<n> list2 = this.f47917g;
            if (list2 != null) {
                list2.clear();
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048580, this, viewGroup, i2, obj) == null) || this.f47918h.size() <= 0 || i2 < 0 || i2 >= this.f47918h.size() || (view = this.f47918h.get(i2)) == null) {
            return;
        }
        viewGroup.removeView(view);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f47917g.size() : invokeV.intValue;
    }

    public View getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (i2 >= this.f47918h.size() || i2 >= this.f47917g.size()) {
                return null;
            }
            View view = this.f47918h.get(i2);
            a c2 = c(view);
            if (c2 != null && c2.a() == null) {
                b((a) view.getTag(), this.f47917g.get(i2));
            }
            return view;
        }
        return (View) invokeI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
            int i2 = this.f47919i;
            if (i2 > 0) {
                this.f47919i = i2 - 1;
                return -2;
            }
            return super.getItemPosition(obj);
        }
        return invokeL.intValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup, i2)) == null) {
            if (i2 >= this.f47917g.size()) {
                return null;
            }
            View item = getItem(i2);
            if (item != null && item.getParent() != viewGroup) {
                viewGroup.addView(item);
            }
            return item;
        }
        return invokeLI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, view, obj)) == null) ? view == obj : invokeLL.booleanValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f47919i = getCount();
            super.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a c2;
        b<T, V> bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, view) == null) || (c2 = c(view)) == null || c2.a() == null || c2.a().getType() == null || (bVar = this.f47916f.get(c2.a().getType())) == null || bVar.a() == null) {
            return;
        }
        bVar.a().a(c2, c2.a());
    }

    public void onSkinTypeChanged(int i2) {
        List<View> list;
        b<T, V> bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (list = this.f47918h) == null) {
            return;
        }
        for (View view : list) {
            a c2 = c(view);
            if (c2 != null && c2.a() != null && (bVar = this.f47916f.get(c2.a().getType())) != null) {
                bVar.f(i2, c2, c2.a());
            }
        }
    }

    public void registerAdapter(Context context, b<T, V> bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, context, bVar) == null) || bVar == null || bVar.b() == null) {
            return;
        }
        this.f47916f.put(bVar.b(), bVar);
    }

    public void registerAdapters(Context context, List<b<T, V>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, context, list) == null) {
            for (b<T, V> bVar : list) {
                registerAdapter(context, bVar);
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Parcelable saveState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? super.saveState() : (Parcelable) invokeV.objValue;
    }

    public void setDatas(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, list) == null) || list == null || list.size() <= 0) {
            return;
        }
        destory();
        this.f47917g = list;
        if (this.f47918h == null) {
            this.f47918h = new ArrayList();
        }
        for (int i2 = 0; i2 < this.f47917g.size(); i2++) {
            n nVar = this.f47917g.get(i2);
            if (nVar != null) {
                View a2 = a(nVar);
                a2.setOnClickListener(this);
                this.f47918h.add(a2);
            }
        }
    }
}
