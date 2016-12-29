package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.chat.ISendVoiceView;
import com.baidu.tieba.im.chat.ak;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class SendVoiceView extends LinearLayout implements com.baidu.tbadk.editortools.y, ISendVoiceView, ak {
    private TextView EK;
    private int EL;
    private com.baidu.tbadk.editortools.j EM;
    private FloatRecordView EN;
    private WindowManager EO;
    private WindowManager.LayoutParams EP;

    public SendVoiceView(Context context) {
        super(context);
        this.EK = null;
        this.EL = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(r.h.send_voice_view, this);
            this.EK = (TextView) findViewById(r.g.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            lA();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.EK.setBackgroundResource(r.f.but_talk_s);
            this.EK.setText(TbadkCoreApplication.m9getInst().getContext().getString(r.j.msglist_no_push));
            return;
        }
        this.EK.setBackgroundResource(r.f.but_talk_n);
        this.EK.setText(TbadkCoreApplication.m9getInst().getContext().getString(r.j.msglist_push_talk));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.y
    public void lz() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.EL;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.y
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.EM != null) {
            this.EM.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.EM = jVar;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.EL = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void onChangeSkinType(int i) {
    }

    private void lA() {
        this.EN = new FloatRecordView(getContext());
        this.EO = (WindowManager) TbadkCoreApplication.m9getInst().getContext().getSystemService("window");
        this.EP = new WindowManager.LayoutParams();
        this.EP.type = 2002;
        this.EP.format = 1;
        this.EP.flags = 56;
        this.EP.gravity = 17;
        this.EP.x = 0;
        this.EP.y = 0;
        this.EP.width = getContext().getResources().getDimensionPixelSize(r.e.ds360);
        this.EP.height = getContext().getResources().getDimensionPixelSize(r.e.ds360);
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
                lu();
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
        if (this.EN != null && this.EO != null && this.EP != null) {
            this.EN.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void closeRecordCancel() {
        if (this.EN != null && this.EO != null && this.EP != null) {
            this.EN.closeRecordCancel();
            LinearLayout lt = this.EN.lt();
            if (lt != null && lt.getParent() != null) {
                this.EO.removeView(lt);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void closeRecordTooShort() {
        if (this.EN != null && this.EO != null && this.EP != null) {
            this.EN.closeRecordTooShort();
            LinearLayout ls = this.EN.ls();
            if (ls != null && ls.getParent() != null) {
                this.EO.removeView(ls);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void showRecordCancel() {
        LinearLayout lt;
        if (this.EN != null && this.EO != null && this.EP != null && (lt = this.EN.lt()) != null && lt.getParent() == null) {
            this.EO.addView(lt, this.EP);
            this.EN.showRecordCancel();
        }
    }

    public void lu() {
        LinearLayout ls;
        if (this.EN != null && this.EO != null && this.EP != null && (ls = this.EN.ls()) != null && ls.getParent() == null) {
            this.EO.addView(ls, this.EP);
            this.EN.lu();
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void startRecordVoice() {
        LinearLayout lr;
        if (this.EN != null && this.EO != null && this.EP != null && (lr = this.EN.lr()) != null && lr.getParent() == null) {
            this.EO.addView(lr, this.EP);
            this.EN.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void stopRecordVoice() {
        if (this.EN != null && this.EO != null && this.EP != null) {
            this.EN.stopRecordVoice();
            LinearLayout lr = this.EN.lr();
            if (lr != null && lr.getParent() != null) {
                this.EO.removeView(lr);
            }
        }
    }
}
