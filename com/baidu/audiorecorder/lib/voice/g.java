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
    private int JF;
    private i JG;
    private final int[] JK;
    private int JL;
    private int JM;
    private final int JN;
    private final int JO;
    private final int JP;
    private final int JQ;
    private final int JR;
    private int JS;
    private int JT;
    private int JU;
    private int JV;
    private int JW;
    private int JX;
    private int JY;
    private int JZ;
    private int Jr;
    private long Js;
    private com.baidu.tbadk.core.dialog.a KA;
    private long KB;
    private long KC;
    private final int[] KD;
    private final a KE;
    private SweepGradient KF;
    private int KG;
    private Paint Ka;
    private Paint Kb;
    private Paint Kc;
    private Paint Kd;
    private int Ke;
    private int Kf;
    private int Kg;
    private int Kh;
    private int Ki;
    private int Kj;
    private int Kk;
    private int Kl;
    private final BitmapDrawable Km;
    private final Paint Kn;
    private final Rect Ko;
    private final RectF Kp;
    private TextView Kq;
    private TextView Kr;
    private TextView Ks;
    private TextView Kt;
    private VoiceButton Ku;
    private ImageView Kv;
    private TextView Kw;
    private float Kx;
    private float Ky;
    private f Kz;
    private int centerX;
    private int centerY;
    VoiceData.VoiceModel mModel;

    static /* synthetic */ int e(g gVar) {
        int i = gVar.JT;
        gVar.JT = i + 1;
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
                if (g.this.Ky >= 360.0f) {
                    g.this.Ky = 360.0f;
                    g.this.JT = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    g.this.KB = uptimeMillis;
                    g.this.KC = uptimeMillis + 200;
                    g.this.Ky += (((float) (uptimeMillis - g.this.KB)) / 1000.0f) * g.this.Kx;
                    sendEmptyMessageAtTime(1, g.this.KC);
                    g.e(g.this);
                }
                g.this.JS = g.this.JT % 6;
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
        this.Js = 0L;
        this.JK = new int[4];
        this.JS = 0;
        this.JT = 0;
        this.centerX = 0;
        this.centerY = 0;
        this.JU = 0;
        this.JV = 0;
        this.JW = 0;
        this.JX = 0;
        this.JY = 0;
        this.JZ = 0;
        this.Ke = -1724676609;
        this.Kf = 1546880511;
        this.Kg = 674465279;
        this.Kh = 255034879;
        this.Ki = -1725669966;
        this.Kj = 1545887154;
        this.Kk = 673471922;
        this.Kl = 254041522;
        this.Kn = new Paint(1);
        this.Ko = new Rect();
        this.Kp = new RectF();
        this.JF = 0;
        this.KD = new int[2];
        this.KE = new a();
        this.Jr = 0;
        this.KG = 0;
        this.JK[0] = context.getResources().getDimensionPixelSize(d.f.ds24);
        this.JK[1] = context.getResources().getDimensionPixelSize(d.f.ds8);
        this.JK[2] = context.getResources().getDimensionPixelSize(d.f.ds22);
        this.JK[3] = context.getResources().getDimensionPixelSize(d.f.ds36);
        this.JU = context.getResources().getDimensionPixelSize(d.f.ds134);
        this.JV = this.JU + context.getResources().getDimensionPixelSize(d.f.ds14);
        this.JW = this.JV + context.getResources().getDimensionPixelSize(d.f.ds16);
        this.JX = this.JW + context.getResources().getDimensionPixelSize(d.f.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.JY = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.JZ = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.JY = context.getResources().getDimensionPixelSize(d.f.ds70);
            this.JZ = context.getResources().getDimensionPixelSize(d.f.ds210);
        }
        this.JL = context.getResources().getDimensionPixelSize(d.f.ds26);
        this.JM = context.getResources().getDimensionPixelSize(d.f.ds10);
        this.JN = context.getResources().getDimensionPixelSize(d.f.ds14);
        this.JO = context.getResources().getDimensionPixelSize(d.f.ds4);
        this.JP = context.getResources().getDimensionPixelSize(d.f.ds4);
        this.JQ = context.getResources().getDimensionPixelSize(d.f.ds12);
        this.JR = context.getResources().getDimensionPixelSize(d.f.ds2);
        this.Kn.setStyle(Paint.Style.STROKE);
        this.Kn.setStrokeWidth(this.JQ);
        this.Km = (BitmapDrawable) getResources().getDrawable(d.g.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        aj(context);
        lU();
        this.KD[0] = aj.getColor(d.e.common_color_10151);
        this.KD[1] = aj.getColor(d.e.common_color_10152);
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
        this.JL = ((i4 - getContext().getResources().getDimensionPixelSize(d.f.ds460)) / 2) + getContext().getResources().getDimensionPixelSize(d.f.ds6);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int measuredWidth = this.Ku.getMeasuredWidth();
        int measuredHeight = this.Ku.getMeasuredHeight();
        int measuredWidth2 = this.Kr.getMeasuredWidth();
        this.Kr.layout((i5 - measuredWidth2) >> 1, this.JL + i2, (measuredWidth2 + i5) >> 1, this.Kr.getMeasuredHeight() + this.JL + i2);
        int bottom = this.Kr.getBottom();
        this.Ku.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.centerX = (measuredWidth / 2) + i6;
        this.centerY = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.Kt.getMeasuredWidth();
        int measuredHeight2 = this.Kt.getMeasuredHeight();
        int top = this.Ku.getTop();
        this.Kt.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.Kq.getMeasuredWidth();
        int measuredHeight3 = this.Kq.getMeasuredHeight();
        int right = this.Ku.getRight() - this.JM;
        int bottom2 = this.Ku.getBottom() - this.JN;
        this.Kq.layout(this.JY + i6, this.JZ + bottom, measuredWidth4 + i6 + this.JY, measuredHeight3 + this.JZ + bottom);
        int measuredWidth5 = this.Kv.getMeasuredWidth();
        this.Kv.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.Kv.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.Kw.getMeasuredWidth();
        this.Kw.layout((i5 - measuredWidth6) >> 1, (this.Kq.getTop() - this.Kw.getMeasuredHeight()) - this.JO, (measuredWidth6 + i5) >> 1, (this.Kq.getTop() + i2) - this.JO);
        this.Ku.getLeft();
        this.Ku.getRight();
        int measuredWidth7 = this.Ks.getMeasuredWidth();
        int measuredHeight4 = this.Ks.getMeasuredHeight();
        int bottom3 = this.Ku.getBottom();
        this.Ks.layout((i5 - measuredWidth7) >> 1, this.JK[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.JK[3]);
        this.Ko.set((i5 - this.Km.getIntrinsicWidth()) >> 1, this.Kv.getTop() - this.JP, (i5 + this.Km.getIntrinsicHeight()) >> 1, (this.Kv.getTop() + this.Km.getIntrinsicHeight()) - this.JP);
        this.Km.setBounds(this.Ko);
        this.Kp.set(this.Kv.getLeft() + (this.JQ >> 1) + this.JR, this.Kv.getTop() + (this.JQ >> 1) + this.JR, (this.Kv.getRight() - (this.JQ >> 1)) - this.JR, (this.Kv.getBottom() - (this.JQ >> 1)) - this.JR);
        if (this.KF == null) {
            this.KF = new SweepGradient(this.Kp.centerX(), this.Kp.centerY(), this.KD, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.KF.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.Kp.centerX(), this.Kp.centerY());
            this.KF.setLocalMatrix(matrix);
            this.Kn.setShader(this.KF);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        f(canvas);
        super.dispatchDraw(canvas);
    }

    private void lO() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.KA == null) {
            this.KA = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.i.Y(getContext()).getPageActivity());
            this.KA.cM(getContext().getString(d.l.voice_restart_tip)).a(getContext().getString(d.l.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.g.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    g.this.lQ();
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
            this.KA.ti();
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
        this.Kr = (TextView) findViewById(d.h.tip_error);
        aj.c(this.Kr, d.e.cp_cont_i, 1);
        this.Ks = (TextView) findViewById(d.h.tip_operator);
        this.Kt = (TextView) findViewById(d.h.tip_time_out);
        this.Ku = (VoiceButton) findViewById(d.h.voice_bnt);
        this.Kq = (TextView) findViewById(d.h.restart);
        this.Kv = (ImageView) findViewById(d.h.play_img);
        this.Kw = (TextView) findViewById(d.h.play_time);
        this.Kw.setClickable(false);
        this.Kq.setOnClickListener(this);
        this.Kv.setOnClickListener(this);
        this.Ku.setRecorderView(this);
        lQ();
    }

    private void lP() {
        this.Ku.setVisibility(4);
        this.Kw.setVisibility(0);
        this.Kq.setVisibility(0);
        aj.c(this.Kw, d.e.cp_cont_f, 1);
        aj.c(this.Kq, d.e.cp_cont_f, 1);
        aj.j(this.Kq, d.g.but_posts_record_again_selector);
        this.Kv.setVisibility(0);
        if (this.mModel != null) {
            this.Kw.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.Kv.setContentDescription(String.format(getContext().getString(d.l.listen_time), Integer.valueOf(this.mModel.duration)));
            aj.c(this.Kv, d.g.but_posts_record_play_selector);
        }
        aj.c(this.Ks, d.e.cp_cont_c, 1);
        this.Ks.setText(getContext().getString(d.l.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lQ() {
        aj.c(this.Ku, d.g.but_posts_record_zero_selector);
        this.Ku.setVisibility(0);
        this.JS = 0;
        this.Kv.setVisibility(4);
        this.Kw.setVisibility(4);
        this.Kq.setVisibility(4);
        this.Kt.setVisibility(4);
        aj.c(this.Ks, d.e.cp_cont_c, 1);
        this.Ks.setText(getContext().getString(d.l.voice_record_press_to_record));
    }

    public void reset() {
        lQ();
        this.mModel = null;
        this.JS = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.Kr.setText("");
        this.Kr.setVisibility(4);
        this.JS = 0;
        lP();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            lQ();
            this.Ks.setText(getContext().getString(d.l.voice_record_release_to_stop));
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
        if (this.Kv != null && this.Kw != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    aj.c(this.Kw, d.e.cp_cont_f, 1);
                    this.Kw.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    aj.c(this.Kv, d.g.but_posts_record_play_selector);
                    this.Kv.setContentDescription(String.format(getContext().getString(d.l.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.Ks.setText(getContext().getString(d.l.voice_play_tip));
                    lS();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    aj.c(this.Kw, d.e.cp_cont_f, 1);
                    aj.c(this.Kv, d.g.but_posts_record_stop_selector);
                    this.Kv.setContentDescription(getContext().getString(d.l.pause_load));
                    this.Ks.setText(getContext().getString(d.l.voice_stop_tip));
                    lR();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        aj.c(this.Kt, d.e.cp_cont_i, 1);
        aj.c(this.Kr, d.e.cp_cont_i, 1);
        aj.c(this.Ks, d.e.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.Kt.setVisibility(0);
                this.Kt.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.g.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (g.this.Kt != null) {
                            g.this.Kt.setVisibility(4);
                            g.this.Kt.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 2) {
                this.Kr.setVisibility(0);
                this.Kr.setText(str);
                this.Ks.setText(d.l.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.g.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (g.this.Kr != null) {
                            g.this.Kr.setVisibility(4);
                            g.this.Kr.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 5) {
                this.Kr.setVisibility(0);
                this.Kr.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.g.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (g.this.Kr != null) {
                            g.this.Kr.setVisibility(4);
                            g.this.Kr.setText("");
                        }
                    }
                }, 2000L);
            } else {
                lQ();
                this.Kr.setVisibility(0);
                this.Kr.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.g.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (g.this.Kr != null) {
                            g.this.Kr.setVisibility(4);
                            g.this.Kr.setText("");
                        }
                    }
                }, 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.Kr.setVisibility(4);
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
        aj.c(this.Kr, d.e.cp_cont_i, 1);
        this.Kr.setVisibility(0);
        this.Kr.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.Jr = Math.max(i, this.Jr);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.Js > 200) {
            this.Jr = 0;
            this.Js = uptimeMillis;
        }
        if (this.Jr < 10) {
            this.JS = 1;
            invalidate();
        } else if (this.Jr < 20) {
            this.JS = 2;
            invalidate();
        } else if (this.Jr < 30) {
            this.JS = 3;
            invalidate();
        } else if (this.Jr < 40) {
            this.JS = 4;
            invalidate();
        } else {
            this.JS = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aS(int i) {
        if (this.mModel != null && this.Kw != null) {
            int i2 = i / 1000;
            if (this.KG != i2) {
                this.Kw.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.KG = i2;
        }
    }

    private void lR() {
        if (this.mModel != null) {
            this.JS = 0;
            this.Kx = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.KB = SystemClock.uptimeMillis();
            this.KC = this.KB + 200;
            this.KE.sendEmptyMessageAtTime(1, this.KC);
            invalidate();
        }
    }

    private void lS() {
        this.JS = 0;
        this.JT = 0;
        this.Kx = 0.0f;
        this.Ky = 0.0f;
        this.KE.removeMessages(1);
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
                lO();
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
        this.Kz = fVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lT() {
    }

    public void lU() {
        this.Ka = new Paint();
        this.Ka.setAntiAlias(true);
        this.Ka.setStyle(Paint.Style.STROKE);
        this.Ka.setStrokeWidth(2.0f);
        this.Kb = new Paint();
        this.Kb.setAntiAlias(true);
        this.Kb.setStyle(Paint.Style.STROKE);
        this.Kb.setStrokeWidth(2.0f);
        this.Kc = new Paint();
        this.Kc.setAntiAlias(true);
        this.Kc.setStyle(Paint.Style.STROKE);
        this.Kc.setStrokeWidth(2.0f);
        this.Kd = new Paint();
        this.Kd.setAntiAlias(true);
        this.Kd.setStyle(Paint.Style.STROKE);
        this.Kd.setStrokeWidth(2.0f);
    }

    public void f(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.Ka.setColor(this.Ki);
            this.Kb.setColor(this.Kj);
            this.Kc.setColor(this.Kk);
            this.Kd.setColor(this.Kl);
        } else {
            this.Ka.setColor(this.Ke);
            this.Kb.setColor(this.Kf);
            this.Kc.setColor(this.Kg);
            this.Kd.setColor(this.Kh);
        }
        if (this.JS == 2) {
            canvas.drawCircle(this.centerX, this.centerY, this.JU, this.Ka);
        } else if (this.JS == 3) {
            canvas.drawCircle(this.centerX, this.centerY, this.JU, this.Ka);
            canvas.drawCircle(this.centerX, this.centerY, this.JV, this.Kb);
        } else if (this.JS == 4) {
            canvas.drawCircle(this.centerX, this.centerY, this.JU, this.Ka);
            canvas.drawCircle(this.centerX, this.centerY, this.JV, this.Kb);
            canvas.drawCircle(this.centerX, this.centerY, this.JW, this.Kc);
        } else if (this.JS == 5) {
            canvas.drawCircle(this.centerX, this.centerY, this.JU, this.Ka);
            canvas.drawCircle(this.centerX, this.centerY, this.JV, this.Kb);
            canvas.drawCircle(this.centerX, this.centerY, this.JW, this.Kc);
            canvas.drawCircle(this.centerX, this.centerY, this.JX, this.Kd);
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
    public void lM() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.JF;
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
        if (this.JG != null) {
            this.JG.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.JG = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.JF = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
    }
}
