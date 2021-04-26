package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.R;
import d.a.j0.e1.f.b;
/* loaded from: classes.dex */
public class FloatRecordView implements b {

    /* renamed from: e  reason: collision with root package name */
    public ImageView f4340e = null;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f4341f = null;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f4342g = null;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f4343h = null;

    /* renamed from: i  reason: collision with root package name */
    public int f4344i = 0;
    public long j = 0;
    public int k = 0;

    public FloatRecordView(Context context) {
        d(context, null);
    }

    public LinearLayout a() {
        return this.f4343h;
    }

    public LinearLayout b() {
        return this.f4342g;
    }

    public LinearLayout c() {
        return this.f4341f;
    }

    @Override // d.a.j0.e1.f.b
    public void closeRecordCancel() {
        this.f4343h.setVisibility(8);
    }

    @Override // d.a.j0.e1.f.b
    public void closeRecordTooShort() {
        this.f4342g.setVisibility(8);
    }

    public final void d(Context context, ViewGroup viewGroup) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.float_chat_recording_view, (ViewGroup) null);
        this.f4341f = linearLayout;
        this.f4340e = (ImageView) linearLayout.findViewById(R.id.img_msgsend_recording);
        this.f4342g = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_too_short_view, (ViewGroup) null);
        this.f4343h = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.floating_chat_cancel_view, (ViewGroup) null);
    }

    public void e() {
        this.f4342g.setVisibility(0);
    }

    @Override // d.a.c.e.q.f
    public void onDeletedVoice(String str) {
    }

    @Override // d.a.c.e.q.f
    public void onSendVoice(String str, int i2) {
    }

    @Override // d.a.c.e.q.f
    public void onShowErr(int i2, String str) {
    }

    @Override // d.a.c.e.q.f
    public void onShowRecordTime(int i2) {
    }

    @Override // d.a.c.e.q.f
    public void onShowRecording(int i2) {
        this.f4344i = Math.max(i2, this.f4344i);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.j > 150) {
            this.f4344i = 0;
            this.j = uptimeMillis;
        }
        int i3 = this.k + 1;
        this.k = i3;
        if (i3 % 5 == 0) {
            this.k = 0;
            int i4 = this.f4344i;
            if (i4 < 2) {
                this.f4340e.setImageResource(R.drawable.icon_chat_talk_sound_up_zero);
            } else if (i4 < 10) {
                this.f4340e.setImageResource(R.drawable.icon_chat_talk_sound_up_one);
            } else if (i4 < 20) {
                this.f4340e.setImageResource(R.drawable.icon_chat_talk_sound_up_two);
            } else if (i4 < 30) {
                this.f4340e.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            } else if (i4 < 40) {
                this.f4340e.setImageResource(R.drawable.icon_chat_talk_sound_up_four);
            } else if (i4 < 50) {
                this.f4340e.setImageResource(R.drawable.icon_chat_talk_sound_up_five);
            } else {
                this.f4340e.setImageResource(R.drawable.icon_chat_talk_sound_up_three);
            }
        }
    }

    @Override // d.a.c.e.q.f
    public void onStartedRecorder(boolean z) {
    }

    @Override // d.a.c.e.q.f
    public void onStopingRecorder() {
    }

    @Override // d.a.j0.e1.f.b
    public void showRecordCancel() {
        this.f4343h.setVisibility(0);
    }

    @Override // d.a.j0.e1.f.b
    public void startRecordVoice() {
        this.f4341f.setVisibility(0);
    }

    @Override // d.a.j0.e1.f.b
    public void stopRecordVoice() {
        this.f4341f.setVisibility(8);
    }
}
