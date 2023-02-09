package com.baidu.card.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.BottomCommonTipLayout;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.MemberBroadcastHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.data.MemberBroadcastData;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tieba.R;
import com.baidu.tieba.da;
import com.baidu.tieba.k95;
import com.baidu.tieba.n45;
import com.baidu.tieba.on;
import com.baidu.tieba.p09;
import com.baidu.tieba.ro;
import com.baidu.tieba.t99;
import com.baidu.tieba.x9;
import com.baidu.tieba.yg;
import com.baidu.tieba.zg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 ,2\u00020\u0001:\u0002,-B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u0012\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u001c\u001a\u00020\"H\u0002J\u0006\u0010#\u001a\u00020\u001aJ\u0012\u0010$\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010%H\u0002J\u0010\u0010&\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J(\u0010'\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020\f2\u0006\u0010*\u001a\u00020\nJ\u0010\u0010+\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u0012\u0010\u0007\u001a\u00060\bR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/baidu/card/view/BottomCommonTipLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "animationHandler", "Lcom/baidu/card/view/BottomCommonTipLayout$ShowAnimationHandler;", "mFid", "", "mScene", "", "mSource", "mTipBackgroundImg", "Landroid/widget/ImageView;", "mTipButton", "Lcom/baidu/tbadk/core/view/commonBtn/TBSpecificationBtn;", "mTipLeftImg", "mTipMessageView", "Landroid/widget/TextView;", "canLoadWithGlide", "", "img", "Lcom/baidu/adp/widget/ImageView/BdImage;", "changeSkin", "", "clickStatistic", "data", "Lcom/baidu/tbadk/data/MemberBroadcastData;", "createDrawable", "Landroid/graphics/drawable/Drawable;", "createImageSpan", "Lcom/baidu/adp/widget/StickerSpan;", "Lcom/baidu/tbadk/widget/richText/TbRichTextData;", "dismiss", "parseAndShowMessage", "Lcom/baidu/tbadk/widget/richText/TbRichText;", "setData", "show", "source", "scene", "fid", "showStatistic", "Companion", "ShowAnimationHandler", "tbadk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class BottomCommonTipLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public String c;
    public ImageView d;
    public ImageView e;
    public TextView f;
    public TBSpecificationBtn g;
    public final a h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2050702043, "Lcom/baidu/card/view/BottomCommonTipLayout;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2050702043, "Lcom/baidu/card/view/BottomCommonTipLayout;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BottomCommonTipLayout(Context context) {
        this(context, null, 2, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (DefaultConstructorMarker) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static final void a(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, view2) == null) {
        }
    }

    /* loaded from: classes2.dex */
    public final class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<BottomCommonTipLayout> a;
        public final int b;
        public final /* synthetic */ BottomCommonTipLayout c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(BottomCommonTipLayout this$0, BottomCommonTipLayout bottomCommonTipLayout) {
            super(Looper.getMainLooper());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {this$0, bottomCommonTipLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.c = this$0;
            this.a = new WeakReference<>(bottomCommonTipLayout);
            this.b = 800;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, msg) == null) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                int i = msg.what;
                if (i != 1) {
                    if (i == 2) {
                        BottomCommonTipLayout bottomCommonTipLayout = this.a.get();
                        Intrinsics.checkNotNull(bottomCommonTipLayout);
                        t99.b(bottomCommonTipLayout, this.b);
                        return;
                    }
                    return;
                }
                BottomCommonTipLayout bottomCommonTipLayout2 = this.a.get();
                Intrinsics.checkNotNull(bottomCommonTipLayout2);
                t99.d(bottomCommonTipLayout2, this.b);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends yg<on> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BottomCommonTipLayout a;
        public final /* synthetic */ ro b;

        public b(BottomCommonTipLayout bottomCommonTipLayout, ro roVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bottomCommonTipLayout, roVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bottomCommonTipLayout;
            this.b = roVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yg
        public void onLoaded(on onVar, String key, int i) {
            Drawable i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, onVar, key, i) == null) {
                Intrinsics.checkNotNullParameter(key, "key");
                super.onLoaded((b) onVar, key, i);
                if (onVar != null && onVar.w() && (i2 = this.a.i(onVar)) != null) {
                    this.b.a(i2);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class c implements k95.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BottomCommonTipLayout a;
        public final /* synthetic */ MemberBroadcastData b;

        public c(BottomCommonTipLayout bottomCommonTipLayout, MemberBroadcastData memberBroadcastData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bottomCommonTipLayout, memberBroadcastData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bottomCommonTipLayout;
            this.b = memberBroadcastData;
        }

        @Override // com.baidu.tieba.k95.a
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.getVisibility() == 0 || this.a.h.hasMessages(1) || this.a.h.hasMessages(2)) {
                return;
            }
            this.a.setData(this.b);
            long j = 7000;
            if (this.b.getShowTime() > 0) {
                j = this.b.getShowTime() * 1000;
            }
            this.a.h.sendEmptyMessage(1);
            this.a.h.sendEmptyMessageDelayed(2, j);
            this.a.p(this.b);
            if (this.b.getBroadcastType() == 1) {
                MemberBroadcastHelper.saveSpInfo(1);
            } else if (this.b.getBroadcastType() == 2) {
                MemberBroadcastHelper.saveSpInfo(2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BottomCommonTipLayout(Context context, AttributeSet attributeSet) {
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
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = "";
        this.c = "";
        LayoutInflater.from(context).inflate(R.layout.bottom_common_tip_layout, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.tip_background);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tip_background)");
        this.d = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.tip_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.tip_icon)");
        this.e = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.tip_message);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.tip_message)");
        this.f = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.tip_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.tip_btn)");
        this.g = (TBSpecificationBtn) findViewById4;
        g();
        this.h = new a(this, this);
        setVisibility(4);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hz
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    BottomCommonTipLayout.a(view2);
                }
            }
        });
    }

    public /* synthetic */ BottomCommonTipLayout(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public static final Drawable k(TbRichTextData data, BottomCommonTipLayout this$0, ro roVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, data, this$0, roVar)) == null) {
            Intrinsics.checkNotNullParameter(data, "$data");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            on onVar = (on) zg.h().n(data.O().L(), 21, new Object[0]);
            Drawable i = this$0.i(onVar);
            if (onVar == null) {
                zg.h().m(data.O().L(), 21, new b(this$0, roVar), null);
            } else if (i != null) {
                roVar.a(i);
            }
            return i;
        }
        return (Drawable) invokeLLL.objValue;
    }

    public static final void n(MemberBroadcastData data, BottomCommonTipLayout this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, data, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(data, "$data");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (!TextUtils.isEmpty(data.rightBtnUrl)) {
                String str = data.rightBtnUrl;
                if (!TextUtils.isEmpty(this$0.a)) {
                    str = ((Object) str) + "&source=" + this$0.a;
                }
                x9<?> a2 = da.a(this$0.getContext());
                if (a2 != null) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) a2, new String[]{str});
                    this$0.h(data);
                    this$0.setVisibility(4);
                    this$0.h.removeMessages(2);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.TbPageContext<*>");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setData(final MemberBroadcastData memberBroadcastData) {
        byte[] k;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, memberBroadcastData) == null) {
            byte[] bArr = null;
            if (!TextUtils.isEmpty(memberBroadcastData.getBackgroundSrc())) {
                on onVar = (on) zg.h().n(memberBroadcastData.getBackgroundSrc(), 33, new Object[0]);
                if (f(onVar)) {
                    RequestManager with = Glide.with(getContext());
                    if (onVar == null) {
                        k = null;
                    } else {
                        k = onVar.k();
                    }
                    with.load(k).into(this.d);
                }
            }
            if (!TextUtils.isEmpty(memberBroadcastData.getLeftIconSrc())) {
                on onVar2 = (on) zg.h().n(memberBroadcastData.getLeftIconSrc(), 33, new Object[0]);
                if (f(onVar2)) {
                    RequestManager with2 = Glide.with(getContext());
                    if (onVar2 != null) {
                        bArr = onVar2.k();
                    }
                    with2.load(bArr).into(this.e);
                }
                if (memberBroadcastData.getLeftIconWidth() > 0 && memberBroadcastData.getLeftIconHeight() > 0) {
                    ViewGroup.LayoutParams layoutParams = this.e.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new ViewGroup.LayoutParams(-2, -2);
                    }
                    layoutParams.width = (int) (memberBroadcastData.getLeftIconWidth() * 1.5d);
                    layoutParams.height = (int) (memberBroadcastData.getLeftIconHeight() * 1.5d);
                    this.e.setLayoutParams(layoutParams);
                }
            }
            if (!TextUtils.isEmpty(memberBroadcastData.getRightBtnText())) {
                this.g.setText(memberBroadcastData.getRightBtnText());
            } else {
                this.g.setText("去看看");
            }
            n45 n45Var = new n45();
            if (!TextUtils.isEmpty(memberBroadcastData.getBtnBackgroundColor()) && !TextUtils.isEmpty(memberBroadcastData.getBtnTextColor())) {
                n45Var.q(p09.f(memberBroadcastData.getBtnBackgroundColor()), p09.f(memberBroadcastData.getBtnTextColor()));
            } else {
                n45Var.w(R.color.CAM_X0108);
            }
            this.g.setConfig(n45Var);
            this.g.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.jz
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        BottomCommonTipLayout.n(MemberBroadcastData.this, this, view2);
                    }
                }
            });
            if (!TextUtils.isEmpty(memberBroadcastData.getTextColor())) {
                this.f.setTextColor(p09.f(memberBroadcastData.getTextColor()));
            }
            m(memberBroadcastData.getTbRichText());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0026, code lost:
        if (((android.app.Activity) r5).isDestroyed() == false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean f(on onVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, onVar)) == null) {
            if (onVar != null && onVar.w() && getContext() != null) {
                if (Build.VERSION.SDK_INT >= 17) {
                    Context context = getContext();
                    if (context == null) {
                        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
                    }
                }
                Context context2 = getContext();
                if (context2 != null) {
                    if (!((Activity) context2).isFinishing()) {
                        return true;
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void h(MemberBroadcastData memberBroadcastData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, memberBroadcastData) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.MEMBER_BROADCAST_CLICK).param("obj_type", memberBroadcastData.getSceneCondition()).param("obj_locate", this.b).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("source", this.a);
            Intrinsics.checkNotNullExpressionValue(param, "StatisticItem(TbadkCoreS…rams.REC_SOURCE, mSource)");
            if (StringUtils.isNotNull(this.c)) {
                param.param("fid", this.c);
            }
            TiebaStatic.log(param);
        }
    }

    public final void p(MemberBroadcastData memberBroadcastData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, memberBroadcastData) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.MEMBER_BROADCAST_SHOW).param("obj_type", memberBroadcastData.getSceneCondition()).param("obj_locate", this.b).param("uid", TbadkCoreApplication.getCurrentAccountId());
            Intrinsics.checkNotNullExpressionValue(param, "StatisticItem(TbadkCoreS…on.getCurrentAccountId())");
            if (StringUtils.isNotNull(this.c)) {
                param.param("fid", this.c);
            }
            TiebaStatic.log(param);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.d.setColorFilter(SkinManager.getColor(R.color.CAM_X1503), PorterDuff.Mode.SRC_ATOP);
            this.e.setColorFilter(SkinManager.getColor(R.color.CAM_X1503), PorterDuff.Mode.SRC_ATOP);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || getVisibility() != 0) {
            return;
        }
        this.h.removeMessages(2);
        this.h.sendEmptyMessage(2);
    }

    public final Drawable i(on onVar) {
        InterceptResult invokeL;
        Bitmap p;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, onVar)) == null) {
            if (onVar == null || (p = onVar.p()) == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable((Resources) null, p);
            int i2 = TbConfig.SUBPB_FONT_SIZE_SMALL;
            if (p.getHeight() > 0 && p.getWidth() > 0) {
                i = (p.getWidth() * i2) / p.getHeight();
            } else {
                i = i2;
            }
            bitmapDrawable.setBounds(0, 0, i, i2);
            return bitmapDrawable;
        }
        return (Drawable) invokeL.objValue;
    }

    public final ro j(final TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbRichTextData)) == null) {
            if (tbRichTextData.O() != null && !TextUtils.isEmpty(tbRichTextData.O().L())) {
                return new ro(new ro.a() { // from class: com.baidu.tieba.iz
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.ro.a
                    public final Drawable a(ro roVar) {
                        InterceptResult invokeL2;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, roVar)) == null) ? BottomCommonTipLayout.k(TbRichTextData.this, this, roVar) : (Drawable) invokeL2.objValue;
                    }
                }, 0, 1);
            }
            return null;
        }
        return (ro) invokeL.objValue;
    }

    public final void m(TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, tbRichText) == null) && tbRichText != null && !ListUtils.isEmpty(tbRichText.I())) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            int i = 0;
            int size = tbRichText.I().size() - 1;
            if (size >= 0) {
                while (true) {
                    int i2 = i + 1;
                    TbRichTextData item = tbRichText.I().get(i);
                    if (item.getType() == 8) {
                        Intrinsics.checkNotNullExpressionValue(item, "item");
                        ro j = j(item);
                        spannableStringBuilder.append((CharSequence) " ");
                        spannableStringBuilder.setSpan(j, spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 17);
                    } else if (item.getType() == 1 && !TextUtils.isEmpty(item.S())) {
                        spannableStringBuilder.append((CharSequence) item.S());
                    }
                    if (i2 > size) {
                        break;
                    }
                    i = i2;
                }
            }
            this.f.setMarqueeRepeatLimit(10);
            this.f.setText(spannableStringBuilder);
        }
    }

    public final void o(MemberBroadcastData memberBroadcastData, String source, int i, String fid) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048583, this, memberBroadcastData, source, i, fid) == null) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(fid, "fid");
            if (memberBroadcastData == null) {
                return;
            }
            this.a = source;
            this.b = i;
            this.c = fid;
            ArrayList arrayList = new ArrayList();
            arrayList.add(memberBroadcastData.getBackgroundSrc());
            arrayList.add(memberBroadcastData.getLeftIconSrc());
            new k95().c(arrayList, new c(this, memberBroadcastData), 33);
        }
    }
}
