package c.a.o0.r.l0;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public Context f10624b;

    /* renamed from: c  reason: collision with root package name */
    public View f10625c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f10626d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f10627e;

    /* renamed from: f  reason: collision with root package name */
    public Toast f10628f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f10629g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f10630h;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f10628f == null) {
                return;
            }
            this.a.f10628f.cancel();
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3000L;
        this.f10624b = null;
        this.f10625c = null;
        this.f10626d = null;
        this.f10627e = null;
        this.f10630h = new a(this);
        this.f10624b = TbadkCoreApplication.getInst().getContext();
        this.f10629g = new Handler();
    }

    public void b(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, charSequence) == null) {
            View inflate = LayoutInflater.from(this.f10624b).inflate(R.layout.obfuscated_res_0x7f0d03d7, (ViewGroup) null);
            this.f10625c = inflate;
            this.f10626d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092022);
            this.f10627e = (ImageView) this.f10625c.findViewById(R.id.obfuscated_res_0x7f092018);
            this.f10625c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(n.f(this.f10624b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
            SkinManager.setViewTextColor(this.f10626d, (int) R.color.CAM_X0101);
            this.f10626d.setText(charSequence);
            this.f10627e.setImageResource(R.drawable.obfuscated_res_0x7f080a66);
            e(this.f10625c);
        }
    }

    public void c(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence) == null) {
            View inflate = LayoutInflater.from(this.f10624b).inflate(R.layout.obfuscated_res_0x7f0d03d7, (ViewGroup) null);
            this.f10625c = inflate;
            this.f10626d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092022);
            this.f10627e = (ImageView) this.f10625c.findViewById(R.id.obfuscated_res_0x7f092018);
            this.f10625c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(n.f(this.f10624b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
            SkinManager.setViewTextColor(this.f10626d, (int) R.color.CAM_X0101);
            this.f10626d.setText(charSequence);
            this.f10627e.setImageResource(R.drawable.obfuscated_res_0x7f080a67);
            e(this.f10625c);
        }
    }

    public void d(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            View inflate = LayoutInflater.from(this.f10624b).inflate(R.layout.obfuscated_res_0x7f0d03d7, (ViewGroup) null);
            this.f10625c = inflate;
            this.f10626d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092022);
            this.f10627e = (ImageView) this.f10625c.findViewById(R.id.obfuscated_res_0x7f092018);
            this.f10625c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(n.f(this.f10624b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
            SkinManager.setViewTextColor(this.f10626d, (int) R.color.CAM_X0101);
            this.f10626d.setText(i2);
            this.f10627e.setImageResource(i);
            e(this.f10625c);
        }
    }

    public void e(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            this.f10629g.removeCallbacks(this.f10630h);
            if (this.f10628f == null) {
                this.f10628f = new Toast(this.f10624b);
            }
            this.f10629g.postDelayed(this.f10630h, this.a);
            this.f10628f.setView(view);
            this.f10628f.setDuration(1);
            this.f10628f.setGravity(17, 0, 0);
            this.f10628f.show();
        }
    }
}
