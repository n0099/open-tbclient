package c.a.r0.g1.e.a;

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
    public List<c.a.r0.g1.e.c.a> f17955e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f17956f;

    /* renamed from: g  reason: collision with root package name */
    public int f17957g;

    /* renamed from: h  reason: collision with root package name */
    public int f17958h;

    /* renamed from: i  reason: collision with root package name */
    public BdUniqueId f17959i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f17960j;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.r0.g1.e.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0874b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f17961a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f17962b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f17963c;

        public C0874b(b bVar) {
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

        public /* synthetic */ C0874b(b bVar, a aVar) {
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
        this.f17957g = -1;
        this.f17960j = false;
        this.f17956f = tbPageContext;
        this.f17959i = bdUniqueId;
        this.f17958h = i2;
        this.f17957g = c.a.q0.s.d0.b.j().k("key_game_video_tab_has_choosed_sub_class_id", -1);
    }

    public final void a(C0874b c0874b) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, c0874b) == null) || c0874b == null) {
            return;
        }
        SkinManager.setViewTextColor(c0874b.f17961a, R.color.CAM_X0107);
        SkinManager.setImageResource(c0874b.f17963c, R.drawable.icon_game_video_tab_choose_select);
    }

    public void b(List<c.a.r0.g1.e.c.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f17955e = list;
            if (this.f17960j || ListUtils.isEmpty(list)) {
                return;
            }
            for (c.a.r0.g1.e.c.a aVar : list) {
                if (!StringUtils.isNull(aVar.f18020c)) {
                    c.a.e.e.l.d.h().m(aVar.f18020c, 10, null, this.f17959i);
                }
            }
            this.f17960j = true;
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f17957g = i2;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? ListUtils.getCount(this.f17955e) : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? ListUtils.getItem(this.f17955e, i2) : invokeI.objValue;
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
        C0874b c0874b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                c0874b = new C0874b(this, null);
                view2 = LayoutInflater.from(this.f17956f.getPageActivity()).inflate(R.layout.game_video_choose_item_layout, (ViewGroup) null);
                c0874b.f17961a = (TextView) view2.findViewById(R.id.id_game_video_choose_item_title);
                c0874b.f17962b = (BarImageView) view2.findViewById(R.id.id_game_video_choose_item_photo);
                c0874b.f17963c = (ImageView) view2.findViewById(R.id.id_game_video_choose_item_selected);
                c0874b.f17962b.setShowOval(true);
                c0874b.f17962b.setAutoChangeStyle(true);
                c0874b.f17962b.setBorderColor(this.f17956f.getResources().getColor(R.color.black_alpha8));
                c0874b.f17962b.setBorderWidth(this.f17956f.getResources().getDimensionPixelOffset(R.dimen.tbds3));
                view2.setTag(c0874b);
            } else {
                view2 = view;
                c0874b = (C0874b) view.getTag();
            }
            a(c0874b);
            c.a.r0.g1.e.c.a aVar = (c.a.r0.g1.e.c.a) ListUtils.getItem(this.f17955e, i2);
            if (aVar != null) {
                c0874b.f17961a.setText(StringUtils.isNull(aVar.f18019b) ? "" : aVar.f18019b);
                c0874b.f17962b.startLoad(aVar.f18020c, 10, false);
                if (aVar.f18021d == 1) {
                    c0874b.f17962b.setAlpha(1);
                    c0874b.f17961a.setAlpha(1.0f);
                } else {
                    c0874b.f17962b.setAlpha(0.5f);
                    c0874b.f17961a.setAlpha(0.5f);
                }
                if (aVar.f18018a == this.f17957g && this.f17958h != 101) {
                    c0874b.f17963c.setVisibility(0);
                } else {
                    c0874b.f17963c.setVisibility(8);
                }
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
