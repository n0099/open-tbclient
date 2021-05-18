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
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.webkit.sdk.PermissionRequest;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.c.a.j;
import d.a.c.e.q.f;
import d.a.j0.r.s.a;
import d.a.j0.w.n;
/* loaded from: classes.dex */
public class NewVoiceRecordButton extends LinearLayout implements f, n {

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f4189e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f4190f;

    /* renamed from: g  reason: collision with root package name */
    public RecordingAnimView f4191g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f4192h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f4193i;
    public EditorTools j;
    public int k;
    public VoiceData$VoiceModel l;
    public boolean m;
    public d.a.j0.r.s.a n;
    public PermissionJudgePolicy o;

    /* loaded from: classes.dex */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    if (NewVoiceRecordButton.this.l == null) {
                        NewVoiceRecordButton.this.n();
                    } else {
                        NewVoiceRecordButton.this.l();
                    }
                }
            } else if (NewVoiceRecordButton.this.l == null) {
                NewVoiceRecordButton.this.m();
            }
            return true;
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.e {
        public b() {
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes.dex */
    public class c implements a.e {
        public c() {
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            aVar.dismiss();
            NewVoiceRecordButton.this.d(new d.a.j0.w.a(11, -1, null));
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (NewVoiceRecordButton.this.f4192h == null || NewVoiceRecordButton.this.m) {
                return;
            }
            NewVoiceRecordButton.this.f4192h.setVisibility(4);
            NewVoiceRecordButton.this.f4192h.setText("");
        }
    }

    public NewVoiceRecordButton(Context context) {
        super(context);
        this.k = 0;
        j();
    }

    @Override // d.a.j0.w.n
    public void b() {
        setVisibility(0);
    }

    @Override // d.a.j0.w.n
    public void d(d.a.j0.w.a aVar) {
        EditorTools editorTools = this.j;
        if (editorTools != null) {
            editorTools.A(aVar);
        }
    }

    public d.a.k0.d3.p0.a getRecorderManager() {
        VoiceManager voiceManager = getVoiceManager();
        if (voiceManager == null || voiceManager.getRecorderManager() == null) {
            return null;
        }
        return voiceManager.getRecorderManager();
    }

    @Override // d.a.j0.w.n
    public int getToolId() {
        return this.k;
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.j) {
            return ((VoiceManager.j) context).getVoiceManager();
        }
        if ((j.a(getContext()) instanceof d.a.c.a.f) && (tbPageContext = (TbPageContext) j.a(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.j)) {
            return ((VoiceManager.j) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return null;
    }

    @Override // d.a.j0.w.n
    public void hide() {
        setVisibility(8);
    }

    @Override // d.a.j0.w.n
    public void init() {
    }

    public final void j() {
        LinearLayout.inflate(getContext(), R.layout.layou_new_record_button, this);
        this.f4189e = (FrameLayout) findViewById(R.id.layout_record_button);
        this.f4190f = (ImageView) findViewById(R.id.iv_record_init);
        RecordingAnimView recordingAnimView = (RecordingAnimView) findViewById(R.id.record_anim_view);
        this.f4191g = recordingAnimView;
        recordingAnimView.setCertainColumnCount(8);
        this.f4191g.setColumnColor(R.color.CAM_X0111);
        this.f4191g.setColumnWidth(getResources().getDimensionPixelSize(R.dimen.ds4));
        this.f4192h = (TextView) findViewById(R.id.tv_duration);
        this.f4193i = (TextView) findViewById(R.id.tv_tip);
        this.f4189e.setOnTouchListener(new a());
        d.a.k0.d3.p0.a recorderManager = getRecorderManager();
        if (recorderManager != null) {
            recorderManager.e(this);
        }
    }

    public final void k() {
        this.l = null;
        this.f4193i.setText(getResources().getText(R.string.voice_record_press_to_record));
        this.f4192h.setText("");
        this.f4192h.setVisibility(4);
    }

    public final void l() {
        if (this.n == null) {
            d.a.j0.r.s.a aVar = new d.a.j0.r.s.a(j.a(getContext()).getPageActivity());
            this.n = aVar;
            aVar.setMessage(getContext().getString(R.string.voice_restart_tip)).setPositiveButton(getContext().getString(R.string.voice_restart), new c()).setNegativeButton(getContext().getString(R.string.cancel), new b()).create(j.a(getContext()));
        }
        this.n.show();
    }

    public final void m() {
        if (getContext() instanceof Activity) {
            if (this.o == null) {
                this.o = new PermissionJudgePolicy();
            }
            this.o.clearRequestPermissionList();
            this.o.appendRequestPermission((Activity) getContext(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
            this.o.appendRequestPermission((Activity) getContext(), PermissionRequest.RESOURCE_AUDIO_CAPTURE);
            if (this.o.startRequestPermission((Activity) getContext())) {
                return;
            }
        }
        VoiceData$VoiceModel voiceData$VoiceModel = this.l;
        if (voiceData$VoiceModel != null) {
            d.a.j0.r.g0.a.a(d.a.j0.r.g0.a.b(voiceData$VoiceModel.voiceId));
        }
        d.a.k0.d3.p0.a recorderManager = getRecorderManager();
        if (recorderManager == null || !recorderManager.f()) {
            return;
        }
        this.m = recorderManager.b(this, -1);
        this.f4192h.setVisibility(0);
    }

    public final void n() {
        this.f4190f.setVisibility(0);
        this.f4191g.g();
        this.f4191g.setVisibility(4);
        this.f4193i.setText(getResources().getText(R.string.voice_record_press_to_record));
        this.f4192h.setVisibility(4);
        d.a.k0.d3.p0.a recorderManager = getRecorderManager();
        if (this.m && recorderManager != null) {
            recorderManager.stopRecord();
        }
        this.m = false;
    }

    @Override // d.a.j0.w.b
    public void onAction(d.a.j0.w.a aVar) {
        if (aVar == null) {
            return;
        }
        int i2 = aVar.f50768a;
        if (i2 == 1) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 6));
        } else if (i2 == 9) {
            k();
        } else if (i2 != 52) {
        } else {
            Object obj = aVar.f50770c;
            if (obj instanceof VoiceData$VoiceModel) {
                this.l = (VoiceData$VoiceModel) obj;
                this.f4193i.setText(getResources().getText(R.string.voice_restart));
                return;
            }
            k();
        }
    }

    @Override // d.a.j0.w.n
    public void onChangeSkinType(int i2) {
        SkinManager.setViewTextColor(this.f4193i, R.color.CAM_X0106, 1, i2);
        SkinManager.setViewTextColor(this.f4192h, R.color.CAM_X0302, 1, i2);
        SkinManager.setBackgroundResource(this.f4190f, R.drawable.ic_post_record, i2);
        this.f4191g.f(i2);
    }

    @Override // d.a.c.e.q.f
    public void onDeletedVoice(String str) {
    }

    @Override // d.a.c.e.q.f
    public void onSendVoice(String str, int i2) {
        if (TextUtils.isEmpty(str) || i2 <= 0) {
            return;
        }
        VoiceData$VoiceModel voiceData$VoiceModel = new VoiceData$VoiceModel();
        this.l = voiceData$VoiceModel;
        voiceData$VoiceModel.duration = i2;
        voiceData$VoiceModel.isLocal = true;
        voiceData$VoiceModel.voiceId = str;
        voiceData$VoiceModel.voice_status = 1;
        this.f4193i.setText(getResources().getText(R.string.voice_restart));
        d(new d.a.j0.w.a(10, -1, this.l));
    }

    @Override // d.a.c.e.q.f
    public void onShowErr(int i2, String str) {
        this.f4192h.setVisibility(0);
        this.f4192h.setText(str);
        postDelayed(new d(), 2000L);
    }

    @Override // d.a.c.e.q.f
    public void onShowRecordTime(int i2) {
        this.f4192h.setText(VoiceManager.formatVoiceTime(i2));
    }

    @Override // d.a.c.e.q.f
    public void onShowRecording(int i2) {
    }

    @Override // d.a.c.e.q.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            this.f4190f.setVisibility(4);
            this.f4191g.setVisibility(0);
            this.f4191g.h();
            this.f4193i.setText(getResources().getText(R.string.voice_record_release_to_stop));
        }
    }

    @Override // d.a.c.e.q.f
    public void onStopingRecorder() {
    }

    @Override // d.a.j0.w.n
    public void setEditorTools(EditorTools editorTools) {
        this.j = editorTools;
    }

    @Override // d.a.j0.w.n
    public void setToolId(int i2) {
        this.k = i2;
    }
}
