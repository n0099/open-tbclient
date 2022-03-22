package c.a.p0.a1;

import android.app.Dialog;
import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class h extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public View f11963b;

    /* renamed from: c  reason: collision with root package name */
    public SpannableString f11964c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f11965d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f11966e;

    /* renamed from: f  reason: collision with root package name */
    public int f11967f;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                h hVar = this.a;
                c.a.d.f.m.g.b(hVar, hVar.a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(TbPageContext tbPageContext, int i) {
        super(tbPageContext.getContext(), i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
    }

    public final void b() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (tbPageContext = this.a) == null) {
            return;
        }
        tbPageContext.getLayoutMode().k(this.f11967f == 1);
        this.a.getLayoutMode().j(this.f11963b);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f11963b = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0286, (ViewGroup) null);
            this.f11967f = TbadkApplication.getInst().getSkinType();
            String string = getContext().getResources().getString(R.string.obfuscated_res_0x7f0f0f1e);
            this.f11964c = new SpannableString(string);
            this.f11964c.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.common_color_10159)), 5, string.length(), 33);
            setContentView(this.f11963b, new LinearLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702d2), getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702a4)));
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f091f0c);
            this.f11965d = textView;
            textView.setText(this.f11964c);
            TextView textView2 = (TextView) findViewById(R.id.obfuscated_res_0x7f0906ba);
            this.f11966e = textView2;
            textView2.setOnClickListener(new a(this));
            setCancelable(true);
            b();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f11963b = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0287, (ViewGroup) null);
            this.f11967f = TbadkApplication.getInst().getSkinType();
            setContentView(this.f11963b, new LinearLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702d2), getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07028c)));
            setCancelable(false);
            b();
        }
    }
}
