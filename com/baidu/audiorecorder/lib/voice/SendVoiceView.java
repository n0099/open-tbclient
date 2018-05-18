package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.ISendVoiceView;
/* loaded from: classes3.dex */
public class SendVoiceView extends LinearLayout implements l, ISendVoiceView, com.baidu.tieba.im.chat.c {
    private EditorTools JO;
    private int JP;
    private TextView Kp;
    private FloatRecordView Kq;
    private WindowManager Kr;
    private WindowManager.LayoutParams Ks;

    public SendVoiceView(Context context) {
        super(context);
        this.Kp = null;
        this.JP = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(d.i.send_voice_view, this);
            this.Kp = (TextView) findViewById(d.g.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            lT();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.Kp.setBackgroundResource(d.f.but_talk_s);
            this.Kp.setText(TbadkCoreApplication.getInst().getContext().getString(d.k.msglist_no_push));
            return;
        }
        this.Kp.setBackgroundResource(d.f.but_talk_n);
        this.Kp.setText(TbadkCoreApplication.getInst().getContext().getString(d.k.msglist_push_talk));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void lM() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.JP;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.JO != null) {
            this.JO.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.JO = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.JP = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
    }

    private void lT() {
        this.Kq = new FloatRecordView(getContext());
        this.Kr = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
        this.Ks = new WindowManager.LayoutParams();
        this.Ks.type = 2002;
        this.Ks.format = 1;
        this.Ks.flags = 56;
        this.Ks.gravity = 17;
        this.Ks.x = 0;
        this.Ks.y = 0;
        this.Ks.width = getContext().getResources().getDimensionPixelSize(d.e.ds360);
        this.Ks.height = getContext().getResources().getDimensionPixelSize(d.e.ds360);
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStopingRecorder() {
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                stopRecordVoice();
            } else if (i == 2) {
                closeRecordCancel();
                closeRecordTooShort();
                lK();
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onDeletedVoice(String str) {
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecordTime(int i) {
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        if (this.Kq != null && this.Kr != null && this.Ks != null) {
            this.Kq.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        if (this.Kq != null && this.Kr != null && this.Ks != null) {
            this.Kq.closeRecordCancel();
            LinearLayout lJ = this.Kq.lJ();
            if (lJ != null && lJ.getParent() != null) {
                this.Kr.removeView(lJ);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        if (this.Kq != null && this.Kr != null && this.Ks != null) {
            this.Kq.closeRecordTooShort();
            LinearLayout lI = this.Kq.lI();
            if (lI != null && lI.getParent() != null) {
                this.Kr.removeView(lI);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        LinearLayout lJ;
        if (this.Kq != null && this.Kr != null && this.Ks != null && (lJ = this.Kq.lJ()) != null && lJ.getParent() == null) {
            this.Kr.addView(lJ, this.Ks);
            this.Kq.showRecordCancel();
        }
    }

    public void lK() {
        LinearLayout lI;
        if (this.Kq != null && this.Kr != null && this.Ks != null && (lI = this.Kq.lI()) != null && lI.getParent() == null) {
            this.Kr.addView(lI, this.Ks);
            this.Kq.lK();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        LinearLayout lH;
        if (this.Kq != null && this.Kr != null && this.Ks != null && (lH = this.Kq.lH()) != null && lH.getParent() == null) {
            this.Kr.addView(lH, this.Ks);
            this.Kq.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        if (this.Kq != null && this.Kr != null && this.Ks != null) {
            this.Kq.stopRecordVoice();
            LinearLayout lH = this.Kq.lH();
            if (lH != null && lH.getParent() != null) {
                this.Kr.removeView(lH);
            }
        }
    }
}
