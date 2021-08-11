package c.a.o0.i0.f;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.i0.d.b;
import c.a.o0.i0.f.a;
import c.a.p0.i3.t;
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
/* loaded from: classes3.dex */
public abstract class c<D, S extends c.a.o0.i0.d.b, H extends a<D, S>> extends BaseAdapter implements t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<D> f13252e;

    /* renamed from: f  reason: collision with root package name */
    public final List<H> f13253f;

    /* renamed from: g  reason: collision with root package name */
    public final SparseArray<H> f13254g;

    /* renamed from: h  reason: collision with root package name */
    public final TbPageContext<?> f13255h;

    /* renamed from: i  reason: collision with root package name */
    public S f13256i;

    /* renamed from: j  reason: collision with root package name */
    public final ViewEventCenter f13257j;
    public boolean k;
    public NoDataView l;
    public FrameLayout m;
    public NoDataViewFactory.e n;
    public NoDataViewFactory.d o;
    public NoDataViewFactory.c p;
    public FrameLayout.LayoutParams q;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewEventCenter};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13253f = new ArrayList();
        this.f13254g = new SparseArray<>();
        this.k = true;
        this.f13255h = tbPageContext;
        this.f13257j = viewEventCenter;
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.m == null) {
                this.m = new FrameLayout(this.f13255h.getPageActivity());
            }
            if (this.l == null) {
                this.l = NoDataViewFactory.a(this.f13255h.getPageActivity(), this.m, this.o, this.n, this.p);
            }
            this.l.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = this.q;
            if (layoutParams != null) {
                this.l.setLayoutParams(layoutParams);
            }
            this.m.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
            this.l.onChangeSkinType(this.f13255h, TbadkCoreApplication.getInst().getSkinType());
            return this.m;
        }
        return (View) invokeV.objValue;
    }

    public void b() {
        FrameLayout frameLayout;
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (frameLayout = this.m) == null || (noDataView = this.l) == null) {
            return;
        }
        frameLayout.removeView(noDataView);
        this.l = null;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<D> list = this.f13252e;
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
            if (this.f13252e == null) {
                return new ArrayList();
            }
            return new ArrayList(this.f13252e);
        }
        return (List) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<D> list = this.f13252e;
            return list != null && list.size() == 0;
        }
        return invokeV.booleanValue;
    }

    public final View f(View view, int i2, Class<?> cls, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{view, Integer.valueOf(i2), cls, Integer.valueOf(i3)})) == null) {
            H g2 = g(view, cls, i3);
            if (this.f13254g.indexOfValue(g2) >= 0) {
                this.f13254g.remove(g2.n());
            }
            this.f13254g.put(i2, g2);
            m(g2, i2);
            return g2.g();
        }
        return (View) invokeCommon.objValue;
    }

    public final H g(View view, Class<?> cls, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048582, this, view, cls, i2)) == null) {
            if (view != null && view.getTag() != null) {
                return (H) view.getTag();
            }
            View inflate = this.f13255h.getPageActivity().getLayoutInflater().inflate(i2, (ViewGroup) null);
            try {
                H h2 = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.f13255h, inflate, this.f13257j);
                h2.onChangeSkinType(this.f13255h, TbadkCoreApplication.getInst().getSkinType());
                inflate.setTag(h2);
                this.f13253f.add(h2);
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
            List<D> list = this.f13252e;
            if (list == null) {
                return 0;
            }
            if (list.size() == 0 && this.k) {
                return 1;
            }
            return this.f13252e.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public D getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            List<D> list = this.f13252e;
            if (list != null && list.size() != 0 && i2 >= 0 && i2 < this.f13252e.size()) {
                return this.f13252e.get(i2);
            }
            return null;
        }
        return (D) invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            List<D> list = this.f13252e;
            if (list != null && list.size() != 0 && i2 >= 0 && i2 < this.f13252e.size()) {
                return i2;
            }
            return 0L;
        }
        return invokeI.longValue;
    }

    public void h(D d2) {
        List<D> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, d2) == null) || d2 == null || (list = this.f13252e) == null) {
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
        if (this.f13252e == null) {
            this.f13252e = new ArrayList();
        }
        this.f13252e.addAll(list);
        notifyDataSetChanged();
    }

    public void j(NoDataViewFactory.d dVar, NoDataViewFactory.e eVar, NoDataViewFactory.c cVar, FrameLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048588, this, dVar, eVar, cVar, layoutParams) == null) {
            this.o = dVar;
            this.n = eVar;
            this.p = cVar;
            this.q = layoutParams;
            NoDataView noDataView = this.l;
            if (noDataView != null) {
                noDataView.setTextOption(eVar);
                this.l.setImgOption(dVar);
                this.l.setButtonOption(cVar);
                if (layoutParams != null) {
                    this.l.setLayoutParams(layoutParams);
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
        if (this.f13252e == null) {
            this.f13252e = new ArrayList();
        }
        this.f13252e.clear();
        this.f13252e.addAll(list);
        this.f13254g.clear();
    }

    public final void m(H h2, int i2) {
        D item;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048591, this, h2, i2) == null) || (item = getItem(i2)) == null) {
            return;
        }
        h2.f13251j = i2;
        h2.l(item, this.f13256i);
    }

    public void n(D d2) {
        List<D> list;
        H h2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, d2) == null) || d2 == null || (list = this.f13252e) == null || !list.contains(d2) || (h2 = this.f13254g.get(this.f13252e.indexOf(d2))) == null) {
            return;
        }
        h2.k(d2);
    }

    @Override // c.a.p0.i3.t
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048593, this, tbPageContext, i2)) == null) {
            int size = this.f13253f.size();
            for (int i3 = 0; i3 < size; i3++) {
                H h2 = this.f13253f.get(i3);
                if (h2 != null) {
                    h2.onChangeSkinType(tbPageContext, i2);
                }
            }
            NoDataView noDataView = this.l;
            if (noDataView != null) {
                noDataView.onChangeSkinType(this.f13255h, i2);
                return true;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }
}
