package com.baidu.nadcore.widget.view;

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
import c.a.c0.b.g;
import c.a.c0.d0.f;
import c.a.c0.d0.q;
import c.a.c0.h0.k;
import c.a.c0.p.e;
import c.a.c0.p.o;
import c.a.c0.p.p;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.nadcore.widget.uitemplate.SimpleAdInfoView;
import com.baidu.nadcore.widget.view.PortraitVideoTailView;
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
    public static final char[] A;
    public static final String B;
    public static final boolean DEBUG = false;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f38666e;

    /* renamed from: f  reason: collision with root package name */
    public AdImageView f38667f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f38668g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f38669h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f38670i;

    /* renamed from: j  reason: collision with root package name */
    public PortraitVideoTailView f38671j;

    /* renamed from: k  reason: collision with root package name */
    public RelativeLayout f38672k;
    public View.OnClickListener l;
    public View.OnClickListener m;
    public LinearLayout n;
    public c.a.c0.h0.g0.b<View> o;
    public FrameLayout p;
    public c.a.c0.h0.a q;
    public d r;
    public boolean s;
    public View t;
    public LinearLayout u;
    public SimpleAdInfoView v;
    public boolean w;
    public k x;
    public FrameLayout y;
    public c.a.c0.h0.g0.a<View> z;

    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdBaseModel f38673e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NadVideoAdOverContainer f38674f;

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
            this.f38674f = nadVideoAdOverContainer;
            this.f38673e = adBaseModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f38674f.isShowingTailFrame()) {
                return;
            }
            c.a.c0.d.c.c(this.f38673e.f38219d.a, this.f38674f.getContext());
            this.f38674f.u(ClogBuilder.LogType.CLICK, ThreadAchievementShareDialogView.HOT_LIST_VIEW_TYPE, this.f38673e);
            if (this.f38674f.l != null) {
                this.f38674f.l.onClick(view);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements SimpleAdInfoView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ NadVideoAdOverContainer f38675b;

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
            this.f38675b = nadVideoAdOverContainer;
            this.a = adBaseModel;
        }

        @Override // com.baidu.nadcore.widget.uitemplate.SimpleAdInfoView.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f38675b.u(ClogBuilder.LogType.FREE_CLICK, str, this.a);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdBaseModel f38676e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f38677f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ NadVideoAdOverContainer f38678g;

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
            this.f38678g = nadVideoAdOverContainer;
            this.f38676e = adBaseModel;
            this.f38677f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((LinearLayout.LayoutParams) this.f38678g.f38670i.getLayoutParams()).rightMargin = (int) this.f38678g.getResources().getDimension(c.a.c0.b.c.nad_dimen_8dp);
                this.f38678g.f38669h.setBackgroundResource(0);
                this.f38678g.f38669h.setPadding(0, 0, 0, 0);
                this.f38678g.f38670i.setText(this.f38678g.k(String.format("@%s", this.f38676e.f38219d.f2228c), this.f38678g.f38670i.getPaint()));
                this.f38678g.f38669h.requestLayout();
                this.f38678g.f38666e.setText(this.f38678g.j(this.f38677f));
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface d {
        int a();

        int getPosition();
    }

    /* loaded from: classes10.dex */
    public interface e {
        void a();
    }

    /* loaded from: classes10.dex */
    public static class f extends ImageSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f38679e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Drawable drawable) {
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
                this.f38679e = i9;
                return i9;
            }
            return invokeCommon.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-859320537, "Lcom/baidu/nadcore/widget/view/NadVideoAdOverContainer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-859320537, "Lcom/baidu/nadcore/widget/view/NadVideoAdOverContainer;");
                return;
            }
        }
        A = new char[]{21704};
        B = new String(A);
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
        this.l = null;
        this.s = true;
        l(context);
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
            return (TextUtils.isEmpty(pVar.f2260f) && TextUtils.isEmpty(pVar.f2258d) && ((bVar = pVar.f2261g) == null || TextUtils.isEmpty(bVar.a)) && ((aVar = pVar.f2262h) == null || TextUtils.isEmpty(aVar.a))) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public void destroyAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (getHandler() != null) {
                getHandler().removeCallbacksAndMessages(null);
            }
            c.a.c0.h0.g0.b<View> bVar = this.o;
            if (bVar != null) {
                bVar.resetAnim();
            }
            k kVar = this.x;
            if (kVar != null) {
                kVar.release();
            }
            c.a.c0.h0.g0.a<View> aVar = this.z;
            if (aVar != null) {
                aVar.resetAnim();
            }
        }
    }

    public boolean getHotAreaEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.s : invokeV.booleanValue;
    }

    @Nullable
    public k getInteractController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.x : (k) invokeV.objValue;
    }

    public final void h() {
        k kVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (getTag() instanceof AdBaseModel)) {
            AdBaseModel adBaseModel = (AdBaseModel) getTag();
            if (adBaseModel.f38219d == null || (kVar = this.x) == null) {
                return;
            }
            if (kVar.a("avatarIcon") instanceof AdImageView) {
                this.f38667f = (AdImageView) this.x.a("avatarIcon");
            }
            if (this.x.a("avatarText") instanceof TextView) {
                this.f38668g = (TextView) this.x.a("avatarText");
            }
            if (this.f38667f.getParent() instanceof View) {
                ((View) this.f38667f.getParent()).setVisibility(0);
            }
            if (!TextUtils.isEmpty(adBaseModel.f38219d.f2229d)) {
                this.f38667f.setVisibility(0);
                this.f38668g.setVisibility(8);
                this.f38667f.displayImage(adBaseModel.f38219d.f2229d);
            } else if (!TextUtils.isEmpty(adBaseModel.f38219d.f2228c)) {
                this.f38667f.setVisibility(8);
                this.f38668g.setVisibility(0);
                this.f38668g.setText(adBaseModel.f38219d.f2228c);
            } else {
                this.f38667f.setVisibility(8);
                this.f38668g.setVisibility(8);
            }
        }
    }

    public final void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.s = z;
            this.y.setClickable(z);
            this.f38666e.setClickable(z);
            AdImageView adImageView = this.f38667f;
            if (adImageView != null) {
                adImageView.setClickable(z);
            }
            TextView textView = this.f38668g;
            if (textView != null) {
                textView.setClickable(z);
            }
            this.f38670i.setClickable(z);
            this.v.setClickable(z);
            c.a.c0.h0.g0.b<View> bVar = this.o;
            if (bVar != null && bVar.getRealView() != null) {
                this.o.getRealView().setClickable(z);
            }
            k kVar = this.x;
            if (kVar != null) {
                kVar.a("praiseImage");
            }
        }
    }

    public boolean isInteractionDataVaild(@NonNull AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        c.a.c0.p.f fVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, adBaseModel)) == null) ? (adBaseModel == null || (fVar = adBaseModel.f38226k) == null || fVar.a == null) ? false : true : invokeL.booleanValue;
    }

    public boolean isShowingTailFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f38671j.getVisibility() == 0 : invokeV.booleanValue;
    }

    public final SpannableStringBuilder j(String str) {
        InterceptResult invokeL;
        float e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            Drawable drawable = ContextCompat.getDrawable(getContext(), c.a.c0.b.d.nad_tag_icon);
            if (drawable == null) {
                return spannableStringBuilder;
            }
            if (this.f38666e.getMeasuredWidth() > 0) {
                e2 = (this.f38666e.getMeasuredWidth() * 4) - drawable.getIntrinsicWidth();
            } else {
                e2 = ((f.c.e(getContext()) - getResources().getDimension(c.a.c0.b.c.nad_dimen_100dp)) * 4.0f) - drawable.getIntrinsicWidth();
            }
            float dimension = e2 - (getResources().getDimension(c.a.c0.b.c.nad_dimen_10dp) * 3.0f);
            int length = str.length() + 1;
            spannableStringBuilder.append((CharSequence) " ").append((CharSequence) B);
            if (dimension < this.f38666e.getPaint().measureText(spannableStringBuilder.toString())) {
                String a2 = k.a.a(spannableStringBuilder.toString(), B, dimension, this.f38666e.getPaint(), drawable.getIntrinsicWidth());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(a2);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                spannableStringBuilder2.setSpan(new f(drawable), a2.length() - B.length(), a2.length(), 17);
                return spannableStringBuilder2;
            }
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            spannableStringBuilder.setSpan(new f(drawable), length, spannableStringBuilder.length(), 17);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public final String k(@Nullable String str, @Nullable TextPaint textPaint) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, textPaint)) == null) ? q.b(str, "", (int) (((int) (f.c.e(getContext()) - getResources().getDimension(c.a.c0.b.c.nad_dimen_15dp))) - getResources().getDimension(c.a.c0.b.c.nad_dimen_11dp)), textPaint) : (String) invokeLL.objValue;
    }

    public final void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
            LayoutInflater.from(context).inflate(g.nad_mini_video_detail_ad_item_over_info, this);
            this.f38666e = (TextView) findViewById(c.a.c0.b.e.nad_video_title);
            this.f38669h = (LinearLayout) findViewById(c.a.c0.b.e.nad_author_container);
            this.f38670i = (TextView) findViewById(c.a.c0.b.e.nad_mini_author_name);
            this.f38671j = (PortraitVideoTailView) findViewById(c.a.c0.b.e.ad_mini_video_tail_frame_view_new);
            this.f38672k = (RelativeLayout) findViewById(c.a.c0.b.e.ad_mini_video_info_view);
            this.n = (LinearLayout) findViewById(c.a.c0.b.e.nad_right_vertical_container);
            this.p = (FrameLayout) findViewById(c.a.c0.b.e.ad_transition_btn_view);
            this.t = findViewById(c.a.c0.b.e.nad_bottom_line);
            this.u = (LinearLayout) findViewById(c.a.c0.b.e.nad_mini_video_recommend_tag);
            this.v = (SimpleAdInfoView) findViewById(c.a.c0.b.e.nad_app_info_container);
            this.y = (FrameLayout) findViewById(c.a.c0.b.e.ad_mini_video_mini_pop);
        }
    }

    public final void m(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, adBaseModel) == null) || adBaseModel == null) {
            return;
        }
        p pVar = adBaseModel.f38222g;
        if (!canShowAppInfoLayout(pVar)) {
            this.w = false;
            this.v.setVisibility(8);
            this.f38671j.setAdInfo(null);
            return;
        }
        this.w = true;
        this.v.setVisibility(0);
        this.v.setAdInfo(pVar);
        this.v.setAfterListener(new b(this, adBaseModel));
        this.f38671j.setAdInfo(pVar);
    }

    public final void n(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, adBaseModel) == null) {
            View findViewById = findViewById(c.a.c0.b.e.nad_video_btn_placeholder);
            if (!adBaseModel.f38218c) {
                findViewById.setVisibility(8);
                return;
            }
            o(adBaseModel);
            this.y.setVisibility(8);
            this.p.setVisibility(0);
            findViewById.setVisibility(0);
        }
    }

    public final void o(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, adBaseModel) == null) {
            c.a.c0.h0.g0.b<View> bVar = this.o;
            if (bVar != null) {
                bVar.resetAnim();
                this.p.setVisibility(8);
                this.o = null;
            }
            View findViewById = findViewById(c.a.c0.b.e.nad_video_btn_placeholder);
            findViewById.setVisibility(0);
            this.p.setVisibility(0);
            if (this.p.getChildCount() > 0) {
                this.p.removeAllViews();
            }
            AdEnhanceButtonView adEnhanceButtonView = new AdEnhanceButtonView(c.a.c0.e.a.b(), this.p, findViewById);
            this.o = adEnhanceButtonView;
            c.a.c0.h0.a aVar = new c.a.c0.h0.a(adBaseModel, adEnhanceButtonView);
            this.q = aVar;
            aVar.g(this.l);
            this.o.setEnhanceBtnListener(this.q);
            this.o.setData(adBaseModel);
            this.o.setBtnIconNightModeEnable(false);
        }
    }

    public final void p(@NonNull AdBaseModel adBaseModel) {
        c.a.c0.p.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, adBaseModel) == null) {
            o oVar = adBaseModel.l;
            if (oVar != null && oVar.f2253h) {
                if (adBaseModel != null && adBaseModel.f38219d != null && (fVar = adBaseModel.f38226k) != null) {
                    c.a.c0.p.g gVar = new c.a.c0.p.g();
                    String str = adBaseModel.f38219d.f2227b;
                    fVar.f2223d = gVar;
                    e.a aVar = new e.a();
                    e.b bVar = new e.b();
                    k kVar = this.x;
                    if (kVar != null) {
                        kVar.release();
                        this.x = null;
                        this.n.setVisibility(8);
                    }
                    LinearLayout linearLayout = this.n;
                    aVar.c(true);
                    aVar.b(bVar);
                    c.a.c0.h0.c cVar = new c.a.c0.h0.c(linearLayout, aVar.a());
                    this.x = cVar;
                    if (cVar != null) {
                        cVar.b(adBaseModel);
                    }
                    this.n.setVisibility(0);
                    return;
                }
                this.n.setVisibility(8);
                return;
            }
            this.n.setVisibility(8);
        }
    }

    public final void q(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, adBaseModel) == null) {
            a aVar = new a(this, adBaseModel);
            this.m = aVar;
            this.f38666e.setOnClickListener(aVar);
            TextView textView = this.f38668g;
            if (textView != null) {
                textView.setOnClickListener(this.m);
            }
            AdImageView adImageView = this.f38667f;
            if (adImageView != null) {
                adImageView.setOnClickListener(this.m);
            }
            this.f38670i.setOnClickListener(this.m);
            this.v.setOnClickListener(this.m);
        }
    }

    public final void r(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, adBaseModel) == null) {
        }
    }

    public final boolean s(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, adBaseModel)) == null) ? (adBaseModel == null || adBaseModel.f38219d == null) ? false : true : invokeL.booleanValue;
    }

    public void setAdInfoVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            if (z) {
                this.t.setVisibility(0);
                if (this.o != null) {
                    this.p.setVisibility(0);
                }
                if (this.z != null) {
                    this.y.setVisibility(0);
                }
                this.f38666e.setVisibility(0);
                this.f38669h.setVisibility(0);
                this.u.setVisibility(0);
                this.v.setVisibility(this.w ? 0 : 8);
                return;
            }
            this.t.setVisibility(4);
            if (this.o != null) {
                this.p.setVisibility(4);
            }
            if (this.z != null) {
                this.y.setVisibility(4);
            }
            this.f38666e.setVisibility(4);
            this.f38669h.setVisibility(4);
            this.u.setVisibility(4);
            this.v.setVisibility(this.w ? 4 : 8);
        }
    }

    public void setAdOverInfoVisiblity(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            if (z) {
                this.f38672k.setVisibility(0);
            } else {
                this.f38672k.setVisibility(4);
            }
        }
    }

    public void setData(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, adBaseModel) == null) {
            if (!s(adBaseModel)) {
                setVisibility(8);
                return;
            }
            setTag(adBaseModel);
            setVisibility(0);
            n(adBaseModel);
            t(adBaseModel);
            m(adBaseModel);
            p(adBaseModel);
            h();
            q(adBaseModel);
            r(adBaseModel);
        }
    }

    public void setNewTailFrameUbsClickHandler(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, eVar) == null) {
        }
    }

    public void setOnNewTailFrameReplayClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, onClickListener) == null) {
            this.f38671j.setOnReplayClickListener(onClickListener);
        }
    }

    public void setOnNewTailJumpHandler(PortraitVideoTailView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bVar) == null) {
            this.f38671j.setOnTailJumpHandler(bVar);
        }
    }

    public void setOnUiClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, onClickListener) == null) {
            this.l = onClickListener;
            PortraitVideoTailView portraitVideoTailView = this.f38671j;
            if (portraitVideoTailView != null) {
                portraitVideoTailView.setOnAdClickListener(onClickListener);
            }
            c.a.c0.h0.a aVar = this.q;
            if (aVar != null) {
                aVar.g(onClickListener);
            }
        }
    }

    public void setOverLayInfoVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            setAdInfoVisible(z);
        }
    }

    public void setPlayerProgressHandler(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, dVar) == null) {
            this.r = dVar;
        }
    }

    public void showNewTailFrame(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            Object tag = getTag();
            if (!(tag instanceof AdBaseModel)) {
                this.f38671j.hideTailFrame();
                setAdOverInfoVisiblity(true);
                i(true);
            } else if (z) {
                this.f38671j.showTailFrame((AdBaseModel) tag);
                setAdOverInfoVisiblity(false);
                i(false);
            } else {
                this.f38671j.hideTailFrame();
                setAdOverInfoVisiblity(true);
                i(true);
            }
        }
    }

    public final void t(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, adBaseModel) == null) {
            String str = adBaseModel.f38219d.f2230e;
            if (str == null) {
                str = "";
            }
            this.f38666e.post(new c(this, adBaseModel, str));
        }
    }

    public final void u(ClogBuilder.LogType logType, String str, AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048604, this, logType, str, adBaseModel) == null) || adBaseModel == null || TextUtils.isEmpty(adBaseModel.f38219d.f2227b)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.r(logType);
        clogBuilder.g(str);
        d dVar = this.r;
        if (dVar != null) {
            clogBuilder.h(String.valueOf(dVar.getPosition()));
            clogBuilder.i(String.valueOf(this.r.a()));
        }
        clogBuilder.m(adBaseModel.f38219d.f2227b);
        c.a.c0.x.a.b(clogBuilder);
    }

    public void updateEnhancementBtn() {
        c.a.c0.h0.g0.b<View> bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (bVar = this.o) == null) {
            return;
        }
        bVar.updateUI();
    }

    public void updateProgress(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048606, this, i2, i3, i4) == null) {
            c.a.c0.h0.g0.b<View> bVar = this.o;
            if (bVar != null) {
                bVar.update(i2);
            }
            c.a.c0.h0.g0.a<View> aVar = this.z;
            if (aVar != null) {
                aVar.update(i2);
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
        this.l = null;
        this.s = true;
        l(context);
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
        this.l = null;
        this.s = true;
        l(context);
    }
}
