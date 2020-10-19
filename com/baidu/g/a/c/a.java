package com.baidu.g.a.c;

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
import com.baidu.g.a.e.c;
import com.baidu.live.adp.widget.HorizontalTranslateLayout;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
@TargetApi(23)
/* loaded from: classes26.dex */
public class a {
    public final int aoP;
    public final int aoQ;
    public String auB;
    protected int auG;
    protected int auH;
    protected int auI;
    private CriusNode auJ;
    public final CriusNode auK;
    public final float auL;
    private TextView auM;
    private final CriusMeasureFunction auN;
    public String auO;
    public String auP;
    public String auQ;
    public String auR;
    public String auS;
    public int auT;
    public int auU;
    public int auV;
    public String auW;
    public String auX;
    public double auY;
    public double auZ;
    private double avA;
    private double avB;
    private double avC;
    public String avD;
    public double avE;
    public double avF;
    public double avG;
    public double avH;
    public double avI;
    public String avJ;
    public String avK;
    public Typeface avL;
    public String avM;
    public String avN;
    public String avO;
    public String avP;
    public String avQ;
    public String avR;
    public String avS;
    public String avT;
    public String avU;
    public double avV;
    public String avW;
    public String avX;
    public String avY;
    public String avZ;
    private String ava;
    private String avb;
    private String avc;
    private String avd;
    private String ave;
    private String avf;
    private double avg;
    private double avh;
    private double avi;
    private double avj;
    private double avk;
    private double avl;
    private double avm;
    private double avn;
    private double avo;
    private double avp;
    private double avq;
    private double avr;
    private double avs;
    private double avt;
    private double avu;
    private double avv;
    private double avw;
    private double avx;
    private double avy;
    private double avz;
    public String awa;
    public final List<a> awb;
    public String backgroundColor;
    public String borderColor;
    public double borderRadius;
    private InterfaceC0133a businessConverter;
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

