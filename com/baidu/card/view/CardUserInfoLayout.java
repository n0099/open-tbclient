package com.baidu.card.view;

import android.content.Context;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.HeadCustomImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.VirtualImageCustomFigure;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.view.VirtualImageStatusTip;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ab8;
import com.repackage.dx;
import com.repackage.h9;
import com.repackage.hx;
import com.repackage.ng;
import com.repackage.pi;
import com.repackage.py;
import com.repackage.sl4;
import com.repackage.vr4;
import com.repackage.z05;
import java.util.ArrayList;
import tbclient.AppPosInfo;
/* loaded from: classes.dex */
public class CardUserInfoLayout extends LinearLayout implements hx {
    public static /* synthetic */ Interceptable $ic;
    public static final int N;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadData A;
    public ImageView B;
    public FrameLayout C;
    public HeadCustomImageView D;
    public int E;
    public boolean F;
    public int G;
    public String H;
    public Runnable I;
    public View.OnClickListener J;
    public View.OnClickListener K;
    public View.OnClickListener L;
    public final View.OnClickListener M;
    public Context a;
    public int b;
    public HeadPendantClickableView c;
    public TBLottieAnimationView d;
    public TextView e;
    public TextView f;
    public UserIconBox g;
    public UserIconBox h;
    public TextView i;
    public LocationExtendLayout j;
    public ImageView k;
    public TextView l;
    public TextView m;
    public RelativeLayout n;
    public ImageView o;
    public LinearLayout p;
    public VirtualImageStatusTip q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public View.OnClickListener w;
    public View.OnClickListener x;
    public ViewGroup y;
    public View z;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardUserInfoLayout a;

