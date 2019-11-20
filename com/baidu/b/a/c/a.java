package com.baidu.b.a.c;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.b.a.e.b;
import com.baidu.crius.CriusAlign;
import com.baidu.crius.CriusConstants;
import com.baidu.crius.CriusDisplay;
import com.baidu.crius.CriusEdge;
import com.baidu.crius.CriusFlexDirection;
import com.baidu.crius.CriusJustify;
import com.baidu.crius.CriusMeasureFunction;
import com.baidu.crius.CriusMeasureMode;
import com.baidu.crius.CriusMeasureOutput;
import com.baidu.crius.CriusNode;
import com.baidu.crius.CriusPositionType;
import com.baidu.live.adp.widget.HorizontalTranslateLayout;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
@TargetApi(23)
/* loaded from: classes3.dex */
public class a {
    public final int JS;
    public final int JT;
    public String KI;
    public String KQ;
    protected int KV;
    protected int KW;
    protected int KX;
    private CriusNode KY;
    public final CriusNode KZ;
    private double LA;
    private double LB;
    private double LC;
    private double LD;
    private double LE;
    private double LG;
    private double LH;
    private double LI;
    private double LJ;
    private double LK;
    private double LM;
    private double LN;
    private double LO;
    private double LP;
    private double LQ;
    private double LR;
    private double LS;
    public String LU;
    public double LV;
    public double LW;
    public double LX;
    public double LY;
    public double LZ;
    private TextView La;
    private final CriusMeasureFunction Lb;
    public String Lc;
    public String Ld;
    public String Le;
    public String Lf;
    public String Lg;
    public int Lh;
    public int Li;
    public int Lj;
    public String Lk;
    public String Ll;
    public double Lm;
    public double Ln;
    private String Lo;
    private String Lp;
    private String Lq;
    private String Lr;
    private String Ls;
    private String Lt;
    private double Lu;
    private double Lv;
    private double Lw;
    private double Lx;
    private double Ly;
    private double Lz;
    public String Ma;
    public String Mb;
    public Typeface Mc;
    public String Md;
    public String Me;
    public String Mf;
    public String Mg;
    public String Mh;
    public String Mi;
    public String Mj;
    public String Mk;
    public String Ml;
    public double Mm;
    public String Mn;
    public String Mo;
    public String Mp;
    public String Mq;
    public String Mr;
    public final List<a> Ms;
    public String backgroundColor;
    public String borderColor;
    public double borderRadius;
    private InterfaceC0040a businessConverter;
    public String color;
    public double fontSize;
    public int gravity;
    private double height;
    public final float hz;
    public String id;
    public int maxLines;
    public String name;
    public double opacity;
    private String position;
    public String shareContent;
    public String shareTitle;
    public String src;
    public String text;
    public String type;
    public int videoDuration;
    private double width;

