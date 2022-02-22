package c.a.u0.h2.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import c.a.u0.h2.c.k.o;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.index.CategoryView;
import com.baidu.tieba.memberCenter.index.CooperatePrivilegeListView;
import com.baidu.tieba.memberCenter.index.PrivilegeGridView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipSpecialItem;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static int o = 8;
    public static int p = 8;
    public static int q = 6;
    public static int r = 6;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View f18233b;

    /* renamed from: c  reason: collision with root package name */
    public View f18234c;

    /* renamed from: d  reason: collision with root package name */
    public CategoryView f18235d;

    /* renamed from: e  reason: collision with root package name */
    public PrivilegeGridView f18236e;

    /* renamed from: f  reason: collision with root package name */
    public CooperatePrivilegeListView f18237f;

    /* renamed from: g  reason: collision with root package name */
    public PrivilegeGridView f18238g;

    /* renamed from: h  reason: collision with root package name */
    public CooperatePrivilegeListView f18239h;

    /* renamed from: i  reason: collision with root package name */
    public ViewGroup f18240i;

    /* renamed from: j  reason: collision with root package name */
    public ViewGroup f18241j;
    public ViewGroup k;
    public ViewGroup l;
    public ArrayList<o> m;
    public View.OnClickListener n;

    /* loaded from: classes8.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f18242e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18242e = bVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                view.setTag(this.f18242e.m.get(i2));
                this.f18242e.n.onClick(view);
            }
        }
    }

    /* renamed from: c.a.u0.h2.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1134b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f18243e;

        public C1134b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18243e = bVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                view.setTag(this.f18243e.m.get(i2));
                this.f18243e.n.onClick(view);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f18244e;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18244e = bVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                view.setTag(this.f18244e.m.get(i2));
                this.f18244e.n.onClick(view);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f18245e;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18245e = bVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                view.setTag(this.f18245e.m.get(i2));
                this.f18245e.n.onClick(view);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1788764060, "Lc/a/u0/h2/c/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1788764060, "Lc/a/u0/h2/c/b;");
        }
    }

    public b(BaseFragmentActivity baseFragmentActivity, View view, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, view, onClickListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.n = null;
        this.a = baseFragmentActivity;
        this.n = onClickListener;
        h(view);
    }

    public final void c(c.a.u0.h2.c.k.c cVar) {
        List<VipSpecialItem> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            if (cVar != null && cVar.d() != null) {
                arrayList = cVar.d();
            } else {
                arrayList = new ArrayList<>();
            }
            this.f18240i.setVisibility(8);
            this.f18241j.setVisibility(8);
            this.k.setVisibility(8);
            this.l.setVisibility(0);
            int min = Math.min(arrayList.size(), r);
            this.m = new ArrayList<>();
            for (int i2 = 0; i2 < min; i2++) {
                this.m.add(new o(arrayList.get(i2)));
            }
            this.f18237f.setAdapter((ListAdapter) new c.a.u0.h2.c.j.b(this.a.getPageContext(), this.m, this.n));
            this.f18237f.setOnItemClickListener(new a(this));
        }
    }

    public final void d(c.a.u0.h2.c.k.c cVar) {
        List<VipSpecialItem> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (cVar != null && cVar.d() != null) {
                arrayList = cVar.d();
            } else {
                arrayList = new ArrayList<>();
            }
            this.f18240i.setVisibility(0);
            this.f18241j.setVisibility(8);
            this.k.setVisibility(8);
            this.l.setVisibility(8);
            int min = Math.min(arrayList.size(), q);
            this.m = new ArrayList<>();
            for (int i2 = 0; i2 < min; i2++) {
                this.m.add(new o(arrayList.get(i2)));
            }
            this.f18239h.setAdapter((ListAdapter) new c.a.u0.h2.c.j.a(this.a.getPageContext(), this.m));
            this.f18239h.setOnItemClickListener(new C1134b(this));
        }
    }

    public final void e(c.a.u0.h2.c.k.c cVar) {
        List<VipSpecialItem> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            if (cVar != null && cVar.d() != null) {
                arrayList = cVar.d();
            } else {
                arrayList = new ArrayList<>();
            }
            this.f18240i.setVisibility(8);
            this.f18241j.setVisibility(0);
            this.k.setVisibility(8);
            this.l.setVisibility(8);
            int min = Math.min(arrayList.size(), p);
            this.m = new ArrayList<>();
            for (int i2 = 0; i2 < min; i2++) {
                this.m.add(new o(arrayList.get(i2)));
            }
            this.f18236e.setAdapter((ListAdapter) new c.a.u0.h2.c.j.d(this.a.getPageContext(), this.m));
            this.f18236e.setOnItemClickListener(new d(this));
        }
    }

    public final void f(c.a.u0.h2.c.k.c cVar) {
        List<VipSpecialItem> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            if (cVar != null && cVar.d() != null) {
                arrayList = cVar.d();
            } else {
                arrayList = new ArrayList<>();
            }
            this.f18240i.setVisibility(8);
            this.f18241j.setVisibility(8);
            this.k.setVisibility(0);
            this.l.setVisibility(8);
            int min = Math.min((arrayList.size() / 2) * 2, o);
            this.m = new ArrayList<>();
            for (int i2 = 0; i2 < min; i2++) {
                this.m.add(new o(arrayList.get(i2)));
            }
            this.f18238g.setAdapter((ListAdapter) new c.a.u0.h2.c.j.c(this.a.getPageContext(), this.m));
            this.f18238g.setOnItemClickListener(new c(this));
        }
    }

    public void g(c.a.u0.h2.c.k.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) || cVar == null || cVar.d() == null || cVar.d().size() <= 0) {
            return;
        }
        this.f18235d.fillView(cVar.a());
        if (cVar.f18351h) {
            this.f18234c.setVisibility(0);
        } else {
            this.f18234c.setVisibility(8);
        }
        int i2 = cVar.f18350g;
        if (i2 == 1) {
            d(cVar);
        } else if (i2 == 3) {
            f(cVar);
        } else if (i2 == 2) {
            e(cVar);
        } else if (i2 == 4) {
            c(cVar);
        }
    }

    public final void h(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            this.f18233b = view;
            this.f18235d = (CategoryView) view.findViewById(R.id.category);
            this.f18240i = (ViewGroup) this.f18233b.findViewById(R.id.layout_col_one_img_text);
            this.f18241j = (ViewGroup) this.f18233b.findViewById(R.id.layout_col_two_img_text);
            this.k = (ViewGroup) this.f18233b.findViewById(R.id.layout_col_two_img);
            this.l = (ViewGroup) this.f18233b.findViewById(R.id.layout_col_one_img_text_btn);
            this.f18237f = (CooperatePrivilegeListView) this.f18233b.findViewById(R.id.lv_col_one_img_text_btn_list);
            this.f18236e = (PrivilegeGridView) this.f18233b.findViewById(R.id.gv_col_two_img_text_list);
            this.f18238g = (PrivilegeGridView) this.f18233b.findViewById(R.id.gv_col_two_img_list);
            this.f18239h = (CooperatePrivilegeListView) this.f18233b.findViewById(R.id.lv_col_one_img_text_list);
            this.f18234c = this.f18233b.findViewById(R.id.divider_sp_line);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.t0.x0.a.a(this.a.getPageContext(), this.f18233b);
        }
    }
}
