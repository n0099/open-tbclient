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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.VoiceButton;
/* loaded from: classes3.dex */
public class VoiceRecordButton extends ViewGroup implements View.OnClickListener, com.baidu.adp.lib.voice.f, VoiceManager.b, l {
    private final int[] QO;
    private int QP;
    private final int QQ;
    private final int QR;
    private final int QS;
    private final int QT;
    private final int QU;
    private int QV;
    private int QW;
    private int QX;
    private int QY;
    private int QZ;
    private int Qb;
    private long Qc;
    private EditorTools Qj;
    private int Qk;
    private com.baidu.tbadk.core.dialog.a Qm;
    private float RA;
    private float RB;
    private f RC;
    private long RD;
    private long RE;
    private final int[] RF;
    private final a RG;
    private SweepGradient RH;
    private int RI;
    private int Ra;
    private int Rb;
    private int Rc;
    private Paint Rd;
    private Paint Re;
    private Paint Rf;
    private Paint Rg;
    private int Rh;
    private int Ri;
    private int Rj;
    private int Rk;
    private int Rl;
    private int Rm;
    private int Rn;
    private int Ro;
    private final BitmapDrawable Rp;
    private final Paint Rq;
    private final Rect Rr;
    private final RectF Rs;
    private TextView Rt;
    private TextView Ru;
    private TextView Rv;
    private TextView Rw;
    private VoiceButton Rx;
    private ImageView Ry;
    private TextView Rz;
    private int centerX;
    private int centerY;
    VoiceData.VoiceModel mModel;
    private int mPaddingTop;

