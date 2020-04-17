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
    private int YS;
    private long YT;
    private final int[] ZC;
    private int ZD;
    private final int ZE;
    private final int ZF;
    private final int ZG;
    private final int ZH;
    private final int ZI;
    private int ZJ;
    private int ZK;
    private int ZL;
    private int ZM;
    private int ZN;
    private int ZO;
    private int ZP;
    private int ZQ;
    private int ZR;
    private int ZS;
    private Paint ZT;
    private Paint ZU;
    private Paint ZV;
    private Paint ZW;
    private int ZX;
    private int ZY;
    private int ZZ;
    private EditorTools Za;
    private int Zb;
    private com.baidu.tbadk.core.dialog.a Zd;
    private int aaa;
    private int aab;
    private int aac;
    private int aae;
    private int aaf;
    private final BitmapDrawable aag;
    private final Paint aah;
    private final Rect aai;
    private final RectF aaj;
    private TextView aak;
    private TextView aal;
    private TextView aam;
    private TextView aan;
    private VoiceButton aao;
    private ImageView aap;
    private TextView aaq;
    private float aar;
    private float aas;
    private f aat;
    private long aau;
    private long aav;
    private final int[] aaw;
    private final a aax;
    private SweepGradient aay;
    private int aaz;
    VoiceData.VoiceModel mModel;
    private int mPaddingTop;

    static /* synthetic */ int e(VoiceRecordButton voiceRecordButton) {
        int i = voiceRecordButton.ZK;
        voiceRecordButton.ZK = i + 1;
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
                if (VoiceRecordButton.this.aas >= 360.0f) {
                    VoiceRecordButton.this.aas = 360.0f;
                    VoiceRecordButton.this.ZK = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    VoiceRecordButton.this.aau = uptimeMillis;
                    VoiceRecordButton.this.aav = uptimeMillis + 200;
                    VoiceRecordButton.this.aas += (((float) (uptimeMillis - VoiceRecordButton.this.aau)) / 1000.0f) * VoiceRecordButton.this.aar;
                    sendEmptyMessageAtTime(1, VoiceRecordButton.this.aav);
                    VoiceRecordButton.e(VoiceRecordButton.this);
                }
                VoiceRecordButton.this.ZJ = VoiceRecordButton.this.ZK % 6;
                VoiceRecordButton.this.invalidate();
            }
        }
    }

    public static VoiceRecordButton V(Context context) {
        return new VoiceRecordButton(context);
    }

    public VoiceRecordButton(Context context) {
        this(context, null);
    }

    public VoiceRecordButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.YT = 0L;
        this.ZC = new int[4];
        this.ZJ = 0;
        this.ZK = 0;
        this.ZL = 0;
        this.ZM = 0;
        this.ZN = 0;
        this.ZO = 0;
        this.ZP = 0;
        this.ZQ = 0;
        this.ZR = 0;
        this.ZS = 0;
        this.ZX = -1724676609;
        this.ZY = 1546880511;
        this.ZZ = 674465279;
        this.aaa = 255034879;
        this.aab = -1725669966;
        this.aac = 1545887154;
        this.aae = 673471922;
        this.aaf = 254041522;
        this.aah = new Paint(1);
        this.aai = new Rect();
        this.aaj = new RectF();
        this.Zb = 0;
        this.aaw = new int[2];
        this.aax = new a();
        this.YS = 0;
        this.aaz = 0;
        this.ZC[0] = context.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.ZC[1] = context.getResources().getDimensionPixelSize(R.dimen.ds8);
        this.ZC[2] = context.getResources().getDimensionPixelSize(R.dimen.ds22);
        this.ZC[3] = context.getResources().getDimensionPixelSize(R.dimen.ds36);
        this.ZN = context.getResources().getDimensionPixelSize(R.dimen.ds134);
        this.ZO = this.ZN + context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.ZP = this.ZO + context.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.ZQ = this.ZP + context.getResources().getDimensionPixelSize(R.dimen.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.ZR = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.ZS = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.ZR = context.getResources().getDimensionPixelSize(R.dimen.ds70);
            this.ZS = context.getResources().getDimensionPixelSize(R.dimen.ds210);
        }
        this.mPaddingTop = context.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.ZD = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.ZE = context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.ZF = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.ZG = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.ZH = context.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.ZI = context.getResources().getDimensionPixelSize(R.dimen.ds2);
        this.aah.setStyle(Paint.Style.STROKE);
        this.aah.setStrokeWidth(this.ZH);
        this.aag = (BitmapDrawable) getResources().getDrawable(R.drawable.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        W(context);
        qA();
        this.aaw[0] = am.getColor(R.color.common_color_10151);
        this.aaw[1] = am.getColor(R.color.common_color_10152);
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
        int measuredWidth = this.aao.getMeasuredWidth();
        int measuredHeight = this.aao.getMeasuredHeight();
        int measuredWidth2 = this.aal.getMeasuredWidth();
        this.aal.layout((i5 - measuredWidth2) >> 1, this.mPaddingTop + i2, (measuredWidth2 + i5) >> 1, this.aal.getMeasuredHeight() + this.mPaddingTop + i2);
        int bottom = this.aal.getBottom();
        this.aao.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.ZL = (measuredWidth / 2) + i6;
        this.ZM = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.aan.getMeasuredWidth();
        int measuredHeight2 = this.aan.getMeasuredHeight();
        int top2 = this.aao.getTop();
        this.aan.layout((i5 - measuredWidth3) >> 1, top2 - measuredHeight2, (measuredWidth3 + i5) >> 1, top2);
        int measuredWidth4 = this.aak.getMeasuredWidth();
        int measuredHeight3 = this.aak.getMeasuredHeight();
        int right = this.aao.getRight() - this.ZD;
        int bottom2 = this.aao.getBottom() - this.ZE;
        this.aak.layout(this.ZR + i6, this.ZS + bottom, measuredWidth4 + i6 + this.ZR, measuredHeight3 + this.ZS + bottom);
        int measuredWidth5 = this.aap.getMeasuredWidth();
        this.aap.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.aap.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.aaq.getMeasuredWidth();
        this.aaq.layout((i5 - measuredWidth6) >> 1, (this.aak.getTop() - this.aaq.getMeasuredHeight()) - this.ZF, (measuredWidth6 + i5) >> 1, (this.aak.getTop() + i2) - this.ZF);
        this.aao.getLeft();
        this.aao.getRight();
        int measuredWidth7 = this.aam.getMeasuredWidth();
        int measuredHeight4 = this.aam.getMeasuredHeight();
        int bottom3 = this.aao.getBottom();
        this.aam.layout((i5 - measuredWidth7) >> 1, this.ZC[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.ZC[3]);
        this.aai.set((i5 - this.aag.getIntrinsicWidth()) >> 1, this.aap.getTop() - this.ZG, (i5 + this.aag.getIntrinsicHeight()) >> 1, (this.aap.getTop() + this.aag.getIntrinsicHeight()) - this.ZG);
        this.aag.setBounds(this.aai);
        this.aaj.set(this.aap.getLeft() + (this.ZH >> 1) + this.ZI, this.aap.getTop() + (this.ZH >> 1) + this.ZI, (this.aap.getRight() - (this.ZH >> 1)) - this.ZI, (this.aap.getBottom() - (this.ZH >> 1)) - this.ZI);
        if (this.aay == null) {
            this.aay = new SweepGradient(this.aaj.centerX(), this.aaj.centerY(), this.aaw, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.aay.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.aaj.centerX(), this.aaj.centerY());
            this.aay.setLocalMatrix(matrix);
            this.aah.setShader(this.aay);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        f(canvas);
        super.dispatchDraw(canvas);
    }

    private void qn() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.Zd == null) {
            this.Zd = new com.baidu.tbadk.core.dialog.a(i.T(getContext()).getPageActivity());
            this.Zd.uf(getContext().getString(R.string.voice_restart_tip)).a(getContext().getString(R.string.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.2
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
            }).b(i.T(getContext()));
        }
        try {
            this.Zd.aMU();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.mModel != null) {
                if (recorderManager != null) {
                    recorderManager.cN(this.mModel.voiceId);
                }
                this.mModel = null;
            }
        }
    }

    private void W(Context context) {
        LayoutInflater.from(context).inflate(R.layout.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.aal = (TextView) findViewById(R.id.tip_error);
        am.setViewTextColor(this.aal, R.color.cp_cont_a, 1);
        this.aam = (TextView) findViewById(R.id.tip_operator);
        this.aan = (TextView) findViewById(R.id.tip_time_out);
        this.aao = (VoiceButton) findViewById(R.id.voice_bnt);
        this.aak = (TextView) findViewById(R.id.restart);
        this.aap = (ImageView) findViewById(R.id.play_img);
        this.aaq = (TextView) findViewById(R.id.play_time);
        this.aaq.setClickable(false);
        this.aak.setOnClickListener(this);
        this.aap.setOnClickListener(this);
        this.aao.setRecorderView(this);
        qx();
    }

    private void qw() {
        this.aao.setVisibility(4);
        this.aaq.setVisibility(0);
        this.aak.setVisibility(0);
        am.setViewTextColor(this.aaq, R.color.cp_cont_f, 1);
        am.setViewTextColor(this.aak, R.color.cp_cont_f, 1);
        am.setBackgroundResource(this.aak, R.drawable.but_posts_record_again_selector);
        this.aap.setVisibility(0);
        if (this.mModel != null) {
            this.aaq.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.aap.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(this.mModel.duration)));
            am.setImageResource(this.aap, R.drawable.but_posts_record_play_selector);
        }
        am.setViewTextColor(this.aam, R.color.cp_cont_c, 1);
        this.aam.setText(getContext().getString(R.string.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qx() {
        am.setImageResource(this.aao, R.drawable.but_posts_record_zero_selector);
        this.aao.setVisibility(0);
        this.ZJ = 0;
        this.aap.setVisibility(4);
        this.aaq.setVisibility(4);
        this.aak.setVisibility(4);
        this.aan.setVisibility(4);
        am.setViewTextColor(this.aam, R.color.cp_cont_c, 1);
        this.aam.setText(getContext().getString(R.string.voice_record_press_to_record));
    }

    public void reset() {
        qx();
        this.mModel = null;
        this.ZJ = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.aal.setText("");
        this.aal.setVisibility(4);
        this.ZJ = 0;
        qw();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            qx();
            this.aam.setText(getContext().getString(R.string.voice_record_release_to_stop));
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
        if (this.aap != null && this.aaq != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    am.setViewTextColor(this.aaq, R.color.cp_cont_f, 1);
                    this.aaq.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    am.setImageResource(this.aap, R.drawable.but_posts_record_play_selector);
                    this.aap.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.aam.setText(getContext().getString(R.string.voice_play_tip));
                    stopProgress();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    am.setViewTextColor(this.aaq, R.color.cp_cont_f, 1);
                    am.setImageResource(this.aap, R.drawable.but_posts_record_stop_selector);
                    this.aap.setContentDescription(getContext().getString(R.string.pause_load));
                    this.aam.setText(getContext().getString(R.string.voice_stop_tip));
                    qy();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        am.setViewTextColor(this.aan, R.color.cp_cont_a, 1);
        am.setViewTextColor(this.aal, R.color.cp_cont_a, 1);
        am.setViewTextColor(this.aam, R.color.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.aan.setVisibility(0);
                this.aan.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.aan != null) {
                            VoiceRecordButton.this.aan.setVisibility(4);
                            VoiceRecordButton.this.aan.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 2) {
                this.aal.setVisibility(0);
                this.aal.setText(str);
                this.aam.setText(R.string.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.aal != null) {
                            VoiceRecordButton.this.aal.setVisibility(4);
                            VoiceRecordButton.this.aal.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 5) {
                this.aal.setVisibility(0);
                this.aal.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.aal != null) {
                            VoiceRecordButton.this.aal.setVisibility(4);
                            VoiceRecordButton.this.aal.setText("");
                        }
                    }
                }, 2000L);
            } else {
                qx();
                this.aal.setVisibility(0);
                this.aal.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.aal != null) {
                            VoiceRecordButton.this.aal.setVisibility(4);
                            VoiceRecordButton.this.aal.setText("");
                        }
                    }
                }, 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.aal.setVisibility(4);
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
        am.setViewTextColor(this.aal, R.color.cp_cont_a, 1);
        this.aal.setVisibility(0);
        this.aal.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.YS = Math.max(i, this.YS);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.YT > 200) {
            this.YS = 0;
            this.YT = uptimeMillis;
        }
        if (this.YS < 10) {
            this.ZJ = 1;
            invalidate();
        } else if (this.YS < 20) {
            this.ZJ = 2;
            invalidate();
        } else if (this.YS < 30) {
            this.ZJ = 3;
            invalidate();
        } else if (this.YS < 40) {
            this.ZJ = 4;
            invalidate();
        } else {
            this.ZJ = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aS(int i) {
        if (this.mModel != null && this.aaq != null) {
            int i2 = i / 1000;
            if (this.aaz != i2) {
                this.aaq.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.aaz = i2;
        }
    }

    private void qy() {
        if (this.mModel != null) {
            this.ZJ = 0;
            this.aar = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.aau = SystemClock.uptimeMillis();
            this.aav = this.aau + 200;
            this.aax.sendEmptyMessageAtTime(1, this.aav);
            invalidate();
        }
    }

    private void stopProgress() {
        this.ZJ = 0;
        this.ZK = 0;
        this.aar = 0.0f;
        this.aas = 0.0f;
        this.aax.removeMessages(1);
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
        this.aat = fVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void qz() {
    }

    public void qA() {
        this.ZT = new Paint();
        this.ZT.setAntiAlias(true);
        this.ZT.setStyle(Paint.Style.STROKE);
        this.ZT.setStrokeWidth(2.0f);
        this.ZU = new Paint();
        this.ZU.setAntiAlias(true);
        this.ZU.setStyle(Paint.Style.STROKE);
        this.ZU.setStrokeWidth(2.0f);
        this.ZV = new Paint();
        this.ZV.setAntiAlias(true);
        this.ZV.setStyle(Paint.Style.STROKE);
        this.ZV.setStrokeWidth(2.0f);
        this.ZW = new Paint();
        this.ZW.setAntiAlias(true);
        this.ZW.setStyle(Paint.Style.STROKE);
        this.ZW.setStrokeWidth(2.0f);
    }

    public void f(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.ZT.setColor(this.aab);
            this.ZU.setColor(this.aac);
            this.ZV.setColor(this.aae);
            this.ZW.setColor(this.aaf);
        } else {
            this.ZT.setColor(this.ZX);
            this.ZU.setColor(this.ZY);
            this.ZV.setColor(this.ZZ);
            this.ZW.setColor(this.aaa);
        }
        if (this.ZJ == 2) {
            canvas.drawCircle(this.ZL, this.ZM, this.ZN, this.ZT);
        } else if (this.ZJ == 3) {
            canvas.drawCircle(this.ZL, this.ZM, this.ZN, this.ZT);
            canvas.drawCircle(this.ZL, this.ZM, this.ZO, this.ZU);
        } else if (this.ZJ == 4) {
            canvas.drawCircle(this.ZL, this.ZM, this.ZN, this.ZT);
            canvas.drawCircle(this.ZL, this.ZM, this.ZO, this.ZU);
            canvas.drawCircle(this.ZL, this.ZM, this.ZP, this.ZV);
        } else if (this.ZJ == 5) {
            canvas.drawCircle(this.ZL, this.ZM, this.ZN, this.ZT);
            canvas.drawCircle(this.ZL, this.ZM, this.ZO, this.ZU);
            canvas.drawCircle(this.ZL, this.ZM, this.ZP, this.ZV);
            canvas.drawCircle(this.ZL, this.ZM, this.ZQ, this.ZW);
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
        return this.Zb;
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
        if (this.Za != null) {
            this.Za.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.Za = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.Zb = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
    }
}
