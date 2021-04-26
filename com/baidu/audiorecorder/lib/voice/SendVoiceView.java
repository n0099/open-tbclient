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
import d.a.i0.w.a;
import d.a.i0.w.n;
import d.a.j0.e1.f.b;
import d.a.j0.p3.c;
/* loaded from: classes.dex */
public class SendVoiceView extends LinearLayout implements n, b, ISendVoiceView {

    /* renamed from: e  reason: collision with root package name */
    public TextView f4360e;

    /* renamed from: f  reason: collision with root package name */
    public int f4361f;

    /* renamed from: g  reason: collision with root package name */
    public EditorTools f4362g;

    /* renamed from: h  reason: collision with root package name */
    public FloatRecordView f4363h;

    /* renamed from: i  reason: collision with root package name */
    public WindowManager f4364i;
    public WindowManager.LayoutParams j;

    public SendVoiceView(Context context) {
        super(context);
        this.f4360e = null;
        this.f4361f = 0;
        if (context == null) {
            return;
        }
        LayoutInflater.from(context).inflate(R.layout.send_voice_view, this);
        this.f4360e = (TextView) findViewById(R.id.tex_send_voice);
        setFocusable(true);
        setFocusableInTouchMode(true);
        a();
    }

    public final void a() {
        this.f4363h = new FloatRecordView(getContext());
        this.f4364i = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
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

    @Override // d.a.i0.w.n
    public void b() {
        setVisibility(0);
    }

    public void c() {
        LinearLayout b2;
        FloatRecordView floatRecordView = this.f4363h;
        if (floatRecordView == null || this.f4364i == null || this.j == null || (b2 = floatRecordView.b()) == null || b2.getParent() != null) {
            return;
        }
        this.f4364i.addView(b2, this.j);
        this.f4363h.e();
    }

    @Override // d.a.j0.e1.f.b
    public void closeRecordCancel() {
        FloatRecordView floatRecordView = this.f4363h;
        if (floatRecordView == null || this.f4364i == null || this.j == null) {
            return;
        }
        floatRecordView.closeRecordCancel();
        LinearLayout a2 = this.f4363h.a();
        if (a2 == null || a2.getParent() == null) {
            return;
        }
        this.f4364i.removeView(a2);
    }

    @Override // d.a.j0.e1.f.b
    public void closeRecordTooShort() {
        FloatRecordView floatRecordView = this.f4363h;
        if (floatRecordView == null || this.f4364i == null || this.j == null) {
            return;
        }
        floatRecordView.closeRecordTooShort();
        LinearLayout b2 = this.f4363h.b();
        if (b2 == null || b2.getParent() == null) {
            return;
        }
        this.f4364i.removeView(b2);
    }

    @Override // d.a.i0.w.n
    public void d(a aVar) {
        EditorTools editorTools = this.f4362g;
        if (editorTools != null) {
            editorTools.A(aVar);
        }
    }

    @Override // d.a.i0.w.n
    public int getToolId() {
        return this.f4361f;
    }

    @Override // d.a.i0.w.n
    public void hide() {
        setVisibility(8);
    }

    @Override // d.a.i0.w.n
    public void init() {
    }

    @Override // d.a.i0.w.b
    public void onAction(a aVar) {
    }

    @Override // d.a.i0.w.n
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
        FloatRecordView floatRecordView = this.f4363h;
        if (floatRecordView == null || this.f4364i == null || this.j == null) {
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
            this.f4360e.setBackgroundResource(R.drawable.but_talk_s);
            this.f4360e.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_no_push));
            return;
        }
        this.f4360e.setBackgroundResource(R.drawable.but_talk_n);
        this.f4360e.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_push_talk));
    }

    @Override // d.a.i0.w.n
    public void setEditorTools(EditorTools editorTools) {
        this.f4362g = editorTools;
    }

    @Override // d.a.i0.w.n
    public void setToolId(int i2) {
        this.f4361f = i2;
    }

    @Override // d.a.j0.e1.f.b
    public void showRecordCancel() {
        LinearLayout a2;
        FloatRecordView floatRecordView = this.f4363h;
        if (floatRecordView == null || this.f4364i == null || this.j == null || (a2 = floatRecordView.a()) == null || a2.getParent() != null) {
            return;
        }
        this.f4364i.addView(a2, this.j);
        this.f4363h.showRecordCancel();
    }

    @Override // d.a.j0.e1.f.b
    public void startRecordVoice() {
        LinearLayout c2;
        FloatRecordView floatRecordView = this.f4363h;
        if (floatRecordView == null || this.f4364i == null || this.j == null || (c2 = floatRecordView.c()) == null || c2.getParent() != null) {
            return;
        }
        this.f4364i.addView(c2, this.j);
        this.f4363h.startRecordVoice();
    }

    @Override // d.a.j0.e1.f.b
    public void stopRecordVoice() {
        FloatRecordView floatRecordView = this.f4363h;
        if (floatRecordView == null || this.f4364i == null || this.j == null) {
            return;
        }
        floatRecordView.stopRecordVoice();
        LinearLayout c2 = this.f4363h.c();
        if (c2 == null || c2.getParent() == null) {
            return;
        }
        this.f4364i.removeView(c2);
    }
}
