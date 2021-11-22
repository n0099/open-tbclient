package b.a.r0.k2.u.f.b1;

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
import b.a.r0.k2.u.f.r0;
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
    public PbFragment f20592a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.r0.k2.s.c f20593b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f20594c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f20595d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f20596e;

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
        this.f20594c = null;
        this.f20595d = null;
        this.f20592a = pbFragment;
        this.f20593b = cVar;
        b();
    }

    public void a(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        this.f20594c.setVisibility(0);
        bdTypeListView.addHeaderView(this.f20594c);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f20594c == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f20592a.getContext()).inflate(b.a.r0.k2.j.new_pb_title, (ViewGroup) null);
            this.f20594c = relativeLayout;
            ImageView imageView = (ImageView) relativeLayout.findViewById(b.a.r0.k2.i.pb_thread_type_stamp_title_bottom_part);
            this.f20596e = imageView;
            imageView.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -r0.g());
            this.f20596e.setImageMatrix(matrix);
            TextView textView = (TextView) this.f20594c.findViewById(b.a.r0.k2.i.tv_pb_title);
            this.f20595d = textView;
            b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(textView);
            d2.z(b.a.r0.k2.g.T_X03);
            d2.w(b.a.r0.k2.g.M_T_X003);
            d2.v(b.a.r0.k2.f.CAM_X0105);
            d2.A(b.a.r0.k2.l.F_X02);
            d2.r(b.a.r0.k2.f.CAM_X0304);
            this.f20595d.setVisibility(8);
            if (this.f20595d.getParent() == null) {
                this.f20594c.addView(this.f20595d);
            }
            this.f20594c.setOnTouchListener(this.f20593b);
            this.f20594c.setOnLongClickListener(new a(this));
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f20594c, b.a.r0.k2.f.CAM_X0205);
            TextView textView = this.f20595d;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, b.a.r0.k2.f.CAM_X0105);
                this.f20595d.setLinkTextColor(SkinManager.getColor(b.a.r0.k2.f.CAM_X0304));
            }
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        this.f20594c.setVisibility(8);
        bdTypeListView.removeHeaderView(this.f20594c);
    }

    public void e(b.a.r0.k2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) || fVar == null || fVar.O() == null) {
            return;
        }
        SpannableStringBuilder h1 = fVar.O().h1();
        SpannableString c2 = r0.c(fVar.O());
        if (!StringUtils.isNull(fVar.O().getTitle())) {
            if (c2 != null) {
                h1.append((CharSequence) c2);
                this.f20595d.setText(h1, TextView.BufferType.SPANNABLE);
            } else {
                this.f20595d.setText(h1);
            }
            h(fVar);
            this.f20595d.setVisibility(0);
            this.f20595d.setMaxLines(3);
            this.f20595d.setEllipsize(TextUtils.TruncateAt.END);
            this.f20595d.invalidate();
            return;
        }
        this.f20595d.setVisibility(8);
    }

    public void f(b.a.r0.k2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            if (fVar != null && !fVar.O().G2() && this.f20595d.getText() != null && this.f20595d.getText().length() > 0) {
                this.f20595d.setVisibility(0);
            } else {
                this.f20595d.setVisibility(8);
            }
        }
    }

    public void g(b.a.r0.k2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) || fVar == null || fVar.O() == null) {
            return;
        }
        SpannableStringBuilder h1 = fVar.O().h1();
        this.f20595d.setOnTouchListener(new b.a.r0.d4.h(h1));
        this.f20595d.setText(h1);
        this.f20595d.setVisibility(0);
    }

    public void h(b.a.r0.k2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) || this.f20595d == null) {
            return;
        }
        int g2 = b.a.e.f.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.tbds56);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f20595d.getLayoutParams();
        if (fVar.g0()) {
            g2 = 0;
        }
        layoutParams.bottomMargin = g2;
        this.f20595d.setLayoutParams(layoutParams);
    }
}
