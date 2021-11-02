package com.baidu.live.business;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.w.b.f.a;
import b.a.w.b.f.e;
import b.a.w.c.a.c;
import b.a.w.c.a.d;
import b.a.w.i.f;
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
/* loaded from: classes7.dex */
public class Live16Ratio9ItemView extends LiveBaseItemView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public SimpleDraweeView f38681f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f38682g;

    /* renamed from: h  reason: collision with root package name */
    public float[] f38683h;
    public Context mContext;
    public SimpleDraweeView mCover;
    public TextView mName;
    public TextView mPersonNum;
    public TextView mTitle;
    public SimpleDraweeView mUserAvatar;
    public LiveStatusAnimView mUserLable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Live16Ratio9ItemView(Context context) {
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
        this.f38682g = false;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.mContext = context;
            setNeedRatio(false);
            int c2 = (int) (((a.c(context) - (a.a(context, 12.0f) * 2)) - a.a(context, 7.0f)) / 2.0d);
            View inflate = RelativeLayout.inflate(context, d.live_feed_page_16_9_item_view, this);
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) inflate.findViewById(c.live_feed_page_item_cover);
            this.mCover = simpleDraweeView;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) simpleDraweeView.getLayoutParams();
            layoutParams.width = c2;
            layoutParams.height = (int) ((c2 * 9) / 16.0d);
            this.mCover.setLayoutParams(layoutParams);
            this.mUserLable = (LiveStatusAnimView) inflate.findViewById(c.live_feed_page_item_label);
            this.mTitle = (TextView) inflate.findViewById(c.live_feed_page_item_title);
            this.mName = (TextView) inflate.findViewById(c.live_feed_page_item_name);
            this.mUserAvatar = (SimpleDraweeView) inflate.findViewById(c.live_feed_page_item_avatar_iv);
            this.mPersonNum = (TextView) inflate.findViewById(c.live_feed_page_item_count);
            this.f38681f = (SimpleDraweeView) inflate.findViewById(c.live_feed_page_item_right_lable);
            float a2 = a.a(getContext(), 10.0f);
            this.f38683h = new float[]{a2, a2, a2, a2, a2, a2, a2, a2};
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void onDarkModeChange(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(f.e().a(getContext(), this.mIsImmersion, "color_white2"));
            gradientDrawable.setCornerRadii(this.f38683h);
            setBackgroundDrawable(gradientDrawable);
            SimpleDraweeView simpleDraweeView = this.mCover;
            if (simpleDraweeView != null) {
                simpleDraweeView.getHierarchy().setPlaceholderImage(f.e().j(this.mIsImmersion), ScalingUtils.ScaleType.FIT_XY);
            }
            SimpleDraweeView simpleDraweeView2 = this.mUserAvatar;
            if (simpleDraweeView2 != null) {
                simpleDraweeView2.getHierarchy().setPlaceholderImage(f.e().j(this.mIsImmersion), ScalingUtils.ScaleType.FIT_XY);
            }
            TextView textView = this.mTitle;
            if (textView != null) {
                textView.setTextColor(f.e().a(getContext(), this.mIsImmersion, "color_1F1F1F"));
            }
            TextView textView2 = this.mName;
            if (textView2 != null) {
                textView2.setTextColor(f.e().a(getContext(), this.mIsImmersion, "color_858585"));
            }
            TextView textView3 = this.mPersonNum;
            if (textView3 != null) {
                textView3.setTextColor(f.e().a(getContext(), this.mIsImmersion, "color_858585"));
            }
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void onViewAttached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onViewAttached();
            if (this.f38682g && this.mUserLable.isHasAnim()) {
                this.mUserLable.startAnim();
            }
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void onViewDetached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onViewDetached();
            LiveStatusAnimView liveStatusAnimView = this.mUserLable;
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
            LiveStatusAnimView liveStatusAnimView = this.mUserLable;
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
            LiveStatusAnimView liveStatusAnimView = this.mUserLable;
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
            this.mUserLable.setIsImmersion(this.mIsImmersion);
            if (liveRoomEntity != null) {
                this.mCover.setImageURI(liveRoomEntity.cover);
                LeftLableInfo leftLableInfo = liveRoomEntity.leftLabel;
                if (leftLableInfo != null && !TextUtils.isEmpty(leftLableInfo.text) && (liveStatusAnimView = this.mUserLable) != null) {
                    int i3 = liveRoomEntity.liveStatus;
                    LeftLableInfo leftLableInfo2 = liveRoomEntity.leftLabel;
                    liveStatusAnimView.setData(i3, leftLableInfo2.text, leftLableInfo2.startColor, leftLableInfo2.endColor);
                    this.f38682g = true;
                    this.mUserLable.setVisibility(0);
                } else {
                    this.f38682g = false;
                    LiveStatusAnimView liveStatusAnimView2 = this.mUserLable;
                    if (liveStatusAnimView2 != null) {
                        liveStatusAnimView2.setVisibility(8);
                    }
                }
                this.mTitle.setText(liveRoomEntity.title);
                LiveHostInfo liveHostInfo = liveRoomEntity.hostInfo;
                if (liveHostInfo != null) {
                    this.mName.setText(liveHostInfo.name);
                    this.mUserAvatar.setImageURI(liveRoomEntity.hostInfo.avatar);
                }
                if (liveRoomEntity.liveStatus == 0) {
                    this.mPersonNum.setVisibility(8);
                } else {
                    this.mPersonNum.setText(e.a(this.mContext, liveRoomEntity.audienceCount));
                    this.mPersonNum.setVisibility(0);
                }
                RightLableInfo rightLableInfo = liveRoomEntity.rightLabel;
                if (rightLableInfo != null && !TextUtils.isEmpty(rightLableInfo.iconUrl)) {
                    this.f38681f.setImageURI(liveRoomEntity.rightLabel.iconUrl);
                    this.f38681f.setVisibility(0);
                } else {
                    this.f38681f.setVisibility(8);
                }
                if (this.mIsImmersion) {
                    this.mCover.getHierarchy().setUseGlobalColorFilter(false);
                    this.mUserAvatar.getHierarchy().setUseGlobalColorFilter(false);
                    this.f38681f.getHierarchy().setUseGlobalColorFilter(false);
                }
                onDarkModeChange("day");
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
        this.f38682g = false;
        a(context);
    }
}
