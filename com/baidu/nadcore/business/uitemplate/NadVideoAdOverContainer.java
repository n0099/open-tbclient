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
import com.repackage.dg0;
import com.repackage.eg0;
import com.repackage.g11;
import com.repackage.hh0;
import com.repackage.i51;
import com.repackage.iy0;
import com.repackage.q01;
import com.repackage.qg0;
import com.repackage.qn0;
/* loaded from: classes2.dex */
public class NadVideoAdOverContainer extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final char[] s;
    public static final String t;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public LinearLayout b;
    public TextView c;
    public PortraitVideoTailView d;
    public RelativeLayout e;
    public View.OnClickListener f;
    public View.OnClickListener g;
    public LinearLayout h;
    public i51<View> i;
    public FrameLayout j;
    public dg0 k;
    public d l;
    public boolean m;
    public View n;
    public LinearLayout o;
    public SimpleAdInfoView p;
    public boolean q;
    public TextView r;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;
        public final /* synthetic */ NadVideoAdOverContainer b;

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
            this.b = nadVideoAdOverContainer;
            this.a = adBaseModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.b.s()) {
                return;
            }
            qg0.c(this.a.f.c, this.b.getContext());
            this.b.u(ClogBuilder.LogType.CLICK, "hot", this.a);
            if (this.b.f != null) {
                this.b.f.onClick(view2);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements SimpleAdInfoView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;
        public final /* synthetic */ NadVideoAdOverContainer b;

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
            this.b = nadVideoAdOverContainer;
            this.a = adBaseModel;
        }

        @Override // com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.b.u(ClogBuilder.LogType.FREE_CLICK, str, this.a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;
        public final /* synthetic */ String b;
        public final /* synthetic */ NadVideoAdOverContainer c;

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
            this.c = nadVideoAdOverContainer;
            this.a = adBaseModel;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((LinearLayout.LayoutParams) this.c.c.getLayoutParams()).rightMargin = (int) this.c.getResources().getDimension(R.dimen.obfuscated_res_0x7f07054d);
                this.c.b.setBackgroundResource(0);
                this.c.b.setPadding(0, 0, 0, 0);
                this.c.c.setText(this.c.k(String.format("@%s", this.a.f.e), this.c.c.getPaint()));
                this.c.b.requestLayout();
                this.c.a.setText(this.c.j(this.b));
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        int a();

        int getPosition();
    }

    /* loaded from: classes2.dex */
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
        public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{canvas, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), paint}) == null) {
                Drawable drawable = getDrawable();
                canvas.save();
                canvas.translate(f, (((i5 - i3) - drawable.getBounds().bottom) / 2) + i3);
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
        this.f = null;
        this.m = true;
        l(context);
    }

    public static boolean h(qn0 qn0Var) {
        InterceptResult invokeL;
        qn0.b bVar;
        qn0.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, qn0Var)) == null) {
            if (qn0Var == null) {
                return false;
            }
            return (TextUtils.isEmpty(qn0Var.f) && TextUtils.isEmpty(qn0Var.d) && ((bVar = qn0Var.g) == null || TextUtils.isEmpty(bVar.a)) && ((aVar = qn0Var.h) == null || TextUtils.isEmpty(aVar.a))) ? false : true;
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
            this.c.setClickable(z);
            this.p.setClickable(z);
            i51<View> i51Var = this.i;
            if (i51Var == null || i51Var.getRealView() == null) {
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
            Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.obfuscated_res_0x7f080d7b);
            if (drawable == null) {
                return spannableStringBuilder;
            }
            if (this.a.getMeasuredWidth() > 0) {
                e2 = (this.a.getMeasuredWidth() * 4) - drawable.getIntrinsicWidth();
            } else {
                e2 = ((q01.c.e(getContext()) - getResources().getDimension(R.dimen.obfuscated_res_0x7f07052f)) * 4.0f) - drawable.getIntrinsicWidth();
            }
            float dimension = e2 - (getResources().getDimension(R.dimen.obfuscated_res_0x7f070530) * 3.0f);
            int length = str.length() + 1;
            spannableStringBuilder.append((CharSequence) " ").append((CharSequence) t);
            if (dimension < this.a.getPaint().measureText(spannableStringBuilder.toString())) {
                String b2 = eg0.b(spannableStringBuilder.toString(), t, dimension, this.a.getPaint(), drawable.getIntrinsicWidth());
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
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, textPaint)) == null) ? g11.b(str, "", (int) (((int) (q01.c.e(getContext()) - getResources().getDimension(R.dimen.obfuscated_res_0x7f070535))) - getResources().getDimension(R.dimen.obfuscated_res_0x7f070531)), textPaint) : (String) invokeLL.objValue;
    }

    public final void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d05cb, this);
            this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f091537);
            this.b = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0914ed);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f09151d);
            this.d = (PortraitVideoTailView) findViewById(R.id.obfuscated_res_0x7f0900d4);
            this.e = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0900d2);
            this.h = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09152e);
            this.j = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0900f2);
            this.n = findViewById(R.id.obfuscated_res_0x7f0914f0);
            this.o = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091521);
            this.p = (SimpleAdInfoView) findViewById(R.id.obfuscated_res_0x7f0914e9);
            this.r = (TextView) findViewById(R.id.obfuscated_res_0x7f0914ee);
        }
    }

    public final void m(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, adBaseModel) == null) || adBaseModel == null) {
            return;
        }
        qn0 qn0Var = adBaseModel.i;
        if (!h(qn0Var)) {
            this.q = false;
            this.p.setVisibility(8);
            this.d.setAdInfo(null);
            return;
        }
        this.q = true;
        this.p.setVisibility(0);
        this.p.setAdInfo(qn0Var);
        this.p.setAfterListener(new b(this, adBaseModel));
        this.d.setAdInfo(qn0Var);
    }

    public final void n(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, adBaseModel) == null) {
            View findViewById = findViewById(R.id.obfuscated_res_0x7f091535);
            if (!adBaseModel.d) {
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
            i51<View> i51Var = this.i;
            if (i51Var != null) {
                i51Var.a();
                this.j.setVisibility(8);
                this.i = null;
            }
            if (adBaseModel.m == null) {
                return;
            }
            View findViewById = findViewById(R.id.obfuscated_res_0x7f091535);
            findViewById.setVisibility(0);
            this.j.setVisibility(0);
            if (this.j.getChildCount() > 0) {
                this.j.removeAllViews();
            }
            AdEnhanceButtonView adEnhanceButtonView = new AdEnhanceButtonView(hh0.b(), this.j, findViewById);
            this.i = adEnhanceButtonView;
            dg0 dg0Var = new dg0(adBaseModel, adEnhanceButtonView);
            this.k = dg0Var;
            dg0Var.h(this.f);
            this.i.setEnhanceBtnListener(this.k);
            this.i.setData(adBaseModel.m);
            this.i.setBtnIconNightModeEnable(false);
        }
    }

    public final void p(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, adBaseModel) == null) {
            a aVar = new a(this, adBaseModel);
            this.g = aVar;
            this.a.setOnClickListener(aVar);
            this.c.setOnClickListener(this.g);
            this.p.setOnClickListener(this.g);
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, adBaseModel)) == null) ? (adBaseModel == null || adBaseModel.f == null) ? false : true : invokeL.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.d.getVisibility() == 0 : invokeV.booleanValue;
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
                this.b.setVisibility(0);
                this.o.setVisibility(0);
                this.p.setVisibility(this.q ? 0 : 8);
                return;
            }
            this.n.setVisibility(4);
            if (this.i != null) {
                this.j.setVisibility(4);
            }
            this.a.setVisibility(4);
            this.b.setVisibility(4);
            this.o.setVisibility(4);
            this.p.setVisibility(this.q ? 4 : 8);
        }
    }

    public void setAdOverInfoVisiblity(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            if (z) {
                this.e.setVisibility(0);
            } else {
                this.e.setVisibility(4);
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
            this.d.setOnReplayClickListener(onClickListener);
        }
    }

    public void setOnNewTailJumpHandler(PortraitVideoTailView.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, cVar) == null) {
            this.d.setOnTailJumpHandler(cVar);
        }
    }

    public void setOnUiClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) {
            this.f = onClickListener;
            PortraitVideoTailView portraitVideoTailView = this.d;
            if (portraitVideoTailView != null) {
                portraitVideoTailView.setOnAdClickListener(onClickListener);
            }
            dg0 dg0Var = this.k;
            if (dg0Var != null) {
                dg0Var.h(onClickListener);
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
            String str = adBaseModel.f.g;
            if (str == null) {
                str = "";
            }
            this.a.post(new c(this, adBaseModel, str));
        }
    }

    public final void u(ClogBuilder.LogType logType, String str, AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048598, this, logType, str, adBaseModel) == null) || adBaseModel == null || TextUtils.isEmpty(adBaseModel.f.d)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(logType);
        clogBuilder.j(str);
        d dVar = this.l;
        if (dVar != null) {
            clogBuilder.k(String.valueOf(dVar.getPosition()));
            clogBuilder.l(String.valueOf(this.l.a()));
        }
        clogBuilder.p(adBaseModel.f.d);
        iy0.b(clogBuilder);
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            Object tag = getTag();
            if (!(tag instanceof AdBaseModel)) {
                this.d.e();
                setAdOverInfoVisiblity(true);
                i(true);
            } else if (z) {
                this.d.j((AdBaseModel) tag);
                setAdOverInfoVisiblity(false);
                i(false);
            } else {
                this.d.e();
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
        this.f = null;
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
        this.f = null;
        this.m = true;
        l(context);
    }
}
