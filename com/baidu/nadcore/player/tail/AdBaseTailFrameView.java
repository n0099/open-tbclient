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
import c.a.a0.s.r;
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
/* loaded from: classes4.dex */
public abstract class AdBaseTailFrameView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdImageView a;

    /* renamed from: b  reason: collision with root package name */
    public AdImageView f27581b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f27582c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f27583d;

    /* renamed from: e  reason: collision with root package name */
    public AdProgressButton f27584e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f27585f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.a0.j.f.d f27586g;

    /* renamed from: h  reason: collision with root package name */
    public d f27587h;
    public e i;
    public View.OnClickListener j;
    public TextView k;
    public c l;

    /* loaded from: classes4.dex */
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.f27586g.p();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ r f27588b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AdBaseTailFrameView f27589c;

        public b(AdBaseTailFrameView adBaseTailFrameView, boolean z, r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adBaseTailFrameView, Boolean.valueOf(z), rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27589c = adBaseTailFrameView;
            this.a = z;
            this.f27588b = rVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Object tag = this.f27589c.getTag();
                if (tag instanceof r) {
                    r rVar = (r) tag;
                    if (!this.a) {
                        this.f27589c.c(this.f27588b, view);
                    } else if (!rVar.p) {
                        this.f27589c.c(this.f27588b, view);
                    } else {
                        this.f27589c.f27584e.performClick();
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a();
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(String str, String str2);
    }

    /* loaded from: classes4.dex */
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

    public final void b(r rVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, rVar) == null) || rVar == null) {
            return;
        }
        e eVar = this.i;
        if (eVar == null) {
            c.a.a0.a0.b.a.b(rVar.k);
        } else {
            eVar.a();
        }
    }

    public final void c(r rVar, View view) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rVar, view) == null) || TextUtils.isEmpty(rVar.f1564c)) {
            return;
        }
        String str2 = rVar.f1564c;
        if (R.id.obfuscated_res_0x7f0900fd == view.getId() && !TextUtils.isEmpty(rVar.f1565d) && !"__BTN_SCHEME__".equals(rVar.f1565d)) {
            str2 = rVar.f1565d;
        }
        c.a.a0.g.c.c(str2, getContext());
        int id = view.getId();
        if (id == R.id.obfuscated_res_0x7f0900fb) {
            str = ClogBuilder.Area.ICON.type;
        } else if (id == R.id.obfuscated_res_0x7f0900ff) {
            str = ClogBuilder.Area.NAME.type;
        } else if (id == R.id.obfuscated_res_0x7f0900fd) {
            str = ClogBuilder.Area.BUTTON.type;
        } else {
            str = ClogBuilder.Area.HOTAREA.type;
        }
        i(ClogBuilder.LogType.CLICK.type, str, rVar);
        b(rVar);
        j(view);
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
            this.a = (AdImageView) findViewById(R.id.obfuscated_res_0x7f090100);
            this.f27581b = (AdImageView) findViewById(R.id.obfuscated_res_0x7f0900fb);
            this.f27582c = (TextView) findViewById(R.id.obfuscated_res_0x7f0900ff);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f0900fd);
            this.f27583d = textView;
            c.a.a0.b0.a.b(textView, Font.F_F_X02);
            this.f27584e = (AdProgressButton) findViewById(R.id.obfuscated_res_0x7f0900fe);
            this.f27585f = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0900fc);
            this.k = (TextView) findViewById(R.id.obfuscated_res_0x7f092309);
            g();
        }
    }

    public abstract int f();

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public final void h(r rVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, rVar) == null) || rVar == null) {
            return;
        }
        d dVar = this.f27587h;
        if (dVar == null) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.s(ClogBuilder.LogType.FREE_SHOW).q(ClogBuilder.Page.AD_TAIL).n(rVar.l);
            c.a.a0.a0.a.b(clogBuilder);
            return;
        }
        dVar.a(ClogBuilder.LogType.FREE_SHOW.type, "");
    }

    public final void i(String str, String str2, r rVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, rVar) == null) || rVar == null) {
            return;
        }
        d dVar = this.f27587h;
        if (dVar == null) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.t(str).q(ClogBuilder.Page.AD_TAIL).h(str2).n(rVar.l);
            c.a.a0.a0.a.b(clogBuilder);
            return;
        }
        dVar.a(str, str2);
    }

    public final void j(View view) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) || (onClickListener = this.j) == null) {
            return;
        }
        onClickListener.onClick(view);
    }

    public boolean k(r rVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, rVar)) == null) {
            if (rVar != null && rVar.i()) {
                setVisibility(0);
                if (!TextUtils.isEmpty(rVar.j)) {
                    this.a.setImageURI(Uri.parse(rVar.j));
                }
                if (!TextUtils.isEmpty(rVar.f1563b)) {
                    this.f27581b.setVisibility(0);
                    this.f27581b.g(rVar.f1563b);
                } else {
                    this.f27581b.setVisibility(8);
                }
                if (!TextUtils.isEmpty(rVar.a)) {
                    this.f27582c.setVisibility(0);
                    ((UnifyTextView) this.f27582c).setTextWithUnifiedPadding(rVar.a, TextView.BufferType.NORMAL);
                } else {
                    this.f27582c.setVisibility(8);
                }
                boolean h2 = rVar.h();
                if (h2) {
                    this.f27583d.setVisibility(8);
                    c.a.a0.s.c cVar = rVar.m;
                    if (cVar != null && cVar.f1535e) {
                        this.f27584e.setVisibility(0);
                        if (!TextUtils.isEmpty(rVar.f1566e)) {
                            this.f27584e.setText(rVar.f1566e);
                        } else {
                            this.f27584e.setText(getResources().getString(R.string.obfuscated_res_0x7f0f0b4e));
                        }
                        c.a.a0.j.d.a c2 = c.a.a0.j.d.a.c(rVar.m, rVar.l, rVar.f1565d);
                        c2.f1248e = TextUtils.isEmpty(c2.f1247d);
                        this.f27586g = new c.a.a0.j.f.d(c2, this.f27584e);
                        this.f27584e.setOnClickListener(new a(this));
                    } else {
                        this.f27584e.setVisibility(8);
                        this.f27586g = null;
                    }
                } else {
                    if (this.f27586g != null) {
                        this.f27586g = null;
                    }
                    this.f27584e.setVisibility(8);
                    this.f27583d.setVisibility(0);
                    if (!TextUtils.isEmpty(rVar.f1566e)) {
                        this.f27583d.setText(rVar.f1566e);
                    } else {
                        this.f27583d.setText(getResources().getText(R.string.obfuscated_res_0x7f0f0b3f));
                    }
                }
                b bVar = new b(this, h2, rVar);
                this.f27581b.setOnClickListener(bVar);
                this.f27582c.setOnClickListener(bVar);
                this.f27583d.setOnClickListener(bVar);
                if (rVar.o) {
                    setOnClickListener(bVar);
                } else {
                    setOnClickListener(null);
                }
                h(rVar);
                setTag(rVar);
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
            this.f27587h = dVar;
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
