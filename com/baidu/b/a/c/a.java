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
import com.baidu.b.a.e.c;
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
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
@TargetApi(23)
/* loaded from: classes13.dex */
public class a {
    public final int amF;
    public final int amG;
    protected int aoA;
    protected int aoB;
    private CriusNode aoC;
    public final CriusNode aoD;
    public final float aoE;
    private TextView aoF;
    private final CriusMeasureFunction aoG;
    public String aoH;
    public String aoI;
    public String aoJ;
    public String aoK;
    public String aoL;
    public int aoM;
    public int aoN;
    public int aoO;
    public String aoP;
    public String aoQ;
    public double aoR;
    public double aoS;
    private String aoT;
    private String aoU;
    private String aoV;
    private String aoW;
    private String aoX;
    private String aoY;
    private double aoZ;
    public String aou;
    protected int aoz;
    public double apA;
    public double apB;
    public double apC;
    public String apD;
    public String apE;
    public Typeface apF;
    public String apG;
    public String apH;
    public String apI;
    public String apJ;
    public String apK;
    public String apL;
    public String apM;
    public String apN;
    public String apO;
    public double apP;
    public String apQ;
    public String apR;
    public String apS;
    public String apT;
    public String apU;
    public final List<a> apV;
    private double apa;
    private double apb;
    private double apc;
    private double apd;
    private double ape;
    private double apf;
    private double apg;
    private double aph;
    private double api;
    private double apj;
    private double apk;
    private double apl;
    private double apm;
    private double apn;
    private double apo;
    private double apq;
    private double apr;
    private double aps;
    private double apt;
    private double apu;
    private double apv;
    private double apw;
    public String apx;
    public double apy;
    public double apz;
    public String backgroundColor;
    public String borderColor;
    public double borderRadius;
    private InterfaceC0090a businessConverter;
    public String color;
    public double fontSize;
    public int gravity;
    private double height;
    public String id;
    public int maxLines;
    public String name;
    public double opacity;
    private String position;
    public String poster;
    public String shareContent;
    public String shareTitle;
    public String src;
    public String text;
    public String type;
    public int videoDuration;
    private double width;

