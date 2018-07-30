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
    private int PY;
    private long PZ;
    private final int[] QL;
    private int QM;
    private final int QN;
    private final int QO;
    private final int QP;
    private final int QQ;
    private final int QR;
    private int QS;
    private int QT;
    private int QU;
    private int QV;
    private int QW;
    private int QX;
    private int QY;
    private int QZ;
    private EditorTools Qg;
    private int Qh;
    private com.baidu.tbadk.core.dialog.a Qj;
    private long RA;
    private long RB;
    private final int[] RC;
    private final a RD;
    private SweepGradient RE;
    private int RF;
    private Paint Ra;
    private Paint Rb;
    private Paint Rc;
    private Paint Rd;
    private int Re;
    private int Rf;
    private int Rg;
    private int Rh;
    private int Ri;
    private int Rj;
    private int Rk;
    private int Rl;
    private final BitmapDrawable Rm;
    private final Paint Rn;
    private final Rect Ro;
    private final RectF Rp;
    private TextView Rq;
    private TextView Rr;
    private TextView Rs;
    private TextView Rt;
    private VoiceButton Ru;
    private ImageView Rv;
    private TextView Rw;
    private float Rx;
    private float Ry;
    private f Rz;
    private int centerX;
    private int centerY;
    VoiceData.VoiceModel mModel;
    private int mPaddingTop;

    static /* synthetic */ int e(VoiceRecordButton voiceRecordButton) {
        int i = voiceRecordButton.QT;
        voiceRecordButton.QT = i + 1;
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
                if (VoiceRecordButton.this.Ry >= 360.0f) {
                    VoiceRecordButton.this.Ry = 360.0f;
                    VoiceRecordButton.this.QT = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    VoiceRecordButton.this.RA = uptimeMillis;
                    VoiceRecordButton.this.RB = uptimeMillis + 200;
                    VoiceRecordButton.this.Ry += (((float) (uptimeMillis - VoiceRecordButton.this.RA)) / 1000.0f) * VoiceRecordButton.this.Rx;
                    sendEmptyMessageAtTime(1, VoiceRecordButton.this.RB);
                    VoiceRecordButton.e(VoiceRecordButton.this);
                }
                VoiceRecordButton.this.QS = VoiceRecordButton.this.QT % 6;
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
        this.PZ = 0L;
        this.QL = new int[4];
        this.QS = 0;
        this.QT = 0;
        this.centerX = 0;
        this.centerY = 0;
        this.QU = 0;
        this.QV = 0;
        this.QW = 0;
        this.QX = 0;
        this.QY = 0;
        this.QZ = 0;
        this.Re = -1724676609;
        this.Rf = 1546880511;
        this.Rg = 674465279;
        this.Rh = 255034879;
        this.Ri = -1725669966;
        this.Rj = 1545887154;
        this.Rk = 673471922;
        this.Rl = 254041522;
        this.Rn = new Paint(1);
        this.Ro = new Rect();
        this.Rp = new RectF();
        this.Qh = 0;
        this.RC = new int[2];
        this.RD = new a();
        this.PY = 0;
        this.RF = 0;
        this.QL[0] = context.getResources().getDimensionPixelSize(d.e.ds24);
        this.QL[1] = context.getResources().getDimensionPixelSize(d.e.ds8);
        this.QL[2] = context.getResources().getDimensionPixelSize(d.e.ds22);
        this.QL[3] = context.getResources().getDimensionPixelSize(d.e.ds36);
        this.QU = context.getResources().getDimensionPixelSize(d.e.ds134);
        this.QV = this.QU + context.getResources().getDimensionPixelSize(d.e.ds14);
        this.QW = this.QV + context.getResources().getDimensionPixelSize(d.e.ds16);
        this.QX = this.QW + context.getResources().getDimensionPixelSize(d.e.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.QY = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.QZ = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.QY = context.getResources().getDimensionPixelSize(d.e.ds70);
            this.QZ = context.getResources().getDimensionPixelSize(d.e.ds210);
        }
        this.mPaddingTop = context.getResources().getDimensionPixelSize(d.e.ds26);
        this.QM = context.getResources().getDimensionPixelSize(d.e.ds10);
        this.QN = context.getResources().getDimensionPixelSize(d.e.ds14);
        this.QO = context.getResources().getDimensionPixelSize(d.e.ds4);
        this.QP = context.getResources().getDimensionPixelSize(d.e.ds4);
        this.QQ = context.getResources().getDimensionPixelSize(d.e.ds12);
        this.QR = context.getResources().getDimensionPixelSize(d.e.ds2);
        this.Rn.setStyle(Paint.Style.STROKE);
        this.Rn.setStrokeWidth(this.QQ);
        this.Rm = (BitmapDrawable) getResources().getDrawable(d.f.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        aq(context);
        oT();
        this.RC[0] = am.getColor(d.C0140d.common_color_10151);
        this.RC[1] = am.getColor(d.C0140d.common_color_10152);
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
        int measuredWidth = this.Ru.getMeasuredWidth();
        int measuredHeight = this.Ru.getMeasuredHeight();
        int measuredWidth2 = this.Rr.getMeasuredWidth();
        this.Rr.layout((i5 - measuredWidth2) >> 1, this.mPaddingTop + i2, (measuredWidth2 + i5) >> 1, this.Rr.getMeasuredHeight() + this.mPaddingTop + i2);
        int bottom = this.Rr.getBottom();
        this.Ru.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.centerX = (measuredWidth / 2) + i6;
        this.centerY = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.Rt.getMeasuredWidth();
        int measuredHeight2 = this.Rt.getMeasuredHeight();
        int top = this.Ru.getTop();
        this.Rt.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.Rq.getMeasuredWidth();
        int measuredHeight3 = this.Rq.getMeasuredHeight();
        int right = this.Ru.getRight() - this.QM;
        int bottom2 = this.Ru.getBottom() - this.QN;
        this.Rq.layout(this.QY + i6, this.QZ + bottom, measuredWidth4 + i6 + this.QY, measuredHeight3 + this.QZ + bottom);
        int measuredWidth5 = this.Rv.getMeasuredWidth();
        this.Rv.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.Rv.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.Rw.getMeasuredWidth();
        this.Rw.layout((i5 - measuredWidth6) >> 1, (this.Rq.getTop() - this.Rw.getMeasuredHeight()) - this.QO, (measuredWidth6 + i5) >> 1, (this.Rq.getTop() + i2) - this.QO);
        this.Ru.getLeft();
        this.Ru.getRight();
        int measuredWidth7 = this.Rs.getMeasuredWidth();
        int measuredHeight4 = this.Rs.getMeasuredHeight();
        int bottom3 = this.Ru.getBottom();
        this.Rs.layout((i5 - measuredWidth7) >> 1, this.QL[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.QL[3]);
        this.Ro.set((i5 - this.Rm.getIntrinsicWidth()) >> 1, this.Rv.getTop() - this.QP, (i5 + this.Rm.getIntrinsicHeight()) >> 1, (this.Rv.getTop() + this.Rm.getIntrinsicHeight()) - this.QP);
        this.Rm.setBounds(this.Ro);
        this.Rp.set(this.Rv.getLeft() + (this.QQ >> 1) + this.QR, this.Rv.getTop() + (this.QQ >> 1) + this.QR, (this.Rv.getRight() - (this.QQ >> 1)) - this.QR, (this.Rv.getBottom() - (this.QQ >> 1)) - this.QR);
        if (this.RE == null) {
            this.RE = new SweepGradient(this.Rp.centerX(), this.Rp.centerY(), this.RC, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.RE.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.Rp.centerX(), this.Rp.centerY());
            this.RE.setLocalMatrix(matrix);
            this.Rn.setShader(this.RE);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        g(canvas);
        super.dispatchDraw(canvas);
    }

    private void oE() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.Qj == null) {
            this.Qj = new com.baidu.tbadk.core.dialog.a(i.ad(getContext()).getPageActivity());
            this.Qj.dB(getContext().getString(d.j.voice_restart_tip)).a(getContext().getString(d.j.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    VoiceRecordButton.this.oP();
                    if (VoiceRecordButton.this.getVoiceManager() != null && VoiceRecordButton.this.mModel != null) {
                        if (recorderManager != null) {
                            recorderManager.cd(VoiceRecordButton.this.mModel.voiceId);
                        }
                        VoiceRecordButton.this.mModel = null;
                    }
                }
            }).b(getContext().getString(d.j.cancel), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(i.ad(getContext()));
        }
        try {
            this.Qj.xf();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.mModel != null) {
                if (recorderManager != null) {
                    recorderManager.cd(this.mModel.voiceId);
                }
                this.mModel = null;
            }
        }
    }

    private void aq(Context context) {
        LayoutInflater.from(context).inflate(d.h.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.Rr = (TextView) findViewById(d.g.tip_error);
        am.c(this.Rr, d.C0140d.cp_cont_i, 1);
        this.Rs = (TextView) findViewById(d.g.tip_operator);
        this.Rt = (TextView) findViewById(d.g.tip_time_out);
        this.Ru = (VoiceButton) findViewById(d.g.voice_bnt);
        this.Rq = (TextView) findViewById(d.g.restart);
        this.Rv = (ImageView) findViewById(d.g.play_img);
        this.Rw = (TextView) findViewById(d.g.play_time);
        this.Rw.setClickable(false);
        this.Rq.setOnClickListener(this);
        this.Rv.setOnClickListener(this);
        this.Ru.setRecorderView(this);
        oP();
    }

    private void oO() {
        this.Ru.setVisibility(4);
        this.Rw.setVisibility(0);
        this.Rq.setVisibility(0);
        am.c(this.Rw, d.C0140d.cp_cont_f, 1);
        am.c(this.Rq, d.C0140d.cp_cont_f, 1);
        am.i(this.Rq, d.f.but_posts_record_again_selector);
        this.Rv.setVisibility(0);
        if (this.mModel != null) {
            this.Rw.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.Rv.setContentDescription(String.format(getContext().getString(d.j.listen_time), Integer.valueOf(this.mModel.duration)));
            am.c(this.Rv, d.f.but_posts_record_play_selector);
        }
        am.c(this.Rs, d.C0140d.cp_cont_c, 1);
        this.Rs.setText(getContext().getString(d.j.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oP() {
        am.c(this.Ru, d.f.but_posts_record_zero_selector);
        this.Ru.setVisibility(0);
        this.QS = 0;
        this.Rv.setVisibility(4);
        this.Rw.setVisibility(4);
        this.Rq.setVisibility(4);
        this.Rt.setVisibility(4);
        am.c(this.Rs, d.C0140d.cp_cont_c, 1);
        this.Rs.setText(getContext().getString(d.j.voice_record_press_to_record));
    }

    public void reset() {
        oP();
        this.mModel = null;
        this.QS = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.Rr.setText("");
        this.Rr.setVisibility(4);
        this.QS = 0;
        oO();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            oP();
            this.Rs.setText(getContext().getString(d.j.voice_record_release_to_stop));
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
        if (this.Rv != null && this.Rw != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    am.c(this.Rw, d.C0140d.cp_cont_f, 1);
                    this.Rw.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    am.c(this.Rv, d.f.but_posts_record_play_selector);
                    this.Rv.setContentDescription(String.format(getContext().getString(d.j.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.Rs.setText(getContext().getString(d.j.voice_play_tip));
                    oR();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    am.c(this.Rw, d.C0140d.cp_cont_f, 1);
                    am.c(this.Rv, d.f.but_posts_record_stop_selector);
                    this.Rv.setContentDescription(getContext().getString(d.j.pause_load));
                    this.Rs.setText(getContext().getString(d.j.voice_stop_tip));
                    oQ();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        am.c(this.Rt, d.C0140d.cp_cont_i, 1);
        am.c(this.Rr, d.C0140d.cp_cont_i, 1);
        am.c(this.Rs, d.C0140d.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.Rt.setVisibility(0);
                this.Rt.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.Rt != null) {
                            VoiceRecordButton.this.Rt.setVisibility(4);
                            VoiceRecordButton.this.Rt.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 2) {
                this.Rr.setVisibility(0);
                this.Rr.setText(str);
                this.Rs.setText(d.j.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.Rr != null) {
                            VoiceRecordButton.this.Rr.setVisibility(4);
                            VoiceRecordButton.this.Rr.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 5) {
                this.Rr.setVisibility(0);
                this.Rr.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.Rr != null) {
                            VoiceRecordButton.this.Rr.setVisibility(4);
                            VoiceRecordButton.this.Rr.setText("");
                        }
                    }
                }, 2000L);
            } else {
                oP();
                this.Rr.setVisibility(0);
                this.Rr.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.Rr != null) {
                            VoiceRecordButton.this.Rr.setVisibility(4);
                            VoiceRecordButton.this.Rr.setText("");
                        }
                    }
                }, 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.Rr.setVisibility(4);
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
        am.c(this.Rr, d.C0140d.cp_cont_i, 1);
        this.Rr.setVisibility(0);
        this.Rr.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.PY = Math.max(i, this.PY);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.PZ > 200) {
            this.PY = 0;
            this.PZ = uptimeMillis;
        }
        if (this.PY < 10) {
            this.QS = 1;
            invalidate();
        } else if (this.PY < 20) {
            this.QS = 2;
            invalidate();
        } else if (this.PY < 30) {
            this.QS = 3;
            invalidate();
        } else if (this.PY < 40) {
            this.QS = 4;
            invalidate();
        } else {
            this.QS = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void ba(int i) {
        if (this.mModel != null && this.Rw != null) {
            int i2 = i / 1000;
            if (this.RF != i2) {
                this.Rw.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.RF = i2;
        }
    }

    private void oQ() {
        if (this.mModel != null) {
            this.QS = 0;
            this.Rx = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.RA = SystemClock.uptimeMillis();
            this.RB = this.RA + 200;
            this.RD.sendEmptyMessageAtTime(1, this.RB);
            invalidate();
        }
    }

    private void oR() {
        this.QS = 0;
        this.QT = 0;
        this.Rx = 0.0f;
        this.Ry = 0.0f;
        this.RD.removeMessages(1);
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
                oE();
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
        this.Rz = fVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void oS() {
    }

    public void oT() {
        this.Ra = new Paint();
        this.Ra.setAntiAlias(true);
        this.Ra.setStyle(Paint.Style.STROKE);
        this.Ra.setStrokeWidth(2.0f);
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
    }

    public void g(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.Ra.setColor(this.Ri);
            this.Rb.setColor(this.Rj);
            this.Rc.setColor(this.Rk);
            this.Rd.setColor(this.Rl);
        } else {
            this.Ra.setColor(this.Re);
            this.Rb.setColor(this.Rf);
            this.Rc.setColor(this.Rg);
            this.Rd.setColor(this.Rh);
        }
        if (this.QS == 2) {
            canvas.drawCircle(this.centerX, this.centerY, this.QU, this.Ra);
        } else if (this.QS == 3) {
            canvas.drawCircle(this.centerX, this.centerY, this.QU, this.Ra);
            canvas.drawCircle(this.centerX, this.centerY, this.QV, this.Rb);
        } else if (this.QS == 4) {
            canvas.drawCircle(this.centerX, this.centerY, this.QU, this.Ra);
            canvas.drawCircle(this.centerX, this.centerY, this.QV, this.Rb);
            canvas.drawCircle(this.centerX, this.centerY, this.QW, this.Rc);
        } else if (this.QS == 5) {
            canvas.drawCircle(this.centerX, this.centerY, this.QU, this.Ra);
            canvas.drawCircle(this.centerX, this.centerY, this.QV, this.Rb);
            canvas.drawCircle(this.centerX, this.centerY, this.QW, this.Rc);
            canvas.drawCircle(this.centerX, this.centerY, this.QX, this.Rd);
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
                    oO();
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
    public void oF() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Qh;
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
        if (this.Qg != null) {
            this.Qg.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Qg = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Qh = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
    }
}
