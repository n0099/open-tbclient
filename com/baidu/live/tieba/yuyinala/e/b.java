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
    private String bOt;
    private TextView bPa;
    private BdGridView bPd;
    private com.baidu.live.tieba.yuyinala.a.a bPe;
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
        this.bPd = (BdGridView) this.mView.findViewById(a.f.id_feedback_gridview);
        this.bPa = (TextView) this.mView.findViewById(a.f.id_feenback_confirm_btn);
        this.bPa.setEnabled(false);
        this.bPa.setOnClickListener(this);
        this.bPe = new com.baidu.live.tieba.yuyinala.a.a(this.mPageContext);
        this.bPd.setAdapter((ListAdapter) this.bPe);
        this.bPd.setOnItemClickListener(new a());
    }

    public void aN(String str, String str2) {
        this.mLiveId = str;
        this.mRoomId = str2;
    }

    public void E(String str, String str2, String str3) {
        this.mLiveId = str;
        this.mRoomId = str2;
        this.bOt = str3;
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
                if (item.Vf() != 0) {
                    if (b.this.bPe.Vd() == i) {
                        b.this.bPe.eY(-1);
                        b.this.bPe.notifyDataSetChanged();
                        b.this.bPa.setEnabled(false);
                        return;
                    }
                    b.this.bPe.eY(i);
                    b.this.bPe.notifyDataSetChanged();
                    b.this.bPa.setEnabled(true);
                    return;
                }
                ab abVar = new ab(b.this.mPageContext.getPageActivity());
                abVar.ak(b.this.mLiveId, b.this.mRoomId);
                abVar.fq(b.this.bOt);
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
        this.bPe.setData(list);
    }

    public com.baidu.live.tieba.yuyinala.c.a Vl() {
        if (this.bPe == null || this.bPe.Vd() < 0) {
            return null;
        }
        return this.bPe.getItem(this.bPe.Vd());
    }
}
