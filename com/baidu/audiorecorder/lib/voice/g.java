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
    private int JG;
    private i JH;
    private final int[] JL;
    private int JM;
    private int JN;
    private final int JO;
    private final int JP;
    private final int JQ;
    private final int JR;
    private final int JS;
    private int JT;
    private int JU;
    private int JV;
    private int JW;
    private int JX;
    private int JY;
    private int JZ;
    private int Js;
    private long Jt;
    private f KA;
    private com.baidu.tbadk.core.dialog.a KB;
    private long KC;
    private long KD;
    private final int[] KE;
    private final a KF;
    private SweepGradient KG;
    private int KH;
    private int Ka;
    private Paint Kb;
    private Paint Kc;
    private Paint Kd;
    private Paint Ke;
    private int Kf;
    private int Kg;
    private int Kh;
    private int Ki;
    private int Kj;
    private int Kk;
    private int Kl;
    private int Km;
    private final BitmapDrawable Kn;
    private final Paint Ko;
    private final Rect Kp;
    private final RectF Kq;
    private TextView Kr;
    private TextView Ks;
    private TextView Kt;
    private TextView Ku;
    private VoiceButton Kv;
    private ImageView Kw;
    private TextView Kx;
    private float Ky;
    private float Kz;
    private int centerX;
    private int centerY;
    VoiceData.VoiceModel mModel;

    static /* synthetic */ int e(g gVar) {
        int i = gVar.JU;
        gVar.JU = i + 1;
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
                if (g.this.Kz >= 360.0f) {
                    g.this.Kz = 360.0f;
                    g.this.JU = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    g.this.KC = uptimeMillis;
                    g.this.KD = uptimeMillis + 200;
                    g.this.Kz += (((float) (uptimeMillis - g.this.KC)) / 1000.0f) * g.this.Ky;
                    sendEmptyMessageAtTime(1, g.this.KD);
                    g.e(g.this);
                }
                g.this.JT = g.this.JU % 6;
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
        this.Jt = 0L;
        this.JL = new int[4];
        this.JT = 0;
        this.JU = 0;
        this.centerX = 0;
        this.centerY = 0;
        this.JV = 0;
        this.JW = 0;
        this.JX = 0;
        this.JY = 0;
        this.JZ = 0;
        this.Ka = 0;
        this.Kf = -1724676609;
        this.Kg = 1546880511;
        this.Kh = 674465279;
        this.Ki = 255034879;
        this.Kj = -1725669966;
        this.Kk = 1545887154;
        this.Kl = 673471922;
        this.Km = 254041522;
        this.Ko = new Paint(1);
        this.Kp = new Rect();
        this.Kq = new RectF();
        this.JG = 0;
        this.KE = new int[2];
        this.KF = new a();
        this.Js = 0;
        this.KH = 0;
        this.JL[0] = context.getResources().getDimensionPixelSize(d.f.ds24);
        this.JL[1] = context.getResources().getDimensionPixelSize(d.f.ds8);
        this.JL[2] = context.getResources().getDimensionPixelSize(d.f.ds22);
        this.JL[3] = context.getResources().getDimensionPixelSize(d.f.ds36);
        this.JV = context.getResources().getDimensionPixelSize(d.f.ds134);
        this.JW = this.JV + context.getResources().getDimensionPixelSize(d.f.ds14);
        this.JX = this.JW + context.getResources().getDimensionPixelSize(d.f.ds16);
        this.JY = this.JX + context.getResources().getDimensionPixelSize(d.f.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.JZ = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.Ka = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.JZ = context.getResources().getDimensionPixelSize(d.f.ds70);
            this.Ka = context.getResources().getDimensionPixelSize(d.f.ds210);
        }
        this.JM = context.getResources().getDimensionPixelSize(d.f.ds26);
        this.JN = context.getResources().getDimensionPixelSize(d.f.ds10);
        this.JO = context.getResources().getDimensionPixelSize(d.f.ds14);
        this.JP = context.getResources().getDimensionPixelSize(d.f.ds4);
        this.JQ = context.getResources().getDimensionPixelSize(d.f.ds4);
        this.JR = context.getResources().getDimensionPixelSize(d.f.ds12);
        this.JS = context.getResources().getDimensionPixelSize(d.f.ds2);
        this.Ko.setStyle(Paint.Style.STROKE);
        this.Ko.setStrokeWidth(this.JR);
        this.Kn = (BitmapDrawable) getResources().getDrawable(d.g.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        aj(context);
        lU();
        this.KE[0] = aj.getColor(d.e.common_color_10151);
        this.KE[1] = aj.getColor(d.e.common_color_10152);
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
        this.JM = ((i4 - getContext().getResources().getDimensionPixelSize(d.f.ds460)) / 2) + getContext().getResources().getDimensionPixelSize(d.f.ds6);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int measuredWidth = this.Kv.getMeasuredWidth();
        int measuredHeight = this.Kv.getMeasuredHeight();
        int measuredWidth2 = this.Ks.getMeasuredWidth();
        this.Ks.layout((i5 - measuredWidth2) >> 1, this.JM + i2, (measuredWidth2 + i5) >> 1, this.Ks.getMeasuredHeight() + this.JM + i2);
        int bottom = this.Ks.getBottom();
        this.Kv.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.centerX = (measuredWidth / 2) + i6;
        this.centerY = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.Ku.getMeasuredWidth();
        int measuredHeight2 = this.Ku.getMeasuredHeight();
        int top = this.Kv.getTop();
        this.Ku.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.Kr.getMeasuredWidth();
        int measuredHeight3 = this.Kr.getMeasuredHeight();
        int right = this.Kv.getRight() - this.JN;
        int bottom2 = this.Kv.getBottom() - this.JO;
        this.Kr.layout(this.JZ + i6, this.Ka + bottom, measuredWidth4 + i6 + this.JZ, measuredHeight3 + this.Ka + bottom);
        int measuredWidth5 = this.Kw.getMeasuredWidth();
        this.Kw.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.Kw.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.Kx.getMeasuredWidth();
        this.Kx.layout((i5 - measuredWidth6) >> 1, (this.Kr.getTop() - this.Kx.getMeasuredHeight()) - this.JP, (measuredWidth6 + i5) >> 1, (this.Kr.getTop() + i2) - this.JP);
        this.Kv.getLeft();
        this.Kv.getRight();
        int measuredWidth7 = this.Kt.getMeasuredWidth();
        int measuredHeight4 = this.Kt.getMeasuredHeight();
        int bottom3 = this.Kv.getBottom();
        this.Kt.layout((i5 - measuredWidth7) >> 1, this.JL[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.JL[3]);
        this.Kp.set((i5 - this.Kn.getIntrinsicWidth()) >> 1, this.Kw.getTop() - this.JQ, (i5 + this.Kn.getIntrinsicHeight()) >> 1, (this.Kw.getTop() + this.Kn.getIntrinsicHeight()) - this.JQ);
        this.Kn.setBounds(this.Kp);
        this.Kq.set(this.Kw.getLeft() + (this.JR >> 1) + this.JS, this.Kw.getTop() + (this.JR >> 1) + this.JS, (this.Kw.getRight() - (this.JR >> 1)) - this.JS, (this.Kw.getBottom() - (this.JR >> 1)) - this.JS);
        if (this.KG == null) {
            this.KG = new SweepGradient(this.Kq.centerX(), this.Kq.centerY(), this.KE, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.KG.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.Kq.centerX(), this.Kq.centerY());
            this.KG.setLocalMatrix(matrix);
            this.Ko.setShader(this.KG);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        f(canvas);
        super.dispatchDraw(canvas);
    }

    private void lO() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.KB == null) {
            this.KB = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.i.Y(getContext()).getPageActivity());
            this.KB.cL(getContext().getString(d.l.voice_restart_tip)).a(getContext().getString(d.l.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.g.2
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
            this.KB.tb();
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
        this.Ks = (TextView) findViewById(d.h.tip_error);
        aj.c(this.Ks, d.e.cp_cont_i, 1);
        this.Kt = (TextView) findViewById(d.h.tip_operator);
        this.Ku = (TextView) findViewById(d.h.tip_time_out);
        this.Kv = (VoiceButton) findViewById(d.h.voice_bnt);
        this.Kr = (TextView) findViewById(d.h.restart);
        this.Kw = (ImageView) findViewById(d.h.play_img);
        this.Kx = (TextView) findViewById(d.h.play_time);
        this.Kx.setClickable(false);
        this.Kr.setOnClickListener(this);
        this.Kw.setOnClickListener(this);
        this.Kv.setRecorderView(this);
        lQ();
    }

    private void lP() {
        this.Kv.setVisibility(4);
        this.Kx.setVisibility(0);
        this.Kr.setVisibility(0);
        aj.c(this.Kx, d.e.cp_cont_f, 1);
        aj.c(this.Kr, d.e.cp_cont_f, 1);
        aj.j(this.Kr, d.g.but_posts_record_again_selector);
        this.Kw.setVisibility(0);
        if (this.mModel != null) {
            this.Kx.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.Kw.setContentDescription(String.format(getContext().getString(d.l.listen_time), Integer.valueOf(this.mModel.duration)));
            aj.c(this.Kw, d.g.but_posts_record_play_selector);
        }
        aj.c(this.Kt, d.e.cp_cont_c, 1);
        this.Kt.setText(getContext().getString(d.l.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lQ() {
        aj.c(this.Kv, d.g.but_posts_record_zero_selector);
        this.Kv.setVisibility(0);
        this.JT = 0;
        this.Kw.setVisibility(4);
        this.Kx.setVisibility(4);
        this.Kr.setVisibility(4);
        this.Ku.setVisibility(4);
        aj.c(this.Kt, d.e.cp_cont_c, 1);
        this.Kt.setText(getContext().getString(d.l.voice_record_press_to_record));
    }

    public void reset() {
        lQ();
        this.mModel = null;
        this.JT = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.Ks.setText("");
        this.Ks.setVisibility(4);
        this.JT = 0;
        lP();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            lQ();
            this.Kt.setText(getContext().getString(d.l.voice_record_release_to_stop));
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
        if (this.Kw != null && this.Kx != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    aj.c(this.Kx, d.e.cp_cont_f, 1);
                    this.Kx.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    aj.c(this.Kw, d.g.but_posts_record_play_selector);
                    this.Kw.setContentDescription(String.format(getContext().getString(d.l.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.Kt.setText(getContext().getString(d.l.voice_play_tip));
                    lS();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    aj.c(this.Kx, d.e.cp_cont_f, 1);
                    aj.c(this.Kw, d.g.but_posts_record_stop_selector);
                    this.Kw.setContentDescription(getContext().getString(d.l.pause_load));
                    this.Kt.setText(getContext().getString(d.l.voice_stop_tip));
                    lR();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        aj.c(this.Ku, d.e.cp_cont_i, 1);
        aj.c(this.Ks, d.e.cp_cont_i, 1);
        aj.c(this.Kt, d.e.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.Ku.setVisibility(0);
                this.Ku.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.g.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (g.this.Ku != null) {
                            g.this.Ku.setVisibility(4);
                            g.this.Ku.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 2) {
                this.Ks.setVisibility(0);
                this.Ks.setText(str);
                this.Kt.setText(d.l.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.g.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (g.this.Ks != null) {
                            g.this.Ks.setVisibility(4);
                            g.this.Ks.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 5) {
                this.Ks.setVisibility(0);
                this.Ks.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.g.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (g.this.Ks != null) {
                            g.this.Ks.setVisibility(4);
                            g.this.Ks.setText("");
                        }
                    }
                }, 2000L);
            } else {
                lQ();
                this.Ks.setVisibility(0);
                this.Ks.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.g.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (g.this.Ks != null) {
                            g.this.Ks.setVisibility(4);
                            g.this.Ks.setText("");
                        }
                    }
                }, 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.Ks.setVisibility(4);
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
        aj.c(this.Ks, d.e.cp_cont_i, 1);
        this.Ks.setVisibility(0);
        this.Ks.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.Js = Math.max(i, this.Js);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.Jt > 200) {
            this.Js = 0;
            this.Jt = uptimeMillis;
        }
        if (this.Js < 10) {
            this.JT = 1;
            invalidate();
        } else if (this.Js < 20) {
            this.JT = 2;
            invalidate();
        } else if (this.Js < 30) {
            this.JT = 3;
            invalidate();
        } else if (this.Js < 40) {
            this.JT = 4;
            invalidate();
        } else {
            this.JT = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aS(int i) {
        if (this.mModel != null && this.Kx != null) {
            int i2 = i / 1000;
            if (this.KH != i2) {
                this.Kx.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.KH = i2;
        }
    }

    private void lR() {
        if (this.mModel != null) {
            this.JT = 0;
            this.Ky = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.KC = SystemClock.uptimeMillis();
            this.KD = this.KC + 200;
            this.KF.sendEmptyMessageAtTime(1, this.KD);
            invalidate();
        }
    }

    private void lS() {
        this.JT = 0;
        this.JU = 0;
        this.Ky = 0.0f;
        this.Kz = 0.0f;
        this.KF.removeMessages(1);
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
        this.KA = fVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lT() {
    }

    public void lU() {
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
        this.Ke = new Paint();
        this.Ke.setAntiAlias(true);
        this.Ke.setStyle(Paint.Style.STROKE);
        this.Ke.setStrokeWidth(2.0f);
    }

    public void f(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.Kb.setColor(this.Kj);
            this.Kc.setColor(this.Kk);
            this.Kd.setColor(this.Kl);
            this.Ke.setColor(this.Km);
        } else {
            this.Kb.setColor(this.Kf);
            this.Kc.setColor(this.Kg);
            this.Kd.setColor(this.Kh);
            this.Ke.setColor(this.Ki);
        }
        if (this.JT == 2) {
            canvas.drawCircle(this.centerX, this.centerY, this.JV, this.Kb);
        } else if (this.JT == 3) {
            canvas.drawCircle(this.centerX, this.centerY, this.JV, this.Kb);
            canvas.drawCircle(this.centerX, this.centerY, this.JW, this.Kc);
        } else if (this.JT == 4) {
            canvas.drawCircle(this.centerX, this.centerY, this.JV, this.Kb);
            canvas.drawCircle(this.centerX, this.centerY, this.JW, this.Kc);
            canvas.drawCircle(this.centerX, this.centerY, this.JX, this.Kd);
        } else if (this.JT == 5) {
            canvas.drawCircle(this.centerX, this.centerY, this.JV, this.Kb);
            canvas.drawCircle(this.centerX, this.centerY, this.JW, this.Kc);
            canvas.drawCircle(this.centerX, this.centerY, this.JX, this.Kd);
            canvas.drawCircle(this.centerX, this.centerY, this.JY, this.Ke);
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
        return this.JG;
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
        if (this.JH != null) {
            this.JH.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.JH = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.JG = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
    }
}
