package com.baidu.live.yuyingift.widget.wheatlist;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.view.SafeFrameLayout;
import java.util.List;
/* loaded from: classes10.dex */
public class c extends BaseAdapter {
    private List<d> bWT;
    private a bWU;
    private Context mContext;

    public c(Context context) {
        this.mContext = context;
    }

    public void a(a aVar) {
        this.bWU = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public abstract class a {
        abstract void dR(int i);

        /* JADX INFO: Access modifiers changed from: package-private */
        public a() {
        }
    }

    public boolean Xx() {
        if (this.bWT == null || this.bWT.size() == 0) {
            return false;
        }
        for (d dVar : this.bWT) {
            if (!dVar.bXr.isSelected) {
                return false;
            }
        }
        return true;
    }

    public void dD(boolean z) {
        if (this.bWT != null) {
            for (d dVar : this.bWT) {
                dVar.bXr.isSelected = z;
                GiftPanelSelectMicrophoneSendView.k(dVar.bXr.uk, dVar.posName, dVar.bXr.isSelected);
            }
            notifyDataSetChanged();
        }
    }

    public List<d> getData() {
        return this.bWT;
    }

    public void setData(List<d> list) {
        this.bWT = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bWT == null) {
            return 0;
        }
        return this.bWT.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.bWT.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        b bVar;
        final d dVar = (d) getItem(i);
        if (view == null) {
            bVar = new b();
            view = LayoutInflater.from(this.mContext).inflate(bVar.getLayoutId(), viewGroup, false);
            bVar.ap(view);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.widget.wheatlist.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                dVar.bXr.isSelected = !dVar.bXr.isSelected;
                GiftPanelSelectMicrophoneSendView.k(dVar.bXr.uk, dVar.posName, dVar.bXr.isSelected);
                c.this.notifyDataSetChanged();
                if (c.this.bWU != null) {
                    c.this.bWU.dR(i);
                }
            }
        });
        bVar.a(i, dVar);
        return view;
    }

    /* loaded from: classes10.dex */
    class b {
        public HeadImageView bWX;
        public TextView bWY;
        public View bWZ;
        public SafeFrameLayout bXa;

        b() {
        }

        public int getLayoutId() {
            return a.g.yuyin_ala_gift_item_microphone_headerview;
        }

        public void ap(View view) {
            this.bWZ = view.findViewById(a.f.yuyin_ala_gift_microphone_content);
            this.bXa = (SafeFrameLayout) view.findViewById(a.f.yuyin_ala_gift_microphone_headwrap);
            this.bWX = (HeadImageView) view.findViewById(a.f.yuyin_ala_gift_microphone_header);
            this.bWY = (TextView) view.findViewById(a.f.yuyin_ala_gift_microphone_number);
            this.bWX.setIsRound(true);
        }

        public void a(int i, d dVar) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bWZ.getLayoutParams();
            if (i > 0) {
                layoutParams.leftMargin = BdUtilHelper.getDimens(c.this.mContext, a.d.sdk_ds8);
            } else {
                layoutParams.leftMargin = 0;
            }
            this.bWZ.setLayoutParams(layoutParams);
            if (dVar.bXr != null) {
                this.bWX.setDefaultResource(a.e.yuyin_ala_gift_panel_wheat_header_loadfail);
                this.bWX.setDefaultErrorResource(a.e.yuyin_ala_gift_panel_wheat_header_loadfail);
                this.bWX.startLoad(TextUtils.isEmpty(dVar.bXr.portrait) ? com.baidu.pass.biometrics.face.liveness.c.a.p : dVar.bXr.portrait, 12, false);
                ih(dVar.posName);
                dE(dVar.bXr.isSelected);
            }
        }

        public void dE(boolean z) {
            if (z) {
                this.bXa.setBackgroundResource(a.e.ala_gift_circle_red_bg_header);
            } else {
                this.bXa.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00000000")));
            }
            this.bWY.setSelected(z);
        }

        public void ih(String str) {
            if (!TextUtils.isEmpty(str)) {
                int dip2px = str.length() > 1 ? BdUtilHelper.dip2px(c.this.mContext, BdUtilHelper.getDimens(c.this.mContext, a.d.sdk_ds3)) : 0;
                this.bWY.setPadding(dip2px, 0, dip2px, 0);
                this.bWY.setText(str);
            }
        }
    }
}
