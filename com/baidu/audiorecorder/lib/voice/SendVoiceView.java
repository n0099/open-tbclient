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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class SendVoiceView extends LinearLayout implements z, ISendVoiceView, ak {
    private WindowManager.LayoutParams LA;
    private TextView Lv;
    private int Lw;
    private com.baidu.tbadk.editortools.k Lx;
    private FloatRecordView Ly;
    private WindowManager Lz;

    public SendVoiceView(Context context) {
        super(context);
        this.Lv = null;
        this.Lw = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(t.h.send_voice_view, this);
            this.Lv = (TextView) findViewById(t.g.tex_send_voice);
            ox();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.Lv.setBackgroundResource(t.f.but_talk_s);
            this.Lv.setText(TbadkCoreApplication.m411getInst().getContext().getString(t.j.msglist_no_push));
            return;
        }
        this.Lv.setBackgroundResource(t.f.but_talk_n);
        this.Lv.setText(TbadkCoreApplication.m411getInst().getContext().getString(t.j.msglist_push_talk));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.z
    public void ow() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.z
    public int getToolId() {
        return this.Lw;
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
        if (this.Lx != null) {
            this.Lx.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.z
    public void setEditorTools(com.baidu.tbadk.editortools.k kVar) {
        this.Lx = kVar;
    }

    @Override // com.baidu.tbadk.editortools.z
    public void setToolId(int i) {
        this.Lw = i;
    }

    @Override // com.baidu.tbadk.editortools.z
    public void onChangeSkinType(int i) {
    }

    private void ox() {
        this.Ly = new FloatRecordView(getContext());
        this.Lz = (WindowManager) TbadkCoreApplication.m411getInst().getContext().getSystemService("window");
        this.LA = new WindowManager.LayoutParams();
        this.LA.type = 2002;
        this.LA.format = 1;
        this.LA.flags = 56;
        this.LA.gravity = 17;
        this.LA.x = 0;
        this.LA.y = 0;
        this.LA.width = getContext().getResources().getDimensionPixelSize(t.e.im_msg_voice_layer_width);
        this.LA.height = getContext().getResources().getDimensionPixelSize(t.e.im_msg_voice_layer_height);
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
                or();
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
        if (this.Ly != null && this.Lz != null && this.LA != null) {
            this.Ly.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void closeRecordCancel() {
        if (this.Ly != null && this.Lz != null && this.LA != null) {
            this.Ly.closeRecordCancel();
            LinearLayout oq = this.Ly.oq();
            if (oq != null && oq.getParent() != null) {
                this.Lz.removeView(oq);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void closeRecordTooShort() {
        if (this.Ly != null && this.Lz != null && this.LA != null) {
            this.Ly.closeRecordTooShort();
            LinearLayout op = this.Ly.op();
            if (op != null && op.getParent() != null) {
                this.Lz.removeView(op);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void showRecordCancel() {
        LinearLayout oq;
        if (this.Ly != null && this.Lz != null && this.LA != null && (oq = this.Ly.oq()) != null && oq.getParent() == null) {
            this.Lz.addView(oq, this.LA);
            this.Ly.showRecordCancel();
        }
    }

    public void or() {
        LinearLayout op;
        if (this.Ly != null && this.Lz != null && this.LA != null && (op = this.Ly.op()) != null && op.getParent() == null) {
            this.Lz.addView(op, this.LA);
            this.Ly.or();
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void startRecordVoice() {
        LinearLayout oo;
        if (this.Ly != null && this.Lz != null && this.LA != null && (oo = this.Ly.oo()) != null && oo.getParent() == null) {
            this.Lz.addView(oo, this.LA);
            this.Ly.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void stopRecordVoice() {
        if (this.Ly != null && this.Lz != null && this.LA != null) {
            this.Ly.stopRecordVoice();
            LinearLayout oo = this.Ly.oo();
            if (oo != null && oo.getParent() != null) {
                this.Lz.removeView(oo);
            }
        }
    }
}
