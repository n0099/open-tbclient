package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.s;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.ISendVoiceView;
/* loaded from: classes2.dex */
public class SendVoiceView extends LinearLayout implements s, ISendVoiceView, com.baidu.tieba.im.chat.c {
    private TextView Jn;
    private int Jo;
    private i Jp;
    private FloatRecordView Jq;
    private WindowManager Jr;
    private WindowManager.LayoutParams Js;

    public SendVoiceView(Context context) {
        super(context);
        this.Jn = null;
        this.Jo = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(d.j.send_voice_view, this);
            this.Jn = (TextView) findViewById(d.h.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            lL();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.Jn.setBackgroundResource(d.g.but_talk_s);
            this.Jn.setText(TbadkCoreApplication.getInst().getContext().getString(d.l.msglist_no_push));
            return;
        }
        this.Jn.setBackgroundResource(d.g.but_talk_n);
        this.Jn.setText(TbadkCoreApplication.getInst().getContext().getString(d.l.msglist_push_talk));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lK() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.Jo;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Jp != null) {
            this.Jp.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.Jp = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.Jo = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
    }

    private void lL() {
        this.Jq = new FloatRecordView(getContext());
        this.Jr = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
        this.Js = new WindowManager.LayoutParams();
        this.Js.type = 2002;
        this.Js.format = 1;
        this.Js.flags = 56;
        this.Js.gravity = 17;
        this.Js.x = 0;
        this.Js.y = 0;
        this.Js.width = getContext().getResources().getDimensionPixelSize(d.f.ds360);
        this.Js.height = getContext().getResources().getDimensionPixelSize(d.f.ds360);
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
                lG();
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
        if (this.Jq != null && this.Jr != null && this.Js != null) {
            this.Jq.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        if (this.Jq != null && this.Jr != null && this.Js != null) {
            this.Jq.closeRecordCancel();
            LinearLayout lF = this.Jq.lF();
            if (lF != null && lF.getParent() != null) {
                this.Jr.removeView(lF);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        if (this.Jq != null && this.Jr != null && this.Js != null) {
            this.Jq.closeRecordTooShort();
            LinearLayout lE = this.Jq.lE();
            if (lE != null && lE.getParent() != null) {
                this.Jr.removeView(lE);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        LinearLayout lF;
        if (this.Jq != null && this.Jr != null && this.Js != null && (lF = this.Jq.lF()) != null && lF.getParent() == null) {
            this.Jr.addView(lF, this.Js);
            this.Jq.showRecordCancel();
        }
    }

    public void lG() {
        LinearLayout lE;
        if (this.Jq != null && this.Jr != null && this.Js != null && (lE = this.Jq.lE()) != null && lE.getParent() == null) {
            this.Jr.addView(lE, this.Js);
            this.Jq.lG();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        LinearLayout lD;
        if (this.Jq != null && this.Jr != null && this.Js != null && (lD = this.Jq.lD()) != null && lD.getParent() == null) {
            this.Jr.addView(lD, this.Js);
            this.Jq.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        if (this.Jq != null && this.Jr != null && this.Js != null) {
            this.Jq.stopRecordVoice();
            LinearLayout lD = this.Jq.lD();
            if (lD != null && lD.getParent() != null) {
                this.Jr.removeView(lD);
            }
        }
    }
}
