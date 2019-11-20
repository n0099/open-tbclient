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
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.voice.VoiceButton;
/* loaded from: classes6.dex */
public class VoiceRecordButton extends ViewGroup implements View.OnClickListener, com.baidu.adp.lib.voice.f, VoiceManager.b, l {
    private int CB;
    private long CC;
    private EditorTools CJ;
    private int CK;
    private com.baidu.tbadk.core.dialog.a CM;
    private int DA;
    private int DC;
    private int DD;
    private int DE;
    private int DF;
    private int DG;
    private int DH;
    private Paint DI;
    private Paint DJ;
    private Paint DK;
    private Paint DL;
    private int DM;
    private int DN;
    private int DO;
    private int DQ;
    private int DR;
    private int DS;
    private int DT;
    private int DU;
    private final BitmapDrawable DV;
    private final Paint DW;
    private final Rect DX;
    private final RectF DY;
    private TextView DZ;
    private final int[] Dq;
    private int Dr;
    private final int Ds;
    private final int Dt;
    private final int Du;
    private final int Dv;
    private final int Dw;
    private int Dx;
    private int Dy;
    private int Dz;
    private TextView Ea;
    private TextView Eb;
    private TextView Ec;
    private VoiceButton Ed;
    private ImageView Ee;
    private TextView Ef;
    private float Eg;
    private float Eh;
    private f Ei;
    private long Ej;
    private long Ek;
    private final int[] El;
    private final a Em;
    private SweepGradient En;
    private int Eo;
    VoiceData.VoiceModel mModel;
    private int mPaddingTop;

