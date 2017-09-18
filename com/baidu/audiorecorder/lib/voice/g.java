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
public class g extends ViewGroup implements View.OnClickListener, com.baidu.adp.lib.voice.f, VoiceManager.b, s {
    private final int JA;
    private int JB;
    private int JC;
    private int JD;
    private int JE;
    private int JF;
    private int JG;
    private int JH;
    private int JI;
    private Paint JJ;
    private Paint JK;
    private Paint JL;
    private Paint JM;
    private int JN;
    private int JO;
    private int JP;
    private int JQ;
    private int JR;
    private int JS;
    private int JT;
    private int JU;
    private final BitmapDrawable JV;
    private final Paint JW;
    private final Rect JX;
    private final RectF JY;
    private TextView JZ;
    private int Ja;
    private long Jb;
    private int Jo;
    private i Jp;
    private final int[] Jt;
    private int Ju;
    private int Jv;
    private final int Jw;
    private final int Jx;
    private final int Jy;
    private final int Jz;
    private TextView Ka;
    private TextView Kb;
    private TextView Kc;
    private VoiceButton Kd;
    private ImageView Ke;
    private TextView Kf;
    private float Kg;
    private float Kh;
    private f Ki;
    private com.baidu.tbadk.core.dialog.a Kj;
    private long Kk;
    private long Kl;
    private final int[] Km;
    private final a Kn;
    private SweepGradient Ko;
    private int Kp;
    private int centerX;
    private int centerY;
    VoiceData.VoiceModel mModel;

