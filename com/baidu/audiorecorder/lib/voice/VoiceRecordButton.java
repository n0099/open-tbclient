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
    private final int[] TP;
    private int TQ;
    private final int TR;
    private final int TS;
    private final int TT;
    private final int TU;
    private final int TV;
    private int TW;
    private int TX;
    private int TY;
    private int TZ;
    private int Tb;
    private long Tc;
    private EditorTools Tj;
    private int Tk;
    private com.baidu.tbadk.core.dialog.a Tm;
    private TextView UB;
    private float UC;
    private float UD;
    private f UE;
    private long UF;
    private long UG;
    private final int[] UH;
    private final a UI;
    private SweepGradient UJ;
    private int UK;
    private int Ua;
    private int Ub;
    private int Uc;
    private int Ud;
    private Paint Ue;
    private Paint Uf;
    private Paint Ug;
    private Paint Uh;
    private int Ui;
    private int Uj;
    private int Uk;
    private int Ul;
    private int Um;
    private int Un;
    private int Uo;
    private int Up;
    private final BitmapDrawable Uq;
    private final Paint Ur;
    private final Rect Us;
    private final RectF Ut;
    private TextView Uu;
    private TextView Uv;
    private TextView Uw;
    private TextView Ux;
    private VoiceButton Uy;
    private ImageView Uz;
    private int centerX;
    private int centerY;
    VoiceData.VoiceModel mModel;
    private int mPaddingTop;

    static /* synthetic */ int e(VoiceRecordButton voiceRecordButton) {
        int i = voiceRecordButton.TX;
        voiceRecordButton.TX = i + 1;
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
                if (VoiceRecordButton.this.UD >= 360.0f) {
                    VoiceRecordButton.this.UD = 360.0f;
                    VoiceRecordButton.this.TX = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    VoiceRecordButton.this.UF = uptimeMillis;
                    VoiceRecordButton.this.UG = uptimeMillis + 200;
                    VoiceRecordButton.this.UD += (((float) (uptimeMillis - VoiceRecordButton.this.UF)) / 1000.0f) * VoiceRecordButton.this.UC;
                    sendEmptyMessageAtTime(1, VoiceRecordButton.this.UG);
                    VoiceRecordButton.e(VoiceRecordButton.this);
                }
                VoiceRecordButton.this.TW = VoiceRecordButton.this.TX % 6;
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
        this.Tc = 0L;
        this.TP = new int[4];
        this.TW = 0;
        this.TX = 0;
        this.centerX = 0;
        this.centerY = 0;
        this.TY = 0;
        this.TZ = 0;
        this.Ua = 0;
        this.Ub = 0;
        this.Uc = 0;
        this.Ud = 0;
        this.Ui = -1724676609;
        this.Uj = 1546880511;
        this.Uk = 674465279;
        this.Ul = 255034879;
        this.Um = -1725669966;
        this.Un = 1545887154;
        this.Uo = 673471922;
        this.Up = 254041522;
        this.Ur = new Paint(1);
        this.Us = new Rect();
        this.Ut = new RectF();
        this.Tk = 0;
        this.UH = new int[2];
        this.UI = new a();
        this.Tb = 0;
        this.UK = 0;
        this.TP[0] = context.getResources().getDimensionPixelSize(e.C0210e.ds24);
        this.TP[1] = context.getResources().getDimensionPixelSize(e.C0210e.ds8);
        this.TP[2] = context.getResources().getDimensionPixelSize(e.C0210e.ds22);
        this.TP[3] = context.getResources().getDimensionPixelSize(e.C0210e.ds36);
        this.TY = context.getResources().getDimensionPixelSize(e.C0210e.ds134);
        this.TZ = this.TY + context.getResources().getDimensionPixelSize(e.C0210e.ds14);
        this.Ua = this.TZ + context.getResources().getDimensionPixelSize(e.C0210e.ds16);
        this.Ub = this.Ua + context.getResources().getDimensionPixelSize(e.C0210e.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.Uc = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.Ud = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.Uc = context.getResources().getDimensionPixelSize(e.C0210e.ds70);
            this.Ud = context.getResources().getDimensionPixelSize(e.C0210e.ds210);
        }
        this.mPaddingTop = context.getResources().getDimensionPixelSize(e.C0210e.ds26);
        this.TQ = context.getResources().getDimensionPixelSize(e.C0210e.ds10);
        this.TR = context.getResources().getDimensionPixelSize(e.C0210e.ds14);
        this.TS = context.getResources().getDimensionPixelSize(e.C0210e.ds4);
        this.TT = context.getResources().getDimensionPixelSize(e.C0210e.ds4);
        this.TU = context.getResources().getDimensionPixelSize(e.C0210e.ds12);
        this.TV = context.getResources().getDimensionPixelSize(e.C0210e.ds2);
        this.Ur.setStyle(Paint.Style.STROKE);
        this.Ur.setStrokeWidth(this.TU);
        this.Uq = (BitmapDrawable) getResources().getDrawable(e.f.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        aW(context);
        qe();
        this.UH[0] = al.getColor(e.d.common_color_10151);
        this.UH[1] = al.getColor(e.d.common_color_10152);
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
        int measuredWidth = this.Uy.getMeasuredWidth();
        int measuredHeight = this.Uy.getMeasuredHeight();
        int measuredWidth2 = this.Uv.getMeasuredWidth();
        this.Uv.layout((i5 - measuredWidth2) >> 1, this.mPaddingTop + i2, (measuredWidth2 + i5) >> 1, this.Uv.getMeasuredHeight() + this.mPaddingTop + i2);
        int bottom = this.Uv.getBottom();
        this.Uy.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.centerX = (measuredWidth / 2) + i6;
        this.centerY = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.Ux.getMeasuredWidth();
        int measuredHeight2 = this.Ux.getMeasuredHeight();
        int top = this.Uy.getTop();
        this.Ux.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.Uu.getMeasuredWidth();
        int measuredHeight3 = this.Uu.getMeasuredHeight();
        int right = this.Uy.getRight() - this.TQ;
        int bottom2 = this.Uy.getBottom() - this.TR;
        this.Uu.layout(this.Uc + i6, this.Ud + bottom, measuredWidth4 + i6 + this.Uc, measuredHeight3 + this.Ud + bottom);
        int measuredWidth5 = this.Uz.getMeasuredWidth();
        this.Uz.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.Uz.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.UB.getMeasuredWidth();
        this.UB.layout((i5 - measuredWidth6) >> 1, (this.Uu.getTop() - this.UB.getMeasuredHeight()) - this.TS, (measuredWidth6 + i5) >> 1, (this.Uu.getTop() + i2) - this.TS);
        this.Uy.getLeft();
        this.Uy.getRight();
        int measuredWidth7 = this.Uw.getMeasuredWidth();
        int measuredHeight4 = this.Uw.getMeasuredHeight();
        int bottom3 = this.Uy.getBottom();
        this.Uw.layout((i5 - measuredWidth7) >> 1, this.TP[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.TP[3]);
        this.Us.set((i5 - this.Uq.getIntrinsicWidth()) >> 1, this.Uz.getTop() - this.TT, (i5 + this.Uq.getIntrinsicHeight()) >> 1, (this.Uz.getTop() + this.Uq.getIntrinsicHeight()) - this.TT);
        this.Uq.setBounds(this.Us);
        this.Ut.set(this.Uz.getLeft() + (this.TU >> 1) + this.TV, this.Uz.getTop() + (this.TU >> 1) + this.TV, (this.Uz.getRight() - (this.TU >> 1)) - this.TV, (this.Uz.getBottom() - (this.TU >> 1)) - this.TV);
        if (this.UJ == null) {
            this.UJ = new SweepGradient(this.Ut.centerX(), this.Ut.centerY(), this.UH, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.UJ.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.Ut.centerX(), this.Ut.centerY());
            this.UJ.setLocalMatrix(matrix);
            this.Ur.setShader(this.UJ);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        f(canvas);
        super.dispatchDraw(canvas);
    }

    private void pQ() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.Tm == null) {
            this.Tm = new com.baidu.tbadk.core.dialog.a(i.aK(getContext()).getPageActivity());
            this.Tm.eK(getContext().getString(e.j.voice_restart_tip)).a(getContext().getString(e.j.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    VoiceRecordButton.this.qa();
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
            this.Tm.BS();
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
        this.Uv = (TextView) findViewById(e.g.tip_error);
        al.c(this.Uv, e.d.cp_cont_i, 1);
        this.Uw = (TextView) findViewById(e.g.tip_operator);
        this.Ux = (TextView) findViewById(e.g.tip_time_out);
        this.Uy = (VoiceButton) findViewById(e.g.voice_bnt);
        this.Uu = (TextView) findViewById(e.g.restart);
        this.Uz = (ImageView) findViewById(e.g.play_img);
        this.UB = (TextView) findViewById(e.g.play_time);
        this.UB.setClickable(false);
        this.Uu.setOnClickListener(this);
        this.Uz.setOnClickListener(this);
        this.Uy.setRecorderView(this);
        qa();
    }

    private void pZ() {
        this.Uy.setVisibility(4);
        this.UB.setVisibility(0);
        this.Uu.setVisibility(0);
        al.c(this.UB, e.d.cp_cont_f, 1);
        al.c(this.Uu, e.d.cp_cont_f, 1);
        al.i(this.Uu, e.f.but_posts_record_again_selector);
        this.Uz.setVisibility(0);
        if (this.mModel != null) {
            this.UB.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.Uz.setContentDescription(String.format(getContext().getString(e.j.listen_time), Integer.valueOf(this.mModel.duration)));
            al.c(this.Uz, e.f.but_posts_record_play_selector);
        }
        al.c(this.Uw, e.d.cp_cont_c, 1);
        this.Uw.setText(getContext().getString(e.j.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qa() {
        al.c(this.Uy, e.f.but_posts_record_zero_selector);
        this.Uy.setVisibility(0);
        this.TW = 0;
        this.Uz.setVisibility(4);
        this.UB.setVisibility(4);
        this.Uu.setVisibility(4);
        this.Ux.setVisibility(4);
        al.c(this.Uw, e.d.cp_cont_c, 1);
        this.Uw.setText(getContext().getString(e.j.voice_record_press_to_record));
    }

    public void reset() {
        qa();
        this.mModel = null;
        this.TW = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.Uv.setText("");
        this.Uv.setVisibility(4);
        this.TW = 0;
        pZ();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            qa();
            this.Uw.setText(getContext().getString(e.j.voice_record_release_to_stop));
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
        if (this.Uz != null && this.UB != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    al.c(this.UB, e.d.cp_cont_f, 1);
                    this.UB.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    al.c(this.Uz, e.f.but_posts_record_play_selector);
                    this.Uz.setContentDescription(String.format(getContext().getString(e.j.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.Uw.setText(getContext().getString(e.j.voice_play_tip));
                    qc();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    al.c(this.UB, e.d.cp_cont_f, 1);
                    al.c(this.Uz, e.f.but_posts_record_stop_selector);
                    this.Uz.setContentDescription(getContext().getString(e.j.pause_load));
                    this.Uw.setText(getContext().getString(e.j.voice_stop_tip));
                    qb();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        al.c(this.Ux, e.d.cp_cont_i, 1);
        al.c(this.Uv, e.d.cp_cont_i, 1);
        al.c(this.Uw, e.d.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.Ux.setVisibility(0);
                this.Ux.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.Ux != null) {
                            VoiceRecordButton.this.Ux.setVisibility(4);
                            VoiceRecordButton.this.Ux.setText("");
                        }
                    }
                }, SystemScreenshotManager.DELAY_TIME);
            } else if (i == 2) {
                this.Uv.setVisibility(0);
                this.Uv.setText(str);
                this.Uw.setText(e.j.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.Uv != null) {
                            VoiceRecordButton.this.Uv.setVisibility(4);
                            VoiceRecordButton.this.Uv.setText("");
                        }
                    }
                }, SystemScreenshotManager.DELAY_TIME);
            } else if (i == 5) {
                this.Uv.setVisibility(0);
                this.Uv.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.Uv != null) {
                            VoiceRecordButton.this.Uv.setVisibility(4);
                            VoiceRecordButton.this.Uv.setText("");
                        }
                    }
                }, SystemScreenshotManager.DELAY_TIME);
            } else {
                qa();
                this.Uv.setVisibility(0);
                this.Uv.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.Uv != null) {
                            VoiceRecordButton.this.Uv.setVisibility(4);
                            VoiceRecordButton.this.Uv.setText("");
                        }
                    }
                }, SystemScreenshotManager.DELAY_TIME);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.Uv.setVisibility(4);
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
        al.c(this.Uv, e.d.cp_cont_i, 1);
        this.Uv.setVisibility(0);
        this.Uv.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.Tb = Math.max(i, this.Tb);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.Tc > 200) {
            this.Tb = 0;
            this.Tc = uptimeMillis;
        }
        if (this.Tb < 10) {
            this.TW = 1;
            invalidate();
        } else if (this.Tb < 20) {
            this.TW = 2;
            invalidate();
        } else if (this.Tb < 30) {
            this.TW = 3;
            invalidate();
        } else if (this.Tb < 40) {
            this.TW = 4;
            invalidate();
        } else {
            this.TW = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bz(int i) {
        if (this.mModel != null && this.UB != null) {
            int i2 = i / 1000;
            if (this.UK != i2) {
                this.UB.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.UK = i2;
        }
    }

    private void qb() {
        if (this.mModel != null) {
            this.TW = 0;
            this.UC = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.UF = SystemClock.uptimeMillis();
            this.UG = this.UF + 200;
            this.UI.sendEmptyMessageAtTime(1, this.UG);
            invalidate();
        }
    }

    private void qc() {
        this.TW = 0;
        this.TX = 0;
        this.UC = 0.0f;
        this.UD = 0.0f;
        this.UI.removeMessages(1);
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
                pQ();
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
        this.UE = fVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void qd() {
    }

    public void qe() {
        this.Ue = new Paint();
        this.Ue.setAntiAlias(true);
        this.Ue.setStyle(Paint.Style.STROKE);
        this.Ue.setStrokeWidth(2.0f);
        this.Uf = new Paint();
        this.Uf.setAntiAlias(true);
        this.Uf.setStyle(Paint.Style.STROKE);
        this.Uf.setStrokeWidth(2.0f);
        this.Ug = new Paint();
        this.Ug.setAntiAlias(true);
        this.Ug.setStyle(Paint.Style.STROKE);
        this.Ug.setStrokeWidth(2.0f);
        this.Uh = new Paint();
        this.Uh.setAntiAlias(true);
        this.Uh.setStyle(Paint.Style.STROKE);
        this.Uh.setStrokeWidth(2.0f);
    }

    public void f(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.Ue.setColor(this.Um);
            this.Uf.setColor(this.Un);
            this.Ug.setColor(this.Uo);
            this.Uh.setColor(this.Up);
        } else {
            this.Ue.setColor(this.Ui);
            this.Uf.setColor(this.Uj);
            this.Ug.setColor(this.Uk);
            this.Uh.setColor(this.Ul);
        }
        if (this.TW == 2) {
            canvas.drawCircle(this.centerX, this.centerY, this.TY, this.Ue);
        } else if (this.TW == 3) {
            canvas.drawCircle(this.centerX, this.centerY, this.TY, this.Ue);
            canvas.drawCircle(this.centerX, this.centerY, this.TZ, this.Uf);
        } else if (this.TW == 4) {
            canvas.drawCircle(this.centerX, this.centerY, this.TY, this.Ue);
            canvas.drawCircle(this.centerX, this.centerY, this.TZ, this.Uf);
            canvas.drawCircle(this.centerX, this.centerY, this.Ua, this.Ug);
        } else if (this.TW == 5) {
            canvas.drawCircle(this.centerX, this.centerY, this.TY, this.Ue);
            canvas.drawCircle(this.centerX, this.centerY, this.TZ, this.Uf);
            canvas.drawCircle(this.centerX, this.centerY, this.Ua, this.Ug);
            canvas.drawCircle(this.centerX, this.centerY, this.Ub, this.Uh);
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
                    pZ();
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
    public void pR() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Tk;
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
        if (this.Tj != null) {
            this.Tj.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Tj = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Tk = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
    }
}
