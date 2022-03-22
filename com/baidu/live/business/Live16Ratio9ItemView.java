package com.baidu.live.business;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.v.b.f.a;
import c.a.v.b.f.e;
import c.a.v.i.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.business.base.LiveBaseItemView;
import com.baidu.live.business.model.data.LeftLableInfo;
import com.baidu.live.business.model.data.LiveHostInfo;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.business.model.data.RightLableInfo;
import com.baidu.live.business.view.LiveStatusAnimView;
import com.baidu.mobstat.Config;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes3.dex */
public class Live16Ratio9ItemView extends LiveBaseItemView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public SimpleDraweeView f25683d;

    /* renamed from: e  reason: collision with root package name */
    public LiveStatusAnimView f25684e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f25685f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f25686g;

    /* renamed from: h  reason: collision with root package name */
    public SimpleDraweeView f25687h;
    public TextView i;
    public SimpleDraweeView j;
    public FrameLayout k;
    public boolean l;
    public float[] m;
    public Context n;

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
        this.l = false;
        d(context);
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            if (this.l && this.f25684e.b()) {
                this.f25684e.c();
            }
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b();
            LiveStatusAnimView liveStatusAnimView = this.f25684e;
            if (liveStatusAnimView != null) {
                liveStatusAnimView.d();
            }
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            LiveStatusAnimView liveStatusAnimView = this.f25684e;
            if (liveStatusAnimView != null) {
                liveStatusAnimView.d();
            }
        }
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            this.n = context;
            setNeedRatio(false);
            int c2 = (int) (((a.c(context) - (a.a(context, 12.0f) * 2)) - a.a(context, 7.0f)) / 2.0d);
            View inflate = RelativeLayout.inflate(context, R.layout.obfuscated_res_0x7f0d050b, this);
            this.f25683d = (SimpleDraweeView) inflate.findViewById(R.id.obfuscated_res_0x7f0912a3);
            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0912a4);
            this.k = frameLayout;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams.width = c2;
            layoutParams.height = (int) ((c2 * 9) / 16.0d);
            this.k.setLayoutParams(layoutParams);
            this.f25684e = (LiveStatusAnimView) inflate.findViewById(R.id.obfuscated_res_0x7f0912a5);
            this.f25686g = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0912a9);
            this.f25685f = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0912a7);
            this.f25687h = (SimpleDraweeView) inflate.findViewById(R.id.obfuscated_res_0x7f0912a0);
            this.i = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0912a2);
            this.j = (SimpleDraweeView) inflate.findViewById(R.id.obfuscated_res_0x7f0912a8);
            float a = a.a(getContext(), 10.0f);
            this.m = new float[]{a, a, a, a, a, a, a, a};
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(f.e().a(getContext(), this.f25736c, "color_white2"));
            gradientDrawable.setCornerRadii(this.m);
            setBackgroundDrawable(gradientDrawable);
            SimpleDraweeView simpleDraweeView = this.f25683d;
            if (simpleDraweeView != null) {
                simpleDraweeView.getHierarchy().setPlaceholderImage(f.e().j(this.f25736c), ScalingUtils.ScaleType.FIT_XY);
            }
            SimpleDraweeView simpleDraweeView2 = this.f25687h;
            if (simpleDraweeView2 != null) {
                simpleDraweeView2.getHierarchy().setPlaceholderImage(f.e().j(this.f25736c), ScalingUtils.ScaleType.FIT_XY);
            }
            TextView textView = this.f25686g;
            if (textView != null) {
                textView.setTextColor(f.e().a(getContext(), this.f25736c, "color_1F1F1F"));
            }
            TextView textView2 = this.f25685f;
            if (textView2 != null) {
                textView2.setTextColor(f.e().a(getContext(), this.f25736c, "color_858585"));
            }
            TextView textView3 = this.i;
            if (textView3 != null) {
                textView3.setTextColor(f.e().a(getContext(), this.f25736c, "color_858585"));
            }
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public ViewGroup getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.k : (ViewGroup) invokeV.objValue;
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void setData(LiveRoomEntity liveRoomEntity, int i) {
        LiveStatusAnimView liveStatusAnimView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, liveRoomEntity, i) == null) {
            this.f25684e.setIsImmersion(this.f25736c);
            if (liveRoomEntity != null) {
                this.f25683d.setImageURI(liveRoomEntity.cover);
                LeftLableInfo leftLableInfo = liveRoomEntity.leftLabel;
                if (leftLableInfo != null && !TextUtils.isEmpty(leftLableInfo.text) && (liveStatusAnimView = this.f25684e) != null) {
                    int i2 = liveRoomEntity.liveStatus;
                    LeftLableInfo leftLableInfo2 = liveRoomEntity.leftLabel;
                    liveStatusAnimView.setData(i2, leftLableInfo2.text, leftLableInfo2.startColor, leftLableInfo2.endColor);
                    this.l = true;
                    this.f25684e.setVisibility(0);
                } else {
                    this.l = false;
                    LiveStatusAnimView liveStatusAnimView2 = this.f25684e;
                    if (liveStatusAnimView2 != null) {
                        liveStatusAnimView2.setVisibility(8);
                    }
                }
                this.f25686g.setText(liveRoomEntity.title);
                LiveHostInfo liveHostInfo = liveRoomEntity.hostInfo;
                if (liveHostInfo != null) {
                    this.f25685f.setText(liveHostInfo.name);
                    this.f25687h.setImageURI(liveRoomEntity.hostInfo.avatar);
                }
                if (liveRoomEntity.liveStatus == 0) {
                    this.i.setVisibility(8);
                } else {
                    this.i.setText(e.a(this.n, liveRoomEntity.audienceCount));
                    this.i.setVisibility(0);
                }
                RightLableInfo rightLableInfo = liveRoomEntity.rightLabel;
                if (rightLableInfo != null && !TextUtils.isEmpty(rightLableInfo.iconUrl)) {
                    this.j.setImageURI(liveRoomEntity.rightLabel.iconUrl);
                    this.j.setVisibility(0);
                } else {
                    this.j.setVisibility(8);
                }
                if (this.f25736c) {
                    this.f25683d.getHierarchy().setUseGlobalColorFilter(false);
                    this.f25687h.getHierarchy().setUseGlobalColorFilter(false);
                    this.j.getHierarchy().setUseGlobalColorFilter(false);
                }
                e(Config.TRACE_VISIT_RECENT_DAY);
            }
        }
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
        this.l = false;
        d(context);
    }
}