    static /* synthetic */ int e(g gVar) {
        int i = gVar.JC;
        gVar.JC = i + 1;
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
                if (g.this.Kh >= 360.0f) {
                    g.this.Kh = 360.0f;
                    g.this.JC = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    g.this.Kk = uptimeMillis;
                    g.this.Kl = uptimeMillis + 200;
                    g.this.Kh += (((float) (uptimeMillis - g.this.Kk)) / 1000.0f) * g.this.Kg;
                    sendEmptyMessageAtTime(1, g.this.Kl);
                    g.e(g.this);
                }
                g.this.JB = g.this.JC % 6;
                g.this.invalidate();
            }
        }
    }

    public static g ai(Context context) {
        return new g(context);
    }

    public g(Context context) {
        this(context, null);
    }

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Jb = 0L;
        this.Jt = new int[4];
        this.JB = 0;
        this.JC = 0;
        this.centerX = 0;
        this.centerY = 0;
        this.JD = 0;
        this.JE = 0;
        this.JF = 0;
        this.JG = 0;
        this.JH = 0;
        this.JI = 0;
        this.JN = -1724676609;
        this.JO = 1546880511;
        this.JP = 674465279;
        this.JQ = 255034879;
        this.JR = -1725669966;
        this.JS = 1545887154;
        this.JT = 673471922;
        this.JU = 254041522;
        this.JW = new Paint(1);
        this.JX = new Rect();
        this.JY = new RectF();
        this.Jo = 0;
        this.Km = new int[2];
        this.Kn = new a();
        this.Ja = 0;
        this.Kp = 0;
        this.Jt[0] = context.getResources().getDimensionPixelSize(d.f.ds24);
        this.Jt[1] = context.getResources().getDimensionPixelSize(d.f.ds8);
        this.Jt[2] = context.getResources().getDimensionPixelSize(d.f.ds22);
        this.Jt[3] = context.getResources().getDimensionPixelSize(d.f.ds36);
        this.JD = context.getResources().getDimensionPixelSize(d.f.ds134);
        this.JE = this.JD + context.getResources().getDimensionPixelSize(d.f.ds14);
        this.JF = this.JE + context.getResources().getDimensionPixelSize(d.f.ds16);
        this.JG = this.JF + context.getResources().getDimensionPixelSize(d.f.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.JH = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.JI = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.JH = context.getResources().getDimensionPixelSize(d.f.ds70);
            this.JI = context.getResources().getDimensionPixelSize(d.f.ds210);
        }
        this.Ju = context.getResources().getDimensionPixelSize(d.f.ds26);
        this.Jv = context.getResources().getDimensionPixelSize(d.f.ds10);
        this.Jw = context.getResources().getDimensionPixelSize(d.f.ds14);
        this.Jx = context.getResources().getDimensionPixelSize(d.f.ds4);
        this.Jy = context.getResources().getDimensionPixelSize(d.f.ds4);
        this.Jz = context.getResources().getDimensionPixelSize(d.f.ds12);
        this.JA = context.getResources().getDimensionPixelSize(d.f.ds2);
        this.JW.setStyle(Paint.Style.STROKE);
        this.JW.setStrokeWidth(this.Jz);
        this.JV = (BitmapDrawable) getResources().getDrawable(d.g.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        aj(context);
        lS();
        this.Km[0] = aj.getColor(d.e.common_color_10151);
        this.Km[1] = aj.getColor(d.e.common_color_10152);
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
        this.Ju = ((i4 - getContext().getResources().getDimensionPixelSize(d.f.ds460)) / 2) + getContext().getResources().getDimensionPixelSize(d.f.ds6);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int measuredWidth = this.Kd.getMeasuredWidth();
        int measuredHeight = this.Kd.getMeasuredHeight();
        int measuredWidth2 = this.Ka.getMeasuredWidth();
        this.Ka.layout((i5 - measuredWidth2) >> 1, this.Ju + i2, (measuredWidth2 + i5) >> 1, this.Ka.getMeasuredHeight() + this.Ju + i2);
        int bottom = this.Ka.getBottom();
        this.Kd.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.centerX = (measuredWidth / 2) + i6;
        this.centerY = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.Kc.getMeasuredWidth();
        int measuredHeight2 = this.Kc.getMeasuredHeight();
        int top = this.Kd.getTop();
        this.Kc.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.JZ.getMeasuredWidth();
        int measuredHeight3 = this.JZ.getMeasuredHeight();
        int right = this.Kd.getRight() - this.Jv;
        int bottom2 = this.Kd.getBottom() - this.Jw;
        this.JZ.layout(this.JH + i6, this.JI + bottom, measuredWidth4 + i6 + this.JH, measuredHeight3 + this.JI + bottom);
        int measuredWidth5 = this.Ke.getMeasuredWidth();
        this.Ke.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.Ke.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.Kf.getMeasuredWidth();
        this.Kf.layout((i5 - measuredWidth6) >> 1, (this.JZ.getTop() - this.Kf.getMeasuredHeight()) - this.Jx, (measuredWidth6 + i5) >> 1, (this.JZ.getTop() + i2) - this.Jx);
        this.Kd.getLeft();
        this.Kd.getRight();
        int measuredWidth7 = this.Kb.getMeasuredWidth();
        int measuredHeight4 = this.Kb.getMeasuredHeight();
        int bottom3 = this.Kd.getBottom();
        this.Kb.layout((i5 - measuredWidth7) >> 1, this.Jt[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.Jt[3]);
        this.JX.set((i5 - this.JV.getIntrinsicWidth()) >> 1, this.Ke.getTop() - this.Jy, (i5 + this.JV.getIntrinsicHeight()) >> 1, (this.Ke.getTop() + this.JV.getIntrinsicHeight()) - this.Jy);
        this.JV.setBounds(this.JX);
        this.JY.set(this.Ke.getLeft() + (this.Jz >> 1) + this.JA, this.Ke.getTop() + (this.Jz >> 1) + this.JA, (this.Ke.getRight() - (this.Jz >> 1)) - this.JA, (this.Ke.getBottom() - (this.Jz >> 1)) - this.JA);
        if (this.Ko == null) {
            this.Ko = new SweepGradient(this.JY.centerX(), this.JY.centerY(), this.Km, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.Ko.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.JY.centerX(), this.JY.centerY());
            this.Ko.setLocalMatrix(matrix);
            this.JW.setShader(this.Ko);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        f(canvas);
        super.dispatchDraw(canvas);
    }

    private void lM() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.Kj == null) {
            this.Kj = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.i.Y(getContext()).getPageActivity());
            this.Kj.cM(getContext().getString(d.l.voice_restart_tip)).a(getContext().getString(d.l.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.g.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    g.this.lO();
                    if (g.this.getVoiceManager() != null && g.this.mModel != null) {
                        if (recorderManager != null) {
                            recorderManager.bJ(g.this.mModel.voiceId);
                        }
                        g.this.mModel = null;
                    }
                }
            }).b(getContext().getString(d.l.cancel), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.g.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(com.baidu.adp.base.i.Y(getContext()));
        }
        try {
            this.Kj.to();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.mModel != null) {
                if (recorderManager != null) {
                    recorderManager.bJ(this.mModel.voiceId);
                }
                this.mModel = null;
            }
        }
    }

    private void aj(Context context) {
        LayoutInflater.from(context).inflate(d.j.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.Ka = (TextView) findViewById(d.h.tip_error);
        aj.c(this.Ka, d.e.cp_cont_i, 1);
        this.Kb = (TextView) findViewById(d.h.tip_operator);
        this.Kc = (TextView) findViewById(d.h.tip_time_out);
        this.Kd = (VoiceButton) findViewById(d.h.voice_bnt);
        this.JZ = (TextView) findViewById(d.h.restart);
        this.Ke = (ImageView) findViewById(d.h.play_img);
        this.Kf = (TextView) findViewById(d.h.play_time);
        this.Kf.setClickable(false);
        this.JZ.setOnClickListener(this);
        this.Ke.setOnClickListener(this);
        this.Kd.setRecorderView(this);
        lO();
    }

    private void lN() {
        this.Kd.setVisibility(4);
        this.Kf.setVisibility(0);
        this.JZ.setVisibility(0);
        aj.c(this.Kf, d.e.cp_cont_f, 1);
        aj.c(this.JZ, d.e.cp_cont_f, 1);
        aj.j(this.JZ, d.g.but_posts_record_again_selector);
        this.Ke.setVisibility(0);
        if (this.mModel != null) {
            this.Kf.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.Ke.setContentDescription(String.format(getContext().getString(d.l.listen_time), Integer.valueOf(this.mModel.duration)));
            aj.c(this.Ke, d.g.but_posts_record_play_selector);
        }
        aj.c(this.Kb, d.e.cp_cont_c, 1);
        this.Kb.setText(getContext().getString(d.l.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lO() {
        aj.c(this.Kd, d.g.but_posts_record_zero_selector);
        this.Kd.setVisibility(0);
        this.JB = 0;
        this.Ke.setVisibility(4);
        this.Kf.setVisibility(4);
        this.JZ.setVisibility(4);
        this.Kc.setVisibility(4);
        aj.c(this.Kb, d.e.cp_cont_c, 1);
        this.Kb.setText(getContext().getString(d.l.voice_record_press_to_record));
    }

    public void reset() {
        lO();
        this.mModel = null;
        this.JB = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.Ka.setText("");
        this.Ka.setVisibility(4);
        this.JB = 0;
        lN();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            lO();
            this.Kb.setText(getContext().getString(d.l.voice_record_release_to_stop));
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
        if (this.Ke != null && this.Kf != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    aj.c(this.Kf, d.e.cp_cont_f, 1);
                    this.Kf.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    aj.c(this.Ke, d.g.but_posts_record_play_selector);
                    this.Ke.setContentDescription(String.format(getContext().getString(d.l.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.Kb.setText(getContext().getString(d.l.voice_play_tip));
                    lQ();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    aj.c(this.Kf, d.e.cp_cont_f, 1);
                    aj.c(this.Ke, d.g.but_posts_record_stop_selector);
                    this.Ke.setContentDescription(getContext().getString(d.l.pause_load));
                    this.Kb.setText(getContext().getString(d.l.voice_stop_tip));
                    lP();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        aj.c(this.Kc, d.e.cp_cont_i, 1);
        aj.c(this.Ka, d.e.cp_cont_i, 1);
        aj.c(this.Kb, d.e.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.Kc.setVisibility(0);
                this.Kc.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.g.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (g.this.Kc != null) {
                            g.this.Kc.setVisibility(4);
                            g.this.Kc.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 2) {
                this.Ka.setVisibility(0);
                this.Ka.setText(str);
                this.Kb.setText(d.l.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.g.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (g.this.Ka != null) {
                            g.this.Ka.setVisibility(4);
                            g.this.Ka.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 5) {
                this.Ka.setVisibility(0);
                this.Ka.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.g.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (g.this.Ka != null) {
                            g.this.Ka.setVisibility(4);
                            g.this.Ka.setText("");
                        }
                    }
                }, 2000L);
            } else {
                lO();
                this.Ka.setVisibility(0);
                this.Ka.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.g.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (g.this.Ka != null) {
                            g.this.Ka.setVisibility(4);
                            g.this.Ka.setText("");
                        }
                    }
                }, 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.Ka.setVisibility(4);
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
        aj.c(this.Ka, d.e.cp_cont_i, 1);
        this.Ka.setVisibility(0);
        this.Ka.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.Ja = Math.max(i, this.Ja);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.Jb > 200) {
            this.Ja = 0;
            this.Jb = uptimeMillis;
        }
        if (this.Ja < 10) {
            this.JB = 1;
            invalidate();
        } else if (this.Ja < 20) {
            this.JB = 2;
            invalidate();
        } else if (this.Ja < 30) {
            this.JB = 3;
            invalidate();
        } else if (this.Ja < 40) {
            this.JB = 4;
            invalidate();
        } else {
            this.JB = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aO(int i) {
        if (this.mModel != null && this.Kf != null) {
            int i2 = i / 1000;
            if (this.Kp != i2) {
                this.Kf.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.Kp = i2;
        }
    }

    private void lP() {
        if (this.mModel != null) {
            this.JB = 0;
            this.Kg = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.Kk = SystemClock.uptimeMillis();
            this.Kl = this.Kk + 200;
            this.Kn.sendEmptyMessageAtTime(1, this.Kl);
            invalidate();
        }
    }

    private void lQ() {
        this.JB = 0;
        this.JC = 0;
        this.Kg = 0.0f;
        this.Kh = 0.0f;
        this.Kn.removeMessages(1);
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
            if (id == d.h.restart) {
                voiceManager.stopPlay();
                lM();
            } else if (id == d.h.play_img && this.mModel != null) {
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

    public void setCallback(f fVar) {
        this.Ki = fVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lR() {
    }

    public void lS() {
        this.JJ = new Paint();
        this.JJ.setAntiAlias(true);
        this.JJ.setStyle(Paint.Style.STROKE);
        this.JJ.setStrokeWidth(2.0f);
        this.JK = new Paint();
        this.JK.setAntiAlias(true);
        this.JK.setStyle(Paint.Style.STROKE);
        this.JK.setStrokeWidth(2.0f);
        this.JL = new Paint();
        this.JL.setAntiAlias(true);
        this.JL.setStyle(Paint.Style.STROKE);
        this.JL.setStrokeWidth(2.0f);
        this.JM = new Paint();
        this.JM.setAntiAlias(true);
        this.JM.setStyle(Paint.Style.STROKE);
        this.JM.setStrokeWidth(2.0f);
    }

    public void f(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.JJ.setColor(this.JR);
            this.JK.setColor(this.JS);
            this.JL.setColor(this.JT);
            this.JM.setColor(this.JU);
        } else {
            this.JJ.setColor(this.JN);
            this.JK.setColor(this.JO);
            this.JL.setColor(this.JP);
            this.JM.setColor(this.JQ);
        }
        if (this.JB == 2) {
            canvas.drawCircle(this.centerX, this.centerY, this.JD, this.JJ);
        } else if (this.JB == 3) {
            canvas.drawCircle(this.centerX, this.centerY, this.JD, this.JJ);
            canvas.drawCircle(this.centerX, this.centerY, this.JE, this.JK);
        } else if (this.JB == 4) {
            canvas.drawCircle(this.centerX, this.centerY, this.JD, this.JJ);
            canvas.drawCircle(this.centerX, this.centerY, this.JE, this.JK);
            canvas.drawCircle(this.centerX, this.centerY, this.JF, this.JL);
        } else if (this.JB == 5) {
            canvas.drawCircle(this.centerX, this.centerY, this.JD, this.JJ);
            canvas.drawCircle(this.centerX, this.centerY, this.JE, this.JK);
            canvas.drawCircle(this.centerX, this.centerY, this.JF, this.JL);
            canvas.drawCircle(this.centerX, this.centerY, this.JG, this.JM);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.code == 9) {
            reset();
            b(new com.baidu.tbadk.editortools.a(2, 6, null));
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lK() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.Jo;
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
        if (this.Jp != null) {
            this.Jp.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.Jp = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.Jo = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
    }
}
