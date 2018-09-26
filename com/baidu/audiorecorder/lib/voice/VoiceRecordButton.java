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
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.voice.VoiceButton;
/* loaded from: classes3.dex */
public class VoiceRecordButton extends ViewGroup implements View.OnClickListener, com.baidu.adp.lib.voice.f, VoiceManager.b, l {
    private EditorTools SG;
    private int SH;
    private com.baidu.tbadk.core.dialog.a SK;
    private int Sy;
    private long Sz;
    private int TA;
    private int TB;
    private int TC;
    private Paint TD;
    private Paint TE;
    private Paint TF;
    private Paint TG;
    private int TH;
    private int TI;
    private int TJ;
    private int TK;
    private int TL;
    private int TM;
    private int TO;
    private int TP;
    private final BitmapDrawable TQ;
    private final Paint TR;
    private final Rect TS;
    private final RectF TT;
    private TextView TU;
    private TextView TV;
    private TextView TW;
    private TextView TX;
    private VoiceButton TY;
    private ImageView TZ;
    private final int[] To;
    private int Tp;
    private final int Tq;
    private final int Tr;
    private final int Ts;
    private final int Tt;
    private final int Tu;
    private int Tv;
    private int Tw;
    private int Tx;
    private int Ty;
    private int Tz;
    private TextView Ua;
    private float Ub;
    private float Uc;
    private f Ud;
    private long Ue;
    private long Uf;
    private final int[] Ug;
    private final a Uh;
    private SweepGradient Ui;
    private int Uj;
    private int centerX;
    private int centerY;
    VoiceData.VoiceModel mModel;
    private int mPaddingTop;

