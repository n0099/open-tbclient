package com.baidu.live.business;

import android.content.Context;
import android.graphics.Typeface;
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
public class Live4Ratio5ItemView extends LiveBaseItemView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public SimpleDraweeView f25688d;

    /* renamed from: e  reason: collision with root package name */
    public SimpleDraweeView f25689e;

    /* renamed from: f  reason: collision with root package name */
    public LiveStatusAnimView f25690f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f25691g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f25692h;
    public TextView i;
    public SimpleDraweeView j;
    public FrameLayout k;
    public boolean l;
    public View m;
    public Context n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Live4Ratio5ItemView(Context context) {
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
            if (this.l && this.f25690f.b()) {
                this.f25690f.c();
            }
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b();
            LiveStatusAnimView liveStatusAnimView = this.f25690f;
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
            LiveStatusAnimView liveStatusAnimView = this.f25690f;
            if (liveStatusAnimView != null) {
                liveStatusAnimView.d();
            }
        }
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            setNeedRatio(true);
            setAspectRatio(1.25f);
            this.n = context;
            View inflate = RelativeLayout.inflate(context, R.layout.obfuscated_res_0x7f0d050c, this);
            this.k = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0912a4);
            this.f25688d = (SimpleDraweeView) inflate.findViewById(R.id.obfuscated_res_0x7f0912a3);
            this.f25690f = (LiveStatusAnimView) inflate.findViewById(R.id.obfuscated_res_0x7f0912a6);
            this.f25691g = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0912a9);
            this.f25692h = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09129f);
            this.f25689e = (SimpleDraweeView) inflate.findViewById(R.id.obfuscated_res_0x7f0912a0);
            this.i = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0912a7);
            this.j = (SimpleDraweeView) inflate.findViewById(R.id.obfuscated_res_0x7f0912a8);
            this.m = inflate.findViewById(R.id.obfuscated_res_0x7f091296);
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            SimpleDraweeView simpleDraweeView = this.f25688d;
            if (simpleDraweeView != null) {
                simpleDraweeView.getHierarchy().setPlaceholderImage(f.e().j(this.f25736c), ScalingUtils.ScaleType.FIT_XY);
            }
            SimpleDraweeView simpleDraweeView2 = this.f25689e;
            if (simpleDraweeView2 != null) {
                simpleDraweeView2.getHierarchy().setPlaceholderImage(f.e().j(this.f25736c), ScalingUtils.ScaleType.FIT_XY);
            }
            TextView textView = this.f25691g;
            if (textView != null) {
                textView.setTextColor(f.e().a(getContext(), this.f25736c, "color_white3"));
            }
            TextView textView2 = this.i;
            if (textView2 != null) {
                textView2.setTextColor(f.e().a(getContext(), this.f25736c, "color_white3"));
            }
            TextView textView3 = this.f25692h;
            if (textView3 != null) {
                textView3.setTextColor(f.e().a(getContext(), this.f25736c, "color_white3"));
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
            this.f25690f.setIsImmersion(this.f25736c);
            if (liveRoomEntity != null) {
                this.f25688d.setImageURI(liveRoomEntity.cover);
                LeftLableInfo leftLableInfo = liveRoomEntity.leftLabel;
                if (leftLableInfo != null && !TextUtils.isEmpty(leftLableInfo.text) && (liveStatusAnimView = this.f25690f) != null) {
                    int i2 = liveRoomEntity.liveStatus;
                    LeftLableInfo leftLableInfo2 = liveRoomEntity.leftLabel;
                    liveStatusAnimView.setData(i2, leftLableInfo2.text, leftLableInfo2.startColor, leftLableInfo2.endColor);
                    this.l = true;
                    this.f25690f.setVisibility(0);
                } else {
                    this.l = false;
                    LiveStatusAnimView liveStatusAnimView2 = this.f25690f;
                    if (liveStatusAnimView2 != null) {
                        liveStatusAnimView2.setVisibility(8);
                    }
                }
                this.f25691g.setText(liveRoomEntity.title);
                LiveHostInfo liveHostInfo = liveRoomEntity.hostInfo;
                if (liveHostInfo != null) {
                    this.i.setText(liveHostInfo.name);
                    this.f25689e.setImageURI(liveRoomEntity.hostInfo.avatar);
                }
                if (liveRoomEntity.liveStatus == 0) {
                    this.f25692h.setVisibility(8);
                } else {
                    this.f25692h.setText(e.a(this.n, liveRoomEntity.audienceCount));
                    this.f25692h.setVisibility(0);
                }
                this.m.getLayoutParams().height = a.a(getContext(), 61.0f);
                this.m.setBackground(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080d13));
                if (liveRoomEntity.showTpl == 1) {
                    this.f25689e.setVisibility(0);
                    this.f25691g.setVisibility(0);
                } else {
                    this.f25689e.setVisibility(8);
                    this.f25691g.setVisibility(8);
                    this.i.setTextSize(1, 14.0f);
                    this.i.setTypeface(Typeface.defaultFromStyle(1));
                    this.m.getLayoutParams().height = a.a(getContext(), 35.0f);
                    this.m.setBackground(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080d10));
                }
                RightLableInfo rightLableInfo = liveRoomEntity.rightLabel;
                if (rightLableInfo != null && !TextUtils.isEmpty(rightLableInfo.iconUrl)) {
                    this.j.setImageURI(liveRoomEntity.rightLabel.iconUrl);
                    this.j.setVisibility(0);
                } else {
                    this.j.setVisibility(8);
                }
                if (this.f25736c) {
                    this.f25688d.getHierarchy().setUseGlobalColorFilter(false);
                    this.f25689e.getHierarchy().setUseGlobalColorFilter(false);
                    this.j.getHierarchy().setUseGlobalColorFilter(false);
                }
                e(Config.TRACE_VISIT_RECENT_DAY);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Live4Ratio5ItemView(Context context, AttributeSet attributeSet) {
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
