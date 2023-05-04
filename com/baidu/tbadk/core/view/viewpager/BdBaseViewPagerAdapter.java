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
import com.baidu.tieba.in;
import com.baidu.tieba.j75;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class BdBaseViewPagerAdapter<T extends in, V extends a> extends PagerAdapter implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public HashMap<BdUniqueId, j75<T, V>> b;
    public List<in> c;
    public List<View> d;
    public int e;

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view2, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, view2, obj)) == null) ? view2 == obj : invokeLL.booleanValue;
    }

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public View b;
        public in c;

        public a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 3;
            this.b = null;
            this.c = null;
            this.b = view2;
            if (view2 != null) {
                view2.setTag(this);
                return;
            }
            throw new RuntimeException("view cannt be null");
        }

        public in a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.c;
            }
            return (in) invokeV.objValue;
        }

        public View b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.b;
            }
            return (View) invokeV.objValue;
        }

        public void c(in inVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, inVar) == null) {
                this.c = inVar;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new HashMap<>();
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = 0;
        this.a = context;
    }

    public final View b(in inVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, inVar)) == null) {
            j75<T, V> j75Var = this.b.get(inVar.getType());
            if (j75Var != null) {
                V b = j75Var.b(null);
                if (BdBaseApplication.getInst().isDebugMode()) {
                    BdLog.i("ViewPager View is creating " + b.getClass().getName());
                }
                if (b != null) {
                    b.c(inVar);
                    j75Var.d(null, b, inVar);
                    return b.b();
                }
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    public View e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            if (i < this.d.size() && i < this.c.size()) {
                View view2 = this.d.get(i);
                a f = f(view2);
                if (f != null && f.a() == null) {
                    d((a) view2.getTag(), this.c.get(i));
                }
                return view2;
            }
            return null;
        }
        return (View) invokeI.objValue;
    }

    public void h(List<in> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, list) == null) && list != null && list.size() > 0) {
            c();
            this.c = list;
            if (this.d == null) {
                this.d = new ArrayList();
            }
            for (int i = 0; i < this.c.size(); i++) {
                in inVar = this.c.get(i);
                if (inVar != null) {
                    View b = b(inVar);
                    b.setOnClickListener(this);
                    this.d.add(b);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        a f;
        j75<T, V> j75Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, view2) == null) && (f = f(view2)) != null && f.a() != null && f.a().getType() != null && (j75Var = this.b.get(f.a().getType())) != null && j75Var.a() != null) {
            j75Var.a().a(f, f.a());
        }
    }

    public void c() {
        j75<T, V> j75Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            List<View> list = this.d;
            if (list != null) {
                for (View view2 : list) {
                    a f = f(view2);
                    if (f != null && f.a() != null && (j75Var = this.b.get(f.a().getType())) != null) {
                        j75Var.c(f, f.a());
                    }
                }
                this.d.clear();
                this.d = null;
            }
            List<in> list2 = this.c;
            if (list2 != null) {
                list2.clear();
            }
        }
    }

    public final void d(a aVar, in inVar) {
        j75<T, V> j75Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, aVar, inVar) == null) && aVar != null && inVar != null && (j75Var = this.b.get(inVar.getType())) != null) {
            aVar.c(inVar);
            j75Var.d(null, aVar, inVar);
        }
    }

    public void g(Context context, j75<T, V> j75Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, context, j75Var) == null) && j75Var != null && j75Var.getType() != null) {
            this.b.put(j75Var.getType(), j75Var);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, viewGroup, i)) == null) {
            if (i >= this.c.size()) {
                return null;
            }
            View e = e(i);
            if (e != null && e.getParent() != viewGroup) {
                viewGroup.addView(e);
            }
            return e;
        }
        return invokeLI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048579, this, viewGroup, i, obj) == null) && this.d.size() > 0 && i >= 0 && i < this.d.size() && (view2 = this.d.get(i)) != null) {
            viewGroup.removeView(view2);
        }
    }

    public final a f(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, view2)) == null) {
            if (view2 != null && (view2.getTag() instanceof a)) {
                return (a) view2.getTag();
            }
            return null;
        }
        return (a) invokeL.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) {
            int i = this.e;
            if (i > 0) {
                this.e = i - 1;
                return -2;
            }
            return super.getItemPosition(obj);
        }
        return invokeL.intValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.c.size();
        }
        return invokeV.intValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.e = getCount();
            super.notifyDataSetChanged();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Parcelable saveState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return super.saveState();
        }
        return (Parcelable) invokeV.objValue;
    }
}
