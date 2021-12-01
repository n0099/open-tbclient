package c.a.r0.d1.w2;

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
import c.a.r0.d1.c1;
import c.a.r0.d1.d1;
import c.a.r0.d1.e1;
import c.a.r0.d1.f1;
import c.a.r0.d1.g1;
import c.a.r0.d1.o1;
import c.a.r0.d1.w2.f;
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
public class g implements c.a.r0.d1.w2.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdListView a;

    /* renamed from: b  reason: collision with root package name */
    public f.e f16159b;

    /* renamed from: c  reason: collision with root package name */
    public Context f16160c;

    /* renamed from: d  reason: collision with root package name */
    public List<o1> f16161d;

    /* renamed from: e  reason: collision with root package name */
    public f f16162e;

    /* renamed from: f  reason: collision with root package name */
    public final BaseAdapter f16163f;

    /* renamed from: g  reason: collision with root package name */
    public AdapterView.OnItemClickListener f16164g;

    /* loaded from: classes5.dex */
    public class a extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f16165e;

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
            this.f16165e = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public o1 getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (this.f16165e.f16161d == null) {
                    return null;
                }
                return (o1) this.f16165e.f16161d.get(i2);
            }
            return (o1) invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f16165e.f16161d == null) {
                    return 0;
                }
                return this.f16165e.f16161d.size();
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
                    f.C0971f c0971f = new f.C0971f();
                    c0971f.a = (TextView) view.findViewById(f1.tab_menu_name);
                    c0971f.f16156b = (ImageView) view.findViewById(f1.tab_menu_check);
                    c0971f.f16157c = view.findViewById(f1.tab_menu_line_s);
                    c0971f.f16158d = view.findViewById(f1.tab_menu_line_f);
                    view.setTag(c0971f);
                }
                SkinManager.setBackgroundResource(view, c1.CAM_X0201);
                f.C0971f c0971f2 = (f.C0971f) view.getTag();
                o1 item = getItem(i2);
                if (item == null) {
                    return view;
                }
                c0971f2.a.setText(item.a);
                if (item.f15738c) {
                    SkinManager.setViewTextColor(c0971f2.a, c1.CAM_X0302, 1);
                    SkinManager.setImageResource(c0971f2.f16156b, e1.chx_tips_list_ok);
                    c0971f2.f16156b.setVisibility(0);
                } else {
                    SkinManager.setViewTextColor(c0971f2.a, c1.CAM_X0108, 1);
                    c0971f2.f16156b.setVisibility(8);
                }
                if (i2 >= 0 && i2 == getCount() - 1) {
                    c0971f2.f16158d.setVisibility(0);
                    c0971f2.f16157c.setVisibility(8);
                    SkinManager.setBackgroundColor(c0971f2.f16158d, c1.CAM_X0204);
                } else {
                    c0971f2.f16157c.setVisibility(0);
                    c0971f2.f16158d.setVisibility(8);
                    SkinManager.setBackgroundColor(c0971f2.f16157c, c1.CAM_X0204);
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
        public final /* synthetic */ g f16166e;

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
            this.f16166e = gVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                if (this.f16166e.f16162e != null) {
                    this.f16166e.f16162e.d();
                }
                if (this.f16166e.f16163f == null || this.f16166e.f16159b == null) {
                    return;
                }
                for (o1 o1Var : this.f16166e.f16161d) {
                    if (o1Var != null) {
                        o1Var.f15738c = false;
                    }
                }
                o1 o1Var2 = (o1) this.f16166e.f16163f.getItem(i2);
                if (o1Var2 != null) {
                    o1Var2.f15738c = true;
                    this.f16166e.f16159b.a(o1Var2.f15737b);
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
        this.f16163f = new a(this);
        this.f16164g = new b(this);
    }

    @Override // c.a.r0.d1.w2.b
    public void a(Context context, f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, fVar) == null) || context == null || fVar == null) {
            return;
        }
        this.f16160c = context;
        this.f16162e = fVar;
        this.f16159b = fVar.e();
        g();
    }

    @Override // c.a.r0.d1.w2.b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.r0.d1.w2.b
    public void changeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f16163f.notifyDataSetChanged();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            BdListView bdListView = new BdListView(this.f16160c);
            this.a = bdListView;
            bdListView.setAlwaysDrawnWithCacheEnabled(false);
            this.a.setDivider(null);
            this.a.setDividerHeight(0);
            this.a.setSelector(17170445);
            this.a.setCacheColorHint(this.f16160c.getResources().getColor(17170445));
            this.a.setOnItemClickListener(this.f16164g);
            this.a.setAdapter((ListAdapter) this.f16163f);
        }
    }

    @Override // c.a.r0.d1.w2.b
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    @Override // c.a.r0.d1.w2.b
    public void setData(List<o1> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f16161d = list;
            this.f16163f.notifyDataSetChanged();
        }
    }
}
