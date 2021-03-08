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
public class LiveBCMasterChatSelectorLayer extends LayerChildView implements a.InterfaceC0208a {
    private LinearLayout bFn;
    private com.baidu.live.talentshow.components.selector.a bFo;
    private b bFp;
    private FrameLayout bFq;
    private a bFr;
    private LinearLayout bFs;
    private boolean bFt;
    private CommonEmptyView byj;
    private BdListView mListView;

    /* loaded from: classes10.dex */
    public interface a {
        void Ru();

        void Rv();
    }

    /* loaded from: classes10.dex */
    public interface b {
        void b(com.baidu.live.talentshow.b.d dVar);
    }

    public LiveBCMasterChatSelectorLayer(@NonNull Context context) {
        super(context);
        this.bFt = false;
        init(context);
    }

    public LiveBCMasterChatSelectorLayer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bFt = false;
        init(context);
    }

    public LiveBCMasterChatSelectorLayer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bFt = false;
        init(context);
    }

    private void init(Context context) {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(a.g.talent_layout_master_apply_list, this);
        this.mListView = (BdListView) viewGroup.findViewById(a.f.detail_list);
        this.byj = (CommonEmptyView) viewGroup.findViewById(a.f.emptyView);
        this.bFn = (LinearLayout) viewGroup.findViewById(a.f.root_view);
        this.bFq = (FrameLayout) viewGroup.findViewById(a.f.layout_progress);
        this.byj.setTitle(a.h.talent_no_apply_user);
        this.byj.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
        this.mListView.setEmptyView(this.byj);
        this.bFs = (LinearLayout) viewGroup.findViewById(a.f.layout_list);
        this.bFo = new com.baidu.live.talentshow.components.selector.a();
        this.mListView.setAdapter((ListAdapter) this.bFo);
        setCanceledOnTouchOutside(true);
    }

    public LinearLayout getParentLayout() {
        return this.bFn;
    }

    public LinearLayout getListLayout() {
        return this.bFs;
    }

    public BdListView getListView() {
        return this.mListView;
    }

    public void d(View.OnClickListener onClickListener) {
        this.bFn.setOnClickListener(onClickListener);
        this.bFo.a(this);
        this.bFs.setOnClickListener(onClickListener);
    }

    public void setOnConfirmListener(b bVar) {
        this.bFp = bVar;
    }

    public void setOnPanelStateChangeListener(a aVar) {
        this.bFr = aVar;
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void AZ() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Ba() {
        this.bFn.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_transparent));
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Bb() {
        this.bFt = true;
        if (this.bFr != null) {
            this.bFr.Ru();
        }
        this.bFn.setBackgroundColor(getContext().getResources().getColor(a.c.sdk_black_alpha50));
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Bc() {
        this.bFt = false;
        if (this.bFo != null) {
            this.bFo.clearData();
        }
        if (this.bFr != null) {
            this.bFr.Rv();
        }
    }

    public void setData(List<com.baidu.live.talentshow.b.d> list) {
        if (list != null) {
            if (list.size() == 0) {
                showNoDataView();
            } else {
                Sl();
            }
            this.bFo.setDatas(list);
        }
    }

    @Override // com.baidu.live.talentshow.components.selector.a.InterfaceC0208a
    public void c(com.baidu.live.talentshow.b.d dVar) {
        if (this.bFp != null) {
            this.bFp.b(dVar);
        }
    }

    public void Sk() {
        this.byj.setTitle(a.h.talent_no_apply_net_error);
        this.byj.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
        this.bFq.setVisibility(8);
        this.byj.setVisibility(0);
    }

    public void showLoading() {
        this.bFq.setVisibility(0);
        this.byj.setVisibility(8);
    }

    public void showNoDataView() {
        this.byj.setTitle(a.h.talent_no_apply_user);
        this.byj.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
        this.bFq.setVisibility(8);
        this.byj.setVisibility(0);
    }

    public void Sl() {
        this.bFq.setVisibility(8);
        this.byj.setVisibility(8);
    }

    public boolean Sm() {
        return this.bFt;
    }
}
