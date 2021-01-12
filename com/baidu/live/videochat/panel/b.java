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
/* loaded from: classes10.dex */
public class b extends BaseAdapter {
    private a bNa;
    private Context mContext;
    private List<com.baidu.live.videochat.panel.a.a> mDataList = new ArrayList();

    /* loaded from: classes10.dex */
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
                if (aVar != null && str.equals(aVar.bNA)) {
                    aVar.bNy = z ? 3 : 0;
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
        this.bNa = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mDataList.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: fd */
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
        C0226b c0226b;
        if (view == null) {
            C0226b c0226b2 = new C0226b();
            view = LayoutInflater.from(this.mContext).inflate(a.g.video_chat_friend_item_viewl, viewGroup, false);
            c0226b2.bNd = (HeadImageView) view.findViewById(a.f.video_chat_user_header);
            c0226b2.bNd.setIsRound(true);
            c0226b2.bNd.setDrawBorder(true);
            c0226b2.bNd.setBorderWidth(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds1));
            c0226b2.bNd.setBorderColor(this.mContext.getResources().getColor(a.c.sdk_black_alpha10));
            c0226b2.bNd.setAutoChangeStyle(false);
            c0226b2.bNe = (TextView) view.findViewById(a.f.video_chat_user_name);
            c0226b2.bNf = view.findViewById(a.f.video_chat_user_top_divider);
            c0226b2.bNg = view.findViewById(a.f.video_chat_user_bottom_divider);
            c0226b2.bNh = (TBLottieAnimationView) view.findViewById(a.f.video_chat_active_view);
            c0226b2.bNh.setAnimation("video_chat_active_anim.json");
            c0226b2.bNh.loop(true);
            c0226b2.bNi = (TextView) view.findViewById(a.f.video_chat_status_invite);
            c0226b2.bNj = (TextView) view.findViewById(a.f.video_chat_status_inviting);
            c0226b2.bNk = (TextView) view.findViewById(a.f.video_chat_status_active);
            view.setTag(c0226b2);
            c0226b = c0226b2;
        } else {
            c0226b = (C0226b) view.getTag();
        }
        if (i == getCount() - 1) {
            c0226b.bNg.setVisibility(8);
        } else {
            c0226b.bNg.setVisibility(0);
        }
        if (i == 0) {
            c0226b.bNf.setVisibility(0);
        } else {
            c0226b.bNf.setVisibility(8);
        }
        final com.baidu.live.videochat.panel.a.a item = getItem(i);
        if (item != null) {
            if (StringUtils.isNull(item.portrait)) {
                c0226b.bNd.startLoad("https://error", 12, false);
            } else {
                c0226b.bNd.startLoad(item.portrait, 12, false);
            }
            c0226b.bNe.setText(item.userName);
            if (item.bNy == 0) {
                c0226b.bNi.setVisibility(0);
                c0226b.bNh.setVisibility(8);
                c0226b.bNj.setVisibility(8);
                c0226b.bNk.setVisibility(8);
            } else if (1 == item.bNy) {
                c0226b.bNj.setVisibility(0);
                c0226b.bNh.setVisibility(8);
                c0226b.bNi.setVisibility(8);
                c0226b.bNk.setVisibility(8);
            } else if (2 == item.bNy || 3 == item.bNy) {
                c0226b.bNk.setVisibility(0);
                c0226b.bNh.setVisibility(0);
                c0226b.bNh.playAnimation();
                c0226b.bNi.setVisibility(8);
                c0226b.bNj.setVisibility(8);
            }
        }
        c0226b.bNi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.videochat.panel.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.bNa != null) {
                    b.this.bNa.c(item);
                }
            }
        });
        return view;
    }

    /* renamed from: com.baidu.live.videochat.panel.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private static class C0226b {
        public HeadImageView bNd;
        public TextView bNe;
        public View bNf;
        public View bNg;
        public TBLottieAnimationView bNh;
        public TextView bNi;
        public TextView bNj;
        public TextView bNk;

        private C0226b() {
        }
    }
}
