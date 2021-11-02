package b.a.r0.x0;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import b.a.q0.s.s.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.BawuThrones;
/* loaded from: classes5.dex */
public class v {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.q0.s.s.a f26403a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f26404b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f26405c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f26406d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f26407e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f26408f;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ v f26409e;

        public a(v vVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26409e = vVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                v vVar = this.f26409e;
                vVar.f26408f = !vVar.f26408f;
                this.f26409e.h();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f26410e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f26411f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ v f26412g;

        public b(v vVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26412g = vVar;
            this.f26410e = str;
            this.f26411f = str2;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                b.a.q0.s.e0.b.j().t("key_frs_recommend_tip", !this.f26412g.f26408f);
                b.a.r0.x0.c.c().d(this.f26410e, this.f26411f);
                this.f26412g.f26403a.dismiss();
                this.f26412g.f26403a = null;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ v f26413e;

        public c(v vVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26413e = vVar;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f26413e.f26408f = false;
                this.f26413e.f26403a.dismiss();
                this.f26413e.f26403a = null;
            }
        }
    }

    public v() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TextView textView = this.f26404b;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
            }
            TextView textView2 = this.f26405c;
            if (textView2 != null) {
                SkinManager.setViewTextColor(textView2, R.color.CAM_X0107);
            }
            h();
            TextView textView3 = this.f26407e;
            if (textView3 != null) {
                SkinManager.setViewTextColor(textView3, R.color.CAM_X0107);
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f26403a = null;
            this.f26404b = null;
            this.f26405c = null;
            this.f26406d = null;
            this.f26407e = null;
        }
    }

    public final void h() {
        ImageView imageView;
        Drawable maskDrawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (imageView = this.f26406d) == null) {
            return;
        }
        if (this.f26408f) {
            maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.ic_icon_mask_use_complete16_svg, null);
        } else {
            maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.ic_icon_mask_use_check16_svg, null);
        }
        imageView.setImageDrawable(maskDrawable);
    }

    public void i(TbPageContext tbPageContext, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, tbPageContext, str, str2) == null) {
            b.a.q0.s.s.a aVar = this.f26403a;
            if (aVar == null || !aVar.isShowing()) {
                b.a.q0.s.s.a aVar2 = new b.a.q0.s.s.a(tbPageContext.getPageActivity());
                this.f26403a = aVar2;
                aVar2.setContentViewSize(1);
                this.f26403a.setNegativeTextColor(R.color.CAM_X0105);
                View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.title);
                this.f26404b = textView;
                textView.setText(R.string.frs_recommend_thread_sure_title);
                this.f26405c = (TextView) inflate.findViewById(R.id.call_fans_intro);
                BawuThrones b2 = b.a.r0.x0.c.c().b();
                if (b2 != null) {
                    TextView textView2 = this.f26405c;
                    String string = tbPageContext.getString(R.string.frs_recommend_thread_sure_content);
                    Integer num = b2.total_recommend_num;
                    textView2.setText(String.format(string, b2.bazhu_level, num, Integer.valueOf(num.intValue() - b2.used_recommend_num.intValue())));
                } else {
                    this.f26405c.setText(String.format(tbPageContext.getString(R.string.frs_recommend_thread_sure_content), "D", 2, 2));
                }
                this.f26406d = (ImageView) inflate.findViewById(R.id.checkbox);
                this.f26407e = (TextView) inflate.findViewById(R.id.no_tip_again_text);
                inflate.findViewById(R.id.no_tip_again_group).setOnClickListener(new a(this));
                f();
                this.f26403a.setContentView(inflate);
                this.f26403a.setPositiveButton(tbPageContext.getString(R.string.frs_recommend_thread_confirm), new b(this, str, str2));
                this.f26403a.setNegativeButton(tbPageContext.getString(R.string.next_time), new c(this));
                this.f26403a.create(tbPageContext).show();
            }
        }
    }
}
