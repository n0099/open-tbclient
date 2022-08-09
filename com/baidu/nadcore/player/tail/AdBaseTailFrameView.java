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
import com.repackage.bj0;
import com.repackage.hy0;
import com.repackage.iy0;
import com.repackage.ln0;
import com.repackage.mg0;
import com.repackage.oi0;
import com.repackage.py0;
import com.repackage.um0;
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
    public bj0 g;
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
                this.a.g.m();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ ln0 b;
        public final /* synthetic */ AdBaseTailFrameView c;

        public b(AdBaseTailFrameView adBaseTailFrameView, boolean z, ln0 ln0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adBaseTailFrameView, Boolean.valueOf(z), ln0Var};
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
            this.b = ln0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                Object tag = this.c.getTag();
                if (tag instanceof ln0) {
                    ln0 ln0Var = (ln0) tag;
                    if (!this.a) {
                        this.c.c(this.b, view2);
                    } else if (!ln0Var.p) {
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

    public final void b(ln0 ln0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, ln0Var) == null) || ln0Var == null) {
            return;
        }
        e eVar = this.i;
        if (eVar == null) {
            iy0.b(ln0Var.k);
        } else {
            eVar.a();
        }
    }

    public final void c(ln0 ln0Var, View view2) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ln0Var, view2) == null) || TextUtils.isEmpty(ln0Var.c)) {
            return;
        }
        String str2 = ln0Var.c;
        if (R.id.obfuscated_res_0x7f090100 == view2.getId() && !TextUtils.isEmpty(ln0Var.d) && !"__BTN_SCHEME__".equals(ln0Var.d)) {
            str2 = ln0Var.d;
        }
        mg0.c(str2, getContext());
        int id = view2.getId();
        if (id == R.id.obfuscated_res_0x7f0900fe) {
            str = ClogBuilder.Area.ICON.type;
        } else if (id == R.id.obfuscated_res_0x7f090102) {
            str = ClogBuilder.Area.NAME.type;
        } else if (id == R.id.obfuscated_res_0x7f090100) {
            str = ClogBuilder.Area.BUTTON.type;
        } else {
            str = ClogBuilder.Area.HOTAREA.type;
        }
        i(ClogBuilder.LogType.CLICK.type, str, ln0Var);
        b(ln0Var);
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
            this.a = (AdImageView) findViewById(R.id.obfuscated_res_0x7f090103);
            this.b = (AdImageView) findViewById(R.id.obfuscated_res_0x7f0900fe);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f090102);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f090100);
            this.d = textView;
            py0.b(textView, Font.F_F_X02);
            this.e = (AdProgressButton) findViewById(R.id.obfuscated_res_0x7f090101);
            this.f = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0900ff);
            this.k = (TextView) findViewById(R.id.obfuscated_res_0x7f09249c);
            g();
        }
    }

    public abstract int f();

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public final void h(ln0 ln0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, ln0Var) == null) || ln0Var == null) {
            return;
        }
        d dVar = this.h;
        if (dVar == null) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.FREE_SHOW).u(ClogBuilder.Page.AD_TAIL).p(ln0Var.l);
            hy0.b(clogBuilder);
            return;
        }
        dVar.a(ClogBuilder.LogType.FREE_SHOW.type, "");
    }

    public final void i(String str, String str2, ln0 ln0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, ln0Var) == null) || ln0Var == null) {
            return;
        }
        d dVar = this.h;
        if (dVar == null) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.z(str).u(ClogBuilder.Page.AD_TAIL).j(str2).p(ln0Var.l);
            hy0.b(clogBuilder);
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

    public boolean k(ln0 ln0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, ln0Var)) == null) {
            if (ln0Var != null && ln0Var.i()) {
                setVisibility(0);
                if (!TextUtils.isEmpty(ln0Var.j)) {
                    this.a.setImageURI(Uri.parse(ln0Var.j));
                }
                if (!TextUtils.isEmpty(ln0Var.b)) {
                    this.b.setVisibility(0);
                    this.b.g(ln0Var.b);
                } else {
                    this.b.setVisibility(8);
                }
                if (!TextUtils.isEmpty(ln0Var.a)) {
                    this.c.setVisibility(0);
                    ((UnifyTextView) this.c).setTextWithUnifiedPadding(ln0Var.a, TextView.BufferType.NORMAL);
                } else {
                    this.c.setVisibility(8);
                }
                boolean h = ln0Var.h();
                if (h) {
                    this.d.setVisibility(8);
                    um0 um0Var = ln0Var.m;
                    if (um0Var != null && um0Var.e) {
                        this.e.setVisibility(0);
                        if (!TextUtils.isEmpty(ln0Var.e)) {
                            this.e.setText(ln0Var.e);
                        } else {
                            this.e.setText(getResources().getString(R.string.obfuscated_res_0x7f0f0b6e));
                        }
                        oi0 d2 = oi0.d(ln0Var.m, ln0Var.l, ln0Var.d);
                        d2.e = TextUtils.isEmpty(d2.d);
                        this.g = new bj0(d2, this.e);
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
                    if (!TextUtils.isEmpty(ln0Var.e)) {
                        this.d.setText(ln0Var.e);
                    } else {
                        this.d.setText(getResources().getText(R.string.obfuscated_res_0x7f0f0b5e));
                    }
                }
                b bVar = new b(this, h, ln0Var);
                this.b.setOnClickListener(bVar);
                this.c.setOnClickListener(bVar);
                this.d.setOnClickListener(bVar);
                if (ln0Var.o) {
                    setOnClickListener(bVar);
                } else {
                    setOnClickListener(null);
                }
                h(ln0Var);
                setTag(ln0Var);
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
