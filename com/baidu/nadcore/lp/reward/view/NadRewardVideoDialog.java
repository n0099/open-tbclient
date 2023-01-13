package com.baidu.nadcore.lp.reward.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.utils.ExtensionsKt;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.tieba.R;
import com.baidu.tieba.bo0;
import com.baidu.tieba.co0;
import com.baidu.tieba.e11;
import com.baidu.tieba.ni0;
import com.baidu.tieba.r31;
import com.baidu.tieba.un0;
import com.baidu.tieba.vn0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 a2\u00020\u0001:\u0002abB\u0007¢\u0006\u0004\b`\u0010\u0010JI\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0018\u0010\u0010J+\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010#\u001a\u00020\u000e2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b#\u0010$J\u0019\u0010&\u001a\u00020%2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b&\u0010'J+\u0010-\u001a\u00020,2\u0006\u0010)\u001a\u00020(2\b\u0010+\u001a\u0004\u0018\u00010*2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u000eH\u0016¢\u0006\u0004\b/\u0010\u0010J\u0017\u00101\u001a\u00020\u000e2\u0006\u00100\u001a\u00020!H\u0016¢\u0006\u0004\b1\u0010$J\u0015\u00104\u001a\u00020\u000e2\u0006\u00103\u001a\u000202¢\u0006\u0004\b4\u00105J\u0015\u00107\u001a\u00020\u000e2\u0006\u00103\u001a\u000206¢\u0006\u0004\b7\u00108J\u001b\u0010:\u001a\u00020\u000e2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u000e09¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\u000eH\u0002¢\u0006\u0004\b<\u0010\u0010J\u001b\u0010=\u001a\u00020\u000e2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u000e09¢\u0006\u0004\b=\u0010;J\u0015\u0010>\u001a\u00020\u000e2\u0006\u00103\u001a\u000206¢\u0006\u0004\b>\u00108J!\u0010B\u001a\u00020\u000e2\u0006\u0010@\u001a\u00020?2\b\u0010A\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\bB\u0010CJ\u001b\u0010E\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010+\u001a\u00020DH\u0002¢\u0006\u0004\bE\u0010FR\u0018\u0010G\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010I\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u001e\u0010K\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010M\u001a\u00020,8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bM\u0010NR\u001e\u0010O\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010LR\u0016\u0010Q\u001a\u00020P8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010S\u001a\u00020\u00148\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010U\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010JR\u0016\u0010V\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010Y\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010[\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010WR\u0016\u0010\\\u001a\u00020,8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\\\u0010NR\u0016\u0010]\u001a\u00020\u00148\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b]\u0010TR\u0016\u0010^\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010_¨\u0006c"}, d2 = {"Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoDialog;", "Landroidx/fragment/app/DialogFragment;", "Lcom/baidu/nadcore/lp/reward/data/NadDialogButtonData;", "buttonData", "", "type", DnsModel.AREA_KEY, "btnIndex", "", "shouldCharge", "closeDialog", "Landroid/widget/TextView;", "buildButton", "(Lcom/baidu/nadcore/lp/reward/data/NadDialogButtonData;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)Landroid/widget/TextView;", "", "dismiss", "()V", "btnCmd", "handleLocalCmd", "(Ljava/lang/String;)Z", "Lcom/baidu/nadcore/widget/AdImageView;", "icon", "initCloseIcon", "(Lcom/baidu/nadcore/widget/AdImageView;)V", "initCommonView", "logWelfareDialog", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/content/DialogInterface;", "dialog", "onCancel", "(Landroid/content/DialogInterface;)V", "onConvertClick", "(Ljava/lang/String;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onDetach", "outState", "onSaveInstanceState", "Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoDialog$DialogClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setAfterClickListener", "(Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoDialog$DialogClickListener;)V", "Landroid/view/View$OnClickListener;", "setCloseBtnClickListener", "(Landroid/view/View$OnClickListener;)V", "Lkotlin/Function0;", "setConvertClickListener", "(Lkotlin/Function0;)V", "setDialogContentView", "setDialogDismissListener", "setDownloadBtnClickListener", "Landroidx/fragment/app/FragmentManager;", "manager", "tag", "show", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V", "Landroid/widget/FrameLayout;", "setBottomBtnStyle", "(Landroid/widget/TextView;Landroid/widget/FrameLayout;)V", "afterClickListener", "Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoDialog$DialogClickListener;", "closeBtnClickListener", "Landroid/view/View$OnClickListener;", "convertClickListener", "Lkotlin/Function0;", "dialogContent", "Landroid/view/View;", "dialogDismissListener", "Landroid/view/ViewStub;", "dialogStub", "Landroid/view/ViewStub;", "dialogTopImg", "Lcom/baidu/nadcore/widget/AdImageView;", "downloadBtnClickListener", "ext", "Ljava/lang/String;", "Lcom/baidu/nadcore/lp/reward/data/NadRewardDialogData;", "rewardData", "Lcom/baidu/nadcore/lp/reward/data/NadRewardDialogData;", "rewardDataJson", "rootContainerView", "topImg", "upperLimit", "Z", "<init>", "Companion", "DialogClickListener", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class NadRewardVideoDialog extends DialogFragment {
    public static /* synthetic */ Interceptable $ic;
    public static final a p;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public AdImageView b;
    public AdImageView c;
    public ViewStub d;
    public View e;
    public View.OnClickListener f;
    public Function0<Unit> g;
    public View.OnClickListener h;
    public b i;
    public Function0<Unit> j;
    public co0 k;
    public String l;
    public String m;
    public boolean n;
    public HashMap o;

    /* loaded from: classes2.dex */
    public interface b {
        void a();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1003071568, "Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoDialog;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1003071568, "Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoDialog;");
                return;
            }
        }
        p = new a(null);
    }

    public void C1() {
        HashMap hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (hashMap = this.o) == null) {
            return;
        }
        hashMap.clear();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        C1();
    }

    /* loaded from: classes2.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final NadRewardVideoDialog a(String rewardDataJson, String ext) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, rewardDataJson, ext)) == null) {
                Intrinsics.checkNotNullParameter(rewardDataJson, "rewardDataJson");
                Intrinsics.checkNotNullParameter(ext, "ext");
                Bundle bundle = new Bundle();
                bundle.putString("extra_reward_data", rewardDataJson);
                bundle.putString("extra_ext", ext);
                NadRewardVideoDialog nadRewardVideoDialog = new NadRewardVideoDialog();
                nadRewardVideoDialog.setArguments(bundle);
                nadRewardVideoDialog.k = new co0(rewardDataJson);
                nadRewardVideoDialog.m = ext;
                return nadRewardVideoDialog;
            }
            return (NadRewardVideoDialog) invokeLL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class c implements vn0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ NadRewardVideoDialog b;
        public final /* synthetic */ TextView c;

        @Override // com.baidu.tieba.vn0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public c(Context context, NadRewardVideoDialog nadRewardVideoDialog, TextView textView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, nadRewardVideoDialog, textView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = nadRewardVideoDialog;
            this.c = textView;
        }

        @Override // com.baidu.tieba.vn0
        public void b(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                if (bitmap != null) {
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(this.a.getResources(), bitmap);
                    Context context = this.b.getContext();
                    Intrinsics.checkNotNull(context);
                    Intrinsics.checkNotNullExpressionValue(context, "context!!");
                    int d = ExtensionsKt.d(10, context);
                    Context context2 = this.b.getContext();
                    Intrinsics.checkNotNull(context2);
                    Intrinsics.checkNotNullExpressionValue(context2, "context!!");
                    bitmapDrawable.setBounds(0, 0, d, ExtensionsKt.d(10, context2));
                    this.c.setCompoundDrawables(null, null, bitmapDrawable, null);
                    TextView textView = this.c;
                    Context context3 = this.b.getContext();
                    Intrinsics.checkNotNull(context3);
                    Intrinsics.checkNotNullExpressionValue(context3, "context!!");
                    textView.setCompoundDrawablePadding(ExtensionsKt.d(2, context3));
                    return;
                }
                a();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class d implements vn0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ View b;

        @Override // com.baidu.tieba.vn0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public d(Context context, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = view2;
        }

        @Override // com.baidu.tieba.vn0
        public void b(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                if (bitmap != null) {
                    this.b.setBackground(new BitmapDrawable(this.a.getResources(), bitmap));
                    return;
                }
                a();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardVideoDialog a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ bo0 e;
        public final /* synthetic */ boolean f;
        public final /* synthetic */ boolean g;

        public e(NadRewardVideoDialog nadRewardVideoDialog, String str, String str2, String str3, bo0 bo0Var, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardVideoDialog, str, str2, str3, bo0Var, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardVideoDialog;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = bo0Var;
            this.f = z;
            this.g = z2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            b bVar;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.O1(this.b, this.c, this.d);
            if (!this.a.L1(this.e.b())) {
                ni0.c(this.e.b(), this.a.getContext());
            }
            if (this.f && (bVar = this.a.i) != null) {
                bVar.a();
            }
            if (this.g) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardVideoDialog a;

        public f(NadRewardVideoDialog nadRewardVideoDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardVideoDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardVideoDialog;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                NadRewardVideoDialog nadRewardVideoDialog = this.a;
                String str = ClogBuilder.LogType.FREE_CLICK.type;
                Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.LogType.FREE_CLICK.type");
                NadRewardVideoDialog.P1(nadRewardVideoDialog, str, "close", null, 4, null);
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardVideoDialog a;

        public g(NadRewardVideoDialog nadRewardVideoDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardVideoDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardVideoDialog;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                NadRewardVideoDialog nadRewardVideoDialog = this.a;
                String str = ClogBuilder.Area.AVATAR.type;
                Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.AVATAR.type");
                nadRewardVideoDialog.Q1(str);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardVideoDialog a;

        public h(NadRewardVideoDialog nadRewardVideoDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardVideoDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardVideoDialog;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                NadRewardVideoDialog nadRewardVideoDialog = this.a;
                String str = ClogBuilder.Area.NAME.type;
                Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.NAME.type");
                nadRewardVideoDialog.Q1(str);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardVideoDialog a;

        public i(NadRewardVideoDialog nadRewardVideoDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardVideoDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardVideoDialog;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                NadRewardVideoDialog nadRewardVideoDialog = this.a;
                String str = ClogBuilder.Area.TITTLE.type;
                Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.TITTLE.type");
                nadRewardVideoDialog.Q1(str);
            }
        }
    }

    public NadRewardVideoDialog() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = "";
        this.m = "";
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            dismissAllowingStateLoss();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onDetach();
            Function0<Unit> function0 = this.g;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    public final void R1(b listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, listener) == null) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.i = listener;
        }
    }

    public final void T1(View.OnClickListener listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, listener) == null) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.f = listener;
        }
    }

    public final void U1(Function0<Unit> listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, listener) == null) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.j = listener;
        }
    }

    public final void W1(Function0<Unit> listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, listener) == null) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.g = listener;
        }
    }

    public final void X1(View.OnClickListener listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, listener) == null) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.h = listener;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, dialog) == null) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            super.onCancel(dialog);
            String str = ClogBuilder.LogType.FREE_CLICK.type;
            Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.LogType.FREE_CLICK.type");
            P1(this, str, "blank", null, 4, null);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            super.onCreate(bundle);
            setStyle(0, R.style.obfuscated_res_0x7f1003cb);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, outState) == null) {
            Intrinsics.checkNotNullParameter(outState, "outState");
            super.onSaveInstanceState(outState);
            outState.putString("extra_reward_data", this.l);
            outState.putString("extra_ext", this.m);
            outState.putBoolean("extra_upper_limit", this.n);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(FragmentManager manager, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, manager, str) == null) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            try {
                super.show(manager, str);
            } catch (Exception unused) {
                dismiss();
            }
            String str2 = ClogBuilder.LogType.FREE_SHOW.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.LogType.FREE_SHOW.type");
            P1(this, str2, null, null, 6, null);
        }
    }

    public static /* synthetic */ TextView K1(NadRewardVideoDialog nadRewardVideoDialog, bo0 bo0Var, String str, String str2, String str3, boolean z, boolean z2, int i2, Object obj) {
        String str4;
        String str5;
        boolean z3;
        boolean z4;
        if ((i2 & 2) != 0) {
            str = ClogBuilder.LogType.FREE_CLICK.type;
            Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.LogType.FREE_CLICK.type");
        }
        String str6 = str;
        if ((i2 & 4) != 0) {
            str4 = "";
        } else {
            str4 = str2;
        }
        if ((i2 & 8) != 0) {
            str5 = "";
        } else {
            str5 = str3;
        }
        if ((i2 & 16) != 0) {
            z3 = false;
        } else {
            z3 = z;
        }
        if ((i2 & 32) != 0) {
            z4 = true;
        } else {
            z4 = z2;
        }
        return nadRewardVideoDialog.J1(bo0Var, str6, str4, str5, z3, z4);
    }

    public static /* synthetic */ void P1(NadRewardVideoDialog nadRewardVideoDialog, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = "";
        }
        if ((i2 & 4) != 0) {
            str3 = "";
        }
        nadRewardVideoDialog.O1(str, str2, str3);
    }

    public final TextView J1(bo0 bo0Var, String str, String str2, String str3, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bo0Var, str, str2, str3, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            TextView textView = new TextView(getContext());
            String a2 = bo0Var.a();
            Context context = textView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            boolean z4 = true;
            if (a2 != null && a2.length() != 0) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (!z3) {
                un0.a().c(a2, new d(context, textView));
            }
            if (!TextUtils.isEmpty(bo0Var.e())) {
                textView.setTextColor(Color.parseColor(bo0Var.e()));
            }
            Context context2 = getContext();
            if (context2 != null) {
                String c2 = bo0Var.c();
                if (c2 != null && c2.length() != 0) {
                    z4 = false;
                }
                if (!z4) {
                    un0.a().c(c2, new c(context2, this, textView));
                    textView.setText(bo0Var.d());
                    textView.setIncludeFontPadding(false);
                    textView.setOnClickListener(new e(this, str, str2, str3, bo0Var, z, z2));
                    return textView;
                }
            }
            textView.setText(bo0Var.d());
            textView.setIncludeFontPadding(false);
            textView.setOnClickListener(new e(this, str, str2, str3, bo0Var, z, z2));
            return textView;
        }
        return (TextView) invokeCommon.objValue;
    }

    public final boolean L1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (str != null) {
                int hashCode = str.hashCode();
                if (hashCode != -1077350185) {
                    if (hashCode != 446830939) {
                        if (hashCode == 1522490442 && str.equals("__STARTDOWNLOAD__")) {
                            View.OnClickListener onClickListener = this.h;
                            if (onClickListener == null) {
                                return true;
                            }
                            onClickListener.onClick(getView());
                            return true;
                        }
                    } else if (str.equals("__CONTINUEPLAY__")) {
                        return true;
                    }
                } else if (str.equals("__LEAVE__")) {
                    View.OnClickListener onClickListener2 = this.f;
                    if (onClickListener2 == null) {
                        return true;
                    }
                    onClickListener2.onClick(getView());
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void M1(AdImageView adImageView) {
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, adImageView) == null) {
            co0 co0Var = this.k;
            String str2 = null;
            if (co0Var != null) {
                str = co0Var.g();
            } else {
                str = null;
            }
            if (str != null && !StringsKt__StringsJVMKt.isBlank(str)) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                adImageView.setImageDrawable(ContextCompat.getDrawable(adImageView.getContext(), R.drawable.nad_reward_video_lp_close_btn));
            } else {
                co0 co0Var2 = this.k;
                if (co0Var2 != null) {
                    str2 = co0Var2.g();
                }
                adImageView.g(str2);
            }
            adImageView.setOnClickListener(new f(this));
        }
    }

    public final void Q1(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            co0 co0Var = this.k;
            if (co0Var != null && co0Var.p()) {
                co0 co0Var2 = this.k;
                if (co0Var2 != null) {
                    str2 = co0Var2.i();
                } else {
                    str2 = null;
                }
                ni0.c(str2, getContext());
            }
            String str3 = ClogBuilder.LogType.CLICK.type;
            Intrinsics.checkNotNullExpressionValue(str3, "ClogBuilder.LogType.CLICK.type");
            P1(this, str3, str, null, 4, null);
            b bVar = this.i;
            if (bVar != null) {
                bVar.a();
            }
            Function0<Unit> function0 = this.j;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    public final void N1() {
        co0 co0Var;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (co0Var = this.k) != null) {
            AdImageView adImageView = this.b;
            if (adImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topImg");
            }
            String o = co0Var.o();
            if (o != null && o.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            AdImageView adImageView2 = null;
            if (!z) {
                adImageView.setVisibility(0);
            } else {
                adImageView.setVisibility(8);
                adImageView = null;
            }
            if (adImageView != null) {
                adImageView.g(co0Var.o());
            }
            AdImageView adImageView3 = this.c;
            if (adImageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dialogTopImg");
            }
            String j = co0Var.j();
            if (j != null && j.length() != 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!z2) {
                adImageView3.setVisibility(0);
                adImageView2 = adImageView3;
            } else {
                adImageView3.setVisibility(8);
            }
            if (adImageView2 != null) {
                adImageView2.g(co0Var.j());
            }
            View view2 = this.e;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dialogContent");
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TL_BR);
            gradientDrawable.setCornerRadius(r31.c.a(getContext(), 18.0f));
            gradientDrawable.setColors(new int[]{co0Var.c(), co0Var.b()});
            gradientDrawable.setStroke(r31.c.a(getContext(), 2.0f), co0Var.d());
            Unit unit = Unit.INSTANCE;
            view2.setBackground(gradientDrawable);
        }
    }

    public final void O1(String str, String str2, String str3) {
        boolean z;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, str, str2, str3) == null) {
            if (this.m.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z && this.k != null) {
                ClogBuilder clogBuilder = new ClogBuilder();
                clogBuilder.u(ClogBuilder.Page.WELFAREPANEL);
                clogBuilder.z(str);
                clogBuilder.p(this.m);
                clogBuilder.j(str2);
                clogBuilder.k(str3);
                co0 co0Var = this.k;
                if (co0Var != null) {
                    str4 = co0Var.k();
                } else {
                    str4 = null;
                }
                clogBuilder.l(String.valueOf(str4));
                e11.b(clogBuilder);
            }
        }
    }

    public final void S1(TextView textView, FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, textView, frameLayout) == null) {
            textView.setTypeface(Typeface.defaultFromStyle(1));
            textView.setTextSize(1, 14.0f);
            textView.setGravity(17);
            ViewParent parent = textView.getParent();
            if (!(parent instanceof ViewGroup)) {
                parent = null;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup != null) {
                viewGroup.removeView(textView);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            frameLayout.addView(textView, layoutParams);
            frameLayout.setVisibility(0);
        }
    }

    public final void V1() {
        View view2;
        FrameLayout frameLayout;
        AdImageView adImageView;
        FrameLayout frameLayout2;
        TextView textView;
        LinearLayout linearLayout;
        TextView textView2;
        TextView textView3;
        FrameLayout frameLayout3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        String str;
        int i2;
        boolean z;
        String str2;
        int i3;
        String str3;
        int i4;
        LinearLayout linearLayout2;
        String str4;
        String str5;
        bo0 e2;
        co0 co0Var;
        bo0 f2;
        bo0 l;
        bo0 h2;
        String str6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            ViewStub viewStub = this.d;
            if (viewStub == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dialogStub");
            }
            viewStub.setLayoutResource(R.layout.nad_reward_video_dialog_content);
            ViewStub viewStub2 = this.d;
            if (viewStub2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dialogStub");
            }
            View inflate = viewStub2.inflate();
            Intrinsics.checkNotNullExpressionValue(inflate, "dialogStub.inflate()");
            this.e = inflate;
            if (inflate == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dialogContent");
            }
            View findViewById = inflate.findViewById(R.id.close_img);
            Intrinsics.checkNotNullExpressionValue(findViewById, "dialogContent.findViewById(R.id.close_img)");
            AdImageView adImageView2 = (AdImageView) findViewById;
            View view3 = this.e;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dialogContent");
            }
            View findViewById2 = view3.findViewById(R.id.obfuscated_res_0x7f090311);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "dialogContent.findViewById(R.id.avatar)");
            AdImageView adImageView3 = (AdImageView) findViewById2;
            View view4 = this.e;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dialogContent");
            }
            View findViewById3 = view4.findViewById(R.id.obfuscated_res_0x7f0922ff);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "dialogContent.findViewById(R.id.title)");
            TextView textView8 = (TextView) findViewById3;
            View view5 = this.e;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dialogContent");
            }
            View findViewById4 = view5.findViewById(R.id.sub_title);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "dialogContent.findViewById(R.id.sub_title)");
            TextView textView9 = (TextView) findViewById4;
            View view6 = this.e;
            if (view6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dialogContent");
            }
            View findViewById5 = view6.findViewById(R.id.button_container);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "dialogContent.findViewById(R.id.button_container)");
            LinearLayout linearLayout3 = (LinearLayout) findViewById5;
            View view7 = this.e;
            if (view7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dialogContent");
            }
            View findViewById6 = view7.findViewById(R.id.bottom_btn_container);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "dialogContent.findViewBy….id.bottom_btn_container)");
            LinearLayout linearLayout4 = (LinearLayout) findViewById6;
            View view8 = this.e;
            if (view8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dialogContent");
            }
            View findViewById7 = view8.findViewById(R.id.left_container);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "dialogContent.findViewById(R.id.left_container)");
            FrameLayout frameLayout4 = (FrameLayout) findViewById7;
            View view9 = this.e;
            if (view9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dialogContent");
            }
            View findViewById8 = view9.findViewById(R.id.right_container);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "dialogContent.findViewById(R.id.right_container)");
            FrameLayout frameLayout5 = (FrameLayout) findViewById8;
            View view10 = this.e;
            if (view10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dialogContent");
            }
            View findViewById9 = view10.findViewById(R.id.bottom_divider);
            Intrinsics.checkNotNullExpressionValue(findViewById9, "dialogContent.findViewById(R.id.bottom_divider)");
            co0 co0Var2 = this.k;
            String str7 = null;
            if (co0Var2 != null && (h2 = co0Var2.h()) != null) {
                co0 co0Var3 = this.k;
                Intrinsics.checkNotNull(co0Var3);
                boolean z2 = !co0Var3.q();
                co0 co0Var4 = this.k;
                Intrinsics.checkNotNull(co0Var4);
                if (co0Var4.q()) {
                    str6 = ClogBuilder.LogType.FREE_CLICK.type;
                } else {
                    str6 = ClogBuilder.LogType.CLICK.type;
                }
                String str8 = str6;
                Intrinsics.checkNotNullExpressionValue(str8, "if (rewardData!!.isDownl…CK.type\n                }");
                String str9 = ClogBuilder.Area.AD_BTN_DETAIL.type;
                Intrinsics.checkNotNullExpressionValue(str9, "ClogBuilder.Area.AD_BTN_DETAIL.type");
                co0 co0Var5 = this.k;
                Intrinsics.checkNotNull(co0Var5);
                view2 = findViewById9;
                frameLayout = frameLayout5;
                adImageView = adImageView2;
                frameLayout2 = frameLayout4;
                textView = K1(this, h2, str8, str9, null, z2, co0Var5.q(), 8, null);
            } else {
                view2 = findViewById9;
                frameLayout = frameLayout5;
                adImageView = adImageView2;
                frameLayout2 = frameLayout4;
                textView = null;
            }
            co0 co0Var6 = this.k;
            if (co0Var6 != null && (l = co0Var6.l()) != null) {
                linearLayout = linearLayout4;
                textView2 = textView;
                textView3 = K1(this, l, null, null, "1", false, false, 54, null);
            } else {
                linearLayout = linearLayout4;
                textView2 = textView;
                textView3 = null;
            }
            if (!this.n && (co0Var = this.k) != null && (f2 = co0Var.f()) != null) {
                frameLayout3 = frameLayout2;
                textView4 = textView3;
                textView5 = K1(this, f2, null, null, "2", false, false, 54, null);
            } else {
                frameLayout3 = frameLayout2;
                textView4 = textView3;
                textView5 = null;
            }
            co0 co0Var7 = this.k;
            if (co0Var7 != null && (e2 = co0Var7.e()) != null) {
                String str10 = ClogBuilder.Area.AD_LEAVE.type;
                Intrinsics.checkNotNullExpressionValue(str10, "ClogBuilder.Area.AD_LEAVE.type");
                textView6 = textView5;
                textView7 = K1(this, e2, null, str10, null, false, false, 58, null);
            } else {
                textView6 = textView5;
                textView7 = null;
            }
            co0 co0Var8 = this.k;
            if (co0Var8 != null) {
                str = co0Var8.a();
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                i2 = 1;
                z = false;
            } else {
                i2 = 1;
                z = true;
            }
            if (!z) {
                adImageView3.setVisibility(0);
            } else {
                adImageView3.setVisibility(8);
                adImageView3 = null;
            }
            if (adImageView3 != null) {
                co0 co0Var9 = this.k;
                if (co0Var9 != null) {
                    str5 = co0Var9.a();
                } else {
                    str5 = null;
                }
                adImageView3.g(str5);
                adImageView3.setOnClickListener(new g(this));
                Unit unit = Unit.INSTANCE;
            }
            co0 co0Var10 = this.k;
            if (co0Var10 != null) {
                str2 = co0Var10.n();
            } else {
                str2 = null;
            }
            if (str2 != null && !StringsKt__StringsJVMKt.isBlank(str2)) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            if ((i3 ^ i2) != 0) {
                textView8.setVisibility(0);
            } else {
                textView8.setVisibility(8);
                textView8 = null;
            }
            if (textView8 != null) {
                co0 co0Var11 = this.k;
                if (co0Var11 != null) {
                    str4 = co0Var11.n();
                } else {
                    str4 = null;
                }
                textView8.setText(str4);
                textView8.setOnClickListener(new h(this));
                Unit unit2 = Unit.INSTANCE;
            }
            co0 co0Var12 = this.k;
            if (co0Var12 != null) {
                str3 = co0Var12.m();
            } else {
                str3 = null;
            }
            if (str3 != null && str3.length() != 0) {
                i4 = 0;
            } else {
                i4 = 1;
            }
            if ((i4 ^ i2) != 0) {
                textView9.setVisibility(0);
            } else {
                textView9.setVisibility(8);
                textView9 = null;
            }
            if (textView9 != null) {
                co0 co0Var13 = this.k;
                if (co0Var13 != null) {
                    str7 = co0Var13.m();
                }
                textView9.setText(str7);
                textView9.setOnClickListener(new i(this));
                Unit unit3 = Unit.INSTANCE;
            }
            if (textView4 != null) {
                textView4.setTypeface(Typeface.defaultFromStyle(i2));
                textView4.setTextSize(i2, 17.0f);
                textView4.setGravity(17);
                textView4.setHeight(r31.c.a(textView4.getContext(), 50.0f));
                textView4.setWidth(r31.c.a(textView4.getContext(), 219.0f));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.topMargin = r31.c.a(textView4.getContext(), 15.0f);
                linearLayout3.addView(textView4, 0, layoutParams);
                Unit unit4 = Unit.INSTANCE;
            }
            if (textView2 != null) {
                textView2.setTypeface(Typeface.defaultFromStyle(i2));
                textView2.setTextSize(i2, 12.0f);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.gravity = 17;
                linearLayout3.addView(textView2, 0, layoutParams2);
                Unit unit5 = Unit.INSTANCE;
            }
            TextView textView10 = textView6;
            if (textView10 == null) {
                i2 = 0;
            }
            if (i2 != 0) {
                view2.setVisibility(0);
            } else {
                view2.setVisibility(8);
            }
            if (textView7 != null) {
                S1(textView7, frameLayout3);
                linearLayout2 = linearLayout;
                linearLayout2.setVisibility(0);
                Unit unit6 = Unit.INSTANCE;
            } else {
                linearLayout2 = linearLayout;
            }
            if (textView10 != null) {
                S1(textView10, frameLayout);
                linearLayout2.setVisibility(0);
                Unit unit7 = Unit.INSTANCE;
            }
            M1(adImageView);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        InterceptResult invokeL;
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, bundle)) == null) {
            Dialog onCreateDialog = super.onCreateDialog(bundle);
            Intrinsics.checkNotNullExpressionValue(onCreateDialog, "super.onCreateDialog(savedInstanceState)");
            Window window = onCreateDialog.getWindow();
            if (window != null) {
                layoutParams = window.getAttributes();
            } else {
                layoutParams = null;
            }
            if (layoutParams != null) {
                layoutParams.gravity = 17;
            }
            Window window2 = onCreateDialog.getWindow();
            if (window2 != null) {
                window2.setAttributes(layoutParams);
            }
            return onCreateDialog;
        }
        return (Dialog) invokeL.objValue;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        boolean z;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, inflater, viewGroup, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            boolean z2 = true;
            View rootView = inflater.inflate(R.layout.nad_reward_video_dialog, viewGroup, true);
            View findViewById = rootView.findViewById(R.id.obfuscated_res_0x7f091d60);
            Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.root_view)");
            this.a = findViewById;
            View findViewById2 = rootView.findViewById(R.id.top_img);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.top_img)");
            this.b = (AdImageView) findViewById2;
            View findViewById3 = rootView.findViewById(R.id.dialog_top_img);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.dialog_top_img)");
            this.c = (AdImageView) findViewById3;
            View findViewById4 = rootView.findViewById(R.id.dialog_content);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.dialog_content)");
            this.d = (ViewStub) findViewById4;
            Bundle arguments = getArguments();
            String str = "";
            this.m = (arguments == null || (r6 = arguments.getString("extra_ext")) == null) ? "" : "";
            Bundle arguments2 = getArguments();
            if (arguments2 != null && (string = arguments2.getString("extra_reward_data")) != null) {
                str = string;
            }
            Intrinsics.checkNotNullExpressionValue(str, "arguments?.getString(EXTRA_REWARD_DATA) ?: \"\"");
            this.k = new co0(str);
            Bundle arguments3 = getArguments();
            if (arguments3 != null) {
                z = arguments3.getBoolean("extra_upper_limit");
            } else {
                z = false;
            }
            this.n = z;
            if (this.m.length() != 0) {
                z2 = false;
            }
            if (!z2 && this.k != null) {
                V1();
                N1();
                Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
                return rootView;
            }
            dismiss();
            Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
            return rootView;
        }
        return (View) invokeLLL.objValue;
    }
}
