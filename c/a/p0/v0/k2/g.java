package c.a.p0.v0.k2;

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
import c.a.p0.v0.d1;
import c.a.p0.v0.k2.f;
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
public class g implements c.a.p0.v0.k2.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdListView f26019a;

    /* renamed from: b  reason: collision with root package name */
    public f.e f26020b;

    /* renamed from: c  reason: collision with root package name */
    public Context f26021c;

    /* renamed from: d  reason: collision with root package name */
    public List<d1> f26022d;

    /* renamed from: e  reason: collision with root package name */
    public f f26023e;

    /* renamed from: f  reason: collision with root package name */
    public final BaseAdapter f26024f;

    /* renamed from: g  reason: collision with root package name */
    public AdapterView.OnItemClickListener f26025g;

    /* loaded from: classes4.dex */
    public class a extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f26026e;

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
            this.f26026e = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public d1 getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (this.f26026e.f26022d == null) {
                    return null;
                }
                return (d1) this.f26026e.f26022d.get(i2);
            }
            return (d1) invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f26026e.f26022d == null) {
                    return 0;
                }
                return this.f26026e.f26022d.size();
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
                    f.C1216f c1216f = new f.C1216f();
                    c1216f.f26015a = (TextView) view.findViewById(R.id.tab_menu_name);
                    c1216f.f26016b = (ImageView) view.findViewById(R.id.tab_menu_check);
                    c1216f.f26017c = view.findViewById(R.id.tab_menu_line_s);
                    c1216f.f26018d = view.findViewById(R.id.tab_menu_line_f);
                    view.setTag(c1216f);
                }
                SkinManager.setBackgroundResource(view, R.color.CAM_X0201);
                f.C1216f c1216f2 = (f.C1216f) view.getTag();
                d1 item = getItem(i2);
                if (item == null) {
                    return view;
                }
                c1216f2.f26015a.setText(item.f25575a);
                if (item.f25577c) {
                    SkinManager.setViewTextColor(c1216f2.f26015a, R.color.CAM_X0302, 1);
                    SkinManager.setImageResource(c1216f2.f26016b, R.drawable.chx_tips_list_ok);
                    c1216f2.f26016b.setVisibility(0);
                } else {
                    SkinManager.setViewTextColor(c1216f2.f26015a, R.color.CAM_X0108, 1);
                    c1216f2.f26016b.setVisibility(8);
                }
                if (i2 >= 0 && i2 == getCount() - 1) {
                    c1216f2.f26018d.setVisibility(0);
                    c1216f2.f26017c.setVisibility(8);
                    SkinManager.setBackgroundColor(c1216f2.f26018d, R.color.CAM_X0204);
                } else {
                    c1216f2.f26017c.setVisibility(0);
                    c1216f2.f26018d.setVisibility(8);
                    SkinManager.setBackgroundColor(c1216f2.f26017c, R.color.CAM_X0204);
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
        public final /* synthetic */ g f26027e;

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
            this.f26027e = gVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                if (this.f26027e.f26023e != null) {
                    this.f26027e.f26023e.d();
                }
                if (this.f26027e.f26024f == null || this.f26027e.f26020b == null) {
                    return;
                }
                for (d1 d1Var : this.f26027e.f26022d) {
                    if (d1Var != null) {
                        d1Var.f25577c = false;
                    }
                }
                d1 d1Var2 = (d1) this.f26027e.f26024f.getItem(i2);
                if (d1Var2 != null) {
                    d1Var2.f25577c = true;
                    this.f26027e.f26020b.a(d1Var2.f25576b);
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
        this.f26024f = new a(this);
        this.f26025g = new b(this);
    }

    @Override // c.a.p0.v0.k2.b
    public void a(Context context, f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, fVar) == null) || context == null || fVar == null) {
            return;
        }
        this.f26021c = context;
        this.f26023e = fVar;
        this.f26020b = fVar.e();
        g();
    }

    @Override // c.a.p0.v0.k2.b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.p0.v0.k2.b
    public void changeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f26024f.notifyDataSetChanged();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            BdListView bdListView = new BdListView(this.f26021c);
            this.f26019a = bdListView;
            bdListView.setAlwaysDrawnWithCacheEnabled(false);
            this.f26019a.setDivider(null);
            this.f26019a.setDividerHeight(0);
            this.f26019a.setSelector(17170445);
            this.f26019a.setCacheColorHint(this.f26021c.getResources().getColor(17170445));
            this.f26019a.setOnItemClickListener(this.f26025g);
            this.f26019a.setAdapter((ListAdapter) this.f26024f);
        }
    }

    @Override // c.a.p0.v0.k2.b
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f26019a : (View) invokeV.objValue;
    }

    @Override // c.a.p0.v0.k2.b
    public void setData(List<d1> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f26022d = list;
            this.f26024f.notifyDataSetChanged();
        }
    }
}
