package c.a.s0.s2.u.f.b1;

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
import c.a.d.f.p.m;
import c.a.s0.s2.u.f.r0;
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
/* loaded from: classes8.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbFragment a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.s0.s2.s.c f22801b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f22802c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f22803d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f22804e;

    /* loaded from: classes8.dex */
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

    public f(PbFragment pbFragment, c.a.s0.s2.s.c cVar) {
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
        this.f22802c = null;
        this.f22803d = null;
        this.a = pbFragment;
        this.f22801b = cVar;
        b();
    }

    public void a(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        this.f22802c.setVisibility(0);
        bdTypeListView.addHeaderView(this.f22802c);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f22802c == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.a.getContext()).inflate(c.a.s0.s2.j.new_pb_title, (ViewGroup) null);
            this.f22802c = relativeLayout;
            ImageView imageView = (ImageView) relativeLayout.findViewById(c.a.s0.s2.i.pb_thread_type_stamp_title_bottom_part);
            this.f22804e = imageView;
            imageView.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -r0.g());
            this.f22804e.setImageMatrix(matrix);
            TextView textView = (TextView) this.f22802c.findViewById(c.a.s0.s2.i.tv_pb_title);
            this.f22803d = textView;
            c.a.r0.s.v.c d2 = c.a.r0.s.v.c.d(textView);
            d2.z(c.a.s0.s2.g.T_X03);
            d2.w(c.a.s0.s2.g.M_T_X003);
            d2.v(c.a.s0.s2.f.CAM_X0105);
            d2.A(c.a.s0.s2.l.F_X02);
            d2.r(c.a.s0.s2.f.CAM_X0304);
            this.f22803d.setVisibility(8);
            if (this.f22803d.getParent() == null) {
                this.f22802c.addView(this.f22803d);
            }
            this.f22802c.setOnTouchListener(this.f22801b);
            this.f22802c.setOnLongClickListener(new a(this));
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f22802c, c.a.s0.s2.f.CAM_X0205);
            TextView textView = this.f22803d;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, c.a.s0.s2.f.CAM_X0105);
                this.f22803d.setLinkTextColor(SkinManager.getColor(c.a.s0.s2.f.CAM_X0304));
            }
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        this.f22802c.setVisibility(8);
        bdTypeListView.removeHeaderView(this.f22802c);
    }

    public void e(c.a.s0.s2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) || fVar == null || fVar.O() == null) {
            return;
        }
        SpannableStringBuilder i1 = fVar.O().i1();
        SpannableString c2 = r0.c(fVar.O());
        if (!StringUtils.isNull(fVar.O().getTitle())) {
            if (c2 != null) {
                i1.append((CharSequence) c2);
                this.f22803d.setText(i1, TextView.BufferType.SPANNABLE);
            } else {
                this.f22803d.setText(i1);
            }
            h(fVar);
            this.f22803d.setVisibility(0);
            this.f22803d.setMaxLines(3);
            this.f22803d.setEllipsize(TextUtils.TruncateAt.END);
            this.f22803d.invalidate();
            return;
        }
        this.f22803d.setVisibility(8);
    }

    public void f(c.a.s0.s2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            if (fVar != null && !fVar.O().H2() && this.f22803d.getText() != null && this.f22803d.getText().length() > 0) {
                this.f22803d.setVisibility(0);
            } else {
                this.f22803d.setVisibility(8);
            }
        }
    }

    public void g(c.a.s0.s2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) || fVar == null || fVar.O() == null) {
            return;
        }
        SpannableStringBuilder i1 = fVar.O().i1();
        this.f22803d.setOnTouchListener(new c.a.s0.m4.h(i1));
        this.f22803d.setText(i1);
        this.f22803d.setVisibility(0);
    }

    public void h(c.a.s0.s2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) || this.f22803d == null) {
            return;
        }
        int f2 = m.f(TbadkCoreApplication.getInst(), c.a.s0.s2.g.tbds56);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f22803d.getLayoutParams();
        if (fVar.g0()) {
            f2 = 0;
        }
        layoutParams.bottomMargin = f2;
        this.f22803d.setLayoutParams(layoutParams);
    }
}
