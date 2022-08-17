package com.baidu.live.business;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.business.base.LiveBaseItemView;
import com.baidu.live.business.model.data.LeftLableInfo;
import com.baidu.live.business.model.data.LiveBannerEntity;
import com.baidu.live.business.model.data.LiveHostInfo;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.business.util.LiveBaseLottieView;
import com.baidu.live.business.view.LiveStatusAnimView;
import com.baidu.live.business.view.banner.BannerEntity;
import com.baidu.live.business.view.banner.BannerView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.repackage.ab0;
import com.repackage.la0;
import com.repackage.m80;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class Live4Ratio5TopicView extends LiveBaseItemView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BannerView h;
    public SimpleDraweeView i;
    public LiveStatusAnimView j;
    public TextSwitcher k;
    public TextSwitcher l;
    public TextSwitcher m;
    public ViewStub n;
    public View o;
    public LiveBaseLottieView p;
    public boolean q;
    public View r;
    public Context s;
    public LeftLableInfo t;
    public List<LiveRoomEntity> u;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Live4Ratio5TopicView a;

        public a(Live4Ratio5TopicView live4Ratio5TopicView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {live4Ratio5TopicView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = live4Ratio5TopicView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.f == null || this.a.t == null || TextUtils.isEmpty(this.a.t.cmd)) {
                return;
            }
            this.a.f.a(this.a.t.cmd);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Live4Ratio5TopicView a;

        public b(Live4Ratio5TopicView live4Ratio5TopicView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {live4Ratio5TopicView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = live4Ratio5TopicView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.g == null) {
                return;
            }
            this.a.g.a(this.a.h.getCurrentPosition());
        }
    }

    /* loaded from: classes2.dex */
    public class c implements BannerView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Live4Ratio5TopicView a;

        public c(Live4Ratio5TopicView live4Ratio5TopicView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {live4Ratio5TopicView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = live4Ratio5TopicView;
        }

        @Override // com.baidu.live.business.view.banner.BannerView.i
        public void onBannerShow(LiveBannerEntity liveBannerEntity) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, liveBannerEntity) == null) || this.a.g == null || liveBannerEntity == null) {
                return;
            }
            this.a.g.b(this.a.h.getCurrentPosition());
        }
    }

    /* loaded from: classes2.dex */
    public class d implements BannerView.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Live4Ratio5TopicView a;

        public d(Live4Ratio5TopicView live4Ratio5TopicView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {live4Ratio5TopicView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = live4Ratio5TopicView;
        }

        @Override // com.baidu.live.business.view.banner.BannerView.j
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || this.a.u == null) {
                return;
            }
            int i2 = i + 1;
            if (i2 >= this.a.u.size()) {
                i2 = 0;
            }
            this.a.u((LiveRoomEntity) this.a.u.get(i2), true);
        }
    }

    /* loaded from: classes2.dex */
    public class e implements ViewSwitcher.ViewFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Live4Ratio5TopicView a;

        public e(Live4Ratio5TopicView live4Ratio5TopicView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {live4Ratio5TopicView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = live4Ratio5TopicView;
        }

        @Override // android.widget.ViewSwitcher.ViewFactory
        public View makeView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                TextView textView = new TextView(this.a.getContext());
                textView.setMaxLines(1);
                textView.setTextSize(1, 14.0f);
                textView.setTextColor(ab0.f().a(this.a.getContext(), this.a.c, "color_white3"));
                textView.setEllipsize(TextUtils.TruncateAt.END);
                return textView;
            }
            return (View) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class f implements ViewSwitcher.ViewFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Live4Ratio5TopicView a;

        public f(Live4Ratio5TopicView live4Ratio5TopicView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {live4Ratio5TopicView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = live4Ratio5TopicView;
        }

        @Override // android.widget.ViewSwitcher.ViewFactory
        public View makeView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                TextView textView = new TextView(this.a.getContext());
                textView.setMaxLines(1);
                textView.setTextSize(1, 14.0f);
                textView.setTypeface(Typeface.defaultFromStyle(1));
                textView.setTextColor(ab0.f().a(this.a.getContext(), this.a.c, "color_white3"));
                textView.setEllipsize(TextUtils.TruncateAt.END);
                return textView;
            }
            return (View) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class g implements ViewSwitcher.ViewFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Live4Ratio5TopicView a;

        public g(Live4Ratio5TopicView live4Ratio5TopicView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {live4Ratio5TopicView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = live4Ratio5TopicView;
        }

        @Override // android.widget.ViewSwitcher.ViewFactory
        public View makeView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                TextView textView = new TextView(this.a.getContext());
                textView.setMaxLines(1);
                textView.setTextSize(1, 10.0f);
                textView.setTextColor(ab0.f().a(this.a.getContext(), this.a.c, "color_white3"));
                textView.setEllipsize(TextUtils.TruncateAt.END);
                return textView;
            }
            return (View) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Live4Ratio5TopicView(Context context) {
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
        this.q = false;
        s(context);
    }

    private void setCoverBannerData(List<LiveRoomEntity> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            if (!la0.c(list)) {
                for (LiveRoomEntity liveRoomEntity : list) {
                    LiveBannerEntity liveBannerEntity = new LiveBannerEntity();
                    liveBannerEntity.pic = liveRoomEntity.cover;
                    liveBannerEntity.liveStatus = liveRoomEntity.liveStatus;
                    liveBannerEntity.roomEntity = liveRoomEntity;
                    arrayList.add(liveBannerEntity);
                }
            }
            if (this.h.r(arrayList)) {
                BannerEntity bannerEntity = new BannerEntity();
                bannerEntity.mBannerList = arrayList;
                bannerEntity.mBroadcastInterval = 2000;
                this.h.setBannerEntity(bannerEntity);
            }
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void a() {
        LiveBaseLottieView liveBaseLottieView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            BannerView bannerView = this.h;
            if (bannerView != null) {
                bannerView.x();
            }
            if (this.q && this.j.b()) {
                this.j.c();
            }
            View view2 = this.o;
            if (view2 == null || view2.getVisibility() != 0 || (liveBaseLottieView = this.p) == null) {
                return;
            }
            liveBaseLottieView.playAnimation();
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b();
            BannerView bannerView = this.h;
            if (bannerView != null) {
                bannerView.w();
            }
            LiveStatusAnimView liveStatusAnimView = this.j;
            if (liveStatusAnimView != null) {
                liveStatusAnimView.d();
            }
            LiveBaseLottieView liveBaseLottieView = this.p;
            if (liveBaseLottieView != null) {
                liveBaseLottieView.cancelAnimation();
            }
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            BannerView bannerView = this.h;
            if (bannerView != null) {
                bannerView.w();
            }
            LiveStatusAnimView liveStatusAnimView = this.j;
            if (liveStatusAnimView != null) {
                liveStatusAnimView.d();
            }
            LiveBaseLottieView liveBaseLottieView = this.p;
            if (liveBaseLottieView != null) {
                liveBaseLottieView.cancelAnimation();
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.h.setHasIndicator(false);
            this.h.setCanTouchScroll(false);
            this.h.setSwitchDuration(300);
            this.h.setAspectRatio(1.25f);
            this.h.setOnBannerShowListener(new c(this));
            this.h.setOnBannerSwitchListener(new d(this));
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.s, 17432576);
            loadAnimation.setDuration(300L);
            loadAnimation.setInterpolator(new AccelerateInterpolator());
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.s, 17432577);
            loadAnimation2.setDuration(300L);
            loadAnimation2.setInterpolator(new AccelerateInterpolator());
            this.k.setInAnimation(loadAnimation);
            this.k.setOutAnimation(loadAnimation2);
            this.m.setInAnimation(loadAnimation);
            this.m.setOutAnimation(loadAnimation2);
            this.l.setInAnimation(loadAnimation);
            this.l.setOutAnimation(loadAnimation2);
            this.k.setFactory(new e(this));
            this.m.setFactory(new f(this));
            this.l.setFactory(new g(this));
        }
    }

    public final void s(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            setNeedRatio(true);
            setAspectRatio(1.25f);
            this.s = context;
            View inflate = RelativeLayout.inflate(context, R.layout.obfuscated_res_0x7f0d051c, this);
            this.h = (BannerView) inflate.findViewById(R.id.obfuscated_res_0x7f091351);
            this.n = (ViewStub) inflate.findViewById(R.id.obfuscated_res_0x7f091354);
            this.j = (LiveStatusAnimView) inflate.findViewById(R.id.obfuscated_res_0x7f09133b);
            this.k = (TextSwitcher) inflate.findViewById(R.id.obfuscated_res_0x7f091340);
            this.l = (TextSwitcher) inflate.findViewById(R.id.obfuscated_res_0x7f091333);
            this.i = (SimpleDraweeView) inflate.findViewById(R.id.obfuscated_res_0x7f091334);
            this.m = (TextSwitcher) inflate.findViewById(R.id.obfuscated_res_0x7f09133c);
            View findViewById = inflate.findViewById(R.id.obfuscated_res_0x7f091329);
            this.r = findViewById;
            findViewById.getLayoutParams().height = m80.b(getContext(), 35.0f);
            this.r.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.obfuscated_res_0x7f080ccd, null));
            r();
            q();
            this.j.setOnClickListener(new a(this));
            setOnClickListener(new b(this));
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void setData(LiveRoomEntity liveRoomEntity, int i) {
        LiveStatusAnimView liveStatusAnimView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, liveRoomEntity, i) == null) || liveRoomEntity == null) {
            return;
        }
        this.u = liveRoomEntity.topicRoomList;
        this.h.setScene(this.c);
        this.j.setScene(this.c);
        this.t = liveRoomEntity.leftLabel;
        setCoverBannerData(liveRoomEntity.topicRoomList);
        LeftLableInfo leftLableInfo = liveRoomEntity.leftLabel;
        if (leftLableInfo != null && this.j != null && leftLableInfo.isRankTopStyle()) {
            this.j.setData(liveRoomEntity, true);
            this.q = true;
            this.j.setVisibility(0);
        } else {
            LeftLableInfo leftLableInfo2 = liveRoomEntity.leftLabel;
            if (leftLableInfo2 != null && leftLableInfo2.canShowLabel() && (liveStatusAnimView = this.j) != null) {
                liveStatusAnimView.setData(liveRoomEntity, false);
                this.q = true;
                this.j.setVisibility(0);
            } else {
                this.q = false;
                LiveStatusAnimView liveStatusAnimView2 = this.j;
                if (liveStatusAnimView2 != null) {
                    liveStatusAnimView2.setVisibility(8);
                }
            }
        }
        u(this.u.get(this.h.getCurrentPosition()), false);
        t("day");
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void setIsCurViewing(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (z) {
                View view2 = this.o;
                if (view2 == null) {
                    View inflate = this.n.inflate();
                    this.o = inflate;
                    LiveBaseLottieView liveBaseLottieView = (LiveBaseLottieView) inflate.findViewById(R.id.obfuscated_res_0x7f091353);
                    this.p = liveBaseLottieView;
                    liveBaseLottieView.setRepeatCount(-1);
                    this.p.setAnimationFromUrl("https://ala-rmb-gift.bj.bcebos.com/lottie/android/liveshow_room_viewing.json");
                } else {
                    view2.setVisibility(0);
                }
                this.p.playAnimation();
            } else if (this.o != null) {
                this.p.cancelAnimation();
                this.o.setVisibility(8);
            }
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(ab0.f().a(getContext(), this.c, "color_white2"));
            gradientDrawable.setCornerRadius(m80.b(getContext(), 10.0f));
            setBackgroundDrawable(gradientDrawable);
            BannerView bannerView = this.h;
            if (bannerView != null) {
                bannerView.u(str);
            }
            SimpleDraweeView simpleDraweeView = this.i;
            if (simpleDraweeView != null) {
                simpleDraweeView.getHierarchy().setPlaceholderImage(ab0.f().k(this.c), ScalingUtils.ScaleType.FIT_XY);
            }
            TextSwitcher textSwitcher = this.k;
            if (textSwitcher != null && textSwitcher.getCurrentView() != null) {
                ((TextView) this.k.getCurrentView()).setTextColor(ab0.f().a(getContext(), this.c, "color_white3"));
            }
            TextSwitcher textSwitcher2 = this.m;
            if (textSwitcher2 != null && textSwitcher2.getCurrentView() != null) {
                ((TextView) this.m.getCurrentView()).setTextColor(ab0.f().a(getContext(), this.c, "color_white3"));
            }
            TextSwitcher textSwitcher3 = this.l;
            if (textSwitcher3 == null || textSwitcher3.getCurrentView() == null) {
                return;
            }
            ((TextView) this.l.getCurrentView()).setTextColor(ab0.f().a(getContext(), this.c, "color_white3"));
        }
    }

    public final void u(LiveRoomEntity liveRoomEntity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048585, this, liveRoomEntity, z) == null) {
            LiveHostInfo liveHostInfo = liveRoomEntity.hostInfo;
            if (liveHostInfo != null) {
                if (z) {
                    this.m.setText(liveHostInfo.name);
                } else {
                    this.m.setCurrentText(liveHostInfo.name);
                }
            }
            if (liveRoomEntity.liveStatus == 0) {
                this.l.setVisibility(8);
                return;
            }
            this.l.setVisibility(0);
            if (z) {
                this.l.setText(m80.a(this.s, liveRoomEntity.audienceCount));
            } else {
                this.l.setCurrentText(m80.a(this.s, liveRoomEntity.audienceCount));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Live4Ratio5TopicView(Context context, AttributeSet attributeSet) {
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
        this.q = false;
        s(context);
    }
}
