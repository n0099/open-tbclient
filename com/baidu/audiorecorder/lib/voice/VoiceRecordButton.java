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
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.VoiceButton;
/* loaded from: classes3.dex */
public class VoiceRecordButton extends ViewGroup implements View.OnClickListener, com.baidu.adp.lib.voice.f, VoiceManager.b, l {
    private int PZ;
    private final int[] QM;
    private int QN;
    private final int QO;
    private final int QP;
    private final int QQ;
    private final int QR;
    private final int QS;
    private int QT;
    private int QU;
    private int QV;
    private int QW;
    private int QX;
    private int QY;
    private int QZ;
    private long Qa;
    private EditorTools Qh;
    private int Qi;
    private com.baidu.tbadk.core.dialog.a Qk;
    private f RA;
    private long RB;
    private long RC;
    private final int[] RD;
    private final a RE;
    private SweepGradient RF;
    private int RG;
    private int Ra;
    private Paint Rb;
    private Paint Rc;
    private Paint Rd;
    private Paint Re;
    private int Rf;
    private int Rg;
    private int Rh;
    private int Ri;
    private int Rj;
    private int Rk;
    private int Rl;
    private int Rm;
    private final BitmapDrawable Rn;
    private final Paint Ro;
    private final Rect Rp;
    private final RectF Rq;
    private TextView Rr;
    private TextView Rs;
    private TextView Rt;
    private TextView Ru;
    private VoiceButton Rv;
    private ImageView Rw;
    private TextView Rx;
    private float Ry;
    private float Rz;
    private int centerX;
    private int centerY;
    VoiceData.VoiceModel mModel;
    private int mPaddingTop;

