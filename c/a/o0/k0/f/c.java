package c.a.o0.k0.f;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.k0.d.b;
import c.a.o0.k0.f.a;
import c.a.p0.a4.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class c<D, S extends c.a.o0.k0.d.b, H extends a<D, S>> extends BaseAdapter implements v {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<D> a;

    /* renamed from: b  reason: collision with root package name */
    public final List<H> f10377b;

    /* renamed from: c  reason: collision with root package name */
    public final SparseArray<H> f10378c;

    /* renamed from: d  reason: collision with root package name */
    public final TbPageContext<?> f10379d;

    /* renamed from: e  reason: collision with root package name */
    public S f10380e;

    /* renamed from: f  reason: collision with root package name */
    public final ViewEventCenter f10381f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f10382g;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f10383h;
    public FrameLayout i;
    public NoDataViewFactory.e j;
    public NoDataViewFactory.d k;
    public NoDataViewFactory.c l;
    public FrameLayout.LayoutParams m;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewEventCenter};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f10377b = new ArrayList();
        this.f10378c = new SparseArray<>();
        this.f10382g = true;
        this.f10379d = tbPageContext;
        this.f10381f = viewEventCenter;
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.i == null) {
                this.i = new FrameLayout(this.f10379d.getPageActivity());
            }
            if (this.f10383h == null) {
                this.f10383h = NoDataViewFactory.a(this.f10379d.getPageActivity(), this.i, this.k, this.j, this.l);
            }
            this.f10383h.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = this.m;
            if (layoutParams != null) {
                this.f10383h.setLayoutParams(layoutParams);
            }
            this.i.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
            this.f10383h.f(this.f10379d, TbadkCoreApplication.getInst().getSkinType());
            return this.i;
        }
        return (View) invokeV.objValue;
    }

    public void b() {
        FrameLayout frameLayout;
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (frameLayout = this.i) == null || (noDataView = this.f10383h) == null) {
            return;
        }
        frameLayout.removeView(noDataView);
        this.f10383h = null;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<D> list = this.a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    public List<D> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.a == null) {
                return new ArrayList();
            }
            return new ArrayList(this.a);
        }
        return (List) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<D> list = this.a;
            return list != null && list.size() == 0;
        }
        return invokeV.booleanValue;
    }

    public final View f(View view, int i, Class<?> cls, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{view, Integer.valueOf(i), cls, Integer.valueOf(i2)})) == null) {
            H g2 = g(view, cls, i2);
            if (this.f10378c.indexOfValue(g2) >= 0) {
                this.f10378c.remove(g2.l());
            }
            this.f10378c.put(i, g2);
            m(g2, i);
            return g2.e();
        }
        return (View) invokeCommon.objValue;
    }

    public final H g(View view, Class<?> cls, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048582, this, view, cls, i)) == null) {
            if (view != null && view.getTag() != null) {
                return (H) view.getTag();
            }
            View inflate = this.f10379d.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
            try {
                H h2 = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.f10379d, inflate, this.f10381f);
                h2.onChangeSkinType(this.f10379d, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h2);
                this.f10377b.add(h2);
                return h2;
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            } catch (IllegalArgumentException e3) {
                throw e3;
            } catch (InstantiationException e4) {
                throw new RuntimeException(e4);
            } catch (NoSuchMethodException e5) {
                throw new RuntimeException(e5);
            } catch (SecurityException e6) {
                throw e6;
            } catch (InvocationTargetException e7) {
                throw new RuntimeException(e7);
            }
        }
        return (H) invokeLLI.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            List<D> list = this.a;
            if (list == null) {
                return 0;
            }
            if (list.size() == 0 && this.f10382g) {
                return 1;
            }
            return this.a.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            List<D> list = this.a;
            if (list != null && list.size() != 0 && i >= 0 && i < this.a.size()) {
                return this.a.get(i);
            }
            return null;
        }
        return (D) invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            List<D> list = this.a;
            if (list != null && list.size() != 0 && i >= 0 && i < this.a.size()) {
                return i;
            }
            return 0L;
        }
        return invokeI.longValue;
    }

    public void h(D d2) {
        List<D> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, d2) == null) || d2 == null || (list = this.a) == null) {
            return;
        }
        list.remove(d2);
        notifyDataSetChanged();
    }

    public void i(List<D> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, list) == null) || list == null) {
            return;
        }
        if (this.a == null) {
            this.a = new ArrayList();
        }
        this.a.addAll(list);
        notifyDataSetChanged();
    }

    public void j(NoDataViewFactory.d dVar, NoDataViewFactory.e eVar, NoDataViewFactory.c cVar, FrameLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048588, this, dVar, eVar, cVar, layoutParams) == null) {
            this.k = dVar;
            this.j = eVar;
            this.l = cVar;
            this.m = layoutParams;
            NoDataView noDataView = this.f10383h;
            if (noDataView != null) {
                noDataView.setTextOption(eVar);
                this.f10383h.setImgOption(dVar);
                this.f10383h.setButtonOption(cVar);
                if (layoutParams != null) {
                    this.f10383h.setLayoutParams(layoutParams);
                }
            }
        }
    }

    public void k(List<D> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, list) == null) {
            l(list);
            notifyDataSetChanged();
        }
    }

    public void l(List<D> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, list) == null) || list == null) {
            return;
        }
        if (this.a == null) {
            this.a = new ArrayList();
        }
        this.a.clear();
        this.a.addAll(list);
        this.f10378c.clear();
    }

    public final void m(H h2, int i) {
        D item;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048591, this, h2, i) == null) || (item = getItem(i)) == null) {
            return;
        }
        h2.f10376f = i;
        h2.j(item, this.f10380e);
    }

    public void n(D d2) {
        List<D> list;
        H h2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, d2) == null) || d2 == null || (list = this.a) == null || !list.contains(d2) || (h2 = this.f10378c.get(this.a.indexOf(d2))) == null) {
            return;
        }
        h2.i(d2);
    }

    @Override // c.a.p0.a4.v
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048593, this, tbPageContext, i)) == null) {
            int size = this.f10377b.size();
            for (int i2 = 0; i2 < size; i2++) {
                H h2 = this.f10377b.get(i2);
                if (h2 != null) {
                    h2.onChangeSkinType(tbPageContext, i);
                }
            }
            NoDataView noDataView = this.f10383h;
            if (noDataView != null) {
                noDataView.f(this.f10379d, i);
                return true;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }
}
