package c.a.r0.j2.k.e.a1;

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
import c.a.r0.j2.k.e.q0;
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

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f19826a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.j2.i.c f19827b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f19828c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f19829d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f19830e;

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

    public f(PbFragment pbFragment, c.a.r0.j2.i.c cVar) {
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
        this.f19828c = null;
        this.f19829d = null;
        this.f19826a = pbFragment;
        this.f19827b = cVar;
        b();
    }

    public void a(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        this.f19828c.setVisibility(0);
        bdTypeListView.addHeaderView(this.f19828c);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f19828c == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f19826a.getContext()).inflate(R.layout.new_pb_title, (ViewGroup) null);
            this.f19828c = relativeLayout;
            ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.pb_thread_type_stamp_title_bottom_part);
            this.f19830e = imageView;
            imageView.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -q0.g());
            this.f19830e.setImageMatrix(matrix);
            TextView textView = (TextView) this.f19828c.findViewById(R.id.tv_pb_title);
            this.f19829d = textView;
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(textView);
            d2.A(R.dimen.T_X03);
            d2.x(R.dimen.M_T_X003);
            d2.w(R.color.CAM_X0105);
            d2.B(R.string.F_X02);
            d2.s(R.color.CAM_X0304);
            this.f19829d.setVisibility(8);
            if (this.f19829d.getParent() == null) {
                this.f19828c.addView(this.f19829d);
            }
            this.f19828c.setOnTouchListener(this.f19827b);
            this.f19828c.setOnLongClickListener(new a(this));
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f19828c, R.color.CAM_X0205);
            TextView textView = this.f19829d;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
                this.f19829d.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            }
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        this.f19828c.setVisibility(8);
        bdTypeListView.removeHeaderView(this.f19828c);
    }

    public void e(c.a.r0.j2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) || eVar == null || eVar.O() == null) {
            return;
        }
        SpannableStringBuilder g1 = eVar.O().g1();
        SpannableString c2 = q0.c(eVar.O());
        if (!StringUtils.isNull(eVar.O().getTitle())) {
            if (c2 != null) {
                g1.append((CharSequence) c2);
                this.f19829d.setText(g1, TextView.BufferType.SPANNABLE);
            } else {
                this.f19829d.setText(g1);
            }
            h(eVar);
            this.f19829d.setVisibility(0);
            this.f19829d.setMaxLines(3);
            this.f19829d.setEllipsize(TextUtils.TruncateAt.END);
            this.f19829d.invalidate();
            return;
        }
        this.f19829d.setVisibility(8);
    }

    public void f(c.a.r0.j2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) {
            if (eVar != null && !eVar.O().E2() && this.f19829d.getText() != null && this.f19829d.getText().length() > 0) {
                this.f19829d.setVisibility(0);
            } else {
                this.f19829d.setVisibility(8);
            }
        }
    }

    public void g(c.a.r0.j2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) || eVar == null || eVar.O() == null) {
            return;
        }
        SpannableStringBuilder g1 = eVar.O().g1();
        this.f19829d.setOnTouchListener(new c.a.r0.b4.h(g1));
        this.f19829d.setText(g1);
        this.f19829d.setVisibility(0);
    }

    public void h(c.a.r0.j2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) || this.f19829d == null) {
            return;
        }
        int g2 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds56);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f19829d.getLayoutParams();
        if (eVar.f0()) {
            g2 = 0;
        }
        layoutParams.bottomMargin = g2;
        this.f19829d.setLayoutParams(layoutParams);
    }
}
