package c.a.r0.w0.l2;

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
import c.a.r0.w0.d1;
import c.a.r0.w0.l2.f;
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
/* loaded from: classes4.dex */
public class g implements c.a.r0.w0.l2.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdListView f27022a;

    /* renamed from: b  reason: collision with root package name */
    public f.e f27023b;

    /* renamed from: c  reason: collision with root package name */
    public Context f27024c;

    /* renamed from: d  reason: collision with root package name */
    public List<d1> f27025d;

    /* renamed from: e  reason: collision with root package name */
    public f f27026e;

    /* renamed from: f  reason: collision with root package name */
    public final BaseAdapter f27027f;

    /* renamed from: g  reason: collision with root package name */
    public AdapterView.OnItemClickListener f27028g;

    /* loaded from: classes4.dex */
    public class a extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f27029e;

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
            this.f27029e = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public d1 getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (this.f27029e.f27025d == null) {
                    return null;
                }
                return (d1) this.f27029e.f27025d.get(i2);
            }
            return (d1) invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f27029e.f27025d == null) {
                    return 0;
                }
                return this.f27029e.f27025d.size();
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
                    f.C1266f c1266f = new f.C1266f();
                    c1266f.f27018a = (TextView) view.findViewById(R.id.tab_menu_name);
                    c1266f.f27019b = (ImageView) view.findViewById(R.id.tab_menu_check);
                    c1266f.f27020c = view.findViewById(R.id.tab_menu_line_s);
                    c1266f.f27021d = view.findViewById(R.id.tab_menu_line_f);
                    view.setTag(c1266f);
                }
                SkinManager.setBackgroundResource(view, R.color.CAM_X0201);
                f.C1266f c1266f2 = (f.C1266f) view.getTag();
                d1 item = getItem(i2);
                if (item == null) {
                    return view;
                }
                c1266f2.f27018a.setText(item.f26542a);
                if (item.f26544c) {
                    SkinManager.setViewTextColor(c1266f2.f27018a, R.color.CAM_X0302, 1);
                    SkinManager.setImageResource(c1266f2.f27019b, R.drawable.chx_tips_list_ok);
                    c1266f2.f27019b.setVisibility(0);
                } else {
                    SkinManager.setViewTextColor(c1266f2.f27018a, R.color.CAM_X0108, 1);
                    c1266f2.f27019b.setVisibility(8);
                }
                if (i2 >= 0 && i2 == getCount() - 1) {
                    c1266f2.f27021d.setVisibility(0);
                    c1266f2.f27020c.setVisibility(8);
                    SkinManager.setBackgroundColor(c1266f2.f27021d, R.color.CAM_X0204);
                } else {
                    c1266f2.f27020c.setVisibility(0);
                    c1266f2.f27021d.setVisibility(8);
                    SkinManager.setBackgroundColor(c1266f2.f27020c, R.color.CAM_X0204);
                }
                return view;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f27030e;

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
            this.f27030e = gVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                if (this.f27030e.f27026e != null) {
                    this.f27030e.f27026e.d();
                }
                if (this.f27030e.f27027f == null || this.f27030e.f27023b == null) {
                    return;
                }
                for (d1 d1Var : this.f27030e.f27025d) {
                    if (d1Var != null) {
                        d1Var.f26544c = false;
                    }
                }
                d1 d1Var2 = (d1) this.f27030e.f27027f.getItem(i2);
                if (d1Var2 != null) {
                    d1Var2.f26544c = true;
                    this.f27030e.f27023b.a(d1Var2.f26543b);
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
        this.f27027f = new a(this);
        this.f27028g = new b(this);
    }

    @Override // c.a.r0.w0.l2.b
    public void a(Context context, f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, fVar) == null) || context == null || fVar == null) {
            return;
        }
        this.f27024c = context;
        this.f27026e = fVar;
        this.f27023b = fVar.e();
        g();
    }

    @Override // c.a.r0.w0.l2.b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.r0.w0.l2.b
    public void changeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f27027f.notifyDataSetChanged();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            BdListView bdListView = new BdListView(this.f27024c);
            this.f27022a = bdListView;
            bdListView.setAlwaysDrawnWithCacheEnabled(false);
            this.f27022a.setDivider(null);
            this.f27022a.setDividerHeight(0);
            this.f27022a.setSelector(17170445);
            this.f27022a.setCacheColorHint(this.f27024c.getResources().getColor(17170445));
            this.f27022a.setOnItemClickListener(this.f27028g);
            this.f27022a.setAdapter((ListAdapter) this.f27027f);
        }
    }

    @Override // c.a.r0.w0.l2.b
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f27022a : (View) invokeV.objValue;
    }

    @Override // c.a.r0.w0.l2.b
    public void setData(List<d1> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f27025d = list;
            this.f27027f.notifyDataSetChanged();
        }
    }
}
