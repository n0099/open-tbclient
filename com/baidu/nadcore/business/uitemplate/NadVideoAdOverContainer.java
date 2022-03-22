package com.baidu.nadcore.business.uitemplate;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.a0.h0.f;
import c.a.a0.s.t;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.business.uitemplate.PortraitVideoTailView;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class NadVideoAdOverContainer extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final char[] s;
    public static final String t;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f27472b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f27473c;

    /* renamed from: d  reason: collision with root package name */
    public PortraitVideoTailView f27474d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f27475e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f27476f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f27477g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f27478h;
    public c.a.a0.l0.u.b<View> i;
    public FrameLayout j;
    public c.a.a0.d.h.a k;
    public d l;
    public boolean m;
    public View n;
    public LinearLayout o;
    public SimpleAdInfoView p;
    public boolean q;
    public TextView r;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ NadVideoAdOverContainer f27479b;

        public a(NadVideoAdOverContainer nadVideoAdOverContainer, AdBaseModel adBaseModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadVideoAdOverContainer, adBaseModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27479b = nadVideoAdOverContainer;
            this.a = adBaseModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f27479b.s()) {
                return;
            }
            c.a.a0.g.c.c(this.a.f27543f.f1548c, this.f27479b.getContext());
            this.f27479b.u(ClogBuilder.LogType.CLICK, "hot", this.a);
            if (this.f27479b.f27476f != null) {
                this.f27479b.f27476f.onClick(view);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements SimpleAdInfoView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ NadVideoAdOverContainer f27480b;

        public b(NadVideoAdOverContainer nadVideoAdOverContainer, AdBaseModel adBaseModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadVideoAdOverContainer, adBaseModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27480b = nadVideoAdOverContainer;
            this.a = adBaseModel;
        }

        @Override // com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f27480b.u(ClogBuilder.LogType.FREE_CLICK, str, this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f27481b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ NadVideoAdOverContainer f27482c;

        public c(NadVideoAdOverContainer nadVideoAdOverContainer, AdBaseModel adBaseModel, String str) {
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
            this.f27482c = nadVideoAdOverContainer;
            this.a = adBaseModel;
            this.f27481b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((LinearLayout.LayoutParams) this.f27482c.f27473c.getLayoutParams()).rightMargin = (int) this.f27482c.getResources().getDimension(R.dimen.obfuscated_res_0x7f0704eb);
                this.f27482c.f27472b.setBackgroundResource(0);
                this.f27482c.f27472b.setPadding(0, 0, 0, 0);
                this.f27482c.f27473c.setText(this.f27482c.k(String.format("@%s", this.a.f27543f.f1550e), this.f27482c.f27473c.getPaint()));
                this.f27482c.f27472b.requestLayout();
                this.f27482c.a.setText(this.f27482c.j(this.f27481b));
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        int a();

        int getPosition();
    }

    /* loaded from: classes4.dex */
    public static class e extends ImageSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Drawable drawable) {
            super(drawable);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {drawable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Drawable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f2, int i3, int i4, int i5, Paint paint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{canvas, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), paint}) == null) {
                Drawable drawable = getDrawable();
                canvas.save();
                canvas.translate(f2, (((i5 - i3) - drawable.getBounds().bottom) / 2) + i3);
                drawable.draw(canvas);
                canvas.restore();
            }
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{paint, charSequence, Integer.valueOf(i), Integer.valueOf(i2), fontMetricsInt})) == null) {
                Rect bounds = getDrawable().getBounds();
                if (fontMetricsInt != null) {
                    Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
                    int i3 = fontMetricsInt2.bottom - fontMetricsInt2.top;
                    int i4 = (bounds.bottom - bounds.top) / 2;
                    int i5 = i3 / 4;
                    int i6 = i4 - i5;
                    int i7 = -(i4 + i5);
                    fontMetricsInt.ascent = i7;
                    fontMetricsInt.top = i7;
                    fontMetricsInt.bottom = i6;
                    fontMetricsInt.descent = i6;
                }
                int i8 = bounds.right;
                this.a = i8;
                return i8;
            }
            return invokeCommon.intValue;
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
        s = new char[]{21704};
        t = new String(s);
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
        this.f27476f = null;
        this.m = true;
        l(context);
    }

    public static boolean h(t tVar) {
        InterceptResult invokeL;
        t.b bVar;
        t.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, tVar)) == null) {
            if (tVar == null) {
                return false;
            }
            return (TextUtils.isEmpty(tVar.f1590f) && TextUtils.isEmpty(tVar.f1588d) && ((bVar = tVar.f1591g) == null || TextUtils.isEmpty(bVar.a)) && ((aVar = tVar.f1592h) == null || TextUtils.isEmpty(aVar.a))) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public boolean getHotAreaEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.m : invokeV.booleanValue;
    }

    public final void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.m = z;
            this.a.setClickable(z);
            this.f27473c.setClickable(z);
            this.p.setClickable(z);
            c.a.a0.l0.u.b<View> bVar = this.i;
            if (bVar == null || bVar.getRealView() == null) {
                return;
            }
            this.i.getRealView().setClickable(z);
        }
    }

    public final SpannableStringBuilder j(String str) {
        InterceptResult invokeL;
        float e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.obfuscated_res_0x7f080dd3);
            if (drawable == null) {
                return spannableStringBuilder;
            }
            if (this.a.getMeasuredWidth() > 0) {
                e2 = (this.a.getMeasuredWidth() * 4) - drawable.getIntrinsicWidth();
            } else {
                e2 = ((f.c.e(getContext()) - getResources().getDimension(R.dimen.obfuscated_res_0x7f0704ca)) * 4.0f) - drawable.getIntrinsicWidth();
            }
            float dimension = e2 - (getResources().getDimension(R.dimen.obfuscated_res_0x7f0704cb) * 3.0f);
            int length = str.length() + 1;
            spannableStringBuilder.append((CharSequence) " ").append((CharSequence) t);
            if (dimension < this.a.getPaint().measureText(spannableStringBuilder.toString())) {
                String b2 = c.a.a0.d.i.a.b(spannableStringBuilder.toString(), t, dimension, this.a.getPaint(), drawable.getIntrinsicWidth());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(b2);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                spannableStringBuilder2.setSpan(new e(drawable), b2.length() - t.length(), b2.length(), 17);
                return spannableStringBuilder2;
            }
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            spannableStringBuilder.setSpan(new e(drawable), length, spannableStringBuilder.length(), 17);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public final String k(@Nullable String str, @Nullable TextPaint textPaint) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, textPaint)) == null) ? c.a.a0.h0.t.b(str, "", (int) (((int) (f.c.e(getContext()) - getResources().getDimension(R.dimen.obfuscated_res_0x7f0704d1))) - getResources().getDimension(R.dimen.obfuscated_res_0x7f0704cc)), textPaint) : (String) invokeLL.objValue;
    }

    public final void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d05be, this);
            this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f0914e7);
            this.f27472b = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0914a1);
            this.f27473c = (TextView) findViewById(R.id.obfuscated_res_0x7f0914ce);
            this.f27474d = (PortraitVideoTailView) findViewById(R.id.obfuscated_res_0x7f0900d5);
            this.f27475e = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0900d3);
            this.f27478h = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0914df);
            this.j = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0900f6);
            this.n = findViewById(R.id.obfuscated_res_0x7f0914a4);
            this.o = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0914d2);
            this.p = (SimpleAdInfoView) findViewById(R.id.obfuscated_res_0x7f09149d);
            this.r = (TextView) findViewById(R.id.obfuscated_res_0x7f0914a2);
        }
    }

    public final void m(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, adBaseModel) == null) || adBaseModel == null) {
            return;
        }
        t tVar = adBaseModel.i;
        if (!h(tVar)) {
            this.q = false;
            this.p.setVisibility(8);
            this.f27474d.setAdInfo(null);
            return;
        }
        this.q = true;
        this.p.setVisibility(0);
        this.p.setAdInfo(tVar);
        this.p.setAfterListener(new b(this, adBaseModel));
        this.f27474d.setAdInfo(tVar);
    }

    public final void n(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, adBaseModel) == null) {
            View findViewById = findViewById(R.id.obfuscated_res_0x7f0914e5);
            if (!adBaseModel.f27541d) {
                findViewById.setVisibility(8);
                return;
            }
            o(adBaseModel);
            this.j.setVisibility(0);
            findViewById.setVisibility(0);
        }
    }

    public final void o(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, adBaseModel) == null) {
            c.a.a0.l0.u.b<View> bVar = this.i;
            if (bVar != null) {
                bVar.a();
                this.j.setVisibility(8);
                this.i = null;
            }
            if (adBaseModel.m == null) {
                return;
            }
            View findViewById = findViewById(R.id.obfuscated_res_0x7f0914e5);
            findViewById.setVisibility(0);
            this.j.setVisibility(0);
            if (this.j.getChildCount() > 0) {
                this.j.removeAllViews();
            }
            AdEnhanceButtonView adEnhanceButtonView = new AdEnhanceButtonView(c.a.a0.h.a.b(), this.j, findViewById);
            this.i = adEnhanceButtonView;
            c.a.a0.d.h.a aVar = new c.a.a0.d.h.a(adBaseModel, adEnhanceButtonView);
            this.k = aVar;
            aVar.h(this.f27476f);
            this.i.setEnhanceBtnListener(this.k);
            this.i.setData(adBaseModel.m);
            this.i.setBtnIconNightModeEnable(false);
        }
    }

    public final void p(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, adBaseModel) == null) {
            a aVar = new a(this, adBaseModel);
            this.f27477g = aVar;
            this.a.setOnClickListener(aVar);
            this.f27473c.setOnClickListener(this.f27477g);
            this.p.setOnClickListener(this.f27477g);
        }
    }

    public final void q(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, adBaseModel) == null) {
        }
    }

    public final boolean r(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, adBaseModel)) == null) ? (adBaseModel == null || adBaseModel.f27543f == null) ? false : true : invokeL.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f27474d.getVisibility() == 0 : invokeV.booleanValue;
    }

    public void setAdInfoVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (z) {
                this.n.setVisibility(0);
                if (this.i != null) {
                    this.j.setVisibility(0);
                }
                this.a.setVisibility(0);
                this.f27472b.setVisibility(0);
                this.o.setVisibility(0);
                this.p.setVisibility(this.q ? 0 : 8);
                return;
            }
            this.n.setVisibility(4);
            if (this.i != null) {
                this.j.setVisibility(4);
            }
            this.a.setVisibility(4);
            this.f27472b.setVisibility(4);
            this.o.setVisibility(4);
            this.p.setVisibility(this.q ? 4 : 8);
        }
    }

    public void setAdOverInfoVisiblity(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            if (z) {
                this.f27475e.setVisibility(0);
            } else {
                this.f27475e.setVisibility(4);
            }
        }
    }

    public void setData(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, adBaseModel) == null) {
            if (!r(adBaseModel)) {
                setVisibility(8);
                return;
            }
            setTag(adBaseModel);
            setVisibility(0);
            n(adBaseModel);
            t(adBaseModel);
            m(adBaseModel);
            p(adBaseModel);
            q(adBaseModel);
        }
    }

    public void setFeedbackBtnVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.r.setVisibility(z ? 0 : 8);
        }
    }

    public void setOnNewTailFrameReplayClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            this.f27474d.setOnReplayClickListener(onClickListener);
        }
    }

    public void setOnNewTailJumpHandler(PortraitVideoTailView.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, cVar) == null) {
            this.f27474d.setOnTailJumpHandler(cVar);
        }
    }

    public void setOnUiClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) {
            this.f27476f = onClickListener;
            PortraitVideoTailView portraitVideoTailView = this.f27474d;
            if (portraitVideoTailView != null) {
                portraitVideoTailView.setOnAdClickListener(onClickListener);
            }
            c.a.a0.d.h.a aVar = this.k;
            if (aVar != null) {
                aVar.h(onClickListener);
            }
        }
    }

    public void setOverLayInfoVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            setAdInfoVisible(z);
        }
    }

    public void setPlayerProgressHandler(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, dVar) == null) {
            this.l = dVar;
        }
    }

    public final void t(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, adBaseModel) == null) {
            String str = adBaseModel.f27543f.f1552g;
            if (str == null) {
                str = "";
            }
            this.a.post(new c(this, adBaseModel, str));
        }
    }

    public final void u(ClogBuilder.LogType logType, String str, AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048598, this, logType, str, adBaseModel) == null) || adBaseModel == null || TextUtils.isEmpty(adBaseModel.f27543f.f1549d)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.s(logType);
        clogBuilder.h(str);
        d dVar = this.l;
        if (dVar != null) {
            clogBuilder.i(String.valueOf(dVar.getPosition()));
            clogBuilder.j(String.valueOf(this.l.a()));
        }
        clogBuilder.n(adBaseModel.f27543f.f1549d);
        c.a.a0.a0.a.b(clogBuilder);
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            Object tag = getTag();
            if (!(tag instanceof AdBaseModel)) {
                this.f27474d.e();
                setAdOverInfoVisiblity(true);
                i(true);
            } else if (z) {
                this.f27474d.j((AdBaseModel) tag);
                setAdOverInfoVisiblity(false);
                i(false);
            } else {
                this.f27474d.e();
                setAdOverInfoVisiblity(true);
                i(true);
            }
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
        this.f27476f = null;
        this.m = true;
        l(context);
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
        this.f27476f = null;
        this.m = true;
        l(context);
    }
}
