package com.baidu.live.feed.search.holder;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.model.data.LiveHostInfo;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.feed.search.view.LiveBaseLottieView;
import com.baidu.tieba.R;
import com.baidu.tieba.fd0;
import com.baidu.tieba.oa0;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes3.dex */
public class LiveSearchHotRankItemViewHolder extends RecyclerView.ViewHolder {
    public View a;
    public final TextView b;
    public final LiveBaseLottieView c;
    public final SimpleDraweeView d;
    public final TextView e;
    public final TextView f;

    public LiveSearchHotRankItemViewHolder(@NonNull View view2) {
        super(view2);
        this.a = view2;
        this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092765);
        this.c = (LiveBaseLottieView) view2.findViewById(R.id.obfuscated_res_0x7f091678);
        this.d = (SimpleDraweeView) view2.findViewById(R.id.obfuscated_res_0x7f0911f4);
        this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092740);
        this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092713);
        this.e.setTextColor(fd0.f().a(view2.getContext(), LiveFeedPageSdk.HOST_LIVE_TAB, "color_1F1F1F"));
        this.f.setTextColor(fd0.f().a(view2.getContext(), LiveFeedPageSdk.HOST_LIVE_TAB, "color_858585"));
        if (!"night".equals(fd0.f().r()) && !"dark".equals(fd0.f().r())) {
            this.c.setAnimationFromUrl("https://ala-rmb-gift.bj.bcebos.com/lottie/common/live_feed_page_shinning.json");
        } else {
            this.c.setAnimationFromUrl("https://ala-rmb-gift.bj.bcebos.com/lottie/common/live_feed_page_shinning_night.json");
        }
        this.c.setRepeatCount(-1);
    }

    public void b(LiveRoomEntity liveRoomEntity) {
        int i;
        int i2;
        int i3;
        if (liveRoomEntity == null) {
            return;
        }
        TextView textView = this.b;
        if (textView != null) {
            textView.setText(String.valueOf(liveRoomEntity.rank));
            int i4 = liveRoomEntity.rank;
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        this.b.setTextColor(fd0.f().a(this.a.getContext(), LiveFeedPageSdk.HOST_LIVE_TAB, "color_858585"));
                    } else {
                        TextView textView2 = this.b;
                        if ("night".equals(fd0.f().r())) {
                            i3 = -8760559;
                        } else {
                            i3 = -349938;
                        }
                        textView2.setTextColor(i3);
                    }
                } else {
                    TextView textView3 = this.b;
                    if ("night".equals(fd0.f().r())) {
                        i2 = -8375552;
                    } else {
                        i2 = -39424;
                    }
                    textView3.setTextColor(i2);
                }
            } else {
                TextView textView4 = this.b;
                if ("night".equals(fd0.f().r())) {
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
                c();
            }
        }
        LiveHostInfo liveHostInfo = liveRoomEntity.hostInfo;
        if (liveHostInfo != null) {
            if (this.d != null) {
                if (!TextUtils.isEmpty(liveHostInfo.avatar)) {
                    this.d.setImageURI(liveRoomEntity.hostInfo.avatar);
                } else {
                    e();
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
            e();
        }
        TextView textView6 = this.f;
        if (textView6 != null) {
            textView6.setText(oa0.a(textView6.getContext(), liveRoomEntity.audienceCount));
        }
    }

    public final void c() {
        LiveBaseLottieView liveBaseLottieView = this.c;
        if (liveBaseLottieView != null) {
            liveBaseLottieView.cancelAnimation();
        }
    }

    public void d() {
        c();
        e();
    }

    public final void e() {
        SimpleDraweeView simpleDraweeView = this.d;
        if (simpleDraweeView != null) {
            simpleDraweeView.setImageDrawable(null);
        }
    }
}
