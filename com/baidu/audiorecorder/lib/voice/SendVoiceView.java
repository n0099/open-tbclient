package com.baidu.audiorecorder.lib.voice;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.chat.aw;
/* loaded from: classes.dex */
public class SendVoiceView implements aw {
    private TextView KC;
    protected ImageView mBtnMsgSendMore1;
    protected ImageView mBtnMsgSendSoftkey;
    private RelativeLayout mBtnMsgSendVoice;
    private LinearLayout mLayMsgSendVoice;

    public SendVoiceView(ViewGroup viewGroup) {
        this.mLayMsgSendVoice = null;
        this.mBtnMsgSendSoftkey = null;
        this.mBtnMsgSendMore1 = null;
        this.mBtnMsgSendVoice = null;
        this.KC = null;
        if (viewGroup != null) {
            View inflate = com.baidu.adp.lib.g.b.hH().inflate(viewGroup.getContext(), com.baidu.tieba.w.send_voice_view, viewGroup);
            this.mLayMsgSendVoice = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.lay_msgsend_voice);
            this.mLayMsgSendVoice.setVisibility(8);
            this.mBtnMsgSendSoftkey = (ImageView) inflate.findViewById(com.baidu.tieba.v.btn_msgsend_softkey);
            this.mBtnMsgSendMore1 = (ImageView) inflate.findViewById(com.baidu.tieba.v.btn_msgsend_more1);
            this.mBtnMsgSendVoice = (RelativeLayout) inflate.findViewById(com.baidu.tieba.v.btn_msgsend_voice);
            this.KC = (TextView) inflate.findViewById(com.baidu.tieba.v.tex_send_voice);
        }
    }

    @Override // com.baidu.tieba.im.chat.aw
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.mBtnMsgSendVoice.setBackgroundResource(com.baidu.tieba.u.but_talk_s);
            this.KC.setText(TbadkCoreApplication.m411getInst().getContext().getString(com.baidu.tieba.y.msglist_no_push));
            return;
        }
        this.mBtnMsgSendVoice.setBackgroundResource(com.baidu.tieba.u.but_talk_n);
        this.KC.setText(TbadkCoreApplication.m411getInst().getContext().getString(com.baidu.tieba.y.msglist_push_talk));
    }

    @Override // com.baidu.tieba.im.chat.aw
    public RelativeLayout getBtnSendVoice() {
        return this.mBtnMsgSendVoice;
    }

    @Override // com.baidu.tieba.im.chat.aw
    public int nW() {
        return com.baidu.tieba.u.selector_msgsend_btn_govoice;
    }

    @Override // com.baidu.tieba.im.chat.aw
    public ImageView nX() {
        return this.mBtnMsgSendMore1;
    }

    @Override // com.baidu.tieba.im.chat.aw
    public ImageView nY() {
        return this.mBtnMsgSendSoftkey;
    }

    @Override // com.baidu.tieba.im.chat.aw
    public LinearLayout nZ() {
        return this.mLayMsgSendVoice;
    }
}
