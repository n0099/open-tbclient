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
    private a bAZ;
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

    public void C(String str, boolean z) {
        if (!StringUtils.isNull(str)) {
            for (com.baidu.live.videochat.panel.a.a aVar : this.mDataList) {
                if (aVar != null && str.equals(aVar.bBz)) {
                    aVar.bBx = z ? 3 : 0;
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
        this.bAZ = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mDataList.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: fY */
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
        C0212b c0212b;
        if (view == null) {
            C0212b c0212b2 = new C0212b();
            view = LayoutInflater.from(this.mContext).inflate(a.h.video_chat_friend_item_viewl, viewGroup, false);
            c0212b2.bBc = (HeadImageView) view.findViewById(a.g.video_chat_user_header);
            c0212b2.bBc.setIsRound(true);
            c0212b2.bBc.setDrawBorder(true);
            c0212b2.bBc.setBorderWidth(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds1));
            c0212b2.bBc.setBorderColor(this.mContext.getResources().getColor(a.d.sdk_black_alpha10));
            c0212b2.bBc.setAutoChangeStyle(false);
            c0212b2.bBd = (TextView) view.findViewById(a.g.video_chat_user_name);
            c0212b2.bBe = view.findViewById(a.g.video_chat_user_top_divider);
            c0212b2.bBf = view.findViewById(a.g.video_chat_user_bottom_divider);
            c0212b2.bBg = (TBLottieAnimationView) view.findViewById(a.g.video_chat_active_view);
            c0212b2.bBg.setAnimation("video_chat_active_anim.json");
            c0212b2.bBg.loop(true);
            c0212b2.bBh = (TextView) view.findViewById(a.g.video_chat_status_invite);
            c0212b2.bBi = (TextView) view.findViewById(a.g.video_chat_status_inviting);
            c0212b2.bBj = (TextView) view.findViewById(a.g.video_chat_status_active);
            view.setTag(c0212b2);
            c0212b = c0212b2;
        } else {
            c0212b = (C0212b) view.getTag();
        }
        if (i == getCount() - 1) {
            c0212b.bBf.setVisibility(8);
        } else {
            c0212b.bBf.setVisibility(0);
        }
        if (i == 0) {
            c0212b.bBe.setVisibility(0);
        } else {
            c0212b.bBe.setVisibility(8);
        }
        final com.baidu.live.videochat.panel.a.a item = getItem(i);
        if (item != null) {
            if (StringUtils.isNull(item.portrait)) {
                c0212b.bBc.startLoad("https://error", 12, false);
            } else {
                c0212b.bBc.startLoad(item.portrait, 12, false);
            }
            c0212b.bBd.setText(item.userName);
            if (item.bBx == 0) {
                c0212b.bBh.setVisibility(0);
                c0212b.bBg.setVisibility(8);
                c0212b.bBi.setVisibility(8);
                c0212b.bBj.setVisibility(8);
            } else if (1 == item.bBx) {
                c0212b.bBi.setVisibility(0);
                c0212b.bBg.setVisibility(8);
                c0212b.bBh.setVisibility(8);
                c0212b.bBj.setVisibility(8);
            } else if (2 == item.bBx || 3 == item.bBx) {
                c0212b.bBj.setVisibility(0);
                c0212b.bBg.setVisibility(0);
                c0212b.bBg.playAnimation();
                c0212b.bBh.setVisibility(8);
                c0212b.bBi.setVisibility(8);
            }
        }
        c0212b.bBh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.videochat.panel.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.bAZ != null) {
                    b.this.bAZ.c(item);
                }
            }
        });
        return view;
    }

    /* renamed from: com.baidu.live.videochat.panel.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class C0212b {
        public HeadImageView bBc;
        public TextView bBd;
        public View bBe;
        public View bBf;
        public TBLottieAnimationView bBg;
        public TextView bBh;
        public TextView bBi;
        public TextView bBj;

        private C0212b() {
        }
    }
}
