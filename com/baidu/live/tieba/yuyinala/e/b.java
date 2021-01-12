package com.baidu.live.tieba.yuyinala.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.d.ab;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.view.BdGridView;
import java.util.List;
/* loaded from: classes10.dex */
public class b implements View.OnClickListener {
    private TextView bJQ;
    private BdGridView bJT;
    private com.baidu.live.tieba.yuyinala.a.a bJU;
    private String bJj;
    private String mLiveId;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private String mRoomId;
    private View mView;

    public b(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mPageContext = tbPageContext;
        this.mOnClickListener = onClickListener;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.yuyin_ala_activity_choose_feedback_reason_layout, (ViewGroup) null);
        this.bJT = (BdGridView) this.mView.findViewById(a.f.id_feedback_gridview);
        this.bJQ = (TextView) this.mView.findViewById(a.f.id_feenback_confirm_btn);
        this.bJQ.setEnabled(false);
        this.bJQ.setOnClickListener(this);
        this.bJU = new com.baidu.live.tieba.yuyinala.a.a(this.mPageContext);
        this.bJT.setAdapter((ListAdapter) this.bJU);
        this.bJT.setOnItemClickListener(new a());
    }

    public void aN(String str, String str2) {
        this.mLiveId = str;
        this.mRoomId = str2;
    }

    public void D(String str, String str2, String str3) {
        this.mLiveId = str;
        this.mRoomId = str2;
        this.bJj = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a implements AdapterView.OnItemClickListener {
        private a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            com.baidu.live.tieba.yuyinala.c.a item = ((com.baidu.live.tieba.yuyinala.a.a) adapterView.getAdapter()).getItem(i);
            if (item != null) {
                if (item.Tv() != 0) {
                    if (b.this.bJU.Tt() == i) {
                        b.this.bJU.eT(-1);
                        b.this.bJU.notifyDataSetChanged();
                        b.this.bJQ.setEnabled(false);
                        return;
                    }
                    b.this.bJU.eT(i);
                    b.this.bJU.notifyDataSetChanged();
                    b.this.bJQ.setEnabled(true);
                    return;
                }
                ab abVar = new ab(b.this.mPageContext.getPageActivity());
                abVar.ak(b.this.mLiveId, b.this.mRoomId);
                abVar.eS(b.this.bJj);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, abVar));
                b.this.mPageContext.getPageActivity().finish();
            }
        }
    }

    public View getView() {
        return this.mView;
    }

    public void onDestroy() {
    }

    public void setData(List<com.baidu.live.tieba.yuyinala.c.a> list) {
        this.bJU.setData(list);
    }

    public com.baidu.live.tieba.yuyinala.c.a TB() {
        if (this.bJU == null || this.bJU.Tt() < 0) {
            return null;
        }
        return this.bJU.getItem(this.bJU.Tt());
    }
}
