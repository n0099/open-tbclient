package com.baidu.live.videochat.panel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.lottie.TBLottieAnimationView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {
    private a bHR;
    private Context mContext;
    private List<com.baidu.live.videochat.panel.a.a> mDataList = new ArrayList();

    /* loaded from: classes4.dex */
    public interface a {
        void c(com.baidu.live.videochat.panel.a.a aVar);
    }

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext.getPageActivity();
    }

    public void setData(List<com.baidu.live.videochat.panel.a.a> list) {
        if (!ListUtils.isEmpty(list)) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void D(String str, boolean z) {
        if (!StringUtils.isNull(str)) {
            for (com.baidu.live.videochat.panel.a.a aVar : this.mDataList) {
                if (aVar != null && str.equals(aVar.bIr)) {
                    aVar.bIp = z ? 3 : 0;
                }
            }
            notifyDataSetChanged();
        }
    }

    public void clearData() {
        if (!ListUtils.isEmpty(this.mDataList)) {
            this.mDataList.clear();
            notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.bHR = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mDataList.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: gk */
    public com.baidu.live.videochat.panel.a.a getItem(int i) {
        if (i < getCount()) {
            return this.mDataList.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0228b c0228b;
        if (view == null) {
            C0228b c0228b2 = new C0228b();
            view = LayoutInflater.from(this.mContext).inflate(a.g.video_chat_friend_item_viewl, viewGroup, false);
            c0228b2.bHU = (HeadImageView) view.findViewById(a.f.video_chat_user_header);
            c0228b2.bHU.setIsRound(true);
            c0228b2.bHU.setDrawBorder(true);
            c0228b2.bHU.setBorderWidth(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds1));
            c0228b2.bHU.setBorderColor(this.mContext.getResources().getColor(a.c.sdk_black_alpha10));
            c0228b2.bHU.setAutoChangeStyle(false);
            c0228b2.bHV = (TextView) view.findViewById(a.f.video_chat_user_name);
            c0228b2.bHW = view.findViewById(a.f.video_chat_user_top_divider);
            c0228b2.bHX = view.findViewById(a.f.video_chat_user_bottom_divider);
            c0228b2.bHY = (TBLottieAnimationView) view.findViewById(a.f.video_chat_active_view);
            c0228b2.bHY.setAnimation("video_chat_active_anim.json");
            c0228b2.bHY.loop(true);
            c0228b2.bHZ = (TextView) view.findViewById(a.f.video_chat_status_invite);
            c0228b2.bIa = (TextView) view.findViewById(a.f.video_chat_status_inviting);
            c0228b2.bIb = (TextView) view.findViewById(a.f.video_chat_status_active);
            view.setTag(c0228b2);
            c0228b = c0228b2;
        } else {
            c0228b = (C0228b) view.getTag();
        }
        if (i == getCount() - 1) {
            c0228b.bHX.setVisibility(8);
        } else {
            c0228b.bHX.setVisibility(0);
        }
        if (i == 0) {
            c0228b.bHW.setVisibility(0);
        } else {
            c0228b.bHW.setVisibility(8);
        }
        final com.baidu.live.videochat.panel.a.a item = getItem(i);
        if (item != null) {
            if (StringUtils.isNull(item.portrait)) {
                c0228b.bHU.startLoad("https://error", 12, false);
            } else {
                c0228b.bHU.startLoad(item.portrait, 12, false);
            }
            c0228b.bHV.setText(item.userName);
            if (item.bIp == 0) {
                c0228b.bHZ.setVisibility(0);
                c0228b.bHY.setVisibility(8);
                c0228b.bIa.setVisibility(8);
                c0228b.bIb.setVisibility(8);
            } else if (1 == item.bIp) {
                c0228b.bIa.setVisibility(0);
                c0228b.bHY.setVisibility(8);
                c0228b.bHZ.setVisibility(8);
                c0228b.bIb.setVisibility(8);
            } else if (2 == item.bIp || 3 == item.bIp) {
                c0228b.bIb.setVisibility(0);
                c0228b.bHY.setVisibility(0);
                c0228b.bHY.playAnimation();
                c0228b.bHZ.setVisibility(8);
                c0228b.bIa.setVisibility(8);
            }
        }
        c0228b.bHZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.videochat.panel.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.bHR != null) {
                    b.this.bHR.c(item);
                }
            }
        });
        return view;
    }

    /* renamed from: com.baidu.live.videochat.panel.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class C0228b {
        public HeadImageView bHU;
        public TextView bHV;
        public View bHW;
        public View bHX;
        public TBLottieAnimationView bHY;
        public TextView bHZ;
        public TextView bIa;
        public TextView bIb;

        private C0228b() {
        }
    }
}
