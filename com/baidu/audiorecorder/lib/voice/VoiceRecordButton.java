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
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.voice.VoiceButton;
/* loaded from: classes9.dex */
public class VoiceRecordButton extends ViewGroup implements View.OnClickListener, com.baidu.adp.lib.voice.f, VoiceManager.b, m {
    private final int[] FY;
    private int FZ;
    private int Fn;
    private long Fo;
    private EditorTools Fv;
    private int Fw;
    private com.baidu.tbadk.core.dialog.a Fy;
    private int GA;
    private final BitmapDrawable GC;
    private final Paint GD;
    private final Rect GE;
    private final RectF GF;
    private TextView GG;
    private TextView GH;
    private TextView GI;
    private TextView GJ;
    private VoiceButton GK;
    private ImageView GL;
    private TextView GM;
    private float GN;
    private float GO;
    private f GP;
    private long GQ;
    private long GR;
    private final int[] GU;
    private final a GV;
    private SweepGradient GW;
    private int GX;
    private final int Ga;
    private final int Gb;
    private final int Gc;
    private final int Gd;
    private final int Ge;
    private int Gf;
    private int Gg;
    private int Gh;
    private int Gi;
    private int Gj;
    private int Gk;
    private int Gl;
    private int Gm;
    private int Gn;
    private int Go;
    private Paint Gp;
    private Paint Gq;
    private Paint Gr;
    private Paint Gs;
    private int Gt;
    private int Gu;
    private int Gv;
    private int Gw;
    private int Gx;
    private int Gy;
    private int Gz;
    VoiceData.VoiceModel mModel;
    private int mPaddingTop;

