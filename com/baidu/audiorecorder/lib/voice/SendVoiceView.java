package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.ISendVoiceView;
/* loaded from: classes18.dex */
public class SendVoiceView extends LinearLayout implements m, ISendVoiceView, com.baidu.tieba.im.chat.c {
    private EditorTools ZS;
    private int ZT;
    private TextView aar;
    private FloatRecordView aas;
    private WindowManager aat;
    private WindowManager.LayoutParams aau;

    public SendVoiceView(Context context) {
        super(context);
        this.aar = null;
        this.ZT = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(R.layout.send_voice_view, this);
            this.aar = (TextView) findViewById(R.id.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            qV();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.aar.setBackgroundResource(R.drawable.but_talk_s);
            this.aar.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_no_push));
            return;
        }
        this.aar.setBackgroundResource(R.drawable.but_talk_n);
        this.aar.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_push_talk));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.m
    public void display() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.ZT;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.ZS != null) {
            this.ZS.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.ZS = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.ZT = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
    }

    private void qV() {
        this.aas = new FloatRecordView(getContext());
        this.aat = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
        this.aau = new WindowManager.LayoutParams();
        this.aau.type = com.baidu.tieba.v.c.Gk(2002);
        this.aau.format = 1;
        this.aau.flags = 56;
        this.aau.gravity = 17;
        this.aau.x = 0;
        this.aau.y = 0;
        this.aau.width = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
        this.aau.height = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
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
                qM();
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
        if (this.aas != null && this.aat != null && this.aau != null) {
            this.aas.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        if (this.aas != null && this.aat != null && this.aau != null) {
            this.aas.closeRecordCancel();
            LinearLayout qL = this.aas.qL();
            if (qL != null && qL.getParent() != null) {
                this.aat.removeView(qL);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        if (this.aas != null && this.aat != null && this.aau != null) {
            this.aas.closeRecordTooShort();
            LinearLayout qK = this.aas.qK();
            if (qK != null && qK.getParent() != null) {
                this.aat.removeView(qK);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        LinearLayout qL;
        if (this.aas != null && this.aat != null && this.aau != null && (qL = this.aas.qL()) != null && qL.getParent() == null) {
            this.aat.addView(qL, this.aau);
            this.aas.showRecordCancel();
        }
    }

    public void qM() {
        LinearLayout qK;
        if (this.aas != null && this.aat != null && this.aau != null && (qK = this.aas.qK()) != null && qK.getParent() == null) {
            this.aat.addView(qK, this.aau);
            this.aas.qM();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        LinearLayout qJ;
        if (this.aas != null && this.aat != null && this.aau != null && (qJ = this.aas.qJ()) != null && qJ.getParent() == null) {
            this.aat.addView(qJ, this.aau);
            this.aas.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        if (this.aas != null && this.aat != null && this.aau != null) {
            this.aas.stopRecordVoice();
            LinearLayout qJ = this.aas.qJ();
            if (qJ != null && qJ.getParent() != null) {
                this.aat.removeView(qJ);
            }
        }
    }
}
