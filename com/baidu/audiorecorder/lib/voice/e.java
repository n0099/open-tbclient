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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.s;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class e extends LinearLayout implements com.baidu.adp.lib.voice.f, s {
    private FrameLayout axK;
    private ImageView axL;
    private RecordingAnimView axM;
    private TextView axN;
    private TextView axO;
    private i axP;
    private int axQ;
    private boolean axR;
    private com.baidu.tbadk.core.dialog.a axS;
    private VoiceData.VoiceModel mModel;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;

    public e(Context context) {
        super(context);
        this.axQ = 0;
        initView();
    }

    private void initView() {
        inflate(getContext(), d.h.layou_new_record_button, this);
        this.axK = (FrameLayout) findViewById(d.g.layout_record_button);
        this.axL = (ImageView) findViewById(d.g.iv_record_init);
        this.axM = (RecordingAnimView) findViewById(d.g.record_anim_view);
        this.axM.setCertainColumnCount(8);
        this.axM.setColumnColor(d.C0140d.cp_cont_g);
        this.axM.setColumnWidth(getResources().getDimensionPixelSize(d.e.ds4));
        this.axN = (TextView) findViewById(d.g.tv_duration);
        this.axO = (TextView) findViewById(d.g.tv_tip);
        this.axK.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.audiorecorder.lib.voice.e.1
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
        if (this.axS == null) {
            this.axS = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.i.ak(getContext()).getPageActivity());
            this.axS.dk(getContext().getString(d.j.voice_restart_tip)).a(getContext().getString(d.j.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.e.3
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
        this.axS.AU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRecord() {
        if (getContext() instanceof Activity) {
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.DI();
            this.mPermissionJudgePolicy.c((Activity) getContext(), "android.permission.WRITE_EXTERNAL_STORAGE");
            this.mPermissionJudgePolicy.c((Activity) getContext(), "android.permission.RECORD_AUDIO");
            if (this.mPermissionJudgePolicy.v((Activity) getContext())) {
                return;
            }
        }
        if (this.mModel != null) {
            com.baidu.tbadk.core.voice.a.aM(com.baidu.tbadk.core.voice.a.eZ(this.mModel.voiceId));
        }
        com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (recorderManager != null && recorderManager.tk()) {
            this.axR = recorderManager.a(this, -1);
            this.axN.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopRecord() {
        this.axL.setVisibility(0);
        this.axM.tn();
        this.axM.setVisibility(4);
        this.axO.setText(getResources().getText(d.j.voice_record_press_to_record));
        this.axN.setVisibility(4);
        com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.axR && recorderManager != null) {
            recorderManager.stopRecord();
        }
        this.axR = false;
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
                        this.axO.setText(getResources().getText(d.j.voice_restart));
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
        this.axO.setText(getResources().getText(d.j.voice_record_press_to_record));
        this.axN.setText("");
        this.axN.setVisibility(4);
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            this.axL.setVisibility(4);
            this.axM.setVisibility(0);
            this.axM.start();
            this.axO.setText(getResources().getText(d.j.voice_record_release_to_stop));
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStopingRecorder() {
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        this.axN.setVisibility(0);
        this.axN.setText(str);
        postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.4
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.axN != null && !e.this.axR) {
                    e.this.axN.setVisibility(4);
                    e.this.axN.setText("");
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
            this.axO.setText(getResources().getText(d.j.voice_restart));
            b(new com.baidu.tbadk.editortools.a(10, -1, this.mModel));
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onDeletedVoice(String str) {
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecordTime(int i) {
        this.axN.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.axP = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.axP != null) {
            this.axP.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.axQ = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.axQ;
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
        aj.r(this.axO, d.C0140d.cp_cont_f);
        aj.r(this.axN, d.C0140d.common_color_10140);
        aj.s(this.axL, d.f.ic_post_record);
        this.axM.onChangeSkinType(i);
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
