package com.baidu.live.yuyingift.widget.panel;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.view.AlphaGradientHListView;
import com.baidu.live.view.SafeFrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class GiftPanelSelectMicrophoneSendView extends RelativeLayout {
    private FrameLayout bMl;
    private FrameLayout bMm;
    private c bMn;
    private f bMo;
    private g bMp;
    private b bMq;
    private AlaWheatInfoData bMr;
    private List<d> bMs;
    private String bMt;

    /* loaded from: classes4.dex */
    public interface c {
        void a(AlaWheatInfoData alaWheatInfoData);

        void b(AlaWheatInfoData alaWheatInfoData);
    }

    /* loaded from: classes4.dex */
    public interface f {
        void onChange();
    }

    /* loaded from: classes4.dex */
    public interface g {
        void c(AlaWheatInfoData alaWheatInfoData);
    }

    public void setOnSetDataListener(g gVar) {
        this.bMp = gVar;
    }

    public void setCallback(c cVar) {
        this.bMn = cVar;
    }

    public void setOnSelectWheatChangeListener(f fVar) {
        this.bMo = fVar;
    }

    public GiftPanelSelectMicrophoneSendView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        setLayoutParams(new LinearLayout.LayoutParams(-1, BdUtilHelper.getDimens(getContext(), a.e.sdk_ds96)));
        setGravity(16);
        inflate(getContext(), a.h.yuyin_ala_gift_panel_select_microphone_send, this);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        initView();
    }

    private void initView() {
        this.bMl = (FrameLayout) findViewById(a.g.yuyin_ala_gift_microphone_person_content);
        this.bMm = (FrameLayout) findViewById(a.g.yuyin_ala_gift_microphone_op_content);
    }

    private boolean ah(List<d> list) {
        if (list == null || this.bMs == null || list.size() != this.bMs.size() || list.size() == 0) {
            return false;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (!TextUtils.equals(list.get(i2).bMB.uk, this.bMs.get(i2).bMB.uk) || list.get(i2).bMB.realWheatPosition != this.bMs.get(i2).bMB.realWheatPosition) {
                return false;
            }
        }
        return true;
    }

    public void b(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2, String str) {
        AlaWheatInfoData alaWheatInfoData;
        d dVar;
        this.bMt = str;
        if (TextUtils.isEmpty(str)) {
            alaWheatInfoData = null;
        } else {
            AlaWheatInfoData iL = com.baidu.live.aj.b.UH().iL(str);
            if (iL == null) {
                this.bMr = null;
                h(null, false);
                return;
            }
            alaWheatInfoData = iL;
        }
        if (alaWheatInfoData != null) {
            if (this.bMr == null || !TextUtils.equals(this.bMr.uk, alaWheatInfoData.uk) || this.bMr.realWheatPosition != alaWheatInfoData.realWheatPosition) {
                this.bMr = alaWheatInfoData;
                final AlaWheatInfoData alaWheatInfoData2 = (AlaWheatInfoData) alaWheatInfoData.clone();
                alaWheatInfoData2.isSelected = true;
                com.baidu.live.aj.b.UH().F(alaWheatInfoData2.uk, true);
                if (alaWheatInfoData.isHost) {
                    dVar = new d(alaWheatInfoData2, "主持");
                } else {
                    dVar = new d(alaWheatInfoData2, alaWheatInfoData.realWheatPosition + "麦");
                }
                this.bMq = new h(getContext());
                h hVar = (h) this.bMq;
                hVar.a(dVar);
                hVar.bML.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (GiftPanelSelectMicrophoneSendView.this.bMn != null) {
                            GiftPanelSelectMicrophoneSendView.this.bMn.a(alaWheatInfoData2);
                        }
                    }
                });
                hVar.bMM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (GiftPanelSelectMicrophoneSendView.this.bMn != null) {
                            GiftPanelSelectMicrophoneSendView.this.bMn.b(alaWheatInfoData2);
                        }
                    }
                });
                this.bMl.removeAllViews();
                this.bMm.removeAllViews();
                this.bMl.addView(this.bMq.contentView);
                this.bMm.addView(this.bMq.bMA);
                if (this.bMp != null) {
                    this.bMp.c(alaWheatInfoData2);
                    return;
                }
                return;
            }
            return;
        }
        List<d> f2 = f(list, list2);
        if (!ah(f2)) {
            if (this.bMs == null) {
                this.bMs = new ArrayList();
            }
            this.bMs.clear();
            for (d dVar2 : f2) {
                this.bMs.add(dVar2.clone());
            }
            h(f2, true);
        }
    }

    private void h(List<d> list, boolean z) {
        this.bMl.removeAllViews();
        this.bMm.removeAllViews();
        this.bMq = new a(getContext());
        final a aVar = (a) this.bMq;
        aVar.setData(list);
        aVar.bMy.setSelected(aVar.bMz.Vu());
        aVar.bMy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.bMz.df(!aVar.bMz.Vu());
                ((a) GiftPanelSelectMicrophoneSendView.this.bMq).bMy.setSelected(aVar.bMz.Vu());
                if (GiftPanelSelectMicrophoneSendView.this.bMo != null) {
                    GiftPanelSelectMicrophoneSendView.this.bMo.onChange();
                }
            }
        });
        e eVar = aVar.bMz;
        e eVar2 = aVar.bMz;
        eVar2.getClass();
        eVar.a(new e.a(eVar2, aVar) { // from class: com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.4
            final /* synthetic */ a bMw;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
                this.bMw = aVar;
                eVar2.getClass();
            }

            @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.e.a
            void onItemClick(int i2) {
                ((a) GiftPanelSelectMicrophoneSendView.this.bMq).bMy.setSelected(this.bMw.bMz.Vu());
                if (GiftPanelSelectMicrophoneSendView.this.bMo != null) {
                    GiftPanelSelectMicrophoneSendView.this.bMo.onChange();
                }
            }
        });
        this.bMl.addView(this.bMq.contentView);
        if (z) {
            this.bMm.addView(this.bMq.bMA);
        }
    }

    public void setAttentionAndInfo(PersonUserData personUserData) {
        if (personUserData != null && personUserData.user_info != null && personUserData.relation_info != null && this.bMq != null && (this.bMq instanceof h)) {
            ((h) this.bMq).di(!TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), personUserData.user_info.user_id) && personUserData.relation_info.follow_status == 0);
            ((h) this.bMq).dh(true);
        }
    }

    public void Vb() {
        if (this.bMq != null && (this.bMq instanceof h)) {
            ((h) this.bMq).di(false);
        }
    }

    private List<d> f(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2) {
        d dVar;
        d dVar2;
        d dVar3;
        ArrayList<d> arrayList = new ArrayList();
        d dVar4 = null;
        if (list == null) {
            dVar = null;
        } else {
            for (AlaWheatInfoData alaWheatInfoData : list) {
                d dVar5 = new d(alaWheatInfoData, "主持");
                arrayList.add(dVar5);
                if (com.baidu.live.aj.b.UH().iJ(alaWheatInfoData.uk)) {
                    dVar3 = dVar5.clone();
                    dVar3.posName = "房主";
                } else {
                    dVar3 = dVar4;
                }
                dVar4 = dVar3;
            }
            dVar = dVar4;
        }
        if (list2 != null) {
            Iterator<AlaWheatInfoData> it = list2.iterator();
            while (true) {
                dVar2 = dVar;
                if (!it.hasNext()) {
                    break;
                }
                AlaWheatInfoData next = it.next();
                d dVar6 = new d(next, String.valueOf(next.realWheatPosition));
                arrayList.add(dVar6);
                if (com.baidu.live.aj.b.UH().iJ(next.uk)) {
                    dVar = dVar6.clone();
                    dVar.posName = "房主";
                } else {
                    dVar = dVar2;
                }
            }
        } else {
            dVar2 = dVar;
        }
        if (dVar2 == null) {
            AlaWheatInfoData UJ = com.baidu.live.aj.b.UH().UJ();
            if (UJ != null) {
                AlaWheatInfoData alaWheatInfoData2 = (AlaWheatInfoData) UJ.clone();
                alaWheatInfoData2.userName = "房主";
                arrayList.add(new d(alaWheatInfoData2, "房主"));
            }
        } else {
            dVar2.bMB.userName = "房主";
            arrayList.add(dVar2);
        }
        if (TbadkCoreApplication.isLogin() && arrayList.size() > 0) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                if (TextUtils.equals(String.valueOf(ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount())), ((d) it2.next()).bMB.uk)) {
                    it2.remove();
                }
            }
        }
        if (arrayList != null) {
            for (d dVar7 : arrayList) {
                dVar7.bMB.isSelected = com.baidu.live.aj.b.UH().iM(dVar7.bMB.uk);
            }
        }
        return arrayList;
    }

    public i getSelectMicrophoneList() {
        i iVar = new i();
        ArrayList arrayList = new ArrayList();
        iVar.bMN = this.bMt;
        if (this.bMq != null) {
            if (this.bMq instanceof h) {
                if (((h) this.bMq).bMJ != null) {
                    arrayList.add(((h) this.bMq).bMJ);
                }
            } else if (this.bMq instanceof a) {
                for (AlaWheatInfoData alaWheatInfoData : ((a) this.bMq).getData()) {
                    if (alaWheatInfoData.isSelected) {
                        arrayList.add(alaWheatInfoData);
                    }
                }
            }
        }
        iVar.bMO = arrayList;
        return iVar;
    }

    /* loaded from: classes4.dex */
    public class i {
        public String bMN;
        public List<AlaWheatInfoData> bMO;

        public i() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public abstract class b {
        protected View bMA;
        protected View contentView = getContentView();

        protected abstract int Vq();

        abstract void Vr();

        abstract void Vs();

        protected abstract View getContentView();

        b(Context context) {
            this.bMA = LayoutInflater.from(context).inflate(Vq(), (ViewGroup) null, false);
            Vr();
            Vs();
        }
    }

    /* loaded from: classes4.dex */
    class h extends b {
        public TextView bMG;
        public AlaWheatInfoData bMJ;
        public TextView bMK;
        public AlaGiftMicrophoneOpBtn bML;
        public AlaGiftMicrophoneOpBtn bMM;
        public HeadImageView bgk;

        h(Context context) {
            super(context);
        }

        @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.b
        protected View getContentView() {
            return LayoutInflater.from(GiftPanelSelectMicrophoneSendView.this.getContext()).inflate(a.h.yuyin_ala_gift_item_onlyone_microphone_headerview, (ViewGroup) null, false);
        }

        @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.b
        protected int Vq() {
            return a.h.yuyin_ala_gift_microphone_onlyone_footerview;
        }

        @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.b
        void Vr() {
            this.bgk = (HeadImageView) this.contentView.findViewById(a.g.yuyin_ala_gift_onlyone_microphone_header);
            this.bMG = (TextView) this.contentView.findViewById(a.g.yuyin_ala_gift_onlyone_microphone_number);
            this.bMK = (TextView) this.contentView.findViewById(a.g.yuyin_ala_gift_onlyone_microphone_name);
            this.bgk.setIsRound(true);
        }

        @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.b
        void Vs() {
            this.bML = (AlaGiftMicrophoneOpBtn) this.bMA.findViewById(a.g.yuyin_ala_gift_microphone_person_attention);
            this.bMM = (AlaGiftMicrophoneOpBtn) this.bMA.findViewById(a.g.yuyin_ala_gift_microphone_person_info);
            this.bML.setSelected(true);
            this.bMM.setSelected(false);
        }

        public void a(d dVar) {
            if (dVar != null && dVar.bMB != null) {
                this.bMJ = dVar.bMB;
                this.bgk.startLoad(dVar.bMB.portrait, 12, true);
                this.bMG.setText(dVar.posName);
                this.bMK.setText(dVar.bMB.userName);
            }
        }

        public void dh(boolean z) {
            this.bMM.setVisibility(z ? 0 : 8);
        }

        public void di(boolean z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bMM.getLayoutParams();
            if (!z) {
                layoutParams.leftMargin = 0;
                this.bML.setVisibility(8);
            } else {
                layoutParams.leftMargin = BdUtilHelper.getDimens(GiftPanelSelectMicrophoneSendView.this.getContext(), a.e.sdk_ds20);
                this.bML.setVisibility(0);
            }
            this.bMM.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends b {
        private List<AlaWheatInfoData> aOh;
        public AlphaGradientHListView bMx;
        public AlaGiftMicrophoneOpBtn bMy;
        public e bMz;

        a(Context context) {
            super(context);
            this.aOh = new ArrayList();
        }

        @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.b
        protected View getContentView() {
            return new AlphaGradientHListView(GiftPanelSelectMicrophoneSendView.this.getContext());
        }

        @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.b
        protected int Vq() {
            return a.h.yuyin_ala_gift_microphone_aboveone_footerview;
        }

        @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.b
        void Vr() {
            this.bMx = (AlphaGradientHListView) this.contentView;
            this.bMx.setShadowWidth(GiftPanelSelectMicrophoneSendView.this.getResources().getDimensionPixelOffset(a.e.sdk_ds56));
            this.bMx.setNeedAlphaShade(true);
            this.bMx.setColor(GiftPanelSelectMicrophoneSendView.this.getResources().getColor(a.d.sdk_white_alpha100), GiftPanelSelectMicrophoneSendView.this.getResources().getColor(a.d.sdk_white_alpha0));
            this.bMx.setSelector(new ColorDrawable(0));
            this.bMz = new e();
            this.bMx.setAdapter((ListAdapter) this.bMz);
        }

        @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.b
        void Vs() {
            this.bMy = (AlaGiftMicrophoneOpBtn) this.bMA.findViewById(a.g.yuyin_ala_gift_microphone_person_selectall);
            this.bMy.setSelected(true);
        }

        public List<AlaWheatInfoData> getData() {
            this.aOh.clear();
            if (this.bMz != null && this.bMz.getData() != null) {
                for (d dVar : this.bMz.getData()) {
                    this.aOh.add(dVar.bMB);
                }
            }
            return this.aOh;
        }

        public void setData(List<d> list) {
            this.bMz.setData(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d implements Cloneable {
        public AlaWheatInfoData bMB;
        public String posName;

        public d(AlaWheatInfoData alaWheatInfoData, String str) {
            this.bMB = alaWheatInfoData;
            this.posName = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* renamed from: Vt */
        public d clone() {
            d dVar = null;
            try {
                dVar = (d) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            if (dVar != null && this.bMB != null) {
                dVar.bMB = (AlaWheatInfoData) this.bMB.clone();
            }
            return dVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class e extends BaseAdapter {
        private List<d> bMC;
        private a bMD;

        e() {
        }

        public void a(a aVar) {
            this.bMD = aVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public abstract class a {
            abstract void onItemClick(int i);

            a() {
            }
        }

        public boolean Vu() {
            if (this.bMC == null || this.bMC.size() == 0) {
                return false;
            }
            for (d dVar : this.bMC) {
                if (!dVar.bMB.isSelected) {
                    return false;
                }
            }
            return true;
        }

        public void df(boolean z) {
            if (this.bMC != null) {
                for (d dVar : this.bMC) {
                    dVar.bMB.isSelected = z;
                    com.baidu.live.aj.b.UH().F(dVar.bMB.uk, dVar.bMB.isSelected);
                }
                notifyDataSetChanged();
            }
        }

        public List<d> getData() {
            return this.bMC;
        }

        public void setData(List<d> list) {
            this.bMC = list;
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.bMC == null) {
                return 0;
            }
            return this.bMC.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.bMC.get(i);
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
                view = LayoutInflater.from(GiftPanelSelectMicrophoneSendView.this.getContext()).inflate(bVar.getLayoutId(), viewGroup, false);
                bVar.ah(view);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    dVar.bMB.isSelected = !dVar.bMB.isSelected;
                    com.baidu.live.aj.b.UH().F(dVar.bMB.uk, dVar.bMB.isSelected);
                    e.this.notifyDataSetChanged();
                    if (e.this.bMD != null) {
                        e.this.bMD.onItemClick(i);
                    }
                }
            });
            bVar.a(i, dVar);
            return view;
        }

        /* loaded from: classes4.dex */
        class b {
            public TextView bMG;
            public View bMH;
            public SafeFrameLayout bMI;
            public HeadImageView bgk;

            b() {
            }

            public int getLayoutId() {
                return a.h.yuyin_ala_gift_item_microphone_headerview;
            }

            public void ah(View view) {
                this.bMH = view.findViewById(a.g.yuyin_ala_gift_microphone_content);
                this.bMI = (SafeFrameLayout) view.findViewById(a.g.yuyin_ala_gift_microphone_headwrap);
                this.bgk = (HeadImageView) view.findViewById(a.g.yuyin_ala_gift_microphone_header);
                this.bMG = (TextView) view.findViewById(a.g.yuyin_ala_gift_microphone_number);
                this.bgk.setIsRound(true);
            }

            public void a(int i, d dVar) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bMH.getLayoutParams();
                if (i > 0) {
                    layoutParams.leftMargin = BdUtilHelper.getDimens(GiftPanelSelectMicrophoneSendView.this.getContext(), a.e.sdk_ds8);
                } else {
                    layoutParams.leftMargin = 0;
                }
                this.bMH.setLayoutParams(layoutParams);
                if (dVar.bMB != null) {
                    this.bgk.setDefaultResource(a.f.yuyin_ala_gift_panel_wheat_header_loadfail);
                    this.bgk.setDefaultErrorResource(a.f.yuyin_ala_gift_panel_wheat_header_loadfail);
                    this.bgk.startLoad(TextUtils.isEmpty(dVar.bMB.portrait) ? "fail" : dVar.bMB.portrait, 12, false);
                    iO(dVar.posName);
                    dg(dVar.bMB.isSelected);
                }
            }

            public void dg(boolean z) {
                if (z) {
                    this.bMI.setBackgroundResource(a.f.ala_gift_circle_red_bg_header);
                } else {
                    this.bMI.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00000000")));
                }
                this.bMG.setSelected(z);
            }

            public void iO(String str) {
                if (!TextUtils.isEmpty(str)) {
                    int dip2px = str.length() > 1 ? BdUtilHelper.dip2px(GiftPanelSelectMicrophoneSendView.this.getContext(), BdUtilHelper.getDimens(GiftPanelSelectMicrophoneSendView.this.getContext(), a.e.sdk_ds3)) : 0;
                    this.bMG.setPadding(dip2px, 0, dip2px, 0);
                    this.bMG.setText(str);
                }
            }
        }
    }
}
