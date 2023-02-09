package com.baidu.nadcore.lp.reward.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.MonitorUrl;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.nadcore.widget.txt.UnifyTextView;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.tieba.R;
import com.baidu.tieba.ar0;
import com.baidu.tieba.b51;
import com.baidu.tieba.cr0;
import com.baidu.tieba.fr0;
import com.baidu.tieba.n21;
import com.baidu.tieba.o21;
import com.baidu.tieba.ph0;
import com.baidu.tieba.pr0;
import com.baidu.tieba.ro0;
import com.baidu.tieba.sm0;
import com.baidu.tieba.tq0;
import com.baidu.tieba.wi0;
import com.baidu.tieba.wm0;
import com.baidu.tieba.xq0;
import com.baidu.tieba.y41;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010R\u001a\u00020Q\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010S\u0012\b\b\u0002\u0010V\u001a\u00020U¢\u0006\u0004\bW\u0010XJ)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0014\u0010\u0013J\u0019\u0010\u0015\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0015\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0016\u0010\u0013J\u001b\u0010\u0019\u001a\u00020\u00072\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001b\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u001b\u0010\u0013J\u0019\u0010\u001c\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u001c\u0010\u0013J\u0019\u0010\u001d\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u001d\u0010\u0013R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u001eR\u001d\u0010$\u001a\u00020\u001f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0018\u0010%\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u001d\u0010+\u001a\u00020'8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010!\u001a\u0004\b)\u0010*R\u001d\u0010.\u001a\u00020\u001f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010!\u001a\u0004\b-\u0010#R\u001d\u00103\u001a\u00020/8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010!\u001a\u0004\b1\u00102R\u001d\u00108\u001a\u0002048B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010!\u001a\u0004\b6\u00107R\u001d\u0010;\u001a\u00020\u001f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010!\u001a\u0004\b:\u0010#R\u001d\u0010@\u001a\u00020<8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010!\u001a\u0004\b>\u0010?R\u001d\u0010C\u001a\u0002048B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u0010!\u001a\u0004\bB\u00107R\u001d\u0010H\u001a\u00020D8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010!\u001a\u0004\bF\u0010GR\u001e\u0010I\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u001d\u0010M\u001a\u00020/8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bK\u0010!\u001a\u0004\bL\u00102R\u001d\u0010P\u001a\u00020/8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bN\u0010!\u001a\u0004\bO\u00102¨\u0006Y"}, d2 = {"Lcom/baidu/nadcore/lp/reward/view/NadRewardHalfTailView;", "Landroid/widget/RelativeLayout;", "", DnsModel.AREA_KEY, "Lcom/baidu/nadcore/stats/request/ClogBuilder$LogType;", "logType", "scheme", "", "handleClick", "(Ljava/lang/String;Lcom/baidu/nadcore/stats/request/ClogBuilder$LogType;Ljava/lang/String;)V", "Lcom/baidu/nadcore/lp/reward/inerface/IClickInterceptor;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "registerClickInterceptor", "(Lcom/baidu/nadcore/lp/reward/inerface/IClickInterceptor;)V", "registerRewardTaskEvent", "()V", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "adModel", "setAvatar", "(Lcom/baidu/nadcore/model/AdRewardVideoLpModel;)V", "setData", "setDetailButton", "setMoreButton", "Lkotlin/Function0;", WebChromeClient.KEY_ARG_CALLBACK, "setOnReplayClickListener", "(Lkotlin/Function0;)V", "setReplayButton", "setSubTitle", com.alipay.sdk.widget.d.o, "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "Lcom/baidu/nadcore/widget/AdImageView;", "avatar$delegate", "Lkotlin/Lazy;", "getAvatar", "()Lcom/baidu/nadcore/widget/AdImageView;", "avatar", "clickInterceptor", "Lcom/baidu/nadcore/lp/reward/inerface/IClickInterceptor;", "Landroid/view/View;", "detailBtn$delegate", "getDetailBtn", "()Landroid/view/View;", "detailBtn", "detailBtnIcon$delegate", "getDetailBtnIcon", "detailBtnIcon", "Landroid/widget/TextView;", "detailBtnText$delegate", "getDetailBtnText", "()Landroid/widget/TextView;", "detailBtnText", "Landroid/widget/LinearLayout;", "moreBtnContainer$delegate", "getMoreBtnContainer", "()Landroid/widget/LinearLayout;", "moreBtnContainer", "moreBtnIcon$delegate", "getMoreBtnIcon", "moreBtnIcon", "Lcom/baidu/nadcore/widget/txt/UnifyTextView;", "moreBtnText$delegate", "getMoreBtnText", "()Lcom/baidu/nadcore/widget/txt/UnifyTextView;", "moreBtnText", "replayBtn$delegate", "getReplayBtn", "replayBtn", "Landroid/widget/ImageView;", "replayBtnIcon$delegate", "getReplayBtnIcon", "()Landroid/widget/ImageView;", "replayBtnIcon", "replayClickListener", "Lkotlin/Function0;", "subTitle$delegate", "getSubTitle", "subTitle", "title$delegate", "getTitle", "title", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class NadRewardHalfTailView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public xq0 l;
    public Function0<Unit> m;
    public ro0 n;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NadRewardHalfTailView(Context context) {
        this(context, null, 0, 6, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NadRewardHalfTailView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private final AdImageView getAvatar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) ? (AdImageView) this.a.getValue() : (AdImageView) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View getDetailBtn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) ? (View) this.d.getValue() : (View) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AdImageView getDetailBtnIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) ? (AdImageView) this.e.getValue() : (AdImageView) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getDetailBtnText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) ? (TextView) this.f.getValue() : (TextView) invokeV.objValue;
    }

    private final LinearLayout getMoreBtnContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) ? (LinearLayout) this.i.getValue() : (LinearLayout) invokeV.objValue;
    }

    private final AdImageView getMoreBtnIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) ? (AdImageView) this.j.getValue() : (AdImageView) invokeV.objValue;
    }

    private final UnifyTextView getMoreBtnText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) ? (UnifyTextView) this.k.getValue() : (UnifyTextView) invokeV.objValue;
    }

    private final LinearLayout getReplayBtn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) ? (LinearLayout) this.g.getValue() : (LinearLayout) invokeV.objValue;
    }

    private final ImageView getReplayBtnIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) ? (ImageView) this.h.getValue() : (ImageView) invokeV.objValue;
    }

    private final TextView getSubTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, this)) == null) ? (TextView) this.c.getValue() : (TextView) invokeV.objValue;
    }

    private final TextView getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) ? (TextView) this.b.getValue() : (TextView) invokeV.objValue;
    }

    /* loaded from: classes2.dex */
    public static final class a extends wm0<ph0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardHalfTailView b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(NadRewardHalfTailView nadRewardHalfTailView, Class cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardHalfTailView, cls};
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
            this.b = nadRewardHalfTailView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wm0
        public void onEvent(ph0 event) {
            String str;
            tq0 tq0Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (!Intrinsics.areEqual(event.a, "4")) {
                    return;
                }
                if (!event.h) {
                    String str2 = event.f;
                    if (str2 != null) {
                        this.b.getDetailBtnIcon().g(str2);
                    }
                    String str3 = event.g;
                    if (str3 != null) {
                        this.b.getDetailBtnText().setText(str3);
                    }
                    if (event.d != null && event.e != null) {
                        Drawable background = this.b.getDetailBtn().getBackground();
                        if (background != null) {
                            GradientDrawable gradientDrawable = (GradientDrawable) background;
                            gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                            gradientDrawable.setColors(new int[]{y41.a(event.d, R.color.nad_reward_full_tail_btn_color), y41.a(event.e, R.color.nad_reward_full_tail_btn_color)});
                            this.b.getDetailBtn().setBackground(gradientDrawable);
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                        }
                    }
                    ClogBuilder u = new ClogBuilder().y(ClogBuilder.LogType.REWARD_SHOW_TASK).u(ClogBuilder.Page.WELFARETAIL);
                    xq0 xq0Var = this.b.l;
                    if (xq0Var != null && (tq0Var = xq0Var.f) != null) {
                        str = tq0Var.d;
                    } else {
                        str = null;
                    }
                    n21.b(u.p(str).k("4").l(event.c));
                    return;
                }
                xq0 xq0Var2 = this.b.l;
                if (xq0Var2 == null) {
                    return;
                }
                this.b.setDetailButton(xq0Var2);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardHalfTailView a;
        public final /* synthetic */ xq0 b;

        public b(NadRewardHalfTailView nadRewardHalfTailView, xq0 xq0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardHalfTailView, xq0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardHalfTailView;
            this.b = xq0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            ar0 ar0Var;
            cr0 cr0Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                NadRewardHalfTailView nadRewardHalfTailView = this.a;
                ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
                xq0 xq0Var = this.b;
                if (xq0Var != null && (ar0Var = xq0Var.j) != null && (cr0Var = ar0Var.h) != null) {
                    str = cr0Var.f;
                } else {
                    str = null;
                }
                nadRewardHalfTailView.h("icon", logType, str);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardHalfTailView a;
        public final /* synthetic */ xq0 b;

        public c(NadRewardHalfTailView nadRewardHalfTailView, xq0 xq0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardHalfTailView, xq0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardHalfTailView;
            this.b = xq0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            ar0 ar0Var;
            cr0 cr0Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                NadRewardHalfTailView nadRewardHalfTailView = this.a;
                ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
                xq0 xq0Var = this.b;
                if (xq0Var != null && (ar0Var = xq0Var.j) != null && (cr0Var = ar0Var.h) != null) {
                    str = cr0Var.f;
                } else {
                    str = null;
                }
                nadRewardHalfTailView.h("detailbtn", logType, str);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardHalfTailView a;
        public final /* synthetic */ xq0 b;

        public d(NadRewardHalfTailView nadRewardHalfTailView, xq0 xq0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardHalfTailView, xq0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardHalfTailView;
            this.b = xq0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            ar0 ar0Var;
            cr0 cr0Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                NadRewardHalfTailView nadRewardHalfTailView = this.a;
                ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_CLICK;
                xq0 xq0Var = this.b;
                if (xq0Var != null && (ar0Var = xq0Var.j) != null && (cr0Var = ar0Var.h) != null) {
                    str = cr0Var.y;
                } else {
                    str = null;
                }
                nadRewardHalfTailView.h("morebtn", logType, str);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardHalfTailView a;

        public e(NadRewardHalfTailView nadRewardHalfTailView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardHalfTailView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardHalfTailView;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.h("replaybtn", ClogBuilder.LogType.FREE_CLICK, null);
            Function0 function0 = this.a.m;
            if (function0 != null) {
                Unit unit = (Unit) function0.invoke();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardHalfTailView a;
        public final /* synthetic */ xq0 b;

        public f(NadRewardHalfTailView nadRewardHalfTailView, xq0 xq0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardHalfTailView, xq0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardHalfTailView;
            this.b = xq0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            ar0 ar0Var;
            cr0 cr0Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                NadRewardHalfTailView nadRewardHalfTailView = this.a;
                ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
                xq0 xq0Var = this.b;
                if (xq0Var != null && (ar0Var = xq0Var.j) != null && (cr0Var = ar0Var.h) != null) {
                    str = cr0Var.f;
                } else {
                    str = null;
                }
                nadRewardHalfTailView.h("tail_subtitle", logType, str);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardHalfTailView a;
        public final /* synthetic */ xq0 b;

        public g(NadRewardHalfTailView nadRewardHalfTailView, xq0 xq0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardHalfTailView, xq0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardHalfTailView;
            this.b = xq0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            ar0 ar0Var;
            cr0 cr0Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                NadRewardHalfTailView nadRewardHalfTailView = this.a;
                ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
                xq0 xq0Var = this.b;
                if (xq0Var != null && (ar0Var = xq0Var.j) != null && (cr0Var = ar0Var.h) != null) {
                    str = cr0Var.f;
                } else {
                    str = null;
                }
                nadRewardHalfTailView.h("name", logType, str);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NadRewardHalfTailView(Context context, AttributeSet attributeSet, int i) {
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
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = LazyKt__LazyJVMKt.lazy(new Function0<AdImageView>(this) { // from class: com.baidu.nadcore.lp.reward.view.NadRewardHalfTailView$avatar$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NadRewardHalfTailView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AdImageView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    View findViewById = this.this$0.findViewById(R.id.obfuscated_res_0x7f09030e);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.avatar)");
                    return (AdImageView) findViewById;
                }
                return (AdImageView) invokeV.objValue;
            }
        });
        this.b = LazyKt__LazyJVMKt.lazy(new Function0<TextView>(this) { // from class: com.baidu.nadcore.lp.reward.view.NadRewardHalfTailView$title$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NadRewardHalfTailView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    View findViewById = this.this$0.findViewById(R.id.obfuscated_res_0x7f09235b);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.title)");
                    return (TextView) findViewById;
                }
                return (TextView) invokeV.objValue;
            }
        });
        this.c = LazyKt__LazyJVMKt.lazy(new Function0<TextView>(this) { // from class: com.baidu.nadcore.lp.reward.view.NadRewardHalfTailView$subTitle$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NadRewardHalfTailView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    View findViewById = this.this$0.findViewById(R.id.sub_title);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.sub_title)");
                    return (TextView) findViewById;
                }
                return (TextView) invokeV.objValue;
            }
        });
        this.d = LazyKt__LazyJVMKt.lazy(new Function0<View>(this) { // from class: com.baidu.nadcore.lp.reward.view.NadRewardHalfTailView$detailBtn$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NadRewardHalfTailView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    View findViewById = this.this$0.findViewById(R.id.detail_btn);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.detail_btn)");
                    return findViewById;
                }
                return (View) invokeV.objValue;
            }
        });
        this.e = LazyKt__LazyJVMKt.lazy(new Function0<AdImageView>(this) { // from class: com.baidu.nadcore.lp.reward.view.NadRewardHalfTailView$detailBtnIcon$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NadRewardHalfTailView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AdImageView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    View findViewById = this.this$0.findViewById(R.id.detail_btn_icon);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.detail_btn_icon)");
                    return (AdImageView) findViewById;
                }
                return (AdImageView) invokeV.objValue;
            }
        });
        this.f = LazyKt__LazyJVMKt.lazy(new Function0<TextView>(this) { // from class: com.baidu.nadcore.lp.reward.view.NadRewardHalfTailView$detailBtnText$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NadRewardHalfTailView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    View findViewById = this.this$0.findViewById(R.id.detail_btn_text);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.detail_btn_text)");
                    return (TextView) findViewById;
                }
                return (TextView) invokeV.objValue;
            }
        });
        this.g = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>(this) { // from class: com.baidu.nadcore.lp.reward.view.NadRewardHalfTailView$replayBtn$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NadRewardHalfTailView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    View findViewById = this.this$0.findViewById(R.id.replay_btn);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.replay_btn)");
                    return (LinearLayout) findViewById;
                }
                return (LinearLayout) invokeV.objValue;
            }
        });
        this.h = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>(this) { // from class: com.baidu.nadcore.lp.reward.view.NadRewardHalfTailView$replayBtnIcon$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NadRewardHalfTailView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    View findViewById = this.this$0.findViewById(R.id.replay_btn_icon);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.replay_btn_icon)");
                    return (ImageView) findViewById;
                }
                return (ImageView) invokeV.objValue;
            }
        });
        this.i = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>(this) { // from class: com.baidu.nadcore.lp.reward.view.NadRewardHalfTailView$moreBtnContainer$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NadRewardHalfTailView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    View findViewById = this.this$0.findViewById(R.id.more_btn_container);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.more_btn_container)");
                    return (LinearLayout) findViewById;
                }
                return (LinearLayout) invokeV.objValue;
            }
        });
        this.j = LazyKt__LazyJVMKt.lazy(new Function0<AdImageView>(this) { // from class: com.baidu.nadcore.lp.reward.view.NadRewardHalfTailView$moreBtnIcon$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NadRewardHalfTailView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AdImageView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    View findViewById = this.this$0.findViewById(R.id.more_btn_icon);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.more_btn_icon)");
                    return (AdImageView) findViewById;
                }
                return (AdImageView) invokeV.objValue;
            }
        });
        this.k = LazyKt__LazyJVMKt.lazy(new Function0<UnifyTextView>(this) { // from class: com.baidu.nadcore.lp.reward.view.NadRewardHalfTailView$moreBtnText$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NadRewardHalfTailView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final UnifyTextView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    View findViewById = this.this$0.findViewById(R.id.more_btn_text);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.more_btn_text)");
                    return (UnifyTextView) findViewById;
                }
                return (UnifyTextView) invokeV.objValue;
            }
        });
        LayoutInflater.from(context).inflate(R.layout.nad_reward_half_tail, this);
    }

    public /* synthetic */ NadRewardHalfTailView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void setAvatar(xq0 xq0Var) {
        String str;
        ar0 ar0Var;
        cr0 cr0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, this, xq0Var) == null) {
            AdImageView avatar = getAvatar();
            if (xq0Var != null && (ar0Var = xq0Var.j) != null && (cr0Var = ar0Var.h) != null) {
                str = cr0Var.d;
            } else {
                str = null;
            }
            avatar.g(str);
            avatar.setOnClickListener(new b(this, xq0Var));
        }
    }

    public final void i(ro0 listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, listener) == null) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.n = listener;
        }
    }

    public final void setData(xq0 xq0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, xq0Var) == null) {
            this.l = xq0Var;
            setAvatar(xq0Var);
            setTitle(xq0Var);
            setSubTitle(xq0Var);
            setDetailButton(xq0Var);
            setReplayButton(xq0Var);
            setMoreButton(xq0Var);
            j();
        }
    }

    public final void setOnReplayClickListener(Function0<Unit> callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, callback) == null) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.m = callback;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDetailButton(xq0 xq0Var) {
        String str;
        String str2;
        String str3;
        boolean z;
        String str4;
        ar0 ar0Var;
        cr0 cr0Var;
        ar0 ar0Var2;
        cr0 cr0Var2;
        String str5;
        String str6;
        ar0 ar0Var3;
        cr0 cr0Var3;
        ar0 ar0Var4;
        cr0 cr0Var4;
        ar0 ar0Var5;
        cr0 cr0Var5;
        fr0 b2;
        ar0 ar0Var6;
        cr0 cr0Var6;
        ar0 ar0Var7;
        cr0 cr0Var7;
        ar0 ar0Var8;
        cr0 cr0Var8;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, this, xq0Var) == null) {
            View detailBtn = getDetailBtn();
            int a2 = b51.c.a(detailBtn.getContext(), 16.5f);
            GradientDrawable gradientDrawable = new GradientDrawable();
            String str7 = null;
            if (xq0Var != null && (ar0Var8 = xq0Var.j) != null && (cr0Var8 = ar0Var8.h) != null) {
                str = cr0Var8.h;
            } else {
                str = null;
            }
            gradientDrawable.setColor(y41.a(str, R.color.nad_reward_full_tail_btn_color));
            gradientDrawable.setCornerRadius(a2);
            Unit unit = Unit.INSTANCE;
            detailBtn.setBackground(gradientDrawable);
            if (xq0Var != null && (ar0Var7 = xq0Var.j) != null && (cr0Var7 = ar0Var7.h) != null) {
                str2 = cr0Var7.b;
            } else {
                str2 = null;
            }
            int i = 8;
            boolean z2 = false;
            if (Intrinsics.areEqual(str2, "detail")) {
                detailBtn.setVisibility(0);
            } else {
                detailBtn.setVisibility(8);
            }
            detailBtn.setOnClickListener(new c(this, xq0Var));
            AdImageView detailBtnIcon = getDetailBtnIcon();
            if (xq0Var != null && (ar0Var6 = xq0Var.j) != null && (cr0Var6 = ar0Var6.h) != null && cr0Var6.C) {
                detailBtnIcon.setImageResource(R.drawable.nad_reward_detail_btn_dp_icon);
                n21.b(new ClogBuilder().j("openbtn").y(ClogBuilder.LogType.FREE_SHOW).u(ClogBuilder.Page.WELFAREMAXLP).p(xq0Var.f.d));
            } else {
                if (xq0Var != null && (ar0Var2 = xq0Var.j) != null && (cr0Var2 = ar0Var2.h) != null) {
                    str3 = cr0Var2.i;
                } else {
                    str3 = null;
                }
                if (str3 != null && !StringsKt__StringsJVMKt.isBlank(str3)) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    if (xq0Var != null && (ar0Var = xq0Var.j) != null && (cr0Var = ar0Var.h) != null) {
                        str4 = cr0Var.i;
                    } else {
                        str4 = null;
                    }
                    detailBtnIcon.g(str4);
                } else {
                    detailBtnIcon.setImageResource(R.drawable.nad_reward_detail_btn_icon);
                }
            }
            detailBtnIcon.setVisibility((xq0Var == null || (b2 = xq0Var.b()) == null || !b2.c()) ? 0 : 0);
            TextView detailBtnText = getDetailBtnText();
            if (xq0Var != null && (ar0Var5 = xq0Var.j) != null && (cr0Var5 = ar0Var5.h) != null && cr0Var5.C) {
                str6 = detailBtnText.getContext().getString(R.string.nad_reward_detail_btn_open_app);
            } else {
                if (xq0Var != null && (ar0Var4 = xq0Var.j) != null && (cr0Var4 = ar0Var4.h) != null) {
                    str5 = cr0Var4.g;
                } else {
                    str5 = null;
                }
                if (!((str5 == null || StringsKt__StringsJVMKt.isBlank(str5)) ? true : true)) {
                    if (xq0Var != null && (ar0Var3 = xq0Var.j) != null && (cr0Var3 = ar0Var3.h) != null) {
                        str7 = cr0Var3.g;
                    }
                } else {
                    str7 = detailBtnText.getContext().getString(R.string.nad_reward_detail_btn_text);
                }
                str6 = str7;
            }
            detailBtnText.setText(str6);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x004f, code lost:
        if (r4 == false) goto L110;
     */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void setMoreButton(xq0 xq0Var) {
        String str;
        boolean z;
        boolean z2;
        String str2;
        boolean z3;
        ar0 ar0Var;
        cr0 cr0Var;
        ar0 ar0Var2;
        cr0 cr0Var2;
        LinearLayout linearLayout;
        AdImageView moreBtnIcon;
        String str3;
        boolean z4;
        UnifyTextView moreBtnText;
        String str4;
        String str5;
        boolean z5;
        ar0 ar0Var3;
        cr0 cr0Var3;
        ar0 ar0Var4;
        cr0 cr0Var4;
        ar0 ar0Var5;
        cr0 cr0Var5;
        String str6;
        ar0 ar0Var6;
        cr0 cr0Var6;
        ar0 ar0Var7;
        cr0 cr0Var7;
        String str7;
        ar0 ar0Var8;
        cr0 cr0Var8;
        pr0 g2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, this, xq0Var) == null) {
            LinearLayout moreBtnContainer = getMoreBtnContainer();
            String str8 = null;
            if (xq0Var == null || (g2 = xq0Var.g()) == null || !g2.d()) {
                if (xq0Var != null && (ar0Var2 = xq0Var.j) != null && (cr0Var2 = ar0Var2.h) != null) {
                    str = cr0Var2.w;
                } else {
                    str = null;
                }
                if (str != null && str.length() != 0) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    if (xq0Var != null && (ar0Var = xq0Var.j) != null && (cr0Var = ar0Var.h) != null) {
                        str2 = cr0Var.x;
                    } else {
                        str2 = null;
                    }
                    if (str2 != null && str2.length() != 0) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                }
                z2 = true;
                if (!z2) {
                    moreBtnContainer.setVisibility(0);
                    linearLayout = moreBtnContainer;
                } else {
                    moreBtnContainer.setVisibility(8);
                    linearLayout = null;
                }
                if (linearLayout != null) {
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setCornerRadius(b51.c.a(moreBtnContainer.getContext(), 17.0f));
                    if (xq0Var != null && (ar0Var8 = xq0Var.j) != null && (cr0Var8 = ar0Var8.h) != null) {
                        str7 = cr0Var8.z;
                    } else {
                        str7 = null;
                    }
                    gradientDrawable.setStroke(2, y41.a(str7, R.color.nad_reward_half_tail_more_btn_border));
                    Unit unit = Unit.INSTANCE;
                    linearLayout.setBackground(gradientDrawable);
                }
                moreBtnContainer.setOnClickListener(new d(this, xq0Var));
                moreBtnIcon = getMoreBtnIcon();
                if (xq0Var == null && (ar0Var7 = xq0Var.j) != null && (cr0Var7 = ar0Var7.h) != null) {
                    str3 = cr0Var7.w;
                } else {
                    str3 = null;
                }
                if (str3 == null && str3.length() != 0) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                if (!(!z4)) {
                    moreBtnIcon.setVisibility(0);
                } else {
                    moreBtnIcon.setVisibility(8);
                    moreBtnIcon = null;
                }
                if (moreBtnIcon != null) {
                    if (xq0Var != null && (ar0Var6 = xq0Var.j) != null && (cr0Var6 = ar0Var6.h) != null) {
                        str6 = cr0Var6.w;
                    } else {
                        str6 = null;
                    }
                    moreBtnIcon.g(str6);
                }
                moreBtnText = getMoreBtnText();
                if (xq0Var == null && (ar0Var5 = xq0Var.j) != null && (cr0Var5 = ar0Var5.h) != null) {
                    str4 = cr0Var5.A;
                } else {
                    str4 = null;
                }
                moreBtnText.setTextColor(y41.a(str4, R.color.nad_reward_half_tail_more_text_color));
                if (xq0Var == null && (ar0Var4 = xq0Var.j) != null && (cr0Var4 = ar0Var4.h) != null) {
                    str5 = cr0Var4.x;
                } else {
                    str5 = null;
                }
                if (str5 == null && str5.length() != 0) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                if (!(true ^ z5)) {
                    moreBtnText.setVisibility(0);
                } else {
                    moreBtnText.setVisibility(8);
                    moreBtnText = null;
                }
                if (moreBtnText == null) {
                    if (xq0Var != null && (ar0Var3 = xq0Var.j) != null && (cr0Var3 = ar0Var3.h) != null) {
                        str8 = cr0Var3.x;
                    }
                    moreBtnText.setText(str8);
                    return;
                }
                return;
            }
            z2 = false;
            if (!z2) {
            }
            if (linearLayout != null) {
            }
            moreBtnContainer.setOnClickListener(new d(this, xq0Var));
            moreBtnIcon = getMoreBtnIcon();
            if (xq0Var == null) {
            }
            str3 = null;
            if (str3 == null) {
            }
            z4 = true;
            if (!(!z4)) {
            }
            if (moreBtnIcon != null) {
            }
            moreBtnText = getMoreBtnText();
            if (xq0Var == null) {
            }
            str4 = null;
            moreBtnText.setTextColor(y41.a(str4, R.color.nad_reward_half_tail_more_text_color));
            if (xq0Var == null) {
            }
            str5 = null;
            if (str5 == null) {
            }
            z5 = true;
            if (!(true ^ z5)) {
            }
            if (moreBtnText == null) {
            }
        }
    }

    private final void setReplayButton(xq0 xq0Var) {
        int i;
        fr0 b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, this, xq0Var) == null) {
            getReplayBtn().setOnClickListener(new e(this));
            ImageView replayBtnIcon = getReplayBtnIcon();
            if (xq0Var != null && (b2 = xq0Var.b()) != null && b2.c()) {
                i = 8;
            } else {
                i = 0;
            }
            replayBtnIcon.setVisibility(i);
        }
    }

    private final void setSubTitle(xq0 xq0Var) {
        String str;
        boolean z;
        ar0 ar0Var;
        cr0 cr0Var;
        ar0 ar0Var2;
        cr0 cr0Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, this, xq0Var) == null) {
            TextView subTitle = getSubTitle();
            String str2 = null;
            if (xq0Var != null && (ar0Var2 = xq0Var.j) != null && (cr0Var2 = ar0Var2.h) != null) {
                str = cr0Var2.m;
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                if (xq0Var != null && (ar0Var = xq0Var.j) != null && (cr0Var = ar0Var.h) != null) {
                    str2 = cr0Var.m;
                }
                subTitle.setText(str2);
            }
            subTitle.setOnClickListener(new f(this, xq0Var));
        }
    }

    private final void setTitle(xq0 xq0Var) {
        String str;
        boolean z;
        ar0 ar0Var;
        cr0 cr0Var;
        ar0 ar0Var2;
        cr0 cr0Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, this, xq0Var) == null) {
            TextView title = getTitle();
            String str2 = null;
            if (xq0Var != null && (ar0Var2 = xq0Var.j) != null && (cr0Var2 = ar0Var2.h) != null) {
                str = cr0Var2.l;
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                if (xq0Var != null && (ar0Var = xq0Var.j) != null && (cr0Var = ar0Var.h) != null) {
                    str2 = cr0Var.l;
                }
                title.setText(str2);
            }
            title.setOnClickListener(new g(this, xq0Var));
        }
    }

    public final void h(String str, ClogBuilder.LogType logType, String str2) {
        String str3;
        xq0 xq0Var;
        List<MonitorUrl> list;
        boolean z;
        tq0 tq0Var;
        ar0 ar0Var;
        cr0 cr0Var;
        ro0 ro0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, logType, str2) == null) {
            xq0 xq0Var2 = this.l;
            boolean z2 = true;
            if (xq0Var2 != null && (ar0Var = xq0Var2.j) != null && (cr0Var = ar0Var.h) != null && !cr0Var.C && (ro0Var = this.n) != null && ro0Var.a(str, logType, str2)) {
                return;
            }
            ClogBuilder u = new ClogBuilder().j(str).y(logType).u(ClogBuilder.Page.WELFARETAIL);
            xq0 xq0Var3 = this.l;
            if (xq0Var3 != null && (tq0Var = xq0Var3.f) != null) {
                str3 = tq0Var.d;
            } else {
                str3 = null;
            }
            n21.b(u.p(str3));
            if (logType == ClogBuilder.LogType.CLICK && (xq0Var = this.l) != null && (list = xq0Var.e) != null) {
                ArrayList<MonitorUrl> arrayList = new ArrayList();
                for (Object obj : list) {
                    String str4 = ((MonitorUrl) obj).clickUrl;
                    if (str4 != null && !StringsKt__StringsJVMKt.isBlank(str4)) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        arrayList.add(obj);
                    }
                }
                for (MonitorUrl monitorUrl : arrayList) {
                    o21.b(monitorUrl.clickUrl);
                }
            }
            if (str2 != null && str2.length() != 0) {
                z2 = false;
            }
            if (!z2) {
                wi0.c(str2, getContext());
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            sm0.a().b(this, new a(this, ph0.class));
        }
    }
}
