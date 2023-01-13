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
import com.baidu.tieba.dl0;
import com.baidu.tieba.e11;
import com.baidu.tieba.f11;
import com.baidu.tieba.gq0;
import com.baidu.tieba.m11;
import com.baidu.tieba.ni0;
import com.baidu.tieba.pp0;
import com.baidu.tieba.qk0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public dl0 g;
    public d h;
    public e i;
    public View.OnClickListener j;
    public TextView k;
    public c l;

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

    public abstract int f();

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

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
        public final /* synthetic */ gq0 b;
        public final /* synthetic */ AdBaseTailFrameView c;

        public b(AdBaseTailFrameView adBaseTailFrameView, boolean z, gq0 gq0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adBaseTailFrameView, Boolean.valueOf(z), gq0Var};
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
            this.b = gq0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                Object tag = this.c.getTag();
                if (!(tag instanceof gq0)) {
                    return;
                }
                gq0 gq0Var = (gq0) tag;
                if (this.a) {
                    if (gq0Var.p) {
                        this.c.e.performClick();
                        return;
                    } else {
                        this.c.c(this.b, view2);
                        return;
                    }
                }
                this.c.c(this.b, view2);
            }
        }
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

    public final void h(gq0 gq0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, gq0Var) != null) || gq0Var == null) {
            return;
        }
        d dVar = this.h;
        if (dVar == null) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.FREE_SHOW).u(ClogBuilder.Page.AD_TAIL).p(gq0Var.l);
            e11.b(clogBuilder);
            return;
        }
        dVar.a(ClogBuilder.LogType.FREE_SHOW.type, "");
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

    public final void b(gq0 gq0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, gq0Var) != null) || gq0Var == null) {
            return;
        }
        e eVar = this.i;
        if (eVar == null) {
            f11.b(gq0Var.k);
        } else {
            eVar.a();
        }
    }

    public final void j(View view2) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) && (onClickListener = this.j) != null) {
            onClickListener.onClick(view2);
        }
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

    public final void c(gq0 gq0Var, View view2) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gq0Var, view2) != null) || TextUtils.isEmpty(gq0Var.c)) {
            return;
        }
        String str2 = gq0Var.c;
        if (R.id.ad_video_tail_frame_check_btn_txt == view2.getId() && !TextUtils.isEmpty(gq0Var.d) && !"__BTN_SCHEME__".equals(gq0Var.d)) {
            str2 = gq0Var.d;
        }
        ni0.c(str2, getContext());
        int id = view2.getId();
        if (id == R.id.ad_video_tail_frame_avatar) {
            str = ClogBuilder.Area.ICON.type;
        } else if (id == R.id.ad_video_tail_frame_name) {
            str = ClogBuilder.Area.NAME.type;
        } else if (id == R.id.ad_video_tail_frame_check_btn_txt) {
            str = ClogBuilder.Area.BUTTON.type;
        } else {
            str = ClogBuilder.Area.HOTAREA.type;
        }
        i(ClogBuilder.LogType.CLICK.type, str, gq0Var);
        b(gq0Var);
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
            this.a = (AdImageView) findViewById(R.id.ad_video_tail_frame_video_cover);
            this.b = (AdImageView) findViewById(R.id.ad_video_tail_frame_avatar);
            this.c = (TextView) findViewById(R.id.ad_video_tail_frame_name);
            TextView textView = (TextView) findViewById(R.id.ad_video_tail_frame_check_btn_txt);
            this.d = textView;
            m11.b(textView, Font.F_F_X02);
            this.e = (AdProgressButton) findViewById(R.id.ad_video_tail_frame_download_btn_txt);
            this.f = (FrameLayout) findViewById(R.id.ad_video_tail_frame_btn_container);
            this.k = (TextView) findViewById(R.id.video_ad_suffix_close_divider);
            g();
        }
    }

    public final void i(String str, String str2, gq0 gq0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048583, this, str, str2, gq0Var) != null) || gq0Var == null) {
            return;
        }
        d dVar = this.h;
        if (dVar == null) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.z(str).u(ClogBuilder.Page.AD_TAIL).j(str2).p(gq0Var.l);
            e11.b(clogBuilder);
            return;
        }
        dVar.a(str, str2);
    }

    public boolean k(gq0 gq0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, gq0Var)) == null) {
            if (gq0Var != null && gq0Var.i()) {
                setVisibility(0);
                if (!TextUtils.isEmpty(gq0Var.j)) {
                    this.a.setImageURI(Uri.parse(gq0Var.j));
                }
                if (!TextUtils.isEmpty(gq0Var.b)) {
                    this.b.setVisibility(0);
                    this.b.g(gq0Var.b);
                } else {
                    this.b.setVisibility(8);
                }
                if (!TextUtils.isEmpty(gq0Var.a)) {
                    this.c.setVisibility(0);
                    ((UnifyTextView) this.c).setTextWithUnifiedPadding(gq0Var.a, TextView.BufferType.NORMAL);
                } else {
                    this.c.setVisibility(8);
                }
                boolean h = gq0Var.h();
                if (h) {
                    this.d.setVisibility(8);
                    pp0 pp0Var = gq0Var.m;
                    if (pp0Var != null && pp0Var.e) {
                        this.e.setVisibility(0);
                        if (!TextUtils.isEmpty(gq0Var.e)) {
                            this.e.setText(gq0Var.e);
                        } else {
                            this.e.setText(getResources().getString(R.string.nad_button_download));
                        }
                        qk0 d2 = qk0.d(gq0Var.m, gq0Var.l, gq0Var.d);
                        d2.e = TextUtils.isEmpty(d2.d);
                        this.g = new dl0(d2, this.e);
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
                    if (!TextUtils.isEmpty(gq0Var.e)) {
                        this.d.setText(gq0Var.e);
                    } else {
                        this.d.setText(getResources().getText(R.string.nad_ad_video_check_btn_txt));
                    }
                }
                b bVar = new b(this, h, gq0Var);
                this.b.setOnClickListener(bVar);
                this.c.setOnClickListener(bVar);
                this.d.setOnClickListener(bVar);
                if (gq0Var.o) {
                    setOnClickListener(bVar);
                } else {
                    setOnClickListener(null);
                }
                h(gq0Var);
                setTag(gq0Var);
                return true;
            }
            setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }
}
