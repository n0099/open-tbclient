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
    private a bMZ;
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

    public void E(String str, boolean z) {
        if (!StringUtils.isNull(str)) {
            for (com.baidu.live.videochat.panel.a.a aVar : this.mDataList) {
                if (aVar != null && str.equals(aVar.bNz)) {
                    aVar.bNx = z ? 3 : 0;
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
        this.bMZ = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mDataList.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: gJ */
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
        C0237b c0237b;
        if (view == null) {
            C0237b c0237b2 = new C0237b();
            view = LayoutInflater.from(this.mContext).inflate(a.g.video_chat_friend_item_viewl, viewGroup, false);
            c0237b2.bNc = (HeadImageView) view.findViewById(a.f.video_chat_user_header);
            c0237b2.bNc.setIsRound(true);
            c0237b2.bNc.setDrawBorder(true);
            c0237b2.bNc.setBorderWidth(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds1));
            c0237b2.bNc.setBorderColor(this.mContext.getResources().getColor(a.c.sdk_black_alpha10));
            c0237b2.bNc.setAutoChangeStyle(false);
            c0237b2.bNd = (TextView) view.findViewById(a.f.video_chat_user_name);
            c0237b2.bNe = view.findViewById(a.f.video_chat_user_top_divider);
            c0237b2.bNf = view.findViewById(a.f.video_chat_user_bottom_divider);
            c0237b2.bNg = (TBLottieAnimationView) view.findViewById(a.f.video_chat_active_view);
            c0237b2.bNg.setAnimation("video_chat_active_anim.json");
            c0237b2.bNg.loop(true);
            c0237b2.bNh = (TextView) view.findViewById(a.f.video_chat_status_invite);
            c0237b2.bNi = (TextView) view.findViewById(a.f.video_chat_status_inviting);
            c0237b2.bNj = (TextView) view.findViewById(a.f.video_chat_status_active);
            view.setTag(c0237b2);
            c0237b = c0237b2;
        } else {
            c0237b = (C0237b) view.getTag();
        }
        if (i == getCount() - 1) {
            c0237b.bNf.setVisibility(8);
        } else {
            c0237b.bNf.setVisibility(0);
        }
        if (i == 0) {
            c0237b.bNe.setVisibility(0);
        } else {
            c0237b.bNe.setVisibility(8);
        }
        final com.baidu.live.videochat.panel.a.a item = getItem(i);
        if (item != null) {
            if (StringUtils.isNull(item.portrait)) {
                c0237b.bNc.startLoad("https://error", 12, false);
            } else {
                c0237b.bNc.startLoad(item.portrait, 12, false);
            }
            c0237b.bNd.setText(item.userName);
            if (item.bNx == 0) {
                c0237b.bNh.setVisibility(0);
                c0237b.bNg.setVisibility(8);
                c0237b.bNi.setVisibility(8);
                c0237b.bNj.setVisibility(8);
            } else if (1 == item.bNx) {
                c0237b.bNi.setVisibility(0);
                c0237b.bNg.setVisibility(8);
                c0237b.bNh.setVisibility(8);
                c0237b.bNj.setVisibility(8);
            } else if (2 == item.bNx || 3 == item.bNx) {
                c0237b.bNj.setVisibility(0);
                c0237b.bNg.setVisibility(0);
                c0237b.bNg.playAnimation();
                c0237b.bNh.setVisibility(8);
                c0237b.bNi.setVisibility(8);
            }
        }
        c0237b.bNh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.videochat.panel.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.bMZ != null) {
                    b.this.bMZ.c(item);
                }
            }
        });
        return view;
    }

    /* renamed from: com.baidu.live.videochat.panel.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class C0237b {
        public HeadImageView bNc;
        public TextView bNd;
        public View bNe;
        public View bNf;
        public TBLottieAnimationView bNg;
        public TextView bNh;
        public TextView bNi;
        public TextView bNj;

        private C0237b() {
        }
    }
}
