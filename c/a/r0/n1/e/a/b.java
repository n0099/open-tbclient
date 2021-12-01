package c.a.r0.n1.e.a;

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
/* loaded from: classes6.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.r0.n1.e.c.a> f20254e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f20255f;

    /* renamed from: g  reason: collision with root package name */
    public int f20256g;

    /* renamed from: h  reason: collision with root package name */
    public int f20257h;

    /* renamed from: i  reason: collision with root package name */
    public BdUniqueId f20258i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f20259j;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.r0.n1.e.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1203b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f20260b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f20261c;

        public C1203b(b bVar) {
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

        public /* synthetic */ C1203b(b bVar, a aVar) {
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
        this.f20256g = -1;
        this.f20259j = false;
        this.f20255f = tbPageContext;
        this.f20258i = bdUniqueId;
        this.f20257h = i2;
        this.f20256g = c.a.q0.s.e0.b.j().k("key_game_video_tab_has_choosed_sub_class_id", -1);
    }

    public final void a(C1203b c1203b) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, c1203b) == null) || c1203b == null) {
            return;
        }
        SkinManager.setViewTextColor(c1203b.a, R.color.CAM_X0107);
        SkinManager.setImageResource(c1203b.f20261c, R.drawable.icon_game_video_tab_choose_select);
    }

    public void b(List<c.a.r0.n1.e.c.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f20254e = list;
            if (this.f20259j || ListUtils.isEmpty(list)) {
                return;
            }
            for (c.a.r0.n1.e.c.a aVar : list) {
                if (!StringUtils.isNull(aVar.f20308c)) {
                    c.a.d.f.l.d.h().m(aVar.f20308c, 10, null, this.f20258i);
                }
            }
            this.f20259j = true;
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f20256g = i2;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? ListUtils.getCount(this.f20254e) : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? ListUtils.getItem(this.f20254e, i2) : invokeI.objValue;
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
        C1203b c1203b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                c1203b = new C1203b(this, null);
                view2 = LayoutInflater.from(this.f20255f.getPageActivity()).inflate(R.layout.game_video_choose_item_layout, (ViewGroup) null);
                c1203b.a = (TextView) view2.findViewById(R.id.id_game_video_choose_item_title);
                c1203b.f20260b = (BarImageView) view2.findViewById(R.id.id_game_video_choose_item_photo);
                c1203b.f20261c = (ImageView) view2.findViewById(R.id.id_game_video_choose_item_selected);
                c1203b.f20260b.setShowOval(true);
                c1203b.f20260b.setAutoChangeStyle(true);
                c1203b.f20260b.setBorderColor(this.f20255f.getResources().getColor(R.color.black_alpha8));
                c1203b.f20260b.setBorderWidth(this.f20255f.getResources().getDimensionPixelOffset(R.dimen.tbds3));
                view2.setTag(c1203b);
            } else {
                view2 = view;
                c1203b = (C1203b) view.getTag();
            }
            a(c1203b);
            c.a.r0.n1.e.c.a aVar = (c.a.r0.n1.e.c.a) ListUtils.getItem(this.f20254e, i2);
            if (aVar != null) {
                c1203b.a.setText(StringUtils.isNull(aVar.f20307b) ? "" : aVar.f20307b);
                c1203b.f20260b.startLoad(aVar.f20308c, 10, false);
                if (aVar.f20309d == 1) {
                    c1203b.f20260b.setAlpha(1);
                    c1203b.a.setAlpha(1.0f);
                } else {
                    c1203b.f20260b.setAlpha(0.5f);
                    c1203b.a.setAlpha(0.5f);
                }
                if (aVar.a == this.f20256g && this.f20257h != 101) {
                    c1203b.f20261c.setVisibility(0);
                } else {
                    c1203b.f20261c.setVisibility(8);
                }
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
