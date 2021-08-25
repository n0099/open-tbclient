package c.a.q0.f1.e.a;

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
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.q0.f1.e.c.a> f17431e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f17432f;

    /* renamed from: g  reason: collision with root package name */
    public int f17433g;

    /* renamed from: h  reason: collision with root package name */
    public int f17434h;

    /* renamed from: i  reason: collision with root package name */
    public BdUniqueId f17435i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f17436j;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.q0.f1.e.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0843b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f17437a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f17438b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f17439c;

        public C0843b(b bVar) {
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

        public /* synthetic */ C0843b(b bVar, a aVar) {
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
        this.f17433g = -1;
        this.f17436j = false;
        this.f17432f = tbPageContext;
        this.f17435i = bdUniqueId;
        this.f17434h = i2;
        this.f17433g = c.a.p0.s.d0.b.j().k("key_game_video_tab_has_choosed_sub_class_id", -1);
    }

    public final void a(C0843b c0843b) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, c0843b) == null) || c0843b == null) {
            return;
        }
        SkinManager.setViewTextColor(c0843b.f17437a, R.color.CAM_X0107);
        SkinManager.setImageResource(c0843b.f17439c, R.drawable.icon_game_video_tab_choose_select);
    }

    public void b(List<c.a.q0.f1.e.c.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f17431e = list;
            if (this.f17436j || ListUtils.isEmpty(list)) {
                return;
            }
            for (c.a.q0.f1.e.c.a aVar : list) {
                if (!StringUtils.isNull(aVar.f17496c)) {
                    c.a.e.e.l.d.h().m(aVar.f17496c, 10, null, this.f17435i);
                }
            }
            this.f17436j = true;
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f17433g = i2;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? ListUtils.getCount(this.f17431e) : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? ListUtils.getItem(this.f17431e, i2) : invokeI.objValue;
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
        C0843b c0843b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                c0843b = new C0843b(this, null);
                view2 = LayoutInflater.from(this.f17432f.getPageActivity()).inflate(R.layout.game_video_choose_item_layout, (ViewGroup) null);
                c0843b.f17437a = (TextView) view2.findViewById(R.id.id_game_video_choose_item_title);
                c0843b.f17438b = (BarImageView) view2.findViewById(R.id.id_game_video_choose_item_photo);
                c0843b.f17439c = (ImageView) view2.findViewById(R.id.id_game_video_choose_item_selected);
                c0843b.f17438b.setShowOval(true);
                c0843b.f17438b.setAutoChangeStyle(true);
                c0843b.f17438b.setBorderColor(this.f17432f.getResources().getColor(R.color.black_alpha8));
                c0843b.f17438b.setBorderWidth(this.f17432f.getResources().getDimensionPixelOffset(R.dimen.tbds3));
                view2.setTag(c0843b);
            } else {
                view2 = view;
                c0843b = (C0843b) view.getTag();
            }
            a(c0843b);
            c.a.q0.f1.e.c.a aVar = (c.a.q0.f1.e.c.a) ListUtils.getItem(this.f17431e, i2);
            if (aVar != null) {
                c0843b.f17437a.setText(StringUtils.isNull(aVar.f17495b) ? "" : aVar.f17495b);
                c0843b.f17438b.startLoad(aVar.f17496c, 10, false);
                if (aVar.f17497d == 1) {
                    c0843b.f17438b.setAlpha(1);
                    c0843b.f17437a.setAlpha(1.0f);
                } else {
                    c0843b.f17438b.setAlpha(0.5f);
                    c0843b.f17437a.setAlpha(0.5f);
                }
                if (aVar.f17494a == this.f17433g && this.f17434h != 101) {
                    c0843b.f17439c.setVisibility(0);
                } else {
                    c0843b.f17439c.setVisibility(8);
                }
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
