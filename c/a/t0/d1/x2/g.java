package c.a.t0.d1.x2;

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
import c.a.t0.d1.c1;
import c.a.t0.d1.d1;
import c.a.t0.d1.e1;
import c.a.t0.d1.f1;
import c.a.t0.d1.g1;
import c.a.t0.d1.o1;
import c.a.t0.d1.x2.f;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class g implements c.a.t0.d1.x2.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdListView a;

    /* renamed from: b  reason: collision with root package name */
    public f.e f16783b;

    /* renamed from: c  reason: collision with root package name */
    public Context f16784c;

    /* renamed from: d  reason: collision with root package name */
    public List<o1> f16785d;

    /* renamed from: e  reason: collision with root package name */
    public f f16786e;

    /* renamed from: f  reason: collision with root package name */
    public final BaseAdapter f16787f;

    /* renamed from: g  reason: collision with root package name */
    public AdapterView.OnItemClickListener f16788g;

    /* loaded from: classes7.dex */
    public class a extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f16789e;

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
            this.f16789e = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public o1 getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (this.f16789e.f16785d == null) {
                    return null;
                }
                return (o1) this.f16789e.f16785d.get(i2);
            }
            return (o1) invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f16789e.f16785d == null) {
                    return 0;
                }
                return this.f16789e.f16785d.size();
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
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(g1.tab_item_menu_item_view, (ViewGroup) null);
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(d1.ds80)));
                    f.C1063f c1063f = new f.C1063f();
                    c1063f.a = (TextView) view.findViewById(f1.tab_menu_name);
                    c1063f.f16780b = (ImageView) view.findViewById(f1.tab_menu_check);
                    c1063f.f16781c = view.findViewById(f1.tab_menu_line_s);
                    c1063f.f16782d = view.findViewById(f1.tab_menu_line_f);
                    view.setTag(c1063f);
                }
                SkinManager.setBackgroundResource(view, c1.CAM_X0201);
                f.C1063f c1063f2 = (f.C1063f) view.getTag();
                o1 item = getItem(i2);
                if (item == null) {
                    return view;
                }
                c1063f2.a.setText(item.a);
                if (item.f16352c) {
                    SkinManager.setViewTextColor(c1063f2.a, c1.CAM_X0302, 1);
                    SkinManager.setImageResource(c1063f2.f16780b, e1.chx_tips_list_ok);
                    c1063f2.f16780b.setVisibility(0);
                } else {
                    SkinManager.setViewTextColor(c1063f2.a, c1.CAM_X0108, 1);
                    c1063f2.f16780b.setVisibility(8);
                }
                if (i2 >= 0 && i2 == getCount() - 1) {
                    c1063f2.f16782d.setVisibility(0);
                    c1063f2.f16781c.setVisibility(8);
                    SkinManager.setBackgroundColor(c1063f2.f16782d, c1.CAM_X0204);
                } else {
                    c1063f2.f16781c.setVisibility(0);
                    c1063f2.f16782d.setVisibility(8);
                    SkinManager.setBackgroundColor(c1063f2.f16781c, c1.CAM_X0204);
                }
                return view;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f16790e;

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
            this.f16790e = gVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                if (this.f16790e.f16786e != null) {
                    this.f16790e.f16786e.d();
                }
                if (this.f16790e.f16787f == null || this.f16790e.f16783b == null) {
                    return;
                }
                for (o1 o1Var : this.f16790e.f16785d) {
                    if (o1Var != null) {
                        o1Var.f16352c = false;
                    }
                }
                o1 o1Var2 = (o1) this.f16790e.f16787f.getItem(i2);
                if (o1Var2 != null) {
                    o1Var2.f16352c = true;
                    this.f16790e.f16783b.a(o1Var2.f16351b);
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
        this.f16787f = new a(this);
        this.f16788g = new b(this);
    }

    @Override // c.a.t0.d1.x2.b
    public void a(Context context, f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, fVar) == null) || context == null || fVar == null) {
            return;
        }
        this.f16784c = context;
        this.f16786e = fVar;
        this.f16783b = fVar.e();
        g();
    }

    @Override // c.a.t0.d1.x2.b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.t0.d1.x2.b
    public void changeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f16787f.notifyDataSetChanged();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            BdListView bdListView = new BdListView(this.f16784c);
            this.a = bdListView;
            bdListView.setAlwaysDrawnWithCacheEnabled(false);
            this.a.setDivider(null);
            this.a.setDividerHeight(0);
            this.a.setSelector(17170445);
            this.a.setCacheColorHint(this.f16784c.getResources().getColor(17170445));
            this.a.setOnItemClickListener(this.f16788g);
            this.a.setAdapter((ListAdapter) this.f16787f);
        }
    }

    @Override // c.a.t0.d1.x2.b
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    @Override // c.a.t0.d1.x2.b
    public void setData(List<o1> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f16785d = list;
            this.f16787f.notifyDataSetChanged();
        }
    }
}
