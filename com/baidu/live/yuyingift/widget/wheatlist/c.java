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
    private List<d> cbG;
    private a cbH;
    private Context mContext;

    public c(Context context) {
        this.mContext = context;
    }

    public void a(a aVar) {
        this.cbH = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public abstract class a {
        abstract void fx(int i);

        /* JADX INFO: Access modifiers changed from: package-private */
        public a() {
        }
    }

    public boolean abq() {
        if (this.cbG == null || this.cbG.size() == 0) {
            return false;
        }
        for (d dVar : this.cbG) {
            if (!dVar.cce.isSelected) {
                return false;
            }
        }
        return true;
    }

    public void dH(boolean z) {
        if (this.cbG != null) {
            for (d dVar : this.cbG) {
                dVar.cce.isSelected = z;
                GiftPanelSelectMicrophoneSendView.k(dVar.cce.uk, dVar.posName, dVar.cce.isSelected);
            }
            notifyDataSetChanged();
        }
    }

    public List<d> getData() {
        return this.cbG;
    }

    public void setData(List<d> list) {
        this.cbG = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cbG == null) {
            return 0;
        }
        return this.cbG.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.cbG.get(i);
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
                dVar.cce.isSelected = !dVar.cce.isSelected;
                GiftPanelSelectMicrophoneSendView.k(dVar.cce.uk, dVar.posName, dVar.cce.isSelected);
                c.this.notifyDataSetChanged();
                if (c.this.cbH != null) {
                    c.this.cbH.fx(i);
                }
            }
        });
        bVar.a(i, dVar);
        return view;
    }

    /* loaded from: classes11.dex */
    class b {
        public HeadImageView cbK;
        public TextView cbL;
        public View cbM;
        public SafeFrameLayout cbN;

        b() {
        }

        public int getLayoutId() {
            return a.g.yuyin_ala_gift_item_microphone_headerview;
        }

        public void ap(View view) {
            this.cbM = view.findViewById(a.f.yuyin_ala_gift_microphone_content);
            this.cbN = (SafeFrameLayout) view.findViewById(a.f.yuyin_ala_gift_microphone_headwrap);
            this.cbK = (HeadImageView) view.findViewById(a.f.yuyin_ala_gift_microphone_header);
            this.cbL = (TextView) view.findViewById(a.f.yuyin_ala_gift_microphone_number);
            this.cbK.setIsRound(true);
        }

        public void a(int i, d dVar) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cbM.getLayoutParams();
            if (i > 0) {
                layoutParams.leftMargin = BdUtilHelper.getDimens(c.this.mContext, a.d.sdk_ds8);
            } else {
                layoutParams.leftMargin = 0;
            }
            this.cbM.setLayoutParams(layoutParams);
            if (dVar.cce != null) {
                this.cbK.setDefaultResource(a.e.yuyin_ala_gift_panel_wheat_header_loadfail);
                this.cbK.setDefaultErrorResource(a.e.yuyin_ala_gift_panel_wheat_header_loadfail);
                this.cbK.startLoad(TextUtils.isEmpty(dVar.cce.portrait) ? com.baidu.pass.biometrics.face.liveness.c.a.p : dVar.cce.portrait, 12, false);
                js(dVar.posName);
                dI(dVar.cce.isSelected);
            }
        }

        public void dI(boolean z) {
            if (z) {
                this.cbN.setBackgroundResource(a.e.ala_gift_circle_red_bg_header);
            } else {
                this.cbN.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00000000")));
            }
            this.cbL.setSelected(z);
        }

        public void js(String str) {
            if (!TextUtils.isEmpty(str)) {
                int dip2px = str.length() > 1 ? BdUtilHelper.dip2px(c.this.mContext, BdUtilHelper.getDimens(c.this.mContext, a.d.sdk_ds3)) : 0;
                this.cbL.setPadding(dip2px, 0, dip2px, 0);
                this.cbL.setText(str);
            }
        }
    }
}
