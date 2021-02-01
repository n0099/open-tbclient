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
/* loaded from: classes11.dex */
public class a extends BaseAdapter {
    private List<com.baidu.live.talentshow.b.d> bDF = new ArrayList();
    private InterfaceC0202a bDG;

    /* renamed from: com.baidu.live.talentshow.components.selector.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0202a {
        void c(com.baidu.live.talentshow.b.d dVar);
    }

    public void setDatas(List<com.baidu.live.talentshow.b.d> list) {
        if (list != null) {
            this.bDF.clear();
            this.bDF.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void clearData() {
        if (!ListUtils.isEmpty(this.bDF)) {
            this.bDF.clear();
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bDF == null) {
            return 0;
        }
        return this.bDF.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: eg */
    public com.baidu.live.talentshow.b.d getItem(int i) {
        if (this.bDF == null) {
            return null;
        }
        return this.bDF.get(i);
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
            bVar2.bDK = (HeadImageView) view.findViewById(a.f.talent_item_user_head);
            bVar2.bDK.setIsRound(true);
            bVar2.bDK.setScaleType(ImageView.ScaleType.CENTER_CROP);
            bVar2.bDJ = (TBLottieAnimationView) view.findViewById(a.f.lottie_loading);
            bVar2.bDL = (TextView) view.findViewById(a.f.tv_user_nickname);
            bVar2.bDM = (TextView) view.findViewById(a.f.tv_confirm);
            bVar2.bDJ.setRepeatCount(-1);
            bVar2.bDJ.setAnimation("live_rtc_connect.json");
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        final com.baidu.live.talentshow.b.d item = getItem(i);
        item.itemPosition = i;
        bVar.bDL.setText(com.baidu.live.videochat.d.K(item.nickName, 16));
        bVar.bDK.startLoad(item.portrait, 12, false);
        a(item.status, bVar.bDM, bVar.bDJ);
        bVar.bDM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.talentshow.components.selector.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!UtilHelper.isFastDoubleClick() && a.this.bDG != null) {
                    a.this.bDG.c(item);
                }
            }
        });
        return view;
    }

    /* loaded from: classes11.dex */
    public static class b {
        private TBLottieAnimationView bDJ;
        private HeadImageView bDK;
        private TextView bDL;
        private TextView bDM;
    }

    private void a(int i, TextView textView, TBLottieAnimationView tBLottieAnimationView) {
        if (textView != null && tBLottieAnimationView != null) {
            if (i == com.baidu.live.talentshow.d.d.bFG) {
                b(tBLottieAnimationView);
                c(textView);
            } else if (i == com.baidu.live.talentshow.d.d.bFK || i == com.baidu.live.talentshow.d.d.bFJ) {
                a(tBLottieAnimationView);
                d(textView);
            } else if (i == 5) {
                b(tBLottieAnimationView);
                e(textView);
            } else if (i == com.baidu.live.talentshow.d.d.bFH || i == com.baidu.live.talentshow.d.d.bFI) {
                b(tBLottieAnimationView);
                f(textView);
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

    private void c(TextView textView) {
        textView.setText(a.h.talent_chat_confirm);
        a(textView, true, a.e.talent_item_confirm_enable_bg, "#FFFFFFFF");
    }

    public void d(TextView textView) {
        textView.setText(a.h.talent_chat_connecting);
        a(textView, false, a.e.talent_item_connecting_bg, "#FF1E65");
    }

    public void e(TextView textView) {
        textView.setText(a.h.talent_chat_confirm);
        a(textView, true, a.e.talent_item_confirm_disable_bg, "#B8B8B8");
    }

    public void f(TextView textView) {
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

    public void a(InterfaceC0202a interfaceC0202a) {
        this.bDG = interfaceC0202a;
    }
}
