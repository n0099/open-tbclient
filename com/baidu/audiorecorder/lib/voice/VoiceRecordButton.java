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
    private int SS;
    private long ST;
    private final int[] TF;
    private int TG;
    private final int TH;
    private final int TI;
    private final int TJ;
    private final int TK;
    private final int TL;
    private int TM;
    private int TO;
    private int TP;
    private int TQ;
    private int TR;
    private int TS;
    private int TT;
    private int TU;
    private Paint TV;
    private Paint TW;
    private Paint TX;
    private Paint TY;
    private int TZ;
    private EditorTools Ta;
    private int Tb;
    private com.baidu.tbadk.core.dialog.a Td;
    private int UB;
    private int Ua;
    private int Ub;
    private int Uc;
    private int Ud;
    private int Ue;
    private int Uf;
    private int Ug;
    private final BitmapDrawable Uh;
    private final Paint Ui;
    private final Rect Uj;
    private final RectF Uk;
    private TextView Ul;
    private TextView Um;
    private TextView Un;
    private TextView Uo;
    private VoiceButton Up;
    private ImageView Uq;
    private TextView Ur;
    private float Us;
    private float Ut;
    private f Uu;
    private long Uv;
    private long Uw;
    private final int[] Ux;
    private final a Uy;
    private SweepGradient Uz;
    private int centerX;
    private int centerY;
    VoiceData.VoiceModel mModel;
    private int mPaddingTop;

    static /* synthetic */ int e(VoiceRecordButton voiceRecordButton) {
        int i = voiceRecordButton.TO;
        voiceRecordButton.TO = i + 1;
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
                if (VoiceRecordButton.this.Ut >= 360.0f) {
                    VoiceRecordButton.this.Ut = 360.0f;
                    VoiceRecordButton.this.TO = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    VoiceRecordButton.this.Uv = uptimeMillis;
                    VoiceRecordButton.this.Uw = uptimeMillis + 200;
                    VoiceRecordButton.this.Ut += (((float) (uptimeMillis - VoiceRecordButton.this.Uv)) / 1000.0f) * VoiceRecordButton.this.Us;
                    sendEmptyMessageAtTime(1, VoiceRecordButton.this.Uw);
                    VoiceRecordButton.e(VoiceRecordButton.this);
                }
                VoiceRecordButton.this.TM = VoiceRecordButton.this.TO % 6;
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
        this.ST = 0L;
        this.TF = new int[4];
        this.TM = 0;
        this.TO = 0;
        this.centerX = 0;
        this.centerY = 0;
        this.TP = 0;
        this.TQ = 0;
        this.TR = 0;
        this.TS = 0;
        this.TT = 0;
        this.TU = 0;
        this.TZ = -1724676609;
        this.Ua = 1546880511;
        this.Ub = 674465279;
        this.Uc = 255034879;
        this.Ud = -1725669966;
        this.Ue = 1545887154;
        this.Uf = 673471922;
        this.Ug = 254041522;
        this.Ui = new Paint(1);
        this.Uj = new Rect();
        this.Uk = new RectF();
        this.Tb = 0;
        this.Ux = new int[2];
        this.Uy = new a();
        this.SS = 0;
        this.UB = 0;
        this.TF[0] = context.getResources().getDimensionPixelSize(e.C0210e.ds24);
        this.TF[1] = context.getResources().getDimensionPixelSize(e.C0210e.ds8);
        this.TF[2] = context.getResources().getDimensionPixelSize(e.C0210e.ds22);
        this.TF[3] = context.getResources().getDimensionPixelSize(e.C0210e.ds36);
        this.TP = context.getResources().getDimensionPixelSize(e.C0210e.ds134);
        this.TQ = this.TP + context.getResources().getDimensionPixelSize(e.C0210e.ds14);
        this.TR = this.TQ + context.getResources().getDimensionPixelSize(e.C0210e.ds16);
        this.TS = this.TR + context.getResources().getDimensionPixelSize(e.C0210e.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.TT = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.TU = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.TT = context.getResources().getDimensionPixelSize(e.C0210e.ds70);
            this.TU = context.getResources().getDimensionPixelSize(e.C0210e.ds210);
        }
        this.mPaddingTop = context.getResources().getDimensionPixelSize(e.C0210e.ds26);
        this.TG = context.getResources().getDimensionPixelSize(e.C0210e.ds10);
        this.TH = context.getResources().getDimensionPixelSize(e.C0210e.ds14);
        this.TI = context.getResources().getDimensionPixelSize(e.C0210e.ds4);
        this.TJ = context.getResources().getDimensionPixelSize(e.C0210e.ds4);
        this.TK = context.getResources().getDimensionPixelSize(e.C0210e.ds12);
        this.TL = context.getResources().getDimensionPixelSize(e.C0210e.ds2);
        this.Ui.setStyle(Paint.Style.STROKE);
        this.Ui.setStrokeWidth(this.TK);
        this.Uh = (BitmapDrawable) getResources().getDrawable(e.f.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        aW(context);
        qa();
        this.Ux[0] = al.getColor(e.d.common_color_10151);
        this.Ux[1] = al.getColor(e.d.common_color_10152);
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
        this.mPaddingTop = ((i4 - getContext().getResources().getDimensionPixelSize(e.C0210e.ds460)) / 2) + getContext().getResources().getDimensionPixelSize(e.C0210e.ds6);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int measuredWidth = this.Up.getMeasuredWidth();
        int measuredHeight = this.Up.getMeasuredHeight();
        int measuredWidth2 = this.Um.getMeasuredWidth();
        this.Um.layout((i5 - measuredWidth2) >> 1, this.mPaddingTop + i2, (measuredWidth2 + i5) >> 1, this.Um.getMeasuredHeight() + this.mPaddingTop + i2);
        int bottom = this.Um.getBottom();
        this.Up.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.centerX = (measuredWidth / 2) + i6;
        this.centerY = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.Uo.getMeasuredWidth();
        int measuredHeight2 = this.Uo.getMeasuredHeight();
        int top = this.Up.getTop();
        this.Uo.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.Ul.getMeasuredWidth();
        int measuredHeight3 = this.Ul.getMeasuredHeight();
        int right = this.Up.getRight() - this.TG;
        int bottom2 = this.Up.getBottom() - this.TH;
        this.Ul.layout(this.TT + i6, this.TU + bottom, measuredWidth4 + i6 + this.TT, measuredHeight3 + this.TU + bottom);
        int measuredWidth5 = this.Uq.getMeasuredWidth();
        this.Uq.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.Uq.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.Ur.getMeasuredWidth();
        this.Ur.layout((i5 - measuredWidth6) >> 1, (this.Ul.getTop() - this.Ur.getMeasuredHeight()) - this.TI, (measuredWidth6 + i5) >> 1, (this.Ul.getTop() + i2) - this.TI);
        this.Up.getLeft();
        this.Up.getRight();
        int measuredWidth7 = this.Un.getMeasuredWidth();
        int measuredHeight4 = this.Un.getMeasuredHeight();
        int bottom3 = this.Up.getBottom();
        this.Un.layout((i5 - measuredWidth7) >> 1, this.TF[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.TF[3]);
        this.Uj.set((i5 - this.Uh.getIntrinsicWidth()) >> 1, this.Uq.getTop() - this.TJ, (i5 + this.Uh.getIntrinsicHeight()) >> 1, (this.Uq.getTop() + this.Uh.getIntrinsicHeight()) - this.TJ);
        this.Uh.setBounds(this.Uj);
        this.Uk.set(this.Uq.getLeft() + (this.TK >> 1) + this.TL, this.Uq.getTop() + (this.TK >> 1) + this.TL, (this.Uq.getRight() - (this.TK >> 1)) - this.TL, (this.Uq.getBottom() - (this.TK >> 1)) - this.TL);
        if (this.Uz == null) {
            this.Uz = new SweepGradient(this.Uk.centerX(), this.Uk.centerY(), this.Ux, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.Uz.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.Uk.centerX(), this.Uk.centerY());
            this.Uz.setLocalMatrix(matrix);
            this.Ui.setShader(this.Uz);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        f(canvas);
        super.dispatchDraw(canvas);
    }

    private void pM() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.Td == null) {
            this.Td = new com.baidu.tbadk.core.dialog.a(i.aK(getContext()).getPageActivity());
            this.Td.eB(getContext().getString(e.j.voice_restart_tip)).a(getContext().getString(e.j.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    VoiceRecordButton.this.pW();
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
            this.Td.BF();
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
        this.Um = (TextView) findViewById(e.g.tip_error);
        al.c(this.Um, e.d.cp_cont_i, 1);
        this.Un = (TextView) findViewById(e.g.tip_operator);
        this.Uo = (TextView) findViewById(e.g.tip_time_out);
        this.Up = (VoiceButton) findViewById(e.g.voice_bnt);
        this.Ul = (TextView) findViewById(e.g.restart);
        this.Uq = (ImageView) findViewById(e.g.play_img);
        this.Ur = (TextView) findViewById(e.g.play_time);
        this.Ur.setClickable(false);
        this.Ul.setOnClickListener(this);
        this.Uq.setOnClickListener(this);
        this.Up.setRecorderView(this);
        pW();
    }

    private void pV() {
        this.Up.setVisibility(4);
        this.Ur.setVisibility(0);
        this.Ul.setVisibility(0);
        al.c(this.Ur, e.d.cp_cont_f, 1);
        al.c(this.Ul, e.d.cp_cont_f, 1);
        al.i(this.Ul, e.f.but_posts_record_again_selector);
        this.Uq.setVisibility(0);
        if (this.mModel != null) {
            this.Ur.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.Uq.setContentDescription(String.format(getContext().getString(e.j.listen_time), Integer.valueOf(this.mModel.duration)));
            al.c(this.Uq, e.f.but_posts_record_play_selector);
        }
        al.c(this.Un, e.d.cp_cont_c, 1);
        this.Un.setText(getContext().getString(e.j.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pW() {
        al.c(this.Up, e.f.but_posts_record_zero_selector);
        this.Up.setVisibility(0);
        this.TM = 0;
        this.Uq.setVisibility(4);
        this.Ur.setVisibility(4);
        this.Ul.setVisibility(4);
        this.Uo.setVisibility(4);
        al.c(this.Un, e.d.cp_cont_c, 1);
        this.Un.setText(getContext().getString(e.j.voice_record_press_to_record));
    }

    public void reset() {
        pW();
        this.mModel = null;
        this.TM = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.Um.setText("");
        this.Um.setVisibility(4);
        this.TM = 0;
        pV();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            pW();
            this.Un.setText(getContext().getString(e.j.voice_record_release_to_stop));
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
        if (this.Uq != null && this.Ur != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    al.c(this.Ur, e.d.cp_cont_f, 1);
                    this.Ur.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    al.c(this.Uq, e.f.but_posts_record_play_selector);
                    this.Uq.setContentDescription(String.format(getContext().getString(e.j.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.Un.setText(getContext().getString(e.j.voice_play_tip));
                    pY();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    al.c(this.Ur, e.d.cp_cont_f, 1);
                    al.c(this.Uq, e.f.but_posts_record_stop_selector);
                    this.Uq.setContentDescription(getContext().getString(e.j.pause_load));
                    this.Un.setText(getContext().getString(e.j.voice_stop_tip));
                    pX();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        al.c(this.Uo, e.d.cp_cont_i, 1);
        al.c(this.Um, e.d.cp_cont_i, 1);
        al.c(this.Un, e.d.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.Uo.setVisibility(0);
                this.Uo.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.Uo != null) {
                            VoiceRecordButton.this.Uo.setVisibility(4);
                            VoiceRecordButton.this.Uo.setText("");
                        }
                    }
                }, SystemScreenshotManager.DELAY_TIME);
            } else if (i == 2) {
                this.Um.setVisibility(0);
                this.Um.setText(str);
                this.Un.setText(e.j.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.Um != null) {
                            VoiceRecordButton.this.Um.setVisibility(4);
                            VoiceRecordButton.this.Um.setText("");
                        }
                    }
                }, SystemScreenshotManager.DELAY_TIME);
            } else if (i == 5) {
                this.Um.setVisibility(0);
                this.Um.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.Um != null) {
                            VoiceRecordButton.this.Um.setVisibility(4);
                            VoiceRecordButton.this.Um.setText("");
                        }
                    }
                }, SystemScreenshotManager.DELAY_TIME);
            } else {
                pW();
                this.Um.setVisibility(0);
                this.Um.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.Um != null) {
                            VoiceRecordButton.this.Um.setVisibility(4);
                            VoiceRecordButton.this.Um.setText("");
                        }
                    }
                }, SystemScreenshotManager.DELAY_TIME);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.Um.setVisibility(4);
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
        al.c(this.Um, e.d.cp_cont_i, 1);
        this.Um.setVisibility(0);
        this.Um.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.SS = Math.max(i, this.SS);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.ST > 200) {
            this.SS = 0;
            this.ST = uptimeMillis;
        }
        if (this.SS < 10) {
            this.TM = 1;
            invalidate();
        } else if (this.SS < 20) {
            this.TM = 2;
            invalidate();
        } else if (this.SS < 30) {
            this.TM = 3;
            invalidate();
        } else if (this.SS < 40) {
            this.TM = 4;
            invalidate();
        } else {
            this.TM = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bz(int i) {
        if (this.mModel != null && this.Ur != null) {
            int i2 = i / 1000;
            if (this.UB != i2) {
                this.Ur.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.UB = i2;
        }
    }

    private void pX() {
        if (this.mModel != null) {
            this.TM = 0;
            this.Us = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.Uv = SystemClock.uptimeMillis();
            this.Uw = this.Uv + 200;
            this.Uy.sendEmptyMessageAtTime(1, this.Uw);
            invalidate();
        }
    }

    private void pY() {
        this.TM = 0;
        this.TO = 0;
        this.Us = 0.0f;
        this.Ut = 0.0f;
        this.Uy.removeMessages(1);
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
                pM();
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
        this.Uu = fVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void pZ() {
    }

    public void qa() {
        this.TV = new Paint();
        this.TV.setAntiAlias(true);
        this.TV.setStyle(Paint.Style.STROKE);
        this.TV.setStrokeWidth(2.0f);
        this.TW = new Paint();
        this.TW.setAntiAlias(true);
        this.TW.setStyle(Paint.Style.STROKE);
        this.TW.setStrokeWidth(2.0f);
        this.TX = new Paint();
        this.TX.setAntiAlias(true);
        this.TX.setStyle(Paint.Style.STROKE);
        this.TX.setStrokeWidth(2.0f);
        this.TY = new Paint();
        this.TY.setAntiAlias(true);
        this.TY.setStyle(Paint.Style.STROKE);
        this.TY.setStrokeWidth(2.0f);
    }

    public void f(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.TV.setColor(this.Ud);
            this.TW.setColor(this.Ue);
            this.TX.setColor(this.Uf);
            this.TY.setColor(this.Ug);
        } else {
            this.TV.setColor(this.TZ);
            this.TW.setColor(this.Ua);
            this.TX.setColor(this.Ub);
            this.TY.setColor(this.Uc);
        }
        if (this.TM == 2) {
            canvas.drawCircle(this.centerX, this.centerY, this.TP, this.TV);
        } else if (this.TM == 3) {
            canvas.drawCircle(this.centerX, this.centerY, this.TP, this.TV);
            canvas.drawCircle(this.centerX, this.centerY, this.TQ, this.TW);
        } else if (this.TM == 4) {
            canvas.drawCircle(this.centerX, this.centerY, this.TP, this.TV);
            canvas.drawCircle(this.centerX, this.centerY, this.TQ, this.TW);
            canvas.drawCircle(this.centerX, this.centerY, this.TR, this.TX);
        } else if (this.TM == 5) {
            canvas.drawCircle(this.centerX, this.centerY, this.TP, this.TV);
            canvas.drawCircle(this.centerX, this.centerY, this.TQ, this.TW);
            canvas.drawCircle(this.centerX, this.centerY, this.TR, this.TX);
            canvas.drawCircle(this.centerX, this.centerY, this.TS, this.TY);
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
                    pV();
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
    public void pN() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Tb;
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
        if (this.Ta != null) {
            this.Ta.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Ta = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Tb = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
    }
}
