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
/* loaded from: classes11.dex */
public class SendVoiceView extends LinearLayout implements m, ISendVoiceView, com.baidu.tieba.im.chat.c {
    private EditorTools ZX;
    private int ZY;
    private TextView aaw;
    private FloatRecordView aax;
    private WindowManager aay;
    private WindowManager.LayoutParams aaz;

    public SendVoiceView(Context context) {
        super(context);
        this.aaw = null;
        this.ZY = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(R.layout.send_voice_view, this);
            this.aaw = (TextView) findViewById(R.id.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            qS();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.aaw.setBackgroundResource(R.drawable.but_talk_s);
            this.aaw.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_no_push));
            return;
        }
        this.aaw.setBackgroundResource(R.drawable.but_talk_n);
        this.aaw.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_push_talk));
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
        return this.ZY;
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
        if (this.ZX != null) {
            this.ZX.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.ZX = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.ZY = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
    }

    private void qS() {
        this.aax = new FloatRecordView(getContext());
        this.aay = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
        this.aaz = new WindowManager.LayoutParams();
        this.aaz.type = com.baidu.tieba.v.c.FO(2002);
        this.aaz.format = 1;
        this.aaz.flags = 56;
        this.aaz.gravity = 17;
        this.aaz.x = 0;
        this.aaz.y = 0;
        this.aaz.width = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
        this.aaz.height = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
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
                qJ();
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
        if (this.aax != null && this.aay != null && this.aaz != null) {
            this.aax.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        if (this.aax != null && this.aay != null && this.aaz != null) {
            this.aax.closeRecordCancel();
            LinearLayout qI = this.aax.qI();
            if (qI != null && qI.getParent() != null) {
                this.aay.removeView(qI);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        if (this.aax != null && this.aay != null && this.aaz != null) {
            this.aax.closeRecordTooShort();
            LinearLayout qH = this.aax.qH();
            if (qH != null && qH.getParent() != null) {
                this.aay.removeView(qH);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        LinearLayout qI;
        if (this.aax != null && this.aay != null && this.aaz != null && (qI = this.aax.qI()) != null && qI.getParent() == null) {
            this.aay.addView(qI, this.aaz);
            this.aax.showRecordCancel();
        }
    }

    public void qJ() {
        LinearLayout qH;
        if (this.aax != null && this.aay != null && this.aaz != null && (qH = this.aax.qH()) != null && qH.getParent() == null) {
            this.aay.addView(qH, this.aaz);
            this.aax.qJ();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        LinearLayout qG;
        if (this.aax != null && this.aay != null && this.aaz != null && (qG = this.aax.qG()) != null && qG.getParent() == null) {
            this.aay.addView(qG, this.aaz);
            this.aax.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        if (this.aax != null && this.aay != null && this.aaz != null) {
            this.aax.stopRecordVoice();
            LinearLayout qG = this.aax.qG();
            if (qG != null && qG.getParent() != null) {
                this.aay.removeView(qG);
            }
        }
    }
}
