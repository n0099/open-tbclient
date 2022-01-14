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
import c.a.c0.d.g;
import c.a.c0.g0.f;
import c.a.c0.g0.q;
import c.a.c0.s.p;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.business.uitemplate.PortraitVideoTailView;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class NadVideoAdOverContainer extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean DEBUG = false;
    public static final char[] w;
    public static final String x;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f36947e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f36948f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f36949g;

    /* renamed from: h  reason: collision with root package name */
    public PortraitVideoTailView f36950h;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f36951i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f36952j;
    public View.OnClickListener k;
    public LinearLayout l;
    public c.a.c0.k0.a0.b<View> m;
    public FrameLayout n;
    public c.a.c0.d.p.a o;
    public d p;
    public boolean q;
    public View r;
    public LinearLayout s;
    public SimpleAdInfoView t;
    public boolean u;
    public TextView v;

    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdBaseModel f36953e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NadVideoAdOverContainer f36954f;

        public a(NadVideoAdOverContainer nadVideoAdOverContainer, AdBaseModel adBaseModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadVideoAdOverContainer, adBaseModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36954f = nadVideoAdOverContainer;
            this.f36953e = adBaseModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f36954f.isShowingTailFrame()) {
                return;
            }
            c.a.c0.f.d.c(this.f36953e.f37016d.a, this.f36954f.getContext());
            this.f36954f.s(ClogBuilder.LogType.CLICK, ThreadAchievementShareDialogView.HOT_LIST_VIEW_TYPE, this.f36953e);
            if (this.f36954f.f36952j != null) {
                this.f36954f.f36952j.onClick(view);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements SimpleAdInfoView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ NadVideoAdOverContainer f36955b;

        public b(NadVideoAdOverContainer nadVideoAdOverContainer, AdBaseModel adBaseModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadVideoAdOverContainer, adBaseModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36955b = nadVideoAdOverContainer;
            this.a = adBaseModel;
        }

        @Override // com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f36955b.s(ClogBuilder.LogType.FREE_CLICK, str, this.a);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdBaseModel f36956e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f36957f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ NadVideoAdOverContainer f36958g;

        public c(NadVideoAdOverContainer nadVideoAdOverContainer, AdBaseModel adBaseModel, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadVideoAdOverContainer, adBaseModel, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36958g = nadVideoAdOverContainer;
            this.f36956e = adBaseModel;
            this.f36957f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((LinearLayout.LayoutParams) this.f36958g.f36949g.getLayoutParams()).rightMargin = (int) this.f36958g.getResources().getDimension(c.a.c0.d.c.nad_dimen_8dp);
                this.f36958g.f36948f.setBackgroundResource(0);
                this.f36958g.f36948f.setPadding(0, 0, 0, 0);
                this.f36958g.f36949g.setText(this.f36958g.j(String.format("@%s", this.f36956e.f37016d.f2234c), this.f36958g.f36949g.getPaint()));
                this.f36958g.f36948f.requestLayout();
                this.f36958g.f36947e.setText(this.f36958g.i(this.f36957f));
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface d {
        int a();

        int getPosition();
    }

    /* loaded from: classes10.dex */
    public static class e extends ImageSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f36959e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Drawable drawable) {
            super(drawable);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {drawable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Drawable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{canvas, charSequence, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), paint}) == null) {
                Drawable drawable = getDrawable();
                canvas.save();
                canvas.translate(f2, (((i6 - i4) - drawable.getBounds().bottom) / 2) + i4);
                drawable.draw(canvas);
                canvas.restore();
            }
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{paint, charSequence, Integer.valueOf(i2), Integer.valueOf(i3), fontMetricsInt})) == null) {
                Rect bounds = getDrawable().getBounds();
                if (fontMetricsInt != null) {
                    Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
                    int i4 = fontMetricsInt2.bottom - fontMetricsInt2.top;
                    int i5 = (bounds.bottom - bounds.top) / 2;
                    int i6 = i4 / 4;
                    int i7 = i5 - i6;
                    int i8 = -(i5 + i6);
                    fontMetricsInt.ascent = i8;
                    fontMetricsInt.top = i8;
                    fontMetricsInt.bottom = i7;
                    fontMetricsInt.descent = i7;
                }
                int i9 = bounds.right;
                this.f36959e = i9;
                return i9;
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
        w = new char[]{21704};
        x = new String(w);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f36952j = null;
        this.q = true;
        k(context);
    }

    public static boolean canShowAppInfoLayout(p pVar) {
        InterceptResult invokeL;
        p.b bVar;
        p.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, pVar)) == null) {
            if (pVar == null) {
                return false;
            }
            return (TextUtils.isEmpty(pVar.f2270f) && TextUtils.isEmpty(pVar.f2268d) && ((bVar = pVar.f2271g) == null || TextUtils.isEmpty(bVar.a)) && ((aVar = pVar.f2272h) == null || TextUtils.isEmpty(aVar.a))) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public void destroyAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (getHandler() != null) {
                getHandler().removeCallbacksAndMessages(null);
            }
            c.a.c0.k0.a0.b<View> bVar = this.m;
            if (bVar != null) {
                bVar.resetAnim();
            }
        }
    }

    public boolean getHotAreaEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.q : invokeV.booleanValue;
    }

    public final void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.q = z;
            this.f36947e.setClickable(z);
            this.f36949g.setClickable(z);
            this.t.setClickable(z);
            c.a.c0.k0.a0.b<View> bVar = this.m;
            if (bVar == null || bVar.getRealView() == null) {
                return;
            }
            this.m.getRealView().setClickable(z);
        }
    }

    public final SpannableStringBuilder i(String str) {
        InterceptResult invokeL;
        float e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            Drawable drawable = ContextCompat.getDrawable(getContext(), c.a.c0.d.d.nad_tag_icon);
            if (drawable == null) {
                return spannableStringBuilder;
            }
            if (this.f36947e.getMeasuredWidth() > 0) {
                e2 = (this.f36947e.getMeasuredWidth() * 4) - drawable.getIntrinsicWidth();
            } else {
                e2 = ((f.c.e(getContext()) - getResources().getDimension(c.a.c0.d.c.nad_dimen_100dp)) * 4.0f) - drawable.getIntrinsicWidth();
            }
            float dimension = e2 - (getResources().getDimension(c.a.c0.d.c.nad_dimen_10dp) * 3.0f);
            int length = str.length() + 1;
            spannableStringBuilder.append((CharSequence) " ").append((CharSequence) x);
            if (dimension < this.f36947e.getPaint().measureText(spannableStringBuilder.toString())) {
                String b2 = c.a.c0.d.q.a.b(spannableStringBuilder.toString(), x, dimension, this.f36947e.getPaint(), drawable.getIntrinsicWidth());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(b2);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                spannableStringBuilder2.setSpan(new e(drawable), b2.length() - x.length(), b2.length(), 17);
                return spannableStringBuilder2;
            }
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            spannableStringBuilder.setSpan(new e(drawable), length, spannableStringBuilder.length(), 17);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public boolean isInteractionDataVaild(@NonNull AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        c.a.c0.s.e eVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, adBaseModel)) == null) ? (adBaseModel == null || (eVar = adBaseModel.k) == null || eVar.a == null) ? false : true : invokeL.booleanValue;
    }

    public boolean isShowingTailFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f36950h.getVisibility() == 0 : invokeV.booleanValue;
    }

    public final String j(@Nullable String str, @Nullable TextPaint textPaint) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, textPaint)) == null) ? q.b(str, "", (int) (((int) (f.c.e(getContext()) - getResources().getDimension(c.a.c0.d.c.nad_dimen_15dp))) - getResources().getDimension(c.a.c0.d.c.nad_dimen_11dp)), textPaint) : (String) invokeLL.objValue;
    }

    public final void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            LayoutInflater.from(context).inflate(g.nad_mini_video_detail_ad_item_over_info, this);
            this.f36947e = (TextView) findViewById(c.a.c0.d.e.nad_video_title);
            this.f36948f = (LinearLayout) findViewById(c.a.c0.d.e.nad_author_container);
            this.f36949g = (TextView) findViewById(c.a.c0.d.e.nad_mini_author_name);
            this.f36950h = (PortraitVideoTailView) findViewById(c.a.c0.d.e.ad_mini_video_tail_frame_view_new);
            this.f36951i = (RelativeLayout) findViewById(c.a.c0.d.e.ad_mini_video_info_view);
            this.l = (LinearLayout) findViewById(c.a.c0.d.e.nad_right_vertical_container);
            this.n = (FrameLayout) findViewById(c.a.c0.d.e.ad_transition_btn_view);
            this.r = findViewById(c.a.c0.d.e.nad_bottom_line);
            this.s = (LinearLayout) findViewById(c.a.c0.d.e.nad_mini_video_recommend_tag);
            this.t = (SimpleAdInfoView) findViewById(c.a.c0.d.e.nad_app_info_container);
            this.v = (TextView) findViewById(c.a.c0.d.e.nad_base_delete_id);
        }
    }

    public final void l(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, adBaseModel) == null) || adBaseModel == null) {
            return;
        }
        p pVar = adBaseModel.f37019g;
        if (!canShowAppInfoLayout(pVar)) {
            this.u = false;
            this.t.setVisibility(8);
            this.f36950h.setAdInfo(null);
            return;
        }
        this.u = true;
        this.t.setVisibility(0);
        this.t.setAdInfo(pVar);
        this.t.setAfterListener(new b(this, adBaseModel));
        this.f36950h.setAdInfo(pVar);
    }

    public final void m(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, adBaseModel) == null) {
            View findViewById = findViewById(c.a.c0.d.e.nad_video_btn_placeholder);
            if (!adBaseModel.f37015c) {
                findViewById.setVisibility(8);
                return;
            }
            n(adBaseModel);
            this.n.setVisibility(0);
            findViewById.setVisibility(0);
        }
    }

    public final void n(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, adBaseModel) == null) {
            c.a.c0.k0.a0.b<View> bVar = this.m;
            if (bVar != null) {
                bVar.resetAnim();
                this.n.setVisibility(8);
                this.m = null;
            }
            if (adBaseModel.f37022j == null) {
                return;
            }
            View findViewById = findViewById(c.a.c0.d.e.nad_video_btn_placeholder);
            findViewById.setVisibility(0);
            this.n.setVisibility(0);
            if (this.n.getChildCount() > 0) {
                this.n.removeAllViews();
            }
            AdEnhanceButtonView adEnhanceButtonView = new AdEnhanceButtonView(c.a.c0.h.a.b(), this.n, findViewById);
            this.m = adEnhanceButtonView;
            c.a.c0.d.p.a aVar = new c.a.c0.d.p.a(adBaseModel, adEnhanceButtonView);
            this.o = aVar;
            aVar.h(this.f36952j);
            this.m.setEnhanceBtnListener(this.o);
            this.m.setData(adBaseModel.f37022j);
            this.m.setBtnIconNightModeEnable(false);
        }
    }

    public final void o(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, adBaseModel) == null) {
            a aVar = new a(this, adBaseModel);
            this.k = aVar;
            this.f36947e.setOnClickListener(aVar);
            this.f36949g.setOnClickListener(this.k);
            this.t.setOnClickListener(this.k);
        }
    }

    public final void p(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, adBaseModel) == null) {
        }
    }

    public final boolean q(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, adBaseModel)) == null) ? (adBaseModel == null || adBaseModel.f37016d == null) ? false : true : invokeL.booleanValue;
    }

    public final void r(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, adBaseModel) == null) {
            String str = adBaseModel.f37016d.f2236e;
            if (str == null) {
                str = "";
            }
            this.f36947e.post(new c(this, adBaseModel, str));
        }
    }

    public final void s(ClogBuilder.LogType logType, String str, AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048591, this, logType, str, adBaseModel) == null) || adBaseModel == null || TextUtils.isEmpty(adBaseModel.f37016d.f2233b)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.r(logType);
        clogBuilder.g(str);
        d dVar = this.p;
        if (dVar != null) {
            clogBuilder.h(String.valueOf(dVar.getPosition()));
            clogBuilder.i(String.valueOf(this.p.a()));
        }
        clogBuilder.m(adBaseModel.f37016d.f2233b);
        c.a.c0.a0.a.b(clogBuilder);
    }

    public void setAdInfoVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            if (z) {
                this.r.setVisibility(0);
                if (this.m != null) {
                    this.n.setVisibility(0);
                }
                this.f36947e.setVisibility(0);
                this.f36948f.setVisibility(0);
                this.s.setVisibility(0);
                this.t.setVisibility(this.u ? 0 : 8);
                return;
            }
            this.r.setVisibility(4);
            if (this.m != null) {
                this.n.setVisibility(4);
            }
            this.f36947e.setVisibility(4);
            this.f36948f.setVisibility(4);
            this.s.setVisibility(4);
            this.t.setVisibility(this.u ? 4 : 8);
        }
    }

    public void setAdOverInfoVisiblity(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            if (z) {
                this.f36951i.setVisibility(0);
            } else {
                this.f36951i.setVisibility(4);
            }
        }
    }

    public void setData(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, adBaseModel) == null) {
            if (!q(adBaseModel)) {
                setVisibility(8);
                return;
            }
            setTag(adBaseModel);
            setVisibility(0);
            m(adBaseModel);
            r(adBaseModel);
            l(adBaseModel);
            o(adBaseModel);
            p(adBaseModel);
        }
    }

    public void setFeedbackBtnVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.v.setVisibility(z ? 0 : 8);
        }
    }

    public void setOnNewTailFrameReplayClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, onClickListener) == null) {
            this.f36950h.setOnReplayClickListener(onClickListener);
        }
    }

    public void setOnNewTailJumpHandler(PortraitVideoTailView.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, cVar) == null) {
            this.f36950h.setOnTailJumpHandler(cVar);
        }
    }

    public void setOnUiClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, onClickListener) == null) {
            this.f36952j = onClickListener;
            PortraitVideoTailView portraitVideoTailView = this.f36950h;
            if (portraitVideoTailView != null) {
                portraitVideoTailView.setOnAdClickListener(onClickListener);
            }
            c.a.c0.d.p.a aVar = this.o;
            if (aVar != null) {
                aVar.h(onClickListener);
            }
        }
    }

    public void setOverLayInfoVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            setAdInfoVisible(z);
        }
    }

    public void setPlayerProgressHandler(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, dVar) == null) {
            this.p = dVar;
        }
    }

    public void showNewTailFrame(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            Object tag = getTag();
            if (!(tag instanceof AdBaseModel)) {
                this.f36950h.hideTailFrame();
                setAdOverInfoVisiblity(true);
                h(true);
            } else if (z) {
                this.f36950h.showTailFrame((AdBaseModel) tag);
                setAdOverInfoVisiblity(false);
                h(false);
            } else {
                this.f36950h.hideTailFrame();
                setAdOverInfoVisiblity(true);
                h(true);
            }
        }
    }

    public void updateEnhancementBtn() {
        c.a.c0.k0.a0.b<View> bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (bVar = this.m) == null) {
            return;
        }
        bVar.updateUI();
    }

    public void updateProgress(int i2, int i3, int i4) {
        c.a.c0.k0.a0.b<View> bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048603, this, i2, i3, i4) == null) || (bVar = this.m) == null) {
            return;
        }
        bVar.update(i2);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f36952j = null;
        this.q = true;
        k(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NadVideoAdOverContainer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f36952j = null;
        this.q = true;
        k(context);
    }
}
