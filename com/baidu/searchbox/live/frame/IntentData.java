package com.baidu.searchbox.live.frame;

import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.arch.frame.State;
import com.baidu.live.arch.runtime.MiniShellRuntime;
import com.baidu.live.arch.utils.MiniJsonUtils;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.net.URLDecoder;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONException;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b)\b\u0086\b\u0018\u0000 D2\u00020\u0001:\u0002DEB=\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\bB\u0010CJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004JL\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0019\u0010\u0004J\r\u0010\u001a\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u0004J\u000f\u0010\u001b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001b\u0010\u0004J\r\u0010\u001c\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\tJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\u0016¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\u0016¢\u0006\u0004\b\"\u0010!J\u0010\u0010#\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b#\u0010\u0004J\r\u0010$\u001a\u00020\u0016¢\u0006\u0004\b$\u0010!R\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010%\u001a\u0004\b&\u0010\u0004\"\u0004\b'\u0010(R\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010%\u001a\u0004\b)\u0010\u0004\"\u0004\b*\u0010(R\"\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010+\u001a\u0004\b,\u0010\t\"\u0004\b-\u0010.R\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010%\u001a\u0004\b/\u0010\u0004\"\u0004\b0\u0010(R\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010%\u001a\u0004\b1\u0010\u0004\"\u0004\b2\u0010(R\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010%\u001a\u0004\b3\u0010\u0004\"\u0004\b4\u0010(R\"\u00105\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u0010\u001f\"\u0004\b8\u00109R*\u0010:\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b:\u0010;\u0012\u0004\b@\u0010A\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?¨\u0006F"}, d2 = {"Lcom/baidu/searchbox/live/frame/IntentData;", "Lcom/baidu/live/arch/frame/State;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "Lcom/baidu/searchbox/live/frame/IntentData$SchemeModel;", "component4", "()Lcom/baidu/searchbox/live/frame/IntentData$SchemeModel;", "component5", "component6", "id", "source", "scheme", "model", "tpl", "extReq", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/live/frame/IntentData$SchemeModel;Ljava/lang/String;Ljava/lang/String;)Lcom/baidu/searchbox/live/frame/IntentData;", "", ImageViewerConfig.FROM_OTHER, "", "equals", "(Ljava/lang/Object;)Z", "getLiveSource", "getNidFromHLReplay", "getQuestionFromSearch", "getSchemeData", "", TTDownloadField.TT_HASHCODE, "()I", "isEnterBookRoom", "()Z", "isHLReplay", "toString", "transitionSeamless", "Ljava/lang/String;", "getExtReq", "setExtReq", "(Ljava/lang/String;)V", "getId", "setId", "Lcom/baidu/searchbox/live/frame/IntentData$SchemeModel;", "getModel", "setModel", "(Lcom/baidu/searchbox/live/frame/IntentData$SchemeModel;)V", "getScheme", "setScheme", "getSource", "setSource", "getTpl", "setTpl", "transitionStatus", "I", "getTransitionStatus", "setTransitionStatus", "(I)V", "translucent", "Ljava/lang/Boolean;", "getTranslucent", "()Ljava/lang/Boolean;", "setTranslucent", "(Ljava/lang/Boolean;)V", "translucent$annotations", "()V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/live/frame/IntentData$SchemeModel;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "SchemeModel", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class IntentData implements State {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Companion Companion;
    public static final String KEY = "intent";
    public static boolean banQuestionFromSearchDialog;
    public transient /* synthetic */ FieldHolder $fh;
    public String extReq;
    public String id;
    public SchemeModel model;
    public String scheme;
    public String source;
    public String tpl;
    public int transitionStatus;
    public Boolean translucent;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00012\b\u0010\t\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0007\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/live/frame/IntentData$Companion;", "", "source", "getLiveSource", "(Ljava/lang/String;)Ljava/lang/String;", "params", "Lcom/baidu/searchbox/live/frame/IntentData$SchemeModel;", "parseSchemeData", "(Ljava/lang/String;)Lcom/baidu/searchbox/live/frame/IntentData$SchemeModel;", "scheme", "(Ljava/lang/String;Ljava/lang/String;)Lcom/baidu/searchbox/live/frame/IntentData$SchemeModel;", "KEY", "Ljava/lang/String;", "", "banQuestionFromSearchDialog", "Z", "getBanQuestionFromSearchDialog", "()Z", "setBanQuestionFromSearchDialog", "(Z)V", "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: Can't wrap try/catch for region: R(7:(4:(1:256)(7:118|119|120|121|122|123|(24:125|126|(2:128|129)(7:204|205|206|(7:223|224|225|226|228|229|230)(1:208)|209|(1:211)(2:214|(1:216))|212)|(3:179|180|(5:182|(1:184)|185|186|(2:188|(1:190))(20:192|132|133|134|135|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151)))|131|132|133|134|135|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151))|149|150|151)|143|144|145|146|147|148) */
        /* JADX WARN: Code restructure failed: missing block: B:181:0x0490, code lost:
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:182:0x0491, code lost:
            r11 = r4;
         */
        /* JADX WARN: Removed duplicated region for block: B:110:0x01f8 A[Catch: Exception -> 0x0217, TRY_LEAVE, TryCatch #18 {Exception -> 0x0217, blocks: (B:110:0x01f8, B:106:0x01ec), top: B:333:0x01ec }] */
        /* JADX WARN: Removed duplicated region for block: B:398:0x0385 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:414:0x0263 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final SchemeModel parseSchemeData(String str, String str2) {
            InterceptResult invokeLL;
            Exception exc;
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
            String str16;
            Integer num;
            String str17;
            JSONObject jSONObject;
            String str18;
            JSONObject jSONObject2;
            JSONObject jSONObject3;
            JSONObject jSONObject4;
            JSONObject jSONObject5;
            JSONObject jSONObject6;
            JSONObject jSONObject7;
            String str19;
            String str20;
            JSONObject jSONObject8;
            JSONObject jSONObject9;
            JSONObject jSONObject10;
            JSONObject jSONObject11;
            String str21;
            String str22;
            String str23;
            String str24;
            JSONObject jSONObject12;
            String str25;
            String str26;
            JSONObject jSONObject13;
            String str27;
            String str28;
            String str29;
            String str30;
            String str31;
            String str32;
            String str33;
            String str34;
            JSONObject parseJSONObject;
            JSONObject parseJSONObject2;
            JSONObject parseJSONObject3;
            JSONObject parseJSONObject4;
            JSONObject parseJSONObject5;
            JSONObject parseJSONObject6;
            JSONObject parseJSONObject7;
            JSONObject parseJSONObject8;
            String optString;
            String optString2;
            String optString3;
            String optString4;
            String optString5;
            String optString6;
            String optString7;
            String optString8;
            JSONObject parseJSONObject9;
            String optString9;
            Integer valueOf;
            String optString10;
            String str35;
            String str36;
            String str37;
            JSONObject parseJSONObject10;
            String str38;
            JSONObject jSONObject14;
            JSONObject jSONObject15;
            String str39;
            JSONObject optJSONObject;
            JSONObject jSONObject16;
            Integer num2;
            JSONObject jSONObject17;
            String str40;
            String str41;
            String str42;
            String str43;
            JSONObject jSONObject18;
            String str44;
            String str45;
            String str46;
            String str47;
            JSONObject optJSONObject2;
            JSONObject optJSONObject3;
            JSONObject jSONObject19;
            String str48;
            String str49;
            JSONObject jSONObject20;
            String str50;
            String queryParameter;
            JSONObject jSONObject21;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) != null) {
                return (SchemeModel) invokeLL.objValue;
            }
            try {
                JSONObject jSONObject22 = new JSONObject(str);
                String optString11 = jSONObject22.optString("roomId");
                if (optString11 == null) {
                    optString11 = "";
                }
                try {
                    if (TextUtils.isEmpty(optString11)) {
                        try {
                            optString11 = jSONObject22.optString("room_id");
                            if (optString11 == null) {
                                optString11 = "";
                            }
                        } catch (Exception e) {
                            exc = e;
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
                            str3 = optString11;
                            str16 = null;
                            num = null;
                            str17 = null;
                            jSONObject = null;
                            str18 = null;
                            jSONObject2 = null;
                            jSONObject3 = null;
                            jSONObject4 = null;
                            jSONObject5 = null;
                            jSONObject6 = null;
                            jSONObject7 = null;
                            str19 = null;
                            str20 = null;
                            jSONObject8 = null;
                            jSONObject9 = null;
                            jSONObject10 = null;
                            jSONObject11 = null;
                            str21 = null;
                            str22 = null;
                            str23 = null;
                            str24 = null;
                            jSONObject12 = null;
                            str25 = null;
                            str26 = null;
                            jSONObject13 = null;
                            exc.printStackTrace();
                            SchemeModel schemeModel = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject3, jSONObject4, jSONObject5, jSONObject6, jSONObject7, str19, str20, jSONObject8, jSONObject9, jSONObject10, jSONObject11, str13, str14, str21, str22, str23, str24, jSONObject12, str25, str15, str26, jSONObject13);
                            schemeModel.setPlayerCacheKey(str17);
                            schemeModel.setPlayerCacheCodeC(num);
                            schemeModel.setKabrSpts(str16);
                            schemeModel.setRtcHevcUrl(str18);
                            schemeModel.setCommonShareInfo(jSONObject2);
                            schemeModel.setMultiRate(jSONObject);
                            schemeModel.setFromIntent(Boolean.TRUE);
                            return schemeModel;
                        }
                    }
                } catch (Exception e2) {
                    str27 = "";
                    exc = e2;
                    str3 = optString11;
                }
                try {
                    String optString12 = jSONObject22.optString("inviterId");
                    try {
                        String optString13 = jSONObject22.optString("roomType");
                        String str51 = optString13 != null ? optString13 : "";
                        try {
                            String optString14 = jSONObject22.optString("source");
                            if (optString14 == null) {
                                optString14 = "";
                            }
                            String liveSource = getLiveSource(optString14);
                            try {
                                String optString15 = jSONObject22.optString(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY);
                                str29 = optString15 != null ? optString15 : "";
                                try {
                                    String optString16 = jSONObject22.optString("playUrl");
                                    str30 = optString16 != null ? optString16 : "";
                                    try {
                                        String optString17 = jSONObject22.optString("status");
                                        str31 = optString17 != null ? optString17 : "";
                                        try {
                                            String optString18 = jSONObject22.optString("format");
                                            str32 = optString18 != null ? optString18 : "";
                                            try {
                                                String optString19 = jSONObject22.optString("screen");
                                                str33 = optString19 != null ? optString19 : "";
                                                try {
                                                    String optString20 = jSONObject22.optString(MediaTrackConfig.AE_IMPORT_TEMPLATE);
                                                    str34 = optString20 != null ? optString20 : "";
                                                } catch (Exception e3) {
                                                    str28 = liveSource;
                                                    str3 = optString11;
                                                    exc = e3;
                                                    str11 = "";
                                                    str12 = str11;
                                                    str13 = str12;
                                                    str14 = str13;
                                                    str15 = optString12;
                                                    str4 = str51;
                                                    str6 = str29;
                                                    str7 = str30;
                                                    str8 = str31;
                                                    str9 = str32;
                                                    str10 = str33;
                                                }
                                            } catch (Exception e4) {
                                                str28 = liveSource;
                                                str3 = optString11;
                                                exc = e4;
                                                str10 = "";
                                                str11 = str10;
                                                str12 = str11;
                                                str13 = str12;
                                                str14 = str13;
                                                str15 = optString12;
                                                str4 = str51;
                                                str6 = str29;
                                                str7 = str30;
                                                str8 = str31;
                                                str9 = str32;
                                            }
                                            try {
                                                parseJSONObject = MiniJsonUtils.INSTANCE.parseJSONObject(jSONObject22, "ext");
                                                try {
                                                    JSONObject parseJSONObject11 = MiniJsonUtils.INSTANCE.parseJSONObject(jSONObject22, "otherParams");
                                                    if (parseJSONObject11 == null) {
                                                        try {
                                                            String optString21 = jSONObject22.optString("otherParams");
                                                            Intrinsics.checkExpressionValueIsNotNull(optString21, "json.optString(\"otherParams\")");
                                                            if (!TextUtils.isEmpty(optString21)) {
                                                                try {
                                                                    parseJSONObject11 = new JSONObject(URLDecoder.decode(optString21));
                                                                } catch (JSONException unused) {
                                                                    parseJSONObject11 = null;
                                                                }
                                                            }
                                                        } catch (Exception e5) {
                                                            exc = e5;
                                                            str12 = "";
                                                            str13 = str12;
                                                            str14 = str13;
                                                            str3 = optString11;
                                                            jSONObject3 = parseJSONObject;
                                                            jSONObject8 = parseJSONObject11;
                                                            str5 = liveSource;
                                                            str15 = optString12;
                                                            str4 = str51;
                                                            str6 = str29;
                                                            str7 = str30;
                                                            str8 = str31;
                                                            str9 = str32;
                                                            str10 = str33;
                                                            str11 = str34;
                                                            str16 = null;
                                                            num = null;
                                                            str17 = null;
                                                            jSONObject = null;
                                                            str18 = null;
                                                            jSONObject2 = null;
                                                            jSONObject4 = null;
                                                            jSONObject5 = null;
                                                            jSONObject6 = null;
                                                            jSONObject7 = null;
                                                            str19 = null;
                                                            str20 = null;
                                                            jSONObject9 = null;
                                                            jSONObject10 = null;
                                                            jSONObject11 = null;
                                                            str21 = null;
                                                            str22 = null;
                                                            str23 = null;
                                                            str24 = null;
                                                            jSONObject12 = null;
                                                            str25 = null;
                                                            str26 = null;
                                                            jSONObject13 = null;
                                                            exc.printStackTrace();
                                                            SchemeModel schemeModel2 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject3, jSONObject4, jSONObject5, jSONObject6, jSONObject7, str19, str20, jSONObject8, jSONObject9, jSONObject10, jSONObject11, str13, str14, str21, str22, str23, str24, jSONObject12, str25, str15, str26, jSONObject13);
                                                            schemeModel2.setPlayerCacheKey(str17);
                                                            schemeModel2.setPlayerCacheCodeC(num);
                                                            schemeModel2.setKabrSpts(str16);
                                                            schemeModel2.setRtcHevcUrl(str18);
                                                            schemeModel2.setCommonShareInfo(jSONObject2);
                                                            schemeModel2.setMultiRate(jSONObject);
                                                            schemeModel2.setFromIntent(Boolean.TRUE);
                                                            return schemeModel2;
                                                        }
                                                    }
                                                    try {
                                                        parseJSONObject2 = MiniJsonUtils.INSTANCE.parseJSONObject(jSONObject22, "otherParams");
                                                        try {
                                                            parseJSONObject3 = MiniJsonUtils.INSTANCE.parseJSONObject(jSONObject22, "query");
                                                            try {
                                                                parseJSONObject4 = MiniJsonUtils.INSTANCE.parseJSONObject(jSONObject22, "extRequest");
                                                            } catch (Exception e6) {
                                                                e = e6;
                                                                str3 = optString11;
                                                                jSONObject8 = parseJSONObject2;
                                                                jSONObject3 = parseJSONObject;
                                                                str12 = "";
                                                                str13 = str12;
                                                                str14 = str13;
                                                                str15 = optString12;
                                                                str4 = str51;
                                                                str6 = str29;
                                                                str7 = str30;
                                                                str8 = str31;
                                                                str9 = str32;
                                                                str10 = str33;
                                                                str11 = str34;
                                                                jSONObject6 = parseJSONObject3;
                                                                str5 = liveSource;
                                                                num = null;
                                                                str17 = null;
                                                                jSONObject = null;
                                                                str18 = null;
                                                                jSONObject2 = null;
                                                                jSONObject4 = null;
                                                            }
                                                        } catch (Exception e7) {
                                                            e = e7;
                                                            str3 = optString11;
                                                            jSONObject8 = parseJSONObject2;
                                                            jSONObject3 = parseJSONObject;
                                                            str12 = "";
                                                            str13 = str12;
                                                            str14 = str13;
                                                            str15 = optString12;
                                                            str4 = str51;
                                                            str6 = str29;
                                                            str7 = str30;
                                                            str8 = str31;
                                                            str9 = str32;
                                                            str10 = str33;
                                                            str11 = str34;
                                                            str5 = liveSource;
                                                            num = null;
                                                            str17 = null;
                                                            jSONObject = null;
                                                            str18 = null;
                                                            jSONObject2 = null;
                                                            jSONObject4 = null;
                                                            jSONObject5 = null;
                                                            jSONObject6 = null;
                                                        }
                                                    } catch (Exception e8) {
                                                        str3 = optString11;
                                                        exc = e8;
                                                        jSONObject3 = parseJSONObject;
                                                        jSONObject8 = parseJSONObject11;
                                                        str12 = "";
                                                        str13 = str12;
                                                        str14 = str13;
                                                        str15 = optString12;
                                                        str4 = str51;
                                                        str6 = str29;
                                                        str7 = str30;
                                                        str8 = str31;
                                                        str9 = str32;
                                                        str10 = str33;
                                                        str11 = str34;
                                                        str5 = liveSource;
                                                        str16 = null;
                                                        num = null;
                                                        str17 = null;
                                                        jSONObject = null;
                                                        str18 = null;
                                                        jSONObject2 = null;
                                                        jSONObject4 = null;
                                                        jSONObject5 = null;
                                                        jSONObject6 = null;
                                                        jSONObject7 = null;
                                                        str19 = null;
                                                        str20 = null;
                                                        jSONObject9 = null;
                                                        jSONObject10 = null;
                                                        jSONObject11 = null;
                                                        str21 = null;
                                                        str22 = null;
                                                        str23 = null;
                                                        str24 = null;
                                                        jSONObject12 = null;
                                                        str25 = null;
                                                        str26 = null;
                                                        jSONObject13 = null;
                                                        exc.printStackTrace();
                                                        SchemeModel schemeModel22 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject3, jSONObject4, jSONObject5, jSONObject6, jSONObject7, str19, str20, jSONObject8, jSONObject9, jSONObject10, jSONObject11, str13, str14, str21, str22, str23, str24, jSONObject12, str25, str15, str26, jSONObject13);
                                                        schemeModel22.setPlayerCacheKey(str17);
                                                        schemeModel22.setPlayerCacheCodeC(num);
                                                        schemeModel22.setKabrSpts(str16);
                                                        schemeModel22.setRtcHevcUrl(str18);
                                                        schemeModel22.setCommonShareInfo(jSONObject2);
                                                        schemeModel22.setMultiRate(jSONObject);
                                                        schemeModel22.setFromIntent(Boolean.TRUE);
                                                        return schemeModel22;
                                                    }
                                                } catch (Exception e9) {
                                                    str3 = optString11;
                                                    exc = e9;
                                                    jSONObject3 = parseJSONObject;
                                                    str12 = "";
                                                    str13 = str12;
                                                    str14 = str13;
                                                    str15 = optString12;
                                                    str4 = str51;
                                                    str6 = str29;
                                                    str7 = str30;
                                                    str8 = str31;
                                                    str9 = str32;
                                                    str10 = str33;
                                                    str11 = str34;
                                                    str5 = liveSource;
                                                    str16 = null;
                                                    num = null;
                                                    str17 = null;
                                                    jSONObject = null;
                                                    str18 = null;
                                                    jSONObject2 = null;
                                                    jSONObject4 = null;
                                                    jSONObject5 = null;
                                                    jSONObject6 = null;
                                                    jSONObject7 = null;
                                                    str19 = null;
                                                    str20 = null;
                                                    jSONObject8 = null;
                                                    jSONObject9 = null;
                                                    jSONObject10 = null;
                                                    jSONObject11 = null;
                                                    str21 = null;
                                                    str22 = null;
                                                    str23 = null;
                                                    str24 = null;
                                                    jSONObject12 = null;
                                                    str25 = null;
                                                    str26 = null;
                                                    jSONObject13 = null;
                                                    exc.printStackTrace();
                                                    SchemeModel schemeModel222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject3, jSONObject4, jSONObject5, jSONObject6, jSONObject7, str19, str20, jSONObject8, jSONObject9, jSONObject10, jSONObject11, str13, str14, str21, str22, str23, str24, jSONObject12, str25, str15, str26, jSONObject13);
                                                    schemeModel222.setPlayerCacheKey(str17);
                                                    schemeModel222.setPlayerCacheCodeC(num);
                                                    schemeModel222.setKabrSpts(str16);
                                                    schemeModel222.setRtcHevcUrl(str18);
                                                    schemeModel222.setCommonShareInfo(jSONObject2);
                                                    schemeModel222.setMultiRate(jSONObject);
                                                    schemeModel222.setFromIntent(Boolean.TRUE);
                                                    return schemeModel222;
                                                }
                                            } catch (Exception e10) {
                                                str28 = liveSource;
                                                str3 = optString11;
                                                exc = e10;
                                                str12 = "";
                                                str13 = str12;
                                                str14 = str13;
                                                str15 = optString12;
                                                str4 = str51;
                                                str6 = str29;
                                                str7 = str30;
                                                str8 = str31;
                                                str9 = str32;
                                                str10 = str33;
                                                str11 = str34;
                                                str5 = str28;
                                                str16 = null;
                                                num = null;
                                                str17 = null;
                                                jSONObject = null;
                                                str18 = null;
                                                jSONObject2 = null;
                                                jSONObject3 = null;
                                                jSONObject4 = null;
                                                jSONObject5 = null;
                                                jSONObject6 = null;
                                                jSONObject7 = null;
                                                str19 = null;
                                                str20 = null;
                                                jSONObject8 = null;
                                                jSONObject9 = null;
                                                jSONObject10 = null;
                                                jSONObject11 = null;
                                                str21 = null;
                                                str22 = null;
                                                str23 = null;
                                                str24 = null;
                                                jSONObject12 = null;
                                                str25 = null;
                                                str26 = null;
                                                jSONObject13 = null;
                                                exc.printStackTrace();
                                                SchemeModel schemeModel2222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject3, jSONObject4, jSONObject5, jSONObject6, jSONObject7, str19, str20, jSONObject8, jSONObject9, jSONObject10, jSONObject11, str13, str14, str21, str22, str23, str24, jSONObject12, str25, str15, str26, jSONObject13);
                                                schemeModel2222.setPlayerCacheKey(str17);
                                                schemeModel2222.setPlayerCacheCodeC(num);
                                                schemeModel2222.setKabrSpts(str16);
                                                schemeModel2222.setRtcHevcUrl(str18);
                                                schemeModel2222.setCommonShareInfo(jSONObject2);
                                                schemeModel2222.setMultiRate(jSONObject);
                                                schemeModel2222.setFromIntent(Boolean.TRUE);
                                                return schemeModel2222;
                                            }
                                            try {
                                                parseJSONObject5 = MiniJsonUtils.INSTANCE.parseJSONObject(jSONObject22, "extLog");
                                                try {
                                                    parseJSONObject6 = MiniJsonUtils.INSTANCE.parseJSONObject(jSONObject22, "extParams");
                                                } catch (Exception e11) {
                                                    e = e11;
                                                    str3 = optString11;
                                                    jSONObject8 = parseJSONObject2;
                                                    jSONObject3 = parseJSONObject;
                                                    str12 = "";
                                                    str13 = str12;
                                                    str14 = str13;
                                                    str15 = optString12;
                                                    str4 = str51;
                                                    str6 = str29;
                                                    str7 = str30;
                                                    str8 = str31;
                                                    str9 = str32;
                                                    str10 = str33;
                                                    str11 = str34;
                                                    jSONObject6 = parseJSONObject3;
                                                    jSONObject4 = parseJSONObject4;
                                                    jSONObject5 = parseJSONObject5;
                                                    str5 = liveSource;
                                                    num = null;
                                                    str17 = null;
                                                    jSONObject = null;
                                                    str18 = null;
                                                    jSONObject2 = null;
                                                    jSONObject7 = null;
                                                    str19 = null;
                                                    str20 = null;
                                                    jSONObject9 = null;
                                                    jSONObject10 = null;
                                                    jSONObject11 = null;
                                                    str21 = null;
                                                    str22 = null;
                                                    str23 = null;
                                                    str24 = null;
                                                    jSONObject12 = null;
                                                    str25 = null;
                                                    str26 = null;
                                                    jSONObject13 = null;
                                                    exc = e;
                                                    str16 = null;
                                                    exc.printStackTrace();
                                                    SchemeModel schemeModel22222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject3, jSONObject4, jSONObject5, jSONObject6, jSONObject7, str19, str20, jSONObject8, jSONObject9, jSONObject10, jSONObject11, str13, str14, str21, str22, str23, str24, jSONObject12, str25, str15, str26, jSONObject13);
                                                    schemeModel22222.setPlayerCacheKey(str17);
                                                    schemeModel22222.setPlayerCacheCodeC(num);
                                                    schemeModel22222.setKabrSpts(str16);
                                                    schemeModel22222.setRtcHevcUrl(str18);
                                                    schemeModel22222.setCommonShareInfo(jSONObject2);
                                                    schemeModel22222.setMultiRate(jSONObject);
                                                    schemeModel22222.setFromIntent(Boolean.TRUE);
                                                    return schemeModel22222;
                                                }
                                                try {
                                                    parseJSONObject7 = MiniJsonUtils.INSTANCE.parseJSONObject(jSONObject22, "invokePop");
                                                    try {
                                                        parseJSONObject8 = MiniJsonUtils.INSTANCE.parseJSONObject(jSONObject22, "shareTaskInfo");
                                                        try {
                                                            optString = jSONObject22.optString("askId");
                                                            try {
                                                                optString2 = jSONObject22.optString("templateId");
                                                                try {
                                                                    optString3 = jSONObject22.optString("avcUrl");
                                                                } catch (Exception e12) {
                                                                    e = e12;
                                                                    str3 = optString11;
                                                                    jSONObject8 = parseJSONObject2;
                                                                    jSONObject3 = parseJSONObject;
                                                                    str12 = "";
                                                                    str13 = str12;
                                                                    str14 = str13;
                                                                    str15 = optString12;
                                                                    str4 = str51;
                                                                    str6 = str29;
                                                                    str7 = str30;
                                                                    str8 = str31;
                                                                    str9 = str32;
                                                                    str10 = str33;
                                                                    str11 = str34;
                                                                    jSONObject6 = parseJSONObject3;
                                                                    jSONObject4 = parseJSONObject4;
                                                                    jSONObject5 = parseJSONObject5;
                                                                    jSONObject9 = parseJSONObject7;
                                                                    jSONObject12 = parseJSONObject8;
                                                                    str19 = optString;
                                                                    str20 = optString2;
                                                                    jSONObject7 = parseJSONObject6;
                                                                    str5 = liveSource;
                                                                    num = null;
                                                                    str17 = null;
                                                                    jSONObject = null;
                                                                    str18 = null;
                                                                    jSONObject2 = null;
                                                                    jSONObject10 = null;
                                                                    jSONObject11 = null;
                                                                    str21 = null;
                                                                    str22 = null;
                                                                    str23 = null;
                                                                    str24 = null;
                                                                    str25 = null;
                                                                    str26 = null;
                                                                    jSONObject13 = null;
                                                                    exc = e;
                                                                    str16 = null;
                                                                    exc.printStackTrace();
                                                                    SchemeModel schemeModel222222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject3, jSONObject4, jSONObject5, jSONObject6, jSONObject7, str19, str20, jSONObject8, jSONObject9, jSONObject10, jSONObject11, str13, str14, str21, str22, str23, str24, jSONObject12, str25, str15, str26, jSONObject13);
                                                                    schemeModel222222.setPlayerCacheKey(str17);
                                                                    schemeModel222222.setPlayerCacheCodeC(num);
                                                                    schemeModel222222.setKabrSpts(str16);
                                                                    schemeModel222222.setRtcHevcUrl(str18);
                                                                    schemeModel222222.setCommonShareInfo(jSONObject2);
                                                                    schemeModel222222.setMultiRate(jSONObject);
                                                                    schemeModel222222.setFromIntent(Boolean.TRUE);
                                                                    return schemeModel222222;
                                                                }
                                                            } catch (Exception e13) {
                                                                e = e13;
                                                                str3 = optString11;
                                                                jSONObject8 = parseJSONObject2;
                                                                jSONObject3 = parseJSONObject;
                                                                str12 = "";
                                                                str13 = str12;
                                                                str14 = str13;
                                                                str15 = optString12;
                                                                str4 = str51;
                                                                str6 = str29;
                                                                str7 = str30;
                                                                str8 = str31;
                                                                str9 = str32;
                                                                str10 = str33;
                                                                str11 = str34;
                                                                jSONObject6 = parseJSONObject3;
                                                                jSONObject4 = parseJSONObject4;
                                                                jSONObject5 = parseJSONObject5;
                                                                jSONObject9 = parseJSONObject7;
                                                                jSONObject12 = parseJSONObject8;
                                                                str19 = optString;
                                                                jSONObject7 = parseJSONObject6;
                                                                str5 = liveSource;
                                                                num = null;
                                                                str17 = null;
                                                                jSONObject = null;
                                                                str18 = null;
                                                                jSONObject2 = null;
                                                                str20 = null;
                                                                jSONObject10 = null;
                                                                jSONObject11 = null;
                                                                str21 = null;
                                                                str22 = null;
                                                                str23 = null;
                                                                str24 = null;
                                                                str25 = null;
                                                                str26 = null;
                                                                jSONObject13 = null;
                                                                exc = e;
                                                                str16 = null;
                                                                exc.printStackTrace();
                                                                SchemeModel schemeModel2222222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject3, jSONObject4, jSONObject5, jSONObject6, jSONObject7, str19, str20, jSONObject8, jSONObject9, jSONObject10, jSONObject11, str13, str14, str21, str22, str23, str24, jSONObject12, str25, str15, str26, jSONObject13);
                                                                schemeModel2222222.setPlayerCacheKey(str17);
                                                                schemeModel2222222.setPlayerCacheCodeC(num);
                                                                schemeModel2222222.setKabrSpts(str16);
                                                                schemeModel2222222.setRtcHevcUrl(str18);
                                                                schemeModel2222222.setCommonShareInfo(jSONObject2);
                                                                schemeModel2222222.setMultiRate(jSONObject);
                                                                schemeModel2222222.setFromIntent(Boolean.TRUE);
                                                                return schemeModel2222222;
                                                            }
                                                            try {
                                                                optString4 = jSONObject22.optString("hevcUrl");
                                                            } catch (Exception e14) {
                                                                e = e14;
                                                                str3 = optString11;
                                                                jSONObject8 = parseJSONObject2;
                                                                jSONObject3 = parseJSONObject;
                                                                str12 = "";
                                                                str13 = str12;
                                                                str14 = str13;
                                                                str15 = optString12;
                                                                str4 = str51;
                                                                str6 = str29;
                                                                str7 = str30;
                                                                str8 = str31;
                                                                str9 = str32;
                                                                str10 = str33;
                                                                str11 = str34;
                                                                jSONObject6 = parseJSONObject3;
                                                                jSONObject4 = parseJSONObject4;
                                                                jSONObject5 = parseJSONObject5;
                                                                jSONObject9 = parseJSONObject7;
                                                                jSONObject12 = parseJSONObject8;
                                                                str19 = optString;
                                                                str20 = optString2;
                                                                str21 = optString3;
                                                                jSONObject7 = parseJSONObject6;
                                                                str5 = liveSource;
                                                                num = null;
                                                                str17 = null;
                                                                jSONObject = null;
                                                                str18 = null;
                                                                jSONObject2 = null;
                                                                jSONObject10 = null;
                                                                jSONObject11 = null;
                                                                str22 = null;
                                                                str23 = null;
                                                                str24 = null;
                                                                str25 = null;
                                                                str26 = null;
                                                                jSONObject13 = null;
                                                                exc = e;
                                                                str16 = null;
                                                                exc.printStackTrace();
                                                                SchemeModel schemeModel22222222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject3, jSONObject4, jSONObject5, jSONObject6, jSONObject7, str19, str20, jSONObject8, jSONObject9, jSONObject10, jSONObject11, str13, str14, str21, str22, str23, str24, jSONObject12, str25, str15, str26, jSONObject13);
                                                                schemeModel22222222.setPlayerCacheKey(str17);
                                                                schemeModel22222222.setPlayerCacheCodeC(num);
                                                                schemeModel22222222.setKabrSpts(str16);
                                                                schemeModel22222222.setRtcHevcUrl(str18);
                                                                schemeModel22222222.setCommonShareInfo(jSONObject2);
                                                                schemeModel22222222.setMultiRate(jSONObject);
                                                                schemeModel22222222.setFromIntent(Boolean.TRUE);
                                                                return schemeModel22222222;
                                                            }
                                                            try {
                                                                optString5 = jSONObject22.optString("rtcUrl");
                                                                try {
                                                                    optString6 = jSONObject22.optString("rtcHevcUrl");
                                                                } catch (Exception e15) {
                                                                    e = e15;
                                                                    str3 = optString11;
                                                                    jSONObject8 = parseJSONObject2;
                                                                    jSONObject3 = parseJSONObject;
                                                                    str12 = "";
                                                                    str13 = str12;
                                                                    str14 = str13;
                                                                    str15 = optString12;
                                                                    str4 = str51;
                                                                    str6 = str29;
                                                                    str7 = str30;
                                                                    str8 = str31;
                                                                    str9 = str32;
                                                                    str10 = str33;
                                                                    str11 = str34;
                                                                    jSONObject6 = parseJSONObject3;
                                                                    jSONObject4 = parseJSONObject4;
                                                                    jSONObject5 = parseJSONObject5;
                                                                    jSONObject9 = parseJSONObject7;
                                                                    jSONObject12 = parseJSONObject8;
                                                                    str19 = optString;
                                                                    str20 = optString2;
                                                                    str21 = optString3;
                                                                    str22 = optString4;
                                                                    str23 = optString5;
                                                                    jSONObject7 = parseJSONObject6;
                                                                    str5 = liveSource;
                                                                    num = null;
                                                                    str17 = null;
                                                                    jSONObject = null;
                                                                    str18 = null;
                                                                }
                                                            } catch (Exception e16) {
                                                                e = e16;
                                                                str3 = optString11;
                                                                jSONObject8 = parseJSONObject2;
                                                                jSONObject3 = parseJSONObject;
                                                                str12 = "";
                                                                str13 = str12;
                                                                str14 = str13;
                                                                str15 = optString12;
                                                                str4 = str51;
                                                                str6 = str29;
                                                                str7 = str30;
                                                                str8 = str31;
                                                                str9 = str32;
                                                                str10 = str33;
                                                                str11 = str34;
                                                                jSONObject6 = parseJSONObject3;
                                                                jSONObject4 = parseJSONObject4;
                                                                jSONObject5 = parseJSONObject5;
                                                                jSONObject9 = parseJSONObject7;
                                                                jSONObject12 = parseJSONObject8;
                                                                str19 = optString;
                                                                str20 = optString2;
                                                                str21 = optString3;
                                                                str22 = optString4;
                                                                jSONObject7 = parseJSONObject6;
                                                                str5 = liveSource;
                                                                num = null;
                                                                str17 = null;
                                                                jSONObject = null;
                                                                str18 = null;
                                                                jSONObject2 = null;
                                                                jSONObject10 = null;
                                                                jSONObject11 = null;
                                                                str23 = null;
                                                                str24 = null;
                                                                str25 = null;
                                                                str26 = null;
                                                                jSONObject13 = null;
                                                                exc = e;
                                                                str16 = null;
                                                                exc.printStackTrace();
                                                                SchemeModel schemeModel222222222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject3, jSONObject4, jSONObject5, jSONObject6, jSONObject7, str19, str20, jSONObject8, jSONObject9, jSONObject10, jSONObject11, str13, str14, str21, str22, str23, str24, jSONObject12, str25, str15, str26, jSONObject13);
                                                                schemeModel222222222.setPlayerCacheKey(str17);
                                                                schemeModel222222222.setPlayerCacheCodeC(num);
                                                                schemeModel222222222.setKabrSpts(str16);
                                                                schemeModel222222222.setRtcHevcUrl(str18);
                                                                schemeModel222222222.setCommonShareInfo(jSONObject2);
                                                                schemeModel222222222.setMultiRate(jSONObject);
                                                                schemeModel222222222.setFromIntent(Boolean.TRUE);
                                                                return schemeModel222222222;
                                                            }
                                                        } catch (Exception e17) {
                                                            e = e17;
                                                            str3 = optString11;
                                                            jSONObject8 = parseJSONObject2;
                                                            jSONObject3 = parseJSONObject;
                                                            str12 = "";
                                                            str13 = str12;
                                                            str14 = str13;
                                                            str15 = optString12;
                                                            str4 = str51;
                                                            str6 = str29;
                                                            str7 = str30;
                                                            str8 = str31;
                                                            str9 = str32;
                                                            str10 = str33;
                                                            str11 = str34;
                                                            jSONObject6 = parseJSONObject3;
                                                            jSONObject4 = parseJSONObject4;
                                                            jSONObject5 = parseJSONObject5;
                                                            jSONObject9 = parseJSONObject7;
                                                            jSONObject12 = parseJSONObject8;
                                                            jSONObject7 = parseJSONObject6;
                                                            str5 = liveSource;
                                                            num = null;
                                                            str17 = null;
                                                            jSONObject = null;
                                                            str18 = null;
                                                            jSONObject2 = null;
                                                            str19 = null;
                                                        }
                                                    } catch (Exception e18) {
                                                        e = e18;
                                                        str3 = optString11;
                                                        jSONObject8 = parseJSONObject2;
                                                        jSONObject3 = parseJSONObject;
                                                        str12 = "";
                                                        str13 = str12;
                                                        str14 = str13;
                                                        str15 = optString12;
                                                        str4 = str51;
                                                        str6 = str29;
                                                        str7 = str30;
                                                        str8 = str31;
                                                        str9 = str32;
                                                        str10 = str33;
                                                        str11 = str34;
                                                        jSONObject6 = parseJSONObject3;
                                                        jSONObject4 = parseJSONObject4;
                                                        jSONObject5 = parseJSONObject5;
                                                        jSONObject9 = parseJSONObject7;
                                                        jSONObject7 = parseJSONObject6;
                                                        str5 = liveSource;
                                                        num = null;
                                                        str17 = null;
                                                        jSONObject = null;
                                                        str18 = null;
                                                        jSONObject2 = null;
                                                        str19 = null;
                                                        str20 = null;
                                                        jSONObject10 = null;
                                                        jSONObject11 = null;
                                                        str21 = null;
                                                        str22 = null;
                                                        str23 = null;
                                                        str24 = null;
                                                        jSONObject12 = null;
                                                        str25 = null;
                                                        str26 = null;
                                                        jSONObject13 = null;
                                                        exc = e;
                                                        str16 = null;
                                                        exc.printStackTrace();
                                                        SchemeModel schemeModel2222222222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject3, jSONObject4, jSONObject5, jSONObject6, jSONObject7, str19, str20, jSONObject8, jSONObject9, jSONObject10, jSONObject11, str13, str14, str21, str22, str23, str24, jSONObject12, str25, str15, str26, jSONObject13);
                                                        schemeModel2222222222.setPlayerCacheKey(str17);
                                                        schemeModel2222222222.setPlayerCacheCodeC(num);
                                                        schemeModel2222222222.setKabrSpts(str16);
                                                        schemeModel2222222222.setRtcHevcUrl(str18);
                                                        schemeModel2222222222.setCommonShareInfo(jSONObject2);
                                                        schemeModel2222222222.setMultiRate(jSONObject);
                                                        schemeModel2222222222.setFromIntent(Boolean.TRUE);
                                                        return schemeModel2222222222;
                                                    }
                                                } catch (Exception e19) {
                                                    e = e19;
                                                    str3 = optString11;
                                                    jSONObject8 = parseJSONObject2;
                                                    jSONObject3 = parseJSONObject;
                                                    str12 = "";
                                                    str13 = str12;
                                                    str14 = str13;
                                                    str15 = optString12;
                                                    str4 = str51;
                                                    str6 = str29;
                                                    str7 = str30;
                                                    str8 = str31;
                                                    str9 = str32;
                                                    str10 = str33;
                                                    str11 = str34;
                                                    jSONObject6 = parseJSONObject3;
                                                    jSONObject4 = parseJSONObject4;
                                                    jSONObject5 = parseJSONObject5;
                                                    jSONObject7 = parseJSONObject6;
                                                    str5 = liveSource;
                                                    num = null;
                                                    str17 = null;
                                                    jSONObject = null;
                                                    str18 = null;
                                                    jSONObject2 = null;
                                                    str19 = null;
                                                    str20 = null;
                                                    jSONObject9 = null;
                                                    jSONObject10 = null;
                                                    jSONObject11 = null;
                                                    str21 = null;
                                                    str22 = null;
                                                    str23 = null;
                                                    str24 = null;
                                                    jSONObject12 = null;
                                                    str25 = null;
                                                    str26 = null;
                                                    jSONObject13 = null;
                                                    exc = e;
                                                    str16 = null;
                                                    exc.printStackTrace();
                                                    SchemeModel schemeModel22222222222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject3, jSONObject4, jSONObject5, jSONObject6, jSONObject7, str19, str20, jSONObject8, jSONObject9, jSONObject10, jSONObject11, str13, str14, str21, str22, str23, str24, jSONObject12, str25, str15, str26, jSONObject13);
                                                    schemeModel22222222222.setPlayerCacheKey(str17);
                                                    schemeModel22222222222.setPlayerCacheCodeC(num);
                                                    schemeModel22222222222.setKabrSpts(str16);
                                                    schemeModel22222222222.setRtcHevcUrl(str18);
                                                    schemeModel22222222222.setCommonShareInfo(jSONObject2);
                                                    schemeModel22222222222.setMultiRate(jSONObject);
                                                    schemeModel22222222222.setFromIntent(Boolean.TRUE);
                                                    return schemeModel22222222222;
                                                }
                                            } catch (Exception e20) {
                                                e = e20;
                                                str3 = optString11;
                                                jSONObject8 = parseJSONObject2;
                                                jSONObject3 = parseJSONObject;
                                                str12 = "";
                                                str13 = str12;
                                                str14 = str13;
                                                str15 = optString12;
                                                str4 = str51;
                                                str6 = str29;
                                                str7 = str30;
                                                str8 = str31;
                                                str9 = str32;
                                                str10 = str33;
                                                str11 = str34;
                                                jSONObject6 = parseJSONObject3;
                                                jSONObject4 = parseJSONObject4;
                                                str5 = liveSource;
                                                num = null;
                                                str17 = null;
                                                jSONObject = null;
                                                str18 = null;
                                                jSONObject2 = null;
                                                jSONObject5 = null;
                                                jSONObject7 = null;
                                                str19 = null;
                                                str20 = null;
                                                jSONObject9 = null;
                                                jSONObject10 = null;
                                                jSONObject11 = null;
                                                str21 = null;
                                                str22 = null;
                                                str23 = null;
                                                str24 = null;
                                                jSONObject12 = null;
                                                str25 = null;
                                                str26 = null;
                                                jSONObject13 = null;
                                                exc = e;
                                                str16 = null;
                                                exc.printStackTrace();
                                                SchemeModel schemeModel222222222222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject3, jSONObject4, jSONObject5, jSONObject6, jSONObject7, str19, str20, jSONObject8, jSONObject9, jSONObject10, jSONObject11, str13, str14, str21, str22, str23, str24, jSONObject12, str25, str15, str26, jSONObject13);
                                                schemeModel222222222222.setPlayerCacheKey(str17);
                                                schemeModel222222222222.setPlayerCacheCodeC(num);
                                                schemeModel222222222222.setKabrSpts(str16);
                                                schemeModel222222222222.setRtcHevcUrl(str18);
                                                schemeModel222222222222.setCommonShareInfo(jSONObject2);
                                                schemeModel222222222222.setMultiRate(jSONObject);
                                                schemeModel222222222222.setFromIntent(Boolean.TRUE);
                                                return schemeModel222222222222;
                                            }
                                        } catch (Exception e21) {
                                            str28 = liveSource;
                                            str3 = optString11;
                                            exc = e21;
                                            str9 = "";
                                            str10 = str9;
                                            str11 = str10;
                                            str12 = str11;
                                            str13 = str12;
                                            str14 = str13;
                                            str15 = optString12;
                                            str4 = str51;
                                            str6 = str29;
                                            str7 = str30;
                                            str8 = str31;
                                        }
                                    } catch (Exception e22) {
                                        str28 = liveSource;
                                        str3 = optString11;
                                        exc = e22;
                                        str8 = "";
                                        str9 = str8;
                                        str10 = str9;
                                        str11 = str10;
                                        str12 = str11;
                                        str13 = str12;
                                        str14 = str13;
                                        str15 = optString12;
                                        str4 = str51;
                                        str6 = str29;
                                        str7 = str30;
                                    }
                                } catch (Exception e23) {
                                    str28 = liveSource;
                                    str3 = optString11;
                                    exc = e23;
                                    str7 = "";
                                    str8 = str7;
                                    str9 = str8;
                                    str10 = str9;
                                    str11 = str10;
                                    str12 = str11;
                                    str13 = str12;
                                    str14 = str13;
                                    str15 = optString12;
                                    str4 = str51;
                                    str6 = str29;
                                }
                            } catch (Exception e24) {
                                str28 = liveSource;
                                str3 = optString11;
                                exc = e24;
                                str6 = "";
                                str7 = str6;
                                str8 = str7;
                                str9 = str8;
                                str10 = str9;
                                str11 = str10;
                                str12 = str11;
                                str13 = str12;
                                str14 = str13;
                                str15 = optString12;
                                str4 = str51;
                            }
                            try {
                                String optString22 = jSONObject22.optString("title");
                                try {
                                    optString7 = jSONObject22.optString("quic");
                                } catch (Exception e25) {
                                    e = e25;
                                    str18 = optString6;
                                    str3 = optString11;
                                    jSONObject8 = parseJSONObject2;
                                    jSONObject3 = parseJSONObject;
                                    str12 = "";
                                    str13 = str12;
                                    str14 = str13;
                                    str15 = optString12;
                                    str4 = str51;
                                    str6 = str29;
                                    str7 = str30;
                                    str8 = str31;
                                    str9 = str32;
                                    str10 = str33;
                                    str11 = str34;
                                    jSONObject6 = parseJSONObject3;
                                    jSONObject4 = parseJSONObject4;
                                    jSONObject5 = parseJSONObject5;
                                    jSONObject9 = parseJSONObject7;
                                    jSONObject12 = parseJSONObject8;
                                    str19 = optString;
                                    str20 = optString2;
                                    str21 = optString3;
                                    str22 = optString4;
                                    str23 = optString5;
                                    str24 = optString22;
                                    jSONObject7 = parseJSONObject6;
                                    str5 = liveSource;
                                    num = null;
                                    str17 = null;
                                    jSONObject = null;
                                    jSONObject2 = null;
                                    jSONObject10 = null;
                                    jSONObject11 = null;
                                    str25 = null;
                                    str26 = null;
                                    jSONObject13 = null;
                                    exc = e;
                                    str16 = null;
                                    exc.printStackTrace();
                                    SchemeModel schemeModel2222222222222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject3, jSONObject4, jSONObject5, jSONObject6, jSONObject7, str19, str20, jSONObject8, jSONObject9, jSONObject10, jSONObject11, str13, str14, str21, str22, str23, str24, jSONObject12, str25, str15, str26, jSONObject13);
                                    schemeModel2222222222222.setPlayerCacheKey(str17);
                                    schemeModel2222222222222.setPlayerCacheCodeC(num);
                                    schemeModel2222222222222.setKabrSpts(str16);
                                    schemeModel2222222222222.setRtcHevcUrl(str18);
                                    schemeModel2222222222222.setCommonShareInfo(jSONObject2);
                                    schemeModel2222222222222.setMultiRate(jSONObject);
                                    schemeModel2222222222222.setFromIntent(Boolean.TRUE);
                                    return schemeModel2222222222222;
                                }
                                try {
                                    optString8 = jSONObject22.optString("highLightUrl");
                                    try {
                                        parseJSONObject9 = MiniJsonUtils.INSTANCE.parseJSONObject(jSONObject22, "introduce_tips");
                                        try {
                                            optString9 = jSONObject22.optString("playerIdentifier");
                                            try {
                                                valueOf = Integer.valueOf(jSONObject22.optInt("codec_id"));
                                                try {
                                                    optString10 = jSONObject22.optString("kabr_spts");
                                                    try {
                                                        str35 = "";
                                                    } catch (Exception e26) {
                                                        e = e26;
                                                        str35 = "";
                                                    }
                                                } catch (Exception e27) {
                                                    e = e27;
                                                    num = valueOf;
                                                    str18 = optString6;
                                                    str3 = optString11;
                                                    jSONObject8 = parseJSONObject2;
                                                    str17 = optString9;
                                                    jSONObject3 = parseJSONObject;
                                                    str12 = "";
                                                    str13 = str12;
                                                    str14 = str13;
                                                    str15 = optString12;
                                                    str4 = str51;
                                                    str6 = str29;
                                                    str7 = str30;
                                                    str8 = str31;
                                                    str9 = str32;
                                                    str10 = str33;
                                                    str11 = str34;
                                                    jSONObject6 = parseJSONObject3;
                                                    jSONObject4 = parseJSONObject4;
                                                    jSONObject5 = parseJSONObject5;
                                                    jSONObject9 = parseJSONObject7;
                                                    jSONObject12 = parseJSONObject8;
                                                    str19 = optString;
                                                    str20 = optString2;
                                                    str21 = optString3;
                                                    str22 = optString4;
                                                    str23 = optString5;
                                                    str24 = optString22;
                                                    str25 = optString7;
                                                    str26 = optString8;
                                                    jSONObject13 = parseJSONObject9;
                                                    jSONObject7 = parseJSONObject6;
                                                    str5 = liveSource;
                                                    jSONObject = null;
                                                    jSONObject2 = null;
                                                    jSONObject10 = null;
                                                    jSONObject11 = null;
                                                    exc = e;
                                                    str16 = null;
                                                    exc.printStackTrace();
                                                    SchemeModel schemeModel22222222222222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject3, jSONObject4, jSONObject5, jSONObject6, jSONObject7, str19, str20, jSONObject8, jSONObject9, jSONObject10, jSONObject11, str13, str14, str21, str22, str23, str24, jSONObject12, str25, str15, str26, jSONObject13);
                                                    schemeModel22222222222222.setPlayerCacheKey(str17);
                                                    schemeModel22222222222222.setPlayerCacheCodeC(num);
                                                    schemeModel22222222222222.setKabrSpts(str16);
                                                    schemeModel22222222222222.setRtcHevcUrl(str18);
                                                    schemeModel22222222222222.setCommonShareInfo(jSONObject2);
                                                    schemeModel22222222222222.setMultiRate(jSONObject);
                                                    schemeModel22222222222222.setFromIntent(Boolean.TRUE);
                                                    return schemeModel22222222222222;
                                                }
                                                try {
                                                    parseJSONObject10 = MiniJsonUtils.INSTANCE.parseJSONObject(jSONObject22, "commonShareInfo");
                                                    try {
                                                        String optString23 = jSONObject22.optString("multirate");
                                                        if (TextUtils.isEmpty(optString23)) {
                                                            str38 = optString10;
                                                            jSONObject14 = null;
                                                        } else {
                                                            str38 = optString10;
                                                            try {
                                                                jSONObject21 = new JSONObject(optString23);
                                                            } catch (Exception unused2) {
                                                                jSONObject21 = null;
                                                            }
                                                            jSONObject14 = jSONObject21;
                                                        }
                                                        try {
                                                            optJSONObject = jSONObject22.optJSONObject("vr");
                                                        } catch (Exception e28) {
                                                            e = e28;
                                                            jSONObject = jSONObject14;
                                                            jSONObject15 = parseJSONObject6;
                                                            str39 = liveSource;
                                                            str36 = str38;
                                                            String str52 = optString11;
                                                            str37 = optString9;
                                                            jSONObject2 = parseJSONObject10;
                                                            num = valueOf;
                                                            str18 = optString6;
                                                            str3 = str52;
                                                            jSONObject8 = parseJSONObject2;
                                                            jSONObject3 = parseJSONObject;
                                                            str12 = str35;
                                                            str13 = str12;
                                                            str14 = str13;
                                                            str15 = optString12;
                                                            str4 = str51;
                                                            str6 = str29;
                                                            str7 = str30;
                                                            str8 = str31;
                                                            str9 = str32;
                                                            str10 = str33;
                                                            str11 = str34;
                                                            jSONObject6 = parseJSONObject3;
                                                            jSONObject4 = parseJSONObject4;
                                                            jSONObject5 = parseJSONObject5;
                                                            jSONObject9 = parseJSONObject7;
                                                            jSONObject12 = parseJSONObject8;
                                                            str19 = optString;
                                                            str20 = optString2;
                                                            str21 = optString3;
                                                            str22 = optString4;
                                                            str23 = optString5;
                                                            str24 = optString22;
                                                            str25 = optString7;
                                                            str26 = optString8;
                                                            jSONObject13 = parseJSONObject9;
                                                        }
                                                    } catch (Exception e29) {
                                                        e = e29;
                                                        String str53 = optString11;
                                                        str36 = optString10;
                                                        str37 = optString9;
                                                        jSONObject2 = parseJSONObject10;
                                                        num = valueOf;
                                                        str18 = optString6;
                                                        str3 = str53;
                                                        jSONObject8 = parseJSONObject2;
                                                        jSONObject3 = parseJSONObject;
                                                        str12 = str35;
                                                        str13 = str12;
                                                        str14 = str13;
                                                        str15 = optString12;
                                                        str4 = str51;
                                                        str6 = str29;
                                                        str7 = str30;
                                                        str8 = str31;
                                                        str9 = str32;
                                                        str10 = str33;
                                                        str11 = str34;
                                                        jSONObject6 = parseJSONObject3;
                                                        jSONObject4 = parseJSONObject4;
                                                        jSONObject5 = parseJSONObject5;
                                                        jSONObject9 = parseJSONObject7;
                                                        jSONObject12 = parseJSONObject8;
                                                        str19 = optString;
                                                        str20 = optString2;
                                                        str21 = optString3;
                                                        str22 = optString4;
                                                        str23 = optString5;
                                                        str24 = optString22;
                                                        str25 = optString7;
                                                        str26 = optString8;
                                                        jSONObject13 = parseJSONObject9;
                                                        jSONObject7 = parseJSONObject6;
                                                        str5 = liveSource;
                                                        jSONObject = null;
                                                    }
                                                } catch (Exception e30) {
                                                    e = e30;
                                                    String str54 = optString11;
                                                    str36 = optString10;
                                                    num = valueOf;
                                                    str37 = optString9;
                                                    str18 = optString6;
                                                    str3 = str54;
                                                    jSONObject8 = parseJSONObject2;
                                                    jSONObject3 = parseJSONObject;
                                                    str12 = str35;
                                                    str13 = str12;
                                                    str14 = str13;
                                                    str15 = optString12;
                                                    str4 = str51;
                                                    str6 = str29;
                                                    str7 = str30;
                                                    str8 = str31;
                                                    str9 = str32;
                                                    str10 = str33;
                                                    str11 = str34;
                                                    jSONObject6 = parseJSONObject3;
                                                    jSONObject4 = parseJSONObject4;
                                                    jSONObject5 = parseJSONObject5;
                                                    jSONObject9 = parseJSONObject7;
                                                    jSONObject12 = parseJSONObject8;
                                                    str19 = optString;
                                                    str20 = optString2;
                                                    str21 = optString3;
                                                    str22 = optString4;
                                                    str23 = optString5;
                                                    str24 = optString22;
                                                    str25 = optString7;
                                                    str26 = optString8;
                                                    jSONObject13 = parseJSONObject9;
                                                    jSONObject7 = parseJSONObject6;
                                                    str5 = liveSource;
                                                    jSONObject = null;
                                                    jSONObject2 = null;
                                                    jSONObject10 = null;
                                                    jSONObject11 = null;
                                                    exc = e;
                                                    str16 = str36;
                                                    str17 = str37;
                                                    exc.printStackTrace();
                                                    SchemeModel schemeModel222222222222222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject3, jSONObject4, jSONObject5, jSONObject6, jSONObject7, str19, str20, jSONObject8, jSONObject9, jSONObject10, jSONObject11, str13, str14, str21, str22, str23, str24, jSONObject12, str25, str15, str26, jSONObject13);
                                                    schemeModel222222222222222.setPlayerCacheKey(str17);
                                                    schemeModel222222222222222.setPlayerCacheCodeC(num);
                                                    schemeModel222222222222222.setKabrSpts(str16);
                                                    schemeModel222222222222222.setRtcHevcUrl(str18);
                                                    schemeModel222222222222222.setCommonShareInfo(jSONObject2);
                                                    schemeModel222222222222222.setMultiRate(jSONObject);
                                                    schemeModel222222222222222.setFromIntent(Boolean.TRUE);
                                                    return schemeModel222222222222222;
                                                }
                                            } catch (Exception e31) {
                                                e = e31;
                                                str18 = optString6;
                                                str3 = optString11;
                                                jSONObject8 = parseJSONObject2;
                                                str17 = optString9;
                                                jSONObject3 = parseJSONObject;
                                                str12 = "";
                                                str13 = str12;
                                                str14 = str13;
                                                str15 = optString12;
                                                str4 = str51;
                                                str6 = str29;
                                                str7 = str30;
                                                str8 = str31;
                                                str9 = str32;
                                                str10 = str33;
                                                str11 = str34;
                                                jSONObject6 = parseJSONObject3;
                                                jSONObject4 = parseJSONObject4;
                                                jSONObject5 = parseJSONObject5;
                                                jSONObject9 = parseJSONObject7;
                                                jSONObject12 = parseJSONObject8;
                                                str19 = optString;
                                                str20 = optString2;
                                                str21 = optString3;
                                                str22 = optString4;
                                                str23 = optString5;
                                                str24 = optString22;
                                                str25 = optString7;
                                                str26 = optString8;
                                                jSONObject13 = parseJSONObject9;
                                                jSONObject7 = parseJSONObject6;
                                                str5 = liveSource;
                                                num = null;
                                            }
                                        } catch (Exception e32) {
                                            e = e32;
                                            str18 = optString6;
                                            str3 = optString11;
                                            jSONObject8 = parseJSONObject2;
                                            jSONObject3 = parseJSONObject;
                                            str12 = "";
                                            str13 = str12;
                                            str14 = str13;
                                            str15 = optString12;
                                            str4 = str51;
                                            str6 = str29;
                                            str7 = str30;
                                            str8 = str31;
                                            str9 = str32;
                                            str10 = str33;
                                            str11 = str34;
                                            jSONObject6 = parseJSONObject3;
                                            jSONObject4 = parseJSONObject4;
                                            jSONObject5 = parseJSONObject5;
                                            jSONObject9 = parseJSONObject7;
                                            jSONObject12 = parseJSONObject8;
                                            str19 = optString;
                                            str20 = optString2;
                                            str21 = optString3;
                                            str22 = optString4;
                                            str23 = optString5;
                                            str24 = optString22;
                                            str25 = optString7;
                                            str26 = optString8;
                                            jSONObject13 = parseJSONObject9;
                                            jSONObject7 = parseJSONObject6;
                                            str5 = liveSource;
                                            num = null;
                                            str17 = null;
                                        }
                                    } catch (Exception e33) {
                                        e = e33;
                                        str18 = optString6;
                                        str3 = optString11;
                                        jSONObject8 = parseJSONObject2;
                                        jSONObject3 = parseJSONObject;
                                        str12 = "";
                                        str13 = str12;
                                        str14 = str13;
                                        str15 = optString12;
                                        str4 = str51;
                                        str6 = str29;
                                        str7 = str30;
                                        str8 = str31;
                                        str9 = str32;
                                        str10 = str33;
                                        str11 = str34;
                                        jSONObject6 = parseJSONObject3;
                                        jSONObject4 = parseJSONObject4;
                                        jSONObject5 = parseJSONObject5;
                                        jSONObject9 = parseJSONObject7;
                                        jSONObject12 = parseJSONObject8;
                                        str19 = optString;
                                        str20 = optString2;
                                        str21 = optString3;
                                        str22 = optString4;
                                        str23 = optString5;
                                        str24 = optString22;
                                        str25 = optString7;
                                        str26 = optString8;
                                        jSONObject7 = parseJSONObject6;
                                        str5 = liveSource;
                                        num = null;
                                        str17 = null;
                                        jSONObject = null;
                                        jSONObject2 = null;
                                        jSONObject10 = null;
                                        jSONObject11 = null;
                                        jSONObject13 = null;
                                        exc = e;
                                        str16 = null;
                                        exc.printStackTrace();
                                        SchemeModel schemeModel2222222222222222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject3, jSONObject4, jSONObject5, jSONObject6, jSONObject7, str19, str20, jSONObject8, jSONObject9, jSONObject10, jSONObject11, str13, str14, str21, str22, str23, str24, jSONObject12, str25, str15, str26, jSONObject13);
                                        schemeModel2222222222222222.setPlayerCacheKey(str17);
                                        schemeModel2222222222222222.setPlayerCacheCodeC(num);
                                        schemeModel2222222222222222.setKabrSpts(str16);
                                        schemeModel2222222222222222.setRtcHevcUrl(str18);
                                        schemeModel2222222222222222.setCommonShareInfo(jSONObject2);
                                        schemeModel2222222222222222.setMultiRate(jSONObject);
                                        schemeModel2222222222222222.setFromIntent(Boolean.TRUE);
                                        return schemeModel2222222222222222;
                                    }
                                } catch (Exception e34) {
                                    e = e34;
                                    str18 = optString6;
                                    str3 = optString11;
                                    jSONObject8 = parseJSONObject2;
                                    jSONObject3 = parseJSONObject;
                                    str12 = "";
                                    str13 = str12;
                                    str14 = str13;
                                    str15 = optString12;
                                    str4 = str51;
                                    str6 = str29;
                                    str7 = str30;
                                    str8 = str31;
                                    str9 = str32;
                                    str10 = str33;
                                    str11 = str34;
                                    jSONObject6 = parseJSONObject3;
                                    jSONObject4 = parseJSONObject4;
                                    jSONObject5 = parseJSONObject5;
                                    jSONObject9 = parseJSONObject7;
                                    jSONObject12 = parseJSONObject8;
                                    str19 = optString;
                                    str20 = optString2;
                                    str21 = optString3;
                                    str22 = optString4;
                                    str23 = optString5;
                                    str24 = optString22;
                                    str25 = optString7;
                                    jSONObject7 = parseJSONObject6;
                                    str5 = liveSource;
                                    num = null;
                                    str17 = null;
                                    jSONObject = null;
                                    jSONObject2 = null;
                                    jSONObject10 = null;
                                    jSONObject11 = null;
                                    str26 = null;
                                    jSONObject13 = null;
                                    exc = e;
                                    str16 = null;
                                    exc.printStackTrace();
                                    SchemeModel schemeModel22222222222222222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject3, jSONObject4, jSONObject5, jSONObject6, jSONObject7, str19, str20, jSONObject8, jSONObject9, jSONObject10, jSONObject11, str13, str14, str21, str22, str23, str24, jSONObject12, str25, str15, str26, jSONObject13);
                                    schemeModel22222222222222222.setPlayerCacheKey(str17);
                                    schemeModel22222222222222222.setPlayerCacheCodeC(num);
                                    schemeModel22222222222222222.setKabrSpts(str16);
                                    schemeModel22222222222222222.setRtcHevcUrl(str18);
                                    schemeModel22222222222222222.setCommonShareInfo(jSONObject2);
                                    schemeModel22222222222222222.setMultiRate(jSONObject);
                                    schemeModel22222222222222222.setFromIntent(Boolean.TRUE);
                                    return schemeModel22222222222222222;
                                }
                                try {
                                    try {
                                        try {
                                            try {
                                                try {
                                                    try {
                                                        if (optJSONObject != null || str2 == null) {
                                                            jSONObject16 = optJSONObject;
                                                            num2 = valueOf;
                                                        } else {
                                                            jSONObject16 = optJSONObject;
                                                            try {
                                                                num2 = valueOf;
                                                                try {
                                                                    queryParameter = Uri.parse(str2).getQueryParameter("params");
                                                                } catch (Throwable th) {
                                                                    th = th;
                                                                    try {
                                                                        th.printStackTrace();
                                                                        jSONObject17 = jSONObject16;
                                                                        if (parseJSONObject == null) {
                                                                        }
                                                                        if (parseJSONObject6 != null) {
                                                                        }
                                                                        str47 = str35;
                                                                        optJSONObject2 = jSONObject22.optJSONObject("queryECLive");
                                                                        optJSONObject3 = jSONObject22.optJSONObject("hlReplay");
                                                                        String str55 = str38;
                                                                        String str56 = optString11;
                                                                        str49 = optString11;
                                                                        num = num2;
                                                                        str37 = str40;
                                                                        jSONObject20 = jSONObject14;
                                                                        str36 = str55;
                                                                        str50 = str41;
                                                                        jSONObject19 = parseJSONObject6;
                                                                        str48 = liveSource;
                                                                        JSONObject jSONObject23 = jSONObject17;
                                                                        SchemeModel schemeModel3 = new SchemeModel(str56, str51, liveSource, str29, str30, str31, str32, str33, str34, str47, jSONObject18, parseJSONObject4, parseJSONObject5, parseJSONObject3, jSONObject19, optString, optString2, parseJSONObject2, parseJSONObject7, optJSONObject2, optJSONObject3, str44, str45, optString3, optString4, optString5, optString22, parseJSONObject8, optString7, optString12, optString8, parseJSONObject9);
                                                                        schemeModel3.setPlayerCacheKey(str37);
                                                                        schemeModel3.setPlayerCacheCodeC(num);
                                                                        schemeModel3.setKabrSpts(str36);
                                                                        jSONObject = jSONObject20;
                                                                        schemeModel3.setMultiRate(jSONObject);
                                                                        str18 = str50;
                                                                        schemeModel3.setRtcHevcUrl(str18);
                                                                        jSONObject2 = parseJSONObject10;
                                                                        schemeModel3.setCommonShareInfo(jSONObject2);
                                                                        schemeModel3.setFromIntent(Boolean.TRUE);
                                                                        schemeModel3.setVrParams(jSONObject23);
                                                                        return schemeModel3;
                                                                    } catch (Exception e35) {
                                                                        jSONObject8 = parseJSONObject2;
                                                                        jSONObject = jSONObject14;
                                                                        str3 = optString11;
                                                                        jSONObject3 = parseJSONObject;
                                                                        str17 = optString9;
                                                                        str18 = optString6;
                                                                        jSONObject7 = parseJSONObject6;
                                                                        str5 = liveSource;
                                                                        str12 = str35;
                                                                        str13 = str12;
                                                                        str14 = str13;
                                                                        str15 = optString12;
                                                                        str4 = str51;
                                                                        str6 = str29;
                                                                        str7 = str30;
                                                                        str8 = str31;
                                                                        str9 = str32;
                                                                        str10 = str33;
                                                                        str11 = str34;
                                                                        jSONObject6 = parseJSONObject3;
                                                                        jSONObject4 = parseJSONObject4;
                                                                        jSONObject5 = parseJSONObject5;
                                                                        jSONObject9 = parseJSONObject7;
                                                                        jSONObject12 = parseJSONObject8;
                                                                        str19 = optString;
                                                                        str20 = optString2;
                                                                        str21 = optString3;
                                                                        str22 = optString4;
                                                                        str23 = optString5;
                                                                        str24 = optString22;
                                                                        str25 = optString7;
                                                                        str26 = optString8;
                                                                        jSONObject13 = parseJSONObject9;
                                                                        jSONObject10 = null;
                                                                        jSONObject11 = null;
                                                                        exc = e35;
                                                                        jSONObject2 = parseJSONObject10;
                                                                        num = num2;
                                                                        str16 = str38;
                                                                        exc.printStackTrace();
                                                                        SchemeModel schemeModel222222222222222222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject3, jSONObject4, jSONObject5, jSONObject6, jSONObject7, str19, str20, jSONObject8, jSONObject9, jSONObject10, jSONObject11, str13, str14, str21, str22, str23, str24, jSONObject12, str25, str15, str26, jSONObject13);
                                                                        schemeModel222222222222222222.setPlayerCacheKey(str17);
                                                                        schemeModel222222222222222222.setPlayerCacheCodeC(num);
                                                                        schemeModel222222222222222222.setKabrSpts(str16);
                                                                        schemeModel222222222222222222.setRtcHevcUrl(str18);
                                                                        schemeModel222222222222222222.setCommonShareInfo(jSONObject2);
                                                                        schemeModel222222222222222222.setMultiRate(jSONObject);
                                                                        schemeModel222222222222222222.setFromIntent(Boolean.TRUE);
                                                                        return schemeModel222222222222222222;
                                                                    }
                                                                }
                                                            } catch (Throwable th2) {
                                                                th = th2;
                                                                num2 = valueOf;
                                                            }
                                                            if (queryParameter != null) {
                                                                jSONObject17 = new JSONObject(queryParameter).optJSONObject("vr");
                                                                if (parseJSONObject == null) {
                                                                    JSONObject jSONObject24 = new JSONObject();
                                                                    JSONObject jSONObject25 = new JSONObject();
                                                                    jSONObject25.put("source", liveSource);
                                                                    Unit unit = Unit.INSTANCE;
                                                                    jSONObject24.put("ext", jSONObject25);
                                                                    Unit unit2 = Unit.INSTANCE;
                                                                    jSONObject18 = jSONObject24;
                                                                    str40 = optString9;
                                                                    str41 = optString6;
                                                                    str44 = str35;
                                                                    str45 = str44;
                                                                } else {
                                                                    try {
                                                                        JSONObject optJSONObject4 = parseJSONObject.optJSONObject("ext");
                                                                        str40 = optString9;
                                                                        if (optJSONObject4 != null) {
                                                                            try {
                                                                                String optString24 = optJSONObject4.optString("share_uid");
                                                                                try {
                                                                                    str43 = optJSONObject4.optString("zb_tag");
                                                                                } catch (JSONException unused3) {
                                                                                    str43 = str35;
                                                                                } catch (Exception e36) {
                                                                                    e = e36;
                                                                                    jSONObject8 = parseJSONObject2;
                                                                                    jSONObject2 = parseJSONObject10;
                                                                                    jSONObject = jSONObject14;
                                                                                    str3 = optString11;
                                                                                    jSONObject3 = parseJSONObject;
                                                                                    str18 = optString6;
                                                                                    jSONObject7 = parseJSONObject6;
                                                                                    str5 = liveSource;
                                                                                    str12 = str35;
                                                                                    str14 = str12;
                                                                                    str17 = str40;
                                                                                    num = num2;
                                                                                    str13 = optString24;
                                                                                }
                                                                                try {
                                                                                    Unit unit3 = Unit.INSTANCE;
                                                                                    str46 = str43;
                                                                                    str41 = optString6;
                                                                                    str42 = optString24;
                                                                                } catch (JSONException unused4) {
                                                                                    str41 = optString6;
                                                                                    str42 = optString24;
                                                                                    jSONObject18 = parseJSONObject;
                                                                                    str44 = str42;
                                                                                    str45 = str43;
                                                                                    if (parseJSONObject6 != null) {
                                                                                    }
                                                                                    str47 = str35;
                                                                                    optJSONObject2 = jSONObject22.optJSONObject("queryECLive");
                                                                                    optJSONObject3 = jSONObject22.optJSONObject("hlReplay");
                                                                                    String str552 = str38;
                                                                                    String str562 = optString11;
                                                                                    str49 = optString11;
                                                                                    num = num2;
                                                                                    str37 = str40;
                                                                                    jSONObject20 = jSONObject14;
                                                                                    str36 = str552;
                                                                                    str50 = str41;
                                                                                    jSONObject19 = parseJSONObject6;
                                                                                    str48 = liveSource;
                                                                                    JSONObject jSONObject232 = jSONObject17;
                                                                                    SchemeModel schemeModel32 = new SchemeModel(str562, str51, liveSource, str29, str30, str31, str32, str33, str34, str47, jSONObject18, parseJSONObject4, parseJSONObject5, parseJSONObject3, jSONObject19, optString, optString2, parseJSONObject2, parseJSONObject7, optJSONObject2, optJSONObject3, str44, str45, optString3, optString4, optString5, optString22, parseJSONObject8, optString7, optString12, optString8, parseJSONObject9);
                                                                                    schemeModel32.setPlayerCacheKey(str37);
                                                                                    schemeModel32.setPlayerCacheCodeC(num);
                                                                                    schemeModel32.setKabrSpts(str36);
                                                                                    jSONObject = jSONObject20;
                                                                                    schemeModel32.setMultiRate(jSONObject);
                                                                                    str18 = str50;
                                                                                    schemeModel32.setRtcHevcUrl(str18);
                                                                                    jSONObject2 = parseJSONObject10;
                                                                                    schemeModel32.setCommonShareInfo(jSONObject2);
                                                                                    schemeModel32.setFromIntent(Boolean.TRUE);
                                                                                    schemeModel32.setVrParams(jSONObject232);
                                                                                    return schemeModel32;
                                                                                } catch (Exception e37) {
                                                                                    e = e37;
                                                                                    jSONObject8 = parseJSONObject2;
                                                                                    jSONObject2 = parseJSONObject10;
                                                                                    jSONObject = jSONObject14;
                                                                                    str3 = optString11;
                                                                                    jSONObject3 = parseJSONObject;
                                                                                    str18 = optString6;
                                                                                    jSONObject7 = parseJSONObject6;
                                                                                    str5 = liveSource;
                                                                                    str12 = str35;
                                                                                    str17 = str40;
                                                                                    num = num2;
                                                                                    str13 = optString24;
                                                                                    str14 = str43;
                                                                                    str15 = optString12;
                                                                                    str4 = str51;
                                                                                    str6 = str29;
                                                                                    str7 = str30;
                                                                                    str8 = str31;
                                                                                    str9 = str32;
                                                                                    str10 = str33;
                                                                                    str11 = str34;
                                                                                    jSONObject6 = parseJSONObject3;
                                                                                    jSONObject4 = parseJSONObject4;
                                                                                    jSONObject5 = parseJSONObject5;
                                                                                    jSONObject9 = parseJSONObject7;
                                                                                    jSONObject12 = parseJSONObject8;
                                                                                    str19 = optString;
                                                                                    str20 = optString2;
                                                                                    str21 = optString3;
                                                                                    str22 = optString4;
                                                                                    str23 = optString5;
                                                                                    str24 = optString22;
                                                                                    str25 = optString7;
                                                                                    str26 = optString8;
                                                                                    jSONObject13 = parseJSONObject9;
                                                                                    jSONObject10 = null;
                                                                                    jSONObject11 = null;
                                                                                    exc = e;
                                                                                    str16 = str38;
                                                                                    exc.printStackTrace();
                                                                                    SchemeModel schemeModel2222222222222222222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject3, jSONObject4, jSONObject5, jSONObject6, jSONObject7, str19, str20, jSONObject8, jSONObject9, jSONObject10, jSONObject11, str13, str14, str21, str22, str23, str24, jSONObject12, str25, str15, str26, jSONObject13);
                                                                                    schemeModel2222222222222222222.setPlayerCacheKey(str17);
                                                                                    schemeModel2222222222222222222.setPlayerCacheCodeC(num);
                                                                                    schemeModel2222222222222222222.setKabrSpts(str16);
                                                                                    schemeModel2222222222222222222.setRtcHevcUrl(str18);
                                                                                    schemeModel2222222222222222222.setCommonShareInfo(jSONObject2);
                                                                                    schemeModel2222222222222222222.setMultiRate(jSONObject);
                                                                                    schemeModel2222222222222222222.setFromIntent(Boolean.TRUE);
                                                                                    return schemeModel2222222222222222222;
                                                                                }
                                                                            } catch (JSONException unused5) {
                                                                                str41 = optString6;
                                                                                str42 = str35;
                                                                                str43 = str42;
                                                                                jSONObject18 = parseJSONObject;
                                                                                str44 = str42;
                                                                                str45 = str43;
                                                                                if (parseJSONObject6 != null) {
                                                                                }
                                                                                str47 = str35;
                                                                                optJSONObject2 = jSONObject22.optJSONObject("queryECLive");
                                                                                optJSONObject3 = jSONObject22.optJSONObject("hlReplay");
                                                                                String str5522 = str38;
                                                                                String str5622 = optString11;
                                                                                str49 = optString11;
                                                                                num = num2;
                                                                                str37 = str40;
                                                                                jSONObject20 = jSONObject14;
                                                                                str36 = str5522;
                                                                                str50 = str41;
                                                                                jSONObject19 = parseJSONObject6;
                                                                                str48 = liveSource;
                                                                                JSONObject jSONObject2322 = jSONObject17;
                                                                                SchemeModel schemeModel322 = new SchemeModel(str5622, str51, liveSource, str29, str30, str31, str32, str33, str34, str47, jSONObject18, parseJSONObject4, parseJSONObject5, parseJSONObject3, jSONObject19, optString, optString2, parseJSONObject2, parseJSONObject7, optJSONObject2, optJSONObject3, str44, str45, optString3, optString4, optString5, optString22, parseJSONObject8, optString7, optString12, optString8, parseJSONObject9);
                                                                                schemeModel322.setPlayerCacheKey(str37);
                                                                                schemeModel322.setPlayerCacheCodeC(num);
                                                                                schemeModel322.setKabrSpts(str36);
                                                                                jSONObject = jSONObject20;
                                                                                schemeModel322.setMultiRate(jSONObject);
                                                                                str18 = str50;
                                                                                schemeModel322.setRtcHevcUrl(str18);
                                                                                jSONObject2 = parseJSONObject10;
                                                                                schemeModel322.setCommonShareInfo(jSONObject2);
                                                                                schemeModel322.setFromIntent(Boolean.TRUE);
                                                                                schemeModel322.setVrParams(jSONObject2322);
                                                                                return schemeModel322;
                                                                            } catch (Exception e38) {
                                                                                e = e38;
                                                                                jSONObject8 = parseJSONObject2;
                                                                                jSONObject2 = parseJSONObject10;
                                                                                jSONObject = jSONObject14;
                                                                                str3 = optString11;
                                                                                jSONObject3 = parseJSONObject;
                                                                                str18 = optString6;
                                                                                jSONObject7 = parseJSONObject6;
                                                                                str5 = liveSource;
                                                                                str12 = str35;
                                                                                str13 = str12;
                                                                                str14 = str13;
                                                                                str17 = str40;
                                                                                num = num2;
                                                                            }
                                                                        } else {
                                                                            str41 = optString6;
                                                                            str42 = str35;
                                                                            str46 = str42;
                                                                        }
                                                                        try {
                                                                            if (optJSONObject4 == null) {
                                                                                JSONObject jSONObject26 = new JSONObject();
                                                                                jSONObject26.put("source", liveSource);
                                                                                jSONObject26.put("share_uid", str42);
                                                                                jSONObject26.put("zb_tag", str46);
                                                                                Unit unit4 = Unit.INSTANCE;
                                                                                parseJSONObject.put("ext", jSONObject26);
                                                                            } else if (!optJSONObject4.has("source")) {
                                                                                optJSONObject4.put("source", liveSource);
                                                                                optJSONObject4.put("share_uid", str42);
                                                                                optJSONObject4.put("zb_tag", str46);
                                                                            }
                                                                            jSONObject18 = parseJSONObject;
                                                                            str44 = str42;
                                                                            str45 = str46;
                                                                        } catch (JSONException unused6) {
                                                                            str43 = str46;
                                                                            jSONObject18 = parseJSONObject;
                                                                            str44 = str42;
                                                                            str45 = str43;
                                                                            if (parseJSONObject6 != null) {
                                                                            }
                                                                            str47 = str35;
                                                                            optJSONObject2 = jSONObject22.optJSONObject("queryECLive");
                                                                            optJSONObject3 = jSONObject22.optJSONObject("hlReplay");
                                                                            String str55222 = str38;
                                                                            String str56222 = optString11;
                                                                            str49 = optString11;
                                                                            num = num2;
                                                                            str37 = str40;
                                                                            jSONObject20 = jSONObject14;
                                                                            str36 = str55222;
                                                                            str50 = str41;
                                                                            jSONObject19 = parseJSONObject6;
                                                                            str48 = liveSource;
                                                                            JSONObject jSONObject23222 = jSONObject17;
                                                                            SchemeModel schemeModel3222 = new SchemeModel(str56222, str51, liveSource, str29, str30, str31, str32, str33, str34, str47, jSONObject18, parseJSONObject4, parseJSONObject5, parseJSONObject3, jSONObject19, optString, optString2, parseJSONObject2, parseJSONObject7, optJSONObject2, optJSONObject3, str44, str45, optString3, optString4, optString5, optString22, parseJSONObject8, optString7, optString12, optString8, parseJSONObject9);
                                                                            schemeModel3222.setPlayerCacheKey(str37);
                                                                            schemeModel3222.setPlayerCacheCodeC(num);
                                                                            schemeModel3222.setKabrSpts(str36);
                                                                            jSONObject = jSONObject20;
                                                                            schemeModel3222.setMultiRate(jSONObject);
                                                                            str18 = str50;
                                                                            schemeModel3222.setRtcHevcUrl(str18);
                                                                            jSONObject2 = parseJSONObject10;
                                                                            schemeModel3222.setCommonShareInfo(jSONObject2);
                                                                            schemeModel3222.setFromIntent(Boolean.TRUE);
                                                                            schemeModel3222.setVrParams(jSONObject23222);
                                                                            return schemeModel3222;
                                                                        } catch (Exception e39) {
                                                                            e = e39;
                                                                            jSONObject8 = parseJSONObject2;
                                                                            jSONObject2 = parseJSONObject10;
                                                                            jSONObject = jSONObject14;
                                                                            str3 = optString11;
                                                                            jSONObject3 = parseJSONObject;
                                                                            str13 = str42;
                                                                            jSONObject7 = parseJSONObject6;
                                                                            str5 = liveSource;
                                                                            str14 = str46;
                                                                            str12 = str35;
                                                                            str17 = str40;
                                                                            num = num2;
                                                                            str18 = str41;
                                                                            str15 = optString12;
                                                                            str4 = str51;
                                                                            str6 = str29;
                                                                            str7 = str30;
                                                                            str8 = str31;
                                                                            str9 = str32;
                                                                            str10 = str33;
                                                                            str11 = str34;
                                                                            jSONObject6 = parseJSONObject3;
                                                                            jSONObject4 = parseJSONObject4;
                                                                            jSONObject5 = parseJSONObject5;
                                                                            jSONObject9 = parseJSONObject7;
                                                                            jSONObject12 = parseJSONObject8;
                                                                            str19 = optString;
                                                                            str20 = optString2;
                                                                            str21 = optString3;
                                                                            str22 = optString4;
                                                                            str23 = optString5;
                                                                            str24 = optString22;
                                                                            str25 = optString7;
                                                                            str26 = optString8;
                                                                            jSONObject13 = parseJSONObject9;
                                                                            jSONObject10 = null;
                                                                            jSONObject11 = null;
                                                                            exc = e;
                                                                            str16 = str38;
                                                                            exc.printStackTrace();
                                                                            SchemeModel schemeModel22222222222222222222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject3, jSONObject4, jSONObject5, jSONObject6, jSONObject7, str19, str20, jSONObject8, jSONObject9, jSONObject10, jSONObject11, str13, str14, str21, str22, str23, str24, jSONObject12, str25, str15, str26, jSONObject13);
                                                                            schemeModel22222222222222222222.setPlayerCacheKey(str17);
                                                                            schemeModel22222222222222222222.setPlayerCacheCodeC(num);
                                                                            schemeModel22222222222222222222.setKabrSpts(str16);
                                                                            schemeModel22222222222222222222.setRtcHevcUrl(str18);
                                                                            schemeModel22222222222222222222.setCommonShareInfo(jSONObject2);
                                                                            schemeModel22222222222222222222.setMultiRate(jSONObject);
                                                                            schemeModel22222222222222222222.setFromIntent(Boolean.TRUE);
                                                                            return schemeModel22222222222222222222;
                                                                        }
                                                                    } catch (JSONException unused7) {
                                                                        str40 = optString9;
                                                                    } catch (Exception e40) {
                                                                        e = e40;
                                                                        str40 = optString9;
                                                                        str41 = optString6;
                                                                        jSONObject8 = parseJSONObject2;
                                                                        jSONObject2 = parseJSONObject10;
                                                                        jSONObject = jSONObject14;
                                                                        str3 = optString11;
                                                                        jSONObject3 = parseJSONObject;
                                                                        jSONObject7 = parseJSONObject6;
                                                                        str5 = liveSource;
                                                                        str12 = str35;
                                                                        str13 = str12;
                                                                        str14 = str13;
                                                                    }
                                                                }
                                                                if (parseJSONObject6 != null) {
                                                                    try {
                                                                        JSONObject optJSONObject5 = parseJSONObject6.optJSONObject("ext");
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
                                                                                    str47 = optString25;
                                                                                    optJSONObject2 = jSONObject22.optJSONObject("queryECLive");
                                                                                    optJSONObject3 = jSONObject22.optJSONObject("hlReplay");
                                                                                    String str552222 = str38;
                                                                                    String str562222 = optString11;
                                                                                    str49 = optString11;
                                                                                    num = num2;
                                                                                    str37 = str40;
                                                                                    jSONObject20 = jSONObject14;
                                                                                    str36 = str552222;
                                                                                    str50 = str41;
                                                                                    jSONObject19 = parseJSONObject6;
                                                                                    str48 = liveSource;
                                                                                    JSONObject jSONObject232222 = jSONObject17;
                                                                                    SchemeModel schemeModel32222 = new SchemeModel(str562222, str51, liveSource, str29, str30, str31, str32, str33, str34, str47, jSONObject18, parseJSONObject4, parseJSONObject5, parseJSONObject3, jSONObject19, optString, optString2, parseJSONObject2, parseJSONObject7, optJSONObject2, optJSONObject3, str44, str45, optString3, optString4, optString5, optString22, parseJSONObject8, optString7, optString12, optString8, parseJSONObject9);
                                                                                    schemeModel32222.setPlayerCacheKey(str37);
                                                                                    schemeModel32222.setPlayerCacheCodeC(num);
                                                                                    schemeModel32222.setKabrSpts(str36);
                                                                                    jSONObject = jSONObject20;
                                                                                    schemeModel32222.setMultiRate(jSONObject);
                                                                                    str18 = str50;
                                                                                    schemeModel32222.setRtcHevcUrl(str18);
                                                                                    jSONObject2 = parseJSONObject10;
                                                                                    schemeModel32222.setCommonShareInfo(jSONObject2);
                                                                                    schemeModel32222.setFromIntent(Boolean.TRUE);
                                                                                    schemeModel32222.setVrParams(jSONObject232222);
                                                                                    return schemeModel32222;
                                                                                }
                                                                            } catch (Exception e41) {
                                                                                e = e41;
                                                                                jSONObject8 = parseJSONObject2;
                                                                                jSONObject3 = jSONObject18;
                                                                                jSONObject2 = parseJSONObject10;
                                                                                jSONObject = jSONObject14;
                                                                                str3 = optString11;
                                                                                str12 = optString25;
                                                                                jSONObject7 = parseJSONObject6;
                                                                                str5 = liveSource;
                                                                                str17 = str40;
                                                                                num = num2;
                                                                                str18 = str41;
                                                                                str15 = optString12;
                                                                                str4 = str51;
                                                                                str6 = str29;
                                                                                str7 = str30;
                                                                                str8 = str31;
                                                                                str9 = str32;
                                                                                str10 = str33;
                                                                                str11 = str34;
                                                                                jSONObject6 = parseJSONObject3;
                                                                                jSONObject4 = parseJSONObject4;
                                                                                jSONObject5 = parseJSONObject5;
                                                                                jSONObject9 = parseJSONObject7;
                                                                                jSONObject12 = parseJSONObject8;
                                                                                str19 = optString;
                                                                                str20 = optString2;
                                                                                str21 = optString3;
                                                                                str22 = optString4;
                                                                                str23 = optString5;
                                                                                str24 = optString22;
                                                                                str25 = optString7;
                                                                                str26 = optString8;
                                                                                jSONObject13 = parseJSONObject9;
                                                                                str13 = str44;
                                                                                str14 = str45;
                                                                                jSONObject10 = null;
                                                                                jSONObject11 = null;
                                                                                exc = e;
                                                                                str16 = str38;
                                                                                exc.printStackTrace();
                                                                                SchemeModel schemeModel222222222222222222222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject3, jSONObject4, jSONObject5, jSONObject6, jSONObject7, str19, str20, jSONObject8, jSONObject9, jSONObject10, jSONObject11, str13, str14, str21, str22, str23, str24, jSONObject12, str25, str15, str26, jSONObject13);
                                                                                schemeModel222222222222222222222.setPlayerCacheKey(str17);
                                                                                schemeModel222222222222222222222.setPlayerCacheCodeC(num);
                                                                                schemeModel222222222222222222222.setKabrSpts(str16);
                                                                                schemeModel222222222222222222222.setRtcHevcUrl(str18);
                                                                                schemeModel222222222222222222222.setCommonShareInfo(jSONObject2);
                                                                                schemeModel222222222222222222222.setMultiRate(jSONObject);
                                                                                schemeModel222222222222222222222.setFromIntent(Boolean.TRUE);
                                                                                return schemeModel222222222222222222222;
                                                                            }
                                                                        }
                                                                    } catch (Exception e42) {
                                                                        e = e42;
                                                                        jSONObject8 = parseJSONObject2;
                                                                        jSONObject3 = jSONObject18;
                                                                        jSONObject2 = parseJSONObject10;
                                                                        jSONObject = jSONObject14;
                                                                        str3 = optString11;
                                                                        jSONObject7 = parseJSONObject6;
                                                                        str5 = liveSource;
                                                                        str12 = str35;
                                                                    }
                                                                }
                                                                str47 = str35;
                                                                optJSONObject2 = jSONObject22.optJSONObject("queryECLive");
                                                                optJSONObject3 = jSONObject22.optJSONObject("hlReplay");
                                                                String str5522222 = str38;
                                                                String str5622222 = optString11;
                                                                str49 = optString11;
                                                                num = num2;
                                                                str37 = str40;
                                                                jSONObject20 = jSONObject14;
                                                                str36 = str5522222;
                                                                str50 = str41;
                                                                jSONObject19 = parseJSONObject6;
                                                                str48 = liveSource;
                                                                JSONObject jSONObject2322222 = jSONObject17;
                                                                SchemeModel schemeModel322222 = new SchemeModel(str5622222, str51, liveSource, str29, str30, str31, str32, str33, str34, str47, jSONObject18, parseJSONObject4, parseJSONObject5, parseJSONObject3, jSONObject19, optString, optString2, parseJSONObject2, parseJSONObject7, optJSONObject2, optJSONObject3, str44, str45, optString3, optString4, optString5, optString22, parseJSONObject8, optString7, optString12, optString8, parseJSONObject9);
                                                                schemeModel322222.setPlayerCacheKey(str37);
                                                                schemeModel322222.setPlayerCacheCodeC(num);
                                                                schemeModel322222.setKabrSpts(str36);
                                                                jSONObject = jSONObject20;
                                                                schemeModel322222.setMultiRate(jSONObject);
                                                                str18 = str50;
                                                                schemeModel322222.setRtcHevcUrl(str18);
                                                                jSONObject2 = parseJSONObject10;
                                                                schemeModel322222.setCommonShareInfo(jSONObject2);
                                                                schemeModel322222.setFromIntent(Boolean.TRUE);
                                                                schemeModel322222.setVrParams(jSONObject2322222);
                                                                return schemeModel322222;
                                                            }
                                                        }
                                                        schemeModel322222.setCommonShareInfo(jSONObject2);
                                                        schemeModel322222.setFromIntent(Boolean.TRUE);
                                                        schemeModel322222.setVrParams(jSONObject2322222);
                                                        return schemeModel322222;
                                                    } catch (Exception e43) {
                                                        e = e43;
                                                        str3 = str49;
                                                        jSONObject8 = parseJSONObject2;
                                                        str12 = str47;
                                                        jSONObject3 = jSONObject18;
                                                        jSONObject11 = optJSONObject3;
                                                        str15 = optString12;
                                                        str4 = str51;
                                                        str6 = str29;
                                                        str7 = str30;
                                                        str8 = str31;
                                                        str9 = str32;
                                                        str10 = str33;
                                                        str11 = str34;
                                                        jSONObject6 = parseJSONObject3;
                                                        jSONObject4 = parseJSONObject4;
                                                        jSONObject5 = parseJSONObject5;
                                                        jSONObject9 = parseJSONObject7;
                                                        jSONObject12 = parseJSONObject8;
                                                        str19 = optString;
                                                        str20 = optString2;
                                                        str21 = optString3;
                                                        str22 = optString4;
                                                        str23 = optString5;
                                                        str24 = optString22;
                                                        str25 = optString7;
                                                        str26 = optString8;
                                                        jSONObject13 = parseJSONObject9;
                                                        str13 = str44;
                                                        str14 = str45;
                                                        jSONObject10 = optJSONObject2;
                                                        jSONObject7 = jSONObject19;
                                                        str5 = str48;
                                                        exc = e;
                                                        str16 = str36;
                                                        str17 = str37;
                                                        exc.printStackTrace();
                                                        SchemeModel schemeModel2222222222222222222222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject3, jSONObject4, jSONObject5, jSONObject6, jSONObject7, str19, str20, jSONObject8, jSONObject9, jSONObject10, jSONObject11, str13, str14, str21, str22, str23, str24, jSONObject12, str25, str15, str26, jSONObject13);
                                                        schemeModel2222222222222222222222.setPlayerCacheKey(str17);
                                                        schemeModel2222222222222222222222.setPlayerCacheCodeC(num);
                                                        schemeModel2222222222222222222222.setKabrSpts(str16);
                                                        schemeModel2222222222222222222222.setRtcHevcUrl(str18);
                                                        schemeModel2222222222222222222222.setCommonShareInfo(jSONObject2);
                                                        schemeModel2222222222222222222222.setMultiRate(jSONObject);
                                                        schemeModel2222222222222222222222.setFromIntent(Boolean.TRUE);
                                                        return schemeModel2222222222222222222222;
                                                    }
                                                    schemeModel322222.setMultiRate(jSONObject);
                                                    str18 = str50;
                                                    schemeModel322222.setRtcHevcUrl(str18);
                                                    jSONObject2 = parseJSONObject10;
                                                } catch (Exception e44) {
                                                    e = e44;
                                                    jSONObject2 = parseJSONObject10;
                                                    str18 = str50;
                                                }
                                                SchemeModel schemeModel3222222 = new SchemeModel(str5622222, str51, liveSource, str29, str30, str31, str32, str33, str34, str47, jSONObject18, parseJSONObject4, parseJSONObject5, parseJSONObject3, jSONObject19, optString, optString2, parseJSONObject2, parseJSONObject7, optJSONObject2, optJSONObject3, str44, str45, optString3, optString4, optString5, optString22, parseJSONObject8, optString7, optString12, optString8, parseJSONObject9);
                                                schemeModel3222222.setPlayerCacheKey(str37);
                                                schemeModel3222222.setPlayerCacheCodeC(num);
                                                schemeModel3222222.setKabrSpts(str36);
                                                jSONObject = jSONObject20;
                                            } catch (Exception e45) {
                                                e = e45;
                                                jSONObject2 = parseJSONObject10;
                                                str18 = str50;
                                                jSONObject = jSONObject20;
                                            }
                                            String str55222222 = str38;
                                            String str56222222 = optString11;
                                            str49 = optString11;
                                            num = num2;
                                            str37 = str40;
                                            jSONObject20 = jSONObject14;
                                            str36 = str55222222;
                                            str50 = str41;
                                            jSONObject19 = parseJSONObject6;
                                            str48 = liveSource;
                                            JSONObject jSONObject23222222 = jSONObject17;
                                        } catch (Exception e46) {
                                            e = e46;
                                            jSONObject2 = parseJSONObject10;
                                            jSONObject = jSONObject14;
                                            jSONObject19 = parseJSONObject6;
                                            str48 = liveSource;
                                            num = num2;
                                            str18 = str41;
                                            str36 = str38;
                                            str49 = optString11;
                                            str37 = str40;
                                        }
                                        optJSONObject3 = jSONObject22.optJSONObject("hlReplay");
                                    } catch (Exception e47) {
                                        e = e47;
                                        jSONObject2 = parseJSONObject10;
                                        jSONObject = jSONObject14;
                                        num = num2;
                                        str18 = str41;
                                        str36 = str38;
                                        String str57 = optString11;
                                        str37 = str40;
                                        str3 = str57;
                                        jSONObject8 = parseJSONObject2;
                                        str12 = str47;
                                        jSONObject3 = jSONObject18;
                                        str15 = optString12;
                                        str4 = str51;
                                        str6 = str29;
                                        str7 = str30;
                                        str8 = str31;
                                        str9 = str32;
                                        str10 = str33;
                                        str11 = str34;
                                        jSONObject6 = parseJSONObject3;
                                        jSONObject4 = parseJSONObject4;
                                        jSONObject5 = parseJSONObject5;
                                        jSONObject9 = parseJSONObject7;
                                        jSONObject12 = parseJSONObject8;
                                        str19 = optString;
                                        str20 = optString2;
                                        str21 = optString3;
                                        str22 = optString4;
                                        str23 = optString5;
                                        str24 = optString22;
                                        str25 = optString7;
                                        str26 = optString8;
                                        jSONObject13 = parseJSONObject9;
                                        str13 = str44;
                                        str14 = str45;
                                        jSONObject10 = optJSONObject2;
                                        jSONObject7 = parseJSONObject6;
                                        str5 = liveSource;
                                        jSONObject11 = null;
                                        exc = e;
                                        str16 = str36;
                                        str17 = str37;
                                        exc.printStackTrace();
                                        SchemeModel schemeModel22222222222222222222222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject3, jSONObject4, jSONObject5, jSONObject6, jSONObject7, str19, str20, jSONObject8, jSONObject9, jSONObject10, jSONObject11, str13, str14, str21, str22, str23, str24, jSONObject12, str25, str15, str26, jSONObject13);
                                        schemeModel22222222222222222222222.setPlayerCacheKey(str17);
                                        schemeModel22222222222222222222222.setPlayerCacheCodeC(num);
                                        schemeModel22222222222222222222222.setKabrSpts(str16);
                                        schemeModel22222222222222222222222.setRtcHevcUrl(str18);
                                        schemeModel22222222222222222222222.setCommonShareInfo(jSONObject2);
                                        schemeModel22222222222222222222222.setMultiRate(jSONObject);
                                        schemeModel22222222222222222222222.setFromIntent(Boolean.TRUE);
                                        return schemeModel22222222222222222222222;
                                    }
                                    optJSONObject2 = jSONObject22.optJSONObject("queryECLive");
                                } catch (Exception e48) {
                                    e = e48;
                                    jSONObject2 = parseJSONObject10;
                                    jSONObject = jSONObject14;
                                    jSONObject15 = parseJSONObject6;
                                    str39 = liveSource;
                                    num = num2;
                                    str18 = str41;
                                    str36 = str38;
                                    String str58 = optString11;
                                    str37 = str40;
                                    str3 = str58;
                                    jSONObject8 = parseJSONObject2;
                                    str12 = str47;
                                    jSONObject3 = jSONObject18;
                                    str15 = optString12;
                                    str4 = str51;
                                    str6 = str29;
                                    str7 = str30;
                                    str8 = str31;
                                    str9 = str32;
                                    str10 = str33;
                                    str11 = str34;
                                    jSONObject6 = parseJSONObject3;
                                    jSONObject4 = parseJSONObject4;
                                    jSONObject5 = parseJSONObject5;
                                    jSONObject9 = parseJSONObject7;
                                    jSONObject12 = parseJSONObject8;
                                    str19 = optString;
                                    str20 = optString2;
                                    str21 = optString3;
                                    str22 = optString4;
                                    str23 = optString5;
                                    str24 = optString22;
                                    str25 = optString7;
                                    str26 = optString8;
                                    jSONObject13 = parseJSONObject9;
                                    str13 = str44;
                                    str14 = str45;
                                    jSONObject7 = jSONObject15;
                                    str5 = str39;
                                    jSONObject10 = null;
                                    jSONObject11 = null;
                                    exc = e;
                                    str16 = str36;
                                    str17 = str37;
                                    exc.printStackTrace();
                                    SchemeModel schemeModel222222222222222222222222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject3, jSONObject4, jSONObject5, jSONObject6, jSONObject7, str19, str20, jSONObject8, jSONObject9, jSONObject10, jSONObject11, str13, str14, str21, str22, str23, str24, jSONObject12, str25, str15, str26, jSONObject13);
                                    schemeModel222222222222222222222222.setPlayerCacheKey(str17);
                                    schemeModel222222222222222222222222.setPlayerCacheCodeC(num);
                                    schemeModel222222222222222222222222.setKabrSpts(str16);
                                    schemeModel222222222222222222222222.setRtcHevcUrl(str18);
                                    schemeModel222222222222222222222222.setCommonShareInfo(jSONObject2);
                                    schemeModel222222222222222222222222.setMultiRate(jSONObject);
                                    schemeModel222222222222222222222222.setFromIntent(Boolean.TRUE);
                                    return schemeModel222222222222222222222222;
                                }
                                jSONObject17 = jSONObject16;
                                if (parseJSONObject == null) {
                                }
                                if (parseJSONObject6 != null) {
                                }
                                str47 = str35;
                            } catch (Exception e49) {
                                e = e49;
                                str18 = optString6;
                                str3 = optString11;
                                jSONObject8 = parseJSONObject2;
                                jSONObject3 = parseJSONObject;
                                str12 = "";
                                str13 = str12;
                                str14 = str13;
                                str15 = optString12;
                                str4 = str51;
                                str6 = str29;
                                str7 = str30;
                                str8 = str31;
                                str9 = str32;
                                str10 = str33;
                                str11 = str34;
                                jSONObject6 = parseJSONObject3;
                                jSONObject4 = parseJSONObject4;
                                jSONObject5 = parseJSONObject5;
                                jSONObject9 = parseJSONObject7;
                                jSONObject12 = parseJSONObject8;
                                str19 = optString;
                                str20 = optString2;
                                str21 = optString3;
                                str22 = optString4;
                                str23 = optString5;
                                jSONObject7 = parseJSONObject6;
                                str5 = liveSource;
                                num = null;
                                str17 = null;
                                jSONObject = null;
                                jSONObject2 = null;
                                jSONObject10 = null;
                                jSONObject11 = null;
                                str24 = null;
                                str25 = null;
                                str26 = null;
                                jSONObject13 = null;
                                exc = e;
                                str16 = null;
                                exc.printStackTrace();
                                SchemeModel schemeModel2222222222222222222222222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject3, jSONObject4, jSONObject5, jSONObject6, jSONObject7, str19, str20, jSONObject8, jSONObject9, jSONObject10, jSONObject11, str13, str14, str21, str22, str23, str24, jSONObject12, str25, str15, str26, jSONObject13);
                                schemeModel2222222222222222222222222.setPlayerCacheKey(str17);
                                schemeModel2222222222222222222222222.setPlayerCacheCodeC(num);
                                schemeModel2222222222222222222222222.setKabrSpts(str16);
                                schemeModel2222222222222222222222222.setRtcHevcUrl(str18);
                                schemeModel2222222222222222222222222.setCommonShareInfo(jSONObject2);
                                schemeModel2222222222222222222222222.setMultiRate(jSONObject);
                                schemeModel2222222222222222222222222.setFromIntent(Boolean.TRUE);
                                return schemeModel2222222222222222222222222;
                            }
                        } catch (Exception e50) {
                            str3 = optString11;
                            exc = e50;
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
                            str15 = optString12;
                            str4 = str51;
                        }
                    } catch (Exception e51) {
                        str3 = optString11;
                        exc = e51;
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
                        str15 = optString12;
                    }
                } catch (Exception e52) {
                    str27 = "";
                    str3 = optString11;
                    exc = e52;
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
                    str16 = null;
                    num = null;
                    str17 = null;
                    jSONObject = null;
                    str18 = null;
                    jSONObject2 = null;
                    jSONObject3 = null;
                    jSONObject4 = null;
                    jSONObject5 = null;
                    jSONObject6 = null;
                    jSONObject7 = null;
                    str19 = null;
                    str20 = null;
                    jSONObject8 = null;
                    jSONObject9 = null;
                    jSONObject10 = null;
                    jSONObject11 = null;
                    str21 = null;
                    str22 = null;
                    str23 = null;
                    str24 = null;
                    jSONObject12 = null;
                    str25 = null;
                    str26 = null;
                    jSONObject13 = null;
                    exc.printStackTrace();
                    SchemeModel schemeModel22222222222222222222222222 = new SchemeModel(str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, jSONObject3, jSONObject4, jSONObject5, jSONObject6, jSONObject7, str19, str20, jSONObject8, jSONObject9, jSONObject10, jSONObject11, str13, str14, str21, str22, str23, str24, jSONObject12, str25, str15, str26, jSONObject13);
                    schemeModel22222222222222222222222222.setPlayerCacheKey(str17);
                    schemeModel22222222222222222222222222.setPlayerCacheCodeC(num);
                    schemeModel22222222222222222222222222.setKabrSpts(str16);
                    schemeModel22222222222222222222222222.setRtcHevcUrl(str18);
                    schemeModel22222222222222222222222222.setCommonShareInfo(jSONObject2);
                    schemeModel22222222222222222222222222.setMultiRate(jSONObject);
                    schemeModel22222222222222222222222222.setFromIntent(Boolean.TRUE);
                    return schemeModel22222222222222222222222222;
                }
            } catch (Exception e53) {
                exc = e53;
                str3 = "";
                str4 = str3;
            }
        }

        public Companion() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final boolean getBanQuestionFromSearchDialog() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
                return invokeV.booleanValue;
            }
            return IntentData.banQuestionFromSearchDialog;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getLiveSource(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                try {
                    String optString = new JSONObject(str).optString("livesource");
                    Intrinsics.checkExpressionValueIsNotNull(optString, "json.optString(\"livesource\")");
                    return optString;
                } catch (JSONException unused) {
                    return str;
                }
            }
            return (String) invokeL.objValue;
        }

        public final SchemeModel parseSchemeData(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                return parseSchemeData(str, null);
            }
            return (SchemeModel) invokeL.objValue;
        }

        public final void setBanQuestionFromSearchDialog(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048580, this, z) != null) {
                return;
            }
            IntentData.banQuestionFromSearchDialog = z;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(433234922, "Lcom/baidu/searchbox/live/frame/IntentData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(433234922, "Lcom/baidu/searchbox/live/frame/IntentData;");
                return;
            }
        }
        Companion = new Companion(null);
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.id : (String) invokeV.objValue;
    }

    public final String component2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.source : (String) invokeV.objValue;
    }

    public final String component3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.scheme : (String) invokeV.objValue;
    }

    public final SchemeModel component4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.model : (SchemeModel) invokeV.objValue;
    }

    public final String component5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.tpl : (String) invokeV.objValue;
    }

    public final String component6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.extReq : (String) invokeV.objValue;
    }

    public final IntentData copy(String str, String str2, String str3, SchemeModel schemeModel, String str4, String str5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, str2, str3, schemeModel, str4, str5})) == null) ? new IntentData(str, str2, str3, schemeModel, str4, str5) : (IntentData) invokeCommon.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof IntentData) {
                    IntentData intentData = (IntentData) obj;
                    return Intrinsics.areEqual(this.id, intentData.id) && Intrinsics.areEqual(this.source, intentData.source) && Intrinsics.areEqual(this.scheme, intentData.scheme) && Intrinsics.areEqual(this.model, intentData.model) && Intrinsics.areEqual(this.tpl, intentData.tpl) && Intrinsics.areEqual(this.extReq, intentData.extReq);
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
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
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return "IntentData(id=" + this.id + ", source=" + this.source + ", scheme=" + this.scheme + ", model=" + this.model + ", tpl=" + this.tpl + ", extReq=" + this.extReq + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bA\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\bT\b\u0086\b\u0018\u0000Bó\u0002\u0012\u0006\u0010%\u001a\u00020\u0001\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010'\u001a\u00020\u0001\u0012\b\b\u0002\u0010(\u001a\u00020\u0001\u0012\b\b\u0002\u0010)\u001a\u00020\u0001\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010-\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u0005¢\u0006\u0006\b\u009e\u0001\u0010\u009f\u0001J\u0010\u0010\u0002\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0003J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\f\u0010\u0003J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\r\u0010\u0003J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0007J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0007J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0003J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0007J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0007J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0003J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0003J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0003J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0003J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0003J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0003J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0007J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0003J\u0010\u0010\u001b\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0003J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0003J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0003J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0007J\u0010\u0010\u001f\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0003J\u0010\u0010 \u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b \u0010\u0003J\u0012\u0010!\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b!\u0010\u0003J\u0012\u0010\"\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\"\u0010\u0003J\u0012\u0010#\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b#\u0010\u0003J\u0012\u0010$\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b$\u0010\u0003J\u0088\u0003\u0010E\u001a\u00020\u00002\b\b\u0002\u0010%\u001a\u00020\u00012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010'\u001a\u00020\u00012\b\b\u0002\u0010(\u001a\u00020\u00012\b\b\u0002\u0010)\u001a\u00020\u00012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\bE\u0010FJ\u001a\u0010J\u001a\u00020I2\b\u0010H\u001a\u0004\u0018\u00010GHÖ\u0003¢\u0006\u0004\bJ\u0010KJ\u0010\u0010M\u001a\u00020LHÖ\u0001¢\u0006\u0004\bM\u0010NJ\r\u0010O\u001a\u00020\u0001¢\u0006\u0004\bO\u0010\u0003J\u0010\u0010P\u001a\u00020\u0001HÖ\u0001¢\u0006\u0004\bP\u0010\u0003R\u001b\u00104\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010Q\u001a\u0004\bR\u0010\u0003R\u001b\u0010<\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010Q\u001a\u0004\bS\u0010\u0003R$\u0010T\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010\u0007\"\u0004\bW\u0010XR\u0019\u0010(\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010Q\u001a\u0004\bY\u0010\u0003R\u001b\u0010/\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010U\u001a\u0004\bZ\u0010\u0007R\u001b\u00101\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010U\u001a\u0004\b[\u0010\u0007R\u001b\u00103\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010U\u001a\u0004\b\\\u0010\u0007R\u001b\u00100\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010U\u001a\u0004\b]\u0010\u0007R\u001b\u0010+\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010Q\u001a\u0004\b^\u0010\u0003R$\u0010_\u001a\u0004\u0018\u00010I8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u001b\u0010=\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010Q\u001a\u0004\be\u0010\u0003R\u001b\u0010C\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010Q\u001a\u0004\bf\u0010\u0003R$\u00109\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010U\u001a\u0004\bg\u0010\u0007\"\u0004\bh\u0010XR$\u0010D\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010U\u001a\u0004\bi\u0010\u0007\"\u0004\bj\u0010XR\u001b\u0010B\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\bB\u0010Q\u001a\u0004\bk\u0010\u0003R$\u00107\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010U\u001a\u0004\bl\u0010\u0007\"\u0004\bm\u0010XR$\u0010n\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bn\u0010Q\u001a\u0004\bo\u0010\u0003\"\u0004\bp\u0010qR$\u0010.\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010Q\u001a\u0004\br\u0010\u0003\"\u0004\bs\u0010qR$\u0010t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bt\u0010U\u001a\u0004\bu\u0010\u0007\"\u0004\bv\u0010XR$\u00106\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u0010U\u001a\u0004\bw\u0010\u0007\"\u0004\bx\u0010XR\u0019\u0010)\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010Q\u001a\u0004\by\u0010\u0003R$\u0010z\u001a\u0004\u0018\u00010L8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR(\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0080\u0001\u0010Q\u001a\u0005\b\u0081\u0001\u0010\u0003\"\u0005\b\u0082\u0001\u0010qR&\u00102\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b2\u0010U\u001a\u0005\b\u0083\u0001\u0010\u0007\"\u0005\b\u0084\u0001\u0010XR\u001c\u0010A\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\r\n\u0004\bA\u0010Q\u001a\u0005\b\u0085\u0001\u0010\u0003R\u001a\u0010%\u001a\u00020\u00018\u0006@\u0006¢\u0006\r\n\u0004\b%\u0010Q\u001a\u0005\b\u0086\u0001\u0010\u0003R&\u0010&\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b&\u0010Q\u001a\u0005\b\u0087\u0001\u0010\u0003\"\u0005\b\u0088\u0001\u0010qR(\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0089\u0001\u0010Q\u001a\u0005\b\u008a\u0001\u0010\u0003\"\u0005\b\u008b\u0001\u0010qR\u001c\u0010>\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\r\n\u0004\b>\u0010Q\u001a\u0005\b\u008c\u0001\u0010\u0003R\u001c\u0010,\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\r\n\u0004\b,\u0010Q\u001a\u0005\b\u008d\u0001\u0010\u0003R&\u00108\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b8\u0010U\u001a\u0005\b\u008e\u0001\u0010\u0007\"\u0005\b\u008f\u0001\u0010XR&\u0010;\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b;\u0010Q\u001a\u0005\b\u0090\u0001\u0010\u0003\"\u0005\b\u0091\u0001\u0010qR\u001c\u0010@\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\r\n\u0004\b@\u0010U\u001a\u0005\b\u0092\u0001\u0010\u0007R&\u0010:\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b:\u0010Q\u001a\u0005\b\u0093\u0001\u0010\u0003\"\u0005\b\u0094\u0001\u0010qR\u001a\u0010'\u001a\u00020\u00018\u0006@\u0006¢\u0006\r\n\u0004\b'\u0010Q\u001a\u0005\b\u0095\u0001\u0010\u0003R\u001c\u0010*\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\r\n\u0004\b*\u0010Q\u001a\u0005\b\u0096\u0001\u0010\u0003R\u001c\u0010-\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\r\n\u0004\b-\u0010Q\u001a\u0005\b\u0097\u0001\u0010\u0003R&\u00105\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b5\u0010Q\u001a\u0005\b\u0098\u0001\u0010\u0003\"\u0005\b\u0099\u0001\u0010qR\u001c\u0010?\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\r\n\u0004\b?\u0010Q\u001a\u0005\b\u009a\u0001\u0010\u0003R(\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u009b\u0001\u0010U\u001a\u0005\b\u009c\u0001\u0010\u0007\"\u0005\b\u009d\u0001\u0010X¨\u0006 \u0001"}, d2 = {"Lcom/baidu/searchbox/live/frame/IntentData$SchemeModel;", "", "component1", "()Ljava/lang/String;", "component10", "Lorg/json/JSONObject;", "component11", "()Lorg/json/JSONObject;", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component4", "component5", "component6", "component7", "component8", "component9", "roomId", "roomType", "source", AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, "playUrl", "status", "format", "screen", MediaTrackConfig.AE_IMPORT_TEMPLATE, "liveBackScheme", "ext", "extRequest", "extLog", "query", "extParams", "askId", "templateId", "otherParams", "invokePop", "searchIntoLiveJson", "hlReplyIntoLive", "shareUid", "shareTag", "avcUrl", "hevcUrl", "rtcUrl", "title", "shareTaskInfo", "quic", "inviterId", "highlightUrl", "introduceTips", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)Lcom/baidu/searchbox/live/frame/IntentData$SchemeModel;", "", ImageViewerConfig.FROM_OTHER, "", "equals", "(Ljava/lang/Object;)Z", "", TTDownloadField.TT_HASHCODE, "()I", "toSchemeParams", "toString", "Ljava/lang/String;", "getAskId", "getAvcUrl", "commonShareInfo", "Lorg/json/JSONObject;", "getCommonShareInfo", "setCommonShareInfo", "(Lorg/json/JSONObject;)V", "getCover", "getExt", "getExtLog", "getExtParams", "getExtRequest", "getFormat", "fromIntent", "Ljava/lang/Boolean;", "getFromIntent", "()Ljava/lang/Boolean;", "setFromIntent", "(Ljava/lang/Boolean;)V", "getHevcUrl", "getHighlightUrl", "getHlReplyIntoLive", "setHlReplyIntoLive", "getIntroduceTips", "setIntroduceTips", "getInviterId", "getInvokePop", "setInvokePop", "kabrSpts", "getKabrSpts", "setKabrSpts", "(Ljava/lang/String;)V", "getLiveBackScheme", "setLiveBackScheme", "multiRate", "getMultiRate", "setMultiRate", "getOtherParams", "setOtherParams", "getPlayUrl", "playerCacheCodeC", "Ljava/lang/Integer;", "getPlayerCacheCodeC", "()Ljava/lang/Integer;", "setPlayerCacheCodeC", "(Ljava/lang/Integer;)V", "playerCacheKey", "getPlayerCacheKey", "setPlayerCacheKey", "getQuery", "setQuery", "getQuic", "getRoomId", "getRoomType", "setRoomType", "rtcHevcUrl", "getRtcHevcUrl", "setRtcHevcUrl", "getRtcUrl", "getScreen", "getSearchIntoLiveJson", "setSearchIntoLiveJson", "getShareTag", "setShareTag", "getShareTaskInfo", "getShareUid", "setShareUid", "getSource", "getStatus", "getTemplate", "getTemplateId", "setTemplateId", "getTitle", "vrParams", "getVrParams", "setVrParams", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class SchemeModel {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
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
        public JSONObject introduceTips;
        public final String inviterId;
        public JSONObject invokePop;
        public String kabrSpts;
        public String liveBackScheme;
        public JSONObject multiRate;
        public JSONObject otherParams;
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
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.roomId : (String) invokeV.objValue;
        }

        public final String component10() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.liveBackScheme : (String) invokeV.objValue;
        }

        public final JSONObject component11() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.ext : (JSONObject) invokeV.objValue;
        }

        public final JSONObject component12() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.extRequest : (JSONObject) invokeV.objValue;
        }

        public final JSONObject component13() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.extLog : (JSONObject) invokeV.objValue;
        }

        public final JSONObject component14() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.query : (JSONObject) invokeV.objValue;
        }

        public final JSONObject component15() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.extParams : (JSONObject) invokeV.objValue;
        }

        public final String component16() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.askId : (String) invokeV.objValue;
        }

        public final String component17() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.templateId : (String) invokeV.objValue;
        }

        public final JSONObject component18() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.otherParams : (JSONObject) invokeV.objValue;
        }

        public final JSONObject component19() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.invokePop : (JSONObject) invokeV.objValue;
        }

        public final String component2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.roomType : (String) invokeV.objValue;
        }

        public final JSONObject component20() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.searchIntoLiveJson : (JSONObject) invokeV.objValue;
        }

        public final JSONObject component21() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.hlReplyIntoLive : (JSONObject) invokeV.objValue;
        }

        public final String component22() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.shareUid : (String) invokeV.objValue;
        }

        public final String component23() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.shareTag : (String) invokeV.objValue;
        }

        public final String component24() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.avcUrl : (String) invokeV.objValue;
        }

        public final String component25() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.hevcUrl : (String) invokeV.objValue;
        }

        public final String component26() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.rtcUrl : (String) invokeV.objValue;
        }

        public final String component27() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.title : (String) invokeV.objValue;
        }

        public final JSONObject component28() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.shareTaskInfo : (JSONObject) invokeV.objValue;
        }

        public final String component29() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.quic : (String) invokeV.objValue;
        }

        public final String component3() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.source : (String) invokeV.objValue;
        }

        public final String component30() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.inviterId : (String) invokeV.objValue;
        }

        public final String component31() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.highlightUrl : (String) invokeV.objValue;
        }

        public final JSONObject component32() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.introduceTips : (JSONObject) invokeV.objValue;
        }

        public final String component4() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.cover : (String) invokeV.objValue;
        }

        public final String component5() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.playUrl : (String) invokeV.objValue;
        }

        public final String component6() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.status : (String) invokeV.objValue;
        }

        public final String component7() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.format : (String) invokeV.objValue;
        }

        public final String component8() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.screen : (String) invokeV.objValue;
        }

        public final String component9() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.template : (String) invokeV.objValue;
        }

        public final SchemeModel copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5, String str11, String str12, JSONObject jSONObject6, JSONObject jSONObject7, JSONObject jSONObject8, JSONObject jSONObject9, String str13, String str14, String str15, String str16, String str17, String str18, JSONObject jSONObject10, String str19, String str20, String str21, JSONObject jSONObject11) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048608, this, new Object[]{str, str2, str3, str4, str5, str6, str7, str8, str9, str10, jSONObject, jSONObject2, jSONObject3, jSONObject4, jSONObject5, str11, str12, jSONObject6, jSONObject7, jSONObject8, jSONObject9, str13, str14, str15, str16, str17, str18, jSONObject10, str19, str20, str21, jSONObject11})) == null) ? new SchemeModel(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, jSONObject, jSONObject2, jSONObject3, jSONObject4, jSONObject5, str11, str12, jSONObject6, jSONObject7, jSONObject8, jSONObject9, str13, str14, str15, str16, str17, str18, jSONObject10, str19, str20, str21, jSONObject11) : (SchemeModel) invokeCommon.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, obj)) == null) {
                if (this != obj) {
                    if (obj instanceof SchemeModel) {
                        SchemeModel schemeModel = (SchemeModel) obj;
                        return Intrinsics.areEqual(this.roomId, schemeModel.roomId) && Intrinsics.areEqual(this.roomType, schemeModel.roomType) && Intrinsics.areEqual(this.source, schemeModel.source) && Intrinsics.areEqual(this.cover, schemeModel.cover) && Intrinsics.areEqual(this.playUrl, schemeModel.playUrl) && Intrinsics.areEqual(this.status, schemeModel.status) && Intrinsics.areEqual(this.format, schemeModel.format) && Intrinsics.areEqual(this.screen, schemeModel.screen) && Intrinsics.areEqual(this.template, schemeModel.template) && Intrinsics.areEqual(this.liveBackScheme, schemeModel.liveBackScheme) && Intrinsics.areEqual(this.ext, schemeModel.ext) && Intrinsics.areEqual(this.extRequest, schemeModel.extRequest) && Intrinsics.areEqual(this.extLog, schemeModel.extLog) && Intrinsics.areEqual(this.query, schemeModel.query) && Intrinsics.areEqual(this.extParams, schemeModel.extParams) && Intrinsics.areEqual(this.askId, schemeModel.askId) && Intrinsics.areEqual(this.templateId, schemeModel.templateId) && Intrinsics.areEqual(this.otherParams, schemeModel.otherParams) && Intrinsics.areEqual(this.invokePop, schemeModel.invokePop) && Intrinsics.areEqual(this.searchIntoLiveJson, schemeModel.searchIntoLiveJson) && Intrinsics.areEqual(this.hlReplyIntoLive, schemeModel.hlReplyIntoLive) && Intrinsics.areEqual(this.shareUid, schemeModel.shareUid) && Intrinsics.areEqual(this.shareTag, schemeModel.shareTag) && Intrinsics.areEqual(this.avcUrl, schemeModel.avcUrl) && Intrinsics.areEqual(this.hevcUrl, schemeModel.hevcUrl) && Intrinsics.areEqual(this.rtcUrl, schemeModel.rtcUrl) && Intrinsics.areEqual(this.title, schemeModel.title) && Intrinsics.areEqual(this.shareTaskInfo, schemeModel.shareTaskInfo) && Intrinsics.areEqual(this.quic, schemeModel.quic) && Intrinsics.areEqual(this.inviterId, schemeModel.inviterId) && Intrinsics.areEqual(this.highlightUrl, schemeModel.highlightUrl) && Intrinsics.areEqual(this.introduceTips, schemeModel.introduceTips);
                    }
                    return false;
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
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
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
                return "SchemeModel(roomId=" + this.roomId + ", roomType=" + this.roomType + ", source=" + this.source + ", cover=" + this.cover + ", playUrl=" + this.playUrl + ", status=" + this.status + ", format=" + this.format + ", screen=" + this.screen + ", template=" + this.template + ", liveBackScheme=" + this.liveBackScheme + ", ext=" + this.ext + ", extRequest=" + this.extRequest + ", extLog=" + this.extLog + ", query=" + this.query + ", extParams=" + this.extParams + ", askId=" + this.askId + ", templateId=" + this.templateId + ", otherParams=" + this.otherParams + ", invokePop=" + this.invokePop + ", searchIntoLiveJson=" + this.searchIntoLiveJson + ", hlReplyIntoLive=" + this.hlReplyIntoLive + ", shareUid=" + this.shareUid + ", shareTag=" + this.shareTag + ", avcUrl=" + this.avcUrl + ", hevcUrl=" + this.hevcUrl + ", rtcUrl=" + this.rtcUrl + ", title=" + this.title + ", shareTaskInfo=" + this.shareTaskInfo + ", quic=" + this.quic + ", inviterId=" + this.inviterId + ", highlightUrl=" + this.highlightUrl + ", introduceTips=" + this.introduceTips + SmallTailInfo.EMOTION_SUFFIX;
            }
            return (String) invokeV.objValue;
        }

        public SchemeModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5, String str11, String str12, JSONObject jSONObject6, JSONObject jSONObject7, JSONObject jSONObject8, JSONObject jSONObject9, String str13, String str14, String str15, String str16, String str17, String str18, JSONObject jSONObject10, String str19, String str20, String str21, JSONObject jSONObject11) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3, str4, str5, str6, str7, str8, str9, str10, jSONObject, jSONObject2, jSONObject3, jSONObject4, jSONObject5, str11, str12, jSONObject6, jSONObject7, jSONObject8, jSONObject9, str13, str14, str15, str16, str17, str18, jSONObject10, str19, str20, str21, jSONObject11};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
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
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
                return this.askId;
            }
            return (String) invokeV.objValue;
        }

        public final String getAvcUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
                return this.avcUrl;
            }
            return (String) invokeV.objValue;
        }

        public final JSONObject getCommonShareInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
                return this.commonShareInfo;
            }
            return (JSONObject) invokeV.objValue;
        }

        public final String getCover() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
                return this.cover;
            }
            return (String) invokeV.objValue;
        }

        public final JSONObject getExt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
                return this.ext;
            }
            return (JSONObject) invokeV.objValue;
        }

        public final JSONObject getExtLog() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
                return this.extLog;
            }
            return (JSONObject) invokeV.objValue;
        }

        public final JSONObject getExtParams() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
                return this.extParams;
            }
            return (JSONObject) invokeV.objValue;
        }

        public final JSONObject getExtRequest() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
                return this.extRequest;
            }
            return (JSONObject) invokeV.objValue;
        }

        public final String getFormat() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
                return this.format;
            }
            return (String) invokeV.objValue;
        }

        public final Boolean getFromIntent() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
                return this.fromIntent;
            }
            return (Boolean) invokeV.objValue;
        }

        public final String getHevcUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
                return this.hevcUrl;
            }
            return (String) invokeV.objValue;
        }

        public final String getHighlightUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
                return this.highlightUrl;
            }
            return (String) invokeV.objValue;
        }

        public final JSONObject getHlReplyIntoLive() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
                return this.hlReplyIntoLive;
            }
            return (JSONObject) invokeV.objValue;
        }

        public final JSONObject getIntroduceTips() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
                return this.introduceTips;
            }
            return (JSONObject) invokeV.objValue;
        }

        public final String getInviterId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
                return this.inviterId;
            }
            return (String) invokeV.objValue;
        }

        public final JSONObject getInvokePop() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
                return this.invokePop;
            }
            return (JSONObject) invokeV.objValue;
        }

        public final String getKabrSpts() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
                return this.kabrSpts;
            }
            return (String) invokeV.objValue;
        }

        public final String getLiveBackScheme() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
                return this.liveBackScheme;
            }
            return (String) invokeV.objValue;
        }

        public final JSONObject getMultiRate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
                return this.multiRate;
            }
            return (JSONObject) invokeV.objValue;
        }

        public final JSONObject getOtherParams() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
                return this.otherParams;
            }
            return (JSONObject) invokeV.objValue;
        }

        public final String getPlayUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
                return this.playUrl;
            }
            return (String) invokeV.objValue;
        }

        public final Integer getPlayerCacheCodeC() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
                return this.playerCacheCodeC;
            }
            return (Integer) invokeV.objValue;
        }

        public final String getPlayerCacheKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
                return this.playerCacheKey;
            }
            return (String) invokeV.objValue;
        }

        public final JSONObject getQuery() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
                return this.query;
            }
            return (JSONObject) invokeV.objValue;
        }

        public final String getQuic() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
                return this.quic;
            }
            return (String) invokeV.objValue;
        }

        public final String getRoomId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
                return this.roomId;
            }
            return (String) invokeV.objValue;
        }

        public final String getRoomType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
                return this.roomType;
            }
            return (String) invokeV.objValue;
        }

        public final String getRtcHevcUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
                return this.rtcHevcUrl;
            }
            return (String) invokeV.objValue;
        }

        public final String getRtcUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
                return this.rtcUrl;
            }
            return (String) invokeV.objValue;
        }

        public final String getScreen() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
                return this.screen;
            }
            return (String) invokeV.objValue;
        }

        public final JSONObject getSearchIntoLiveJson() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
                return this.searchIntoLiveJson;
            }
            return (JSONObject) invokeV.objValue;
        }

        public final String getShareTag() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
                return this.shareTag;
            }
            return (String) invokeV.objValue;
        }

        public final JSONObject getShareTaskInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
                return this.shareTaskInfo;
            }
            return (JSONObject) invokeV.objValue;
        }

        public final String getShareUid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
                return this.shareUid;
            }
            return (String) invokeV.objValue;
        }

        public final String getSource() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
                return this.source;
            }
            return (String) invokeV.objValue;
        }

        public final String getStatus() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
                return this.status;
            }
            return (String) invokeV.objValue;
        }

        public final String getTemplate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
                return this.template;
            }
            return (String) invokeV.objValue;
        }

        public final String getTemplateId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
                return this.templateId;
            }
            return (String) invokeV.objValue;
        }

        public final String getTitle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
                return this.title;
            }
            return (String) invokeV.objValue;
        }

        public final JSONObject getVrParams() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
                return this.vrParams;
            }
            return (JSONObject) invokeV.objValue;
        }

        public final void setCommonShareInfo(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048651, this, jSONObject) == null) {
                this.commonShareInfo = jSONObject;
            }
        }

        public final void setFromIntent(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048652, this, bool) == null) {
                this.fromIntent = bool;
            }
        }

        public final void setHlReplyIntoLive(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048653, this, jSONObject) == null) {
                this.hlReplyIntoLive = jSONObject;
            }
        }

        public final void setIntroduceTips(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048654, this, jSONObject) == null) {
                this.introduceTips = jSONObject;
            }
        }

        public final void setInvokePop(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048655, this, jSONObject) == null) {
                this.invokePop = jSONObject;
            }
        }

        public final void setKabrSpts(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048656, this, str) == null) {
                this.kabrSpts = str;
            }
        }

        public final void setLiveBackScheme(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048657, this, str) == null) {
                this.liveBackScheme = str;
            }
        }

        public final void setMultiRate(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048658, this, jSONObject) == null) {
                this.multiRate = jSONObject;
            }
        }

        public final void setOtherParams(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048659, this, jSONObject) == null) {
                this.otherParams = jSONObject;
            }
        }

        public final void setPlayerCacheCodeC(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048660, this, num) == null) {
                this.playerCacheCodeC = num;
            }
        }

        public final void setPlayerCacheKey(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048661, this, str) == null) {
                this.playerCacheKey = str;
            }
        }

        public final void setQuery(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048662, this, jSONObject) == null) {
                this.query = jSONObject;
            }
        }

        public final void setRoomType(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048663, this, str) == null) {
                this.roomType = str;
            }
        }

        public final void setRtcHevcUrl(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048664, this, str) == null) {
                this.rtcHevcUrl = str;
            }
        }

        public final void setSearchIntoLiveJson(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048665, this, jSONObject) == null) {
                this.searchIntoLiveJson = jSONObject;
            }
        }

        public final void setShareTag(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048666, this, str) == null) {
                this.shareTag = str;
            }
        }

        public final void setShareUid(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048667, this, str) == null) {
                this.shareUid = str;
            }
        }

        public final void setTemplateId(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048668, this, str) == null) {
                this.templateId = str;
            }
        }

        public final void setVrParams(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048669, this, jSONObject) == null) {
                this.vrParams = jSONObject;
            }
        }

        public final String toSchemeParams() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) {
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
                } catch (JSONException unused) {
                }
                String jSONObject16 = jSONObject.toString();
                Intrinsics.checkExpressionValueIsNotNull(jSONObject16, "json.toString()");
                return jSONObject16;
            }
            return (String) invokeV.objValue;
        }
    }

    public IntentData(String str, String str2, String str3, SchemeModel schemeModel, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, schemeModel, str4, str5};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.extReq;
        }
        return (String) invokeV.objValue;
    }

    public final String getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.id;
        }
        return (String) invokeV.objValue;
    }

    public final String getLiveSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.source;
        }
        return (String) invokeV.objValue;
    }

    public final SchemeModel getModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.model;
        }
        return (SchemeModel) invokeV.objValue;
    }

    public final String getNidFromHLReplay() {
        InterceptResult invokeV;
        String optString;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            JSONObject hlReplyIntoLive = this.model.getHlReplyIntoLive();
            if (hlReplyIntoLive == null || (optString = hlReplyIntoLive.optString("nid")) == null) {
                return "";
            }
            return optString;
        }
        return (String) invokeV.objValue;
    }

    public final String getQuestionFromSearch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
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
        return (String) invokeV.objValue;
    }

    public final String getScheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.scheme;
        }
        return (String) invokeV.objValue;
    }

    public final SchemeModel getSchemeData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.model;
        }
        return (SchemeModel) invokeV.objValue;
    }

    public final String getSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.source;
        }
        return (String) invokeV.objValue;
    }

    public final String getTpl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.tpl;
        }
        return (String) invokeV.objValue;
    }

    public final int getTransitionStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.transitionStatus;
        }
        return invokeV.intValue;
    }

    public final Boolean getTranslucent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.translucent;
        }
        return (Boolean) invokeV.objValue;
    }

    public final boolean isHLReplay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.model.getHlReplyIntoLive() != null && MiniShellRuntime.INSTANCE.isMobileBaidu()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean transitionSeamless() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            if (this.transitionStatus >= 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void setExtReq(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.extReq = str;
        }
    }

    public final void setId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.id = str;
        }
    }

    public final void setModel(SchemeModel schemeModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, schemeModel) == null) {
            this.model = schemeModel;
        }
    }

    public final void setScheme(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.scheme = str;
        }
    }

    public final void setSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.source = str;
        }
    }

    public final void setTpl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            this.tpl = str;
        }
    }

    public final void setTransitionStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            this.transitionStatus = i;
        }
    }

    public final void setTranslucent(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, bool) == null) {
            this.translucent = bool;
        }
    }

    public final boolean isEnterBookRoom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            String str = this.scheme;
            if (str == null) {
                return false;
            }
            if (!StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "enterBookRoom", false, 2, (Object) null) && !TextUtils.equals(this.model.getStatus(), String.valueOf(4))) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