        public a(CardUserInfoLayout cardUserInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardUserInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardUserInfoLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardUserInfoLayout a;

        public b(CardUserInfoLayout cardUserInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardUserInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardUserInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String url;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || !ViewHelper.checkUpIsLogin(this.a.a) || this.a.A == null || this.a.A.getAuthor() == null || this.a.A.getAuthor().getTShowInfoNew() == null || ListUtils.getItem(this.a.A.getAuthor().getTShowInfoNew(), 0) == null || (url = this.a.A.getAuthor().getTShowInfoNew().get(0).getUrl()) == null || !(h9.a(this.a.a) instanceof TbPageContext)) {
                return;
            }
            UrlManager.getInstance().dealOneLink((TbPageContext) h9.a(this.a.a), new String[]{url});
        }
    }

    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardUserInfoLayout a;

        public c(CardUserInfoLayout cardUserInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardUserInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardUserInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.A == null || this.a.A.getAuthor() == null || StringUtils.isNull(this.a.A.getAuthor().getName_show()) || StringUtils.isNull(this.a.A.getAuthor().getUserId()) || this.a.A.getForum_name() == null) {
                return;
            }
            if (view2.getTag(R.id.obfuscated_res_0x7f091f18) != null && (view2.getTag(R.id.obfuscated_res_0x7f091f18) instanceof String)) {
                String str = (String) view2.getTag(R.id.obfuscated_res_0x7f091f18);
                if (!TextUtils.isEmpty(str) && ViewHelper.checkUpIsLogin(this.a.getContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view2.getContext(), null, str, true)));
                    return;
                }
            }
            PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(this.a.a, this.a.A.getAuthor().getUserId(), this.a.A.getAuthor().getName_show(), this.a.A.getForum_name(), AddFriendActivityConfig.TYPE_FRS_HEAD);
            personInfoActivityConfig.setSourceTid(this.a.A.getTid());
            personInfoActivityConfig.setIsVideoThread(this.a.A.getThreadVideoInfo() != null);
            if (this.a.A.getResource() != 1) {
                if (this.a.A.getResource() != 2) {
                    if (this.a.A.getResource() == 5) {
                        personInfoActivityConfig.setVideoPersonFrom(PersonPolymericActivityConfig.VIDEO_PERSON_FROM_TOPIC_DETAIL);
                    }
                } else {
                    personInfoActivityConfig.setVideoPersonFrom("frs");
                }
            } else {
                personInfoActivityConfig.setVideoPersonFrom(PersonPolymericActivityConfig.VIDEO_PERSON_FROM_HOME);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
            if (this.a.w != null) {
                this.a.w.onClick(view2);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardUserInfoLayout a;

        public d(CardUserInfoLayout cardUserInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardUserInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardUserInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.A == null || this.a.A.getAuthor() == null) {
                return;
            }
            sl4.s(this.a.a.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f149c), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + this.a.A.getAuthor().getUserId() + "&opacity=0", true, true, true);
            if (this.a.x != null) {
                this.a.w.onClick(view2);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardUserInfoLayout a;

        public e(CardUserInfoLayout cardUserInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardUserInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardUserInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.A == null || this.a.A.getAuthor() == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.getContext(), this.a.A.getAuthor().getUserId(), this.a.A.getAuthor().getUserName())));
            this.a.frsVirtualImageStatistic(dx.a);
        }
    }

    /* loaded from: classes.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardUserInfoLayout a;

        public f(CardUserInfoLayout cardUserInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardUserInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardUserInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.w == null) {
                return;
            }
            this.a.w.onClick(view2);
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardUserInfoLayout a;

        public g(CardUserInfoLayout cardUserInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardUserInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardUserInfoLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d.playAnimation();
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardUserInfoLayout a;

        public h(CardUserInfoLayout cardUserInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardUserInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardUserInfoLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d.playAnimation();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1717332751, "Lcom/baidu/card/view/CardUserInfoLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1717332751, "Lcom/baidu/card/view/CardUserInfoLayout;");
                return;
            }
        }
        N = pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CardUserInfoLayout(Context context) {
        this(context, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void A(ThreadData threadData) {
        String cutChineseAndEnglishWithEmoji;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) || this.e == null || threadData == null) {
            return;
        }
        if (!threadData.isFromHomPage && !threadData.isFromConcern() && (!threadData.isFromFeedTab || !"fashion".equals(threadData.mHomePageTopTabTabCode))) {
            if (threadData.getAuthor() != null && !StringUtils.isNull(threadData.getAuthor().getName_show())) {
                if (threadData.isFromLocal) {
                    cutChineseAndEnglishWithEmoji = threadData.getAuthor().getName_show();
                } else {
                    cutChineseAndEnglishWithEmoji = StringHelper.cutChineseAndEnglishWithEmoji(threadData.getAuthor().getName_show(), 12, StringHelper.STRING_MORE);
                }
                this.e.setText(cutChineseAndEnglishWithEmoji);
            } else {
                this.e.setText(R.string.obfuscated_res_0x7f0f14a4);
            }
        } else {
            ViewGroup.LayoutParams layoutParams = this.y.getLayoutParams();
            layoutParams.width = this.v;
            this.y.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.z.getLayoutParams();
            layoutParams2.width = -1;
            this.z.setLayoutParams(layoutParams2);
            ViewGroup.LayoutParams layoutParams3 = this.e.getLayoutParams();
            layoutParams3.width = -1;
            this.e.setLayoutParams(layoutParams3);
            this.e.setEllipsize(TextUtils.TruncateAt.END);
            if (threadData.getAuthor() != null && !StringUtils.isNull(threadData.getAuthor().getName_show())) {
                this.e.setText(threadData.getAuthor().getName_show());
            } else {
                this.e.setText(R.string.obfuscated_res_0x7f0f14a4);
            }
        }
        HomeGroupUbsUIHelper.handleHeadSegmentTitleView(this.e);
        m();
    }

    public final void B(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) == null) || threadData.getVoiceRoomData() == null || StringUtils.isNull(threadData.getVoiceRoomData().room_name) || threadData.getVoiceRoomData().room_id.longValue() <= 0) {
            return;
        }
        if (getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            marginLayoutParams.bottomMargin = pi.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);
            setLayoutParams(marginLayoutParams);
        }
        if (threadData.getVoiceRoomData().status.intValue() == 1) {
            this.c.setIsclearmode(true);
            if (threadData != null && threadData.getAuthor() != null && threadData.getAuthor().isOfficial()) {
                this.B.setVisibility(0);
                SkinManager.setImageResource(this.B, R.drawable.obfuscated_res_0x7f0805d9);
            }
            this.E &= -257;
            y(threadData);
            this.d.setSpeed(0.8f);
            this.d.setVisibility(0);
            this.d.loop(true);
            this.d.post(new g(this));
            return;
        }
        this.d.setVisibility(8);
        this.d.cancelAnimation();
        this.c.setIsclearmode(false);
        this.B.setVisibility(8);
    }

    public void f() {
        int width;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (k(512)) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.e.getMeasuredHeight());
                layoutParams.setMargins(pi.f(this.a, R.dimen.tbds10), pi.f(this.a, R.dimen.tbds_5), 0, 0);
                this.m.setLayoutParams(layoutParams);
            }
            TextPaint paint = this.e.getPaint();
            int i3 = pi.q(this.a)[0];
            if (i3 > 0 && (width = (getWidth() - ((i3 * 31) / 108)) - pi.f(this.a, R.dimen.tbds107)) > 0) {
                int u = pi.u(paint, l(this.A.getAuthor().getName_show(), 12)) + this.e.getPaddingLeft() + this.e.getPaddingRight();
                int u2 = pi.u(paint, l(this.A.getAuthor().getName_show(), 10)) + this.e.getPaddingLeft() + this.e.getPaddingRight();
                int measuredWidth = this.h.getMeasuredWidth();
                int measuredWidth2 = this.e.getMeasuredWidth();
                int measuredWidth3 = this.m.getMeasuredWidth();
                int measuredWidth4 = this.f.getMeasuredWidth();
                int measuredWidth5 = this.g.getMeasuredWidth();
                if (width < measuredWidth2 + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                    String charSequence = this.e.getText().toString();
                    int i4 = measuredWidth + measuredWidth3;
                    int i5 = measuredWidth4 + i4;
                    int i6 = measuredWidth5 + i5;
                    int i7 = u + i6;
                    if (width > i7) {
                        this.e.setText(l(charSequence, 12));
                    } else if (width < i7) {
                        this.e.setText(l(charSequence, 10));
                    }
                    if (width < i6 + u2) {
                        this.g.setVisibility(8);
                    }
                    if (width < i5 + u2) {
                        this.f.setVisibility(8);
                    }
                    if (width > i4 + u2) {
                        this.h.setVisibility(8);
                    }
                    if (width > measuredWidth3 + u2) {
                        this.m.setVisibility(8);
                    }
                }
                int i8 = Integer.MAX_VALUE;
                if (k(2048)) {
                    i = (i3 - this.r) - this.s;
                    i2 = this.t;
                } else {
                    ThreadData threadData = this.A;
                    if (threadData != null && threadData.getAuthor() != null && this.A.getAuthor().isBaijiahaoUser()) {
                        i8 = (i3 - this.r) - this.u;
                        if (!this.A.getAuthor().hadConcerned()) {
                            i = (i3 - this.r) - this.s;
                            i2 = this.t;
                        }
                    }
                    this.i.setMaxWidth(i8);
                }
                i8 = i - i2;
                this.i.setMaxWidth(i8);
            }
        }
    }

    public void frsVirtualImageStatistic(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            z05 customState = this.A.getCustomState();
            if (customState == null) {
                this.G = dx.d;
            } else {
                this.G = dx.c;
                this.q.setData(customState.b(), customState.a());
                this.H = this.q.getData();
            }
            dx.a(i, this.A.getTid(), dx.b, this.G, this.H);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.h.setVisibility(k(1) ? 0 : 8);
            this.e.setVisibility(k(4) ? 0 : 8);
            this.f.setVisibility(k(16) ? 0 : 8);
            this.m.setVisibility(k(8) ? 0 : 8);
            this.g.setVisibility(k(32) ? 0 : 8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.y.getLayoutParams();
            if (k(128)) {
                this.i.setVisibility(0);
            } else {
                this.i.setVisibility(8);
            }
            this.y.setLayoutParams(layoutParams);
            this.o.setVisibility(k(4096) ? 0 : 8);
        }
    }

    public HeadPendantClickableView getAvatar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.c : (HeadPendantClickableView) invokeV.objValue;
    }

    public RelativeLayout getSuffixContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.n : (RelativeLayout) invokeV.objValue;
    }

    public View getUserName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.e : (View) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) findViewById(R.id.obfuscated_res_0x7f09230e);
            this.c = headPendantClickableView;
            headPendantClickableView.setHasPendantStyle();
            this.c.getHeadView().setIsRound(true);
            this.c.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.c.getHeadView().setDefaultResource(17170445);
            this.c.getHeadView().setPlaceHolder(1);
            this.c.setAfterClickListener(new f(this));
            this.C = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f092314);
            HeadCustomImageView headCustomImageView = (HeadCustomImageView) findViewById(R.id.obfuscated_res_0x7f092310);
            this.D = headCustomImageView;
            headCustomImageView.setOnClickListener(this.M);
            this.d = (TBLottieAnimationView) findViewById(R.id.obfuscated_res_0x7f09232d);
            this.B = (ImageView) findViewById(R.id.obfuscated_res_0x7f090e91);
            UserIconBox userIconBox = (UserIconBox) findViewById(R.id.obfuscated_res_0x7f092350);
            this.h = userIconBox;
            userIconBox.setOnClickListener(this.J);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f09232f);
            this.e = textView;
            textView.setOnClickListener(this.K);
            this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f090e00);
            this.m = (TextView) findViewById(R.id.obfuscated_res_0x7f09205c);
            UserIconBox userIconBox2 = (UserIconBox) findViewById(R.id.obfuscated_res_0x7f092066);
            this.g = userIconBox2;
            userIconBox2.setOnClickListener(this.L);
            this.g.setAutoChangedStyle(false);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f09203b);
            if (DeviceInfoUtil.isMi5X()) {
                this.i.setPadding(0, -N, 0, 0);
            }
            this.j = (LocationExtendLayout) findViewById(R.id.obfuscated_res_0x7f0905c9);
            this.k = (ImageView) findViewById(R.id.obfuscated_res_0x7f0901f6);
            this.l = (TextView) findViewById(R.id.obfuscated_res_0x7f0901f5);
            this.y = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f092331);
            this.z = findViewById(R.id.obfuscated_res_0x7f090522);
            this.n = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091e67);
            this.o = (ImageView) findViewById(R.id.obfuscated_res_0x7f090af8);
            this.p = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091ce6);
            VirtualImageStatusTip virtualImageStatusTip = (VirtualImageStatusTip) findViewById(R.id.obfuscated_res_0x7f092479);
            this.q = virtualImageStatusTip;
            virtualImageStatusTip.setOnClickListener(this.M);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.a = getContext();
            setClipChildren(false);
            setClipToPadding(false);
            setOrientation(0);
            setGravity(16);
            setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d086d, (ViewGroup) this, true);
            h();
            pi.f(this.a, R.dimen.tbds40);
            this.r = pi.f(this.a, R.dimen.tbds164);
            this.s = pi.f(this.a, R.dimen.tbds156);
            this.t = pi.f(this.a, R.dimen.tbds148);
            this.u = pi.f(this.a, R.dimen.tbds118);
            this.v = pi.f(this.a, R.dimen.tbds580);
        }
    }

    public boolean isHasPlayVirtualImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.F : invokeV.booleanValue;
    }

    public boolean isVirtualImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            ThreadData threadData = this.A;
            return (threadData == null || threadData.getCustomFigure() == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean j(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, threadData)) == null) ? (threadData == null || threadData.getAuthor() == null || !threadData.isFromConcern || !UbsABTestHelper.isConcernForumCardShow() || threadData.getAuthor().hadConcerned() || ThreadCardUtils.isSelf(threadData)) ? false : true : invokeL.booleanValue;
    }

    public final boolean k(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) ? (i & this.E) > 0 : invokeI.booleanValue;
    }

    public String l(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048590, this, str, i)) == null) ? StringHelper.cutChineseAndEnglishWithSuffix(str, i, StringHelper.STRING_MORE) : (String) invokeLI.objValue;
    }

    public final void m() {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (threadData = this.A) == null || threadData.getAuthor() == null) {
            return;
        }
        ThreadData threadData2 = this.A;
        if (threadData2.middle_page_num > 0 && threadData2.middle_page_pass_flag == 0) {
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0106);
            HomeGroupUbsUIHelper.handleHeadSegmentTitleViewColor(this.e);
        } else if (ListUtils.isEmpty(this.A.getAuthor().getTShowInfoNew()) && !this.A.isNewGodAuthor()) {
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0106);
            HomeGroupUbsUIHelper.handleHeadSegmentTitleViewColor(this.e);
        } else {
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0331);
        }
    }

    public final void n(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, threadData) == null) {
            if (!k(32768)) {
                this.d.setVisibility(8);
                if (this.d.isAnimating()) {
                    this.d.cancelAnimation();
                }
                this.c.setIsclearmode(false);
                this.B.setVisibility(8);
                return;
            }
            boolean z = (threadData == null || threadData.getAuthor() == null || threadData.getAuthor().getAlaUserData() == null || threadData.getAuthor().getAlaUserData().live_status != 1) ? false : true;
            boolean z2 = (threadData == null || threadData.getThreadAlaInfo() == null || threadData.getThreadAlaInfo().friendRoomStatus != 2) ? false : true;
            if (!z && !z2) {
                this.d.setVisibility(8);
                this.d.cancelAnimation();
                this.c.setIsclearmode(false);
                this.B.setVisibility(8);
                return;
            }
            this.c.setIsclearmode(true);
            if (threadData != null && threadData.getAuthor() != null && threadData.getAuthor().isOfficial()) {
                this.B.setVisibility(0);
                SkinManager.setImageResource(this.B, R.drawable.obfuscated_res_0x7f0805d9);
            }
            this.E &= -257;
            y(threadData);
            this.d.setSpeed(0.8f);
            this.d.setVisibility(0);
            this.d.loop(true);
            this.d.post(new h(this));
        }
    }

    public final void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            boolean z = !StringUtils.isNull(str);
            this.k.setVisibility(z ? 0 : 8);
            this.l.setVisibility(z ? 0 : 8);
            if (z) {
                this.l.setText(str);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.obfuscated_res_0x7f080982, R.color.CAM_X0109, null);
                SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0109);
            }
        }
    }

    @Override // com.repackage.hx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048594, this, tbPageContext, i) == null) || i == this.b) {
            return;
        }
        this.b = i;
        this.c.getHeadView().setPlaceHolder(1);
        TBLottieAnimationView tBLottieAnimationView = this.d;
        if (tBLottieAnimationView != null) {
            SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
        }
        if (this.B.getVisibility() == 0) {
            WebPManager.setMaskDrawable(this.B, R.drawable.obfuscated_res_0x7f0805d9, null);
        }
        LocationExtendLayout locationExtendLayout = this.j;
        if (locationExtendLayout != null) {
            locationExtendLayout.onChangeSkinType(tbPageContext, i);
        }
    }

    public final void p(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, threadData) == null) {
            if (isVirtualImage()) {
                VirtualImageCustomFigure customFigure = threadData.getCustomFigure();
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = UtilHelper.getDimenPixelSize(R.dimen.tbds110);
                    setLayoutParams(layoutParams);
                }
                this.D.setHeadImageViewResource(customFigure.getFigureUrl());
                if (VirtualImageCustomFigure.BACK_GROUND_TYPE_TONE.equals(customFigure.getBackGroundType())) {
                    this.D.setHeadImageBackgroundColorResource(customFigure.getBackgroundValue());
                } else if (VirtualImageCustomFigure.BACK_GROUND_TYPE_URL.equals(customFigure.getBackGroundType())) {
                    this.D.setHeadImageBackgroundResource(customFigure.getBackgroundValue());
                }
                this.D.d(threadData.getAuthor());
                this.D.setSmallWidthAndHeight(pi.f(TbadkApplication.getInst(), R.dimen.tbds94), pi.f(TbadkApplication.getInst(), R.dimen.tbds120));
                this.C.setVisibility(8);
                this.D.setVisibility(0);
                frsVirtualImageStatistic(2);
                return;
            }
            ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = -2;
                layoutParams2.width = -2;
                setLayoutParams(layoutParams2);
            }
            this.C.setVisibility(0);
            this.D.setVisibility(8);
        }
    }

    public final void q(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, threadData) == null) {
            String str = "";
            o("");
            if (threadData == null) {
                return;
            }
            if ((threadData.getType() != ThreadData.TYPE_VIDEO_ALA_ONLIVE && threadData.getType() != ThreadData.TYPE_ALA_FRIEND_ROOM) || threadData.getThreadAlaInfo() == null || threadData.getThreadAlaInfo().openRecomLocation == 0) {
                return;
            }
            String latitude = threadData.getLatitude();
            String longtitude = threadData.getLongtitude();
            boolean z = true;
            boolean z2 = UtilHelper.isDecimal(latitude) && UtilHelper.isDecimal(longtitude);
            boolean isSystemLocationProviderEnabled = UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst());
            if (z2 && isSystemLocationProviderEnabled) {
                AppPosInfo c2 = ab8.e().c();
                String str2 = c2.latitude;
                String str3 = c2.longitude;
                if ((UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3)) ? false : false) {
                    double g2 = pi.g(ng.c(str2, 0.0d), ng.c(str3, 0.0d), ng.c(latitude, 0.0d), ng.c(longtitude, 0.0d));
                    if (g2 <= 50.0d) {
                        str = StringHelper.formatDistanceNum(g2);
                    } else {
                        str = threadData.getAddress();
                    }
                }
            } else if (z2) {
                str = threadData.getAddress();
            }
            o(str);
        }
    }

    public final void r(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, threadData) == null) || threadData == null || threadData.getAuthor() == null) {
            return;
        }
        if (threadData.isFromFrs()) {
            this.E |= 4096;
        } else {
            this.E &= -4097;
        }
        if (!threadData.isShowForumAndReply() && !(threadData instanceof AdvertAppInfo) && ((threadData.isFromHomPage && !threadData.isUgcThreadType() && !threadData.isNewGodAuthor() && !threadData.isVocieRoom() && threadData.getType() != ThreadData.TYPE_VIDEO_ALA_ONLIVE && threadData.getType() != ThreadData.TYPE_ALA_FRIEND_ROOM) || (threadData.isFromHomPage && UbsABTestHelper.showNewUI() && !threadData.isVocieRoom() && threadData.getType() != ThreadData.TYPE_VIDEO_ALA_ONLIVE && threadData.getType() != ThreadData.TYPE_ALA_FRIEND_ROOM))) {
            this.E &= -129;
        } else {
            this.E |= 128;
        }
        setShowFlag(this.E);
    }

    public void recoverVirtualImageAnimate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            py.a(this.z);
            this.p.setVisibility(0);
            this.q.setVisibility(8);
            this.D.setHeadViewNormalSize();
        }
    }

    public final void s(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, threadData) == null) || this.i == null) {
            return;
        }
        if (threadData != null && !TextUtils.isEmpty(threadData.getThreadExtendInfo())) {
            if (threadData.getAuthor() != null && threadData.getAuthor().isBaijiahaoUser()) {
                this.i.setLines(1);
                this.i.setEllipsize(TextUtils.TruncateAt.END);
            } else {
                this.i.setMaxLines(Integer.MAX_VALUE);
                this.i.setEllipsize(null);
            }
            SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0109);
            this.i.setText(threadData.getThreadExtendInfo());
            this.i.setVisibility(k(128) ? 0 : 8);
            if (threadData.isFromLocal) {
                this.j.setLocationAndDistance(threadData.getAddress(), threadData.getDistance());
                return;
            } else {
                this.j.setVisibility(8);
                return;
            }
        }
        this.i.setVisibility(8);
    }

    public void setData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, threadData) == null) {
            if (threadData == null) {
                setVisibility(8);
            } else if (j(threadData)) {
                setVisibility(4);
            } else {
                this.A = threadData;
                r(threadData);
                y(threadData);
                x(threadData);
                v(threadData);
                A(threadData);
                z(threadData);
                t(threadData);
                s(threadData);
                q(threadData);
                w(threadData);
                n(threadData);
                u(threadData);
                B(threadData);
                setVisibility(0);
                p(threadData);
                if (!k(128) || threadData.isFromHomPage || threadData.isFromConcern() || threadData.isFromLocal) {
                    return;
                }
                if (threadData.isFromFeedTab && "fashion".equals(threadData.mHomePageTopTabTabCode)) {
                    return;
                }
                this.y.post(this.I);
            }
        }
    }

    public void setHasPlayVirtualImage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.F = z;
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, tbPageContext) == null) {
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        HeadPendantClickableView headPendantClickableView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, bdUniqueId) == null) || (headPendantClickableView = this.c) == null) {
            return;
        }
        headPendantClickableView.setPageId(bdUniqueId);
    }

    public void setShowFlag(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            this.E = i;
            g();
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, onClickListener) == null) {
            this.w = onClickListener;
        }
    }

    public void setUserIconAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, onClickListener) == null) {
            this.x = onClickListener;
        }
    }

    public void startVirtualImageAnimate() {
        ThreadData threadData;
        VirtualImageCustomFigure customFigure;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || (threadData = this.A) == null || (customFigure = threadData.getCustomFigure()) == null) {
            return;
        }
        String backgroundValue = VirtualImageCustomFigure.BACK_GROUND_TYPE_TONE.equals(customFigure.getBackGroundType()) ? customFigure.getBackgroundValue() : "#7F66FE";
        z05 customState = this.A.getCustomState();
        if (customState != null && !TextUtils.isEmpty(customState.b())) {
            this.p.setVisibility(8);
            py.b(this.z, 400);
            this.q.setVisibility(0);
            this.q.setData(customState.b(), customState.a(), backgroundValue);
            this.q.f();
        } else {
            this.q.setVisibility(8);
        }
        this.D.f(true, 400L);
    }

    public final void t(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, threadData) == null) || this.c == null || threadData == null || this.A.getAuthor() == null) {
            return;
        }
        this.c.setBigVDimenSize(R.dimen.tbds36);
        this.c.setIsHomePage(threadData.isFromHomPage);
        ThreadData threadData2 = this.A;
        if (threadData2.middle_page_num > 0 && threadData2.middle_page_pass_flag == 0) {
            this.c.h(false);
        } else {
            this.c.j(this.A.getAuthor(), 0);
        }
    }

    public final void u(ThreadData threadData) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, threadData) == null) || !k(4096) || threadData == null || (imageView = this.o) == null) {
            return;
        }
        if (threadData.isHeadLinePost) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
    }

    public final void v(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, threadData) == null) || this.f == null || threadData == null || threadData.getAuthor() == null || !k(16)) {
            return;
        }
        MetaData author = threadData.getAuthor();
        if (this.f.getLayoutParams() != null) {
            this.f.getLayoutParams().width = -2;
        }
        this.f.setOnClickListener(null);
        if (author.getIs_bawu() == 1) {
            vr4 d2 = vr4.d(this.f);
            d2.v(R.color.CAM_X0101);
            d2.e(R.string.A_X04);
            d2.n(R.string.J_X04);
            d2.f(R.color.CAM_X0302);
            if (threadData.isFromBrandForum) {
                this.f.setVisibility(0);
                this.f.setText(R.string.obfuscated_res_0x7f0f033b);
                return;
            } else if ("manager".equals(author.getBawu_type())) {
                this.f.setVisibility(0);
                this.f.setText(R.string.obfuscated_res_0x7f0f02f6);
                return;
            } else if (PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(author.getBawu_type())) {
                this.f.setText(R.string.obfuscated_res_0x7f0f02f7);
                this.f.setVisibility(0);
                return;
            } else if ("pri_content_assist".equals(author.getBawu_type())) {
                this.f.setText(R.string.obfuscated_res_0x7f0f02f3);
                this.f.setVisibility(0);
                return;
            } else if ("pri_manage_assist".equals(author.getBawu_type())) {
                this.f.setText(R.string.obfuscated_res_0x7f0f02f4);
                this.f.setVisibility(0);
                return;
            } else {
                this.f.setVisibility(8);
                return;
            }
        }
        this.f.setVisibility(8);
    }

    public void w(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, threadData) == null) || this.m == null) {
            return;
        }
        if (threadData != null && (k(8) || k(512))) {
            if (this.A.getType() == ThreadData.TYPE_STAR_INTERVIEW) {
                this.m.setVisibility(0);
                this.m.getPaint().setFakeBoldText(true);
                SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0105);
                return;
            } else if (k(8)) {
                if (StringUtils.isNull(threadData.getRecomReason())) {
                    this.m.setVisibility(8);
                    return;
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.m.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                    this.m.setLayoutParams(layoutParams);
                }
                this.m.setText(threadData.getRecomReason());
                this.m.setVisibility(0);
                return;
            } else if (StringUtils.isNull(this.A.getShareIntro())) {
                this.m.setVisibility(8);
                return;
            } else {
                this.m.setVisibility(0);
                this.m.setText(this.A.getShareIntro());
                return;
            }
        }
        this.m.setVisibility(8);
    }

    public final void x(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, threadData) == null) || this.h == null || threadData == null || threadData.getAuthor() == null || !k(1)) {
            return;
        }
        ArrayList<IconData> tShowInfoNew = threadData.getAuthor().getTShowInfoNew();
        if (ListUtils.getCount(tShowInfoNew) != 0) {
            this.h.setVisibility(0);
            this.h.h(tShowInfoNew, 2, this.a.getResources().getDimensionPixelSize(R.dimen.tbds48), this.a.getResources().getDimensionPixelSize(R.dimen.tbds48), this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070302), true);
            return;
        }
        this.h.setVisibility(8);
    }

    public final void y(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, threadData) == null) {
            if (threadData.getAuthor() == null) {
                this.c.setVisibility(8);
                return;
            }
            MetaData author = threadData.getAuthor();
            if (!k(256)) {
                author.setPendantData(null);
            }
            this.c.setData(threadData);
        }
    }

    public final void z(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048614, this, threadData) == null) || this.g == null) {
            return;
        }
        if (!k(32)) {
            this.g.setVisibility(8);
        } else if (threadData != null && threadData.getAuthor() != null && (threadData.middle_page_num <= 0 || threadData.middle_page_pass_flag != 0)) {
            ArrayList<IconData> iconInfo = threadData.getAuthor().getIconInfo();
            if (ListUtils.getCount(iconInfo) != 0) {
                this.g.setVisibility(0);
                this.g.h(iconInfo, 4, this.a.getResources().getDimensionPixelSize(R.dimen.tbds40), this.a.getResources().getDimensionPixelSize(R.dimen.tbds40), this.a.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                return;
            }
            this.g.setVisibility(8);
        } else {
            this.g.setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardUserInfoLayout(Context context, AttributeSet attributeSet) {
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
        this.b = 3;
        this.E = 34053;
        this.G = 0;
        this.H = null;
        this.I = new a(this);
        this.J = new b(this);
        this.K = new c(this);
        this.L = new d(this);
        this.M = new e(this);
        i();
    }
}