    static /* synthetic */ int e(VoiceRecordButton voiceRecordButton) {
        int i = voiceRecordButton.Dy;
        voiceRecordButton.Dy = i + 1;
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
                if (VoiceRecordButton.this.Eh >= 360.0f) {
                    VoiceRecordButton.this.Eh = 360.0f;
                    VoiceRecordButton.this.Dy = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    VoiceRecordButton.this.Ej = uptimeMillis;
                    VoiceRecordButton.this.Ek = uptimeMillis + 200;
                    VoiceRecordButton.this.Eh += (((float) (uptimeMillis - VoiceRecordButton.this.Ej)) / 1000.0f) * VoiceRecordButton.this.Eg;
                    sendEmptyMessageAtTime(1, VoiceRecordButton.this.Ek);
                    VoiceRecordButton.e(VoiceRecordButton.this);
                }
                VoiceRecordButton.this.Dx = VoiceRecordButton.this.Dy % 6;
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
        this.CC = 0L;
        this.Dq = new int[4];
        this.Dx = 0;
        this.Dy = 0;
        this.Dz = 0;
        this.DA = 0;
        this.DC = 0;
        this.DD = 0;
        this.DE = 0;
        this.DF = 0;
        this.DG = 0;
        this.DH = 0;
        this.DM = -1724676609;
        this.DN = 1546880511;
        this.DO = 674465279;
        this.DQ = 255034879;
        this.DR = -1725669966;
        this.DS = 1545887154;
        this.DT = 673471922;
        this.DU = 254041522;
        this.DW = new Paint(1);
        this.DX = new Rect();
        this.DY = new RectF();
        this.CK = 0;
        this.El = new int[2];
        this.Em = new a();
        this.CB = 0;
        this.Eo = 0;
        this.Dq[0] = context.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.Dq[1] = context.getResources().getDimensionPixelSize(R.dimen.ds8);
        this.Dq[2] = context.getResources().getDimensionPixelSize(R.dimen.ds22);
        this.Dq[3] = context.getResources().getDimensionPixelSize(R.dimen.ds36);
        this.DC = context.getResources().getDimensionPixelSize(R.dimen.ds134);
        this.DD = this.DC + context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.DE = this.DD + context.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.DF = this.DE + context.getResources().getDimensionPixelSize(R.dimen.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.DG = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.DH = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.DG = context.getResources().getDimensionPixelSize(R.dimen.ds70);
            this.DH = context.getResources().getDimensionPixelSize(R.dimen.ds210);
        }
        this.mPaddingTop = context.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.Dr = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.Ds = context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.Dt = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.Du = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.Dv = context.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.Dw = context.getResources().getDimensionPixelSize(R.dimen.ds2);
        this.DW.setStyle(Paint.Style.STROKE);
        this.DW.setStrokeWidth(this.Dv);
        this.DV = (BitmapDrawable) getResources().getDrawable(R.drawable.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        af(context);
        ls();
        this.El[0] = am.getColor(R.color.common_color_10151);
        this.El[1] = am.getColor(R.color.common_color_10152);
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
        int measuredWidth = this.Ed.getMeasuredWidth();
        int measuredHeight = this.Ed.getMeasuredHeight();
        int measuredWidth2 = this.Ea.getMeasuredWidth();
        this.Ea.layout((i5 - measuredWidth2) >> 1, this.mPaddingTop + i2, (measuredWidth2 + i5) >> 1, this.Ea.getMeasuredHeight() + this.mPaddingTop + i2);
        int bottom = this.Ea.getBottom();
        this.Ed.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.Dz = (measuredWidth / 2) + i6;
        this.DA = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.Ec.getMeasuredWidth();
        int measuredHeight2 = this.Ec.getMeasuredHeight();
        int top = this.Ed.getTop();
        this.Ec.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.DZ.getMeasuredWidth();
        int measuredHeight3 = this.DZ.getMeasuredHeight();
        int right = this.Ed.getRight() - this.Dr;
        int bottom2 = this.Ed.getBottom() - this.Ds;
        this.DZ.layout(this.DG + i6, this.DH + bottom, measuredWidth4 + i6 + this.DG, measuredHeight3 + this.DH + bottom);
        int measuredWidth5 = this.Ee.getMeasuredWidth();
        this.Ee.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.Ee.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.Ef.getMeasuredWidth();
        this.Ef.layout((i5 - measuredWidth6) >> 1, (this.DZ.getTop() - this.Ef.getMeasuredHeight()) - this.Dt, (measuredWidth6 + i5) >> 1, (this.DZ.getTop() + i2) - this.Dt);
        this.Ed.getLeft();
        this.Ed.getRight();
        int measuredWidth7 = this.Eb.getMeasuredWidth();
        int measuredHeight4 = this.Eb.getMeasuredHeight();
        int bottom3 = this.Ed.getBottom();
        this.Eb.layout((i5 - measuredWidth7) >> 1, this.Dq[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.Dq[3]);
        this.DX.set((i5 - this.DV.getIntrinsicWidth()) >> 1, this.Ee.getTop() - this.Du, (i5 + this.DV.getIntrinsicHeight()) >> 1, (this.Ee.getTop() + this.DV.getIntrinsicHeight()) - this.Du);
        this.DV.setBounds(this.DX);
        this.DY.set(this.Ee.getLeft() + (this.Dv >> 1) + this.Dw, this.Ee.getTop() + (this.Dv >> 1) + this.Dw, (this.Ee.getRight() - (this.Dv >> 1)) - this.Dw, (this.Ee.getBottom() - (this.Dv >> 1)) - this.Dw);
        if (this.En == null) {
            this.En = new SweepGradient(this.DY.centerX(), this.DY.centerY(), this.El, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.En.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.DY.centerX(), this.DY.centerY());
            this.En.setLocalMatrix(matrix);
            this.DW.setShader(this.En);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        e(canvas);
        super.dispatchDraw(canvas);
    }

    private void ld() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.CM == null) {
            this.CM = new com.baidu.tbadk.core.dialog.a(i.ab(getContext()).getPageActivity());
            this.CM.nn(getContext().getString(R.string.voice_restart_tip)).a(getContext().getString(R.string.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    VoiceRecordButton.this.lo();
                    if (VoiceRecordButton.this.getVoiceManager() != null && VoiceRecordButton.this.mModel != null) {
                        if (recorderManager != null) {
                            recorderManager.bm(VoiceRecordButton.this.mModel.voiceId);
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
            this.CM.akM();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.mModel != null) {
                if (recorderManager != null) {
                    recorderManager.bm(this.mModel.voiceId);
                }
                this.mModel = null;
            }
        }
    }

    private void af(Context context) {
        LayoutInflater.from(context).inflate(R.layout.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.Ea = (TextView) findViewById(R.id.tip_error);
        am.setViewTextColor(this.Ea, R.color.cp_cont_a, 1);
        this.Eb = (TextView) findViewById(R.id.tip_operator);
        this.Ec = (TextView) findViewById(R.id.tip_time_out);
        this.Ed = (VoiceButton) findViewById(R.id.voice_bnt);
        this.DZ = (TextView) findViewById(R.id.restart);
        this.Ee = (ImageView) findViewById(R.id.play_img);
        this.Ef = (TextView) findViewById(R.id.play_time);
        this.Ef.setClickable(false);
        this.DZ.setOnClickListener(this);
        this.Ee.setOnClickListener(this);
        this.Ed.setRecorderView(this);
        lo();
    }

    private void ln() {
        this.Ed.setVisibility(4);
        this.Ef.setVisibility(0);
        this.DZ.setVisibility(0);
        am.setViewTextColor(this.Ef, R.color.cp_cont_f, 1);
        am.setViewTextColor(this.DZ, R.color.cp_cont_f, 1);
        am.setBackgroundResource(this.DZ, R.drawable.but_posts_record_again_selector);
        this.Ee.setVisibility(0);
        if (this.mModel != null) {
            this.Ef.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.Ee.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(this.mModel.duration)));
            am.setImageResource(this.Ee, R.drawable.but_posts_record_play_selector);
        }
        am.setViewTextColor(this.Eb, R.color.cp_cont_c, 1);
        this.Eb.setText(getContext().getString(R.string.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lo() {
        am.setImageResource(this.Ed, R.drawable.but_posts_record_zero_selector);
        this.Ed.setVisibility(0);
        this.Dx = 0;
        this.Ee.setVisibility(4);
        this.Ef.setVisibility(4);
        this.DZ.setVisibility(4);
        this.Ec.setVisibility(4);
        am.setViewTextColor(this.Eb, R.color.cp_cont_c, 1);
        this.Eb.setText(getContext().getString(R.string.voice_record_press_to_record));
    }

    public void reset() {
        lo();
        this.mModel = null;
        this.Dx = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.Ea.setText("");
        this.Ea.setVisibility(4);
        this.Dx = 0;
        ln();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, HanziToPinyin.Token.SEPARATOR));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            lo();
            this.Eb.setText(getContext().getString(R.string.voice_record_release_to_stop));
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
        if (this.Ee != null && this.Ef != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    am.setViewTextColor(this.Ef, R.color.cp_cont_f, 1);
                    this.Ef.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    am.setImageResource(this.Ee, R.drawable.but_posts_record_play_selector);
                    this.Ee.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.Eb.setText(getContext().getString(R.string.voice_play_tip));
                    lq();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    am.setViewTextColor(this.Ef, R.color.cp_cont_f, 1);
                    am.setImageResource(this.Ee, R.drawable.but_posts_record_stop_selector);
                    this.Ee.setContentDescription(getContext().getString(R.string.pause_load));
                    this.Eb.setText(getContext().getString(R.string.voice_stop_tip));
                    lp();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        am.setViewTextColor(this.Ec, R.color.cp_cont_a, 1);
        am.setViewTextColor(this.Ea, R.color.cp_cont_a, 1);
        am.setViewTextColor(this.Eb, R.color.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.Ec.setVisibility(0);
                this.Ec.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.Ec != null) {
                            VoiceRecordButton.this.Ec.setVisibility(4);
                            VoiceRecordButton.this.Ec.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 2) {
                this.Ea.setVisibility(0);
                this.Ea.setText(str);
                this.Eb.setText(R.string.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.Ea != null) {
                            VoiceRecordButton.this.Ea.setVisibility(4);
                            VoiceRecordButton.this.Ea.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 5) {
                this.Ea.setVisibility(0);
                this.Ea.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.Ea != null) {
                            VoiceRecordButton.this.Ea.setVisibility(4);
                            VoiceRecordButton.this.Ea.setText("");
                        }
                    }
                }, 2000L);
            } else {
                lo();
                this.Ea.setVisibility(0);
                this.Ea.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.Ea != null) {
                            VoiceRecordButton.this.Ea.setVisibility(4);
                            VoiceRecordButton.this.Ea.setText("");
                        }
                    }
                }, 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.Ea.setVisibility(4);
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
        am.setViewTextColor(this.Ea, R.color.cp_cont_a, 1);
        this.Ea.setVisibility(0);
        this.Ea.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.CB = Math.max(i, this.CB);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.CC > 200) {
            this.CB = 0;
            this.CC = uptimeMillis;
        }
        if (this.CB < 10) {
            this.Dx = 1;
            invalidate();
        } else if (this.CB < 20) {
            this.Dx = 2;
            invalidate();
        } else if (this.CB < 30) {
            this.Dx = 3;
            invalidate();
        } else if (this.CB < 40) {
            this.Dx = 4;
            invalidate();
        } else {
            this.Dx = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aA(int i) {
        if (this.mModel != null && this.Ef != null) {
            int i2 = i / 1000;
            if (this.Eo != i2) {
                this.Ef.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.Eo = i2;
        }
    }

    private void lp() {
        if (this.mModel != null) {
            this.Dx = 0;
            this.Eg = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.Ej = SystemClock.uptimeMillis();
            this.Ek = this.Ej + 200;
            this.Em.sendEmptyMessageAtTime(1, this.Ek);
            invalidate();
        }
    }

    private void lq() {
        this.Dx = 0;
        this.Dy = 0;
        this.Eg = 0.0f;
        this.Eh = 0.0f;
        this.Em.removeMessages(1);
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
                ld();
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
        this.Ei = fVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lr() {
    }

    public void ls() {
        this.DI = new Paint();
        this.DI.setAntiAlias(true);
        this.DI.setStyle(Paint.Style.STROKE);
        this.DI.setStrokeWidth(2.0f);
        this.DJ = new Paint();
        this.DJ.setAntiAlias(true);
        this.DJ.setStyle(Paint.Style.STROKE);
        this.DJ.setStrokeWidth(2.0f);
        this.DK = new Paint();
        this.DK.setAntiAlias(true);
        this.DK.setStyle(Paint.Style.STROKE);
        this.DK.setStrokeWidth(2.0f);
        this.DL = new Paint();
        this.DL.setAntiAlias(true);
        this.DL.setStyle(Paint.Style.STROKE);
        this.DL.setStrokeWidth(2.0f);
    }

    public void e(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.DI.setColor(this.DR);
            this.DJ.setColor(this.DS);
            this.DK.setColor(this.DT);
            this.DL.setColor(this.DU);
        } else {
            this.DI.setColor(this.DM);
            this.DJ.setColor(this.DN);
            this.DK.setColor(this.DO);
            this.DL.setColor(this.DQ);
        }
        if (this.Dx == 2) {
            canvas.drawCircle(this.Dz, this.DA, this.DC, this.DI);
        } else if (this.Dx == 3) {
            canvas.drawCircle(this.Dz, this.DA, this.DC, this.DI);
            canvas.drawCircle(this.Dz, this.DA, this.DD, this.DJ);
        } else if (this.Dx == 4) {
            canvas.drawCircle(this.Dz, this.DA, this.DC, this.DI);
            canvas.drawCircle(this.Dz, this.DA, this.DD, this.DJ);
            canvas.drawCircle(this.Dz, this.DA, this.DE, this.DK);
        } else if (this.Dx == 5) {
            canvas.drawCircle(this.Dz, this.DA, this.DC, this.DI);
            canvas.drawCircle(this.Dz, this.DA, this.DD, this.DJ);
            canvas.drawCircle(this.Dz, this.DA, this.DE, this.DK);
            canvas.drawCircle(this.Dz, this.DA, this.DF, this.DL);
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
                    ln();
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
    public void le() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.CK;
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
        if (this.CJ != null) {
            this.CJ.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.CJ = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.CK = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
    }
}
