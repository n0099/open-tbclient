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
    private EditorTools JS;
    private int JT;
    private TextView Kt;
    private FloatRecordView Ku;
    private WindowManager Kv;
    private WindowManager.LayoutParams Kw;

    public SendVoiceView(Context context) {
        super(context);
        this.Kt = null;
        this.JT = 0;
        if (context != null) {
            LayoutInflater.from(context).inflate(d.i.send_voice_view, this);
            this.Kt = (TextView) findViewById(d.g.tex_send_voice);
            setFocusable(true);
            setFocusableInTouchMode(true);
            lU();
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.Kt.setBackgroundResource(d.f.but_talk_s);
            this.Kt.setText(TbadkCoreApplication.getInst().getContext().getString(d.k.msglist_no_push));
            return;
        }
        this.Kt.setBackgroundResource(d.f.but_talk_n);
        this.Kt.setText(TbadkCoreApplication.getInst().getContext().getString(d.k.msglist_push_talk));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void lN() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.JT;
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
        if (this.JS != null) {
            this.JS.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.JS = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.JT = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
    }

    private void lU() {
        this.Ku = new FloatRecordView(getContext());
        this.Kv = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
        this.Kw = new WindowManager.LayoutParams();
        this.Kw.type = 2002;
        this.Kw.format = 1;
        this.Kw.flags = 56;
        this.Kw.gravity = 17;
        this.Kw.x = 0;
        this.Kw.y = 0;
        this.Kw.width = getContext().getResources().getDimensionPixelSize(d.e.ds360);
        this.Kw.height = getContext().getResources().getDimensionPixelSize(d.e.ds360);
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
                lL();
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
        if (this.Ku != null && this.Kv != null && this.Kw != null) {
            this.Ku.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordCancel() {
        if (this.Ku != null && this.Kv != null && this.Kw != null) {
            this.Ku.closeRecordCancel();
            LinearLayout lK = this.Ku.lK();
            if (lK != null && lK.getParent() != null) {
                this.Kv.removeView(lK);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void closeRecordTooShort() {
        if (this.Ku != null && this.Kv != null && this.Kw != null) {
            this.Ku.closeRecordTooShort();
            LinearLayout lJ = this.Ku.lJ();
            if (lJ != null && lJ.getParent() != null) {
                this.Kv.removeView(lJ);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void showRecordCancel() {
        LinearLayout lK;
        if (this.Ku != null && this.Kv != null && this.Kw != null && (lK = this.Ku.lK()) != null && lK.getParent() == null) {
            this.Kv.addView(lK, this.Kw);
            this.Ku.showRecordCancel();
        }
    }

    public void lL() {
        LinearLayout lJ;
        if (this.Ku != null && this.Kv != null && this.Kw != null && (lJ = this.Ku.lJ()) != null && lJ.getParent() == null) {
            this.Kv.addView(lJ, this.Kw);
            this.Ku.lL();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void startRecordVoice() {
        LinearLayout lI;
        if (this.Ku != null && this.Kv != null && this.Kw != null && (lI = this.Ku.lI()) != null && lI.getParent() == null) {
            this.Kv.addView(lI, this.Kw);
            this.Ku.startRecordVoice();
        }
    }

    @Override // com.baidu.tieba.im.chat.c
    public void stopRecordVoice() {
        if (this.Ku != null && this.Kv != null && this.Kw != null) {
            this.Ku.stopRecordVoice();
            LinearLayout lI = this.Ku.lI();
            if (lI != null && lI.getParent() != null) {
                this.Kv.removeView(lI);
            }
        }
    }
}
