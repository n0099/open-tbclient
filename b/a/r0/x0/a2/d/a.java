package b.a.r0.x0.a2.d;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import b.a.e.e.p.l;
import b.a.q0.s.u.c;
import b.a.r0.x0.b1;
import b.a.r0.x0.c1;
import b.a.r0.x0.d1;
import b.a.r0.x0.e1;
import b.a.r0.x0.f1;
import b.a.r0.x0.h1;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.tbselector.selector.DrawableSelector;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f25460a;

    /* renamed from: b  reason: collision with root package name */
    public View f25461b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f25462c;

    /* renamed from: d  reason: collision with root package name */
    public EMTextView f25463d;

    /* renamed from: e  reason: collision with root package name */
    public EMTextView f25464e;

    /* renamed from: f  reason: collision with root package name */
    public final int f25465f;

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
        this.f25465f = l.g(TbadkCoreApplication.getInst(), c1.tbds21);
        this.f25460a = context;
        b(context);
    }

    public void a(BdTypeRecyclerView bdTypeRecyclerView) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bdTypeRecyclerView) == null) || bdTypeRecyclerView == null || (relativeLayout = this.f25462c) == null) {
            return;
        }
        relativeLayout.setVisibility(0);
        bdTypeRecyclerView.addHeaderView(this.f25462c);
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) && this.f25461b == null) {
            View inflate = LayoutInflater.from(context).inflate(f1.forum_rules_unaudited, (ViewGroup) null);
            this.f25461b = inflate;
            this.f25462c = (RelativeLayout) inflate.findViewById(e1.unaudited);
            this.f25463d = (EMTextView) this.f25461b.findViewById(e1.unaudited_title);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(context.getResources().getString(h1.forum_rules_unaudited_alert));
            EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(d1.icon_pure_barrules_careful12, b1.CAM_X0109, EMRichTextAnyIconSpan.IconType.WEBP);
            eMRichTextAnyIconSpan.b(l.g(context, c1.tbds0));
            eMRichTextAnyIconSpan.d(l.g(context, c1.M_W_X002));
            spannableStringBuilder.setSpan(eMRichTextAnyIconSpan, 0, 1, 33);
            this.f25463d.setText(spannableStringBuilder);
            this.f25464e = (EMTextView) this.f25461b.findViewById(e1.unaudited_content);
            c(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            DrawableSelector radius = DrawableSelector.make().setShape(0).radius(this.f25465f);
            int i3 = b1.CAM_X0212;
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{radius.gradientLinear(DrawableSelector.TL_BR, i3, i3).build(), DrawableSelector.make().setShape(0).radius(this.f25465f).defaultColor("#4D000000").build()});
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                if (layerDrawable.getDrawable(1) != null) {
                    layerDrawable.getDrawable(1).setAlpha(255);
                }
            } else if (layerDrawable.getDrawable(1) != null) {
                layerDrawable.getDrawable(1).setAlpha(0);
            }
            this.f25462c.setBackgroundDrawable(layerDrawable);
            c.d(this.f25463d).v(b1.CAM_X0109);
            c.d(this.f25464e).v(b1.CAM_X0109);
        }
    }

    public void d(BdTypeRecyclerView bdTypeRecyclerView) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bdTypeRecyclerView) == null) || bdTypeRecyclerView == null || (relativeLayout = this.f25462c) == null) {
            return;
        }
        relativeLayout.setVisibility(8);
        bdTypeRecyclerView.removeHeaderView(this.f25462c);
    }

    public void e(String str) {
        EMTextView eMTextView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (eMTextView = this.f25464e) == null) {
            return;
        }
        eMTextView.setText(str);
    }
}
