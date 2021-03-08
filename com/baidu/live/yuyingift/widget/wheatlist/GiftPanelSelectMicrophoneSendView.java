package com.baidu.live.yuyingift.widget.wheatlist;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.data.ab;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.yuyingift.widget.wheatlist.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public class GiftPanelSelectMicrophoneSendView extends RelativeLayout {
    private FrameLayout ccF;
    private FrameLayout ccG;
    private a ccH;
    private b ccI;
    private c ccJ;
    private com.baidu.live.yuyingift.widget.wheatlist.b ccK;
    private List<AlaWheatInfoData> ccL;
    private TextView ccM;
    private TextView ccN;
    private String[] ccO;

    /* loaded from: classes10.dex */
    public interface a {
        void a(AlaWheatInfoData alaWheatInfoData);

        void b(AlaWheatInfoData alaWheatInfoData);
    }

    /* loaded from: classes10.dex */
    public interface b {
        void onChange();
    }

    /* loaded from: classes10.dex */
    public interface c {
        void c(AlaWheatInfoData alaWheatInfoData);
    }

    public void setOnSetDataListener(c cVar) {
        this.ccJ = cVar;
    }

    public void setCallback(a aVar) {
        this.ccH = aVar;
    }

    public void setOnSelectWheatChangeListener(b bVar) {
        this.ccI = bVar;
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
        this.ccM = (TextView) findViewById(a.f.ala_gift_microphone_title);
        this.ccN = (TextView) findViewById(a.f.yuyin_ala_gift_microphone_empty);
        this.ccF = (FrameLayout) findViewById(a.f.yuyin_ala_gift_microphone_person_content);
        this.ccG = (FrameLayout) findViewById(a.f.yuyin_ala_gift_microphone_op_content);
    }

    private boolean at(List<com.baidu.live.yuyingift.widget.wheatlist.d> list) {
        if (list == null || this.ccL == null || list.size() != this.ccL.size() || list.size() == 0) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!TextUtils.equals(list.get(i).ccV.uk, this.ccL.get(i).uk) || list.get(i).ccV.realWheatPosition != this.ccL.get(i).realWheatPosition) {
                return false;
            }
        }
        return true;
    }

    public void b(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2, String[] strArr) {
        boolean z;
        ArrayList arrayList;
        com.baidu.live.yuyingift.widget.wheatlist.d dVar;
        AlaWheatInfoData iQ;
        this.ccO = strArr;
        if (com.baidu.live.ao.a.Ym().Yt() == null || com.baidu.live.ao.a.Ym().Yt().aKy == null) {
            z = false;
        } else {
            z = com.baidu.live.ao.a.Ym().Yt().aKy.getRoomMode() == 100;
        }
        if (strArr == null || strArr.length == 0) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (String str : strArr) {
                if (!StringUtils.isNull(str) && (iQ = com.baidu.live.ao.a.Ym().iQ(str)) != null) {
                    arrayList.add(iQ);
                }
            }
            if (ListUtils.isEmpty(arrayList)) {
                this.ccL = null;
                Qf();
                return;
            }
        }
        if (!ListUtils.isEmpty(arrayList)) {
            if (!g(this.ccL, arrayList)) {
                this.ccL = arrayList;
                ArrayList arrayList2 = new ArrayList();
                for (AlaWheatInfoData alaWheatInfoData : this.ccL) {
                    AlaWheatInfoData alaWheatInfoData2 = (AlaWheatInfoData) alaWheatInfoData.clone();
                    alaWheatInfoData2.isSelected = true;
                    if (alaWheatInfoData2.isHost) {
                        if (z) {
                            dVar = new com.baidu.live.yuyingift.widget.wheatlist.d(alaWheatInfoData2, "");
                        } else {
                            dVar = new com.baidu.live.yuyingift.widget.wheatlist.d(alaWheatInfoData2, "主持");
                        }
                    } else {
                        ab Yt = com.baidu.live.ao.a.Ym().Yt();
                        if (Yt != null && Yt.aKy != null && Yt.aKy.isSweetStage()) {
                            dVar = new com.baidu.live.yuyingift.widget.wheatlist.d(alaWheatInfoData2, alaWheatInfoData2.phoneOrder + "麦");
                        } else if (z) {
                            dVar = new com.baidu.live.yuyingift.widget.wheatlist.d(alaWheatInfoData2, "");
                        } else {
                            dVar = new com.baidu.live.yuyingift.widget.wheatlist.d(alaWheatInfoData2, alaWheatInfoData2.realWheatPosition + "麦");
                        }
                    }
                    com.baidu.live.yuyingift.widget.wheatlist.d dVar2 = dVar;
                    k(dVar2.ccV.uk, dVar2.posName, true);
                    arrayList2.add(dVar2);
                }
                if (ListUtils.getCount(arrayList2) > 1) {
                    h(arrayList2, true);
                    return;
                } else if (ListUtils.getCount(arrayList2) == 1) {
                    a((com.baidu.live.yuyingift.widget.wheatlist.d) ListUtils.getItem(arrayList2, 0));
                    return;
                } else {
                    Qf();
                    return;
                }
            }
            return;
        }
        List<com.baidu.live.yuyingift.widget.wheatlist.d> a2 = a(list, list2, z);
        if (!at(a2)) {
            if (this.ccL == null) {
                this.ccL = new ArrayList();
            }
            this.ccL.clear();
            for (com.baidu.live.yuyingift.widget.wheatlist.d dVar3 : a2) {
                this.ccL.add(dVar3.ccV);
            }
            int count = ListUtils.getCount(a2);
            if (count > 0) {
                if (z && count == 1) {
                    a(a2.get(0));
                    return;
                } else {
                    h(a2, true);
                    return;
                }
            }
            Qf();
        }
    }

    private void Qf() {
        this.ccF.removeAllViews();
        this.ccG.removeAllViews();
        this.ccM.setVisibility(8);
        this.ccN.setVisibility(0);
        if (this.ccI != null) {
            this.ccI.onChange();
        }
    }

    private void a(final com.baidu.live.yuyingift.widget.wheatlist.d dVar) {
        this.ccN.setVisibility(8);
        this.ccM.setVisibility(0);
        this.ccF.removeAllViews();
        this.ccG.removeAllViews();
        this.ccK = new e(getContext());
        if (dVar != null) {
            final e eVar = (e) this.ccK;
            eVar.b(dVar);
            eVar.ccY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.widget.wheatlist.GiftPanelSelectMicrophoneSendView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (GiftPanelSelectMicrophoneSendView.this.ccH != null) {
                        GiftPanelSelectMicrophoneSendView.this.ccH.a(dVar.ccV);
                        eVar.ccY.setStatus(3);
                    }
                }
            });
            eVar.ccZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.widget.wheatlist.GiftPanelSelectMicrophoneSendView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (GiftPanelSelectMicrophoneSendView.this.ccH != null) {
                        GiftPanelSelectMicrophoneSendView.this.ccH.b(dVar.ccV);
                    }
                    com.baidu.live.yuyingift.b.a.u(GiftPanelSelectMicrophoneSendView.this.ccO);
                }
            });
            if (this.ccJ != null) {
                this.ccJ.c(dVar.ccV);
            }
            this.ccF.addView(this.ccK.contentView);
            this.ccG.addView(this.ccK.ccw);
        }
    }

    private void f(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2) {
        boolean z;
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                String str = list.get(i).uk;
                if (com.baidu.live.ao.a.Ym().iR(str)) {
                    if (ListUtils.isEmpty(list2) && this.ccI != null) {
                        this.ccI.onChange();
                        return;
                    }
                    int i2 = 0;
                    while (true) {
                        if (i2 < list2.size()) {
                            if (!TextUtils.equals(list2.get(i2).uk, str)) {
                                i2++;
                            } else {
                                z = true;
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (!z && this.ccI != null) {
                        this.ccI.onChange();
                        return;
                    }
                }
            }
        }
    }

    private boolean g(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2) {
        f(list, list2);
        int count = ListUtils.getCount(list);
        if (count != ListUtils.getCount(list2)) {
            return false;
        }
        for (int i = 0; i < count; i++) {
            AlaWheatInfoData alaWheatInfoData = (AlaWheatInfoData) ListUtils.getItem(list, i);
            AlaWheatInfoData alaWheatInfoData2 = (AlaWheatInfoData) ListUtils.getItem(list2, i);
            if (alaWheatInfoData == null || alaWheatInfoData2 == null || !TextUtils.equals(alaWheatInfoData.uk, alaWheatInfoData2.uk) || alaWheatInfoData.realWheatPosition != alaWheatInfoData2.realWheatPosition) {
                return false;
            }
        }
        return true;
    }

    private void h(List<com.baidu.live.yuyingift.widget.wheatlist.d> list, boolean z) {
        this.ccN.setVisibility(8);
        this.ccM.setVisibility(0);
        this.ccF.removeAllViews();
        this.ccG.removeAllViews();
        this.ccK = new com.baidu.live.yuyingift.widget.wheatlist.a(getContext());
        final com.baidu.live.yuyingift.widget.wheatlist.a aVar = (com.baidu.live.yuyingift.widget.wheatlist.a) this.ccK;
        aVar.setData(list);
        aVar.cct.setSelected(aVar.ccv.Zq());
        aVar.cct.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.widget.wheatlist.GiftPanelSelectMicrophoneSendView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.ccv.dL(!aVar.ccv.Zq());
                ((com.baidu.live.yuyingift.widget.wheatlist.a) GiftPanelSelectMicrophoneSendView.this.ccK).cct.setSelected(aVar.ccv.Zq());
                if (GiftPanelSelectMicrophoneSendView.this.ccI != null) {
                    GiftPanelSelectMicrophoneSendView.this.ccI.onChange();
                }
                com.baidu.live.yuyingift.b.a.q(GiftPanelSelectMicrophoneSendView.this.ccO);
            }
        });
        com.baidu.live.yuyingift.widget.wheatlist.c cVar = aVar.ccv;
        com.baidu.live.yuyingift.widget.wheatlist.c cVar2 = aVar.ccv;
        cVar2.getClass();
        cVar.a(new c.a(cVar2, aVar) { // from class: com.baidu.live.yuyingift.widget.wheatlist.GiftPanelSelectMicrophoneSendView.4
            final /* synthetic */ com.baidu.live.yuyingift.widget.wheatlist.a ccS;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
                this.ccS = aVar;
                cVar2.getClass();
            }

            @Override // com.baidu.live.yuyingift.widget.wheatlist.c.a
            void dW(int i) {
                ((com.baidu.live.yuyingift.widget.wheatlist.a) GiftPanelSelectMicrophoneSendView.this.ccK).cct.setSelected(this.ccS.ccv.Zq());
                if (GiftPanelSelectMicrophoneSendView.this.ccI != null) {
                    GiftPanelSelectMicrophoneSendView.this.ccI.onChange();
                }
                com.baidu.live.yuyingift.b.a.r(GiftPanelSelectMicrophoneSendView.this.ccO);
            }
        });
        this.ccF.addView(this.ccK.contentView);
        if (z) {
            this.ccG.addView(this.ccK.ccw);
        }
    }

    public void setAttentionAndInfo(PersonUserData personUserData) {
        if (personUserData != null && personUserData.user_info != null && personUserData.relation_info != null && this.ccK != null && (this.ccK instanceof e)) {
            ((e) this.ccK).dO(!TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), personUserData.user_info.user_id) && personUserData.relation_info.follow_status == 0);
            ((e) this.ccK).dN(true);
        }
    }

    public void YG() {
        if (this.ccK != null && (this.ccK instanceof e)) {
            ((e) this.ccK).dO(false);
        }
    }

    private List<com.baidu.live.yuyingift.widget.wheatlist.d> a(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2, boolean z) {
        com.baidu.live.yuyingift.widget.wheatlist.d dVar;
        com.baidu.live.yuyingift.widget.wheatlist.d dVar2;
        com.baidu.live.yuyingift.widget.wheatlist.d dVar3;
        ArrayList<com.baidu.live.yuyingift.widget.wheatlist.d> arrayList = new ArrayList();
        com.baidu.live.yuyingift.widget.wheatlist.d dVar4 = null;
        if (list == null) {
            dVar = null;
        } else {
            for (AlaWheatInfoData alaWheatInfoData : list) {
                if (z) {
                    dVar3 = new com.baidu.live.yuyingift.widget.wheatlist.d(alaWheatInfoData, "");
                } else {
                    com.baidu.live.yuyingift.widget.wheatlist.d dVar5 = new com.baidu.live.yuyingift.widget.wheatlist.d(alaWheatInfoData, "主持");
                    arrayList.add(dVar5);
                    if (com.baidu.live.ao.a.Ym().iO(alaWheatInfoData.uk)) {
                        dVar3 = dVar5.clone();
                        dVar3.ccV.userName = "房主";
                        dVar3.posName = "房主";
                    } else {
                        dVar3 = dVar4;
                    }
                }
                dVar4 = dVar3;
            }
            dVar = dVar4;
        }
        if (list2 != null && !z) {
            Iterator<AlaWheatInfoData> it = list2.iterator();
            while (true) {
                dVar2 = dVar;
                if (!it.hasNext()) {
                    break;
                }
                AlaWheatInfoData next = it.next();
                com.baidu.live.yuyingift.widget.wheatlist.d dVar6 = new com.baidu.live.yuyingift.widget.wheatlist.d(next, String.valueOf(next.realWheatPosition));
                arrayList.add(dVar6);
                if (com.baidu.live.ao.a.Ym().iO(next.uk)) {
                    dVar = dVar6.clone();
                    dVar.ccV.userName = "房主";
                    dVar.posName = "房主";
                } else {
                    dVar = dVar2;
                }
            }
            dVar = dVar2;
        }
        if (dVar == null) {
            AlaWheatInfoData Yo = com.baidu.live.ao.a.Ym().Yo();
            if (Yo != null) {
                AlaWheatInfoData alaWheatInfoData2 = (AlaWheatInfoData) Yo.clone();
                if (z) {
                    arrayList.add(new com.baidu.live.yuyingift.widget.wheatlist.d(alaWheatInfoData2, ""));
                } else {
                    alaWheatInfoData2.userName = "房主";
                    arrayList.add(new com.baidu.live.yuyingift.widget.wheatlist.d(alaWheatInfoData2, "房主"));
                }
            }
        } else {
            arrayList.add(dVar);
        }
        if (TbadkCoreApplication.isLogin() && arrayList.size() > 0) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                if (TextUtils.equals(String.valueOf(ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount())), ((com.baidu.live.yuyingift.widget.wheatlist.d) it2.next()).ccV.uk)) {
                    it2.remove();
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        if (arrayList != null) {
            for (com.baidu.live.yuyingift.widget.wheatlist.d dVar7 : arrayList) {
                if (TextUtils.equals("房主", dVar7.posName)) {
                    dVar7.ccV.isSelected = com.baidu.live.ao.a.Ym().iR(dVar7.posName);
                } else {
                    dVar7.ccV.isSelected = com.baidu.live.ao.a.Ym().iR(dVar7.ccV.uk);
                }
                arrayList2.add(dVar7.ccV);
            }
        }
        f(this.ccL, arrayList2);
        return arrayList;
    }

    public d getSelectMicrophoneList() {
        d dVar = new d();
        ArrayList arrayList = new ArrayList();
        dVar.ccT = this.ccO;
        if (this.ccF != null && this.ccF.getChildCount() > 0) {
            View childAt = this.ccF.getChildAt(0);
            if (this.ccK != null && childAt == this.ccK.contentView) {
                if (this.ccK instanceof e) {
                    if (((e) this.ccK).ccW != null) {
                        arrayList.add(((e) this.ccK).ccW);
                    }
                } else if (this.ccK instanceof com.baidu.live.yuyingift.widget.wheatlist.a) {
                    for (AlaWheatInfoData alaWheatInfoData : ((com.baidu.live.yuyingift.widget.wheatlist.a) this.ccK).getData()) {
                        if (alaWheatInfoData.isSelected) {
                            arrayList.add(alaWheatInfoData);
                        }
                    }
                }
            }
            dVar.ccU = arrayList;
        }
        return dVar;
    }

    public void Zr() {
        com.baidu.live.yuyingift.b.a.s(this.ccO);
    }

    public void Zs() {
        com.baidu.live.yuyingift.b.a.t(this.ccO);
    }

    public void Zt() {
        com.baidu.live.yuyingift.b.a.v(this.ccO);
    }

    public void aV(String str, String str2) {
        com.baidu.live.yuyingift.b.a.a(this.ccO, str, str2);
    }

    /* loaded from: classes10.dex */
    public class d {
        public String[] ccT;
        public List<AlaWheatInfoData> ccU;

        public d() {
        }
    }

    public static void k(String str, String str2, boolean z) {
        if (TextUtils.equals("房主", str2)) {
            com.baidu.live.ao.a.Ym().G("房主", z);
        } else {
            com.baidu.live.ao.a.Ym().G(str, z);
        }
    }
}
