package com.baidu.nadcore.player.tail;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.view.AdProgressButton;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.styles.Font;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.nadcore.widget.txt.UnifyTextView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ck0;
import com.repackage.ez0;
import com.repackage.fz0;
import com.repackage.ko0;
import com.repackage.mz0;
import com.repackage.rj0;
import com.repackage.th0;
import com.repackage.tn0;
/* loaded from: classes2.dex */
public abstract class AdBaseTailFrameView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdImageView a;
    public AdImageView b;
    public TextView c;
    public TextView d;
    public AdProgressButton e;
    public FrameLayout f;
    public ck0 g;
    public d h;
    public e i;
    public View.OnClickListener j;
    public TextView k;
    public c l;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseTailFrameView a;

        public a(AdBaseTailFrameView adBaseTailFrameView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adBaseTailFrameView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adBaseTailFrameView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.g.l();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ ko0 b;
        public final /* synthetic */ AdBaseTailFrameView c;

        public b(AdBaseTailFrameView adBaseTailFrameView, boolean z, ko0 ko0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adBaseTailFrameView, Boolean.valueOf(z), ko0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = adBaseTailFrameView;
            this.a = z;
            this.b = ko0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                Object tag = this.c.getTag();
                if (tag instanceof ko0) {
                    ko0 ko0Var = (ko0) tag;
                    if (!this.a) {
                        this.c.c(this.b, view2);
                    } else if (!ko0Var.p) {
                        this.c.c(this.b, view2);
                    } else {
                        this.c.e.performClick();
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a();
    }

    /* loaded from: classes2.dex */
    public interface d {
        void a(String str, String str2);
    }

    /* loaded from: classes2.dex */
    public interface e {
        void a();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdBaseTailFrameView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void b(ko0 ko0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, ko0Var) == null) || ko0Var == null) {
            return;
        }
        e eVar = this.i;
        if (eVar == null) {
            fz0.b(ko0Var.k);
        } else {
            eVar.a();
        }
    }

    public final void c(ko0 ko0Var, View view2) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ko0Var, view2) == null) || TextUtils.isEmpty(ko0Var.c)) {
            return;
        }
        String str2 = ko0Var.c;
        if (R.id.obfuscated_res_0x7f0900fb == view2.getId() && !TextUtils.isEmpty(ko0Var.d) && !"__BTN_SCHEME__".equals(ko0Var.d)) {
            str2 = ko0Var.d;
        }
        th0.c(str2, getContext());
        int id = view2.getId();
        if (id == R.id.obfuscated_res_0x7f0900f9) {
            str = ClogBuilder.Area.ICON.type;
        } else if (id == R.id.obfuscated_res_0x7f0900fd) {
            str = ClogBuilder.Area.NAME.type;
        } else if (id == R.id.obfuscated_res_0x7f0900fb) {
            str = ClogBuilder.Area.BUTTON.type;
        } else {
            str = ClogBuilder.Area.HOTAREA.type;
        }
        i(ClogBuilder.LogType.CLICK.type, str, ko0Var);
        b(ko0Var);
        j(view2);
        c cVar = this.l;
        if (cVar != null) {
            cVar.a();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setVisibility(8);
        }
    }

    public void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            LayoutInflater.from(context).inflate(f(), this);
            this.a = (AdImageView) findViewById(R.id.obfuscated_res_0x7f0900fe);
            this.b = (AdImageView) findViewById(R.id.obfuscated_res_0x7f0900f9);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f0900fd);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f0900fb);
            this.d = textView;
            mz0.b(textView, Font.F_F_X02);
            this.e = (AdProgressButton) findViewById(R.id.obfuscated_res_0x7f0900fc);
            this.f = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0900fa);
            this.k = (TextView) findViewById(R.id.obfuscated_res_0x7f092340);
            g();
        }
    }

    public abstract int f();

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public final void h(ko0 ko0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, ko0Var) == null) || ko0Var == null) {
            return;
        }
        d dVar = this.h;
        if (dVar == null) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.w(ClogBuilder.LogType.FREE_SHOW).s(ClogBuilder.Page.AD_TAIL).n(ko0Var.l);
            ez0.c(clogBuilder);
            return;
        }
        dVar.a(ClogBuilder.LogType.FREE_SHOW.type, "");
    }

    public final void i(String str, String str2, ko0 ko0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, ko0Var) == null) || ko0Var == null) {
            return;
        }
        d dVar = this.h;
        if (dVar == null) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.x(str).s(ClogBuilder.Page.AD_TAIL).h(str2).n(ko0Var.l);
            ez0.c(clogBuilder);
            return;
        }
        dVar.a(str, str2);
    }

    public final void j(View view2) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) || (onClickListener = this.j) == null) {
            return;
        }
        onClickListener.onClick(view2);
    }

    public boolean k(ko0 ko0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, ko0Var)) == null) {
            if (ko0Var != null && ko0Var.i()) {
                setVisibility(0);
                if (!TextUtils.isEmpty(ko0Var.j)) {
                    this.a.setImageURI(Uri.parse(ko0Var.j));
                }
                if (!TextUtils.isEmpty(ko0Var.b)) {
                    this.b.setVisibility(0);
                    this.b.n(ko0Var.b);
                } else {
                    this.b.setVisibility(8);
                }
                if (!TextUtils.isEmpty(ko0Var.a)) {
                    this.c.setVisibility(0);
                    ((UnifyTextView) this.c).setTextWithUnifiedPadding(ko0Var.a, TextView.BufferType.NORMAL);
                } else {
                    this.c.setVisibility(8);
                }
                boolean h = ko0Var.h();
                if (h) {
                    this.d.setVisibility(8);
                    tn0 tn0Var = ko0Var.m;
                    if (tn0Var != null && tn0Var.e) {
                        this.e.setVisibility(0);
                        if (!TextUtils.isEmpty(ko0Var.e)) {
                            this.e.setText(ko0Var.e);
                        } else {
                            this.e.setText(getResources().getString(R.string.obfuscated_res_0x7f0f0b63));
                        }
                        rj0 c2 = rj0.c(ko0Var.m, ko0Var.l, ko0Var.d);
                        c2.e = TextUtils.isEmpty(c2.d);
                        this.g = new ck0(c2, this.e);
                        this.e.setOnClickListener(new a(this));
                    } else {
                        this.e.setVisibility(8);
                        this.g = null;
                    }
                } else {
                    if (this.g != null) {
                        this.g = null;
                    }
                    this.e.setVisibility(8);
                    this.d.setVisibility(0);
                    if (!TextUtils.isEmpty(ko0Var.e)) {
                        this.d.setText(ko0Var.e);
                    } else {
                        this.d.setText(getResources().getText(R.string.obfuscated_res_0x7f0f0b54));
                    }
                }
                b bVar = new b(this, h, ko0Var);
                this.b.setOnClickListener(bVar);
                this.c.setOnClickListener(bVar);
                this.d.setOnClickListener(bVar);
                if (ko0Var.o) {
                    setOnClickListener(bVar);
                } else {
                    setOnClickListener(null);
                }
                h(ko0Var);
                setTag(ko0Var);
                return true;
            }
            setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setAdTailCloseListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            this.l = cVar;
        }
    }

    public void setAlsHandler(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, dVar) == null) {
            this.h = dVar;
        }
    }

    public void setOnChargeHandler(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, eVar) == null) {
            this.i = eVar;
        }
    }

    public void setOnJumpHandler(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onClickListener) == null) {
            this.j = onClickListener;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdBaseTailFrameView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdBaseTailFrameView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        e(context);
    }
}