    static /* synthetic */ int e(VoiceRecordButton voiceRecordButton) {
        int i = voiceRecordButton.QW;
        voiceRecordButton.QW = i + 1;
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
                if (VoiceRecordButton.this.RB >= 360.0f) {
                    VoiceRecordButton.this.RB = 360.0f;
                    VoiceRecordButton.this.QW = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    VoiceRecordButton.this.RD = uptimeMillis;
                    VoiceRecordButton.this.RE = uptimeMillis + 200;
                    VoiceRecordButton.this.RB += (((float) (uptimeMillis - VoiceRecordButton.this.RD)) / 1000.0f) * VoiceRecordButton.this.RA;
                    sendEmptyMessageAtTime(1, VoiceRecordButton.this.RE);
                    VoiceRecordButton.e(VoiceRecordButton.this);
                }
                VoiceRecordButton.this.QV = VoiceRecordButton.this.QW % 6;
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
        this.Qc = 0L;
        this.QO = new int[4];
        this.QV = 0;
        this.QW = 0;
        this.centerX = 0;
        this.centerY = 0;
        this.QX = 0;
        this.QY = 0;
        this.QZ = 0;
        this.Ra = 0;
        this.Rb = 0;
        this.Rc = 0;
        this.Rh = -1724676609;
        this.Ri = 1546880511;
        this.Rj = 674465279;
        this.Rk = 255034879;
        this.Rl = -1725669966;
        this.Rm = 1545887154;
        this.Rn = 673471922;
        this.Ro = 254041522;
        this.Rq = new Paint(1);
        this.Rr = new Rect();
        this.Rs = new RectF();
        this.Qk = 0;
        this.RF = new int[2];
        this.RG = new a();
        this.Qb = 0;
        this.RI = 0;
        this.QO[0] = context.getResources().getDimensionPixelSize(d.e.ds24);
        this.QO[1] = context.getResources().getDimensionPixelSize(d.e.ds8);
        this.QO[2] = context.getResources().getDimensionPixelSize(d.e.ds22);
        this.QO[3] = context.getResources().getDimensionPixelSize(d.e.ds36);
        this.QX = context.getResources().getDimensionPixelSize(d.e.ds134);
        this.QY = this.QX + context.getResources().getDimensionPixelSize(d.e.ds14);
        this.QZ = this.QY + context.getResources().getDimensionPixelSize(d.e.ds16);
        this.Ra = this.QZ + context.getResources().getDimensionPixelSize(d.e.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.Rb = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.Rc = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.Rb = context.getResources().getDimensionPixelSize(d.e.ds70);
            this.Rc = context.getResources().getDimensionPixelSize(d.e.ds210);
        }
        this.mPaddingTop = context.getResources().getDimensionPixelSize(d.e.ds26);
        this.QP = context.getResources().getDimensionPixelSize(d.e.ds10);
        this.QQ = context.getResources().getDimensionPixelSize(d.e.ds14);
        this.QR = context.getResources().getDimensionPixelSize(d.e.ds4);
        this.QS = context.getResources().getDimensionPixelSize(d.e.ds4);
        this.QT = context.getResources().getDimensionPixelSize(d.e.ds12);
        this.QU = context.getResources().getDimensionPixelSize(d.e.ds2);
        this.Rq.setStyle(Paint.Style.STROKE);
        this.Rq.setStrokeWidth(this.QT);
        this.Rp = (BitmapDrawable) getResources().getDrawable(d.f.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        aq(context);
        oQ();
        this.RF[0] = am.getColor(d.C0142d.common_color_10151);
        this.RF[1] = am.getColor(d.C0142d.common_color_10152);
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
        int measuredWidth = this.Rx.getMeasuredWidth();
        int measuredHeight = this.Rx.getMeasuredHeight();
        int measuredWidth2 = this.Ru.getMeasuredWidth();
        this.Ru.layout((i5 - measuredWidth2) >> 1, this.mPaddingTop + i2, (measuredWidth2 + i5) >> 1, this.Ru.getMeasuredHeight() + this.mPaddingTop + i2);
        int bottom = this.Ru.getBottom();
        this.Rx.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.centerX = (measuredWidth / 2) + i6;
        this.centerY = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.Rw.getMeasuredWidth();
        int measuredHeight2 = this.Rw.getMeasuredHeight();
        int top = this.Rx.getTop();
        this.Rw.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.Rt.getMeasuredWidth();
        int measuredHeight3 = this.Rt.getMeasuredHeight();
        int right = this.Rx.getRight() - this.QP;
        int bottom2 = this.Rx.getBottom() - this.QQ;
        this.Rt.layout(this.Rb + i6, this.Rc + bottom, measuredWidth4 + i6 + this.Rb, measuredHeight3 + this.Rc + bottom);
        int measuredWidth5 = this.Ry.getMeasuredWidth();
        this.Ry.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.Ry.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.Rz.getMeasuredWidth();
        this.Rz.layout((i5 - measuredWidth6) >> 1, (this.Rt.getTop() - this.Rz.getMeasuredHeight()) - this.QR, (measuredWidth6 + i5) >> 1, (this.Rt.getTop() + i2) - this.QR);
        this.Rx.getLeft();
        this.Rx.getRight();
        int measuredWidth7 = this.Rv.getMeasuredWidth();
        int measuredHeight4 = this.Rv.getMeasuredHeight();
        int bottom3 = this.Rx.getBottom();
        this.Rv.layout((i5 - measuredWidth7) >> 1, this.QO[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.QO[3]);
        this.Rr.set((i5 - this.Rp.getIntrinsicWidth()) >> 1, this.Ry.getTop() - this.QS, (i5 + this.Rp.getIntrinsicHeight()) >> 1, (this.Ry.getTop() + this.Rp.getIntrinsicHeight()) - this.QS);
        this.Rp.setBounds(this.Rr);
        this.Rs.set(this.Ry.getLeft() + (this.QT >> 1) + this.QU, this.Ry.getTop() + (this.QT >> 1) + this.QU, (this.Ry.getRight() - (this.QT >> 1)) - this.QU, (this.Ry.getBottom() - (this.QT >> 1)) - this.QU);
        if (this.RH == null) {
            this.RH = new SweepGradient(this.Rs.centerX(), this.Rs.centerY(), this.RF, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.RH.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.Rs.centerX(), this.Rs.centerY());
            this.RH.setLocalMatrix(matrix);
            this.Rq.setShader(this.RH);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        h(canvas);
        super.dispatchDraw(canvas);
    }

    private void oC() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.Qm == null) {
            this.Qm = new com.baidu.tbadk.core.dialog.a(i.ad(getContext()).getPageActivity());
            this.Qm.dE(getContext().getString(d.k.voice_restart_tip)).a(getContext().getString(d.k.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    VoiceRecordButton.this.oM();
                    if (VoiceRecordButton.this.getVoiceManager() != null && VoiceRecordButton.this.mModel != null) {
                        if (recorderManager != null) {
                            recorderManager.cc(VoiceRecordButton.this.mModel.voiceId);
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
            this.Qm.xn();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.mModel != null) {
                if (recorderManager != null) {
                    recorderManager.cc(this.mModel.voiceId);
                }
                this.mModel = null;
            }
        }
    }

    private void aq(Context context) {
        LayoutInflater.from(context).inflate(d.i.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.Ru = (TextView) findViewById(d.g.tip_error);
        am.c(this.Ru, d.C0142d.cp_cont_i, 1);
        this.Rv = (TextView) findViewById(d.g.tip_operator);
        this.Rw = (TextView) findViewById(d.g.tip_time_out);
        this.Rx = (VoiceButton) findViewById(d.g.voice_bnt);
        this.Rt = (TextView) findViewById(d.g.restart);
        this.Ry = (ImageView) findViewById(d.g.play_img);
        this.Rz = (TextView) findViewById(d.g.play_time);
        this.Rz.setClickable(false);
        this.Rt.setOnClickListener(this);
        this.Ry.setOnClickListener(this);
        this.Rx.setRecorderView(this);
        oM();
    }

    private void oL() {
        this.Rx.setVisibility(4);
        this.Rz.setVisibility(0);
        this.Rt.setVisibility(0);
        am.c(this.Rz, d.C0142d.cp_cont_f, 1);
        am.c(this.Rt, d.C0142d.cp_cont_f, 1);
        am.i(this.Rt, d.f.but_posts_record_again_selector);
        this.Ry.setVisibility(0);
        if (this.mModel != null) {
            this.Rz.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.Ry.setContentDescription(String.format(getContext().getString(d.k.listen_time), Integer.valueOf(this.mModel.duration)));
            am.c(this.Ry, d.f.but_posts_record_play_selector);
        }
        am.c(this.Rv, d.C0142d.cp_cont_c, 1);
        this.Rv.setText(getContext().getString(d.k.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oM() {
        am.c(this.Rx, d.f.but_posts_record_zero_selector);
        this.Rx.setVisibility(0);
        this.QV = 0;
        this.Ry.setVisibility(4);
        this.Rz.setVisibility(4);
        this.Rt.setVisibility(4);
        this.Rw.setVisibility(4);
        am.c(this.Rv, d.C0142d.cp_cont_c, 1);
        this.Rv.setText(getContext().getString(d.k.voice_record_press_to_record));
    }

    public void reset() {
        oM();
        this.mModel = null;
        this.QV = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.Ru.setText("");
        this.Ru.setVisibility(4);
        this.QV = 0;
        oL();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            oM();
            this.Rv.setText(getContext().getString(d.k.voice_record_release_to_stop));
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
        if (this.Ry != null && this.Rz != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    am.c(this.Rz, d.C0142d.cp_cont_f, 1);
                    this.Rz.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    am.c(this.Ry, d.f.but_posts_record_play_selector);
                    this.Ry.setContentDescription(String.format(getContext().getString(d.k.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.Rv.setText(getContext().getString(d.k.voice_play_tip));
                    oO();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    am.c(this.Rz, d.C0142d.cp_cont_f, 1);
                    am.c(this.Ry, d.f.but_posts_record_stop_selector);
                    this.Ry.setContentDescription(getContext().getString(d.k.pause_load));
                    this.Rv.setText(getContext().getString(d.k.voice_stop_tip));
                    oN();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        am.c(this.Rw, d.C0142d.cp_cont_i, 1);
        am.c(this.Ru, d.C0142d.cp_cont_i, 1);
        am.c(this.Rv, d.C0142d.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.Rw.setVisibility(0);
                this.Rw.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.Rw != null) {
                            VoiceRecordButton.this.Rw.setVisibility(4);
                            VoiceRecordButton.this.Rw.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 2) {
                this.Ru.setVisibility(0);
                this.Ru.setText(str);
                this.Rv.setText(d.k.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.Ru != null) {
                            VoiceRecordButton.this.Ru.setVisibility(4);
                            VoiceRecordButton.this.Ru.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 5) {
                this.Ru.setVisibility(0);
                this.Ru.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.Ru != null) {
                            VoiceRecordButton.this.Ru.setVisibility(4);
                            VoiceRecordButton.this.Ru.setText("");
                        }
                    }
                }, 2000L);
            } else {
                oM();
                this.Ru.setVisibility(0);
                this.Ru.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.Ru != null) {
                            VoiceRecordButton.this.Ru.setVisibility(4);
                            VoiceRecordButton.this.Ru.setText("");
                        }
                    }
                }, 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.Ru.setVisibility(4);
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
        am.c(this.Ru, d.C0142d.cp_cont_i, 1);
        this.Ru.setVisibility(0);
        this.Ru.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.Qb = Math.max(i, this.Qb);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.Qc > 200) {
            this.Qb = 0;
            this.Qc = uptimeMillis;
        }
        if (this.Qb < 10) {
            this.QV = 1;
            invalidate();
        } else if (this.Qb < 20) {
            this.QV = 2;
            invalidate();
        } else if (this.Qb < 30) {
            this.QV = 3;
            invalidate();
        } else if (this.Qb < 40) {
            this.QV = 4;
            invalidate();
        } else {
            this.QV = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aZ(int i) {
        if (this.mModel != null && this.Rz != null) {
            int i2 = i / 1000;
            if (this.RI != i2) {
                this.Rz.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.RI = i2;
        }
    }

    private void oN() {
        if (this.mModel != null) {
            this.QV = 0;
            this.RA = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.RD = SystemClock.uptimeMillis();
            this.RE = this.RD + 200;
            this.RG.sendEmptyMessageAtTime(1, this.RE);
            invalidate();
        }
    }

    private void oO() {
        this.QV = 0;
        this.QW = 0;
        this.RA = 0.0f;
        this.RB = 0.0f;
        this.RG.removeMessages(1);
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
        this.RC = fVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void oP() {
    }

    public void oQ() {
        this.Rd = new Paint();
        this.Rd.setAntiAlias(true);
        this.Rd.setStyle(Paint.Style.STROKE);
        this.Rd.setStrokeWidth(2.0f);
        this.Re = new Paint();
        this.Re.setAntiAlias(true);
        this.Re.setStyle(Paint.Style.STROKE);
        this.Re.setStrokeWidth(2.0f);
        this.Rf = new Paint();
        this.Rf.setAntiAlias(true);
        this.Rf.setStyle(Paint.Style.STROKE);
        this.Rf.setStrokeWidth(2.0f);
        this.Rg = new Paint();
        this.Rg.setAntiAlias(true);
        this.Rg.setStyle(Paint.Style.STROKE);
        this.Rg.setStrokeWidth(2.0f);
    }

    public void h(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.Rd.setColor(this.Rl);
            this.Re.setColor(this.Rm);
            this.Rf.setColor(this.Rn);
            this.Rg.setColor(this.Ro);
        } else {
            this.Rd.setColor(this.Rh);
            this.Re.setColor(this.Ri);
            this.Rf.setColor(this.Rj);
            this.Rg.setColor(this.Rk);
        }
        if (this.QV == 2) {
            canvas.drawCircle(this.centerX, this.centerY, this.QX, this.Rd);
        } else if (this.QV == 3) {
            canvas.drawCircle(this.centerX, this.centerY, this.QX, this.Rd);
            canvas.drawCircle(this.centerX, this.centerY, this.QY, this.Re);
        } else if (this.QV == 4) {
            canvas.drawCircle(this.centerX, this.centerY, this.QX, this.Rd);
            canvas.drawCircle(this.centerX, this.centerY, this.QY, this.Re);
            canvas.drawCircle(this.centerX, this.centerY, this.QZ, this.Rf);
        } else if (this.QV == 5) {
            canvas.drawCircle(this.centerX, this.centerY, this.QX, this.Rd);
            canvas.drawCircle(this.centerX, this.centerY, this.QY, this.Re);
            canvas.drawCircle(this.centerX, this.centerY, this.QZ, this.Rf);
            canvas.drawCircle(this.centerX, this.centerY, this.Ra, this.Rg);
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
        return this.Qk;
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
        if (this.Qj != null) {
            this.Qj.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Qj = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Qk = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
    }
}