    static /* synthetic */ int e(VoiceRecordButton voiceRecordButton) {
        int i = voiceRecordButton.Tw;
        voiceRecordButton.Tw = i + 1;
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
                if (VoiceRecordButton.this.Uc >= 360.0f) {
                    VoiceRecordButton.this.Uc = 360.0f;
                    VoiceRecordButton.this.Tw = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    VoiceRecordButton.this.Ue = uptimeMillis;
                    VoiceRecordButton.this.Uf = uptimeMillis + 200;
                    VoiceRecordButton.this.Uc += (((float) (uptimeMillis - VoiceRecordButton.this.Ue)) / 1000.0f) * VoiceRecordButton.this.Ub;
                    sendEmptyMessageAtTime(1, VoiceRecordButton.this.Uf);
                    VoiceRecordButton.e(VoiceRecordButton.this);
                }
                VoiceRecordButton.this.Tv = VoiceRecordButton.this.Tw % 6;
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
        this.Sz = 0L;
        this.To = new int[4];
        this.Tv = 0;
        this.Tw = 0;
        this.centerX = 0;
        this.centerY = 0;
        this.Tx = 0;
        this.Ty = 0;
        this.Tz = 0;
        this.TA = 0;
        this.TB = 0;
        this.TC = 0;
        this.TH = -1724676609;
        this.TI = 1546880511;
        this.TJ = 674465279;
        this.TK = 255034879;
        this.TL = -1725669966;
        this.TM = 1545887154;
        this.TO = 673471922;
        this.TP = 254041522;
        this.TR = new Paint(1);
        this.TS = new Rect();
        this.TT = new RectF();
        this.SH = 0;
        this.Ug = new int[2];
        this.Uh = new a();
        this.Sy = 0;
        this.Uj = 0;
        this.To[0] = context.getResources().getDimensionPixelSize(e.C0141e.ds24);
        this.To[1] = context.getResources().getDimensionPixelSize(e.C0141e.ds8);
        this.To[2] = context.getResources().getDimensionPixelSize(e.C0141e.ds22);
        this.To[3] = context.getResources().getDimensionPixelSize(e.C0141e.ds36);
        this.Tx = context.getResources().getDimensionPixelSize(e.C0141e.ds134);
        this.Ty = this.Tx + context.getResources().getDimensionPixelSize(e.C0141e.ds14);
        this.Tz = this.Ty + context.getResources().getDimensionPixelSize(e.C0141e.ds16);
        this.TA = this.Tz + context.getResources().getDimensionPixelSize(e.C0141e.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.TB = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.TC = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.TB = context.getResources().getDimensionPixelSize(e.C0141e.ds70);
            this.TC = context.getResources().getDimensionPixelSize(e.C0141e.ds210);
        }
        this.mPaddingTop = context.getResources().getDimensionPixelSize(e.C0141e.ds26);
        this.Tp = context.getResources().getDimensionPixelSize(e.C0141e.ds10);
        this.Tq = context.getResources().getDimensionPixelSize(e.C0141e.ds14);
        this.Tr = context.getResources().getDimensionPixelSize(e.C0141e.ds4);
        this.Ts = context.getResources().getDimensionPixelSize(e.C0141e.ds4);
        this.Tt = context.getResources().getDimensionPixelSize(e.C0141e.ds12);
        this.Tu = context.getResources().getDimensionPixelSize(e.C0141e.ds2);
        this.TR.setStyle(Paint.Style.STROKE);
        this.TR.setStrokeWidth(this.Tt);
        this.TQ = (BitmapDrawable) getResources().getDrawable(e.f.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        aW(context);
        pW();
        this.Ug[0] = al.getColor(e.d.common_color_10151);
        this.Ug[1] = al.getColor(e.d.common_color_10152);
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
        this.mPaddingTop = ((i4 - getContext().getResources().getDimensionPixelSize(e.C0141e.ds460)) / 2) + getContext().getResources().getDimensionPixelSize(e.C0141e.ds6);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int measuredWidth = this.TY.getMeasuredWidth();
        int measuredHeight = this.TY.getMeasuredHeight();
        int measuredWidth2 = this.TV.getMeasuredWidth();
        this.TV.layout((i5 - measuredWidth2) >> 1, this.mPaddingTop + i2, (measuredWidth2 + i5) >> 1, this.TV.getMeasuredHeight() + this.mPaddingTop + i2);
        int bottom = this.TV.getBottom();
        this.TY.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.centerX = (measuredWidth / 2) + i6;
        this.centerY = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.TX.getMeasuredWidth();
        int measuredHeight2 = this.TX.getMeasuredHeight();
        int top = this.TY.getTop();
        this.TX.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.TU.getMeasuredWidth();
        int measuredHeight3 = this.TU.getMeasuredHeight();
        int right = this.TY.getRight() - this.Tp;
        int bottom2 = this.TY.getBottom() - this.Tq;
        this.TU.layout(this.TB + i6, this.TC + bottom, measuredWidth4 + i6 + this.TB, measuredHeight3 + this.TC + bottom);
        int measuredWidth5 = this.TZ.getMeasuredWidth();
        this.TZ.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.TZ.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.Ua.getMeasuredWidth();
        this.Ua.layout((i5 - measuredWidth6) >> 1, (this.TU.getTop() - this.Ua.getMeasuredHeight()) - this.Tr, (measuredWidth6 + i5) >> 1, (this.TU.getTop() + i2) - this.Tr);
        this.TY.getLeft();
        this.TY.getRight();
        int measuredWidth7 = this.TW.getMeasuredWidth();
        int measuredHeight4 = this.TW.getMeasuredHeight();
        int bottom3 = this.TY.getBottom();
        this.TW.layout((i5 - measuredWidth7) >> 1, this.To[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.To[3]);
        this.TS.set((i5 - this.TQ.getIntrinsicWidth()) >> 1, this.TZ.getTop() - this.Ts, (i5 + this.TQ.getIntrinsicHeight()) >> 1, (this.TZ.getTop() + this.TQ.getIntrinsicHeight()) - this.Ts);
        this.TQ.setBounds(this.TS);
        this.TT.set(this.TZ.getLeft() + (this.Tt >> 1) + this.Tu, this.TZ.getTop() + (this.Tt >> 1) + this.Tu, (this.TZ.getRight() - (this.Tt >> 1)) - this.Tu, (this.TZ.getBottom() - (this.Tt >> 1)) - this.Tu);
        if (this.Ui == null) {
            this.Ui = new SweepGradient(this.TT.centerX(), this.TT.centerY(), this.Ug, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.Ui.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.TT.centerX(), this.TT.centerY());
            this.Ui.setLocalMatrix(matrix);
            this.TR.setShader(this.Ui);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        f(canvas);
        super.dispatchDraw(canvas);
    }

    private void pH() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.SK == null) {
            this.SK = new com.baidu.tbadk.core.dialog.a(i.aK(getContext()).getPageActivity());
            this.SK.dT(getContext().getString(e.j.voice_restart_tip)).a(getContext().getString(e.j.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    VoiceRecordButton.this.pS();
                    if (VoiceRecordButton.this.getVoiceManager() != null && VoiceRecordButton.this.mModel != null) {
                        if (recorderManager != null) {
                            recorderManager.cu(VoiceRecordButton.this.mModel.voiceId);
                        }
                        VoiceRecordButton.this.mModel = null;
                    }
                }
            }).b(getContext().getString(e.j.cancel), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(i.aK(getContext()));
        }
        try {
            this.SK.yl();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.mModel != null) {
                if (recorderManager != null) {
                    recorderManager.cu(this.mModel.voiceId);
                }
                this.mModel = null;
            }
        }
    }

