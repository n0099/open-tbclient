package b.a.r0.k2.u.f.a1;

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
import b.a.r0.k2.u.f.q0;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f19013a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.r0.k2.s.c f19014b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f19015c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f19016d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f19017e;

    /* loaded from: classes5.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

    public f(PbFragment pbFragment, b.a.r0.k2.s.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19015c = null;
        this.f19016d = null;
        this.f19013a = pbFragment;
        this.f19014b = cVar;
        b();
    }

    public void a(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        this.f19015c.setVisibility(0);
        bdTypeListView.addHeaderView(this.f19015c);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f19015c == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f19013a.getContext()).inflate(b.a.r0.k2.j.new_pb_title, (ViewGroup) null);
            this.f19015c = relativeLayout;
            ImageView imageView = (ImageView) relativeLayout.findViewById(b.a.r0.k2.i.pb_thread_type_stamp_title_bottom_part);
            this.f19017e = imageView;
            imageView.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -q0.g());
            this.f19017e.setImageMatrix(matrix);
            TextView textView = (TextView) this.f19015c.findViewById(b.a.r0.k2.i.tv_pb_title);
            this.f19016d = textView;
            b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(textView);
            d2.z(b.a.r0.k2.g.T_X03);
            d2.w(b.a.r0.k2.g.M_T_X003);
            d2.v(b.a.r0.k2.f.CAM_X0105);
            d2.A(b.a.r0.k2.l.F_X02);
            d2.r(b.a.r0.k2.f.CAM_X0304);
            this.f19016d.setVisibility(8);
            if (this.f19016d.getParent() == null) {
                this.f19015c.addView(this.f19016d);
            }
            this.f19015c.setOnTouchListener(this.f19014b);
            this.f19015c.setOnLongClickListener(new a(this));
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f19015c, b.a.r0.k2.f.CAM_X0205);
            TextView textView = this.f19016d;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, b.a.r0.k2.f.CAM_X0105);
                this.f19016d.setLinkTextColor(SkinManager.getColor(b.a.r0.k2.f.CAM_X0304));
            }
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        this.f19015c.setVisibility(8);
        bdTypeListView.removeHeaderView(this.f19015c);
    }

    public void e(b.a.r0.k2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) || fVar == null || fVar.O() == null) {
            return;
        }
        SpannableStringBuilder g1 = fVar.O().g1();
        SpannableString c2 = q0.c(fVar.O());
        if (!StringUtils.isNull(fVar.O().getTitle())) {
            if (c2 != null) {
                g1.append((CharSequence) c2);
                this.f19016d.setText(g1, TextView.BufferType.SPANNABLE);
            } else {
                this.f19016d.setText(g1);
            }
            h(fVar);
            this.f19016d.setVisibility(0);
            this.f19016d.setMaxLines(3);
            this.f19016d.setEllipsize(TextUtils.TruncateAt.END);
            this.f19016d.invalidate();
            return;
        }
        this.f19016d.setVisibility(8);
    }

    public void f(b.a.r0.k2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            if (fVar != null && !fVar.O().E2() && this.f19016d.getText() != null && this.f19016d.getText().length() > 0) {
                this.f19016d.setVisibility(0);
            } else {
                this.f19016d.setVisibility(8);
            }
        }
    }

    public void g(b.a.r0.k2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) || fVar == null || fVar.O() == null) {
            return;
        }
        SpannableStringBuilder g1 = fVar.O().g1();
        this.f19016d.setOnTouchListener(new b.a.r0.c4.h(g1));
        this.f19016d.setText(g1);
        this.f19016d.setVisibility(0);
    }

    public void h(b.a.r0.k2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) || this.f19016d == null) {
            return;
        }
        int g2 = b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.tbds56);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f19016d.getLayoutParams();
        if (fVar.g0()) {
            g2 = 0;
        }
        layoutParams.bottomMargin = g2;
        this.f19016d.setLayoutParams(layoutParams);
    }
}
