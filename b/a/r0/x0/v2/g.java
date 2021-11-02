package b.a.r0.x0.v2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import b.a.r0.x0.b1;
import b.a.r0.x0.c1;
import b.a.r0.x0.d1;
import b.a.r0.x0.e1;
import b.a.r0.x0.f1;
import b.a.r0.x0.n1;
import b.a.r0.x0.v2.f;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class g implements b.a.r0.x0.v2.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdListView f26473a;

    /* renamed from: b  reason: collision with root package name */
    public f.e f26474b;

    /* renamed from: c  reason: collision with root package name */
    public Context f26475c;

    /* renamed from: d  reason: collision with root package name */
    public List<n1> f26476d;

    /* renamed from: e  reason: collision with root package name */
    public f f26477e;

    /* renamed from: f  reason: collision with root package name */
    public final BaseAdapter f26478f;

    /* renamed from: g  reason: collision with root package name */
    public AdapterView.OnItemClickListener f26479g;

    /* loaded from: classes5.dex */
    public class a extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f26480e;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26480e = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public n1 getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (this.f26480e.f26476d == null) {
                    return null;
                }
                return (n1) this.f26480e.f26476d.get(i2);
            }
            return (n1) invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f26480e.f26476d == null) {
                    return 0;
                }
                return this.f26480e.f26476d.size();
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? i2 : invokeI.longValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i2, view, viewGroup)) == null) {
                if (view == null) {
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(f1.tab_item_menu_item_view, (ViewGroup) null);
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(c1.ds80)));
                    f.C1297f c1297f = new f.C1297f();
                    c1297f.f26469a = (TextView) view.findViewById(e1.tab_menu_name);
                    c1297f.f26470b = (ImageView) view.findViewById(e1.tab_menu_check);
                    c1297f.f26471c = view.findViewById(e1.tab_menu_line_s);
                    c1297f.f26472d = view.findViewById(e1.tab_menu_line_f);
                    view.setTag(c1297f);
                }
                SkinManager.setBackgroundResource(view, b1.CAM_X0201);
                f.C1297f c1297f2 = (f.C1297f) view.getTag();
                n1 item = getItem(i2);
                if (item == null) {
                    return view;
                }
                c1297f2.f26469a.setText(item.f25997a);
                if (item.f25999c) {
                    SkinManager.setViewTextColor(c1297f2.f26469a, b1.CAM_X0302, 1);
                    SkinManager.setImageResource(c1297f2.f26470b, d1.chx_tips_list_ok);
                    c1297f2.f26470b.setVisibility(0);
                } else {
                    SkinManager.setViewTextColor(c1297f2.f26469a, b1.CAM_X0108, 1);
                    c1297f2.f26470b.setVisibility(8);
                }
                if (i2 >= 0 && i2 == getCount() - 1) {
                    c1297f2.f26472d.setVisibility(0);
                    c1297f2.f26471c.setVisibility(8);
                    SkinManager.setBackgroundColor(c1297f2.f26472d, b1.CAM_X0204);
                } else {
                    c1297f2.f26471c.setVisibility(0);
                    c1297f2.f26472d.setVisibility(8);
                    SkinManager.setBackgroundColor(c1297f2.f26471c, b1.CAM_X0204);
                }
                return view;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f26481e;

        public b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26481e = gVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                if (this.f26481e.f26477e != null) {
                    this.f26481e.f26477e.d();
                }
                if (this.f26481e.f26478f == null || this.f26481e.f26474b == null) {
                    return;
                }
                for (n1 n1Var : this.f26481e.f26476d) {
                    if (n1Var != null) {
                        n1Var.f25999c = false;
                    }
                }
                n1 n1Var2 = (n1) this.f26481e.f26478f.getItem(i2);
                if (n1Var2 != null) {
                    n1Var2.f25999c = true;
                    this.f26481e.f26474b.a(n1Var2.f25998b);
                }
            }
        }
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f26478f = new a(this);
        this.f26479g = new b(this);
    }

    @Override // b.a.r0.x0.v2.b
    public void a(Context context, f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, fVar) == null) || context == null || fVar == null) {
            return;
        }
        this.f26475c = context;
        this.f26477e = fVar;
        this.f26474b = fVar.e();
        g();
    }

    @Override // b.a.r0.x0.v2.b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // b.a.r0.x0.v2.b
    public void changeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f26478f.notifyDataSetChanged();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            BdListView bdListView = new BdListView(this.f26475c);
            this.f26473a = bdListView;
            bdListView.setAlwaysDrawnWithCacheEnabled(false);
            this.f26473a.setDivider(null);
            this.f26473a.setDividerHeight(0);
            this.f26473a.setSelector(17170445);
            this.f26473a.setCacheColorHint(this.f26475c.getResources().getColor(17170445));
            this.f26473a.setOnItemClickListener(this.f26479g);
            this.f26473a.setAdapter((ListAdapter) this.f26478f);
        }
    }

    @Override // b.a.r0.x0.v2.b
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f26473a : (View) invokeV.objValue;
    }

    @Override // b.a.r0.x0.v2.b
    public void setData(List<n1> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f26476d = list;
            this.f26478f.notifyDataSetChanged();
        }
    }
}
