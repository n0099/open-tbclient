package com.baidu.live.talentshow.components.selector;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.lottie.TBLottieAnimationView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private List<com.baidu.live.talentshow.b.d> bzY = new ArrayList();
    private InterfaceC0211a bzZ;

    /* renamed from: com.baidu.live.talentshow.components.selector.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0211a {
        void c(com.baidu.live.talentshow.b.d dVar);
    }

    public void setDatas(List<com.baidu.live.talentshow.b.d> list) {
        if (list != null) {
            this.bzY.clear();
            this.bzY.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void clearData() {
        if (!ListUtils.isEmpty(this.bzY)) {
            this.bzY.clear();
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bzY == null) {
            return 0;
        }
        return this.bzY.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: fH */
    public com.baidu.live.talentshow.b.d getItem(int i) {
        if (this.bzY == null) {
            return null;
        }
        return this.bzY.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(a.g.talent_apply_chat_user_item, viewGroup, false);
            b bVar2 = new b();
            bVar2.bAd = (HeadImageView) view.findViewById(a.f.talent_item_user_head);
            bVar2.bAd.setIsRound(true);
            bVar2.bAd.setScaleType(ImageView.ScaleType.CENTER_CROP);
            bVar2.bAc = (TBLottieAnimationView) view.findViewById(a.f.lottie_loading);
            bVar2.bAe = (TextView) view.findViewById(a.f.tv_user_nickname);
            bVar2.bAf = (TextView) view.findViewById(a.f.tv_confirm);
            bVar2.bAc.setRepeatCount(-1);
            bVar2.bAc.setAnimation("live_rtc_connect.json");
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        final com.baidu.live.talentshow.b.d item = getItem(i);
        item.bBF = i;
        bVar.bAe.setText(com.baidu.live.videochat.d.H(item.nickName, 16));
        bVar.bAd.startLoad(item.portrait, 12, false);
        a(item.status, bVar.bAf, bVar.bAc);
        bVar.bAf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.talentshow.components.selector.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!UtilHelper.isFastDoubleClick() && a.this.bzZ != null) {
                    a.this.bzZ.c(item);
                }
            }
        });
        return view;
    }

    /* loaded from: classes4.dex */
    public static class b {
        private TBLottieAnimationView bAc;
        private HeadImageView bAd;
        private TextView bAe;
        private TextView bAf;
    }

    private void a(int i, TextView textView, TBLottieAnimationView tBLottieAnimationView) {
        if (textView != null && tBLottieAnimationView != null) {
            if (i == com.baidu.live.talentshow.d.d.bBW) {
                b(tBLottieAnimationView);
                a(textView);
            } else if (i == com.baidu.live.talentshow.d.d.bCa || i == com.baidu.live.talentshow.d.d.bBZ) {
                a(tBLottieAnimationView);
                b(textView);
            } else if (i == 5) {
                b(tBLottieAnimationView);
                c(textView);
            } else if (i == com.baidu.live.talentshow.d.d.bBX || i == com.baidu.live.talentshow.d.d.bBY) {
                b(tBLottieAnimationView);
                d(textView);
            }
        }
    }

    public void a(TBLottieAnimationView tBLottieAnimationView) {
        if (tBLottieAnimationView != null) {
            tBLottieAnimationView.setVisibility(0);
            tBLottieAnimationView.playAnimation();
        }
    }

    public void b(TBLottieAnimationView tBLottieAnimationView) {
        if (tBLottieAnimationView != null) {
            if (tBLottieAnimationView.isAnimating()) {
                tBLottieAnimationView.cancelAnimation();
            }
            tBLottieAnimationView.setVisibility(8);
        }
    }

    private void a(TextView textView) {
        textView.setText(a.h.talent_chat_confirm);
        a(textView, true, a.e.talent_item_confirm_enable_bg, "#FFFFFFFF");
    }

    public void b(TextView textView) {
        textView.setText(a.h.talent_chat_connecting);
        a(textView, false, a.e.talent_item_connecting_bg, "#FF1E65");
    }

    public void c(TextView textView) {
        textView.setText(a.h.talent_chat_confirm);
        a(textView, true, a.e.talent_item_confirm_disable_bg, "#B8B8B8");
    }

    public void d(TextView textView) {
        textView.setText(a.h.talent_chat_confirming);
        a(textView, false, a.e.talent_item_connecting_bg, "#FF1E65");
    }

    public void a(TextView textView, boolean z, int i, String str) {
        if (textView != null) {
            textView.setBackgroundResource(i);
            textView.setEnabled(z);
            textView.setTextColor(Color.parseColor(str));
        }
    }

    public void a(InterfaceC0211a interfaceC0211a) {
        this.bzZ = interfaceC0211a;
    }
}