    /* renamed from: com.baidu.b.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0090a {
        String dS(String str);
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
            if (Double.compare(aVar.tA(), 0.0d) > 0) {
                textView.setTextSize(0, (float) (aVar.tA() * textView.getContext().getResources().getDisplayMetrics().density));
            }
            textView.setIncludeFontPadding(false);
            textView.setTypeface(aVar.apF);
            textView.setGravity(aVar.gravity);
            float h = aVar.aoR > 0.0d ? h(aVar.aoR) : 0.0f;
            float f = aVar.aoS > 0.0d ? (float) aVar.aoS : 1.0f;
            if (h > 0.0f || f > 0.0f) {
                textView.setLineSpacing(h, f);
            }
        }
    }

    public static boolean dO(String str) {
        return Pattern.compile("[^一-龥]").matcher(str).find();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float p(float f) {
        if (Build.VERSION.SDK_INT == 19 || TbadkCoreApplication.getInst().isMIUIRom()) {
            return (1.12f * f) + 0.5f;
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float q(float f) {
        if ((Build.VERSION.SDK_INT == 19 || TbadkCoreApplication.getInst().isMIUIRom()) && this.maxLines == 1 && dO(this.text)) {
            return (1.09859f * f) + 0.5f;
        }
        return f;
    }

    private void j(JSONObject jSONObject) {
        this.id = c.l(jSONObject, "id");
        this.name = c.l(jSONObject, "name");
        this.type = c.l(jSONObject, "type");
        if (uf()) {
            this.aoD.setMeasureFunction(this.aoG);
        }
        this.aoH = c.l(jSONObject, "component");
        this.src = c.l(jSONObject, UserAccountActionItem.KEY_SRC);
        this.poster = c.l(jSONObject, "poster");
        this.aoI = c.l(jSONObject, "href");
        this.text = c.l(jSONObject, "text");
        if ("time".equalsIgnoreCase(this.aoH) && this.businessConverter != null) {
            this.text = this.businessConverter.dS(this.text);
        }
        this.maxLines = jSONObject.optInt("max-lines", 1);
        this.aoR = c.m(jSONObject, "line-space");
        this.aoS = c.m(jSONObject, "line-multi");
        this.videoDuration = jSONObject.optInt("data-video-duration");
        this.aoJ = jSONObject.optString("data-als-stat");
        this.aoK = jSONObject.optString("data-url-stat");
        this.aoL = jSONObject.optString("data-href-pop");
        this.aoM = c.n(jSONObject, "data-share-num");
        this.aoN = c.n(jSONObject, "data-reply-num");
        this.aoO = c.n(jSONObject, "data-agree-num");
        this.shareTitle = jSONObject.optString("data-share-title");
        this.shareContent = jSONObject.optString("data-share-content");
        this.aoP = jSONObject.optString("data-share-image");
        this.aoQ = jSONObject.optString("data-share-link");
    }

    private void k(JSONObject jSONObject) {
        this.aoT = c.l(jSONObject, "display");
        tX();
        this.aoU = c.l(jSONObject, "flex-direction");
        ue();
        this.aoV = c.l(jSONObject, "justify-content");
        ud();
        this.aoW = c.l(jSONObject, "align-items");
        uc();
        this.aoX = c.l(jSONObject, "align-self");
        ub();
        this.aoY = c.l(jSONObject, "align-content");
        ua();
        this.aoZ = c.m(jSONObject, "flex");
        tW();
        this.apa = c.m(jSONObject, "flex-grow");
        tV();
        this.apb = c.m(jSONObject, "flex-shrink");
        tU();
        this.apc = c.m(jSONObject, "flex-basis");
        tT();
        this.position = c.l(jSONObject, "position");
        tZ();
        this.apd = c.m(jSONObject, "left");
        this.ape = c.m(jSONObject, VerticalTranslateLayout.TOP);
        this.apf = c.m(jSONObject, HorizontalTranslateLayout.DIRECTION_RIGHT);
        this.apg = c.m(jSONObject, VerticalTranslateLayout.BOTTOM);
        tY();
        this.aph = c.m(jSONObject, "margin");
        tS();
        this.api = c.m(jSONObject, "margin-left");
        tO();
        this.apj = c.m(jSONObject, "margin-top");
        tR();
        this.apk = c.m(jSONObject, "margin-right");
        tQ();
        this.apl = c.m(jSONObject, "margin-bottom");
        tP();
        this.apm = c.m(jSONObject, "padding");
        initPadding();
        this.apn = c.m(jSONObject, "padding-left");
        tK();
        this.apo = c.m(jSONObject, "padding-top");
        tN();
        this.apq = c.m(jSONObject, "padding-right");
        tM();
        this.apr = c.m(jSONObject, "padding-bottom");
        tL();
        this.width = c.m(jSONObject, "width");
        tJ();
        this.height = c.m(jSONObject, "height");
        tI();
        this.aps = c.m(jSONObject, "min-width");
        tH();
        this.apt = c.m(jSONObject, "min-height");
        tG();
        this.apu = c.m(jSONObject, "max-width");
        tD();
        this.apv = c.m(jSONObject, "max-height");
        tF();
        this.apw = c.m(jSONObject, "aspect-ratio");
        tE();
    }

    private void l(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SharedPrefConfig.ACTIVE_STATE)) != null) {
            this.apR = c.l(optJSONObject, "background-image");
            this.apS = c.l(optJSONObject, "background-color");
            this.apT = c.l(optJSONObject, "border-color");
            this.apU = c.l(optJSONObject, "color");
        }
    }

    private void m(JSONObject jSONObject) {
        this.apM = c.l(jSONObject, "background-image");
        this.apN = c.l(jSONObject, "background-color");
        this.apO = c.l(jSONObject, "border-color");
        this.apP = c.m(jSONObject, "opacity");
        this.apQ = c.l(jSONObject, "color");
    }

    private void n(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SharedPrefConfig.ACTIVE_STATE)) != null) {
            this.apI = c.l(optJSONObject, "background-image");
            this.apJ = c.l(optJSONObject, "background-color");
            this.apK = c.l(optJSONObject, "border-color");
            this.apL = c.l(optJSONObject, "color");
        }
    }

    private void o(JSONObject jSONObject) {
        this.apx = c.l(jSONObject, "background-image");
        this.backgroundColor = c.l(jSONObject, "background-color");
        this.borderColor = c.l(jSONObject, "border-color");
        this.opacity = c.m(jSONObject, "opacity");
        this.color = c.l(jSONObject, "color");
        this.apy = c.m(jSONObject, "border-width");
        this.borderRadius = c.m(jSONObject, "border-radius");
        this.apz = c.m(jSONObject, "border-top-left-radius");
        this.apA = c.m(jSONObject, "border-bottom-left-radius");
        this.apB = c.m(jSONObject, "border-top-right-radius");
        this.apC = c.m(jSONObject, "border-bottom-right-radius");
        this.apD = c.l(jSONObject, "font-style");
        this.apE = c.l(jSONObject, "font-weight");
        this.apF = Typeface.create(Typeface.DEFAULT, tB());
        this.fontSize = jSONObject.optDouble("font-size", 12.0d);
        this.apG = c.l(jSONObject, "text-align");
        this.apH = c.l(jSONObject, "vertical-align");
        this.gravity = tC();
        this.aou = c.l(jSONObject, "download-style");
    }

    public a(Context context, JSONObject jSONObject, InterfaceC0090a interfaceC0090a, boolean z) {
        this.aoz = Build.VERSION.SDK_INT < 23 ? 0 : 1;
        if (Build.VERSION.SDK_INT < 23) {
        }
        this.aoA = 0;
        if (Build.VERSION.SDK_INT < 26) {
        }
        this.aoB = 0;
        this.aoG = new CriusMeasureFunction() { // from class: com.baidu.b.a.c.a.1
            @Override // com.baidu.crius.CriusMeasureFunction
            @SuppressLint({"WrongConstant"})
            public long measure(CriusNode criusNode, float f, CriusMeasureMode criusMeasureMode, float f2, CriusMeasureMode criusMeasureMode2) {
                float f3;
                boolean z2;
                Layout build;
                Layout build2;
                SpannableString spannableString = new SpannableString(a.this.text);
                a.this.a(a.this.aoF, a.this);
                TextPaint paint = a.this.aoF.getPaint();
                BoringLayout.Metrics isBoring = BoringLayout.isBoring(spannableString, paint);
                float desiredWidth = isBoring == null ? Layout.getDesiredWidth(spannableString, paint) : Float.NaN;
                if (a.this.aoR > 0.0d) {
                    f3 = a.this.h(a.this.aoR);
                } else {
                    f3 = 0.0f;
                }
                float f4 = a.this.aoS > 0.0d ? (float) a.this.aoS : 1.0f;
                boolean z3 = criusMeasureMode == CriusMeasureMode.UNDEFINED || f < 0.0f;
                if (isBoring == null && (z3 || (!CriusConstants.isUndefined(desiredWidth) && desiredWidth <= f))) {
                    int ceil = (int) Math.ceil(desiredWidth);
                    if (Build.VERSION.SDK_INT < 23) {
                        build2 = new StaticLayout(spannableString, paint, ceil, Layout.Alignment.ALIGN_NORMAL, f4, f3, false);
                    } else {
                        StaticLayout.Builder hyphenationFrequency = StaticLayout.Builder.obtain(spannableString, 0, spannableString.length(), paint, ceil).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(f3, f4).setIncludePad(false).setBreakStrategy(a.this.aoz).setHyphenationFrequency(a.this.aoA);
                        if (Build.VERSION.SDK_INT >= 26) {
                            hyphenationFrequency.setJustificationMode(a.this.aoB);
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
                    StaticLayout.Builder hyphenationFrequency2 = StaticLayout.Builder.obtain(spannableString, 0, spannableString.length(), paint, (int) f).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(f3, f4).setIncludePad(false).setBreakStrategy(a.this.aoz).setHyphenationFrequency(a.this.aoA);
                    if (Build.VERSION.SDK_INT >= 26) {
                        hyphenationFrequency2.setJustificationMode(a.this.aoB);
                    }
                    a.this.a(hyphenationFrequency2, true);
                    z2 = false;
                    build = hyphenationFrequency2.build();
                }
                if (build != null && a.this.maxLines < build.getLineCount()) {
                    return CriusMeasureOutput.make(a.this.q(build.getWidth()), a.this.p(build.getLineBottom(a.this.maxLines - 1)) - f3);
                }
                if (build != null) {
                    float q = a.this.q(build.getWidth());
                    float p = a.this.p(build.getHeight());
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
                            if (lineDescent > 0.0f && p > lineCount) {
                                p -= f3;
                            }
                        }
                    }
                    return CriusMeasureOutput.make(q, p);
                }
                return CriusMeasureOutput.make(f, f2);
            }
        };
        this.apP = -10000.0d;
        this.aoD = new CriusNode();
        this.businessConverter = interfaceC0090a;
        this.aoE = context.getResources().getDisplayMetrics().density;
        this.amF = context.getResources().getDisplayMetrics().widthPixels;
        this.amG = context.getResources().getDisplayMetrics().heightPixels;
        this.aoF = new TextView(context);
        j(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("style");
        if (optJSONObject != null) {
            k(optJSONObject);
            o(optJSONObject);
            n(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("night-style");
        if (optJSONObject2 != null) {
            m(optJSONObject2);
            l(optJSONObject2);
        }
        if (jSONObject.has("children")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("children");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.apV = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    a aVar = new a(context, optJSONArray.optJSONObject(i), interfaceC0090a, false);
                    this.apV.add(aVar);
                    this.aoD.addChildAt(aVar.aoD, i);
                }
            } else {
                this.apV = null;
            }
        } else {
            this.apV = null;
        }
        if (z) {
            this.aoC = new CriusNode();
            this.aoC.addChildAt(this.aoD, 0);
            this.aoC.calculateLayout(Float.NaN, Float.NaN);
        }
    }

    public double tA() {
        return this.fontSize;
    }

    private int tB() {
        return "italic".equalsIgnoreCase(this.apD) ? (TextUtils.isEmpty(this.apE) || "normal".equalsIgnoreCase(this.apE) || !"bold".equalsIgnoreCase(this.apE)) ? 2 : 3 : (TextUtils.isEmpty(this.apE) || "normal".equalsIgnoreCase(this.apE) || !"bold".equalsIgnoreCase(this.apE)) ? 0 : 1;
    }

    private int tC() {
        int i;
        if ("left".equalsIgnoreCase(this.apG)) {
            i = 3;
        } else if (HorizontalTranslateLayout.DIRECTION_RIGHT.equalsIgnoreCase(this.apG)) {
            i = 5;
        } else if ("center".equalsIgnoreCase(this.apG)) {
            i = 1;
        } else {
            i = 0;
        }
        if (VerticalTranslateLayout.TOP.equalsIgnoreCase(this.apH)) {
            return i | 48;
        }
        if (VerticalTranslateLayout.BOTTOM.equalsIgnoreCase(this.apH)) {
            return i | 80;
        }
        if ("middle".equalsIgnoreCase(this.apH)) {
            return i | 16;
        }
        return i | 0;
    }

    private void tD() {
        if (this.apu >= 0.0d) {
            this.aoD.setMaxWidth(h(this.apu));
        } else if (this.apu > -10000.0d) {
            this.aoD.setMaxWidth(this.amF);
        }
    }

    private void tE() {
        if (this.apw > 0.0d) {
            this.aoD.setAspectRatio((float) this.apw);
        }
    }

    private void tF() {
        if (this.apv >= 0.0d) {
            this.aoD.setMaxHeight(h(this.apv));
        } else if (this.apv > -10000.0d) {
            this.aoD.setMaxHeight(this.amG);
        }
    }

    private void tG() {
        if (this.apt >= 0.0d) {
            this.aoD.setMinHeight(h(this.apt));
        } else if (this.apt > -10000.0d) {
            this.aoD.setMinHeight(this.amG);
        }
    }

    private void tH() {
        if (this.aps >= 0.0d) {
            this.aoD.setMinWidth(h(this.aps));
        } else if (this.aps > -10000.0d) {
            this.aoD.setMinWidth(this.amF);
        }
    }

    private void tI() {
        if (this.height >= 0.0d) {
            this.aoD.setHeight(h(this.height));
        } else if (this.height > -10000.0d) {
            this.aoD.setHeight(this.amG);
        }
    }

    private void tJ() {
        if (this.width >= 0.0d) {
            this.aoD.setWidth(h(this.width));
        } else if (this.width > -10000.0d) {
            this.aoD.setWidth(this.amF);
        }
    }

    private void tK() {
        if (this.apn >= -1.0d) {
            this.aoD.setPadding(CriusEdge.LEFT, h(this.apn));
        }
    }

    private void tL() {
        if (this.apr >= -1.0d) {
            this.aoD.setPadding(CriusEdge.BOTTOM, h(this.apr));
        }
    }

    private void tM() {
        if (this.apq >= -1.0d) {
            this.aoD.setPadding(CriusEdge.RIGHT, h(this.apq));
        }
    }

    private void tN() {
        if (this.apo >= -1.0d) {
            this.aoD.setPadding(CriusEdge.TOP, h(this.apo));
        }
    }

    private void initPadding() {
        if (this.apm >= -1.0d) {
            this.aoD.setPadding(CriusEdge.ALL, h(this.apm));
        }
    }

    private void tO() {
        if (this.api >= -1.0d) {
            this.aoD.setMargin(CriusEdge.LEFT, h(this.api));
        }
    }

    private void tP() {
        if (this.apl >= -1.0d) {
            this.aoD.setMargin(CriusEdge.BOTTOM, h(this.apl));
        }
    }

    private void tQ() {
        if (this.apk >= -1.0d) {
            this.aoD.setMargin(CriusEdge.RIGHT, h(this.apk));
        }
    }

    private void tR() {
        if (this.apj >= -1.0d) {
            this.aoD.setMargin(CriusEdge.TOP, h(this.apj));
        }
    }

    private void tS() {
        if (this.aph >= -1.0d) {
            this.aoD.setMargin(CriusEdge.ALL, h(this.aph));
        }
    }

    private void tT() {
        if (this.apc >= -1.0d) {
            this.aoD.setFlexBasis(h(this.apc));
        }
    }

    private void tU() {
        if (this.apb >= -1.0d) {
            this.aoD.setFlexShrink((float) this.apb);
        }
    }

    private void tV() {
        if (this.apa >= -1.0d) {
            this.aoD.setFlexGrow((float) this.apa);
        }
    }

    private void tW() {
        if (this.aoZ >= -1.0d) {
            this.aoD.setFlex((float) this.aoZ);
        }
    }

    private void tX() {
        if (!TextUtils.isEmpty(this.aoT)) {
            if ("flex".equalsIgnoreCase(this.aoT)) {
                this.aoD.setDisplay(CriusDisplay.FLEX);
            } else if ("none".equalsIgnoreCase(this.aoT)) {
                this.aoD.setDisplay(CriusDisplay.NONE);
            } else {
                this.aoD.setDisplay(CriusDisplay.FLEX);
            }
        }
    }

    private void tY() {
        if (!c.b(this.apd, -10000.0d)) {
            this.aoD.setPosition(CriusEdge.LEFT, h(this.apd));
        }
        if (!c.b(this.ape, -10000.0d)) {
            this.aoD.setPosition(CriusEdge.TOP, h(this.ape));
        }
        if (!c.b(this.apf, -10000.0d)) {
            this.aoD.setPosition(CriusEdge.RIGHT, h(this.apf));
        }
        if (!c.b(this.apg, -10000.0d)) {
            this.aoD.setPosition(CriusEdge.BOTTOM, h(this.apg));
        }
    }

    private void tZ() {
        if (!TextUtils.isEmpty(this.position)) {
            if ("relative".equalsIgnoreCase(this.position)) {
                this.aoD.setPositionType(CriusPositionType.RELATIVE);
            } else if ("absolute".equalsIgnoreCase(this.position)) {
                this.aoD.setPositionType(CriusPositionType.ABSOLUTE);
            }
        }
    }

    private void ua() {
        if (!TextUtils.isEmpty(this.aoY)) {
            if ("flex-start".equalsIgnoreCase(this.aoY)) {
                this.aoD.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.aoY)) {
                this.aoD.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.aoY)) {
                this.aoD.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.aoY)) {
                this.aoD.setAlignSelf(CriusAlign.STRETCH);
            } else if ("space-between".equalsIgnoreCase(this.aoY)) {
                this.aoD.setAlignSelf(CriusAlign.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.aoY)) {
                this.aoD.setAlignSelf(CriusAlign.SPACE_AROUND);
            } else {
                this.aoD.setAlignSelf(CriusAlign.FLEX_START);
            }
        }
    }

    private void ub() {
        if (!TextUtils.isEmpty(this.aoX)) {
            if ("auto".equalsIgnoreCase(this.aoX)) {
                this.aoD.setAlignSelf(CriusAlign.AUTO);
            } else if ("flex-start".equalsIgnoreCase(this.aoX)) {
                this.aoD.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.aoX)) {
                this.aoD.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.aoX)) {
                this.aoD.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.aoX)) {
                this.aoD.setAlignSelf(CriusAlign.STRETCH);
            } else {
                this.aoD.setAlignSelf(CriusAlign.AUTO);
            }
        }
    }

    private void uc() {
        if (!TextUtils.isEmpty(this.aoW)) {
            if ("flex-start".equalsIgnoreCase(this.aoW)) {
                this.aoD.setAlignItems(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.aoW)) {
                this.aoD.setAlignItems(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.aoW)) {
                this.aoD.setAlignItems(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.aoW)) {
                this.aoD.setAlignItems(CriusAlign.STRETCH);
            } else {
                this.aoD.setAlignItems(CriusAlign.STRETCH);
            }
        }
    }

    private void ud() {
        if (!TextUtils.isEmpty(this.aoV)) {
            if ("flex-start".equalsIgnoreCase(this.aoV)) {
                this.aoD.setJustifyContent(CriusJustify.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.aoV)) {
                this.aoD.setJustifyContent(CriusJustify.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.aoV)) {
                this.aoD.setJustifyContent(CriusJustify.FLEX_END);
            } else if ("space-between".equalsIgnoreCase(this.aoV)) {
                this.aoD.setJustifyContent(CriusJustify.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.aoV)) {
                this.aoD.setJustifyContent(CriusJustify.SPACE_AROUND);
            } else {
                this.aoD.setJustifyContent(CriusJustify.FLEX_START);
            }
        }
    }

    private void ue() {
        if (!TextUtils.isEmpty(this.aoU)) {
            if ("column".equalsIgnoreCase(this.aoU)) {
                this.aoD.setFlexDirection(CriusFlexDirection.COLUMN);
            } else if ("column-reverse".equalsIgnoreCase(this.aoU)) {
                this.aoD.setFlexDirection(CriusFlexDirection.COLUMN_REVERSE);
            } else if ("row".equalsIgnoreCase(this.aoU)) {
                this.aoD.setFlexDirection(CriusFlexDirection.ROW);
            } else if ("row-reverse".equalsIgnoreCase(this.aoU)) {
                this.aoD.setFlexDirection(CriusFlexDirection.ROW_REVERSE);
            } else {
                this.aoD.setFlexDirection(CriusFlexDirection.COLUMN);
            }
        }
    }

    public boolean uf() {
        return "text".equals(this.type);
    }

    public a dP(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.id)) {
            if (this.apV != null && this.apV.size() > 0) {
                for (a aVar : this.apV) {
                    a dP = aVar.dP(str);
                    if (dP != null) {
                        return dP;
                    }
                }
            }
            return null;
        }
        return this;
    }

    public a dQ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.aoH)) {
            if (this.apV != null && this.apV.size() > 0) {
                for (a aVar : this.apV) {
                    a dQ = aVar.dQ(str);
                    if (dQ != null) {
                        return dQ;
                    }
                }
            }
            return null;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float h(double d) {
        return d < 1.0d ? (float) (10.0d * d) : (float) (this.aoE * d);
    }

    public static float a(double d, float f) {
        return d < 1.0d ? (float) (10.0d * d) : (float) (f * d);
    }

    public boolean dR(String str) {
        a dQ;
        if (this.aoC == null || (dQ = dQ(str)) == null || dQ.aoD == null) {
            return false;
        }
        dQ.aoD.setDisplay(CriusDisplay.NONE);
        dQ.aoD.dirty();
        this.aoC.calculateLayout(Float.NaN, Float.NaN);
        return true;
    }

    public void c(String str, float f) {
        a dP;
        if (this.aoC != null && (dP = dP(str)) != null && dP.aoD != null) {
            dP.fontSize = f;
            dP.aoD.dirty();
            this.aoC.calculateLayout(Float.NaN, Float.NaN);
        }
    }
}
