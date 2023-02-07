package com.baidu.nadcore.business.uitemplate;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.tieba.b51;
import com.baidu.tieba.bj0;
import com.baidu.tieba.ji0;
import com.baidu.tieba.ki0;
import com.baidu.tieba.kj0;
import com.baidu.tieba.n21;
import com.baidu.tieba.nd1;
import com.baidu.tieba.nj0;
import com.baidu.tieba.oh0;
import com.baidu.tieba.pq0;
import com.baidu.tieba.rd1;
import com.baidu.tieba.sm0;
import com.baidu.tieba.t51;
import com.baidu.tieba.u51;
import com.baidu.tieba.wi0;
import com.baidu.tieba.wm0;
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
    public nd1<View> j;
    public FrameLayout k;
    public ji0 l;
    public f m;
    public boolean n;
    public View o;
    public LinearLayout p;
    public SimpleAdInfoView q;
    public boolean r;
    public TextView s;
    public t51 t;
    public Runnable u;
    public final Object v;
    public String w;

    /* loaded from: classes2.dex */
    public interface f {
        int a();

        int getPosition();
    }

    public int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? R.layout.nad_mini_video_detail_ad_item_over_info : invokeV.intValue;
    }

    public final void t(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, adBaseModel) == null) {
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
            String str = adBaseModel.f.c;
            pq0 pq0Var = adBaseModel.m;
            if (pq0Var != null && pq0Var.a == 0 && !this.c.j(str).booleanValue()) {
                wi0.c(str, this.c.getContext());
            }
            this.c.z(ClogBuilder.LogType.CLICK, this.b, this.a);
            if (this.c.h != null) {
                this.c.h.onClick(view2);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends t51.b {
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

        @Override // com.baidu.tieba.t51.b
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
    public class e extends wm0<oh0> {
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
        @Override // com.baidu.tieba.wm0
        public void onEvent(@NonNull oh0 oh0Var) {
            nd1<View> nd1Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, oh0Var) == null) && (nd1Var = this.c.j) != null && nd1Var.getRealView() != null && (this.c.j.getRealView() instanceof NadEnhanceButtonDownloadView)) {
                NadEnhanceButtonDownloadView nadEnhanceButtonDownloadView = (NadEnhanceButtonDownloadView) this.c.j.getRealView();
                if (oh0Var.a == null) {
                    return;
                }
                if (nadEnhanceButtonDownloadView.getDownloadStatus() != AdDownloadStatus.DOWNLOADING) {
                    nadEnhanceButtonDownloadView.performClick();
                }
                AdBaseModel adBaseModel = this.b;
                if (adBaseModel == null) {
                    return;
                }
                ki0.b(adBaseModel.e);
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
            sm0.a().unregister(this.v);
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
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            t51 t51Var = new t51(100000L, 1000L);
            t51Var.d(new b(this));
            this.t = t51Var;
            c cVar = new c(this);
            this.u = cVar;
            post(cVar);
        }
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (this.f.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048590, this, adBaseModel) == null) {
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

    public View.OnClickListener s(@NonNull AdBaseModel adBaseModel, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, adBaseModel, str)) == null) {
            return new a(this, adBaseModel, str);
        }
        return (View.OnClickListener) invokeLL.objValue;
    }

    public void C(int i) {
        nd1<View> nd1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (nd1Var = this.j) != null) {
            nd1Var.update(i);
        }
    }

    public final void o(@NonNull AdBaseModel adBaseModel) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, adBaseModel) == null) {
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
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            if (z) {
                this.g.setVisibility(0);
            } else {
                this.g.setVisibility(4);
            }
        }
    }

    public void setAlsLogPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.w = str;
        }
    }

    public void setBottomLineHeight(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048595, this, i) == null) && (view2 = this.o) != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            layoutParams.height = i;
            this.o.setLayoutParams(layoutParams);
        }
    }

    public void setFeedbackBtnVisibility(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048598, this, onClickListener) == null) {
            this.f.setOnReplayClickListener(onClickListener);
        }
    }

    public void setOnNewTailJumpHandler(PortraitVideoTailView.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, cVar) == null) {
            this.f.setOnTailJumpHandler(cVar);
        }
    }

    public void setOnUiClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, onClickListener) == null) {
            this.h = onClickListener;
            PortraitVideoTailView portraitVideoTailView = this.f;
            if (portraitVideoTailView != null) {
                portraitVideoTailView.setOnAdClickListener(onClickListener);
            }
            ji0 ji0Var = this.l;
            if (ji0Var != null) {
                ji0Var.h(onClickListener);
            }
        }
    }

    public void setOverLayInfoVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            setAdInfoVisible(z);
        }
    }

    public void setPlayerProgressHandler(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, fVar) == null) {
            this.m = fVar;
        }
    }

    public final boolean u(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, adBaseModel)) == null) {
            if (adBaseModel != null && adBaseModel.f != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void w(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, adBaseModel) == null) {
            String str = adBaseModel.f.g;
            if (str == null) {
                str = "";
            }
            this.a.post(new d(this, adBaseModel, str));
        }
    }

    public final void x(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, adBaseModel) == null) {
            sm0.a().c(this.v, 1, new e(this, oh0.class, adBaseModel));
        }
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

    public final Boolean j(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return Boolean.FALSE;
            }
            if (!kj0.o(str)) {
                return Boolean.FALSE;
            }
            return Boolean.valueOf("rewardWebPanel".equals(new bj0(str).a()));
        }
        return (Boolean) invokeL.objValue;
    }

    public final void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.n = z;
            this.a.setClickable(z);
            this.e.setClickable(z);
            this.q.setClickable(z);
            nd1<View> nd1Var = this.j;
            if (nd1Var != null && nd1Var.getRealView() != null) {
                this.j.getRealView().setClickable(z);
            }
        }
    }

    public final SpannableStringBuilder l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (getResources() == null) {
                return new SpannableStringBuilder(str);
            }
            return rd1.b(str, 2, this.a, getContext(), ContextCompat.getDrawable(getContext(), R.drawable.nad_tag_icon), (int) getResources().getDimension(R.dimen.nad_dimen_100dp));
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public void setData(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, adBaseModel) == null) {
            if (!u(adBaseModel)) {
                setVisibility(8);
                return;
            }
            setTag(adBaseModel);
            setVisibility(0);
            o(adBaseModel);
            w(adBaseModel);
            i();
            r(adBaseModel);
            t(adBaseModel);
            x(adBaseModel);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || !(getTag() instanceof AdBaseModel)) {
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, textPaint)) == null) {
            return u51.b(str, "", (int) (((int) (b51.c.e(getContext()) - getResources().getDimension(R.dimen.nad_dimen_15dp))) - getResources().getDimension(R.dimen.nad_dimen_11dp)), textPaint);
        }
        return (String) invokeLL.objValue;
    }

    public void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, context) == null) {
            LayoutInflater.from(context).inflate(getLayoutId(), this);
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
        if (interceptable == null || interceptable.invokeL(1048589, this, adBaseModel) == null) {
            nd1<View> nd1Var = this.j;
            if (nd1Var != null) {
                nd1Var.a();
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
            AdEnhanceButtonView adEnhanceButtonView = new AdEnhanceButtonView(nj0.b(), this.k, findViewById);
            this.j = adEnhanceButtonView;
            ji0 ji0Var = new ji0(adBaseModel, adEnhanceButtonView);
            this.l = ji0Var;
            ji0Var.h(this.h);
            this.j.setEnhanceBtnListener(this.l);
            this.j.setData(adBaseModel.m);
            this.j.setBtnIconNightModeEnable(false);
        }
    }

    public void setAdInfoVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
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

    public void z(ClogBuilder.LogType logType, String str, AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048609, this, logType, str, adBaseModel) == null) && adBaseModel != null && !TextUtils.isEmpty(adBaseModel.f.d)) {
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
            n21.b(clogBuilder);
        }
    }
}
