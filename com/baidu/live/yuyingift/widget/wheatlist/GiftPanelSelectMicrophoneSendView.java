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
/* loaded from: classes11.dex */
public class GiftPanelSelectMicrophoneSendView extends RelativeLayout {
    private FrameLayout cbO;
    private FrameLayout cbP;
    private a cbQ;
    private b cbR;
    private c cbS;
    private com.baidu.live.yuyingift.widget.wheatlist.b cbT;
    private List<AlaWheatInfoData> cbU;
    private TextView cbV;
    private TextView cbW;
    private String[] cbX;

    /* loaded from: classes11.dex */
    public interface a {
        void a(AlaWheatInfoData alaWheatInfoData);

        void b(AlaWheatInfoData alaWheatInfoData);
    }

    /* loaded from: classes11.dex */
    public interface b {
        void onChange();
    }

    /* loaded from: classes11.dex */
    public interface c {
        void c(AlaWheatInfoData alaWheatInfoData);
    }

    public void setOnSetDataListener(c cVar) {
        this.cbS = cVar;
    }

    public void setCallback(a aVar) {
        this.cbQ = aVar;
    }

    public void setOnSelectWheatChangeListener(b bVar) {
        this.cbR = bVar;
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
        this.cbV = (TextView) findViewById(a.f.ala_gift_microphone_title);
        this.cbW = (TextView) findViewById(a.f.yuyin_ala_gift_microphone_empty);
        this.cbO = (FrameLayout) findViewById(a.f.yuyin_ala_gift_microphone_person_content);
        this.cbP = (FrameLayout) findViewById(a.f.yuyin_ala_gift_microphone_op_content);
    }

