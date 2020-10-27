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
    private a bDV;
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
                if (aVar != null && str.equals(aVar.bEv)) {
                    aVar.bEt = z ? 3 : 0;
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
        this.bDV = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mDataList.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: gd */
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
        C0218b c0218b;
        if (view == null) {
            C0218b c0218b2 = new C0218b();
            view = LayoutInflater.from(this.mContext).inflate(a.h.video_chat_friend_item_viewl, viewGroup, false);
            c0218b2.bDY = (HeadImageView) view.findViewById(a.g.video_chat_user_header);
            c0218b2.bDY.setIsRound(true);
            c0218b2.bDY.setDrawBorder(true);
            c0218b2.bDY.setBorderWidth(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds1));
            c0218b2.bDY.setBorderColor(this.mContext.getResources().getColor(a.d.sdk_black_alpha10));
            c0218b2.bDY.setAutoChangeStyle(false);
            c0218b2.bDZ = (TextView) view.findViewById(a.g.video_chat_user_name);
            c0218b2.bEa = view.findViewById(a.g.video_chat_user_top_divider);
            c0218b2.bEb = view.findViewById(a.g.video_chat_user_bottom_divider);
            c0218b2.bEc = (TBLottieAnimationView) view.findViewById(a.g.video_chat_active_view);
            c0218b2.bEc.setAnimation("video_chat_active_anim.json");
            c0218b2.bEc.loop(true);
            c0218b2.bEd = (TextView) view.findViewById(a.g.video_chat_status_invite);
            c0218b2.bEe = (TextView) view.findViewById(a.g.video_chat_status_inviting);
            c0218b2.bEf = (TextView) view.findViewById(a.g.video_chat_status_active);
            view.setTag(c0218b2);
            c0218b = c0218b2;
        } else {
            c0218b = (C0218b) view.getTag();
        }
        if (i == getCount() - 1) {
            c0218b.bEb.setVisibility(8);
        } else {
            c0218b.bEb.setVisibility(0);
        }
        if (i == 0) {
            c0218b.bEa.setVisibility(0);
        } else {
            c0218b.bEa.setVisibility(8);
        }
        final com.baidu.live.videochat.panel.a.a item = getItem(i);
        if (item != null) {
            if (StringUtils.isNull(item.portrait)) {
                c0218b.bDY.startLoad("https://error", 12, false);
            } else {
                c0218b.bDY.startLoad(item.portrait, 12, false);
            }
            c0218b.bDZ.setText(item.userName);
            if (item.bEt == 0) {
                c0218b.bEd.setVisibility(0);
                c0218b.bEc.setVisibility(8);
                c0218b.bEe.setVisibility(8);
                c0218b.bEf.setVisibility(8);
            } else if (1 == item.bEt) {
                c0218b.bEe.setVisibility(0);
                c0218b.bEc.setVisibility(8);
                c0218b.bEd.setVisibility(8);
                c0218b.bEf.setVisibility(8);
            } else if (2 == item.bEt || 3 == item.bEt) {
                c0218b.bEf.setVisibility(0);
                c0218b.bEc.setVisibility(0);
                c0218b.bEc.playAnimation();
                c0218b.bEd.setVisibility(8);
                c0218b.bEe.setVisibility(8);
            }
        }
        c0218b.bEd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.videochat.panel.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.bDV != null) {
                    b.this.bDV.c(item);
                }
            }
        });
        return view;
    }

    /* renamed from: com.baidu.live.videochat.panel.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class C0218b {
        public HeadImageView bDY;
        public TextView bDZ;
        public View bEa;
        public View bEb;
        public TBLottieAnimationView bEc;
        public TextView bEd;
        public TextView bEe;
        public TextView bEf;

        private C0218b() {
        }
    }
}
