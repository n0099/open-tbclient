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
/* loaded from: classes11.dex */
public class b extends BaseAdapter {
    private a bRM;
    private Context mContext;
    private List<com.baidu.live.videochat.panel.a.a> mDataList = new ArrayList();

    /* loaded from: classes11.dex */
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

    public void E(String str, boolean z) {
        if (!StringUtils.isNull(str)) {
            for (com.baidu.live.videochat.panel.a.a aVar : this.mDataList) {
                if (aVar != null && str.equals(aVar.bSm)) {
                    aVar.bSk = z ? 3 : 0;
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
        this.bRM = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mDataList.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: gK */
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
        C0235b c0235b;
        if (view == null) {
            C0235b c0235b2 = new C0235b();
            view = LayoutInflater.from(this.mContext).inflate(a.g.video_chat_friend_item_viewl, viewGroup, false);
            c0235b2.bRP = (HeadImageView) view.findViewById(a.f.video_chat_user_header);
            c0235b2.bRP.setIsRound(true);
            c0235b2.bRP.setDrawBorder(true);
            c0235b2.bRP.setBorderWidth(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds1));
            c0235b2.bRP.setBorderColor(this.mContext.getResources().getColor(a.c.sdk_black_alpha10));
            c0235b2.bRP.setAutoChangeStyle(false);
            c0235b2.bRQ = (TextView) view.findViewById(a.f.video_chat_user_name);
            c0235b2.bRR = view.findViewById(a.f.video_chat_user_top_divider);
            c0235b2.bRS = view.findViewById(a.f.video_chat_user_bottom_divider);
            c0235b2.bRT = (TBLottieAnimationView) view.findViewById(a.f.video_chat_active_view);
            c0235b2.bRT.setAnimation("video_chat_active_anim.json");
            c0235b2.bRT.loop(true);
            c0235b2.bRU = (TextView) view.findViewById(a.f.video_chat_status_invite);
            c0235b2.bRV = (TextView) view.findViewById(a.f.video_chat_status_inviting);
            c0235b2.bRW = (TextView) view.findViewById(a.f.video_chat_status_active);
            view.setTag(c0235b2);
            c0235b = c0235b2;
        } else {
            c0235b = (C0235b) view.getTag();
        }
        if (i == getCount() - 1) {
            c0235b.bRS.setVisibility(8);
        } else {
            c0235b.bRS.setVisibility(0);
        }
        if (i == 0) {
            c0235b.bRR.setVisibility(0);
        } else {
            c0235b.bRR.setVisibility(8);
        }
        final com.baidu.live.videochat.panel.a.a item = getItem(i);
        if (item != null) {
            if (StringUtils.isNull(item.portrait)) {
                c0235b.bRP.startLoad("https://error", 12, false);
            } else {
                c0235b.bRP.startLoad(item.portrait, 12, false);
            }
            c0235b.bRQ.setText(item.userName);
            if (item.bSk == 0) {
                c0235b.bRU.setVisibility(0);
                c0235b.bRT.setVisibility(8);
                c0235b.bRV.setVisibility(8);
                c0235b.bRW.setVisibility(8);
            } else if (1 == item.bSk) {
                c0235b.bRV.setVisibility(0);
                c0235b.bRT.setVisibility(8);
                c0235b.bRU.setVisibility(8);
                c0235b.bRW.setVisibility(8);
            } else if (2 == item.bSk || 3 == item.bSk) {
                c0235b.bRW.setVisibility(0);
                c0235b.bRT.setVisibility(0);
                c0235b.bRT.playAnimation();
                c0235b.bRU.setVisibility(8);
                c0235b.bRV.setVisibility(8);
            }
        }
        c0235b.bRU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.videochat.panel.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.bRM != null) {
                    b.this.bRM.c(item);
                }
            }
        });
        return view;
    }

    /* renamed from: com.baidu.live.videochat.panel.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private static class C0235b {
        public HeadImageView bRP;
        public TextView bRQ;
        public View bRR;
        public View bRS;
        public TBLottieAnimationView bRT;
        public TextView bRU;
        public TextView bRV;
        public TextView bRW;

        private C0235b() {
        }
    }
}