    private boolean as(List<com.baidu.live.yuyingift.widget.wheatlist.d> list) {
        if (list == null || this.cbU == null || list.size() != this.cbU.size() || list.size() == 0) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!TextUtils.equals(list.get(i).cce.uk, this.cbU.get(i).uk) || list.get(i).cce.realWheatPosition != this.cbU.get(i).realWheatPosition) {
                return false;
            }
        }
        return true;
    }

    public void b(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2, String[] strArr) {
        ArrayList arrayList;
        com.baidu.live.yuyingift.widget.wheatlist.d dVar;
        AlaWheatInfoData jp;
        this.cbX = strArr;
        if (strArr == null || strArr.length == 0) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (String str : strArr) {
                if (!StringUtils.isNull(str) && (jp = com.baidu.live.aq.a.aan().jp(str)) != null) {
                    arrayList.add(jp);
                }
            }
            if (ListUtils.isEmpty(arrayList)) {
                this.cbU = null;
                Sy();
                return;
            }
        }
        if (!ListUtils.isEmpty(arrayList)) {
            if (!h(this.cbU, arrayList)) {
                this.cbU = arrayList;
                ArrayList arrayList2 = new ArrayList();
                for (AlaWheatInfoData alaWheatInfoData : this.cbU) {
                    AlaWheatInfoData alaWheatInfoData2 = (AlaWheatInfoData) alaWheatInfoData.clone();
                    alaWheatInfoData2.isSelected = true;
                    if (alaWheatInfoData2.isHost) {
                        dVar = new com.baidu.live.yuyingift.widget.wheatlist.d(alaWheatInfoData2, "主持");
                    } else {
                        x aat = com.baidu.live.aq.a.aan().aat();
                        if (aat != null && aat.aLq != null && aat.aLq.isSweetStage()) {
                            dVar = new com.baidu.live.yuyingift.widget.wheatlist.d(alaWheatInfoData2, alaWheatInfoData2.phoneOrder + "麦");
                        } else {
                            dVar = new com.baidu.live.yuyingift.widget.wheatlist.d(alaWheatInfoData2, alaWheatInfoData2.realWheatPosition + "麦");
                        }
                    }
                    com.baidu.live.yuyingift.widget.wheatlist.d dVar2 = dVar;
                    k(dVar2.cce.uk, dVar2.posName, true);
                    arrayList2.add(dVar2);
                }
                if (ListUtils.getCount(arrayList2) > 1) {
                    h((List<com.baidu.live.yuyingift.widget.wheatlist.d>) arrayList2, true);
                    return;
                } else if (ListUtils.getCount(arrayList2) == 1) {
                    a((com.baidu.live.yuyingift.widget.wheatlist.d) ListUtils.getItem(arrayList2, 0));
                    return;
                } else {
                    Sy();
                    return;
                }
            }
            return;
        }
        List<com.baidu.live.yuyingift.widget.wheatlist.d> i = i(list, list2);
        if (!as(i)) {
            if (this.cbU == null) {
                this.cbU = new ArrayList();
            }
            this.cbU.clear();
            for (com.baidu.live.yuyingift.widget.wheatlist.d dVar3 : i) {
                this.cbU.add(dVar3.cce);
            }
            if (ListUtils.getCount(i) > 0) {
                h(i, true);
            } else {
                Sy();
            }
        }
    }

    private void Sy() {
        this.cbO.removeAllViews();
        this.cbP.removeAllViews();
        this.cbV.setVisibility(8);
        this.cbW.setVisibility(0);
        if (this.cbR != null) {
            this.cbR.onChange();
        }
    }

    private void a(final com.baidu.live.yuyingift.widget.wheatlist.d dVar) {
        this.cbW.setVisibility(8);
        this.cbV.setVisibility(0);
        this.cbO.removeAllViews();
        this.cbP.removeAllViews();
        this.cbT = new e(getContext());
        if (dVar != null) {
            final e eVar = (e) this.cbT;
            eVar.b(dVar);
            eVar.cch.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.widget.wheatlist.GiftPanelSelectMicrophoneSendView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (GiftPanelSelectMicrophoneSendView.this.cbQ != null) {
                        GiftPanelSelectMicrophoneSendView.this.cbQ.a(dVar.cce);
                        eVar.cch.setStatus(3);
                    }
                }
            });
            eVar.cci.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.widget.wheatlist.GiftPanelSelectMicrophoneSendView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (GiftPanelSelectMicrophoneSendView.this.cbQ != null) {
                        GiftPanelSelectMicrophoneSendView.this.cbQ.b(dVar.cce);
                    }
                    com.baidu.live.yuyingift.b.a.u(GiftPanelSelectMicrophoneSendView.this.cbX);
                }
            });
            if (this.cbS != null) {
                this.cbS.c(dVar.cce);
            }
            this.cbO.addView(this.cbT.contentView);
            this.cbP.addView(this.cbT.cbF);
        }
    }

    private void g(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2) {
        boolean z;
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                String str = list.get(i).uk;
                if (com.baidu.live.aq.a.aan().jq(str)) {
                    if (ListUtils.isEmpty(list2) && this.cbR != null) {
                        this.cbR.onChange();
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
                    if (!z && this.cbR != null) {
                        this.cbR.onChange();
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
        this.cbW.setVisibility(8);
        this.cbV.setVisibility(0);
        this.cbO.removeAllViews();
        this.cbP.removeAllViews();
        this.cbT = new com.baidu.live.yuyingift.widget.wheatlist.a(getContext());
        final com.baidu.live.yuyingift.widget.wheatlist.a aVar = (com.baidu.live.yuyingift.widget.wheatlist.a) this.cbT;
        aVar.setData(list);
        aVar.cbC.setSelected(aVar.cbE.abq());
        aVar.cbC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.widget.wheatlist.GiftPanelSelectMicrophoneSendView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.cbE.dH(!aVar.cbE.abq());
                ((com.baidu.live.yuyingift.widget.wheatlist.a) GiftPanelSelectMicrophoneSendView.this.cbT).cbC.setSelected(aVar.cbE.abq());
                if (GiftPanelSelectMicrophoneSendView.this.cbR != null) {
                    GiftPanelSelectMicrophoneSendView.this.cbR.onChange();
                }
                com.baidu.live.yuyingift.b.a.q(GiftPanelSelectMicrophoneSendView.this.cbX);
            }
        });
        com.baidu.live.yuyingift.widget.wheatlist.c cVar = aVar.cbE;
        com.baidu.live.yuyingift.widget.wheatlist.c cVar2 = aVar.cbE;
        cVar2.getClass();
        cVar.a(new c.a(cVar2, aVar) { // from class: com.baidu.live.yuyingift.widget.wheatlist.GiftPanelSelectMicrophoneSendView.4
            final /* synthetic */ com.baidu.live.yuyingift.widget.wheatlist.a ccb;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
                this.ccb = aVar;
                cVar2.getClass();
            }

            @Override // com.baidu.live.yuyingift.widget.wheatlist.c.a
            void fx(int i) {
                ((com.baidu.live.yuyingift.widget.wheatlist.a) GiftPanelSelectMicrophoneSendView.this.cbT).cbC.setSelected(this.ccb.cbE.abq());
                if (GiftPanelSelectMicrophoneSendView.this.cbR != null) {
                    GiftPanelSelectMicrophoneSendView.this.cbR.onChange();
                }
                com.baidu.live.yuyingift.b.a.r(GiftPanelSelectMicrophoneSendView.this.cbX);
            }
        });
        this.cbO.addView(this.cbT.contentView);
        if (z) {
            this.cbP.addView(this.cbT.cbF);
        }
    }

    public void setAttentionAndInfo(PersonUserData personUserData) {
        if (personUserData != null && personUserData.user_info != null && personUserData.relation_info != null && this.cbT != null && (this.cbT instanceof e)) {
            ((e) this.cbT).dK(!TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), personUserData.user_info.user_id) && personUserData.relation_info.follow_status == 0);
            ((e) this.cbT).dJ(true);
        }
    }

    public void aaG() {
        if (this.cbT != null && (this.cbT instanceof e)) {
            ((e) this.cbT).dK(false);
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
                if (com.baidu.live.aq.a.aan().jn(alaWheatInfoData.uk)) {
                    dVar3 = dVar5.clone();
                    dVar3.cce.userName = "房主";
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
                if (com.baidu.live.aq.a.aan().jn(next.uk)) {
                    dVar = dVar6.clone();
                    dVar.cce.userName = "房主";
                    dVar.posName = "房主";
                } else {
                    dVar = dVar2;
                }
            }
        } else {
            dVar2 = dVar;
        }
        if (dVar2 == null) {
            AlaWheatInfoData aao = com.baidu.live.aq.a.aan().aao();
            if (aao != null) {
                AlaWheatInfoData alaWheatInfoData2 = (AlaWheatInfoData) aao.clone();
                alaWheatInfoData2.userName = "房主";
                arrayList.add(new com.baidu.live.yuyingift.widget.wheatlist.d(alaWheatInfoData2, "房主"));
            }
        } else {
            arrayList.add(dVar2);
        }
        if (TbadkCoreApplication.isLogin() && arrayList.size() > 0) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                if (TextUtils.equals(String.valueOf(ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount())), ((com.baidu.live.yuyingift.widget.wheatlist.d) it2.next()).cce.uk)) {
                    it2.remove();
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        if (arrayList != null) {
            for (com.baidu.live.yuyingift.widget.wheatlist.d dVar7 : arrayList) {
                if (TextUtils.equals("房主", dVar7.posName)) {
                    dVar7.cce.isSelected = com.baidu.live.aq.a.aan().jq(dVar7.posName);
                } else {
                    dVar7.cce.isSelected = com.baidu.live.aq.a.aan().jq(dVar7.cce.uk);
                }
                arrayList2.add(dVar7.cce);
            }
        }
        g(this.cbU, arrayList2);
        return arrayList;
    }

    public d getSelectMicrophoneList() {
        d dVar = new d();
        ArrayList arrayList = new ArrayList();
        dVar.ccc = this.cbX;
        if (this.cbO != null && this.cbO.getChildCount() > 0) {
            View childAt = this.cbO.getChildAt(0);
            if (this.cbT != null && childAt == this.cbT.contentView) {
                if (this.cbT instanceof e) {
                    if (((e) this.cbT).ccf != null) {
                        arrayList.add(((e) this.cbT).ccf);
                    }
                } else if (this.cbT instanceof com.baidu.live.yuyingift.widget.wheatlist.a) {
                    for (AlaWheatInfoData alaWheatInfoData : ((com.baidu.live.yuyingift.widget.wheatlist.a) this.cbT).getData()) {
                        if (alaWheatInfoData.isSelected) {
                            arrayList.add(alaWheatInfoData);
                        }
                    }
                }
            }
            dVar.ccd = arrayList;
        }
        return dVar;
    }

    public void abr() {
        com.baidu.live.yuyingift.b.a.s(this.cbX);
    }

    public void abs() {
        com.baidu.live.yuyingift.b.a.t(this.cbX);
    }

    public void abt() {
        com.baidu.live.yuyingift.b.a.v(this.cbX);
    }

    public void aX(String str, String str2) {
        com.baidu.live.yuyingift.b.a.a(this.cbX, str, str2);
    }

    /* loaded from: classes11.dex */
    public class d {
        public String[] ccc;
        public List<AlaWheatInfoData> ccd;

        public d() {
        }
    }

    public static void k(String str, String str2, boolean z) {
        if (TextUtils.equals("房主", str2)) {
            com.baidu.live.aq.a.aan().G("房主", z);
        } else {
            com.baidu.live.aq.a.aan().G(str, z);
        }
    }
}
