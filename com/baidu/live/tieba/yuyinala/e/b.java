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
    private String bFK;
    private TextView bGr;
    private BdGridView bGu;
    private com.baidu.live.tieba.yuyinala.a.a bGv;
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
        this.bGu = (BdGridView) this.mView.findViewById(a.f.id_feedback_gridview);
        this.bGr = (TextView) this.mView.findViewById(a.f.id_feenback_confirm_btn);
        this.bGr.setEnabled(false);
        this.bGr.setOnClickListener(this);
        this.bGv = new com.baidu.live.tieba.yuyinala.a.a(this.mPageContext);
        this.bGu.setAdapter((ListAdapter) this.bGv);
        this.bGu.setOnItemClickListener(new a());
    }

    public void aQ(String str, String str2) {
        this.mLiveId = str;
        this.mRoomId = str2;
    }

    public void z(String str, String str2, String str3) {
        this.mLiveId = str;
        this.mRoomId = str2;
        this.bFK = str3;
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
                if (item.Uu() != 0) {
                    if (b.this.bGv.Us() == i) {
                        b.this.bGv.ge(-1);
                        b.this.bGv.notifyDataSetChanged();
                        b.this.bGr.setEnabled(false);
                        return;
                    }
                    b.this.bGv.ge(i);
                    b.this.bGv.notifyDataSetChanged();
                    b.this.bGr.setEnabled(true);
                    return;
                }
                aa aaVar = new aa(b.this.mPageContext.getPageActivity());
                aaVar.ai(b.this.mLiveId, b.this.mRoomId);
                aaVar.ge(b.this.bFK);
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
        this.bGv.setData(list);
    }

    public com.baidu.live.tieba.yuyinala.c.a UA() {
        if (this.bGv == null || this.bGv.Us() < 0) {
            return null;
        }
        return this.bGv.getItem(this.bGv.Us());
    }
}
