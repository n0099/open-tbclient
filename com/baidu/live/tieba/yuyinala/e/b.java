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
/* loaded from: classes4.dex */
public class b implements View.OnClickListener {
    private TextView bJO;
    private BdGridView bJR;
    private com.baidu.live.tieba.yuyinala.a.a bJS;
    private String bJh;
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
        this.bJR = (BdGridView) this.mView.findViewById(a.f.id_feedback_gridview);
        this.bJO = (TextView) this.mView.findViewById(a.f.id_feenback_confirm_btn);
        this.bJO.setEnabled(false);
        this.bJO.setOnClickListener(this);
        this.bJS = new com.baidu.live.tieba.yuyinala.a.a(this.mPageContext);
        this.bJR.setAdapter((ListAdapter) this.bJS);
        this.bJR.setOnItemClickListener(new a());
    }

    public void aT(String str, String str2) {
        this.mLiveId = str;
        this.mRoomId = str2;
    }

    public void C(String str, String str2, String str3) {
        this.mLiveId = str;
        this.mRoomId = str2;
        this.bJh = str3;
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
                if (item.Wl() != 0) {
                    if (b.this.bJS.Wj() == i) {
                        b.this.bJS.gz(-1);
                        b.this.bJS.notifyDataSetChanged();
                        b.this.bJO.setEnabled(false);
                        return;
                    }
                    b.this.bJS.gz(i);
                    b.this.bJS.notifyDataSetChanged();
                    b.this.bJO.setEnabled(true);
                    return;
                }
                ab abVar = new ab(b.this.mPageContext.getPageActivity());
                abVar.am(b.this.mLiveId, b.this.mRoomId);
                abVar.gu(b.this.bJh);
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
        this.bJS.setData(list);
    }

    public com.baidu.live.tieba.yuyinala.c.a Wr() {
        if (this.bJS == null || this.bJS.Wj() < 0) {
            return null;
        }
        return this.bJS.getItem(this.bJS.Wj());
    }
}
