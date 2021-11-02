package b.a.r0.y1.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import b.a.r0.y1.c.k.o;
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
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static int o = 8;
    public static int p = 8;
    public static int q = 6;
    public static int r = 6;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f27278a;

    /* renamed from: b  reason: collision with root package name */
    public View f27279b;

    /* renamed from: c  reason: collision with root package name */
    public View f27280c;

    /* renamed from: d  reason: collision with root package name */
    public CategoryView f27281d;

    /* renamed from: e  reason: collision with root package name */
    public PrivilegeGridView f27282e;

    /* renamed from: f  reason: collision with root package name */
    public CooperatePrivilegeListView f27283f;

    /* renamed from: g  reason: collision with root package name */
    public PrivilegeGridView f27284g;

    /* renamed from: h  reason: collision with root package name */
    public CooperatePrivilegeListView f27285h;

    /* renamed from: i  reason: collision with root package name */
    public ViewGroup f27286i;
    public ViewGroup j;
    public ViewGroup k;
    public ViewGroup l;
    public ArrayList<o> m;
    public View.OnClickListener n;

    /* loaded from: classes5.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f27287e;

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
            this.f27287e = bVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                view.setTag(this.f27287e.m.get(i2));
                this.f27287e.n.onClick(view);
            }
        }
    }

    /* renamed from: b.a.r0.y1.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1344b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f27288e;

        public C1344b(b bVar) {
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
            this.f27288e = bVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                view.setTag(this.f27288e.m.get(i2));
                this.f27288e.n.onClick(view);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f27289e;

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
            this.f27289e = bVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                view.setTag(this.f27289e.m.get(i2));
                this.f27289e.n.onClick(view);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f27290e;

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
            this.f27290e = bVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                view.setTag(this.f27290e.m.get(i2));
                this.f27290e.n.onClick(view);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(762927442, "Lb/a/r0/y1/c/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(762927442, "Lb/a/r0/y1/c/b;");
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
        this.f27278a = baseFragmentActivity;
        this.n = onClickListener;
        h(view);
    }

    public final void c(b.a.r0.y1.c.k.c cVar) {
        List<VipSpecialItem> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            if (cVar != null && cVar.d() != null) {
                arrayList = cVar.d();
            } else {
                arrayList = new ArrayList<>();
            }
            this.f27286i.setVisibility(8);
            this.j.setVisibility(8);
            this.k.setVisibility(8);
            this.l.setVisibility(0);
            int min = Math.min(arrayList.size(), r);
            this.m = new ArrayList<>();
            for (int i2 = 0; i2 < min; i2++) {
                this.m.add(new o(arrayList.get(i2)));
            }
            this.f27283f.setAdapter((ListAdapter) new b.a.r0.y1.c.j.b(this.f27278a.getPageContext(), this.m, this.n));
            this.f27283f.setOnItemClickListener(new a(this));
        }
    }

    public final void d(b.a.r0.y1.c.k.c cVar) {
        List<VipSpecialItem> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (cVar != null && cVar.d() != null) {
                arrayList = cVar.d();
            } else {
                arrayList = new ArrayList<>();
            }
            this.f27286i.setVisibility(0);
            this.j.setVisibility(8);
            this.k.setVisibility(8);
            this.l.setVisibility(8);
            int min = Math.min(arrayList.size(), q);
            this.m = new ArrayList<>();
            for (int i2 = 0; i2 < min; i2++) {
                this.m.add(new o(arrayList.get(i2)));
            }
            this.f27285h.setAdapter((ListAdapter) new b.a.r0.y1.c.j.a(this.f27278a.getPageContext(), this.m));
            this.f27285h.setOnItemClickListener(new C1344b(this));
        }
    }

    public final void e(b.a.r0.y1.c.k.c cVar) {
        List<VipSpecialItem> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            if (cVar != null && cVar.d() != null) {
                arrayList = cVar.d();
            } else {
                arrayList = new ArrayList<>();
            }
            this.f27286i.setVisibility(8);
            this.j.setVisibility(0);
            this.k.setVisibility(8);
            this.l.setVisibility(8);
            int min = Math.min(arrayList.size(), p);
            this.m = new ArrayList<>();
            for (int i2 = 0; i2 < min; i2++) {
                this.m.add(new o(arrayList.get(i2)));
            }
            this.f27282e.setAdapter((ListAdapter) new b.a.r0.y1.c.j.d(this.f27278a.getPageContext(), this.m));
            this.f27282e.setOnItemClickListener(new d(this));
        }
    }

    public final void f(b.a.r0.y1.c.k.c cVar) {
        List<VipSpecialItem> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            if (cVar != null && cVar.d() != null) {
                arrayList = cVar.d();
            } else {
                arrayList = new ArrayList<>();
            }
            this.f27286i.setVisibility(8);
            this.j.setVisibility(8);
            this.k.setVisibility(0);
            this.l.setVisibility(8);
            int min = Math.min((arrayList.size() / 2) * 2, o);
            this.m = new ArrayList<>();
            for (int i2 = 0; i2 < min; i2++) {
                this.m.add(new o(arrayList.get(i2)));
            }
            this.f27284g.setAdapter((ListAdapter) new b.a.r0.y1.c.j.c(this.f27278a.getPageContext(), this.m));
            this.f27284g.setOnItemClickListener(new c(this));
        }
    }

    public void g(b.a.r0.y1.c.k.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) || cVar == null || cVar.d() == null || cVar.d().size() <= 0) {
            return;
        }
        this.f27281d.fillView(cVar.a());
        if (cVar.f27406h) {
            this.f27280c.setVisibility(0);
        } else {
            this.f27280c.setVisibility(8);
        }
        int i2 = cVar.f27405g;
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
            this.f27279b = view;
            this.f27281d = (CategoryView) view.findViewById(R.id.category);
            this.f27286i = (ViewGroup) this.f27279b.findViewById(R.id.layout_col_one_img_text);
            this.j = (ViewGroup) this.f27279b.findViewById(R.id.layout_col_two_img_text);
            this.k = (ViewGroup) this.f27279b.findViewById(R.id.layout_col_two_img);
            this.l = (ViewGroup) this.f27279b.findViewById(R.id.layout_col_one_img_text_btn);
            this.f27283f = (CooperatePrivilegeListView) this.f27279b.findViewById(R.id.lv_col_one_img_text_btn_list);
            this.f27282e = (PrivilegeGridView) this.f27279b.findViewById(R.id.gv_col_two_img_text_list);
            this.f27284g = (PrivilegeGridView) this.f27279b.findViewById(R.id.gv_col_two_img_list);
            this.f27285h = (CooperatePrivilegeListView) this.f27279b.findViewById(R.id.lv_col_one_img_text_list);
            this.f27280c = this.f27279b.findViewById(R.id.divider_sp_line);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            b.a.q0.w0.a.a(this.f27278a.getPageContext(), this.f27279b);
        }
    }
}
