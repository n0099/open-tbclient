package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.ab;
import com.baidu.tieba.im.chat.ISendVoiceView;
import com.baidu.tieba.im.chat.ak;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class SendVoiceView extends LinearLayout implements ab, ISendVoiceView, ak {
    private TextView LC;
    private int LD;
    private com.baidu.tbadk.editortools.l LE;
    private FloatRecordView LF;
    private WindowManager LG;
    private WindowManager.LayoutParams LH;

    public SendVoiceView(Context context) {
        super(context);
        this.LC = null;
        this.LD = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(t.h.send_voice_view, this);
            this.LC = (TextView) findViewById(t.g.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            oq();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.LC.setBackgroundResource(t.f.but_talk_s);
            this.LC.setText(TbadkCoreApplication.m411getInst().getContext().getString(t.j.msglist_no_push));
            return;
        }
        this.LC.setBackgroundResource(t.f.but_talk_n);
        this.LC.setText(TbadkCoreApplication.m411getInst().getContext().getString(t.j.msglist_push_talk));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void op() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public int getToolId() {
        return this.LD;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.LE != null) {
            this.LE.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setEditorTools(com.baidu.tbadk.editortools.l lVar) {
        this.LE = lVar;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setToolId(int i) {
        this.LD = i;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void onChangeSkinType(int i) {
    }

    private void oq() {
        this.LF = new FloatRecordView(getContext());
        this.LG = (WindowManager) TbadkCoreApplication.m411getInst().getContext().getSystemService("window");
        this.LH = new WindowManager.LayoutParams();
        this.LH.type = 2002;
        this.LH.format = 1;
        this.LH.flags = 56;
        this.LH.gravity = 17;
        this.LH.x = 0;
        this.LH.y = 0;
        this.LH.width = getContext().getResources().getDimensionPixelSize(t.e.im_msg_voice_layer_width);
        this.LH.height = getContext().getResources().getDimensionPixelSize(t.e.im_msg_voice_layer_height);
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
                ok();
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
        if (this.LF != null && this.LG != null && this.LH != null) {
            this.LF.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void closeRecordCancel() {
        if (this.LF != null && this.LG != null && this.LH != null) {
            this.LF.closeRecordCancel();
            LinearLayout oj = this.LF.oj();
            if (oj != null && oj.getParent() != null) {
                this.LG.removeView(oj);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void closeRecordTooShort() {
        if (this.LF != null && this.LG != null && this.LH != null) {
            this.LF.closeRecordTooShort();
            LinearLayout oi = this.LF.oi();
            if (oi != null && oi.getParent() != null) {
                this.LG.removeView(oi);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void showRecordCancel() {
        LinearLayout oj;
        if (this.LF != null && this.LG != null && this.LH != null && (oj = this.LF.oj()) != null && oj.getParent() == null) {
            this.LG.addView(oj, this.LH);
            this.LF.showRecordCancel();
        }
    }

    public void ok() {
        LinearLayout oi;
        if (this.LF != null && this.LG != null && this.LH != null && (oi = this.LF.oi()) != null && oi.getParent() == null) {
            this.LG.addView(oi, this.LH);
            this.LF.ok();
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void startRecordVoice() {
        LinearLayout oh;
        if (this.LF != null && this.LG != null && this.LH != null && (oh = this.LF.oh()) != null && oh.getParent() == null) {
            this.LG.addView(oh, this.LH);
            this.LF.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void stopRecordVoice() {
        if (this.LF != null && this.LG != null && this.LH != null) {
            this.LF.stopRecordVoice();
            LinearLayout oh = this.LF.oh();
            if (oh != null && oh.getParent() != null) {
                this.LG.removeView(oh);
            }
        }
    }
}
