package com.baidu.live.tieba.yuyinala.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.b.aa;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.view.BdGridView;
import java.util.List;
/* loaded from: classes4.dex */
public class b implements View.OnClickListener {
    private TextView bAg;
    private BdGridView bAj;
    private com.baidu.live.tieba.yuyinala.a.a bAk;
    private String bzz;
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
        this.mView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_activity_choose_feedback_reason_layout, (ViewGroup) null);
        this.bAj = (BdGridView) this.mView.findViewById(a.g.id_feedback_gridview);
        this.bAg = (TextView) this.mView.findViewById(a.g.id_feenback_confirm_btn);
        this.bAg.setEnabled(false);
        this.bAg.setOnClickListener(this);
        this.bAk = new com.baidu.live.tieba.yuyinala.a.a(this.mPageContext);
        this.bAj.setAdapter((ListAdapter) this.bAk);
        this.bAj.setOnItemClickListener(new a());
    }

    public void aP(String str, String str2) {
        this.mLiveId = str;
        this.mRoomId = str2;
    }

    public void z(String str, String str2, String str3) {
        this.mLiveId = str;
        this.mRoomId = str2;
        this.bzz = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {
        private a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            com.baidu.live.tieba.yuyinala.c.a item = ((com.baidu.live.tieba.yuyinala.a.a) adapterView.getAdapter()).getItem(i);
            if (item != null) {
                if (item.RM() != 0) {
                    if (b.this.bAk.RK() == i) {
                        b.this.bAk.fR(-1);
                        b.this.bAk.notifyDataSetChanged();
                        b.this.bAg.setEnabled(false);
                        return;
                    }
                    b.this.bAk.fR(i);
                    b.this.bAk.notifyDataSetChanged();
                    b.this.bAg.setEnabled(true);
                    return;
                }
                aa aaVar = new aa(b.this.mPageContext.getPageActivity());
                aaVar.ah(b.this.mLiveId, b.this.mRoomId);
                aaVar.fZ(b.this.bzz);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, aaVar));
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
        this.bAk.setData(list);
    }

    public com.baidu.live.tieba.yuyinala.c.a RS() {
        if (this.bAk == null || this.bAk.RK() < 0) {
            return null;
        }
        return this.bAk.getItem(this.bAk.RK());
    }
}
