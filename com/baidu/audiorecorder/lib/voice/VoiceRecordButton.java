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
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
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
    private int SQ;
    private long SR;
    private EditorTools SY;
    private int SZ;
    private final int[] TC;
    private int TD;
    private final int TF;
    private final int TG;
    private final int TH;
    private final int TI;
    private final int TJ;
    private int TK;
    private int TL;
    private int TM;
    private int TO;
    private int TP;
    private int TQ;
    private int TR;
    private int TS;
    private Paint TT;
    private Paint TU;
    private Paint TV;
    private Paint TW;
    private int TX;
    private int TY;
    private int TZ;
    private com.baidu.tbadk.core.dialog.a Tb;
    private int Ua;
    private int Ub;
    private int Uc;
    private int Ud;
    private int Ue;
    private final BitmapDrawable Uf;
    private final Paint Ug;
    private final Rect Uh;
    private final RectF Ui;
    private TextView Uj;
    private TextView Uk;
    private TextView Ul;
    private TextView Um;
    private VoiceButton Un;
    private ImageView Uo;
    private TextView Up;
    private float Uq;
    private float Ur;
    private f Us;
    private long Ut;
    private long Uu;
    private final int[] Uv;
    private final a Uw;
    private SweepGradient Ux;
    private int Uy;
    private int centerX;
    private int centerY;
    VoiceData.VoiceModel mModel;
    private int mPaddingTop;

    static /* synthetic */ int e(VoiceRecordButton voiceRecordButton) {
        int i = voiceRecordButton.TL;
        voiceRecordButton.TL = i + 1;
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
                if (VoiceRecordButton.this.Ur >= 360.0f) {
                    VoiceRecordButton.this.Ur = 360.0f;
                    VoiceRecordButton.this.TL = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    VoiceRecordButton.this.Ut = uptimeMillis;
                    VoiceRecordButton.this.Uu = uptimeMillis + 200;
                    VoiceRecordButton.this.Ur += (((float) (uptimeMillis - VoiceRecordButton.this.Ut)) / 1000.0f) * VoiceRecordButton.this.Uq;
                    sendEmptyMessageAtTime(1, VoiceRecordButton.this.Uu);
                    VoiceRecordButton.e(VoiceRecordButton.this);
                }
                VoiceRecordButton.this.TK = VoiceRecordButton.this.TL % 6;
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
        this.SR = 0L;
        this.TC = new int[4];
        this.TK = 0;
        this.TL = 0;
        this.centerX = 0;
        this.centerY = 0;
        this.TM = 0;
        this.TO = 0;
        this.TP = 0;
        this.TQ = 0;
        this.TR = 0;
        this.TS = 0;
        this.TX = -1724676609;
        this.TY = 1546880511;
        this.TZ = 674465279;
        this.Ua = 255034879;
        this.Ub = -1725669966;
        this.Uc = 1545887154;
        this.Ud = 673471922;
        this.Ue = 254041522;
        this.Ug = new Paint(1);
        this.Uh = new Rect();
        this.Ui = new RectF();
        this.SZ = 0;
        this.Uv = new int[2];
        this.Uw = new a();
        this.SQ = 0;
        this.Uy = 0;
        this.TC[0] = context.getResources().getDimensionPixelSize(e.C0175e.ds24);
        this.TC[1] = context.getResources().getDimensionPixelSize(e.C0175e.ds8);
        this.TC[2] = context.getResources().getDimensionPixelSize(e.C0175e.ds22);
        this.TC[3] = context.getResources().getDimensionPixelSize(e.C0175e.ds36);
        this.TM = context.getResources().getDimensionPixelSize(e.C0175e.ds134);
        this.TO = this.TM + context.getResources().getDimensionPixelSize(e.C0175e.ds14);
        this.TP = this.TO + context.getResources().getDimensionPixelSize(e.C0175e.ds16);
        this.TQ = this.TP + context.getResources().getDimensionPixelSize(e.C0175e.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.TR = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.TS = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.TR = context.getResources().getDimensionPixelSize(e.C0175e.ds70);
            this.TS = context.getResources().getDimensionPixelSize(e.C0175e.ds210);
        }
        this.mPaddingTop = context.getResources().getDimensionPixelSize(e.C0175e.ds26);
        this.TD = context.getResources().getDimensionPixelSize(e.C0175e.ds10);
        this.TF = context.getResources().getDimensionPixelSize(e.C0175e.ds14);
        this.TG = context.getResources().getDimensionPixelSize(e.C0175e.ds4);
        this.TH = context.getResources().getDimensionPixelSize(e.C0175e.ds4);
        this.TI = context.getResources().getDimensionPixelSize(e.C0175e.ds12);
        this.TJ = context.getResources().getDimensionPixelSize(e.C0175e.ds2);
        this.Ug.setStyle(Paint.Style.STROKE);
        this.Ug.setStrokeWidth(this.TI);
        this.Uf = (BitmapDrawable) getResources().getDrawable(e.f.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        aW(context);
        qd();
        this.Uv[0] = al.getColor(e.d.common_color_10151);
        this.Uv[1] = al.getColor(e.d.common_color_10152);
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
        this.mPaddingTop = ((i4 - getContext().getResources().getDimensionPixelSize(e.C0175e.ds460)) / 2) + getContext().getResources().getDimensionPixelSize(e.C0175e.ds6);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int measuredWidth = this.Un.getMeasuredWidth();
        int measuredHeight = this.Un.getMeasuredHeight();
        int measuredWidth2 = this.Uk.getMeasuredWidth();
        this.Uk.layout((i5 - measuredWidth2) >> 1, this.mPaddingTop + i2, (measuredWidth2 + i5) >> 1, this.Uk.getMeasuredHeight() + this.mPaddingTop + i2);
        int bottom = this.Uk.getBottom();
        this.Un.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.centerX = (measuredWidth / 2) + i6;
        this.centerY = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.Um.getMeasuredWidth();
        int measuredHeight2 = this.Um.getMeasuredHeight();
        int top = this.Un.getTop();
        this.Um.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.Uj.getMeasuredWidth();
        int measuredHeight3 = this.Uj.getMeasuredHeight();
        int right = this.Un.getRight() - this.TD;
        int bottom2 = this.Un.getBottom() - this.TF;
        this.Uj.layout(this.TR + i6, this.TS + bottom, measuredWidth4 + i6 + this.TR, measuredHeight3 + this.TS + bottom);
        int measuredWidth5 = this.Uo.getMeasuredWidth();
        this.Uo.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.Uo.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.Up.getMeasuredWidth();
        this.Up.layout((i5 - measuredWidth6) >> 1, (this.Uj.getTop() - this.Up.getMeasuredHeight()) - this.TG, (measuredWidth6 + i5) >> 1, (this.Uj.getTop() + i2) - this.TG);
        this.Un.getLeft();
        this.Un.getRight();
        int measuredWidth7 = this.Ul.getMeasuredWidth();
        int measuredHeight4 = this.Ul.getMeasuredHeight();
        int bottom3 = this.Un.getBottom();
        this.Ul.layout((i5 - measuredWidth7) >> 1, this.TC[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.TC[3]);
        this.Uh.set((i5 - this.Uf.getIntrinsicWidth()) >> 1, this.Uo.getTop() - this.TH, (i5 + this.Uf.getIntrinsicHeight()) >> 1, (this.Uo.getTop() + this.Uf.getIntrinsicHeight()) - this.TH);
        this.Uf.setBounds(this.Uh);
        this.Ui.set(this.Uo.getLeft() + (this.TI >> 1) + this.TJ, this.Uo.getTop() + (this.TI >> 1) + this.TJ, (this.Uo.getRight() - (this.TI >> 1)) - this.TJ, (this.Uo.getBottom() - (this.TI >> 1)) - this.TJ);
        if (this.Ux == null) {
            this.Ux = new SweepGradient(this.Ui.centerX(), this.Ui.centerY(), this.Uv, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.Ux.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.Ui.centerX(), this.Ui.centerY());
            this.Ux.setLocalMatrix(matrix);
            this.Ug.setShader(this.Ux);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        f(canvas);
        super.dispatchDraw(canvas);
    }

    private void pP() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.Tb == null) {
            this.Tb = new com.baidu.tbadk.core.dialog.a(i.aK(getContext()).getPageActivity());
            this.Tb.ej(getContext().getString(e.j.voice_restart_tip)).a(getContext().getString(e.j.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    VoiceRecordButton.this.pZ();
                    if (VoiceRecordButton.this.getVoiceManager() != null && VoiceRecordButton.this.mModel != null) {
                        if (recorderManager != null) {
                            recorderManager.ct(VoiceRecordButton.this.mModel.voiceId);
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
            this.Tb.Au();
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
        LayoutInflater.from(context).inflate(e.h.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.Uk = (TextView) findViewById(e.g.tip_error);
        al.c(this.Uk, e.d.cp_cont_i, 1);
        this.Ul = (TextView) findViewById(e.g.tip_operator);
        this.Um = (TextView) findViewById(e.g.tip_time_out);
        this.Un = (VoiceButton) findViewById(e.g.voice_bnt);
        this.Uj = (TextView) findViewById(e.g.restart);
        this.Uo = (ImageView) findViewById(e.g.play_img);
        this.Up = (TextView) findViewById(e.g.play_time);
        this.Up.setClickable(false);
        this.Uj.setOnClickListener(this);
        this.Uo.setOnClickListener(this);
        this.Un.setRecorderView(this);
        pZ();
    }

    private void pY() {
        this.Un.setVisibility(4);
        this.Up.setVisibility(0);
        this.Uj.setVisibility(0);
        al.c(this.Up, e.d.cp_cont_f, 1);
        al.c(this.Uj, e.d.cp_cont_f, 1);
        al.i(this.Uj, e.f.but_posts_record_again_selector);
        this.Uo.setVisibility(0);
        if (this.mModel != null) {
            this.Up.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.Uo.setContentDescription(String.format(getContext().getString(e.j.listen_time), Integer.valueOf(this.mModel.duration)));
            al.c(this.Uo, e.f.but_posts_record_play_selector);
        }
        al.c(this.Ul, e.d.cp_cont_c, 1);
        this.Ul.setText(getContext().getString(e.j.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pZ() {
        al.c(this.Un, e.f.but_posts_record_zero_selector);
        this.Un.setVisibility(0);
        this.TK = 0;
        this.Uo.setVisibility(4);
        this.Up.setVisibility(4);
        this.Uj.setVisibility(4);
        this.Um.setVisibility(4);
        al.c(this.Ul, e.d.cp_cont_c, 1);
        this.Ul.setText(getContext().getString(e.j.voice_record_press_to_record));
    }

    public void reset() {
        pZ();
        this.mModel = null;
        this.TK = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.Uk.setText("");
        this.Uk.setVisibility(4);
        this.TK = 0;
        pY();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            pZ();
            this.Ul.setText(getContext().getString(e.j.voice_record_release_to_stop));
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
        if (this.Uo != null && this.Up != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    al.c(this.Up, e.d.cp_cont_f, 1);
                    this.Up.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    al.c(this.Uo, e.f.but_posts_record_play_selector);
                    this.Uo.setContentDescription(String.format(getContext().getString(e.j.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.Ul.setText(getContext().getString(e.j.voice_play_tip));
                    qb();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    al.c(this.Up, e.d.cp_cont_f, 1);
                    al.c(this.Uo, e.f.but_posts_record_stop_selector);
                    this.Uo.setContentDescription(getContext().getString(e.j.pause_load));
                    this.Ul.setText(getContext().getString(e.j.voice_stop_tip));
                    qa();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        al.c(this.Um, e.d.cp_cont_i, 1);
        al.c(this.Uk, e.d.cp_cont_i, 1);
        al.c(this.Ul, e.d.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.Um.setVisibility(0);
                this.Um.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.Um != null) {
                            VoiceRecordButton.this.Um.setVisibility(4);
                            VoiceRecordButton.this.Um.setText("");
                        }
                    }
                }, SystemScreenshotManager.DELAY_TIME);
            } else if (i == 2) {
                this.Uk.setVisibility(0);
                this.Uk.setText(str);
                this.Ul.setText(e.j.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.Uk != null) {
                            VoiceRecordButton.this.Uk.setVisibility(4);
                            VoiceRecordButton.this.Uk.setText("");
                        }
                    }
                }, SystemScreenshotManager.DELAY_TIME);
            } else if (i == 5) {
                this.Uk.setVisibility(0);
                this.Uk.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.Uk != null) {
                            VoiceRecordButton.this.Uk.setVisibility(4);
                            VoiceRecordButton.this.Uk.setText("");
                        }
                    }
                }, SystemScreenshotManager.DELAY_TIME);
            } else {
                pZ();
                this.Uk.setVisibility(0);
                this.Uk.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.Uk != null) {
                            VoiceRecordButton.this.Uk.setVisibility(4);
                            VoiceRecordButton.this.Uk.setText("");
                        }
                    }
                }, SystemScreenshotManager.DELAY_TIME);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.Uk.setVisibility(4);
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
        al.c(this.Uk, e.d.cp_cont_i, 1);
        this.Uk.setVisibility(0);
        this.Uk.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.SQ = Math.max(i, this.SQ);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.SR > 200) {
            this.SQ = 0;
            this.SR = uptimeMillis;
        }
        if (this.SQ < 10) {
            this.TK = 1;
            invalidate();
        } else if (this.SQ < 20) {
            this.TK = 2;
            invalidate();
        } else if (this.SQ < 30) {
            this.TK = 3;
            invalidate();
        } else if (this.SQ < 40) {
            this.TK = 4;
            invalidate();
        } else {
            this.TK = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bk(int i) {
        if (this.mModel != null && this.Up != null) {
            int i2 = i / 1000;
            if (this.Uy != i2) {
                this.Up.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.Uy = i2;
        }
    }

    private void qa() {
        if (this.mModel != null) {
            this.TK = 0;
            this.Uq = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.Ut = SystemClock.uptimeMillis();
            this.Uu = this.Ut + 200;
            this.Uw.sendEmptyMessageAtTime(1, this.Uu);
            invalidate();
        }
    }

    private void qb() {
        this.TK = 0;
        this.TL = 0;
        this.Uq = 0.0f;
        this.Ur = 0.0f;
        this.Uw.removeMessages(1);
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
                pP();
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
        this.Us = fVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void qc() {
    }

    public void qd() {
        this.TT = new Paint();
        this.TT.setAntiAlias(true);
        this.TT.setStyle(Paint.Style.STROKE);
        this.TT.setStrokeWidth(2.0f);
        this.TU = new Paint();
        this.TU.setAntiAlias(true);
        this.TU.setStyle(Paint.Style.STROKE);
        this.TU.setStrokeWidth(2.0f);
        this.TV = new Paint();
        this.TV.setAntiAlias(true);
        this.TV.setStyle(Paint.Style.STROKE);
        this.TV.setStrokeWidth(2.0f);
        this.TW = new Paint();
        this.TW.setAntiAlias(true);
        this.TW.setStyle(Paint.Style.STROKE);
        this.TW.setStrokeWidth(2.0f);
    }

    public void f(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.TT.setColor(this.Ub);
            this.TU.setColor(this.Uc);
            this.TV.setColor(this.Ud);
            this.TW.setColor(this.Ue);
        } else {
            this.TT.setColor(this.TX);
            this.TU.setColor(this.TY);
            this.TV.setColor(this.TZ);
            this.TW.setColor(this.Ua);
        }
        if (this.TK == 2) {
            canvas.drawCircle(this.centerX, this.centerY, this.TM, this.TT);
        } else if (this.TK == 3) {
            canvas.drawCircle(this.centerX, this.centerY, this.TM, this.TT);
            canvas.drawCircle(this.centerX, this.centerY, this.TO, this.TU);
        } else if (this.TK == 4) {
            canvas.drawCircle(this.centerX, this.centerY, this.TM, this.TT);
            canvas.drawCircle(this.centerX, this.centerY, this.TO, this.TU);
            canvas.drawCircle(this.centerX, this.centerY, this.TP, this.TV);
        } else if (this.TK == 5) {
            canvas.drawCircle(this.centerX, this.centerY, this.TM, this.TT);
            canvas.drawCircle(this.centerX, this.centerY, this.TO, this.TU);
            canvas.drawCircle(this.centerX, this.centerY, this.TP, this.TV);
            canvas.drawCircle(this.centerX, this.centerY, this.TQ, this.TW);
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
                    pY();
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
    public void pQ() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.SZ;
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
        if (this.SY != null) {
            this.SY.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.SY = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.SZ = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
    }
}