    static /* synthetic */ int e(VoiceRecordButton voiceRecordButton) {
        int i = voiceRecordButton.QU;
        voiceRecordButton.QU = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends Handler {
        private a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                if (VoiceRecordButton.this.Rz >= 360.0f) {
                    VoiceRecordButton.this.Rz = 360.0f;
                    VoiceRecordButton.this.QU = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    VoiceRecordButton.this.RB = uptimeMillis;
                    VoiceRecordButton.this.RC = uptimeMillis + 200;
                    VoiceRecordButton.this.Rz += (((float) (uptimeMillis - VoiceRecordButton.this.RB)) / 1000.0f) * VoiceRecordButton.this.Ry;
                    sendEmptyMessageAtTime(1, VoiceRecordButton.this.RC);
                    VoiceRecordButton.e(VoiceRecordButton.this);
                }
                VoiceRecordButton.this.QT = VoiceRecordButton.this.QU % 6;
                VoiceRecordButton.this.invalidate();
            }
        }
    }

    public static VoiceRecordButton ap(Context context) {
        return new VoiceRecordButton(context);
    }

    public VoiceRecordButton(Context context) {
        this(context, null);
    }

    public VoiceRecordButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Qa = 0L;
        this.QM = new int[4];
        this.QT = 0;
        this.QU = 0;
        this.centerX = 0;
        this.centerY = 0;
        this.QV = 0;
        this.QW = 0;
        this.QX = 0;
        this.QY = 0;
        this.QZ = 0;
        this.Ra = 0;
        this.Rf = -1724676609;
        this.Rg = 1546880511;
        this.Rh = 674465279;
        this.Ri = 255034879;
        this.Rj = -1725669966;
        this.Rk = 1545887154;
        this.Rl = 673471922;
        this.Rm = 254041522;
        this.Ro = new Paint(1);
        this.Rp = new Rect();
        this.Rq = new RectF();
        this.Qi = 0;
        this.RD = new int[2];
        this.RE = new a();
        this.PZ = 0;
        this.RG = 0;
        this.QM[0] = context.getResources().getDimensionPixelSize(d.e.ds24);
        this.QM[1] = context.getResources().getDimensionPixelSize(d.e.ds8);
        this.QM[2] = context.getResources().getDimensionPixelSize(d.e.ds22);
        this.QM[3] = context.getResources().getDimensionPixelSize(d.e.ds36);
        this.QV = context.getResources().getDimensionPixelSize(d.e.ds134);
        this.QW = this.QV + context.getResources().getDimensionPixelSize(d.e.ds14);
        this.QX = this.QW + context.getResources().getDimensionPixelSize(d.e.ds16);
        this.QY = this.QX + context.getResources().getDimensionPixelSize(d.e.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.QZ = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.Ra = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.QZ = context.getResources().getDimensionPixelSize(d.e.ds70);
            this.Ra = context.getResources().getDimensionPixelSize(d.e.ds210);
        }
        this.mPaddingTop = context.getResources().getDimensionPixelSize(d.e.ds26);
        this.QN = context.getResources().getDimensionPixelSize(d.e.ds10);
        this.QO = context.getResources().getDimensionPixelSize(d.e.ds14);
        this.QP = context.getResources().getDimensionPixelSize(d.e.ds4);
        this.QQ = context.getResources().getDimensionPixelSize(d.e.ds4);
        this.QR = context.getResources().getDimensionPixelSize(d.e.ds12);
        this.QS = context.getResources().getDimensionPixelSize(d.e.ds2);
        this.Ro.setStyle(Paint.Style.STROKE);
        this.Ro.setStrokeWidth(this.QR);
        this.Rn = (BitmapDrawable) getResources().getDrawable(d.f.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        aq(context);
        oQ();
        this.RD[0] = al.getColor(d.C0141d.common_color_10151);
        this.RD[1] = al.getColor(d.C0141d.common_color_10152);
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
                measureChild(childAt, i3 - 2147483648, i4 - 2147483648);
            }
        }
        setMeasuredDimension(i3, i4);
        this.mPaddingTop = ((i4 - getContext().getResources().getDimensionPixelSize(d.e.ds460)) / 2) + getContext().getResources().getDimensionPixelSize(d.e.ds6);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int measuredWidth = this.Rv.getMeasuredWidth();
        int measuredHeight = this.Rv.getMeasuredHeight();
        int measuredWidth2 = this.Rs.getMeasuredWidth();
        this.Rs.layout((i5 - measuredWidth2) >> 1, this.mPaddingTop + i2, (measuredWidth2 + i5) >> 1, this.Rs.getMeasuredHeight() + this.mPaddingTop + i2);
        int bottom = this.Rs.getBottom();
        this.Rv.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.centerX = (measuredWidth / 2) + i6;
        this.centerY = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.Ru.getMeasuredWidth();
        int measuredHeight2 = this.Ru.getMeasuredHeight();
        int top = this.Rv.getTop();
        this.Ru.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.Rr.getMeasuredWidth();
        int measuredHeight3 = this.Rr.getMeasuredHeight();
        int right = this.Rv.getRight() - this.QN;
        int bottom2 = this.Rv.getBottom() - this.QO;
        this.Rr.layout(this.QZ + i6, this.Ra + bottom, measuredWidth4 + i6 + this.QZ, measuredHeight3 + this.Ra + bottom);
        int measuredWidth5 = this.Rw.getMeasuredWidth();
        this.Rw.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.Rw.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.Rx.getMeasuredWidth();
        this.Rx.layout((i5 - measuredWidth6) >> 1, (this.Rr.getTop() - this.Rx.getMeasuredHeight()) - this.QP, (measuredWidth6 + i5) >> 1, (this.Rr.getTop() + i2) - this.QP);
        this.Rv.getLeft();
        this.Rv.getRight();
        int measuredWidth7 = this.Rt.getMeasuredWidth();
        int measuredHeight4 = this.Rt.getMeasuredHeight();
        int bottom3 = this.Rv.getBottom();
        this.Rt.layout((i5 - measuredWidth7) >> 1, this.QM[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.QM[3]);
        this.Rp.set((i5 - this.Rn.getIntrinsicWidth()) >> 1, this.Rw.getTop() - this.QQ, (i5 + this.Rn.getIntrinsicHeight()) >> 1, (this.Rw.getTop() + this.Rn.getIntrinsicHeight()) - this.QQ);
        this.Rn.setBounds(this.Rp);
        this.Rq.set(this.Rw.getLeft() + (this.QR >> 1) + this.QS, this.Rw.getTop() + (this.QR >> 1) + this.QS, (this.Rw.getRight() - (this.QR >> 1)) - this.QS, (this.Rw.getBottom() - (this.QR >> 1)) - this.QS);
        if (this.RF == null) {
            this.RF = new SweepGradient(this.Rq.centerX(), this.Rq.centerY(), this.RD, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.RF.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.Rq.centerX(), this.Rq.centerY());
            this.RF.setLocalMatrix(matrix);
            this.Ro.setShader(this.RF);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        h(canvas);
        super.dispatchDraw(canvas);
    }

    private void oC() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.Qk == null) {
            this.Qk = new com.baidu.tbadk.core.dialog.a(i.ad(getContext()).getPageActivity());
            this.Qk.dB(getContext().getString(d.k.voice_restart_tip)).a(getContext().getString(d.k.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    VoiceRecordButton.this.oM();
                    if (VoiceRecordButton.this.getVoiceManager() != null && VoiceRecordButton.this.mModel != null) {
                        if (recorderManager != null) {
                            recorderManager.ca(VoiceRecordButton.this.mModel.voiceId);
                        }
                        VoiceRecordButton.this.mModel = null;
                    }
                }
            }).b(getContext().getString(d.k.cancel), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(i.ad(getContext()));
        }
        try {
            this.Qk.xa();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.mModel != null) {
                if (recorderManager != null) {
                    recorderManager.ca(this.mModel.voiceId);
                }
                this.mModel = null;
            }
        }
    }

    private void aq(Context context) {
        LayoutInflater.from(context).inflate(d.i.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.Rs = (TextView) findViewById(d.g.tip_error);
        al.c(this.Rs, d.C0141d.cp_cont_i, 1);
        this.Rt = (TextView) findViewById(d.g.tip_operator);
        this.Ru = (TextView) findViewById(d.g.tip_time_out);
        this.Rv = (VoiceButton) findViewById(d.g.voice_bnt);
        this.Rr = (TextView) findViewById(d.g.restart);
        this.Rw = (ImageView) findViewById(d.g.play_img);
        this.Rx = (TextView) findViewById(d.g.play_time);
        this.Rx.setClickable(false);
        this.Rr.setOnClickListener(this);
        this.Rw.setOnClickListener(this);
        this.Rv.setRecorderView(this);
        oM();
    }

    private void oL() {
        this.Rv.setVisibility(4);
        this.Rx.setVisibility(0);
        this.Rr.setVisibility(0);
        al.c(this.Rx, d.C0141d.cp_cont_f, 1);
        al.c(this.Rr, d.C0141d.cp_cont_f, 1);
        al.i(this.Rr, d.f.but_posts_record_again_selector);
        this.Rw.setVisibility(0);
        if (this.mModel != null) {
            this.Rx.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.Rw.setContentDescription(String.format(getContext().getString(d.k.listen_time), Integer.valueOf(this.mModel.duration)));
            al.c(this.Rw, d.f.but_posts_record_play_selector);
        }
        al.c(this.Rt, d.C0141d.cp_cont_c, 1);
        this.Rt.setText(getContext().getString(d.k.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oM() {
        al.c(this.Rv, d.f.but_posts_record_zero_selector);
        this.Rv.setVisibility(0);
        this.QT = 0;
        this.Rw.setVisibility(4);
        this.Rx.setVisibility(4);
        this.Rr.setVisibility(4);
        this.Ru.setVisibility(4);
        al.c(this.Rt, d.C0141d.cp_cont_c, 1);
        this.Rt.setText(getContext().getString(d.k.voice_record_press_to_record));
    }

    public void reset() {
        oM();
        this.mModel = null;
        this.QT = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.Rs.setText("");
        this.Rs.setVisibility(4);
        this.QT = 0;
        oL();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            oM();
            this.Rt.setText(getContext().getString(d.k.voice_record_release_to_stop));
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
        if (this.Rw != null && this.Rx != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    al.c(this.Rx, d.C0141d.cp_cont_f, 1);
                    this.Rx.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    al.c(this.Rw, d.f.but_posts_record_play_selector);
                    this.Rw.setContentDescription(String.format(getContext().getString(d.k.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.Rt.setText(getContext().getString(d.k.voice_play_tip));
                    oO();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    al.c(this.Rx, d.C0141d.cp_cont_f, 1);
                    al.c(this.Rw, d.f.but_posts_record_stop_selector);
                    this.Rw.setContentDescription(getContext().getString(d.k.pause_load));
                    this.Rt.setText(getContext().getString(d.k.voice_stop_tip));
                    oN();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        al.c(this.Ru, d.C0141d.cp_cont_i, 1);
        al.c(this.Rs, d.C0141d.cp_cont_i, 1);
        al.c(this.Rt, d.C0141d.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.Ru.setVisibility(0);
                this.Ru.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.Ru != null) {
                            VoiceRecordButton.this.Ru.setVisibility(4);
                            VoiceRecordButton.this.Ru.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 2) {
                this.Rs.setVisibility(0);
                this.Rs.setText(str);
                this.Rt.setText(d.k.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.Rs != null) {
                            VoiceRecordButton.this.Rs.setVisibility(4);
                            VoiceRecordButton.this.Rs.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 5) {
                this.Rs.setVisibility(0);
                this.Rs.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.Rs != null) {
                            VoiceRecordButton.this.Rs.setVisibility(4);
                            VoiceRecordButton.this.Rs.setText("");
                        }
                    }
                }, 2000L);
            } else {
                oM();
                this.Rs.setVisibility(0);
                this.Rs.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.Rs != null) {
                            VoiceRecordButton.this.Rs.setVisibility(4);
                            VoiceRecordButton.this.Rs.setText("");
                        }
                    }
                }, 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.Rs.setVisibility(4);
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
        al.c(this.Rs, d.C0141d.cp_cont_i, 1);
        this.Rs.setVisibility(0);
        this.Rs.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.PZ = Math.max(i, this.PZ);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.Qa > 200) {
            this.PZ = 0;
            this.Qa = uptimeMillis;
        }
        if (this.PZ < 10) {
            this.QT = 1;
            invalidate();
        } else if (this.PZ < 20) {
            this.QT = 2;
            invalidate();
        } else if (this.PZ < 30) {
            this.QT = 3;
            invalidate();
        } else if (this.PZ < 40) {
            this.QT = 4;
            invalidate();
        } else {
            this.QT = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aZ(int i) {
        if (this.mModel != null && this.Rx != null) {
            int i2 = i / 1000;
            if (this.RG != i2) {
                this.Rx.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.RG = i2;
        }
    }

    private void oN() {
        if (this.mModel != null) {
            this.QT = 0;
            this.Ry = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.RB = SystemClock.uptimeMillis();
            this.RC = this.RB + 200;
            this.RE.sendEmptyMessageAtTime(1, this.RC);
            invalidate();
        }
    }

    private void oO() {
        this.QT = 0;
        this.QU = 0;
        this.Ry = 0.0f;
        this.Rz = 0.0f;
        this.RE.removeMessages(1);
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
                oC();
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

    public void setCallback(f fVar) {
        this.RA = fVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void oP() {
    }

    public void oQ() {
        this.Rb = new Paint();
        this.Rb.setAntiAlias(true);
        this.Rb.setStyle(Paint.Style.STROKE);
        this.Rb.setStrokeWidth(2.0f);
        this.Rc = new Paint();
        this.Rc.setAntiAlias(true);
        this.Rc.setStyle(Paint.Style.STROKE);
        this.Rc.setStrokeWidth(2.0f);
        this.Rd = new Paint();
        this.Rd.setAntiAlias(true);
        this.Rd.setStyle(Paint.Style.STROKE);
        this.Rd.setStrokeWidth(2.0f);
        this.Re = new Paint();
        this.Re.setAntiAlias(true);
        this.Re.setStyle(Paint.Style.STROKE);
        this.Re.setStrokeWidth(2.0f);
    }

    public void h(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.Rb.setColor(this.Rj);
            this.Rc.setColor(this.Rk);
            this.Rd.setColor(this.Rl);
            this.Re.setColor(this.Rm);
        } else {
            this.Rb.setColor(this.Rf);
            this.Rc.setColor(this.Rg);
            this.Rd.setColor(this.Rh);
            this.Re.setColor(this.Ri);
        }
        if (this.QT == 2) {
            canvas.drawCircle(this.centerX, this.centerY, this.QV, this.Rb);
        } else if (this.QT == 3) {
            canvas.drawCircle(this.centerX, this.centerY, this.QV, this.Rb);
            canvas.drawCircle(this.centerX, this.centerY, this.QW, this.Rc);
        } else if (this.QT == 4) {
            canvas.drawCircle(this.centerX, this.centerY, this.QV, this.Rb);
            canvas.drawCircle(this.centerX, this.centerY, this.QW, this.Rc);
            canvas.drawCircle(this.centerX, this.centerY, this.QX, this.Rd);
        } else if (this.QT == 5) {
            canvas.drawCircle(this.centerX, this.centerY, this.QV, this.Rb);
            canvas.drawCircle(this.centerX, this.centerY, this.QW, this.Rc);
            canvas.drawCircle(this.centerX, this.centerY, this.QX, this.Rd);
            canvas.drawCircle(this.centerX, this.centerY, this.QY, this.Re);
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
                    oL();
                    b((VoiceData.VoiceModel) aVar.data);
                    this.mModel = (VoiceData.VoiceModel) aVar.data;
                    return;
                }
                reset();
                b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void oD() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Qi;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Qh != null) {
            this.Qh.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Qh = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Qi = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
    }
}
