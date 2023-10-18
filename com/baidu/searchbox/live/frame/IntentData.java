package com.baidu.searchbox.live.frame;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.live.arch.frame.State;
import com.baidu.live.arch.runtime.MiniShellRuntime;
import com.baidu.live.arch.utils.MiniJsonUtils;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.net.URLDecoder;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONException;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b.\b\u0086\b\u0018\u0000 I2\u00020\u0001:\u0002IJB=\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\bG\u0010HJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004JL\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0019\u0010\u0004J\r\u0010\u001a\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u0004J\u000f\u0010\u001b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001b\u0010\u0004J\r\u0010\u001c\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\tJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\u0016¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\u0016¢\u0006\u0004\b\"\u0010!J\u0010\u0010#\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b#\u0010\u0004J\r\u0010$\u001a\u00020\u0016¢\u0006\u0004\b$\u0010!R\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010%\u001a\u0004\b&\u0010\u0004\"\u0004\b'\u0010(R\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010%\u001a\u0004\b)\u0010\u0004\"\u0004\b*\u0010(R\"\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010+\u001a\u0004\b,\u0010\t\"\u0004\b-\u0010.R\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010%\u001a\u0004\b/\u0010\u0004\"\u0004\b0\u0010(R\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010%\u001a\u0004\b1\u0010\u0004\"\u0004\b2\u0010(R\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010%\u001a\u0004\b3\u0010\u0004\"\u0004\b4\u0010(R\"\u00105\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u0010\u001f\"\u0004\b8\u00109R\"\u0010:\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010!\"\u0004\b=\u0010>R*\u0010?\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b?\u0010@\u0012\u0004\bE\u0010F\u001a\u0004\bA\u0010B\"\u0004\bC\u0010D¨\u0006K"}, d2 = {"Lcom/baidu/searchbox/live/frame/IntentData;", "Lcom/baidu/live/arch/frame/State;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "Lcom/baidu/searchbox/live/frame/IntentData$SchemeModel;", "component4", "()Lcom/baidu/searchbox/live/frame/IntentData$SchemeModel;", "component5", "component6", "id", "source", "scheme", "model", "tpl", "extReq", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/live/frame/IntentData$SchemeModel;Ljava/lang/String;Ljava/lang/String;)Lcom/baidu/searchbox/live/frame/IntentData;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "getLiveSource", "getNidFromHLReplay", "getQuestionFromSearch", "getSchemeData", "", "hashCode", "()I", "isEnterBookRoom", "()Z", "isHLReplay", "toString", "transitionSeamless", "Ljava/lang/String;", "getExtReq", "setExtReq", "(Ljava/lang/String;)V", "getId", "setId", "Lcom/baidu/searchbox/live/frame/IntentData$SchemeModel;", "getModel", "setModel", "(Lcom/baidu/searchbox/live/frame/IntentData$SchemeModel;)V", "getScheme", "setScheme", "getSource", "setSource", "getTpl", "setTpl", "transitionStatus", "I", "getTransitionStatus", "setTransitionStatus", "(I)V", "transitionSubStatus", "Z", "getTransitionSubStatus", "setTransitionSubStatus", "(Z)V", "translucent", "Ljava/lang/Boolean;", "getTranslucent", "()Ljava/lang/Boolean;", "setTranslucent", "(Ljava/lang/Boolean;)V", "translucent$annotations", "()V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/live/frame/IntentData$SchemeModel;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "SchemeModel", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class IntentData implements State {
    public static final Companion Companion = new Companion(null);
    public static final String KEY = "intent";
    public static boolean banQuestionFromSearchDialog;
    public String extReq;
    public String id;
    public SchemeModel model;
    public String scheme;
    public String source;
    public String tpl;
    public int transitionStatus;
    public boolean transitionSubStatus;
    public Boolean translucent;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00012\b\u0010\t\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0007\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/live/frame/IntentData$Companion;", "", "source", "getLiveSource", "(Ljava/lang/String;)Ljava/lang/String;", "params", "Lcom/baidu/searchbox/live/frame/IntentData$SchemeModel;", "parseSchemeData", "(Ljava/lang/String;)Lcom/baidu/searchbox/live/frame/IntentData$SchemeModel;", "scheme", "(Ljava/lang/String;Ljava/lang/String;)Lcom/baidu/searchbox/live/frame/IntentData$SchemeModel;", "KEY", "Ljava/lang/String;", "", "banQuestionFromSearchDialog", "Z", "getBanQuestionFromSearchDialog", "()Z", "setBanQuestionFromSearchDialog", "(Z)V", "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class Companion {
        /* JADX WARN: Can't wrap try/catch for region: R(10:(16:(42:143|144|145|146|147|(1:313)(7:150|151|152|153|154|155|(37:157|158|(2:160|161)(7:265|266|267|(6:269|271|272|273|274|275)(1:298)|276|(1:278)(2:281|(1:283))|279)|(3:243|244|(5:246|(1:248)|249|250|(2:252|(1:254))(33:256|164|165|166|167|169|170|(3:223|(1:225)(1:228)|226)|172|174|175|176|177|178|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197)))|163|164|165|166|167|169|170|(0)|172|174|175|176|177|178|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197))|304|(0)(0)|(0)|163|164|165|166|167|169|170|(0)|172|174|175|176|177|178|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197)(1:320)|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197)|174|175|176|177|178|179|180|181|182) */
        /* JADX WARN: Can't wrap try/catch for region: R(12:140|141|(9:(25:(42:143|144|145|146|147|(1:313)(7:150|151|152|153|154|155|(37:157|158|(2:160|161)(7:265|266|267|(6:269|271|272|273|274|275)(1:298)|276|(1:278)(2:281|(1:283))|279)|(3:243|244|(5:246|(1:248)|249|250|(2:252|(1:254))(33:256|164|165|166|167|169|170|(3:223|(1:225)(1:228)|226)|172|174|175|176|177|178|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197)))|163|164|165|166|167|169|170|(0)|172|174|175|176|177|178|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197))|304|(0)(0)|(0)|163|164|165|166|167|169|170|(0)|172|174|175|176|177|178|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197)(1:320)|174|175|176|177|178|179|180|181|182|183|184|185|186|187|188|189|190|191|192|193|194|195|196|197)|164|165|166|167|169|170|(0)|172)|319|146|147|(0)|313|304|(0)(0)|(0)|163) */
        /* JADX WARN: Code restructure failed: missing block: B:202:0x0527, code lost:
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:203:0x0528, code lost:
            r10 = r1;
            r12 = r64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:204:0x052d, code lost:
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:205:0x052e, code lost:
            r10 = r1;
            r12 = r64;
            r11 = r65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:216:0x0675, code lost:
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:217:0x0676, code lost:
            r11 = r7;
            r1 = r12;
            r70 = r13;
            r71 = r14;
            r13 = r12;
            r14 = r21;
            r12 = r5;
            r73 = r9;
            r90 = r2;
            r104 = r6;
            r7 = r11;
            r83 = r10;
            r6 = r11;
            r82 = r18;
            r94 = r82;
            r95 = r94;
         */
        /* JADX WARN: Removed duplicated region for block: B:111:0x0207 A[Catch: Exception -> 0x0225, TRY_LEAVE, TryCatch #45 {Exception -> 0x0225, blocks: (B:111:0x0207, B:122:0x0281, B:107:0x01fb), top: B:408:0x01fb }] */
        /* JADX WARN: Removed duplicated region for block: B:372:0x0420 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:390:0x0275 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:433:0x0382 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final SchemeModel parseSchemeData(String str, String str2) {
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            String str10;
            String str11;
            String str12;
            String str13;
            String str14;
            String str15;
            JSONObject jSONObject;
            String str16;
            String str17;
            JSONObject jSONObject2;
            String str18;
            String str19;
            String str20;
            String str21;
            JSONObject jSONObject3;
            JSONObject jSONObject4;
            JSONObject jSONObject5;
            JSONObject jSONObject6;
            String str22;
            String str23;
            JSONObject jSONObject7;
            JSONObject jSONObject8;
            JSONObject jSONObject9;
            JSONObject jSONObject10;
            JSONObject jSONObject11;
            JSONObject jSONObject12;
            String str24;
            String str25;
            Integer num;
            int i;
            String str26;
            int i2;
            JSONObject jSONObject13;
            String str27;
            String str28;
            String str29;
            String str30;
            String str31;
            String str32;
            JSONObject parseJSONObject;
            String str33;
            String str34;
            JSONObject parseJSONObject2;
            JSONObject parseJSONObject3;
            JSONObject parseJSONObject4;
            JSONObject parseJSONObject5;
            String optString;
            String optString2;
            String optString3;
            String optString4;
            String optString5;
            String optString6;
            JSONObject parseJSONObject6;
            String optString7;
            Integer valueOf;
            String str35;
            int optInt;
            JSONObject jSONObject14;
            String str36;
            int i3;
            JSONObject jSONObject15;
            JSONObject jSONObject16;
            JSONObject optJSONObject;
            JSONObject jSONObject17;
            JSONObject jSONObject18;
            JSONObject jSONObject19;
            String str37;
            Integer num2;
            String str38;
            String str39;
            JSONObject jSONObject20;
            String str40;
            String str41;
            JSONObject optJSONObject2;
            String str42;
            JSONObject optJSONObject3;
            JSONObject optJSONObject4;
            String optString8;
            int optInt2;
            JSONObject jSONObject21;
            String str43;
            int i4;
            String str44;
            String str45;
            JSONObject jSONObject22;
            String queryParameter;
            try {
                JSONObject jSONObject23 = new JSONObject(str);
                String optString9 = jSONObject23.optString("roomId");
                if (optString9 == null) {
                    optString9 = "";
                }
                try {
                    if (TextUtils.isEmpty(optString9)) {
                        try {
                            optString9 = jSONObject23.optString("room_id");
                            if (optString9 == null) {
                                optString9 = "";
                            }
                        } catch (Exception e) {
                            e = e;
                            str4 = "";
                            str5 = str4;
                            str6 = str5;
                            str7 = str6;
                            str8 = str7;
                            str9 = str8;
                            str10 = str9;
                            str11 = str10;
                            str12 = str11;
                            str13 = str12;
                            str14 = str13;
                            str15 = str14;
                            str3 = optString9;
                            jSONObject13 = null;
                            i2 = 0;
                            str26 = null;
                            i = 0;
                            num = null;
                            str25 = null;
                            str24 = null;
                            jSONObject12 = null;
                            jSONObject11 = null;
                            jSONObject10 = null;
                            jSONObject9 = null;
                            jSONObject8 = null;
                            jSONObject7 = null;
                            str23 = null;
                            str22 = null;
                            jSONObject6 = null;
                            jSONObject5 = null;
                            jSONObject4 = null;
                            jSONObject3 = null;
                            str21 = null;
                            str20 = null;
                            str19 = null;
                            str18 = null;
                            jSONObject2 = null;
                            str17 = null;
                            str16 = null;
                            jSONObject = null;
                            e.printStackTrace();
                            SchemeModel schemeModel = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject11, jSONObject10, jSONObject9, jSONObject8, jSONObject7, str23, str22, jSONObject6, jSONObject5, jSONObject4, jSONObject3, str13, str14, str21, str20, str19, str18, jSONObject2, str17, str15, str16, jSONObject);
                            schemeModel.setPlayerCacheKey(str26);
                            schemeModel.setPlayerCacheCodeC(num);
                            schemeModel.setKabrSpts(str25);
                            schemeModel.setRtcHevcUrl(str24);
                            schemeModel.setCommonShareInfo(jSONObject12);
                            schemeModel.setMultiRate(jSONObject13);
                            schemeModel.setFromIntent(Boolean.TRUE);
                            schemeModel.setPlayRateSetting(i2);
                            schemeModel.setInterventions(i);
                            return schemeModel;
                        }
                    }
                    try {
                        String optString10 = jSONObject23.optString("inviterId");
                        try {
                            String optString11 = jSONObject23.optString("roomType");
                            String str46 = optString11 != null ? optString11 : "";
                            try {
                                String optString12 = jSONObject23.optString("source");
                                if (optString12 == null) {
                                    optString12 = "";
                                }
                                String liveSource = getLiveSource(optString12);
                                try {
                                    String optString13 = jSONObject23.optString(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY);
                                    String str47 = optString13 != null ? optString13 : "";
                                    try {
                                        String optString14 = jSONObject23.optString("playUrl");
                                        String str48 = optString14 != null ? optString14 : "";
                                        try {
                                            String optString15 = jSONObject23.optString("status");
                                            str29 = optString15 != null ? optString15 : "";
                                            try {
                                                String optString16 = jSONObject23.optString("format");
                                                str30 = optString16 != null ? optString16 : "";
                                                try {
                                                    String optString17 = jSONObject23.optString("screen");
                                                    str31 = optString17 != null ? optString17 : "";
                                                    try {
                                                        String optString18 = jSONObject23.optString(MediaTrackConfig.AE_IMPORT_TEMPLATE);
                                                        str32 = optString18 != null ? optString18 : "";
                                                        try {
                                                            parseJSONObject = MiniJsonUtils.INSTANCE.parseJSONObject(jSONObject23, "ext");
                                                            try {
                                                                JSONObject parseJSONObject7 = MiniJsonUtils.INSTANCE.parseJSONObject(jSONObject23, "otherParams");
                                                                if (parseJSONObject7 == null) {
                                                                    try {
                                                                        String optString19 = jSONObject23.optString("otherParams");
                                                                        Intrinsics.checkExpressionValueIsNotNull(optString19, "json.optString(\"otherParams\")");
                                                                        if (!TextUtils.isEmpty(optString19)) {
                                                                            try {
                                                                                parseJSONObject7 = new JSONObject(URLDecoder.decode(optString19));
                                                                            } catch (JSONException unused) {
                                                                                parseJSONObject7 = null;
                                                                            }
                                                                        }
                                                                    } catch (Exception e2) {
                                                                        e = e2;
                                                                        str12 = "";
                                                                        str13 = str12;
                                                                        str14 = str13;
                                                                        str3 = optString9;
                                                                        jSONObject11 = parseJSONObject;
                                                                        jSONObject6 = parseJSONObject7;
                                                                        str5 = liveSource;
                                                                        str15 = optString10;
                                                                        str4 = str46;
                                                                        str6 = str47;
                                                                        str7 = str48;
                                                                        str8 = str29;
                                                                        str9 = str30;
                                                                        str10 = str31;
                                                                        str11 = str32;
                                                                        jSONObject13 = null;
                                                                        i2 = 0;
                                                                        str26 = null;
                                                                        i = 0;
                                                                        num = null;
                                                                        str25 = null;
                                                                        str24 = null;
                                                                        jSONObject12 = null;
                                                                        jSONObject10 = null;
                                                                        jSONObject9 = null;
                                                                        jSONObject8 = null;
                                                                        jSONObject7 = null;
                                                                        str23 = null;
                                                                        str22 = null;
                                                                        jSONObject5 = null;
                                                                        jSONObject4 = null;
                                                                        jSONObject3 = null;
                                                                        str21 = null;
                                                                        str20 = null;
                                                                        str19 = null;
                                                                        str18 = null;
                                                                        jSONObject2 = null;
                                                                        str17 = null;
                                                                        str16 = null;
                                                                        jSONObject = null;
                                                                        e.printStackTrace();
                                                                        SchemeModel schemeModel2 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject11, jSONObject10, jSONObject9, jSONObject8, jSONObject7, str23, str22, jSONObject6, jSONObject5, jSONObject4, jSONObject3, str13, str14, str21, str20, str19, str18, jSONObject2, str17, str15, str16, jSONObject);
                                                                        schemeModel2.setPlayerCacheKey(str26);
                                                                        schemeModel2.setPlayerCacheCodeC(num);
                                                                        schemeModel2.setKabrSpts(str25);
                                                                        schemeModel2.setRtcHevcUrl(str24);
                                                                        schemeModel2.setCommonShareInfo(jSONObject12);
                                                                        schemeModel2.setMultiRate(jSONObject13);
                                                                        schemeModel2.setFromIntent(Boolean.TRUE);
                                                                        schemeModel2.setPlayRateSetting(i2);
                                                                        schemeModel2.setInterventions(i);
                                                                        return schemeModel2;
                                                                    }
                                                                }
                                                                try {
                                                                    parseJSONObject2 = MiniJsonUtils.INSTANCE.parseJSONObject(jSONObject23, "otherParams");
                                                                } catch (Exception e3) {
                                                                    e = e3;
                                                                    str33 = "";
                                                                    str34 = liveSource;
                                                                    str3 = optString9;
                                                                    jSONObject11 = parseJSONObject;
                                                                    jSONObject6 = parseJSONObject7;
                                                                }
                                                            } catch (Exception e4) {
                                                                e = e4;
                                                                str3 = optString9;
                                                                jSONObject11 = parseJSONObject;
                                                                str12 = "";
                                                                str13 = str12;
                                                                str14 = str13;
                                                                str15 = optString10;
                                                                str4 = str46;
                                                                str6 = str47;
                                                                str7 = str48;
                                                                str8 = str29;
                                                                str9 = str30;
                                                                str10 = str31;
                                                                str11 = str32;
                                                                str5 = liveSource;
                                                                jSONObject13 = null;
                                                                i2 = 0;
                                                                str26 = null;
                                                                i = 0;
                                                                num = null;
                                                                str25 = null;
                                                                str24 = null;
                                                                jSONObject12 = null;
                                                                jSONObject10 = null;
                                                                jSONObject9 = null;
                                                                jSONObject8 = null;
                                                                jSONObject7 = null;
                                                                str23 = null;
                                                                str22 = null;
                                                                jSONObject6 = null;
                                                                jSONObject5 = null;
                                                                jSONObject4 = null;
                                                                jSONObject3 = null;
                                                                str21 = null;
                                                                str20 = null;
                                                                str19 = null;
                                                                str18 = null;
                                                                jSONObject2 = null;
                                                                str17 = null;
                                                                str16 = null;
                                                                jSONObject = null;
                                                                e.printStackTrace();
                                                                SchemeModel schemeModel22 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject11, jSONObject10, jSONObject9, jSONObject8, jSONObject7, str23, str22, jSONObject6, jSONObject5, jSONObject4, jSONObject3, str13, str14, str21, str20, str19, str18, jSONObject2, str17, str15, str16, jSONObject);
                                                                schemeModel22.setPlayerCacheKey(str26);
                                                                schemeModel22.setPlayerCacheCodeC(num);
                                                                schemeModel22.setKabrSpts(str25);
                                                                schemeModel22.setRtcHevcUrl(str24);
                                                                schemeModel22.setCommonShareInfo(jSONObject12);
                                                                schemeModel22.setMultiRate(jSONObject13);
                                                                schemeModel22.setFromIntent(Boolean.TRUE);
                                                                schemeModel22.setPlayRateSetting(i2);
                                                                schemeModel22.setInterventions(i);
                                                                return schemeModel22;
                                                            }
                                                        } catch (Exception e5) {
                                                            e = e5;
                                                            str28 = liveSource;
                                                            str3 = optString9;
                                                            str12 = "";
                                                            str13 = str12;
                                                            str14 = str13;
                                                            str15 = optString10;
                                                            str4 = str46;
                                                            str6 = str47;
                                                            str7 = str48;
                                                            str8 = str29;
                                                            str9 = str30;
                                                            str10 = str31;
                                                            str11 = str32;
                                                            str5 = str28;
                                                            jSONObject13 = null;
                                                            i2 = 0;
                                                            str26 = null;
                                                            i = 0;
                                                            num = null;
                                                            str25 = null;
                                                            str24 = null;
                                                            jSONObject12 = null;
                                                            jSONObject11 = null;
                                                            jSONObject10 = null;
                                                            jSONObject9 = null;
                                                            jSONObject8 = null;
                                                            jSONObject7 = null;
                                                            str23 = null;
                                                            str22 = null;
                                                            jSONObject6 = null;
                                                            jSONObject5 = null;
                                                            jSONObject4 = null;
                                                            jSONObject3 = null;
                                                            str21 = null;
                                                            str20 = null;
                                                            str19 = null;
                                                            str18 = null;
                                                            jSONObject2 = null;
                                                            str17 = null;
                                                            str16 = null;
                                                            jSONObject = null;
                                                            e.printStackTrace();
                                                            SchemeModel schemeModel222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject11, jSONObject10, jSONObject9, jSONObject8, jSONObject7, str23, str22, jSONObject6, jSONObject5, jSONObject4, jSONObject3, str13, str14, str21, str20, str19, str18, jSONObject2, str17, str15, str16, jSONObject);
                                                            schemeModel222.setPlayerCacheKey(str26);
                                                            schemeModel222.setPlayerCacheCodeC(num);
                                                            schemeModel222.setKabrSpts(str25);
                                                            schemeModel222.setRtcHevcUrl(str24);
                                                            schemeModel222.setCommonShareInfo(jSONObject12);
                                                            schemeModel222.setMultiRate(jSONObject13);
                                                            schemeModel222.setFromIntent(Boolean.TRUE);
                                                            schemeModel222.setPlayRateSetting(i2);
                                                            schemeModel222.setInterventions(i);
                                                            return schemeModel222;
                                                        }
                                                    } catch (Exception e6) {
                                                        e = e6;
                                                        str28 = liveSource;
                                                        str3 = optString9;
                                                        str11 = "";
                                                        str12 = str11;
                                                        str13 = str12;
                                                        str14 = str13;
                                                        str15 = optString10;
                                                        str4 = str46;
                                                        str6 = str47;
                                                        str7 = str48;
                                                        str8 = str29;
                                                        str9 = str30;
                                                        str10 = str31;
                                                    }
                                                    try {
                                                        parseJSONObject3 = MiniJsonUtils.INSTANCE.parseJSONObject(jSONObject23, "query");
                                                        try {
                                                            parseJSONObject4 = MiniJsonUtils.INSTANCE.parseJSONObject(jSONObject23, "extRequest");
                                                        } catch (Exception e7) {
                                                            e = e7;
                                                            str3 = optString9;
                                                            jSONObject6 = parseJSONObject2;
                                                            jSONObject11 = parseJSONObject;
                                                            str12 = "";
                                                            str13 = str12;
                                                            str14 = str13;
                                                            str15 = optString10;
                                                            str4 = str46;
                                                            str6 = str47;
                                                            str7 = str48;
                                                            str8 = str29;
                                                            str9 = str30;
                                                            str10 = str31;
                                                            str11 = str32;
                                                            jSONObject8 = parseJSONObject3;
                                                            str5 = liveSource;
                                                            jSONObject13 = null;
                                                            i2 = 0;
                                                            str26 = null;
                                                            i = 0;
                                                            num = null;
                                                            str25 = null;
                                                            str24 = null;
                                                            jSONObject12 = null;
                                                            jSONObject10 = null;
                                                        }
                                                    } catch (Exception e8) {
                                                        e = e8;
                                                        str33 = "";
                                                        str34 = liveSource;
                                                        str3 = optString9;
                                                        jSONObject6 = parseJSONObject2;
                                                        jSONObject11 = parseJSONObject;
                                                        str12 = str33;
                                                        str13 = str12;
                                                        str14 = str13;
                                                        str15 = optString10;
                                                        str4 = str46;
                                                        str6 = str47;
                                                        str7 = str48;
                                                        str8 = str29;
                                                        str9 = str30;
                                                        str10 = str31;
                                                        str11 = str32;
                                                        str5 = str34;
                                                        jSONObject13 = null;
                                                        i2 = 0;
                                                        str26 = null;
                                                        i = 0;
                                                        num = null;
                                                        str25 = null;
                                                        str24 = null;
                                                        jSONObject12 = null;
                                                        jSONObject10 = null;
                                                        jSONObject9 = null;
                                                        jSONObject8 = null;
                                                        jSONObject7 = null;
                                                        str23 = null;
                                                        str22 = null;
                                                        jSONObject5 = null;
                                                        jSONObject4 = null;
                                                        jSONObject3 = null;
                                                        str21 = null;
                                                        str20 = null;
                                                        str19 = null;
                                                        str18 = null;
                                                        jSONObject2 = null;
                                                        str17 = null;
                                                        str16 = null;
                                                        jSONObject = null;
                                                        e.printStackTrace();
                                                        SchemeModel schemeModel2222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject11, jSONObject10, jSONObject9, jSONObject8, jSONObject7, str23, str22, jSONObject6, jSONObject5, jSONObject4, jSONObject3, str13, str14, str21, str20, str19, str18, jSONObject2, str17, str15, str16, jSONObject);
                                                        schemeModel2222.setPlayerCacheKey(str26);
                                                        schemeModel2222.setPlayerCacheCodeC(num);
                                                        schemeModel2222.setKabrSpts(str25);
                                                        schemeModel2222.setRtcHevcUrl(str24);
                                                        schemeModel2222.setCommonShareInfo(jSONObject12);
                                                        schemeModel2222.setMultiRate(jSONObject13);
                                                        schemeModel2222.setFromIntent(Boolean.TRUE);
                                                        schemeModel2222.setPlayRateSetting(i2);
                                                        schemeModel2222.setInterventions(i);
                                                        return schemeModel2222;
                                                    }
                                                } catch (Exception e9) {
                                                    e = e9;
                                                    str28 = liveSource;
                                                    str3 = optString9;
                                                    str10 = "";
                                                    str11 = str10;
                                                    str12 = str11;
                                                    str13 = str12;
                                                    str14 = str13;
                                                    str15 = optString10;
                                                    str4 = str46;
                                                    str6 = str47;
                                                    str7 = str48;
                                                    str8 = str29;
                                                    str9 = str30;
                                                }
                                            } catch (Exception e10) {
                                                e = e10;
                                                str28 = liveSource;
                                                str3 = optString9;
                                                str9 = "";
                                                str10 = str9;
                                                str11 = str10;
                                                str12 = str11;
                                                str13 = str12;
                                                str14 = str13;
                                                str15 = optString10;
                                                str4 = str46;
                                                str6 = str47;
                                                str7 = str48;
                                                str8 = str29;
                                            }
                                        } catch (Exception e11) {
                                            e = e11;
                                            str28 = liveSource;
                                            str3 = optString9;
                                            str8 = "";
                                            str9 = str8;
                                            str10 = str9;
                                            str11 = str10;
                                            str12 = str11;
                                            str13 = str12;
                                            str14 = str13;
                                            str15 = optString10;
                                            str4 = str46;
                                            str6 = str47;
                                            str7 = str48;
                                        }
                                        try {
                                            JSONObject parseJSONObject8 = MiniJsonUtils.INSTANCE.parseJSONObject(jSONObject23, "extLog");
                                            try {
                                                parseJSONObject5 = MiniJsonUtils.INSTANCE.parseJSONObject(jSONObject23, "extParams");
                                            } catch (Exception e12) {
                                                e = e12;
                                                str3 = optString9;
                                                jSONObject6 = parseJSONObject2;
                                                jSONObject11 = parseJSONObject;
                                                str12 = "";
                                                str13 = str12;
                                                str14 = str13;
                                                str15 = optString10;
                                                str4 = str46;
                                                str6 = str47;
                                                str7 = str48;
                                                str8 = str29;
                                                str9 = str30;
                                                str10 = str31;
                                                str11 = str32;
                                                jSONObject8 = parseJSONObject3;
                                                jSONObject10 = parseJSONObject4;
                                                jSONObject9 = parseJSONObject8;
                                                str5 = liveSource;
                                                jSONObject13 = null;
                                                i2 = 0;
                                                str26 = null;
                                                i = 0;
                                                num = null;
                                                str25 = null;
                                                str24 = null;
                                                jSONObject12 = null;
                                                jSONObject7 = null;
                                                str23 = null;
                                                str22 = null;
                                                jSONObject5 = null;
                                                jSONObject4 = null;
                                                jSONObject3 = null;
                                                str21 = null;
                                                str20 = null;
                                                str19 = null;
                                                str18 = null;
                                                jSONObject2 = null;
                                                str17 = null;
                                                str16 = null;
                                                jSONObject = null;
                                                e.printStackTrace();
                                                SchemeModel schemeModel22222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject11, jSONObject10, jSONObject9, jSONObject8, jSONObject7, str23, str22, jSONObject6, jSONObject5, jSONObject4, jSONObject3, str13, str14, str21, str20, str19, str18, jSONObject2, str17, str15, str16, jSONObject);
                                                schemeModel22222.setPlayerCacheKey(str26);
                                                schemeModel22222.setPlayerCacheCodeC(num);
                                                schemeModel22222.setKabrSpts(str25);
                                                schemeModel22222.setRtcHevcUrl(str24);
                                                schemeModel22222.setCommonShareInfo(jSONObject12);
                                                schemeModel22222.setMultiRate(jSONObject13);
                                                schemeModel22222.setFromIntent(Boolean.TRUE);
                                                schemeModel22222.setPlayRateSetting(i2);
                                                schemeModel22222.setInterventions(i);
                                                return schemeModel22222;
                                            }
                                            try {
                                                JSONObject parseJSONObject9 = MiniJsonUtils.INSTANCE.parseJSONObject(jSONObject23, "invokePop");
                                                try {
                                                    JSONObject parseJSONObject10 = MiniJsonUtils.INSTANCE.parseJSONObject(jSONObject23, "shareTaskInfo");
                                                    try {
                                                        String optString20 = jSONObject23.optString("askId");
                                                        try {
                                                            optString = jSONObject23.optString("templateId");
                                                        } catch (Exception e13) {
                                                            e = e13;
                                                            str3 = optString9;
                                                            jSONObject6 = parseJSONObject2;
                                                            jSONObject11 = parseJSONObject;
                                                            str12 = "";
                                                            str13 = str12;
                                                            str14 = str13;
                                                            str15 = optString10;
                                                            str4 = str46;
                                                            str6 = str47;
                                                            str7 = str48;
                                                            str8 = str29;
                                                            str9 = str30;
                                                            str10 = str31;
                                                            str11 = str32;
                                                            jSONObject8 = parseJSONObject3;
                                                            jSONObject10 = parseJSONObject4;
                                                            jSONObject9 = parseJSONObject8;
                                                            jSONObject5 = parseJSONObject9;
                                                            jSONObject2 = parseJSONObject10;
                                                            str23 = optString20;
                                                            jSONObject7 = parseJSONObject5;
                                                            str5 = liveSource;
                                                            jSONObject13 = null;
                                                            i2 = 0;
                                                            str26 = null;
                                                            i = 0;
                                                            num = null;
                                                            str25 = null;
                                                            str24 = null;
                                                            jSONObject12 = null;
                                                            str22 = null;
                                                            jSONObject4 = null;
                                                            jSONObject3 = null;
                                                            str21 = null;
                                                            str20 = null;
                                                            str19 = null;
                                                            str18 = null;
                                                            str17 = null;
                                                            str16 = null;
                                                            jSONObject = null;
                                                            e.printStackTrace();
                                                            SchemeModel schemeModel222222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject11, jSONObject10, jSONObject9, jSONObject8, jSONObject7, str23, str22, jSONObject6, jSONObject5, jSONObject4, jSONObject3, str13, str14, str21, str20, str19, str18, jSONObject2, str17, str15, str16, jSONObject);
                                                            schemeModel222222.setPlayerCacheKey(str26);
                                                            schemeModel222222.setPlayerCacheCodeC(num);
                                                            schemeModel222222.setKabrSpts(str25);
                                                            schemeModel222222.setRtcHevcUrl(str24);
                                                            schemeModel222222.setCommonShareInfo(jSONObject12);
                                                            schemeModel222222.setMultiRate(jSONObject13);
                                                            schemeModel222222.setFromIntent(Boolean.TRUE);
                                                            schemeModel222222.setPlayRateSetting(i2);
                                                            schemeModel222222.setInterventions(i);
                                                            return schemeModel222222;
                                                        }
                                                        try {
                                                            String optString21 = jSONObject23.optString("avcUrl");
                                                            try {
                                                                optString2 = jSONObject23.optString("hevcUrl");
                                                            } catch (Exception e14) {
                                                                e = e14;
                                                                str3 = optString9;
                                                                jSONObject6 = parseJSONObject2;
                                                                jSONObject11 = parseJSONObject;
                                                                str12 = "";
                                                                str13 = str12;
                                                                str14 = str13;
                                                                str15 = optString10;
                                                                str4 = str46;
                                                                str6 = str47;
                                                                str7 = str48;
                                                                str8 = str29;
                                                                str9 = str30;
                                                                str10 = str31;
                                                                str11 = str32;
                                                                jSONObject8 = parseJSONObject3;
                                                                jSONObject10 = parseJSONObject4;
                                                                jSONObject9 = parseJSONObject8;
                                                                jSONObject5 = parseJSONObject9;
                                                                jSONObject2 = parseJSONObject10;
                                                                str23 = optString20;
                                                                str22 = optString;
                                                                str21 = optString21;
                                                                jSONObject7 = parseJSONObject5;
                                                                str5 = liveSource;
                                                                jSONObject13 = null;
                                                                i2 = 0;
                                                                str26 = null;
                                                                i = 0;
                                                                num = null;
                                                                str25 = null;
                                                                str24 = null;
                                                                jSONObject12 = null;
                                                                jSONObject4 = null;
                                                                jSONObject3 = null;
                                                                str20 = null;
                                                                str19 = null;
                                                                str18 = null;
                                                                str17 = null;
                                                                str16 = null;
                                                                jSONObject = null;
                                                                e.printStackTrace();
                                                                SchemeModel schemeModel2222222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject11, jSONObject10, jSONObject9, jSONObject8, jSONObject7, str23, str22, jSONObject6, jSONObject5, jSONObject4, jSONObject3, str13, str14, str21, str20, str19, str18, jSONObject2, str17, str15, str16, jSONObject);
                                                                schemeModel2222222.setPlayerCacheKey(str26);
                                                                schemeModel2222222.setPlayerCacheCodeC(num);
                                                                schemeModel2222222.setKabrSpts(str25);
                                                                schemeModel2222222.setRtcHevcUrl(str24);
                                                                schemeModel2222222.setCommonShareInfo(jSONObject12);
                                                                schemeModel2222222.setMultiRate(jSONObject13);
                                                                schemeModel2222222.setFromIntent(Boolean.TRUE);
                                                                schemeModel2222222.setPlayRateSetting(i2);
                                                                schemeModel2222222.setInterventions(i);
                                                                return schemeModel2222222;
                                                            }
                                                            try {
                                                                optString3 = jSONObject23.optString("rtcUrl");
                                                                try {
                                                                    optString4 = jSONObject23.optString("rtcHevcUrl");
                                                                } catch (Exception e15) {
                                                                    e = e15;
                                                                    str3 = optString9;
                                                                    jSONObject6 = parseJSONObject2;
                                                                    jSONObject11 = parseJSONObject;
                                                                    str12 = "";
                                                                    str13 = str12;
                                                                    str14 = str13;
                                                                    str15 = optString10;
                                                                    str4 = str46;
                                                                    str6 = str47;
                                                                    str7 = str48;
                                                                    str8 = str29;
                                                                    str9 = str30;
                                                                    str10 = str31;
                                                                    str11 = str32;
                                                                    jSONObject8 = parseJSONObject3;
                                                                    jSONObject10 = parseJSONObject4;
                                                                    jSONObject9 = parseJSONObject8;
                                                                    jSONObject5 = parseJSONObject9;
                                                                    jSONObject2 = parseJSONObject10;
                                                                    str23 = optString20;
                                                                    str22 = optString;
                                                                    str21 = optString21;
                                                                    str20 = optString2;
                                                                    str19 = optString3;
                                                                    jSONObject7 = parseJSONObject5;
                                                                    str5 = liveSource;
                                                                    jSONObject13 = null;
                                                                    i2 = 0;
                                                                    str26 = null;
                                                                    i = 0;
                                                                    num = null;
                                                                    str25 = null;
                                                                    str24 = null;
                                                                }
                                                            } catch (Exception e16) {
                                                                e = e16;
                                                                str3 = optString9;
                                                                jSONObject6 = parseJSONObject2;
                                                                jSONObject11 = parseJSONObject;
                                                                str12 = "";
                                                                str13 = str12;
                                                                str14 = str13;
                                                                str15 = optString10;
                                                                str4 = str46;
                                                                str6 = str47;
                                                                str7 = str48;
                                                                str8 = str29;
                                                                str9 = str30;
                                                                str10 = str31;
                                                                str11 = str32;
                                                                jSONObject8 = parseJSONObject3;
                                                                jSONObject10 = parseJSONObject4;
                                                                jSONObject9 = parseJSONObject8;
                                                                jSONObject5 = parseJSONObject9;
                                                                jSONObject2 = parseJSONObject10;
                                                                str23 = optString20;
                                                                str22 = optString;
                                                                str21 = optString21;
                                                                str20 = optString2;
                                                                jSONObject7 = parseJSONObject5;
                                                                str5 = liveSource;
                                                                jSONObject13 = null;
                                                                i2 = 0;
                                                                str26 = null;
                                                                i = 0;
                                                                num = null;
                                                                str25 = null;
                                                                str24 = null;
                                                                jSONObject12 = null;
                                                                jSONObject4 = null;
                                                                jSONObject3 = null;
                                                                str19 = null;
                                                                str18 = null;
                                                                str17 = null;
                                                                str16 = null;
                                                                jSONObject = null;
                                                                e.printStackTrace();
                                                                SchemeModel schemeModel22222222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject11, jSONObject10, jSONObject9, jSONObject8, jSONObject7, str23, str22, jSONObject6, jSONObject5, jSONObject4, jSONObject3, str13, str14, str21, str20, str19, str18, jSONObject2, str17, str15, str16, jSONObject);
                                                                schemeModel22222222.setPlayerCacheKey(str26);
                                                                schemeModel22222222.setPlayerCacheCodeC(num);
                                                                schemeModel22222222.setKabrSpts(str25);
                                                                schemeModel22222222.setRtcHevcUrl(str24);
                                                                schemeModel22222222.setCommonShareInfo(jSONObject12);
                                                                schemeModel22222222.setMultiRate(jSONObject13);
                                                                schemeModel22222222.setFromIntent(Boolean.TRUE);
                                                                schemeModel22222222.setPlayRateSetting(i2);
                                                                schemeModel22222222.setInterventions(i);
                                                                return schemeModel22222222;
                                                            }
                                                            try {
                                                                optString5 = jSONObject23.optString("title");
                                                            } catch (Exception e17) {
                                                                e = e17;
                                                                str24 = optString4;
                                                                str3 = optString9;
                                                                jSONObject6 = parseJSONObject2;
                                                                jSONObject11 = parseJSONObject;
                                                                str12 = "";
                                                                str13 = str12;
                                                                str14 = str13;
                                                                str15 = optString10;
                                                                str4 = str46;
                                                                str6 = str47;
                                                                str7 = str48;
                                                                str8 = str29;
                                                                str9 = str30;
                                                                str10 = str31;
                                                                str11 = str32;
                                                                jSONObject8 = parseJSONObject3;
                                                                jSONObject10 = parseJSONObject4;
                                                                jSONObject9 = parseJSONObject8;
                                                                jSONObject5 = parseJSONObject9;
                                                                jSONObject2 = parseJSONObject10;
                                                                str23 = optString20;
                                                                str22 = optString;
                                                                str21 = optString21;
                                                                str20 = optString2;
                                                                str19 = optString3;
                                                                jSONObject7 = parseJSONObject5;
                                                                str5 = liveSource;
                                                                jSONObject13 = null;
                                                                i2 = 0;
                                                                str26 = null;
                                                                i = 0;
                                                                num = null;
                                                                str25 = null;
                                                                jSONObject12 = null;
                                                                jSONObject4 = null;
                                                                jSONObject3 = null;
                                                                str18 = null;
                                                                str17 = null;
                                                                str16 = null;
                                                                jSONObject = null;
                                                                e.printStackTrace();
                                                                SchemeModel schemeModel222222222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject11, jSONObject10, jSONObject9, jSONObject8, jSONObject7, str23, str22, jSONObject6, jSONObject5, jSONObject4, jSONObject3, str13, str14, str21, str20, str19, str18, jSONObject2, str17, str15, str16, jSONObject);
                                                                schemeModel222222222.setPlayerCacheKey(str26);
                                                                schemeModel222222222.setPlayerCacheCodeC(num);
                                                                schemeModel222222222.setKabrSpts(str25);
                                                                schemeModel222222222.setRtcHevcUrl(str24);
                                                                schemeModel222222222.setCommonShareInfo(jSONObject12);
                                                                schemeModel222222222.setMultiRate(jSONObject13);
                                                                schemeModel222222222.setFromIntent(Boolean.TRUE);
                                                                schemeModel222222222.setPlayRateSetting(i2);
                                                                schemeModel222222222.setInterventions(i);
                                                                return schemeModel222222222;
                                                            }
                                                            try {
                                                                String optString22 = jSONObject23.optString("quic");
                                                                try {
                                                                    optString6 = jSONObject23.optString("highLightUrl");
                                                                } catch (Exception e18) {
                                                                    e = e18;
                                                                    str24 = optString4;
                                                                    str3 = optString9;
                                                                    jSONObject6 = parseJSONObject2;
                                                                    jSONObject11 = parseJSONObject;
                                                                    str12 = "";
                                                                    str13 = str12;
                                                                    str14 = str13;
                                                                    str15 = optString10;
                                                                    str4 = str46;
                                                                    str6 = str47;
                                                                    str7 = str48;
                                                                    str8 = str29;
                                                                    str9 = str30;
                                                                    str10 = str31;
                                                                    str11 = str32;
                                                                    jSONObject8 = parseJSONObject3;
                                                                    jSONObject10 = parseJSONObject4;
                                                                    jSONObject9 = parseJSONObject8;
                                                                    jSONObject5 = parseJSONObject9;
                                                                    jSONObject2 = parseJSONObject10;
                                                                    str23 = optString20;
                                                                    str22 = optString;
                                                                    str21 = optString21;
                                                                    str20 = optString2;
                                                                    str19 = optString3;
                                                                    str18 = optString5;
                                                                    str17 = optString22;
                                                                    jSONObject7 = parseJSONObject5;
                                                                    str5 = liveSource;
                                                                    jSONObject13 = null;
                                                                    i2 = 0;
                                                                    str26 = null;
                                                                    i = 0;
                                                                    num = null;
                                                                    str25 = null;
                                                                    jSONObject12 = null;
                                                                    jSONObject4 = null;
                                                                    jSONObject3 = null;
                                                                    str16 = null;
                                                                    jSONObject = null;
                                                                    e.printStackTrace();
                                                                    SchemeModel schemeModel2222222222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject11, jSONObject10, jSONObject9, jSONObject8, jSONObject7, str23, str22, jSONObject6, jSONObject5, jSONObject4, jSONObject3, str13, str14, str21, str20, str19, str18, jSONObject2, str17, str15, str16, jSONObject);
                                                                    schemeModel2222222222.setPlayerCacheKey(str26);
                                                                    schemeModel2222222222.setPlayerCacheCodeC(num);
                                                                    schemeModel2222222222.setKabrSpts(str25);
                                                                    schemeModel2222222222.setRtcHevcUrl(str24);
                                                                    schemeModel2222222222.setCommonShareInfo(jSONObject12);
                                                                    schemeModel2222222222.setMultiRate(jSONObject13);
                                                                    schemeModel2222222222.setFromIntent(Boolean.TRUE);
                                                                    schemeModel2222222222.setPlayRateSetting(i2);
                                                                    schemeModel2222222222.setInterventions(i);
                                                                    return schemeModel2222222222;
                                                                }
                                                                try {
                                                                    parseJSONObject6 = MiniJsonUtils.INSTANCE.parseJSONObject(jSONObject23, "introduce_tips");
                                                                    try {
                                                                        optString7 = jSONObject23.optString("playerIdentifier");
                                                                    } catch (Exception e19) {
                                                                        e = e19;
                                                                        str24 = optString4;
                                                                        str3 = optString9;
                                                                        jSONObject6 = parseJSONObject2;
                                                                        jSONObject = parseJSONObject6;
                                                                        jSONObject11 = parseJSONObject;
                                                                        str12 = "";
                                                                        str13 = str12;
                                                                        str14 = str13;
                                                                        str15 = optString10;
                                                                        str4 = str46;
                                                                        str6 = str47;
                                                                        str7 = str48;
                                                                        str8 = str29;
                                                                        str9 = str30;
                                                                        str10 = str31;
                                                                        str11 = str32;
                                                                        jSONObject8 = parseJSONObject3;
                                                                        jSONObject10 = parseJSONObject4;
                                                                        jSONObject9 = parseJSONObject8;
                                                                        jSONObject5 = parseJSONObject9;
                                                                        jSONObject2 = parseJSONObject10;
                                                                        str23 = optString20;
                                                                        str22 = optString;
                                                                        str21 = optString21;
                                                                        str20 = optString2;
                                                                        str19 = optString3;
                                                                        str18 = optString5;
                                                                        str17 = optString22;
                                                                        str16 = optString6;
                                                                        jSONObject7 = parseJSONObject5;
                                                                        str5 = liveSource;
                                                                        jSONObject13 = null;
                                                                        i2 = 0;
                                                                        str26 = null;
                                                                    }
                                                                    try {
                                                                        valueOf = Integer.valueOf(jSONObject23.optInt("codec_id"));
                                                                        str35 = "";
                                                                    } catch (Exception e20) {
                                                                        e = e20;
                                                                        str24 = optString4;
                                                                        str3 = optString9;
                                                                        jSONObject6 = parseJSONObject2;
                                                                        jSONObject = parseJSONObject6;
                                                                        str26 = optString7;
                                                                        jSONObject11 = parseJSONObject;
                                                                        str12 = "";
                                                                        str13 = str12;
                                                                        str14 = str13;
                                                                        str15 = optString10;
                                                                        str4 = str46;
                                                                        str6 = str47;
                                                                        str7 = str48;
                                                                        str8 = str29;
                                                                        str9 = str30;
                                                                        str10 = str31;
                                                                        str11 = str32;
                                                                        jSONObject8 = parseJSONObject3;
                                                                        jSONObject10 = parseJSONObject4;
                                                                        jSONObject9 = parseJSONObject8;
                                                                        jSONObject5 = parseJSONObject9;
                                                                        jSONObject2 = parseJSONObject10;
                                                                        str23 = optString20;
                                                                        str22 = optString;
                                                                        str21 = optString21;
                                                                        str20 = optString2;
                                                                        str19 = optString3;
                                                                        str18 = optString5;
                                                                        str17 = optString22;
                                                                        str16 = optString6;
                                                                        jSONObject7 = parseJSONObject5;
                                                                        str5 = liveSource;
                                                                        jSONObject13 = null;
                                                                        i2 = 0;
                                                                        i = 0;
                                                                        num = null;
                                                                        str25 = null;
                                                                        jSONObject12 = null;
                                                                        jSONObject4 = null;
                                                                        jSONObject3 = null;
                                                                        e.printStackTrace();
                                                                        SchemeModel schemeModel22222222222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject11, jSONObject10, jSONObject9, jSONObject8, jSONObject7, str23, str22, jSONObject6, jSONObject5, jSONObject4, jSONObject3, str13, str14, str21, str20, str19, str18, jSONObject2, str17, str15, str16, jSONObject);
                                                                        schemeModel22222222222.setPlayerCacheKey(str26);
                                                                        schemeModel22222222222.setPlayerCacheCodeC(num);
                                                                        schemeModel22222222222.setKabrSpts(str25);
                                                                        schemeModel22222222222.setRtcHevcUrl(str24);
                                                                        schemeModel22222222222.setCommonShareInfo(jSONObject12);
                                                                        schemeModel22222222222.setMultiRate(jSONObject13);
                                                                        schemeModel22222222222.setFromIntent(Boolean.TRUE);
                                                                        schemeModel22222222222.setPlayRateSetting(i2);
                                                                        schemeModel22222222222.setInterventions(i);
                                                                        return schemeModel22222222222;
                                                                    }
                                                                } catch (Exception e21) {
                                                                    e = e21;
                                                                    str24 = optString4;
                                                                    str3 = optString9;
                                                                    jSONObject6 = parseJSONObject2;
                                                                    jSONObject11 = parseJSONObject;
                                                                    str12 = "";
                                                                    str13 = str12;
                                                                    str14 = str13;
                                                                    str15 = optString10;
                                                                    str4 = str46;
                                                                    str6 = str47;
                                                                    str7 = str48;
                                                                    str8 = str29;
                                                                    str9 = str30;
                                                                    str10 = str31;
                                                                    str11 = str32;
                                                                    jSONObject8 = parseJSONObject3;
                                                                    jSONObject10 = parseJSONObject4;
                                                                    jSONObject9 = parseJSONObject8;
                                                                    jSONObject5 = parseJSONObject9;
                                                                    jSONObject2 = parseJSONObject10;
                                                                    str23 = optString20;
                                                                    str22 = optString;
                                                                    str21 = optString21;
                                                                    str20 = optString2;
                                                                    str19 = optString3;
                                                                    str18 = optString5;
                                                                    str17 = optString22;
                                                                    str16 = optString6;
                                                                    jSONObject7 = parseJSONObject5;
                                                                    str5 = liveSource;
                                                                    jSONObject13 = null;
                                                                    i2 = 0;
                                                                    str26 = null;
                                                                    i = 0;
                                                                    num = null;
                                                                    str25 = null;
                                                                    jSONObject12 = null;
                                                                    jSONObject4 = null;
                                                                    jSONObject3 = null;
                                                                    jSONObject = null;
                                                                    e.printStackTrace();
                                                                    SchemeModel schemeModel222222222222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject11, jSONObject10, jSONObject9, jSONObject8, jSONObject7, str23, str22, jSONObject6, jSONObject5, jSONObject4, jSONObject3, str13, str14, str21, str20, str19, str18, jSONObject2, str17, str15, str16, jSONObject);
                                                                    schemeModel222222222222.setPlayerCacheKey(str26);
                                                                    schemeModel222222222222.setPlayerCacheCodeC(num);
                                                                    schemeModel222222222222.setKabrSpts(str25);
                                                                    schemeModel222222222222.setRtcHevcUrl(str24);
                                                                    schemeModel222222222222.setCommonShareInfo(jSONObject12);
                                                                    schemeModel222222222222.setMultiRate(jSONObject13);
                                                                    schemeModel222222222222.setFromIntent(Boolean.TRUE);
                                                                    schemeModel222222222222.setPlayRateSetting(i2);
                                                                    schemeModel222222222222.setInterventions(i);
                                                                    return schemeModel222222222222;
                                                                }
                                                                try {
                                                                    String optString23 = jSONObject23.optString("kabr_spts");
                                                                    try {
                                                                        optInt = jSONObject23.optInt(LivePreStartPlayServiceImpl.K_LIVE_PLAY_RATE_SETTING_OPTION);
                                                                        try {
                                                                        } catch (Exception e22) {
                                                                            e = e22;
                                                                            num = valueOf;
                                                                            jSONObject14 = parseJSONObject5;
                                                                            str36 = liveSource;
                                                                            i3 = optInt;
                                                                            str24 = optString4;
                                                                            str25 = optString23;
                                                                        }
                                                                    } catch (Exception e23) {
                                                                        e = e23;
                                                                        num = valueOf;
                                                                        str24 = optString4;
                                                                        str25 = optString23;
                                                                        str3 = optString9;
                                                                        jSONObject6 = parseJSONObject2;
                                                                        jSONObject = parseJSONObject6;
                                                                        str26 = optString7;
                                                                        jSONObject11 = parseJSONObject;
                                                                        str12 = str35;
                                                                        str13 = str12;
                                                                        str14 = str13;
                                                                        str15 = optString10;
                                                                        str4 = str46;
                                                                        str6 = str47;
                                                                        str7 = str48;
                                                                        str8 = str29;
                                                                        str9 = str30;
                                                                        str10 = str31;
                                                                        str11 = str32;
                                                                        jSONObject8 = parseJSONObject3;
                                                                        jSONObject10 = parseJSONObject4;
                                                                        jSONObject9 = parseJSONObject8;
                                                                        jSONObject5 = parseJSONObject9;
                                                                        jSONObject2 = parseJSONObject10;
                                                                        str23 = optString20;
                                                                        str22 = optString;
                                                                        str21 = optString21;
                                                                        str20 = optString2;
                                                                        str19 = optString3;
                                                                        str18 = optString5;
                                                                        str17 = optString22;
                                                                        str16 = optString6;
                                                                        jSONObject7 = parseJSONObject5;
                                                                        str5 = liveSource;
                                                                        jSONObject13 = null;
                                                                        i2 = 0;
                                                                    }
                                                                    try {
                                                                        JSONObject parseJSONObject11 = MiniJsonUtils.INSTANCE.parseJSONObject(jSONObject23, "commonShareInfo");
                                                                        try {
                                                                            String optString24 = jSONObject23.optString("multirate");
                                                                            try {
                                                                                try {
                                                                                    try {
                                                                                        try {
                                                                                            try {
                                                                                                try {
                                                                                                    try {
                                                                                                        try {
                                                                                                            try {
                                                                                                                if (!TextUtils.isEmpty(optString24)) {
                                                                                                                    jSONObject15 = parseJSONObject11;
                                                                                                                    try {
                                                                                                                        jSONObject16 = new JSONObject(optString24);
                                                                                                                    } catch (Exception unused2) {
                                                                                                                    }
                                                                                                                    optJSONObject = jSONObject23.optJSONObject("vr");
                                                                                                                    if (optJSONObject == null || str2 == null) {
                                                                                                                        jSONObject17 = optJSONObject;
                                                                                                                        jSONObject18 = jSONObject16;
                                                                                                                    } else {
                                                                                                                        jSONObject17 = optJSONObject;
                                                                                                                        try {
                                                                                                                            jSONObject18 = jSONObject16;
                                                                                                                            try {
                                                                                                                                queryParameter = Uri.parse(str2).getQueryParameter("params");
                                                                                                                            } catch (Throwable th) {
                                                                                                                                th = th;
                                                                                                                                try {
                                                                                                                                    th.printStackTrace();
                                                                                                                                    jSONObject19 = jSONObject17;
                                                                                                                                    if (parseJSONObject != null) {
                                                                                                                                    }
                                                                                                                                    if (parseJSONObject5 != null) {
                                                                                                                                    }
                                                                                                                                    str42 = str35;
                                                                                                                                    optJSONObject3 = jSONObject23.optJSONObject("queryECLive");
                                                                                                                                    optJSONObject4 = jSONObject23.optJSONObject("hlReplay");
                                                                                                                                    optString8 = jSONObject23.optString("task_token");
                                                                                                                                    if (!TextUtils.isEmpty(optString8)) {
                                                                                                                                    }
                                                                                                                                    optInt2 = jSONObject23.optInt("interventions");
                                                                                                                                    String str49 = optString9;
                                                                                                                                    str45 = optString9;
                                                                                                                                    jSONObject22 = jSONObject15;
                                                                                                                                    jSONObject13 = jSONObject18;
                                                                                                                                    jSONObject21 = parseJSONObject5;
                                                                                                                                    str43 = liveSource;
                                                                                                                                    str44 = optString7;
                                                                                                                                    SchemeModel schemeModel3 = new SchemeModel(str49, str46, liveSource, str47, str48, str29, str30, str31, str32, str42, jSONObject20, parseJSONObject4, parseJSONObject8, parseJSONObject3, jSONObject21, optString20, optString, parseJSONObject2, parseJSONObject9, optJSONObject3, optJSONObject4, str40, str41, optString21, optString2, optString3, optString5, parseJSONObject10, optString22, optString10, optString6, parseJSONObject6);
                                                                                                                                    schemeModel3.setPlayerCacheKey(str44);
                                                                                                                                    num = num2;
                                                                                                                                    schemeModel3.setPlayerCacheCodeC(num);
                                                                                                                                    str25 = str37;
                                                                                                                                    schemeModel3.setKabrSpts(str25);
                                                                                                                                    schemeModel3.setMultiRate(jSONObject13);
                                                                                                                                    str24 = optString4;
                                                                                                                                    schemeModel3.setRtcHevcUrl(str24);
                                                                                                                                    jSONObject12 = jSONObject22;
                                                                                                                                    schemeModel3.setCommonShareInfo(jSONObject12);
                                                                                                                                    schemeModel3.setFromIntent(Boolean.TRUE);
                                                                                                                                    schemeModel3.setVrParams(jSONObject19);
                                                                                                                                    i4 = optInt;
                                                                                                                                    schemeModel3.setPlayRateSetting(i4);
                                                                                                                                    i = optInt2;
                                                                                                                                    schemeModel3.setInterventions(i);
                                                                                                                                    return schemeModel3;
                                                                                                                                } catch (Exception e24) {
                                                                                                                                    e = e24;
                                                                                                                                    jSONObject6 = parseJSONObject2;
                                                                                                                                    str25 = optString23;
                                                                                                                                    jSONObject = parseJSONObject6;
                                                                                                                                    num = valueOf;
                                                                                                                                    str3 = optString9;
                                                                                                                                    jSONObject11 = parseJSONObject;
                                                                                                                                    jSONObject7 = parseJSONObject5;
                                                                                                                                    str5 = liveSource;
                                                                                                                                    str12 = str35;
                                                                                                                                    str13 = str12;
                                                                                                                                    str14 = str13;
                                                                                                                                    i2 = optInt;
                                                                                                                                    str24 = optString4;
                                                                                                                                    jSONObject12 = jSONObject15;
                                                                                                                                    jSONObject13 = jSONObject18;
                                                                                                                                    str15 = optString10;
                                                                                                                                    str4 = str46;
                                                                                                                                    str6 = str47;
                                                                                                                                    str7 = str48;
                                                                                                                                    str8 = str29;
                                                                                                                                    str9 = str30;
                                                                                                                                    str10 = str31;
                                                                                                                                    str11 = str32;
                                                                                                                                    jSONObject8 = parseJSONObject3;
                                                                                                                                    jSONObject10 = parseJSONObject4;
                                                                                                                                    jSONObject9 = parseJSONObject8;
                                                                                                                                    jSONObject5 = parseJSONObject9;
                                                                                                                                    jSONObject2 = parseJSONObject10;
                                                                                                                                    str23 = optString20;
                                                                                                                                    str22 = optString;
                                                                                                                                    str21 = optString21;
                                                                                                                                    str20 = optString2;
                                                                                                                                    str19 = optString3;
                                                                                                                                    str18 = optString5;
                                                                                                                                    str17 = optString22;
                                                                                                                                    str16 = optString6;
                                                                                                                                    i = 0;
                                                                                                                                    jSONObject4 = null;
                                                                                                                                    jSONObject3 = null;
                                                                                                                                    str26 = optString7;
                                                                                                                                    e.printStackTrace();
                                                                                                                                    SchemeModel schemeModel2222222222222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject11, jSONObject10, jSONObject9, jSONObject8, jSONObject7, str23, str22, jSONObject6, jSONObject5, jSONObject4, jSONObject3, str13, str14, str21, str20, str19, str18, jSONObject2, str17, str15, str16, jSONObject);
                                                                                                                                    schemeModel2222222222222.setPlayerCacheKey(str26);
                                                                                                                                    schemeModel2222222222222.setPlayerCacheCodeC(num);
                                                                                                                                    schemeModel2222222222222.setKabrSpts(str25);
                                                                                                                                    schemeModel2222222222222.setRtcHevcUrl(str24);
                                                                                                                                    schemeModel2222222222222.setCommonShareInfo(jSONObject12);
                                                                                                                                    schemeModel2222222222222.setMultiRate(jSONObject13);
                                                                                                                                    schemeModel2222222222222.setFromIntent(Boolean.TRUE);
                                                                                                                                    schemeModel2222222222222.setPlayRateSetting(i2);
                                                                                                                                    schemeModel2222222222222.setInterventions(i);
                                                                                                                                    return schemeModel2222222222222;
                                                                                                                                }
                                                                                                                            }
                                                                                                                        } catch (Throwable th2) {
                                                                                                                            th = th2;
                                                                                                                            jSONObject18 = jSONObject16;
                                                                                                                        }
                                                                                                                        if (queryParameter != null) {
                                                                                                                            jSONObject19 = new JSONObject(queryParameter).optJSONObject("vr");
                                                                                                                            if (parseJSONObject != null) {
                                                                                                                                JSONObject jSONObject24 = new JSONObject();
                                                                                                                                JSONObject jSONObject25 = new JSONObject();
                                                                                                                                jSONObject25.put("source", liveSource);
                                                                                                                                Unit unit = Unit.INSTANCE;
                                                                                                                                jSONObject24.put("ext", jSONObject25);
                                                                                                                                Unit unit2 = Unit.INSTANCE;
                                                                                                                                str37 = optString23;
                                                                                                                                num2 = valueOf;
                                                                                                                                jSONObject20 = jSONObject24;
                                                                                                                                str40 = str35;
                                                                                                                                str41 = str40;
                                                                                                                            } else {
                                                                                                                                try {
                                                                                                                                    try {
                                                                                                                                        optJSONObject2 = parseJSONObject.optJSONObject("ext");
                                                                                                                                        if (optJSONObject2 != null) {
                                                                                                                                            str38 = optJSONObject2.optString("share_uid");
                                                                                                                                            try {
                                                                                                                                                str39 = optJSONObject2.optString("zb_tag");
                                                                                                                                                try {
                                                                                                                                                    Unit unit3 = Unit.INSTANCE;
                                                                                                                                                    str37 = optString23;
                                                                                                                                                    num2 = valueOf;
                                                                                                                                                    str40 = str38;
                                                                                                                                                    str41 = str39;
                                                                                                                                                } catch (JSONException unused3) {
                                                                                                                                                    str37 = optString23;
                                                                                                                                                    num2 = valueOf;
                                                                                                                                                    jSONObject20 = parseJSONObject;
                                                                                                                                                    str40 = str38;
                                                                                                                                                    str41 = str39;
                                                                                                                                                    if (parseJSONObject5 != null) {
                                                                                                                                                    }
                                                                                                                                                    str42 = str35;
                                                                                                                                                    optJSONObject3 = jSONObject23.optJSONObject("queryECLive");
                                                                                                                                                    optJSONObject4 = jSONObject23.optJSONObject("hlReplay");
                                                                                                                                                    optString8 = jSONObject23.optString("task_token");
                                                                                                                                                    if (!TextUtils.isEmpty(optString8)) {
                                                                                                                                                    }
                                                                                                                                                    optInt2 = jSONObject23.optInt("interventions");
                                                                                                                                                    String str492 = optString9;
                                                                                                                                                    str45 = optString9;
                                                                                                                                                    jSONObject22 = jSONObject15;
                                                                                                                                                    jSONObject13 = jSONObject18;
                                                                                                                                                    jSONObject21 = parseJSONObject5;
                                                                                                                                                    str43 = liveSource;
                                                                                                                                                    str44 = optString7;
                                                                                                                                                    SchemeModel schemeModel32 = new SchemeModel(str492, str46, liveSource, str47, str48, str29, str30, str31, str32, str42, jSONObject20, parseJSONObject4, parseJSONObject8, parseJSONObject3, jSONObject21, optString20, optString, parseJSONObject2, parseJSONObject9, optJSONObject3, optJSONObject4, str40, str41, optString21, optString2, optString3, optString5, parseJSONObject10, optString22, optString10, optString6, parseJSONObject6);
                                                                                                                                                    schemeModel32.setPlayerCacheKey(str44);
                                                                                                                                                    num = num2;
                                                                                                                                                    schemeModel32.setPlayerCacheCodeC(num);
                                                                                                                                                    str25 = str37;
                                                                                                                                                    schemeModel32.setKabrSpts(str25);
                                                                                                                                                    schemeModel32.setMultiRate(jSONObject13);
                                                                                                                                                    str24 = optString4;
                                                                                                                                                    schemeModel32.setRtcHevcUrl(str24);
                                                                                                                                                    jSONObject12 = jSONObject22;
                                                                                                                                                    schemeModel32.setCommonShareInfo(jSONObject12);
                                                                                                                                                    schemeModel32.setFromIntent(Boolean.TRUE);
                                                                                                                                                    schemeModel32.setVrParams(jSONObject19);
                                                                                                                                                    i4 = optInt;
                                                                                                                                                    schemeModel32.setPlayRateSetting(i4);
                                                                                                                                                    i = optInt2;
                                                                                                                                                    schemeModel32.setInterventions(i);
                                                                                                                                                    return schemeModel32;
                                                                                                                                                } catch (Exception e25) {
                                                                                                                                                    e = e25;
                                                                                                                                                    jSONObject6 = parseJSONObject2;
                                                                                                                                                    str25 = optString23;
                                                                                                                                                    jSONObject = parseJSONObject6;
                                                                                                                                                    num = valueOf;
                                                                                                                                                    str3 = optString9;
                                                                                                                                                    jSONObject11 = parseJSONObject;
                                                                                                                                                    jSONObject7 = parseJSONObject5;
                                                                                                                                                    str5 = liveSource;
                                                                                                                                                    str12 = str35;
                                                                                                                                                    i2 = optInt;
                                                                                                                                                    str24 = optString4;
                                                                                                                                                    jSONObject12 = jSONObject15;
                                                                                                                                                    str13 = str38;
                                                                                                                                                    jSONObject13 = jSONObject18;
                                                                                                                                                    str14 = str39;
                                                                                                                                                    str15 = optString10;
                                                                                                                                                    str4 = str46;
                                                                                                                                                    str6 = str47;
                                                                                                                                                    str7 = str48;
                                                                                                                                                    str8 = str29;
                                                                                                                                                    str9 = str30;
                                                                                                                                                    str10 = str31;
                                                                                                                                                    str11 = str32;
                                                                                                                                                    jSONObject8 = parseJSONObject3;
                                                                                                                                                    jSONObject10 = parseJSONObject4;
                                                                                                                                                    jSONObject9 = parseJSONObject8;
                                                                                                                                                    jSONObject5 = parseJSONObject9;
                                                                                                                                                    jSONObject2 = parseJSONObject10;
                                                                                                                                                    str23 = optString20;
                                                                                                                                                    str22 = optString;
                                                                                                                                                    str21 = optString21;
                                                                                                                                                    str20 = optString2;
                                                                                                                                                    str19 = optString3;
                                                                                                                                                    str18 = optString5;
                                                                                                                                                    str17 = optString22;
                                                                                                                                                    str16 = optString6;
                                                                                                                                                    i = 0;
                                                                                                                                                    jSONObject4 = null;
                                                                                                                                                    jSONObject3 = null;
                                                                                                                                                    str26 = optString7;
                                                                                                                                                    e.printStackTrace();
                                                                                                                                                    SchemeModel schemeModel22222222222222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject11, jSONObject10, jSONObject9, jSONObject8, jSONObject7, str23, str22, jSONObject6, jSONObject5, jSONObject4, jSONObject3, str13, str14, str21, str20, str19, str18, jSONObject2, str17, str15, str16, jSONObject);
                                                                                                                                                    schemeModel22222222222222.setPlayerCacheKey(str26);
                                                                                                                                                    schemeModel22222222222222.setPlayerCacheCodeC(num);
                                                                                                                                                    schemeModel22222222222222.setKabrSpts(str25);
                                                                                                                                                    schemeModel22222222222222.setRtcHevcUrl(str24);
                                                                                                                                                    schemeModel22222222222222.setCommonShareInfo(jSONObject12);
                                                                                                                                                    schemeModel22222222222222.setMultiRate(jSONObject13);
                                                                                                                                                    schemeModel22222222222222.setFromIntent(Boolean.TRUE);
                                                                                                                                                    schemeModel22222222222222.setPlayRateSetting(i2);
                                                                                                                                                    schemeModel22222222222222.setInterventions(i);
                                                                                                                                                    return schemeModel22222222222222;
                                                                                                                                                }
                                                                                                                                            } catch (JSONException unused4) {
                                                                                                                                                str37 = optString23;
                                                                                                                                                num2 = valueOf;
                                                                                                                                                str39 = str35;
                                                                                                                                            } catch (Exception e26) {
                                                                                                                                                e = e26;
                                                                                                                                                jSONObject6 = parseJSONObject2;
                                                                                                                                                str25 = optString23;
                                                                                                                                                jSONObject = parseJSONObject6;
                                                                                                                                                num = valueOf;
                                                                                                                                                str3 = optString9;
                                                                                                                                                jSONObject11 = parseJSONObject;
                                                                                                                                                jSONObject7 = parseJSONObject5;
                                                                                                                                                str5 = liveSource;
                                                                                                                                                str12 = str35;
                                                                                                                                                str14 = str12;
                                                                                                                                                i2 = optInt;
                                                                                                                                                str24 = optString4;
                                                                                                                                                jSONObject12 = jSONObject15;
                                                                                                                                                str13 = str38;
                                                                                                                                                jSONObject13 = jSONObject18;
                                                                                                                                                str15 = optString10;
                                                                                                                                                str4 = str46;
                                                                                                                                                str6 = str47;
                                                                                                                                                str7 = str48;
                                                                                                                                                str8 = str29;
                                                                                                                                                str9 = str30;
                                                                                                                                                str10 = str31;
                                                                                                                                                str11 = str32;
                                                                                                                                                jSONObject8 = parseJSONObject3;
                                                                                                                                                jSONObject10 = parseJSONObject4;
                                                                                                                                                jSONObject9 = parseJSONObject8;
                                                                                                                                                jSONObject5 = parseJSONObject9;
                                                                                                                                                jSONObject2 = parseJSONObject10;
                                                                                                                                                str23 = optString20;
                                                                                                                                                str22 = optString;
                                                                                                                                                str21 = optString21;
                                                                                                                                                str20 = optString2;
                                                                                                                                                str19 = optString3;
                                                                                                                                                str18 = optString5;
                                                                                                                                                str17 = optString22;
                                                                                                                                                str16 = optString6;
                                                                                                                                                i = 0;
                                                                                                                                                jSONObject4 = null;
                                                                                                                                                jSONObject3 = null;
                                                                                                                                                str26 = optString7;
                                                                                                                                                e.printStackTrace();
                                                                                                                                                SchemeModel schemeModel222222222222222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject11, jSONObject10, jSONObject9, jSONObject8, jSONObject7, str23, str22, jSONObject6, jSONObject5, jSONObject4, jSONObject3, str13, str14, str21, str20, str19, str18, jSONObject2, str17, str15, str16, jSONObject);
                                                                                                                                                schemeModel222222222222222.setPlayerCacheKey(str26);
                                                                                                                                                schemeModel222222222222222.setPlayerCacheCodeC(num);
                                                                                                                                                schemeModel222222222222222.setKabrSpts(str25);
                                                                                                                                                schemeModel222222222222222.setRtcHevcUrl(str24);
                                                                                                                                                schemeModel222222222222222.setCommonShareInfo(jSONObject12);
                                                                                                                                                schemeModel222222222222222.setMultiRate(jSONObject13);
                                                                                                                                                schemeModel222222222222222.setFromIntent(Boolean.TRUE);
                                                                                                                                                schemeModel222222222222222.setPlayRateSetting(i2);
                                                                                                                                                schemeModel222222222222222.setInterventions(i);
                                                                                                                                                return schemeModel222222222222222;
                                                                                                                                            }
                                                                                                                                        } else {
                                                                                                                                            str37 = optString23;
                                                                                                                                            num2 = valueOf;
                                                                                                                                            str40 = str35;
                                                                                                                                            str41 = str40;
                                                                                                                                        }
                                                                                                                                    } catch (JSONException unused5) {
                                                                                                                                        str37 = optString23;
                                                                                                                                        num2 = valueOf;
                                                                                                                                        str38 = str35;
                                                                                                                                        str39 = str38;
                                                                                                                                    }
                                                                                                                                } catch (Exception e27) {
                                                                                                                                    e = e27;
                                                                                                                                    str26 = optString7;
                                                                                                                                    jSONObject6 = parseJSONObject2;
                                                                                                                                    jSONObject = parseJSONObject6;
                                                                                                                                    str3 = optString9;
                                                                                                                                    jSONObject11 = parseJSONObject;
                                                                                                                                    jSONObject7 = parseJSONObject5;
                                                                                                                                    str5 = liveSource;
                                                                                                                                    str12 = str35;
                                                                                                                                    str13 = str12;
                                                                                                                                    str14 = str13;
                                                                                                                                    i2 = optInt;
                                                                                                                                    str24 = optString4;
                                                                                                                                    jSONObject12 = jSONObject15;
                                                                                                                                    jSONObject13 = jSONObject18;
                                                                                                                                    str15 = optString10;
                                                                                                                                    str4 = str46;
                                                                                                                                    str6 = str47;
                                                                                                                                    str7 = str48;
                                                                                                                                    str8 = str29;
                                                                                                                                    str9 = str30;
                                                                                                                                    str10 = str31;
                                                                                                                                    str11 = str32;
                                                                                                                                    jSONObject8 = parseJSONObject3;
                                                                                                                                    jSONObject10 = parseJSONObject4;
                                                                                                                                    jSONObject9 = parseJSONObject8;
                                                                                                                                    jSONObject5 = parseJSONObject9;
                                                                                                                                    jSONObject2 = parseJSONObject10;
                                                                                                                                    str23 = optString20;
                                                                                                                                    str22 = optString;
                                                                                                                                    str21 = optString21;
                                                                                                                                    str20 = optString2;
                                                                                                                                    str19 = optString3;
                                                                                                                                    str18 = optString5;
                                                                                                                                    str17 = optString22;
                                                                                                                                    str16 = optString6;
                                                                                                                                    str25 = optString23;
                                                                                                                                    num = valueOf;
                                                                                                                                    i = 0;
                                                                                                                                    jSONObject4 = null;
                                                                                                                                    jSONObject3 = null;
                                                                                                                                    e.printStackTrace();
                                                                                                                                    SchemeModel schemeModel2222222222222222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject11, jSONObject10, jSONObject9, jSONObject8, jSONObject7, str23, str22, jSONObject6, jSONObject5, jSONObject4, jSONObject3, str13, str14, str21, str20, str19, str18, jSONObject2, str17, str15, str16, jSONObject);
                                                                                                                                    schemeModel2222222222222222.setPlayerCacheKey(str26);
                                                                                                                                    schemeModel2222222222222222.setPlayerCacheCodeC(num);
                                                                                                                                    schemeModel2222222222222222.setKabrSpts(str25);
                                                                                                                                    schemeModel2222222222222222.setRtcHevcUrl(str24);
                                                                                                                                    schemeModel2222222222222222.setCommonShareInfo(jSONObject12);
                                                                                                                                    schemeModel2222222222222222.setMultiRate(jSONObject13);
                                                                                                                                    schemeModel2222222222222222.setFromIntent(Boolean.TRUE);
                                                                                                                                    schemeModel2222222222222222.setPlayRateSetting(i2);
                                                                                                                                    schemeModel2222222222222222.setInterventions(i);
                                                                                                                                    return schemeModel2222222222222222;
                                                                                                                                }
                                                                                                                                try {
                                                                                                                                    if (optJSONObject2 == null) {
                                                                                                                                        JSONObject jSONObject26 = new JSONObject();
                                                                                                                                        jSONObject26.put("source", liveSource);
                                                                                                                                        jSONObject26.put("share_uid", str40);
                                                                                                                                        jSONObject26.put("zb_tag", str41);
                                                                                                                                        Unit unit4 = Unit.INSTANCE;
                                                                                                                                        parseJSONObject.put("ext", jSONObject26);
                                                                                                                                    } else if (!optJSONObject2.has("source")) {
                                                                                                                                        optJSONObject2.put("source", liveSource);
                                                                                                                                        optJSONObject2.put("share_uid", str40);
                                                                                                                                        optJSONObject2.put("zb_tag", str41);
                                                                                                                                    }
                                                                                                                                    jSONObject20 = parseJSONObject;
                                                                                                                                } catch (JSONException unused6) {
                                                                                                                                    str38 = str40;
                                                                                                                                    str39 = str41;
                                                                                                                                    jSONObject20 = parseJSONObject;
                                                                                                                                    str40 = str38;
                                                                                                                                    str41 = str39;
                                                                                                                                    if (parseJSONObject5 != null) {
                                                                                                                                    }
                                                                                                                                    str42 = str35;
                                                                                                                                    optJSONObject3 = jSONObject23.optJSONObject("queryECLive");
                                                                                                                                    optJSONObject4 = jSONObject23.optJSONObject("hlReplay");
                                                                                                                                    optString8 = jSONObject23.optString("task_token");
                                                                                                                                    if (!TextUtils.isEmpty(optString8)) {
                                                                                                                                    }
                                                                                                                                    optInt2 = jSONObject23.optInt("interventions");
                                                                                                                                    String str4922 = optString9;
                                                                                                                                    str45 = optString9;
                                                                                                                                    jSONObject22 = jSONObject15;
                                                                                                                                    jSONObject13 = jSONObject18;
                                                                                                                                    jSONObject21 = parseJSONObject5;
                                                                                                                                    str43 = liveSource;
                                                                                                                                    str44 = optString7;
                                                                                                                                    SchemeModel schemeModel322 = new SchemeModel(str4922, str46, liveSource, str47, str48, str29, str30, str31, str32, str42, jSONObject20, parseJSONObject4, parseJSONObject8, parseJSONObject3, jSONObject21, optString20, optString, parseJSONObject2, parseJSONObject9, optJSONObject3, optJSONObject4, str40, str41, optString21, optString2, optString3, optString5, parseJSONObject10, optString22, optString10, optString6, parseJSONObject6);
                                                                                                                                    schemeModel322.setPlayerCacheKey(str44);
                                                                                                                                    num = num2;
                                                                                                                                    schemeModel322.setPlayerCacheCodeC(num);
                                                                                                                                    str25 = str37;
                                                                                                                                    schemeModel322.setKabrSpts(str25);
                                                                                                                                    schemeModel322.setMultiRate(jSONObject13);
                                                                                                                                    str24 = optString4;
                                                                                                                                    schemeModel322.setRtcHevcUrl(str24);
                                                                                                                                    jSONObject12 = jSONObject22;
                                                                                                                                    schemeModel322.setCommonShareInfo(jSONObject12);
                                                                                                                                    schemeModel322.setFromIntent(Boolean.TRUE);
                                                                                                                                    schemeModel322.setVrParams(jSONObject19);
                                                                                                                                    i4 = optInt;
                                                                                                                                    schemeModel322.setPlayRateSetting(i4);
                                                                                                                                    i = optInt2;
                                                                                                                                    schemeModel322.setInterventions(i);
                                                                                                                                    return schemeModel322;
                                                                                                                                } catch (Exception e28) {
                                                                                                                                    e = e28;
                                                                                                                                    jSONObject6 = parseJSONObject2;
                                                                                                                                    str13 = str40;
                                                                                                                                    jSONObject = parseJSONObject6;
                                                                                                                                    str14 = str41;
                                                                                                                                    str3 = optString9;
                                                                                                                                    jSONObject11 = parseJSONObject;
                                                                                                                                    jSONObject7 = parseJSONObject5;
                                                                                                                                    str5 = liveSource;
                                                                                                                                    str12 = str35;
                                                                                                                                    i2 = optInt;
                                                                                                                                    str24 = optString4;
                                                                                                                                    jSONObject12 = jSONObject15;
                                                                                                                                    jSONObject13 = jSONObject18;
                                                                                                                                    str15 = optString10;
                                                                                                                                    str4 = str46;
                                                                                                                                    str6 = str47;
                                                                                                                                    str7 = str48;
                                                                                                                                    str8 = str29;
                                                                                                                                    str9 = str30;
                                                                                                                                    str10 = str31;
                                                                                                                                    str11 = str32;
                                                                                                                                    jSONObject8 = parseJSONObject3;
                                                                                                                                    jSONObject10 = parseJSONObject4;
                                                                                                                                    jSONObject9 = parseJSONObject8;
                                                                                                                                    jSONObject5 = parseJSONObject9;
                                                                                                                                    jSONObject2 = parseJSONObject10;
                                                                                                                                    str23 = optString20;
                                                                                                                                    str22 = optString;
                                                                                                                                    str21 = optString21;
                                                                                                                                    str20 = optString2;
                                                                                                                                    str19 = optString3;
                                                                                                                                    str18 = optString5;
                                                                                                                                    str17 = optString22;
                                                                                                                                    str16 = optString6;
                                                                                                                                    str25 = str37;
                                                                                                                                    num = num2;
                                                                                                                                    i = 0;
                                                                                                                                    jSONObject4 = null;
                                                                                                                                    jSONObject3 = null;
                                                                                                                                    str26 = optString7;
                                                                                                                                    e.printStackTrace();
                                                                                                                                    SchemeModel schemeModel22222222222222222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject11, jSONObject10, jSONObject9, jSONObject8, jSONObject7, str23, str22, jSONObject6, jSONObject5, jSONObject4, jSONObject3, str13, str14, str21, str20, str19, str18, jSONObject2, str17, str15, str16, jSONObject);
                                                                                                                                    schemeModel22222222222222222.setPlayerCacheKey(str26);
                                                                                                                                    schemeModel22222222222222222.setPlayerCacheCodeC(num);
                                                                                                                                    schemeModel22222222222222222.setKabrSpts(str25);
                                                                                                                                    schemeModel22222222222222222.setRtcHevcUrl(str24);
                                                                                                                                    schemeModel22222222222222222.setCommonShareInfo(jSONObject12);
                                                                                                                                    schemeModel22222222222222222.setMultiRate(jSONObject13);
                                                                                                                                    schemeModel22222222222222222.setFromIntent(Boolean.TRUE);
                                                                                                                                    schemeModel22222222222222222.setPlayRateSetting(i2);
                                                                                                                                    schemeModel22222222222222222.setInterventions(i);
                                                                                                                                    return schemeModel22222222222222222;
                                                                                                                                }
                                                                                                                            }
                                                                                                                            if (parseJSONObject5 != null) {
                                                                                                                                try {
                                                                                                                                    JSONObject optJSONObject5 = parseJSONObject5.optJSONObject("ext");
                                                                                                                                    if (optJSONObject5 != null) {
                                                                                                                                        String optString25 = optJSONObject5.optString("live_back_scheme");
                                                                                                                                        if (optString25 == null) {
                                                                                                                                            optString25 = str35;
                                                                                                                                        }
                                                                                                                                        try {
                                                                                                                                            if (TextUtils.isEmpty(optString25)) {
                                                                                                                                                String optString26 = optJSONObject5.optString("live_back_for_both_scheme");
                                                                                                                                                if (optString26 != null) {
                                                                                                                                                    str35 = optString26;
                                                                                                                                                }
                                                                                                                                            } else {
                                                                                                                                                str42 = optString25;
                                                                                                                                                optJSONObject3 = jSONObject23.optJSONObject("queryECLive");
                                                                                                                                                optJSONObject4 = jSONObject23.optJSONObject("hlReplay");
                                                                                                                                                optString8 = jSONObject23.optString("task_token");
                                                                                                                                                if (!TextUtils.isEmpty(optString8)) {
                                                                                                                                                    try {
                                                                                                                                                        if (parseJSONObject2 == null) {
                                                                                                                                                            JSONObject jSONObject27 = new JSONObject();
                                                                                                                                                            jSONObject27.put("task_token", optString8);
                                                                                                                                                            Unit unit5 = Unit.INSTANCE;
                                                                                                                                                            parseJSONObject2 = jSONObject27;
                                                                                                                                                        } else {
                                                                                                                                                            parseJSONObject2.put("task_token", optString8);
                                                                                                                                                        }
                                                                                                                                                    } catch (Exception e29) {
                                                                                                                                                        e = e29;
                                                                                                                                                        jSONObject6 = parseJSONObject2;
                                                                                                                                                        str12 = str42;
                                                                                                                                                        jSONObject11 = jSONObject20;
                                                                                                                                                        str13 = str40;
                                                                                                                                                        jSONObject = parseJSONObject6;
                                                                                                                                                        str14 = str41;
                                                                                                                                                        str3 = optString9;
                                                                                                                                                        jSONObject7 = parseJSONObject5;
                                                                                                                                                        str5 = liveSource;
                                                                                                                                                        i2 = optInt;
                                                                                                                                                        str24 = optString4;
                                                                                                                                                        jSONObject12 = jSONObject15;
                                                                                                                                                        jSONObject13 = jSONObject18;
                                                                                                                                                        str15 = optString10;
                                                                                                                                                        str4 = str46;
                                                                                                                                                        str6 = str47;
                                                                                                                                                        str7 = str48;
                                                                                                                                                        str8 = str29;
                                                                                                                                                        str9 = str30;
                                                                                                                                                        str10 = str31;
                                                                                                                                                        str11 = str32;
                                                                                                                                                        jSONObject8 = parseJSONObject3;
                                                                                                                                                        jSONObject10 = parseJSONObject4;
                                                                                                                                                        jSONObject9 = parseJSONObject8;
                                                                                                                                                        jSONObject5 = parseJSONObject9;
                                                                                                                                                        jSONObject2 = parseJSONObject10;
                                                                                                                                                        str23 = optString20;
                                                                                                                                                        str22 = optString;
                                                                                                                                                        str21 = optString21;
                                                                                                                                                        str20 = optString2;
                                                                                                                                                        str19 = optString3;
                                                                                                                                                        str18 = optString5;
                                                                                                                                                        str17 = optString22;
                                                                                                                                                        str16 = optString6;
                                                                                                                                                        str25 = str37;
                                                                                                                                                        num = num2;
                                                                                                                                                        jSONObject4 = optJSONObject3;
                                                                                                                                                        jSONObject3 = optJSONObject4;
                                                                                                                                                        i = 0;
                                                                                                                                                        str26 = optString7;
                                                                                                                                                        e.printStackTrace();
                                                                                                                                                        SchemeModel schemeModel222222222222222222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject11, jSONObject10, jSONObject9, jSONObject8, jSONObject7, str23, str22, jSONObject6, jSONObject5, jSONObject4, jSONObject3, str13, str14, str21, str20, str19, str18, jSONObject2, str17, str15, str16, jSONObject);
                                                                                                                                                        schemeModel222222222222222222.setPlayerCacheKey(str26);
                                                                                                                                                        schemeModel222222222222222222.setPlayerCacheCodeC(num);
                                                                                                                                                        schemeModel222222222222222222.setKabrSpts(str25);
                                                                                                                                                        schemeModel222222222222222222.setRtcHevcUrl(str24);
                                                                                                                                                        schemeModel222222222222222222.setCommonShareInfo(jSONObject12);
                                                                                                                                                        schemeModel222222222222222222.setMultiRate(jSONObject13);
                                                                                                                                                        schemeModel222222222222222222.setFromIntent(Boolean.TRUE);
                                                                                                                                                        schemeModel222222222222222222.setPlayRateSetting(i2);
                                                                                                                                                        schemeModel222222222222222222.setInterventions(i);
                                                                                                                                                        return schemeModel222222222222222222;
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                                optInt2 = jSONObject23.optInt("interventions");
                                                                                                                                                String str49222 = optString9;
                                                                                                                                                str45 = optString9;
                                                                                                                                                jSONObject22 = jSONObject15;
                                                                                                                                                jSONObject13 = jSONObject18;
                                                                                                                                                jSONObject21 = parseJSONObject5;
                                                                                                                                                str43 = liveSource;
                                                                                                                                                str44 = optString7;
                                                                                                                                                SchemeModel schemeModel3222 = new SchemeModel(str49222, str46, liveSource, str47, str48, str29, str30, str31, str32, str42, jSONObject20, parseJSONObject4, parseJSONObject8, parseJSONObject3, jSONObject21, optString20, optString, parseJSONObject2, parseJSONObject9, optJSONObject3, optJSONObject4, str40, str41, optString21, optString2, optString3, optString5, parseJSONObject10, optString22, optString10, optString6, parseJSONObject6);
                                                                                                                                                schemeModel3222.setPlayerCacheKey(str44);
                                                                                                                                                num = num2;
                                                                                                                                                schemeModel3222.setPlayerCacheCodeC(num);
                                                                                                                                                str25 = str37;
                                                                                                                                                schemeModel3222.setKabrSpts(str25);
                                                                                                                                                schemeModel3222.setMultiRate(jSONObject13);
                                                                                                                                                str24 = optString4;
                                                                                                                                                schemeModel3222.setRtcHevcUrl(str24);
                                                                                                                                                jSONObject12 = jSONObject22;
                                                                                                                                                schemeModel3222.setCommonShareInfo(jSONObject12);
                                                                                                                                                schemeModel3222.setFromIntent(Boolean.TRUE);
                                                                                                                                                schemeModel3222.setVrParams(jSONObject19);
                                                                                                                                                i4 = optInt;
                                                                                                                                                schemeModel3222.setPlayRateSetting(i4);
                                                                                                                                                i = optInt2;
                                                                                                                                                schemeModel3222.setInterventions(i);
                                                                                                                                                return schemeModel3222;
                                                                                                                                            }
                                                                                                                                        } catch (Exception e30) {
                                                                                                                                            e = e30;
                                                                                                                                            jSONObject6 = parseJSONObject2;
                                                                                                                                            jSONObject11 = jSONObject20;
                                                                                                                                            str13 = str40;
                                                                                                                                            jSONObject = parseJSONObject6;
                                                                                                                                            str14 = str41;
                                                                                                                                            str3 = optString9;
                                                                                                                                            str12 = optString25;
                                                                                                                                            jSONObject7 = parseJSONObject5;
                                                                                                                                            str5 = liveSource;
                                                                                                                                            i2 = optInt;
                                                                                                                                            str24 = optString4;
                                                                                                                                            jSONObject12 = jSONObject15;
                                                                                                                                            jSONObject13 = jSONObject18;
                                                                                                                                            str15 = optString10;
                                                                                                                                            str4 = str46;
                                                                                                                                            str6 = str47;
                                                                                                                                            str7 = str48;
                                                                                                                                            str8 = str29;
                                                                                                                                            str9 = str30;
                                                                                                                                            str10 = str31;
                                                                                                                                            str11 = str32;
                                                                                                                                            jSONObject8 = parseJSONObject3;
                                                                                                                                            jSONObject10 = parseJSONObject4;
                                                                                                                                            jSONObject9 = parseJSONObject8;
                                                                                                                                            jSONObject5 = parseJSONObject9;
                                                                                                                                            jSONObject2 = parseJSONObject10;
                                                                                                                                            str23 = optString20;
                                                                                                                                            str22 = optString;
                                                                                                                                            str21 = optString21;
                                                                                                                                            str20 = optString2;
                                                                                                                                            str19 = optString3;
                                                                                                                                            str18 = optString5;
                                                                                                                                            str17 = optString22;
                                                                                                                                            str16 = optString6;
                                                                                                                                            str25 = str37;
                                                                                                                                            num = num2;
                                                                                                                                            i = 0;
                                                                                                                                            jSONObject4 = null;
                                                                                                                                            jSONObject3 = null;
                                                                                                                                            str26 = optString7;
                                                                                                                                            e.printStackTrace();
                                                                                                                                            SchemeModel schemeModel2222222222222222222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject11, jSONObject10, jSONObject9, jSONObject8, jSONObject7, str23, str22, jSONObject6, jSONObject5, jSONObject4, jSONObject3, str13, str14, str21, str20, str19, str18, jSONObject2, str17, str15, str16, jSONObject);
                                                                                                                                            schemeModel2222222222222222222.setPlayerCacheKey(str26);
                                                                                                                                            schemeModel2222222222222222222.setPlayerCacheCodeC(num);
                                                                                                                                            schemeModel2222222222222222222.setKabrSpts(str25);
                                                                                                                                            schemeModel2222222222222222222.setRtcHevcUrl(str24);
                                                                                                                                            schemeModel2222222222222222222.setCommonShareInfo(jSONObject12);
                                                                                                                                            schemeModel2222222222222222222.setMultiRate(jSONObject13);
                                                                                                                                            schemeModel2222222222222222222.setFromIntent(Boolean.TRUE);
                                                                                                                                            schemeModel2222222222222222222.setPlayRateSetting(i2);
                                                                                                                                            schemeModel2222222222222222222.setInterventions(i);
                                                                                                                                            return schemeModel2222222222222222222;
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                } catch (Exception e31) {
                                                                                                                                    e = e31;
                                                                                                                                    jSONObject6 = parseJSONObject2;
                                                                                                                                    jSONObject11 = jSONObject20;
                                                                                                                                    str13 = str40;
                                                                                                                                    jSONObject = parseJSONObject6;
                                                                                                                                    str14 = str41;
                                                                                                                                    str3 = optString9;
                                                                                                                                    jSONObject7 = parseJSONObject5;
                                                                                                                                    str5 = liveSource;
                                                                                                                                    str12 = str35;
                                                                                                                                    i2 = optInt;
                                                                                                                                    str24 = optString4;
                                                                                                                                    jSONObject12 = jSONObject15;
                                                                                                                                    jSONObject13 = jSONObject18;
                                                                                                                                    str15 = optString10;
                                                                                                                                    str4 = str46;
                                                                                                                                    str6 = str47;
                                                                                                                                    str7 = str48;
                                                                                                                                    str8 = str29;
                                                                                                                                    str9 = str30;
                                                                                                                                    str10 = str31;
                                                                                                                                    str11 = str32;
                                                                                                                                    jSONObject8 = parseJSONObject3;
                                                                                                                                    jSONObject10 = parseJSONObject4;
                                                                                                                                    jSONObject9 = parseJSONObject8;
                                                                                                                                    jSONObject5 = parseJSONObject9;
                                                                                                                                    jSONObject2 = parseJSONObject10;
                                                                                                                                    str23 = optString20;
                                                                                                                                    str22 = optString;
                                                                                                                                    str21 = optString21;
                                                                                                                                    str20 = optString2;
                                                                                                                                    str19 = optString3;
                                                                                                                                    str18 = optString5;
                                                                                                                                    str17 = optString22;
                                                                                                                                    str16 = optString6;
                                                                                                                                    str25 = str37;
                                                                                                                                    num = num2;
                                                                                                                                    i = 0;
                                                                                                                                    jSONObject4 = null;
                                                                                                                                    jSONObject3 = null;
                                                                                                                                    str26 = optString7;
                                                                                                                                    e.printStackTrace();
                                                                                                                                    SchemeModel schemeModel22222222222222222222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject11, jSONObject10, jSONObject9, jSONObject8, jSONObject7, str23, str22, jSONObject6, jSONObject5, jSONObject4, jSONObject3, str13, str14, str21, str20, str19, str18, jSONObject2, str17, str15, str16, jSONObject);
                                                                                                                                    schemeModel22222222222222222222.setPlayerCacheKey(str26);
                                                                                                                                    schemeModel22222222222222222222.setPlayerCacheCodeC(num);
                                                                                                                                    schemeModel22222222222222222222.setKabrSpts(str25);
                                                                                                                                    schemeModel22222222222222222222.setRtcHevcUrl(str24);
                                                                                                                                    schemeModel22222222222222222222.setCommonShareInfo(jSONObject12);
                                                                                                                                    schemeModel22222222222222222222.setMultiRate(jSONObject13);
                                                                                                                                    schemeModel22222222222222222222.setFromIntent(Boolean.TRUE);
                                                                                                                                    schemeModel22222222222222222222.setPlayRateSetting(i2);
                                                                                                                                    schemeModel22222222222222222222.setInterventions(i);
                                                                                                                                    return schemeModel22222222222222222222;
                                                                                                                                }
                                                                                                                            }
                                                                                                                            str42 = str35;
                                                                                                                            optJSONObject3 = jSONObject23.optJSONObject("queryECLive");
                                                                                                                            optJSONObject4 = jSONObject23.optJSONObject("hlReplay");
                                                                                                                            optString8 = jSONObject23.optString("task_token");
                                                                                                                            if (!TextUtils.isEmpty(optString8)) {
                                                                                                                            }
                                                                                                                            optInt2 = jSONObject23.optInt("interventions");
                                                                                                                            String str492222 = optString9;
                                                                                                                            str45 = optString9;
                                                                                                                            jSONObject22 = jSONObject15;
                                                                                                                            jSONObject13 = jSONObject18;
                                                                                                                            jSONObject21 = parseJSONObject5;
                                                                                                                            str43 = liveSource;
                                                                                                                            str44 = optString7;
                                                                                                                            SchemeModel schemeModel32222 = new SchemeModel(str492222, str46, liveSource, str47, str48, str29, str30, str31, str32, str42, jSONObject20, parseJSONObject4, parseJSONObject8, parseJSONObject3, jSONObject21, optString20, optString, parseJSONObject2, parseJSONObject9, optJSONObject3, optJSONObject4, str40, str41, optString21, optString2, optString3, optString5, parseJSONObject10, optString22, optString10, optString6, parseJSONObject6);
                                                                                                                            schemeModel32222.setPlayerCacheKey(str44);
                                                                                                                            num = num2;
                                                                                                                            schemeModel32222.setPlayerCacheCodeC(num);
                                                                                                                            str25 = str37;
                                                                                                                            schemeModel32222.setKabrSpts(str25);
                                                                                                                            schemeModel32222.setMultiRate(jSONObject13);
                                                                                                                            str24 = optString4;
                                                                                                                            schemeModel32222.setRtcHevcUrl(str24);
                                                                                                                            jSONObject12 = jSONObject22;
                                                                                                                            schemeModel32222.setCommonShareInfo(jSONObject12);
                                                                                                                            schemeModel32222.setFromIntent(Boolean.TRUE);
                                                                                                                            schemeModel32222.setVrParams(jSONObject19);
                                                                                                                            i4 = optInt;
                                                                                                                            schemeModel32222.setPlayRateSetting(i4);
                                                                                                                            i = optInt2;
                                                                                                                            schemeModel32222.setInterventions(i);
                                                                                                                            return schemeModel32222;
                                                                                                                        }
                                                                                                                    }
                                                                                                                    jSONObject19 = jSONObject17;
                                                                                                                    if (parseJSONObject != null) {
                                                                                                                    }
                                                                                                                    if (parseJSONObject5 != null) {
                                                                                                                    }
                                                                                                                    str42 = str35;
                                                                                                                    optJSONObject3 = jSONObject23.optJSONObject("queryECLive");
                                                                                                                    optJSONObject4 = jSONObject23.optJSONObject("hlReplay");
                                                                                                                    optString8 = jSONObject23.optString("task_token");
                                                                                                                    if (!TextUtils.isEmpty(optString8)) {
                                                                                                                    }
                                                                                                                    optInt2 = jSONObject23.optInt("interventions");
                                                                                                                    String str4922222 = optString9;
                                                                                                                    str45 = optString9;
                                                                                                                    jSONObject22 = jSONObject15;
                                                                                                                    jSONObject13 = jSONObject18;
                                                                                                                    jSONObject21 = parseJSONObject5;
                                                                                                                    str43 = liveSource;
                                                                                                                    str44 = optString7;
                                                                                                                    SchemeModel schemeModel322222 = new SchemeModel(str4922222, str46, liveSource, str47, str48, str29, str30, str31, str32, str42, jSONObject20, parseJSONObject4, parseJSONObject8, parseJSONObject3, jSONObject21, optString20, optString, parseJSONObject2, parseJSONObject9, optJSONObject3, optJSONObject4, str40, str41, optString21, optString2, optString3, optString5, parseJSONObject10, optString22, optString10, optString6, parseJSONObject6);
                                                                                                                    schemeModel322222.setPlayerCacheKey(str44);
                                                                                                                    num = num2;
                                                                                                                    schemeModel322222.setPlayerCacheCodeC(num);
                                                                                                                    str25 = str37;
                                                                                                                    schemeModel322222.setKabrSpts(str25);
                                                                                                                    schemeModel322222.setMultiRate(jSONObject13);
                                                                                                                    str24 = optString4;
                                                                                                                    schemeModel322222.setRtcHevcUrl(str24);
                                                                                                                    jSONObject12 = jSONObject22;
                                                                                                                    schemeModel322222.setCommonShareInfo(jSONObject12);
                                                                                                                    schemeModel322222.setFromIntent(Boolean.TRUE);
                                                                                                                    schemeModel322222.setVrParams(jSONObject19);
                                                                                                                    i4 = optInt;
                                                                                                                    schemeModel322222.setPlayRateSetting(i4);
                                                                                                                    i = optInt2;
                                                                                                                    schemeModel322222.setInterventions(i);
                                                                                                                    return schemeModel322222;
                                                                                                                }
                                                                                                                jSONObject15 = parseJSONObject11;
                                                                                                                schemeModel322222.setInterventions(i);
                                                                                                                return schemeModel322222;
                                                                                                            } catch (Exception e32) {
                                                                                                                e = e32;
                                                                                                                str3 = str45;
                                                                                                                jSONObject6 = parseJSONObject2;
                                                                                                                str12 = str42;
                                                                                                                jSONObject11 = jSONObject20;
                                                                                                                str13 = str40;
                                                                                                                jSONObject = parseJSONObject6;
                                                                                                                str14 = str41;
                                                                                                                str26 = str44;
                                                                                                                i2 = i4;
                                                                                                                str15 = optString10;
                                                                                                                str4 = str46;
                                                                                                                str6 = str47;
                                                                                                                str7 = str48;
                                                                                                                str8 = str29;
                                                                                                                str9 = str30;
                                                                                                                str10 = str31;
                                                                                                                str11 = str32;
                                                                                                                jSONObject8 = parseJSONObject3;
                                                                                                                jSONObject10 = parseJSONObject4;
                                                                                                                jSONObject9 = parseJSONObject8;
                                                                                                                jSONObject5 = parseJSONObject9;
                                                                                                                jSONObject2 = parseJSONObject10;
                                                                                                                str23 = optString20;
                                                                                                                str22 = optString;
                                                                                                                str21 = optString21;
                                                                                                                str20 = optString2;
                                                                                                                str19 = optString3;
                                                                                                                str18 = optString5;
                                                                                                                str17 = optString22;
                                                                                                                str16 = optString6;
                                                                                                                jSONObject4 = optJSONObject3;
                                                                                                                jSONObject3 = optJSONObject4;
                                                                                                                jSONObject7 = jSONObject21;
                                                                                                                str5 = str43;
                                                                                                                e.printStackTrace();
                                                                                                                SchemeModel schemeModel222222222222222222222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject11, jSONObject10, jSONObject9, jSONObject8, jSONObject7, str23, str22, jSONObject6, jSONObject5, jSONObject4, jSONObject3, str13, str14, str21, str20, str19, str18, jSONObject2, str17, str15, str16, jSONObject);
                                                                                                                schemeModel222222222222222222222.setPlayerCacheKey(str26);
                                                                                                                schemeModel222222222222222222222.setPlayerCacheCodeC(num);
                                                                                                                schemeModel222222222222222222222.setKabrSpts(str25);
                                                                                                                schemeModel222222222222222222222.setRtcHevcUrl(str24);
                                                                                                                schemeModel222222222222222222222.setCommonShareInfo(jSONObject12);
                                                                                                                schemeModel222222222222222222222.setMultiRate(jSONObject13);
                                                                                                                schemeModel222222222222222222222.setFromIntent(Boolean.TRUE);
                                                                                                                schemeModel222222222222222222222.setPlayRateSetting(i2);
                                                                                                                schemeModel222222222222222222222.setInterventions(i);
                                                                                                                return schemeModel222222222222222222222;
                                                                                                            }
                                                                                                            schemeModel322222.setPlayRateSetting(i4);
                                                                                                            i = optInt2;
                                                                                                        } catch (Exception e33) {
                                                                                                            e = e33;
                                                                                                            i = optInt2;
                                                                                                        }
                                                                                                        schemeModel322222.setCommonShareInfo(jSONObject12);
                                                                                                        schemeModel322222.setFromIntent(Boolean.TRUE);
                                                                                                        schemeModel322222.setVrParams(jSONObject19);
                                                                                                        i4 = optInt;
                                                                                                    } catch (Exception e34) {
                                                                                                        e = e34;
                                                                                                        i = optInt2;
                                                                                                        i4 = optInt;
                                                                                                    }
                                                                                                    schemeModel322222.setRtcHevcUrl(str24);
                                                                                                    jSONObject12 = jSONObject22;
                                                                                                } catch (Exception e35) {
                                                                                                    e = e35;
                                                                                                    i = optInt2;
                                                                                                    i4 = optInt;
                                                                                                    jSONObject12 = jSONObject22;
                                                                                                }
                                                                                                schemeModel322222.setKabrSpts(str25);
                                                                                                schemeModel322222.setMultiRate(jSONObject13);
                                                                                                str24 = optString4;
                                                                                            } catch (Exception e36) {
                                                                                                e = e36;
                                                                                                i = optInt2;
                                                                                                i4 = optInt;
                                                                                                jSONObject12 = jSONObject22;
                                                                                                str24 = optString4;
                                                                                                str3 = str45;
                                                                                                jSONObject6 = parseJSONObject2;
                                                                                                str12 = str42;
                                                                                                jSONObject11 = jSONObject20;
                                                                                                str13 = str40;
                                                                                                jSONObject = parseJSONObject6;
                                                                                                str14 = str41;
                                                                                                str26 = str44;
                                                                                                i2 = i4;
                                                                                                str15 = optString10;
                                                                                                str4 = str46;
                                                                                                str6 = str47;
                                                                                                str7 = str48;
                                                                                                str8 = str29;
                                                                                                str9 = str30;
                                                                                                str10 = str31;
                                                                                                str11 = str32;
                                                                                                jSONObject8 = parseJSONObject3;
                                                                                                jSONObject10 = parseJSONObject4;
                                                                                                jSONObject9 = parseJSONObject8;
                                                                                                jSONObject5 = parseJSONObject9;
                                                                                                jSONObject2 = parseJSONObject10;
                                                                                                str23 = optString20;
                                                                                                str22 = optString;
                                                                                                str21 = optString21;
                                                                                                str20 = optString2;
                                                                                                str19 = optString3;
                                                                                                str18 = optString5;
                                                                                                str17 = optString22;
                                                                                                str16 = optString6;
                                                                                                jSONObject4 = optJSONObject3;
                                                                                                jSONObject3 = optJSONObject4;
                                                                                                jSONObject7 = jSONObject21;
                                                                                                str5 = str43;
                                                                                                e.printStackTrace();
                                                                                                SchemeModel schemeModel2222222222222222222222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject11, jSONObject10, jSONObject9, jSONObject8, jSONObject7, str23, str22, jSONObject6, jSONObject5, jSONObject4, jSONObject3, str13, str14, str21, str20, str19, str18, jSONObject2, str17, str15, str16, jSONObject);
                                                                                                schemeModel2222222222222222222222.setPlayerCacheKey(str26);
                                                                                                schemeModel2222222222222222222222.setPlayerCacheCodeC(num);
                                                                                                schemeModel2222222222222222222222.setKabrSpts(str25);
                                                                                                schemeModel2222222222222222222222.setRtcHevcUrl(str24);
                                                                                                schemeModel2222222222222222222222.setCommonShareInfo(jSONObject12);
                                                                                                schemeModel2222222222222222222222.setMultiRate(jSONObject13);
                                                                                                schemeModel2222222222222222222222.setFromIntent(Boolean.TRUE);
                                                                                                schemeModel2222222222222222222222.setPlayRateSetting(i2);
                                                                                                schemeModel2222222222222222222222.setInterventions(i);
                                                                                                return schemeModel2222222222222222222222;
                                                                                            }
                                                                                            String str49222222 = optString9;
                                                                                            str45 = optString9;
                                                                                            jSONObject22 = jSONObject15;
                                                                                            jSONObject13 = jSONObject18;
                                                                                            jSONObject21 = parseJSONObject5;
                                                                                            str43 = liveSource;
                                                                                            str44 = optString7;
                                                                                            SchemeModel schemeModel3222222 = new SchemeModel(str49222222, str46, liveSource, str47, str48, str29, str30, str31, str32, str42, jSONObject20, parseJSONObject4, parseJSONObject8, parseJSONObject3, jSONObject21, optString20, optString, parseJSONObject2, parseJSONObject9, optJSONObject3, optJSONObject4, str40, str41, optString21, optString2, optString3, optString5, parseJSONObject10, optString22, optString10, optString6, parseJSONObject6);
                                                                                            schemeModel3222222.setPlayerCacheKey(str44);
                                                                                            num = num2;
                                                                                            schemeModel3222222.setPlayerCacheCodeC(num);
                                                                                            str25 = str37;
                                                                                        } catch (Exception e37) {
                                                                                            e = e37;
                                                                                            i = optInt2;
                                                                                            jSONObject21 = parseJSONObject5;
                                                                                            str43 = liveSource;
                                                                                            i4 = optInt;
                                                                                            str24 = optString4;
                                                                                            jSONObject12 = jSONObject15;
                                                                                            jSONObject13 = jSONObject18;
                                                                                            str25 = str37;
                                                                                            num = num2;
                                                                                            String str50 = optString9;
                                                                                            str44 = optString7;
                                                                                            str45 = str50;
                                                                                        }
                                                                                        optString8 = jSONObject23.optString("task_token");
                                                                                        if (!TextUtils.isEmpty(optString8)) {
                                                                                        }
                                                                                        optInt2 = jSONObject23.optInt("interventions");
                                                                                    } catch (Exception e38) {
                                                                                        e = e38;
                                                                                        str24 = optString4;
                                                                                        jSONObject12 = jSONObject15;
                                                                                        jSONObject13 = jSONObject18;
                                                                                        str25 = str37;
                                                                                        num = num2;
                                                                                        str3 = optString9;
                                                                                        jSONObject6 = parseJSONObject2;
                                                                                        str12 = str42;
                                                                                        jSONObject11 = jSONObject20;
                                                                                        str13 = str40;
                                                                                        jSONObject = parseJSONObject6;
                                                                                        str14 = str41;
                                                                                        str26 = optString7;
                                                                                        i2 = optInt;
                                                                                        str15 = optString10;
                                                                                        str4 = str46;
                                                                                        str6 = str47;
                                                                                        str7 = str48;
                                                                                        str8 = str29;
                                                                                        str9 = str30;
                                                                                        str10 = str31;
                                                                                        str11 = str32;
                                                                                        jSONObject8 = parseJSONObject3;
                                                                                        jSONObject10 = parseJSONObject4;
                                                                                        jSONObject9 = parseJSONObject8;
                                                                                        jSONObject5 = parseJSONObject9;
                                                                                        jSONObject2 = parseJSONObject10;
                                                                                        str23 = optString20;
                                                                                        str22 = optString;
                                                                                        str21 = optString21;
                                                                                        str20 = optString2;
                                                                                        str19 = optString3;
                                                                                        str18 = optString5;
                                                                                        str17 = optString22;
                                                                                        str16 = optString6;
                                                                                        jSONObject4 = optJSONObject3;
                                                                                        jSONObject3 = optJSONObject4;
                                                                                        jSONObject7 = parseJSONObject5;
                                                                                        str5 = liveSource;
                                                                                        i = 0;
                                                                                    }
                                                                                    optJSONObject4 = jSONObject23.optJSONObject("hlReplay");
                                                                                } catch (Exception e39) {
                                                                                    e = e39;
                                                                                    str24 = optString4;
                                                                                    jSONObject12 = jSONObject15;
                                                                                    jSONObject13 = jSONObject18;
                                                                                    str25 = str37;
                                                                                    num = num2;
                                                                                    str3 = optString9;
                                                                                    jSONObject6 = parseJSONObject2;
                                                                                    str12 = str42;
                                                                                    jSONObject11 = jSONObject20;
                                                                                    str13 = str40;
                                                                                    jSONObject = parseJSONObject6;
                                                                                    str14 = str41;
                                                                                    str26 = optString7;
                                                                                    i2 = optInt;
                                                                                    str15 = optString10;
                                                                                    str4 = str46;
                                                                                    str6 = str47;
                                                                                    str7 = str48;
                                                                                    str8 = str29;
                                                                                    str9 = str30;
                                                                                    str10 = str31;
                                                                                    str11 = str32;
                                                                                    jSONObject8 = parseJSONObject3;
                                                                                    jSONObject10 = parseJSONObject4;
                                                                                    jSONObject9 = parseJSONObject8;
                                                                                    jSONObject5 = parseJSONObject9;
                                                                                    jSONObject2 = parseJSONObject10;
                                                                                    str23 = optString20;
                                                                                    str22 = optString;
                                                                                    str21 = optString21;
                                                                                    str20 = optString2;
                                                                                    str19 = optString3;
                                                                                    str18 = optString5;
                                                                                    str17 = optString22;
                                                                                    str16 = optString6;
                                                                                    jSONObject4 = optJSONObject3;
                                                                                    jSONObject7 = parseJSONObject5;
                                                                                    str5 = liveSource;
                                                                                    i = 0;
                                                                                    jSONObject3 = null;
                                                                                    e.printStackTrace();
                                                                                    SchemeModel schemeModel22222222222222222222222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject11, jSONObject10, jSONObject9, jSONObject8, jSONObject7, str23, str22, jSONObject6, jSONObject5, jSONObject4, jSONObject3, str13, str14, str21, str20, str19, str18, jSONObject2, str17, str15, str16, jSONObject);
                                                                                    schemeModel22222222222222222222222.setPlayerCacheKey(str26);
                                                                                    schemeModel22222222222222222222222.setPlayerCacheCodeC(num);
                                                                                    schemeModel22222222222222222222222.setKabrSpts(str25);
                                                                                    schemeModel22222222222222222222222.setRtcHevcUrl(str24);
                                                                                    schemeModel22222222222222222222222.setCommonShareInfo(jSONObject12);
                                                                                    schemeModel22222222222222222222222.setMultiRate(jSONObject13);
                                                                                    schemeModel22222222222222222222222.setFromIntent(Boolean.TRUE);
                                                                                    schemeModel22222222222222222222222.setPlayRateSetting(i2);
                                                                                    schemeModel22222222222222222222222.setInterventions(i);
                                                                                    return schemeModel22222222222222222222222;
                                                                                }
                                                                                optJSONObject3 = jSONObject23.optJSONObject("queryECLive");
                                                                            } catch (Exception e40) {
                                                                                e = e40;
                                                                                JSONObject jSONObject28 = parseJSONObject5;
                                                                                String str51 = liveSource;
                                                                                str24 = optString4;
                                                                                jSONObject12 = jSONObject15;
                                                                                jSONObject13 = jSONObject18;
                                                                                str25 = str37;
                                                                                num = num2;
                                                                                str3 = optString9;
                                                                                jSONObject6 = parseJSONObject2;
                                                                                str12 = str42;
                                                                                jSONObject11 = jSONObject20;
                                                                                str13 = str40;
                                                                                jSONObject = parseJSONObject6;
                                                                                str14 = str41;
                                                                                str26 = optString7;
                                                                                i2 = optInt;
                                                                                str15 = optString10;
                                                                                str4 = str46;
                                                                                str6 = str47;
                                                                                str7 = str48;
                                                                                str8 = str29;
                                                                                str9 = str30;
                                                                                str10 = str31;
                                                                                str11 = str32;
                                                                                jSONObject8 = parseJSONObject3;
                                                                                jSONObject10 = parseJSONObject4;
                                                                                jSONObject9 = parseJSONObject8;
                                                                                jSONObject5 = parseJSONObject9;
                                                                                jSONObject2 = parseJSONObject10;
                                                                                str23 = optString20;
                                                                                str22 = optString;
                                                                                str21 = optString21;
                                                                                str20 = optString2;
                                                                                str19 = optString3;
                                                                                str18 = optString5;
                                                                                str17 = optString22;
                                                                                str16 = optString6;
                                                                                jSONObject7 = jSONObject28;
                                                                                str5 = str51;
                                                                                i = 0;
                                                                                jSONObject4 = null;
                                                                                jSONObject3 = null;
                                                                                e.printStackTrace();
                                                                                SchemeModel schemeModel222222222222222222222222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject11, jSONObject10, jSONObject9, jSONObject8, jSONObject7, str23, str22, jSONObject6, jSONObject5, jSONObject4, jSONObject3, str13, str14, str21, str20, str19, str18, jSONObject2, str17, str15, str16, jSONObject);
                                                                                schemeModel222222222222222222222222.setPlayerCacheKey(str26);
                                                                                schemeModel222222222222222222222222.setPlayerCacheCodeC(num);
                                                                                schemeModel222222222222222222222222.setKabrSpts(str25);
                                                                                schemeModel222222222222222222222222.setRtcHevcUrl(str24);
                                                                                schemeModel222222222222222222222222.setCommonShareInfo(jSONObject12);
                                                                                schemeModel222222222222222222222222.setMultiRate(jSONObject13);
                                                                                schemeModel222222222222222222222222.setFromIntent(Boolean.TRUE);
                                                                                schemeModel222222222222222222222222.setPlayRateSetting(i2);
                                                                                schemeModel222222222222222222222222.setInterventions(i);
                                                                                return schemeModel222222222222222222222222;
                                                                            }
                                                                            jSONObject16 = null;
                                                                            optJSONObject = jSONObject23.optJSONObject("vr");
                                                                            if (optJSONObject == null) {
                                                                            }
                                                                            jSONObject17 = optJSONObject;
                                                                            jSONObject18 = jSONObject16;
                                                                            jSONObject19 = jSONObject17;
                                                                            if (parseJSONObject != null) {
                                                                            }
                                                                            if (parseJSONObject5 != null) {
                                                                            }
                                                                            str42 = str35;
                                                                        } catch (Exception e41) {
                                                                            e = e41;
                                                                            num = valueOf;
                                                                            str24 = optString4;
                                                                            jSONObject12 = parseJSONObject11;
                                                                            str25 = optString23;
                                                                            str3 = optString9;
                                                                            jSONObject6 = parseJSONObject2;
                                                                            jSONObject = parseJSONObject6;
                                                                            str26 = optString7;
                                                                            jSONObject11 = parseJSONObject;
                                                                            i2 = optInt;
                                                                            str12 = str35;
                                                                            str13 = str12;
                                                                            str14 = str13;
                                                                            str15 = optString10;
                                                                            str4 = str46;
                                                                            str6 = str47;
                                                                            str7 = str48;
                                                                            str8 = str29;
                                                                            str9 = str30;
                                                                            str10 = str31;
                                                                            str11 = str32;
                                                                            jSONObject8 = parseJSONObject3;
                                                                            jSONObject10 = parseJSONObject4;
                                                                            jSONObject9 = parseJSONObject8;
                                                                            jSONObject5 = parseJSONObject9;
                                                                            jSONObject2 = parseJSONObject10;
                                                                            str23 = optString20;
                                                                            str22 = optString;
                                                                            str21 = optString21;
                                                                            str20 = optString2;
                                                                            str19 = optString3;
                                                                            str18 = optString5;
                                                                            str17 = optString22;
                                                                            str16 = optString6;
                                                                            jSONObject7 = parseJSONObject5;
                                                                            str5 = liveSource;
                                                                            jSONObject13 = null;
                                                                        }
                                                                    } catch (Exception e42) {
                                                                        e = e42;
                                                                        str25 = optString23;
                                                                        num = valueOf;
                                                                        jSONObject14 = parseJSONObject5;
                                                                        str36 = liveSource;
                                                                        i3 = optInt;
                                                                        str24 = optString4;
                                                                        str3 = optString9;
                                                                        jSONObject6 = parseJSONObject2;
                                                                        jSONObject = parseJSONObject6;
                                                                        str26 = optString7;
                                                                        jSONObject11 = parseJSONObject;
                                                                        i2 = i3;
                                                                        str12 = str35;
                                                                        str13 = str12;
                                                                        str14 = str13;
                                                                        str15 = optString10;
                                                                        str4 = str46;
                                                                        str6 = str47;
                                                                        str7 = str48;
                                                                        str8 = str29;
                                                                        str9 = str30;
                                                                        str10 = str31;
                                                                        str11 = str32;
                                                                        jSONObject8 = parseJSONObject3;
                                                                        jSONObject10 = parseJSONObject4;
                                                                        jSONObject9 = parseJSONObject8;
                                                                        jSONObject5 = parseJSONObject9;
                                                                        jSONObject2 = parseJSONObject10;
                                                                        str23 = optString20;
                                                                        str22 = optString;
                                                                        str21 = optString21;
                                                                        str20 = optString2;
                                                                        str19 = optString3;
                                                                        str18 = optString5;
                                                                        str17 = optString22;
                                                                        str16 = optString6;
                                                                        jSONObject7 = jSONObject14;
                                                                        str5 = str36;
                                                                        jSONObject13 = null;
                                                                        i = 0;
                                                                        jSONObject12 = null;
                                                                        jSONObject4 = null;
                                                                        jSONObject3 = null;
                                                                        e.printStackTrace();
                                                                        SchemeModel schemeModel2222222222222222222222222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject11, jSONObject10, jSONObject9, jSONObject8, jSONObject7, str23, str22, jSONObject6, jSONObject5, jSONObject4, jSONObject3, str13, str14, str21, str20, str19, str18, jSONObject2, str17, str15, str16, jSONObject);
                                                                        schemeModel2222222222222222222222222.setPlayerCacheKey(str26);
                                                                        schemeModel2222222222222222222222222.setPlayerCacheCodeC(num);
                                                                        schemeModel2222222222222222222222222.setKabrSpts(str25);
                                                                        schemeModel2222222222222222222222222.setRtcHevcUrl(str24);
                                                                        schemeModel2222222222222222222222222.setCommonShareInfo(jSONObject12);
                                                                        schemeModel2222222222222222222222222.setMultiRate(jSONObject13);
                                                                        schemeModel2222222222222222222222222.setFromIntent(Boolean.TRUE);
                                                                        schemeModel2222222222222222222222222.setPlayRateSetting(i2);
                                                                        schemeModel2222222222222222222222222.setInterventions(i);
                                                                        return schemeModel2222222222222222222222222;
                                                                    }
                                                                } catch (Exception e43) {
                                                                    e = e43;
                                                                    num = valueOf;
                                                                    str24 = optString4;
                                                                    str3 = optString9;
                                                                    jSONObject6 = parseJSONObject2;
                                                                    jSONObject = parseJSONObject6;
                                                                    str26 = optString7;
                                                                    jSONObject11 = parseJSONObject;
                                                                    str12 = str35;
                                                                    str13 = str12;
                                                                    str14 = str13;
                                                                    str15 = optString10;
                                                                    str4 = str46;
                                                                    str6 = str47;
                                                                    str7 = str48;
                                                                    str8 = str29;
                                                                    str9 = str30;
                                                                    str10 = str31;
                                                                    str11 = str32;
                                                                    jSONObject8 = parseJSONObject3;
                                                                    jSONObject10 = parseJSONObject4;
                                                                    jSONObject9 = parseJSONObject8;
                                                                    jSONObject5 = parseJSONObject9;
                                                                    jSONObject2 = parseJSONObject10;
                                                                    str23 = optString20;
                                                                    str22 = optString;
                                                                    str21 = optString21;
                                                                    str20 = optString2;
                                                                    str19 = optString3;
                                                                    str18 = optString5;
                                                                    str17 = optString22;
                                                                    str16 = optString6;
                                                                    jSONObject7 = parseJSONObject5;
                                                                    str5 = liveSource;
                                                                    jSONObject13 = null;
                                                                    i2 = 0;
                                                                    i = 0;
                                                                    str25 = null;
                                                                    jSONObject12 = null;
                                                                    jSONObject4 = null;
                                                                    jSONObject3 = null;
                                                                    e.printStackTrace();
                                                                    SchemeModel schemeModel22222222222222222222222222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject11, jSONObject10, jSONObject9, jSONObject8, jSONObject7, str23, str22, jSONObject6, jSONObject5, jSONObject4, jSONObject3, str13, str14, str21, str20, str19, str18, jSONObject2, str17, str15, str16, jSONObject);
                                                                    schemeModel22222222222222222222222222.setPlayerCacheKey(str26);
                                                                    schemeModel22222222222222222222222222.setPlayerCacheCodeC(num);
                                                                    schemeModel22222222222222222222222222.setKabrSpts(str25);
                                                                    schemeModel22222222222222222222222222.setRtcHevcUrl(str24);
                                                                    schemeModel22222222222222222222222222.setCommonShareInfo(jSONObject12);
                                                                    schemeModel22222222222222222222222222.setMultiRate(jSONObject13);
                                                                    schemeModel22222222222222222222222222.setFromIntent(Boolean.TRUE);
                                                                    schemeModel22222222222222222222222222.setPlayRateSetting(i2);
                                                                    schemeModel22222222222222222222222222.setInterventions(i);
                                                                    return schemeModel22222222222222222222222222;
                                                                }
                                                            } catch (Exception e44) {
                                                                e = e44;
                                                                str24 = optString4;
                                                                str3 = optString9;
                                                                jSONObject6 = parseJSONObject2;
                                                                jSONObject11 = parseJSONObject;
                                                                str12 = "";
                                                                str13 = str12;
                                                                str14 = str13;
                                                                str15 = optString10;
                                                                str4 = str46;
                                                                str6 = str47;
                                                                str7 = str48;
                                                                str8 = str29;
                                                                str9 = str30;
                                                                str10 = str31;
                                                                str11 = str32;
                                                                jSONObject8 = parseJSONObject3;
                                                                jSONObject10 = parseJSONObject4;
                                                                jSONObject9 = parseJSONObject8;
                                                                jSONObject5 = parseJSONObject9;
                                                                jSONObject2 = parseJSONObject10;
                                                                str23 = optString20;
                                                                str22 = optString;
                                                                str21 = optString21;
                                                                str20 = optString2;
                                                                str19 = optString3;
                                                                str18 = optString5;
                                                                jSONObject7 = parseJSONObject5;
                                                                str5 = liveSource;
                                                                jSONObject13 = null;
                                                                i2 = 0;
                                                                str26 = null;
                                                                i = 0;
                                                                num = null;
                                                                str25 = null;
                                                                jSONObject12 = null;
                                                                jSONObject4 = null;
                                                                jSONObject3 = null;
                                                                str17 = null;
                                                                str16 = null;
                                                                jSONObject = null;
                                                                e.printStackTrace();
                                                                SchemeModel schemeModel222222222222222222222222222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject11, jSONObject10, jSONObject9, jSONObject8, jSONObject7, str23, str22, jSONObject6, jSONObject5, jSONObject4, jSONObject3, str13, str14, str21, str20, str19, str18, jSONObject2, str17, str15, str16, jSONObject);
                                                                schemeModel222222222222222222222222222.setPlayerCacheKey(str26);
                                                                schemeModel222222222222222222222222222.setPlayerCacheCodeC(num);
                                                                schemeModel222222222222222222222222222.setKabrSpts(str25);
                                                                schemeModel222222222222222222222222222.setRtcHevcUrl(str24);
                                                                schemeModel222222222222222222222222222.setCommonShareInfo(jSONObject12);
                                                                schemeModel222222222222222222222222222.setMultiRate(jSONObject13);
                                                                schemeModel222222222222222222222222222.setFromIntent(Boolean.TRUE);
                                                                schemeModel222222222222222222222222222.setPlayRateSetting(i2);
                                                                schemeModel222222222222222222222222222.setInterventions(i);
                                                                return schemeModel222222222222222222222222222;
                                                            }
                                                        } catch (Exception e45) {
                                                            e = e45;
                                                            str3 = optString9;
                                                            jSONObject6 = parseJSONObject2;
                                                            jSONObject11 = parseJSONObject;
                                                            str12 = "";
                                                            str13 = str12;
                                                            str14 = str13;
                                                            str15 = optString10;
                                                            str4 = str46;
                                                            str6 = str47;
                                                            str7 = str48;
                                                            str8 = str29;
                                                            str9 = str30;
                                                            str10 = str31;
                                                            str11 = str32;
                                                            jSONObject8 = parseJSONObject3;
                                                            jSONObject10 = parseJSONObject4;
                                                            jSONObject9 = parseJSONObject8;
                                                            jSONObject5 = parseJSONObject9;
                                                            jSONObject2 = parseJSONObject10;
                                                            str23 = optString20;
                                                            str22 = optString;
                                                            jSONObject7 = parseJSONObject5;
                                                            str5 = liveSource;
                                                            jSONObject13 = null;
                                                            i2 = 0;
                                                            str26 = null;
                                                            i = 0;
                                                            num = null;
                                                            str25 = null;
                                                            str24 = null;
                                                            jSONObject12 = null;
                                                            jSONObject4 = null;
                                                            jSONObject3 = null;
                                                            str21 = null;
                                                            str20 = null;
                                                            str19 = null;
                                                            str18 = null;
                                                            str17 = null;
                                                            str16 = null;
                                                            jSONObject = null;
                                                            e.printStackTrace();
                                                            SchemeModel schemeModel2222222222222222222222222222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject11, jSONObject10, jSONObject9, jSONObject8, jSONObject7, str23, str22, jSONObject6, jSONObject5, jSONObject4, jSONObject3, str13, str14, str21, str20, str19, str18, jSONObject2, str17, str15, str16, jSONObject);
                                                            schemeModel2222222222222222222222222222.setPlayerCacheKey(str26);
                                                            schemeModel2222222222222222222222222222.setPlayerCacheCodeC(num);
                                                            schemeModel2222222222222222222222222222.setKabrSpts(str25);
                                                            schemeModel2222222222222222222222222222.setRtcHevcUrl(str24);
                                                            schemeModel2222222222222222222222222222.setCommonShareInfo(jSONObject12);
                                                            schemeModel2222222222222222222222222222.setMultiRate(jSONObject13);
                                                            schemeModel2222222222222222222222222222.setFromIntent(Boolean.TRUE);
                                                            schemeModel2222222222222222222222222222.setPlayRateSetting(i2);
                                                            schemeModel2222222222222222222222222222.setInterventions(i);
                                                            return schemeModel2222222222222222222222222222;
                                                        }
                                                    } catch (Exception e46) {
                                                        e = e46;
                                                        str3 = optString9;
                                                        jSONObject6 = parseJSONObject2;
                                                        jSONObject11 = parseJSONObject;
                                                        str12 = "";
                                                        str13 = str12;
                                                        str14 = str13;
                                                        str15 = optString10;
                                                        str4 = str46;
                                                        str6 = str47;
                                                        str7 = str48;
                                                        str8 = str29;
                                                        str9 = str30;
                                                        str10 = str31;
                                                        str11 = str32;
                                                        jSONObject8 = parseJSONObject3;
                                                        jSONObject10 = parseJSONObject4;
                                                        jSONObject9 = parseJSONObject8;
                                                        jSONObject5 = parseJSONObject9;
                                                        jSONObject2 = parseJSONObject10;
                                                        jSONObject7 = parseJSONObject5;
                                                        str5 = liveSource;
                                                        jSONObject13 = null;
                                                        i2 = 0;
                                                        str26 = null;
                                                        i = 0;
                                                        num = null;
                                                        str25 = null;
                                                        str24 = null;
                                                        jSONObject12 = null;
                                                        str23 = null;
                                                    }
                                                } catch (Exception e47) {
                                                    e = e47;
                                                    str3 = optString9;
                                                    jSONObject6 = parseJSONObject2;
                                                    jSONObject11 = parseJSONObject;
                                                    str12 = "";
                                                    str13 = str12;
                                                    str14 = str13;
                                                    str15 = optString10;
                                                    str4 = str46;
                                                    str6 = str47;
                                                    str7 = str48;
                                                    str8 = str29;
                                                    str9 = str30;
                                                    str10 = str31;
                                                    str11 = str32;
                                                    jSONObject8 = parseJSONObject3;
                                                    jSONObject10 = parseJSONObject4;
                                                    jSONObject9 = parseJSONObject8;
                                                    jSONObject5 = parseJSONObject9;
                                                    jSONObject7 = parseJSONObject5;
                                                    str5 = liveSource;
                                                    jSONObject13 = null;
                                                    i2 = 0;
                                                    str26 = null;
                                                    i = 0;
                                                    num = null;
                                                    str25 = null;
                                                    str24 = null;
                                                    jSONObject12 = null;
                                                    str23 = null;
                                                    str22 = null;
                                                    jSONObject4 = null;
                                                    jSONObject3 = null;
                                                    str21 = null;
                                                    str20 = null;
                                                    str19 = null;
                                                    str18 = null;
                                                    jSONObject2 = null;
                                                    str17 = null;
                                                    str16 = null;
                                                    jSONObject = null;
                                                    e.printStackTrace();
                                                    SchemeModel schemeModel22222222222222222222222222222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject11, jSONObject10, jSONObject9, jSONObject8, jSONObject7, str23, str22, jSONObject6, jSONObject5, jSONObject4, jSONObject3, str13, str14, str21, str20, str19, str18, jSONObject2, str17, str15, str16, jSONObject);
                                                    schemeModel22222222222222222222222222222.setPlayerCacheKey(str26);
                                                    schemeModel22222222222222222222222222222.setPlayerCacheCodeC(num);
                                                    schemeModel22222222222222222222222222222.setKabrSpts(str25);
                                                    schemeModel22222222222222222222222222222.setRtcHevcUrl(str24);
                                                    schemeModel22222222222222222222222222222.setCommonShareInfo(jSONObject12);
                                                    schemeModel22222222222222222222222222222.setMultiRate(jSONObject13);
                                                    schemeModel22222222222222222222222222222.setFromIntent(Boolean.TRUE);
                                                    schemeModel22222222222222222222222222222.setPlayRateSetting(i2);
                                                    schemeModel22222222222222222222222222222.setInterventions(i);
                                                    return schemeModel22222222222222222222222222222;
                                                }
                                            } catch (Exception e48) {
                                                e = e48;
                                                str3 = optString9;
                                                jSONObject6 = parseJSONObject2;
                                                jSONObject11 = parseJSONObject;
                                                str12 = "";
                                                str13 = str12;
                                                str14 = str13;
                                                str15 = optString10;
                                                str4 = str46;
                                                str6 = str47;
                                                str7 = str48;
                                                str8 = str29;
                                                str9 = str30;
                                                str10 = str31;
                                                str11 = str32;
                                                jSONObject8 = parseJSONObject3;
                                                jSONObject10 = parseJSONObject4;
                                                jSONObject9 = parseJSONObject8;
                                                jSONObject7 = parseJSONObject5;
                                                str5 = liveSource;
                                                jSONObject13 = null;
                                                i2 = 0;
                                                str26 = null;
                                                i = 0;
                                                num = null;
                                                str25 = null;
                                                str24 = null;
                                                jSONObject12 = null;
                                                str23 = null;
                                                str22 = null;
                                                jSONObject5 = null;
                                                jSONObject4 = null;
                                                jSONObject3 = null;
                                                str21 = null;
                                                str20 = null;
                                                str19 = null;
                                                str18 = null;
                                                jSONObject2 = null;
                                                str17 = null;
                                                str16 = null;
                                                jSONObject = null;
                                                e.printStackTrace();
                                                SchemeModel schemeModel222222222222222222222222222222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject11, jSONObject10, jSONObject9, jSONObject8, jSONObject7, str23, str22, jSONObject6, jSONObject5, jSONObject4, jSONObject3, str13, str14, str21, str20, str19, str18, jSONObject2, str17, str15, str16, jSONObject);
                                                schemeModel222222222222222222222222222222.setPlayerCacheKey(str26);
                                                schemeModel222222222222222222222222222222.setPlayerCacheCodeC(num);
                                                schemeModel222222222222222222222222222222.setKabrSpts(str25);
                                                schemeModel222222222222222222222222222222.setRtcHevcUrl(str24);
                                                schemeModel222222222222222222222222222222.setCommonShareInfo(jSONObject12);
                                                schemeModel222222222222222222222222222222.setMultiRate(jSONObject13);
                                                schemeModel222222222222222222222222222222.setFromIntent(Boolean.TRUE);
                                                schemeModel222222222222222222222222222222.setPlayRateSetting(i2);
                                                schemeModel222222222222222222222222222222.setInterventions(i);
                                                return schemeModel222222222222222222222222222222;
                                            }
                                        } catch (Exception e49) {
                                            e = e49;
                                            str3 = optString9;
                                            jSONObject6 = parseJSONObject2;
                                            jSONObject11 = parseJSONObject;
                                            str12 = "";
                                            str13 = str12;
                                            str14 = str13;
                                            str15 = optString10;
                                            str4 = str46;
                                            str6 = str47;
                                            str7 = str48;
                                            str8 = str29;
                                            str9 = str30;
                                            str10 = str31;
                                            str11 = str32;
                                            jSONObject8 = parseJSONObject3;
                                            jSONObject10 = parseJSONObject4;
                                            str5 = liveSource;
                                            jSONObject13 = null;
                                            i2 = 0;
                                            str26 = null;
                                            i = 0;
                                            num = null;
                                            str25 = null;
                                            str24 = null;
                                            jSONObject12 = null;
                                            jSONObject9 = null;
                                            jSONObject7 = null;
                                            str23 = null;
                                            str22 = null;
                                            jSONObject5 = null;
                                            jSONObject4 = null;
                                            jSONObject3 = null;
                                            str21 = null;
                                            str20 = null;
                                            str19 = null;
                                            str18 = null;
                                            jSONObject2 = null;
                                            str17 = null;
                                            str16 = null;
                                            jSONObject = null;
                                            e.printStackTrace();
                                            SchemeModel schemeModel2222222222222222222222222222222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject11, jSONObject10, jSONObject9, jSONObject8, jSONObject7, str23, str22, jSONObject6, jSONObject5, jSONObject4, jSONObject3, str13, str14, str21, str20, str19, str18, jSONObject2, str17, str15, str16, jSONObject);
                                            schemeModel2222222222222222222222222222222.setPlayerCacheKey(str26);
                                            schemeModel2222222222222222222222222222222.setPlayerCacheCodeC(num);
                                            schemeModel2222222222222222222222222222222.setKabrSpts(str25);
                                            schemeModel2222222222222222222222222222222.setRtcHevcUrl(str24);
                                            schemeModel2222222222222222222222222222222.setCommonShareInfo(jSONObject12);
                                            schemeModel2222222222222222222222222222222.setMultiRate(jSONObject13);
                                            schemeModel2222222222222222222222222222222.setFromIntent(Boolean.TRUE);
                                            schemeModel2222222222222222222222222222222.setPlayRateSetting(i2);
                                            schemeModel2222222222222222222222222222222.setInterventions(i);
                                            return schemeModel2222222222222222222222222222222;
                                        }
                                    } catch (Exception e50) {
                                        e = e50;
                                        str28 = liveSource;
                                        str3 = optString9;
                                        str7 = "";
                                        str8 = str7;
                                        str9 = str8;
                                        str10 = str9;
                                        str11 = str10;
                                        str12 = str11;
                                        str13 = str12;
                                        str14 = str13;
                                        str15 = optString10;
                                        str4 = str46;
                                        str6 = str47;
                                    }
                                } catch (Exception e51) {
                                    e = e51;
                                    str28 = liveSource;
                                    str3 = optString9;
                                    str6 = "";
                                    str7 = str6;
                                    str8 = str7;
                                    str9 = str8;
                                    str10 = str9;
                                    str11 = str10;
                                    str12 = str11;
                                    str13 = str12;
                                    str14 = str13;
                                    str15 = optString10;
                                    str4 = str46;
                                }
                            } catch (Exception e52) {
                                e = e52;
                                str3 = optString9;
                                str5 = "";
                                str6 = str5;
                                str7 = str6;
                                str8 = str7;
                                str9 = str8;
                                str10 = str9;
                                str11 = str10;
                                str12 = str11;
                                str13 = str12;
                                str14 = str13;
                                str15 = optString10;
                                str4 = str46;
                            }
                        } catch (Exception e53) {
                            e = e53;
                            str3 = optString9;
                            str4 = "";
                            str5 = str4;
                            str6 = str5;
                            str7 = str6;
                            str8 = str7;
                            str9 = str8;
                            str10 = str9;
                            str11 = str10;
                            str12 = str11;
                            str13 = str12;
                            str14 = str13;
                            str15 = optString10;
                        }
                    } catch (Exception e54) {
                        e = e54;
                        str27 = "";
                        str3 = optString9;
                        str4 = str27;
                        str5 = str4;
                        str6 = str5;
                        str7 = str6;
                        str8 = str7;
                        str9 = str8;
                        str10 = str9;
                        str11 = str10;
                        str12 = str11;
                        str13 = str12;
                        str14 = str13;
                        str15 = str14;
                        jSONObject13 = null;
                        i2 = 0;
                        str26 = null;
                        i = 0;
                        num = null;
                        str25 = null;
                        str24 = null;
                        jSONObject12 = null;
                        jSONObject11 = null;
                        jSONObject10 = null;
                        jSONObject9 = null;
                        jSONObject8 = null;
                        jSONObject7 = null;
                        str23 = null;
                        str22 = null;
                        jSONObject6 = null;
                        jSONObject5 = null;
                        jSONObject4 = null;
                        jSONObject3 = null;
                        str21 = null;
                        str20 = null;
                        str19 = null;
                        str18 = null;
                        jSONObject2 = null;
                        str17 = null;
                        str16 = null;
                        jSONObject = null;
                        e.printStackTrace();
                        SchemeModel schemeModel22222222222222222222222222222222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject11, jSONObject10, jSONObject9, jSONObject8, jSONObject7, str23, str22, jSONObject6, jSONObject5, jSONObject4, jSONObject3, str13, str14, str21, str20, str19, str18, jSONObject2, str17, str15, str16, jSONObject);
                        schemeModel22222222222222222222222222222222.setPlayerCacheKey(str26);
                        schemeModel22222222222222222222222222222222.setPlayerCacheCodeC(num);
                        schemeModel22222222222222222222222222222222.setKabrSpts(str25);
                        schemeModel22222222222222222222222222222222.setRtcHevcUrl(str24);
                        schemeModel22222222222222222222222222222222.setCommonShareInfo(jSONObject12);
                        schemeModel22222222222222222222222222222222.setMultiRate(jSONObject13);
                        schemeModel22222222222222222222222222222222.setFromIntent(Boolean.TRUE);
                        schemeModel22222222222222222222222222222222.setPlayRateSetting(i2);
                        schemeModel22222222222222222222222222222222.setInterventions(i);
                        return schemeModel22222222222222222222222222222222;
                    }
                } catch (Exception e55) {
                    e = e55;
                    str27 = "";
                    str3 = optString9;
                }
            } catch (Exception e56) {
                e = e56;
                str3 = "";
                str4 = str3;
            }
        }

        public Companion() {
        }

        public final boolean getBanQuestionFromSearchDialog() {
            return IntentData.banQuestionFromSearchDialog;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getLiveSource(String str) {
            try {
                String optString = new JSONObject(str).optString("livesource");
                Intrinsics.checkExpressionValueIsNotNull(optString, "json.optString(\"livesource\")");
                return optString;
            } catch (JSONException unused) {
                return str;
            }
        }

        public final SchemeModel parseSchemeData(String str) {
            return parseSchemeData(str, null);
        }

        public final void setBanQuestionFromSearchDialog(boolean z) {
            IntentData.banQuestionFromSearchDialog = z;
        }
    }

    public static /* synthetic */ IntentData copy$default(IntentData intentData, String str, String str2, String str3, SchemeModel schemeModel, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = intentData.id;
        }
        if ((i & 2) != 0) {
            str2 = intentData.source;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = intentData.scheme;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            schemeModel = intentData.model;
        }
        SchemeModel schemeModel2 = schemeModel;
        if ((i & 16) != 0) {
            str4 = intentData.tpl;
        }
        String str8 = str4;
        if ((i & 32) != 0) {
            str5 = intentData.extReq;
        }
        return intentData.copy(str, str6, str7, schemeModel2, str8, str5);
    }

    @Deprecated(message = "使用int值来表示更多状态，这里代码不删是兼容老插件")
    public static /* synthetic */ void translucent$annotations() {
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.source;
    }

    public final String component3() {
        return this.scheme;
    }

    public final SchemeModel component4() {
        return this.model;
    }

    public final String component5() {
        return this.tpl;
    }

    public final String component6() {
        return this.extReq;
    }

    public final IntentData copy(String str, String str2, String str3, SchemeModel schemeModel, String str4, String str5) {
        return new IntentData(str, str2, str3, schemeModel, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof IntentData) {
                IntentData intentData = (IntentData) obj;
                return Intrinsics.areEqual(this.id, intentData.id) && Intrinsics.areEqual(this.source, intentData.source) && Intrinsics.areEqual(this.scheme, intentData.scheme) && Intrinsics.areEqual(this.model, intentData.model) && Intrinsics.areEqual(this.tpl, intentData.tpl) && Intrinsics.areEqual(this.extReq, intentData.extReq);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.id;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.source;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.scheme;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        SchemeModel schemeModel = this.model;
        int hashCode4 = (hashCode3 + (schemeModel != null ? schemeModel.hashCode() : 0)) * 31;
        String str4 = this.tpl;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.extReq;
        return hashCode5 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "IntentData(id=" + this.id + ", source=" + this.source + ", scheme=" + this.scheme + ", model=" + this.model + ", tpl=" + this.tpl + ", extReq=" + this.extReq + SmallTailInfo.EMOTION_SUFFIX;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bA\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\\\b\u0086\b\u0018\u0000Bó\u0002\u0012\u0006\u0010%\u001a\u00020\u0001\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010'\u001a\u00020\u0001\u0012\b\b\u0002\u0010(\u001a\u00020\u0001\u0012\b\b\u0002\u0010)\u001a\u00020\u0001\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010-\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u0005¢\u0006\u0006\b¦\u0001\u0010§\u0001J\u0010\u0010\u0002\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0003J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\f\u0010\u0003J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\r\u0010\u0003J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0007J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0007J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0003J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0007J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0007J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0003J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0003J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0003J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0003J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0003J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0003J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0007J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0003J\u0010\u0010\u001b\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0003J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0003J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0003J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0007J\u0010\u0010\u001f\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0003J\u0010\u0010 \u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b \u0010\u0003J\u0012\u0010!\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b!\u0010\u0003J\u0012\u0010\"\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\"\u0010\u0003J\u0012\u0010#\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b#\u0010\u0003J\u0012\u0010$\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b$\u0010\u0003J\u0088\u0003\u0010E\u001a\u00020\u00002\b\b\u0002\u0010%\u001a\u00020\u00012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010'\u001a\u00020\u00012\b\b\u0002\u0010(\u001a\u00020\u00012\b\b\u0002\u0010)\u001a\u00020\u00012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\bE\u0010FJ\u001a\u0010J\u001a\u00020I2\b\u0010H\u001a\u0004\u0018\u00010GHÖ\u0003¢\u0006\u0004\bJ\u0010KJ\u0010\u0010M\u001a\u00020LHÖ\u0001¢\u0006\u0004\bM\u0010NJ\r\u0010O\u001a\u00020\u0001¢\u0006\u0004\bO\u0010\u0003J\u0010\u0010P\u001a\u00020\u0001HÖ\u0001¢\u0006\u0004\bP\u0010\u0003R\u001b\u00104\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010Q\u001a\u0004\bR\u0010\u0003R\u001b\u0010<\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010Q\u001a\u0004\bS\u0010\u0003R$\u0010T\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010\u0007\"\u0004\bW\u0010XR\u0019\u0010(\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010Q\u001a\u0004\bY\u0010\u0003R\u001b\u0010/\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010U\u001a\u0004\bZ\u0010\u0007R\u001b\u00101\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010U\u001a\u0004\b[\u0010\u0007R\u001b\u00103\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010U\u001a\u0004\b\\\u0010\u0007R\u001b\u00100\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010U\u001a\u0004\b]\u0010\u0007R\u001b\u0010+\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010Q\u001a\u0004\b^\u0010\u0003R$\u0010_\u001a\u0004\u0018\u00010I8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u001b\u0010=\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010Q\u001a\u0004\be\u0010\u0003R\u001b\u0010C\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010Q\u001a\u0004\bf\u0010\u0003R$\u00109\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010U\u001a\u0004\bg\u0010\u0007\"\u0004\bh\u0010XR\"\u0010i\u001a\u00020L8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bi\u0010j\u001a\u0004\bk\u0010N\"\u0004\bl\u0010mR$\u0010D\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010U\u001a\u0004\bn\u0010\u0007\"\u0004\bo\u0010XR\u001b\u0010B\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\bB\u0010Q\u001a\u0004\bp\u0010\u0003R$\u00107\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010U\u001a\u0004\bq\u0010\u0007\"\u0004\br\u0010XR$\u0010s\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bs\u0010Q\u001a\u0004\bt\u0010\u0003\"\u0004\bu\u0010vR$\u0010.\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010Q\u001a\u0004\bw\u0010\u0003\"\u0004\bx\u0010vR$\u0010y\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\by\u0010U\u001a\u0004\bz\u0010\u0007\"\u0004\b{\u0010XR$\u00106\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u0010U\u001a\u0004\b|\u0010\u0007\"\u0004\b}\u0010XR#\u0010~\u001a\u00020L8\u0006@\u0006X\u0086\u000e¢\u0006\u0013\n\u0004\b~\u0010j\u001a\u0004\b\u007f\u0010N\"\u0005\b\u0080\u0001\u0010mR\u001a\u0010)\u001a\u00020\u00018\u0006@\u0006¢\u0006\r\n\u0004\b)\u0010Q\u001a\u0005\b\u0081\u0001\u0010\u0003R+\u0010\u0082\u0001\u001a\u0004\u0018\u00010L8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001\"\u0006\b\u0086\u0001\u0010\u0087\u0001R(\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0088\u0001\u0010Q\u001a\u0005\b\u0089\u0001\u0010\u0003\"\u0005\b\u008a\u0001\u0010vR&\u00102\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b2\u0010U\u001a\u0005\b\u008b\u0001\u0010\u0007\"\u0005\b\u008c\u0001\u0010XR\u001c\u0010A\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\r\n\u0004\bA\u0010Q\u001a\u0005\b\u008d\u0001\u0010\u0003R\u001a\u0010%\u001a\u00020\u00018\u0006@\u0006¢\u0006\r\n\u0004\b%\u0010Q\u001a\u0005\b\u008e\u0001\u0010\u0003R&\u0010&\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b&\u0010Q\u001a\u0005\b\u008f\u0001\u0010\u0003\"\u0005\b\u0090\u0001\u0010vR(\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0091\u0001\u0010Q\u001a\u0005\b\u0092\u0001\u0010\u0003\"\u0005\b\u0093\u0001\u0010vR\u001c\u0010>\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\r\n\u0004\b>\u0010Q\u001a\u0005\b\u0094\u0001\u0010\u0003R\u001c\u0010,\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\r\n\u0004\b,\u0010Q\u001a\u0005\b\u0095\u0001\u0010\u0003R&\u00108\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b8\u0010U\u001a\u0005\b\u0096\u0001\u0010\u0007\"\u0005\b\u0097\u0001\u0010XR&\u0010;\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b;\u0010Q\u001a\u0005\b\u0098\u0001\u0010\u0003\"\u0005\b\u0099\u0001\u0010vR\u001c\u0010@\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\r\n\u0004\b@\u0010U\u001a\u0005\b\u009a\u0001\u0010\u0007R&\u0010:\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b:\u0010Q\u001a\u0005\b\u009b\u0001\u0010\u0003\"\u0005\b\u009c\u0001\u0010vR\u001a\u0010'\u001a\u00020\u00018\u0006@\u0006¢\u0006\r\n\u0004\b'\u0010Q\u001a\u0005\b\u009d\u0001\u0010\u0003R\u001c\u0010*\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\r\n\u0004\b*\u0010Q\u001a\u0005\b\u009e\u0001\u0010\u0003R\u001c\u0010-\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\r\n\u0004\b-\u0010Q\u001a\u0005\b\u009f\u0001\u0010\u0003R&\u00105\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b5\u0010Q\u001a\u0005\b \u0001\u0010\u0003\"\u0005\b¡\u0001\u0010vR\u001c\u0010?\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\r\n\u0004\b?\u0010Q\u001a\u0005\b¢\u0001\u0010\u0003R(\u0010£\u0001\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b£\u0001\u0010U\u001a\u0005\b¤\u0001\u0010\u0007\"\u0005\b¥\u0001\u0010X¨\u0006¨\u0001"}, d2 = {"Lcom/baidu/searchbox/live/frame/IntentData$SchemeModel;", "", "component1", "()Ljava/lang/String;", "component10", "Lorg/json/JSONObject;", "component11", "()Lorg/json/JSONObject;", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component4", "component5", "component6", "component7", "component8", "component9", "roomId", "roomType", "source", AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, "playUrl", "status", "format", "screen", MediaTrackConfig.AE_IMPORT_TEMPLATE, "liveBackScheme", "ext", "extRequest", "extLog", "query", "extParams", "askId", "templateId", "otherParams", "invokePop", "searchIntoLiveJson", "hlReplyIntoLive", "shareUid", "shareTag", "avcUrl", "hevcUrl", "rtcUrl", "title", "shareTaskInfo", "quic", "inviterId", "highlightUrl", "introduceTips", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)Lcom/baidu/searchbox/live/frame/IntentData$SchemeModel;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toSchemeParams", "toString", "Ljava/lang/String;", "getAskId", "getAvcUrl", "commonShareInfo", "Lorg/json/JSONObject;", "getCommonShareInfo", "setCommonShareInfo", "(Lorg/json/JSONObject;)V", "getCover", "getExt", "getExtLog", "getExtParams", "getExtRequest", "getFormat", "fromIntent", "Ljava/lang/Boolean;", "getFromIntent", "()Ljava/lang/Boolean;", "setFromIntent", "(Ljava/lang/Boolean;)V", "getHevcUrl", "getHighlightUrl", "getHlReplyIntoLive", "setHlReplyIntoLive", "interventions", "I", "getInterventions", "setInterventions", "(I)V", "getIntroduceTips", "setIntroduceTips", "getInviterId", "getInvokePop", "setInvokePop", "kabrSpts", "getKabrSpts", "setKabrSpts", "(Ljava/lang/String;)V", "getLiveBackScheme", "setLiveBackScheme", "multiRate", "getMultiRate", "setMultiRate", "getOtherParams", "setOtherParams", "playRateSetting", "getPlayRateSetting", "setPlayRateSetting", "getPlayUrl", "playerCacheCodeC", "Ljava/lang/Integer;", "getPlayerCacheCodeC", "()Ljava/lang/Integer;", "setPlayerCacheCodeC", "(Ljava/lang/Integer;)V", "playerCacheKey", "getPlayerCacheKey", "setPlayerCacheKey", "getQuery", "setQuery", "getQuic", "getRoomId", "getRoomType", "setRoomType", "rtcHevcUrl", "getRtcHevcUrl", "setRtcHevcUrl", "getRtcUrl", "getScreen", "getSearchIntoLiveJson", "setSearchIntoLiveJson", "getShareTag", "setShareTag", "getShareTaskInfo", "getShareUid", "setShareUid", "getSource", "getStatus", "getTemplate", "getTemplateId", "setTemplateId", "getTitle", "vrParams", "getVrParams", "setVrParams", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class SchemeModel {
        public final String askId;
        public final String avcUrl;
        public JSONObject commonShareInfo;
        public final String cover;
        public final JSONObject ext;
        public final JSONObject extLog;
        public final JSONObject extParams;
        public final JSONObject extRequest;
        public final String format;
        public Boolean fromIntent;
        public final String hevcUrl;
        public final String highlightUrl;
        public JSONObject hlReplyIntoLive;
        public int interventions;
        public JSONObject introduceTips;
        public final String inviterId;
        public JSONObject invokePop;
        public String kabrSpts;
        public String liveBackScheme;
        public JSONObject multiRate;
        public JSONObject otherParams;
        public int playRateSetting;
        public final String playUrl;
        public Integer playerCacheCodeC;
        public String playerCacheKey;
        public JSONObject query;
        public final String quic;
        public final String roomId;
        public String roomType;
        public String rtcHevcUrl;
        public final String rtcUrl;
        public final String screen;
        public JSONObject searchIntoLiveJson;
        public String shareTag;
        public final JSONObject shareTaskInfo;
        public String shareUid;
        public final String source;
        public final String status;
        public final String template;
        public String templateId;
        public final String title;
        public JSONObject vrParams;

        public final String component1() {
            return this.roomId;
        }

        public final String component10() {
            return this.liveBackScheme;
        }

        public final JSONObject component11() {
            return this.ext;
        }

        public final JSONObject component12() {
            return this.extRequest;
        }

        public final JSONObject component13() {
            return this.extLog;
        }

        public final JSONObject component14() {
            return this.query;
        }

        public final JSONObject component15() {
            return this.extParams;
        }

        public final String component16() {
            return this.askId;
        }

        public final String component17() {
            return this.templateId;
        }

        public final JSONObject component18() {
            return this.otherParams;
        }

        public final JSONObject component19() {
            return this.invokePop;
        }

        public final String component2() {
            return this.roomType;
        }

        public final JSONObject component20() {
            return this.searchIntoLiveJson;
        }

        public final JSONObject component21() {
            return this.hlReplyIntoLive;
        }

        public final String component22() {
            return this.shareUid;
        }

        public final String component23() {
            return this.shareTag;
        }

        public final String component24() {
            return this.avcUrl;
        }

        public final String component25() {
            return this.hevcUrl;
        }

        public final String component26() {
            return this.rtcUrl;
        }

        public final String component27() {
            return this.title;
        }

        public final JSONObject component28() {
            return this.shareTaskInfo;
        }

        public final String component29() {
            return this.quic;
        }

        public final String component3() {
            return this.source;
        }

        public final String component30() {
            return this.inviterId;
        }

        public final String component31() {
            return this.highlightUrl;
        }

        public final JSONObject component32() {
            return this.introduceTips;
        }

        public final String component4() {
            return this.cover;
        }

        public final String component5() {
            return this.playUrl;
        }

        public final String component6() {
            return this.status;
        }

        public final String component7() {
            return this.format;
        }

        public final String component8() {
            return this.screen;
        }

        public final String component9() {
            return this.template;
        }

        public final SchemeModel copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5, String str11, String str12, JSONObject jSONObject6, JSONObject jSONObject7, JSONObject jSONObject8, JSONObject jSONObject9, String str13, String str14, String str15, String str16, String str17, String str18, JSONObject jSONObject10, String str19, String str20, String str21, JSONObject jSONObject11) {
            return new SchemeModel(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, jSONObject, jSONObject2, jSONObject3, jSONObject4, jSONObject5, str11, str12, jSONObject6, jSONObject7, jSONObject8, jSONObject9, str13, str14, str15, str16, str17, str18, jSONObject10, str19, str20, str21, jSONObject11);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof SchemeModel) {
                    SchemeModel schemeModel = (SchemeModel) obj;
                    return Intrinsics.areEqual(this.roomId, schemeModel.roomId) && Intrinsics.areEqual(this.roomType, schemeModel.roomType) && Intrinsics.areEqual(this.source, schemeModel.source) && Intrinsics.areEqual(this.cover, schemeModel.cover) && Intrinsics.areEqual(this.playUrl, schemeModel.playUrl) && Intrinsics.areEqual(this.status, schemeModel.status) && Intrinsics.areEqual(this.format, schemeModel.format) && Intrinsics.areEqual(this.screen, schemeModel.screen) && Intrinsics.areEqual(this.template, schemeModel.template) && Intrinsics.areEqual(this.liveBackScheme, schemeModel.liveBackScheme) && Intrinsics.areEqual(this.ext, schemeModel.ext) && Intrinsics.areEqual(this.extRequest, schemeModel.extRequest) && Intrinsics.areEqual(this.extLog, schemeModel.extLog) && Intrinsics.areEqual(this.query, schemeModel.query) && Intrinsics.areEqual(this.extParams, schemeModel.extParams) && Intrinsics.areEqual(this.askId, schemeModel.askId) && Intrinsics.areEqual(this.templateId, schemeModel.templateId) && Intrinsics.areEqual(this.otherParams, schemeModel.otherParams) && Intrinsics.areEqual(this.invokePop, schemeModel.invokePop) && Intrinsics.areEqual(this.searchIntoLiveJson, schemeModel.searchIntoLiveJson) && Intrinsics.areEqual(this.hlReplyIntoLive, schemeModel.hlReplyIntoLive) && Intrinsics.areEqual(this.shareUid, schemeModel.shareUid) && Intrinsics.areEqual(this.shareTag, schemeModel.shareTag) && Intrinsics.areEqual(this.avcUrl, schemeModel.avcUrl) && Intrinsics.areEqual(this.hevcUrl, schemeModel.hevcUrl) && Intrinsics.areEqual(this.rtcUrl, schemeModel.rtcUrl) && Intrinsics.areEqual(this.title, schemeModel.title) && Intrinsics.areEqual(this.shareTaskInfo, schemeModel.shareTaskInfo) && Intrinsics.areEqual(this.quic, schemeModel.quic) && Intrinsics.areEqual(this.inviterId, schemeModel.inviterId) && Intrinsics.areEqual(this.highlightUrl, schemeModel.highlightUrl) && Intrinsics.areEqual(this.introduceTips, schemeModel.introduceTips);
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            String str = this.roomId;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.roomType;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.source;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.cover;
            int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.playUrl;
            int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
            String str6 = this.status;
            int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
            String str7 = this.format;
            int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
            String str8 = this.screen;
            int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
            String str9 = this.template;
            int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
            String str10 = this.liveBackScheme;
            int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
            JSONObject jSONObject = this.ext;
            int hashCode11 = (hashCode10 + (jSONObject != null ? jSONObject.hashCode() : 0)) * 31;
            JSONObject jSONObject2 = this.extRequest;
            int hashCode12 = (hashCode11 + (jSONObject2 != null ? jSONObject2.hashCode() : 0)) * 31;
            JSONObject jSONObject3 = this.extLog;
            int hashCode13 = (hashCode12 + (jSONObject3 != null ? jSONObject3.hashCode() : 0)) * 31;
            JSONObject jSONObject4 = this.query;
            int hashCode14 = (hashCode13 + (jSONObject4 != null ? jSONObject4.hashCode() : 0)) * 31;
            JSONObject jSONObject5 = this.extParams;
            int hashCode15 = (hashCode14 + (jSONObject5 != null ? jSONObject5.hashCode() : 0)) * 31;
            String str11 = this.askId;
            int hashCode16 = (hashCode15 + (str11 != null ? str11.hashCode() : 0)) * 31;
            String str12 = this.templateId;
            int hashCode17 = (hashCode16 + (str12 != null ? str12.hashCode() : 0)) * 31;
            JSONObject jSONObject6 = this.otherParams;
            int hashCode18 = (hashCode17 + (jSONObject6 != null ? jSONObject6.hashCode() : 0)) * 31;
            JSONObject jSONObject7 = this.invokePop;
            int hashCode19 = (hashCode18 + (jSONObject7 != null ? jSONObject7.hashCode() : 0)) * 31;
            JSONObject jSONObject8 = this.searchIntoLiveJson;
            int hashCode20 = (hashCode19 + (jSONObject8 != null ? jSONObject8.hashCode() : 0)) * 31;
            JSONObject jSONObject9 = this.hlReplyIntoLive;
            int hashCode21 = (hashCode20 + (jSONObject9 != null ? jSONObject9.hashCode() : 0)) * 31;
            String str13 = this.shareUid;
            int hashCode22 = (hashCode21 + (str13 != null ? str13.hashCode() : 0)) * 31;
            String str14 = this.shareTag;
            int hashCode23 = (hashCode22 + (str14 != null ? str14.hashCode() : 0)) * 31;
            String str15 = this.avcUrl;
            int hashCode24 = (hashCode23 + (str15 != null ? str15.hashCode() : 0)) * 31;
            String str16 = this.hevcUrl;
            int hashCode25 = (hashCode24 + (str16 != null ? str16.hashCode() : 0)) * 31;
            String str17 = this.rtcUrl;
            int hashCode26 = (hashCode25 + (str17 != null ? str17.hashCode() : 0)) * 31;
            String str18 = this.title;
            int hashCode27 = (hashCode26 + (str18 != null ? str18.hashCode() : 0)) * 31;
            JSONObject jSONObject10 = this.shareTaskInfo;
            int hashCode28 = (hashCode27 + (jSONObject10 != null ? jSONObject10.hashCode() : 0)) * 31;
            String str19 = this.quic;
            int hashCode29 = (hashCode28 + (str19 != null ? str19.hashCode() : 0)) * 31;
            String str20 = this.inviterId;
            int hashCode30 = (hashCode29 + (str20 != null ? str20.hashCode() : 0)) * 31;
            String str21 = this.highlightUrl;
            int hashCode31 = (hashCode30 + (str21 != null ? str21.hashCode() : 0)) * 31;
            JSONObject jSONObject11 = this.introduceTips;
            return hashCode31 + (jSONObject11 != null ? jSONObject11.hashCode() : 0);
        }

        public String toString() {
            return "SchemeModel(roomId=" + this.roomId + ", roomType=" + this.roomType + ", source=" + this.source + ", cover=" + this.cover + ", playUrl=" + this.playUrl + ", status=" + this.status + ", format=" + this.format + ", screen=" + this.screen + ", template=" + this.template + ", liveBackScheme=" + this.liveBackScheme + ", ext=" + this.ext + ", extRequest=" + this.extRequest + ", extLog=" + this.extLog + ", query=" + this.query + ", extParams=" + this.extParams + ", askId=" + this.askId + ", templateId=" + this.templateId + ", otherParams=" + this.otherParams + ", invokePop=" + this.invokePop + ", searchIntoLiveJson=" + this.searchIntoLiveJson + ", hlReplyIntoLive=" + this.hlReplyIntoLive + ", shareUid=" + this.shareUid + ", shareTag=" + this.shareTag + ", avcUrl=" + this.avcUrl + ", hevcUrl=" + this.hevcUrl + ", rtcUrl=" + this.rtcUrl + ", title=" + this.title + ", shareTaskInfo=" + this.shareTaskInfo + ", quic=" + this.quic + ", inviterId=" + this.inviterId + ", highlightUrl=" + this.highlightUrl + ", introduceTips=" + this.introduceTips + SmallTailInfo.EMOTION_SUFFIX;
        }

        public SchemeModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5, String str11, String str12, JSONObject jSONObject6, JSONObject jSONObject7, JSONObject jSONObject8, JSONObject jSONObject9, String str13, String str14, String str15, String str16, String str17, String str18, JSONObject jSONObject10, String str19, String str20, String str21, JSONObject jSONObject11) {
            this.roomId = str;
            this.roomType = str2;
            this.source = str3;
            this.cover = str4;
            this.playUrl = str5;
            this.status = str6;
            this.format = str7;
            this.screen = str8;
            this.template = str9;
            this.liveBackScheme = str10;
            this.ext = jSONObject;
            this.extRequest = jSONObject2;
            this.extLog = jSONObject3;
            this.query = jSONObject4;
            this.extParams = jSONObject5;
            this.askId = str11;
            this.templateId = str12;
            this.otherParams = jSONObject6;
            this.invokePop = jSONObject7;
            this.searchIntoLiveJson = jSONObject8;
            this.hlReplyIntoLive = jSONObject9;
            this.shareUid = str13;
            this.shareTag = str14;
            this.avcUrl = str15;
            this.hevcUrl = str16;
            this.rtcUrl = str17;
            this.title = str18;
            this.shareTaskInfo = jSONObject10;
            this.quic = str19;
            this.inviterId = str20;
            this.highlightUrl = str21;
            this.introduceTips = jSONObject11;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public /* synthetic */ SchemeModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5, String str11, String str12, JSONObject jSONObject6, JSONObject jSONObject7, JSONObject jSONObject8, JSONObject jSONObject9, String str13, String str14, String str15, String str16, String str17, String str18, JSONObject jSONObject10, String str19, String str20, String str21, JSONObject jSONObject11, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, r7, r8, str6, str7, str8, str9, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35);
            String str22;
            String str23;
            String str24;
            JSONObject jSONObject12;
            JSONObject jSONObject13;
            JSONObject jSONObject14;
            JSONObject jSONObject15;
            JSONObject jSONObject16;
            String str25;
            String str26;
            JSONObject jSONObject17;
            JSONObject jSONObject18;
            JSONObject jSONObject19;
            JSONObject jSONObject20;
            String str27;
            String str28;
            String str29;
            String str30;
            String str31;
            String str32;
            JSONObject jSONObject21;
            String str33;
            String str34;
            String str35;
            JSONObject jSONObject22;
            if ((i & 8) != 0) {
                str22 = "";
            } else {
                str22 = str4;
            }
            if ((i & 16) != 0) {
                str23 = "";
            } else {
                str23 = str5;
            }
            if ((i & 512) != 0) {
                str24 = "";
            } else {
                str24 = str10;
            }
            if ((i & 1024) != 0) {
                jSONObject12 = null;
            } else {
                jSONObject12 = jSONObject;
            }
            if ((i & 2048) != 0) {
                jSONObject13 = null;
            } else {
                jSONObject13 = jSONObject2;
            }
            if ((i & 4096) != 0) {
                jSONObject14 = null;
            } else {
                jSONObject14 = jSONObject3;
            }
            if ((i & 8192) != 0) {
                jSONObject15 = null;
            } else {
                jSONObject15 = jSONObject4;
            }
            if ((i & 16384) != 0) {
                jSONObject16 = null;
            } else {
                jSONObject16 = jSONObject5;
            }
            if ((32768 & i) != 0) {
                str25 = null;
            } else {
                str25 = str11;
            }
            if ((65536 & i) != 0) {
                str26 = null;
            } else {
                str26 = str12;
            }
            if ((131072 & i) != 0) {
                jSONObject17 = null;
            } else {
                jSONObject17 = jSONObject6;
            }
            if ((262144 & i) != 0) {
                jSONObject18 = null;
            } else {
                jSONObject18 = jSONObject7;
            }
            if ((524288 & i) != 0) {
                jSONObject19 = null;
            } else {
                jSONObject19 = jSONObject8;
            }
            if ((1048576 & i) != 0) {
                jSONObject20 = null;
            } else {
                jSONObject20 = jSONObject9;
            }
            if ((2097152 & i) != 0) {
                str27 = "";
            } else {
                str27 = str13;
            }
            if ((4194304 & i) != 0) {
                str28 = "";
            } else {
                str28 = str14;
            }
            if ((8388608 & i) != 0) {
                str29 = null;
            } else {
                str29 = str15;
            }
            if ((16777216 & i) != 0) {
                str30 = null;
            } else {
                str30 = str16;
            }
            if ((33554432 & i) != 0) {
                str31 = null;
            } else {
                str31 = str17;
            }
            if ((67108864 & i) != 0) {
                str32 = null;
            } else {
                str32 = str18;
            }
            if ((134217728 & i) != 0) {
                jSONObject21 = null;
            } else {
                jSONObject21 = jSONObject10;
            }
            if ((268435456 & i) != 0) {
                str33 = null;
            } else {
                str33 = str19;
            }
            if ((536870912 & i) != 0) {
                str34 = null;
            } else {
                str34 = str20;
            }
            if ((1073741824 & i) != 0) {
                str35 = null;
            } else {
                str35 = str21;
            }
            if ((i & Integer.MIN_VALUE) != 0) {
                jSONObject22 = null;
            } else {
                jSONObject22 = jSONObject11;
            }
        }

        public final String getAskId() {
            return this.askId;
        }

        public final String getAvcUrl() {
            return this.avcUrl;
        }

        public final JSONObject getCommonShareInfo() {
            return this.commonShareInfo;
        }

        public final String getCover() {
            return this.cover;
        }

        public final JSONObject getExt() {
            return this.ext;
        }

        public final JSONObject getExtLog() {
            return this.extLog;
        }

        public final JSONObject getExtParams() {
            return this.extParams;
        }

        public final JSONObject getExtRequest() {
            return this.extRequest;
        }

        public final String getFormat() {
            return this.format;
        }

        public final Boolean getFromIntent() {
            return this.fromIntent;
        }

        public final String getHevcUrl() {
            return this.hevcUrl;
        }

        public final String getHighlightUrl() {
            return this.highlightUrl;
        }

        public final JSONObject getHlReplyIntoLive() {
            return this.hlReplyIntoLive;
        }

        public final int getInterventions() {
            return this.interventions;
        }

        public final JSONObject getIntroduceTips() {
            return this.introduceTips;
        }

        public final String getInviterId() {
            return this.inviterId;
        }

        public final JSONObject getInvokePop() {
            return this.invokePop;
        }

        public final String getKabrSpts() {
            return this.kabrSpts;
        }

        public final String getLiveBackScheme() {
            return this.liveBackScheme;
        }

        public final JSONObject getMultiRate() {
            return this.multiRate;
        }

        public final JSONObject getOtherParams() {
            return this.otherParams;
        }

        public final int getPlayRateSetting() {
            return this.playRateSetting;
        }

        public final String getPlayUrl() {
            return this.playUrl;
        }

        public final Integer getPlayerCacheCodeC() {
            return this.playerCacheCodeC;
        }

        public final String getPlayerCacheKey() {
            return this.playerCacheKey;
        }

        public final JSONObject getQuery() {
            return this.query;
        }

        public final String getQuic() {
            return this.quic;
        }

        public final String getRoomId() {
            return this.roomId;
        }

        public final String getRoomType() {
            return this.roomType;
        }

        public final String getRtcHevcUrl() {
            return this.rtcHevcUrl;
        }

        public final String getRtcUrl() {
            return this.rtcUrl;
        }

        public final String getScreen() {
            return this.screen;
        }

        public final JSONObject getSearchIntoLiveJson() {
            return this.searchIntoLiveJson;
        }

        public final String getShareTag() {
            return this.shareTag;
        }

        public final JSONObject getShareTaskInfo() {
            return this.shareTaskInfo;
        }

        public final String getShareUid() {
            return this.shareUid;
        }

        public final String getSource() {
            return this.source;
        }

        public final String getStatus() {
            return this.status;
        }

        public final String getTemplate() {
            return this.template;
        }

        public final String getTemplateId() {
            return this.templateId;
        }

        public final String getTitle() {
            return this.title;
        }

        public final JSONObject getVrParams() {
            return this.vrParams;
        }

        public final void setCommonShareInfo(JSONObject jSONObject) {
            this.commonShareInfo = jSONObject;
        }

        public final void setFromIntent(Boolean bool) {
            this.fromIntent = bool;
        }

        public final void setHlReplyIntoLive(JSONObject jSONObject) {
            this.hlReplyIntoLive = jSONObject;
        }

        public final void setInterventions(int i) {
            this.interventions = i;
        }

        public final void setIntroduceTips(JSONObject jSONObject) {
            this.introduceTips = jSONObject;
        }

        public final void setInvokePop(JSONObject jSONObject) {
            this.invokePop = jSONObject;
        }

        public final void setKabrSpts(String str) {
            this.kabrSpts = str;
        }

        public final void setLiveBackScheme(String str) {
            this.liveBackScheme = str;
        }

        public final void setMultiRate(JSONObject jSONObject) {
            this.multiRate = jSONObject;
        }

        public final void setOtherParams(JSONObject jSONObject) {
            this.otherParams = jSONObject;
        }

        public final void setPlayRateSetting(int i) {
            this.playRateSetting = i;
        }

        public final void setPlayerCacheCodeC(Integer num) {
            this.playerCacheCodeC = num;
        }

        public final void setPlayerCacheKey(String str) {
            this.playerCacheKey = str;
        }

        public final void setQuery(JSONObject jSONObject) {
            this.query = jSONObject;
        }

        public final void setRoomType(String str) {
            this.roomType = str;
        }

        public final void setRtcHevcUrl(String str) {
            this.rtcHevcUrl = str;
        }

        public final void setSearchIntoLiveJson(JSONObject jSONObject) {
            this.searchIntoLiveJson = jSONObject;
        }

        public final void setShareTag(String str) {
            this.shareTag = str;
        }

        public final void setShareUid(String str) {
            this.shareUid = str;
        }

        public final void setTemplateId(String str) {
            this.templateId = str;
        }

        public final void setVrParams(JSONObject jSONObject) {
            this.vrParams = jSONObject;
        }

        public final String toSchemeParams() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("roomId", this.roomId);
                jSONObject.putOpt("roomType", this.roomType);
                jSONObject.putOpt("source", this.source);
                jSONObject.putOpt(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, this.cover);
                jSONObject.putOpt("play_url", this.playUrl);
                jSONObject.putOpt("live_back_scheme", this.liveBackScheme);
                jSONObject.putOpt("share_uid", this.shareUid);
                jSONObject.putOpt("zb_tag", this.shareTag);
                jSONObject.putOpt("status", this.status);
                JSONObject jSONObject2 = this.otherParams;
                if (jSONObject2 != null) {
                    jSONObject.putOpt("otherParams", jSONObject2);
                }
                JSONObject jSONObject3 = this.ext;
                if (jSONObject3 != null) {
                    jSONObject.putOpt("ext", jSONObject3);
                }
                JSONObject jSONObject4 = this.invokePop;
                if (jSONObject4 != null) {
                    jSONObject.putOpt("invokePop", jSONObject4);
                }
                JSONObject jSONObject5 = this.shareTaskInfo;
                if (jSONObject5 != null) {
                    jSONObject.putOpt("shareTaskInfo", jSONObject5);
                }
                JSONObject jSONObject6 = this.extRequest;
                if (jSONObject6 != null) {
                    jSONObject.putOpt("extRequest", jSONObject6);
                }
                JSONObject jSONObject7 = this.extLog;
                if (jSONObject7 != null) {
                    jSONObject.putOpt("extLog", jSONObject7);
                }
                JSONObject jSONObject8 = this.query;
                if (jSONObject8 != null) {
                    jSONObject.putOpt("query", jSONObject8);
                }
                JSONObject jSONObject9 = this.extParams;
                if (jSONObject9 != null) {
                    jSONObject.putOpt("extParams", jSONObject9);
                }
                String str = this.askId;
                if (str != null) {
                    jSONObject.putOpt("askId", str);
                }
                String str2 = this.templateId;
                if (str2 != null) {
                    jSONObject.putOpt("templateId", str2);
                }
                JSONObject jSONObject10 = this.searchIntoLiveJson;
                if (jSONObject10 != null) {
                    jSONObject.putOpt("queryECLive", jSONObject10);
                }
                JSONObject jSONObject11 = this.hlReplyIntoLive;
                if (jSONObject11 != null) {
                    jSONObject.putOpt("hlReplay", jSONObject11);
                }
                String str3 = this.avcUrl;
                if (str3 != null) {
                    jSONObject.putOpt("avcUrl", str3);
                }
                String str4 = this.hevcUrl;
                if (str4 != null) {
                    jSONObject.putOpt("hevcUrl", str4);
                }
                String str5 = this.rtcUrl;
                if (str5 != null) {
                    jSONObject.putOpt("rtcUrl", str5);
                }
                String str6 = this.rtcHevcUrl;
                if (str6 != null) {
                    jSONObject.putOpt("rtcHevcUrl", str6);
                }
                String str7 = this.title;
                if (str7 != null) {
                    jSONObject.putOpt("title", str7);
                }
                String str8 = this.quic;
                if (str8 != null) {
                    jSONObject.putOpt("quic", str8);
                }
                String str9 = this.inviterId;
                if (str9 != null) {
                    jSONObject.putOpt("inviterId", str9);
                }
                String str10 = this.highlightUrl;
                if (str10 != null) {
                    jSONObject.putOpt("highLightUrl", str10);
                }
                JSONObject jSONObject12 = this.introduceTips;
                if (jSONObject12 != null) {
                    jSONObject.putOpt("introduce_tips", jSONObject12);
                }
                String str11 = this.playerCacheKey;
                if (str11 != null) {
                    jSONObject.putOpt("playerIdentifier", str11);
                }
                Integer num = this.playerCacheCodeC;
                if (num != null) {
                    jSONObject.putOpt("playerCacheCodeC", Integer.valueOf(num.intValue()));
                }
                String str12 = this.kabrSpts;
                if (str12 != null) {
                    jSONObject.putOpt("kabr_spts", str12);
                }
                JSONObject jSONObject13 = this.commonShareInfo;
                if (jSONObject13 != null) {
                    jSONObject.putOpt("commonShareInfo", jSONObject13);
                }
                JSONObject jSONObject14 = this.multiRate;
                if (jSONObject14 != null) {
                    jSONObject.putOpt("multirate", jSONObject14.toString());
                }
                JSONObject jSONObject15 = this.vrParams;
                if (jSONObject15 != null) {
                    jSONObject.putOpt("vr", jSONObject15.toString());
                }
                jSONObject.putOpt(LivePreStartPlayServiceImpl.K_LIVE_PLAY_RATE_SETTING_OPTION, Integer.valueOf(this.playRateSetting));
                jSONObject.putOpt("interventions", Integer.valueOf(this.interventions));
            } catch (JSONException unused) {
            }
            String jSONObject16 = jSONObject.toString();
            Intrinsics.checkExpressionValueIsNotNull(jSONObject16, "json.toString()");
            return jSONObject16;
        }
    }

    public IntentData(String str, String str2, String str3, SchemeModel schemeModel, String str4, String str5) {
        this.id = str;
        this.source = str2;
        this.scheme = str3;
        this.model = schemeModel;
        this.tpl = str4;
        this.extReq = str5;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ IntentData(String str, String str2, String str3, SchemeModel schemeModel, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, r40, r41, r42);
        SchemeModel schemeModel2;
        String str6;
        String str7;
        if ((i & 8) != 0) {
            schemeModel2 = new SchemeModel("", "", "", "", "", "", "", "", "", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -512, null);
        } else {
            schemeModel2 = schemeModel;
        }
        if ((i & 16) != 0) {
            str6 = "";
        } else {
            str6 = str4;
        }
        if ((i & 32) != 0) {
            str7 = "";
        } else {
            str7 = str5;
        }
    }

    public final String getExtReq() {
        return this.extReq;
    }

    public final String getId() {
        return this.id;
    }

    public final String getLiveSource() {
        return this.source;
    }

    public final SchemeModel getModel() {
        return this.model;
    }

    public final String getNidFromHLReplay() {
        String optString;
        JSONObject hlReplyIntoLive = this.model.getHlReplyIntoLive();
        if (hlReplyIntoLive == null || (optString = hlReplyIntoLive.optString("nid")) == null) {
            return "";
        }
        return optString;
    }

    public final String getQuestionFromSearch() {
        if (banQuestionFromSearchDialog) {
            banQuestionFromSearchDialog = false;
            this.model.setSearchIntoLiveJson(null);
        }
        JSONObject searchIntoLiveJson = this.model.getSearchIntoLiveJson();
        if (searchIntoLiveJson == null) {
            return null;
        }
        return searchIntoLiveJson.optString("question");
    }

    public final String getScheme() {
        return this.scheme;
    }

    public final SchemeModel getSchemeData() {
        return this.model;
    }

    public final String getSource() {
        return this.source;
    }

    public final String getTpl() {
        return this.tpl;
    }

    public final int getTransitionStatus() {
        return this.transitionStatus;
    }

    public final boolean getTransitionSubStatus() {
        return this.transitionSubStatus;
    }

    public final Boolean getTranslucent() {
        return this.translucent;
    }

    public final boolean isEnterBookRoom() {
        String str = this.scheme;
        if (str == null) {
            return false;
        }
        if (!StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "enterBookRoom", false, 2, (Object) null) && !TextUtils.equals(this.model.getStatus(), String.valueOf(4))) {
            return false;
        }
        return true;
    }

    public final boolean isHLReplay() {
        if (this.model.getHlReplyIntoLive() != null && MiniShellRuntime.INSTANCE.isMobileBaidu()) {
            return true;
        }
        return false;
    }

    public final boolean transitionSeamless() {
        if (this.transitionStatus >= 1) {
            return true;
        }
        return false;
    }

    public final void setExtReq(String str) {
        this.extReq = str;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final void setModel(SchemeModel schemeModel) {
        this.model = schemeModel;
    }

    public final void setScheme(String str) {
        this.scheme = str;
    }

    public final void setSource(String str) {
        this.source = str;
    }

    public final void setTpl(String str) {
        this.tpl = str;
    }

    public final void setTransitionStatus(int i) {
        this.transitionStatus = i;
    }

    public final void setTransitionSubStatus(boolean z) {
        this.transitionSubStatus = z;
    }

    public final void setTranslucent(Boolean bool) {
        this.translucent = bool;
    }
}
