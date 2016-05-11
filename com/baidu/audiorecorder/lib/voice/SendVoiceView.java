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
    private TextView BT;
    private int BU;
    private com.baidu.tbadk.editortools.l BV;
    private FloatRecordView BW;
    private WindowManager BX;
    private WindowManager.LayoutParams BY;

    public SendVoiceView(Context context) {
        super(context);
        this.BT = null;
        this.BU = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(t.h.send_voice_view, this);
            this.BT = (TextView) findViewById(t.g.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            kD();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.BT.setBackgroundResource(t.f.but_talk_s);
            this.BT.setText(TbadkCoreApplication.m11getInst().getContext().getString(t.j.msglist_no_push));
            return;
        }
        this.BT.setBackgroundResource(t.f.but_talk_n);
        this.BT.setText(TbadkCoreApplication.m11getInst().getContext().getString(t.j.msglist_push_talk));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void kC() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public int getToolId() {
        return this.BU;
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
        if (this.BV != null) {
            this.BV.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setEditorTools(com.baidu.tbadk.editortools.l lVar) {
        this.BV = lVar;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setToolId(int i) {
        this.BU = i;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void onChangeSkinType(int i) {
    }

    private void kD() {
        this.BW = new FloatRecordView(getContext());
        this.BX = (WindowManager) TbadkCoreApplication.m11getInst().getContext().getSystemService("window");
        this.BY = new WindowManager.LayoutParams();
        this.BY.type = 2002;
        this.BY.format = 1;
        this.BY.flags = 56;
        this.BY.gravity = 17;
        this.BY.x = 0;
        this.BY.y = 0;
        this.BY.width = getContext().getResources().getDimensionPixelSize(t.e.im_msg_voice_layer_width);
        this.BY.height = getContext().getResources().getDimensionPixelSize(t.e.im_msg_voice_layer_height);
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
                kx();
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
        if (this.BW != null && this.BX != null && this.BY != null) {
            this.BW.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void closeRecordCancel() {
        if (this.BW != null && this.BX != null && this.BY != null) {
            this.BW.closeRecordCancel();
            LinearLayout kw = this.BW.kw();
            if (kw != null && kw.getParent() != null) {
                this.BX.removeView(kw);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void closeRecordTooShort() {
        if (this.BW != null && this.BX != null && this.BY != null) {
            this.BW.closeRecordTooShort();
            LinearLayout kv = this.BW.kv();
            if (kv != null && kv.getParent() != null) {
                this.BX.removeView(kv);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void showRecordCancel() {
        LinearLayout kw;
        if (this.BW != null && this.BX != null && this.BY != null && (kw = this.BW.kw()) != null && kw.getParent() == null) {
            this.BX.addView(kw, this.BY);
            this.BW.showRecordCancel();
        }
    }

    public void kx() {
        LinearLayout kv;
        if (this.BW != null && this.BX != null && this.BY != null && (kv = this.BW.kv()) != null && kv.getParent() == null) {
            this.BX.addView(kv, this.BY);
            this.BW.kx();
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void startRecordVoice() {
        LinearLayout ku;
        if (this.BW != null && this.BX != null && this.BY != null && (ku = this.BW.ku()) != null && ku.getParent() == null) {
            this.BX.addView(ku, this.BY);
            this.BW.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.ak
    public void stopRecordVoice() {
        if (this.BW != null && this.BX != null && this.BY != null) {
            this.BW.stopRecordVoice();
            LinearLayout ku = this.BW.ku();
            if (ku != null && ku.getParent() != null) {
                this.BX.removeView(ku);
            }
        }
    }
}
