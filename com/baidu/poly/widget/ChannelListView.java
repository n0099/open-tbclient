package com.baidu.poly.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.statistics.exception.SdkException;
import com.baidu.poly.wallet.paychannel.IChannelAuth;
import com.baidu.poly.widget.ChannelItemView;
import com.baidu.poly.widget.PopupWindow;
import com.baidu.poly.widget.coupon.CouponEntranceView;
import com.baidu.poly.widget.coupon.CouponListView;
import com.baidu.poly.widget.digitalbank.DigitalBankPayView;
import com.baidu.poly.widget.digitalbank.DigitalWalletVerifyView;
import com.baidu.poly.widget.entitiy.InstallmentEntity;
import com.baidu.poly.widget.entitiy.PayChannelExtInfoEntity;
import com.baidu.poly.widget.hostmarket.HostMarketView;
import com.baidu.poly.widget.toast.ToastLoadingView;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.tieba.R;
import com.baidu.tieba.dd1;
import com.baidu.tieba.de1;
import com.baidu.tieba.gd1;
import com.baidu.tieba.ld1;
import com.baidu.tieba.mb1;
import com.baidu.tieba.ob1;
import com.baidu.tieba.oc1;
import com.baidu.tieba.od1;
import com.baidu.tieba.pd1;
import com.baidu.tieba.qd1;
import com.baidu.tieba.sc1;
import com.baidu.tieba.tc1;
import com.baidu.tieba.uc1;
import com.baidu.tieba.wb1;
import com.baidu.tieba.xc1;
import com.baidu.tieba.zd1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventAlias;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ChannelListView extends FrameLayout implements View.OnClickListener, DigitalBankPayView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public View B;
    public View C;
    public CouponEntranceView D;
    public View E;
    public View F;
    public CouponListView G;
    public PeriodView H;
    public ToastLoadingView I;
    public Long J;
    public Long K;
    public od1 L;
    public IChannelAuth M;
    public PopupWindow N;
    public String O;
    public zd1 P;
    public boolean Q;
    public boolean R;
    public Runnable S;

    /* renamed from: T  reason: collision with root package name */
    public boolean f1054T;
    public boolean U;
    public String V;
    public String W;
    public View a;
    public boolean a0;
    public RelativeLayout b;
    public boolean b0;
    public PolyFrameLayout c;
    public String c0;
    public TipView d;
    public ViewGroup e;
    public Bundle f;
    public ProgressButton g;
    public mb1.c h;
    public View i;
    public View j;
    public DigitalBankPayView k;
    public DigitalWalletVerifyView l;
    public TextView m;
    public PayChannelEntity n;
    public PayChannelEntity[] o;
    public PayChannelEntity p;
    public boolean q;
    public boolean r;
    public int s;
    public m t;
    public Animation u;
    public Animation v;
    public DuVipGuideView w;
    public View x;
    public HostMarketView y;
    public TextView z;

    /* loaded from: classes3.dex */
    public interface m {
        void onClose();
    }

    /* loaded from: classes3.dex */
    public class a implements CouponListView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChannelListView a;

        public a(ChannelListView channelListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {channelListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = channelListView;
        }

        @Override // com.baidu.poly.widget.coupon.CouponListView.h
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.k0();
            }
        }

        @Override // com.baidu.poly.widget.coupon.CouponListView.h
        public void onDetach() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048579, this) != null) {
                return;
            }
            this.a.G = null;
        }

        @Override // com.baidu.poly.widget.coupon.CouponListView.h
        public void b(zd1.a aVar, pd1 pd1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, pd1Var) != null) || aVar == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(aVar.i);
            if (this.a.n != null && this.a.n.getIsSelected() == 1) {
                arrayList.add(this.a.n.getHostMarketingDetail());
            }
            this.a.N(arrayList, pd1Var);
        }

        @Override // com.baidu.poly.widget.coupon.CouponListView.h
        public void c(boolean z, zd1.a aVar) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, aVar) != null) || this.a.G == null) {
                return;
            }
            this.a.G.s(this.a.b);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements pd1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pd1 a;
        public final /* synthetic */ ChannelListView b;

        public b(ChannelListView channelListView, pd1 pd1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {channelListView, pd1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = channelListView;
            this.a = pd1Var;
        }

        @Override // com.baidu.tieba.pd1
        public void a(pd1.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (aVar.a == 0) {
                    this.b.J = Long.valueOf(aVar.d);
                    this.b.h0();
                    if (this.b.n != null && this.b.n.getIsSelected() == 1) {
                        this.b.n.setHostMarketingDetail(aVar.f);
                    }
                }
                this.a.a(aVar);
                this.b.D.c();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends ob1<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChannelListView a;

        public c(ChannelListView channelListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {channelListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = channelListView;
        }

        @Override // com.baidu.tieba.ob1
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048576, this, th, str) != null) || this.a.o != null) {
                return;
            }
            this.a.p0(str);
            ChannelListView channelListView = this.a;
            channelListView.b0(3, this.a.getContext().getString(R.string.obfuscated_res_0x7f0f08f7) + str, "0");
            this.a.S();
            uc1 uc1Var = new uc1("1");
            uc1Var.b(new SdkException("gatewaylist error --> " + str, th).getStackMessage());
            xc1.e(uc1Var);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.baidu.poly.widget.ChannelListView.D(com.baidu.poly.widget.ChannelListView, com.baidu.poly.widget.PayChannelEntity[]):com.baidu.poly.widget.PayChannelEntity[]
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
            	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.isRegister()" because "arg" is null
            	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
            	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
            	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
            	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
            	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
            	... 1 more
            */
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ob1
        /* renamed from: d */
        public void c(org.json.JSONObject r9) {
            /*
                r8 = this;
                com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.poly.widget.ChannelListView.c.$ic
                if (r0 != 0) goto L20a
            L4:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "requestChannelList onSuccess result="
                r0.append(r1)
                java.lang.String r1 = r9.toString()
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                com.baidu.tieba.gd1.g(r0)
                long r0 = java.lang.System.currentTimeMillis()
                java.lang.String r2 = "1.04"
                com.baidu.tieba.tc1.a(r2, r0)
                java.lang.String r0 = "payMoney"
                long r0 = r9.optLong(r0)
                java.lang.Long r0 = java.lang.Long.valueOf(r0)
                com.baidu.poly.widget.ChannelListView r1 = r8.a
                java.lang.String r2 = "isFoldChannel"
                java.lang.String r2 = r9.optString(r2)
                com.baidu.poly.widget.ChannelListView.p(r1, r2)
                java.lang.String r1 = "showTotalAmount"
                java.lang.String r2 = "1"
                java.lang.String r1 = r9.optString(r1, r2)
                com.baidu.poly.widget.ChannelListView r3 = r8.a
                boolean r1 = r1.equals(r2)
                com.baidu.poly.widget.ChannelListView.r(r3, r1)
                com.baidu.poly.widget.ChannelListView r1 = r8.a
                com.baidu.poly.widget.ChannelListView.n(r1, r0)
                java.lang.String r0 = "payChannels"
                org.json.JSONArray r0 = r9.optJSONArray(r0)
                java.lang.String r1 = "7"
                if (r0 == 0) goto L1f2
                int r2 = r0.length()
                if (r2 > 0) goto L64
                goto L1f2
            L64:
                int r2 = r0.length()
                com.baidu.poly.widget.PayChannelEntity[] r2 = new com.baidu.poly.widget.PayChannelEntity[r2]
                r3 = 0
                r4 = 0
            L6c:
                int r5 = r0.length()
                r6 = 1
                if (r4 >= r5) goto L90
                com.baidu.poly.widget.PayChannelEntity r5 = new com.baidu.poly.widget.PayChannelEntity
                org.json.JSONObject r7 = r0.optJSONObject(r4)
                r5.<init>(r7)
                int r7 = r5.getIsSelected()
                if (r7 != r6) goto L8b
                com.baidu.poly.widget.ChannelListView r6 = r8.a
                java.lang.String r7 = r5.getPayChannel()
                com.baidu.poly.widget.ChannelListView.s(r6, r7)
            L8b:
                r2[r4] = r5
                int r4 = r4 + 1
                goto L6c
            L90:
                com.baidu.poly.widget.ChannelListView r0 = r8.a
                com.baidu.poly.widget.ChannelListView.d(r0, r2)
                java.lang.String r0 = "coupons"
                org.json.JSONArray r0 = r9.optJSONArray(r0)
                com.baidu.poly.widget.ChannelListView r2 = r8.a
                com.baidu.tieba.zd1 r4 = new com.baidu.tieba.zd1
                r4.<init>(r0)
                com.baidu.poly.widget.ChannelListView.u(r2, r4)
                com.baidu.poly.widget.ChannelListView r0 = r8.a
                com.baidu.poly.widget.coupon.CouponEntranceView r0 = com.baidu.poly.widget.ChannelListView.I(r0)
                com.baidu.poly.widget.ChannelListView r2 = r8.a
                com.baidu.tieba.zd1 r2 = com.baidu.poly.widget.ChannelListView.t(r2)
                r0.d(r2)
                com.baidu.poly.widget.ChannelListView r0 = r8.a
                com.baidu.poly.widget.coupon.CouponListView r0 = com.baidu.poly.widget.ChannelListView.h(r0)
                if (r0 == 0) goto Lcd
                com.baidu.poly.widget.ChannelListView r0 = r8.a
                com.baidu.poly.widget.coupon.CouponListView r0 = com.baidu.poly.widget.ChannelListView.h(r0)
                com.baidu.poly.widget.ChannelListView r2 = r8.a
                com.baidu.tieba.zd1 r2 = com.baidu.poly.widget.ChannelListView.t(r2)
                java.util.List<com.baidu.tieba.zd1$a> r2 = r2.b
                r0.u(r2)
            Lcd:
                java.lang.String r0 = "渲染coupon结束"
                com.baidu.tieba.gd1.g(r0)
                java.lang.String r0 = "marketChannels"
                org.json.JSONArray r0 = r9.optJSONArray(r0)
                if (r0 == 0) goto Lef
                int r2 = r0.length()
                if (r2 <= 0) goto Lef
                com.baidu.poly.widget.PayChannelEntity r2 = new com.baidu.poly.widget.PayChannelEntity
                org.json.JSONObject r0 = r0.optJSONObject(r3)
                r2.<init>(r0)
                com.baidu.poly.widget.ChannelListView r0 = r8.a
                com.baidu.poly.widget.ChannelListView.l(r0, r2)
            Lef:
                java.lang.String r0 = "渲染hostMark结束"
                com.baidu.tieba.gd1.g(r0)
                java.lang.String r0 = "guideInfo"
                org.json.JSONObject r9 = r9.optJSONObject(r0)
                r0 = 8
                if (r9 == 0) goto L11b
                com.baidu.poly.widget.ChannelListView r2 = r8.a
                com.baidu.poly.widget.DuVipGuideView r2 = com.baidu.poly.widget.ChannelListView.x(r2)
                r2.setVisibility(r3)
                com.baidu.poly.widget.ChannelListView r2 = r8.a
                android.view.View r2 = com.baidu.poly.widget.ChannelListView.y(r2)
                r2.setVisibility(r3)
                com.baidu.poly.widget.ChannelListView r2 = r8.a
                com.baidu.poly.widget.DuVipGuideView r2 = com.baidu.poly.widget.ChannelListView.x(r2)
                r2.b(r9)
                goto L12d
            L11b:
                com.baidu.poly.widget.ChannelListView r9 = r8.a
                android.view.View r9 = com.baidu.poly.widget.ChannelListView.y(r9)
                r9.setVisibility(r0)
                com.baidu.poly.widget.ChannelListView r9 = r8.a
                com.baidu.poly.widget.DuVipGuideView r9 = com.baidu.poly.widget.ChannelListView.x(r9)
                r9.setVisibility(r0)
            L12d:
                com.baidu.tieba.tc1.h(r1)
                com.baidu.poly.widget.ChannelListView r9 = r8.a
                com.baidu.poly.widget.PayChannelEntity[] r9 = com.baidu.poly.widget.ChannelListView.c(r9)
                int r9 = r9.length
                if (r9 != r6) goto L1ac
                com.baidu.poly.widget.ChannelListView r9 = r8.a
                com.baidu.poly.widget.coupon.CouponEntranceView r9 = com.baidu.poly.widget.ChannelListView.I(r9)
                int r9 = r9.getVisibility()
                if (r9 != r0) goto L1ac
                com.baidu.poly.widget.ChannelListView r9 = r8.a
                com.baidu.poly.widget.PayChannelEntity r9 = com.baidu.poly.widget.ChannelListView.k(r9)
                if (r9 != 0) goto L1ac
                com.baidu.poly.widget.ChannelListView r9 = r8.a
                com.baidu.poly.widget.PayChannelEntity[] r9 = com.baidu.poly.widget.ChannelListView.c(r9)
                r9 = r9[r3]
                if (r9 == 0) goto L1ac
                com.baidu.poly.widget.ChannelListView r9 = r8.a
                com.baidu.poly.widget.ChannelListView.z(r9, r6)
                com.baidu.poly.widget.ChannelListView r9 = r8.a
                com.baidu.poly.widget.ChannelListView.q(r9)
                com.baidu.poly.widget.ChannelListView r9 = r8.a
                com.baidu.poly.widget.TipView r9 = com.baidu.poly.widget.ChannelListView.A(r9)
                com.baidu.poly.widget.ChannelListView r0 = r8.a
                com.baidu.poly.widget.PayChannelEntity[] r0 = com.baidu.poly.widget.ChannelListView.c(r0)
                r0 = r0[r3]
                java.lang.String r0 = r0.getLoadingIcon()
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "即将进入"
                r1.append(r2)
                com.baidu.poly.widget.ChannelListView r2 = r8.a
                com.baidu.poly.widget.PayChannelEntity[] r2 = com.baidu.poly.widget.ChannelListView.c(r2)
                r2 = r2[r3]
                java.lang.String r2 = r2.getDisplayName()
                r1.append(r2)
                java.lang.String r2 = "…"
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r9.d(r0, r1)
                com.baidu.poly.widget.ChannelListView r9 = r8.a
                com.baidu.poly.widget.PayChannelEntity[] r0 = com.baidu.poly.widget.ChannelListView.c(r9)
                r0 = r0[r3]
                com.baidu.poly.widget.ChannelListView.B(r9, r0)
                java.lang.String r9 = "单渠道支付"
                com.baidu.tieba.gd1.g(r9)
                return
            L1ac:
                com.baidu.poly.widget.ChannelListView r9 = r8.a
                com.baidu.poly.widget.ChannelListView.o(r9)
                com.baidu.poly.widget.ChannelListView r9 = r8.a
                com.baidu.poly.widget.ChannelListView.C(r9)
                java.lang.String r9 = "渲染宿主营销结束"
                com.baidu.tieba.gd1.g(r9)
                com.baidu.poly.widget.ChannelListView r9 = r8.a
                com.baidu.poly.widget.PayChannelEntity[] r0 = com.baidu.poly.widget.ChannelListView.c(r9)
                com.baidu.poly.widget.ChannelListView.D(r9, r0)
                com.baidu.poly.widget.ChannelListView.d(r9, r0)
                com.baidu.poly.widget.ChannelListView r9 = r8.a
                com.baidu.poly.widget.ChannelListView.f(r9)
                java.lang.String r9 = "渲染支付渠道结束"
                com.baidu.tieba.gd1.g(r9)
                com.baidu.poly.widget.ChannelListView r9 = r8.a
                com.baidu.poly.widget.TipView r9 = com.baidu.poly.widget.ChannelListView.A(r9)
                r9.a()
                java.lang.String r9 = "隐藏loading状态"
                com.baidu.tieba.gd1.g(r9)
                com.baidu.poly.widget.ChannelListView r9 = r8.a
                com.baidu.poly.widget.ChannelListView.F(r9)
                com.baidu.poly.widget.ChannelListView r9 = r8.a
                com.baidu.poly.widget.ChannelListView.z(r9, r6)
                com.baidu.poly.widget.ChannelListView r9 = r8.a
                com.baidu.poly.widget.ChannelListView.q(r9)
                return
            L1f2:
                r9 = 0
                com.baidu.tieba.tc1.b(r1, r9, r9)
                com.baidu.poly.statistics.exception.ServerDataException r9 = new com.baidu.poly.statistics.exception.ServerDataException
                java.lang.String r0 = "channelList is null"
                r9.<init>(r0)
                java.lang.String r0 = "request channelList payChannels is null"
                r8.b(r9, r0)
                java.lang.String r9 = "requestChannelList channelList is null"
                com.baidu.tieba.gd1.g(r9)
                return
            L20a:
                r6 = r0
                r7 = 1048578(0x100002, float:1.469371E-39)
                com.baidu.titan.sdk.runtime.InterceptResult r0 = r6.invokeL(r7, r8, r9)
                if (r0 == 0) goto L4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.poly.widget.ChannelListView.c.c(org.json.JSONObject):void");
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChannelListView a;

        public d(ChannelListView channelListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {channelListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = channelListView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.q0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChannelListView a;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }

        public e(ChannelListView channelListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {channelListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = channelListView;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, animation) != null) {
                return;
            }
            this.a.f1054T = true;
            this.a.u0();
        }
    }

    /* loaded from: classes3.dex */
    public class f implements HostMarketView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChannelListView a;

        public f(ChannelListView channelListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {channelListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = channelListView;
        }

        @Override // com.baidu.poly.widget.hostmarket.HostMarketView.c
        public void b(pd1.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.a.c.a(false);
                ChannelListView channelListView = this.a;
                channelListView.removeCallbacks(channelListView.S);
                this.a.Y();
            }
        }

        @Override // com.baidu.poly.widget.hostmarket.HostMarketView.c
        public void a(boolean z, PayChannelEntity payChannelEntity, pd1 pd1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), payChannelEntity, pd1Var}) == null) {
                this.a.c.a(true);
                ChannelListView channelListView = this.a;
                channelListView.postDelayed(channelListView.S, 500L);
                if (payChannelEntity == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                if (z) {
                    arrayList.add(payChannelEntity.getHostMarketingDetail());
                }
                if (this.a.D.getSelectedItem() != null) {
                    arrayList.add(this.a.D.getSelectedItem().i);
                }
                this.a.N(arrayList, pd1Var);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChannelListView a;

        public g(ChannelListView channelListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {channelListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = channelListView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (this.a.getParent() instanceof ViewGroup)) {
                ChannelListView channelListView = this.a;
                channelListView.startAnimation(channelListView.v);
                ((ViewGroup) this.a.getParent()).removeView(this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChannelListView a;

        public h(ChannelListView channelListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {channelListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = channelListView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.R();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChannelListView a;

        public i(ChannelListView channelListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {channelListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = channelListView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.N != null && this.a.N.r()) {
                this.a.N.n();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements PopupWindow.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChannelListView a;

        public j(ChannelListView channelListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {channelListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = channelListView;
        }

        @Override // com.baidu.poly.widget.PopupWindow.b
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.R();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements ChannelItemView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PayChannelEntity a;
        public final /* synthetic */ ChannelListView b;

        public k(ChannelListView channelListView, PayChannelEntity payChannelEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {channelListView, payChannelEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = channelListView;
            this.a = payChannelEntity;
        }

        @Override // com.baidu.poly.widget.ChannelItemView.c
        public void a(ChannelItemView channelItemView) {
            PayChannelEntity[] payChannelEntityArr;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, channelItemView) == null) {
                if ("BAIDU-ALIPAY-WISE-HUABEI-INSTALLMENT".equals(this.a.getPayChannel())) {
                    sc1.b = "1";
                }
                sc1.a++;
                for (PayChannelEntity payChannelEntity : this.b.o) {
                    if (payChannelEntity == this.a) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    payChannelEntity.setIsSelected(i);
                }
                this.b.j0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l implements ChannelItemView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChannelListView a;

        public l(ChannelListView channelListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {channelListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = channelListView;
        }

        @Override // com.baidu.poly.widget.ChannelItemView.b
        public void a(InstallmentEntity installmentEntity) {
            ArrayList<InstallmentEntity> installmentEntities;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, installmentEntity) == null) {
                for (PayChannelEntity payChannelEntity : this.a.o) {
                    PayChannelExtInfoEntity payChannelExtInfoEntity = payChannelEntity.getPayChannelExtInfoEntity();
                    if (payChannelExtInfoEntity != null && (installmentEntities = payChannelExtInfoEntity.getInstallmentEntities()) != null && installmentEntities.size() != 0) {
                        Iterator<InstallmentEntity> it = installmentEntities.iterator();
                        while (it.hasNext()) {
                            InstallmentEntity next = it.next();
                            if (next != null) {
                                if (next.equals(installmentEntity)) {
                                    next.setIsSelected("1");
                                } else {
                                    next.setIsSelected("0");
                                }
                            }
                        }
                    }
                }
                this.a.j0();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelListView(PolyActivity polyActivity) {
        super(polyActivity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {polyActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.Q = true;
        this.R = false;
        this.S = new d(this);
        this.f1054T = false;
        this.U = false;
        this.a0 = true;
        Z();
    }

    public final PayChannelEntity[] W(PayChannelEntity[] payChannelEntityArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, payChannelEntityArr)) == null) {
            int i2 = 0;
            for (PayChannelEntity payChannelEntity : payChannelEntityArr) {
                if (payChannelEntity.getIsSelected() == 1 && (i2 = i2 + 1) > 1) {
                    payChannelEntity.setIsSelected(0);
                }
                if (payChannelEntity.getEnable() == 1) {
                    this.s++;
                }
            }
            if (i2 == 0) {
                for (PayChannelEntity payChannelEntity2 : payChannelEntityArr) {
                    if (payChannelEntity2.getEnable() == 1) {
                        payChannelEntity2.setIsSelected(1);
                        return payChannelEntityArr;
                    }
                }
            }
            return payChannelEntityArr;
        }
        return (PayChannelEntity[]) invokeL.objValue;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.poly.widget.ChannelListView.c.d(org.json.JSONObject):void] */
    public static /* synthetic */ void F(ChannelListView channelListView) {
        channelListView.i0();
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.poly.widget.ChannelListView.c.d(org.json.JSONObject):void] */
    public static /* synthetic */ void f(ChannelListView channelListView) {
        channelListView.j0();
    }

    public void O(ld1 ld1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ld1Var) != null) || ld1Var == null) {
            return;
        }
        tc1.f(System.currentTimeMillis());
        od1 od1Var = this.L;
        if (od1Var != null) {
            od1Var.m(ld1Var.a, ld1Var.b, ld1Var.c, this, this.c0);
        }
    }

    public final String V(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2)) == null) {
            return new DecimalFormat("0.00").format((j2 * 1.0d) / 100.0d);
        }
        return (String) invokeJ.objValue;
    }

    @Override // com.baidu.poly.widget.digitalbank.DigitalBankPayView.b
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048589, this, i2) == null) && R.id.obfuscated_res_0x7f091d45 == i2) {
            P(this.k.getSelectedChildrenEntity());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, motionEvent)) == null) {
            if (!this.r && !super.dispatchTouchEvent(motionEvent)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setChannelAuth(IChannelAuth iChannelAuth) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, iChannelAuth) == null) {
            this.M = iChannelAuth;
        }
    }

    public void setCloseListener(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, mVar) == null) {
            this.t = mVar;
        }
    }

    public void setIsPreparePaying(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.r = z;
            R();
            S();
        }
    }

    public void setResultListener(mb1.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, cVar) == null) {
            this.h = cVar;
        }
    }

    public void setWalletList(od1 od1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, od1Var) == null) {
            this.L = od1Var;
        }
    }

    public void setWechatH5Pay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            this.R = z;
        }
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.isRegister()" because "arg" is null
        	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
        	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
        	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
        	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
        	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
        	at jadx.core.dex.visitors.MarkMethodsForInline.visit(MarkMethodsForInline.java:37)
        */
    public static /* synthetic */ com.baidu.poly.widget.PayChannelEntity[] D(com.baidu.poly.widget.ChannelListView r0, com.baidu.poly.widget.PayChannelEntity[] r1) {
        /*
            r0.W(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.poly.widget.ChannelListView.D(com.baidu.poly.widget.ChannelListView, com.baidu.poly.widget.PayChannelEntity[]):com.baidu.poly.widget.PayChannelEntity[]");
    }

    public void T(Bundle bundle, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, bundle, str) == null) {
            s0(bundle, str);
        }
    }

    public void r0(String str, PayChannelEntity payChannelEntity) {
        DigitalWalletVerifyView digitalWalletVerifyView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048611, this, str, payChannelEntity) == null) && (digitalWalletVerifyView = this.l) != null) {
            digitalWalletVerifyView.E(this, this.f, str, payChannelEntity);
        }
    }

    public void d0(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048593, this, i2, str, str2) == null) {
            gd1.g("ChannelListView->payEnd()");
            b0(i2, str, str2);
            setIsPreparePaying(false);
        }
    }

    public final void N(List<String> list, pd1 pd1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, list, pd1Var) != null) || pd1Var == null) {
            return;
        }
        String string = this.f.getString("bduss");
        String string2 = this.f.getString("appKey");
        qd1.b(string, string2, this.K + "", list, new b(this, pd1Var));
    }

    public void U(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            gd1.g("ChannelListView->errorEnd()");
            Y();
            if (!TextUtils.isEmpty(str2)) {
                p0(str2);
            } else {
                p0(getResources().getString(R.string.obfuscated_res_0x7f0f1143));
            }
            b0(3, str, "0");
            setIsPreparePaying(false);
        }
    }

    public final void P(PayChannelEntity payChannelEntity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, payChannelEntity) != null) || payChannelEntity == null) {
            return;
        }
        tc1.f(System.currentTimeMillis());
        JSONArray jSONArray = new JSONArray();
        try {
            if (this.n != null && this.n.getIsSelected() == 1 && !TextUtils.isEmpty(this.n.getHostMarketingDetail())) {
                jSONArray.put(new JSONObject(this.n.getHostMarketingDetail()));
            }
            if (this.D.getSelectedItem() != null && !TextUtils.isEmpty(this.D.getSelectedItem().i)) {
                jSONArray.put(new JSONObject(this.D.getSelectedItem().i));
            }
        } catch (Exception unused) {
        }
        if (jSONArray.length() > 0) {
            this.f.putString("hostMarketingDetail", jSONArray.toString());
        }
        if (!TextUtils.isEmpty(this.c0)) {
            this.f.putString("isFoldChannel", this.c0);
        }
        if (this.L != null) {
            this.O = payChannelEntity.getPayChannel();
            this.L.l(this.f, payChannelEntity, this, this.c0);
        }
    }

    public final void p0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                str = getResources().getString(R.string.obfuscated_res_0x7f0f1143);
            }
            if (this.N == null) {
                View inflate = View.inflate(this.e.getContext(), R.layout.obfuscated_res_0x7f0d0250, null);
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091d65)).setText(EventAlias.PayEventAlias.PAY_FAIL);
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091d64)).setText(str.trim());
                PopupWindow popupWindow = new PopupWindow(inflate, -1, -1, true);
                this.N = popupWindow;
                popupWindow.v(false);
                this.N.A(false);
                this.N.u(new ColorDrawable(0));
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091d5c)).setOnClickListener(new i(this));
                this.N.z(new j(this));
            }
            PolyActivity polyActivity = (PolyActivity) getContext();
            if (!polyActivity.isFinishing()) {
                this.N.C(polyActivity.getWindow().getDecorView(), 0, 0, 0);
            }
        }
    }

    public final void Q() {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || PolyActivity.g == null) {
            return;
        }
        Bundle bundle = this.f;
        String str3 = null;
        if (bundle != null) {
            str = bundle.getString("bduss");
            str2 = this.f.getString("appKey");
        } else {
            str = null;
            str2 = null;
        }
        PayChannelEntity payChannelEntity = this.p;
        if (payChannelEntity != null) {
            str3 = payChannelEntity.getPayChannel();
        }
        if (this.M != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            try {
                Intent intent = new Intent(PolyActivity.g, GuideAgreeNoPwdPayActivity.class);
                intent.putExtra("key_bduss", str);
                intent.putExtra("key_app_key", str2);
                intent.putExtra("key_pay_channel", str3);
                intent.putExtra("key_auth_channel", this.M);
                intent.putExtra("key_invoker_task_id", oc1.a().b());
                PolyActivity.g.startActivity(intent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void R() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            PopupWindow popupWindow = this.N;
            if ((popupWindow == null || !popupWindow.r()) && !this.r && !this.q) {
                z = true;
            } else {
                z = false;
            }
            if ((!TextUtils.isEmpty(this.O) && (TextUtils.equals(this.O, "BAIDU-ALIPAY-WISE") || TextUtils.equals(this.O, "BAIDU-ALIPAY-WISE-HUABEI-PAY"))) || this.R) {
                gd1.g("ChannelListView->confirmViewClose() ali pay channel");
                z &= this.Q;
            }
            gd1.g("ChannelListView->confirmViewClose() canFinishActivity = " + z);
            if (z && this.t != null) {
                gd1.g("ChannelListView->confirmViewClose() finish activity");
                this.t.onClose();
                this.t = null;
            }
        }
    }

    public boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            DigitalWalletVerifyView digitalWalletVerifyView = this.l;
            if (digitalWalletVerifyView != null && digitalWalletVerifyView.getVisibility() == 0) {
                this.l.z();
                return true;
            }
            DigitalBankPayView digitalBankPayView = this.k;
            if (digitalBankPayView != null && digitalBankPayView.getVisibility() == 0) {
                this.m.setText("支付");
                this.k.a();
                this.j.setVisibility(8);
                this.i.setVisibility(0);
                return true;
            }
            CouponListView couponListView = this.G;
            if (couponListView != null) {
                couponListView.r();
                return true;
            }
            PeriodView periodView = this.H;
            if (periodView != null) {
                periodView.f();
                return true;
            } else if (this.r) {
                return true;
            } else {
                if (!this.q) {
                    return false;
                }
                b0(2, dd1.a(2, null, "key_back_cancel"), "0");
                S();
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public final void h0() {
        Long l2;
        Long l3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (l2 = this.K) != null && (l3 = this.J) != null) {
            if (l2.equals(l3)) {
                this.z.setText(V(this.J.longValue()));
                this.A.setVisibility(8);
            } else {
                if (this.a0) {
                    this.A.setVisibility(0);
                }
                this.z.setText(V(this.J.longValue()));
                TextView textView = this.A;
                textView.setText(" ¥" + V(this.K.longValue()));
            }
            if (this.E.getVisibility() != 0) {
                this.E.setVisibility(0);
            }
        }
    }

    public final void j0() {
        PayChannelEntity[] payChannelEntityArr;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.F.setMinimumHeight(0);
            if (this.o != null) {
                this.e.removeAllViews();
                g0();
                for (PayChannelEntity payChannelEntity : this.o) {
                    if (this.b0 || !payChannelEntity.isFold()) {
                        Long l2 = this.J;
                        if (l2 != null) {
                            str = V(l2.longValue());
                        } else {
                            str = "";
                        }
                        ChannelItemView channelItemView = new ChannelItemView(getContext());
                        channelItemView.setChannelInfo(payChannelEntity, new k(this, payChannelEntity), new l(this), str);
                        if ("BAIDU-ALIPAY-WISE-HUABEI-INSTALLMENT".equals(payChannelEntity.getPayChannel())) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("hbit", "1");
                            } catch (JSONException unused) {
                            }
                            uc1 uc1Var = new uc1("9");
                            uc1Var.c(jSONObject);
                            xc1.e(uc1Var);
                        }
                        this.e.addView(channelItemView);
                    }
                }
            }
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.q) {
            this.q = false;
            this.a.animate().alpha(0.0f).setDuration(240L).start();
            postDelayed(new g(this), 240L);
            postDelayed(new h(this), 480L);
        }
    }

    public final void g0() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.b0) {
                this.C.setVisibility(8);
                return;
            }
            PayChannelEntity[] payChannelEntityArr = this.o;
            int length = payChannelEntityArr.length;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    PayChannelEntity payChannelEntity = payChannelEntityArr[i2];
                    if (payChannelEntity != null && payChannelEntity.isFold()) {
                        z = true;
                        break;
                    }
                    i2++;
                } else {
                    z = false;
                    break;
                }
            }
            if (z) {
                this.C.setVisibility(0);
            } else {
                this.C.setVisibility(8);
            }
        }
    }

    public final void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.y.h(this.n);
            this.y.setListener(new f(this));
        }
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            de1.b(this.I);
            this.I = null;
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.r = false;
            this.g.c();
        }
    }

    public PayChannelEntity getSelectedPayChannelEntity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.p;
        }
        return (PayChannelEntity) invokeV.objValue;
    }

    public od1 getWalletList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.L;
        }
        return (od1) invokeV.objValue;
    }

    public final void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (this.s <= 0) {
                this.g.setVisibility(4);
                return;
            }
            this.g.setVisibility(0);
            this.g.setEnable(true);
        }
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            gd1.g("requestChannelList start");
            tc1.a("1.01", System.currentTimeMillis());
            wb1.j().e(this.f, new c(this));
        }
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.g.c();
            this.r = false;
            this.Q = true;
        }
    }

    public final void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.I = de1.c(this.c, layoutParams, "加载中", -1L);
        }
    }

    public final void u0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048620, this) == null) && this.f1054T && this.U) {
            tc1.e();
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.u = AnimationUtils.loadAnimation(getContext(), R.anim.obfuscated_res_0x7f01015c);
            this.v = AnimationUtils.loadAnimation(getContext(), R.anim.obfuscated_res_0x7f010162);
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0a05, this);
            this.a = findViewById(R.id.bg_view);
            this.b = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0906e1);
            this.c = (PolyFrameLayout) findViewById(R.id.obfuscated_res_0x7f091d67);
            this.E = findViewById(R.id.obfuscated_res_0x7f091af5);
            this.F = findViewById(R.id.obfuscated_res_0x7f0906d8);
            this.d = (TipView) findViewById(R.id.obfuscated_res_0x7f0925fa);
            this.e = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0906d9);
            this.m = (TextView) findViewById(R.id.obfuscated_res_0x7f091af6);
            DigitalBankPayView digitalBankPayView = (DigitalBankPayView) findViewById(R.id.obfuscated_res_0x7f091d46);
            this.k = digitalBankPayView;
            digitalBankPayView.setOptionListener(this);
            this.l = (DigitalWalletVerifyView) findViewById(R.id.obfuscated_res_0x7f091d47);
            this.g = (ProgressButton) findViewById(R.id.obfuscated_res_0x7f091af3);
            View findViewById = findViewById(R.id.close_button);
            this.i = findViewById;
            findViewById.setOnClickListener(this);
            View findViewById2 = findViewById(R.id.obfuscated_res_0x7f091d44);
            this.j = findViewById2;
            findViewById2.setOnClickListener(this);
            this.g.setOnClickListener(this);
            this.w = (DuVipGuideView) findViewById(R.id.obfuscated_res_0x7f0929fa);
            this.x = findViewById(R.id.obfuscated_res_0x7f0929c3);
            this.y = (HostMarketView) findViewById(R.id.obfuscated_res_0x7f090fe2);
            CouponEntranceView couponEntranceView = (CouponEntranceView) findViewById(R.id.obfuscated_res_0x7f09081d);
            this.D = couponEntranceView;
            couponEntranceView.setOnClickListener(this);
            this.z = (TextView) findViewById(R.id.obfuscated_res_0x7f0917e0);
            this.A = (TextView) findViewById(R.id.obfuscated_res_0x7f090877);
            this.B = findViewById(R.id.obfuscated_res_0x7f0929e4);
            View findViewById3 = findViewById(R.id.obfuscated_res_0x7f0927c8);
            this.C = findViewById3;
            findViewById3.setOnClickListener(this);
        }
    }

    public void b0(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048591, this, i2, str, str2) == null) {
            gd1.g("ChannelListView->onResult() statusCode = " + i2 + " result = " + str);
            this.Q = true;
            mb1.c cVar = this.h;
            if (cVar != null) {
                cVar.a(i2, str);
                this.h = null;
            }
            xc1.j(i2, str, str2);
            if (((PolyActivity) getContext()).isFinishing()) {
                xc1.f();
            }
            R();
        }
    }

    public final void c0() {
        zd1 zd1Var;
        List<zd1.a> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (zd1Var = this.P) != null && (list = zd1Var.b) != null && list.size() > 0) {
            CouponListView couponListView = new CouponListView(getContext());
            this.G = couponListView;
            couponListView.n(this.b.getMeasuredHeight());
            this.G.setListener(new a(this));
            this.G.u(this.P.b);
            this.G.p(this.b);
        }
    }

    public ChannelListView n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (!this.q) {
                this.q = true;
                if (getContext() instanceof Activity) {
                    this.d.c("收银台加载中...");
                    gd1.g("ChannelListView->attach()");
                    o0();
                } else {
                    throw new IllegalStateException("can not attach to context " + getContext());
                }
            }
            return this;
        }
        return (ChannelListView) invokeV.objValue;
    }

    public final void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.a.setVisibility(0);
            this.b.setVisibility(0);
            this.c.setVisibility(0);
            this.a.setAlpha(0.0f);
            this.a.animate().alpha(0.65f).setDuration(240L).start();
            this.b.startAnimation(this.u);
            this.u.setAnimationListener(new e(this));
            i0();
        }
    }

    public final void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("default", this.V);
                jSONObject.put("selected", this.W);
                this.W = "";
                jSONObject.put("selects", sc1.a);
                sc1.a = 0;
                jSONObject.put("hbit", sc1.b);
                sc1.b = "0";
            } catch (JSONException unused) {
            }
            uc1 uc1Var = new uc1("5");
            uc1Var.c(jSONObject);
            xc1.e(uc1Var);
        }
    }

    public void e0(int i2, String str, String str2, String str3, Map<String, String> map, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i2), str, str2, str3, map, str4}) == null) {
            d0(i2, str, str2);
            if (i2 == 0 && this.f != null) {
                boolean z = false;
                PayChannelEntity payChannelEntity = this.p;
                if (payChannelEntity != null) {
                    z = payChannelEntity.isNeedAgreementGuide();
                }
                if (z) {
                    Q();
                }
            }
        }
    }

    public void l0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, bundle) == null) {
            if (bundle != null) {
                try {
                    String string = bundle.getString("totalAmount");
                    if (TextUtils.isEmpty(string)) {
                        this.K = -1L;
                    } else {
                        this.K = Long.valueOf(Long.parseLong(string));
                    }
                } catch (Exception unused) {
                    gd1.g("totalAmount is not long");
                }
            }
            this.f = bundle;
            k0();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, view2) == null) {
            if (view2.getId() == R.id.close_button) {
                b0(2, "主动取消支付", "0");
                S();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("default", this.V);
                    jSONObject.put("selected", this.W);
                    this.W = "";
                    jSONObject.put("selects", sc1.a);
                    sc1.a = 0;
                    jSONObject.put("hbit", sc1.b);
                    sc1.b = "0";
                } catch (JSONException unused) {
                }
                uc1 uc1Var = new uc1("6");
                uc1Var.c(jSONObject);
                xc1.e(uc1Var);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091af3) {
                if (this.s == 0) {
                    return;
                }
                PayChannelEntity[] payChannelEntityArr = this.o;
                int length = payChannelEntityArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    PayChannelEntity payChannelEntity = payChannelEntityArr[i2];
                    if (payChannelEntity.getIsSelected() == 1) {
                        this.p = payChannelEntity;
                        break;
                    }
                    i2++;
                }
                PayChannelEntity payChannelEntity2 = this.p;
                if (payChannelEntity2 == null) {
                    return;
                }
                if (TextUtils.equals("BAIDU-DRMB-WISE", payChannelEntity2.getPayChannel())) {
                    List<PayChannelEntity> list = this.p.childrenPayChannels;
                    if (list != null && list.size() != 0) {
                        this.m.setText("数字人民币支付");
                        this.k.c();
                        this.k.d(this.p.childrenPayChannels);
                        this.i.setVisibility(8);
                        this.j.setVisibility(0);
                        return;
                    }
                    return;
                }
                this.g.b();
                this.r = true;
                this.Q = false;
                PayChannelEntity payChannelEntity3 = this.p;
                if (payChannelEntity3 != null) {
                    P(payChannelEntity3);
                    this.W = this.p.getPayChannel();
                    t0();
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09081d) {
                c0();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0927c8) {
                this.b0 = true;
                j0();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091d44) {
                this.k.a();
                this.m.setText("支付");
                this.j.setVisibility(8);
                this.i.setVisibility(0);
            }
        }
    }

    public void s0(Bundle bundle, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048612, this, bundle, str) == null) {
            this.O = str;
            if (this.L != null) {
                this.r = true;
                this.Q = false;
                tc1.f(System.currentTimeMillis());
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                this.I = de1.c(this, layoutParams, getResources().getString(R.string.obfuscated_res_0x7f0f1144), -1L);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(DI.PAY_CHANNEL, str);
                    this.L.l(bundle, new PayChannelEntity(jSONObject), this, this.c0);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
