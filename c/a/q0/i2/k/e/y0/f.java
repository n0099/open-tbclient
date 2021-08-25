package c.a.q0.i2.k.e.y0;

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
import c.a.q0.i2.k.e.o0;
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
    public PbFragment f19715a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.q0.i2.i.c f19716b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f19717c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f19718d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f19719e;

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

    public f(PbFragment pbFragment, c.a.q0.i2.i.c cVar) {
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
        this.f19717c = null;
        this.f19718d = null;
        this.f19715a = pbFragment;
        this.f19716b = cVar;
        b();
    }

    public void a(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        this.f19717c.setVisibility(0);
        bdTypeListView.addHeaderView(this.f19717c);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f19717c == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f19715a.getContext()).inflate(R.layout.new_pb_title, (ViewGroup) null);
            this.f19717c = relativeLayout;
            ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.pb_thread_type_stamp_title_bottom_part);
            this.f19719e = imageView;
            imageView.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(0.0f, -o0.g());
            this.f19719e.setImageMatrix(matrix);
            TextView textView = (TextView) this.f19717c.findViewById(R.id.tv_pb_title);
            this.f19718d = textView;
            c.a.p0.s.u.c d2 = c.a.p0.s.u.c.d(textView);
            d2.y(R.dimen.T_X03);
            d2.v(R.dimen.M_T_X003);
            d2.u(R.color.CAM_X0105);
            d2.z(R.string.F_X02);
            d2.q(R.color.CAM_X0304);
            this.f19718d.setVisibility(8);
            if (this.f19718d.getParent() == null) {
                this.f19717c.addView(this.f19718d);
            }
            this.f19717c.setOnTouchListener(this.f19716b);
            this.f19717c.setOnLongClickListener(new a(this));
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f19717c, R.color.CAM_X0205);
            TextView textView = this.f19718d;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
                this.f19718d.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            }
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        this.f19717c.setVisibility(8);
        bdTypeListView.removeHeaderView(this.f19717c);
    }

    public void e(c.a.q0.i2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) || eVar == null || eVar.O() == null) {
            return;
        }
        SpannableStringBuilder e1 = eVar.O().e1();
        SpannableString c2 = o0.c(eVar.O());
        if (!StringUtils.isNull(eVar.O().getTitle())) {
            if (c2 != null) {
                e1.append((CharSequence) c2);
                this.f19718d.setText(e1, TextView.BufferType.SPANNABLE);
            } else {
                this.f19718d.setText(e1);
            }
            h(eVar);
            this.f19718d.setVisibility(0);
            this.f19718d.setMaxLines(3);
            this.f19718d.setEllipsize(TextUtils.TruncateAt.END);
            this.f19718d.invalidate();
            return;
        }
        this.f19718d.setVisibility(8);
    }

    public void f(c.a.q0.i2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) {
            if (eVar != null && !eVar.O().A2() && this.f19718d.getText() != null && this.f19718d.getText().length() > 0) {
                this.f19718d.setVisibility(0);
            } else {
                this.f19718d.setVisibility(8);
            }
        }
    }

    public void g(c.a.q0.i2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) || eVar == null || eVar.O() == null) {
            return;
        }
        SpannableStringBuilder e1 = eVar.O().e1();
        this.f19718d.setOnTouchListener(new c.a.q0.a4.h(e1));
        this.f19718d.setText(e1);
        this.f19718d.setVisibility(0);
    }

    public void h(c.a.q0.i2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) || this.f19718d == null) {
            return;
        }
        int g2 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds56);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f19718d.getLayoutParams();
        if (eVar.f0()) {
            g2 = 0;
        }
        layoutParams.bottomMargin = g2;
        this.f19718d.setLayoutParams(layoutParams);
    }
}
