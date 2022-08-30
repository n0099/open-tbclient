package com.baidu.live.feed.search.holder;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.model.data.LiveHostInfo;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.feed.search.view.LiveBaseLottieView;
import com.baidu.tieba.R;
import com.baidu.tieba.bb0;
import com.baidu.tieba.n80;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes2.dex */
public class LiveSearchHotRankItemViewHolder extends RecyclerView.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public final TextView b;
    public final LiveBaseLottieView c;
    public final SimpleDraweeView d;
    public final TextView e;
    public final TextView f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveSearchHotRankItemViewHolder(@NonNull View view2) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = view2;
        this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09239d);
        this.c = (LiveBaseLottieView) view2.findViewById(R.id.obfuscated_res_0x7f091435);
        this.d = (SimpleDraweeView) view2.findViewById(R.id.obfuscated_res_0x7f090fdb);
        this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092379);
        this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092353);
        this.e.setTextColor(bb0.f().a(view2.getContext(), LiveFeedPageSdk.HOST_LIVE_TAB, "color_1F1F1F"));
        this.f.setTextColor(bb0.f().a(view2.getContext(), LiveFeedPageSdk.HOST_LIVE_TAB, "color_858585"));
        if (!"night".equals(bb0.f().q()) && !"dark".equals(bb0.f().q())) {
            this.c.setAnimationFromUrl("https://ala-rmb-gift.bj.bcebos.com/lottie/common/live_feed_page_shinning.json");
        } else {
            this.c.setAnimationFromUrl("https://ala-rmb-gift.bj.bcebos.com/lottie/common/live_feed_page_shinning_night.json");
        }
        this.c.setRepeatCount(-1);
    }

    public void a(LiveRoomEntity liveRoomEntity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, liveRoomEntity) == null) || liveRoomEntity == null) {
            return;
        }
        TextView textView = this.b;
        if (textView != null) {
            textView.setText(String.valueOf(liveRoomEntity.rank));
            int i = liveRoomEntity.rank;
            if (i == 1) {
                this.b.setTextColor("night".equals(bb0.f().q()) ? -8447719 : -52429);
            } else if (i == 2) {
                this.b.setTextColor("night".equals(bb0.f().q()) ? -8375552 : -39424);
            } else if (i != 3) {
                this.b.setTextColor(bb0.f().a(this.a.getContext(), LiveFeedPageSdk.HOST_LIVE_TAB, "color_858585"));
            } else {
                this.b.setTextColor("night".equals(bb0.f().q()) ? -8760559 : -349938);
            }
        }
        if (this.c != null) {
            if (liveRoomEntity.isStatusLiving()) {
                if (!this.c.isAnimating()) {
                    this.c.playAnimation();
                }
            } else {
                b();
            }
        }
        LiveHostInfo liveHostInfo = liveRoomEntity.hostInfo;
        if (liveHostInfo != null) {
            if (this.d != null) {
                if (!TextUtils.isEmpty(liveHostInfo.avatar)) {
                    this.d.setImageURI(liveRoomEntity.hostInfo.avatar);
                } else {
                    d();
                }
            }
            TextView textView2 = this.e;
            if (textView2 != null) {
                String str = liveRoomEntity.hostInfo.name;
                if (str != null) {
                    textView2.setText(str);
                } else {
                    textView2.setText("");
                }
            }
        } else {
            d();
        }
        TextView textView3 = this.f;
        if (textView3 != null) {
            textView3.setText(n80.a(textView3.getContext(), liveRoomEntity.audienceCount));
        }
    }

    public final void b() {
        LiveBaseLottieView liveBaseLottieView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (liveBaseLottieView = this.c) == null) {
            return;
        }
        liveBaseLottieView.cancelAnimation();
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b();
            d();
        }
    }

    public final void d() {
        SimpleDraweeView simpleDraweeView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (simpleDraweeView = this.d) == null) {
            return;
        }
        simpleDraweeView.setImageDrawable(null);
    }
}
