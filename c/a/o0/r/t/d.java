package c.a.o0.r.t;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.dialog.CircleView1080;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class d extends AlertDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f11033b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f11034c;

    /* renamed from: d  reason: collision with root package name */
    public CircleView1080 f11035d;

    /* renamed from: e  reason: collision with root package name */
    public int f11036e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.a = str;
            TextView textView = this.f11034c;
            if (textView != null) {
                textView.setText(str);
            }
        }
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || i == this.f11036e) {
            return;
        }
        this.f11036e = i;
        TextView textView = this.f11033b;
        if (textView != null) {
            textView.setText(i + "%");
        }
        CircleView1080 circleView1080 = this.f11035d;
        if (circleView1080 != null) {
            circleView1080.setProgress(i);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.show();
            Window window = getWindow();
            if (window != null) {
                window.setContentView(R.layout.obfuscated_res_0x7f0d070c);
                View findViewById = findViewById(R.id.obfuscated_res_0x7f090aae);
                if (findViewById.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
                    layoutParams.topMargin = c.a.d.f.p.n.f(getContext(), R.dimen.tbds50);
                    findViewById.setLayoutParams(layoutParams);
                }
                TextView textView = (TextView) window.findViewById(R.id.obfuscated_res_0x7f091f49);
                this.f11034c = textView;
                if (textView.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f11034c.getLayoutParams();
                    layoutParams2.topMargin = c.a.d.f.p.n.f(getContext(), R.dimen.tbds35);
                    this.f11034c.setLayoutParams(layoutParams2);
                }
                if (!StringUtils.isNull(this.a)) {
                    this.f11034c.setText(this.a);
                }
                this.f11033b = (TextView) window.findViewById(R.id.obfuscated_res_0x7f091f4a);
                this.f11035d = (CircleView1080) window.findViewById(R.id.obfuscated_res_0x7f09064c);
            }
        }
    }
}
