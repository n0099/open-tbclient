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
/* loaded from: classes6.dex */
public class VoiceRecordButton extends ViewGroup implements View.OnClickListener, com.baidu.adp.lib.voice.f, VoiceManager.b, l {
    private int VG;
    private long VH;
    private EditorTools VO;
    private int VP;
    private com.baidu.tbadk.core.dialog.a VR;
    private int WA;
    private int WB;
    private int WC;
    private int WD;
    private int WE;
    private int WF;
    private int WG;
    private int WH;
    private Paint WI;
    private Paint WJ;
    private Paint WK;
    private Paint WL;
    private int WM;
    private int WN;
    private int WO;
    private int WP;
    private int WQ;
    private int WR;
    private int WS;
    private int WT;
    private final BitmapDrawable WU;
    private final Paint WV;
    private final Rect WW;
    private final RectF WX;
    private TextView WY;
    private TextView WZ;
    private final int[] Wt;
    private int Wu;
    private final int Wv;
    private final int Ww;
    private final int Wx;
    private final int Wy;
    private final int Wz;
    private TextView Xa;
    private TextView Xb;
    private VoiceButton Xc;
    private ImageView Xd;
    private TextView Xe;
    private float Xf;
    private float Xg;
    private f Xh;
    private long Xi;
    private long Xj;
    private final int[] Xk;
    private final a Xl;
    private SweepGradient Xm;
    private int Xn;
    private int centerX;
    private int centerY;
    VoiceData.VoiceModel mModel;
    private int mPaddingTop;

