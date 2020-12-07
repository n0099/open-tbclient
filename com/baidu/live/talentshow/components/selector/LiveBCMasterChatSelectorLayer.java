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
public class LiveBCMasterChatSelectorLayer extends LayerChildView implements a.InterfaceC0211a {
    private LinearLayout bAg;
    private com.baidu.live.talentshow.components.selector.a bAh;
    private b bAi;
    private FrameLayout bAj;
    private a bAk;
    private LinearLayout bAl;
    private boolean bAm;
    private CommonEmptyView btg;
    private BdListView mListView;

    /* loaded from: classes4.dex */
    public interface a {
        void Sy();

        void Sz();
    }

    /* loaded from: classes4.dex */
    public interface b {
        void b(com.baidu.live.talentshow.b.d dVar);
    }

    public LiveBCMasterChatSelectorLayer(@NonNull Context context) {
        super(context);
        this.bAm = false;
        init(context);
    }

    public LiveBCMasterChatSelectorLayer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bAm = false;
        init(context);
    }

    public LiveBCMasterChatSelectorLayer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bAm = false;
        init(context);
    }

    private void init(Context context) {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(a.g.talent_layout_master_apply_list, this);
        this.mListView = (BdListView) viewGroup.findViewById(a.f.detail_list);
        this.btg = (CommonEmptyView) viewGroup.findViewById(a.f.emptyView);
        this.bAg = (LinearLayout) viewGroup.findViewById(a.f.root_view);
        this.bAj = (FrameLayout) viewGroup.findViewById(a.f.layout_progress);
        this.btg.setTitle(a.h.talent_no_apply_user);
        this.btg.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
        this.mListView.setEmptyView(this.btg);
        this.bAl = (LinearLayout) viewGroup.findViewById(a.f.layout_list);
        this.bAh = new com.baidu.live.talentshow.components.selector.a();
        this.mListView.setAdapter((ListAdapter) this.bAh);
        setCanceledOnTouchOutside(true);
    }

    public LinearLayout getParentLayout() {
        return this.bAg;
    }

    public LinearLayout getListLayout() {
        return this.bAl;
    }

    public BdListView getListView() {
        return this.mListView;
    }

    public void c(View.OnClickListener onClickListener) {
        this.bAg.setOnClickListener(onClickListener);
        this.bAh.a(this);
        this.bAl.setOnClickListener(onClickListener);
    }

    public void setOnConfirmListener(b bVar) {
        this.bAi = bVar;
    }

    public void setOnPanelStateChangeListener(a aVar) {
        this.bAk = aVar;
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void ES() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void ET() {
        this.bAg.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_transparent));
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void EU() {
        this.bAm = true;
        if (this.bAk != null) {
            this.bAk.Sy();
        }
        this.bAg.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_black_alpha50));
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void EV() {
        this.bAm = false;
        if (this.bAh != null) {
            this.bAh.clearData();
        }
        if (this.bAk != null) {
            this.bAk.Sz();
        }
    }

    public void setData(List<com.baidu.live.talentshow.b.d> list) {
        if (list != null) {
            if (list.size() == 0) {
                showNoDataView();
            } else {
                To();
            }
            this.bAh.setDatas(list);
        }
    }

    @Override // com.baidu.live.talentshow.components.selector.a.InterfaceC0211a
    public void c(com.baidu.live.talentshow.b.d dVar) {
        if (this.bAi != null) {
            this.bAi.b(dVar);
        }
    }

    public void Tn() {
        this.btg.setTitle(a.h.talent_no_apply_net_error);
        this.btg.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
        this.bAj.setVisibility(8);
        this.btg.setVisibility(0);
    }

    public void showLoading() {
        this.bAj.setVisibility(0);
        this.btg.setVisibility(8);
    }

    public void showNoDataView() {
        this.btg.setTitle(a.h.talent_no_apply_user);
        this.btg.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
        this.bAj.setVisibility(8);
        this.btg.setVisibility(0);
    }

    public void To() {
        this.bAj.setVisibility(8);
        this.btg.setVisibility(8);
    }

    public boolean Tp() {
        return this.bAm;
    }
}
