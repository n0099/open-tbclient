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
import d.b.c.a.j;
import d.b.c.e.q.f;
import d.b.i0.r.s.a;
import d.b.i0.w.n;
/* loaded from: classes.dex */
public class NewVoiceRecordButton extends LinearLayout implements f, n {

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f4274e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f4275f;

    /* renamed from: g  reason: collision with root package name */
    public RecordingAnimView f4276g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f4277h;
    public TextView i;
    public EditorTools j;
    public int k;
    public VoiceData$VoiceModel l;
    public boolean m;
    public d.b.i0.r.s.a n;
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

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes.dex */
    public class c implements a.e {
        public c() {
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            aVar.dismiss();
            NewVoiceRecordButton.this.d(new d.b.i0.w.a(11, -1, null));
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (NewVoiceRecordButton.this.f4277h == null || NewVoiceRecordButton.this.m) {
                return;
            }
            NewVoiceRecordButton.this.f4277h.setVisibility(4);
            NewVoiceRecordButton.this.f4277h.setText("");
        }
    }

    public NewVoiceRecordButton(Context context) {
        super(context);
        this.k = 0;
        j();
    }

    @Override // d.b.i0.w.n
    public void b() {
        setVisibility(0);
    }

    @Override // d.b.i0.w.n
    public void d(d.b.i0.w.a aVar) {
        EditorTools editorTools = this.j;
        if (editorTools != null) {
            editorTools.A(aVar);
        }
    }

    public d.b.j0.d3.p0.a getRecorderManager() {
        VoiceManager voiceManager = getVoiceManager();
        if (voiceManager == null || voiceManager.getRecorderManager() == null) {
            return null;
        }
        return voiceManager.getRecorderManager();
    }

    @Override // d.b.i0.w.n
    public int getToolId() {
        return this.k;
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.j) {
            return ((VoiceManager.j) context).getVoiceManager();
        }
        if ((j.a(getContext()) instanceof d.b.c.a.f) && (tbPageContext = (TbPageContext) j.a(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.j)) {
            return ((VoiceManager.j) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return null;
    }

    @Override // d.b.i0.w.n
    public void hide() {
        setVisibility(8);
    }

    @Override // d.b.i0.w.n
    public void init() {
    }

    public final void j() {
        LinearLayout.inflate(getContext(), R.layout.layou_new_record_button, this);
        this.f4274e = (FrameLayout) findViewById(R.id.layout_record_button);
        this.f4275f = (ImageView) findViewById(R.id.iv_record_init);
        RecordingAnimView recordingAnimView = (RecordingAnimView) findViewById(R.id.record_anim_view);
        this.f4276g = recordingAnimView;
        recordingAnimView.setCertainColumnCount(8);
        this.f4276g.setColumnColor(R.color.CAM_X0111);
        this.f4276g.setColumnWidth(getResources().getDimensionPixelSize(R.dimen.ds4));
        this.f4277h = (TextView) findViewById(R.id.tv_duration);
        this.i = (TextView) findViewById(R.id.tv_tip);
        this.f4274e.setOnTouchListener(new a());
        d.b.j0.d3.p0.a recorderManager = getRecorderManager();
        if (recorderManager != null) {
            recorderManager.b(this);
        }
    }

    public final void k() {
        this.l = null;
        this.i.setText(getResources().getText(R.string.voice_record_press_to_record));
        this.f4277h.setText("");
        this.f4277h.setVisibility(4);
    }

    public final void l() {
        if (this.n == null) {
            d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(j.a(getContext()).getPageActivity());
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
            d.b.i0.r.g0.a.a(d.b.i0.r.g0.a.b(voiceData$VoiceModel.voiceId));
        }
        d.b.j0.d3.p0.a recorderManager = getRecorderManager();
        if (recorderManager == null || !recorderManager.d()) {
            return;
        }
        this.m = recorderManager.c(this, -1);
        this.f4277h.setVisibility(0);
    }

    public final void n() {
        this.f4275f.setVisibility(0);
        this.f4276g.g();
        this.f4276g.setVisibility(4);
        this.i.setText(getResources().getText(R.string.voice_record_press_to_record));
        this.f4277h.setVisibility(4);
        d.b.j0.d3.p0.a recorderManager = getRecorderManager();
        if (this.m && recorderManager != null) {
            recorderManager.stopRecord();
        }
        this.m = false;
    }

    @Override // d.b.i0.w.b
    public void onAction(d.b.i0.w.a aVar) {
        if (aVar == null) {
            return;
        }
        int i = aVar.f52278a;
        if (i == 1) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 6));
        } else if (i == 9) {
            k();
        } else if (i != 52) {
        } else {
            Object obj = aVar.f52280c;
            if (obj instanceof VoiceData$VoiceModel) {
                this.l = (VoiceData$VoiceModel) obj;
                this.i.setText(getResources().getText(R.string.voice_restart));
                return;
            }
            k();
        }
    }

    @Override // d.b.i0.w.n
    public void onChangeSkinType(int i) {
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0106, 1, i);
        SkinManager.setViewTextColor(this.f4277h, R.color.CAM_X0302, 1, i);
        SkinManager.setBackgroundResource(this.f4275f, R.drawable.ic_post_record, i);
        this.f4276g.f(i);
    }

    @Override // d.b.c.e.q.f
    public void onDeletedVoice(String str) {
    }

    @Override // d.b.c.e.q.f
    public void onSendVoice(String str, int i) {
        if (TextUtils.isEmpty(str) || i <= 0) {
            return;
        }
        VoiceData$VoiceModel voiceData$VoiceModel = new VoiceData$VoiceModel();
        this.l = voiceData$VoiceModel;
        voiceData$VoiceModel.duration = i;
        voiceData$VoiceModel.isLocal = true;
        voiceData$VoiceModel.voiceId = str;
        voiceData$VoiceModel.voice_status = 1;
        this.i.setText(getResources().getText(R.string.voice_restart));
        d(new d.b.i0.w.a(10, -1, this.l));
    }

    @Override // d.b.c.e.q.f
    public void onShowErr(int i, String str) {
        this.f4277h.setVisibility(0);
        this.f4277h.setText(str);
        postDelayed(new d(), 2000L);
    }

    @Override // d.b.c.e.q.f
    public void onShowRecordTime(int i) {
        this.f4277h.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // d.b.c.e.q.f
    public void onShowRecording(int i) {
    }

    @Override // d.b.c.e.q.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            this.f4275f.setVisibility(4);
            this.f4276g.setVisibility(0);
            this.f4276g.h();
            this.i.setText(getResources().getText(R.string.voice_record_release_to_stop));
        }
    }

    @Override // d.b.c.e.q.f
    public void onStopingRecorder() {
    }

    @Override // d.b.i0.w.n
    public void setEditorTools(EditorTools editorTools) {
        this.j = editorTools;
    }

    @Override // d.b.i0.w.n
    public void setToolId(int i) {
        this.k = i;
    }
}
