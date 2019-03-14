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
    private int VF;
    private long VG;
    private EditorTools VN;
    private int VO;
    private com.baidu.tbadk.core.dialog.a VQ;
    private int WA;
    private int WB;
    private int WC;
    private int WD;
    private int WE;
    private int WF;
    private int WG;
    private Paint WH;
    private Paint WI;
    private Paint WJ;
    private Paint WK;
    private int WL;
    private int WM;
    private int WN;
    private int WO;
    private int WP;
    private int WQ;
    private int WR;
    private int WS;
    private final BitmapDrawable WT;
    private final Paint WU;
    private final Rect WV;
    private final RectF WW;
    private TextView WX;
    private TextView WY;
    private TextView WZ;
    private final int[] Ws;
    private int Wt;
    private final int Wu;
    private final int Wv;
    private final int Ww;
    private final int Wx;
    private final int Wy;
    private int Wz;
    private TextView Xa;
    private VoiceButton Xb;
    private ImageView Xc;
    private TextView Xd;
    private float Xe;
    private float Xf;
    private f Xg;
    private long Xh;
    private long Xi;
    private final int[] Xj;
    private final a Xk;
    private SweepGradient Xl;
    private int Xm;
    private int centerX;
    private int centerY;
    VoiceData.VoiceModel mModel;
    private int mPaddingTop;

    static /* synthetic */ int e(VoiceRecordButton voiceRecordButton) {
        int i = voiceRecordButton.WA;
        voiceRecordButton.WA = i + 1;
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
                if (VoiceRecordButton.this.Xf >= 360.0f) {
                    VoiceRecordButton.this.Xf = 360.0f;
                    VoiceRecordButton.this.WA = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    VoiceRecordButton.this.Xh = uptimeMillis;
                    VoiceRecordButton.this.Xi = uptimeMillis + 200;
                    VoiceRecordButton.this.Xf += (((float) (uptimeMillis - VoiceRecordButton.this.Xh)) / 1000.0f) * VoiceRecordButton.this.Xe;
                    sendEmptyMessageAtTime(1, VoiceRecordButton.this.Xi);
                    VoiceRecordButton.e(VoiceRecordButton.this);
                }
                VoiceRecordButton.this.Wz = VoiceRecordButton.this.WA % 6;
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
        this.VG = 0L;
        this.Ws = new int[4];
        this.Wz = 0;
        this.WA = 0;
        this.centerX = 0;
        this.centerY = 0;
        this.WB = 0;
        this.WC = 0;
        this.WD = 0;
        this.WE = 0;
        this.WF = 0;
        this.WG = 0;
        this.WL = -1724676609;
        this.WM = 1546880511;
        this.WN = 674465279;
        this.WO = 255034879;
        this.WP = -1725669966;
        this.WQ = 1545887154;
        this.WR = 673471922;
        this.WS = 254041522;
        this.WU = new Paint(1);
        this.WV = new Rect();
        this.WW = new RectF();
        this.VO = 0;
        this.Xj = new int[2];
        this.Xk = new a();
        this.VF = 0;
        this.Xm = 0;
        this.Ws[0] = context.getResources().getDimensionPixelSize(d.e.ds24);
        this.Ws[1] = context.getResources().getDimensionPixelSize(d.e.ds8);
        this.Ws[2] = context.getResources().getDimensionPixelSize(d.e.ds22);
        this.Ws[3] = context.getResources().getDimensionPixelSize(d.e.ds36);
        this.WB = context.getResources().getDimensionPixelSize(d.e.ds134);
        this.WC = this.WB + context.getResources().getDimensionPixelSize(d.e.ds14);
        this.WD = this.WC + context.getResources().getDimensionPixelSize(d.e.ds16);
        this.WE = this.WD + context.getResources().getDimensionPixelSize(d.e.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.WF = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.WG = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.WF = context.getResources().getDimensionPixelSize(d.e.ds70);
            this.WG = context.getResources().getDimensionPixelSize(d.e.ds210);
        }
        this.mPaddingTop = context.getResources().getDimensionPixelSize(d.e.ds26);
        this.Wt = context.getResources().getDimensionPixelSize(d.e.ds10);
        this.Wu = context.getResources().getDimensionPixelSize(d.e.ds14);
        this.Wv = context.getResources().getDimensionPixelSize(d.e.ds4);
        this.Ww = context.getResources().getDimensionPixelSize(d.e.ds4);
        this.Wx = context.getResources().getDimensionPixelSize(d.e.ds12);
        this.Wy = context.getResources().getDimensionPixelSize(d.e.ds2);
        this.WU.setStyle(Paint.Style.STROKE);
        this.WU.setStrokeWidth(this.Wx);
        this.WT = (BitmapDrawable) getResources().getDrawable(d.f.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        aW(context);
        rh();
        this.Xj[0] = al.getColor(d.C0277d.common_color_10151);
        this.Xj[1] = al.getColor(d.C0277d.common_color_10152);
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
        int measuredWidth = this.Xb.getMeasuredWidth();
        int measuredHeight = this.Xb.getMeasuredHeight();
        int measuredWidth2 = this.WY.getMeasuredWidth();
        this.WY.layout((i5 - measuredWidth2) >> 1, this.mPaddingTop + i2, (measuredWidth2 + i5) >> 1, this.WY.getMeasuredHeight() + this.mPaddingTop + i2);
        int bottom = this.WY.getBottom();
        this.Xb.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.centerX = (measuredWidth / 2) + i6;
        this.centerY = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.Xa.getMeasuredWidth();
        int measuredHeight2 = this.Xa.getMeasuredHeight();
        int top = this.Xb.getTop();
        this.Xa.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.WX.getMeasuredWidth();
        int measuredHeight3 = this.WX.getMeasuredHeight();
        int right = this.Xb.getRight() - this.Wt;
        int bottom2 = this.Xb.getBottom() - this.Wu;
        this.WX.layout(this.WF + i6, this.WG + bottom, measuredWidth4 + i6 + this.WF, measuredHeight3 + this.WG + bottom);
        int measuredWidth5 = this.Xc.getMeasuredWidth();
        this.Xc.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.Xc.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.Xd.getMeasuredWidth();
        this.Xd.layout((i5 - measuredWidth6) >> 1, (this.WX.getTop() - this.Xd.getMeasuredHeight()) - this.Wv, (measuredWidth6 + i5) >> 1, (this.WX.getTop() + i2) - this.Wv);
        this.Xb.getLeft();
        this.Xb.getRight();
        int measuredWidth7 = this.WZ.getMeasuredWidth();
        int measuredHeight4 = this.WZ.getMeasuredHeight();
        int bottom3 = this.Xb.getBottom();
        this.WZ.layout((i5 - measuredWidth7) >> 1, this.Ws[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.Ws[3]);
        this.WV.set((i5 - this.WT.getIntrinsicWidth()) >> 1, this.Xc.getTop() - this.Ww, (i5 + this.WT.getIntrinsicHeight()) >> 1, (this.Xc.getTop() + this.WT.getIntrinsicHeight()) - this.Ww);
        this.WT.setBounds(this.WV);
        this.WW.set(this.Xc.getLeft() + (this.Wx >> 1) + this.Wy, this.Xc.getTop() + (this.Wx >> 1) + this.Wy, (this.Xc.getRight() - (this.Wx >> 1)) - this.Wy, (this.Xc.getBottom() - (this.Wx >> 1)) - this.Wy);
        if (this.Xl == null) {
            this.Xl = new SweepGradient(this.WW.centerX(), this.WW.centerY(), this.Xj, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.Xl.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.WW.centerX(), this.WW.centerY());
            this.Xl.setLocalMatrix(matrix);
            this.WU.setShader(this.Xl);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        f(canvas);
        super.dispatchDraw(canvas);
    }

    private void qS() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.VQ == null) {
            this.VQ = new com.baidu.tbadk.core.dialog.a(i.aK(getContext()).getPageActivity());
            this.VQ.ly(getContext().getString(d.j.voice_restart_tip)).a(getContext().getString(d.j.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.2
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
            this.VQ.aaZ();
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
        this.WY = (TextView) findViewById(d.g.tip_error);
        al.d(this.WY, d.C0277d.cp_btn_a, 1);
        this.WZ = (TextView) findViewById(d.g.tip_operator);
        this.Xa = (TextView) findViewById(d.g.tip_time_out);
        this.Xb = (VoiceButton) findViewById(d.g.voice_bnt);
        this.WX = (TextView) findViewById(d.g.restart);
        this.Xc = (ImageView) findViewById(d.g.play_img);
        this.Xd = (TextView) findViewById(d.g.play_time);
        this.Xd.setClickable(false);
        this.WX.setOnClickListener(this);
        this.Xc.setOnClickListener(this);
        this.Xb.setRecorderView(this);
        rd();
    }

    private void rc() {
        this.Xb.setVisibility(4);
        this.Xd.setVisibility(0);
        this.WX.setVisibility(0);
        al.d(this.Xd, d.C0277d.cp_cont_f, 1);
        al.d(this.WX, d.C0277d.cp_cont_f, 1);
        al.k(this.WX, d.f.but_posts_record_again_selector);
        this.Xc.setVisibility(0);
        if (this.mModel != null) {
            this.Xd.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.Xc.setContentDescription(String.format(getContext().getString(d.j.listen_time), Integer.valueOf(this.mModel.duration)));
            al.c(this.Xc, d.f.but_posts_record_play_selector);
        }
        al.d(this.WZ, d.C0277d.cp_cont_c, 1);
        this.WZ.setText(getContext().getString(d.j.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rd() {
        al.c(this.Xb, d.f.but_posts_record_zero_selector);
        this.Xb.setVisibility(0);
        this.Wz = 0;
        this.Xc.setVisibility(4);
        this.Xd.setVisibility(4);
        this.WX.setVisibility(4);
        this.Xa.setVisibility(4);
        al.d(this.WZ, d.C0277d.cp_cont_c, 1);
        this.WZ.setText(getContext().getString(d.j.voice_record_press_to_record));
    }

    public void reset() {
        rd();
        this.mModel = null;
        this.Wz = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.WY.setText("");
        this.WY.setVisibility(4);
        this.Wz = 0;
        rc();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            rd();
            this.WZ.setText(getContext().getString(d.j.voice_record_release_to_stop));
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
        if (this.Xc != null && this.Xd != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    al.d(this.Xd, d.C0277d.cp_cont_f, 1);
                    this.Xd.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    al.c(this.Xc, d.f.but_posts_record_play_selector);
                    this.Xc.setContentDescription(String.format(getContext().getString(d.j.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.WZ.setText(getContext().getString(d.j.voice_play_tip));
                    rf();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    al.d(this.Xd, d.C0277d.cp_cont_f, 1);
                    al.c(this.Xc, d.f.but_posts_record_stop_selector);
                    this.Xc.setContentDescription(getContext().getString(d.j.pause_load));
                    this.WZ.setText(getContext().getString(d.j.voice_stop_tip));
                    re();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        al.d(this.Xa, d.C0277d.cp_btn_a, 1);
        al.d(this.WY, d.C0277d.cp_btn_a, 1);
        al.d(this.WZ, d.C0277d.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.Xa.setVisibility(0);
                this.Xa.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.Xa != null) {
                            VoiceRecordButton.this.Xa.setVisibility(4);
                            VoiceRecordButton.this.Xa.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 2) {
                this.WY.setVisibility(0);
                this.WY.setText(str);
                this.WZ.setText(d.j.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.WY != null) {
                            VoiceRecordButton.this.WY.setVisibility(4);
                            VoiceRecordButton.this.WY.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 5) {
                this.WY.setVisibility(0);
                this.WY.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.WY != null) {
                            VoiceRecordButton.this.WY.setVisibility(4);
                            VoiceRecordButton.this.WY.setText("");
                        }
                    }
                }, 2000L);
            } else {
                rd();
                this.WY.setVisibility(0);
                this.WY.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.WY != null) {
                            VoiceRecordButton.this.WY.setVisibility(4);
                            VoiceRecordButton.this.WY.setText("");
                        }
                    }
                }, 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.WY.setVisibility(4);
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
        al.d(this.WY, d.C0277d.cp_btn_a, 1);
        this.WY.setVisibility(0);
        this.WY.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.VF = Math.max(i, this.VF);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.VG > 200) {
            this.VF = 0;
            this.VG = uptimeMillis;
        }
        if (this.VF < 10) {
            this.Wz = 1;
            invalidate();
        } else if (this.VF < 20) {
            this.Wz = 2;
            invalidate();
        } else if (this.VF < 30) {
            this.Wz = 3;
            invalidate();
        } else if (this.VF < 40) {
            this.Wz = 4;
            invalidate();
        } else {
            this.Wz = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bt(int i) {
        if (this.mModel != null && this.Xd != null) {
            int i2 = i / 1000;
            if (this.Xm != i2) {
                this.Xd.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.Xm = i2;
        }
    }

    private void re() {
        if (this.mModel != null) {
            this.Wz = 0;
            this.Xe = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.Xh = SystemClock.uptimeMillis();
            this.Xi = this.Xh + 200;
            this.Xk.sendEmptyMessageAtTime(1, this.Xi);
            invalidate();
        }
    }

    private void rf() {
        this.Wz = 0;
        this.WA = 0;
        this.Xe = 0.0f;
        this.Xf = 0.0f;
        this.Xk.removeMessages(1);
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
        this.Xg = fVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void rg() {
    }

    public void rh() {
        this.WH = new Paint();
        this.WH.setAntiAlias(true);
        this.WH.setStyle(Paint.Style.STROKE);
        this.WH.setStrokeWidth(2.0f);
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
    }

    public void f(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.WH.setColor(this.WP);
            this.WI.setColor(this.WQ);
            this.WJ.setColor(this.WR);
            this.WK.setColor(this.WS);
        } else {
            this.WH.setColor(this.WL);
            this.WI.setColor(this.WM);
            this.WJ.setColor(this.WN);
            this.WK.setColor(this.WO);
        }
        if (this.Wz == 2) {
            canvas.drawCircle(this.centerX, this.centerY, this.WB, this.WH);
        } else if (this.Wz == 3) {
            canvas.drawCircle(this.centerX, this.centerY, this.WB, this.WH);
            canvas.drawCircle(this.centerX, this.centerY, this.WC, this.WI);
        } else if (this.Wz == 4) {
            canvas.drawCircle(this.centerX, this.centerY, this.WB, this.WH);
            canvas.drawCircle(this.centerX, this.centerY, this.WC, this.WI);
            canvas.drawCircle(this.centerX, this.centerY, this.WD, this.WJ);
        } else if (this.Wz == 5) {
            canvas.drawCircle(this.centerX, this.centerY, this.WB, this.WH);
            canvas.drawCircle(this.centerX, this.centerY, this.WC, this.WI);
            canvas.drawCircle(this.centerX, this.centerY, this.WD, this.WJ);
            canvas.drawCircle(this.centerX, this.centerY, this.WE, this.WK);
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
        return this.VO;
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
        if (this.VN != null) {
            this.VN.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.VN = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.VO = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
    }
}
