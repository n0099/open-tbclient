package c.a.p0.w0.p;

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
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;

    /* renamed from: b  reason: collision with root package name */
    public View f19616b;

    /* renamed from: c  reason: collision with root package name */
    public RoundRelativeLayout f19617c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f19618d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f19619e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f19620f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f19621g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f19622h;
    public int i;
    public int j;
    public boolean k;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.p0.w0.b.b(this.a.a, null);
                StatisticItem statisticItem = new StatisticItem("c13645");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("obj_locate", 1);
                statisticItem.param("obj_type", this.a.k ? 5 : 1);
                statisticItem.param("obj_source", this.a.k ? 1 : 3);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        View inflate = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d02d3, (ViewGroup) null);
        this.f19616b = inflate;
        this.f19617c = (RoundRelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091d67);
        this.f19618d = (ImageView) this.f19616b.findViewById(R.id.obfuscated_res_0x7f091d7d);
        this.f19619e = (ImageView) this.f19616b.findViewById(R.id.obfuscated_res_0x7f091d83);
        this.f19621g = (TextView) this.f19616b.findViewById(R.id.obfuscated_res_0x7f091d85);
        this.f19622h = (TextView) this.f19616b.findViewById(R.id.obfuscated_res_0x7f091d69);
        this.f19620f = (ImageView) this.f19616b.findViewById(R.id.obfuscated_res_0x7f090ff6);
        this.f19621g.setText(R.string.obfuscated_res_0x7f0f06a4);
        this.f19622h.setText(R.string.obfuscated_res_0x7f0f06a0);
        this.f19616b.setOnClickListener(new a(this));
        this.i = n.f(this.a.getPageActivity(), R.dimen.tbds90);
        this.j = n.f(this.a.getPageActivity(), R.dimen.tbds58);
        RoundRelativeLayout roundRelativeLayout = this.f19617c;
        int i3 = this.i;
        roundRelativeLayout.setRoundLayoutRadius(new float[]{i3, i3, i3, i3, i3, i3, i3, i3});
    }

    public void c(c.a.p0.w0.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            if (aVar.isTop()) {
                if (this.f19617c.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f19617c.getLayoutParams();
                    int i = marginLayoutParams.bottomMargin;
                    int i2 = this.j;
                    if (i != i2) {
                        marginLayoutParams.bottomMargin = i2;
                        this.f19617c.requestLayout();
                    }
                }
            } else if (this.f19617c.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f19617c.getLayoutParams();
                if (marginLayoutParams2.bottomMargin != 0) {
                    marginLayoutParams2.bottomMargin = 0;
                    this.f19617c.requestLayout();
                }
            }
            SkinManager.setBackgroundColor(this.f19617c, R.color.CAM_X0206);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f19618d, R.drawable.obfuscated_res_0x7f08064d, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setImageResource(this.f19619e, R.drawable.pic_mask_square_circle);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f19620f, R.drawable.obfuscated_res_0x7f0805f8, R.color.CAM_X0108, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.f19621g, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f19622h, (int) R.color.CAM_X0108);
        }
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f19616b : (View) invokeV.objValue;
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.k = z;
        }
    }
}
