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
    private a bSq;
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
                if (aVar != null && str.equals(aVar.bSQ)) {
                    aVar.bSO = z ? 3 : 0;
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
        this.bSq = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mDataList.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: fi */
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
        C0234b c0234b;
        if (view == null) {
            C0234b c0234b2 = new C0234b();
            view = LayoutInflater.from(this.mContext).inflate(a.g.video_chat_friend_item_viewl, viewGroup, false);
            c0234b2.bSt = (HeadImageView) view.findViewById(a.f.video_chat_user_header);
            c0234b2.bSt.setIsRound(true);
            c0234b2.bSt.setDrawBorder(true);
            c0234b2.bSt.setBorderWidth(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds1));
            c0234b2.bSt.setBorderColor(this.mContext.getResources().getColor(a.c.sdk_black_alpha10));
            c0234b2.bSt.setAutoChangeStyle(false);
            c0234b2.bSu = (TextView) view.findViewById(a.f.video_chat_user_name);
            c0234b2.bSv = view.findViewById(a.f.video_chat_user_top_divider);
            c0234b2.bSw = view.findViewById(a.f.video_chat_user_bottom_divider);
            c0234b2.bSx = (TBLottieAnimationView) view.findViewById(a.f.video_chat_active_view);
            c0234b2.bSx.setAnimation("video_chat_active_anim.json");
            c0234b2.bSx.loop(true);
            c0234b2.bSy = (TextView) view.findViewById(a.f.video_chat_status_invite);
            c0234b2.bSz = (TextView) view.findViewById(a.f.video_chat_status_inviting);
            c0234b2.bSA = (TextView) view.findViewById(a.f.video_chat_status_active);
            view.setTag(c0234b2);
            c0234b = c0234b2;
        } else {
            c0234b = (C0234b) view.getTag();
        }
        if (i == getCount() - 1) {
            c0234b.bSw.setVisibility(8);
        } else {
            c0234b.bSw.setVisibility(0);
        }
        if (i == 0) {
            c0234b.bSv.setVisibility(0);
        } else {
            c0234b.bSv.setVisibility(8);
        }
        final com.baidu.live.videochat.panel.a.a item = getItem(i);
        if (item != null) {
            if (StringUtils.isNull(item.portrait)) {
                c0234b.bSt.startLoad("https://error", 12, false);
            } else {
                c0234b.bSt.startLoad(item.portrait, 12, false);
            }
            c0234b.bSu.setText(item.userName);
            if (item.bSO == 0) {
                c0234b.bSy.setVisibility(0);
                c0234b.bSx.setVisibility(8);
                c0234b.bSz.setVisibility(8);
                c0234b.bSA.setVisibility(8);
            } else if (1 == item.bSO) {
                c0234b.bSz.setVisibility(0);
                c0234b.bSx.setVisibility(8);
                c0234b.bSy.setVisibility(8);
                c0234b.bSA.setVisibility(8);
            } else if (2 == item.bSO || 3 == item.bSO) {
                c0234b.bSA.setVisibility(0);
                c0234b.bSx.setVisibility(0);
                c0234b.bSx.playAnimation();
                c0234b.bSy.setVisibility(8);
                c0234b.bSz.setVisibility(8);
            }
        }
        c0234b.bSy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.videochat.panel.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.bSq != null) {
                    b.this.bSq.c(item);
                }
            }
        });
        return view;
    }

    /* renamed from: com.baidu.live.videochat.panel.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private static class C0234b {
        public TextView bSA;
        public HeadImageView bSt;
        public TextView bSu;
        public View bSv;
        public View bSw;
        public TBLottieAnimationView bSx;
        public TextView bSy;
        public TextView bSz;

        private C0234b() {
        }
    }
}
