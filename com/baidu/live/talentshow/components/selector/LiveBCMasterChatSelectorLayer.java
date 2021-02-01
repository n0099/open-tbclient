package com.baidu.live.talentshow.components.selector;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.core.layer.LayerChildView;
import com.baidu.live.sdk.a;
import com.baidu.live.talentshow.components.selector.a;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import java.util.List;
/* loaded from: classes11.dex */
public class LiveBCMasterChatSelectorLayer extends LayerChildView implements a.InterfaceC0202a {
    private LinearLayout bDN;
    private com.baidu.live.talentshow.components.selector.a bDO;
    private b bDP;
    private FrameLayout bDQ;
    private a bDR;
    private LinearLayout bDS;
    private boolean bDT;
    private CommonEmptyView bwJ;
    private BdListView mListView;

    /* loaded from: classes11.dex */
    public interface a {
        void Rr();

        void Rs();
    }

    /* loaded from: classes11.dex */
    public interface b {
        void b(com.baidu.live.talentshow.b.d dVar);
    }

    public LiveBCMasterChatSelectorLayer(@NonNull Context context) {
        super(context);
        this.bDT = false;
        init(context);
    }

    public LiveBCMasterChatSelectorLayer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bDT = false;
        init(context);
    }

    public LiveBCMasterChatSelectorLayer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bDT = false;
        init(context);
    }

    private void init(Context context) {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(a.g.talent_layout_master_apply_list, this);
        this.mListView = (BdListView) viewGroup.findViewById(a.f.detail_list);
        this.bwJ = (CommonEmptyView) viewGroup.findViewById(a.f.emptyView);
        this.bDN = (LinearLayout) viewGroup.findViewById(a.f.root_view);
        this.bDQ = (FrameLayout) viewGroup.findViewById(a.f.layout_progress);
        this.bwJ.setTitle(a.h.talent_no_apply_user);
        this.bwJ.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
        this.mListView.setEmptyView(this.bwJ);
        this.bDS = (LinearLayout) viewGroup.findViewById(a.f.layout_list);
        this.bDO = new com.baidu.live.talentshow.components.selector.a();
        this.mListView.setAdapter((ListAdapter) this.bDO);
        setCanceledOnTouchOutside(true);
    }

    public LinearLayout getParentLayout() {
        return this.bDN;
    }

    public LinearLayout getListLayout() {
        return this.bDS;
    }

    public BdListView getListView() {
        return this.mListView;
    }

    public void d(View.OnClickListener onClickListener) {
        this.bDN.setOnClickListener(onClickListener);
        this.bDO.a(this);
        this.bDS.setOnClickListener(onClickListener);
    }

    public void setOnConfirmListener(b bVar) {
        this.bDP = bVar;
    }

    public void setOnPanelStateChangeListener(a aVar) {
        this.bDR = aVar;
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void AW() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void AX() {
        this.bDN.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_transparent));
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void AY() {
        this.bDT = true;
        if (this.bDR != null) {
            this.bDR.Rr();
        }
        this.bDN.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_black_alpha50));
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void AZ() {
        this.bDT = false;
        if (this.bDO != null) {
            this.bDO.clearData();
        }
        if (this.bDR != null) {
            this.bDR.Rs();
        }
    }

    public void setData(List<com.baidu.live.talentshow.b.d> list) {
        if (list != null) {
            if (list.size() == 0) {
                showNoDataView();
            } else {
                Si();
            }
            this.bDO.setDatas(list);
        }
    }

    @Override // com.baidu.live.talentshow.components.selector.a.InterfaceC0202a
    public void c(com.baidu.live.talentshow.b.d dVar) {
        if (this.bDP != null) {
            this.bDP.b(dVar);
        }
    }

    public void Sh() {
        this.bwJ.setTitle(a.h.talent_no_apply_net_error);
        this.bwJ.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
        this.bDQ.setVisibility(8);
        this.bwJ.setVisibility(0);
    }

    public void showLoading() {
        this.bDQ.setVisibility(0);
        this.bwJ.setVisibility(8);
    }

    public void showNoDataView() {
        this.bwJ.setTitle(a.h.talent_no_apply_user);
        this.bwJ.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
        this.bDQ.setVisibility(8);
        this.bwJ.setVisibility(0);
    }

    public void Si() {
        this.bDQ.setVisibility(8);
        this.bwJ.setVisibility(8);
    }

    public boolean Sj() {
        return this.bDT;
    }
}
