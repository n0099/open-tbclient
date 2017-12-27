package com.baidu.audiorecorder.lib.voice;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.s;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class e extends LinearLayout implements com.baidu.adp.lib.voice.f, s {
    private FrameLayout axJ;
    private ImageView axK;
    private RecordingAnimView axL;
    private TextView axM;
    private TextView axN;
    private i axO;
    private int axP;
    private boolean axQ;
    private com.baidu.tbadk.core.dialog.a axR;
    private VoiceData.VoiceModel mModel;

    public e(Context context) {
        super(context);
        this.axP = 0;
        initView();
    }

    private void initView() {
        inflate(getContext(), d.h.layou_new_record_button, this);
        this.axJ = (FrameLayout) findViewById(d.g.layout_record_button);
        this.axK = (ImageView) findViewById(d.g.iv_record_init);
        this.axL = (RecordingAnimView) findViewById(d.g.record_anim_view);
        this.axL.setCertainColumnCount(8);
        this.axL.setColumnColor(d.C0108d.cp_cont_g);
        this.axL.setColumnWidth(getResources().getDimensionPixelSize(d.e.ds4));
        this.axM = (TextView) findViewById(d.g.tv_duration);
        this.axN = (TextView) findViewById(d.g.tv_tip);
        this.axJ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.audiorecorder.lib.voice.e.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        if (e.this.mModel == null) {
                            e.this.startRecord();
                            return true;
                        }
                        return true;
                    case 1:
                        if (e.this.mModel == null) {
                            e.this.stopRecord();
                            return true;
                        }
                        e.this.tg();
                        return true;
                    default:
                        return true;
                }
            }
        });
        com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (recorderManager != null) {
            recorderManager.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tg() {
        if (this.axR == null) {
            this.axR = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.i.ak(getContext()).getPageActivity());
            this.axR.cZ(getContext().getString(d.j.voice_restart_tip)).a(getContext().getString(d.j.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.e.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    e.this.b(new com.baidu.tbadk.editortools.a(11, -1, null));
                }
            }).b(getContext().getString(d.j.cancel), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.e.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(com.baidu.adp.base.i.ak(getContext()));
        }
        this.axR.AI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRecord() {
        if (!ab.aV(getContext()) && (getContext() instanceof Activity)) {
            ab.g((Activity) getContext(), 25037);
            return;
        }
        if (this.mModel != null) {
            com.baidu.tbadk.core.voice.a.aM(com.baidu.tbadk.core.voice.a.eG(this.mModel.voiceId));
        }
        com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (recorderManager != null && recorderManager.tk()) {
            this.axQ = recorderManager.a(this, -1);
            this.axM.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopRecord() {
        this.axK.setVisibility(0);
        this.axL.tn();
        this.axL.setVisibility(4);
        this.axN.setText(getResources().getText(d.j.voice_record_press_to_record));
        this.axM.setVisibility(4);
        com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.axQ && recorderManager != null) {
            recorderManager.stopRecord();
        }
        this.axQ = false;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 9:
                    reset();
                    return;
                case 52:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        this.mModel = (VoiceData.VoiceModel) aVar.data;
                        this.axN.setText(getResources().getText(d.j.voice_restart));
                        return;
                    }
                    reset();
                    return;
                default:
                    return;
            }
        }
    }

    private void reset() {
        this.mModel = null;
        this.axN.setText(getResources().getText(d.j.voice_record_press_to_record));
        this.axM.setText("");
        this.axM.setVisibility(4);
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            this.axK.setVisibility(4);
            this.axL.setVisibility(0);
            this.axL.start();
            this.axN.setText(getResources().getText(d.j.voice_record_release_to_stop));
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStopingRecorder() {
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        this.axM.setVisibility(0);
        this.axM.setText(str);
        postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.4
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.axM != null && !e.this.axQ) {
                    e.this.axM.setVisibility(4);
                    e.this.axM.setText("");
                }
            }
        }, 2000L);
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        if (!TextUtils.isEmpty(str) && i > 0) {
            this.mModel = new VoiceData.VoiceModel();
            this.mModel.duration = i;
            this.mModel.isLocal = true;
            this.mModel.voiceId = str;
            this.mModel.voice_status = 1;
            this.axN.setText(getResources().getText(d.j.voice_restart));
            b(new com.baidu.tbadk.editortools.a(10, -1, this.mModel));
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onDeletedVoice(String str) {
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecordTime(int i) {
        this.axM.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.axO = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.axO != null) {
            this.axO.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.axP = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.axP;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void th() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        aj.r(this.axN, d.C0108d.cp_cont_f);
        aj.r(this.axM, d.C0108d.common_color_10140);
        aj.s(this.axK, d.f.ic_post_record);
        this.axL.onChangeSkinType(i);
    }

    public com.baidu.tieba.tbadkCore.voice.a getRecorderManager() {
        VoiceManager voiceManager = getVoiceManager();
        if (voiceManager == null || voiceManager.getRecorderManager() == null) {
            return null;
        }
        return voiceManager.getRecorderManager();
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        if ((com.baidu.adp.base.i.ak(getContext()) instanceof com.baidu.adp.base.e) && (tbPageContext = (TbPageContext) com.baidu.adp.base.i.ak(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return null;
    }
}
