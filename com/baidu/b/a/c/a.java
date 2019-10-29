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
    public final int Ks;
    public final int Kt;
    private TextView LA;
    private final CriusMeasureFunction LB;
    public String LC;
    public String LD;
    public String LE;
    public String LG;
    public String LH;
    public int LI;
    public int LJ;
    public int LK;
    public String LM;
    public String LN;
    public double LO;
    public double LP;
    private String LQ;
    private String LR;
    private String LS;
    private String LU;
    private String LV;
    private String LW;
    private double LX;
    private double LY;
    private double LZ;
    public String Li;
    public String Lq;
    protected int Lv;
    protected int Lw;
    protected int Lx;
    private CriusNode Ly;
    public final CriusNode Lz;
    public String MA;
    public String MB;
    public Typeface MC;
    public String MD;
    public String ME;
    public String MF;
    public String MG;
    public String MH;
    public String MI;
    public String MJ;
    public String MK;
    public String MM;
    public double MN;
    public String MO;
    public String MP;
    public String MQ;
    public String MR;
    public String MS;
    public final List<a> MT;
    private double Ma;
    private double Mb;
    private double Mc;
    private double Md;
    private double Me;
    private double Mf;
    private double Mg;
    private double Mh;
    private double Mi;
    private double Mj;
    private double Mk;
    private double Ml;
    private double Mm;
    private double Mn;
    private double Mo;
    private double Mp;
    private double Mq;
    private double Mr;
    private double Ms;
    private double Mt;
    public String Mu;
    public double Mv;
    public double Mw;
    public double Mx;
    public double My;
    public double Mz;
    public String backgroundColor;
    public String borderColor;
    public double borderRadius;
    private InterfaceC0040a businessConverter;
    public String color;
    public double fontSize;
    public int gravity;
    public final float hY;
    private double height;
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
            textView.setTypeface(aVar.MC);
            textView.setGravity(aVar.gravity);
            float d = aVar.LO > 0.0d ? d(aVar.LO) : 0.0f;
            float f = aVar.LP > 0.0d ? (float) aVar.LP : 1.0f;
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
            this.Lz.setMeasureFunction(this.LB);
        }
        this.LC = b.g(jSONObject, "component");
        this.src = b.g(jSONObject, "src");
        this.Li = b.g(jSONObject, "poster");
        this.LD = b.g(jSONObject, "href");
        this.text = b.g(jSONObject, "text");
        if ("time".equalsIgnoreCase(this.LC) && this.businessConverter != null) {
            this.text = this.businessConverter.bO(this.text);
        }
        this.maxLines = jSONObject.optInt("max-lines", 1);
        this.LO = b.h(jSONObject, "line-space");
        this.LP = b.h(jSONObject, "line-multi");
        this.videoDuration = jSONObject.optInt("data-video-duration");
        this.LE = jSONObject.optString("data-als-stat");
        this.LG = jSONObject.optString("data-url-stat");
        this.LH = jSONObject.optString("data-href-pop");
        this.LI = b.i(jSONObject, "data-share-num");
        this.LJ = b.i(jSONObject, "data-reply-num");
        this.LK = b.i(jSONObject, "data-agree-num");
        this.shareTitle = jSONObject.optString("data-share-title");
        this.shareContent = jSONObject.optString("data-share-content");
        this.LM = jSONObject.optString("data-share-image");
        this.LN = jSONObject.optString("data-share-link");
    }

    private void i(JSONObject jSONObject) {
        this.LQ = b.g(jSONObject, LogConfig.KEY_DISPLAY);
        nf();
        this.LR = b.g(jSONObject, "flex-direction");
        nm();
        this.LS = b.g(jSONObject, "justify-content");
        nl();
        this.LU = b.g(jSONObject, "align-items");
        nk();
        this.LV = b.g(jSONObject, "align-self");
        nj();
        this.LW = b.g(jSONObject, "align-content");
        ni();
        this.LX = b.h(jSONObject, "flex");
        ne();
        this.LY = b.h(jSONObject, "flex-grow");
        nd();
        this.LZ = b.h(jSONObject, "flex-shrink");
        nc();
        this.Ma = b.h(jSONObject, "flex-basis");
        nb();
        this.position = b.g(jSONObject, "position");
        nh();
        this.Mb = b.h(jSONObject, "left");
        this.Mc = b.h(jSONObject, VerticalTranslateLayout.TOP);
        this.Md = b.h(jSONObject, HorizontalTranslateLayout.RIGHT);
        this.Me = b.h(jSONObject, VerticalTranslateLayout.BOTTOM);
        ng();
        this.Mf = b.h(jSONObject, "margin");
        na();
        this.Mg = b.h(jSONObject, "margin-left");
        mW();
        this.Mh = b.h(jSONObject, "margin-top");
        mZ();
        this.Mi = b.h(jSONObject, "margin-right");
        mY();
        this.Mj = b.h(jSONObject, "margin-bottom");
        mX();
        this.Mk = b.h(jSONObject, "padding");
        initPadding();
        this.Ml = b.h(jSONObject, "padding-left");
        mS();
        this.Mm = b.h(jSONObject, "padding-top");
        mV();
        this.Mn = b.h(jSONObject, "padding-right");
        mU();
        this.Mo = b.h(jSONObject, "padding-bottom");
        mT();
        this.width = b.h(jSONObject, "width");
        mR();
        this.height = b.h(jSONObject, "height");
        mQ();
        this.Mp = b.h(jSONObject, "min-width");
        mP();
        this.Mq = b.h(jSONObject, "min-height");
        mO();
        this.Mr = b.h(jSONObject, "max-width");
        mL();
        this.Ms = b.h(jSONObject, "max-height");
        mN();
        this.Mt = b.h(jSONObject, "aspect-ratio");
        mM();
    }

    private void j(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SharedPrefConfig.ACTIVE_STATE)) != null) {
            this.MP = b.g(optJSONObject, "background-image");
            this.MQ = b.g(optJSONObject, "background-color");
            this.MR = b.g(optJSONObject, "border-color");
            this.MS = b.g(optJSONObject, "color");
        }
    }

    private void k(JSONObject jSONObject) {
        this.MJ = b.g(jSONObject, "background-image");
        this.MK = b.g(jSONObject, "background-color");
        this.MM = b.g(jSONObject, "border-color");
        this.MN = b.h(jSONObject, "opacity");
        this.MO = b.g(jSONObject, "color");
    }

    private void l(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SharedPrefConfig.ACTIVE_STATE)) != null) {
            this.MF = b.g(optJSONObject, "background-image");
            this.MG = b.g(optJSONObject, "background-color");
            this.MH = b.g(optJSONObject, "border-color");
            this.MI = b.g(optJSONObject, "color");
        }
    }

    private void m(JSONObject jSONObject) {
        this.Mu = b.g(jSONObject, "background-image");
        this.backgroundColor = b.g(jSONObject, "background-color");
        this.borderColor = b.g(jSONObject, "border-color");
        this.opacity = b.h(jSONObject, "opacity");
        this.color = b.g(jSONObject, "color");
        this.Mv = b.h(jSONObject, "border-width");
        this.borderRadius = b.h(jSONObject, "border-radius");
        this.Mw = b.h(jSONObject, "border-top-left-radius");
        this.Mx = b.h(jSONObject, "border-bottom-left-radius");
        this.My = b.h(jSONObject, "border-top-right-radius");
        this.Mz = b.h(jSONObject, "border-bottom-right-radius");
        this.MA = b.g(jSONObject, "font-style");
        this.MB = b.g(jSONObject, "font-weight");
        this.MC = Typeface.create(Typeface.DEFAULT, mJ());
        this.fontSize = jSONObject.optDouble("font-size", 12.0d);
        this.MD = b.g(jSONObject, "text-align");
        this.ME = b.g(jSONObject, "vertical-align");
        this.gravity = mK();
        this.Lq = b.g(jSONObject, "download-style");
    }

    public a(Context context, JSONObject jSONObject, InterfaceC0040a interfaceC0040a, boolean z) {
        this.Lv = Build.VERSION.SDK_INT < 23 ? 0 : 1;
        if (Build.VERSION.SDK_INT < 23) {
        }
        this.Lw = 0;
        if (Build.VERSION.SDK_INT < 26) {
        }
        this.Lx = 0;
        this.LB = new CriusMeasureFunction() { // from class: com.baidu.b.a.c.a.1
            @Override // com.baidu.crius.CriusMeasureFunction
            @SuppressLint({"WrongConstant"})
            public long measure(CriusNode criusNode, float f, CriusMeasureMode criusMeasureMode, float f2, CriusMeasureMode criusMeasureMode2) {
                float f3;
                boolean z2;
                Layout build;
                Layout build2;
                SpannableString spannableString = new SpannableString(a.this.text);
                a.this.a(a.this.LA, a.this);
                TextPaint paint = a.this.LA.getPaint();
                BoringLayout.Metrics isBoring = BoringLayout.isBoring(spannableString, paint);
                float desiredWidth = isBoring == null ? Layout.getDesiredWidth(spannableString, paint) : Float.NaN;
                if (a.this.LO > 0.0d) {
                    f3 = a.this.d(a.this.LO);
                } else {
                    f3 = 0.0f;
                }
                float f4 = a.this.LP > 0.0d ? (float) a.this.LP : 1.0f;
                boolean z3 = criusMeasureMode == CriusMeasureMode.UNDEFINED || f < 0.0f;
                if (isBoring == null && (z3 || (!CriusConstants.isUndefined(desiredWidth) && desiredWidth <= f))) {
                    int ceil = (int) Math.ceil(desiredWidth);
                    if (Build.VERSION.SDK_INT < 23) {
                        build2 = new StaticLayout(spannableString, paint, ceil, Layout.Alignment.ALIGN_NORMAL, f4, f3, false);
                    } else {
                        StaticLayout.Builder hyphenationFrequency = StaticLayout.Builder.obtain(spannableString, 0, spannableString.length(), paint, ceil).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(f3, f4).setIncludePad(false).setBreakStrategy(a.this.Lv).setHyphenationFrequency(a.this.Lw);
                        if (Build.VERSION.SDK_INT >= 26) {
                            hyphenationFrequency.setJustificationMode(a.this.Lx);
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
                    StaticLayout.Builder hyphenationFrequency2 = StaticLayout.Builder.obtain(spannableString, 0, spannableString.length(), paint, (int) f).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(f3, f4).setIncludePad(false).setBreakStrategy(a.this.Lv).setHyphenationFrequency(a.this.Lw);
                    if (Build.VERSION.SDK_INT >= 26) {
                        hyphenationFrequency2.setJustificationMode(a.this.Lx);
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
        this.MN = -10000.0d;
        this.Lz = new CriusNode();
        this.businessConverter = interfaceC0040a;
        this.hY = context.getResources().getDisplayMetrics().density;
        this.Ks = context.getResources().getDisplayMetrics().widthPixels;
        this.Kt = context.getResources().getDisplayMetrics().heightPixels;
        this.LA = new TextView(context);
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
                this.MT = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    a aVar = new a(context, optJSONArray.optJSONObject(i), interfaceC0040a, false);
                    this.MT.add(aVar);
                    this.Lz.addChildAt(aVar.Lz, i);
                }
            } else {
                this.MT = null;
            }
        } else {
            this.MT = null;
        }
        if (z) {
            this.Ly = new CriusNode();
            this.Ly.addChildAt(this.Lz, 0);
            this.Ly.calculateLayout(Float.NaN, Float.NaN);
        }
    }

    public double mI() {
        return this.fontSize;
    }

    private int mJ() {
        return "italic".equalsIgnoreCase(this.MA) ? (TextUtils.isEmpty(this.MB) || "normal".equalsIgnoreCase(this.MB) || !"bold".equalsIgnoreCase(this.MB)) ? 2 : 3 : (TextUtils.isEmpty(this.MB) || "normal".equalsIgnoreCase(this.MB) || !"bold".equalsIgnoreCase(this.MB)) ? 0 : 1;
    }

    private int mK() {
        int i;
        if ("left".equalsIgnoreCase(this.MD)) {
            i = 3;
        } else if (HorizontalTranslateLayout.RIGHT.equalsIgnoreCase(this.MD)) {
            i = 5;
        } else if ("center".equalsIgnoreCase(this.MD)) {
            i = 1;
        } else {
            i = 0;
        }
        if (VerticalTranslateLayout.TOP.equalsIgnoreCase(this.ME)) {
            return i | 48;
        }
        if (VerticalTranslateLayout.BOTTOM.equalsIgnoreCase(this.ME)) {
            return i | 80;
        }
        if ("middle".equalsIgnoreCase(this.ME)) {
            return i | 16;
        }
        return i | 0;
    }

    private void mL() {
        if (this.Mr >= 0.0d) {
            this.Lz.setMaxWidth(d(this.Mr));
        } else if (this.Mr > -10000.0d) {
            this.Lz.setMaxWidth(this.Ks);
        }
    }

    private void mM() {
        if (this.Mt > 0.0d) {
            this.Lz.setAspectRatio((float) this.Mt);
        }
    }

    private void mN() {
        if (this.Ms >= 0.0d) {
            this.Lz.setMaxHeight(d(this.Ms));
        } else if (this.Ms > -10000.0d) {
            this.Lz.setMaxHeight(this.Kt);
        }
    }

    private void mO() {
        if (this.Mq >= 0.0d) {
            this.Lz.setMinHeight(d(this.Mq));
        } else if (this.Mq > -10000.0d) {
            this.Lz.setMinHeight(this.Kt);
        }
    }

    private void mP() {
        if (this.Mp >= 0.0d) {
            this.Lz.setMinWidth(d(this.Mp));
        } else if (this.Mp > -10000.0d) {
            this.Lz.setMinWidth(this.Ks);
        }
    }

    private void mQ() {
        if (this.height >= 0.0d) {
            this.Lz.setHeight(d(this.height));
        } else if (this.height > -10000.0d) {
            this.Lz.setHeight(this.Kt);
        }
    }

    private void mR() {
        if (this.width >= 0.0d) {
            this.Lz.setWidth(d(this.width));
        } else if (this.width > -10000.0d) {
            this.Lz.setWidth(this.Ks);
        }
    }

    private void mS() {
        if (this.Ml >= -1.0d) {
            this.Lz.setPadding(CriusEdge.LEFT, d(this.Ml));
        }
    }

    private void mT() {
        if (this.Mo >= -1.0d) {
            this.Lz.setPadding(CriusEdge.BOTTOM, d(this.Mo));
        }
    }

    private void mU() {
        if (this.Mn >= -1.0d) {
            this.Lz.setPadding(CriusEdge.RIGHT, d(this.Mn));
        }
    }

    private void mV() {
        if (this.Mm >= -1.0d) {
            this.Lz.setPadding(CriusEdge.TOP, d(this.Mm));
        }
    }

    private void initPadding() {
        if (this.Mk >= -1.0d) {
            this.Lz.setPadding(CriusEdge.ALL, d(this.Mk));
        }
    }

    private void mW() {
        if (this.Mg >= -1.0d) {
            this.Lz.setMargin(CriusEdge.LEFT, d(this.Mg));
        }
    }

    private void mX() {
        if (this.Mj >= -1.0d) {
            this.Lz.setMargin(CriusEdge.BOTTOM, d(this.Mj));
        }
    }

    private void mY() {
        if (this.Mi >= -1.0d) {
            this.Lz.setMargin(CriusEdge.RIGHT, d(this.Mi));
        }
    }

    private void mZ() {
        if (this.Mh >= -1.0d) {
            this.Lz.setMargin(CriusEdge.TOP, d(this.Mh));
        }
    }

    private void na() {
        if (this.Mf >= -1.0d) {
            this.Lz.setMargin(CriusEdge.ALL, d(this.Mf));
        }
    }

    private void nb() {
        if (this.Ma >= -1.0d) {
            this.Lz.setFlexBasis(d(this.Ma));
        }
    }

    private void nc() {
        if (this.LZ >= -1.0d) {
            this.Lz.setFlexShrink((float) this.LZ);
        }
    }

    private void nd() {
        if (this.LY >= -1.0d) {
            this.Lz.setFlexGrow((float) this.LY);
        }
    }

    private void ne() {
        if (this.LX >= -1.0d) {
            this.Lz.setFlex((float) this.LX);
        }
    }

    private void nf() {
        if (!TextUtils.isEmpty(this.LQ)) {
            if ("flex".equalsIgnoreCase(this.LQ)) {
                this.Lz.setDisplay(CriusDisplay.FLEX);
            } else if (IXAdSystemUtils.NT_NONE.equalsIgnoreCase(this.LQ)) {
                this.Lz.setDisplay(CriusDisplay.NONE);
            } else {
                this.Lz.setDisplay(CriusDisplay.FLEX);
            }
        }
    }

    private void ng() {
        if (!b.c(this.Mb, -10000.0d)) {
            this.Lz.setPosition(CriusEdge.LEFT, d(this.Mb));
        }
        if (!b.c(this.Mc, -10000.0d)) {
            this.Lz.setPosition(CriusEdge.TOP, d(this.Mc));
        }
        if (!b.c(this.Md, -10000.0d)) {
            this.Lz.setPosition(CriusEdge.RIGHT, d(this.Md));
        }
        if (!b.c(this.Me, -10000.0d)) {
            this.Lz.setPosition(CriusEdge.BOTTOM, d(this.Me));
        }
    }

    private void nh() {
        if (!TextUtils.isEmpty(this.position)) {
            if ("relative".equalsIgnoreCase(this.position)) {
                this.Lz.setPositionType(CriusPositionType.RELATIVE);
            } else if ("absolute".equalsIgnoreCase(this.position)) {
                this.Lz.setPositionType(CriusPositionType.ABSOLUTE);
            }
        }
    }

    private void ni() {
        if (!TextUtils.isEmpty(this.LW)) {
            if ("flex-start".equalsIgnoreCase(this.LW)) {
                this.Lz.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.LW)) {
                this.Lz.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.LW)) {
                this.Lz.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.LW)) {
                this.Lz.setAlignSelf(CriusAlign.STRETCH);
            } else if ("space-between".equalsIgnoreCase(this.LW)) {
                this.Lz.setAlignSelf(CriusAlign.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.LW)) {
                this.Lz.setAlignSelf(CriusAlign.SPACE_AROUND);
            } else {
                this.Lz.setAlignSelf(CriusAlign.FLEX_START);
            }
        }
    }

    private void nj() {
        if (!TextUtils.isEmpty(this.LV)) {
            if ("auto".equalsIgnoreCase(this.LV)) {
                this.Lz.setAlignSelf(CriusAlign.AUTO);
            } else if ("flex-start".equalsIgnoreCase(this.LV)) {
                this.Lz.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.LV)) {
                this.Lz.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.LV)) {
                this.Lz.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.LV)) {
                this.Lz.setAlignSelf(CriusAlign.STRETCH);
            } else {
                this.Lz.setAlignSelf(CriusAlign.AUTO);
            }
        }
    }

    private void nk() {
        if (!TextUtils.isEmpty(this.LU)) {
            if ("flex-start".equalsIgnoreCase(this.LU)) {
                this.Lz.setAlignItems(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.LU)) {
                this.Lz.setAlignItems(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.LU)) {
                this.Lz.setAlignItems(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.LU)) {
                this.Lz.setAlignItems(CriusAlign.STRETCH);
            } else {
                this.Lz.setAlignItems(CriusAlign.STRETCH);
            }
        }
    }

    private void nl() {
        if (!TextUtils.isEmpty(this.LS)) {
            if ("flex-start".equalsIgnoreCase(this.LS)) {
                this.Lz.setJustifyContent(CriusJustify.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.LS)) {
                this.Lz.setJustifyContent(CriusJustify.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.LS)) {
                this.Lz.setJustifyContent(CriusJustify.FLEX_END);
            } else if ("space-between".equalsIgnoreCase(this.LS)) {
                this.Lz.setJustifyContent(CriusJustify.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.LS)) {
                this.Lz.setJustifyContent(CriusJustify.SPACE_AROUND);
            } else {
                this.Lz.setJustifyContent(CriusJustify.FLEX_START);
            }
        }
    }

    private void nm() {
        if (!TextUtils.isEmpty(this.LR)) {
            if ("column".equalsIgnoreCase(this.LR)) {
                this.Lz.setFlexDirection(CriusFlexDirection.COLUMN);
            } else if ("column-reverse".equalsIgnoreCase(this.LR)) {
                this.Lz.setFlexDirection(CriusFlexDirection.COLUMN_REVERSE);
            } else if ("row".equalsIgnoreCase(this.LR)) {
                this.Lz.setFlexDirection(CriusFlexDirection.ROW);
            } else if ("row-reverse".equalsIgnoreCase(this.LR)) {
                this.Lz.setFlexDirection(CriusFlexDirection.ROW_REVERSE);
            } else {
                this.Lz.setFlexDirection(CriusFlexDirection.COLUMN);
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
            if (this.MT != null && this.MT.size() > 0) {
                for (a aVar : this.MT) {
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
        if (!str.equalsIgnoreCase(this.LC)) {
            if (this.MT != null && this.MT.size() > 0) {
                for (a aVar : this.MT) {
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
        return d < 1.0d ? (float) (10.0d * d) : (float) (this.hY * d);
    }

    public static float a(double d, float f) {
        return d < 1.0d ? (float) (10.0d * d) : (float) (f * d);
    }

    public boolean bN(String str) {
        a bM;
        if (this.Ly == null || (bM = bM(str)) == null || bM.Lz == null) {
            return false;
        }
        bM.Lz.setDisplay(CriusDisplay.NONE);
        bM.Lz.dirty();
        this.Ly.calculateLayout(Float.NaN, Float.NaN);
        return true;
    }

    public void c(String str, float f) {
        a bL;
        if (this.Ly != null && (bL = bL(str)) != null && bL.Lz != null) {
            bL.fontSize = f;
            bL.Lz.dirty();
            this.Ly.calculateLayout(Float.NaN, Float.NaN);
        }
    }
}
