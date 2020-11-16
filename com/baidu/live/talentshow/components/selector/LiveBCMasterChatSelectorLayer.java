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
public class LiveBCMasterChatSelectorLayer extends LayerChildView implements a.InterfaceC0201a {
    private CommonEmptyView bnY;
    private LinearLayout buW;
    private com.baidu.live.talentshow.components.selector.a buX;
    private b buY;
    private FrameLayout buZ;
    private a bva;
    private LinearLayout bvb;
    private boolean bvc;
    private BdListView mListView;

    /* loaded from: classes4.dex */
    public interface a {
        void Qa();

        void Qb();
    }

    /* loaded from: classes4.dex */
    public interface b {
        void b(com.baidu.live.talentshow.b.d dVar);
    }

    public LiveBCMasterChatSelectorLayer(@NonNull Context context) {
        super(context);
        this.bvc = false;
        init(context);
    }

    public LiveBCMasterChatSelectorLayer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bvc = false;
        init(context);
    }

    public LiveBCMasterChatSelectorLayer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bvc = false;
        init(context);
    }

    private void init(Context context) {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(a.g.talent_layout_master_apply_list, this);
        this.mListView = (BdListView) viewGroup.findViewById(a.f.detail_list);
        this.bnY = (CommonEmptyView) viewGroup.findViewById(a.f.emptyView);
        this.buW = (LinearLayout) viewGroup.findViewById(a.f.root_view);
        this.buZ = (FrameLayout) viewGroup.findViewById(a.f.layout_progress);
        this.bnY.setTitle(a.h.talent_no_apply_user);
        this.bnY.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
        this.mListView.setEmptyView(this.bnY);
        this.bvb = (LinearLayout) viewGroup.findViewById(a.f.layout_list);
        this.buX = new com.baidu.live.talentshow.components.selector.a();
        this.mListView.setAdapter((ListAdapter) this.buX);
        setCanceledOnTouchOutside(true);
    }

    public LinearLayout getParentLayout() {
        return this.buW;
    }

    public LinearLayout getListLayout() {
        return this.bvb;
    }

    public BdListView getListView() {
        return this.mListView;
    }

    public void c(View.OnClickListener onClickListener) {
        this.buW.setOnClickListener(onClickListener);
        this.buX.a(this);
        this.bvb.setOnClickListener(onClickListener);
    }

    public void setOnConfirmListener(b bVar) {
        this.buY = bVar;
    }

    public void setOnPanelStateChangeListener(a aVar) {
        this.bva = aVar;
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Di() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Dj() {
        this.buW.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_transparent));
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Dk() {
        this.bvc = true;
        if (this.bva != null) {
            this.bva.Qa();
        }
        this.buW.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_black_alpha50));
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Dl() {
        this.bvc = false;
        if (this.buX != null) {
            this.buX.clearData();
        }
        if (this.bva != null) {
            this.bva.Qb();
        }
    }

    public void setData(List<com.baidu.live.talentshow.b.d> list) {
        if (list != null) {
            if (list.size() == 0) {
                showNoDataView();
            } else {
                QQ();
            }
            this.buX.setDatas(list);
        }
    }

    @Override // com.baidu.live.talentshow.components.selector.a.InterfaceC0201a
    public void c(com.baidu.live.talentshow.b.d dVar) {
        if (this.buY != null) {
            this.buY.b(dVar);
        }
    }

    public void QP() {
        this.bnY.setTitle(a.h.talent_no_apply_net_error);
        this.bnY.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
        this.buZ.setVisibility(8);
        this.bnY.setVisibility(0);
    }

    public void showLoading() {
        this.buZ.setVisibility(0);
        this.bnY.setVisibility(8);
    }

    public void showNoDataView() {
        this.bnY.setTitle(a.h.talent_no_apply_user);
        this.bnY.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
        this.buZ.setVisibility(8);
        this.bnY.setVisibility(0);
    }

    public void QQ() {
        this.buZ.setVisibility(8);
        this.bnY.setVisibility(8);
    }

    public boolean QR() {
        return this.bvc;
    }
}
