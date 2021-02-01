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
/* loaded from: classes11.dex */
public class GiftPanelSelectMicrophoneSendView extends RelativeLayout {
    private FrameLayout cbd;
    private FrameLayout cbe;
    private a cbf;
    private b cbg;
    private c cbh;
    private com.baidu.live.yuyingift.widget.wheatlist.b cbi;
    private List<AlaWheatInfoData> cbj;
    private TextView cbk;
    private TextView cbl;
    private String[] cbm;

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
        this.cbh = cVar;
    }

    public void setCallback(a aVar) {
        this.cbf = aVar;
    }

    public void setOnSelectWheatChangeListener(b bVar) {
        this.cbg = bVar;
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
        this.cbk = (TextView) findViewById(a.f.ala_gift_microphone_title);
        this.cbl = (TextView) findViewById(a.f.yuyin_ala_gift_microphone_empty);
        this.cbd = (FrameLayout) findViewById(a.f.yuyin_ala_gift_microphone_person_content);
        this.cbe = (FrameLayout) findViewById(a.f.yuyin_ala_gift_microphone_op_content);
    }

    private boolean at(List<com.baidu.live.yuyingift.widget.wheatlist.d> list) {
        if (list == null || this.cbj == null || list.size() != this.cbj.size() || list.size() == 0) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!TextUtils.equals(list.get(i).cbu.uk, this.cbj.get(i).uk) || list.get(i).cbu.realWheatPosition != this.cbj.get(i).realWheatPosition) {
                return false;
            }
        }
        return true;
    }

    public void b(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2, String[] strArr) {
        boolean z;
        ArrayList arrayList;
        com.baidu.live.yuyingift.widget.wheatlist.d dVar;
        AlaWheatInfoData iK;
        this.cbm = strArr;
        if (com.baidu.live.ao.a.Yj().Yq() == null || com.baidu.live.ao.a.Yj().Yq().aIY == null) {
            z = false;
        } else {
            z = com.baidu.live.ao.a.Yj().Yq().aIY.getRoomMode() == 100;
        }
        if (strArr == null || strArr.length == 0) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (String str : strArr) {
                if (!StringUtils.isNull(str) && (iK = com.baidu.live.ao.a.Yj().iK(str)) != null) {
                    arrayList.add(iK);
                }
            }
            if (ListUtils.isEmpty(arrayList)) {
                this.cbj = null;
                Qc();
                return;
            }
        }
        if (!ListUtils.isEmpty(arrayList)) {
            if (!h(this.cbj, arrayList)) {
                this.cbj = arrayList;
                ArrayList arrayList2 = new ArrayList();
                for (AlaWheatInfoData alaWheatInfoData : this.cbj) {
                    AlaWheatInfoData alaWheatInfoData2 = (AlaWheatInfoData) alaWheatInfoData.clone();
                    alaWheatInfoData2.isSelected = true;
                    if (alaWheatInfoData2.isHost) {
                        if (z) {
                            dVar = new com.baidu.live.yuyingift.widget.wheatlist.d(alaWheatInfoData2, "");
                        } else {
                            dVar = new com.baidu.live.yuyingift.widget.wheatlist.d(alaWheatInfoData2, "主持");
                        }
                    } else {
                        ab Yq = com.baidu.live.ao.a.Yj().Yq();
                        if (Yq != null && Yq.aIY != null && Yq.aIY.isSweetStage()) {
                            dVar = new com.baidu.live.yuyingift.widget.wheatlist.d(alaWheatInfoData2, alaWheatInfoData2.phoneOrder + "麦");
                        } else if (z) {
                            dVar = new com.baidu.live.yuyingift.widget.wheatlist.d(alaWheatInfoData2, "");
                        } else {
                            dVar = new com.baidu.live.yuyingift.widget.wheatlist.d(alaWheatInfoData2, alaWheatInfoData2.realWheatPosition + "麦");
                        }
                    }
                    com.baidu.live.yuyingift.widget.wheatlist.d dVar2 = dVar;
                    k(dVar2.cbu.uk, dVar2.posName, true);
                    arrayList2.add(dVar2);
                }
                if (ListUtils.getCount(arrayList2) > 1) {
                    h((List<com.baidu.live.yuyingift.widget.wheatlist.d>) arrayList2, true);
                    return;
                } else if (ListUtils.getCount(arrayList2) == 1) {
                    a((com.baidu.live.yuyingift.widget.wheatlist.d) ListUtils.getItem(arrayList2, 0));
                    return;
                } else {
                    Qc();
                    return;
                }
            }
            return;
        }
        List<com.baidu.live.yuyingift.widget.wheatlist.d> a2 = a(list, list2, z);
        if (!at(a2)) {
            if (this.cbj == null) {
                this.cbj = new ArrayList();
            }
            this.cbj.clear();
            for (com.baidu.live.yuyingift.widget.wheatlist.d dVar3 : a2) {
                this.cbj.add(dVar3.cbu);
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
            Qc();
        }
    }

    private void Qc() {
        this.cbd.removeAllViews();
        this.cbe.removeAllViews();
        this.cbk.setVisibility(8);
        this.cbl.setVisibility(0);
        if (this.cbg != null) {
            this.cbg.onChange();
        }
    }

    private void a(final com.baidu.live.yuyingift.widget.wheatlist.d dVar) {
        this.cbl.setVisibility(8);
        this.cbk.setVisibility(0);
        this.cbd.removeAllViews();
        this.cbe.removeAllViews();
        this.cbi = new e(getContext());
        if (dVar != null) {
            final e eVar = (e) this.cbi;
            eVar.b(dVar);
            eVar.cbx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.widget.wheatlist.GiftPanelSelectMicrophoneSendView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (GiftPanelSelectMicrophoneSendView.this.cbf != null) {
                        GiftPanelSelectMicrophoneSendView.this.cbf.a(dVar.cbu);
                        eVar.cbx.setStatus(3);
                    }
                }
            });
            eVar.cby.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.widget.wheatlist.GiftPanelSelectMicrophoneSendView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (GiftPanelSelectMicrophoneSendView.this.cbf != null) {
                        GiftPanelSelectMicrophoneSendView.this.cbf.b(dVar.cbu);
                    }
                    com.baidu.live.yuyingift.b.a.u(GiftPanelSelectMicrophoneSendView.this.cbm);
                }
            });
            if (this.cbh != null) {
                this.cbh.c(dVar.cbu);
            }
            this.cbd.addView(this.cbi.contentView);
            this.cbe.addView(this.cbi.caU);
        }
    }

    private void g(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2) {
        boolean z;
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                String str = list.get(i).uk;
                if (com.baidu.live.ao.a.Yj().iL(str)) {
                    if (ListUtils.isEmpty(list2) && this.cbg != null) {
                        this.cbg.onChange();
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
                    if (!z && this.cbg != null) {
                        this.cbg.onChange();
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
        this.cbl.setVisibility(8);
        this.cbk.setVisibility(0);
        this.cbd.removeAllViews();
        this.cbe.removeAllViews();
        this.cbi = new com.baidu.live.yuyingift.widget.wheatlist.a(getContext());
        final com.baidu.live.yuyingift.widget.wheatlist.a aVar = (com.baidu.live.yuyingift.widget.wheatlist.a) this.cbi;
        aVar.setData(list);
        aVar.caR.setSelected(aVar.caT.Zn());
        aVar.caR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.widget.wheatlist.GiftPanelSelectMicrophoneSendView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.caT.dL(!aVar.caT.Zn());
                ((com.baidu.live.yuyingift.widget.wheatlist.a) GiftPanelSelectMicrophoneSendView.this.cbi).caR.setSelected(aVar.caT.Zn());
                if (GiftPanelSelectMicrophoneSendView.this.cbg != null) {
                    GiftPanelSelectMicrophoneSendView.this.cbg.onChange();
                }
                com.baidu.live.yuyingift.b.a.q(GiftPanelSelectMicrophoneSendView.this.cbm);
            }
        });
        com.baidu.live.yuyingift.widget.wheatlist.c cVar = aVar.caT;
        com.baidu.live.yuyingift.widget.wheatlist.c cVar2 = aVar.caT;
        cVar2.getClass();
        cVar.a(new c.a(cVar2, aVar) { // from class: com.baidu.live.yuyingift.widget.wheatlist.GiftPanelSelectMicrophoneSendView.4
            final /* synthetic */ com.baidu.live.yuyingift.widget.wheatlist.a cbq;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
                this.cbq = aVar;
                cVar2.getClass();
            }

            @Override // com.baidu.live.yuyingift.widget.wheatlist.c.a
            void dV(int i) {
                ((com.baidu.live.yuyingift.widget.wheatlist.a) GiftPanelSelectMicrophoneSendView.this.cbi).caR.setSelected(this.cbq.caT.Zn());
                if (GiftPanelSelectMicrophoneSendView.this.cbg != null) {
                    GiftPanelSelectMicrophoneSendView.this.cbg.onChange();
                }
                com.baidu.live.yuyingift.b.a.r(GiftPanelSelectMicrophoneSendView.this.cbm);
            }
        });
        this.cbd.addView(this.cbi.contentView);
        if (z) {
            this.cbe.addView(this.cbi.caU);
        }
    }

    public void setAttentionAndInfo(PersonUserData personUserData) {
        if (personUserData != null && personUserData.user_info != null && personUserData.relation_info != null && this.cbi != null && (this.cbi instanceof e)) {
            ((e) this.cbi).dO(!TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), personUserData.user_info.user_id) && personUserData.relation_info.follow_status == 0);
            ((e) this.cbi).dN(true);
        }
    }

    public void YD() {
        if (this.cbi != null && (this.cbi instanceof e)) {
            ((e) this.cbi).dO(false);
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
                    if (com.baidu.live.ao.a.Yj().iI(alaWheatInfoData.uk)) {
                        dVar3 = dVar5.clone();
                        dVar3.cbu.userName = "房主";
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
                if (com.baidu.live.ao.a.Yj().iI(next.uk)) {
                    dVar = dVar6.clone();
                    dVar.cbu.userName = "房主";
                    dVar.posName = "房主";
                } else {
                    dVar = dVar2;
                }
            }
            dVar = dVar2;
        }
        if (dVar == null) {
            AlaWheatInfoData Yl = com.baidu.live.ao.a.Yj().Yl();
            if (Yl != null) {
                AlaWheatInfoData alaWheatInfoData2 = (AlaWheatInfoData) Yl.clone();
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
                if (TextUtils.equals(String.valueOf(ExtraParamsManager.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount())), ((com.baidu.live.yuyingift.widget.wheatlist.d) it2.next()).cbu.uk)) {
                    it2.remove();
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        if (arrayList != null) {
            for (com.baidu.live.yuyingift.widget.wheatlist.d dVar7 : arrayList) {
                if (TextUtils.equals("房主", dVar7.posName)) {
                    dVar7.cbu.isSelected = com.baidu.live.ao.a.Yj().iL(dVar7.posName);
                } else {
                    dVar7.cbu.isSelected = com.baidu.live.ao.a.Yj().iL(dVar7.cbu.uk);
                }
                arrayList2.add(dVar7.cbu);
            }
        }
        g(this.cbj, arrayList2);
        return arrayList;
    }

    public d getSelectMicrophoneList() {
        d dVar = new d();
        ArrayList arrayList = new ArrayList();
        dVar.cbr = this.cbm;
        if (this.cbd != null && this.cbd.getChildCount() > 0) {
            View childAt = this.cbd.getChildAt(0);
            if (this.cbi != null && childAt == this.cbi.contentView) {
                if (this.cbi instanceof e) {
                    if (((e) this.cbi).cbv != null) {
                        arrayList.add(((e) this.cbi).cbv);
                    }
                } else if (this.cbi instanceof com.baidu.live.yuyingift.widget.wheatlist.a) {
                    for (AlaWheatInfoData alaWheatInfoData : ((com.baidu.live.yuyingift.widget.wheatlist.a) this.cbi).getData()) {
                        if (alaWheatInfoData.isSelected) {
                            arrayList.add(alaWheatInfoData);
                        }
                    }
                }
            }
            dVar.cbt = arrayList;
        }
        return dVar;
    }

    public void Zo() {
        com.baidu.live.yuyingift.b.a.s(this.cbm);
    }

    public void Zp() {
        com.baidu.live.yuyingift.b.a.t(this.cbm);
    }

    public void Zq() {
        com.baidu.live.yuyingift.b.a.v(this.cbm);
    }

    public void aV(String str, String str2) {
        com.baidu.live.yuyingift.b.a.a(this.cbm, str, str2);
    }

    /* loaded from: classes11.dex */
    public class d {
        public String[] cbr;
        public List<AlaWheatInfoData> cbt;

        public d() {
        }
    }

    public static void k(String str, String str2, boolean z) {
        if (TextUtils.equals("房主", str2)) {
            com.baidu.live.ao.a.Yj().G("房主", z);
        } else {
            com.baidu.live.ao.a.Yj().G(str, z);
        }
    }
}
