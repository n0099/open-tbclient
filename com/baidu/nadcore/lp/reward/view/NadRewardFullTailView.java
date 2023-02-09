package com.baidu.nadcore.lp.reward.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.business.uitemplate.NadMiniVideoDownloadView;
import com.baidu.nadcore.model.MonitorUrl;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.nadcore.widget.txt.UnifyTextView;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.tieba.R;
import com.baidu.tieba.ar0;
import com.baidu.tieba.b51;
import com.baidu.tieba.cl0;
import com.baidu.tieba.cr0;
import com.baidu.tieba.er0;
import com.baidu.tieba.fr0;
import com.baidu.tieba.ii0;
import com.baidu.tieba.jj0;
import com.baidu.tieba.ki0;
import com.baidu.tieba.lq0;
import com.baidu.tieba.n21;
import com.baidu.tieba.o21;
import com.baidu.tieba.pq0;
import com.baidu.tieba.s41;
import com.baidu.tieba.so0;
import com.baidu.tieba.tq0;
import com.baidu.tieba.wi0;
import com.baidu.tieba.xq0;
import com.baidu.tieba.y41;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010]\u001a\u00020\\\u0012\n\b\u0002\u0010_\u001a\u0004\u0018\u00010^\u0012\b\b\u0002\u0010a\u001a\u00020`¢\u0006\u0004\bb\u0010cJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0014\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0015\u0010\u0011J\u001d\u0010\u0018\u001a\u00020\u000b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001a\u0010\u0011J\u0017\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001b\u0010\u0011J\u0017\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001c\u0010\u0011J\u0017\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010!R\u001d\u0010'\u001a\u00020\"8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001d\u0010,\u001a\u00020(8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010$\u001a\u0004\b*\u0010+R\u001d\u00101\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010$\u001a\u0004\b/\u00100R\u001d\u00106\u001a\u0002028B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010$\u001a\u0004\b4\u00105R\u0018\u00108\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u001d\u0010<\u001a\u00020\"8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010$\u001a\u0004\b;\u0010&R\u001d\u0010?\u001a\u00020(8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010$\u001a\u0004\b>\u0010+R\u001d\u0010B\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010$\u001a\u0004\bA\u00100R\u001d\u0010E\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010$\u001a\u0004\bD\u00100R\u001d\u0010H\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u0010$\u001a\u0004\bG\u00100R\u001d\u0010M\u001a\u00020I8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010$\u001a\u0004\bK\u0010LR\u001d\u0010P\u001a\u00020\"8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bN\u0010$\u001a\u0004\bO\u0010&R\u001e\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u001d\u0010U\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bS\u0010$\u001a\u0004\bT\u00100R\u001d\u0010X\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bV\u0010$\u001a\u0004\bW\u00100R\u001d\u0010[\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bY\u0010$\u001a\u0004\bZ\u00100¨\u0006d"}, d2 = {"Lcom/baidu/nadcore/lp/reward/view/NadRewardFullTailView;", "Lcom/baidu/tieba/so0;", "Landroid/widget/RelativeLayout;", "Landroid/view/ViewGroup;", "getView", "()Landroid/view/ViewGroup;", "", DnsModel.AREA_KEY, "Lcom/baidu/nadcore/stats/request/ClogBuilder$LogType;", "logType", "scheme", "", "handleClick", "(Ljava/lang/String;Lcom/baidu/nadcore/stats/request/ClogBuilder$LogType;Ljava/lang/String;)V", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "adModel", "setAppInfo", "(Lcom/baidu/nadcore/model/AdRewardVideoLpModel;)V", "setAvatar", "setData", "setDownloadButton", "setMoreButton", "Lkotlin/Function0;", WebChromeClient.KEY_ARG_CALLBACK, "setOnReplayClickListener", "(Lkotlin/Function0;)V", "setReplayButton", "setSubTitle", com.alipay.sdk.widget.d.o, "", "isVisible", "setVisibility", "(Z)V", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "Landroid/widget/LinearLayout;", "appInfoView$delegate", "Lkotlin/Lazy;", "getAppInfoView", "()Landroid/widget/LinearLayout;", "appInfoView", "Lcom/baidu/nadcore/widget/AdImageView;", "avatar$delegate", "getAvatar", "()Lcom/baidu/nadcore/widget/AdImageView;", "avatar", "Lcom/baidu/nadcore/widget/txt/UnifyTextView;", "developerName$delegate", "getDeveloperName", "()Lcom/baidu/nadcore/widget/txt/UnifyTextView;", "developerName", "Lcom/baidu/nadcore/business/uitemplate/NadMiniVideoDownloadView;", "downloadButton$delegate", "getDownloadButton", "()Lcom/baidu/nadcore/business/uitemplate/NadMiniVideoDownloadView;", "downloadButton", "Lcom/baidu/nadcore/business/presenter/NadRewardDownloadPresenter;", "downloadPresenter", "Lcom/baidu/nadcore/business/presenter/NadRewardDownloadPresenter;", "moreBtnContainer$delegate", "getMoreBtnContainer", "moreBtnContainer", "moreBtnIcon$delegate", "getMoreBtnIcon", "moreBtnIcon", "moreBtnText$delegate", "getMoreBtnText", "moreBtnText", "permissionView$delegate", "getPermissionView", "permissionView", "privacyView$delegate", "getPrivacyView", "privacyView", "Landroid/widget/ImageView;", "replayBtnIcon$delegate", "getReplayBtnIcon", "()Landroid/widget/ImageView;", "replayBtnIcon", "replayButton$delegate", "getReplayButton", "replayButton", "replayClickListener", "Lkotlin/Function0;", "subTitle$delegate", "getSubTitle", "subTitle", "title$delegate", "getTitle", "title", "version$delegate", WebChromeClient.MSG_METHOD_GETVERSION, "version", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "style", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class NadRewardFullTailView extends RelativeLayout implements so0 {
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
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public xq0 o;
    public Function0<Unit> p;
    public ii0 q;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NadRewardFullTailView(Context context) {
        this(context, null, 0, 6, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
    public NadRewardFullTailView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private final LinearLayout getAppInfoView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? (LinearLayout) this.j.getValue() : (LinearLayout) invokeV.objValue;
    }

    private final AdImageView getAvatar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) ? (AdImageView) this.a.getValue() : (AdImageView) invokeV.objValue;
    }

    private final UnifyTextView getDeveloperName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) ? (UnifyTextView) this.l.getValue() : (UnifyTextView) invokeV.objValue;
    }

    private final NadMiniVideoDownloadView getDownloadButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? (NadMiniVideoDownloadView) this.d.getValue() : (NadMiniVideoDownloadView) invokeV.objValue;
    }

    private final LinearLayout getMoreBtnContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) ? (LinearLayout) this.g.getValue() : (LinearLayout) invokeV.objValue;
    }

    private final AdImageView getMoreBtnIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) ? (AdImageView) this.h.getValue() : (AdImageView) invokeV.objValue;
    }

    private final UnifyTextView getMoreBtnText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) ? (UnifyTextView) this.i.getValue() : (UnifyTextView) invokeV.objValue;
    }

    private final UnifyTextView getPermissionView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) ? (UnifyTextView) this.n.getValue() : (UnifyTextView) invokeV.objValue;
    }

    private final UnifyTextView getPrivacyView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) ? (UnifyTextView) this.m.getValue() : (UnifyTextView) invokeV.objValue;
    }

    private final ImageView getReplayBtnIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) ? (ImageView) this.f.getValue() : (ImageView) invokeV.objValue;
    }

    private final LinearLayout getReplayButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) ? (LinearLayout) this.e.getValue() : (LinearLayout) invokeV.objValue;
    }

    private final UnifyTextView getSubTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) ? (UnifyTextView) this.c.getValue() : (UnifyTextView) invokeV.objValue;
    }

    private final UnifyTextView getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) ? (UnifyTextView) this.b.getValue() : (UnifyTextView) invokeV.objValue;
    }

    private final UnifyTextView getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, this)) == null) ? (UnifyTextView) this.k.getValue() : (UnifyTextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.so0
    public ViewGroup getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this : (ViewGroup) invokeV.objValue;
    }

    /* loaded from: classes2.dex */
    public static final class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnifyTextView a;
        public final /* synthetic */ xq0 b;

        public a(UnifyTextView unifyTextView, xq0 xq0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {unifyTextView, xq0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = unifyTextView;
            this.b = xq0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                Context context = this.a.getContext();
                er0 er0Var = this.b.i;
                if (er0Var != null) {
                    str = er0Var.f;
                } else {
                    str = null;
                }
                Toast.makeText(context, str, 0).show();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnifyTextView a;
        public final /* synthetic */ xq0 b;

        public b(UnifyTextView unifyTextView, xq0 xq0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {unifyTextView, xq0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = unifyTextView;
            this.b = xq0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                Context context = this.a.getContext();
                er0 er0Var = this.b.i;
                if (er0Var != null) {
                    str = er0Var.d;
                } else {
                    str = null;
                }
                Toast.makeText(context, str, 0).show();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnifyTextView a;
        public final /* synthetic */ NadRewardFullTailView b;
        public final /* synthetic */ xq0 c;

        public c(UnifyTextView unifyTextView, NadRewardFullTailView nadRewardFullTailView, xq0 xq0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {unifyTextView, nadRewardFullTailView, xq0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = unifyTextView;
            this.b = nadRewardFullTailView;
            this.c = xq0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            er0.b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                NadRewardFullTailView nadRewardFullTailView = this.b;
                String str2 = ClogBuilder.Area.APP_PRIVACY.type;
                Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.APP_PRIVACY.type");
                ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_CLICK;
                er0 er0Var = this.c.i;
                if (er0Var != null && (bVar = er0Var.g) != null) {
                    str = bVar.b;
                } else {
                    str = null;
                }
                nadRewardFullTailView.d(str2, logType, str);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnifyTextView a;
        public final /* synthetic */ NadRewardFullTailView b;
        public final /* synthetic */ xq0 c;

        public d(UnifyTextView unifyTextView, NadRewardFullTailView nadRewardFullTailView, xq0 xq0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {unifyTextView, nadRewardFullTailView, xq0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = unifyTextView;
            this.b = nadRewardFullTailView;
            this.c = xq0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            er0.a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                NadRewardFullTailView nadRewardFullTailView = this.b;
                String str2 = ClogBuilder.Area.APP_PERMISSION.type;
                Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.APP_PERMISSION.type");
                ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_CLICK;
                er0 er0Var = this.c.i;
                if (er0Var != null && (aVar = er0Var.h) != null) {
                    str = aVar.b;
                } else {
                    str = null;
                }
                nadRewardFullTailView.d(str2, logType, str);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardFullTailView a;
        public final /* synthetic */ xq0 b;

        public e(NadRewardFullTailView nadRewardFullTailView, xq0 xq0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardFullTailView, xq0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardFullTailView;
            this.b = xq0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            cr0 cr0Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                NadRewardFullTailView nadRewardFullTailView = this.a;
                ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
                ar0 ar0Var = this.b.j;
                if (ar0Var != null && (cr0Var = ar0Var.h) != null) {
                    str = cr0Var.f;
                } else {
                    str = null;
                }
                nadRewardFullTailView.d("icon", logType, str);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardFullTailView a;
        public final /* synthetic */ xq0 b;

        public f(NadRewardFullTailView nadRewardFullTailView, xq0 xq0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardFullTailView, xq0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardFullTailView;
            this.b = xq0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            ii0 ii0Var = this.a.q;
            if (ii0Var != null) {
                ii0Var.m();
            }
            ki0.b(this.b.e);
        }
    }

    /* loaded from: classes2.dex */
    public static final class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardFullTailView a;
        public final /* synthetic */ xq0 b;

        public g(NadRewardFullTailView nadRewardFullTailView, xq0 xq0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardFullTailView, xq0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardFullTailView;
            this.b = xq0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            cr0 cr0Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                NadRewardFullTailView nadRewardFullTailView = this.a;
                ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_CLICK;
                ar0 ar0Var = this.b.j;
                if (ar0Var != null && (cr0Var = ar0Var.h) != null) {
                    str = cr0Var.y;
                } else {
                    str = null;
                }
                nadRewardFullTailView.d("morebtn", logType, str);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardFullTailView a;

        public h(NadRewardFullTailView nadRewardFullTailView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardFullTailView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardFullTailView;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.d("replaybtn", ClogBuilder.LogType.FREE_CLICK, null);
            Function0 function0 = this.a.p;
            if (function0 != null) {
                Unit unit = (Unit) function0.invoke();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardFullTailView a;
        public final /* synthetic */ xq0 b;

        public i(NadRewardFullTailView nadRewardFullTailView, xq0 xq0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardFullTailView, xq0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardFullTailView;
            this.b = xq0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            cr0 cr0Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                NadRewardFullTailView nadRewardFullTailView = this.a;
                ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
                ar0 ar0Var = this.b.j;
                if (ar0Var != null && (cr0Var = ar0Var.h) != null) {
                    str = cr0Var.f;
                } else {
                    str = null;
                }
                nadRewardFullTailView.d("tail_subtitle", logType, str);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardFullTailView a;
        public final /* synthetic */ xq0 b;

        public j(NadRewardFullTailView nadRewardFullTailView, xq0 xq0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardFullTailView, xq0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardFullTailView;
            this.b = xq0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            cr0 cr0Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                NadRewardFullTailView nadRewardFullTailView = this.a;
                ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
                ar0 ar0Var = this.b.j;
                if (ar0Var != null && (cr0Var = ar0Var.h) != null) {
                    str = cr0Var.f;
                } else {
                    str = null;
                }
                nadRewardFullTailView.d("name", logType, str);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NadRewardFullTailView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = LazyKt__LazyJVMKt.lazy(new Function0<AdImageView>(this) { // from class: com.baidu.nadcore.lp.reward.view.NadRewardFullTailView$avatar$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NadRewardFullTailView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
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
        this.b = LazyKt__LazyJVMKt.lazy(new Function0<UnifyTextView>(this) { // from class: com.baidu.nadcore.lp.reward.view.NadRewardFullTailView$title$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NadRewardFullTailView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
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
                    View findViewById = this.this$0.findViewById(R.id.obfuscated_res_0x7f09235b);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.title)");
                    return (UnifyTextView) findViewById;
                }
                return (UnifyTextView) invokeV.objValue;
            }
        });
        this.c = LazyKt__LazyJVMKt.lazy(new Function0<UnifyTextView>(this) { // from class: com.baidu.nadcore.lp.reward.view.NadRewardFullTailView$subTitle$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NadRewardFullTailView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
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
                    View findViewById = this.this$0.findViewById(R.id.sub_title);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.sub_title)");
                    return (UnifyTextView) findViewById;
                }
                return (UnifyTextView) invokeV.objValue;
            }
        });
        this.d = LazyKt__LazyJVMKt.lazy(new Function0<NadMiniVideoDownloadView>(this) { // from class: com.baidu.nadcore.lp.reward.view.NadRewardFullTailView$downloadButton$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NadRewardFullTailView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
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
            public final NadMiniVideoDownloadView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    View findViewById = this.this$0.findViewById(R.id.download_btn);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.download_btn)");
                    return (NadMiniVideoDownloadView) findViewById;
                }
                return (NadMiniVideoDownloadView) invokeV.objValue;
            }
        });
        this.e = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>(this) { // from class: com.baidu.nadcore.lp.reward.view.NadRewardFullTailView$replayButton$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NadRewardFullTailView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
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
        this.f = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>(this) { // from class: com.baidu.nadcore.lp.reward.view.NadRewardFullTailView$replayBtnIcon$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NadRewardFullTailView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
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
        this.g = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>(this) { // from class: com.baidu.nadcore.lp.reward.view.NadRewardFullTailView$moreBtnContainer$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NadRewardFullTailView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
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
        this.h = LazyKt__LazyJVMKt.lazy(new Function0<AdImageView>(this) { // from class: com.baidu.nadcore.lp.reward.view.NadRewardFullTailView$moreBtnIcon$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NadRewardFullTailView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
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
        this.i = LazyKt__LazyJVMKt.lazy(new Function0<UnifyTextView>(this) { // from class: com.baidu.nadcore.lp.reward.view.NadRewardFullTailView$moreBtnText$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NadRewardFullTailView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
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
        this.j = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>(this) { // from class: com.baidu.nadcore.lp.reward.view.NadRewardFullTailView$appInfoView$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NadRewardFullTailView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
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
                    View findViewById = this.this$0.findViewById(R.id.app_info_container);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.app_info_container)");
                    return (LinearLayout) findViewById;
                }
                return (LinearLayout) invokeV.objValue;
            }
        });
        this.k = LazyKt__LazyJVMKt.lazy(new Function0<UnifyTextView>(this) { // from class: com.baidu.nadcore.lp.reward.view.NadRewardFullTailView$version$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NadRewardFullTailView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
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
                    View findViewById = this.this$0.findViewById(R.id.ad_version);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.ad_version)");
                    return (UnifyTextView) findViewById;
                }
                return (UnifyTextView) invokeV.objValue;
            }
        });
        this.l = LazyKt__LazyJVMKt.lazy(new Function0<UnifyTextView>(this) { // from class: com.baidu.nadcore.lp.reward.view.NadRewardFullTailView$developerName$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NadRewardFullTailView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
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
                    View findViewById = this.this$0.findViewById(R.id.ad_author_full_name);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.ad_author_full_name)");
                    return (UnifyTextView) findViewById;
                }
                return (UnifyTextView) invokeV.objValue;
            }
        });
        this.m = LazyKt__LazyJVMKt.lazy(new Function0<UnifyTextView>(this) { // from class: com.baidu.nadcore.lp.reward.view.NadRewardFullTailView$privacyView$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NadRewardFullTailView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
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
                    View findViewById = this.this$0.findViewById(R.id.ad_privacy);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.ad_privacy)");
                    return (UnifyTextView) findViewById;
                }
                return (UnifyTextView) invokeV.objValue;
            }
        });
        this.n = LazyKt__LazyJVMKt.lazy(new Function0<UnifyTextView>(this) { // from class: com.baidu.nadcore.lp.reward.view.NadRewardFullTailView$permissionView$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NadRewardFullTailView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
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
                    View findViewById = this.this$0.findViewById(R.id.ad_permission);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.ad_permission)");
                    return (UnifyTextView) findViewById;
                }
                return (UnifyTextView) invokeV.objValue;
            }
        });
        LayoutInflater.from(context).inflate(R.layout.nad_reward_full_tail, this);
        setBackgroundColor(ContextCompat.getColor(context, R.color.nad_reward_full_tail_bg_color));
    }

    public /* synthetic */ NadRewardFullTailView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final void setAvatar(xq0 xq0Var) {
        String str;
        cr0 cr0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, this, xq0Var) == null) {
            AdImageView avatar = getAvatar();
            ar0 ar0Var = xq0Var.j;
            if (ar0Var != null && (cr0Var = ar0Var.h) != null) {
                str = cr0Var.d;
            } else {
                str = null;
            }
            avatar.g(str);
            avatar.setOnClickListener(new e(this, xq0Var));
        }
    }

    @Override // com.baidu.tieba.so0
    public void setData(xq0 adModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adModel) == null) {
            Intrinsics.checkNotNullParameter(adModel, "adModel");
            this.o = adModel;
            setAvatar(adModel);
            setTitle(adModel);
            setSubTitle(adModel);
            setDownloadButton(adModel);
            setReplayButton(adModel);
            setMoreButton(adModel);
            setAppInfo(adModel);
        }
    }

    @Override // com.baidu.tieba.so0
    public void setOnReplayClickListener(Function0<Unit> callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, callback) == null) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.p = callback;
        }
    }

    @Override // com.baidu.tieba.so0
    public void setVisibility(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            setVisibility(i2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:131:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void setAppInfo(xq0 xq0Var) {
        String str;
        boolean z;
        UnifyTextView unifyTextView;
        String str2;
        boolean z2;
        UnifyTextView unifyTextView2;
        String str3;
        boolean z3;
        boolean z4;
        UnifyTextView unifyTextView3;
        er0 er0Var;
        String str4;
        boolean z5;
        UnifyTextView unifyTextView4;
        er0.a aVar;
        String str5;
        boolean z6;
        er0.a aVar2;
        er0.a aVar3;
        String str6;
        er0.b bVar;
        String str7;
        boolean z7;
        er0.b bVar2;
        er0.b bVar3;
        String str8;
        String str9;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, this, xq0Var) == null) {
            LinearLayout appInfoView = getAppInfoView();
            if (ki0.a(xq0Var.i)) {
                appInfoView.setVisibility(0);
            } else {
                appInfoView.setVisibility(8);
            }
            UnifyTextView version = getVersion();
            er0 er0Var2 = xq0Var.i;
            String str10 = null;
            if (er0Var2 != null) {
                str = er0Var2.f;
            } else {
                str = null;
            }
            boolean z8 = true;
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                version.setVisibility(0);
                unifyTextView = version;
            } else {
                version.setVisibility(8);
                unifyTextView = null;
            }
            if (unifyTextView != null) {
                er0 er0Var3 = xq0Var.i;
                if (er0Var3 != null) {
                    str9 = er0Var3.f;
                } else {
                    str9 = null;
                }
                version.setTextWithUnifiedPadding(str9, TextView.BufferType.NORMAL);
                version.setOnClickListener(new a(version, xq0Var));
            }
            UnifyTextView developerName = getDeveloperName();
            er0 er0Var4 = xq0Var.i;
            if (er0Var4 != null) {
                str2 = er0Var4.d;
            } else {
                str2 = null;
            }
            if (str2 != null && str2.length() != 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!z2) {
                developerName.setVisibility(0);
                unifyTextView2 = developerName;
            } else {
                developerName.setVisibility(8);
                unifyTextView2 = null;
            }
            if (unifyTextView2 != null) {
                er0 er0Var5 = xq0Var.i;
                if (er0Var5 != null) {
                    str8 = er0Var5.d;
                } else {
                    str8 = null;
                }
                developerName.setTextWithUnifiedPadding(str8, TextView.BufferType.NORMAL);
                developerName.setOnClickListener(new b(developerName, xq0Var));
            }
            UnifyTextView privacyView = getPrivacyView();
            er0 er0Var6 = xq0Var.i;
            if (er0Var6 != null && (bVar3 = er0Var6.g) != null) {
                str3 = bVar3.a;
            } else {
                str3 = null;
            }
            if (str3 != null && str3.length() != 0) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                er0 er0Var7 = xq0Var.i;
                if (er0Var7 != null && (bVar2 = er0Var7.g) != null) {
                    str7 = bVar2.b;
                } else {
                    str7 = null;
                }
                if (str7 != null && str7.length() != 0) {
                    z7 = false;
                } else {
                    z7 = true;
                }
                if (z7) {
                    z4 = false;
                    if (!z4) {
                        privacyView.setVisibility(0);
                        unifyTextView3 = privacyView;
                    } else {
                        privacyView.setVisibility(8);
                        unifyTextView3 = null;
                    }
                    if (unifyTextView3 != null) {
                        er0 er0Var8 = xq0Var.i;
                        if (er0Var8 != null && (bVar = er0Var8.g) != null) {
                            str6 = bVar.a;
                        } else {
                            str6 = null;
                        }
                        privacyView.setTextWithUnifiedPadding(str6, TextView.BufferType.NORMAL);
                        privacyView.setOnClickListener(new c(privacyView, this, xq0Var));
                    }
                    UnifyTextView permissionView = getPermissionView();
                    er0Var = xq0Var.i;
                    if (er0Var == null && (aVar3 = er0Var.h) != null) {
                        str4 = aVar3.a;
                    } else {
                        str4 = null;
                    }
                    if (str4 == null && str4.length() != 0) {
                        z5 = false;
                    } else {
                        z5 = true;
                    }
                    if (z5) {
                        er0 er0Var9 = xq0Var.i;
                        if (er0Var9 != null && (aVar2 = er0Var9.h) != null) {
                            str5 = aVar2.b;
                        } else {
                            str5 = null;
                        }
                        if (str5 != null && str5.length() != 0) {
                            z6 = false;
                        } else {
                            z6 = true;
                        }
                        if (z6) {
                            z8 = false;
                        }
                    }
                    if (!z8) {
                        permissionView.setVisibility(0);
                        unifyTextView4 = permissionView;
                    } else {
                        permissionView.setVisibility(8);
                        unifyTextView4 = null;
                    }
                    if (unifyTextView4 == null) {
                        er0 er0Var10 = xq0Var.i;
                        if (er0Var10 != null && (aVar = er0Var10.h) != null) {
                            str10 = aVar.a;
                        }
                        permissionView.setTextWithUnifiedPadding(str10, TextView.BufferType.NORMAL);
                        permissionView.setOnClickListener(new d(permissionView, this, xq0Var));
                        return;
                    }
                    return;
                }
            }
            z4 = true;
            if (!z4) {
            }
            if (unifyTextView3 != null) {
            }
            UnifyTextView permissionView2 = getPermissionView();
            er0Var = xq0Var.i;
            if (er0Var == null) {
            }
            str4 = null;
            if (str4 == null) {
            }
            z5 = true;
            if (z5) {
            }
            if (!z8) {
            }
            if (unifyTextView4 == null) {
            }
        }
    }

    private final void setDownloadButton(xq0 xq0Var) {
        String str;
        boolean z;
        String str2;
        Object obj;
        lq0 lq0Var;
        pq0 pq0Var;
        lq0 lq0Var2;
        cr0 cr0Var;
        cr0 cr0Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, this, xq0Var) == null) {
            ii0 ii0Var = this.q;
            if (ii0Var != null) {
                ii0Var.k();
            }
            String str3 = null;
            this.q = null;
            NadMiniVideoDownloadView downloadButton = getDownloadButton();
            int a2 = b51.c.a(downloadButton.getContext(), 16.5f);
            GradientDrawable gradientDrawable = new GradientDrawable();
            ar0 ar0Var = xq0Var.j;
            if (ar0Var != null && (cr0Var2 = ar0Var.h) != null) {
                str = cr0Var2.h;
            } else {
                str = null;
            }
            gradientDrawable.setColor(y41.a(str, R.color.nad_reward_full_tail_btn_color));
            float f2 = a2;
            gradientDrawable.setCornerRadius(f2);
            Unit unit = Unit.INSTANCE;
            downloadButton.setBackground(gradientDrawable);
            downloadButton.setBorderRadius(f2);
            downloadButton.setTextSize(12.0f);
            downloadButton.setTextColor(ContextCompat.getColor(downloadButton.getContext(), R.color.nad_reward_full_tail_btn_text_color));
            downloadButton.setProgressColor(ContextCompat.getColor(downloadButton.getContext(), R.color.nad_reward_full_tail_btn_download_progress));
            fr0 b2 = xq0Var.b();
            if (b2 != null) {
                z = b2.c();
            } else {
                z = false;
            }
            downloadButton.setIconArrowSwitch(z);
            ar0 ar0Var2 = xq0Var.j;
            if (ar0Var2 != null && (cr0Var = ar0Var2.h) != null) {
                str2 = cr0Var.b;
            } else {
                str2 = null;
            }
            boolean z2 = true;
            if ((!Intrinsics.areEqual(str2, "download") || (pq0Var = xq0Var.m) == null || (lq0Var2 = pq0Var.p) == null || !lq0Var2.e) ? false : false) {
                downloadButton.setVisibility(0);
                obj = downloadButton;
            } else {
                downloadButton.setVisibility(8);
                obj = null;
            }
            if (obj != null) {
                pq0 pq0Var2 = xq0Var.m;
                if (pq0Var2 != null) {
                    lq0Var = pq0Var2.p;
                } else {
                    lq0Var = null;
                }
                String str4 = xq0Var.f.d;
                pq0 pq0Var3 = xq0Var.m;
                if (pq0Var3 != null) {
                    str3 = pq0Var3.t;
                }
                cl0 d2 = cl0.d(lq0Var, str4, str3);
                Intrinsics.checkNotNullExpressionValue(d2, "AdDownloadBean.from(adMo….enhanceModel?.btnScheme)");
                ii0 ii0Var2 = new ii0(d2, getDownloadButton());
                this.q = ii0Var2;
                Intrinsics.checkNotNull(ii0Var2);
                ii0Var2.y();
            }
            downloadButton.setOnClickListener(new f(this, xq0Var));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0047, code lost:
        if (r1 == false) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0112  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void setMoreButton(xq0 xq0Var) {
        boolean z;
        LinearLayout linearLayout;
        AdImageView moreBtnIcon;
        ar0 ar0Var;
        String str;
        boolean z2;
        UnifyTextView moreBtnText;
        ar0 ar0Var2;
        String str2;
        ar0 ar0Var3;
        String str3;
        boolean z3;
        cr0 cr0Var;
        cr0 cr0Var2;
        cr0 cr0Var3;
        String str4;
        cr0 cr0Var4;
        cr0 cr0Var5;
        String str5;
        cr0 cr0Var6;
        String str6;
        boolean z4;
        String str7;
        boolean z5;
        cr0 cr0Var7;
        cr0 cr0Var8;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, this, xq0Var) == null) {
            LinearLayout moreBtnContainer = getMoreBtnContainer();
            String str8 = null;
            if (!xq0Var.g().d()) {
                ar0 ar0Var4 = xq0Var.j;
                if (ar0Var4 != null && (cr0Var8 = ar0Var4.h) != null) {
                    str6 = cr0Var8.w;
                } else {
                    str6 = null;
                }
                if (str6 != null && str6.length() != 0) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                if (z4) {
                    ar0 ar0Var5 = xq0Var.j;
                    if (ar0Var5 != null && (cr0Var7 = ar0Var5.h) != null) {
                        str7 = cr0Var7.x;
                    } else {
                        str7 = null;
                    }
                    if (str7 != null && str7.length() != 0) {
                        z5 = false;
                    } else {
                        z5 = true;
                    }
                }
                z = true;
                if (!z) {
                    moreBtnContainer.setVisibility(0);
                    linearLayout = moreBtnContainer;
                } else {
                    moreBtnContainer.setVisibility(8);
                    linearLayout = null;
                }
                if (linearLayout != null) {
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setCornerRadius(b51.c.a(moreBtnContainer.getContext(), 17.0f));
                    ar0 ar0Var6 = xq0Var.j;
                    if (ar0Var6 != null && (cr0Var6 = ar0Var6.h) != null) {
                        str5 = cr0Var6.z;
                    } else {
                        str5 = null;
                    }
                    gradientDrawable.setStroke(2, y41.a(str5, R.color.nad_reward_full_tail_more_btn_border));
                    gradientDrawable.setAlpha((int) 127.5d);
                    Unit unit = Unit.INSTANCE;
                    linearLayout.setBackground(gradientDrawable);
                }
                moreBtnContainer.setOnClickListener(new g(this, xq0Var));
                moreBtnIcon = getMoreBtnIcon();
                ar0Var = xq0Var.j;
                if (ar0Var == null && (cr0Var5 = ar0Var.h) != null) {
                    str = cr0Var5.w;
                } else {
                    str = null;
                }
                if (str == null && str.length() != 0) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!(!z2)) {
                    moreBtnIcon.setVisibility(0);
                } else {
                    moreBtnIcon.setVisibility(8);
                    moreBtnIcon = null;
                }
                if (moreBtnIcon != null) {
                    ar0 ar0Var7 = xq0Var.j;
                    if (ar0Var7 != null && (cr0Var4 = ar0Var7.h) != null) {
                        str4 = cr0Var4.w;
                    } else {
                        str4 = null;
                    }
                    moreBtnIcon.g(str4);
                }
                moreBtnText = getMoreBtnText();
                ar0Var2 = xq0Var.j;
                if (ar0Var2 == null && (cr0Var3 = ar0Var2.h) != null) {
                    str2 = cr0Var3.A;
                } else {
                    str2 = null;
                }
                moreBtnText.setTextColor(y41.a(str2, 17170443));
                ar0Var3 = xq0Var.j;
                if (ar0Var3 == null && (cr0Var2 = ar0Var3.h) != null) {
                    str3 = cr0Var2.x;
                } else {
                    str3 = null;
                }
                if (str3 == null && str3.length() != 0) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (!(!z3)) {
                    moreBtnText.setVisibility(0);
                } else {
                    moreBtnText.setVisibility(8);
                    moreBtnText = null;
                }
                if (moreBtnText == null) {
                    ar0 ar0Var8 = xq0Var.j;
                    if (ar0Var8 != null && (cr0Var = ar0Var8.h) != null) {
                        str8 = cr0Var.x;
                    }
                    moreBtnText.setText(str8);
                    return;
                }
                return;
            }
            z = false;
            if (!z) {
            }
            if (linearLayout != null) {
            }
            moreBtnContainer.setOnClickListener(new g(this, xq0Var));
            moreBtnIcon = getMoreBtnIcon();
            ar0Var = xq0Var.j;
            if (ar0Var == null) {
            }
            str = null;
            if (str == null) {
            }
            z2 = true;
            if (!(!z2)) {
            }
            if (moreBtnIcon != null) {
            }
            moreBtnText = getMoreBtnText();
            ar0Var2 = xq0Var.j;
            if (ar0Var2 == null) {
            }
            str2 = null;
            moreBtnText.setTextColor(y41.a(str2, 17170443));
            ar0Var3 = xq0Var.j;
            if (ar0Var3 == null) {
            }
            str3 = null;
            if (str3 == null) {
            }
            z3 = true;
            if (!(!z3)) {
            }
            if (moreBtnText == null) {
            }
        }
    }

    private final void setReplayButton(xq0 xq0Var) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, this, xq0Var) == null) {
            getReplayButton().setOnClickListener(new h(this));
            ImageView replayBtnIcon = getReplayBtnIcon();
            fr0 b2 = xq0Var.b();
            if (b2 != null && b2.c()) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            replayBtnIcon.setVisibility(i2);
        }
    }

    private final void setSubTitle(xq0 xq0Var) {
        String str;
        boolean z;
        cr0 cr0Var;
        cr0 cr0Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, this, xq0Var) == null) {
            UnifyTextView subTitle = getSubTitle();
            ar0 ar0Var = xq0Var.j;
            String str2 = null;
            if (ar0Var != null && (cr0Var2 = ar0Var.h) != null) {
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
                ar0 ar0Var2 = xq0Var.j;
                if (ar0Var2 != null && (cr0Var = ar0Var2.h) != null) {
                    str2 = cr0Var.m;
                }
                subTitle.setText(str2);
            }
            subTitle.setOnClickListener(new i(this, xq0Var));
        }
    }

    private final void setTitle(xq0 xq0Var) {
        String str;
        boolean z;
        cr0 cr0Var;
        cr0 cr0Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, this, xq0Var) == null) {
            UnifyTextView title = getTitle();
            ar0 ar0Var = xq0Var.j;
            String str2 = null;
            if (ar0Var != null && (cr0Var2 = ar0Var.h) != null) {
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
                ar0 ar0Var2 = xq0Var.j;
                if (ar0Var2 != null && (cr0Var = ar0Var2.h) != null) {
                    str2 = cr0Var.l;
                }
                title.setText(str2);
            }
            title.setOnClickListener(new j(this, xq0Var));
        }
    }

    public final void d(String str, ClogBuilder.LogType logType, String str2) {
        String str3;
        xq0 xq0Var;
        pq0 pq0Var;
        lq0 lq0Var;
        String str4;
        boolean z;
        String str5;
        String str6;
        pq0 pq0Var2;
        lq0 lq0Var2;
        pq0 pq0Var3;
        lq0 lq0Var3;
        pq0 pq0Var4;
        lq0 lq0Var4;
        xq0 xq0Var2;
        List<MonitorUrl> list;
        boolean z2;
        tq0 tq0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, logType, str2) == null) {
            ClogBuilder u = new ClogBuilder().j(str).y(logType).u(ClogBuilder.Page.WELFARETAIL);
            xq0 xq0Var3 = this.o;
            String str7 = null;
            if (xq0Var3 != null && (tq0Var = xq0Var3.f) != null) {
                str3 = tq0Var.d;
            } else {
                str3 = null;
            }
            n21.b(u.p(str3));
            boolean z3 = false;
            if (logType == ClogBuilder.LogType.CLICK && (xq0Var2 = this.o) != null && (list = xq0Var2.e) != null) {
                ArrayList<MonitorUrl> arrayList = new ArrayList();
                for (Object obj : list) {
                    String str8 = ((MonitorUrl) obj).clickUrl;
                    if (str8 != null && !StringsKt__StringsJVMKt.isBlank(str8)) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (!z2) {
                        arrayList.add(obj);
                    }
                }
                for (MonitorUrl monitorUrl : arrayList) {
                    o21.b(monitorUrl.clickUrl);
                }
            }
            if ((Intrinsics.areEqual(str, "icon") || Intrinsics.areEqual(str, "name") || Intrinsics.areEqual(str, "tail_subtitle")) && (xq0Var = this.o) != null && (pq0Var = xq0Var.m) != null && (lq0Var = pq0Var.p) != null && lq0Var.e) {
                if (xq0Var != null && pq0Var != null && lq0Var != null) {
                    str4 = lq0Var.b;
                } else {
                    str4 = null;
                }
                if (str4 != null && str4.length() != 0) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    xq0 xq0Var4 = this.o;
                    if (xq0Var4 != null && (pq0Var4 = xq0Var4.m) != null && (lq0Var4 = pq0Var4.p) != null) {
                        str5 = lq0Var4.a;
                    } else {
                        str5 = null;
                    }
                    if (!((str5 == null || str5.length() == 0) ? true : true)) {
                        xq0 xq0Var5 = this.o;
                        if (xq0Var5 != null && (pq0Var3 = xq0Var5.m) != null && (lq0Var3 = pq0Var3.p) != null) {
                            str6 = lq0Var3.a;
                        } else {
                            str6 = null;
                        }
                        if (s41.d(str6)) {
                            Context context = getContext();
                            xq0 xq0Var6 = this.o;
                            if (xq0Var6 != null && (pq0Var2 = xq0Var6.m) != null && (lq0Var2 = pq0Var2.p) != null) {
                                str7 = lq0Var2.a;
                            }
                            Intrinsics.checkNotNull(str7);
                            jj0.b(context, str7);
                            return;
                        }
                    }
                }
                if (Intrinsics.areEqual(str2, "__CONVERT_CMD__")) {
                    xq0 xq0Var7 = this.o;
                    Intrinsics.checkNotNull(xq0Var7);
                    xq0 xq0Var8 = this.o;
                    if (xq0Var8 != null) {
                        str7 = xq0Var8.e();
                    }
                    wi0.c(s41.b(xq0Var7, str7), getContext());
                    return;
                }
                xq0 xq0Var9 = this.o;
                Intrinsics.checkNotNull(xq0Var9);
                wi0.c(s41.b(xq0Var9, str2), getContext());
                return;
            }
            wi0.c(str2, getContext());
        }
    }
}
