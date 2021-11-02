package b.a.r0.o0.n;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import b.a.e.e.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f21922e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f21923f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f21924g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f21925h;

    /* renamed from: i  reason: collision with root package name */
    public int f21926i;
    public View.OnClickListener j;

    public a(TbPageContext<?> tbPageContext) {
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
        View inflate = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_bar_creator_item, (ViewGroup) null);
        this.f21922e = inflate;
        this.f21923f = (FrameLayout) inflate.findViewById(R.id.create_bar_container);
        this.f21924g = (ImageView) this.f21922e.findViewById(R.id.iv_create_icon);
        this.f21925h = (TextView) this.f21922e.findViewById(R.id.create_text);
        this.f21926i = l.g(tbPageContext.getPageActivity(), R.dimen.tbds52);
        this.f21923f.setOnClickListener(this);
        this.f21924g.setOnClickListener(this);
        this.f21925h.setOnClickListener(this);
        if (this.f21923f.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.f21923f.getLayoutParams()).bottomMargin = l.g(tbPageContext.getPageActivity(), R.dimen.tbds47) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
            this.f21923f.requestLayout();
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TBSelector.makeDrawableSelector().defaultColor(R.color.CAM_X0205).defaultStrokeColor(R.color.cp_cont_b_alpha42).strokeWidth(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).radius(this.f21926i).into(this.f21923f);
            SkinManager.setViewTextColor(this.f21925h, R.color.CAM_X0105);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f21924g, R.drawable.ic_icon_pure_createba16, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
        }
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f21922e : (View) invokeV.objValue;
    }

    public void c(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.j = onClickListener;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if ((view == this.f21923f || view == this.f21924g || view == this.f21925h) && (onClickListener = this.j) != null) {
                onClickListener.onClick(view);
            }
        }
    }
}
