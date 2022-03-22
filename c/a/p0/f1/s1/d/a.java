package c.a.p0.f1.s1.d;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import c.a.d.f.p.n;
import c.a.o0.r.v.c;
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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public View f14530b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f14531c;

    /* renamed from: d  reason: collision with root package name */
    public EMTextView f14532d;

    /* renamed from: e  reason: collision with root package name */
    public EMTextView f14533e;

    /* renamed from: f  reason: collision with root package name */
    public final int f14534f;

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14534f = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds21);
        this.a = context;
        b(context);
    }

    public void a(BdTypeRecyclerView bdTypeRecyclerView) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bdTypeRecyclerView) == null) || bdTypeRecyclerView == null || (relativeLayout = this.f14531c) == null) {
            return;
        }
        relativeLayout.setVisibility(0);
        bdTypeRecyclerView.s(this.f14531c);
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) && this.f14530b == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d02c8, (ViewGroup) null);
            this.f14530b = inflate;
            this.f14531c = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f092264);
            this.f14532d = (EMTextView) this.f14530b.findViewById(R.id.obfuscated_res_0x7f092266);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(context.getResources().getString(R.string.obfuscated_res_0x7f0f069c));
            EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.obfuscated_res_0x7f0808e2, R.color.CAM_X0109, EMRichTextAnyIconSpan.IconType.WEBP);
            eMRichTextAnyIconSpan.b(n.f(context, R.dimen.tbds0));
            eMRichTextAnyIconSpan.d(n.f(context, R.dimen.M_W_X002));
            spannableStringBuilder.setSpan(eMRichTextAnyIconSpan, 0, 1, 33);
            this.f14532d.setText(spannableStringBuilder);
            this.f14533e = (EMTextView) this.f14530b.findViewById(R.id.obfuscated_res_0x7f092265);
            c(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{DrawableSelector.make().setShape(0).radius(this.f14534f).gradientLinear(DrawableSelector.TL_BR, R.color.CAM_X0212, R.color.CAM_X0212).build(), DrawableSelector.make().setShape(0).radius(this.f14534f).defaultColor("#4D000000").build()});
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                if (layerDrawable.getDrawable(1) != null) {
                    layerDrawable.getDrawable(1).setAlpha(255);
                }
            } else if (layerDrawable.getDrawable(1) != null) {
                layerDrawable.getDrawable(1).setAlpha(0);
            }
            this.f14531c.setBackgroundDrawable(layerDrawable);
            c.d(this.f14532d).v(R.color.CAM_X0109);
            c.d(this.f14533e).v(R.color.CAM_X0109);
        }
    }

    public void d(BdTypeRecyclerView bdTypeRecyclerView) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bdTypeRecyclerView) == null) || bdTypeRecyclerView == null || (relativeLayout = this.f14531c) == null) {
            return;
        }
        relativeLayout.setVisibility(8);
        bdTypeRecyclerView.removeHeaderView(this.f14531c);
    }

    public void e(String str) {
        EMTextView eMTextView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (eMTextView = this.f14533e) == null) {
            return;
        }
        eMTextView.setText(str);
    }
}
