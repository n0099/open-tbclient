package c.a.r0.e2.h.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.memberCenter.tail.data.TailData;
import com.baidu.tieba.memberCenter.tail.data.TailEditActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f17058e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.e2.h.c.d f17059f;

    /* renamed from: g  reason: collision with root package name */
    public List<Object> f17060g;

    /* renamed from: h  reason: collision with root package name */
    public f f17061h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f17062i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f17063j;

    /* renamed from: k  reason: collision with root package name */
    public View.OnClickListener f17064k;
    public c.a.r0.e2.h.f.a<Void> l;
    public c.a.r0.e2.h.f.a<Integer> m;

    /* renamed from: c.a.r0.e2.h.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1019a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f17065e;

        public View$OnClickListenerC1019a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17065e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f17065e.h();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f17066e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17066e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TailData c2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || view.getTag() == null || (c2 = ((c.a.r0.e2.h.c.c) view.getTag()).c()) == null || this.f17066e.f17059f.g()) {
                return;
            }
            this.f17066e.i(c2.getId(), c2.getContent(), c2.getFontColor());
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f17067e;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17067e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.a.r0.e2.h.c.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || (cVar = (c.a.r0.e2.h.c.c) view.getTag()) == null || cVar.c() == null) {
                return;
            }
            this.f17067e.f17059f.e(cVar.c().getId());
        }
    }

    /* loaded from: classes5.dex */
    public class d implements c.a.r0.e2.h.f.a<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.e2.h.f.a
        /* renamed from: b */
        public void a(boolean z, String str, Void r7) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), str, r7}) == null) {
                if (z) {
                    this.a.f17058e.showToast(str);
                    return;
                }
                a aVar = this.a;
                aVar.l(aVar.f17059f.h());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements c.a.r0.e2.h.f.a<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.e2.h.f.a
        /* renamed from: b */
        public void a(boolean z, String str, Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), str, num}) == null) {
                if (z) {
                    this.a.f17058e.showToast(str);
                    return;
                }
                TailData tailData = new TailData();
                tailData.setId(num.intValue());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001340, new c.a.r0.e2.h.a.e(3, tailData)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface f {
        void callback();
    }

    public a(TbPageContext<?> tbPageContext, c.a.r0.e2.h.c.d dVar, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, dVar, fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17062i = new View$OnClickListenerC1019a(this);
        this.f17063j = new b(this);
        this.f17064k = new c(this);
        this.l = new d(this);
        this.m = new e(this);
        this.f17058e = tbPageContext;
        this.f17059f = dVar;
        this.f17060g = new ArrayList();
        this.f17059f.m(this.l);
        this.f17059f.k(this.m);
        this.f17061h = fVar;
    }

    public final View f(View view) {
        InterceptResult invokeL;
        View view2;
        c.a.r0.e2.h.c.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
            if (view == null) {
                bVar = new c.a.r0.e2.h.c.b();
                view2 = bVar.b(this.f17058e.getPageActivity());
                bVar.c(this.f17062i);
                bVar.a(this.f17058e);
            } else {
                view2 = view;
                bVar = (c.a.r0.e2.h.c.b) view.getTag();
            }
            bVar.d(this.f17059f.f());
            return view2;
        }
        return (View) invokeL.objValue;
    }

    public final View g(Object obj, View view) {
        InterceptResult invokeLL;
        View view2;
        c.a.r0.e2.h.c.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, view)) == null) {
            if (obj == null || !(obj instanceof TailData)) {
                return null;
            }
            TailData tailData = (TailData) obj;
            if (view == null) {
                cVar = new c.a.r0.e2.h.c.c();
                view2 = cVar.b(this.f17058e.getPageActivity());
                cVar.h(this.f17063j);
                cVar.f(this.f17064k);
                cVar.a(this.f17058e);
            } else {
                view2 = view;
                cVar = (c.a.r0.e2.h.c.c) view.getTag();
            }
            cVar.i(tailData);
            cVar.g(Boolean.valueOf(this.f17059f.g()));
            return view2;
        }
        return (View) invokeLL.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f17060g.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? this.f17060g.get(i2) : invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            Object obj = this.f17060g.get(i2);
            if (obj instanceof TailData) {
                return 0;
            }
            return obj instanceof c.a.r0.e2.h.a.a ? 1 : -1;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            if (getItemViewType(i2) == 0) {
                return g(getItem(i2), view);
            }
            if (getItemViewType(i2) == 1) {
                return f(view);
            }
            return null;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f17058e.sendMessage(new CustomMessage(2002001, new TailEditActivityConfig(this.f17058e.getPageActivity(), this.f17059f.h().isEmpty())));
        }
    }

    public final void i(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048585, this, i2, str, str2) == null) {
            this.f17058e.sendMessage(new CustomMessage(2002001, new TailEditActivityConfig(this.f17058e.getPageActivity(), i2, str, str2)));
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            k();
            notifyDataSetChanged();
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            f fVar = this.f17061h;
            if (fVar != null) {
                fVar.callback();
            }
            this.f17060g.clear();
            this.f17060g.addAll(this.f17059f.h());
            if (this.f17059f.g()) {
                return;
            }
            this.f17060g.add(new c.a.r0.e2.h.a.a(this.f17059f.f()));
        }
    }

    public final void l(List<TailData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, list) == null) {
            this.f17059f.n(list);
            j();
        }
    }
}
