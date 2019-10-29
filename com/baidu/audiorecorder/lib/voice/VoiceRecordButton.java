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
    private final int[] DS;
    private int DT;
    private final int DU;
    private final int DV;
    private final int DW;
    private final int DX;
    private final int DY;
    private int DZ;
    private int Dd;
    private long De;
    private EditorTools Dl;
    private int Dm;
    private com.baidu.tbadk.core.dialog.a Do;
    private TextView EA;
    private TextView EB;
    private TextView EC;
    private VoiceButton ED;
    private ImageView EE;
    private TextView EF;
    private float EG;
    private float EH;
    private f EI;
    private long EJ;
    private long EK;
    private final int[] EL;
    private final a EM;
    private SweepGradient EN;
    private int EO;
    private int Ea;
    private int Eb;
    private int Ec;
    private int Ed;
    private int Ee;
    private int Ef;
    private int Eg;
    private int Eh;
    private int Ei;
    private Paint Ej;
    private Paint Ek;
    private Paint El;
    private Paint Em;
    private int En;
    private int Eo;
    private int Ep;
    private int Eq;
    private int Er;
    private int Es;
    private int Et;
    private int Eu;
    private final BitmapDrawable Ev;
    private final Paint Ew;
    private final Rect Ex;
    private final RectF Ey;
    private TextView Ez;
    VoiceData.VoiceModel mModel;
    private int mPaddingTop;

    static /* synthetic */ int e(VoiceRecordButton voiceRecordButton) {
        int i = voiceRecordButton.Ea;
        voiceRecordButton.Ea = i + 1;
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
                if (VoiceRecordButton.this.EH >= 360.0f) {
                    VoiceRecordButton.this.EH = 360.0f;
                    VoiceRecordButton.this.Ea = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    VoiceRecordButton.this.EJ = uptimeMillis;
                    VoiceRecordButton.this.EK = uptimeMillis + 200;
                    VoiceRecordButton.this.EH += (((float) (uptimeMillis - VoiceRecordButton.this.EJ)) / 1000.0f) * VoiceRecordButton.this.EG;
                    sendEmptyMessageAtTime(1, VoiceRecordButton.this.EK);
                    VoiceRecordButton.e(VoiceRecordButton.this);
                }
                VoiceRecordButton.this.DZ = VoiceRecordButton.this.Ea % 6;
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
        this.De = 0L;
        this.DS = new int[4];
        this.DZ = 0;
        this.Ea = 0;
        this.Eb = 0;
        this.Ec = 0;
        this.Ed = 0;
        this.Ee = 0;
        this.Ef = 0;
        this.Eg = 0;
        this.Eh = 0;
        this.Ei = 0;
        this.En = -1724676609;
        this.Eo = 1546880511;
        this.Ep = 674465279;
        this.Eq = 255034879;
        this.Er = -1725669966;
        this.Es = 1545887154;
        this.Et = 673471922;
        this.Eu = 254041522;
        this.Ew = new Paint(1);
        this.Ex = new Rect();
        this.Ey = new RectF();
        this.Dm = 0;
        this.EL = new int[2];
        this.EM = new a();
        this.Dd = 0;
        this.EO = 0;
        this.DS[0] = context.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.DS[1] = context.getResources().getDimensionPixelSize(R.dimen.ds8);
        this.DS[2] = context.getResources().getDimensionPixelSize(R.dimen.ds22);
        this.DS[3] = context.getResources().getDimensionPixelSize(R.dimen.ds36);
        this.Ed = context.getResources().getDimensionPixelSize(R.dimen.ds134);
        this.Ee = this.Ed + context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.Ef = this.Ee + context.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.Eg = this.Ef + context.getResources().getDimensionPixelSize(R.dimen.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.Eh = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.Ei = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.Eh = context.getResources().getDimensionPixelSize(R.dimen.ds70);
            this.Ei = context.getResources().getDimensionPixelSize(R.dimen.ds210);
        }
        this.mPaddingTop = context.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.DT = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.DU = context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.DV = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.DW = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.DX = context.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.DY = context.getResources().getDimensionPixelSize(R.dimen.ds2);
        this.Ew.setStyle(Paint.Style.STROKE);
        this.Ew.setStrokeWidth(this.DX);
        this.Ev = (BitmapDrawable) getResources().getDrawable(R.drawable.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        af(context);
        ls();
        this.EL[0] = am.getColor(R.color.common_color_10151);
        this.EL[1] = am.getColor(R.color.common_color_10152);
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
        int measuredWidth = this.ED.getMeasuredWidth();
        int measuredHeight = this.ED.getMeasuredHeight();
        int measuredWidth2 = this.EA.getMeasuredWidth();
        this.EA.layout((i5 - measuredWidth2) >> 1, this.mPaddingTop + i2, (measuredWidth2 + i5) >> 1, this.EA.getMeasuredHeight() + this.mPaddingTop + i2);
        int bottom = this.EA.getBottom();
        this.ED.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.Eb = (measuredWidth / 2) + i6;
        this.Ec = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.EC.getMeasuredWidth();
        int measuredHeight2 = this.EC.getMeasuredHeight();
        int top = this.ED.getTop();
        this.EC.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.Ez.getMeasuredWidth();
        int measuredHeight3 = this.Ez.getMeasuredHeight();
        int right = this.ED.getRight() - this.DT;
        int bottom2 = this.ED.getBottom() - this.DU;
        this.Ez.layout(this.Eh + i6, this.Ei + bottom, measuredWidth4 + i6 + this.Eh, measuredHeight3 + this.Ei + bottom);
        int measuredWidth5 = this.EE.getMeasuredWidth();
        this.EE.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.EE.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.EF.getMeasuredWidth();
        this.EF.layout((i5 - measuredWidth6) >> 1, (this.Ez.getTop() - this.EF.getMeasuredHeight()) - this.DV, (measuredWidth6 + i5) >> 1, (this.Ez.getTop() + i2) - this.DV);
        this.ED.getLeft();
        this.ED.getRight();
        int measuredWidth7 = this.EB.getMeasuredWidth();
        int measuredHeight4 = this.EB.getMeasuredHeight();
        int bottom3 = this.ED.getBottom();
        this.EB.layout((i5 - measuredWidth7) >> 1, this.DS[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.DS[3]);
        this.Ex.set((i5 - this.Ev.getIntrinsicWidth()) >> 1, this.EE.getTop() - this.DW, (i5 + this.Ev.getIntrinsicHeight()) >> 1, (this.EE.getTop() + this.Ev.getIntrinsicHeight()) - this.DW);
        this.Ev.setBounds(this.Ex);
        this.Ey.set(this.EE.getLeft() + (this.DX >> 1) + this.DY, this.EE.getTop() + (this.DX >> 1) + this.DY, (this.EE.getRight() - (this.DX >> 1)) - this.DY, (this.EE.getBottom() - (this.DX >> 1)) - this.DY);
        if (this.EN == null) {
            this.EN = new SweepGradient(this.Ey.centerX(), this.Ey.centerY(), this.EL, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.EN.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.Ey.centerX(), this.Ey.centerY());
            this.EN.setLocalMatrix(matrix);
            this.Ew.setShader(this.EN);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        e(canvas);
        super.dispatchDraw(canvas);
    }

    private void ld() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.Do == null) {
            this.Do = new com.baidu.tbadk.core.dialog.a(i.ab(getContext()).getPageActivity());
            this.Do.nn(getContext().getString(R.string.voice_restart_tip)).a(getContext().getString(R.string.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.2
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
            this.Do.akO();
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
        this.EA = (TextView) findViewById(R.id.tip_error);
        am.setViewTextColor(this.EA, R.color.cp_cont_a, 1);
        this.EB = (TextView) findViewById(R.id.tip_operator);
        this.EC = (TextView) findViewById(R.id.tip_time_out);
        this.ED = (VoiceButton) findViewById(R.id.voice_bnt);
        this.Ez = (TextView) findViewById(R.id.restart);
        this.EE = (ImageView) findViewById(R.id.play_img);
        this.EF = (TextView) findViewById(R.id.play_time);
        this.EF.setClickable(false);
        this.Ez.setOnClickListener(this);
        this.EE.setOnClickListener(this);
        this.ED.setRecorderView(this);
        lo();
    }

    private void ln() {
        this.ED.setVisibility(4);
        this.EF.setVisibility(0);
        this.Ez.setVisibility(0);
        am.setViewTextColor(this.EF, R.color.cp_cont_f, 1);
        am.setViewTextColor(this.Ez, R.color.cp_cont_f, 1);
        am.setBackgroundResource(this.Ez, R.drawable.but_posts_record_again_selector);
        this.EE.setVisibility(0);
        if (this.mModel != null) {
            this.EF.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.EE.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(this.mModel.duration)));
            am.setImageResource(this.EE, R.drawable.but_posts_record_play_selector);
        }
        am.setViewTextColor(this.EB, R.color.cp_cont_c, 1);
        this.EB.setText(getContext().getString(R.string.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lo() {
        am.setImageResource(this.ED, R.drawable.but_posts_record_zero_selector);
        this.ED.setVisibility(0);
        this.DZ = 0;
        this.EE.setVisibility(4);
        this.EF.setVisibility(4);
        this.Ez.setVisibility(4);
        this.EC.setVisibility(4);
        am.setViewTextColor(this.EB, R.color.cp_cont_c, 1);
        this.EB.setText(getContext().getString(R.string.voice_record_press_to_record));
    }

    public void reset() {
        lo();
        this.mModel = null;
        this.DZ = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.EA.setText("");
        this.EA.setVisibility(4);
        this.DZ = 0;
        ln();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, HanziToPinyin.Token.SEPARATOR));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            lo();
            this.EB.setText(getContext().getString(R.string.voice_record_release_to_stop));
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
        if (this.EE != null && this.EF != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    am.setViewTextColor(this.EF, R.color.cp_cont_f, 1);
                    this.EF.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    am.setImageResource(this.EE, R.drawable.but_posts_record_play_selector);
                    this.EE.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.EB.setText(getContext().getString(R.string.voice_play_tip));
                    lq();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    am.setViewTextColor(this.EF, R.color.cp_cont_f, 1);
                    am.setImageResource(this.EE, R.drawable.but_posts_record_stop_selector);
                    this.EE.setContentDescription(getContext().getString(R.string.pause_load));
                    this.EB.setText(getContext().getString(R.string.voice_stop_tip));
                    lp();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        am.setViewTextColor(this.EC, R.color.cp_cont_a, 1);
        am.setViewTextColor(this.EA, R.color.cp_cont_a, 1);
        am.setViewTextColor(this.EB, R.color.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.EC.setVisibility(0);
                this.EC.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.EC != null) {
                            VoiceRecordButton.this.EC.setVisibility(4);
                            VoiceRecordButton.this.EC.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 2) {
                this.EA.setVisibility(0);
                this.EA.setText(str);
                this.EB.setText(R.string.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.EA != null) {
                            VoiceRecordButton.this.EA.setVisibility(4);
                            VoiceRecordButton.this.EA.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 5) {
                this.EA.setVisibility(0);
                this.EA.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.EA != null) {
                            VoiceRecordButton.this.EA.setVisibility(4);
                            VoiceRecordButton.this.EA.setText("");
                        }
                    }
                }, 2000L);
            } else {
                lo();
                this.EA.setVisibility(0);
                this.EA.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.EA != null) {
                            VoiceRecordButton.this.EA.setVisibility(4);
                            VoiceRecordButton.this.EA.setText("");
                        }
                    }
                }, 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.EA.setVisibility(4);
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
        am.setViewTextColor(this.EA, R.color.cp_cont_a, 1);
        this.EA.setVisibility(0);
        this.EA.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.Dd = Math.max(i, this.Dd);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.De > 200) {
            this.Dd = 0;
            this.De = uptimeMillis;
        }
        if (this.Dd < 10) {
            this.DZ = 1;
            invalidate();
        } else if (this.Dd < 20) {
            this.DZ = 2;
            invalidate();
        } else if (this.Dd < 30) {
            this.DZ = 3;
            invalidate();
        } else if (this.Dd < 40) {
            this.DZ = 4;
            invalidate();
        } else {
            this.DZ = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aA(int i) {
        if (this.mModel != null && this.EF != null) {
            int i2 = i / 1000;
            if (this.EO != i2) {
                this.EF.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.EO = i2;
        }
    }

    private void lp() {
        if (this.mModel != null) {
            this.DZ = 0;
            this.EG = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.EJ = SystemClock.uptimeMillis();
            this.EK = this.EJ + 200;
            this.EM.sendEmptyMessageAtTime(1, this.EK);
            invalidate();
        }
    }

    private void lq() {
        this.DZ = 0;
        this.Ea = 0;
        this.EG = 0.0f;
        this.EH = 0.0f;
        this.EM.removeMessages(1);
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
        this.EI = fVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lr() {
    }

    public void ls() {
        this.Ej = new Paint();
        this.Ej.setAntiAlias(true);
        this.Ej.setStyle(Paint.Style.STROKE);
        this.Ej.setStrokeWidth(2.0f);
        this.Ek = new Paint();
        this.Ek.setAntiAlias(true);
        this.Ek.setStyle(Paint.Style.STROKE);
        this.Ek.setStrokeWidth(2.0f);
        this.El = new Paint();
        this.El.setAntiAlias(true);
        this.El.setStyle(Paint.Style.STROKE);
        this.El.setStrokeWidth(2.0f);
        this.Em = new Paint();
        this.Em.setAntiAlias(true);
        this.Em.setStyle(Paint.Style.STROKE);
        this.Em.setStrokeWidth(2.0f);
    }

    public void e(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.Ej.setColor(this.Er);
            this.Ek.setColor(this.Es);
            this.El.setColor(this.Et);
            this.Em.setColor(this.Eu);
        } else {
            this.Ej.setColor(this.En);
            this.Ek.setColor(this.Eo);
            this.El.setColor(this.Ep);
            this.Em.setColor(this.Eq);
        }
        if (this.DZ == 2) {
            canvas.drawCircle(this.Eb, this.Ec, this.Ed, this.Ej);
        } else if (this.DZ == 3) {
            canvas.drawCircle(this.Eb, this.Ec, this.Ed, this.Ej);
            canvas.drawCircle(this.Eb, this.Ec, this.Ee, this.Ek);
        } else if (this.DZ == 4) {
            canvas.drawCircle(this.Eb, this.Ec, this.Ed, this.Ej);
            canvas.drawCircle(this.Eb, this.Ec, this.Ee, this.Ek);
            canvas.drawCircle(this.Eb, this.Ec, this.Ef, this.El);
        } else if (this.DZ == 5) {
            canvas.drawCircle(this.Eb, this.Ec, this.Ed, this.Ej);
            canvas.drawCircle(this.Eb, this.Ec, this.Ee, this.Ek);
            canvas.drawCircle(this.Eb, this.Ec, this.Ef, this.El);
            canvas.drawCircle(this.Eb, this.Ec, this.Eg, this.Em);
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
        return this.Dm;
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
        if (this.Dl != null) {
            this.Dl.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Dl = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Dm = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
    }
}
