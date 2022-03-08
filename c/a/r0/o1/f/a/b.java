package c.a.r0.o1.f.a;

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

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.r0.o1.f.c.a> f19808e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f19809f;

    /* renamed from: g  reason: collision with root package name */
    public int f19810g;

    /* renamed from: h  reason: collision with root package name */
    public int f19811h;

    /* renamed from: i  reason: collision with root package name */
    public BdUniqueId f19812i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f19813j;

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.r0.o1.f.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1240b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f19814b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f19815c;

        public C1240b(b bVar) {
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

        public /* synthetic */ C1240b(b bVar, a aVar) {
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
        this.f19810g = -1;
        this.f19813j = false;
        this.f19809f = tbPageContext;
        this.f19812i = bdUniqueId;
        this.f19811h = i2;
        this.f19810g = c.a.q0.r.j0.b.k().l("key_game_video_tab_has_choosed_sub_class_id", -1);
    }

    public final void a(C1240b c1240b) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, c1240b) == null) || c1240b == null) {
            return;
        }
        SkinManager.setViewTextColor(c1240b.a, (int) R.color.CAM_X0107);
        SkinManager.setImageResource(c1240b.f19815c, R.drawable.icon_game_video_tab_choose_select);
    }

    public void b(List<c.a.r0.o1.f.c.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f19808e = list;
            if (this.f19813j || ListUtils.isEmpty(list)) {
                return;
            }
            for (c.a.r0.o1.f.c.a aVar : list) {
                if (!StringUtils.isNull(aVar.f19860c)) {
                    c.a.d.f.l.d.h().m(aVar.f19860c, 10, null, this.f19812i);
                }
            }
            this.f19813j = true;
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f19810g = i2;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? ListUtils.getCount(this.f19808e) : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? ListUtils.getItem(this.f19808e, i2) : invokeI.objValue;
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
        C1240b c1240b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                c1240b = new C1240b(this, null);
                view2 = LayoutInflater.from(this.f19809f.getPageActivity()).inflate(R.layout.game_video_choose_item_layout, (ViewGroup) null);
                c1240b.a = (TextView) view2.findViewById(R.id.id_game_video_choose_item_title);
                c1240b.f19814b = (BarImageView) view2.findViewById(R.id.id_game_video_choose_item_photo);
                c1240b.f19815c = (ImageView) view2.findViewById(R.id.id_game_video_choose_item_selected);
                c1240b.f19814b.setShowOval(true);
                c1240b.f19814b.setAutoChangeStyle(true);
                c1240b.f19814b.setBorderColor(this.f19809f.getResources().getColor(R.color.black_alpha8));
                c1240b.f19814b.setBorderWidth(this.f19809f.getResources().getDimensionPixelOffset(R.dimen.tbds3));
                view2.setTag(c1240b);
            } else {
                view2 = view;
                c1240b = (C1240b) view.getTag();
            }
            a(c1240b);
            c.a.r0.o1.f.c.a aVar = (c.a.r0.o1.f.c.a) ListUtils.getItem(this.f19808e, i2);
            if (aVar != null) {
                c1240b.a.setText(StringUtils.isNull(aVar.f19859b) ? "" : aVar.f19859b);
                c1240b.f19814b.startLoad(aVar.f19860c, 10, false);
                if (aVar.f19861d == 1) {
                    c1240b.f19814b.setAlpha(1);
                    c1240b.a.setAlpha(1.0f);
                } else {
                    c1240b.f19814b.setAlpha(0.5f);
                    c1240b.a.setAlpha(0.5f);
                }
                if (aVar.a == this.f19810g && this.f19811h != 101) {
                    c1240b.f19815c.setVisibility(0);
                } else {
                    c1240b.f19815c.setVisibility(8);
                }
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
