package c.a.q0.m0.n;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.e.e.p.l;
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
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f22295a;

    /* renamed from: b  reason: collision with root package name */
    public View f22296b;

    /* renamed from: c  reason: collision with root package name */
    public RoundRelativeLayout f22297c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f22298d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f22299e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f22300f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f22301g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f22302h;

    /* renamed from: i  reason: collision with root package name */
    public int f22303i;

    /* renamed from: j  reason: collision with root package name */
    public int f22304j;
    public boolean k;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22305e;

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
            this.f22305e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.q0.m0.b.a(this.f22305e.f22295a, null);
                StatisticItem statisticItem = new StatisticItem(RecommendBarLayout.KEY_RECOMMEND_BAR_MORE);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("obj_locate", 1);
                statisticItem.param("obj_type", this.f22305e.k ? 5 : 1);
                statisticItem.param("obj_source", this.f22305e.k ? 1 : 3);
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
        this.f22295a = tbPageContext;
        View inflate = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.forum_square_item_view, (ViewGroup) null);
        this.f22296b = inflate;
        this.f22297c = (RoundRelativeLayout) inflate.findViewById(R.id.square_background);
        this.f22298d = (ImageView) this.f22296b.findViewById(R.id.square_left_img);
        this.f22299e = (ImageView) this.f22296b.findViewById(R.id.square_right_img);
        this.f22301g = (TextView) this.f22296b.findViewById(R.id.square_title);
        this.f22302h = (TextView) this.f22296b.findViewById(R.id.square_desc);
        this.f22300f = (ImageView) this.f22296b.findViewById(R.id.iv_right_arrow);
        this.f22301g.setText(R.string.forum_square_title);
        this.f22302h.setText(R.string.forum_square_desc);
        this.f22296b.setOnClickListener(new a(this));
        this.f22303i = l.g(this.f22295a.getPageActivity(), R.dimen.tbds90);
        this.f22304j = l.g(this.f22295a.getPageActivity(), R.dimen.tbds58);
        RoundRelativeLayout roundRelativeLayout = this.f22297c;
        int i4 = this.f22303i;
        roundRelativeLayout.setRoundLayoutRadius(new float[]{i4, i4, i4, i4, i4, i4, i4, i4});
    }

    public void c(c.a.q0.m0.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            if (aVar.k()) {
                if (this.f22297c.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f22297c.getLayoutParams();
                    int i2 = marginLayoutParams.bottomMargin;
                    int i3 = this.f22304j;
                    if (i2 != i3) {
                        marginLayoutParams.bottomMargin = i3;
                        this.f22297c.requestLayout();
                    }
                }
            } else if (this.f22297c.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f22297c.getLayoutParams();
                if (marginLayoutParams2.bottomMargin != 0) {
                    marginLayoutParams2.bottomMargin = 0;
                    this.f22297c.requestLayout();
                }
            }
            SkinManager.setBackgroundColor(this.f22297c, R.color.CAM_X0206);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f22298d, R.drawable.ic_pic_mask_square, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setImageResource(this.f22299e, R.drawable.pic_mask_square_circle);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f22300f, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0108, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.f22301g, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f22302h, R.color.CAM_X0108);
        }
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22296b : (View) invokeV.objValue;
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.k = z;
        }
    }
}
