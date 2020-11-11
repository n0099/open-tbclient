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
    private a bJC;
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
                if (aVar != null && str.equals(aVar.bKc)) {
                    aVar.bKa = z ? 3 : 0;
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
        this.bJC = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mDataList.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: gp */
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
        C0230b c0230b;
        if (view == null) {
            C0230b c0230b2 = new C0230b();
            view = LayoutInflater.from(this.mContext).inflate(a.g.video_chat_friend_item_viewl, viewGroup, false);
            c0230b2.bJF = (HeadImageView) view.findViewById(a.f.video_chat_user_header);
            c0230b2.bJF.setIsRound(true);
            c0230b2.bJF.setDrawBorder(true);
            c0230b2.bJF.setBorderWidth(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds1));
            c0230b2.bJF.setBorderColor(this.mContext.getResources().getColor(a.c.sdk_black_alpha10));
            c0230b2.bJF.setAutoChangeStyle(false);
            c0230b2.bJG = (TextView) view.findViewById(a.f.video_chat_user_name);
            c0230b2.bJH = view.findViewById(a.f.video_chat_user_top_divider);
            c0230b2.bJI = view.findViewById(a.f.video_chat_user_bottom_divider);
            c0230b2.bJJ = (TBLottieAnimationView) view.findViewById(a.f.video_chat_active_view);
            c0230b2.bJJ.setAnimation("video_chat_active_anim.json");
            c0230b2.bJJ.loop(true);
            c0230b2.bJK = (TextView) view.findViewById(a.f.video_chat_status_invite);
            c0230b2.bJL = (TextView) view.findViewById(a.f.video_chat_status_inviting);
            c0230b2.bJM = (TextView) view.findViewById(a.f.video_chat_status_active);
            view.setTag(c0230b2);
            c0230b = c0230b2;
        } else {
            c0230b = (C0230b) view.getTag();
        }
        if (i == getCount() - 1) {
            c0230b.bJI.setVisibility(8);
        } else {
            c0230b.bJI.setVisibility(0);
        }
        if (i == 0) {
            c0230b.bJH.setVisibility(0);
        } else {
            c0230b.bJH.setVisibility(8);
        }
        final com.baidu.live.videochat.panel.a.a item = getItem(i);
        if (item != null) {
            if (StringUtils.isNull(item.portrait)) {
                c0230b.bJF.startLoad("https://error", 12, false);
            } else {
                c0230b.bJF.startLoad(item.portrait, 12, false);
            }
            c0230b.bJG.setText(item.userName);
            if (item.bKa == 0) {
                c0230b.bJK.setVisibility(0);
                c0230b.bJJ.setVisibility(8);
                c0230b.bJL.setVisibility(8);
                c0230b.bJM.setVisibility(8);
            } else if (1 == item.bKa) {
                c0230b.bJL.setVisibility(0);
                c0230b.bJJ.setVisibility(8);
                c0230b.bJK.setVisibility(8);
                c0230b.bJM.setVisibility(8);
            } else if (2 == item.bKa || 3 == item.bKa) {
                c0230b.bJM.setVisibility(0);
                c0230b.bJJ.setVisibility(0);
                c0230b.bJJ.playAnimation();
                c0230b.bJK.setVisibility(8);
                c0230b.bJL.setVisibility(8);
            }
        }
        c0230b.bJK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.videochat.panel.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.bJC != null) {
                    b.this.bJC.c(item);
                }
            }
        });
        return view;
    }

    /* renamed from: com.baidu.live.videochat.panel.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class C0230b {
        public HeadImageView bJF;
        public TextView bJG;
        public View bJH;
        public View bJI;
        public TBLottieAnimationView bJJ;
        public TextView bJK;
        public TextView bJL;
        public TextView bJM;

        private C0230b() {
        }
    }
}
