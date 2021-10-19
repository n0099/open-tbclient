package com.baidu.live.business;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.w.b.f.e;
import c.a.w.c.a.c;
import c.a.w.c.a.d;
import c.a.w.i.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.business.base.LiveBaseItemView;
import com.baidu.live.business.model.data.LeftLableInfo;
import com.baidu.live.business.model.data.LiveHostInfo;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.business.model.data.RightLableInfo;
import com.baidu.live.business.view.LiveStatusAnimView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes5.dex */
public class Live4Ratio5ItemView extends LiveBaseItemView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public SimpleDraweeView f40795f;

    /* renamed from: g  reason: collision with root package name */
    public SimpleDraweeView f40796g;

    /* renamed from: h  reason: collision with root package name */
    public LiveStatusAnimView f40797h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f40798i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f40799j;
    public TextView k;
    public SimpleDraweeView l;
    public boolean m;
    public Context mContext;

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
        this.m = false;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            setNeedRatio(true);
            setAspectRatio(1.25f);
            this.mContext = context;
            View inflate = RelativeLayout.inflate(context, d.live_feed_page_4_5_item_view, this);
            this.f40795f = (SimpleDraweeView) inflate.findViewById(c.live_feed_page_item_cover);
            this.f40797h = (LiveStatusAnimView) inflate.findViewById(c.live_feed_page_item_lable);
            this.f40798i = (TextView) inflate.findViewById(c.live_feed_page_item_title);
            this.f40799j = (TextView) inflate.findViewById(c.live_feed_page_item_audience_num);
            this.f40796g = (SimpleDraweeView) inflate.findViewById(c.live_feed_page_item_avatar_iv);
            this.k = (TextView) inflate.findViewById(c.live_feed_page_item_name);
            this.l = (SimpleDraweeView) inflate.findViewById(c.live_feed_page_item_right_lable);
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void onDarkModeChange(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            SimpleDraweeView simpleDraweeView = this.f40795f;
            if (simpleDraweeView != null) {
                simpleDraweeView.getHierarchy().setPlaceholderImage(f.e().j(this.mIsImmersion), ScalingUtils.ScaleType.FIT_XY);
            }
            SimpleDraweeView simpleDraweeView2 = this.f40796g;
            if (simpleDraweeView2 != null) {
                simpleDraweeView2.getHierarchy().setPlaceholderImage(f.e().j(this.mIsImmersion), ScalingUtils.ScaleType.FIT_XY);
            }
            TextView textView = this.f40798i;
            if (textView != null) {
                textView.setTextColor(f.e().a(getContext(), this.mIsImmersion, "color_white3"));
            }
            TextView textView2 = this.k;
            if (textView2 != null) {
                textView2.setTextColor(f.e().a(getContext(), this.mIsImmersion, "color_white3"));
            }
            TextView textView3 = this.f40799j;
            if (textView3 != null) {
                textView3.setTextColor(f.e().a(getContext(), this.mIsImmersion, "color_white3"));
            }
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void onViewAttached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onViewAttached();
            if (this.m && this.f40797h.isHasAnim()) {
                this.f40797h.startAnim();
            }
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void onViewDetached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onViewDetached();
            LiveStatusAnimView liveStatusAnimView = this.f40797h;
            if (liveStatusAnimView != null) {
                liveStatusAnimView.stopAnim();
            }
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void onViewRecycled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onViewRecycled();
            LiveStatusAnimView liveStatusAnimView = this.f40797h;
            if (liveStatusAnimView != null) {
                liveStatusAnimView.stopAnim();
            }
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void releaseHolder() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.releaseHolder();
            LiveStatusAnimView liveStatusAnimView = this.f40797h;
            if (liveStatusAnimView != null) {
                liveStatusAnimView.stopAnim();
            }
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void setData(LiveRoomEntity liveRoomEntity, int i2) {
        LiveStatusAnimView liveStatusAnimView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, liveRoomEntity, i2) == null) {
            this.f40797h.setIsImmersion(this.mIsImmersion);
            if (liveRoomEntity != null) {
                this.f40795f.setImageURI(liveRoomEntity.cover);
                LeftLableInfo leftLableInfo = liveRoomEntity.leftLabel;
                if (leftLableInfo != null && !TextUtils.isEmpty(leftLableInfo.text) && (liveStatusAnimView = this.f40797h) != null) {
                    int i3 = liveRoomEntity.liveStatus;
                    LeftLableInfo leftLableInfo2 = liveRoomEntity.leftLabel;
                    liveStatusAnimView.setData(i3, leftLableInfo2.text, leftLableInfo2.startColor, leftLableInfo2.endColor);
                    this.m = true;
                    this.f40797h.setVisibility(0);
                } else {
                    this.m = false;
                    LiveStatusAnimView liveStatusAnimView2 = this.f40797h;
                    if (liveStatusAnimView2 != null) {
                        liveStatusAnimView2.setVisibility(8);
                    }
                }
                this.f40798i.setText(liveRoomEntity.title);
                LiveHostInfo liveHostInfo = liveRoomEntity.hostInfo;
                if (liveHostInfo != null) {
                    this.k.setText(liveHostInfo.name);
                    this.f40796g.setImageURI(liveRoomEntity.hostInfo.avatar);
                }
                if (liveRoomEntity.liveStatus == 0) {
                    this.f40799j.setVisibility(8);
                } else {
                    this.f40799j.setText(e.a(this.mContext, liveRoomEntity.audienceCount));
                    this.f40799j.setVisibility(0);
                }
                if (liveRoomEntity.showTpl == 1) {
                    this.f40796g.setVisibility(0);
                    this.f40798i.setVisibility(0);
                } else {
                    this.f40796g.setVisibility(8);
                    this.f40798i.setVisibility(8);
                }
                RightLableInfo rightLableInfo = liveRoomEntity.rightLabel;
                if (rightLableInfo != null && !TextUtils.isEmpty(rightLableInfo.iconUrl)) {
                    this.l.setImageURI(liveRoomEntity.rightLabel.iconUrl);
                    this.l.setVisibility(0);
                } else {
                    this.l.setVisibility(8);
                }
                if (this.mIsImmersion) {
                    this.f40795f.getHierarchy().setUseGlobalColorFilter(false);
                    this.f40796g.getHierarchy().setUseGlobalColorFilter(false);
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
        this.m = false;
        a(context);
    }
}
