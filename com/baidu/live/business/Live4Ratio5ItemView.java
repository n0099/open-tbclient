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
import c.a.w.b.f.a;
import c.a.w.b.f.e;
import c.a.w.i.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.business.base.LiveBaseItemView;
import com.baidu.live.business.model.data.LeftLableInfo;
import com.baidu.live.business.model.data.LiveHostInfo;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.business.model.data.RightLableInfo;
import com.baidu.live.business.view.LiveStatusAnimView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes4.dex */
public class Live4Ratio5ItemView extends LiveBaseItemView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public SimpleDraweeView f33342f;

    /* renamed from: g  reason: collision with root package name */
    public SimpleDraweeView f33343g;

    /* renamed from: h  reason: collision with root package name */
    public LiveStatusAnimView f33344h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f33345i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f33346j;
    public TextView k;
    public SimpleDraweeView l;
    public FrameLayout m;
    public Context mContext;
    public boolean n;
    public View o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Live4Ratio5ItemView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        this.n = false;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            setNeedRatio(true);
            setAspectRatio(1.25f);
            this.mContext = context;
            View inflate = RelativeLayout.inflate(context, R.layout.live_feed_page_4_5_item_view, this);
            this.m = (FrameLayout) inflate.findViewById(R.id.live_feed_page_item_cover_rect);
            this.f33342f = (SimpleDraweeView) inflate.findViewById(R.id.live_feed_page_item_cover);
            this.f33344h = (LiveStatusAnimView) inflate.findViewById(R.id.live_feed_page_item_lable);
            this.f33345i = (TextView) inflate.findViewById(R.id.live_feed_page_item_title);
            this.f33346j = (TextView) inflate.findViewById(R.id.live_feed_page_item_audience_num);
            this.f33343g = (SimpleDraweeView) inflate.findViewById(R.id.live_feed_page_item_avatar_iv);
            this.k = (TextView) inflate.findViewById(R.id.live_feed_page_item_name);
            this.l = (SimpleDraweeView) inflate.findViewById(R.id.live_feed_page_item_right_lable);
            this.o = inflate.findViewById(R.id.live_feed_page_4_5_mask);
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public ViewGroup getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.m : (ViewGroup) invokeV.objValue;
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void onDarkModeChange(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            SimpleDraweeView simpleDraweeView = this.f33342f;
            if (simpleDraweeView != null) {
                simpleDraweeView.getHierarchy().setPlaceholderImage(f.e().j(this.mIsImmersion), ScalingUtils.ScaleType.FIT_XY);
            }
            SimpleDraweeView simpleDraweeView2 = this.f33343g;
            if (simpleDraweeView2 != null) {
                simpleDraweeView2.getHierarchy().setPlaceholderImage(f.e().j(this.mIsImmersion), ScalingUtils.ScaleType.FIT_XY);
            }
            TextView textView = this.f33345i;
            if (textView != null) {
                textView.setTextColor(f.e().a(getContext(), this.mIsImmersion, "color_white3"));
            }
            TextView textView2 = this.k;
            if (textView2 != null) {
                textView2.setTextColor(f.e().a(getContext(), this.mIsImmersion, "color_white3"));
            }
            TextView textView3 = this.f33346j;
            if (textView3 != null) {
                textView3.setTextColor(f.e().a(getContext(), this.mIsImmersion, "color_white3"));
            }
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void onViewAttached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onViewAttached();
            if (this.n && this.f33344h.isHasAnim()) {
                this.f33344h.startAnim();
            }
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void onViewDetached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onViewDetached();
            LiveStatusAnimView liveStatusAnimView = this.f33344h;
            if (liveStatusAnimView != null) {
                liveStatusAnimView.stopAnim();
            }
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void onViewRecycled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onViewRecycled();
            LiveStatusAnimView liveStatusAnimView = this.f33344h;
            if (liveStatusAnimView != null) {
                liveStatusAnimView.stopAnim();
            }
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void releaseHolder() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.releaseHolder();
            LiveStatusAnimView liveStatusAnimView = this.f33344h;
            if (liveStatusAnimView != null) {
                liveStatusAnimView.stopAnim();
            }
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void setData(LiveRoomEntity liveRoomEntity, int i2) {
        LiveStatusAnimView liveStatusAnimView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, liveRoomEntity, i2) == null) {
            this.f33344h.setIsImmersion(this.mIsImmersion);
            if (liveRoomEntity != null) {
                this.f33342f.setImageURI(liveRoomEntity.cover);
                LeftLableInfo leftLableInfo = liveRoomEntity.leftLabel;
                if (leftLableInfo != null && !TextUtils.isEmpty(leftLableInfo.text) && (liveStatusAnimView = this.f33344h) != null) {
                    int i3 = liveRoomEntity.liveStatus;
                    LeftLableInfo leftLableInfo2 = liveRoomEntity.leftLabel;
                    liveStatusAnimView.setData(i3, leftLableInfo2.text, leftLableInfo2.startColor, leftLableInfo2.endColor);
                    this.n = true;
                    this.f33344h.setVisibility(0);
                } else {
                    this.n = false;
                    LiveStatusAnimView liveStatusAnimView2 = this.f33344h;
                    if (liveStatusAnimView2 != null) {
                        liveStatusAnimView2.setVisibility(8);
                    }
                }
                this.f33345i.setText(liveRoomEntity.title);
                LiveHostInfo liveHostInfo = liveRoomEntity.hostInfo;
                if (liveHostInfo != null) {
                    this.k.setText(liveHostInfo.name);
                    this.f33343g.setImageURI(liveRoomEntity.hostInfo.avatar);
                }
                if (liveRoomEntity.liveStatus == 0) {
                    this.f33346j.setVisibility(8);
                } else {
                    this.f33346j.setText(e.a(this.mContext, liveRoomEntity.audienceCount));
                    this.f33346j.setVisibility(0);
                }
                this.o.getLayoutParams().height = a.a(getContext(), 61.0f);
                this.o.setBackground(getResources().getDrawable(R.drawable.live_feed_page_index_item_bottom_mask_radius_12));
                if (liveRoomEntity.showTpl == 1) {
                    this.f33343g.setVisibility(0);
                    this.f33345i.setVisibility(0);
                } else {
                    this.f33343g.setVisibility(8);
                    this.f33345i.setVisibility(8);
                    this.k.setTextSize(1, 14.0f);
                    this.k.setTypeface(Typeface.defaultFromStyle(1));
                    this.o.getLayoutParams().height = a.a(getContext(), 35.0f);
                    this.o.setBackground(getResources().getDrawable(R.drawable.live_feed_page_haokan_index_item_bottom_mask_radius_12));
                }
                RightLableInfo rightLableInfo = liveRoomEntity.rightLabel;
                if (rightLableInfo != null && !TextUtils.isEmpty(rightLableInfo.iconUrl)) {
                    this.l.setImageURI(liveRoomEntity.rightLabel.iconUrl);
                    this.l.setVisibility(0);
                } else {
                    this.l.setVisibility(8);
                }
                if (this.mIsImmersion) {
                    this.f33342f.getHierarchy().setUseGlobalColorFilter(false);
                    this.f33343g.getHierarchy().setUseGlobalColorFilter(false);
                    this.l.getHierarchy().setUseGlobalColorFilter(false);
                }
                onDarkModeChange("day");
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.n = false;
        a(context);
    }
}
