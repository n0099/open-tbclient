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
    private FrameLayout bRT;
    private FrameLayout bRU;
    private c bRV;
    private f bRW;
    private g bRX;
    private b bRY;
    private List<AlaWheatInfoData> bRZ;
    private List<d> bSa;
    private String[] bSb;

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
        this.bRX = gVar;
    }

    public void setCallback(c cVar) {
        this.bRV = cVar;
    }

    public void setOnSelectWheatChangeListener(f fVar) {
        this.bRW = fVar;
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
        this.bRT = (FrameLayout) findViewById(a.f.yuyin_ala_gift_microphone_person_content);
        this.bRU = (FrameLayout) findViewById(a.f.yuyin_ala_gift_microphone_op_content);
    }

    private boolean am(List<d> list) {
        if (list == null || this.bSa == null || list.size() != this.bSa.size() || list.size() == 0) {
            return false;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (!TextUtils.equals(list.get(i2).bSk.uk, this.bSa.get(i2).bSk.uk) || list.get(i2).bSk.realWheatPosition != this.bSa.get(i2).bSk.realWheatPosition) {
                return false;
            }
        }
        return true;
    }

    public void b(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2, String[] strArr) {
        ArrayList arrayList;
        d dVar;
        AlaWheatInfoData iY;
        this.bSb = strArr;
        if (strArr == null || strArr.length == 0) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (String str : strArr) {
                if (!StringUtils.isNull(str) && (iY = com.baidu.live.al.b.Xh().iY(str)) != null) {
                    arrayList.add(iY);
                }
            }
            if (ListUtils.isEmpty(arrayList)) {
                this.bRZ = null;
                h(null, false);
                return;
            }
        }
        if (!ListUtils.isEmpty(arrayList)) {
            if (!f(this.bRZ, arrayList)) {
                this.bRZ = arrayList;
                ArrayList arrayList2 = new ArrayList();
                for (AlaWheatInfoData alaWheatInfoData : this.bRZ) {
                    AlaWheatInfoData alaWheatInfoData2 = (AlaWheatInfoData) alaWheatInfoData.clone();
                    alaWheatInfoData2.isSelected = true;
                    com.baidu.live.al.b.Xh().F(alaWheatInfoData2.uk, true);
                    if (alaWheatInfoData2.isHost) {
                        dVar = new d(alaWheatInfoData2, "主持");
                    } else {
                        w Xn = com.baidu.live.al.b.Xh().Xn();
                        if (Xn != null && Xn.aJP != null && Xn.aJP.isSweetStage()) {
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
            if (this.bSa == null) {
                this.bSa = new ArrayList();
            }
            this.bSa.clear();
            for (d dVar2 : g2) {
                this.bSa.add(dVar2.clone());
            }
            h(g2, true);
        }
    }

    private void a(final d dVar) {
        this.bRT.removeAllViews();
        this.bRU.removeAllViews();
        this.bRY = new h(getContext());
        if (dVar != null) {
            h hVar = (h) this.bRY;
            hVar.b(dVar);
            hVar.bSu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (GiftPanelSelectMicrophoneSendView.this.bRV != null) {
                        GiftPanelSelectMicrophoneSendView.this.bRV.a(dVar.bSk);
                    }
                }
            });
            hVar.bSv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (GiftPanelSelectMicrophoneSendView.this.bRV != null) {
                        GiftPanelSelectMicrophoneSendView.this.bRV.b(dVar.bSk);
                    }
                }
            });
            if (this.bRX != null) {
                this.bRX.c(dVar.bSk);
            }
            this.bRT.addView(this.bRY.contentView);
            this.bRU.addView(this.bRY.bSj);
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
        this.bRT.removeAllViews();
        this.bRU.removeAllViews();
        this.bRY = new a(getContext());
        final a aVar = (a) this.bRY;
        aVar.setData(list);
        aVar.bSg.setSelected(aVar.bSi.XT());
        aVar.bSg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.bSi.dm(!aVar.bSi.XT());
                ((a) GiftPanelSelectMicrophoneSendView.this.bRY).bSg.setSelected(aVar.bSi.XT());
                if (GiftPanelSelectMicrophoneSendView.this.bRW != null) {
                    GiftPanelSelectMicrophoneSendView.this.bRW.onChange();
                }
            }
        });
        e eVar = aVar.bSi;
        e eVar2 = aVar.bSi;
        eVar2.getClass();
        eVar.a(new e.a(eVar2, aVar) { // from class: com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.4
            final /* synthetic */ a bSe;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
                this.bSe = aVar;
                eVar2.getClass();
            }

            @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.e.a
            void onItemClick(int i2) {
                ((a) GiftPanelSelectMicrophoneSendView.this.bRY).bSg.setSelected(this.bSe.bSi.XT());
                if (GiftPanelSelectMicrophoneSendView.this.bRW != null) {
                    GiftPanelSelectMicrophoneSendView.this.bRW.onChange();
                }
            }
        });
        this.bRT.addView(this.bRY.contentView);
        if (z) {
            this.bRU.addView(this.bRY.bSj);
        }
    }

    public void setAttentionAndInfo(PersonUserData personUserData) {
        if (personUserData != null && personUserData.user_info != null && personUserData.relation_info != null && this.bRY != null && (this.bRY instanceof h)) {
            ((h) this.bRY).dp(!TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), personUserData.user_info.user_id) && personUserData.relation_info.follow_status == 0);
            ((h) this.bRY).m24do(true);
        }
    }

    public void XA() {
        if (this.bRY != null && (this.bRY instanceof h)) {
            ((h) this.bRY).dp(false);
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
                if (com.baidu.live.al.b.Xh().iW(alaWheatInfoData.uk)) {
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
                if (com.baidu.live.al.b.Xh().iW(next.uk)) {
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
            AlaWheatInfoData Xi = com.baidu.live.al.b.Xh().Xi();
            if (Xi != null) {
                AlaWheatInfoData alaWheatInfoData2 = (AlaWheatInfoData) Xi.clone();
                alaWheatInfoData2.userName = "房主";
                arrayList.add(new d(alaWheatInfoData2, "房主"));
            }
        } else {
            dVar2.bSk.userName = "房主";
            arrayList.add(dVar2);
        }
        if (TbadkCoreApplication.isLogin() && arrayList.size() > 0) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                if (TextUtils.equals(String.valueOf(ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount())), ((d) it2.next()).bSk.uk)) {
                    it2.remove();
                }
            }
        }
        if (arrayList != null) {
            for (d dVar7 : arrayList) {
                dVar7.bSk.isSelected = com.baidu.live.al.b.Xh().iZ(dVar7.bSk.uk);
            }
        }
        return arrayList;
    }

    public i getSelectMicrophoneList() {
        i iVar = new i();
        ArrayList arrayList = new ArrayList();
        iVar.bSw = this.bSb;
        if (this.bRY != null) {
            if (this.bRY instanceof h) {
                if (((h) this.bRY).bSs != null) {
                    arrayList.add(((h) this.bRY).bSs);
                }
            } else if (this.bRY instanceof a) {
                for (AlaWheatInfoData alaWheatInfoData : ((a) this.bRY).getData()) {
                    if (alaWheatInfoData.isSelected) {
                        arrayList.add(alaWheatInfoData);
                    }
                }
            }
        }
        iVar.bSx = arrayList;
        return iVar;
    }

    /* loaded from: classes4.dex */
    public class i {
        public String[] bSw;
        public List<AlaWheatInfoData> bSx;

        public i() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public abstract class b {
        protected View bSj;
        protected View contentView = getContentView();

        protected abstract int XP();

        abstract void XQ();

        abstract void XR();

        protected abstract View getContentView();

        b(Context context) {
            this.bSj = LayoutInflater.from(context).inflate(XP(), (ViewGroup) null, false);
            XQ();
            XR();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class h extends b {
        public TextView bSp;
        public AlaWheatInfoData bSs;
        public TextView bSt;
        public AlaGiftMicrophoneOpBtn bSu;
        public AlaGiftMicrophoneOpBtn bSv;
        public HeadImageView bhE;

        h(Context context) {
            super(context);
        }

        @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.b
        protected View getContentView() {
            return LayoutInflater.from(GiftPanelSelectMicrophoneSendView.this.getContext()).inflate(a.g.yuyin_ala_gift_item_onlyone_microphone_headerview, (ViewGroup) null, false);
        }

        @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.b
        protected int XP() {
            return a.g.yuyin_ala_gift_microphone_onlyone_footerview;
        }

        @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.b
        void XQ() {
            this.bhE = (HeadImageView) this.contentView.findViewById(a.f.yuyin_ala_gift_onlyone_microphone_header);
            this.bSp = (TextView) this.contentView.findViewById(a.f.yuyin_ala_gift_onlyone_microphone_number);
            this.bSt = (TextView) this.contentView.findViewById(a.f.yuyin_ala_gift_onlyone_microphone_name);
            this.bhE.setIsRound(true);
        }

        @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.b
        void XR() {
            this.bSu = (AlaGiftMicrophoneOpBtn) this.bSj.findViewById(a.f.yuyin_ala_gift_microphone_person_attention);
            this.bSv = (AlaGiftMicrophoneOpBtn) this.bSj.findViewById(a.f.yuyin_ala_gift_microphone_person_info);
            this.bSu.setSelected(true);
            this.bSv.setSelected(false);
        }

        public void b(d dVar) {
            if (dVar != null && dVar.bSk != null) {
                this.bSs = dVar.bSk;
                this.bhE.startLoad(dVar.bSk.portrait, 12, true);
                this.bSp.setText(dVar.posName);
                this.bSt.setText(dVar.bSk.userName);
            }
        }

        /* renamed from: do  reason: not valid java name */
        public void m24do(boolean z) {
            this.bSv.setVisibility(z ? 0 : 8);
        }

        public void dp(boolean z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bSv.getLayoutParams();
            if (!z) {
                layoutParams.leftMargin = 0;
                this.bSu.setVisibility(8);
            } else {
                layoutParams.leftMargin = BdUtilHelper.getDimens(GiftPanelSelectMicrophoneSendView.this.getContext(), a.d.sdk_ds20);
                this.bSu.setVisibility(0);
            }
            this.bSv.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends b {
        public AlphaGradientHListView bSf;
        public AlaGiftMicrophoneOpBtn bSg;
        private List<AlaWheatInfoData> bSh;
        public e bSi;

        a(Context context) {
            super(context);
            this.bSh = new ArrayList();
        }

        @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.b
        protected View getContentView() {
            return new AlphaGradientHListView(GiftPanelSelectMicrophoneSendView.this.getContext());
        }

        @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.b
        protected int XP() {
            return a.g.yuyin_ala_gift_microphone_aboveone_footerview;
        }

        @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.b
        void XQ() {
            this.bSf = (AlphaGradientHListView) this.contentView;
            this.bSf.setShadowWidth(GiftPanelSelectMicrophoneSendView.this.getResources().getDimensionPixelOffset(a.d.sdk_ds56));
            this.bSf.setNeedAlphaShade(true);
            this.bSf.setColor(GiftPanelSelectMicrophoneSendView.this.getResources().getColor(a.c.sdk_white_alpha100), GiftPanelSelectMicrophoneSendView.this.getResources().getColor(a.c.sdk_white_alpha0));
            this.bSf.setSelector(new ColorDrawable(0));
            this.bSi = new e();
            this.bSf.setAdapter((ListAdapter) this.bSi);
        }

        @Override // com.baidu.live.yuyingift.widget.panel.GiftPanelSelectMicrophoneSendView.b
        void XR() {
            this.bSg = (AlaGiftMicrophoneOpBtn) this.bSj.findViewById(a.f.yuyin_ala_gift_microphone_person_selectall);
            this.bSg.setSelected(true);
        }

        public List<AlaWheatInfoData> getData() {
            this.bSh.clear();
            if (this.bSi != null && this.bSi.getData() != null) {
                for (d dVar : this.bSi.getData()) {
                    this.bSh.add(dVar.bSk);
                }
            }
            return this.bSh;
        }

        public void setData(List<d> list) {
            this.bSi.setData(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d implements Cloneable {
        public AlaWheatInfoData bSk;
        public String posName;

        public d(AlaWheatInfoData alaWheatInfoData, String str) {
            this.bSk = alaWheatInfoData;
            this.posName = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* renamed from: XS */
        public d clone() {
            d dVar = null;
            try {
                dVar = (d) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            if (dVar != null && this.bSk != null) {
                dVar.bSk = (AlaWheatInfoData) this.bSk.clone();
            }
            return dVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class e extends BaseAdapter {
        private List<d> bSl;
        private a bSm;

        e() {
        }

        public void a(a aVar) {
            this.bSm = aVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public abstract class a {
            abstract void onItemClick(int i);

            a() {
            }
        }

        public boolean XT() {
            if (this.bSl == null || this.bSl.size() == 0) {
                return false;
            }
            for (d dVar : this.bSl) {
                if (!dVar.bSk.isSelected) {
                    return false;
                }
            }
            return true;
        }

        public void dm(boolean z) {
            if (this.bSl != null) {
                for (d dVar : this.bSl) {
                    dVar.bSk.isSelected = z;
                    com.baidu.live.al.b.Xh().F(dVar.bSk.uk, dVar.bSk.isSelected);
                }
                notifyDataSetChanged();
            }
        }

        public List<d> getData() {
            return this.bSl;
        }

        public void setData(List<d> list) {
            this.bSl = list;
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.bSl == null) {
                return 0;
            }
            return this.bSl.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.bSl.get(i);
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
                    dVar.bSk.isSelected = !dVar.bSk.isSelected;
                    com.baidu.live.al.b.Xh().F(dVar.bSk.uk, dVar.bSk.isSelected);
                    e.this.notifyDataSetChanged();
                    if (e.this.bSm != null) {
                        e.this.bSm.onItemClick(i);
                    }
                }
            });
            bVar.a(i, dVar);
            return view;
        }

        /* loaded from: classes4.dex */
        class b {
            public TextView bSp;
            public View bSq;
            public SafeFrameLayout bSr;
            public HeadImageView bhE;

            b() {
            }

            public int getLayoutId() {
                return a.g.yuyin_ala_gift_item_microphone_headerview;
            }

            public void al(View view) {
                this.bSq = view.findViewById(a.f.yuyin_ala_gift_microphone_content);
                this.bSr = (SafeFrameLayout) view.findViewById(a.f.yuyin_ala_gift_microphone_headwrap);
                this.bhE = (HeadImageView) view.findViewById(a.f.yuyin_ala_gift_microphone_header);
                this.bSp = (TextView) view.findViewById(a.f.yuyin_ala_gift_microphone_number);
                this.bhE.setIsRound(true);
            }

            public void a(int i, d dVar) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bSq.getLayoutParams();
                if (i > 0) {
                    layoutParams.leftMargin = BdUtilHelper.getDimens(GiftPanelSelectMicrophoneSendView.this.getContext(), a.d.sdk_ds8);
                } else {
                    layoutParams.leftMargin = 0;
                }
                this.bSq.setLayoutParams(layoutParams);
                if (dVar.bSk != null) {
                    this.bhE.setDefaultResource(a.e.yuyin_ala_gift_panel_wheat_header_loadfail);
                    this.bhE.setDefaultErrorResource(a.e.yuyin_ala_gift_panel_wheat_header_loadfail);
                    this.bhE.startLoad(TextUtils.isEmpty(dVar.bSk.portrait) ? "fail" : dVar.bSk.portrait, 12, false);
                    jb(dVar.posName);
                    dn(dVar.bSk.isSelected);
                }
            }

            public void dn(boolean z) {
                if (z) {
                    this.bSr.setBackgroundResource(a.e.ala_gift_circle_red_bg_header);
                } else {
                    this.bSr.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00000000")));
                }
                this.bSp.setSelected(z);
            }

            public void jb(String str) {
                if (!TextUtils.isEmpty(str)) {
                    int dip2px = str.length() > 1 ? BdUtilHelper.dip2px(GiftPanelSelectMicrophoneSendView.this.getContext(), BdUtilHelper.getDimens(GiftPanelSelectMicrophoneSendView.this.getContext(), a.d.sdk_ds3)) : 0;
                    this.bSp.setPadding(dip2px, 0, dip2px, 0);
                    this.bSp.setText(str);
                }
            }
        }
    }
}