    /* renamed from: com.baidu.g.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public interface InterfaceC0133a {
        String fs(String str);
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
            if (Double.compare(aVar.zs(), 0.0d) > 0) {
                textView.setTextSize(0, (float) (aVar.zs() * textView.getContext().getResources().getDisplayMetrics().density));
            }
            textView.setIncludeFontPadding(false);
            textView.setTypeface(aVar.avL);
            textView.setGravity(aVar.gravity);
            float n = aVar.auY > 0.0d ? n(aVar.auY) : 0.0f;
            float f = aVar.auZ > 0.0d ? (float) aVar.auZ : 1.0f;
            if (n > 0.0f || f > 0.0f) {
                textView.setLineSpacing(n, f);
            }
        }
    }

    public static boolean fo(String str) {
        return Pattern.compile("[^一-龥]").matcher(str).find();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float q(float f) {
        if (Build.VERSION.SDK_INT == 19 || TbadkCoreApplication.getInst().isMIUIRom()) {
            return (1.12f * f) + 0.5f;
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float r(float f) {
        if ((Build.VERSION.SDK_INT == 19 || TbadkCoreApplication.getInst().isMIUIRom()) && this.maxLines == 1 && fo(this.text)) {
            return (1.09859f * f) + 0.5f;
        }
        return f;
    }

    private void j(JSONObject jSONObject) {
        this.id = c.l(jSONObject, "id");
        this.name = c.l(jSONObject, "name");
        this.type = c.l(jSONObject, "type");
        if (zX()) {
            this.auK.setMeasureFunction(this.auN);
        }
        this.auO = c.l(jSONObject, "component");
        this.src = c.l(jSONObject, "src");
        this.poster = c.l(jSONObject, "poster");
        this.auP = c.l(jSONObject, "href");
        this.text = c.l(jSONObject, "text");
        if ("time".equalsIgnoreCase(this.auO) && this.businessConverter != null) {
            this.text = this.businessConverter.fs(this.text);
        }
        this.maxLines = jSONObject.optInt("max-lines", 1);
        this.auY = c.m(jSONObject, "line-space");
        this.auZ = c.m(jSONObject, "line-multi");
        this.videoDuration = jSONObject.optInt("data-video-duration");
        this.auQ = jSONObject.optString("data-als-stat");
        this.auR = jSONObject.optString("data-url-stat");
        this.auS = jSONObject.optString("data-href-pop");
        this.auT = c.n(jSONObject, "data-share-num");
        this.auU = c.n(jSONObject, "data-reply-num");
        this.auV = c.n(jSONObject, "data-agree-num");
        this.shareTitle = jSONObject.optString("data-share-title");
        this.shareContent = jSONObject.optString("data-share-content");
        this.auW = jSONObject.optString("data-share-image");
        this.auX = jSONObject.optString("data-share-link");
    }

    private void k(JSONObject jSONObject) {
        this.ava = c.l(jSONObject, "display");
        zP();
        this.avb = c.l(jSONObject, "flex-direction");
        zW();
        this.avc = c.l(jSONObject, "justify-content");
        zV();
        this.avd = c.l(jSONObject, "align-items");
        zU();
        this.ave = c.l(jSONObject, "align-self");
        zT();
        this.avf = c.l(jSONObject, "align-content");
        zS();
        this.avg = c.m(jSONObject, "flex");
        zO();
        this.avh = c.m(jSONObject, "flex-grow");
        zN();
        this.avi = c.m(jSONObject, "flex-shrink");
        zM();
        this.avj = c.m(jSONObject, "flex-basis");
        zL();
        this.position = c.l(jSONObject, "position");
        zR();
        this.avk = c.m(jSONObject, "left");
        this.avl = c.m(jSONObject, VerticalTranslateLayout.TOP);
        this.avm = c.m(jSONObject, HorizontalTranslateLayout.DIRECTION_RIGHT);
        this.avn = c.m(jSONObject, VerticalTranslateLayout.BOTTOM);
        zQ();
        this.avo = c.m(jSONObject, "margin");
        zK();
        this.avp = c.m(jSONObject, "margin-left");
        zG();
        this.avq = c.m(jSONObject, "margin-top");
        zJ();
        this.avr = c.m(jSONObject, "margin-right");
        zI();
        this.avs = c.m(jSONObject, "margin-bottom");
        zH();
        this.avt = c.m(jSONObject, "padding");
        initPadding();
        this.avu = c.m(jSONObject, "padding-left");
        zC();
        this.avv = c.m(jSONObject, "padding-top");
        zF();
        this.avw = c.m(jSONObject, "padding-right");
        zE();
        this.avx = c.m(jSONObject, "padding-bottom");
        zD();
        this.width = c.m(jSONObject, "width");
        zB();
        this.height = c.m(jSONObject, "height");
        zA();
        this.avy = c.m(jSONObject, "min-width");
        zz();
        this.avz = c.m(jSONObject, "min-height");
        zy();
        this.avA = c.m(jSONObject, "max-width");
        zv();
        this.avB = c.m(jSONObject, "max-height");
        zx();
        this.avC = c.m(jSONObject, "aspect-ratio");
        zw();
    }

    private void l(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SharedPrefConfig.ACTIVE_STATE)) != null) {
            this.avX = c.l(optJSONObject, "background-image");
            this.avY = c.l(optJSONObject, "background-color");
            this.avZ = c.l(optJSONObject, "border-color");
            this.awa = c.l(optJSONObject, "color");
        }
    }

    private void m(JSONObject jSONObject) {
        this.avS = c.l(jSONObject, "background-image");
        this.avT = c.l(jSONObject, "background-color");
        this.avU = c.l(jSONObject, "border-color");
        this.avV = c.m(jSONObject, "opacity");
        this.avW = c.l(jSONObject, "color");
    }

    private void n(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SharedPrefConfig.ACTIVE_STATE)) != null) {
            this.avO = c.l(optJSONObject, "background-image");
            this.avP = c.l(optJSONObject, "background-color");
            this.avQ = c.l(optJSONObject, "border-color");
            this.avR = c.l(optJSONObject, "color");
        }
    }

    private void o(JSONObject jSONObject) {
        this.avD = c.l(jSONObject, "background-image");
        this.backgroundColor = c.l(jSONObject, "background-color");
        this.borderColor = c.l(jSONObject, "border-color");
        this.opacity = c.m(jSONObject, "opacity");
        this.color = c.l(jSONObject, "color");
        this.avE = c.m(jSONObject, "border-width");
        this.borderRadius = c.m(jSONObject, "border-radius");
        this.avF = c.m(jSONObject, "border-top-left-radius");
        this.avG = c.m(jSONObject, "border-bottom-left-radius");
        this.avH = c.m(jSONObject, "border-top-right-radius");
        this.avI = c.m(jSONObject, "border-bottom-right-radius");
        this.avJ = c.l(jSONObject, "font-style");
        this.avK = c.l(jSONObject, "font-weight");
        this.avL = Typeface.create(Typeface.DEFAULT, zt());
        this.fontSize = jSONObject.optDouble("font-size", 12.0d);
        this.avM = c.l(jSONObject, "text-align");
        this.avN = c.l(jSONObject, "vertical-align");
        this.gravity = zu();
        this.auB = c.l(jSONObject, "download-style");
    }

    public a(Context context, JSONObject jSONObject, InterfaceC0133a interfaceC0133a, boolean z) {
        this.auG = Build.VERSION.SDK_INT < 23 ? 0 : 1;
        if (Build.VERSION.SDK_INT < 23) {
        }
        this.auH = 0;
        if (Build.VERSION.SDK_INT < 26) {
        }
        this.auI = 0;
        this.auN = new CriusMeasureFunction() { // from class: com.baidu.g.a.c.a.1
            @Override // com.baidu.crius.CriusMeasureFunction
            @SuppressLint({"WrongConstant"})
            public long measure(CriusNode criusNode, float f, CriusMeasureMode criusMeasureMode, float f2, CriusMeasureMode criusMeasureMode2) {
                float f3;
                boolean z2;
                Layout build;
                Layout build2;
                SpannableString spannableString = new SpannableString(a.this.text);
                a.this.a(a.this.auM, a.this);
                TextPaint paint = a.this.auM.getPaint();
                BoringLayout.Metrics isBoring = BoringLayout.isBoring(spannableString, paint);
                float desiredWidth = isBoring == null ? Layout.getDesiredWidth(spannableString, paint) : Float.NaN;
                if (a.this.auY > 0.0d) {
                    f3 = a.this.n(a.this.auY);
                } else {
                    f3 = 0.0f;
                }
                float f4 = a.this.auZ > 0.0d ? (float) a.this.auZ : 1.0f;
                boolean z3 = criusMeasureMode == CriusMeasureMode.UNDEFINED || f < 0.0f;
                if (isBoring == null && (z3 || (!CriusConstants.isUndefined(desiredWidth) && desiredWidth <= f))) {
                    int ceil = (int) Math.ceil(desiredWidth);
                    if (Build.VERSION.SDK_INT < 23) {
                        build2 = new StaticLayout(spannableString, paint, ceil, Layout.Alignment.ALIGN_NORMAL, f4, f3, false);
                    } else {
                        StaticLayout.Builder hyphenationFrequency = StaticLayout.Builder.obtain(spannableString, 0, spannableString.length(), paint, ceil).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(f3, f4).setIncludePad(false).setBreakStrategy(a.this.auG).setHyphenationFrequency(a.this.auH);
                        if (Build.VERSION.SDK_INT >= 26) {
                            hyphenationFrequency.setJustificationMode(a.this.auI);
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
                    StaticLayout.Builder hyphenationFrequency2 = StaticLayout.Builder.obtain(spannableString, 0, spannableString.length(), paint, (int) f).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(f3, f4).setIncludePad(false).setBreakStrategy(a.this.auG).setHyphenationFrequency(a.this.auH);
                    if (Build.VERSION.SDK_INT >= 26) {
                        hyphenationFrequency2.setJustificationMode(a.this.auI);
                    }
                    a.this.a(hyphenationFrequency2, true);
                    z2 = false;
                    build = hyphenationFrequency2.build();
                }
                if (build != null && a.this.maxLines < build.getLineCount()) {
                    return CriusMeasureOutput.make(a.this.r(build.getWidth()), a.this.q(build.getLineBottom(a.this.maxLines - 1)) - f3);
                }
                if (build != null) {
                    float r = a.this.r(build.getWidth());
                    float q = a.this.q(build.getHeight());
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
                            if (lineDescent > 0.0f && q > lineCount) {
                                q -= f3;
                            }
                        }
                    }
                    return CriusMeasureOutput.make(r, q);
                }
                return CriusMeasureOutput.make(f, f2);
            }
        };
        this.avV = -10000.0d;
        this.auK = new CriusNode();
        this.businessConverter = interfaceC0133a;
        this.auL = context.getResources().getDisplayMetrics().density;
        this.aoP = context.getResources().getDisplayMetrics().widthPixels;
        this.aoQ = context.getResources().getDisplayMetrics().heightPixels;
        this.auM = new TextView(context);
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
                this.awb = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    a aVar = new a(context, optJSONArray.optJSONObject(i), interfaceC0133a, false);
                    this.awb.add(aVar);
                    this.auK.addChildAt(aVar.auK, i);
                }
            } else {
                this.awb = null;
            }
        } else {
            this.awb = null;
        }
        if (z) {
            this.auJ = new CriusNode();
            this.auJ.addChildAt(this.auK, 0);
            this.auJ.calculateLayout(Float.NaN, Float.NaN);
        }
    }

    public double zs() {
        return this.fontSize;
    }

    private int zt() {
        return "italic".equalsIgnoreCase(this.avJ) ? (TextUtils.isEmpty(this.avK) || "normal".equalsIgnoreCase(this.avK) || !"bold".equalsIgnoreCase(this.avK)) ? 2 : 3 : (TextUtils.isEmpty(this.avK) || "normal".equalsIgnoreCase(this.avK) || !"bold".equalsIgnoreCase(this.avK)) ? 0 : 1;
    }

    private int zu() {
        int i;
        if ("left".equalsIgnoreCase(this.avM)) {
            i = 3;
        } else if (HorizontalTranslateLayout.DIRECTION_RIGHT.equalsIgnoreCase(this.avM)) {
            i = 5;
        } else if ("center".equalsIgnoreCase(this.avM)) {
            i = 1;
        } else {
            i = 0;
        }
        if (VerticalTranslateLayout.TOP.equalsIgnoreCase(this.avN)) {
            return i | 48;
        }
        if (VerticalTranslateLayout.BOTTOM.equalsIgnoreCase(this.avN)) {
            return i | 80;
        }
        if ("middle".equalsIgnoreCase(this.avN)) {
            return i | 16;
        }
        return i | 0;
    }

    private void zv() {
        if (this.avA >= 0.0d) {
            this.auK.setMaxWidth(n(this.avA));
        } else if (this.avA > -10000.0d) {
            this.auK.setMaxWidth(this.aoP);
        }
    }

    private void zw() {
        if (this.avC > 0.0d) {
            this.auK.setAspectRatio((float) this.avC);
        }
    }

    private void zx() {
        if (this.avB >= 0.0d) {
            this.auK.setMaxHeight(n(this.avB));
        } else if (this.avB > -10000.0d) {
            this.auK.setMaxHeight(this.aoQ);
        }
    }

    private void zy() {
        if (this.avz >= 0.0d) {
            this.auK.setMinHeight(n(this.avz));
        } else if (this.avz > -10000.0d) {
            this.auK.setMinHeight(this.aoQ);
        }
    }

    private void zz() {
        if (this.avy >= 0.0d) {
            this.auK.setMinWidth(n(this.avy));
        } else if (this.avy > -10000.0d) {
            this.auK.setMinWidth(this.aoP);
        }
    }

    private void zA() {
        if (this.height >= 0.0d) {
            this.auK.setHeight(n(this.height));
        } else if (this.height > -10000.0d) {
            this.auK.setHeight(this.aoQ);
        }
    }

    private void zB() {
        if (this.width >= 0.0d) {
            this.auK.setWidth(n(this.width));
        } else if (this.width > -10000.0d) {
            this.auK.setWidth(this.aoP);
        }
    }

    private void zC() {
        if (this.avu >= -1.0d) {
            this.auK.setPadding(CriusEdge.LEFT, n(this.avu));
        }
    }

    private void zD() {
        if (this.avx >= -1.0d) {
            this.auK.setPadding(CriusEdge.BOTTOM, n(this.avx));
        }
    }

    private void zE() {
        if (this.avw >= -1.0d) {
            this.auK.setPadding(CriusEdge.RIGHT, n(this.avw));
        }
    }

    private void zF() {
        if (this.avv >= -1.0d) {
            this.auK.setPadding(CriusEdge.TOP, n(this.avv));
        }
    }

    private void initPadding() {
        if (this.avt >= -1.0d) {
            this.auK.setPadding(CriusEdge.ALL, n(this.avt));
        }
    }

    private void zG() {
        if (this.avp >= -1.0d) {
            this.auK.setMargin(CriusEdge.LEFT, n(this.avp));
        }
    }

    private void zH() {
        if (this.avs >= -1.0d) {
            this.auK.setMargin(CriusEdge.BOTTOM, n(this.avs));
        }
    }

    private void zI() {
        if (this.avr >= -1.0d) {
            this.auK.setMargin(CriusEdge.RIGHT, n(this.avr));
        }
    }

    private void zJ() {
        if (this.avq >= -1.0d) {
            this.auK.setMargin(CriusEdge.TOP, n(this.avq));
        }
    }

    private void zK() {
        if (this.avo >= -1.0d) {
            this.auK.setMargin(CriusEdge.ALL, n(this.avo));
        }
    }

    private void zL() {
        if (this.avj >= -1.0d) {
            this.auK.setFlexBasis(n(this.avj));
        }
    }

    private void zM() {
        if (this.avi >= -1.0d) {
            this.auK.setFlexShrink((float) this.avi);
        }
    }

    private void zN() {
        if (this.avh >= -1.0d) {
            this.auK.setFlexGrow((float) this.avh);
        }
    }

    private void zO() {
        if (this.avg >= -1.0d) {
            this.auK.setFlex((float) this.avg);
        }
    }

    private void zP() {
        if (!TextUtils.isEmpty(this.ava)) {
            if ("flex".equalsIgnoreCase(this.ava)) {
                this.auK.setDisplay(CriusDisplay.FLEX);
            } else if ("none".equalsIgnoreCase(this.ava)) {
                this.auK.setDisplay(CriusDisplay.NONE);
            } else {
                this.auK.setDisplay(CriusDisplay.FLEX);
            }
        }
    }

    private void zQ() {
        if (!c.b(this.avk, -10000.0d)) {
            this.auK.setPosition(CriusEdge.LEFT, n(this.avk));
        }
        if (!c.b(this.avl, -10000.0d)) {
            this.auK.setPosition(CriusEdge.TOP, n(this.avl));
        }
        if (!c.b(this.avm, -10000.0d)) {
            this.auK.setPosition(CriusEdge.RIGHT, n(this.avm));
        }
        if (!c.b(this.avn, -10000.0d)) {
            this.auK.setPosition(CriusEdge.BOTTOM, n(this.avn));
        }
    }

    private void zR() {
        if (!TextUtils.isEmpty(this.position)) {
            if ("relative".equalsIgnoreCase(this.position)) {
                this.auK.setPositionType(CriusPositionType.RELATIVE);
            } else if ("absolute".equalsIgnoreCase(this.position)) {
                this.auK.setPositionType(CriusPositionType.ABSOLUTE);
            }
        }
    }

    private void zS() {
        if (!TextUtils.isEmpty(this.avf)) {
            if ("flex-start".equalsIgnoreCase(this.avf)) {
                this.auK.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.avf)) {
                this.auK.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.avf)) {
                this.auK.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.avf)) {
                this.auK.setAlignSelf(CriusAlign.STRETCH);
            } else if ("space-between".equalsIgnoreCase(this.avf)) {
                this.auK.setAlignSelf(CriusAlign.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.avf)) {
                this.auK.setAlignSelf(CriusAlign.SPACE_AROUND);
            } else {
                this.auK.setAlignSelf(CriusAlign.FLEX_START);
            }
        }
    }

    private void zT() {
        if (!TextUtils.isEmpty(this.ave)) {
            if ("auto".equalsIgnoreCase(this.ave)) {
                this.auK.setAlignSelf(CriusAlign.AUTO);
            } else if ("flex-start".equalsIgnoreCase(this.ave)) {
                this.auK.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.ave)) {
                this.auK.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.ave)) {
                this.auK.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.ave)) {
                this.auK.setAlignSelf(CriusAlign.STRETCH);
            } else {
                this.auK.setAlignSelf(CriusAlign.AUTO);
            }
        }
    }

    private void zU() {
        if (!TextUtils.isEmpty(this.avd)) {
            if ("flex-start".equalsIgnoreCase(this.avd)) {
                this.auK.setAlignItems(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.avd)) {
                this.auK.setAlignItems(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.avd)) {
                this.auK.setAlignItems(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.avd)) {
                this.auK.setAlignItems(CriusAlign.STRETCH);
            } else {
                this.auK.setAlignItems(CriusAlign.STRETCH);
            }
        }
    }

    private void zV() {
        if (!TextUtils.isEmpty(this.avc)) {
            if ("flex-start".equalsIgnoreCase(this.avc)) {
                this.auK.setJustifyContent(CriusJustify.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.avc)) {
                this.auK.setJustifyContent(CriusJustify.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.avc)) {
                this.auK.setJustifyContent(CriusJustify.FLEX_END);
            } else if ("space-between".equalsIgnoreCase(this.avc)) {
                this.auK.setJustifyContent(CriusJustify.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.avc)) {
                this.auK.setJustifyContent(CriusJustify.SPACE_AROUND);
            } else {
                this.auK.setJustifyContent(CriusJustify.FLEX_START);
            }
        }
    }

    private void zW() {
        if (!TextUtils.isEmpty(this.avb)) {
            if ("column".equalsIgnoreCase(this.avb)) {
                this.auK.setFlexDirection(CriusFlexDirection.COLUMN);
            } else if ("column-reverse".equalsIgnoreCase(this.avb)) {
                this.auK.setFlexDirection(CriusFlexDirection.COLUMN_REVERSE);
            } else if ("row".equalsIgnoreCase(this.avb)) {
                this.auK.setFlexDirection(CriusFlexDirection.ROW);
            } else if ("row-reverse".equalsIgnoreCase(this.avb)) {
                this.auK.setFlexDirection(CriusFlexDirection.ROW_REVERSE);
            } else {
                this.auK.setFlexDirection(CriusFlexDirection.COLUMN);
            }
        }
    }

    public boolean zX() {
        return "text".equals(this.type);
    }

    public a fp(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.id)) {
            if (this.awb != null && this.awb.size() > 0) {
                for (a aVar : this.awb) {
                    a fp = aVar.fp(str);
                    if (fp != null) {
                        return fp;
                    }
                }
            }
            return null;
        }
        return this;
    }

    public a fq(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.auO)) {
            if (this.awb != null && this.awb.size() > 0) {
                for (a aVar : this.awb) {
                    a fq = aVar.fq(str);
                    if (fq != null) {
                        return fq;
                    }
                }
            }
            return null;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float n(double d) {
        return d < 1.0d ? (float) (10.0d * d) : (float) (this.auL * d);
    }

    public static float a(double d, float f) {
        return d < 1.0d ? (float) (10.0d * d) : (float) (f * d);
    }

    public boolean fr(String str) {
        a fq;
        if (this.auJ == null || (fq = fq(str)) == null || fq.auK == null) {
            return false;
        }
        fq.auK.setDisplay(CriusDisplay.NONE);
        fq.auK.dirty();
        this.auJ.calculateLayout(Float.NaN, Float.NaN);
        return true;
    }

    public void c(String str, float f) {
        a fp;
        if (this.auJ != null && (fp = fp(str)) != null && fp.auK != null) {
            fp.fontSize = f;
            fp.auK.dirty();
            this.auJ.calculateLayout(Float.NaN, Float.NaN);
        }
    }
}