    private void aW(Context context) {
        LayoutInflater.from(context).inflate(e.h.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.TV = (TextView) findViewById(e.g.tip_error);
        al.c(this.TV, e.d.cp_cont_i, 1);
        this.TW = (TextView) findViewById(e.g.tip_operator);
        this.TX = (TextView) findViewById(e.g.tip_time_out);
        this.TY = (VoiceButton) findViewById(e.g.voice_bnt);
        this.TU = (TextView) findViewById(e.g.restart);
        this.TZ = (ImageView) findViewById(e.g.play_img);
        this.Ua = (TextView) findViewById(e.g.play_time);
        this.Ua.setClickable(false);
        this.TU.setOnClickListener(this);
        this.TZ.setOnClickListener(this);
        this.TY.setRecorderView(this);
        pS();
    }

    private void pR() {
        this.TY.setVisibility(4);
        this.Ua.setVisibility(0);
        this.TU.setVisibility(0);
        al.c(this.Ua, e.d.cp_cont_f, 1);
        al.c(this.TU, e.d.cp_cont_f, 1);
        al.i(this.TU, e.f.but_posts_record_again_selector);
        this.TZ.setVisibility(0);
        if (this.mModel != null) {
            this.Ua.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.TZ.setContentDescription(String.format(getContext().getString(e.j.listen_time), Integer.valueOf(this.mModel.duration)));
            al.c(this.TZ, e.f.but_posts_record_play_selector);
        }
        al.c(this.TW, e.d.cp_cont_c, 1);
        this.TW.setText(getContext().getString(e.j.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pS() {
        al.c(this.TY, e.f.but_posts_record_zero_selector);
        this.TY.setVisibility(0);
        this.Tv = 0;
        this.TZ.setVisibility(4);
        this.Ua.setVisibility(4);
        this.TU.setVisibility(4);
        this.TX.setVisibility(4);
        al.c(this.TW, e.d.cp_cont_c, 1);
        this.TW.setText(getContext().getString(e.j.voice_record_press_to_record));
    }

    public void reset() {
        pS();
        this.mModel = null;
        this.Tv = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.TV.setText("");
        this.TV.setVisibility(4);
        this.Tv = 0;
        pR();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            pS();
            this.TW.setText(getContext().getString(e.j.voice_record_release_to_stop));
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
        if (this.TZ != null && this.Ua != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    al.c(this.Ua, e.d.cp_cont_f, 1);
                    this.Ua.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    al.c(this.TZ, e.f.but_posts_record_play_selector);
                    this.TZ.setContentDescription(String.format(getContext().getString(e.j.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.TW.setText(getContext().getString(e.j.voice_play_tip));
                    pU();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    al.c(this.Ua, e.d.cp_cont_f, 1);
                    al.c(this.TZ, e.f.but_posts_record_stop_selector);
                    this.TZ.setContentDescription(getContext().getString(e.j.pause_load));
                    this.TW.setText(getContext().getString(e.j.voice_stop_tip));
                    pT();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        al.c(this.TX, e.d.cp_cont_i, 1);
        al.c(this.TV, e.d.cp_cont_i, 1);
        al.c(this.TW, e.d.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.TX.setVisibility(0);
                this.TX.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.TX != null) {
                            VoiceRecordButton.this.TX.setVisibility(4);
                            VoiceRecordButton.this.TX.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 2) {
                this.TV.setVisibility(0);
                this.TV.setText(str);
                this.TW.setText(e.j.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.TV != null) {
                            VoiceRecordButton.this.TV.setVisibility(4);
                            VoiceRecordButton.this.TV.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 5) {
                this.TV.setVisibility(0);
                this.TV.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.TV != null) {
                            VoiceRecordButton.this.TV.setVisibility(4);
                            VoiceRecordButton.this.TV.setText("");
                        }
                    }
                }, 2000L);
            } else {
                pS();
                this.TV.setVisibility(0);
                this.TV.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.TV != null) {
                            VoiceRecordButton.this.TV.setVisibility(4);
                            VoiceRecordButton.this.TV.setText("");
                        }
                    }
                }, 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.TV.setVisibility(4);
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
        al.c(this.TV, e.d.cp_cont_i, 1);
        this.TV.setVisibility(0);
        this.TV.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.Sy = Math.max(i, this.Sy);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.Sz > 200) {
            this.Sy = 0;
            this.Sz = uptimeMillis;
        }
        if (this.Sy < 10) {
            this.Tv = 1;
            invalidate();
        } else if (this.Sy < 20) {
            this.Tv = 2;
            invalidate();
        } else if (this.Sy < 30) {
            this.Tv = 3;
            invalidate();
        } else if (this.Sy < 40) {
            this.Tv = 4;
            invalidate();
        } else {
            this.Tv = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bk(int i) {
        if (this.mModel != null && this.Ua != null) {
            int i2 = i / 1000;
            if (this.Uj != i2) {
                this.Ua.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.Uj = i2;
        }
    }

    private void pT() {
        if (this.mModel != null) {
            this.Tv = 0;
            this.Ub = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.Ue = SystemClock.uptimeMillis();
            this.Uf = this.Ue + 200;
            this.Uh.sendEmptyMessageAtTime(1, this.Uf);
            invalidate();
        }
    }

    private void pU() {
        this.Tv = 0;
        this.Tw = 0;
        this.Ub = 0.0f;
        this.Uc = 0.0f;
        this.Uh.removeMessages(1);
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
            if (id == e.g.restart) {
                voiceManager.stopPlay();
                pH();
            } else if (id == e.g.play_img && this.mModel != null) {
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
        this.Ud = fVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void pV() {
    }

    public void pW() {
        this.TD = new Paint();
        this.TD.setAntiAlias(true);
        this.TD.setStyle(Paint.Style.STROKE);
        this.TD.setStrokeWidth(2.0f);
        this.TE = new Paint();
        this.TE.setAntiAlias(true);
        this.TE.setStyle(Paint.Style.STROKE);
        this.TE.setStrokeWidth(2.0f);
        this.TF = new Paint();
        this.TF.setAntiAlias(true);
        this.TF.setStyle(Paint.Style.STROKE);
        this.TF.setStrokeWidth(2.0f);
        this.TG = new Paint();
        this.TG.setAntiAlias(true);
        this.TG.setStyle(Paint.Style.STROKE);
        this.TG.setStrokeWidth(2.0f);
    }

    public void f(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.TD.setColor(this.TL);
            this.TE.setColor(this.TM);
            this.TF.setColor(this.TO);
            this.TG.setColor(this.TP);
        } else {
            this.TD.setColor(this.TH);
            this.TE.setColor(this.TI);
            this.TF.setColor(this.TJ);
            this.TG.setColor(this.TK);
        }
        if (this.Tv == 2) {
            canvas.drawCircle(this.centerX, this.centerY, this.Tx, this.TD);
        } else if (this.Tv == 3) {
            canvas.drawCircle(this.centerX, this.centerY, this.Tx, this.TD);
            canvas.drawCircle(this.centerX, this.centerY, this.Ty, this.TE);
        } else if (this.Tv == 4) {
            canvas.drawCircle(this.centerX, this.centerY, this.Tx, this.TD);
            canvas.drawCircle(this.centerX, this.centerY, this.Ty, this.TE);
            canvas.drawCircle(this.centerX, this.centerY, this.Tz, this.TF);
        } else if (this.Tv == 5) {
            canvas.drawCircle(this.centerX, this.centerY, this.Tx, this.TD);
            canvas.drawCircle(this.centerX, this.centerY, this.Ty, this.TE);
            canvas.drawCircle(this.centerX, this.centerY, this.Tz, this.TF);
            canvas.drawCircle(this.centerX, this.centerY, this.TA, this.TG);
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
                    pR();
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
    public void pI() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.SH;
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
        if (this.SG != null) {
            this.SG.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.SG = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.SH = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
    }
}
