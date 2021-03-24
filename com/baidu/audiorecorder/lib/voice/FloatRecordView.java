package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.R;
import d.b.i0.d1.f.b;
/* loaded from: classes2.dex */
public class FloatRecordView implements b {

    /* renamed from: e  reason: collision with root package name */
    public ImageView f4234e = null;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f4235f = null;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f4236g = null;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f4237h = null;
    public int i = 0;
    public long j = 0;
    public int k = 0;

    public FloatRecordView(Context context) {
        d(context, null);
    }

    public LinearLayout a() {
        return this.f4237h;
    }

    public LinearLayout b() {
        return this.f4236g;
    }

    public LinearLayout c() {
        return this.f4235f;
    }

    @Override // d.b.i0.d1.f.b
    public void closeRecordCancel() {
        this.f4237h.setVisibility(8);
    }

    @Override // d.b.i0.d1.f.b
    public void closeRecordTooShort() {
        this.f4236g.setVisibility(8);
    }

    public final void d(Context context, ViewGroup viewGroup) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.float_chat_recording_view, (ViewGroup) null);
        this.f4235f = linearLayout;
        this.f4234e = (ImageView) linearLayout.findViewById(R.id.img_msgsend_recording);
        this.f4236g = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_too_short_view, (ViewGroup) null);
        this.f4237h = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_cancel_view, (ViewGroup) null);
    }

    public void e() {
        this.f4236g.setVisibility(0);
    }

    @Override // d.b.b.e.q.f
    public void onDeletedVoice(String str) {
    }

    @Override // d.b.b.e.q.f
    public void onSendVoice(String str, int i) {
    }

    @Override // d.b.b.e.q.f
    public void onShowErr(int i, String str) {
    }

    @Override // d.b.b.e.q.f
    public void onShowRecordTime(int i) {
    }

    @Override // d.b.b.e.q.f
    public void onShowRecording(int i) {
        this.i = Math.max(i, this.i);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.j > 150) {
            this.i = 0;
            this.j = uptimeMillis;
        }
        int i2 = this.k + 1;
        this.k = i2;
        if (i2 % 5 == 0) {
            this.k = 0;
            int i3 = this.i;
            if (i3 < 2) {
                this.f4234e.setImageResource(R.drawable.icon_chat_talk_sound_up_zero);
            } else if (i3 < 10) {
                this.f4234e.setImageResource(R.drawable.icon_chat_talk_sound_up_one);
            } else if (i3 < 20) {
                this.f4234e.setImageResource(R.drawable.icon_chat_talk_sound_up_two);
            } else if (i3 < 30) {
                this.f4234e.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            } else if (i3 < 40) {
                this.f4234e.setImageResource(R.drawable.icon_chat_talk_sound_up_four);
            } else if (i3 < 50) {
                this.f4234e.setImageResource(R.drawable.icon_chat_talk_sound_up_five);
            } else {
                this.f4234e.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // d.b.b.e.q.f
    public void onStartedRecorder(boolean z) {
    }

    @Override // d.b.b.e.q.f
    public void onStopingRecorder() {
    }

    @Override // d.b.i0.d1.f.b
    public void showRecordCancel() {
        this.f4237h.setVisibility(0);
    }

    @Override // d.b.i0.d1.f.b
    public void startRecordVoice() {
        this.f4235f.setVisibility(0);
    }

    @Override // d.b.i0.d1.f.b
    public void stopRecordVoice() {
        this.f4235f.setVisibility(8);
    }
}
