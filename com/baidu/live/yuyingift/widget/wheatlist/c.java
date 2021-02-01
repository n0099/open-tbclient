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
/* loaded from: classes11.dex */
public class c extends BaseAdapter {
    private List<d> caV;
    private a caW;
    private Context mContext;

    public c(Context context) {
        this.mContext = context;
    }

    public void a(a aVar) {
        this.caW = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public abstract class a {
        abstract void dV(int i);

        /* JADX INFO: Access modifiers changed from: package-private */
        public a() {
        }
    }

    public boolean Zn() {
        if (this.caV == null || this.caV.size() == 0) {
            return false;
        }
        for (d dVar : this.caV) {
            if (!dVar.cbu.isSelected) {
                return false;
            }
        }
        return true;
    }

    public void dL(boolean z) {
        if (this.caV != null) {
            for (d dVar : this.caV) {
                dVar.cbu.isSelected = z;
                GiftPanelSelectMicrophoneSendView.k(dVar.cbu.uk, dVar.posName, dVar.cbu.isSelected);
            }
            notifyDataSetChanged();
        }
    }

    public List<d> getData() {
        return this.caV;
    }

    public void setData(List<d> list) {
        this.caV = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.caV == null) {
            return 0;
        }
        return this.caV.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.caV.get(i);
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
                dVar.cbu.isSelected = !dVar.cbu.isSelected;
                GiftPanelSelectMicrophoneSendView.k(dVar.cbu.uk, dVar.posName, dVar.cbu.isSelected);
                c.this.notifyDataSetChanged();
                if (c.this.caW != null) {
                    c.this.caW.dV(i);
                }
            }
        });
        bVar.a(i, dVar);
        return view;
    }

    /* loaded from: classes11.dex */
    class b {
        public HeadImageView caZ;
        public TextView cba;
        public View cbb;
        public SafeFrameLayout cbc;

        b() {
        }

        public int getLayoutId() {
            return a.g.yuyin_ala_gift_item_microphone_headerview;
        }

        public void am(View view) {
            this.cbb = view.findViewById(a.f.yuyin_ala_gift_microphone_content);
            this.cbc = (SafeFrameLayout) view.findViewById(a.f.yuyin_ala_gift_microphone_headwrap);
            this.caZ = (HeadImageView) view.findViewById(a.f.yuyin_ala_gift_microphone_header);
            this.cba = (TextView) view.findViewById(a.f.yuyin_ala_gift_microphone_number);
            this.caZ.setIsRound(true);
        }

        public void a(int i, d dVar) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cbb.getLayoutParams();
            if (i > 0) {
                layoutParams.leftMargin = BdUtilHelper.getDimens(c.this.mContext, a.d.sdk_ds8);
            } else {
                layoutParams.leftMargin = 0;
            }
            this.cbb.setLayoutParams(layoutParams);
            if (dVar.cbu != null) {
                this.caZ.setDefaultResource(a.e.yuyin_ala_gift_panel_wheat_header_loadfail);
                this.caZ.setDefaultErrorResource(a.e.yuyin_ala_gift_panel_wheat_header_loadfail);
                this.caZ.startLoad(TextUtils.isEmpty(dVar.cbu.portrait) ? com.baidu.pass.biometrics.face.liveness.c.a.p : dVar.cbu.portrait, 12, false);
                iN(dVar.posName);
                dM(dVar.cbu.isSelected);
            }
        }

        public void dM(boolean z) {
            if (z) {
                this.cbc.setBackgroundResource(a.e.ala_gift_circle_red_bg_header);
            } else {
                this.cbc.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00000000")));
            }
            this.cba.setSelected(z);
        }

        public void iN(String str) {
            if (!TextUtils.isEmpty(str)) {
                int dip2px = str.length() > 1 ? BdUtilHelper.dip2px(c.this.mContext, BdUtilHelper.getDimens(c.this.mContext, a.d.sdk_ds3)) : 0;
                this.cba.setPadding(dip2px, 0, dip2px, 0);
                this.cba.setText(str);
            }
        }
    }
}
