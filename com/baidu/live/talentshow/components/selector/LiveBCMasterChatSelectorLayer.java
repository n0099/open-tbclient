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
/* loaded from: classes10.dex */
public class LiveBCMasterChatSelectorLayer extends LayerChildView implements a.InterfaceC0200a {
    private LinearLayout bAh;
    private com.baidu.live.talentshow.components.selector.a bAi;
    private b bAj;
    private FrameLayout bAk;
    private a bAl;
    private LinearLayout bAm;
    private boolean bAn;
    private CommonEmptyView btf;
    private BdListView mListView;

    /* loaded from: classes10.dex */
    public interface a {
        void PH();

        void PI();
    }

    /* loaded from: classes10.dex */
    public interface b {
        void b(com.baidu.live.talentshow.b.d dVar);
    }

    public LiveBCMasterChatSelectorLayer(@NonNull Context context) {
        super(context);
        this.bAn = false;
        init(context);
    }

    public LiveBCMasterChatSelectorLayer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bAn = false;
        init(context);
    }

    public LiveBCMasterChatSelectorLayer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bAn = false;
        init(context);
    }

    private void init(Context context) {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(a.g.talent_layout_master_apply_list, this);
        this.mListView = (BdListView) viewGroup.findViewById(a.f.detail_list);
        this.btf = (CommonEmptyView) viewGroup.findViewById(a.f.emptyView);
        this.bAh = (LinearLayout) viewGroup.findViewById(a.f.root_view);
        this.bAk = (FrameLayout) viewGroup.findViewById(a.f.layout_progress);
        this.btf.setTitle(a.h.talent_no_apply_user);
        this.btf.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
        this.mListView.setEmptyView(this.btf);
        this.bAm = (LinearLayout) viewGroup.findViewById(a.f.layout_list);
        this.bAi = new com.baidu.live.talentshow.components.selector.a();
        this.mListView.setAdapter((ListAdapter) this.bAi);
        setCanceledOnTouchOutside(true);
    }

    public LinearLayout getParentLayout() {
        return this.bAh;
    }

    public LinearLayout getListLayout() {
        return this.bAm;
    }

    public BdListView getListView() {
        return this.mListView;
    }

    public void d(View.OnClickListener onClickListener) {
        this.bAh.setOnClickListener(onClickListener);
        this.bAi.a(this);
        this.bAm.setOnClickListener(onClickListener);
    }

    public void setOnConfirmListener(b bVar) {
        this.bAj = bVar;
    }

    public void setOnPanelStateChangeListener(a aVar) {
        this.bAl = aVar;
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Am() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void An() {
        this.bAh.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_transparent));
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Ao() {
        this.bAn = true;
        if (this.bAl != null) {
            this.bAl.PH();
        }
        this.bAh.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_black_alpha50));
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Ap() {
        this.bAn = false;
        if (this.bAi != null) {
            this.bAi.clearData();
        }
        if (this.bAl != null) {
            this.bAl.PI();
        }
    }

    public void setData(List<com.baidu.live.talentshow.b.d> list) {
        if (list != null) {
            if (list.size() == 0) {
                showNoDataView();
            } else {
                Qy();
            }
            this.bAi.setDatas(list);
        }
    }

    @Override // com.baidu.live.talentshow.components.selector.a.InterfaceC0200a
    public void c(com.baidu.live.talentshow.b.d dVar) {
        if (this.bAj != null) {
            this.bAj.b(dVar);
        }
    }

    public void Qx() {
        this.btf.setTitle(a.h.talent_no_apply_net_error);
        this.btf.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
        this.bAk.setVisibility(8);
        this.btf.setVisibility(0);
    }

    public void showLoading() {
        this.bAk.setVisibility(0);
        this.btf.setVisibility(8);
    }

    public void showNoDataView() {
        this.btf.setTitle(a.h.talent_no_apply_user);
        this.btf.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
        this.bAk.setVisibility(8);
        this.btf.setVisibility(0);
    }

    public void Qy() {
        this.bAk.setVisibility(8);
        this.btf.setVisibility(8);
    }

    public boolean Qz() {
        return this.bAn;
    }
}
