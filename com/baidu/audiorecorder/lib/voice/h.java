package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.s;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.VoiceButton;
/* loaded from: classes2.dex */
public class h extends ViewGroup implements View.OnClickListener, com.baidu.adp.lib.voice.f, VoiceManager.b, s {
    private int IL;
    private long IM;
    private i IT;
    private int IU;
    private com.baidu.tbadk.core.dialog.a IW;
    private int JA;
    private final int JB;
    private final int JC;
    private final int JD;
    private final int JE;
    private final int JF;
    private int JG;
    private int JH;
    private int JI;
    private int JJ;
    private int JK;
    private int JL;
    private int JM;
    private int JN;
    private Paint JO;
    private Paint JP;
    private Paint JQ;
    private Paint JR;
    private int JS;
    private int JT;
    private int JU;
    private int JV;
    private int JW;
    private int JX;
    private int JY;
    private int JZ;
    private final int[] Jy;
    private int Jz;
    private final BitmapDrawable Ka;
    private final Paint Kb;
    private final Rect Kc;
    private final RectF Kd;
    private TextView Ke;
    private TextView Kf;
    private TextView Kg;
    private TextView Kh;
    private VoiceButton Ki;
    private ImageView Kj;
    private TextView Kk;
    private float Kl;
    private float Km;
    private g Kn;
    private long Ko;
    private long Kp;
    private final int[] Kq;
    private final a Kr;
    private SweepGradient Ks;
    private int Kt;
    private int centerX;
    private int centerY;
    VoiceData.VoiceModel mModel;

