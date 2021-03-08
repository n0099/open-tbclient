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
    private List<d> ccx;
    private a ccy;
    private Context mContext;

    public c(Context context) {
        this.mContext = context;
    }

    public void a(a aVar) {
        this.ccy = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public abstract class a {
        abstract void dW(int i);

        /* JADX INFO: Access modifiers changed from: package-private */
        public a() {
        }
    }

    public boolean Zq() {
        if (this.ccx == null || this.ccx.size() == 0) {
            return false;
        }
        for (d dVar : this.ccx) {
            if (!dVar.ccV.isSelected) {
                return false;
            }
        }
        return true;
    }

    public void dL(boolean z) {
        if (this.ccx != null) {
            for (d dVar : this.ccx) {
                dVar.ccV.isSelected = z;
                GiftPanelSelectMicrophoneSendView.k(dVar.ccV.uk, dVar.posName, dVar.ccV.isSelected);
            }
            notifyDataSetChanged();
        }
    }

    public List<d> getData() {
        return this.ccx;
    }

    public void setData(List<d> list) {
        this.ccx = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ccx == null) {
            return 0;
        }
        return this.ccx.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.ccx.get(i);
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
            bVar.am(view);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.widget.wheatlist.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                dVar.ccV.isSelected = !dVar.ccV.isSelected;
                GiftPanelSelectMicrophoneSendView.k(dVar.ccV.uk, dVar.posName, dVar.ccV.isSelected);
                c.this.notifyDataSetChanged();
                if (c.this.ccy != null) {
                    c.this.ccy.dW(i);
                }
            }
        });
        bVar.a(i, dVar);
        return view;
    }

    /* loaded from: classes10.dex */
    class b {
        public HeadImageView ccB;
        public TextView ccC;
        public View ccD;
        public SafeFrameLayout ccE;

        b() {
        }

        public int getLayoutId() {
            return a.g.yuyin_ala_gift_item_microphone_headerview;
        }

        public void am(View view) {
            this.ccD = view.findViewById(a.f.yuyin_ala_gift_microphone_content);
            this.ccE = (SafeFrameLayout) view.findViewById(a.f.yuyin_ala_gift_microphone_headwrap);
            this.ccB = (HeadImageView) view.findViewById(a.f.yuyin_ala_gift_microphone_header);
            this.ccC = (TextView) view.findViewById(a.f.yuyin_ala_gift_microphone_number);
            this.ccB.setIsRound(true);
        }

        public void a(int i, d dVar) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ccD.getLayoutParams();
            if (i > 0) {
                layoutParams.leftMargin = BdUtilHelper.getDimens(c.this.mContext, a.d.sdk_ds8);
            } else {
                layoutParams.leftMargin = 0;
            }
            this.ccD.setLayoutParams(layoutParams);
            if (dVar.ccV != null) {
                this.ccB.setDefaultResource(a.e.yuyin_ala_gift_panel_wheat_header_loadfail);
                this.ccB.setDefaultErrorResource(a.e.yuyin_ala_gift_panel_wheat_header_loadfail);
                this.ccB.startLoad(TextUtils.isEmpty(dVar.ccV.portrait) ? com.baidu.pass.biometrics.face.liveness.c.a.p : dVar.ccV.portrait, 12, false);
                iT(dVar.posName);
                dM(dVar.ccV.isSelected);
            }
        }

        public void dM(boolean z) {
            if (z) {
                this.ccE.setBackgroundResource(a.e.ala_gift_circle_red_bg_header);
            } else {
                this.ccE.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00000000")));
            }
            this.ccC.setSelected(z);
        }

        public void iT(String str) {
            if (!TextUtils.isEmpty(str)) {
                int dip2px = str.length() > 1 ? BdUtilHelper.dip2px(c.this.mContext, BdUtilHelper.getDimens(c.this.mContext, a.d.sdk_ds3)) : 0;
                this.ccC.setPadding(dip2px, 0, dip2px, 0);
                this.ccC.setText(str);
            }
        }
    }
}
