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
    private TextView ZR;
    private FloatRecordView ZS;
    private WindowManager ZT;
    private WindowManager.LayoutParams ZU;
    private EditorTools Zt;
    private int Zu;

    public SendVoiceView(Context context) {
        super(context);
        this.ZR = null;
        this.Zu = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(R.layout.send_voice_view, this);
            this.ZR = (TextView) findViewById(R.id.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            qB();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.ZR.setBackgroundResource(R.drawable.but_talk_s);
            this.ZR.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_no_push));
            return;
        }
        this.ZR.setBackgroundResource(R.drawable.but_talk_n);
        this.ZR.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_push_talk));
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
        return this.Zu;
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
        if (this.Zt != null) {
            this.Zt.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.Zt = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.Zu = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
    }

    private void qB() {
        this.ZS = new FloatRecordView(getContext());
        this.ZT = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
        this.ZU = new WindowManager.LayoutParams();
        this.ZU.type = com.baidu.tieba.v.c.EK(2002);
        this.ZU.format = 1;
        this.ZU.flags = 56;
        this.ZU.gravity = 17;
        this.ZU.x = 0;
        this.ZU.y = 0;
        this.ZU.width = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
        this.ZU.height = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
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
                qs();
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
        if (this.ZS != null && this.ZT != null && this.ZU != null) {
            this.ZS.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        if (this.ZS != null && this.ZT != null && this.ZU != null) {
            this.ZS.closeRecordCancel();
            LinearLayout qr = this.ZS.qr();
            if (qr != null && qr.getParent() != null) {
                this.ZT.removeView(qr);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        if (this.ZS != null && this.ZT != null && this.ZU != null) {
            this.ZS.closeRecordTooShort();
            LinearLayout qq = this.ZS.qq();
            if (qq != null && qq.getParent() != null) {
                this.ZT.removeView(qq);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        LinearLayout qr;
        if (this.ZS != null && this.ZT != null && this.ZU != null && (qr = this.ZS.qr()) != null && qr.getParent() == null) {
            this.ZT.addView(qr, this.ZU);
            this.ZS.showRecordCancel();
        }
    }

    public void qs() {
        LinearLayout qq;
        if (this.ZS != null && this.ZT != null && this.ZU != null && (qq = this.ZS.qq()) != null && qq.getParent() == null) {
            this.ZT.addView(qq, this.ZU);
            this.ZS.qs();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        LinearLayout qp;
        if (this.ZS != null && this.ZT != null && this.ZU != null && (qp = this.ZS.qp()) != null && qp.getParent() == null) {
            this.ZT.addView(qp, this.ZU);
            this.ZS.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        if (this.ZS != null && this.ZT != null && this.ZU != null) {
            this.ZS.stopRecordVoice();
            LinearLayout qp = this.ZS.qp();
            if (qp != null && qp.getParent() != null) {
                this.ZT.removeView(qp);
            }
        }
    }
}
