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
import d.b.h0.w.a;
import d.b.h0.w.n;
import d.b.i0.d1.f.b;
import d.b.i0.o3.c;
/* loaded from: classes2.dex */
public class SendVoiceView extends LinearLayout implements n, b, ISendVoiceView {

    /* renamed from: e  reason: collision with root package name */
    public TextView f4251e;

    /* renamed from: f  reason: collision with root package name */
    public int f4252f;

    /* renamed from: g  reason: collision with root package name */
    public EditorTools f4253g;

    /* renamed from: h  reason: collision with root package name */
    public FloatRecordView f4254h;
    public WindowManager i;
    public WindowManager.LayoutParams j;

    public SendVoiceView(Context context) {
        super(context);
        this.f4251e = null;
        this.f4252f = 0;
        if (context == null) {
            return;
        }
        LayoutInflater.from(context).inflate(R.layout.send_voice_view, this);
        this.f4251e = (TextView) findViewById(R.id.tex_send_voice);
        setFocusable(true);
        setFocusableInTouchMode(true);
        a();
    }

    public final void a() {
        this.f4254h = new FloatRecordView(getContext());
        this.i = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
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

    @Override // d.b.h0.w.n
    public void b() {
        setVisibility(0);
    }

    public void c() {
        LinearLayout b2;
        FloatRecordView floatRecordView = this.f4254h;
        if (floatRecordView == null || this.i == null || this.j == null || (b2 = floatRecordView.b()) == null || b2.getParent() != null) {
            return;
        }
        this.i.addView(b2, this.j);
        this.f4254h.e();
    }

    @Override // d.b.i0.d1.f.b
    public void closeRecordCancel() {
        FloatRecordView floatRecordView = this.f4254h;
        if (floatRecordView == null || this.i == null || this.j == null) {
            return;
        }
        floatRecordView.closeRecordCancel();
        LinearLayout a2 = this.f4254h.a();
        if (a2 == null || a2.getParent() == null) {
            return;
        }
        this.i.removeView(a2);
    }

    @Override // d.b.i0.d1.f.b
    public void closeRecordTooShort() {
        FloatRecordView floatRecordView = this.f4254h;
        if (floatRecordView == null || this.i == null || this.j == null) {
            return;
        }
        floatRecordView.closeRecordTooShort();
        LinearLayout b2 = this.f4254h.b();
        if (b2 == null || b2.getParent() == null) {
            return;
        }
        this.i.removeView(b2);
    }

    @Override // d.b.h0.w.n
    public void d(a aVar) {
        EditorTools editorTools = this.f4253g;
        if (editorTools != null) {
            editorTools.A(aVar);
        }
    }

    @Override // d.b.h0.w.n
    public int getToolId() {
        return this.f4252f;
    }

    @Override // d.b.h0.w.n
    public void hide() {
        setVisibility(8);
    }

    @Override // d.b.h0.w.n
    public void init() {
    }

    @Override // d.b.h0.w.b
    public void onAction(a aVar) {
    }

    @Override // d.b.h0.w.n
    public void onChangeSkinType(int i) {
    }

    @Override // d.b.b.e.q.f
    public void onDeletedVoice(String str) {
    }

    @Override // d.b.b.e.q.f
    public void onSendVoice(String str, int i) {
    }

    @Override // d.b.b.e.q.f
    public void onShowErr(int i, String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        if (i == 3) {
            stopRecordVoice();
        } else if (i == 2) {
            closeRecordCancel();
            closeRecordTooShort();
            c();
        }
    }

    @Override // d.b.b.e.q.f
    public void onShowRecordTime(int i) {
    }

    @Override // d.b.b.e.q.f
    public void onShowRecording(int i) {
        FloatRecordView floatRecordView = this.f4254h;
        if (floatRecordView == null || this.i == null || this.j == null) {
            return;
        }
        floatRecordView.onShowRecording(i);
    }

    @Override // d.b.b.e.q.f
    public void onStartedRecorder(boolean z) {
    }

    @Override // d.b.b.e.q.f
    public void onStopingRecorder() {
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        if (z) {
            this.f4251e.setBackgroundResource(R.drawable.but_talk_s);
            this.f4251e.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_no_push));
            return;
        }
        this.f4251e.setBackgroundResource(R.drawable.but_talk_n);
        this.f4251e.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_push_talk));
    }

    @Override // d.b.h0.w.n
    public void setEditorTools(EditorTools editorTools) {
        this.f4253g = editorTools;
    }

    @Override // d.b.h0.w.n
    public void setToolId(int i) {
        this.f4252f = i;
    }

    @Override // d.b.i0.d1.f.b
    public void showRecordCancel() {
        LinearLayout a2;
        FloatRecordView floatRecordView = this.f4254h;
        if (floatRecordView == null || this.i == null || this.j == null || (a2 = floatRecordView.a()) == null || a2.getParent() != null) {
            return;
        }
        this.i.addView(a2, this.j);
        this.f4254h.showRecordCancel();
    }

    @Override // d.b.i0.d1.f.b
    public void startRecordVoice() {
        LinearLayout c2;
        FloatRecordView floatRecordView = this.f4254h;
        if (floatRecordView == null || this.i == null || this.j == null || (c2 = floatRecordView.c()) == null || c2.getParent() != null) {
            return;
        }
        this.i.addView(c2, this.j);
        this.f4254h.startRecordVoice();
    }

    @Override // d.b.i0.d1.f.b
    public void stopRecordVoice() {
        FloatRecordView floatRecordView = this.f4254h;
        if (floatRecordView == null || this.i == null || this.j == null) {
            return;
        }
        floatRecordView.stopRecordVoice();
        LinearLayout c2 = this.f4254h.c();
        if (c2 == null || c2.getParent() == null) {
            return;
        }
        this.i.removeView(c2);
    }
}
