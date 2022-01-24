package c.a.t0.p1.e.a;

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
/* loaded from: classes8.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.t0.p1.e.c.a> f20582e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f20583f;

    /* renamed from: g  reason: collision with root package name */
    public int f20584g;

    /* renamed from: h  reason: collision with root package name */
    public int f20585h;

    /* renamed from: i  reason: collision with root package name */
    public BdUniqueId f20586i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f20587j;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.t0.p1.e.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1285b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f20588b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f20589c;

        public C1285b(b bVar) {
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
                }
            }
        }

        public /* synthetic */ C1285b(b bVar, a aVar) {
            this(bVar);
        }
    }

    public b(TbPageContext tbPageContext, int i2, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i2), bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20584g = -1;
        this.f20587j = false;
        this.f20583f = tbPageContext;
        this.f20586i = bdUniqueId;
        this.f20585h = i2;
        this.f20584g = c.a.s0.s.i0.b.k().l("key_game_video_tab_has_choosed_sub_class_id", -1);
    }

    public final void a(C1285b c1285b) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, c1285b) == null) || c1285b == null) {
            return;
        }
        SkinManager.setViewTextColor(c1285b.a, R.color.CAM_X0107);
        SkinManager.setImageResource(c1285b.f20589c, R.drawable.icon_game_video_tab_choose_select);
    }

    public void b(List<c.a.t0.p1.e.c.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f20582e = list;
            if (this.f20587j || ListUtils.isEmpty(list)) {
                return;
            }
            for (c.a.t0.p1.e.c.a aVar : list) {
                if (!StringUtils.isNull(aVar.f20634c)) {
                    c.a.d.f.l.d.h().m(aVar.f20634c, 10, null, this.f20586i);
                }
            }
            this.f20587j = true;
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f20584g = i2;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? ListUtils.getCount(this.f20582e) : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? ListUtils.getItem(this.f20582e, i2) : invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        View view2;
        C1285b c1285b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                c1285b = new C1285b(this, null);
                view2 = LayoutInflater.from(this.f20583f.getPageActivity()).inflate(R.layout.game_video_choose_item_layout, (ViewGroup) null);
                c1285b.a = (TextView) view2.findViewById(R.id.id_game_video_choose_item_title);
                c1285b.f20588b = (BarImageView) view2.findViewById(R.id.id_game_video_choose_item_photo);
                c1285b.f20589c = (ImageView) view2.findViewById(R.id.id_game_video_choose_item_selected);
                c1285b.f20588b.setShowOval(true);
                c1285b.f20588b.setAutoChangeStyle(true);
                c1285b.f20588b.setBorderColor(this.f20583f.getResources().getColor(R.color.black_alpha8));
                c1285b.f20588b.setBorderWidth(this.f20583f.getResources().getDimensionPixelOffset(R.dimen.tbds3));
                view2.setTag(c1285b);
            } else {
                view2 = view;
                c1285b = (C1285b) view.getTag();
            }
            a(c1285b);
            c.a.t0.p1.e.c.a aVar = (c.a.t0.p1.e.c.a) ListUtils.getItem(this.f20582e, i2);
            if (aVar != null) {
                c1285b.a.setText(StringUtils.isNull(aVar.f20633b) ? "" : aVar.f20633b);
                c1285b.f20588b.startLoad(aVar.f20634c, 10, false);
                if (aVar.f20635d == 1) {
                    c1285b.f20588b.setAlpha(1);
                    c1285b.a.setAlpha(1.0f);
                } else {
                    c1285b.f20588b.setAlpha(0.5f);
                    c1285b.a.setAlpha(0.5f);
                }
                if (aVar.a == this.f20584g && this.f20585h != 101) {
                    c1285b.f20589c.setVisibility(0);
                } else {
                    c1285b.f20589c.setVisibility(8);
                }
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
