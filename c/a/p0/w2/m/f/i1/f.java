package c.a.p0.w2.m.f.i1;

import android.graphics.Matrix;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.p0.w2.m.f.y0;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbFragment a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.w2.j.c f20101b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f20102c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f20103d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f20104e;

    /* loaded from: classes3.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    public f(PbFragment pbFragment, c.a.p0.w2.j.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20102c = null;
        this.f20103d = null;
        this.a = pbFragment;
        this.f20101b = cVar;
        b();
    }

    public void a(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        this.f20102c.setVisibility(0);
        bdTypeListView.addHeaderView(this.f20102c);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f20102c == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.a.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0600, (ViewGroup) null);
            this.f20102c = relativeLayout;
            ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f09172d);
            this.f20104e = imageView;
            imageView.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -y0.g());
            this.f20104e.setImageMatrix(matrix);
            TextView textView = (TextView) this.f20102c.findViewById(R.id.obfuscated_res_0x7f0921ea);
            this.f20103d = textView;
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(textView);
            d2.z(R.dimen.T_X03);
            d2.w(R.dimen.M_T_X003);
            d2.v(R.color.CAM_X0105);
            d2.A(R.string.F_X02);
            d2.r(R.color.CAM_X0304);
            this.f20103d.setVisibility(8);
            if (this.f20103d.getParent() == null) {
                this.f20102c.addView(this.f20103d);
            }
            this.f20102c.setOnTouchListener(this.f20101b);
            this.f20102c.setOnLongClickListener(new a(this));
        }
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            SkinManager.setBackgroundColor(this.f20102c, R.color.CAM_X0205);
            TextView textView = this.f20103d;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
                this.f20103d.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            }
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        this.f20102c.setVisibility(8);
        bdTypeListView.removeHeaderView(this.f20102c);
    }

    public void e(c.a.p0.w2.i.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) || fVar == null || fVar.O() == null) {
            return;
        }
        SpannableStringBuilder span_str = fVar.O().getSpan_str();
        SpannableString c2 = y0.c(fVar.O());
        if (!StringUtils.isNull(fVar.O().getTitle())) {
            if (c2 != null) {
                span_str.append((CharSequence) c2);
                this.f20103d.setText(span_str, TextView.BufferType.SPANNABLE);
            } else {
                this.f20103d.setText(span_str);
            }
            h(fVar);
            this.f20103d.setVisibility(0);
            this.f20103d.setMaxLines(3);
            this.f20103d.setEllipsize(TextUtils.TruncateAt.END);
            this.f20103d.invalidate();
            return;
        }
        this.f20103d.setVisibility(8);
    }

    public void f(c.a.p0.w2.i.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            if (fVar != null && !fVar.O().isVideoThreadType() && this.f20103d.getText() != null && this.f20103d.getText().length() > 0) {
                this.f20103d.setVisibility(0);
            } else {
                this.f20103d.setVisibility(8);
            }
        }
    }

    public void g(c.a.p0.w2.i.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) || fVar == null || fVar.O() == null) {
            return;
        }
        SpannableStringBuilder span_str = fVar.O().getSpan_str();
        this.f20103d.setOnTouchListener(new c.a.p0.q4.i(span_str));
        this.f20103d.setText(span_str);
        this.f20103d.setVisibility(0);
    }

    public void h(c.a.p0.w2.i.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) || this.f20103d == null) {
            return;
        }
        int f2 = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds56);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f20103d.getLayoutParams();
        if (fVar.g0()) {
            f2 = 0;
        }
        layoutParams.bottomMargin = f2;
        this.f20103d.setLayoutParams(layoutParams);
    }
}
