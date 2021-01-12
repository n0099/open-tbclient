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
import com.baidu.live.data.x;
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
    private FrameLayout bXb;
    private FrameLayout bXc;
    private a bXd;
    private b bXe;
    private c bXf;
    private com.baidu.live.yuyingift.widget.wheatlist.b bXg;
    private List<AlaWheatInfoData> bXh;
    private TextView bXi;
    private TextView bXj;
    private String[] bXk;

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
        this.bXf = cVar;
    }

    public void setCallback(a aVar) {
        this.bXd = aVar;
    }

    public void setOnSelectWheatChangeListener(b bVar) {
        this.bXe = bVar;
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
        this.bXi = (TextView) findViewById(a.f.ala_gift_microphone_title);
        this.bXj = (TextView) findViewById(a.f.yuyin_ala_gift_microphone_empty);
        this.bXb = (FrameLayout) findViewById(a.f.yuyin_ala_gift_microphone_person_content);
        this.bXc = (FrameLayout) findViewById(a.f.yuyin_ala_gift_microphone_op_content);
    }

    private boolean as(List<com.baidu.live.yuyingift.widget.wheatlist.d> list) {
        if (list == null || this.bXh == null || list.size() != this.bXh.size() || list.size() == 0) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!TextUtils.equals(list.get(i).bXr.uk, this.bXh.get(i).uk) || list.get(i).bXr.realWheatPosition != this.bXh.get(i).realWheatPosition) {
                return false;
            }
        }
        return true;
    }

    public void b(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2, String[] strArr) {
        ArrayList arrayList;
        com.baidu.live.yuyingift.widget.wheatlist.d dVar;
        AlaWheatInfoData ie;
        this.bXk = strArr;
        if (strArr == null || strArr.length == 0) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (String str : strArr) {
                if (!StringUtils.isNull(str) && (ie = com.baidu.live.aq.a.Wu().ie(str)) != null) {
                    arrayList.add(ie);
                }
            }
            if (ListUtils.isEmpty(arrayList)) {
                this.bXh = null;
                OD();
                return;
            }
        }
        if (!ListUtils.isEmpty(arrayList)) {
            if (!h(this.bXh, arrayList)) {
                this.bXh = arrayList;
                ArrayList arrayList2 = new ArrayList();
                for (AlaWheatInfoData alaWheatInfoData : this.bXh) {
                    AlaWheatInfoData alaWheatInfoData2 = (AlaWheatInfoData) alaWheatInfoData.clone();
                    alaWheatInfoData2.isSelected = true;
                    if (alaWheatInfoData2.isHost) {
                        dVar = new com.baidu.live.yuyingift.widget.wheatlist.d(alaWheatInfoData2, "主持");
                    } else {
                        x WA = com.baidu.live.aq.a.Wu().WA();
                        if (WA != null && WA.aGD != null && WA.aGD.isSweetStage()) {
                            dVar = new com.baidu.live.yuyingift.widget.wheatlist.d(alaWheatInfoData2, alaWheatInfoData2.phoneOrder + "麦");
                        } else {
                            dVar = new com.baidu.live.yuyingift.widget.wheatlist.d(alaWheatInfoData2, alaWheatInfoData2.realWheatPosition + "麦");
                        }
                    }
                    com.baidu.live.yuyingift.widget.wheatlist.d dVar2 = dVar;
                    k(dVar2.bXr.uk, dVar2.posName, true);
                    arrayList2.add(dVar2);
                }
                if (ListUtils.getCount(arrayList2) > 1) {
                    h((List<com.baidu.live.yuyingift.widget.wheatlist.d>) arrayList2, true);
                    return;
                } else if (ListUtils.getCount(arrayList2) == 1) {
                    a((com.baidu.live.yuyingift.widget.wheatlist.d) ListUtils.getItem(arrayList2, 0));
                    return;
                } else {
                    OD();
                    return;
                }
            }
            return;
        }
        List<com.baidu.live.yuyingift.widget.wheatlist.d> i = i(list, list2);
        if (!as(i)) {
            if (this.bXh == null) {
                this.bXh = new ArrayList();
            }
            this.bXh.clear();
            for (com.baidu.live.yuyingift.widget.wheatlist.d dVar3 : i) {
                this.bXh.add(dVar3.bXr);
            }
            if (ListUtils.getCount(i) > 0) {
                h(i, true);
            } else {
                OD();
            }
        }
    }

    private void OD() {
        this.bXb.removeAllViews();
        this.bXc.removeAllViews();
        this.bXi.setVisibility(8);
        this.bXj.setVisibility(0);
        if (this.bXe != null) {
            this.bXe.onChange();
        }
    }

    private void a(final com.baidu.live.yuyingift.widget.wheatlist.d dVar) {
        this.bXj.setVisibility(8);
        this.bXi.setVisibility(0);
        this.bXb.removeAllViews();
        this.bXc.removeAllViews();
        this.bXg = new e(getContext());
        if (dVar != null) {
            final e eVar = (e) this.bXg;
            eVar.b(dVar);
            eVar.bXu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.widget.wheatlist.GiftPanelSelectMicrophoneSendView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (GiftPanelSelectMicrophoneSendView.this.bXd != null) {
                        GiftPanelSelectMicrophoneSendView.this.bXd.a(dVar.bXr);
                        eVar.bXu.setStatus(3);
                    }
                }
            });
            eVar.bXv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.widget.wheatlist.GiftPanelSelectMicrophoneSendView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (GiftPanelSelectMicrophoneSendView.this.bXd != null) {
                        GiftPanelSelectMicrophoneSendView.this.bXd.b(dVar.bXr);
                    }
                    com.baidu.live.yuyingift.b.a.u(GiftPanelSelectMicrophoneSendView.this.bXk);
                }
            });
            if (this.bXf != null) {
                this.bXf.c(dVar.bXr);
            }
            this.bXb.addView(this.bXg.contentView);
            this.bXc.addView(this.bXg.bWS);
        }
    }

    private void g(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2) {
        boolean z;
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                String str = list.get(i).uk;
                if (com.baidu.live.aq.a.Wu().mo18if(str)) {
                    if (ListUtils.isEmpty(list2) && this.bXe != null) {
                        this.bXe.onChange();
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
                    if (!z && this.bXe != null) {
                        this.bXe.onChange();
                        return;
                    }
                }
            }
        }
    }

    private boolean h(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2) {
        g(list, list2);
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
        this.bXj.setVisibility(8);
        this.bXi.setVisibility(0);
        this.bXb.removeAllViews();
        this.bXc.removeAllViews();
        this.bXg = new com.baidu.live.yuyingift.widget.wheatlist.a(getContext());
        final com.baidu.live.yuyingift.widget.wheatlist.a aVar = (com.baidu.live.yuyingift.widget.wheatlist.a) this.bXg;
        aVar.setData(list);
        aVar.bWP.setSelected(aVar.bWR.Xx());
        aVar.bWP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.widget.wheatlist.GiftPanelSelectMicrophoneSendView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.bWR.dD(!aVar.bWR.Xx());
                ((com.baidu.live.yuyingift.widget.wheatlist.a) GiftPanelSelectMicrophoneSendView.this.bXg).bWP.setSelected(aVar.bWR.Xx());
                if (GiftPanelSelectMicrophoneSendView.this.bXe != null) {
                    GiftPanelSelectMicrophoneSendView.this.bXe.onChange();
                }
                com.baidu.live.yuyingift.b.a.q(GiftPanelSelectMicrophoneSendView.this.bXk);
            }
        });
        com.baidu.live.yuyingift.widget.wheatlist.c cVar = aVar.bWR;
        com.baidu.live.yuyingift.widget.wheatlist.c cVar2 = aVar.bWR;
        cVar2.getClass();
        cVar.a(new c.a(cVar2, aVar) { // from class: com.baidu.live.yuyingift.widget.wheatlist.GiftPanelSelectMicrophoneSendView.4
            final /* synthetic */ com.baidu.live.yuyingift.widget.wheatlist.a bXo;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
                this.bXo = aVar;
                cVar2.getClass();
            }

            @Override // com.baidu.live.yuyingift.widget.wheatlist.c.a
            void dR(int i) {
                ((com.baidu.live.yuyingift.widget.wheatlist.a) GiftPanelSelectMicrophoneSendView.this.bXg).bWP.setSelected(this.bXo.bWR.Xx());
                if (GiftPanelSelectMicrophoneSendView.this.bXe != null) {
                    GiftPanelSelectMicrophoneSendView.this.bXe.onChange();
                }
                com.baidu.live.yuyingift.b.a.r(GiftPanelSelectMicrophoneSendView.this.bXk);
            }
        });
        this.bXb.addView(this.bXg.contentView);
        if (z) {
            this.bXc.addView(this.bXg.bWS);
        }
    }

    public void setAttentionAndInfo(PersonUserData personUserData) {
        if (personUserData != null && personUserData.user_info != null && personUserData.relation_info != null && this.bXg != null && (this.bXg instanceof e)) {
            ((e) this.bXg).dG(!TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), personUserData.user_info.user_id) && personUserData.relation_info.follow_status == 0);
            ((e) this.bXg).dF(true);
        }
    }

    public void WN() {
        if (this.bXg != null && (this.bXg instanceof e)) {
            ((e) this.bXg).dG(false);
        }
    }

    private List<com.baidu.live.yuyingift.widget.wheatlist.d> i(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2) {
        com.baidu.live.yuyingift.widget.wheatlist.d dVar;
        com.baidu.live.yuyingift.widget.wheatlist.d dVar2;
        com.baidu.live.yuyingift.widget.wheatlist.d dVar3;
        ArrayList<com.baidu.live.yuyingift.widget.wheatlist.d> arrayList = new ArrayList();
        com.baidu.live.yuyingift.widget.wheatlist.d dVar4 = null;
        if (list == null) {
            dVar = null;
        } else {
            for (AlaWheatInfoData alaWheatInfoData : list) {
                com.baidu.live.yuyingift.widget.wheatlist.d dVar5 = new com.baidu.live.yuyingift.widget.wheatlist.d(alaWheatInfoData, "主持");
                arrayList.add(dVar5);
                if (com.baidu.live.aq.a.Wu().ic(alaWheatInfoData.uk)) {
                    dVar3 = dVar5.clone();
                    dVar3.bXr.userName = "房主";
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
                com.baidu.live.yuyingift.widget.wheatlist.d dVar6 = new com.baidu.live.yuyingift.widget.wheatlist.d(next, String.valueOf(next.realWheatPosition));
                arrayList.add(dVar6);
                if (com.baidu.live.aq.a.Wu().ic(next.uk)) {
                    dVar = dVar6.clone();
                    dVar.bXr.userName = "房主";
                    dVar.posName = "房主";
                } else {
                    dVar = dVar2;
                }
            }
        } else {
            dVar2 = dVar;
        }
        if (dVar2 == null) {
            AlaWheatInfoData Wv = com.baidu.live.aq.a.Wu().Wv();
            if (Wv != null) {
                AlaWheatInfoData alaWheatInfoData2 = (AlaWheatInfoData) Wv.clone();
                alaWheatInfoData2.userName = "房主";
                arrayList.add(new com.baidu.live.yuyingift.widget.wheatlist.d(alaWheatInfoData2, "房主"));
            }
        } else {
            arrayList.add(dVar2);
        }
        if (TbadkCoreApplication.isLogin() && arrayList.size() > 0) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                if (TextUtils.equals(String.valueOf(ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount())), ((com.baidu.live.yuyingift.widget.wheatlist.d) it2.next()).bXr.uk)) {
                    it2.remove();
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        if (arrayList != null) {
            for (com.baidu.live.yuyingift.widget.wheatlist.d dVar7 : arrayList) {
                if (TextUtils.equals("房主", dVar7.posName)) {
                    dVar7.bXr.isSelected = com.baidu.live.aq.a.Wu().mo18if(dVar7.posName);
                } else {
                    dVar7.bXr.isSelected = com.baidu.live.aq.a.Wu().mo18if(dVar7.bXr.uk);
                }
                arrayList2.add(dVar7.bXr);
            }
        }
        g(this.bXh, arrayList2);
        return arrayList;
    }

    public d getSelectMicrophoneList() {
        d dVar = new d();
        ArrayList arrayList = new ArrayList();
        dVar.bXp = this.bXk;
        if (this.bXb != null && this.bXb.getChildCount() > 0) {
            View childAt = this.bXb.getChildAt(0);
            if (this.bXg != null && childAt == this.bXg.contentView) {
                if (this.bXg instanceof e) {
                    if (((e) this.bXg).bXs != null) {
                        arrayList.add(((e) this.bXg).bXs);
                    }
                } else if (this.bXg instanceof com.baidu.live.yuyingift.widget.wheatlist.a) {
                    for (AlaWheatInfoData alaWheatInfoData : ((com.baidu.live.yuyingift.widget.wheatlist.a) this.bXg).getData()) {
                        if (alaWheatInfoData.isSelected) {
                            arrayList.add(alaWheatInfoData);
                        }
                    }
                }
            }
            dVar.bXq = arrayList;
        }
        return dVar;
    }

    public void Xy() {
        com.baidu.live.yuyingift.b.a.s(this.bXk);
    }

    public void Xz() {
        com.baidu.live.yuyingift.b.a.t(this.bXk);
    }

    public void XA() {
        com.baidu.live.yuyingift.b.a.v(this.bXk);
    }

    public void aW(String str, String str2) {
        com.baidu.live.yuyingift.b.a.a(this.bXk, str, str2);
    }

    /* loaded from: classes10.dex */
    public class d {
        public String[] bXp;
        public List<AlaWheatInfoData> bXq;

        public d() {
        }
    }

    public static void k(String str, String str2, boolean z) {
        if (TextUtils.equals("房主", str2)) {
            com.baidu.live.aq.a.Wu().G("房主", z);
        } else {
            com.baidu.live.aq.a.Wu().G(str, z);
        }
    }
}
