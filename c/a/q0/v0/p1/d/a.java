package c.a.q0.v0.p1.d;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import c.a.e.e.p.l;
import c.a.p0.s.u.c;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.tbselector.selector.DrawableSelector;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f26916a;

    /* renamed from: b  reason: collision with root package name */
    public View f26917b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f26918c;

    /* renamed from: d  reason: collision with root package name */
    public EMTextView f26919d;

    /* renamed from: e  reason: collision with root package name */
    public EMTextView f26920e;

    /* renamed from: f  reason: collision with root package name */
    public final int f26921f;

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f26921f = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds21);
        this.f26916a = context;
        b(context);
    }

    public void a(BdTypeRecyclerView bdTypeRecyclerView) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bdTypeRecyclerView) == null) || bdTypeRecyclerView == null || (relativeLayout = this.f26918c) == null) {
            return;
        }
        relativeLayout.setVisibility(0);
        bdTypeRecyclerView.addHeaderView(this.f26918c);
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) && this.f26917b == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.forum_rules_unaudited, (ViewGroup) null);
            this.f26917b = inflate;
            this.f26918c = (RelativeLayout) inflate.findViewById(R.id.unaudited);
            this.f26919d = (EMTextView) this.f26917b.findViewById(R.id.unaudited_title);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(context.getResources().getString(R.string.forum_rules_unaudited_alert));
            EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.icon_pure_barrules_careful12, R.color.CAM_X0109, EMRichTextAnyIconSpan.IconType.WEBP);
            eMRichTextAnyIconSpan.a(l.g(context, R.dimen.tbds0));
            eMRichTextAnyIconSpan.c(l.g(context, R.dimen.M_W_X002));
            spannableStringBuilder.setSpan(eMRichTextAnyIconSpan, 0, 1, 33);
            this.f26919d.setText(spannableStringBuilder);
            this.f26920e = (EMTextView) this.f26917b.findViewById(R.id.unaudited_content);
            c(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            DrawableSelector radius = DrawableSelector.make().setShape(0).radius(this.f26921f);
            int i3 = R.color.CAM_X0212;
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{radius.gradientLinear(DrawableSelector.TL_BR, i3, i3).build(), DrawableSelector.make().setShape(0).radius(this.f26921f).defaultColor("#4D000000").build()});
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                if (layerDrawable.getDrawable(1) != null) {
                    layerDrawable.getDrawable(1).setAlpha(255);
                }
            } else if (layerDrawable.getDrawable(1) != null) {
                layerDrawable.getDrawable(1).setAlpha(0);
            }
            this.f26918c.setBackgroundDrawable(layerDrawable);
            c.d(this.f26919d).u(R.color.CAM_X0109);
            c.d(this.f26920e).u(R.color.CAM_X0109);
        }
    }

    public void d(BdTypeRecyclerView bdTypeRecyclerView) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bdTypeRecyclerView) == null) || bdTypeRecyclerView == null || (relativeLayout = this.f26918c) == null) {
            return;
        }
        relativeLayout.setVisibility(8);
        bdTypeRecyclerView.removeHeaderView(this.f26918c);
    }

    public void e(String str) {
        EMTextView eMTextView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (eMTextView = this.f26920e) == null) {
            return;
        }
        eMTextView.setText(str);
    }
}
