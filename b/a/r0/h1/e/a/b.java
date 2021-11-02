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
    public List<b.a.r0.h1.e.c.a> f17078e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f17079f;

    /* renamed from: g  reason: collision with root package name */
    public int f17080g;

    /* renamed from: h  reason: collision with root package name */
    public int f17081h;

    /* renamed from: i  reason: collision with root package name */
    public BdUniqueId f17082i;
    public boolean j;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: b.a.r0.h1.e.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0876b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f17083a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f17084b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f17085c;

        public C0876b(b bVar) {
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

        public /* synthetic */ C0876b(b bVar, a aVar) {
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
        this.f17080g = -1;
        this.j = false;
        this.f17079f = tbPageContext;
        this.f17082i = bdUniqueId;
        this.f17081h = i2;
        this.f17080g = b.a.q0.s.e0.b.j().k("key_game_video_tab_has_choosed_sub_class_id", -1);
    }

    public final void a(C0876b c0876b) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, c0876b) == null) || c0876b == null) {
            return;
        }
        SkinManager.setViewTextColor(c0876b.f17083a, R.color.CAM_X0107);
        SkinManager.setImageResource(c0876b.f17085c, R.drawable.icon_game_video_tab_choose_select);
    }

    public void b(List<b.a.r0.h1.e.c.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f17078e = list;
            if (this.j || ListUtils.isEmpty(list)) {
                return;
            }
            for (b.a.r0.h1.e.c.a aVar : list) {
                if (!StringUtils.isNull(aVar.f17140c)) {
                    b.a.e.e.l.d.h().m(aVar.f17140c, 10, null, this.f17082i);
                }
            }
            this.j = true;
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f17080g = i2;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? ListUtils.getCount(this.f17078e) : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? ListUtils.getItem(this.f17078e, i2) : invokeI.objValue;
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
        C0876b c0876b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                c0876b = new C0876b(this, null);
                view2 = LayoutInflater.from(this.f17079f.getPageActivity()).inflate(R.layout.game_video_choose_item_layout, (ViewGroup) null);
                c0876b.f17083a = (TextView) view2.findViewById(R.id.id_game_video_choose_item_title);
                c0876b.f17084b = (BarImageView) view2.findViewById(R.id.id_game_video_choose_item_photo);
                c0876b.f17085c = (ImageView) view2.findViewById(R.id.id_game_video_choose_item_selected);
                c0876b.f17084b.setShowOval(true);
                c0876b.f17084b.setAutoChangeStyle(true);
                c0876b.f17084b.setBorderColor(this.f17079f.getResources().getColor(R.color.black_alpha8));
                c0876b.f17084b.setBorderWidth(this.f17079f.getResources().getDimensionPixelOffset(R.dimen.tbds3));
                view2.setTag(c0876b);
            } else {
                view2 = view;
                c0876b = (C0876b) view.getTag();
            }
            a(c0876b);
            b.a.r0.h1.e.c.a aVar = (b.a.r0.h1.e.c.a) ListUtils.getItem(this.f17078e, i2);
            if (aVar != null) {
                c0876b.f17083a.setText(StringUtils.isNull(aVar.f17139b) ? "" : aVar.f17139b);
                c0876b.f17084b.startLoad(aVar.f17140c, 10, false);
                if (aVar.f17141d == 1) {
                    c0876b.f17084b.setAlpha(1);
                    c0876b.f17083a.setAlpha(1.0f);
                } else {
                    c0876b.f17084b.setAlpha(0.5f);
                    c0876b.f17083a.setAlpha(0.5f);
                }
                if (aVar.f17138a == this.f17080g && this.f17081h != 101) {
                    c0876b.f17085c.setVisibility(0);
                } else {
                    c0876b.f17085c.setVisibility(8);
                }
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
