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
public class LiveBCMasterChatSelectorLayer extends LayerChildView implements a.InterfaceC0209a {
    private LinearLayout bET;
    private com.baidu.live.talentshow.components.selector.a bEU;
    private b bEV;
    private FrameLayout bEW;
    private a bEX;
    private LinearLayout bEY;
    private boolean bEZ;
    private CommonEmptyView bxT;
    private BdListView mListView;

    /* loaded from: classes11.dex */
    public interface a {
        void TC();

        void TD();
    }

    /* loaded from: classes11.dex */
    public interface b {
        void b(com.baidu.live.talentshow.b.d dVar);
    }

    public LiveBCMasterChatSelectorLayer(@NonNull Context context) {
        super(context);
        this.bEZ = false;
        init(context);
    }

    public LiveBCMasterChatSelectorLayer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bEZ = false;
        init(context);
    }

    public LiveBCMasterChatSelectorLayer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bEZ = false;
        init(context);
    }

    private void init(Context context) {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(a.g.talent_layout_master_apply_list, this);
        this.mListView = (BdListView) viewGroup.findViewById(a.f.detail_list);
        this.bxT = (CommonEmptyView) viewGroup.findViewById(a.f.emptyView);
        this.bET = (LinearLayout) viewGroup.findViewById(a.f.root_view);
        this.bEW = (FrameLayout) viewGroup.findViewById(a.f.layout_progress);
        this.bxT.setTitle(a.h.talent_no_apply_user);
        this.bxT.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
        this.mListView.setEmptyView(this.bxT);
        this.bEY = (LinearLayout) viewGroup.findViewById(a.f.layout_list);
        this.bEU = new com.baidu.live.talentshow.components.selector.a();
        this.mListView.setAdapter((ListAdapter) this.bEU);
        setCanceledOnTouchOutside(true);
    }

    public LinearLayout getParentLayout() {
        return this.bET;
    }

    public LinearLayout getListLayout() {
        return this.bEY;
    }

    public BdListView getListView() {
        return this.mListView;
    }

    public void d(View.OnClickListener onClickListener) {
        this.bET.setOnClickListener(onClickListener);
        this.bEU.a(this);
        this.bEY.setOnClickListener(onClickListener);
    }

    public void setOnConfirmListener(b bVar) {
        this.bEV = bVar;
    }

    public void setOnPanelStateChangeListener(a aVar) {
        this.bEX = aVar;
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Eh() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Ei() {
        this.bET.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_transparent));
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Ej() {
        this.bEZ = true;
        if (this.bEX != null) {
            this.bEX.TC();
        }
        this.bET.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_black_alpha50));
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Ek() {
        this.bEZ = false;
        if (this.bEU != null) {
            this.bEU.clearData();
        }
        if (this.bEX != null) {
            this.bEX.TD();
        }
    }

    public void setData(List<com.baidu.live.talentshow.b.d> list) {
        if (list != null) {
            if (list.size() == 0) {
                showNoDataView();
            } else {
                Ut();
            }
            this.bEU.setDatas(list);
        }
    }

    @Override // com.baidu.live.talentshow.components.selector.a.InterfaceC0209a
    public void c(com.baidu.live.talentshow.b.d dVar) {
        if (this.bEV != null) {
            this.bEV.b(dVar);
        }
    }

    public void Us() {
        this.bxT.setTitle(a.h.talent_no_apply_net_error);
        this.bxT.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
        this.bEW.setVisibility(8);
        this.bxT.setVisibility(0);
    }

    public void showLoading() {
        this.bEW.setVisibility(0);
        this.bxT.setVisibility(8);
    }

    public void showNoDataView() {
        this.bxT.setTitle(a.h.talent_no_apply_user);
        this.bxT.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
        this.bEW.setVisibility(8);
        this.bxT.setVisibility(0);
    }

    public void Ut() {
        this.bEW.setVisibility(8);
        this.bxT.setVisibility(8);
    }

    public boolean Uu() {
        return this.bEZ;
    }
}
