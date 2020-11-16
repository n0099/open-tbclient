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
    private FrameLayout bQj;
    private FrameLayout bQk;
    private c bQl;
    private f bQm;
    private g bQn;
    private b bQo;
    private List<AlaWheatInfoData> bQp;
    private List<d> bQq;
    private String[] bQr;

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
        this.bQn = gVar;
    }

    public void setCallback(c cVar) {
        this.bQl = cVar;
    }

    public void setOnSelectWheatChangeListener(f fVar) {
        this.bQm = fVar;
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
        this.bQj = (FrameLayout) findViewById(a.f.yuyin_ala_gift_microphone_person_content);
        this.bQk = (FrameLayout) findViewById(a.f.yuyin_ala_gift_microphone_op_content);
    }

    private boolean am(List<d> list) {
        if (list == null || this.bQq == null || list.size() != this.bQq.size() || list.size() == 0) {
            return false;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (!TextUtils.equals(list.get(i2).bQA.uk, this.bQq.get(i2).bQA.uk) || list.get(i2).bQA.realWheatPosition != this.bQq.get(i2).bQA.realWheatPosition) {
                return false;
            }
        }
        return true;
    }

    public void b(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2, String[] strArr) {
        ArrayList arrayList;
        d dVar;
        AlaWheatInfoData iS;
        this.bQr = strArr;
        if (strArr == null || strArr.length == 0) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (String str : strArr) {
                if (!StringUtils.isNull(str) && (iS = com.baidu.live.al.b.Wy().iS(str)) != null) {
                    arrayList.add(iS);
                }
            }
            if (ListUtils.isEmpty(arrayList)) {
                this.bQp = null;
                h(null, false);
                return;
            }
        }
        if (!ListUtils.isEmpty(arrayList)) {
            if (!f(this.bQp, arrayList)) {
                this.bQp = arrayList;
                ArrayList arrayList2 = new ArrayList();
                for (AlaWheatInfoData alaWheatInfoData : this.bQp) {
                    AlaWheatInfoData alaWheatInfoData2 = (AlaWheatInfoData) alaWheatInfoData.clone();
                    alaWheatInfoData2.isSelected = true;
                    com.baidu.live.al.b.Wy().F(alaWheatInfoData2.uk, true);
                    if (alaWheatInfoData2.isHost) {
                        dVar = new d(alaWheatInfoData2, "主持");
                    } else {
                        w WE = com.baidu.live.al.b.Wy().WE();
                        if (WE != null && WE.aIe != null && WE.aIe.isSweetStage()) {
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
        if (!am(g2)) {
            if (this.bQq == null) {
                this.bQq = new ArrayList();
            }
            this.bQq.clear();
            for (d dVar2 : g2) {
                this.bQq.add(dVar2.clone());
            }
            h(g2, true);
        }
    }

    private void a(final d dVar) {
        this.bQj.removeAllViews();
        this.bQk.removeAllViews();
        this.bQo = new h(getContext());
        if (dVar != null) {
            h hVar = (h) this.bQo;
            hVar.b(dVar);
            hVar.bQK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (GiftPanelSelectMicrophoneSendView.this.bQl != null) {
                        GiftPanelSelectMicrophoneSendView.this.bQl.a(dVar.bQA);
                    }
                }
            });
            hVar.bQL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (GiftPanelSelectMicrophoneSendView.this.bQl != null) {
                        GiftPanelSelectMicrophoneSendView.this.bQl.b(dVar.bQA);
                    }
                }
            });
            if (this.bQn != null) {
                this.bQn.c(dVar.bQA);
            }
            this.bQj.addView(this.bQo.contentView);
            this.bQk.addView(this.bQo.bQz);
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
        this.bQj.removeAllViews();
        this.bQk.removeAllViews();
        this.bQo = new a(getContext());
        final a aVar = (a) this.bQo;
        aVar.setData(list);
        aVar.bQw.setSelected(aVar.bQy.Xk());
        aVar.bQw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.bQy.m24do(!aVar.bQy.Xk());
                ((a) GiftPanelSelectMicrophoneSendView.this.bQo).bQw.setSelected(aVar.bQy.Xk());
                if (GiftPanelSelectMicrophoneSendView.this.bQm != null) {
                    GiftPanelSelectMicrophoneSendView.this.bQm.onChange();
                }
            }
        });
        e eVar = aVar.bQy;
        e eVar2 = aVar.bQy;
        eVar2.getClass();
        eVar.a(new e.a(eVar2, aVar) { // from class: com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.4
            final /* synthetic */ a bQu;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
                this.bQu = aVar;
                eVar2.getClass();
            }

            @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.e.a
            void onItemClick(int i2) {
                ((a) GiftPanelSelectMicrophoneSendView.this.bQo).bQw.setSelected(this.bQu.bQy.Xk());
                if (GiftPanelSelectMicrophoneSendView.this.bQm != null) {
                    GiftPanelSelectMicrophoneSendView.this.bQm.onChange();
                }
            }
        });
        this.bQj.addView(this.bQo.contentView);
        if (z) {
            this.bQk.addView(this.bQo.bQz);
        }
    }

    public void setAttentionAndInfo(PersonUserData personUserData) {
        if (personUserData != null && personUserData.user_info != null && personUserData.relation_info != null && this.bQo != null && (this.bQo instanceof h)) {
            ((h) this.bQo).dr(!TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), personUserData.user_info.user_id) && personUserData.relation_info.follow_status == 0);
            ((h) this.bQo).dq(true);
        }
    }

    public void WR() {
        if (this.bQo != null && (this.bQo instanceof h)) {
            ((h) this.bQo).dr(false);
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
                if (com.baidu.live.al.b.Wy().iQ(alaWheatInfoData.uk)) {
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
                if (com.baidu.live.al.b.Wy().iQ(next.uk)) {
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
            AlaWheatInfoData Wz = com.baidu.live.al.b.Wy().Wz();
            if (Wz != null) {
                AlaWheatInfoData alaWheatInfoData2 = (AlaWheatInfoData) Wz.clone();
                alaWheatInfoData2.userName = "房主";
                arrayList.add(new d(alaWheatInfoData2, "房主"));
            }
        } else {
            dVar2.bQA.userName = "房主";
            arrayList.add(dVar2);
        }
        if (TbadkCoreApplication.isLogin() && arrayList.size() > 0) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                if (TextUtils.equals(String.valueOf(ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount())), ((d) it2.next()).bQA.uk)) {
                    it2.remove();
                }
            }
        }
        if (arrayList != null) {
            for (d dVar7 : arrayList) {
                dVar7.bQA.isSelected = com.baidu.live.al.b.Wy().iT(dVar7.bQA.uk);
            }
        }
        return arrayList;
    }

    public i getSelectMicrophoneList() {
        i iVar = new i();
        ArrayList arrayList = new ArrayList();
        iVar.bQM = this.bQr;
        if (this.bQo != null) {
            if (this.bQo instanceof h) {
                if (((h) this.bQo).bQI != null) {
                    arrayList.add(((h) this.bQo).bQI);
                }
            } else if (this.bQo instanceof a) {
                for (AlaWheatInfoData alaWheatInfoData : ((a) this.bQo).getData()) {
                    if (alaWheatInfoData.isSelected) {
                        arrayList.add(alaWheatInfoData);
                    }
                }
            }
        }
        iVar.bQN = arrayList;
        return iVar;
    }

    /* loaded from: classes4.dex */
    public class i {
        public String[] bQM;
        public List<AlaWheatInfoData> bQN;

        public i() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public abstract class b {
        protected View bQz;
        protected View contentView = getContentView();

        protected abstract int Xg();

        abstract void Xh();

        abstract void Xi();

        protected abstract View getContentView();

        b(Context context) {
            this.bQz = LayoutInflater.from(context).inflate(Xg(), (ViewGroup) null, false);
            Xh();
            Xi();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class h extends b {
        public TextView bQF;
        public AlaWheatInfoData bQI;
        public TextView bQJ;
        public AlaGiftMicrophoneOpBtn bQK;
        public AlaGiftMicrophoneOpBtn bQL;
        public HeadImageView bfS;

        h(Context context) {
            super(context);
        }

        @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.b
        protected View getContentView() {
            return LayoutInflater.from(GiftPanelSelectMicrophoneSendView.this.getContext()).inflate(a.g.yuyin_ala_gift_item_onlyone_microphone_headerview, (ViewGroup) null, false);
        }

        @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.b
        protected int Xg() {
            return a.g.yuyin_ala_gift_microphone_onlyone_footerview;
        }

        @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.b
        void Xh() {
            this.bfS = (HeadImageView) this.contentView.findViewById(a.f.yuyin_ala_gift_onlyone_microphone_header);
            this.bQF = (TextView) this.contentView.findViewById(a.f.yuyin_ala_gift_onlyone_microphone_number);
            this.bQJ = (TextView) this.contentView.findViewById(a.f.yuyin_ala_gift_onlyone_microphone_name);
            this.bfS.setIsRound(true);
        }

        @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.b
        void Xi() {
            this.bQK = (AlaGiftMicrophoneOpBtn) this.bQz.findViewById(a.f.yuyin_ala_gift_microphone_person_attention);
            this.bQL = (AlaGiftMicrophoneOpBtn) this.bQz.findViewById(a.f.yuyin_ala_gift_microphone_person_info);
            this.bQK.setSelected(true);
            this.bQL.setSelected(false);
        }

        public void b(d dVar) {
            if (dVar != null && dVar.bQA != null) {
                this.bQI = dVar.bQA;
                this.bfS.startLoad(dVar.bQA.portrait, 12, true);
                this.bQF.setText(dVar.posName);
                this.bQJ.setText(dVar.bQA.userName);
            }
        }

        public void dq(boolean z) {
            this.bQL.setVisibility(z ? 0 : 8);
        }

        public void dr(boolean z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bQL.getLayoutParams();
            if (!z) {
                layoutParams.leftMargin = 0;
                this.bQK.setVisibility(8);
            } else {
                layoutParams.leftMargin = BdUtilHelper.getDimens(GiftPanelSelectMicrophoneSendView.this.getContext(), a.d.sdk_ds20);
                this.bQK.setVisibility(0);
            }
            this.bQL.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends b {
        public AlphaGradientHListView bQv;
        public AlaGiftMicrophoneOpBtn bQw;
        private List<AlaWheatInfoData> bQx;
        public e bQy;

        a(Context context) {
            super(context);
            this.bQx = new ArrayList();
        }

        @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.b
        protected View getContentView() {
            return new AlphaGradientHListView(GiftPanelSelectMicrophoneSendView.this.getContext());
        }

        @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.b
        protected int Xg() {
            return a.g.yuyin_ala_gift_microphone_aboveone_footerview;
        }

        @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.b
        void Xh() {
            this.bQv = (AlphaGradientHListView) this.contentView;
            this.bQv.setShadowWidth(GiftPanelSelectMicrophoneSendView.this.getResources().getDimensionPixelOffset(a.d.sdk_ds56));
            this.bQv.setNeedAlphaShade(true);
            this.bQv.setColor(GiftPanelSelectMicrophoneSendView.this.getResources().getColor(a.c.sdk_white_alpha100), GiftPanelSelectMicrophoneSendView.this.getResources().getColor(a.c.sdk_white_alpha0));
            this.bQv.setSelector(new ColorDrawable(0));
            this.bQy = new e();
            this.bQv.setAdapter((ListAdapter) this.bQy);
        }

        @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.b
        void Xi() {
            this.bQw = (AlaGiftMicrophoneOpBtn) this.bQz.findViewById(a.f.yuyin_ala_gift_microphone_person_selectall);
            this.bQw.setSelected(true);
        }

        public List<AlaWheatInfoData> getData() {
            this.bQx.clear();
            if (this.bQy != null && this.bQy.getData() != null) {
                for (d dVar : this.bQy.getData()) {
                    this.bQx.add(dVar.bQA);
                }
            }
            return this.bQx;
        }

        public void setData(List<d> list) {
            this.bQy.setData(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d implements Cloneable {
        public AlaWheatInfoData bQA;
        public String posName;

        public d(AlaWheatInfoData alaWheatInfoData, String str) {
            this.bQA = alaWheatInfoData;
            this.posName = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* renamed from: Xj */
        public d clone() {
            d dVar = null;
            try {
                dVar = (d) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            if (dVar != null && this.bQA != null) {
                dVar.bQA = (AlaWheatInfoData) this.bQA.clone();
            }
            return dVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class e extends BaseAdapter {
        private List<d> bQB;
        private a bQC;

        e() {
        }

        public void a(a aVar) {
            this.bQC = aVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public abstract class a {
            abstract void onItemClick(int i);

            a() {
            }
        }

        public boolean Xk() {
            if (this.bQB == null || this.bQB.size() == 0) {
                return false;
            }
            for (d dVar : this.bQB) {
                if (!dVar.bQA.isSelected) {
                    return false;
                }
            }
            return true;
        }

        /* renamed from: do  reason: not valid java name */
        public void m24do(boolean z) {
            if (this.bQB != null) {
                for (d dVar : this.bQB) {
                    dVar.bQA.isSelected = z;
                    com.baidu.live.al.b.Wy().F(dVar.bQA.uk, dVar.bQA.isSelected);
                }
                notifyDataSetChanged();
            }
        }

        public List<d> getData() {
            return this.bQB;
        }

        public void setData(List<d> list) {
            this.bQB = list;
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.bQB == null) {
                return 0;
            }
            return this.bQB.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.bQB.get(i);
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
                bVar.al(view);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    dVar.bQA.isSelected = !dVar.bQA.isSelected;
                    com.baidu.live.al.b.Wy().F(dVar.bQA.uk, dVar.bQA.isSelected);
                    e.this.notifyDataSetChanged();
                    if (e.this.bQC != null) {
                        e.this.bQC.onItemClick(i);
                    }
                }
            });
            bVar.a(i, dVar);
            return view;
        }

        /* loaded from: classes4.dex */
        class b {
            public TextView bQF;
            public View bQG;
            public SafeFrameLayout bQH;
            public HeadImageView bfS;

            b() {
            }

            public int getLayoutId() {
                return a.g.yuyin_ala_gift_item_microphone_headerview;
            }

            public void al(View view) {
                this.bQG = view.findViewById(a.f.yuyin_ala_gift_microphone_content);
                this.bQH = (SafeFrameLayout) view.findViewById(a.f.yuyin_ala_gift_microphone_headwrap);
                this.bfS = (HeadImageView) view.findViewById(a.f.yuyin_ala_gift_microphone_header);
                this.bQF = (TextView) view.findViewById(a.f.yuyin_ala_gift_microphone_number);
                this.bfS.setIsRound(true);
            }

            public void a(int i, d dVar) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bQG.getLayoutParams();
                if (i > 0) {
                    layoutParams.leftMargin = BdUtilHelper.getDimens(GiftPanelSelectMicrophoneSendView.this.getContext(), a.d.sdk_ds8);
                } else {
                    layoutParams.leftMargin = 0;
                }
                this.bQG.setLayoutParams(layoutParams);
                if (dVar.bQA != null) {
                    this.bfS.setDefaultResource(a.e.yuyin_ala_gift_panel_wheat_header_loadfail);
                    this.bfS.setDefaultErrorResource(a.e.yuyin_ala_gift_panel_wheat_header_loadfail);
                    this.bfS.startLoad(TextUtils.isEmpty(dVar.bQA.portrait) ? "fail" : dVar.bQA.portrait, 12, false);
                    iV(dVar.posName);
                    dp(dVar.bQA.isSelected);
                }
            }

            public void dp(boolean z) {
                if (z) {
                    this.bQH.setBackgroundResource(a.e.ala_gift_circle_red_bg_header);
                } else {
                    this.bQH.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00000000")));
                }
                this.bQF.setSelected(z);
            }

            public void iV(String str) {
                if (!TextUtils.isEmpty(str)) {
                    int dip2px = str.length() > 1 ? BdUtilHelper.dip2px(GiftPanelSelectMicrophoneSendView.this.getContext(), BdUtilHelper.getDimens(GiftPanelSelectMicrophoneSendView.this.getContext(), a.d.sdk_ds3)) : 0;
                    this.bQF.setPadding(dip2px, 0, dip2px, 0);
                    this.bQF.setText(str);
                }
            }
        }
    }
}
