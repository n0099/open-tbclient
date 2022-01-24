package c.a.t0.g2.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import c.a.t0.g2.c.k.o;
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
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static int o = 8;
    public static int p = 8;
    public static int q = 6;
    public static int r = 6;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View f17771b;

    /* renamed from: c  reason: collision with root package name */
    public View f17772c;

    /* renamed from: d  reason: collision with root package name */
    public CategoryView f17773d;

    /* renamed from: e  reason: collision with root package name */
    public PrivilegeGridView f17774e;

    /* renamed from: f  reason: collision with root package name */
    public CooperatePrivilegeListView f17775f;

    /* renamed from: g  reason: collision with root package name */
    public PrivilegeGridView f17776g;

    /* renamed from: h  reason: collision with root package name */
    public CooperatePrivilegeListView f17777h;

    /* renamed from: i  reason: collision with root package name */
    public ViewGroup f17778i;

    /* renamed from: j  reason: collision with root package name */
    public ViewGroup f17779j;
    public ViewGroup k;
    public ViewGroup l;
    public ArrayList<o> m;
    public View.OnClickListener n;

    /* loaded from: classes7.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f17780e;

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
            this.f17780e = bVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                view.setTag(this.f17780e.m.get(i2));
                this.f17780e.n.onClick(view);
            }
        }
    }

    /* renamed from: c.a.t0.g2.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1118b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f17781e;

        public C1118b(b bVar) {
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
            this.f17781e = bVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                view.setTag(this.f17781e.m.get(i2));
                this.f17781e.n.onClick(view);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f17782e;

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
            this.f17782e = bVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                view.setTag(this.f17782e.m.get(i2));
                this.f17782e.n.onClick(view);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f17783e;

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
            this.f17783e = bVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                view.setTag(this.f17783e.m.get(i2));
                this.f17783e.n.onClick(view);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1097773884, "Lc/a/t0/g2/c/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1097773884, "Lc/a/t0/g2/c/b;");
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

    public final void c(c.a.t0.g2.c.k.c cVar) {
        List<VipSpecialItem> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            if (cVar != null && cVar.d() != null) {
                arrayList = cVar.d();
            } else {
                arrayList = new ArrayList<>();
            }
            this.f17778i.setVisibility(8);
            this.f17779j.setVisibility(8);
            this.k.setVisibility(8);
            this.l.setVisibility(0);
            int min = Math.min(arrayList.size(), r);
            this.m = new ArrayList<>();
            for (int i2 = 0; i2 < min; i2++) {
                this.m.add(new o(arrayList.get(i2)));
            }
            this.f17775f.setAdapter((ListAdapter) new c.a.t0.g2.c.j.b(this.a.getPageContext(), this.m, this.n));
            this.f17775f.setOnItemClickListener(new a(this));
        }
    }

    public final void d(c.a.t0.g2.c.k.c cVar) {
        List<VipSpecialItem> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (cVar != null && cVar.d() != null) {
                arrayList = cVar.d();
            } else {
                arrayList = new ArrayList<>();
            }
            this.f17778i.setVisibility(0);
            this.f17779j.setVisibility(8);
            this.k.setVisibility(8);
            this.l.setVisibility(8);
            int min = Math.min(arrayList.size(), q);
            this.m = new ArrayList<>();
            for (int i2 = 0; i2 < min; i2++) {
                this.m.add(new o(arrayList.get(i2)));
            }
            this.f17777h.setAdapter((ListAdapter) new c.a.t0.g2.c.j.a(this.a.getPageContext(), this.m));
            this.f17777h.setOnItemClickListener(new C1118b(this));
        }
    }

    public final void e(c.a.t0.g2.c.k.c cVar) {
        List<VipSpecialItem> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            if (cVar != null && cVar.d() != null) {
                arrayList = cVar.d();
            } else {
                arrayList = new ArrayList<>();
            }
            this.f17778i.setVisibility(8);
            this.f17779j.setVisibility(0);
            this.k.setVisibility(8);
            this.l.setVisibility(8);
            int min = Math.min(arrayList.size(), p);
            this.m = new ArrayList<>();
            for (int i2 = 0; i2 < min; i2++) {
                this.m.add(new o(arrayList.get(i2)));
            }
            this.f17774e.setAdapter((ListAdapter) new c.a.t0.g2.c.j.d(this.a.getPageContext(), this.m));
            this.f17774e.setOnItemClickListener(new d(this));
        }
    }

    public final void f(c.a.t0.g2.c.k.c cVar) {
        List<VipSpecialItem> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            if (cVar != null && cVar.d() != null) {
                arrayList = cVar.d();
            } else {
                arrayList = new ArrayList<>();
            }
            this.f17778i.setVisibility(8);
            this.f17779j.setVisibility(8);
            this.k.setVisibility(0);
            this.l.setVisibility(8);
            int min = Math.min((arrayList.size() / 2) * 2, o);
            this.m = new ArrayList<>();
            for (int i2 = 0; i2 < min; i2++) {
                this.m.add(new o(arrayList.get(i2)));
            }
            this.f17776g.setAdapter((ListAdapter) new c.a.t0.g2.c.j.c(this.a.getPageContext(), this.m));
            this.f17776g.setOnItemClickListener(new c(this));
        }
    }

    public void g(c.a.t0.g2.c.k.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) || cVar == null || cVar.d() == null || cVar.d().size() <= 0) {
            return;
        }
        this.f17773d.fillView(cVar.a());
        if (cVar.f17889h) {
            this.f17772c.setVisibility(0);
        } else {
            this.f17772c.setVisibility(8);
        }
        int i2 = cVar.f17888g;
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
            this.f17771b = view;
            this.f17773d = (CategoryView) view.findViewById(R.id.category);
            this.f17778i = (ViewGroup) this.f17771b.findViewById(R.id.layout_col_one_img_text);
            this.f17779j = (ViewGroup) this.f17771b.findViewById(R.id.layout_col_two_img_text);
            this.k = (ViewGroup) this.f17771b.findViewById(R.id.layout_col_two_img);
            this.l = (ViewGroup) this.f17771b.findViewById(R.id.layout_col_one_img_text_btn);
            this.f17775f = (CooperatePrivilegeListView) this.f17771b.findViewById(R.id.lv_col_one_img_text_btn_list);
            this.f17774e = (PrivilegeGridView) this.f17771b.findViewById(R.id.gv_col_two_img_text_list);
            this.f17776g = (PrivilegeGridView) this.f17771b.findViewById(R.id.gv_col_two_img_list);
            this.f17777h = (CooperatePrivilegeListView) this.f17771b.findViewById(R.id.lv_col_one_img_text_list);
            this.f17772c = this.f17771b.findViewById(R.id.divider_sp_line);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.s0.x0.a.a(this.a.getPageContext(), this.f17771b);
        }
    }
}
