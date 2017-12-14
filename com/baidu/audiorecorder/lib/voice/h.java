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
    private int IJ;
    private long IK;
    private i IR;
    private int IS;
    private com.baidu.tbadk.core.dialog.a IU;
    private final int JA;
    private final int JB;
    private final int JC;
    private final int JD;
    private final int JE;
    private int JF;
    private int JG;
    private int JH;
    private int JI;
    private int JJ;
    private int JK;
    private int JL;
    private int JM;
    private Paint JN;
    private Paint JO;
    private Paint JP;
    private Paint JQ;
    private int JR;
    private int JS;
    private int JT;
    private int JU;
    private int JV;
    private int JW;
    private int JX;
    private int JY;
    private final BitmapDrawable JZ;
    private final int[] Jx;
    private int Jy;
    private int Jz;
    private final Paint Ka;
    private final Rect Kb;
    private final RectF Kc;
    private TextView Kd;
    private TextView Ke;
    private TextView Kf;
    private TextView Kg;
    private VoiceButton Kh;
    private ImageView Ki;
    private TextView Kj;
    private float Kk;
    private float Kl;
    private g Km;
    private long Kn;
    private long Ko;
    private final int[] Kp;
    private final a Kq;
    private SweepGradient Kr;
    private int Ks;
    private int centerX;
    private int centerY;
    VoiceData.VoiceModel mModel;

    static /* synthetic */ int e(h hVar) {
        int i = hVar.JG;
        hVar.JG = i + 1;
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
                if (h.this.Kl >= 360.0f) {
                    h.this.Kl = 360.0f;
                    h.this.JG = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    h.this.Kn = uptimeMillis;
                    h.this.Ko = uptimeMillis + 200;
                    h.this.Kl += (((float) (uptimeMillis - h.this.Kn)) / 1000.0f) * h.this.Kk;
                    sendEmptyMessageAtTime(1, h.this.Ko);
                    h.e(h.this);
                }
                h.this.JF = h.this.JG % 6;
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
        this.IK = 0L;
        this.Jx = new int[4];
        this.JF = 0;
        this.JG = 0;
        this.centerX = 0;
        this.centerY = 0;
        this.JH = 0;
        this.JI = 0;
        this.JJ = 0;
        this.JK = 0;
        this.JL = 0;
        this.JM = 0;
        this.JR = -1724676609;
        this.JS = 1546880511;
        this.JT = 674465279;
        this.JU = 255034879;
        this.JV = -1725669966;
        this.JW = 1545887154;
        this.JX = 673471922;
        this.JY = 254041522;
        this.Ka = new Paint(1);
        this.Kb = new Rect();
        this.Kc = new RectF();
        this.IS = 0;
        this.Kp = new int[2];
        this.Kq = new a();
        this.IJ = 0;
        this.Ks = 0;
        this.Jx[0] = context.getResources().getDimensionPixelSize(d.e.ds24);
        this.Jx[1] = context.getResources().getDimensionPixelSize(d.e.ds8);
        this.Jx[2] = context.getResources().getDimensionPixelSize(d.e.ds22);
        this.Jx[3] = context.getResources().getDimensionPixelSize(d.e.ds36);
        this.JH = context.getResources().getDimensionPixelSize(d.e.ds134);
        this.JI = this.JH + context.getResources().getDimensionPixelSize(d.e.ds14);
        this.JJ = this.JI + context.getResources().getDimensionPixelSize(d.e.ds16);
        this.JK = this.JJ + context.getResources().getDimensionPixelSize(d.e.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.JL = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.JM = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.JL = context.getResources().getDimensionPixelSize(d.e.ds70);
            this.JM = context.getResources().getDimensionPixelSize(d.e.ds210);
        }
        this.Jy = context.getResources().getDimensionPixelSize(d.e.ds26);
        this.Jz = context.getResources().getDimensionPixelSize(d.e.ds10);
        this.JA = context.getResources().getDimensionPixelSize(d.e.ds14);
        this.JB = context.getResources().getDimensionPixelSize(d.e.ds4);
        this.JC = context.getResources().getDimensionPixelSize(d.e.ds4);
        this.JD = context.getResources().getDimensionPixelSize(d.e.ds12);
        this.JE = context.getResources().getDimensionPixelSize(d.e.ds2);
        this.Ka.setStyle(Paint.Style.STROKE);
        this.Ka.setStrokeWidth(this.JD);
        this.JZ = (BitmapDrawable) getResources().getDrawable(d.f.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        ai(context);
        lR();
        this.Kp[0] = aj.getColor(d.C0096d.common_color_10151);
        this.Kp[1] = aj.getColor(d.C0096d.common_color_10152);
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
        this.Jy = ((i4 - getContext().getResources().getDimensionPixelSize(d.e.ds460)) / 2) + getContext().getResources().getDimensionPixelSize(d.e.ds6);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int measuredWidth = this.Kh.getMeasuredWidth();
        int measuredHeight = this.Kh.getMeasuredHeight();
        int measuredWidth2 = this.Ke.getMeasuredWidth();
        this.Ke.layout((i5 - measuredWidth2) >> 1, this.Jy + i2, (measuredWidth2 + i5) >> 1, this.Ke.getMeasuredHeight() + this.Jy + i2);
        int bottom = this.Ke.getBottom();
        this.Kh.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.centerX = (measuredWidth / 2) + i6;
        this.centerY = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.Kg.getMeasuredWidth();
        int measuredHeight2 = this.Kg.getMeasuredHeight();
        int top = this.Kh.getTop();
        this.Kg.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.Kd.getMeasuredWidth();
        int measuredHeight3 = this.Kd.getMeasuredHeight();
        int right = this.Kh.getRight() - this.Jz;
        int bottom2 = this.Kh.getBottom() - this.JA;
        this.Kd.layout(this.JL + i6, this.JM + bottom, measuredWidth4 + i6 + this.JL, measuredHeight3 + this.JM + bottom);
        int measuredWidth5 = this.Ki.getMeasuredWidth();
        this.Ki.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.Ki.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.Kj.getMeasuredWidth();
        this.Kj.layout((i5 - measuredWidth6) >> 1, (this.Kd.getTop() - this.Kj.getMeasuredHeight()) - this.JB, (measuredWidth6 + i5) >> 1, (this.Kd.getTop() + i2) - this.JB);
        this.Kh.getLeft();
        this.Kh.getRight();
        int measuredWidth7 = this.Kf.getMeasuredWidth();
        int measuredHeight4 = this.Kf.getMeasuredHeight();
        int bottom3 = this.Kh.getBottom();
        this.Kf.layout((i5 - measuredWidth7) >> 1, this.Jx[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.Jx[3]);
        this.Kb.set((i5 - this.JZ.getIntrinsicWidth()) >> 1, this.Ki.getTop() - this.JC, (i5 + this.JZ.getIntrinsicHeight()) >> 1, (this.Ki.getTop() + this.JZ.getIntrinsicHeight()) - this.JC);
        this.JZ.setBounds(this.Kb);
        this.Kc.set(this.Ki.getLeft() + (this.JD >> 1) + this.JE, this.Ki.getTop() + (this.JD >> 1) + this.JE, (this.Ki.getRight() - (this.JD >> 1)) - this.JE, (this.Ki.getBottom() - (this.JD >> 1)) - this.JE);
        if (this.Kr == null) {
            this.Kr = new SweepGradient(this.Kc.centerX(), this.Kc.centerY(), this.Kp, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.Kr.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.Kc.centerX(), this.Kc.centerY());
            this.Kr.setLocalMatrix(matrix);
            this.Ka.setShader(this.Kr);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        e(canvas);
        super.dispatchDraw(canvas);
    }

    private void lD() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.IU == null) {
            this.IU = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.i.Y(getContext()).getPageActivity());
            this.IU.cS(getContext().getString(d.j.voice_restart_tip)).a(getContext().getString(d.j.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.h.2
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
            this.IU.th();
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
        this.Ke = (TextView) findViewById(d.g.tip_error);
        aj.c(this.Ke, d.C0096d.cp_cont_i, 1);
        this.Kf = (TextView) findViewById(d.g.tip_operator);
        this.Kg = (TextView) findViewById(d.g.tip_time_out);
        this.Kh = (VoiceButton) findViewById(d.g.voice_bnt);
        this.Kd = (TextView) findViewById(d.g.restart);
        this.Ki = (ImageView) findViewById(d.g.play_img);
        this.Kj = (TextView) findViewById(d.g.play_time);
        this.Kj.setClickable(false);
        this.Kd.setOnClickListener(this);
        this.Ki.setOnClickListener(this);
        this.Kh.setRecorderView(this);
        lN();
    }

    private void lM() {
        this.Kh.setVisibility(4);
        this.Kj.setVisibility(0);
        this.Kd.setVisibility(0);
        aj.c(this.Kj, d.C0096d.cp_cont_f, 1);
        aj.c(this.Kd, d.C0096d.cp_cont_f, 1);
        aj.j(this.Kd, d.f.but_posts_record_again_selector);
        this.Ki.setVisibility(0);
        if (this.mModel != null) {
            this.Kj.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.Ki.setContentDescription(String.format(getContext().getString(d.j.listen_time), Integer.valueOf(this.mModel.duration)));
            aj.c(this.Ki, d.f.but_posts_record_play_selector);
        }
        aj.c(this.Kf, d.C0096d.cp_cont_c, 1);
        this.Kf.setText(getContext().getString(d.j.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lN() {
        aj.c(this.Kh, d.f.but_posts_record_zero_selector);
        this.Kh.setVisibility(0);
        this.JF = 0;
        this.Ki.setVisibility(4);
        this.Kj.setVisibility(4);
        this.Kd.setVisibility(4);
        this.Kg.setVisibility(4);
        aj.c(this.Kf, d.C0096d.cp_cont_c, 1);
        this.Kf.setText(getContext().getString(d.j.voice_record_press_to_record));
    }

    public void reset() {
        lN();
        this.mModel = null;
        this.JF = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.Ke.setText("");
        this.Ke.setVisibility(4);
        this.JF = 0;
        lM();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            lN();
            this.Kf.setText(getContext().getString(d.j.voice_record_release_to_stop));
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
        if (this.Ki != null && this.Kj != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    aj.c(this.Kj, d.C0096d.cp_cont_f, 1);
                    this.Kj.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    aj.c(this.Ki, d.f.but_posts_record_play_selector);
                    this.Ki.setContentDescription(String.format(getContext().getString(d.j.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.Kf.setText(getContext().getString(d.j.voice_play_tip));
                    lP();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    aj.c(this.Kj, d.C0096d.cp_cont_f, 1);
                    aj.c(this.Ki, d.f.but_posts_record_stop_selector);
                    this.Ki.setContentDescription(getContext().getString(d.j.pause_load));
                    this.Kf.setText(getContext().getString(d.j.voice_stop_tip));
                    lO();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        aj.c(this.Kg, d.C0096d.cp_cont_i, 1);
        aj.c(this.Ke, d.C0096d.cp_cont_i, 1);
        aj.c(this.Kf, d.C0096d.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.Kg.setVisibility(0);
                this.Kg.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.h.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (h.this.Kg != null) {
                            h.this.Kg.setVisibility(4);
                            h.this.Kg.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 2) {
                this.Ke.setVisibility(0);
                this.Ke.setText(str);
                this.Kf.setText(d.j.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.h.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (h.this.Ke != null) {
                            h.this.Ke.setVisibility(4);
                            h.this.Ke.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 5) {
                this.Ke.setVisibility(0);
                this.Ke.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.h.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (h.this.Ke != null) {
                            h.this.Ke.setVisibility(4);
                            h.this.Ke.setText("");
                        }
                    }
                }, 2000L);
            } else {
                lN();
                this.Ke.setVisibility(0);
                this.Ke.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.h.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (h.this.Ke != null) {
                            h.this.Ke.setVisibility(4);
                            h.this.Ke.setText("");
                        }
                    }
                }, 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.Ke.setVisibility(4);
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
        aj.c(this.Ke, d.C0096d.cp_cont_i, 1);
        this.Ke.setVisibility(0);
        this.Ke.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.IJ = Math.max(i, this.IJ);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.IK > 200) {
            this.IJ = 0;
            this.IK = uptimeMillis;
        }
        if (this.IJ < 10) {
            this.JF = 1;
            invalidate();
        } else if (this.IJ < 20) {
            this.JF = 2;
            invalidate();
        } else if (this.IJ < 30) {
            this.JF = 3;
            invalidate();
        } else if (this.IJ < 40) {
            this.JF = 4;
            invalidate();
        } else {
            this.JF = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aR(int i) {
        if (this.mModel != null && this.Kj != null) {
            int i2 = i / 1000;
            if (this.Ks != i2) {
                this.Kj.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.Ks = i2;
        }
    }

    private void lO() {
        if (this.mModel != null) {
            this.JF = 0;
            this.Kk = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.Kn = SystemClock.uptimeMillis();
            this.Ko = this.Kn + 200;
            this.Kq.sendEmptyMessageAtTime(1, this.Ko);
            invalidate();
        }
    }

    private void lP() {
        this.JF = 0;
        this.JG = 0;
        this.Kk = 0.0f;
        this.Kl = 0.0f;
        this.Kq.removeMessages(1);
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
        this.Km = gVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lQ() {
    }

    public void lR() {
        this.JN = new Paint();
        this.JN.setAntiAlias(true);
        this.JN.setStyle(Paint.Style.STROKE);
        this.JN.setStrokeWidth(2.0f);
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
    }

    public void e(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.JN.setColor(this.JV);
            this.JO.setColor(this.JW);
            this.JP.setColor(this.JX);
            this.JQ.setColor(this.JY);
        } else {
            this.JN.setColor(this.JR);
            this.JO.setColor(this.JS);
            this.JP.setColor(this.JT);
            this.JQ.setColor(this.JU);
        }
        if (this.JF == 2) {
            canvas.drawCircle(this.centerX, this.centerY, this.JH, this.JN);
        } else if (this.JF == 3) {
            canvas.drawCircle(this.centerX, this.centerY, this.JH, this.JN);
            canvas.drawCircle(this.centerX, this.centerY, this.JI, this.JO);
        } else if (this.JF == 4) {
            canvas.drawCircle(this.centerX, this.centerY, this.JH, this.JN);
            canvas.drawCircle(this.centerX, this.centerY, this.JI, this.JO);
            canvas.drawCircle(this.centerX, this.centerY, this.JJ, this.JP);
        } else if (this.JF == 5) {
            canvas.drawCircle(this.centerX, this.centerY, this.JH, this.JN);
            canvas.drawCircle(this.centerX, this.centerY, this.JI, this.JO);
            canvas.drawCircle(this.centerX, this.centerY, this.JJ, this.JP);
            canvas.drawCircle(this.centerX, this.centerY, this.JK, this.JQ);
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
        return this.IS;
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
        if (this.IR != null) {
            this.IR.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.IR = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.IS = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
    }
}
