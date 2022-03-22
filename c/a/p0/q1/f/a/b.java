package c.a.p0.q1.f.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<c.a.p0.q1.f.c.a> a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f17250b;

    /* renamed from: c  reason: collision with root package name */
    public int f17251c;

    /* renamed from: d  reason: collision with root package name */
    public int f17252d;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f17253e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f17254f;

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.p0.q1.f.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1294b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f17255b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f17256c;

        public C1294b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ C1294b(b bVar, a aVar) {
            this(bVar);
        }
    }

    public b(TbPageContext tbPageContext, int i, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i), bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17251c = -1;
        this.f17254f = false;
        this.f17250b = tbPageContext;
        this.f17253e = bdUniqueId;
        this.f17252d = i;
        this.f17251c = c.a.o0.r.j0.b.k().l("key_game_video_tab_has_choosed_sub_class_id", -1);
    }

    public final void a(C1294b c1294b) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, c1294b) == null) || c1294b == null) {
            return;
        }
        SkinManager.setViewTextColor(c1294b.a, (int) R.color.CAM_X0107);
        SkinManager.setImageResource(c1294b.f17256c, R.drawable.icon_game_video_tab_choose_select);
    }

    public void b(List<c.a.p0.q1.f.c.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.a = list;
            if (this.f17254f || ListUtils.isEmpty(list)) {
                return;
            }
            for (c.a.p0.q1.f.c.a aVar : list) {
                if (!StringUtils.isNull(aVar.f17284c)) {
                    c.a.d.f.l.d.h().m(aVar.f17284c, 10, null, this.f17253e);
                }
            }
            this.f17254f = true;
        }
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.f17251c = i;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? ListUtils.getCount(this.a) : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) ? ListUtils.getItem(this.a, i) : invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        View view2;
        C1294b c1294b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view, viewGroup)) == null) {
            if (view == null) {
                c1294b = new C1294b(this, null);
                view2 = LayoutInflater.from(this.f17250b.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0380, (ViewGroup) null);
                c1294b.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090e30);
                c1294b.f17255b = (BarImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e2e);
                c1294b.f17256c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e2f);
                c1294b.f17255b.setShowOval(true);
                c1294b.f17255b.setAutoChangeStyle(true);
                c1294b.f17255b.setBorderColor(this.f17250b.getResources().getColor(R.color.black_alpha8));
                c1294b.f17255b.setBorderWidth(this.f17250b.getResources().getDimensionPixelOffset(R.dimen.tbds3));
                view2.setTag(c1294b);
            } else {
                view2 = view;
                c1294b = (C1294b) view.getTag();
            }
            a(c1294b);
            c.a.p0.q1.f.c.a aVar = (c.a.p0.q1.f.c.a) ListUtils.getItem(this.a, i);
            if (aVar != null) {
                c1294b.a.setText(StringUtils.isNull(aVar.f17283b) ? "" : aVar.f17283b);
                c1294b.f17255b.J(aVar.f17284c, 10, false);
                if (aVar.f17285d == 1) {
                    c1294b.f17255b.setAlpha(1);
                    c1294b.a.setAlpha(1.0f);
                } else {
                    c1294b.f17255b.setAlpha(0.5f);
                    c1294b.a.setAlpha(0.5f);
                }
                if (aVar.a == this.f17251c && this.f17252d != 101) {
                    c1294b.f17256c.setVisibility(0);
                } else {
                    c1294b.f17256c.setVisibility(8);
                }
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
