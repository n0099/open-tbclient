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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import com.baidu.tieba.b91;
import com.baidu.tieba.bm0;
import com.baidu.tieba.dh0;
import com.baidu.tieba.e41;
import com.baidu.tieba.f41;
import com.baidu.tieba.fm0;
import com.baidu.tieba.ii0;
import com.baidu.tieba.kp0;
import com.baidu.tieba.m31;
import com.baidu.tieba.op0;
import com.baidu.tieba.vh0;
import com.baidu.tieba.x81;
import com.baidu.tieba.z01;
import com.baidu.tieba.zi0;
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
    public x81<View> j;
    public FrameLayout k;
    public vh0 l;
    public f m;
    public boolean n;
    public View o;
    public LinearLayout p;
    public SimpleAdInfoView q;
    public boolean r;
    public TextView s;
    public e41 t;
    public Runnable u;
    public final Object v;
    public String w;

    /* loaded from: classes2.dex */
    public interface f {
        int a();

        int getPosition();
    }

    public final void t(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, adBaseModel) == null) {
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
            op0 op0Var = adBaseModel.m;
            if (op0Var != null && op0Var.a == 0) {
                ii0.c(adBaseModel.f.c, this.c.getContext());
            }
            this.c.z(ClogBuilder.LogType.CLICK, this.b, this.a);
            if (this.c.h != null) {
                this.c.h.onClick(view2);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends e41.b {
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

        @Override // com.baidu.tieba.e41.b
        public void f(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                this.a.C(Math.round((float) ((100000 - j) / 1000)));
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
                ((LinearLayout.LayoutParams) this.c.e.getLayoutParams()).rightMargin = (int) this.c.getResources().getDimension(R.dimen.nad_dimen_8dp);
                this.c.d.setBackgroundResource(0);
                this.c.d.setPadding(0, 0, 0, 0);
                this.c.e.setText(this.c.m(String.format("@%s", this.a.f.e), this.c.e.getPaint()));
                this.c.d.requestLayout();
                this.c.a.setText(this.c.l(this.b));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e extends fm0<dh0> {
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
        @Override // com.baidu.tieba.fm0
        public void onEvent(@NonNull dh0 dh0Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dh0Var) == null) && this.c.j != null && this.c.j.getRealView() != null && (this.c.j.getRealView() instanceof NadEnhanceButtonDownloadView)) {
                NadEnhanceButtonDownloadView nadEnhanceButtonDownloadView = (NadEnhanceButtonDownloadView) this.c.j.getRealView();
                kp0 kp0Var = dh0Var.a;
                if (kp0Var != null && kp0Var == this.b.l && nadEnhanceButtonDownloadView.getDownloadStatus() != AdDownloadStatus.DOWNLOADING) {
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

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            bm0.a().unregister(this.v);
        }
    }

    public boolean getHotAreaEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.n;
        }
        return invokeV.booleanValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            e41 e41Var = new e41(100000L, 1000L);
            e41Var.d(new b(this));
            this.t = e41Var;
            c cVar = new c(this);
            this.u = cVar;
            post(cVar);
        }
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (this.f.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            removeCallbacks(this.u);
            B();
        }
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

    public final void r(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, adBaseModel) == null) {
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

    public void C(int i) {
        x81<View> x81Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (x81Var = this.j) != null) {
            x81Var.update(i);
        }
    }

    public final void o(@NonNull AdBaseModel adBaseModel) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, adBaseModel) == null) {
            View findViewById = findViewById(R.id.nad_video_btn_placeholder);
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
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            if (z) {
                this.g.setVisibility(0);
            } else {
                this.g.setVisibility(4);
            }
        }
    }

    public void setAlsLogPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.w = str;
        }
    }

    public void setFeedbackBtnVisibility(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) {
            this.f.setOnReplayClickListener(onClickListener);
        }
    }

    public void setOnNewTailJumpHandler(PortraitVideoTailView.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, cVar) == null) {
            this.f.setOnTailJumpHandler(cVar);
        }
    }

    public void setOnUiClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, onClickListener) == null) {
            this.h = onClickListener;
            PortraitVideoTailView portraitVideoTailView = this.f;
            if (portraitVideoTailView != null) {
                portraitVideoTailView.setOnAdClickListener(onClickListener);
            }
            vh0 vh0Var = this.l;
            if (vh0Var != null) {
                vh0Var.h(onClickListener);
            }
        }
    }

    public void setOverLayInfoVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            setAdInfoVisible(z);
        }
    }

    public void setPlayerProgressHandler(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, fVar) == null) {
            this.m = fVar;
        }
    }

    public final boolean u(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, adBaseModel)) == null) {
            if (adBaseModel != null && adBaseModel.f != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void w(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, adBaseModel) == null) {
            String str = adBaseModel.f.g;
            if (str == null) {
                str = "";
            }
            this.a.post(new d(this, adBaseModel, str));
        }
    }

    public final void x(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, adBaseModel) == null) {
            bm0.a().c(this.v, 1, new e(this, dh0.class, adBaseModel));
        }
    }

    public final View.OnClickListener s(@NonNull AdBaseModel adBaseModel, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, adBaseModel, str)) == null) {
            return new a(this, adBaseModel, str);
        }
        return (View.OnClickListener) invokeLL.objValue;
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
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

    public final void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.n = z;
            this.a.setClickable(z);
            this.e.setClickable(z);
            this.q.setClickable(z);
            x81<View> x81Var = this.j;
            if (x81Var != null && x81Var.getRealView() != null) {
                this.j.getRealView().setClickable(z);
            }
        }
    }

    public final SpannableStringBuilder l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (getResources() == null) {
                return new SpannableStringBuilder(str);
            }
            return b91.b(str, 2, this.a, getContext(), ContextCompat.getDrawable(getContext(), R.drawable.nad_tag_icon), (int) getResources().getDimension(R.dimen.nad_dimen_100dp));
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public void setData(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, adBaseModel) == null) {
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

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || !(getTag() instanceof AdBaseModel)) {
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

    public final String m(@Nullable String str, @Nullable TextPaint textPaint) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, textPaint)) == null) {
            return f41.b(str, "", (int) (((int) (m31.c.e(getContext()) - getResources().getDimension(R.dimen.nad_dimen_15dp))) - getResources().getDimension(R.dimen.nad_dimen_11dp)), textPaint);
        }
        return (String) invokeLL.objValue;
    }

    public final void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.nad_mini_video_detail_ad_item_over_info, this);
            this.a = (TextView) findViewById(R.id.nad_video_title);
            this.d = (LinearLayout) findViewById(R.id.nad_author_container);
            this.e = (TextView) findViewById(R.id.nad_mini_author_name);
            this.f = (PortraitVideoTailView) findViewById(R.id.ad_mini_video_tail_frame_view_new);
            this.g = (RelativeLayout) findViewById(R.id.ad_mini_video_info_view);
            this.i = (LinearLayout) findViewById(R.id.nad_right_vertical_container);
            this.k = (FrameLayout) findViewById(R.id.ad_transition_btn_view);
            this.o = findViewById(R.id.nad_bottom_line);
            this.p = (LinearLayout) findViewById(R.id.nad_mini_video_recommend_tag);
            this.q = (SimpleAdInfoView) findViewById(R.id.nad_app_info_container);
            this.s = (TextView) findViewById(R.id.nad_base_delete_id);
            this.b = (AdImageView) findViewById(R.id.ad_author_avatar);
            this.c = (TextView) findViewById(R.id.ad_author_avatar_txt);
        }
    }

    public final void q(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, adBaseModel) == null) {
            x81<View> x81Var = this.j;
            if (x81Var != null) {
                x81Var.a();
                this.k.setVisibility(8);
                this.j = null;
            }
            if (adBaseModel.m == null) {
                return;
            }
            View findViewById = findViewById(R.id.nad_video_btn_placeholder);
            findViewById.setVisibility(0);
            this.k.setVisibility(0);
            if (this.k.getChildCount() > 0) {
                this.k.removeAllViews();
            }
            AdEnhanceButtonView adEnhanceButtonView = new AdEnhanceButtonView(zi0.b(), this.k, findViewById);
            this.j = adEnhanceButtonView;
            vh0 vh0Var = new vh0(adBaseModel, adEnhanceButtonView);
            this.l = vh0Var;
            vh0Var.h(this.h);
            this.j.setEnhanceBtnListener(this.l);
            this.j.setData(adBaseModel.m);
            this.j.setBtnIconNightModeEnable(false);
        }
    }

    public void setAdInfoVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
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

    public final void z(ClogBuilder.LogType logType, String str, AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048606, this, logType, str, adBaseModel) == null) && adBaseModel != null && !TextUtils.isEmpty(adBaseModel.f.d)) {
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
            z01.b(clogBuilder);
        }
    }
}
