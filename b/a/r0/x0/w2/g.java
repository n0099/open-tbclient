package b.a.r0.x0.w2;

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
import b.a.r0.x0.c1;
import b.a.r0.x0.d1;
import b.a.r0.x0.e1;
import b.a.r0.x0.f1;
import b.a.r0.x0.g1;
import b.a.r0.x0.o1;
import b.a.r0.x0.w2.f;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class g implements b.a.r0.x0.w2.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdListView f28073a;

    /* renamed from: b  reason: collision with root package name */
    public f.e f28074b;

    /* renamed from: c  reason: collision with root package name */
    public Context f28075c;

    /* renamed from: d  reason: collision with root package name */
    public List<o1> f28076d;

    /* renamed from: e  reason: collision with root package name */
    public f f28077e;

    /* renamed from: f  reason: collision with root package name */
    public final BaseAdapter f28078f;

    /* renamed from: g  reason: collision with root package name */
    public AdapterView.OnItemClickListener f28079g;

    /* loaded from: classes6.dex */
    public class a extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f28080e;

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
            this.f28080e = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public o1 getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (this.f28080e.f28076d == null) {
                    return null;
                }
                return (o1) this.f28080e.f28076d.get(i2);
            }
            return (o1) invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f28080e.f28076d == null) {
                    return 0;
                }
                return this.f28080e.f28076d.size();
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
                    f.C1370f c1370f = new f.C1370f();
                    c1370f.f28069a = (TextView) view.findViewById(f1.tab_menu_name);
                    c1370f.f28070b = (ImageView) view.findViewById(f1.tab_menu_check);
                    c1370f.f28071c = view.findViewById(f1.tab_menu_line_s);
                    c1370f.f28072d = view.findViewById(f1.tab_menu_line_f);
                    view.setTag(c1370f);
                }
                SkinManager.setBackgroundResource(view, c1.CAM_X0201);
                f.C1370f c1370f2 = (f.C1370f) view.getTag();
                o1 item = getItem(i2);
                if (item == null) {
                    return view;
                }
                c1370f2.f28069a.setText(item.f27596a);
                if (item.f27598c) {
                    SkinManager.setViewTextColor(c1370f2.f28069a, c1.CAM_X0302, 1);
                    SkinManager.setImageResource(c1370f2.f28070b, e1.chx_tips_list_ok);
                    c1370f2.f28070b.setVisibility(0);
                } else {
                    SkinManager.setViewTextColor(c1370f2.f28069a, c1.CAM_X0108, 1);
                    c1370f2.f28070b.setVisibility(8);
                }
                if (i2 >= 0 && i2 == getCount() - 1) {
                    c1370f2.f28072d.setVisibility(0);
                    c1370f2.f28071c.setVisibility(8);
                    SkinManager.setBackgroundColor(c1370f2.f28072d, c1.CAM_X0204);
                } else {
                    c1370f2.f28071c.setVisibility(0);
                    c1370f2.f28072d.setVisibility(8);
                    SkinManager.setBackgroundColor(c1370f2.f28071c, c1.CAM_X0204);
                }
                return view;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f28081e;

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
            this.f28081e = gVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                if (this.f28081e.f28077e != null) {
                    this.f28081e.f28077e.d();
                }
                if (this.f28081e.f28078f == null || this.f28081e.f28074b == null) {
                    return;
                }
                for (o1 o1Var : this.f28081e.f28076d) {
                    if (o1Var != null) {
                        o1Var.f27598c = false;
                    }
                }
                o1 o1Var2 = (o1) this.f28081e.f28078f.getItem(i2);
                if (o1Var2 != null) {
                    o1Var2.f27598c = true;
                    this.f28081e.f28074b.a(o1Var2.f27597b);
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
        this.f28078f = new a(this);
        this.f28079g = new b(this);
    }

    @Override // b.a.r0.x0.w2.b
    public void a(Context context, f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, fVar) == null) || context == null || fVar == null) {
            return;
        }
        this.f28075c = context;
        this.f28077e = fVar;
        this.f28074b = fVar.e();
        g();
    }

    @Override // b.a.r0.x0.w2.b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // b.a.r0.x0.w2.b
    public void changeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f28078f.notifyDataSetChanged();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            BdListView bdListView = new BdListView(this.f28075c);
            this.f28073a = bdListView;
            bdListView.setAlwaysDrawnWithCacheEnabled(false);
            this.f28073a.setDivider(null);
            this.f28073a.setDividerHeight(0);
            this.f28073a.setSelector(17170445);
            this.f28073a.setCacheColorHint(this.f28075c.getResources().getColor(17170445));
            this.f28073a.setOnItemClickListener(this.f28079g);
            this.f28073a.setAdapter((ListAdapter) this.f28078f);
        }
    }

    @Override // b.a.r0.x0.w2.b
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f28073a : (View) invokeV.objValue;
    }

    @Override // b.a.r0.x0.w2.b
    public void setData(List<o1> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f28076d = list;
            this.f28078f.notifyDataSetChanged();
        }
    }
}
