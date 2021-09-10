package c.a.r0.x1.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import c.a.r0.x1.c.k.o;
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
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static int o = 8;
    public static int p = 8;
    public static int q = 6;
    public static int r = 6;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f28352a;

    /* renamed from: b  reason: collision with root package name */
    public View f28353b;

    /* renamed from: c  reason: collision with root package name */
    public View f28354c;

    /* renamed from: d  reason: collision with root package name */
    public CategoryView f28355d;

    /* renamed from: e  reason: collision with root package name */
    public PrivilegeGridView f28356e;

    /* renamed from: f  reason: collision with root package name */
    public CooperatePrivilegeListView f28357f;

    /* renamed from: g  reason: collision with root package name */
    public PrivilegeGridView f28358g;

    /* renamed from: h  reason: collision with root package name */
    public CooperatePrivilegeListView f28359h;

    /* renamed from: i  reason: collision with root package name */
    public ViewGroup f28360i;

    /* renamed from: j  reason: collision with root package name */
    public ViewGroup f28361j;
    public ViewGroup k;
    public ViewGroup l;
    public ArrayList<o> m;
    public View.OnClickListener n;

    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f28362e;

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
            this.f28362e = bVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                view.setTag(this.f28362e.m.get(i2));
                this.f28362e.n.onClick(view);
            }
        }
    }

    /* renamed from: c.a.r0.x1.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1337b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f28363e;

        public C1337b(b bVar) {
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
            this.f28363e = bVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                view.setTag(this.f28363e.m.get(i2));
                this.f28363e.n.onClick(view);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f28364e;

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
            this.f28364e = bVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                view.setTag(this.f28364e.m.get(i2));
                this.f28364e.n.onClick(view);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f28365e;

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
            this.f28365e = bVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                view.setTag(this.f28365e.m.get(i2));
                this.f28365e.n.onClick(view);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-630134864, "Lc/a/r0/x1/c/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-630134864, "Lc/a/r0/x1/c/b;");
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
        this.f28352a = baseFragmentActivity;
        this.n = onClickListener;
        h(view);
    }

    public final void c(c.a.r0.x1.c.k.c cVar) {
        List<VipSpecialItem> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            if (cVar != null && cVar.c() != null) {
                arrayList = cVar.c();
            } else {
                arrayList = new ArrayList<>();
            }
            this.f28360i.setVisibility(8);
            this.f28361j.setVisibility(8);
            this.k.setVisibility(8);
            this.l.setVisibility(0);
            int min = Math.min(arrayList.size(), r);
            this.m = new ArrayList<>();
            for (int i2 = 0; i2 < min; i2++) {
                this.m.add(new o(arrayList.get(i2)));
            }
            this.f28357f.setAdapter((ListAdapter) new c.a.r0.x1.c.j.b(this.f28352a.getPageContext(), this.m, this.n));
            this.f28357f.setOnItemClickListener(new a(this));
        }
    }

    public final void d(c.a.r0.x1.c.k.c cVar) {
        List<VipSpecialItem> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (cVar != null && cVar.c() != null) {
                arrayList = cVar.c();
            } else {
                arrayList = new ArrayList<>();
            }
            this.f28360i.setVisibility(0);
            this.f28361j.setVisibility(8);
            this.k.setVisibility(8);
            this.l.setVisibility(8);
            int min = Math.min(arrayList.size(), q);
            this.m = new ArrayList<>();
            for (int i2 = 0; i2 < min; i2++) {
                this.m.add(new o(arrayList.get(i2)));
            }
            this.f28359h.setAdapter((ListAdapter) new c.a.r0.x1.c.j.a(this.f28352a.getPageContext(), this.m));
            this.f28359h.setOnItemClickListener(new C1337b(this));
        }
    }

    public final void e(c.a.r0.x1.c.k.c cVar) {
        List<VipSpecialItem> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            if (cVar != null && cVar.c() != null) {
                arrayList = cVar.c();
            } else {
                arrayList = new ArrayList<>();
            }
            this.f28360i.setVisibility(8);
            this.f28361j.setVisibility(0);
            this.k.setVisibility(8);
            this.l.setVisibility(8);
            int min = Math.min(arrayList.size(), p);
            this.m = new ArrayList<>();
            for (int i2 = 0; i2 < min; i2++) {
                this.m.add(new o(arrayList.get(i2)));
            }
            this.f28356e.setAdapter((ListAdapter) new c.a.r0.x1.c.j.d(this.f28352a.getPageContext(), this.m));
            this.f28356e.setOnItemClickListener(new d(this));
        }
    }

    public final void f(c.a.r0.x1.c.k.c cVar) {
        List<VipSpecialItem> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            if (cVar != null && cVar.c() != null) {
                arrayList = cVar.c();
            } else {
                arrayList = new ArrayList<>();
            }
            this.f28360i.setVisibility(8);
            this.f28361j.setVisibility(8);
            this.k.setVisibility(0);
            this.l.setVisibility(8);
            int min = Math.min((arrayList.size() / 2) * 2, o);
            this.m = new ArrayList<>();
            for (int i2 = 0; i2 < min; i2++) {
                this.m.add(new o(arrayList.get(i2)));
            }
            this.f28358g.setAdapter((ListAdapter) new c.a.r0.x1.c.j.c(this.f28352a.getPageContext(), this.m));
            this.f28358g.setOnItemClickListener(new c(this));
        }
    }

    public void g(c.a.r0.x1.c.k.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) || cVar == null || cVar.c() == null || cVar.c().size() <= 0) {
            return;
        }
        this.f28355d.fillView(cVar.b());
        if (cVar.f28484h) {
            this.f28354c.setVisibility(0);
        } else {
            this.f28354c.setVisibility(8);
        }
        int i2 = cVar.f28483g;
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
            this.f28353b = view;
            this.f28355d = (CategoryView) view.findViewById(R.id.category);
            this.f28360i = (ViewGroup) this.f28353b.findViewById(R.id.layout_col_one_img_text);
            this.f28361j = (ViewGroup) this.f28353b.findViewById(R.id.layout_col_two_img_text);
            this.k = (ViewGroup) this.f28353b.findViewById(R.id.layout_col_two_img);
            this.l = (ViewGroup) this.f28353b.findViewById(R.id.layout_col_one_img_text_btn);
            this.f28357f = (CooperatePrivilegeListView) this.f28353b.findViewById(R.id.lv_col_one_img_text_btn_list);
            this.f28356e = (PrivilegeGridView) this.f28353b.findViewById(R.id.gv_col_two_img_text_list);
            this.f28358g = (PrivilegeGridView) this.f28353b.findViewById(R.id.gv_col_two_img_list);
            this.f28359h = (CooperatePrivilegeListView) this.f28353b.findViewById(R.id.lv_col_one_img_text_list);
            this.f28354c = this.f28353b.findViewById(R.id.divider_sp_line);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.q0.w0.a.a(this.f28352a.getPageContext(), this.f28353b);
        }
    }
}
