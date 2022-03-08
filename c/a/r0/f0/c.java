package c.a.r0.f0;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.r0.f0.d0.a;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public abstract class c<T extends c.a.r0.f0.d0.a> extends b<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout m;
    public TextView n;
    public TextView o;
    public TextView p;
    public View q;
    public View r;
    public View s;
    public ImageView t;
    public LinearLayout u;
    public View v;
    public View w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.u = null;
        q(j());
    }

    @Override // c.a.r0.f0.b
    public final int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.card_group : invokeV.intValue;
    }

    @Override // c.a.r0.f0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            if (this.f17260e != i2) {
                p();
            }
            this.f17260e = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && this.p == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (StringUtils.isNull(str)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(i(), new String[]{str});
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (e() != null && e().equals("home")) {
                SkinManager.setViewTextColor(this.n, R.color.CAM_X0109, 1);
                this.t.setVisibility(8);
            } else {
                SkinManager.setViewTextColor(this.n, R.color.CAM_X0106, 1);
                SkinManager.setImageResource(this.t, R.drawable.icon_arrow_tab);
            }
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0304, 1);
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0109, 1);
            SkinManager.setBackgroundColor(j(), R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.q, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.r, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.s, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.v, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.w, R.color.CAM_X0204);
        }
    }

    public final void q(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            this.m = (RelativeLayout) view.findViewById(R.id.item_layout_group_title);
            this.n = (TextView) view.findViewById(R.id.item_group_title);
            this.o = (TextView) view.findViewById(R.id.item_right_tv);
            this.p = (TextView) view.findViewById(R.id.item_bottom_more_tv);
            this.q = view.findViewById(R.id.divider_line_top);
            this.r = view.findViewById(R.id.divider_line_middle);
            this.s = view.findViewById(R.id.divider_line_bottom);
            this.u = (LinearLayout) view.findViewById(R.id.card_container);
            this.v = view.findViewById(R.id.divider_card);
            this.w = view.findViewById(R.id.divider_card_top);
            this.t = (ImageView) view.findViewById(R.id.item_right_arrow);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.f0.b
    /* renamed from: s */
    public void k(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, t) == null) {
            if (t == null) {
                j().setVisibility(8);
                return;
            }
            this.n.setText(t.mGroupTitle);
            int i2 = t.mRightIconResId;
            if (i2 > 0) {
                this.o.setBackgroundResource(i2);
            }
            if (t.showTopDivider) {
                this.w.setVisibility(0);
            } else {
                this.w.setVisibility(8);
            }
            if (t.showBottomDivider) {
                this.v.setVisibility(0);
            } else {
                this.v.setVisibility(8);
            }
            if (!StringUtils.isNull(t.mBottomText)) {
                this.p.setVisibility(0);
                this.s.setVisibility(0);
                this.r.setVisibility(0);
                this.p.setText(t.mBottomText);
                String str = t.mBottomLink;
                if (StringUtils.isNull(str)) {
                    return;
                }
                this.p.setTag(str);
                this.p.setOnClickListener(this);
                return;
            }
            this.p.setVisibility(8);
            this.s.setVisibility(8);
            this.r.setVisibility(8);
        }
    }
}
