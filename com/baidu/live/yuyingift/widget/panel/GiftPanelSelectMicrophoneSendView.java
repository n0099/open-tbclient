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
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.view.AlphaGradientHListView;
import com.baidu.live.view.SafeFrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class GiftPanelSelectMicrophoneSendView extends RelativeLayout {
    private List<d> bVA;
    private String[] bVB;
    private FrameLayout bVt;
    private FrameLayout bVu;
    private c bVv;
    private f bVw;
    private g bVx;
    private b bVy;
    private List<AlaWheatInfoData> bVz;

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
        this.bVx = gVar;
    }

    public void setCallback(c cVar) {
        this.bVv = cVar;
    }

    public void setOnSelectWheatChangeListener(f fVar) {
        this.bVw = fVar;
    }

    public GiftPanelSelectMicrophoneSendView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        inflate(getContext(), a.g.yuyin_ala_gift_panel_select_microphone_send, this);
        setGravity(16);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        initView();
    }

    private void initView() {
        this.bVt = (FrameLayout) findViewById(a.f.yuyin_ala_gift_microphone_person_content);
        this.bVu = (FrameLayout) findViewById(a.f.yuyin_ala_gift_microphone_op_content);
    }

    private boolean ao(List<d> list) {
        if (list == null || this.bVA == null || list.size() != this.bVA.size() || list.size() == 0) {
            return false;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (!TextUtils.equals(list.get(i2).bVK.uk, this.bVA.get(i2).bVK.uk) || list.get(i2).bVK.realWheatPosition != this.bVA.get(i2).bVK.realWheatPosition) {
                return false;
            }
        }
        return true;
    }

    public void b(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2, String[] strArr) {
        ArrayList arrayList;
        d dVar;
        AlaWheatInfoData jw;
        this.bVB = strArr;
        if (strArr == null || strArr.length == 0) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (String str : strArr) {
                if (!StringUtils.isNull(str) && (jw = com.baidu.live.ap.b.YX().jw(str)) != null) {
                    arrayList.add(jw);
                }
            }
            if (ListUtils.isEmpty(arrayList)) {
                this.bVz = null;
                h(null, false);
                return;
            }
        }
        if (!ListUtils.isEmpty(arrayList)) {
            if (!f(this.bVz, arrayList)) {
                this.bVz = arrayList;
                ArrayList arrayList2 = new ArrayList();
                for (AlaWheatInfoData alaWheatInfoData : this.bVz) {
                    AlaWheatInfoData alaWheatInfoData2 = (AlaWheatInfoData) alaWheatInfoData.clone();
                    alaWheatInfoData2.isSelected = true;
                    com.baidu.live.ap.b.YX().G(alaWheatInfoData2.uk, true);
                    if (alaWheatInfoData2.isHost) {
                        dVar = new d(alaWheatInfoData2, "主持");
                    } else {
                        w Zd = com.baidu.live.ap.b.YX().Zd();
                        if (Zd != null && Zd.aKQ != null && Zd.aKQ.isSweetStage()) {
                            dVar = new d(alaWheatInfoData2, alaWheatInfoData2.phoneOrder + "麦");
                        } else {
                            dVar = new d(alaWheatInfoData2, alaWheatInfoData2.realWheatPosition + "麦");
                        }
                    }
                    arrayList2.add(dVar);
                }
                if (ListUtils.getCount(arrayList2) > 1) {
                    h(arrayList2, true);
                    return;
                } else {
                    a((d) ListUtils.getItem(arrayList2, 0));
                    return;
                }
            }
            return;
        }
        List<d> g2 = g(list, list2);
        if (!ao(g2)) {
            if (this.bVA == null) {
                this.bVA = new ArrayList();
            }
            this.bVA.clear();
            for (d dVar2 : g2) {
                this.bVA.add(dVar2.clone());
            }
            h(g2, true);
        }
    }

    private void a(final d dVar) {
        this.bVt.removeAllViews();
        this.bVu.removeAllViews();
        this.bVy = new h(getContext());
        if (dVar != null) {
            h hVar = (h) this.bVy;
            hVar.b(dVar);
            hVar.bVU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (GiftPanelSelectMicrophoneSendView.this.bVv != null) {
                        GiftPanelSelectMicrophoneSendView.this.bVv.a(dVar.bVK);
                    }
                }
            });
            hVar.bVV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (GiftPanelSelectMicrophoneSendView.this.bVv != null) {
                        GiftPanelSelectMicrophoneSendView.this.bVv.b(dVar.bVK);
                    }
                }
            });
            if (this.bVx != null) {
                this.bVx.c(dVar.bVK);
            }
            this.bVt.addView(this.bVy.contentView);
            this.bVu.addView(this.bVy.bVJ);
        }
    }

    private boolean f(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2) {
        int count = ListUtils.getCount(list);
        if (count != ListUtils.getCount(list2)) {
            return false;
        }
        for (int i2 = 0; i2 < count; i2++) {
            AlaWheatInfoData alaWheatInfoData = (AlaWheatInfoData) ListUtils.getItem(list, i2);
            AlaWheatInfoData alaWheatInfoData2 = (AlaWheatInfoData) ListUtils.getItem(list2, i2);
            if (alaWheatInfoData == null || alaWheatInfoData2 == null || !TextUtils.equals(alaWheatInfoData.uk, alaWheatInfoData2.uk) || alaWheatInfoData.realWheatPosition != alaWheatInfoData2.realWheatPosition) {
                return false;
            }
        }
        return true;
    }

    private void h(List<d> list, boolean z) {
        this.bVt.removeAllViews();
        this.bVu.removeAllViews();
        this.bVy = new a(getContext());
        final a aVar = (a) this.bVy;
        aVar.setData(list);
        aVar.bVG.setSelected(aVar.bVI.ZJ());
        aVar.bVG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.bVI.dC(!aVar.bVI.ZJ());
                ((a) GiftPanelSelectMicrophoneSendView.this.bVy).bVG.setSelected(aVar.bVI.ZJ());
                if (GiftPanelSelectMicrophoneSendView.this.bVw != null) {
                    GiftPanelSelectMicrophoneSendView.this.bVw.onChange();
                }
            }
        });
        e eVar = aVar.bVI;
        e eVar2 = aVar.bVI;
        eVar2.getClass();
        eVar.a(new e.a(eVar2, aVar) { // from class: com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.4
            final /* synthetic */ a bVE;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
                this.bVE = aVar;
                eVar2.getClass();
            }

            @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.e.a
            void onItemClick(int i2) {
                ((a) GiftPanelSelectMicrophoneSendView.this.bVy).bVG.setSelected(this.bVE.bVI.ZJ());
                if (GiftPanelSelectMicrophoneSendView.this.bVw != null) {
                    GiftPanelSelectMicrophoneSendView.this.bVw.onChange();
                }
            }
        });
        this.bVt.addView(this.bVy.contentView);
        if (z) {
            this.bVu.addView(this.bVy.bVJ);
        }
    }

    public void setAttentionAndInfo(PersonUserData personUserData) {
        if (personUserData != null && personUserData.user_info != null && personUserData.relation_info != null && this.bVy != null && (this.bVy instanceof h)) {
            ((h) this.bVy).dF(!TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), personUserData.user_info.user_id) && personUserData.relation_info.follow_status == 0);
            ((h) this.bVy).dE(true);
        }
    }

    public void Zq() {
        if (this.bVy != null && (this.bVy instanceof h)) {
            ((h) this.bVy).dF(false);
        }
    }

    private List<d> g(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2) {
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
                if (com.baidu.live.ap.b.YX().ju(alaWheatInfoData.uk)) {
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
                if (com.baidu.live.ap.b.YX().ju(next.uk)) {
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
            AlaWheatInfoData YY = com.baidu.live.ap.b.YX().YY();
            if (YY != null) {
                AlaWheatInfoData alaWheatInfoData2 = (AlaWheatInfoData) YY.clone();
                alaWheatInfoData2.userName = "房主";
                arrayList.add(new d(alaWheatInfoData2, "房主"));
            }
        } else {
            dVar2.bVK.userName = "房主";
            arrayList.add(dVar2);
        }
        if (TbadkCoreApplication.isLogin() && arrayList.size() > 0) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                if (TextUtils.equals(String.valueOf(ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount())), ((d) it2.next()).bVK.uk)) {
                    it2.remove();
                }
            }
        }
        if (arrayList != null) {
            for (d dVar7 : arrayList) {
                dVar7.bVK.isSelected = com.baidu.live.ap.b.YX().jx(dVar7.bVK.uk);
            }
        }
        return arrayList;
    }

    public i getSelectMicrophoneList() {
        i iVar = new i();
        ArrayList arrayList = new ArrayList();
        iVar.bVW = this.bVB;
        if (this.bVy != null) {
            if (this.bVy instanceof h) {
                if (((h) this.bVy).bVS != null) {
                    arrayList.add(((h) this.bVy).bVS);
                }
            } else if (this.bVy instanceof a) {
                for (AlaWheatInfoData alaWheatInfoData : ((a) this.bVy).getData()) {
                    if (alaWheatInfoData.isSelected) {
                        arrayList.add(alaWheatInfoData);
                    }
                }
            }
        }
        iVar.bVX = arrayList;
        return iVar;
    }

    /* loaded from: classes4.dex */
    public class i {
        public String[] bVW;
        public List<AlaWheatInfoData> bVX;

        public i() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public abstract class b {
        protected View bVJ;
        protected View contentView = getContentView();

        protected abstract int ZF();

        abstract void ZG();

        abstract void ZH();

        protected abstract View getContentView();

        b(Context context) {
            this.bVJ = LayoutInflater.from(context).inflate(ZF(), (ViewGroup) null, false);
            ZG();
            ZH();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class h extends b {
        public TextView bVP;
        public AlaWheatInfoData bVS;
        public TextView bVT;
        public AlaGiftMicrophoneOpBtn bVU;
        public AlaGiftMicrophoneOpBtn bVV;
        public HeadImageView bki;

        h(Context context) {
            super(context);
        }

        @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.b
        protected View getContentView() {
            return LayoutInflater.from(GiftPanelSelectMicrophoneSendView.this.getContext()).inflate(a.g.yuyin_ala_gift_item_onlyone_microphone_headerview, (ViewGroup) null, false);
        }

        @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.b
        protected int ZF() {
            return a.g.yuyin_ala_gift_microphone_onlyone_footerview;
        }

        @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.b
        void ZG() {
            this.bki = (HeadImageView) this.contentView.findViewById(a.f.yuyin_ala_gift_onlyone_microphone_header);
            this.bVP = (TextView) this.contentView.findViewById(a.f.yuyin_ala_gift_onlyone_microphone_number);
            this.bVT = (TextView) this.contentView.findViewById(a.f.yuyin_ala_gift_onlyone_microphone_name);
            this.bki.setIsRound(true);
        }

        @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.b
        void ZH() {
            this.bVU = (AlaGiftMicrophoneOpBtn) this.bVJ.findViewById(a.f.yuyin_ala_gift_microphone_person_attention);
            this.bVV = (AlaGiftMicrophoneOpBtn) this.bVJ.findViewById(a.f.yuyin_ala_gift_microphone_person_info);
            this.bVU.setSelected(true);
            this.bVV.setSelected(false);
        }

        public void b(d dVar) {
            if (dVar != null && dVar.bVK != null) {
                this.bVS = dVar.bVK;
                this.bki.startLoad(dVar.bVK.portrait, 12, true);
                this.bVP.setText(dVar.posName);
                this.bVT.setText(dVar.bVK.userName);
            }
        }

        public void dE(boolean z) {
            this.bVV.setVisibility(z ? 0 : 8);
        }

        public void dF(boolean z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bVV.getLayoutParams();
            if (!z) {
                layoutParams.leftMargin = 0;
                this.bVU.setVisibility(8);
            } else {
                layoutParams.leftMargin = BdUtilHelper.getDimens(GiftPanelSelectMicrophoneSendView.this.getContext(), a.d.sdk_ds20);
                this.bVU.setVisibility(0);
            }
            this.bVV.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends b {
        public AlphaGradientHListView bVF;
        public AlaGiftMicrophoneOpBtn bVG;
        private List<AlaWheatInfoData> bVH;
        public e bVI;

        a(Context context) {
            super(context);
            this.bVH = new ArrayList();
        }

        @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.b
        protected View getContentView() {
            return new AlphaGradientHListView(GiftPanelSelectMicrophoneSendView.this.getContext());
        }

        @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.b
        protected int ZF() {
            return a.g.yuyin_ala_gift_microphone_aboveone_footerview;
        }

        @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.b
        void ZG() {
            this.bVF = (AlphaGradientHListView) this.contentView;
            this.bVF.setShadowWidth(GiftPanelSelectMicrophoneSendView.this.getResources().getDimensionPixelOffset(a.d.sdk_ds56));
            this.bVF.setNeedAlphaShade(true);
            this.bVF.setColor(GiftPanelSelectMicrophoneSendView.this.getResources().getColor(a.c.sdk_white_alpha100), GiftPanelSelectMicrophoneSendView.this.getResources().getColor(a.c.sdk_white_alpha0));
            this.bVF.setSelector(new ColorDrawable(0));
            this.bVI = new e();
            this.bVF.setAdapter((ListAdapter) this.bVI);
        }

        @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.b
        void ZH() {
            this.bVG = (AlaGiftMicrophoneOpBtn) this.bVJ.findViewById(a.f.yuyin_ala_gift_microphone_person_selectall);
            this.bVG.setSelected(true);
        }

        public List<AlaWheatInfoData> getData() {
            this.bVH.clear();
            if (this.bVI != null && this.bVI.getData() != null) {
                for (d dVar : this.bVI.getData()) {
                    this.bVH.add(dVar.bVK);
                }
            }
            return this.bVH;
        }

        public void setData(List<d> list) {
            this.bVI.setData(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d implements Cloneable {
        public AlaWheatInfoData bVK;
        public String posName;

        public d(AlaWheatInfoData alaWheatInfoData, String str) {
            this.bVK = alaWheatInfoData;
            this.posName = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* renamed from: ZI */
        public d clone() {
            d dVar = null;
            try {
                dVar = (d) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            if (dVar != null && this.bVK != null) {
                dVar.bVK = (AlaWheatInfoData) this.bVK.clone();
            }
            return dVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class e extends BaseAdapter {
        private List<d> bVL;
        private a bVM;

        e() {
        }

        public void a(a aVar) {
            this.bVM = aVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public abstract class a {
            abstract void onItemClick(int i);

            a() {
            }
        }

        public boolean ZJ() {
            if (this.bVL == null || this.bVL.size() == 0) {
                return false;
            }
            for (d dVar : this.bVL) {
                if (!dVar.bVK.isSelected) {
                    return false;
                }
            }
            return true;
        }

        public void dC(boolean z) {
            if (this.bVL != null) {
                for (d dVar : this.bVL) {
                    dVar.bVK.isSelected = z;
                    com.baidu.live.ap.b.YX().G(dVar.bVK.uk, dVar.bVK.isSelected);
                }
                notifyDataSetChanged();
            }
        }

        public List<d> getData() {
            return this.bVL;
        }

        public void setData(List<d> list) {
            this.bVL = list;
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.bVL == null) {
                return 0;
            }
            return this.bVL.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.bVL.get(i);
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
                bVar.an(view);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    dVar.bVK.isSelected = !dVar.bVK.isSelected;
                    com.baidu.live.ap.b.YX().G(dVar.bVK.uk, dVar.bVK.isSelected);
                    e.this.notifyDataSetChanged();
                    if (e.this.bVM != null) {
                        e.this.bVM.onItemClick(i);
                    }
                }
            });
            bVar.a(i, dVar);
            return view;
        }

        /* loaded from: classes4.dex */
        class b {
            public TextView bVP;
            public View bVQ;
            public SafeFrameLayout bVR;
            public HeadImageView bki;

            b() {
            }

            public int getLayoutId() {
                return a.g.yuyin_ala_gift_item_microphone_headerview;
            }

            public void an(View view) {
                this.bVQ = view.findViewById(a.f.yuyin_ala_gift_microphone_content);
                this.bVR = (SafeFrameLayout) view.findViewById(a.f.yuyin_ala_gift_microphone_headwrap);
                this.bki = (HeadImageView) view.findViewById(a.f.yuyin_ala_gift_microphone_header);
                this.bVP = (TextView) view.findViewById(a.f.yuyin_ala_gift_microphone_number);
                this.bki.setIsRound(true);
            }

            public void a(int i, d dVar) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bVQ.getLayoutParams();
                if (i > 0) {
                    layoutParams.leftMargin = BdUtilHelper.getDimens(GiftPanelSelectMicrophoneSendView.this.getContext(), a.d.sdk_ds8);
                } else {
                    layoutParams.leftMargin = 0;
                }
                this.bVQ.setLayoutParams(layoutParams);
                if (dVar.bVK != null) {
                    this.bki.setDefaultResource(a.e.yuyin_ala_gift_panel_wheat_header_loadfail);
                    this.bki.setDefaultErrorResource(a.e.yuyin_ala_gift_panel_wheat_header_loadfail);
                    this.bki.startLoad(TextUtils.isEmpty(dVar.bVK.portrait) ? "fail" : dVar.bVK.portrait, 12, false);
                    jz(dVar.posName);
                    dD(dVar.bVK.isSelected);
                }
            }

            public void dD(boolean z) {
                if (z) {
                    this.bVR.setBackgroundResource(a.e.ala_gift_circle_red_bg_header);
                } else {
                    this.bVR.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00000000")));
                }
                this.bVP.setSelected(z);
            }

            public void jz(String str) {
                if (!TextUtils.isEmpty(str)) {
                    int dip2px = str.length() > 1 ? BdUtilHelper.dip2px(GiftPanelSelectMicrophoneSendView.this.getContext(), BdUtilHelper.getDimens(GiftPanelSelectMicrophoneSendView.this.getContext(), a.d.sdk_ds3)) : 0;
                    this.bVP.setPadding(dip2px, 0, dip2px, 0);
                    this.bVP.setText(str);
                }
            }
        }
    }
}
