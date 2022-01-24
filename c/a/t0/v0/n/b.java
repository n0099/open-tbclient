package c.a.t0.v0.n;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.concern.view.RecommendBarLayout;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;

    /* renamed from: b  reason: collision with root package name */
    public View f24547b;

    /* renamed from: c  reason: collision with root package name */
    public RoundRelativeLayout f24548c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f24549d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f24550e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f24551f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f24552g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f24553h;

    /* renamed from: i  reason: collision with root package name */
    public int f24554i;

    /* renamed from: j  reason: collision with root package name */
    public int f24555j;
    public boolean k;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f24556e;

        public a(b bVar) {
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
                    return;
                }
            }
            this.f24556e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.t0.v0.b.a(this.f24556e.a, null);
                StatisticItem statisticItem = new StatisticItem(RecommendBarLayout.KEY_RECOMMEND_BAR_MORE);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("obj_locate", 1);
                statisticItem.param("obj_type", this.f24556e.k ? 5 : 1);
                statisticItem.param("obj_source", this.f24556e.k ? 1 : 3);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public b(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        View inflate = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.forum_square_item_view, (ViewGroup) null);
        this.f24547b = inflate;
        this.f24548c = (RoundRelativeLayout) inflate.findViewById(R.id.square_background);
        this.f24549d = (ImageView) this.f24547b.findViewById(R.id.square_left_img);
        this.f24550e = (ImageView) this.f24547b.findViewById(R.id.square_right_img);
        this.f24552g = (TextView) this.f24547b.findViewById(R.id.square_title);
        this.f24553h = (TextView) this.f24547b.findViewById(R.id.square_desc);
        this.f24551f = (ImageView) this.f24547b.findViewById(R.id.iv_right_arrow);
        this.f24552g.setText(R.string.forum_square_title);
        this.f24553h.setText(R.string.forum_square_desc);
        this.f24547b.setOnClickListener(new a(this));
        this.f24554i = n.f(this.a.getPageActivity(), R.dimen.tbds90);
        this.f24555j = n.f(this.a.getPageActivity(), R.dimen.tbds58);
        RoundRelativeLayout roundRelativeLayout = this.f24548c;
        int i4 = this.f24554i;
        roundRelativeLayout.setRoundLayoutRadius(new float[]{i4, i4, i4, i4, i4, i4, i4, i4});
    }

    public void c(c.a.t0.v0.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            if (aVar.k()) {
                if (this.f24548c.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f24548c.getLayoutParams();
                    int i2 = marginLayoutParams.bottomMargin;
                    int i3 = this.f24555j;
                    if (i2 != i3) {
                        marginLayoutParams.bottomMargin = i3;
                        this.f24548c.requestLayout();
                    }
                }
            } else if (this.f24548c.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f24548c.getLayoutParams();
                if (marginLayoutParams2.bottomMargin != 0) {
                    marginLayoutParams2.bottomMargin = 0;
                    this.f24548c.requestLayout();
                }
            }
            SkinManager.setBackgroundColor(this.f24548c, R.color.CAM_X0206);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f24549d, R.drawable.ic_pic_mask_square, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setImageResource(this.f24550e, R.drawable.pic_mask_square_circle);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f24551f, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0108, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.f24552g, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f24553h, R.color.CAM_X0108);
        }
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f24547b : (View) invokeV.objValue;
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.k = z;
        }
    }
}
