package c.a.r0.n0.n;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.e.e.p.l;
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
/* loaded from: classes3.dex */
public class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f22857e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f22858f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f22859g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f22860h;

    /* renamed from: i  reason: collision with root package name */
    public int f22861i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f22862j;

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
        this.f22857e = inflate;
        this.f22858f = (FrameLayout) inflate.findViewById(R.id.create_bar_container);
        this.f22859g = (ImageView) this.f22857e.findViewById(R.id.iv_create_icon);
        this.f22860h = (TextView) this.f22857e.findViewById(R.id.create_text);
        this.f22861i = l.g(tbPageContext.getPageActivity(), R.dimen.tbds52);
        this.f22858f.setOnClickListener(this);
        this.f22859g.setOnClickListener(this);
        this.f22860h.setOnClickListener(this);
        if (this.f22858f.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.f22858f.getLayoutParams()).bottomMargin = l.g(tbPageContext.getPageActivity(), R.dimen.tbds47) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
            this.f22858f.requestLayout();
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TBSelector.makeDrawableSelector().defaultColor(R.color.CAM_X0205).defaultStrokeColor(R.color.cp_cont_b_alpha42).strokeWidth(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).radius(this.f22861i).into(this.f22858f);
            SkinManager.setViewTextColor(this.f22860h, R.color.CAM_X0105);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f22859g, R.drawable.ic_icon_pure_createba16, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
        }
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22857e : (View) invokeV.objValue;
    }

    public void c(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.f22862j = onClickListener;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if ((view == this.f22858f || view == this.f22859g || view == this.f22860h) && (onClickListener = this.f22862j) != null) {
                onClickListener.onClick(view);
            }
        }
    }
}