    static /* synthetic */ int e(h hVar) {
        int i = hVar.JH;
        hVar.JH = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends Handler {
        private a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                if (h.this.Km >= 360.0f) {
                    h.this.Km = 360.0f;
                    h.this.JH = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    h.this.Ko = uptimeMillis;
                    h.this.Kp = uptimeMillis + 200;
                    h.this.Km += (((float) (uptimeMillis - h.this.Ko)) / 1000.0f) * h.this.Kl;
                    sendEmptyMessageAtTime(1, h.this.Kp);
                    h.e(h.this);
                }
                h.this.JG = h.this.JH % 6;
                h.this.invalidate();
            }
        }
    }

    public static h ah(Context context) {
        return new h(context);
    }

    public h(Context context) {
        this(context, null);
    }

    public h(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.IM = 0L;
        this.Jy = new int[4];
        this.JG = 0;
        this.JH = 0;
        this.centerX = 0;
        this.centerY = 0;
        this.JI = 0;
        this.JJ = 0;
        this.JK = 0;
        this.JL = 0;
        this.JM = 0;
        this.JN = 0;
        this.JS = -1724676609;
        this.JT = 1546880511;
        this.JU = 674465279;
        this.JV = 255034879;
        this.JW = -1725669966;
        this.JX = 1545887154;
        this.JY = 673471922;
        this.JZ = 254041522;
        this.Kb = new Paint(1);
        this.Kc = new Rect();
        this.Kd = new RectF();
        this.IU = 0;
        this.Kq = new int[2];
        this.Kr = new a();
        this.IL = 0;
        this.Kt = 0;
        this.Jy[0] = context.getResources().getDimensionPixelSize(d.e.ds24);
        this.Jy[1] = context.getResources().getDimensionPixelSize(d.e.ds8);
        this.Jy[2] = context.getResources().getDimensionPixelSize(d.e.ds22);
        this.Jy[3] = context.getResources().getDimensionPixelSize(d.e.ds36);
        this.JI = context.getResources().getDimensionPixelSize(d.e.ds134);
        this.JJ = this.JI + context.getResources().getDimensionPixelSize(d.e.ds14);
        this.JK = this.JJ + context.getResources().getDimensionPixelSize(d.e.ds16);
        this.JL = this.JK + context.getResources().getDimensionPixelSize(d.e.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.JM = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.JN = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.JM = context.getResources().getDimensionPixelSize(d.e.ds70);
            this.JN = context.getResources().getDimensionPixelSize(d.e.ds210);
        }
        this.Jz = context.getResources().getDimensionPixelSize(d.e.ds26);
        this.JA = context.getResources().getDimensionPixelSize(d.e.ds10);
        this.JB = context.getResources().getDimensionPixelSize(d.e.ds14);
        this.JC = context.getResources().getDimensionPixelSize(d.e.ds4);
        this.JD = context.getResources().getDimensionPixelSize(d.e.ds4);
        this.JE = context.getResources().getDimensionPixelSize(d.e.ds12);
        this.JF = context.getResources().getDimensionPixelSize(d.e.ds2);
        this.Kb.setStyle(Paint.Style.STROKE);
        this.Kb.setStrokeWidth(this.JE);
        this.Ka = (BitmapDrawable) getResources().getDrawable(d.f.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        ai(context);
        lR();
        this.Kq[0] = aj.getColor(d.C0082d.common_color_10151);
        this.Kq[1] = aj.getColor(d.C0082d.common_color_10152);
        VoiceManager voiceManager = getVoiceManager();
        if (voiceManager != null) {
            voiceManager.setAllowChangeVoiceMode(false);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = i & 1073741823;
        int i4 = i2 & 1073741823;
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                measureChild(childAt, i3 + ExploreByTouchHelper.INVALID_ID, i4 + ExploreByTouchHelper.INVALID_ID);
            }
        }
        setMeasuredDimension(i3, i4);
        this.Jz = ((i4 - getContext().getResources().getDimensionPixelSize(d.e.ds460)) / 2) + getContext().getResources().getDimensionPixelSize(d.e.ds6);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int measuredWidth = this.Ki.getMeasuredWidth();
        int measuredHeight = this.Ki.getMeasuredHeight();
        int measuredWidth2 = this.Kf.getMeasuredWidth();
        this.Kf.layout((i5 - measuredWidth2) >> 1, this.Jz + i2, (measuredWidth2 + i5) >> 1, this.Kf.getMeasuredHeight() + this.Jz + i2);
        int bottom = this.Kf.getBottom();
        this.Ki.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.centerX = (measuredWidth / 2) + i6;
        this.centerY = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.Kh.getMeasuredWidth();
        int measuredHeight2 = this.Kh.getMeasuredHeight();
        int top = this.Ki.getTop();
        this.Kh.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.Ke.getMeasuredWidth();
        int measuredHeight3 = this.Ke.getMeasuredHeight();
        int right = this.Ki.getRight() - this.JA;
        int bottom2 = this.Ki.getBottom() - this.JB;
        this.Ke.layout(this.JM + i6, this.JN + bottom, measuredWidth4 + i6 + this.JM, measuredHeight3 + this.JN + bottom);
        int measuredWidth5 = this.Kj.getMeasuredWidth();
        this.Kj.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.Kj.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.Kk.getMeasuredWidth();
        this.Kk.layout((i5 - measuredWidth6) >> 1, (this.Ke.getTop() - this.Kk.getMeasuredHeight()) - this.JC, (measuredWidth6 + i5) >> 1, (this.Ke.getTop() + i2) - this.JC);
        this.Ki.getLeft();
        this.Ki.getRight();
        int measuredWidth7 = this.Kg.getMeasuredWidth();
        int measuredHeight4 = this.Kg.getMeasuredHeight();
        int bottom3 = this.Ki.getBottom();
        this.Kg.layout((i5 - measuredWidth7) >> 1, this.Jy[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.Jy[3]);
        this.Kc.set((i5 - this.Ka.getIntrinsicWidth()) >> 1, this.Kj.getTop() - this.JD, (i5 + this.Ka.getIntrinsicHeight()) >> 1, (this.Kj.getTop() + this.Ka.getIntrinsicHeight()) - this.JD);
        this.Ka.setBounds(this.Kc);
        this.Kd.set(this.Kj.getLeft() + (this.JE >> 1) + this.JF, this.Kj.getTop() + (this.JE >> 1) + this.JF, (this.Kj.getRight() - (this.JE >> 1)) - this.JF, (this.Kj.getBottom() - (this.JE >> 1)) - this.JF);
        if (this.Ks == null) {
            this.Ks = new SweepGradient(this.Kd.centerX(), this.Kd.centerY(), this.Kq, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.Ks.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.Kd.centerX(), this.Kd.centerY());
            this.Ks.setLocalMatrix(matrix);
            this.Kb.setShader(this.Ks);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        e(canvas);
        super.dispatchDraw(canvas);
    }

    private void lD() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.IW == null) {
            this.IW = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.i.Y(getContext()).getPageActivity());
            this.IW.cS(getContext().getString(d.j.voice_restart_tip)).a(getContext().getString(d.j.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.h.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    h.this.lN();
                    if (h.this.getVoiceManager() != null && h.this.mModel != null) {
                        if (recorderManager != null) {
                            recorderManager.bJ(h.this.mModel.voiceId);
                        }
                        h.this.mModel = null;
                    }
                }
            }).b(getContext().getString(d.j.cancel), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.h.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(com.baidu.adp.base.i.Y(getContext()));
        }
        try {
            this.IW.tk();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.mModel != null) {
                if (recorderManager != null) {
                    recorderManager.bJ(this.mModel.voiceId);
                }
                this.mModel = null;
            }
        }
    }

    private void ai(Context context) {
        LayoutInflater.from(context).inflate(d.h.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.Kf = (TextView) findViewById(d.g.tip_error);
        aj.c(this.Kf, d.C0082d.cp_cont_i, 1);
        this.Kg = (TextView) findViewById(d.g.tip_operator);
        this.Kh = (TextView) findViewById(d.g.tip_time_out);
        this.Ki = (VoiceButton) findViewById(d.g.voice_bnt);
        this.Ke = (TextView) findViewById(d.g.restart);
        this.Kj = (ImageView) findViewById(d.g.play_img);
        this.Kk = (TextView) findViewById(d.g.play_time);
        this.Kk.setClickable(false);
        this.Ke.setOnClickListener(this);
        this.Kj.setOnClickListener(this);
        this.Ki.setRecorderView(this);
        lN();
    }

    private void lM() {
        this.Ki.setVisibility(4);
        this.Kk.setVisibility(0);
        this.Ke.setVisibility(0);
        aj.c(this.Kk, d.C0082d.cp_cont_f, 1);
        aj.c(this.Ke, d.C0082d.cp_cont_f, 1);
        aj.j(this.Ke, d.f.but_posts_record_again_selector);
        this.Kj.setVisibility(0);
        if (this.mModel != null) {
            this.Kk.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.Kj.setContentDescription(String.format(getContext().getString(d.j.listen_time), Integer.valueOf(this.mModel.duration)));
            aj.c(this.Kj, d.f.but_posts_record_play_selector);
        }
        aj.c(this.Kg, d.C0082d.cp_cont_c, 1);
        this.Kg.setText(getContext().getString(d.j.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lN() {
        aj.c(this.Ki, d.f.but_posts_record_zero_selector);
        this.Ki.setVisibility(0);
        this.JG = 0;
        this.Kj.setVisibility(4);
        this.Kk.setVisibility(4);
        this.Ke.setVisibility(4);
        this.Kh.setVisibility(4);
        aj.c(this.Kg, d.C0082d.cp_cont_c, 1);
        this.Kg.setText(getContext().getString(d.j.voice_record_press_to_record));
    }

    public void reset() {
        lN();
        this.mModel = null;
        this.JG = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.Kf.setText("");
        this.Kf.setVisibility(4);
        this.JG = 0;
        lM();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            lN();
            this.Kg.setText(getContext().getString(d.j.voice_record_release_to_stop));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStopingRecorder() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (this.Kj != null && this.Kk != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    aj.c(this.Kk, d.C0082d.cp_cont_f, 1);
                    this.Kk.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    aj.c(this.Kj, d.f.but_posts_record_play_selector);
                    this.Kj.setContentDescription(String.format(getContext().getString(d.j.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.Kg.setText(getContext().getString(d.j.voice_play_tip));
                    lP();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    aj.c(this.Kk, d.C0082d.cp_cont_f, 1);
                    aj.c(this.Kj, d.f.but_posts_record_stop_selector);
                    this.Kj.setContentDescription(getContext().getString(d.j.pause_load));
                    this.Kg.setText(getContext().getString(d.j.voice_stop_tip));
                    lO();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        aj.c(this.Kh, d.C0082d.cp_cont_i, 1);
        aj.c(this.Kf, d.C0082d.cp_cont_i, 1);
        aj.c(this.Kg, d.C0082d.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.Kh.setVisibility(0);
                this.Kh.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.h.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (h.this.Kh != null) {
                            h.this.Kh.setVisibility(4);
                            h.this.Kh.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 2) {
                this.Kf.setVisibility(0);
                this.Kf.setText(str);
                this.Kg.setText(d.j.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.h.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (h.this.Kf != null) {
                            h.this.Kf.setVisibility(4);
                            h.this.Kf.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 5) {
                this.Kf.setVisibility(0);
                this.Kf.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.h.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (h.this.Kf != null) {
                            h.this.Kf.setVisibility(4);
                            h.this.Kf.setText("");
                        }
                    }
                }, 2000L);
            } else {
                lN();
                this.Kf.setVisibility(0);
                this.Kf.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (h.this.Kf != null) {
                            h.this.Kf.setVisibility(4);
                            h.this.Kf.setText("");
                        }
                    }
                }, 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.Kf.setVisibility(4);
        VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
        voiceModel.duration = i;
        voiceModel.isLocal = true;
        voiceModel.voiceId = str;
        voiceModel.voice_status = 1;
        a(voiceModel);
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onDeletedVoice(String str) {
        this.mModel = null;
        b(new com.baidu.tbadk.editortools.a(11, -1, str));
        b(new com.baidu.tbadk.editortools.a(2, 6, null));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecordTime(int i) {
        aj.c(this.Kf, d.C0082d.cp_cont_i, 1);
        this.Kf.setVisibility(0);
        this.Kf.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.IL = Math.max(i, this.IL);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.IM > 200) {
            this.IL = 0;
            this.IM = uptimeMillis;
        }
        if (this.IL < 10) {
            this.JG = 1;
            invalidate();
        } else if (this.IL < 20) {
            this.JG = 2;
            invalidate();
        } else if (this.IL < 30) {
            this.JG = 3;
            invalidate();
        } else if (this.IL < 40) {
            this.JG = 4;
            invalidate();
        } else {
            this.JG = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aS(int i) {
        if (this.mModel != null && this.Kk != null) {
            int i2 = i / 1000;
            if (this.Kt != i2) {
                this.Kk.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.Kt = i2;
        }
    }

    private void lO() {
        if (this.mModel != null) {
            this.JG = 0;
            this.Kl = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.Ko = SystemClock.uptimeMillis();
            this.Kp = this.Ko + 200;
            this.Kr.sendEmptyMessageAtTime(1, this.Kp);
            invalidate();
        }
    }

    private void lP() {
        this.JG = 0;
        this.JH = 0;
        this.Kl = 0.0f;
        this.Km = 0.0f;
        this.Kr.removeMessages(1);
        ((ViewGroup) getParent()).invalidate();
    }

    public VoiceManager getVoiceManager() {
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        return null;
    }

    public com.baidu.tieba.tbadkCore.voice.a getRecorderManager() {
        VoiceManager voiceManager = getVoiceManager();
        if (voiceManager == null || voiceManager.getRecorderManager() == null) {
            return null;
        }
        return voiceManager.getRecorderManager();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (view != null && (voiceManager = getVoiceManager()) != null) {
            int id = view.getId();
            if (id == d.g.restart) {
                voiceManager.stopPlay();
                lD();
            } else if (id == d.g.play_img && this.mModel != null) {
                if (this.mModel.voice_status.intValue() == 3) {
                    voiceManager.stopPlay();
                } else if (this.mModel.voice_status.intValue() == 1) {
                    voiceManager.setAllowChangeVoiceMode(false);
                    voiceManager.startPlay(this);
                }
            }
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (getVisibility() == 0 && (i == 4 || i == 8)) {
            if (getVoiceManager() != null) {
                getVoiceManager().stopPlay();
            } else {
                return;
            }
        }
        super.setVisibility(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (getVoiceManager() != null) {
            getVoiceManager().stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.mModel;
    }

    public void setCallback(g gVar) {
        this.Kn = gVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lQ() {
    }

    public void lR() {
        this.JO = new Paint();
        this.JO.setAntiAlias(true);
        this.JO.setStyle(Paint.Style.STROKE);
        this.JO.setStrokeWidth(2.0f);
        this.JP = new Paint();
        this.JP.setAntiAlias(true);
        this.JP.setStyle(Paint.Style.STROKE);
        this.JP.setStrokeWidth(2.0f);
        this.JQ = new Paint();
        this.JQ.setAntiAlias(true);
        this.JQ.setStyle(Paint.Style.STROKE);
        this.JQ.setStrokeWidth(2.0f);
        this.JR = new Paint();
        this.JR.setAntiAlias(true);
        this.JR.setStyle(Paint.Style.STROKE);
        this.JR.setStrokeWidth(2.0f);
    }

    public void e(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.JO.setColor(this.JW);
            this.JP.setColor(this.JX);
            this.JQ.setColor(this.JY);
            this.JR.setColor(this.JZ);
        } else {
            this.JO.setColor(this.JS);
            this.JP.setColor(this.JT);
            this.JQ.setColor(this.JU);
            this.JR.setColor(this.JV);
        }
        if (this.JG == 2) {
            canvas.drawCircle(this.centerX, this.centerY, this.JI, this.JO);
        } else if (this.JG == 3) {
            canvas.drawCircle(this.centerX, this.centerY, this.JI, this.JO);
            canvas.drawCircle(this.centerX, this.centerY, this.JJ, this.JP);
        } else if (this.JG == 4) {
            canvas.drawCircle(this.centerX, this.centerY, this.JI, this.JO);
            canvas.drawCircle(this.centerX, this.centerY, this.JJ, this.JP);
            canvas.drawCircle(this.centerX, this.centerY, this.JK, this.JQ);
        } else if (this.JG == 5) {
            canvas.drawCircle(this.centerX, this.centerY, this.JI, this.JO);
            canvas.drawCircle(this.centerX, this.centerY, this.JJ, this.JP);
            canvas.drawCircle(this.centerX, this.centerY, this.JK, this.JQ);
            canvas.drawCircle(this.centerX, this.centerY, this.JL, this.JR);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            if (aVar.code == 9) {
                reset();
                b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
            if (aVar.code == 52) {
                if (aVar.data instanceof VoiceData.VoiceModel) {
                    lM();
                    b((VoiceData.VoiceModel) aVar.data);
                    this.mModel = (VoiceData.VoiceModel) aVar.data;
                    return;
                }
                reset();
                b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lE() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.IU;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.IT != null) {
            this.IT.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.IT = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.IU = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
    }
}
