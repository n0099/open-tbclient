package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.z;
import com.baidu.tieba.im.chat.ISendVoiceView;
import com.baidu.tieba.im.chat.ak;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class SendVoiceView extends LinearLayout implements z, ISendVoiceView, ak {
    private TextView Lg;
    private int Lh;
    private com.baidu.tbadk.editortools.k Li;
    private FloatRecordView Lj;
    private WindowManager Lk;
    private WindowManager.LayoutParams Ll;

    public SendVoiceView(Context context) {
        super(context);
        this.Lg = null;
        this.Lh = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(n.h.send_voice_view, this);
            this.Lg = (TextView) findViewById(n.g.tex_send_voice);
            oc();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.Lg.setBackgroundResource(n.f.but_talk_s);
            this.Lg.setText(TbadkCoreApplication.m411getInst().getContext().getString(n.j.msglist_no_push));
            return;
        }
        this.Lg.setBackgroundResource(n.f.but_talk_n);
        this.Lg.setText(TbadkCoreApplication.m411getInst().getContext().getString(n.j.msglist_push_talk));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.z
    public void ob() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.z
    public int getToolId() {
        return this.Lh;
    }

    @Override // com.baidu.tbadk.editortools.z
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.z
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.z
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Li != null) {
            this.Li.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.z
    public void setEditorTools(com.baidu.tbadk.editortools.k kVar) {
        this.Li = kVar;
    }

    @Override // com.baidu.tbadk.editortools.z
    public void setToolId(int i) {
        this.Lh = i;
    }

    @Override // com.baidu.tbadk.editortools.z
    public void onChangeSkinType(int i) {
    }

    private void oc() {
        this.Lj = new FloatRecordView(getContext());
        this.Lk = (WindowManager) TbadkCoreApplication.m411getInst().getContext().getSystemService("window");
        this.Ll = new WindowManager.LayoutParams();
        this.Ll.type = 2002;
        this.Ll.format = 1;
        this.Ll.flags = 56;
        this.Ll.gravity = 17;
        this.Ll.x = 0;
        this.Ll.y = 0;
        this.Ll.width = getContext().getResources().getDimensionPixelSize(n.e.im_msg_voice_layer_width);
        this.Ll.height = getContext().getResources().getDimensionPixelSize(n.e.im_msg_voice_layer_height);
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onStartedRecorder(boolean z) {
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onStopingRecorder() {
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowErr(int i, String str) {
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                stopRecordVoice();
            } else if (i == 2) {
                closeRecordCancel();
                closeRecordTooShort();
                showRecordTooShort();
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onSendVoice(String str, int i) {
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onDeletedVoice(String str) {
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecordTime(int i) {
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecording(int i) {
        if (this.Lj != null && this.Lk != null && this.Ll != null) {
            this.Lj.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void closeRecordCancel() {
        if (this.Lj != null && this.Lk != null && this.Ll != null) {
            this.Lj.closeRecordCancel();
            LinearLayout nW = this.Lj.nW();
            if (nW != null && nW.getParent() != null) {
                this.Lk.removeView(nW);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void closeRecordTooShort() {
        if (this.Lj != null && this.Lk != null && this.Ll != null) {
            this.Lj.closeRecordTooShort();
            LinearLayout nV = this.Lj.nV();
            if (nV != null && nV.getParent() != null) {
                this.Lk.removeView(nV);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void showRecordCancel() {
        LinearLayout nW;
        if (this.Lj != null && this.Lk != null && this.Ll != null && (nW = this.Lj.nW()) != null && nW.getParent() == null) {
            this.Lk.addView(nW, this.Ll);
            this.Lj.showRecordCancel();
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void showRecordTooShort() {
        LinearLayout nV;
        if (this.Lj != null && this.Lk != null && this.Ll != null && (nV = this.Lj.nV()) != null && nV.getParent() == null) {
            this.Lk.addView(nV, this.Ll);
            this.Lj.showRecordTooShort();
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void startRecordVoice() {
        LinearLayout nU;
        if (this.Lj != null && this.Lk != null && this.Ll != null && (nU = this.Lj.nU()) != null && nU.getParent() == null) {
            this.Lk.addView(nU, this.Ll);
            this.Lj.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void stopRecordVoice() {
        if (this.Lj != null && this.Lk != null && this.Ll != null) {
            this.Lj.stopRecordVoice();
            LinearLayout nU = this.Lj.nU();
            if (nU != null && nU.getParent() != null) {
                this.Lk.removeView(nU);
            }
        }
    }
}
