package com.baidu.tbadk.core.view;

import android.animation.Animator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.o0.r.l0.h;
import c.a.o0.r.r.f;
import c.a.p0.a4.k0.e;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.widget.lottie.TBLazyLottieAnimationView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class AgreeView extends LinearLayout implements Animator.AnimatorListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout A;
    public boolean B;
    public boolean C;
    public d D;
    public c.a.o0.r.g0.a E;
    public boolean F;
    public CustomMessageListener G;
    public CustomMessageListener H;
    public View.OnClickListener I;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f29944b;

    /* renamed from: c  reason: collision with root package name */
    public TBLottieAnimationView f29945c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f29946d;

    /* renamed from: e  reason: collision with root package name */
    public TBLottieAnimationView f29947e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f29948f;

    /* renamed from: g  reason: collision with root package name */
    public AgreeData f29949g;

    /* renamed from: h  reason: collision with root package name */
    public e f29950h;
    public ScaleAnimation i;
    public boolean j;
    public boolean k;
    public f l;
    public int m;
    public String n;
    public int o;
    public int p;
    public int q;
    public String r;
    public String s;
    public boolean t;
    public ThreadData u;
    public int v;
    public View.OnClickListener w;
    public View.OnClickListener x;
    public int y;
    public LinearLayout z;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AgreeView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AgreeView agreeView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {agreeView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = agreeView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e eVar;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof e) || (eVar = (e) customResponsedMessage.getData()) == null || (agreeData = eVar.f12234b) == null || this.a.f29949g == null || agreeData == null || this.a.f29950h == null || this.a.f29949g.isInPost || this.a.f29950h.a == eVar.a) {
                return;
            }
            String str = agreeData.nid;
            if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                if (this.a.f29949g.baijiahaoData == null || !TextUtils.equals(str, this.a.f29949g.baijiahaoData.oriUgcNid)) {
                    return;
                }
                this.a.A(agreeData);
                return;
            }
            String str2 = agreeData.threadId;
            String str3 = this.a.f29949g.threadId;
            if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                return;
            }
            this.a.A(agreeData);
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AgreeView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AgreeView agreeView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {agreeView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = agreeView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e eVar;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof e) || (eVar = (e) customResponsedMessage.getData()) == null || (agreeData = eVar.f12234b) == null || this.a.f29949g == null || TextUtils.isEmpty(this.a.f29949g.postId) || agreeData == null || TextUtils.isEmpty(agreeData.postId) || !this.a.f29949g.postId.equals(agreeData.postId) || this.a.f29949g.isInThread) {
                return;
            }
            if (this.a.j) {
                if (this.a.f29949g.indexOfPic == agreeData.indexOfPic) {
                    return;
                }
            } else if (this.a.f29950h.a == eVar.a) {
                return;
            }
            this.a.A(agreeData);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AgreeView a;

        public c(AgreeView agreeView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {agreeView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = agreeView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.a.u == null || this.a.u.getType() != ThreadData.TYPE_FAKE_VIDEO) {
                    this.a.w(view);
                    View.OnClickListener onClickListener = this.a.x;
                    if (onClickListener != null) {
                        onClickListener.onClick(view);
                    }
                    if (this.a.y == 1 || this.a.y == 2) {
                        TbSingleton.getInstance().saveHomeRecommendItemClickTime();
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface d {
        void a(View view, boolean z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgreeView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.o = R.raw.lottie_agree;
        this.p = R.raw.lottie_disagree;
        this.q = R.color.CAM_X0107;
        this.t = false;
        this.v = 1;
        this.B = false;
        this.C = false;
        this.G = new a(this, 2016528);
        this.H = new b(this, 2016530);
        this.I = new c(this);
        o(context);
    }

    public static boolean s(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i)) == null) ? i == 4 || i == 5 || i == 12 : invokeI.booleanValue;
    }

    private void setTextNormalColor(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, textView) == null) {
            if (this.k) {
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            } else if (this.j) {
                textView.setTextColor(getResources().getColor(R.color.CAM_X0101));
            } else {
                textView.setTextColor(SkinManager.getColor(this.q));
            }
        }
    }

    public static int x(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65548, null, i)) == null) {
            if (i == 2) {
                return 1;
            }
            return i == 3 ? 2 : -1;
        }
        return invokeI.intValue;
    }

    public final void A(AgreeData agreeData) {
        AgreeData agreeData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, agreeData) == null) || agreeData == null || (agreeData2 = this.f29949g) == null) {
            return;
        }
        agreeData2.agreeType = agreeData.agreeType;
        agreeData2.hasAgree = agreeData.hasAgree;
        agreeData2.agreeNum = agreeData.agreeNum;
        B();
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            String n = n(this.f29949g);
            if (this.f29949g == null) {
                return;
            }
            this.f29946d.setText(n);
            this.f29945c.cancelAnimation();
            AgreeData agreeData = this.f29949g;
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    this.f29947e.setProgress(0.0f);
                    this.f29945c.setProgress(1.0f);
                    this.f29946d.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                    setTextNormalColor(this.f29948f);
                } else {
                    this.f29945c.setProgress(0.0f);
                    this.f29947e.setProgress(1.0f);
                    setTextNormalColor(this.f29946d);
                    this.f29948f.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
                }
            } else {
                this.f29945c.setProgress(0.0f);
                this.f29947e.setProgress(0.0f);
                setTextNormalColor(this.f29946d);
                setTextNormalColor(this.f29948f);
                if (this.F) {
                    h.c(this.f29946d);
                }
            }
            if (this.F) {
                h.d(this.f29946d);
            }
        }
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || this.f29949g == null) {
            return;
        }
        this.f29945c.setMinAndMaxProgress(0.0f, 1.0f);
        this.f29947e.setMinAndMaxProgress(0.0f, 1.0f);
        this.f29946d.setText(n(this.f29949g));
        this.f29945c.clearColorFilter();
        this.f29947e.clearColorFilter();
        if (z) {
            this.f29945c.playAnimation();
            this.f29947e.cancelAnimation();
            this.f29947e.setFrame(0);
        } else {
            this.f29947e.playAnimation();
            this.f29945c.cancelAnimation();
            this.f29945c.setFrame(0);
        }
        AgreeData agreeData = this.f29949g;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 2) {
                this.f29946d.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                setTextNormalColor(this.f29948f);
            } else {
                setTextNormalColor(this.f29946d);
                this.f29948f.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
                if (this.F) {
                    h.c(this.f29946d);
                }
            }
        } else {
            setTextNormalColor(this.f29946d);
            setTextNormalColor(this.f29948f);
            if (this.F) {
                h.c(this.f29946d);
            }
        }
        if (this.F) {
            h.d(this.f29946d);
        }
    }

    public TextView getAgreeNumView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f29946d : (TextView) invokeV.objValue;
    }

    public AgreeData getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f29949g : (AgreeData) invokeV.objValue;
    }

    public TextView getDisagreeNumView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f29948f : (TextView) invokeV.objValue;
    }

    public TBLottieAnimationView getImgAgree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f29945c : (TBLottieAnimationView) invokeV.objValue;
    }

    public TBLottieAnimationView getImgDisagree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f29947e : (TBLottieAnimationView) invokeV.objValue;
    }

    public BdUniqueId getPageId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            TbPageContext tbPageContext = getTbPageContext();
            if (tbPageContext != null) {
                return tbPageContext.getUniqueId();
            }
            return null;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public Animation getScaleAnimation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.i == null) {
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
                this.i = scaleAnimation;
                scaleAnimation.setDuration(200L);
            }
            return this.i;
        }
        return (Animation) invokeV.objValue;
    }

    public TbPageContext getTbPageContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.f29944b == null) {
                Context context = getContext();
                if (context instanceof BaseActivity) {
                    this.f29944b = ((BaseActivity) context).getPageContext();
                } else if (context instanceof BaseFragmentActivity) {
                    this.f29944b = ((BaseFragmentActivity) context).getPageContext();
                }
            }
            return this.f29944b;
        }
        return (TbPageContext) invokeV.objValue;
    }

    public TBLottieAnimationView getmImgAgree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f29945c : (TBLottieAnimationView) invokeV.objValue;
    }

    public TBLottieAnimationView getmImgDisagree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f29947e : (TBLottieAnimationView) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            int f2 = n.f(getContext(), R.dimen.tbds120);
            removeAllViews();
            y(this.f29945c);
            y(this.f29947e);
            y(this.f29946d);
            y(this.f29948f);
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setId(R.id.obfuscated_res_0x7f0903b5);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.topMargin = n.f(getContext(), R.dimen.tbds2);
            layoutParams.weight = 0.5f;
            linearLayout.setLayoutParams(layoutParams);
            addView(linearLayout);
            linearLayout.setOnClickListener(this.I);
            linearLayout.addView(this.f29945c, new LinearLayout.LayoutParams(f2, f2));
            this.f29946d.setTextSize(0, n.f(getContext(), R.dimen.T_X09));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.topMargin = -n.f(getContext(), R.dimen.tbds16);
            linearLayout.addView(this.f29946d, layoutParams2);
            LinearLayout linearLayout2 = new LinearLayout(getContext());
            linearLayout2.setId(R.id.obfuscated_res_0x7f0903c0);
            linearLayout2.setOrientation(1);
            linearLayout2.setGravity(1);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2);
            layoutParams3.topMargin = n.f(getContext(), R.dimen.tbds3);
            layoutParams3.weight = 0.5f;
            linearLayout2.setLayoutParams(layoutParams3);
            addView(linearLayout2);
            linearLayout2.setOnClickListener(this.I);
            this.z = linearLayout2;
            linearLayout2.addView(this.f29947e, new LinearLayout.LayoutParams(f2, f2));
            this.f29948f.setTextSize(0, n.f(getContext(), R.dimen.T_X09));
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams4.topMargin = -n.f(getContext(), R.dimen.tbds18);
            linearLayout2.addView(this.f29948f, layoutParams4);
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            int f2 = n.f(getContext(), R.dimen.tbds104);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(f2, f2);
            layoutParams.gravity = 16;
            this.f29945c.setLayoutParams(layoutParams);
            this.f29946d.setTextSize(0, n.f(getContext(), R.dimen.tbfontsize34));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            if (z) {
                layoutParams2.leftMargin = -n.f(getContext(), R.dimen.tbds24);
                int f3 = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds20);
                this.f29946d.setPadding(0, f3, f3 * 3, f3);
                this.C = true;
            } else {
                layoutParams2.leftMargin = -n.f(getContext(), R.dimen.tbds22);
            }
            layoutParams2.gravity = 16;
            this.f29946d.setLayoutParams(layoutParams2);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(f2, f2);
            layoutParams3.gravity = 16;
            if (!z) {
                layoutParams3.leftMargin = n.f(getContext(), R.dimen.tbds28);
            }
            this.f29947e.setLayoutParams(layoutParams3);
            this.f29948f.setVisibility(8);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            int f2 = n.f(getContext(), R.dimen.tbds112);
            int f3 = n.f(getContext(), R.dimen.tbds19);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(f2, f2);
            layoutParams.gravity = 16;
            layoutParams.rightMargin = -f3;
            layoutParams.topMargin = n.f(getContext(), R.dimen.tbds_2);
            this.f29945c.setLayoutParams(layoutParams);
            this.f29946d.setTextSize(0, n.f(getContext(), R.dimen.tbfontsize34));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 16;
            layoutParams2.rightMargin = n.f(getContext(), R.dimen.tbds6);
            layoutParams2.topMargin = n.f(getContext(), R.dimen.tbds_2);
            this.f29946d.setLayoutParams(layoutParams2);
            this.f29947e.setVisibility(8);
            this.f29948f.setVisibility(8);
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            if (z) {
                q(n.f(getContext(), R.dimen.tbds126), 0, 1, 17);
                setAgreeAlone(this.B);
                return;
            }
            q(n.f(getContext(), R.dimen.tbds126), -2, 0, 16);
            setAgreeAlone(this.B);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x0411  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0422  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0239  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void l() {
        AgreeData agreeData;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        AgreeData agreeData2;
        String str6;
        c.a.o0.n0.c findPageExtraByView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || this.l == null || (agreeData = this.f29949g) == null) {
            return;
        }
        BaijiahaoData baijiahaoData = agreeData.baijiahaoData;
        int i = baijiahaoData != null ? baijiahaoData.oriUgcType : 0;
        int i2 = this.l.a;
        if (i2 != 1) {
            if (i2 == 2) {
                StatisticItem param = new StatisticItem("c13271").param("obj_type", this.l.f10857g).param("obj_locate", this.l.f10858h).param(TiebaStatic.Params.OBJ_PARAM2, this.m).param("obj_id", this.l.i).param("obj_name", i).param("post_id", this.f29949g.postId).param("nid", this.f29949g.nid);
                ThreadData threadData = this.u;
                if (threadData != null) {
                    param.param("tid", threadData.getId()).param("nid", this.u.getNid()).param("fid", this.u.getFid()).param("card_type", this.v).param("ab_tag", this.u.mRecomAbTag).param("recom_source", this.u.mRecomSource).param("weight", this.u.mRecomWeight).param("extra", this.u.mRecomExtra);
                    if (this.u.getBaijiahaoData() != null) {
                        param.param(TiebaStatic.Params.OBJ_PARAM4, this.u.getBaijiahaoData().oriUgcNid);
                        if (this.u.isBJHVideoThreadType() || this.u.isBJHVideoDynamicThreadType()) {
                            param.param(TiebaStatic.Params.OBJ_PARAM6, this.u.getBaijiahaoData().oriUgcVid);
                        }
                    }
                    if (this.u.isBjhDynamicThread()) {
                        param.param(TiebaStatic.Params.OBJ_PARAM5, 2);
                    } else if (!this.u.isBJHArticleThreadType() && !this.u.isBJHVideoThreadType()) {
                        int i3 = this.u.threadType;
                        if (i3 == 0 || i3 == 40) {
                            param.param(TiebaStatic.Params.OBJ_PARAM5, 1);
                        }
                    } else {
                        param.param(TiebaStatic.Params.OBJ_PARAM5, 3);
                    }
                } else {
                    param.param("tid", this.f29949g.threadId);
                    param.param("nid", this.f29949g.nid);
                    param.param("fid", this.f29949g.forumId);
                    param.param("card_type", this.f29949g.cardType);
                    param.param("ab_tag", this.f29949g.recomAbTag);
                    param.param("recom_source", this.f29949g.recomSource);
                    param.param("weight", this.f29949g.recomWeight);
                    param.param("extra", this.f29949g.recomExtra);
                    BaijiahaoData baijiahaoData2 = this.f29949g.baijiahaoData;
                    if (baijiahaoData2 != null) {
                        param.param(TiebaStatic.Params.OBJ_PARAM6, baijiahaoData2.oriUgcVid);
                    }
                }
                int i4 = this.y;
                if (i4 == 1) {
                    str = TiebaStatic.Params.OBJ_TAB;
                    str2 = "a002";
                } else if (i4 != 2) {
                    if (i4 == 18) {
                        str = TiebaStatic.Params.OBJ_TAB;
                        param.param(str, "a099");
                        param.param(TiebaStatic.Params.RESOURCE_ID, this.n);
                    } else {
                        str = TiebaStatic.Params.OBJ_TAB;
                    }
                    str2 = "a002";
                    if (getTbPageContext() != null) {
                        c.a.o0.o0.c.b(getTbPageContext().getPageActivity(), param);
                    }
                    if (this.f29949g.isFromImageViewer) {
                        param.param(str, "a008");
                        if (this.f29949g.mImageViewerFromPage == "index") {
                            param.param(GuildActivityConfig.FROM_PAGE, str2);
                        }
                    }
                    TiebaStatic.log(param);
                    return;
                } else {
                    str2 = "a002";
                    str = TiebaStatic.Params.OBJ_TAB;
                }
                param.param(str, str2);
                if (getTbPageContext() != null) {
                }
                if (this.f29949g.isFromImageViewer) {
                }
                TiebaStatic.log(param);
                return;
            }
            return;
        }
        if (StringUtils.isNull(this.r)) {
            StatisticItem param2 = new StatisticItem("c12003").param("obj_locate", this.l.f10852b).param("obj_param1", this.l.f10853c).param("obj_source", this.l.f10854d).param("obj_id", this.l.f10855e).param("obj_name", i).param("post_id", this.f29949g.postId);
            ThreadData threadData2 = this.u;
            if (threadData2 != null) {
                param2.param("tid", threadData2.getId()).param("nid", this.u.getNid()).param("fid", this.u.getFid()).param("card_type", this.v).param("ab_tag", this.u.mRecomAbTag).param("recom_source", this.u.mRecomSource).param("weight", this.u.mRecomWeight).param("thread_type", this.u.threadType).param("extra", this.u.mRecomExtra);
                if (this.u.getBaijiahaoData() != null) {
                    param2.param(TiebaStatic.Params.OBJ_PARAM4, this.u.getBaijiahaoData().oriUgcNid);
                    if (this.u.isBJHVideoThreadType() || this.u.isBJHVideoDynamicThreadType()) {
                        param2.param(TiebaStatic.Params.OBJ_PARAM6, this.u.getBaijiahaoData().oriUgcVid);
                    }
                }
                if (this.u.isBjhDynamicThread()) {
                    param2.param(TiebaStatic.Params.OBJ_PARAM5, 2);
                } else if (!this.u.isBJHArticleThreadType() && !this.u.isBJHVideoThreadType()) {
                    int i5 = this.u.threadType;
                    if (i5 == 0 || i5 == 40) {
                        param2.param(TiebaStatic.Params.OBJ_PARAM5, 1);
                    }
                } else {
                    param2.param(TiebaStatic.Params.OBJ_PARAM5, 3);
                }
            } else {
                param2.param("tid", this.f29949g.threadId);
                param2.param("nid", this.f29949g.nid);
                param2.param("fid", this.f29949g.forumId);
                param2.param("card_type", this.f29949g.cardType);
                param2.param("ab_tag", this.f29949g.recomAbTag);
                param2.param("recom_source", this.f29949g.recomSource);
                param2.param("weight", this.f29949g.recomWeight);
                param2.param("extra", this.f29949g.recomExtra);
                BaijiahaoData baijiahaoData3 = this.f29949g.baijiahaoData;
                if (baijiahaoData3 != null) {
                    param2.param(TiebaStatic.Params.OBJ_PARAM6, baijiahaoData3.oriUgcVid);
                }
            }
            if (s(this.l.f10852b) && x(this.l.f10856f) != -1) {
                param2.param(TiebaStatic.Params.OBJ_TO, x(this.l.f10856f));
            }
            int i6 = this.y;
            if (i6 == 1) {
                str3 = TiebaStatic.Params.RESOURCE_ID;
                str4 = TiebaStatic.Params.OBJ_TAB;
                str5 = "a002";
            } else if (i6 == 2) {
                str3 = TiebaStatic.Params.RESOURCE_ID;
                str5 = "a002";
                str4 = TiebaStatic.Params.OBJ_TAB;
            } else {
                if (i6 == 18) {
                    param2.param(TiebaStatic.Params.OBJ_TAB, "a099");
                    param2.param(TiebaStatic.Params.RESOURCE_ID, this.n);
                } else {
                    param2.param(TiebaStatic.Params.RESOURCE_ID, this.m);
                }
                str5 = "a002";
                if (getTbPageContext() != null) {
                    c.a.o0.o0.c.b(getTbPageContext().getPageActivity(), param2);
                }
                agreeData2 = this.f29949g;
                if (agreeData2.isFromImageViewer) {
                    str6 = "index";
                } else {
                    str6 = "index";
                    if (agreeData2.mImageViewerFromPage == str6) {
                        param2.param(GuildActivityConfig.FROM_PAGE, str5);
                    }
                }
                if (str6.equals(this.f29949g.keyFromHomePage)) {
                    param2.param(TiebaStatic.Params.OBJ_PRE_PAGE, str5);
                    param2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a023");
                }
                findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
                if (findPageExtraByView != null) {
                    param2.param(TiebaStatic.Params.OBJ_CUR_PAGE, findPageExtraByView.a());
                }
                if (TbPageExtraHelper.getPrePageKey() != null) {
                    param2.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
                }
                TiebaStatic.log(param2);
            }
            param2.param(str4, str5);
            param2.param(str3, this.m);
            if (getTbPageContext() != null) {
            }
            agreeData2 = this.f29949g;
            if (agreeData2.isFromImageViewer) {
            }
            if (str6.equals(this.f29949g.keyFromHomePage)) {
            }
            findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
            if (findPageExtraByView != null) {
            }
            if (TbPageExtraHelper.getPrePageKey() != null) {
            }
            TiebaStatic.log(param2);
        } else if (this.l.f10852b == 4 && this.t) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_TOPIC_DETAIL_TO_PB_AGREE_CLICK).param("tid", this.f29949g.threadId).param("uid", TbadkCoreApplication.getCurrentAccount()).param(TiebaStatic.Params.TOPIC_TYPE, this.s).param("topic_id", this.r));
        } else {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_TOPIC_DETAIL_CARD_AGREE_CLICK).param("tid", this.f29949g.threadId).param("topic_id", this.r));
        }
        z();
    }

    public final String m(AgreeData agreeData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, agreeData)) == null) {
            long j = agreeData != null ? agreeData.agreeNum : 0L;
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i == 0) {
                return getContext().getString(R.string.obfuscated_res_0x7f0f0358);
            }
            if (i > 0) {
                return StringHelper.numFormatOverWanNa(j);
            }
            return "-" + StringHelper.numFormatOverWanNa(-j);
        }
        return (String) invokeL.objValue;
    }

    public final String n(AgreeData agreeData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, agreeData)) == null) ? m(agreeData) : (String) invokeL.objValue;
    }

    public final void o(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, context) == null) {
            setOrientation(0);
            TBLazyLottieAnimationView tBLazyLottieAnimationView = new TBLazyLottieAnimationView(context);
            this.f29945c = tBLazyLottieAnimationView;
            tBLazyLottieAnimationView.setId(R.id.obfuscated_res_0x7f090e9b);
            this.f29945c.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.f29945c.addAnimatorListener(this);
            this.f29945c.setOnClickListener(this.I);
            TextView textView = new TextView(context);
            this.f29946d = textView;
            textView.setTextSize(0, n.f(context, R.dimen.tbfontsize34));
            this.f29946d.setOnClickListener(this.I);
            TBLazyLottieAnimationView tBLazyLottieAnimationView2 = new TBLazyLottieAnimationView(context);
            this.f29947e = tBLazyLottieAnimationView2;
            tBLazyLottieAnimationView2.setId(R.id.obfuscated_res_0x7f090eb1);
            this.f29947e.addAnimatorListener(this);
            this.f29947e.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.f29947e.setOnClickListener(this.I);
            TextView textView2 = new TextView(context);
            this.f29948f = textView2;
            textView2.setText(R.string.obfuscated_res_0x7f0f035a);
            this.f29948f.setTextSize(0, n.f(context, R.dimen.tbfontsize34));
            this.f29948f.setOnClickListener(this.I);
            e eVar = new e();
            this.f29950h = eVar;
            eVar.a = getPageId();
            this.E = new c.a.o0.r.g0.a();
            p();
            setAgreeAnimationResource();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, animator) == null) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, animator) == null) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, animator) == null) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, animator) == null) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.G);
            MessageManager.getInstance().registerListener(this.H);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.G);
            MessageManager.getInstance().unRegisterListener(this.H);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setId(R.id.obfuscated_res_0x7f0903b5);
            this.A = linearLayout;
            linearLayout.setOrientation(0);
            addView(linearLayout);
            linearLayout.setOnClickListener(this.I);
            linearLayout.addView(this.f29945c);
            linearLayout.addView(this.f29946d);
            LinearLayout linearLayout2 = new LinearLayout(getContext());
            linearLayout2.setId(R.id.obfuscated_res_0x7f0903c0);
            this.z = linearLayout2;
            linearLayout2.setOrientation(0);
            addView(linearLayout2);
            linearLayout2.setOnClickListener(this.I);
            linearLayout2.addView(this.f29947e);
            linearLayout2.addView(this.f29948f);
            k(false);
        }
    }

    public final void q(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048604, this, i, i2, i3, i4) == null) {
            int i5 = -n.f(getContext(), R.dimen.tbds24);
            int f2 = n.f(getContext(), R.dimen.tbds34);
            this.A.setGravity(i4);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, -1);
            float f3 = i3;
            layoutParams.weight = f3;
            this.A.setLayoutParams(layoutParams);
            this.f29945c.setLayoutParams(new LinearLayout.LayoutParams(i, i));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 16;
            layoutParams2.leftMargin = i5;
            this.f29946d.setLayoutParams(layoutParams2);
            this.z.setGravity(i4);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i2, -1);
            layoutParams3.weight = f3;
            this.z.setLayoutParams(layoutParams3);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i, i);
            layoutParams4.leftMargin = f2;
            this.f29947e.setLayoutParams(layoutParams4);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams5.gravity = 16;
            layoutParams5.leftMargin = i5;
            this.f29948f.setLayoutParams(layoutParams5);
        }
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.B : invokeV.booleanValue;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, onClickListener) == null) {
            this.w = onClickListener;
        }
    }

    public void setAgreeAlone(boolean z) {
        d dVar;
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.f29947e.setVisibility(z ? 8 : 0);
            this.f29948f.setVisibility(z ? 8 : 0);
            if (z && (linearLayout = this.z) != null) {
                linearLayout.setVisibility(8);
            }
            if (this.B != z && (dVar = this.D) != null) {
                dVar.a(this.f29947e, z);
            }
            this.B = z;
        }
    }

    public void setAgreeAnimationResource() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            SkinManager.setLottieAnimation(this.f29945c, this.o);
            SkinManager.setLottieAnimation(this.f29947e, this.p);
            if (this.F) {
                h.f(this.f29945c, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void setCardType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            this.v = i;
        }
    }

    public void setData(AgreeData agreeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, agreeData) == null) || agreeData == null) {
            return;
        }
        this.f29949g = agreeData;
        B();
    }

    public void setDisagreeShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.f29947e.setVisibility(z ? 8 : 0);
            this.f29948f.setVisibility(z ? 8 : 0);
            LinearLayout linearLayout = this.z;
            if (linearLayout != null) {
                linearLayout.setVisibility(z ? 8 : 0);
            }
            this.B = z;
        }
    }

    public void setFrom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i) == null) {
            this.y = i;
        }
    }

    public void setGameId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i) == null) {
            this.m = i;
        }
    }

    public void setIsFromBigpic(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.j = z;
        }
    }

    public void setIsFromMiddlePage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.k = z;
        }
    }

    public void setNormalColorResourceId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i) == null) {
            this.q = i;
            setTextNormalColor(this.f29946d);
            setTextNormalColor(this.f29948f);
        }
    }

    public void setResourceId(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048617, this, i, i2) == null) {
            this.o = i;
            this.p = i2;
            setAgreeAnimationResource();
        }
    }

    public void setStatisticData(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, fVar) == null) {
            this.l = fVar;
        }
    }

    public void setTabName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, str) == null) {
            this.n = str;
        }
    }

    public void setThreadData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, threadData) == null) {
            this.u = threadData;
        }
    }

    public void setTopicId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, str) == null) {
            this.r = str;
        }
    }

    public void setTopicSubjectName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            this.s = str;
        }
    }

    public void setVisibilityListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, dVar) == null) {
            this.D = dVar;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            this.F = z;
            if (z) {
                h.f(this.f29945c, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            w(this.f29945c);
        }
    }

    public void v(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048626, this, i) == null) || this.f29949g == null || this.a == i) {
            return;
        }
        this.a = i;
        SkinManager.setLottieAnimation(this.f29945c, this.o);
        SkinManager.setLottieAnimation(this.f29947e, this.p);
        if (this.F) {
            h.f(this.f29945c, i);
        }
        B();
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void w(View view) {
        c.a.o0.n0.c findPageExtraByView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048627, this, view) == null) || this.f29949g == null || view == null) {
            return;
        }
        if (!this.j || c.a.o0.j0.f.a(getContext())) {
            if (this.j || ViewHelper.checkUpIsLogin(getContext())) {
                if (view != this.f29946d || this.C) {
                    int i = 0;
                    int i2 = 1;
                    if (view.getId() != this.A.getId() && view.getId() != this.f29945c.getId() && (!this.C || view.getId() != this.f29946d.getId())) {
                        if (view.getId() == this.z.getId() || view.getId() == this.f29947e.getId()) {
                            this.f29947e.cancelAnimation();
                            f fVar = this.l;
                            if (fVar != null) {
                                fVar.a = 2;
                            }
                            AgreeData agreeData = this.f29949g;
                            if (agreeData.hasAgree) {
                                if (agreeData.agreeType == 5) {
                                    agreeData.agreeType = 5;
                                    agreeData.hasAgree = false;
                                    B();
                                    f fVar2 = this.l;
                                    if (fVar2 != null) {
                                        fVar2.i = 0;
                                    }
                                    this.t = false;
                                    findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
                                    if (findPageExtraByView != null) {
                                        this.f29949g.objSource = findPageExtraByView.a();
                                    }
                                    this.E.c(this.f29949g, i2, getPageId(), this.j);
                                } else {
                                    agreeData.agreeType = 5;
                                    agreeData.hasAgree = true;
                                    agreeData.agreeNum--;
                                    C(false);
                                    f fVar3 = this.l;
                                    if (fVar3 != null) {
                                        fVar3.i = 1;
                                    }
                                }
                            } else {
                                agreeData.agreeType = 5;
                                agreeData.hasAgree = true;
                                C(false);
                                f fVar4 = this.l;
                                if (fVar4 != null) {
                                    fVar4.i = 1;
                                }
                            }
                            i2 = 0;
                            this.t = false;
                            findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
                            if (findPageExtraByView != null) {
                            }
                            this.E.c(this.f29949g, i2, getPageId(), this.j);
                        }
                    } else {
                        this.f29945c.cancelAnimation();
                        f fVar5 = this.l;
                        if (fVar5 != null) {
                            fVar5.a = 1;
                        }
                        AgreeData agreeData2 = this.f29949g;
                        if (agreeData2.hasAgree) {
                            if (agreeData2.agreeType == 2) {
                                this.t = false;
                                agreeData2.agreeType = 2;
                                agreeData2.hasAgree = false;
                                agreeData2.agreeNum--;
                                B();
                                f fVar6 = this.l;
                                if (fVar6 != null) {
                                    fVar6.f10855e = 1;
                                }
                                i = 1;
                            } else {
                                this.t = true;
                                agreeData2.agreeType = 2;
                                agreeData2.hasAgree = true;
                                agreeData2.agreeNum++;
                                C(true);
                                c.a.p0.k3.a.g().l(getTbPageContext());
                                f fVar7 = this.l;
                                if (fVar7 != null) {
                                    fVar7.f10855e = 0;
                                }
                            }
                        } else {
                            this.t = true;
                            agreeData2.agreeType = 2;
                            agreeData2.hasAgree = true;
                            agreeData2.agreeNum++;
                            C(true);
                            c.a.p0.k3.a.g().l(getTbPageContext());
                            f fVar8 = this.l;
                            if (fVar8 != null) {
                                fVar8.f10855e = 0;
                            }
                        }
                        c.a.o0.n0.c findPageExtraByView2 = TbPageExtraHelper.findPageExtraByView(this);
                        if (findPageExtraByView2 != null) {
                            this.f29949g.objSource = findPageExtraByView2.a();
                        }
                        this.E.c(this.f29949g, i, getPageId(), this.j);
                    }
                    this.E.d(this.f29949g, this.f29950h);
                    View.OnClickListener onClickListener = this.w;
                    if (onClickListener != null) {
                        onClickListener.onClick(view);
                    }
                    l();
                }
            }
        }
    }

    public final void y(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048628, this, view) == null) && view != null && (view.getParent() instanceof ViewGroup)) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void z() {
        ThreadData threadData;
        f fVar;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048629, this) == null) || (threadData = this.u) == null || (fVar = this.l) == null || !threadData.isTiebaPlusAdThread) {
            return;
        }
        int i7 = fVar.f10852b;
        if (i7 == 1 || i7 == 2 || i7 == 10 || i7 == 25 || i7 == 4) {
            f fVar2 = this.l;
            if (fVar2.f10852b != 4 || (i6 = fVar2.f10856f) == 2 || i6 == 3) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HEATING_THREAD_AGREE);
                int i8 = this.l.f10852b;
                if (i8 == 1) {
                    statisticItem.addParam("obj_locate", 1);
                } else if (i8 == 2 || i8 == 25 || i8 == 10) {
                    int i9 = this.u.tiePlusFrsStaticLocate;
                    if (i9 != 2) {
                        statisticItem.addParam("obj_locate", i9 + 1);
                    } else {
                        statisticItem.addParam("obj_locate", 2);
                    }
                } else if (i8 == 4) {
                    statisticItem.addParam("obj_locate", 3);
                }
                if (this.u.isVideoWorksInfo()) {
                    statisticItem.addParam("obj_type", 3);
                } else if (this.u.isVideoThreadType()) {
                    statisticItem.addParam("obj_type", 2);
                } else {
                    statisticItem.addParam("obj_type", 1);
                }
                statisticItem.addParam("tid", this.u.getTid());
                statisticItem.addParam(TiebaStatic.Params.FID_1, this.u.getFid());
                statisticItem.addParam(TiebaStatic.Params.FID_2, this.l.j);
                int i10 = this.l.f10855e;
                if (i10 == 0) {
                    statisticItem.addParam(TiebaStatic.Params.LIKE_TYPE, 1);
                } else if (i10 == 1) {
                    statisticItem.addParam(TiebaStatic.Params.LIKE_TYPE, 2);
                }
                statisticItem.addParam("order_id", this.u.tiebaPlusOrderId);
                TiebaStatic.log(statisticItem);
                int i11 = this.l.f10855e;
                if (i11 == 0) {
                    i2 = c.a.o0.c.a.f9872g;
                } else if (i11 == 1) {
                    i2 = c.a.o0.c.a.j;
                } else {
                    i = 0;
                    i3 = this.l.f10852b;
                    if (i3 != 1) {
                        i5 = c.a.o0.c.a.a;
                    } else if (i3 == 2) {
                        i5 = c.a.o0.c.a.f9867b;
                    } else if (s(i3)) {
                        i5 = c.a.o0.c.a.f9868c;
                    } else {
                        i4 = 0;
                        ThreadData threadData2 = this.u;
                        c.a.o0.c.a.a(i, i4, threadData2.tiebaPlusOrderId, threadData2.tiebaPlusToken, threadData2.tiebaPlusExtraParam, threadData2.statFloor);
                    }
                    i4 = i5;
                    ThreadData threadData22 = this.u;
                    c.a.o0.c.a.a(i, i4, threadData22.tiebaPlusOrderId, threadData22.tiebaPlusToken, threadData22.tiebaPlusExtraParam, threadData22.statFloor);
                }
                i = i2;
                i3 = this.l.f10852b;
                if (i3 != 1) {
                }
                i4 = i5;
                ThreadData threadData222 = this.u;
                c.a.o0.c.a.a(i, i4, threadData222.tiebaPlusOrderId, threadData222.tiebaPlusToken, threadData222.tiebaPlusExtraParam, threadData222.statFloor);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgreeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.o = R.raw.lottie_agree;
        this.p = R.raw.lottie_disagree;
        this.q = R.color.CAM_X0107;
        this.t = false;
        this.v = 1;
        this.B = false;
        this.C = false;
        this.G = new a(this, 2016528);
        this.H = new b(this, 2016530);
        this.I = new c(this);
        o(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgreeView(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.a = 3;
        this.o = R.raw.lottie_agree;
        this.p = R.raw.lottie_disagree;
        this.q = R.color.CAM_X0107;
        this.t = false;
        this.v = 1;
        this.B = false;
        this.C = false;
        this.G = new a(this, 2016528);
        this.H = new b(this, 2016530);
        this.I = new c(this);
        o(context);
    }
}
