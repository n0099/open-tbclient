package com.baidu.live.talentshow.components.selector;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.core.layer.LayerChildView;
import com.baidu.live.sdk.a;
import com.baidu.live.talentshow.components.selector.a;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import java.util.List;
/* loaded from: classes4.dex */
public class LiveBCMasterChatSelectorLayer extends LayerChildView implements a.InterfaceC0203a {
    private CommonEmptyView bpJ;
    private LinearLayout bwH;
    private com.baidu.live.talentshow.components.selector.a bwI;
    private b bwJ;
    private FrameLayout bwK;
    private a bwL;
    private LinearLayout bwM;
    private boolean bwN;
    private BdListView mListView;

    /* loaded from: classes4.dex */
    public interface a {
        void QJ();

        void QK();
    }

    /* loaded from: classes4.dex */
    public interface b {
        void b(com.baidu.live.talentshow.b.d dVar);
    }

    public LiveBCMasterChatSelectorLayer(@NonNull Context context) {
        super(context);
        this.bwN = false;
        init(context);
    }

    public LiveBCMasterChatSelectorLayer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bwN = false;
        init(context);
    }

    public LiveBCMasterChatSelectorLayer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bwN = false;
        init(context);
    }

    private void init(Context context) {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(a.g.talent_layout_master_apply_list, this);
        this.mListView = (BdListView) viewGroup.findViewById(a.f.detail_list);
        this.bpJ = (CommonEmptyView) viewGroup.findViewById(a.f.emptyView);
        this.bwH = (LinearLayout) viewGroup.findViewById(a.f.root_view);
        this.bwK = (FrameLayout) viewGroup.findViewById(a.f.layout_progress);
        this.bpJ.setTitle(a.h.talent_no_apply_user);
        this.bpJ.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
        this.mListView.setEmptyView(this.bpJ);
        this.bwM = (LinearLayout) viewGroup.findViewById(a.f.layout_list);
        this.bwI = new com.baidu.live.talentshow.components.selector.a();
        this.mListView.setAdapter((ListAdapter) this.bwI);
        setCanceledOnTouchOutside(true);
    }

    public LinearLayout getParentLayout() {
        return this.bwH;
    }

    public LinearLayout getListLayout() {
        return this.bwM;
    }

    public BdListView getListView() {
        return this.mListView;
    }

    public void c(View.OnClickListener onClickListener) {
        this.bwH.setOnClickListener(onClickListener);
        this.bwI.a(this);
        this.bwM.setOnClickListener(onClickListener);
    }

    public void setOnConfirmListener(b bVar) {
        this.bwJ = bVar;
    }

    public void setOnPanelStateChangeListener(a aVar) {
        this.bwL = aVar;
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void DR() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void DS() {
        this.bwH.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_transparent));
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void DT() {
        this.bwN = true;
        if (this.bwL != null) {
            this.bwL.QJ();
        }
        this.bwH.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_black_alpha50));
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void DU() {
        this.bwN = false;
        if (this.bwI != null) {
            this.bwI.clearData();
        }
        if (this.bwL != null) {
            this.bwL.QK();
        }
    }

    public void setData(List<com.baidu.live.talentshow.b.d> list) {
        if (list != null) {
            if (list.size() == 0) {
                showNoDataView();
            } else {
                Rz();
            }
            this.bwI.setDatas(list);
        }
    }

    @Override // com.baidu.live.talentshow.components.selector.a.InterfaceC0203a
    public void c(com.baidu.live.talentshow.b.d dVar) {
        if (this.bwJ != null) {
            this.bwJ.b(dVar);
        }
    }

    public void Ry() {
        this.bpJ.setTitle(a.h.talent_no_apply_net_error);
        this.bpJ.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
        this.bwK.setVisibility(8);
        this.bpJ.setVisibility(0);
    }

    public void showLoading() {
        this.bwK.setVisibility(0);
        this.bpJ.setVisibility(8);
    }

    public void showNoDataView() {
        this.bpJ.setTitle(a.h.talent_no_apply_user);
        this.bpJ.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
        this.bwK.setVisibility(8);
        this.bpJ.setVisibility(0);
    }

    public void Rz() {
        this.bwK.setVisibility(8);
        this.bpJ.setVisibility(8);
    }

    public boolean RA() {
        return this.bwN;
    }
}
