package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import c.a.d.n.e.n;
import c.a.s0.s.i0.u.b;
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
/* loaded from: classes11.dex */
public class BdBaseViewPagerAdapter<T extends n, V extends a> extends PagerAdapter implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f42179e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<BdUniqueId, b<T, V>> f42180f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f42181g;

    /* renamed from: h  reason: collision with root package name */
    public List<View> f42182h;

    /* renamed from: i  reason: collision with root package name */
    public int f42183i;

    /* loaded from: classes11.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f42184e;

        /* renamed from: f  reason: collision with root package name */
        public View f42185f;

        /* renamed from: g  reason: collision with root package name */
        public n f42186g;

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
            this.f42184e = 3;
            this.f42185f = null;
            this.f42186g = null;
            this.f42185f = view;
            if (view != null) {
                view.setTag(this);
                return;
            }
            throw new RuntimeException("view cannt be null");
        }

        public n a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f42186g : (n) invokeV.objValue;
        }

        public View b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f42185f : (View) invokeV.objValue;
        }

        public void c(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nVar) == null) {
                this.f42186g = nVar;
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
        this.f42180f = new HashMap<>();
        this.f42181g = new ArrayList();
        this.f42182h = new ArrayList();
        this.f42183i = 0;
        this.f42179e = context;
    }

    public final View a(n nVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, nVar)) == null) {
            b<T, V> bVar = this.f42180f.get(nVar.getType());
            if (bVar != null) {
                V b2 = bVar.b(null);
                if (BdBaseApplication.getInst().isDebugMode()) {
                    BdLog.i("ViewPager View is creating " + b2.getClass().getName());
                }
                if (b2 != null) {
                    b2.c(nVar);
                    bVar.d(null, b2, nVar);
                    return b2.b();
                }
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    public final void b(a aVar, n nVar) {
        b<T, V> bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, nVar) == null) || aVar == null || nVar == null || (bVar = this.f42180f.get(nVar.getType())) == null) {
            return;
        }
        aVar.c(nVar);
        bVar.d(null, aVar, nVar);
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
            List<View> list = this.f42182h;
            if (list != null) {
                for (View view : list) {
                    a c2 = c(view);
                    if (c2 != null && c2.a() != null && (bVar = this.f42180f.get(c2.a().getType())) != null) {
                        bVar.c(c2, c2.a());
                    }
                }
                this.f42182h.clear();
                this.f42182h = null;
            }
            List<n> list2 = this.f42181g;
            if (list2 != null) {
                list2.clear();
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048580, this, viewGroup, i2, obj) == null) || this.f42182h.size() <= 0 || i2 < 0 || i2 >= this.f42182h.size() || (view = this.f42182h.get(i2)) == null) {
            return;
        }
        viewGroup.removeView(view);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f42181g.size() : invokeV.intValue;
    }

    public View getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (i2 >= this.f42182h.size() || i2 >= this.f42181g.size()) {
                return null;
            }
            View view = this.f42182h.get(i2);
            a c2 = c(view);
            if (c2 != null && c2.a() == null) {
                b((a) view.getTag(), this.f42181g.get(i2));
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
            int i2 = this.f42183i;
            if (i2 > 0) {
                this.f42183i = i2 - 1;
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
            if (i2 >= this.f42181g.size()) {
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
            this.f42183i = getCount();
            super.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a c2;
        b<T, V> bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, view) == null) || (c2 = c(view)) == null || c2.a() == null || c2.a().getType() == null || (bVar = this.f42180f.get(c2.a().getType())) == null || bVar.a() == null) {
            return;
        }
        bVar.a().a(c2, c2.a());
    }

    public void onSkinTypeChanged(int i2) {
        List<View> list;
        b<T, V> bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (list = this.f42182h) == null) {
            return;
        }
        for (View view : list) {
            a c2 = c(view);
            if (c2 != null && c2.a() != null && (bVar = this.f42180f.get(c2.a().getType())) != null) {
                bVar.e(i2, c2, c2.a());
            }
        }
    }

    public void registerAdapter(Context context, b<T, V> bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, context, bVar) == null) || bVar == null || bVar.getType() == null) {
            return;
        }
        this.f42180f.put(bVar.getType(), bVar);
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
        this.f42181g = list;
        if (this.f42182h == null) {
            this.f42182h = new ArrayList();
        }
        for (int i2 = 0; i2 < this.f42181g.size(); i2++) {
            n nVar = this.f42181g.get(i2);
            if (nVar != null) {
                View a2 = a(nVar);
                a2.setOnClickListener(this);
                this.f42182h.add(a2);
            }
        }
    }
}