    /* renamed from: com.baidu.b.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0040a {
        String bO(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"PrivateApi"})
    public void a(@NonNull StaticLayout.Builder builder, boolean z) {
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                Method declaredMethod = builder.getClass().getDeclaredMethod("setUseLineSpacingFromFallbacks", Boolean.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(builder, Boolean.valueOf(z));
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextView textView, a aVar) {
        if (!TextUtils.isEmpty(aVar.text)) {
            if (aVar.maxLines > 0) {
                if (aVar.maxLines == 1) {
                    textView.setSingleLine(true);
                } else {
                    textView.setSingleLine(false);
                }
                textView.setMaxLines(aVar.maxLines);
            }
            textView.setEllipsize(TextUtils.TruncateAt.END);
            if (Double.compare(aVar.mI(), 0.0d) > 0) {
                textView.setTextSize(0, (float) (aVar.mI() * textView.getContext().getResources().getDisplayMetrics().density));
            }
            textView.setIncludeFontPadding(false);
            textView.setTypeface(aVar.Mc);
            textView.setGravity(aVar.gravity);
            float d = aVar.Lm > 0.0d ? d(aVar.Lm) : 0.0f;
            float f = aVar.Ln > 0.0d ? (float) aVar.Ln : 1.0f;
            if (d > 0.0f || f > 0.0f) {
                textView.setLineSpacing(d, f);
            }
        }
    }

    public static boolean bK(String str) {
        return Pattern.compile("[^一-龥]").matcher(str).find();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float F(float f) {
        if (Build.VERSION.SDK_INT == 19 || TbadkCoreApplication.getInst().isMIUIRom()) {
            return (1.12f * f) + 0.5f;
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float G(float f) {
        if ((Build.VERSION.SDK_INT == 19 || TbadkCoreApplication.getInst().isMIUIRom()) && this.maxLines == 1 && bK(this.text)) {
            return (1.09859f * f) + 0.5f;
        }
        return f;
    }

    private void h(JSONObject jSONObject) {
        this.id = b.g(jSONObject, "id");
        this.name = b.g(jSONObject, "name");
        this.type = b.g(jSONObject, "type");
        if (nn()) {
            this.KZ.setMeasureFunction(this.Lb);
        }
        this.Lc = b.g(jSONObject, "component");
        this.src = b.g(jSONObject, "src");
        this.KI = b.g(jSONObject, "poster");
        this.Ld = b.g(jSONObject, "href");
        this.text = b.g(jSONObject, "text");
        if ("time".equalsIgnoreCase(this.Lc) && this.businessConverter != null) {
            this.text = this.businessConverter.bO(this.text);
        }
        this.maxLines = jSONObject.optInt("max-lines", 1);
        this.Lm = b.h(jSONObject, "line-space");
        this.Ln = b.h(jSONObject, "line-multi");
        this.videoDuration = jSONObject.optInt("data-video-duration");
        this.Le = jSONObject.optString("data-als-stat");
        this.Lf = jSONObject.optString("data-url-stat");
        this.Lg = jSONObject.optString("data-href-pop");
        this.Lh = b.i(jSONObject, "data-share-num");
        this.Li = b.i(jSONObject, "data-reply-num");
        this.Lj = b.i(jSONObject, "data-agree-num");
        this.shareTitle = jSONObject.optString("data-share-title");
        this.shareContent = jSONObject.optString("data-share-content");
        this.Lk = jSONObject.optString("data-share-image");
        this.Ll = jSONObject.optString("data-share-link");
    }

    private void i(JSONObject jSONObject) {
        this.Lo = b.g(jSONObject, LogConfig.KEY_DISPLAY);
        nf();
        this.Lp = b.g(jSONObject, "flex-direction");
        nm();
        this.Lq = b.g(jSONObject, "justify-content");
        nl();
        this.Lr = b.g(jSONObject, "align-items");
        nk();
        this.Ls = b.g(jSONObject, "align-self");
        nj();
        this.Lt = b.g(jSONObject, "align-content");
        ni();
        this.Lu = b.h(jSONObject, "flex");
        ne();
        this.Lv = b.h(jSONObject, "flex-grow");
        nd();
        this.Lw = b.h(jSONObject, "flex-shrink");
        nc();
        this.Lx = b.h(jSONObject, "flex-basis");
        nb();
        this.position = b.g(jSONObject, "position");
        nh();
        this.Ly = b.h(jSONObject, "left");
        this.Lz = b.h(jSONObject, VerticalTranslateLayout.TOP);
        this.LA = b.h(jSONObject, HorizontalTranslateLayout.RIGHT);
        this.LB = b.h(jSONObject, VerticalTranslateLayout.BOTTOM);
        ng();
        this.LC = b.h(jSONObject, "margin");
        na();
        this.LD = b.h(jSONObject, "margin-left");
        mW();
        this.LE = b.h(jSONObject, "margin-top");
        mZ();
        this.LG = b.h(jSONObject, "margin-right");
        mY();
        this.LH = b.h(jSONObject, "margin-bottom");
        mX();
        this.LI = b.h(jSONObject, "padding");
        initPadding();
        this.LJ = b.h(jSONObject, "padding-left");
        mS();
        this.LK = b.h(jSONObject, "padding-top");
        mV();
        this.LM = b.h(jSONObject, "padding-right");
        mU();
        this.LN = b.h(jSONObject, "padding-bottom");
        mT();
        this.width = b.h(jSONObject, "width");
        mR();
        this.height = b.h(jSONObject, "height");
        mQ();
        this.LO = b.h(jSONObject, "min-width");
        mP();
        this.LP = b.h(jSONObject, "min-height");
        mO();
        this.LQ = b.h(jSONObject, "max-width");
        mL();
        this.LR = b.h(jSONObject, "max-height");
        mN();
        this.LS = b.h(jSONObject, "aspect-ratio");
        mM();
    }

    private void j(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SharedPrefConfig.ACTIVE_STATE)) != null) {
            this.Mo = b.g(optJSONObject, "background-image");
            this.Mp = b.g(optJSONObject, "background-color");
            this.Mq = b.g(optJSONObject, "border-color");
            this.Mr = b.g(optJSONObject, "color");
        }
    }

    private void k(JSONObject jSONObject) {
        this.Mj = b.g(jSONObject, "background-image");
        this.Mk = b.g(jSONObject, "background-color");
        this.Ml = b.g(jSONObject, "border-color");
        this.Mm = b.h(jSONObject, "opacity");
        this.Mn = b.g(jSONObject, "color");
    }

    private void l(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SharedPrefConfig.ACTIVE_STATE)) != null) {
            this.Mf = b.g(optJSONObject, "background-image");
            this.Mg = b.g(optJSONObject, "background-color");
            this.Mh = b.g(optJSONObject, "border-color");
            this.Mi = b.g(optJSONObject, "color");
        }
    }

    private void m(JSONObject jSONObject) {
        this.LU = b.g(jSONObject, "background-image");
        this.backgroundColor = b.g(jSONObject, "background-color");
        this.borderColor = b.g(jSONObject, "border-color");
        this.opacity = b.h(jSONObject, "opacity");
        this.color = b.g(jSONObject, "color");
        this.LV = b.h(jSONObject, "border-width");
        this.borderRadius = b.h(jSONObject, "border-radius");
        this.LW = b.h(jSONObject, "border-top-left-radius");
        this.LX = b.h(jSONObject, "border-bottom-left-radius");
        this.LY = b.h(jSONObject, "border-top-right-radius");
        this.LZ = b.h(jSONObject, "border-bottom-right-radius");
        this.Ma = b.g(jSONObject, "font-style");
        this.Mb = b.g(jSONObject, "font-weight");
        this.Mc = Typeface.create(Typeface.DEFAULT, mJ());
        this.fontSize = jSONObject.optDouble("font-size", 12.0d);
        this.Md = b.g(jSONObject, "text-align");
        this.Me = b.g(jSONObject, "vertical-align");
        this.gravity = mK();
        this.KQ = b.g(jSONObject, "download-style");
    }

    public a(Context context, JSONObject jSONObject, InterfaceC0040a interfaceC0040a, boolean z) {
        this.KV = Build.VERSION.SDK_INT < 23 ? 0 : 1;
        if (Build.VERSION.SDK_INT < 23) {
        }
        this.KW = 0;
        if (Build.VERSION.SDK_INT < 26) {
        }
        this.KX = 0;
        this.Lb = new CriusMeasureFunction() { // from class: com.baidu.b.a.c.a.1
            @Override // com.baidu.crius.CriusMeasureFunction
            @SuppressLint({"WrongConstant"})
            public long measure(CriusNode criusNode, float f, CriusMeasureMode criusMeasureMode, float f2, CriusMeasureMode criusMeasureMode2) {
                float f3;
                boolean z2;
                Layout build;
                Layout build2;
                SpannableString spannableString = new SpannableString(a.this.text);
                a.this.a(a.this.La, a.this);
                TextPaint paint = a.this.La.getPaint();
                BoringLayout.Metrics isBoring = BoringLayout.isBoring(spannableString, paint);
                float desiredWidth = isBoring == null ? Layout.getDesiredWidth(spannableString, paint) : Float.NaN;
                if (a.this.Lm > 0.0d) {
                    f3 = a.this.d(a.this.Lm);
                } else {
                    f3 = 0.0f;
                }
                float f4 = a.this.Ln > 0.0d ? (float) a.this.Ln : 1.0f;
                boolean z3 = criusMeasureMode == CriusMeasureMode.UNDEFINED || f < 0.0f;
                if (isBoring == null && (z3 || (!CriusConstants.isUndefined(desiredWidth) && desiredWidth <= f))) {
                    int ceil = (int) Math.ceil(desiredWidth);
                    if (Build.VERSION.SDK_INT < 23) {
                        build2 = new StaticLayout(spannableString, paint, ceil, Layout.Alignment.ALIGN_NORMAL, f4, f3, false);
                    } else {
                        StaticLayout.Builder hyphenationFrequency = StaticLayout.Builder.obtain(spannableString, 0, spannableString.length(), paint, ceil).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(f3, f4).setIncludePad(false).setBreakStrategy(a.this.KV).setHyphenationFrequency(a.this.KW);
                        if (Build.VERSION.SDK_INT >= 26) {
                            hyphenationFrequency.setJustificationMode(a.this.KX);
                        }
                        a.this.a(hyphenationFrequency, true);
                        build2 = hyphenationFrequency.build();
                    }
                    z2 = false;
                    build = build2;
                } else if (isBoring != null && (z3 || isBoring.width <= f)) {
                    build = BoringLayout.make(spannableString, paint, isBoring.width, Layout.Alignment.ALIGN_NORMAL, f4, f3, isBoring, false);
                    z2 = true;
                } else if (Build.VERSION.SDK_INT < 23) {
                    Layout staticLayout = new StaticLayout(spannableString, paint, (int) f, Layout.Alignment.ALIGN_NORMAL, f4, f3, false);
                    z2 = false;
                    build = staticLayout;
                } else {
                    StaticLayout.Builder hyphenationFrequency2 = StaticLayout.Builder.obtain(spannableString, 0, spannableString.length(), paint, (int) f).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(f3, f4).setIncludePad(false).setBreakStrategy(a.this.KV).setHyphenationFrequency(a.this.KW);
                    if (Build.VERSION.SDK_INT >= 26) {
                        hyphenationFrequency2.setJustificationMode(a.this.KX);
                    }
                    a.this.a(hyphenationFrequency2, true);
                    z2 = false;
                    build = hyphenationFrequency2.build();
                }
                if (build != null && a.this.maxLines < build.getLineCount()) {
                    return CriusMeasureOutput.make(a.this.G(build.getWidth()), a.this.F(build.getLineBottom(a.this.maxLines - 1)) - f3);
                }
                if (build != null) {
                    float G = a.this.G(build.getWidth());
                    float F = a.this.F(build.getHeight());
                    if (!z2) {
                        boolean z4 = false;
                        if (TbadkCoreApplication.getInst().isMIUIRom()) {
                            if (Build.VERSION.SDK_INT < 23) {
                                z4 = true;
                            }
                        } else {
                            z4 = true;
                        }
                        if (z4) {
                            float lineDescent = (build.getLineDescent(0) - build.getLineAscent(0)) - f3;
                            float lineCount = ((build.getLineCount() - 1) * f3) + (build.getLineCount() * lineDescent);
                            if (lineDescent > 0.0f && F > lineCount) {
                                F -= f3;
                            }
                        }
                    }
                    return CriusMeasureOutput.make(G, F);
                }
                return CriusMeasureOutput.make(f, f2);
            }
        };
        this.Mm = -10000.0d;
        this.KZ = new CriusNode();
        this.businessConverter = interfaceC0040a;
        this.hz = context.getResources().getDisplayMetrics().density;
        this.JS = context.getResources().getDisplayMetrics().widthPixels;
        this.JT = context.getResources().getDisplayMetrics().heightPixels;
        this.La = new TextView(context);
        h(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("style");
        if (optJSONObject != null) {
            i(optJSONObject);
            m(optJSONObject);
            l(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("night-style");
        if (optJSONObject2 != null) {
            k(optJSONObject2);
            j(optJSONObject2);
        }
        if (jSONObject.has("children")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("children");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.Ms = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    a aVar = new a(context, optJSONArray.optJSONObject(i), interfaceC0040a, false);
                    this.Ms.add(aVar);
                    this.KZ.addChildAt(aVar.KZ, i);
                }
            } else {
                this.Ms = null;
            }
        } else {
            this.Ms = null;
        }
        if (z) {
            this.KY = new CriusNode();
            this.KY.addChildAt(this.KZ, 0);
            this.KY.calculateLayout(Float.NaN, Float.NaN);
        }
    }

    public double mI() {
        return this.fontSize;
    }

    private int mJ() {
        return "italic".equalsIgnoreCase(this.Ma) ? (TextUtils.isEmpty(this.Mb) || "normal".equalsIgnoreCase(this.Mb) || !"bold".equalsIgnoreCase(this.Mb)) ? 2 : 3 : (TextUtils.isEmpty(this.Mb) || "normal".equalsIgnoreCase(this.Mb) || !"bold".equalsIgnoreCase(this.Mb)) ? 0 : 1;
    }

    private int mK() {
        int i;
        if ("left".equalsIgnoreCase(this.Md)) {
            i = 3;
        } else if (HorizontalTranslateLayout.RIGHT.equalsIgnoreCase(this.Md)) {
            i = 5;
        } else if ("center".equalsIgnoreCase(this.Md)) {
            i = 1;
        } else {
            i = 0;
        }
        if (VerticalTranslateLayout.TOP.equalsIgnoreCase(this.Me)) {
            return i | 48;
        }
        if (VerticalTranslateLayout.BOTTOM.equalsIgnoreCase(this.Me)) {
            return i | 80;
        }
        if ("middle".equalsIgnoreCase(this.Me)) {
            return i | 16;
        }
        return i | 0;
    }

    private void mL() {
        if (this.LQ >= 0.0d) {
            this.KZ.setMaxWidth(d(this.LQ));
        } else if (this.LQ > -10000.0d) {
            this.KZ.setMaxWidth(this.JS);
        }
    }

    private void mM() {
        if (this.LS > 0.0d) {
            this.KZ.setAspectRatio((float) this.LS);
        }
    }

    private void mN() {
        if (this.LR >= 0.0d) {
            this.KZ.setMaxHeight(d(this.LR));
        } else if (this.LR > -10000.0d) {
            this.KZ.setMaxHeight(this.JT);
        }
    }

    private void mO() {
        if (this.LP >= 0.0d) {
            this.KZ.setMinHeight(d(this.LP));
        } else if (this.LP > -10000.0d) {
            this.KZ.setMinHeight(this.JT);
        }
    }

    private void mP() {
        if (this.LO >= 0.0d) {
            this.KZ.setMinWidth(d(this.LO));
        } else if (this.LO > -10000.0d) {
            this.KZ.setMinWidth(this.JS);
        }
    }

    private void mQ() {
        if (this.height >= 0.0d) {
            this.KZ.setHeight(d(this.height));
        } else if (this.height > -10000.0d) {
            this.KZ.setHeight(this.JT);
        }
    }

    private void mR() {
        if (this.width >= 0.0d) {
            this.KZ.setWidth(d(this.width));
        } else if (this.width > -10000.0d) {
            this.KZ.setWidth(this.JS);
        }
    }

    private void mS() {
        if (this.LJ >= -1.0d) {
            this.KZ.setPadding(CriusEdge.LEFT, d(this.LJ));
        }
    }

    private void mT() {
        if (this.LN >= -1.0d) {
            this.KZ.setPadding(CriusEdge.BOTTOM, d(this.LN));
        }
    }

    private void mU() {
        if (this.LM >= -1.0d) {
            this.KZ.setPadding(CriusEdge.RIGHT, d(this.LM));
        }
    }

    private void mV() {
        if (this.LK >= -1.0d) {
            this.KZ.setPadding(CriusEdge.TOP, d(this.LK));
        }
    }

    private void initPadding() {
        if (this.LI >= -1.0d) {
            this.KZ.setPadding(CriusEdge.ALL, d(this.LI));
        }
    }

    private void mW() {
        if (this.LD >= -1.0d) {
            this.KZ.setMargin(CriusEdge.LEFT, d(this.LD));
        }
    }

    private void mX() {
        if (this.LH >= -1.0d) {
            this.KZ.setMargin(CriusEdge.BOTTOM, d(this.LH));
        }
    }

    private void mY() {
        if (this.LG >= -1.0d) {
            this.KZ.setMargin(CriusEdge.RIGHT, d(this.LG));
        }
    }

    private void mZ() {
        if (this.LE >= -1.0d) {
            this.KZ.setMargin(CriusEdge.TOP, d(this.LE));
        }
    }

    private void na() {
        if (this.LC >= -1.0d) {
            this.KZ.setMargin(CriusEdge.ALL, d(this.LC));
        }
    }

    private void nb() {
        if (this.Lx >= -1.0d) {
            this.KZ.setFlexBasis(d(this.Lx));
        }
    }

    private void nc() {
        if (this.Lw >= -1.0d) {
            this.KZ.setFlexShrink((float) this.Lw);
        }
    }

    private void nd() {
        if (this.Lv >= -1.0d) {
            this.KZ.setFlexGrow((float) this.Lv);
        }
    }

    private void ne() {
        if (this.Lu >= -1.0d) {
            this.KZ.setFlex((float) this.Lu);
        }
    }

    private void nf() {
        if (!TextUtils.isEmpty(this.Lo)) {
            if ("flex".equalsIgnoreCase(this.Lo)) {
                this.KZ.setDisplay(CriusDisplay.FLEX);
            } else if (IXAdSystemUtils.NT_NONE.equalsIgnoreCase(this.Lo)) {
                this.KZ.setDisplay(CriusDisplay.NONE);
            } else {
                this.KZ.setDisplay(CriusDisplay.FLEX);
            }
        }
    }

    private void ng() {
        if (!b.c(this.Ly, -10000.0d)) {
            this.KZ.setPosition(CriusEdge.LEFT, d(this.Ly));
        }
        if (!b.c(this.Lz, -10000.0d)) {
            this.KZ.setPosition(CriusEdge.TOP, d(this.Lz));
        }
        if (!b.c(this.LA, -10000.0d)) {
            this.KZ.setPosition(CriusEdge.RIGHT, d(this.LA));
        }
        if (!b.c(this.LB, -10000.0d)) {
            this.KZ.setPosition(CriusEdge.BOTTOM, d(this.LB));
        }
    }

    private void nh() {
        if (!TextUtils.isEmpty(this.position)) {
            if ("relative".equalsIgnoreCase(this.position)) {
                this.KZ.setPositionType(CriusPositionType.RELATIVE);
            } else if ("absolute".equalsIgnoreCase(this.position)) {
                this.KZ.setPositionType(CriusPositionType.ABSOLUTE);
            }
        }
    }

    private void ni() {
        if (!TextUtils.isEmpty(this.Lt)) {
            if ("flex-start".equalsIgnoreCase(this.Lt)) {
                this.KZ.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.Lt)) {
                this.KZ.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.Lt)) {
                this.KZ.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.Lt)) {
                this.KZ.setAlignSelf(CriusAlign.STRETCH);
            } else if ("space-between".equalsIgnoreCase(this.Lt)) {
                this.KZ.setAlignSelf(CriusAlign.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.Lt)) {
                this.KZ.setAlignSelf(CriusAlign.SPACE_AROUND);
            } else {
                this.KZ.setAlignSelf(CriusAlign.FLEX_START);
            }
        }
    }

    private void nj() {
        if (!TextUtils.isEmpty(this.Ls)) {
            if ("auto".equalsIgnoreCase(this.Ls)) {
                this.KZ.setAlignSelf(CriusAlign.AUTO);
            } else if ("flex-start".equalsIgnoreCase(this.Ls)) {
                this.KZ.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.Ls)) {
                this.KZ.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.Ls)) {
                this.KZ.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.Ls)) {
                this.KZ.setAlignSelf(CriusAlign.STRETCH);
            } else {
                this.KZ.setAlignSelf(CriusAlign.AUTO);
            }
        }
    }

    private void nk() {
        if (!TextUtils.isEmpty(this.Lr)) {
            if ("flex-start".equalsIgnoreCase(this.Lr)) {
                this.KZ.setAlignItems(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.Lr)) {
                this.KZ.setAlignItems(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.Lr)) {
                this.KZ.setAlignItems(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.Lr)) {
                this.KZ.setAlignItems(CriusAlign.STRETCH);
            } else {
                this.KZ.setAlignItems(CriusAlign.STRETCH);
            }
        }
    }

    private void nl() {
        if (!TextUtils.isEmpty(this.Lq)) {
            if ("flex-start".equalsIgnoreCase(this.Lq)) {
                this.KZ.setJustifyContent(CriusJustify.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.Lq)) {
                this.KZ.setJustifyContent(CriusJustify.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.Lq)) {
                this.KZ.setJustifyContent(CriusJustify.FLEX_END);
            } else if ("space-between".equalsIgnoreCase(this.Lq)) {
                this.KZ.setJustifyContent(CriusJustify.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.Lq)) {
                this.KZ.setJustifyContent(CriusJustify.SPACE_AROUND);
            } else {
                this.KZ.setJustifyContent(CriusJustify.FLEX_START);
            }
        }
    }

    private void nm() {
        if (!TextUtils.isEmpty(this.Lp)) {
            if ("column".equalsIgnoreCase(this.Lp)) {
                this.KZ.setFlexDirection(CriusFlexDirection.COLUMN);
            } else if ("column-reverse".equalsIgnoreCase(this.Lp)) {
                this.KZ.setFlexDirection(CriusFlexDirection.COLUMN_REVERSE);
            } else if ("row".equalsIgnoreCase(this.Lp)) {
                this.KZ.setFlexDirection(CriusFlexDirection.ROW);
            } else if ("row-reverse".equalsIgnoreCase(this.Lp)) {
                this.KZ.setFlexDirection(CriusFlexDirection.ROW_REVERSE);
            } else {
                this.KZ.setFlexDirection(CriusFlexDirection.COLUMN);
            }
        }
    }

    public boolean nn() {
        return "text".equals(this.type);
    }

    public a bL(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.id)) {
            if (this.Ms != null && this.Ms.size() > 0) {
                for (a aVar : this.Ms) {
                    a bL = aVar.bL(str);
                    if (bL != null) {
                        return bL;
                    }
                }
            }
            return null;
        }
        return this;
    }

    public a bM(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.Lc)) {
            if (this.Ms != null && this.Ms.size() > 0) {
                for (a aVar : this.Ms) {
                    a bM = aVar.bM(str);
                    if (bM != null) {
                        return bM;
                    }
                }
            }
            return null;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float d(double d) {
        return d < 1.0d ? (float) (10.0d * d) : (float) (this.hz * d);
    }

    public static float a(double d, float f) {
        return d < 1.0d ? (float) (10.0d * d) : (float) (f * d);
    }

    public boolean bN(String str) {
        a bM;
        if (this.KY == null || (bM = bM(str)) == null || bM.KZ == null) {
            return false;
        }
        bM.KZ.setDisplay(CriusDisplay.NONE);
        bM.KZ.dirty();
        this.KY.calculateLayout(Float.NaN, Float.NaN);
        return true;
    }

    public void c(String str, float f) {
        a bL;
        if (this.KY != null && (bL = bL(str)) != null && bL.KZ != null) {
            bL.fontSize = f;
            bL.KZ.dirty();
            this.KY.calculateLayout(Float.NaN, Float.NaN);
        }
    }
}
