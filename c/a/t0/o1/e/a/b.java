package c.a.t0.o1.e.a;

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
    public List<c.a.t0.o1.e.c.a> f20261e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f20262f;

    /* renamed from: g  reason: collision with root package name */
    public int f20263g;

    /* renamed from: h  reason: collision with root package name */
    public int f20264h;

    /* renamed from: i  reason: collision with root package name */
    public BdUniqueId f20265i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f20266j;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.t0.o1.e.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1271b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f20267b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f20268c;

        public C1271b(b bVar) {
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

        public /* synthetic */ C1271b(b bVar, a aVar) {
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
        this.f20263g = -1;
        this.f20266j = false;
        this.f20262f = tbPageContext;
        this.f20265i = bdUniqueId;
        this.f20264h = i2;
        this.f20263g = c.a.s0.s.h0.b.k().l("key_game_video_tab_has_choosed_sub_class_id", -1);
    }

    public final void a(C1271b c1271b) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, c1271b) == null) || c1271b == null) {
            return;
        }
        SkinManager.setViewTextColor(c1271b.a, R.color.CAM_X0107);
        SkinManager.setImageResource(c1271b.f20268c, R.drawable.icon_game_video_tab_choose_select);
    }

    public void b(List<c.a.t0.o1.e.c.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f20261e = list;
            if (this.f20266j || ListUtils.isEmpty(list)) {
                return;
            }
            for (c.a.t0.o1.e.c.a aVar : list) {
                if (!StringUtils.isNull(aVar.f20313c)) {
                    c.a.d.f.l.d.h().m(aVar.f20313c, 10, null, this.f20265i);
                }
            }
            this.f20266j = true;
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f20263g = i2;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? ListUtils.getCount(this.f20261e) : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? ListUtils.getItem(this.f20261e, i2) : invokeI.objValue;
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
        C1271b c1271b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                c1271b = new C1271b(this, null);
                view2 = LayoutInflater.from(this.f20262f.getPageActivity()).inflate(R.layout.game_video_choose_item_layout, (ViewGroup) null);
                c1271b.a = (TextView) view2.findViewById(R.id.id_game_video_choose_item_title);
                c1271b.f20267b = (BarImageView) view2.findViewById(R.id.id_game_video_choose_item_photo);
                c1271b.f20268c = (ImageView) view2.findViewById(R.id.id_game_video_choose_item_selected);
                c1271b.f20267b.setShowOval(true);
                c1271b.f20267b.setAutoChangeStyle(true);
                c1271b.f20267b.setBorderColor(this.f20262f.getResources().getColor(R.color.black_alpha8));
                c1271b.f20267b.setBorderWidth(this.f20262f.getResources().getDimensionPixelOffset(R.dimen.tbds3));
                view2.setTag(c1271b);
            } else {
                view2 = view;
                c1271b = (C1271b) view.getTag();
            }
            a(c1271b);
            c.a.t0.o1.e.c.a aVar = (c.a.t0.o1.e.c.a) ListUtils.getItem(this.f20261e, i2);
            if (aVar != null) {
                c1271b.a.setText(StringUtils.isNull(aVar.f20312b) ? "" : aVar.f20312b);
                c1271b.f20267b.startLoad(aVar.f20313c, 10, false);
                if (aVar.f20314d == 1) {
                    c1271b.f20267b.setAlpha(1);
                    c1271b.a.setAlpha(1.0f);
                } else {
                    c1271b.f20267b.setAlpha(0.5f);
                    c1271b.a.setAlpha(0.5f);
                }
                if (aVar.a == this.f20263g && this.f20264h != 101) {
                    c1271b.f20268c.setVisibility(0);
                } else {
                    c1271b.f20268c.setVisibility(8);
                }
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
