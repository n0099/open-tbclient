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
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.voice.VoiceButton;
/* loaded from: classes11.dex */
public class VoiceRecordButton extends ViewGroup implements View.OnClickListener, com.baidu.adp.lib.voice.f, VoiceManager.b, m {
    private int YV;
    private long YW;
    private final int[] ZF;
    private int ZG;
    private final int ZH;
    private final int ZI;
    private final int ZJ;
    private final int ZK;
    private final int ZL;
    private int ZM;
    private int ZN;
    private int ZO;
    private int ZP;
    private int ZQ;
    private int ZR;
    private int ZS;
    private int ZT;
    private int ZU;
    private int ZV;
    private Paint ZW;
    private Paint ZX;
    private Paint ZY;
    private Paint ZZ;
    private EditorTools Zd;
    private int Ze;
    private com.baidu.tbadk.core.dialog.a Zg;
    private final a aaA;
    private SweepGradient aaB;
    private int aaC;
    private int aaa;
    private int aab;
    private int aac;
    private int aae;
    private int aaf;
    private int aag;
    private int aah;
    private int aai;
    private final BitmapDrawable aaj;
    private final Paint aak;
    private final Rect aal;
    private final RectF aam;
    private TextView aan;
    private TextView aao;
    private TextView aap;
    private TextView aaq;
    private VoiceButton aar;
    private ImageView aas;
    private TextView aat;
    private float aau;
    private float aav;
    private f aaw;
    private long aax;
    private long aay;
    private final int[] aaz;
    VoiceData.VoiceModel mModel;
    private int mPaddingTop;

