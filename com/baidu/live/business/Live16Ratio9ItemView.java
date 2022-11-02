package com.baidu.live.business;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.base.LiveBaseItemView;
import com.baidu.live.business.model.data.LeftLableInfo;
import com.baidu.live.business.model.data.LiveFeedConfig;
import com.baidu.live.business.model.data.LiveHostInfo;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.business.model.data.RightLableInfo;
import com.baidu.live.business.model.data.ThirdLabelInfo;
import com.baidu.live.business.util.LiveBaseLottieView;
import com.baidu.live.business.view.LiveStatusAnimView;
import com.baidu.tieba.R;
import com.baidu.tieba.da0;
import com.baidu.tieba.qc0;
import com.baidu.tieba.uc0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes2.dex */
public class Live16Ratio9ItemView extends LiveBaseItemView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SimpleDraweeView h;
    public LiveStatusAnimView i;
    public TextView j;
    public TextView k;
    public SimpleDraweeView l;
    public TextView m;
    public TextView n;
    public SimpleDraweeView o;
    public FrameLayout p;
    public boolean q;
    public View r;
    public TextView s;
    public SimpleDraweeView t;
    public ViewStub u;
    public View v;
    public LiveBaseLottieView w;
    public float[] x;
    public Context y;
    public boolean z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Live16Ratio9ItemView(Context context) {
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
        this.z = false;
        d(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Live16Ratio9ItemView(Context context, AttributeSet attributeSet) {
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
        this.z = false;
        d(context);
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void a() {
        LiveBaseLottieView liveBaseLottieView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            if (this.q && this.i.b()) {
                this.i.c();
            }
            View view2 = this.v;
            if (view2 != null && view2.getVisibility() == 0 && (liveBaseLottieView = this.w) != null) {
                liveBaseLottieView.playAnimation();
            }
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b();
            LiveStatusAnimView liveStatusAnimView = this.i;
            if (liveStatusAnimView != null) {
                liveStatusAnimView.d();
            }
            LiveBaseLottieView liveBaseLottieView = this.w;
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
            LiveStatusAnimView liveStatusAnimView = this.i;
            if (liveStatusAnimView != null) {
                liveStatusAnimView.d();
            }
            LiveBaseLottieView liveBaseLottieView = this.w;
            if (liveBaseLottieView != null) {
                liveBaseLottieView.cancelAnimation();
            }
        }
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            this.y = context;
            setNeedRatio(false);
            int e = (int) (((da0.e(context) - (da0.b(context, 12.0f) * 2)) - da0.b(context, 7.0f)) / 2.0d);
            View inflate = RelativeLayout.inflate(context, R.layout.obfuscated_res_0x7f0d053e, this);
            this.h = (SimpleDraweeView) inflate.findViewById(R.id.obfuscated_res_0x7f091385);
            this.u = (ViewStub) inflate.findViewById(R.id.obfuscated_res_0x7f0913a2);
            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091387);
            this.p = frameLayout;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams.width = e;
            layoutParams.height = (int) ((e * 9) / 16.0d);
            this.p.setLayoutParams(layoutParams);
            this.i = (LiveStatusAnimView) inflate.findViewById(R.id.obfuscated_res_0x7f091388);
            this.k = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09138e);
            this.j = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09138a);
            this.l = (SimpleDraweeView) inflate.findViewById(R.id.obfuscated_res_0x7f091382);
            this.m = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091384);
            this.n = (TextView) findViewById(R.id.obfuscated_res_0x7f09138b);
            this.o = (SimpleDraweeView) inflate.findViewById(R.id.obfuscated_res_0x7f09138d);
            this.r = inflate.findViewById(R.id.obfuscated_res_0x7f0913fc);
            this.s = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0913fd);
            this.t = (SimpleDraweeView) inflate.findViewById(R.id.obfuscated_res_0x7f091404);
            float b = da0.b(getContext(), 10.0f);
            this.x = new float[]{b, b, b, b, b, b, b, b};
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(uc0.f().a(getContext(), this.c, "color_white2"));
            gradientDrawable.setCornerRadii(this.x);
            setBackgroundDrawable(gradientDrawable);
            SimpleDraweeView simpleDraweeView = this.h;
            if (simpleDraweeView != null) {
                simpleDraweeView.getHierarchy().setPlaceholderImage(uc0.f().l(this.c), ScalingUtils.ScaleType.FIT_XY);
                this.h.getHierarchy().setFailureImage(uc0.f().l(this.c), ScalingUtils.ScaleType.FIT_XY);
            }
            SimpleDraweeView simpleDraweeView2 = this.l;
            if (simpleDraweeView2 != null) {
                simpleDraweeView2.getHierarchy().setPlaceholderImage(uc0.f().l(this.c), ScalingUtils.ScaleType.FIT_XY);
                this.l.getHierarchy().setFailureImage(uc0.f().l(this.c), ScalingUtils.ScaleType.FIT_XY);
            }
            TextView textView = this.k;
            if (textView != null) {
                textView.setTextColor(uc0.f().a(getContext(), this.c, "color_white4"));
            }
            TextView textView2 = this.j;
            if (textView2 != null) {
                textView2.setTextColor(uc0.f().a(getContext(), this.c, "color_858585"));
            }
            TextView textView3 = this.m;
            if (textView3 != null) {
                textView3.setTextColor(uc0.f().a(getContext(), this.c, "color_858585"));
            }
            TextView textView4 = this.n;
            if (textView4 != null) {
                textView4.setTextColor(uc0.f().a(getContext(), this.c, "color_858585"));
            }
            TextView textView5 = this.s;
            if (textView5 != null) {
                textView5.setTextColor(uc0.f().a(getContext(), this.c, "color_white3"));
            }
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void setData(LiveRoomEntity liveRoomEntity, int i) {
        LiveStatusAnimView liveStatusAnimView;
        LiveFeedConfig.AbSwitchConfig abSwitchConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, liveRoomEntity, i) == null) {
            this.i.setScene(this.c);
            if (liveRoomEntity != null) {
                this.h.setImageURI(liveRoomEntity.cover);
                LeftLableInfo leftLableInfo = liveRoomEntity.leftLabel;
                if (leftLableInfo != null && this.i != null && leftLableInfo.isRankTopStyle()) {
                    this.i.setData(liveRoomEntity, true);
                    this.q = true;
                    this.i.setVisibility(0);
                } else {
                    LeftLableInfo leftLableInfo2 = liveRoomEntity.leftLabel;
                    if (leftLableInfo2 != null && leftLableInfo2.canShowLabel() && (liveStatusAnimView = this.i) != null) {
                        liveStatusAnimView.setData(liveRoomEntity, false);
                        this.q = true;
                        this.i.setVisibility(0);
                    } else {
                        this.q = false;
                        LiveStatusAnimView liveStatusAnimView2 = this.i;
                        if (liveStatusAnimView2 != null) {
                            liveStatusAnimView2.setVisibility(8);
                        }
                    }
                }
                qc0.h(this.k, 1, 14.0f);
                this.k.setText(liveRoomEntity.title);
                qc0.h(this.j, 1, 10.0f);
                LiveHostInfo liveHostInfo = liveRoomEntity.hostInfo;
                if (liveHostInfo != null) {
                    this.j.setText(liveHostInfo.name);
                    LiveFeedConfig liveFeedConfig = this.d;
                    if (liveFeedConfig != null && (abSwitchConfig = liveFeedConfig.abSwitchConfig) != null && abSwitchConfig.otherNewStyle) {
                        this.z = true;
                    }
                    if (this.z) {
                        this.l.setVisibility(8);
                    } else {
                        this.l.setVisibility(0);
                        this.l.setImageURI(liveRoomEntity.hostInfo.avatar);
                    }
                }
                qc0.h(this.m, 1, 10.0f);
                qc0.h(this.n, 1, 10.0f);
                if (liveRoomEntity.liveStatus == 0) {
                    this.m.setVisibility(8);
                    this.n.setVisibility(0);
                    this.n.setText(liveRoomEntity.formatReserveStartTime());
                } else {
                    this.m.setText(da0.a(this.y, liveRoomEntity.audienceCount));
                    this.m.setVisibility(0);
                    this.n.setVisibility(8);
                }
                RightLableInfo rightLableInfo = liveRoomEntity.rightLabel;
                if (rightLableInfo != null && rightLableInfo.canShowLabel()) {
                    this.o.setImageURI(liveRoomEntity.rightLabel.iconUrl);
                    this.o.setVisibility(0);
                } else {
                    this.o.setVisibility(8);
                }
                if (LiveFeedPageSdk.IMMERSION.equals(this.c) || "recommend".equals(this.c) || LiveFeedPageSdk.VIDEO_BAR.equals(this.c)) {
                    this.h.getHierarchy().setUseGlobalColorFilter(false);
                    this.l.getHierarchy().setUseGlobalColorFilter(false);
                    this.o.getHierarchy().setUseGlobalColorFilter(false);
                    this.t.getHierarchy().setUseGlobalColorFilter(false);
                }
                ThirdLabelInfo thirdLabelInfo = liveRoomEntity.thirdLabel;
                if (thirdLabelInfo != null && thirdLabelInfo.canShowLabel()) {
                    this.r.setVisibility(0);
                    this.s.setText(liveRoomEntity.thirdLabel.text);
                    if (!TextUtils.isEmpty(liveRoomEntity.thirdLabel.iconUrl)) {
                        this.t.setImageURI(liveRoomEntity.thirdLabel.iconUrl);
                        this.t.setVisibility(0);
                    } else {
                        this.t.setVisibility(8);
                    }
                    if (!TextUtils.isEmpty(liveRoomEntity.thirdLabel.startColor) && !TextUtils.isEmpty(liveRoomEntity.thirdLabel.endColor)) {
                        try {
                            ((GradientDrawable) this.r.getBackground()).setColors(new int[]{Color.parseColor(liveRoomEntity.thirdLabel.startColor), Color.parseColor(liveRoomEntity.thirdLabel.endColor)});
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    this.r.setVisibility(8);
                }
                e("day");
            }
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void setIsCurViewing(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (z) {
                View view2 = this.v;
                if (view2 == null) {
                    View inflate = this.u.inflate();
                    this.v = inflate;
                    LiveBaseLottieView liveBaseLottieView = (LiveBaseLottieView) inflate.findViewById(R.id.obfuscated_res_0x7f0913a1);
                    this.w = liveBaseLottieView;
                    liveBaseLottieView.setRepeatCount(-1);
                    this.w.setAnimationFromUrl("https://ala-rmb-gift.bj.bcebos.com/lottie/android/liveshow_room_viewing.json");
                } else {
                    view2.setVisibility(0);
                }
                this.w.playAnimation();
            } else if (this.v != null) {
                this.w.cancelAnimation();
                this.v.setVisibility(8);
            }
        }
    }
}