    static /* synthetic */ int e(VoiceRecordButton voiceRecordButton) {
        int i = voiceRecordButton.WB;
        voiceRecordButton.WB = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a extends Handler {
        private a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                if (VoiceRecordButton.this.Xg >= 360.0f) {
                    VoiceRecordButton.this.Xg = 360.0f;
                    VoiceRecordButton.this.WB = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    VoiceRecordButton.this.Xi = uptimeMillis;
                    VoiceRecordButton.this.Xj = uptimeMillis + 200;
                    VoiceRecordButton.this.Xg += (((float) (uptimeMillis - VoiceRecordButton.this.Xi)) / 1000.0f) * VoiceRecordButton.this.Xf;
                    sendEmptyMessageAtTime(1, VoiceRecordButton.this.Xj);
                    VoiceRecordButton.e(VoiceRecordButton.this);
                }
                VoiceRecordButton.this.WA = VoiceRecordButton.this.WB % 6;
                VoiceRecordButton.this.invalidate();
            }
        }
    }

    public static VoiceRecordButton aV(Context context) {
        return new VoiceRecordButton(context);
    }

    public VoiceRecordButton(Context context) {
        this(context, null);
    }

    public VoiceRecordButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.VH = 0L;
        this.Wt = new int[4];
        this.WA = 0;
        this.WB = 0;
        this.centerX = 0;
        this.centerY = 0;
        this.WC = 0;
        this.WD = 0;
        this.WE = 0;
        this.WF = 0;
        this.WG = 0;
        this.WH = 0;
        this.WM = -1724676609;
        this.WN = 1546880511;
        this.WO = 674465279;
        this.WP = 255034879;
        this.WQ = -1725669966;
        this.WR = 1545887154;
        this.WS = 673471922;
        this.WT = 254041522;
        this.WV = new Paint(1);
        this.WW = new Rect();
        this.WX = new RectF();
        this.VP = 0;
        this.Xk = new int[2];
        this.Xl = new a();
        this.VG = 0;
        this.Xn = 0;
        this.Wt[0] = context.getResources().getDimensionPixelSize(d.e.ds24);
        this.Wt[1] = context.getResources().getDimensionPixelSize(d.e.ds8);
        this.Wt[2] = context.getResources().getDimensionPixelSize(d.e.ds22);
        this.Wt[3] = context.getResources().getDimensionPixelSize(d.e.ds36);
        this.WC = context.getResources().getDimensionPixelSize(d.e.ds134);
        this.WD = this.WC + context.getResources().getDimensionPixelSize(d.e.ds14);
        this.WE = this.WD + context.getResources().getDimensionPixelSize(d.e.ds16);
        this.WF = this.WE + context.getResources().getDimensionPixelSize(d.e.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.WG = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.WH = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.WG = context.getResources().getDimensionPixelSize(d.e.ds70);
            this.WH = context.getResources().getDimensionPixelSize(d.e.ds210);
        }
        this.mPaddingTop = context.getResources().getDimensionPixelSize(d.e.ds26);
        this.Wu = context.getResources().getDimensionPixelSize(d.e.ds10);
        this.Wv = context.getResources().getDimensionPixelSize(d.e.ds14);
        this.Ww = context.getResources().getDimensionPixelSize(d.e.ds4);
        this.Wx = context.getResources().getDimensionPixelSize(d.e.ds4);
        this.Wy = context.getResources().getDimensionPixelSize(d.e.ds12);
        this.Wz = context.getResources().getDimensionPixelSize(d.e.ds2);
        this.WV.setStyle(Paint.Style.STROKE);
        this.WV.setStrokeWidth(this.Wy);
        this.WU = (BitmapDrawable) getResources().getDrawable(d.f.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        aW(context);
        rh();
        this.Xk[0] = al.getColor(d.C0277d.common_color_10151);
        this.Xk[1] = al.getColor(d.C0277d.common_color_10152);
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
        int measuredWidth = this.Xc.getMeasuredWidth();
        int measuredHeight = this.Xc.getMeasuredHeight();
        int measuredWidth2 = this.WZ.getMeasuredWidth();
        this.WZ.layout((i5 - measuredWidth2) >> 1, this.mPaddingTop + i2, (measuredWidth2 + i5) >> 1, this.WZ.getMeasuredHeight() + this.mPaddingTop + i2);
        int bottom = this.WZ.getBottom();
        this.Xc.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.centerX = (measuredWidth / 2) + i6;
        this.centerY = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.Xb.getMeasuredWidth();
        int measuredHeight2 = this.Xb.getMeasuredHeight();
        int top = this.Xc.getTop();
        this.Xb.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.WY.getMeasuredWidth();
        int measuredHeight3 = this.WY.getMeasuredHeight();
        int right = this.Xc.getRight() - this.Wu;
        int bottom2 = this.Xc.getBottom() - this.Wv;
        this.WY.layout(this.WG + i6, this.WH + bottom, measuredWidth4 + i6 + this.WG, measuredHeight3 + this.WH + bottom);
        int measuredWidth5 = this.Xd.getMeasuredWidth();
        this.Xd.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.Xd.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.Xe.getMeasuredWidth();
        this.Xe.layout((i5 - measuredWidth6) >> 1, (this.WY.getTop() - this.Xe.getMeasuredHeight()) - this.Ww, (measuredWidth6 + i5) >> 1, (this.WY.getTop() + i2) - this.Ww);
        this.Xc.getLeft();
        this.Xc.getRight();
        int measuredWidth7 = this.Xa.getMeasuredWidth();
        int measuredHeight4 = this.Xa.getMeasuredHeight();
        int bottom3 = this.Xc.getBottom();
        this.Xa.layout((i5 - measuredWidth7) >> 1, this.Wt[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.Wt[3]);
        this.WW.set((i5 - this.WU.getIntrinsicWidth()) >> 1, this.Xd.getTop() - this.Wx, (i5 + this.WU.getIntrinsicHeight()) >> 1, (this.Xd.getTop() + this.WU.getIntrinsicHeight()) - this.Wx);
        this.WU.setBounds(this.WW);
        this.WX.set(this.Xd.getLeft() + (this.Wy >> 1) + this.Wz, this.Xd.getTop() + (this.Wy >> 1) + this.Wz, (this.Xd.getRight() - (this.Wy >> 1)) - this.Wz, (this.Xd.getBottom() - (this.Wy >> 1)) - this.Wz);
        if (this.Xm == null) {
            this.Xm = new SweepGradient(this.WX.centerX(), this.WX.centerY(), this.Xk, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.Xm.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.WX.centerX(), this.WX.centerY());
            this.Xm.setLocalMatrix(matrix);
            this.WV.setShader(this.Xm);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        f(canvas);
        super.dispatchDraw(canvas);
    }

    private void qS() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.VR == null) {
            this.VR = new com.baidu.tbadk.core.dialog.a(i.aK(getContext()).getPageActivity());
            this.VR.lz(getContext().getString(d.j.voice_restart_tip)).a(getContext().getString(d.j.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    VoiceRecordButton.this.rd();
                    if (VoiceRecordButton.this.getVoiceManager() != null && VoiceRecordButton.this.mModel != null) {
                        if (recorderManager != null) {
                            recorderManager.ct(VoiceRecordButton.this.mModel.voiceId);
                        }
                        VoiceRecordButton.this.mModel = null;
                    }
                }
            }).b(getContext().getString(d.j.cancel), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(i.aK(getContext()));
        }
        try {
            this.VR.aaW();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.mModel != null) {
                if (recorderManager != null) {
                    recorderManager.ct(this.mModel.voiceId);
                }
                this.mModel = null;
            }
        }
    }

    private void aW(Context context) {
        LayoutInflater.from(context).inflate(d.h.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.WZ = (TextView) findViewById(d.g.tip_error);
        al.d(this.WZ, d.C0277d.cp_btn_a, 1);
        this.Xa = (TextView) findViewById(d.g.tip_operator);
        this.Xb = (TextView) findViewById(d.g.tip_time_out);
        this.Xc = (VoiceButton) findViewById(d.g.voice_bnt);
        this.WY = (TextView) findViewById(d.g.restart);
        this.Xd = (ImageView) findViewById(d.g.play_img);
        this.Xe = (TextView) findViewById(d.g.play_time);
        this.Xe.setClickable(false);
        this.WY.setOnClickListener(this);
        this.Xd.setOnClickListener(this);
        this.Xc.setRecorderView(this);
        rd();
    }

    private void rc() {
        this.Xc.setVisibility(4);
        this.Xe.setVisibility(0);
        this.WY.setVisibility(0);
        al.d(this.Xe, d.C0277d.cp_cont_f, 1);
        al.d(this.WY, d.C0277d.cp_cont_f, 1);
        al.k(this.WY, d.f.but_posts_record_again_selector);
        this.Xd.setVisibility(0);
        if (this.mModel != null) {
            this.Xe.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.Xd.setContentDescription(String.format(getContext().getString(d.j.listen_time), Integer.valueOf(this.mModel.duration)));
            al.c(this.Xd, d.f.but_posts_record_play_selector);
        }
        al.d(this.Xa, d.C0277d.cp_cont_c, 1);
        this.Xa.setText(getContext().getString(d.j.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rd() {
        al.c(this.Xc, d.f.but_posts_record_zero_selector);
        this.Xc.setVisibility(0);
        this.WA = 0;
        this.Xd.setVisibility(4);
        this.Xe.setVisibility(4);
        this.WY.setVisibility(4);
        this.Xb.setVisibility(4);
        al.d(this.Xa, d.C0277d.cp_cont_c, 1);
        this.Xa.setText(getContext().getString(d.j.voice_record_press_to_record));
    }

    public void reset() {
        rd();
        this.mModel = null;
        this.WA = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.WZ.setText("");
        this.WZ.setVisibility(4);
        this.WA = 0;
        rc();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            rd();
            this.Xa.setText(getContext().getString(d.j.voice_record_release_to_stop));
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
        if (this.Xd != null && this.Xe != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    al.d(this.Xe, d.C0277d.cp_cont_f, 1);
                    this.Xe.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    al.c(this.Xd, d.f.but_posts_record_play_selector);
                    this.Xd.setContentDescription(String.format(getContext().getString(d.j.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.Xa.setText(getContext().getString(d.j.voice_play_tip));
                    rf();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    al.d(this.Xe, d.C0277d.cp_cont_f, 1);
                    al.c(this.Xd, d.f.but_posts_record_stop_selector);
                    this.Xd.setContentDescription(getContext().getString(d.j.pause_load));
                    this.Xa.setText(getContext().getString(d.j.voice_stop_tip));
                    re();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        al.d(this.Xb, d.C0277d.cp_btn_a, 1);
        al.d(this.WZ, d.C0277d.cp_btn_a, 1);
        al.d(this.Xa, d.C0277d.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.Xb.setVisibility(0);
                this.Xb.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.Xb != null) {
                            VoiceRecordButton.this.Xb.setVisibility(4);
                            VoiceRecordButton.this.Xb.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 2) {
                this.WZ.setVisibility(0);
                this.WZ.setText(str);
                this.Xa.setText(d.j.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.WZ != null) {
                            VoiceRecordButton.this.WZ.setVisibility(4);
                            VoiceRecordButton.this.WZ.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 5) {
                this.WZ.setVisibility(0);
                this.WZ.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.WZ != null) {
                            VoiceRecordButton.this.WZ.setVisibility(4);
                            VoiceRecordButton.this.WZ.setText("");
                        }
                    }
                }, 2000L);
            } else {
                rd();
                this.WZ.setVisibility(0);
                this.WZ.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.WZ != null) {
                            VoiceRecordButton.this.WZ.setVisibility(4);
                            VoiceRecordButton.this.WZ.setText("");
                        }
                    }
                }, 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.WZ.setVisibility(4);
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
        al.d(this.WZ, d.C0277d.cp_btn_a, 1);
        this.WZ.setVisibility(0);
        this.WZ.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.VG = Math.max(i, this.VG);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.VH > 200) {
            this.VG = 0;
            this.VH = uptimeMillis;
        }
        if (this.VG < 10) {
            this.WA = 1;
            invalidate();
        } else if (this.VG < 20) {
            this.WA = 2;
            invalidate();
        } else if (this.VG < 30) {
            this.WA = 3;
            invalidate();
        } else if (this.VG < 40) {
            this.WA = 4;
            invalidate();
        } else {
            this.WA = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bs(int i) {
        if (this.mModel != null && this.Xe != null) {
            int i2 = i / 1000;
            if (this.Xn != i2) {
                this.Xe.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.Xn = i2;
        }
    }

    private void re() {
        if (this.mModel != null) {
            this.WA = 0;
            this.Xf = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.Xi = SystemClock.uptimeMillis();
            this.Xj = this.Xi + 200;
            this.Xl.sendEmptyMessageAtTime(1, this.Xj);
            invalidate();
        }
    }

    private void rf() {
        this.WA = 0;
        this.WB = 0;
        this.Xf = 0.0f;
        this.Xg = 0.0f;
        this.Xl.removeMessages(1);
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
                qS();
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
        this.Xh = fVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void rg() {
    }

    public void rh() {
        this.WI = new Paint();
        this.WI.setAntiAlias(true);
        this.WI.setStyle(Paint.Style.STROKE);
        this.WI.setStrokeWidth(2.0f);
        this.WJ = new Paint();
        this.WJ.setAntiAlias(true);
        this.WJ.setStyle(Paint.Style.STROKE);
        this.WJ.setStrokeWidth(2.0f);
        this.WK = new Paint();
        this.WK.setAntiAlias(true);
        this.WK.setStyle(Paint.Style.STROKE);
        this.WK.setStrokeWidth(2.0f);
        this.WL = new Paint();
        this.WL.setAntiAlias(true);
        this.WL.setStyle(Paint.Style.STROKE);
        this.WL.setStrokeWidth(2.0f);
    }

    public void f(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.WI.setColor(this.WQ);
            this.WJ.setColor(this.WR);
            this.WK.setColor(this.WS);
            this.WL.setColor(this.WT);
        } else {
            this.WI.setColor(this.WM);
            this.WJ.setColor(this.WN);
            this.WK.setColor(this.WO);
            this.WL.setColor(this.WP);
        }
        if (this.WA == 2) {
            canvas.drawCircle(this.centerX, this.centerY, this.WC, this.WI);
        } else if (this.WA == 3) {
            canvas.drawCircle(this.centerX, this.centerY, this.WC, this.WI);
            canvas.drawCircle(this.centerX, this.centerY, this.WD, this.WJ);
        } else if (this.WA == 4) {
            canvas.drawCircle(this.centerX, this.centerY, this.WC, this.WI);
            canvas.drawCircle(this.centerX, this.centerY, this.WD, this.WJ);
            canvas.drawCircle(this.centerX, this.centerY, this.WE, this.WK);
        } else if (this.WA == 5) {
            canvas.drawCircle(this.centerX, this.centerY, this.WC, this.WI);
            canvas.drawCircle(this.centerX, this.centerY, this.WD, this.WJ);
            canvas.drawCircle(this.centerX, this.centerY, this.WE, this.WK);
            canvas.drawCircle(this.centerX, this.centerY, this.WF, this.WL);
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
                    rc();
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
    public void qT() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.VP;
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
        if (this.VO != null) {
            this.VO.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.VO = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.VP = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
    }
}