    static /* synthetic */ int e(VoiceRecordButton voiceRecordButton) {
        int i = voiceRecordButton.ZN;
        voiceRecordButton.ZN = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends Handler {
        private a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                if (VoiceRecordButton.this.aav >= 360.0f) {
                    VoiceRecordButton.this.aav = 360.0f;
                    VoiceRecordButton.this.ZN = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    VoiceRecordButton.this.aax = uptimeMillis;
                    VoiceRecordButton.this.aay = uptimeMillis + 200;
                    VoiceRecordButton.this.aav += (((float) (uptimeMillis - VoiceRecordButton.this.aax)) / 1000.0f) * VoiceRecordButton.this.aau;
                    sendEmptyMessageAtTime(1, VoiceRecordButton.this.aay);
                    VoiceRecordButton.e(VoiceRecordButton.this);
                }
                VoiceRecordButton.this.ZM = VoiceRecordButton.this.ZN % 6;
                VoiceRecordButton.this.invalidate();
            }
        }
    }

    public static VoiceRecordButton I(Context context) {
        return new VoiceRecordButton(context);
    }

    public VoiceRecordButton(Context context) {
        this(context, null);
    }

    public VoiceRecordButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.YW = 0L;
        this.ZF = new int[4];
        this.ZM = 0;
        this.ZN = 0;
        this.ZO = 0;
        this.ZP = 0;
        this.ZQ = 0;
        this.ZR = 0;
        this.ZS = 0;
        this.ZT = 0;
        this.ZU = 0;
        this.ZV = 0;
        this.aaa = -1724676609;
        this.aab = 1546880511;
        this.aac = 674465279;
        this.aae = 255034879;
        this.aaf = -1725669966;
        this.aag = 1545887154;
        this.aah = 673471922;
        this.aai = 254041522;
        this.aak = new Paint(1);
        this.aal = new Rect();
        this.aam = new RectF();
        this.Ze = 0;
        this.aaz = new int[2];
        this.aaA = new a();
        this.YV = 0;
        this.aaC = 0;
        this.ZF[0] = context.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.ZF[1] = context.getResources().getDimensionPixelSize(R.dimen.ds8);
        this.ZF[2] = context.getResources().getDimensionPixelSize(R.dimen.ds22);
        this.ZF[3] = context.getResources().getDimensionPixelSize(R.dimen.ds36);
        this.ZQ = context.getResources().getDimensionPixelSize(R.dimen.ds134);
        this.ZR = this.ZQ + context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.ZS = this.ZR + context.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.ZT = this.ZS + context.getResources().getDimensionPixelSize(R.dimen.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.ZU = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.ZV = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.ZU = context.getResources().getDimensionPixelSize(R.dimen.ds70);
            this.ZV = context.getResources().getDimensionPixelSize(R.dimen.ds210);
        }
        this.mPaddingTop = context.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.ZG = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.ZH = context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.ZI = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.ZJ = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.ZK = context.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.ZL = context.getResources().getDimensionPixelSize(R.dimen.ds2);
        this.aak.setStyle(Paint.Style.STROKE);
        this.aak.setStrokeWidth(this.ZK);
        this.aaj = (BitmapDrawable) getResources().getDrawable(R.drawable.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        J(context);
        qA();
        this.aaz[0] = am.getColor(R.color.common_color_10151);
        this.aaz[1] = am.getColor(R.color.common_color_10152);
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
        int measuredWidth = this.aar.getMeasuredWidth();
        int measuredHeight = this.aar.getMeasuredHeight();
        int measuredWidth2 = this.aao.getMeasuredWidth();
        this.aao.layout((i5 - measuredWidth2) >> 1, this.mPaddingTop + i2, (measuredWidth2 + i5) >> 1, this.aao.getMeasuredHeight() + this.mPaddingTop + i2);
        int bottom = this.aao.getBottom();
        this.aar.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.ZO = (measuredWidth / 2) + i6;
        this.ZP = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.aaq.getMeasuredWidth();
        int measuredHeight2 = this.aaq.getMeasuredHeight();
        int top2 = this.aar.getTop();
        this.aaq.layout((i5 - measuredWidth3) >> 1, top2 - measuredHeight2, (measuredWidth3 + i5) >> 1, top2);
        int measuredWidth4 = this.aan.getMeasuredWidth();
        int measuredHeight3 = this.aan.getMeasuredHeight();
        int right = this.aar.getRight() - this.ZG;
        int bottom2 = this.aar.getBottom() - this.ZH;
        this.aan.layout(this.ZU + i6, this.ZV + bottom, measuredWidth4 + i6 + this.ZU, measuredHeight3 + this.ZV + bottom);
        int measuredWidth5 = this.aas.getMeasuredWidth();
        this.aas.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.aas.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.aat.getMeasuredWidth();
        this.aat.layout((i5 - measuredWidth6) >> 1, (this.aan.getTop() - this.aat.getMeasuredHeight()) - this.ZI, (measuredWidth6 + i5) >> 1, (this.aan.getTop() + i2) - this.ZI);
        this.aar.getLeft();
        this.aar.getRight();
        int measuredWidth7 = this.aap.getMeasuredWidth();
        int measuredHeight4 = this.aap.getMeasuredHeight();
        int bottom3 = this.aar.getBottom();
        this.aap.layout((i5 - measuredWidth7) >> 1, this.ZF[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.ZF[3]);
        this.aal.set((i5 - this.aaj.getIntrinsicWidth()) >> 1, this.aas.getTop() - this.ZJ, (i5 + this.aaj.getIntrinsicHeight()) >> 1, (this.aas.getTop() + this.aaj.getIntrinsicHeight()) - this.ZJ);
        this.aaj.setBounds(this.aal);
        this.aam.set(this.aas.getLeft() + (this.ZK >> 1) + this.ZL, this.aas.getTop() + (this.ZK >> 1) + this.ZL, (this.aas.getRight() - (this.ZK >> 1)) - this.ZL, (this.aas.getBottom() - (this.ZK >> 1)) - this.ZL);
        if (this.aaB == null) {
            this.aaB = new SweepGradient(this.aam.centerX(), this.aam.centerY(), this.aaz, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.aaB.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.aam.centerX(), this.aam.centerY());
            this.aaB.setLocalMatrix(matrix);
            this.aak.setShader(this.aaB);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        f(canvas);
        super.dispatchDraw(canvas);
    }

    private void qn() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.Zg == null) {
            this.Zg = new com.baidu.tbadk.core.dialog.a(i.G(getContext()).getPageActivity());
            this.Zg.ui(getContext().getString(R.string.voice_restart_tip)).a(getContext().getString(R.string.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    VoiceRecordButton.this.qx();
                    if (VoiceRecordButton.this.getVoiceManager() != null && VoiceRecordButton.this.mModel != null) {
                        if (recorderManager != null) {
                            recorderManager.cN(VoiceRecordButton.this.mModel.voiceId);
                        }
                        VoiceRecordButton.this.mModel = null;
                    }
                }
            }).b(getContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(i.G(getContext()));
        }
        try {
            this.Zg.aMS();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.mModel != null) {
                if (recorderManager != null) {
                    recorderManager.cN(this.mModel.voiceId);
                }
                this.mModel = null;
            }
        }
    }

    private void J(Context context) {
        LayoutInflater.from(context).inflate(R.layout.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.aao = (TextView) findViewById(R.id.tip_error);
        am.setViewTextColor(this.aao, R.color.cp_cont_a, 1);
        this.aap = (TextView) findViewById(R.id.tip_operator);
        this.aaq = (TextView) findViewById(R.id.tip_time_out);
        this.aar = (VoiceButton) findViewById(R.id.voice_bnt);
        this.aan = (TextView) findViewById(R.id.restart);
        this.aas = (ImageView) findViewById(R.id.play_img);
        this.aat = (TextView) findViewById(R.id.play_time);
        this.aat.setClickable(false);
        this.aan.setOnClickListener(this);
        this.aas.setOnClickListener(this);
        this.aar.setRecorderView(this);
        qx();
    }

    private void qw() {
        this.aar.setVisibility(4);
        this.aat.setVisibility(0);
        this.aan.setVisibility(0);
        am.setViewTextColor(this.aat, R.color.cp_cont_f, 1);
        am.setViewTextColor(this.aan, R.color.cp_cont_f, 1);
        am.setBackgroundResource(this.aan, R.drawable.but_posts_record_again_selector);
        this.aas.setVisibility(0);
        if (this.mModel != null) {
            this.aat.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.aas.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(this.mModel.duration)));
            am.setImageResource(this.aas, R.drawable.but_posts_record_play_selector);
        }
        am.setViewTextColor(this.aap, R.color.cp_cont_c, 1);
        this.aap.setText(getContext().getString(R.string.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qx() {
        am.setImageResource(this.aar, R.drawable.but_posts_record_zero_selector);
        this.aar.setVisibility(0);
        this.ZM = 0;
        this.aas.setVisibility(4);
        this.aat.setVisibility(4);
        this.aan.setVisibility(4);
        this.aaq.setVisibility(4);
        am.setViewTextColor(this.aap, R.color.cp_cont_c, 1);
        this.aap.setText(getContext().getString(R.string.voice_record_press_to_record));
    }

    public void reset() {
        qx();
        this.mModel = null;
        this.ZM = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.aao.setText("");
        this.aao.setVisibility(4);
        this.ZM = 0;
        qw();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            qx();
            this.aap.setText(getContext().getString(R.string.voice_record_release_to_stop));
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
        if (this.aas != null && this.aat != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    am.setViewTextColor(this.aat, R.color.cp_cont_f, 1);
                    this.aat.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    am.setImageResource(this.aas, R.drawable.but_posts_record_play_selector);
                    this.aas.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.aap.setText(getContext().getString(R.string.voice_play_tip));
                    stopProgress();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    am.setViewTextColor(this.aat, R.color.cp_cont_f, 1);
                    am.setImageResource(this.aas, R.drawable.but_posts_record_stop_selector);
                    this.aas.setContentDescription(getContext().getString(R.string.pause_load));
                    this.aap.setText(getContext().getString(R.string.voice_stop_tip));
                    qy();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        am.setViewTextColor(this.aaq, R.color.cp_cont_a, 1);
        am.setViewTextColor(this.aao, R.color.cp_cont_a, 1);
        am.setViewTextColor(this.aap, R.color.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.aaq.setVisibility(0);
                this.aaq.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.aaq != null) {
                            VoiceRecordButton.this.aaq.setVisibility(4);
                            VoiceRecordButton.this.aaq.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 2) {
                this.aao.setVisibility(0);
                this.aao.setText(str);
                this.aap.setText(R.string.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.aao != null) {
                            VoiceRecordButton.this.aao.setVisibility(4);
                            VoiceRecordButton.this.aao.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 5) {
                this.aao.setVisibility(0);
                this.aao.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.aao != null) {
                            VoiceRecordButton.this.aao.setVisibility(4);
                            VoiceRecordButton.this.aao.setText("");
                        }
                    }
                }, 2000L);
            } else {
                qx();
                this.aao.setVisibility(0);
                this.aao.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.aao != null) {
                            VoiceRecordButton.this.aao.setVisibility(4);
                            VoiceRecordButton.this.aao.setText("");
                        }
                    }
                }, 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.aao.setVisibility(4);
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
        am.setViewTextColor(this.aao, R.color.cp_cont_a, 1);
        this.aao.setVisibility(0);
        this.aao.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.YV = Math.max(i, this.YV);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.YW > 200) {
            this.YV = 0;
            this.YW = uptimeMillis;
        }
        if (this.YV < 10) {
            this.ZM = 1;
            invalidate();
        } else if (this.YV < 20) {
            this.ZM = 2;
            invalidate();
        } else if (this.YV < 30) {
            this.ZM = 3;
            invalidate();
        } else if (this.YV < 40) {
            this.ZM = 4;
            invalidate();
        } else {
            this.ZM = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aS(int i) {
        if (this.mModel != null && this.aat != null) {
            int i2 = i / 1000;
            if (this.aaC != i2) {
                this.aat.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.aaC = i2;
        }
    }

    private void qy() {
        if (this.mModel != null) {
            this.ZM = 0;
            this.aau = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.aax = SystemClock.uptimeMillis();
            this.aay = this.aax + 200;
            this.aaA.sendEmptyMessageAtTime(1, this.aay);
            invalidate();
        }
    }

    private void stopProgress() {
        this.ZM = 0;
        this.ZN = 0;
        this.aau = 0.0f;
        this.aav = 0.0f;
        this.aaA.removeMessages(1);
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
                qn();
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
        this.aaw = fVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void qz() {
    }

    public void qA() {
        this.ZW = new Paint();
        this.ZW.setAntiAlias(true);
        this.ZW.setStyle(Paint.Style.STROKE);
        this.ZW.setStrokeWidth(2.0f);
        this.ZX = new Paint();
        this.ZX.setAntiAlias(true);
        this.ZX.setStyle(Paint.Style.STROKE);
        this.ZX.setStrokeWidth(2.0f);
        this.ZY = new Paint();
        this.ZY.setAntiAlias(true);
        this.ZY.setStyle(Paint.Style.STROKE);
        this.ZY.setStrokeWidth(2.0f);
        this.ZZ = new Paint();
        this.ZZ.setAntiAlias(true);
        this.ZZ.setStyle(Paint.Style.STROKE);
        this.ZZ.setStrokeWidth(2.0f);
    }

    public void f(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.ZW.setColor(this.aaf);
            this.ZX.setColor(this.aag);
            this.ZY.setColor(this.aah);
            this.ZZ.setColor(this.aai);
        } else {
            this.ZW.setColor(this.aaa);
            this.ZX.setColor(this.aab);
            this.ZY.setColor(this.aac);
            this.ZZ.setColor(this.aae);
        }
        if (this.ZM == 2) {
            canvas.drawCircle(this.ZO, this.ZP, this.ZQ, this.ZW);
        } else if (this.ZM == 3) {
            canvas.drawCircle(this.ZO, this.ZP, this.ZQ, this.ZW);
            canvas.drawCircle(this.ZO, this.ZP, this.ZR, this.ZX);
        } else if (this.ZM == 4) {
            canvas.drawCircle(this.ZO, this.ZP, this.ZQ, this.ZW);
            canvas.drawCircle(this.ZO, this.ZP, this.ZR, this.ZX);
            canvas.drawCircle(this.ZO, this.ZP, this.ZS, this.ZY);
        } else if (this.ZM == 5) {
            canvas.drawCircle(this.ZO, this.ZP, this.ZQ, this.ZW);
            canvas.drawCircle(this.ZO, this.ZP, this.ZR, this.ZX);
            canvas.drawCircle(this.ZO, this.ZP, this.ZS, this.ZY);
            canvas.drawCircle(this.ZO, this.ZP, this.ZT, this.ZZ);
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
                    qw();
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
        return this.Ze;
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
        if (this.Zd != null) {
            this.Zd.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.Zd = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.Ze = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
    }
}
