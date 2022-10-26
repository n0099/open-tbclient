package com.baidu.live.feed.search.holder;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.model.data.LiveHostInfo;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.feed.search.view.LiveBaseLottieView;
import com.baidu.tieba.R;
import com.baidu.tieba.ea0;
import com.baidu.tieba.vc0;
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
    public LiveSearchHotRankItemViewHolder(View view2) {
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
        this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0923e4);
        this.c = (LiveBaseLottieView) view2.findViewById(R.id.obfuscated_res_0x7f09144b);
        this.d = (SimpleDraweeView) view2.findViewById(R.id.obfuscated_res_0x7f090feb);
        this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0923c0);
        this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092399);
        this.e.setTextColor(vc0.f().a(view2.getContext(), LiveFeedPageSdk.HOST_LIVE_TAB, "color_1F1F1F"));
        this.f.setTextColor(vc0.f().a(view2.getContext(), LiveFeedPageSdk.HOST_LIVE_TAB, "color_858585"));
        if (!"night".equals(vc0.f().r()) && !"dark".equals(vc0.f().r())) {
            this.c.setAnimationFromUrl("https://ala-rmb-gift.bj.bcebos.com/lottie/common/live_feed_page_shinning.json");
        } else {
            this.c.setAnimationFromUrl("https://ala-rmb-gift.bj.bcebos.com/lottie/common/live_feed_page_shinning_night.json");
        }
        this.c.setRepeatCount(-1);
    }

    public void a(LiveRoomEntity liveRoomEntity) {
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, liveRoomEntity) != null) || liveRoomEntity == null) {
            return;
        }
        TextView textView = this.b;
        if (textView != null) {
            textView.setText(String.valueOf(liveRoomEntity.rank));
            int i4 = liveRoomEntity.rank;
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        this.b.setTextColor(vc0.f().a(this.a.getContext(), LiveFeedPageSdk.HOST_LIVE_TAB, "color_858585"));
                    } else {
                        TextView textView2 = this.b;
                        if ("night".equals(vc0.f().r())) {
                            i3 = -8760559;
                        } else {
                            i3 = -349938;
                        }
                        textView2.setTextColor(i3);
                    }
                } else {
                    TextView textView3 = this.b;
                    if ("night".equals(vc0.f().r())) {
                        i2 = -8375552;
                    } else {
                        i2 = -39424;
                    }
                    textView3.setTextColor(i2);
                }
            } else {
                TextView textView4 = this.b;
                if ("night".equals(vc0.f().r())) {
                    i = -8447719;
                } else {
                    i = -52429;
                }
                textView4.setTextColor(i);
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
            TextView textView5 = this.e;
            if (textView5 != null) {
                String str = liveRoomEntity.hostInfo.name;
                if (str != null) {
                    textView5.setText(str);
                } else {
                    textView5.setText("");
                }
            }
        } else {
            d();
        }
        TextView textView6 = this.f;
        if (textView6 != null) {
            textView6.setText(ea0.a(textView6.getContext(), liveRoomEntity.audienceCount));
        }
    }

    public final void b() {
        LiveBaseLottieView liveBaseLottieView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (liveBaseLottieView = this.c) != null) {
            liveBaseLottieView.cancelAnimation();
        }
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
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (simpleDraweeView = this.d) != null) {
            simpleDraweeView.setImageDrawable(null);
        }
    }
}
