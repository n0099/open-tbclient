package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.ISendVoiceView;
import d.a.n0.w.a;
import d.a.n0.w.n;
import d.a.o0.f1.f.b;
import d.a.o0.q3.c;
/* loaded from: classes.dex */
public class SendVoiceView extends LinearLayout implements n, b, ISendVoiceView {

    /* renamed from: e  reason: collision with root package name */
    public TextView f4226e;

    /* renamed from: f  reason: collision with root package name */
    public int f4227f;

    /* renamed from: g  reason: collision with root package name */
    public EditorTools f4228g;

    /* renamed from: h  reason: collision with root package name */
    public FloatRecordView f4229h;

    /* renamed from: i  reason: collision with root package name */
    public WindowManager f4230i;
    public WindowManager.LayoutParams j;

    public SendVoiceView(Context context) {
        super(context);
        this.f4226e = null;
        this.f4227f = 0;
        if (context == null) {
            return;
        }
        LayoutInflater.from(context).inflate(R.layout.send_voice_view, this);
        this.f4226e = (TextView) findViewById(R.id.tex_send_voice);
        setFocusable(true);
        setFocusableInTouchMode(true);
        a();
    }

    public final void a() {
        this.f4229h = new FloatRecordView(getContext());
        this.f4230i = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.j = layoutParams;
        layoutParams.type = c.a(2002);
        WindowManager.LayoutParams layoutParams2 = this.j;
        layoutParams2.format = 1;
        layoutParams2.flags = 56;
        layoutParams2.gravity = 17;
        layoutParams2.x = 0;
        layoutParams2.y = 0;
        layoutParams2.width = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
        this.j.height = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
    }

    @Override // d.a.n0.w.n
    public void b() {
        setVisibility(0);
    }

    public void c() {
        LinearLayout b2;
        FloatRecordView floatRecordView = this.f4229h;
        if (floatRecordView == null || this.f4230i == null || this.j == null || (b2 = floatRecordView.b()) == null || b2.getParent() != null) {
            return;
        }
        this.f4230i.addView(b2, this.j);
        this.f4229h.e();
    }

    @Override // d.a.o0.f1.f.b
    public void closeRecordCancel() {
        FloatRecordView floatRecordView = this.f4229h;
        if (floatRecordView == null || this.f4230i == null || this.j == null) {
            return;
        }
        floatRecordView.closeRecordCancel();
        LinearLayout a2 = this.f4229h.a();
        if (a2 == null || a2.getParent() == null) {
            return;
        }
        this.f4230i.removeView(a2);
    }

    @Override // d.a.o0.f1.f.b
    public void closeRecordTooShort() {
        FloatRecordView floatRecordView = this.f4229h;
        if (floatRecordView == null || this.f4230i == null || this.j == null) {
            return;
        }
        floatRecordView.closeRecordTooShort();
        LinearLayout b2 = this.f4229h.b();
        if (b2 == null || b2.getParent() == null) {
            return;
        }
        this.f4230i.removeView(b2);
    }

    @Override // d.a.n0.w.n
    public void d(a aVar) {
        EditorTools editorTools = this.f4228g;
        if (editorTools != null) {
            editorTools.A(aVar);
        }
    }

    @Override // d.a.n0.w.n
    public int getToolId() {
        return this.f4227f;
    }

    @Override // d.a.n0.w.n
    public void hide() {
        setVisibility(8);
    }

    @Override // d.a.n0.w.n
    public void init() {
    }

    @Override // d.a.n0.w.b
    public void onAction(a aVar) {
    }

    @Override // d.a.n0.w.n
    public void onChangeSkinType(int i2) {
    }

    @Override // d.a.c.e.q.f
    public void onDeletedVoice(String str) {
    }

    @Override // d.a.c.e.q.f
    public void onSendVoice(String str, int i2) {
    }

    @Override // d.a.c.e.q.f
    public void onShowErr(int i2, String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        if (i2 == 3) {
            stopRecordVoice();
        } else if (i2 == 2) {
            closeRecordCancel();
            closeRecordTooShort();
            c();
        }
    }

    @Override // d.a.c.e.q.f
    public void onShowRecordTime(int i2) {
    }

    @Override // d.a.c.e.q.f
    public void onShowRecording(int i2) {
        FloatRecordView floatRecordView = this.f4229h;
        if (floatRecordView == null || this.f4230i == null || this.j == null) {
            return;
        }
        floatRecordView.onShowRecording(i2);
    }

    @Override // d.a.c.e.q.f
    public void onStartedRecorder(boolean z) {
    }

    @Override // d.a.c.e.q.f
    public void onStopingRecorder() {
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.f4226e.setBackgroundResource(R.drawable.but_talk_s);
            this.f4226e.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_no_push));
            return;
        }
        this.f4226e.setBackgroundResource(R.drawable.but_talk_n);
        this.f4226e.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_push_talk));
    }

    @Override // d.a.n0.w.n
    public void setEditorTools(EditorTools editorTools) {
        this.f4228g = editorTools;
    }

    @Override // d.a.n0.w.n
    public void setToolId(int i2) {
        this.f4227f = i2;
    }

    @Override // d.a.o0.f1.f.b
    public void showRecordCancel() {
        LinearLayout a2;
        FloatRecordView floatRecordView = this.f4229h;
        if (floatRecordView == null || this.f4230i == null || this.j == null || (a2 = floatRecordView.a()) == null || a2.getParent() != null) {
            return;
        }
        this.f4230i.addView(a2, this.j);
        this.f4229h.showRecordCancel();
    }

    @Override // d.a.o0.f1.f.b
    public void startRecordVoice() {
        LinearLayout c2;
        FloatRecordView floatRecordView = this.f4229h;
        if (floatRecordView == null || this.f4230i == null || this.j == null || (c2 = floatRecordView.c()) == null || c2.getParent() != null) {
            return;
        }
        this.f4230i.addView(c2, this.j);
        this.f4229h.startRecordVoice();
    }

    @Override // d.a.o0.f1.f.b
    public void stopRecordVoice() {
        FloatRecordView floatRecordView = this.f4229h;
        if (floatRecordView == null || this.f4230i == null || this.j == null) {
            return;
        }
        floatRecordView.stopRecordVoice();
        LinearLayout c2 = this.f4229h.c();
        if (c2 == null || c2.getParent() == null) {
            return;
        }
        this.f4230i.removeView(c2);
    }
}
