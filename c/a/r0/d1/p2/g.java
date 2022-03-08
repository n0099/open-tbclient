package c.a.r0.d1.p2;

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
import c.a.r0.d1.e1;
import c.a.r0.d1.p2.f;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class g implements c.a.r0.d1.p2.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdListView a;

    /* renamed from: b  reason: collision with root package name */
    public f.e f16065b;

    /* renamed from: c  reason: collision with root package name */
    public Context f16066c;

    /* renamed from: d  reason: collision with root package name */
    public List<e1> f16067d;

    /* renamed from: e  reason: collision with root package name */
    public f f16068e;

    /* renamed from: f  reason: collision with root package name */
    public final BaseAdapter f16069f;

    /* renamed from: g  reason: collision with root package name */
    public AdapterView.OnItemClickListener f16070g;

    /* loaded from: classes2.dex */
    public class a extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f16071e;

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
            this.f16071e = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public e1 getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (this.f16071e.f16067d == null) {
                    return null;
                }
                return (e1) this.f16071e.f16067d.get(i2);
            }
            return (e1) invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f16071e.f16067d == null) {
                    return 0;
                }
                return this.f16071e.f16067d.size();
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
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tab_item_menu_item_view, (ViewGroup) null);
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(R.dimen.ds80)));
                    f.C1027f c1027f = new f.C1027f();
                    c1027f.a = (TextView) view.findViewById(R.id.tab_menu_name);
                    c1027f.f16062b = (ImageView) view.findViewById(R.id.tab_menu_check);
                    c1027f.f16063c = view.findViewById(R.id.tab_menu_line_s);
                    c1027f.f16064d = view.findViewById(R.id.tab_menu_line_f);
                    view.setTag(c1027f);
                }
                SkinManager.setBackgroundResource(view, R.color.CAM_X0201);
                f.C1027f c1027f2 = (f.C1027f) view.getTag();
                e1 item = getItem(i2);
                if (item == null) {
                    return view;
                }
                c1027f2.a.setText(item.a);
                if (item.f15467c) {
                    SkinManager.setViewTextColor(c1027f2.a, R.color.CAM_X0302, 1);
                    SkinManager.setImageResource(c1027f2.f16062b, R.drawable.chx_tips_list_ok);
                    c1027f2.f16062b.setVisibility(0);
                } else {
                    SkinManager.setViewTextColor(c1027f2.a, R.color.CAM_X0108, 1);
                    c1027f2.f16062b.setVisibility(8);
                }
                if (i2 >= 0 && i2 == getCount() - 1) {
                    c1027f2.f16064d.setVisibility(0);
                    c1027f2.f16063c.setVisibility(8);
                    SkinManager.setBackgroundColor(c1027f2.f16064d, R.color.CAM_X0204);
                } else {
                    c1027f2.f16063c.setVisibility(0);
                    c1027f2.f16064d.setVisibility(8);
                    SkinManager.setBackgroundColor(c1027f2.f16063c, R.color.CAM_X0204);
                }
                return view;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f16072e;

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
            this.f16072e = gVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                if (this.f16072e.f16068e != null) {
                    this.f16072e.f16068e.d();
                }
                if (this.f16072e.f16069f == null || this.f16072e.f16065b == null) {
                    return;
                }
                for (e1 e1Var : this.f16072e.f16067d) {
                    if (e1Var != null) {
                        e1Var.f15467c = false;
                    }
                }
                e1 e1Var2 = (e1) this.f16072e.f16069f.getItem(i2);
                if (e1Var2 != null) {
                    e1Var2.f15467c = true;
                    this.f16072e.f16065b.a(e1Var2.f15466b);
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
        this.f16069f = new a(this);
        this.f16070g = new b(this);
    }

    @Override // c.a.r0.d1.p2.b
    public void a(Context context, f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, fVar) == null) || context == null || fVar == null) {
            return;
        }
        this.f16066c = context;
        this.f16068e = fVar;
        this.f16065b = fVar.e();
        g();
    }

    @Override // c.a.r0.d1.p2.b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.r0.d1.p2.b
    public void changeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f16069f.notifyDataSetChanged();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            BdListView bdListView = new BdListView(this.f16066c);
            this.a = bdListView;
            bdListView.setAlwaysDrawnWithCacheEnabled(false);
            this.a.setDivider(null);
            this.a.setDividerHeight(0);
            this.a.setSelector(17170445);
            this.a.setCacheColorHint(this.f16066c.getResources().getColor(17170445));
            this.a.setOnItemClickListener(this.f16070g);
            this.a.setAdapter((ListAdapter) this.f16069f);
        }
    }

    @Override // c.a.r0.d1.p2.b
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    @Override // c.a.r0.d1.p2.b
    public void setData(List<e1> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f16067d = list;
            this.f16069f.notifyDataSetChanged();
        }
    }
}
