package c.a.p0.f1.p2;

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
import c.a.p0.f1.e1;
import c.a.p0.f1.p2.f;
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
public class g implements c.a.p0.f1.p2.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdListView a;

    /* renamed from: b  reason: collision with root package name */
    public f.e f14397b;

    /* renamed from: c  reason: collision with root package name */
    public Context f14398c;

    /* renamed from: d  reason: collision with root package name */
    public List<e1> f14399d;

    /* renamed from: e  reason: collision with root package name */
    public f f14400e;

    /* renamed from: f  reason: collision with root package name */
    public final BaseAdapter f14401f;

    /* renamed from: g  reason: collision with root package name */
    public AdapterView.OnItemClickListener f14402g;

    /* loaded from: classes2.dex */
    public class a extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public e1 getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                if (this.a.f14399d == null) {
                    return null;
                }
                return (e1) this.a.f14399d.get(i);
            }
            return (e1) invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a.f14399d == null) {
                    return 0;
                }
                return this.a.f14399d.size();
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? i : invokeI.longValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, view, viewGroup)) == null) {
                if (view == null) {
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d07f3, (ViewGroup) null);
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070275)));
                    f.C1086f c1086f = new f.C1086f();
                    c1086f.a = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091e4a);
                    c1086f.f14394b = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f091e47);
                    c1086f.f14395c = view.findViewById(R.id.obfuscated_res_0x7f091e49);
                    c1086f.f14396d = view.findViewById(R.id.obfuscated_res_0x7f091e48);
                    view.setTag(c1086f);
                }
                SkinManager.setBackgroundResource(view, R.color.CAM_X0201);
                f.C1086f c1086f2 = (f.C1086f) view.getTag();
                e1 item = getItem(i);
                if (item == null) {
                    return view;
                }
                c1086f2.a.setText(item.a);
                if (item.f13940c) {
                    SkinManager.setViewTextColor(c1086f2.a, R.color.CAM_X0302, 1);
                    SkinManager.setImageResource(c1086f2.f14394b, R.drawable.chx_tips_list_ok);
                    c1086f2.f14394b.setVisibility(0);
                } else {
                    SkinManager.setViewTextColor(c1086f2.a, R.color.CAM_X0108, 1);
                    c1086f2.f14394b.setVisibility(8);
                }
                if (i >= 0 && i == getCount() - 1) {
                    c1086f2.f14396d.setVisibility(0);
                    c1086f2.f14395c.setVisibility(8);
                    SkinManager.setBackgroundColor(c1086f2.f14396d, R.color.CAM_X0204);
                } else {
                    c1086f2.f14395c.setVisibility(0);
                    c1086f2.f14396d.setVisibility(8);
                    SkinManager.setBackgroundColor(c1086f2.f14395c, R.color.CAM_X0204);
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
        public final /* synthetic */ g a;

        public b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                if (this.a.f14400e != null) {
                    this.a.f14400e.c();
                }
                if (this.a.f14401f == null || this.a.f14397b == null) {
                    return;
                }
                for (e1 e1Var : this.a.f14399d) {
                    if (e1Var != null) {
                        e1Var.f13940c = false;
                    }
                }
                e1 e1Var2 = (e1) this.a.f14401f.getItem(i);
                if (e1Var2 != null) {
                    e1Var2.f13940c = true;
                    this.a.f14397b.a(e1Var2.f13939b);
                }
            }
        }
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14401f = new a(this);
        this.f14402g = new b(this);
    }

    @Override // c.a.p0.f1.p2.b
    public void a(Context context, f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, fVar) == null) || context == null || fVar == null) {
            return;
        }
        this.f14398c = context;
        this.f14400e = fVar;
        this.f14397b = fVar.d();
        g();
    }

    @Override // c.a.p0.f1.p2.b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            BdListView bdListView = new BdListView(this.f14398c);
            this.a = bdListView;
            bdListView.setAlwaysDrawnWithCacheEnabled(false);
            this.a.setDivider(null);
            this.a.setDividerHeight(0);
            this.a.setSelector(17170445);
            this.a.setCacheColorHint(this.f14398c.getResources().getColor(17170445));
            this.a.setOnItemClickListener(this.f14402g);
            this.a.setAdapter((ListAdapter) this.f14401f);
        }
    }

    @Override // c.a.p0.f1.p2.b
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    @Override // c.a.p0.f1.p2.b
    public void setData(List<e1> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.f14399d = list;
            this.f14401f.notifyDataSetChanged();
        }
    }
}
