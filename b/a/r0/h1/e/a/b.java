package b.a.r0.h1.e.a;

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
/* loaded from: classes4.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<b.a.r0.h1.e.c.a> f18546e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f18547f;

    /* renamed from: g  reason: collision with root package name */
    public int f18548g;

    /* renamed from: h  reason: collision with root package name */
    public int f18549h;

    /* renamed from: i  reason: collision with root package name */
    public BdUniqueId f18550i;
    public boolean j;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: b.a.r0.h1.e.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0944b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f18551a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f18552b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f18553c;

        public C0944b(b bVar) {
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

        public /* synthetic */ C0944b(b bVar, a aVar) {
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
        this.f18548g = -1;
        this.j = false;
        this.f18547f = tbPageContext;
        this.f18550i = bdUniqueId;
        this.f18549h = i2;
        this.f18548g = b.a.q0.s.e0.b.j().k("key_game_video_tab_has_choosed_sub_class_id", -1);
    }

    public final void a(C0944b c0944b) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, c0944b) == null) || c0944b == null) {
            return;
        }
        SkinManager.setViewTextColor(c0944b.f18551a, R.color.CAM_X0107);
        SkinManager.setImageResource(c0944b.f18553c, R.drawable.icon_game_video_tab_choose_select);
    }

    public void b(List<b.a.r0.h1.e.c.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f18546e = list;
            if (this.j || ListUtils.isEmpty(list)) {
                return;
            }
            for (b.a.r0.h1.e.c.a aVar : list) {
                if (!StringUtils.isNull(aVar.f18608c)) {
                    b.a.e.f.l.d.h().m(aVar.f18608c, 10, null, this.f18550i);
                }
            }
            this.j = true;
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f18548g = i2;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? ListUtils.getCount(this.f18546e) : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? ListUtils.getItem(this.f18546e, i2) : invokeI.objValue;
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
        C0944b c0944b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                c0944b = new C0944b(this, null);
                view2 = LayoutInflater.from(this.f18547f.getPageActivity()).inflate(R.layout.game_video_choose_item_layout, (ViewGroup) null);
                c0944b.f18551a = (TextView) view2.findViewById(R.id.id_game_video_choose_item_title);
                c0944b.f18552b = (BarImageView) view2.findViewById(R.id.id_game_video_choose_item_photo);
                c0944b.f18553c = (ImageView) view2.findViewById(R.id.id_game_video_choose_item_selected);
                c0944b.f18552b.setShowOval(true);
                c0944b.f18552b.setAutoChangeStyle(true);
                c0944b.f18552b.setBorderColor(this.f18547f.getResources().getColor(R.color.black_alpha8));
                c0944b.f18552b.setBorderWidth(this.f18547f.getResources().getDimensionPixelOffset(R.dimen.tbds3));
                view2.setTag(c0944b);
            } else {
                view2 = view;
                c0944b = (C0944b) view.getTag();
            }
            a(c0944b);
            b.a.r0.h1.e.c.a aVar = (b.a.r0.h1.e.c.a) ListUtils.getItem(this.f18546e, i2);
            if (aVar != null) {
                c0944b.f18551a.setText(StringUtils.isNull(aVar.f18607b) ? "" : aVar.f18607b);
                c0944b.f18552b.startLoad(aVar.f18608c, 10, false);
                if (aVar.f18609d == 1) {
                    c0944b.f18552b.setAlpha(1);
                    c0944b.f18551a.setAlpha(1.0f);
                } else {
                    c0944b.f18552b.setAlpha(0.5f);
                    c0944b.f18551a.setAlpha(0.5f);
                }
                if (aVar.f18606a == this.f18548g && this.f18549h != 101) {
                    c0944b.f18553c.setVisibility(0);
                } else {
                    c0944b.f18553c.setVisibility(8);
                }
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