    static /* synthetic */ int e(VoiceRecordButton voiceRecordButton) {
        int i = voiceRecordButton.Gg;
        voiceRecordButton.Gg = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends Handler {
        private a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                if (VoiceRecordButton.this.GO >= 360.0f) {
                    VoiceRecordButton.this.GO = 360.0f;
                    VoiceRecordButton.this.Gg = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    VoiceRecordButton.this.GQ = uptimeMillis;
                    VoiceRecordButton.this.GR = uptimeMillis + 200;
                    VoiceRecordButton.this.GO += (((float) (uptimeMillis - VoiceRecordButton.this.GQ)) / 1000.0f) * VoiceRecordButton.this.GN;
                    sendEmptyMessageAtTime(1, VoiceRecordButton.this.GR);
                    VoiceRecordButton.e(VoiceRecordButton.this);
                }
                VoiceRecordButton.this.Gf = VoiceRecordButton.this.Gg % 6;
                VoiceRecordButton.this.invalidate();
            }
        }
    }

    public static VoiceRecordButton ae(Context context) {
        return new VoiceRecordButton(context);
    }

    public VoiceRecordButton(Context context) {
        this(context, null);
    }

    public VoiceRecordButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Fo = 0L;
        this.FY = new int[4];
        this.Gf = 0;
        this.Gg = 0;
        this.Gh = 0;
        this.Gi = 0;
        this.Gj = 0;
        this.Gk = 0;
        this.Gl = 0;
        this.Gm = 0;
        this.Gn = 0;
        this.Go = 0;
        this.Gt = -1724676609;
        this.Gu = 1546880511;
        this.Gv = 674465279;
        this.Gw = 255034879;
        this.Gx = -1725669966;
        this.Gy = 1545887154;
        this.Gz = 673471922;
        this.GA = 254041522;
        this.GD = new Paint(1);
        this.GE = new Rect();
        this.GF = new RectF();
        this.Fw = 0;
        this.GU = new int[2];
        this.GV = new a();
        this.Fn = 0;
        this.GX = 0;
        this.FY[0] = context.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.FY[1] = context.getResources().getDimensionPixelSize(R.dimen.ds8);
        this.FY[2] = context.getResources().getDimensionPixelSize(R.dimen.ds22);
        this.FY[3] = context.getResources().getDimensionPixelSize(R.dimen.ds36);
        this.Gj = context.getResources().getDimensionPixelSize(R.dimen.ds134);
        this.Gk = this.Gj + context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.Gl = this.Gk + context.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.Gm = this.Gl + context.getResources().getDimensionPixelSize(R.dimen.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.Gn = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.Go = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.Gn = context.getResources().getDimensionPixelSize(R.dimen.ds70);
            this.Go = context.getResources().getDimensionPixelSize(R.dimen.ds210);
        }
        this.mPaddingTop = context.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.FZ = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.Ga = context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.Gb = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.Gc = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.Gd = context.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.Ge = context.getResources().getDimensionPixelSize(R.dimen.ds2);
        this.GD.setStyle(Paint.Style.STROKE);
        this.GD.setStrokeWidth(this.Gd);
        this.GC = (BitmapDrawable) getResources().getDrawable(R.drawable.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        af(context);
        lJ();
        this.GU[0] = am.getColor(R.color.common_color_10151);
        this.GU[1] = am.getColor(R.color.common_color_10152);
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
        this.mPaddingTop = ((i4 - getContext().getResources().getDimensionPixelSize(R.dimen.ds460)) / 2) + getContext().getResources().getDimensionPixelSize(R.dimen.ds6);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int measuredWidth = this.GK.getMeasuredWidth();
        int measuredHeight = this.GK.getMeasuredHeight();
        int measuredWidth2 = this.GH.getMeasuredWidth();
        this.GH.layout((i5 - measuredWidth2) >> 1, this.mPaddingTop + i2, (measuredWidth2 + i5) >> 1, this.GH.getMeasuredHeight() + this.mPaddingTop + i2);
        int bottom = this.GH.getBottom();
        this.GK.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.Gh = (measuredWidth / 2) + i6;
        this.Gi = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.GJ.getMeasuredWidth();
        int measuredHeight2 = this.GJ.getMeasuredHeight();
        int top = this.GK.getTop();
        this.GJ.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.GG.getMeasuredWidth();
        int measuredHeight3 = this.GG.getMeasuredHeight();
        int right = this.GK.getRight() - this.FZ;
        int bottom2 = this.GK.getBottom() - this.Ga;
        this.GG.layout(this.Gn + i6, this.Go + bottom, measuredWidth4 + i6 + this.Gn, measuredHeight3 + this.Go + bottom);
        int measuredWidth5 = this.GL.getMeasuredWidth();
        this.GL.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.GL.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.GM.getMeasuredWidth();
        this.GM.layout((i5 - measuredWidth6) >> 1, (this.GG.getTop() - this.GM.getMeasuredHeight()) - this.Gb, (measuredWidth6 + i5) >> 1, (this.GG.getTop() + i2) - this.Gb);
        this.GK.getLeft();
        this.GK.getRight();
        int measuredWidth7 = this.GI.getMeasuredWidth();
        int measuredHeight4 = this.GI.getMeasuredHeight();
        int bottom3 = this.GK.getBottom();
        this.GI.layout((i5 - measuredWidth7) >> 1, this.FY[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.FY[3]);
        this.GE.set((i5 - this.GC.getIntrinsicWidth()) >> 1, this.GL.getTop() - this.Gc, (i5 + this.GC.getIntrinsicHeight()) >> 1, (this.GL.getTop() + this.GC.getIntrinsicHeight()) - this.Gc);
        this.GC.setBounds(this.GE);
        this.GF.set(this.GL.getLeft() + (this.Gd >> 1) + this.Ge, this.GL.getTop() + (this.Gd >> 1) + this.Ge, (this.GL.getRight() - (this.Gd >> 1)) - this.Ge, (this.GL.getBottom() - (this.Gd >> 1)) - this.Ge);
        if (this.GW == null) {
            this.GW = new SweepGradient(this.GF.centerX(), this.GF.centerY(), this.GU, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.GW.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.GF.centerX(), this.GF.centerY());
            this.GW.setLocalMatrix(matrix);
            this.GD.setShader(this.GW);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        f(canvas);
        super.dispatchDraw(canvas);
    }

    private void lw() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.Fy == null) {
            this.Fy = new com.baidu.tbadk.core.dialog.a(i.ab(getContext()).getPageActivity());
            this.Fy.sC(getContext().getString(R.string.voice_restart_tip)).a(getContext().getString(R.string.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    VoiceRecordButton.this.lG();
                    if (VoiceRecordButton.this.getVoiceManager() != null && VoiceRecordButton.this.mModel != null) {
                        if (recorderManager != null) {
                            recorderManager.bx(VoiceRecordButton.this.mModel.voiceId);
                        }
                        VoiceRecordButton.this.mModel = null;
                    }
                }
            }).b(getContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(i.ab(getContext()));
        }
        try {
            this.Fy.aCp();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.mModel != null) {
                if (recorderManager != null) {
                    recorderManager.bx(this.mModel.voiceId);
                }
                this.mModel = null;
            }
        }
    }

    private void af(Context context) {
        LayoutInflater.from(context).inflate(R.layout.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.GH = (TextView) findViewById(R.id.tip_error);
        am.setViewTextColor(this.GH, R.color.cp_cont_a, 1);
        this.GI = (TextView) findViewById(R.id.tip_operator);
        this.GJ = (TextView) findViewById(R.id.tip_time_out);
        this.GK = (VoiceButton) findViewById(R.id.voice_bnt);
        this.GG = (TextView) findViewById(R.id.restart);
        this.GL = (ImageView) findViewById(R.id.play_img);
        this.GM = (TextView) findViewById(R.id.play_time);
        this.GM.setClickable(false);
        this.GG.setOnClickListener(this);
        this.GL.setOnClickListener(this);
        this.GK.setRecorderView(this);
        lG();
    }

    private void lF() {
        this.GK.setVisibility(4);
        this.GM.setVisibility(0);
        this.GG.setVisibility(0);
        am.setViewTextColor(this.GM, R.color.cp_cont_f, 1);
        am.setViewTextColor(this.GG, R.color.cp_cont_f, 1);
        am.setBackgroundResource(this.GG, R.drawable.but_posts_record_again_selector);
        this.GL.setVisibility(0);
        if (this.mModel != null) {
            this.GM.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.GL.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(this.mModel.duration)));
            am.setImageResource(this.GL, R.drawable.but_posts_record_play_selector);
        }
        am.setViewTextColor(this.GI, R.color.cp_cont_c, 1);
        this.GI.setText(getContext().getString(R.string.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lG() {
        am.setImageResource(this.GK, R.drawable.but_posts_record_zero_selector);
        this.GK.setVisibility(0);
        this.Gf = 0;
        this.GL.setVisibility(4);
        this.GM.setVisibility(4);
        this.GG.setVisibility(4);
        this.GJ.setVisibility(4);
        am.setViewTextColor(this.GI, R.color.cp_cont_c, 1);
        this.GI.setText(getContext().getString(R.string.voice_record_press_to_record));
    }

    public void reset() {
        lG();
        this.mModel = null;
        this.Gf = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.GH.setText("");
        this.GH.setVisibility(4);
        this.Gf = 0;
        lF();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, HanziToPinyin.Token.SEPARATOR));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            lG();
            this.GI.setText(getContext().getString(R.string.voice_record_release_to_stop));
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
        if (this.GL != null && this.GM != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    am.setViewTextColor(this.GM, R.color.cp_cont_f, 1);
                    this.GM.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    am.setImageResource(this.GL, R.drawable.but_posts_record_play_selector);
                    this.GL.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.GI.setText(getContext().getString(R.string.voice_play_tip));
                    stopProgress();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    am.setViewTextColor(this.GM, R.color.cp_cont_f, 1);
                    am.setImageResource(this.GL, R.drawable.but_posts_record_stop_selector);
                    this.GL.setContentDescription(getContext().getString(R.string.pause_load));
                    this.GI.setText(getContext().getString(R.string.voice_stop_tip));
                    lH();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        am.setViewTextColor(this.GJ, R.color.cp_cont_a, 1);
        am.setViewTextColor(this.GH, R.color.cp_cont_a, 1);
        am.setViewTextColor(this.GI, R.color.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.GJ.setVisibility(0);
                this.GJ.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.GJ != null) {
                            VoiceRecordButton.this.GJ.setVisibility(4);
                            VoiceRecordButton.this.GJ.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 2) {
                this.GH.setVisibility(0);
                this.GH.setText(str);
                this.GI.setText(R.string.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.GH != null) {
                            VoiceRecordButton.this.GH.setVisibility(4);
                            VoiceRecordButton.this.GH.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 5) {
                this.GH.setVisibility(0);
                this.GH.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.GH != null) {
                            VoiceRecordButton.this.GH.setVisibility(4);
                            VoiceRecordButton.this.GH.setText("");
                        }
                    }
                }, 2000L);
            } else {
                lG();
                this.GH.setVisibility(0);
                this.GH.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.GH != null) {
                            VoiceRecordButton.this.GH.setVisibility(4);
                            VoiceRecordButton.this.GH.setText("");
                        }
                    }
                }, 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.GH.setVisibility(4);
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
        am.setViewTextColor(this.GH, R.color.cp_cont_a, 1);
        this.GH.setVisibility(0);
        this.GH.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.Fn = Math.max(i, this.Fn);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.Fo > 200) {
            this.Fn = 0;
            this.Fo = uptimeMillis;
        }
        if (this.Fn < 10) {
            this.Gf = 1;
            invalidate();
        } else if (this.Fn < 20) {
            this.Gf = 2;
            invalidate();
        } else if (this.Fn < 30) {
            this.Gf = 3;
            invalidate();
        } else if (this.Fn < 40) {
            this.Gf = 4;
            invalidate();
        } else {
            this.Gf = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aD(int i) {
        if (this.mModel != null && this.GM != null) {
            int i2 = i / 1000;
            if (this.GX != i2) {
                this.GM.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.GX = i2;
        }
    }

    private void lH() {
        if (this.mModel != null) {
            this.Gf = 0;
            this.GN = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.GQ = SystemClock.uptimeMillis();
            this.GR = this.GQ + 200;
            this.GV.sendEmptyMessageAtTime(1, this.GR);
            invalidate();
        }
    }

    private void stopProgress() {
        this.Gf = 0;
        this.Gg = 0;
        this.GN = 0.0f;
        this.GO = 0.0f;
        this.GV.removeMessages(1);
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
            if (id == R.id.restart) {
                voiceManager.stopPlay();
                lw();
            } else if (id == R.id.play_img && this.mModel != null) {
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
        this.GP = fVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lI() {
    }

    public void lJ() {
        this.Gp = new Paint();
        this.Gp.setAntiAlias(true);
        this.Gp.setStyle(Paint.Style.STROKE);
        this.Gp.setStrokeWidth(2.0f);
        this.Gq = new Paint();
        this.Gq.setAntiAlias(true);
        this.Gq.setStyle(Paint.Style.STROKE);
        this.Gq.setStrokeWidth(2.0f);
        this.Gr = new Paint();
        this.Gr.setAntiAlias(true);
        this.Gr.setStyle(Paint.Style.STROKE);
        this.Gr.setStrokeWidth(2.0f);
        this.Gs = new Paint();
        this.Gs.setAntiAlias(true);
        this.Gs.setStyle(Paint.Style.STROKE);
        this.Gs.setStrokeWidth(2.0f);
    }

    public void f(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.Gp.setColor(this.Gx);
            this.Gq.setColor(this.Gy);
            this.Gr.setColor(this.Gz);
            this.Gs.setColor(this.GA);
        } else {
            this.Gp.setColor(this.Gt);
            this.Gq.setColor(this.Gu);
            this.Gr.setColor(this.Gv);
            this.Gs.setColor(this.Gw);
        }
        if (this.Gf == 2) {
            canvas.drawCircle(this.Gh, this.Gi, this.Gj, this.Gp);
        } else if (this.Gf == 3) {
            canvas.drawCircle(this.Gh, this.Gi, this.Gj, this.Gp);
            canvas.drawCircle(this.Gh, this.Gi, this.Gk, this.Gq);
        } else if (this.Gf == 4) {
            canvas.drawCircle(this.Gh, this.Gi, this.Gj, this.Gp);
            canvas.drawCircle(this.Gh, this.Gi, this.Gk, this.Gq);
            canvas.drawCircle(this.Gh, this.Gi, this.Gl, this.Gr);
        } else if (this.Gf == 5) {
            canvas.drawCircle(this.Gh, this.Gi, this.Gj, this.Gp);
            canvas.drawCircle(this.Gh, this.Gi, this.Gk, this.Gq);
            canvas.drawCircle(this.Gh, this.Gi, this.Gl, this.Gr);
            canvas.drawCircle(this.Gh, this.Gi, this.Gm, this.Gs);
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
                    lF();
                    b((VoiceData.VoiceModel) aVar.data);
                    this.mModel = (VoiceData.VoiceModel) aVar.data;
                    return;
                }
                reset();
                b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void display() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.Fw;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Fv != null) {
            this.Fv.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.Fv = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.Fw = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
    }
}
