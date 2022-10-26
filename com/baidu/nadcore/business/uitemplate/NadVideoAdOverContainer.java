package com.baidu.nadcore.business.uitemplate;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.business.uitemplate.PortraitVideoTailView;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView;
import com.baidu.tieba.R;
import com.baidu.tieba.aj0;
import com.baidu.tieba.cm0;
import com.baidu.tieba.eh0;
import com.baidu.tieba.f81;
import com.baidu.tieba.gm0;
import com.baidu.tieba.i01;
import com.baidu.tieba.j81;
import com.baidu.tieba.ji0;
import com.baidu.tieba.m31;
import com.baidu.tieba.n31;
import com.baidu.tieba.u21;
import com.baidu.tieba.vo0;
import com.baidu.tieba.wh0;
import com.baidu.tieba.zo0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class NadVideoAdOverContainer extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final char[] x;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public AdImageView b;
    public TextView c;
    public LinearLayout d;
    public TextView e;
    public PortraitVideoTailView f;
    public RelativeLayout g;
    public View.OnClickListener h;
    public LinearLayout i;
    public f81 j;
    public FrameLayout k;
    public wh0 l;
    public f m;
    public boolean n;
    public View o;
    public LinearLayout p;
    public SimpleAdInfoView q;
    public boolean r;
    public TextView s;
    public m31 t;
    public Runnable u;
    public final Object v;
    public String w;

    /* loaded from: classes2.dex */
    public interface f {
        int a();

        int getPosition();
    }

    public final void t(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, adBaseModel) == null) {
        }
    }

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;
        public final /* synthetic */ String b;
        public final /* synthetic */ NadVideoAdOverContainer c;

        public a(NadVideoAdOverContainer nadVideoAdOverContainer, AdBaseModel adBaseModel, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadVideoAdOverContainer, adBaseModel, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = nadVideoAdOverContainer;
            this.a = adBaseModel;
            this.b = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.c.v()) {
                return;
            }
            AdBaseModel adBaseModel = this.a;
            zo0 zo0Var = adBaseModel.m;
            if (zo0Var != null && zo0Var.a == 0) {
                ji0.c(adBaseModel.f.c, this.c.getContext());
            }
            this.c.y(ClogBuilder.LogType.CLICK, this.b, this.a);
            if (this.c.h != null) {
                this.c.h.onClick(view2);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends m31.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadVideoAdOverContainer a;

        public b(NadVideoAdOverContainer nadVideoAdOverContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadVideoAdOverContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadVideoAdOverContainer;
        }

        @Override // com.baidu.tieba.m31.b
        public void f(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                this.a.A(Math.round((float) ((100000 - j) / 1000)));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadVideoAdOverContainer a;

        public c(NadVideoAdOverContainer nadVideoAdOverContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadVideoAdOverContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadVideoAdOverContainer;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.t.e();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;
        public final /* synthetic */ String b;
        public final /* synthetic */ NadVideoAdOverContainer c;

        public d(NadVideoAdOverContainer nadVideoAdOverContainer, AdBaseModel adBaseModel, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadVideoAdOverContainer, adBaseModel, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = nadVideoAdOverContainer;
            this.a = adBaseModel;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((LinearLayout.LayoutParams) this.c.e.getLayoutParams()).rightMargin = (int) this.c.getResources().getDimension(R.dimen.obfuscated_res_0x7f07054e);
                this.c.d.setBackgroundResource(0);
                this.c.d.setPadding(0, 0, 0, 0);
                this.c.e.setText(this.c.m(String.format("@%s", this.a.f.e), this.c.e.getPaint()));
                this.c.d.requestLayout();
                this.c.a.setText(this.c.l(this.b));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e extends gm0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel b;
        public final /* synthetic */ NadVideoAdOverContainer c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(NadVideoAdOverContainer nadVideoAdOverContainer, Class cls, AdBaseModel adBaseModel) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadVideoAdOverContainer, cls, adBaseModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = nadVideoAdOverContainer;
            this.b = adBaseModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gm0
        public void onEvent(eh0 eh0Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eh0Var) == null) && this.c.j != null && this.c.j.getRealView() != null && (this.c.j.getRealView() instanceof NadEnhanceButtonDownloadView)) {
                NadEnhanceButtonDownloadView nadEnhanceButtonDownloadView = (NadEnhanceButtonDownloadView) this.c.j.getRealView();
                vo0 vo0Var = eh0Var.a;
                if (vo0Var != null && vo0Var == this.b.l && nadEnhanceButtonDownloadView.getDownloadStatus() != AdDownloadStatus.DOWNLOADING) {
                    nadEnhanceButtonDownloadView.performClick();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1461217690, "Lcom/baidu/nadcore/business/uitemplate/NadVideoAdOverContainer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1461217690, "Lcom/baidu/nadcore/business/uitemplate/NadVideoAdOverContainer;");
                return;
            }
        }
        x = new char[]{21704};
        new String(x);
    }

    public boolean getHotAreaEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.n;
        }
        return invokeV.booleanValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            m31 m31Var = new m31(100000L, 1000L);
            m31Var.d(new b(this));
            this.t = m31Var;
            c cVar = new c(this);
            this.u = cVar;
            post(cVar);
        }
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.f.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NadVideoAdOverContainer(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.h = null;
        this.n = true;
        this.v = new Object();
        this.w = "";
        n(context);
    }

    public final void r(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, adBaseModel) == null) {
            this.a.setOnClickListener(s(adBaseModel, ClogBuilder.Area.TITTLE.type));
            TextView textView = this.c;
            if (textView != null) {
                textView.setOnClickListener(s(adBaseModel, ClogBuilder.Area.AVATAR.type));
            }
            AdImageView adImageView = this.b;
            if (adImageView != null) {
                adImageView.setOnClickListener(s(adBaseModel, ClogBuilder.Area.AVATAR.type));
            }
            this.e.setOnClickListener(s(adBaseModel, ClogBuilder.Area.NAME.type));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NadVideoAdOverContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.h = null;
        this.n = true;
        this.v = new Object();
        this.w = "";
        n(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NadVideoAdOverContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.h = null;
        this.n = true;
        this.v = new Object();
        this.w = "";
        n(context);
    }

    public void A(int i) {
        f81 f81Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && (f81Var = this.j) != null) {
            f81Var.update(i);
        }
    }

    public final void o(AdBaseModel adBaseModel) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, adBaseModel) == null) {
            View findViewById = findViewById(R.id.obfuscated_res_0x7f09160e);
            if (adBaseModel.d) {
                i = 0;
            } else {
                i = 8;
            }
            findViewById.setVisibility(i);
            q(adBaseModel);
            this.k.setVisibility(0);
            p();
        }
    }

    public void setAdOverInfoVisiblity(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            if (z) {
                this.g.setVisibility(0);
            } else {
                this.g.setVisibility(4);
            }
        }
    }

    public void setAlsLogPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.w = str;
        }
    }

    public void setFeedbackBtnVisibility(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            TextView textView = this.s;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            textView.setVisibility(i);
        }
    }

    public void setOnNewTailFrameReplayClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onClickListener) == null) {
            this.f.setOnReplayClickListener(onClickListener);
        }
    }

    public void setOnNewTailJumpHandler(PortraitVideoTailView.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, cVar) == null) {
            this.f.setOnTailJumpHandler(cVar);
        }
    }

    public void setOnUiClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) {
            this.h = onClickListener;
            PortraitVideoTailView portraitVideoTailView = this.f;
            if (portraitVideoTailView != null) {
                portraitVideoTailView.setOnAdClickListener(onClickListener);
            }
            wh0 wh0Var = this.l;
            if (wh0Var != null) {
                wh0Var.h(onClickListener);
            }
        }
    }

    public void setOverLayInfoVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            setAdInfoVisible(z);
        }
    }

    public void setPlayerProgressHandler(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, fVar) == null) {
            this.m = fVar;
        }
    }

    public final boolean u(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, adBaseModel)) == null) {
            if (adBaseModel != null && adBaseModel.f != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void w(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, adBaseModel) == null) {
            String str = adBaseModel.f.g;
            if (str == null) {
                str = "";
            }
            this.a.post(new d(this, adBaseModel, str));
        }
    }

    public final void x(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, adBaseModel) == null) {
            cm0.a().c(this.v, 1, new e(this, eh0.class, adBaseModel));
        }
    }

    public final View.OnClickListener s(AdBaseModel adBaseModel, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, adBaseModel, str)) == null) {
            return new a(this, adBaseModel, str);
        }
        return (View.OnClickListener) invokeLL.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || !(getTag() instanceof AdBaseModel)) {
            return;
        }
        AdBaseModel adBaseModel = (AdBaseModel) getTag();
        if (adBaseModel.f == null) {
            return;
        }
        if (this.b.getParent() instanceof View) {
            ((View) this.b.getParent()).setVisibility(0);
        }
        if (!TextUtils.isEmpty(adBaseModel.f.f)) {
            this.b.setVisibility(0);
            this.c.setVisibility(8);
            this.b.g(adBaseModel.f.f);
        } else if (!TextUtils.isEmpty(adBaseModel.f.e)) {
            this.b.setVisibility(8);
            this.c.setVisibility(0);
            this.c.setText(adBaseModel.f.e);
        } else {
            this.b.setVisibility(8);
            this.c.setVisibility(8);
        }
    }

    public final void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.n = z;
            this.a.setClickable(z);
            this.e.setClickable(z);
            this.q.setClickable(z);
            f81 f81Var = this.j;
            if (f81Var != null && f81Var.getRealView() != null) {
                ((View) this.j.getRealView()).setClickable(z);
            }
        }
    }

    public final SpannableStringBuilder l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (getResources() == null) {
                return new SpannableStringBuilder(str);
            }
            return j81.b(str, 2, this.a, getContext(), ContextCompat.getDrawable(getContext(), R.drawable.obfuscated_res_0x7f080e0e), (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f070530));
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public void setData(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, adBaseModel) == null) {
            if (!u(adBaseModel)) {
                setVisibility(8);
                return;
            }
            setTag(adBaseModel);
            setVisibility(0);
            o(adBaseModel);
            w(adBaseModel);
            j();
            r(adBaseModel);
            t(adBaseModel);
            x(adBaseModel);
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            Object tag = getTag();
            if (!(tag instanceof AdBaseModel)) {
                this.f.e();
                setAdOverInfoVisiblity(true);
                k(true);
            } else if (z) {
                this.f.j((AdBaseModel) tag);
                setAdOverInfoVisiblity(false);
                k(false);
            } else {
                this.f.e();
                setAdOverInfoVisiblity(true);
                k(true);
            }
        }
    }

    public final String m(String str, TextPaint textPaint) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, textPaint)) == null) {
            return n31.b(str, "", (int) (((int) (u21.c.e(getContext()) - getResources().getDimension(R.dimen.obfuscated_res_0x7f070536))) - getResources().getDimension(R.dimen.obfuscated_res_0x7f070532)), textPaint);
        }
        return (String) invokeLL.objValue;
    }

    public final void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0603, this);
            this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f091610);
            this.d = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0915c4);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f0915f5);
            this.f = (PortraitVideoTailView) findViewById(R.id.obfuscated_res_0x7f0900d9);
            this.g = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0900d7);
            this.i = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091607);
            this.k = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0900fb);
            this.o = findViewById(R.id.obfuscated_res_0x7f0915c7);
            this.p = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0915f9);
            this.q = (SimpleAdInfoView) findViewById(R.id.obfuscated_res_0x7f0915c0);
            this.s = (TextView) findViewById(R.id.obfuscated_res_0x7f0915c5);
            this.b = (AdImageView) findViewById(R.id.obfuscated_res_0x7f09008a);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f09008b);
        }
    }

    public final void q(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, adBaseModel) == null) {
            f81 f81Var = this.j;
            if (f81Var != null) {
                f81Var.a();
                this.k.setVisibility(8);
                this.j = null;
            }
            if (adBaseModel.m == null) {
                return;
            }
            View findViewById = findViewById(R.id.obfuscated_res_0x7f09160e);
            findViewById.setVisibility(0);
            this.k.setVisibility(0);
            if (this.k.getChildCount() > 0) {
                this.k.removeAllViews();
            }
            AdEnhanceButtonView adEnhanceButtonView = new AdEnhanceButtonView(aj0.b(), this.k, findViewById);
            this.j = adEnhanceButtonView;
            wh0 wh0Var = new wh0(adBaseModel, adEnhanceButtonView);
            this.l = wh0Var;
            wh0Var.h(this.h);
            this.j.setEnhanceBtnListener(this.l);
            this.j.setData(adBaseModel.m);
            this.j.setBtnIconNightModeEnable(false);
        }
    }

    public void setAdInfoVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            int i = 8;
            if (z) {
                this.o.setVisibility(0);
                if (this.j != null) {
                    this.k.setVisibility(0);
                }
                this.a.setVisibility(0);
                this.d.setVisibility(0);
                this.p.setVisibility(0);
                SimpleAdInfoView simpleAdInfoView = this.q;
                if (this.r) {
                    i = 0;
                }
                simpleAdInfoView.setVisibility(i);
                return;
            }
            this.o.setVisibility(4);
            if (this.j != null) {
                this.k.setVisibility(4);
            }
            this.a.setVisibility(4);
            this.d.setVisibility(4);
            this.p.setVisibility(4);
            SimpleAdInfoView simpleAdInfoView2 = this.q;
            if (this.r) {
                i = 4;
            }
            simpleAdInfoView2.setVisibility(i);
        }
    }

    public final void y(ClogBuilder.LogType logType, String str, AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048603, this, logType, str, adBaseModel) == null) && adBaseModel != null && !TextUtils.isEmpty(adBaseModel.f.d)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(logType);
            clogBuilder.j(str);
            clogBuilder.v(this.w);
            f fVar = this.m;
            if (fVar != null) {
                clogBuilder.k(String.valueOf(fVar.getPosition()));
                clogBuilder.l(String.valueOf(this.m.a()));
            }
            clogBuilder.p(adBaseModel.f.d);
            i01.b(clogBuilder);
        }
    }
}
