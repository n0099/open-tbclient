package com.baidu.searchbox.live.frame;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.arch.frame.State;
import com.baidu.live.arch.runtime.MiniShellRuntime;
import com.baidu.live.arch.utils.MiniJsonUtils;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/live/frame/IntentData$Companion;", "", "source", "getLiveSource", "(Ljava/lang/String;)Ljava/lang/String;", "params", "Lcom/baidu/searchbox/live/frame/IntentData$SchemeModel;", "parseSchemeData", "(Ljava/lang/String;)Lcom/baidu/searchbox/live/frame/IntentData$SchemeModel;", "KEY", "Ljava/lang/String;", "", "banQuestionFromSearchDialog", "Z", "getBanQuestionFromSearchDialog", "()Z", "setBanQuestionFromSearchDialog", "(Z)V", "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: Can't wrap try/catch for region: R(9:121|122|123|124|(3:126|127|128)(7:207|208|209|(7:225|226|227|228|229|230|231)(1:211)|212|(1:214)(2:217|(1:219))|215)|(21:(3:182|183|(27:185|(1:187)|188|189|(3:191|(1:193)|194)|131|132|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153))|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153)|130|131|132) */
        /* JADX WARN: Code restructure failed: missing block: B:171:0x04a1, code lost:
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:172:0x04a2, code lost:
            r7 = r104;
            r8 = r10;
            r9 = r18;
            r71 = r6;
            r80 = r1;
            r81 = r2;
            r92 = r3;
            r93 = r4;
            r4 = r11;
            r100 = r40;
            r72 = r41;
            r74 = r42;
            r75 = r43;
            r76 = r44;
            r77 = r45;
            r78 = r46;
            r79 = r47;
            r88 = r48;
            r84 = r49;
            r82 = r50;
            r83 = r51;
            r89 = r52;
            r98 = r53;
            r86 = r54;
            r87 = r55;
            r94 = r56;
            r95 = r57;
            r96 = r58;
            r97 = r59;
            r99 = r60;
            r101 = r61;
            r102 = r62;
            r85 = r13;
            r73 = r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:177:0x0584, code lost:
            r90 = null;
         */
        /* JADX WARN: Removed duplicated region for block: B:365:0x030e A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final SchemeModel parseSchemeData(String str) {
            InterceptResult invokeL;
            String str2;
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
            Integer num;
            String str17;
            JSONObject jSONObject2;
            JSONObject jSONObject3;
            JSONObject jSONObject4;
            JSONObject jSONObject5;
            JSONObject jSONObject6;
            String str18;
            String str19;
            JSONObject jSONObject7;
            JSONObject jSONObject8;
            String str20;
            String str21;
            JSONObject jSONObject9;
            String str22;
            String str23;
            String str24;
            String str25;
            JSONObject jSONObject10;
            JSONObject jSONObject11;
            JSONObject jSONObject12;
            JSONObject jSONObject13;
            String optString;
            String str26;
            String optString2;
            String str27;
            String liveSource;
            String str28;
            String str29;
            String str30;
            String str31;
            String str32;
            String str33;
            String str34;
            JSONObject parseJSONObject;
            String str35;
            JSONObject parseJSONObject2;
            JSONObject parseJSONObject3;
            JSONObject parseJSONObject4;
            JSONObject parseJSONObject5;
            JSONObject parseJSONObject6;
            JSONObject parseJSONObject7;
            JSONObject parseJSONObject8;
            String optString3;
            String optString4;
            String optString5;
            String optString6;
            String optString7;
            String optString8;
            String optString9;
            Integer num2;
            JSONObject jSONObject14;
            String str36;
            String str37;
            String str38;
            String str39;
            JSONObject jSONObject15;
            String str40;
            String str41;
            String optString10;
            JSONObject optJSONObject;
            JSONObject optJSONObject2;
            JSONObject jSONObject16;
            String str42;
            JSONObject jSONObject17;
            String str43;
            String str44;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) != null) {
                return (SchemeModel) invokeL.objValue;
            }
            String str45 = "";
            try {
                jSONObject13 = new JSONObject(str);
                optString = jSONObject13.optString("roomId");
                if (optString == null) {
                    optString = "";
                }
                try {
                    if (TextUtils.isEmpty(optString)) {
                        try {
                            optString = jSONObject13.optString("room_id");
                            if (optString == null) {
                                optString = "";
                            }
                        } catch (Exception e) {
                            e = e;
                            str3 = "";
                            str4 = str3;
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
                            str2 = optString;
                            str15 = null;
                            jSONObject = null;
                            str16 = null;
                            num = null;
                            str17 = null;
                            jSONObject2 = null;
                            jSONObject3 = null;
                            jSONObject4 = null;
                            jSONObject5 = null;
                            jSONObject6 = null;
                            str18 = null;
                            str19 = null;
                            jSONObject7 = null;
                            jSONObject12 = null;
                            jSONObject11 = null;
                            jSONObject10 = null;
                            str25 = null;
                            str24 = null;
                            str23 = null;
                            str22 = null;
                            jSONObject9 = null;
                            str21 = null;
                            str20 = null;
                            jSONObject8 = null;
                            e.printStackTrace();
                            SchemeModel schemeModel = new SchemeModel(str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, jSONObject2, jSONObject3, jSONObject4, jSONObject5, jSONObject6, str18, str19, jSONObject7, jSONObject12, jSONObject11, jSONObject10, str12, str13, str25, str24, str23, str22, jSONObject9, str21, str14, str20, jSONObject8);
                            schemeModel.setPlayerCacheKey(str15);
                            schemeModel.setPlayerCacheCodeC(num);
                            schemeModel.setKabrSpts(str16);
                            schemeModel.setRtcHevcUrl(str17);
                            schemeModel.setCommonShareInfo(jSONObject);
                            return schemeModel;
                        }
                    }
                    try {
                        optString2 = jSONObject13.optString("inviterId");
                        try {
                            String optString11 = jSONObject13.optString("roomType");
                            str27 = optString11 != null ? optString11 : "";
                            try {
                                String optString12 = jSONObject13.optString("source");
                                if (optString12 == null) {
                                    optString12 = "";
                                }
                                liveSource = getLiveSource(optString12);
                                try {
                                    String optString13 = jSONObject13.optString(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY);
                                    str29 = optString13 != null ? optString13 : "";
                                    try {
                                        String optString14 = jSONObject13.optString("playUrl");
                                        str30 = optString14 != null ? optString14 : "";
                                        try {
                                            String optString15 = jSONObject13.optString("status");
                                            str31 = optString15 != null ? optString15 : "";
                                            try {
                                                String optString16 = jSONObject13.optString("format");
                                                str32 = optString16 != null ? optString16 : "";
                                                try {
                                                    String optString17 = jSONObject13.optString("screen");
                                                    str33 = optString17 != null ? optString17 : "";
                                                    try {
                                                        String optString18 = jSONObject13.optString(MediaTrackConfig.AE_IMPORT_TEMPLATE);
                                                        str34 = optString18 != null ? optString18 : "";
                                                        try {
                                                            parseJSONObject = MiniJsonUtils.INSTANCE.parseJSONObject(jSONObject13, "ext");
                                                        } catch (Exception e2) {
                                                            e = e2;
                                                            str28 = liveSource;
                                                            str2 = optString;
                                                            str11 = "";
                                                            str12 = str11;
                                                            str13 = str12;
                                                            str14 = optString2;
                                                            str3 = str27;
                                                            str5 = str29;
                                                            str6 = str30;
                                                            str7 = str31;
                                                            str8 = str32;
                                                            str9 = str33;
                                                            str10 = str34;
                                                            str4 = str28;
                                                            str15 = null;
                                                            jSONObject = null;
                                                            str16 = null;
                                                            num = null;
                                                            str17 = null;
                                                            jSONObject2 = null;
                                                            jSONObject3 = null;
                                                            jSONObject4 = null;
                                                            jSONObject5 = null;
                                                            jSONObject6 = null;
                                                            str18 = null;
                                                            str19 = null;
                                                            jSONObject7 = null;
                                                            jSONObject12 = null;
                                                            jSONObject11 = null;
                                                            jSONObject10 = null;
                                                            str25 = null;
                                                            str24 = null;
                                                            str23 = null;
                                                            str22 = null;
                                                            jSONObject9 = null;
                                                            str21 = null;
                                                            str20 = null;
                                                            jSONObject8 = null;
                                                            e.printStackTrace();
                                                            SchemeModel schemeModel2 = new SchemeModel(str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, jSONObject2, jSONObject3, jSONObject4, jSONObject5, jSONObject6, str18, str19, jSONObject7, jSONObject12, jSONObject11, jSONObject10, str12, str13, str25, str24, str23, str22, jSONObject9, str21, str14, str20, jSONObject8);
                                                            schemeModel2.setPlayerCacheKey(str15);
                                                            schemeModel2.setPlayerCacheCodeC(num);
                                                            schemeModel2.setKabrSpts(str16);
                                                            schemeModel2.setRtcHevcUrl(str17);
                                                            schemeModel2.setCommonShareInfo(jSONObject);
                                                            return schemeModel2;
                                                        }
                                                    } catch (Exception e3) {
                                                        e = e3;
                                                        str28 = liveSource;
                                                        str2 = optString;
                                                        str10 = "";
                                                        str11 = str10;
                                                        str12 = str11;
                                                        str13 = str12;
                                                        str14 = optString2;
                                                        str3 = str27;
                                                        str5 = str29;
                                                        str6 = str30;
                                                        str7 = str31;
                                                        str8 = str32;
                                                        str9 = str33;
                                                    }
                                                } catch (Exception e4) {
                                                    e = e4;
                                                    str28 = liveSource;
                                                    str2 = optString;
                                                    str9 = "";
                                                    str10 = str9;
                                                    str11 = str10;
                                                    str12 = str11;
                                                    str13 = str12;
                                                    str14 = optString2;
                                                    str3 = str27;
                                                    str5 = str29;
                                                    str6 = str30;
                                                    str7 = str31;
                                                    str8 = str32;
                                                }
                                            } catch (Exception e5) {
                                                e = e5;
                                                str28 = liveSource;
                                                str2 = optString;
                                                str8 = "";
                                                str9 = str8;
                                                str10 = str9;
                                                str11 = str10;
                                                str12 = str11;
                                                str13 = str12;
                                                str14 = optString2;
                                                str3 = str27;
                                                str5 = str29;
                                                str6 = str30;
                                                str7 = str31;
                                            }
                                        } catch (Exception e6) {
                                            e = e6;
                                            str28 = liveSource;
                                            str2 = optString;
                                            str7 = "";
                                            str8 = str7;
                                            str9 = str8;
                                            str10 = str9;
                                            str11 = str10;
                                            str12 = str11;
                                            str13 = str12;
                                            str14 = optString2;
                                            str3 = str27;
                                            str5 = str29;
                                            str6 = str30;
                                        }
                                    } catch (Exception e7) {
                                        e = e7;
                                        str28 = liveSource;
                                        str2 = optString;
                                        str6 = "";
                                        str7 = str6;
                                        str8 = str7;
                                        str9 = str8;
                                        str10 = str9;
                                        str11 = str10;
                                        str12 = str11;
                                        str13 = str12;
                                        str14 = optString2;
                                        str3 = str27;
                                        str5 = str29;
                                    }
                                } catch (Exception e8) {
                                    e = e8;
                                    str28 = liveSource;
                                    str2 = optString;
                                    str5 = "";
                                    str6 = str5;
                                    str7 = str6;
                                    str8 = str7;
                                    str9 = str8;
                                    str10 = str9;
                                    str11 = str10;
                                    str12 = str11;
                                    str13 = str12;
                                    str14 = optString2;
                                    str3 = str27;
                                }
                            } catch (Exception e9) {
                                e = e9;
                                str2 = optString;
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
                                str14 = optString2;
                                str3 = str27;
                            }
                        } catch (Exception e10) {
                            e = e10;
                            str2 = optString;
                            str3 = "";
                            str4 = str3;
                            str5 = str4;
                            str6 = str5;
                            str7 = str6;
                            str8 = str7;
                            str9 = str8;
                            str10 = str9;
                            str11 = str10;
                            str12 = str11;
                            str13 = str12;
                            str14 = optString2;
                        }
                    } catch (Exception e11) {
                        e = e11;
                        str26 = "";
                        str2 = optString;
                        str3 = str26;
                        str4 = str3;
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
                        str15 = null;
                        jSONObject = null;
                        str16 = null;
                        num = null;
                        str17 = null;
                        jSONObject2 = null;
                        jSONObject3 = null;
                        jSONObject4 = null;
                        jSONObject5 = null;
                        jSONObject6 = null;
                        str18 = null;
                        str19 = null;
                        jSONObject7 = null;
                        jSONObject12 = null;
                        jSONObject11 = null;
                        jSONObject10 = null;
                        str25 = null;
                        str24 = null;
                        str23 = null;
                        str22 = null;
                        jSONObject9 = null;
                        str21 = null;
                        str20 = null;
                        jSONObject8 = null;
                        e.printStackTrace();
                        SchemeModel schemeModel22 = new SchemeModel(str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, jSONObject2, jSONObject3, jSONObject4, jSONObject5, jSONObject6, str18, str19, jSONObject7, jSONObject12, jSONObject11, jSONObject10, str12, str13, str25, str24, str23, str22, jSONObject9, str21, str14, str20, jSONObject8);
                        schemeModel22.setPlayerCacheKey(str15);
                        schemeModel22.setPlayerCacheCodeC(num);
                        schemeModel22.setKabrSpts(str16);
                        schemeModel22.setRtcHevcUrl(str17);
                        schemeModel22.setCommonShareInfo(jSONObject);
                        return schemeModel22;
                    }
                } catch (Exception e12) {
                    e = e12;
                    str26 = "";
                    str2 = optString;
                }
            } catch (Exception e13) {
                e = e13;
                str2 = "";
                str3 = str2;
            }
            try {
                JSONObject parseJSONObject9 = MiniJsonUtils.INSTANCE.parseJSONObject(jSONObject13, "otherParams");
                if (parseJSONObject9 == null) {
                    try {
                        String optString19 = jSONObject13.optString("otherParams");
                        Intrinsics.checkExpressionValueIsNotNull(optString19, "json.optString(\"otherParams\")");
                        if (!TextUtils.isEmpty(optString19)) {
                            try {
                                parseJSONObject9 = new JSONObject(URLDecoder.decode(optString19));
                            } catch (JSONException unused) {
                                parseJSONObject9 = null;
                            }
                        }
                    } catch (Exception e14) {
                        e = e14;
                        str11 = "";
                        str12 = str11;
                        str13 = str12;
                        str2 = optString;
                        jSONObject2 = parseJSONObject;
                        jSONObject7 = parseJSONObject9;
                        str4 = liveSource;
                        str14 = optString2;
                        str3 = str27;
                        str5 = str29;
                        str6 = str30;
                        str7 = str31;
                        str8 = str32;
                        str9 = str33;
                        str10 = str34;
                        str15 = null;
                        jSONObject = null;
                        str16 = null;
                        num = null;
                        str17 = null;
                        jSONObject3 = null;
                        jSONObject4 = null;
                        jSONObject5 = null;
                        jSONObject6 = null;
                        str18 = null;
                        str19 = null;
                        jSONObject12 = null;
                        jSONObject11 = null;
                        jSONObject10 = null;
                        str25 = null;
                        str24 = null;
                        str23 = null;
                        str22 = null;
                        jSONObject9 = null;
                        str21 = null;
                        str20 = null;
                        jSONObject8 = null;
                        e.printStackTrace();
                        SchemeModel schemeModel222 = new SchemeModel(str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, jSONObject2, jSONObject3, jSONObject4, jSONObject5, jSONObject6, str18, str19, jSONObject7, jSONObject12, jSONObject11, jSONObject10, str12, str13, str25, str24, str23, str22, jSONObject9, str21, str14, str20, jSONObject8);
                        schemeModel222.setPlayerCacheKey(str15);
                        schemeModel222.setPlayerCacheCodeC(num);
                        schemeModel222.setKabrSpts(str16);
                        schemeModel222.setRtcHevcUrl(str17);
                        schemeModel222.setCommonShareInfo(jSONObject);
                        return schemeModel222;
                    }
                }
                try {
                    parseJSONObject2 = MiniJsonUtils.INSTANCE.parseJSONObject(jSONObject13, "otherParams");
                    try {
                        parseJSONObject3 = MiniJsonUtils.INSTANCE.parseJSONObject(jSONObject13, "query");
                        try {
                            parseJSONObject4 = MiniJsonUtils.INSTANCE.parseJSONObject(jSONObject13, "extRequest");
                            try {
                                parseJSONObject5 = MiniJsonUtils.INSTANCE.parseJSONObject(jSONObject13, "extLog");
                            } catch (Exception e15) {
                                e = e15;
                                str2 = optString;
                                jSONObject2 = parseJSONObject;
                                str11 = "";
                                str12 = str11;
                                str13 = str12;
                                str14 = optString2;
                                str3 = str27;
                                str5 = str29;
                                str6 = str30;
                                str7 = str31;
                                str8 = str32;
                                str9 = str33;
                                str10 = str34;
                                jSONObject7 = parseJSONObject2;
                                jSONObject5 = parseJSONObject3;
                                jSONObject3 = parseJSONObject4;
                                str4 = liveSource;
                                str15 = null;
                                jSONObject = null;
                                str16 = null;
                                num = null;
                                str17 = null;
                                jSONObject4 = null;
                                jSONObject6 = null;
                                str18 = null;
                                str19 = null;
                                jSONObject12 = null;
                                jSONObject11 = null;
                                jSONObject10 = null;
                                str25 = null;
                                str24 = null;
                                str23 = null;
                                str22 = null;
                                jSONObject9 = null;
                                str21 = null;
                                str20 = null;
                                jSONObject8 = null;
                                e.printStackTrace();
                                SchemeModel schemeModel2222 = new SchemeModel(str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, jSONObject2, jSONObject3, jSONObject4, jSONObject5, jSONObject6, str18, str19, jSONObject7, jSONObject12, jSONObject11, jSONObject10, str12, str13, str25, str24, str23, str22, jSONObject9, str21, str14, str20, jSONObject8);
                                schemeModel2222.setPlayerCacheKey(str15);
                                schemeModel2222.setPlayerCacheCodeC(num);
                                schemeModel2222.setKabrSpts(str16);
                                schemeModel2222.setRtcHevcUrl(str17);
                                schemeModel2222.setCommonShareInfo(jSONObject);
                                return schemeModel2222;
                            }
                        } catch (Exception e16) {
                            e = e16;
                            str2 = optString;
                            jSONObject2 = parseJSONObject;
                            str11 = "";
                            str12 = str11;
                            str13 = str12;
                            str14 = optString2;
                            str3 = str27;
                            str5 = str29;
                            str6 = str30;
                            str7 = str31;
                            str8 = str32;
                            str9 = str33;
                            str10 = str34;
                            jSONObject7 = parseJSONObject2;
                            jSONObject5 = parseJSONObject3;
                            str4 = liveSource;
                            str15 = null;
                            jSONObject = null;
                            str16 = null;
                            num = null;
                            str17 = null;
                            jSONObject3 = null;
                        }
                    } catch (Exception e17) {
                        e = e17;
                        str35 = liveSource;
                        str2 = optString;
                        jSONObject2 = parseJSONObject;
                        str11 = "";
                        str12 = str11;
                        str13 = str12;
                        str14 = optString2;
                        str3 = str27;
                        str5 = str29;
                        str6 = str30;
                        str7 = str31;
                        str8 = str32;
                        str9 = str33;
                        str10 = str34;
                        jSONObject7 = parseJSONObject2;
                        str4 = str35;
                        str15 = null;
                        jSONObject = null;
                        str16 = null;
                        num = null;
                        str17 = null;
                        jSONObject3 = null;
                        jSONObject4 = null;
                        jSONObject5 = null;
                        jSONObject6 = null;
                        str18 = null;
                        str19 = null;
                        jSONObject12 = null;
                        jSONObject11 = null;
                        jSONObject10 = null;
                        str25 = null;
                        str24 = null;
                        str23 = null;
                        str22 = null;
                        jSONObject9 = null;
                        str21 = null;
                        str20 = null;
                        jSONObject8 = null;
                        e.printStackTrace();
                        SchemeModel schemeModel22222 = new SchemeModel(str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, jSONObject2, jSONObject3, jSONObject4, jSONObject5, jSONObject6, str18, str19, jSONObject7, jSONObject12, jSONObject11, jSONObject10, str12, str13, str25, str24, str23, str22, jSONObject9, str21, str14, str20, jSONObject8);
                        schemeModel22222.setPlayerCacheKey(str15);
                        schemeModel22222.setPlayerCacheCodeC(num);
                        schemeModel22222.setKabrSpts(str16);
                        schemeModel22222.setRtcHevcUrl(str17);
                        schemeModel22222.setCommonShareInfo(jSONObject);
                        return schemeModel22222;
                    }
                } catch (Exception e18) {
                    e = e18;
                    str35 = liveSource;
                    str2 = optString;
                    jSONObject2 = parseJSONObject;
                    jSONObject7 = parseJSONObject9;
                    str11 = "";
                    str12 = str11;
                    str13 = str12;
                    str14 = optString2;
                    str3 = str27;
                    str5 = str29;
                    str6 = str30;
                    str7 = str31;
                    str8 = str32;
                    str9 = str33;
                    str10 = str34;
                }
                try {
                    parseJSONObject6 = MiniJsonUtils.INSTANCE.parseJSONObject(jSONObject13, "extParams");
                    try {
                        parseJSONObject7 = MiniJsonUtils.INSTANCE.parseJSONObject(jSONObject13, "invokePop");
                        try {
                            parseJSONObject8 = MiniJsonUtils.INSTANCE.parseJSONObject(jSONObject13, "shareTaskInfo");
                            try {
                                optString3 = jSONObject13.optString("askId");
                                try {
                                    optString4 = jSONObject13.optString("templateId");
                                } catch (Exception e19) {
                                    e = e19;
                                    str2 = optString;
                                    jSONObject2 = parseJSONObject;
                                    str11 = "";
                                    str12 = str11;
                                    str13 = str12;
                                    str14 = optString2;
                                    str3 = str27;
                                    str5 = str29;
                                    str6 = str30;
                                    str7 = str31;
                                    str8 = str32;
                                    str9 = str33;
                                    str10 = str34;
                                    jSONObject7 = parseJSONObject2;
                                    jSONObject5 = parseJSONObject3;
                                    jSONObject3 = parseJSONObject4;
                                    jSONObject4 = parseJSONObject5;
                                    jSONObject12 = parseJSONObject7;
                                    jSONObject9 = parseJSONObject8;
                                    str18 = optString3;
                                    jSONObject6 = parseJSONObject6;
                                    str4 = liveSource;
                                    str15 = null;
                                    jSONObject = null;
                                    str16 = null;
                                    num = null;
                                    str17 = null;
                                    str19 = null;
                                    jSONObject11 = null;
                                    jSONObject10 = null;
                                    str25 = null;
                                    str24 = null;
                                    str23 = null;
                                    str22 = null;
                                    str21 = null;
                                    str20 = null;
                                    jSONObject8 = null;
                                    e.printStackTrace();
                                    SchemeModel schemeModel222222 = new SchemeModel(str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, jSONObject2, jSONObject3, jSONObject4, jSONObject5, jSONObject6, str18, str19, jSONObject7, jSONObject12, jSONObject11, jSONObject10, str12, str13, str25, str24, str23, str22, jSONObject9, str21, str14, str20, jSONObject8);
                                    schemeModel222222.setPlayerCacheKey(str15);
                                    schemeModel222222.setPlayerCacheCodeC(num);
                                    schemeModel222222.setKabrSpts(str16);
                                    schemeModel222222.setRtcHevcUrl(str17);
                                    schemeModel222222.setCommonShareInfo(jSONObject);
                                    return schemeModel222222;
                                }
                            } catch (Exception e20) {
                                e = e20;
                                str2 = optString;
                                jSONObject2 = parseJSONObject;
                                str11 = "";
                                str12 = str11;
                                str13 = str12;
                                str14 = optString2;
                                str3 = str27;
                                str5 = str29;
                                str6 = str30;
                                str7 = str31;
                                str8 = str32;
                                str9 = str33;
                                str10 = str34;
                                jSONObject7 = parseJSONObject2;
                                jSONObject5 = parseJSONObject3;
                                jSONObject3 = parseJSONObject4;
                                jSONObject4 = parseJSONObject5;
                                jSONObject12 = parseJSONObject7;
                                jSONObject9 = parseJSONObject8;
                                jSONObject6 = parseJSONObject6;
                                str4 = liveSource;
                                str15 = null;
                                jSONObject = null;
                                str16 = null;
                                num = null;
                                str17 = null;
                                str18 = null;
                            }
                        } catch (Exception e21) {
                            e = e21;
                            str2 = optString;
                            jSONObject2 = parseJSONObject;
                            str11 = "";
                            str12 = str11;
                            str13 = str12;
                            str14 = optString2;
                            str3 = str27;
                            str5 = str29;
                            str6 = str30;
                            str7 = str31;
                            str8 = str32;
                            str9 = str33;
                            str10 = str34;
                            jSONObject7 = parseJSONObject2;
                            jSONObject5 = parseJSONObject3;
                            jSONObject3 = parseJSONObject4;
                            jSONObject4 = parseJSONObject5;
                            jSONObject12 = parseJSONObject7;
                            jSONObject6 = parseJSONObject6;
                            str4 = liveSource;
                            str15 = null;
                            jSONObject = null;
                            str16 = null;
                            num = null;
                            str17 = null;
                            str18 = null;
                            str19 = null;
                            jSONObject11 = null;
                            jSONObject10 = null;
                            str25 = null;
                            str24 = null;
                            str23 = null;
                            str22 = null;
                            jSONObject9 = null;
                            str21 = null;
                            str20 = null;
                            jSONObject8 = null;
                            e.printStackTrace();
                            SchemeModel schemeModel2222222 = new SchemeModel(str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, jSONObject2, jSONObject3, jSONObject4, jSONObject5, jSONObject6, str18, str19, jSONObject7, jSONObject12, jSONObject11, jSONObject10, str12, str13, str25, str24, str23, str22, jSONObject9, str21, str14, str20, jSONObject8);
                            schemeModel2222222.setPlayerCacheKey(str15);
                            schemeModel2222222.setPlayerCacheCodeC(num);
                            schemeModel2222222.setKabrSpts(str16);
                            schemeModel2222222.setRtcHevcUrl(str17);
                            schemeModel2222222.setCommonShareInfo(jSONObject);
                            return schemeModel2222222;
                        }
                        try {
                            optString5 = jSONObject13.optString("avcUrl");
                            try {
                                optString6 = jSONObject13.optString("hevcUrl");
                            } catch (Exception e22) {
                                e = e22;
                                str2 = optString;
                                jSONObject2 = parseJSONObject;
                                str11 = "";
                                str12 = str11;
                                str13 = str12;
                                str14 = optString2;
                                str3 = str27;
                                str5 = str29;
                                str6 = str30;
                                str7 = str31;
                                str8 = str32;
                                str9 = str33;
                                str10 = str34;
                                jSONObject7 = parseJSONObject2;
                                jSONObject5 = parseJSONObject3;
                                jSONObject3 = parseJSONObject4;
                                jSONObject4 = parseJSONObject5;
                                jSONObject12 = parseJSONObject7;
                                jSONObject9 = parseJSONObject8;
                                str18 = optString3;
                                str19 = optString4;
                                str25 = optString5;
                                jSONObject6 = parseJSONObject6;
                                str4 = liveSource;
                                str15 = null;
                                jSONObject = null;
                                str16 = null;
                                num = null;
                                str17 = null;
                                jSONObject11 = null;
                                jSONObject10 = null;
                                str24 = null;
                                str23 = null;
                                str22 = null;
                                str21 = null;
                                str20 = null;
                                jSONObject8 = null;
                                e.printStackTrace();
                                SchemeModel schemeModel22222222 = new SchemeModel(str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, jSONObject2, jSONObject3, jSONObject4, jSONObject5, jSONObject6, str18, str19, jSONObject7, jSONObject12, jSONObject11, jSONObject10, str12, str13, str25, str24, str23, str22, jSONObject9, str21, str14, str20, jSONObject8);
                                schemeModel22222222.setPlayerCacheKey(str15);
                                schemeModel22222222.setPlayerCacheCodeC(num);
                                schemeModel22222222.setKabrSpts(str16);
                                schemeModel22222222.setRtcHevcUrl(str17);
                                schemeModel22222222.setCommonShareInfo(jSONObject);
                                return schemeModel22222222;
                            }
                            try {
                                optString7 = jSONObject13.optString("rtcUrl");
                                try {
                                    str17 = jSONObject13.optString("rtcHevcUrl");
                                    try {
                                        optString8 = jSONObject13.optString("title");
                                    } catch (Exception e23) {
                                        e = e23;
                                        str2 = optString;
                                        jSONObject2 = parseJSONObject;
                                        str11 = "";
                                        str12 = str11;
                                        str13 = str12;
                                        str14 = optString2;
                                        str3 = str27;
                                        str5 = str29;
                                        str6 = str30;
                                        str7 = str31;
                                        str8 = str32;
                                        str9 = str33;
                                        str10 = str34;
                                        jSONObject7 = parseJSONObject2;
                                        jSONObject5 = parseJSONObject3;
                                        jSONObject3 = parseJSONObject4;
                                        jSONObject4 = parseJSONObject5;
                                        jSONObject12 = parseJSONObject7;
                                        jSONObject9 = parseJSONObject8;
                                        str18 = optString3;
                                        str19 = optString4;
                                        str25 = optString5;
                                        str24 = optString6;
                                        str23 = optString7;
                                        jSONObject6 = parseJSONObject6;
                                        str4 = liveSource;
                                        str15 = null;
                                        jSONObject = null;
                                        str16 = null;
                                        num = null;
                                        jSONObject11 = null;
                                        jSONObject10 = null;
                                        str22 = null;
                                        str21 = null;
                                        str20 = null;
                                        jSONObject8 = null;
                                        e.printStackTrace();
                                        SchemeModel schemeModel222222222 = new SchemeModel(str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, jSONObject2, jSONObject3, jSONObject4, jSONObject5, jSONObject6, str18, str19, jSONObject7, jSONObject12, jSONObject11, jSONObject10, str12, str13, str25, str24, str23, str22, jSONObject9, str21, str14, str20, jSONObject8);
                                        schemeModel222222222.setPlayerCacheKey(str15);
                                        schemeModel222222222.setPlayerCacheCodeC(num);
                                        schemeModel222222222.setKabrSpts(str16);
                                        schemeModel222222222.setRtcHevcUrl(str17);
                                        schemeModel222222222.setCommonShareInfo(jSONObject);
                                        return schemeModel222222222;
                                    }
                                } catch (Exception e24) {
                                    e = e24;
                                    str2 = optString;
                                    jSONObject2 = parseJSONObject;
                                    str11 = "";
                                    str12 = str11;
                                    str13 = str12;
                                    str14 = optString2;
                                    str3 = str27;
                                    str5 = str29;
                                    str6 = str30;
                                    str7 = str31;
                                    str8 = str32;
                                    str9 = str33;
                                    str10 = str34;
                                    jSONObject7 = parseJSONObject2;
                                    jSONObject5 = parseJSONObject3;
                                    jSONObject3 = parseJSONObject4;
                                    jSONObject4 = parseJSONObject5;
                                    jSONObject12 = parseJSONObject7;
                                    jSONObject9 = parseJSONObject8;
                                    str18 = optString3;
                                    str19 = optString4;
                                    str25 = optString5;
                                    str24 = optString6;
                                    str23 = optString7;
                                    jSONObject6 = parseJSONObject6;
                                    str4 = liveSource;
                                    str15 = null;
                                    jSONObject = null;
                                    str16 = null;
                                    num = null;
                                    str17 = null;
                                }
                            } catch (Exception e25) {
                                e = e25;
                                str2 = optString;
                                jSONObject2 = parseJSONObject;
                                str11 = "";
                                str12 = str11;
                                str13 = str12;
                                str14 = optString2;
                                str3 = str27;
                                str5 = str29;
                                str6 = str30;
                                str7 = str31;
                                str8 = str32;
                                str9 = str33;
                                str10 = str34;
                                jSONObject7 = parseJSONObject2;
                                jSONObject5 = parseJSONObject3;
                                jSONObject3 = parseJSONObject4;
                                jSONObject4 = parseJSONObject5;
                                jSONObject12 = parseJSONObject7;
                                jSONObject9 = parseJSONObject8;
                                str18 = optString3;
                                str19 = optString4;
                                str25 = optString5;
                                str24 = optString6;
                                jSONObject6 = parseJSONObject6;
                                str4 = liveSource;
                                str15 = null;
                                jSONObject = null;
                                str16 = null;
                                num = null;
                                str17 = null;
                                jSONObject11 = null;
                                jSONObject10 = null;
                                str23 = null;
                                str22 = null;
                                str21 = null;
                                str20 = null;
                                jSONObject8 = null;
                                e.printStackTrace();
                                SchemeModel schemeModel2222222222 = new SchemeModel(str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, jSONObject2, jSONObject3, jSONObject4, jSONObject5, jSONObject6, str18, str19, jSONObject7, jSONObject12, jSONObject11, jSONObject10, str12, str13, str25, str24, str23, str22, jSONObject9, str21, str14, str20, jSONObject8);
                                schemeModel2222222222.setPlayerCacheKey(str15);
                                schemeModel2222222222.setPlayerCacheCodeC(num);
                                schemeModel2222222222.setKabrSpts(str16);
                                schemeModel2222222222.setRtcHevcUrl(str17);
                                schemeModel2222222222.setCommonShareInfo(jSONObject);
                                return schemeModel2222222222;
                            }
                        } catch (Exception e26) {
                            e = e26;
                            str2 = optString;
                            jSONObject2 = parseJSONObject;
                            str11 = "";
                            str12 = str11;
                            str13 = str12;
                            str14 = optString2;
                            str3 = str27;
                            str5 = str29;
                            str6 = str30;
                            str7 = str31;
                            str8 = str32;
                            str9 = str33;
                            str10 = str34;
                            jSONObject7 = parseJSONObject2;
                            jSONObject5 = parseJSONObject3;
                            jSONObject3 = parseJSONObject4;
                            jSONObject4 = parseJSONObject5;
                            jSONObject12 = parseJSONObject7;
                            jSONObject9 = parseJSONObject8;
                            str18 = optString3;
                            str19 = optString4;
                            jSONObject6 = parseJSONObject6;
                            str4 = liveSource;
                            str15 = null;
                            jSONObject = null;
                            str16 = null;
                            num = null;
                            str17 = null;
                            jSONObject11 = null;
                            jSONObject10 = null;
                            str25 = null;
                            str24 = null;
                            str23 = null;
                            str22 = null;
                            str21 = null;
                            str20 = null;
                            jSONObject8 = null;
                            e.printStackTrace();
                            SchemeModel schemeModel22222222222 = new SchemeModel(str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, jSONObject2, jSONObject3, jSONObject4, jSONObject5, jSONObject6, str18, str19, jSONObject7, jSONObject12, jSONObject11, jSONObject10, str12, str13, str25, str24, str23, str22, jSONObject9, str21, str14, str20, jSONObject8);
                            schemeModel22222222222.setPlayerCacheKey(str15);
                            schemeModel22222222222.setPlayerCacheCodeC(num);
                            schemeModel22222222222.setKabrSpts(str16);
                            schemeModel22222222222.setRtcHevcUrl(str17);
                            schemeModel22222222222.setCommonShareInfo(jSONObject);
                            return schemeModel22222222222;
                        }
                    } catch (Exception e27) {
                        e = e27;
                        str2 = optString;
                        jSONObject2 = parseJSONObject;
                        str11 = "";
                        str12 = str11;
                        str13 = str12;
                        str14 = optString2;
                        str3 = str27;
                        str5 = str29;
                        str6 = str30;
                        str7 = str31;
                        str8 = str32;
                        str9 = str33;
                        str10 = str34;
                        jSONObject7 = parseJSONObject2;
                        jSONObject5 = parseJSONObject3;
                        jSONObject3 = parseJSONObject4;
                        jSONObject4 = parseJSONObject5;
                        jSONObject6 = parseJSONObject6;
                        str4 = liveSource;
                        str15 = null;
                        jSONObject = null;
                        str16 = null;
                        num = null;
                        str17 = null;
                        str18 = null;
                        str19 = null;
                        jSONObject12 = null;
                        jSONObject11 = null;
                        jSONObject10 = null;
                        str25 = null;
                        str24 = null;
                        str23 = null;
                        str22 = null;
                        jSONObject9 = null;
                        str21 = null;
                        str20 = null;
                        jSONObject8 = null;
                        e.printStackTrace();
                        SchemeModel schemeModel222222222222 = new SchemeModel(str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, jSONObject2, jSONObject3, jSONObject4, jSONObject5, jSONObject6, str18, str19, jSONObject7, jSONObject12, jSONObject11, jSONObject10, str12, str13, str25, str24, str23, str22, jSONObject9, str21, str14, str20, jSONObject8);
                        schemeModel222222222222.setPlayerCacheKey(str15);
                        schemeModel222222222222.setPlayerCacheCodeC(num);
                        schemeModel222222222222.setKabrSpts(str16);
                        schemeModel222222222222.setRtcHevcUrl(str17);
                        schemeModel222222222222.setCommonShareInfo(jSONObject);
                        return schemeModel222222222222;
                    }
                } catch (Exception e28) {
                    e = e28;
                    str2 = optString;
                    jSONObject2 = parseJSONObject;
                    str11 = "";
                    str12 = str11;
                    str13 = str12;
                    str14 = optString2;
                    str3 = str27;
                    str5 = str29;
                    str6 = str30;
                    str7 = str31;
                    str8 = str32;
                    str9 = str33;
                    str10 = str34;
                    jSONObject7 = parseJSONObject2;
                    jSONObject5 = parseJSONObject3;
                    jSONObject3 = parseJSONObject4;
                    jSONObject4 = parseJSONObject5;
                    str4 = liveSource;
                    str15 = null;
                    jSONObject = null;
                    str16 = null;
                    num = null;
                    str17 = null;
                    jSONObject6 = null;
                    str18 = null;
                    str19 = null;
                    jSONObject12 = null;
                    jSONObject11 = null;
                    jSONObject10 = null;
                    str25 = null;
                    str24 = null;
                    str23 = null;
                    str22 = null;
                    jSONObject9 = null;
                    str21 = null;
                    str20 = null;
                    jSONObject8 = null;
                    e.printStackTrace();
                    SchemeModel schemeModel2222222222222 = new SchemeModel(str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, jSONObject2, jSONObject3, jSONObject4, jSONObject5, jSONObject6, str18, str19, jSONObject7, jSONObject12, jSONObject11, jSONObject10, str12, str13, str25, str24, str23, str22, jSONObject9, str21, str14, str20, jSONObject8);
                    schemeModel2222222222222.setPlayerCacheKey(str15);
                    schemeModel2222222222222.setPlayerCacheCodeC(num);
                    schemeModel2222222222222.setKabrSpts(str16);
                    schemeModel2222222222222.setRtcHevcUrl(str17);
                    schemeModel2222222222222.setCommonShareInfo(jSONObject);
                    return schemeModel2222222222222;
                }
            } catch (Exception e29) {
                e = e29;
                str2 = optString;
                jSONObject2 = parseJSONObject;
                str11 = "";
                str12 = str11;
                str13 = str12;
                str14 = optString2;
                str3 = str27;
                str5 = str29;
                str6 = str30;
                str7 = str31;
                str8 = str32;
                str9 = str33;
                str10 = str34;
                str4 = liveSource;
                str15 = null;
                jSONObject = null;
                str16 = null;
                num = null;
                str17 = null;
                jSONObject3 = null;
                jSONObject4 = null;
                jSONObject5 = null;
                jSONObject6 = null;
                str18 = null;
                str19 = null;
                jSONObject7 = null;
                jSONObject12 = null;
                jSONObject11 = null;
                jSONObject10 = null;
                str25 = null;
                str24 = null;
                str23 = null;
                str22 = null;
                jSONObject9 = null;
                str21 = null;
                str20 = null;
                jSONObject8 = null;
                e.printStackTrace();
                SchemeModel schemeModel22222222222222 = new SchemeModel(str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, jSONObject2, jSONObject3, jSONObject4, jSONObject5, jSONObject6, str18, str19, jSONObject7, jSONObject12, jSONObject11, jSONObject10, str12, str13, str25, str24, str23, str22, jSONObject9, str21, str14, str20, jSONObject8);
                schemeModel22222222222222.setPlayerCacheKey(str15);
                schemeModel22222222222222.setPlayerCacheCodeC(num);
                schemeModel22222222222222.setKabrSpts(str16);
                schemeModel22222222222222.setRtcHevcUrl(str17);
                schemeModel22222222222222.setCommonShareInfo(jSONObject);
                return schemeModel22222222222222;
            }
            try {
                String optString20 = jSONObject13.optString("quic");
                try {
                    optString9 = jSONObject13.optString("highLightUrl");
                } catch (Exception e30) {
                    e = e30;
                    str2 = optString;
                    jSONObject2 = parseJSONObject;
                    str11 = "";
                    str12 = str11;
                    str13 = str12;
                    str14 = optString2;
                    str3 = str27;
                    str5 = str29;
                    str6 = str30;
                    str7 = str31;
                    str8 = str32;
                    str9 = str33;
                    str10 = str34;
                    jSONObject7 = parseJSONObject2;
                    jSONObject5 = parseJSONObject3;
                    jSONObject3 = parseJSONObject4;
                    jSONObject4 = parseJSONObject5;
                    jSONObject12 = parseJSONObject7;
                    jSONObject9 = parseJSONObject8;
                    str18 = optString3;
                    str19 = optString4;
                    str25 = optString5;
                    str24 = optString6;
                    str23 = optString7;
                    str22 = optString8;
                    str21 = optString20;
                    jSONObject6 = parseJSONObject6;
                    str4 = liveSource;
                    str15 = null;
                    jSONObject = null;
                    str16 = null;
                    num = null;
                    jSONObject11 = null;
                    jSONObject10 = null;
                    str20 = null;
                    jSONObject8 = null;
                    e.printStackTrace();
                    SchemeModel schemeModel222222222222222 = new SchemeModel(str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, jSONObject2, jSONObject3, jSONObject4, jSONObject5, jSONObject6, str18, str19, jSONObject7, jSONObject12, jSONObject11, jSONObject10, str12, str13, str25, str24, str23, str22, jSONObject9, str21, str14, str20, jSONObject8);
                    schemeModel222222222222222.setPlayerCacheKey(str15);
                    schemeModel222222222222222.setPlayerCacheCodeC(num);
                    schemeModel222222222222222.setKabrSpts(str16);
                    schemeModel222222222222222.setRtcHevcUrl(str17);
                    schemeModel222222222222222.setCommonShareInfo(jSONObject);
                    return schemeModel222222222222222;
                }
                try {
                    JSONObject parseJSONObject10 = MiniJsonUtils.INSTANCE.parseJSONObject(jSONObject13, "introduce_tips");
                    try {
                        String optString21 = jSONObject13.optString("playerIdentifier");
                        try {
                            num = Integer.valueOf(jSONObject13.optInt("codec_id"));
                            try {
                                str16 = jSONObject13.optString(LivePreStartPlayServiceImpl.PARAM_KABR_SPTS);
                                try {
                                    JSONObject parseJSONObject11 = MiniJsonUtils.INSTANCE.parseJSONObject(jSONObject13, "commonShareInfo");
                                    if (parseJSONObject == null) {
                                        try {
                                            JSONObject jSONObject18 = new JSONObject();
                                            JSONObject jSONObject19 = new JSONObject();
                                            jSONObject19.put("source", liveSource);
                                            Unit unit = Unit.INSTANCE;
                                            jSONObject18.put("ext", jSONObject19);
                                            Unit unit2 = Unit.INSTANCE;
                                            jSONObject15 = jSONObject18;
                                            str40 = "";
                                            str36 = str40;
                                            jSONObject14 = parseJSONObject11;
                                            str37 = str16;
                                        } catch (Exception e31) {
                                            e = e31;
                                            str11 = "";
                                            str12 = str11;
                                            str13 = str12;
                                            str2 = optString;
                                            jSONObject2 = parseJSONObject;
                                            jSONObject = parseJSONObject11;
                                            str15 = optString21;
                                            jSONObject6 = parseJSONObject6;
                                            str4 = liveSource;
                                            str14 = optString2;
                                            str3 = str27;
                                            str5 = str29;
                                            str6 = str30;
                                            str7 = str31;
                                            str8 = str32;
                                            str9 = str33;
                                            str10 = str34;
                                            jSONObject7 = parseJSONObject2;
                                            jSONObject5 = parseJSONObject3;
                                            jSONObject3 = parseJSONObject4;
                                            jSONObject4 = parseJSONObject5;
                                            jSONObject12 = parseJSONObject7;
                                            jSONObject9 = parseJSONObject8;
                                            str18 = optString3;
                                            str19 = optString4;
                                            str25 = optString5;
                                            str24 = optString6;
                                            str23 = optString7;
                                            str22 = optString8;
                                            str21 = optString20;
                                            str20 = optString9;
                                            jSONObject8 = parseJSONObject10;
                                            jSONObject11 = null;
                                            jSONObject10 = null;
                                            e.printStackTrace();
                                            SchemeModel schemeModel2222222222222222 = new SchemeModel(str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, jSONObject2, jSONObject3, jSONObject4, jSONObject5, jSONObject6, str18, str19, jSONObject7, jSONObject12, jSONObject11, jSONObject10, str12, str13, str25, str24, str23, str22, jSONObject9, str21, str14, str20, jSONObject8);
                                            schemeModel2222222222222222.setPlayerCacheKey(str15);
                                            schemeModel2222222222222222.setPlayerCacheCodeC(num);
                                            schemeModel2222222222222222.setKabrSpts(str16);
                                            schemeModel2222222222222222.setRtcHevcUrl(str17);
                                            schemeModel2222222222222222.setCommonShareInfo(jSONObject);
                                            return schemeModel2222222222222222;
                                        }
                                    } else {
                                        try {
                                            JSONObject optJSONObject3 = parseJSONObject.optJSONObject("ext");
                                            str36 = "";
                                            if (optJSONObject3 != null) {
                                                try {
                                                    String optString22 = optJSONObject3.optString("share_uid");
                                                    try {
                                                        str39 = optJSONObject3.optString("zb_tag");
                                                        try {
                                                            Unit unit3 = Unit.INSTANCE;
                                                            jSONObject14 = parseJSONObject11;
                                                            str38 = optString22;
                                                            str37 = str16;
                                                            str41 = str39;
                                                        } catch (JSONException unused2) {
                                                            jSONObject14 = parseJSONObject11;
                                                            str38 = optString22;
                                                            str37 = str16;
                                                            jSONObject15 = parseJSONObject;
                                                            str45 = str38;
                                                            str40 = str39;
                                                            if (parseJSONObject6 != null) {
                                                            }
                                                            optString10 = str36;
                                                            optJSONObject = jSONObject13.optJSONObject("queryECLive");
                                                            optJSONObject2 = jSONObject13.optJSONObject("hlReplay");
                                                            try {
                                                                jSONObject17 = jSONObject14;
                                                                String str46 = optString;
                                                                String str47 = optString;
                                                                str43 = str37;
                                                                jSONObject16 = parseJSONObject6;
                                                                str42 = liveSource;
                                                                try {
                                                                    SchemeModel schemeModel3 = new SchemeModel(str46, str27, liveSource, str29, str30, str31, str32, str33, str34, optString10, jSONObject15, parseJSONObject4, parseJSONObject5, parseJSONObject3, jSONObject16, optString3, optString4, parseJSONObject2, parseJSONObject7, optJSONObject, optJSONObject2, str45, str40, optString5, optString6, optString7, optString8, parseJSONObject8, optString20, optString2, optString9, parseJSONObject10);
                                                                    schemeModel3.setPlayerCacheKey(optString21);
                                                                    num2 = num;
                                                                    try {
                                                                        schemeModel3.setPlayerCacheCodeC(num2);
                                                                        str16 = str43;
                                                                        try {
                                                                            schemeModel3.setKabrSpts(str16);
                                                                            str44 = str17;
                                                                            try {
                                                                                schemeModel3.setRtcHevcUrl(str44);
                                                                                jSONObject = jSONObject17;
                                                                            } catch (Exception e32) {
                                                                                e = e32;
                                                                                jSONObject = jSONObject17;
                                                                            }
                                                                        } catch (Exception e33) {
                                                                            e = e33;
                                                                            jSONObject = jSONObject17;
                                                                            str44 = str17;
                                                                            str2 = str47;
                                                                            str11 = optString10;
                                                                            jSONObject2 = jSONObject15;
                                                                            str12 = str45;
                                                                            str13 = str40;
                                                                            jSONObject10 = optJSONObject2;
                                                                            str15 = optString21;
                                                                            str17 = str44;
                                                                            str14 = optString2;
                                                                            str3 = str27;
                                                                            str5 = str29;
                                                                            str6 = str30;
                                                                            str7 = str31;
                                                                            str8 = str32;
                                                                            str9 = str33;
                                                                            str10 = str34;
                                                                            jSONObject7 = parseJSONObject2;
                                                                            jSONObject5 = parseJSONObject3;
                                                                            jSONObject3 = parseJSONObject4;
                                                                            jSONObject4 = parseJSONObject5;
                                                                            jSONObject12 = parseJSONObject7;
                                                                            jSONObject9 = parseJSONObject8;
                                                                            str18 = optString3;
                                                                            str19 = optString4;
                                                                            str25 = optString5;
                                                                            str24 = optString6;
                                                                            str23 = optString7;
                                                                            str22 = optString8;
                                                                            str21 = optString20;
                                                                            str20 = optString9;
                                                                            jSONObject8 = parseJSONObject10;
                                                                            jSONObject11 = optJSONObject;
                                                                            jSONObject6 = jSONObject16;
                                                                            str4 = str42;
                                                                            num = num2;
                                                                            e.printStackTrace();
                                                                            SchemeModel schemeModel22222222222222222 = new SchemeModel(str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, jSONObject2, jSONObject3, jSONObject4, jSONObject5, jSONObject6, str18, str19, jSONObject7, jSONObject12, jSONObject11, jSONObject10, str12, str13, str25, str24, str23, str22, jSONObject9, str21, str14, str20, jSONObject8);
                                                                            schemeModel22222222222222222.setPlayerCacheKey(str15);
                                                                            schemeModel22222222222222222.setPlayerCacheCodeC(num);
                                                                            schemeModel22222222222222222.setKabrSpts(str16);
                                                                            schemeModel22222222222222222.setRtcHevcUrl(str17);
                                                                            schemeModel22222222222222222.setCommonShareInfo(jSONObject);
                                                                            return schemeModel22222222222222222;
                                                                        }
                                                                        try {
                                                                            schemeModel3.setCommonShareInfo(jSONObject);
                                                                            return schemeModel3;
                                                                        } catch (Exception e34) {
                                                                            e = e34;
                                                                            str2 = str47;
                                                                            str11 = optString10;
                                                                            jSONObject2 = jSONObject15;
                                                                            str12 = str45;
                                                                            str13 = str40;
                                                                            jSONObject10 = optJSONObject2;
                                                                            str15 = optString21;
                                                                            str17 = str44;
                                                                            str14 = optString2;
                                                                            str3 = str27;
                                                                            str5 = str29;
                                                                            str6 = str30;
                                                                            str7 = str31;
                                                                            str8 = str32;
                                                                            str9 = str33;
                                                                            str10 = str34;
                                                                            jSONObject7 = parseJSONObject2;
                                                                            jSONObject5 = parseJSONObject3;
                                                                            jSONObject3 = parseJSONObject4;
                                                                            jSONObject4 = parseJSONObject5;
                                                                            jSONObject12 = parseJSONObject7;
                                                                            jSONObject9 = parseJSONObject8;
                                                                            str18 = optString3;
                                                                            str19 = optString4;
                                                                            str25 = optString5;
                                                                            str24 = optString6;
                                                                            str23 = optString7;
                                                                            str22 = optString8;
                                                                            str21 = optString20;
                                                                            str20 = optString9;
                                                                            jSONObject8 = parseJSONObject10;
                                                                            jSONObject11 = optJSONObject;
                                                                            jSONObject6 = jSONObject16;
                                                                            str4 = str42;
                                                                            num = num2;
                                                                            e.printStackTrace();
                                                                            SchemeModel schemeModel222222222222222222 = new SchemeModel(str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, jSONObject2, jSONObject3, jSONObject4, jSONObject5, jSONObject6, str18, str19, jSONObject7, jSONObject12, jSONObject11, jSONObject10, str12, str13, str25, str24, str23, str22, jSONObject9, str21, str14, str20, jSONObject8);
                                                                            schemeModel222222222222222222.setPlayerCacheKey(str15);
                                                                            schemeModel222222222222222222.setPlayerCacheCodeC(num);
                                                                            schemeModel222222222222222222.setKabrSpts(str16);
                                                                            schemeModel222222222222222222.setRtcHevcUrl(str17);
                                                                            schemeModel222222222222222222.setCommonShareInfo(jSONObject);
                                                                            return schemeModel222222222222222222;
                                                                        }
                                                                    } catch (Exception e35) {
                                                                        e = e35;
                                                                        jSONObject = jSONObject17;
                                                                        str16 = str43;
                                                                    }
                                                                } catch (Exception e36) {
                                                                    e = e36;
                                                                    jSONObject = jSONObject17;
                                                                    str16 = str43;
                                                                    num2 = num;
                                                                }
                                                            } catch (Exception e37) {
                                                                e = e37;
                                                                jSONObject = jSONObject14;
                                                                num2 = num;
                                                                jSONObject16 = parseJSONObject6;
                                                                str42 = liveSource;
                                                                str16 = str37;
                                                                str2 = optString;
                                                                str11 = optString10;
                                                                jSONObject2 = jSONObject15;
                                                                str12 = str45;
                                                                str13 = str40;
                                                                jSONObject10 = optJSONObject2;
                                                                str15 = optString21;
                                                            }
                                                        } catch (Exception e38) {
                                                            e = e38;
                                                            str2 = optString;
                                                            jSONObject2 = parseJSONObject;
                                                            jSONObject = parseJSONObject11;
                                                            str15 = optString21;
                                                            jSONObject6 = parseJSONObject6;
                                                            str4 = liveSource;
                                                            str11 = str36;
                                                            str12 = optString22;
                                                            str13 = str39;
                                                            str14 = optString2;
                                                            str3 = str27;
                                                            str5 = str29;
                                                            str6 = str30;
                                                            str7 = str31;
                                                            str8 = str32;
                                                            str9 = str33;
                                                            str10 = str34;
                                                            jSONObject7 = parseJSONObject2;
                                                            jSONObject5 = parseJSONObject3;
                                                            jSONObject3 = parseJSONObject4;
                                                            jSONObject4 = parseJSONObject5;
                                                            jSONObject12 = parseJSONObject7;
                                                            jSONObject9 = parseJSONObject8;
                                                            str18 = optString3;
                                                            str19 = optString4;
                                                            str25 = optString5;
                                                            str24 = optString6;
                                                            str23 = optString7;
                                                            str22 = optString8;
                                                            str21 = optString20;
                                                            str20 = optString9;
                                                            jSONObject8 = parseJSONObject10;
                                                            jSONObject11 = null;
                                                            jSONObject10 = null;
                                                            e.printStackTrace();
                                                            SchemeModel schemeModel2222222222222222222 = new SchemeModel(str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, jSONObject2, jSONObject3, jSONObject4, jSONObject5, jSONObject6, str18, str19, jSONObject7, jSONObject12, jSONObject11, jSONObject10, str12, str13, str25, str24, str23, str22, jSONObject9, str21, str14, str20, jSONObject8);
                                                            schemeModel2222222222222222222.setPlayerCacheKey(str15);
                                                            schemeModel2222222222222222222.setPlayerCacheCodeC(num);
                                                            schemeModel2222222222222222222.setKabrSpts(str16);
                                                            schemeModel2222222222222222222.setRtcHevcUrl(str17);
                                                            schemeModel2222222222222222222.setCommonShareInfo(jSONObject);
                                                            return schemeModel2222222222222222222;
                                                        }
                                                    } catch (JSONException unused3) {
                                                        jSONObject14 = parseJSONObject11;
                                                        str39 = str36;
                                                    } catch (Exception e39) {
                                                        e = e39;
                                                        str2 = optString;
                                                        jSONObject2 = parseJSONObject;
                                                        jSONObject = parseJSONObject11;
                                                        str15 = optString21;
                                                        jSONObject6 = parseJSONObject6;
                                                        str4 = liveSource;
                                                        str11 = str36;
                                                        str13 = str11;
                                                        str12 = optString22;
                                                    }
                                                } catch (JSONException unused4) {
                                                    jSONObject14 = parseJSONObject11;
                                                    str37 = str16;
                                                    str38 = str36;
                                                    str39 = str38;
                                                    jSONObject15 = parseJSONObject;
                                                    str45 = str38;
                                                    str40 = str39;
                                                    if (parseJSONObject6 != null) {
                                                    }
                                                    optString10 = str36;
                                                    optJSONObject = jSONObject13.optJSONObject("queryECLive");
                                                    optJSONObject2 = jSONObject13.optJSONObject("hlReplay");
                                                    jSONObject17 = jSONObject14;
                                                    String str462 = optString;
                                                    String str472 = optString;
                                                    str43 = str37;
                                                    jSONObject16 = parseJSONObject6;
                                                    str42 = liveSource;
                                                    SchemeModel schemeModel32 = new SchemeModel(str462, str27, liveSource, str29, str30, str31, str32, str33, str34, optString10, jSONObject15, parseJSONObject4, parseJSONObject5, parseJSONObject3, jSONObject16, optString3, optString4, parseJSONObject2, parseJSONObject7, optJSONObject, optJSONObject2, str45, str40, optString5, optString6, optString7, optString8, parseJSONObject8, optString20, optString2, optString9, parseJSONObject10);
                                                    schemeModel32.setPlayerCacheKey(optString21);
                                                    num2 = num;
                                                    schemeModel32.setPlayerCacheCodeC(num2);
                                                    str16 = str43;
                                                    schemeModel32.setKabrSpts(str16);
                                                    str44 = str17;
                                                    schemeModel32.setRtcHevcUrl(str44);
                                                    jSONObject = jSONObject17;
                                                    schemeModel32.setCommonShareInfo(jSONObject);
                                                    return schemeModel32;
                                                } catch (Exception e40) {
                                                    e = e40;
                                                    str2 = optString;
                                                    jSONObject2 = parseJSONObject;
                                                    jSONObject = parseJSONObject11;
                                                    str15 = optString21;
                                                    jSONObject6 = parseJSONObject6;
                                                    str4 = liveSource;
                                                    str11 = str36;
                                                    str12 = str11;
                                                    str13 = str12;
                                                }
                                            } else {
                                                jSONObject14 = parseJSONObject11;
                                                str37 = str16;
                                                str38 = str36;
                                                str41 = str38;
                                            }
                                            try {
                                                if (optJSONObject3 == null) {
                                                    JSONObject jSONObject20 = new JSONObject();
                                                    jSONObject20.put("source", liveSource);
                                                    jSONObject20.put("share_uid", str38);
                                                    jSONObject20.put("zb_tag", str41);
                                                    Unit unit4 = Unit.INSTANCE;
                                                    parseJSONObject.put("ext", jSONObject20);
                                                } else if (!optJSONObject3.has("source")) {
                                                    optJSONObject3.put("source", liveSource);
                                                    optJSONObject3.put("share_uid", str38);
                                                    optJSONObject3.put("zb_tag", str41);
                                                }
                                                jSONObject15 = parseJSONObject;
                                                str45 = str38;
                                                str40 = str41;
                                            } catch (JSONException unused5) {
                                                str39 = str41;
                                                jSONObject15 = parseJSONObject;
                                                str45 = str38;
                                                str40 = str39;
                                                if (parseJSONObject6 != null) {
                                                }
                                                optString10 = str36;
                                                optJSONObject = jSONObject13.optJSONObject("queryECLive");
                                                optJSONObject2 = jSONObject13.optJSONObject("hlReplay");
                                                jSONObject17 = jSONObject14;
                                                String str4622 = optString;
                                                String str4722 = optString;
                                                str43 = str37;
                                                jSONObject16 = parseJSONObject6;
                                                str42 = liveSource;
                                                SchemeModel schemeModel322 = new SchemeModel(str4622, str27, liveSource, str29, str30, str31, str32, str33, str34, optString10, jSONObject15, parseJSONObject4, parseJSONObject5, parseJSONObject3, jSONObject16, optString3, optString4, parseJSONObject2, parseJSONObject7, optJSONObject, optJSONObject2, str45, str40, optString5, optString6, optString7, optString8, parseJSONObject8, optString20, optString2, optString9, parseJSONObject10);
                                                schemeModel322.setPlayerCacheKey(optString21);
                                                num2 = num;
                                                schemeModel322.setPlayerCacheCodeC(num2);
                                                str16 = str43;
                                                schemeModel322.setKabrSpts(str16);
                                                str44 = str17;
                                                schemeModel322.setRtcHevcUrl(str44);
                                                jSONObject = jSONObject17;
                                                schemeModel322.setCommonShareInfo(jSONObject);
                                                return schemeModel322;
                                            } catch (Exception e41) {
                                                e = e41;
                                                str2 = optString;
                                                jSONObject2 = parseJSONObject;
                                                str12 = str38;
                                                str13 = str41;
                                                str15 = optString21;
                                                jSONObject6 = parseJSONObject6;
                                                str4 = liveSource;
                                                str11 = str36;
                                                str16 = str37;
                                                str14 = optString2;
                                                str3 = str27;
                                                str5 = str29;
                                                str6 = str30;
                                                str7 = str31;
                                                str8 = str32;
                                                str9 = str33;
                                                str10 = str34;
                                                jSONObject7 = parseJSONObject2;
                                                jSONObject5 = parseJSONObject3;
                                                jSONObject3 = parseJSONObject4;
                                                jSONObject4 = parseJSONObject5;
                                                jSONObject12 = parseJSONObject7;
                                                jSONObject9 = parseJSONObject8;
                                                str18 = optString3;
                                                str19 = optString4;
                                                str25 = optString5;
                                                str24 = optString6;
                                                str23 = optString7;
                                                str22 = optString8;
                                                str21 = optString20;
                                                str20 = optString9;
                                                jSONObject8 = parseJSONObject10;
                                                jSONObject11 = null;
                                                jSONObject10 = null;
                                                jSONObject = jSONObject14;
                                                e.printStackTrace();
                                                SchemeModel schemeModel22222222222222222222 = new SchemeModel(str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, jSONObject2, jSONObject3, jSONObject4, jSONObject5, jSONObject6, str18, str19, jSONObject7, jSONObject12, jSONObject11, jSONObject10, str12, str13, str25, str24, str23, str22, jSONObject9, str21, str14, str20, jSONObject8);
                                                schemeModel22222222222222222222.setPlayerCacheKey(str15);
                                                schemeModel22222222222222222222.setPlayerCacheCodeC(num);
                                                schemeModel22222222222222222222.setKabrSpts(str16);
                                                schemeModel22222222222222222222.setRtcHevcUrl(str17);
                                                schemeModel22222222222222222222.setCommonShareInfo(jSONObject);
                                                return schemeModel22222222222222222222;
                                            }
                                        } catch (JSONException unused6) {
                                            str36 = "";
                                        } catch (Exception e42) {
                                            e = e42;
                                            jSONObject14 = parseJSONObject11;
                                            str2 = optString;
                                            jSONObject2 = parseJSONObject;
                                            str15 = optString21;
                                            jSONObject6 = parseJSONObject6;
                                            str4 = liveSource;
                                            str11 = "";
                                            str12 = str11;
                                            str13 = str12;
                                        }
                                    }
                                } catch (Exception e43) {
                                    e = e43;
                                    num2 = num;
                                    str2 = optString;
                                    str15 = optString21;
                                    jSONObject2 = parseJSONObject;
                                    str11 = "";
                                    str12 = str11;
                                    str13 = str12;
                                    str14 = optString2;
                                    str3 = str27;
                                    str5 = str29;
                                    str6 = str30;
                                    str7 = str31;
                                    str8 = str32;
                                    str9 = str33;
                                    str10 = str34;
                                    jSONObject7 = parseJSONObject2;
                                    jSONObject5 = parseJSONObject3;
                                    jSONObject3 = parseJSONObject4;
                                    jSONObject4 = parseJSONObject5;
                                    jSONObject12 = parseJSONObject7;
                                    jSONObject9 = parseJSONObject8;
                                    str18 = optString3;
                                    str19 = optString4;
                                    str25 = optString5;
                                    str24 = optString6;
                                    str23 = optString7;
                                    str22 = optString8;
                                    str21 = optString20;
                                    str20 = optString9;
                                    jSONObject8 = parseJSONObject10;
                                    jSONObject6 = parseJSONObject6;
                                    str4 = liveSource;
                                    jSONObject = null;
                                }
                                try {
                                    if (parseJSONObject6 != null) {
                                        try {
                                            JSONObject optJSONObject4 = parseJSONObject6.optJSONObject("ext");
                                            if (optJSONObject4 != null) {
                                                optString10 = optJSONObject4.optString("live_back_scheme");
                                                if (optString10 == null) {
                                                    optString10 = str36;
                                                }
                                                try {
                                                    if (TextUtils.isEmpty(optString10)) {
                                                        String optString23 = optJSONObject4.optString("live_back_for_both_scheme");
                                                        if (optString23 == null) {
                                                            optString23 = str36;
                                                        }
                                                        optString10 = optString23;
                                                    }
                                                    optJSONObject = jSONObject13.optJSONObject("queryECLive");
                                                    optJSONObject2 = jSONObject13.optJSONObject("hlReplay");
                                                    jSONObject17 = jSONObject14;
                                                    String str46222 = optString;
                                                    String str47222 = optString;
                                                    str43 = str37;
                                                    jSONObject16 = parseJSONObject6;
                                                    str42 = liveSource;
                                                    SchemeModel schemeModel3222 = new SchemeModel(str46222, str27, liveSource, str29, str30, str31, str32, str33, str34, optString10, jSONObject15, parseJSONObject4, parseJSONObject5, parseJSONObject3, jSONObject16, optString3, optString4, parseJSONObject2, parseJSONObject7, optJSONObject, optJSONObject2, str45, str40, optString5, optString6, optString7, optString8, parseJSONObject8, optString20, optString2, optString9, parseJSONObject10);
                                                    schemeModel3222.setPlayerCacheKey(optString21);
                                                    num2 = num;
                                                    schemeModel3222.setPlayerCacheCodeC(num2);
                                                    str16 = str43;
                                                    schemeModel3222.setKabrSpts(str16);
                                                    str44 = str17;
                                                    schemeModel3222.setRtcHevcUrl(str44);
                                                    jSONObject = jSONObject17;
                                                    schemeModel3222.setCommonShareInfo(jSONObject);
                                                    return schemeModel3222;
                                                } catch (Exception e44) {
                                                    e = e44;
                                                    jSONObject = jSONObject14;
                                                    str11 = optString10;
                                                    jSONObject2 = jSONObject15;
                                                    str12 = str45;
                                                    str13 = str40;
                                                    str2 = optString;
                                                    str15 = optString21;
                                                    jSONObject6 = parseJSONObject6;
                                                    str4 = liveSource;
                                                    str16 = str37;
                                                    str14 = optString2;
                                                    str3 = str27;
                                                    str5 = str29;
                                                    str6 = str30;
                                                    str7 = str31;
                                                    str8 = str32;
                                                    str9 = str33;
                                                    str10 = str34;
                                                    jSONObject7 = parseJSONObject2;
                                                    jSONObject5 = parseJSONObject3;
                                                    jSONObject3 = parseJSONObject4;
                                                    jSONObject4 = parseJSONObject5;
                                                    jSONObject12 = parseJSONObject7;
                                                    jSONObject9 = parseJSONObject8;
                                                    str18 = optString3;
                                                    str19 = optString4;
                                                    str25 = optString5;
                                                    str24 = optString6;
                                                    str23 = optString7;
                                                    str22 = optString8;
                                                    str21 = optString20;
                                                    str20 = optString9;
                                                    jSONObject8 = parseJSONObject10;
                                                    jSONObject11 = null;
                                                    jSONObject10 = null;
                                                    e.printStackTrace();
                                                    SchemeModel schemeModel222222222222222222222 = new SchemeModel(str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, jSONObject2, jSONObject3, jSONObject4, jSONObject5, jSONObject6, str18, str19, jSONObject7, jSONObject12, jSONObject11, jSONObject10, str12, str13, str25, str24, str23, str22, jSONObject9, str21, str14, str20, jSONObject8);
                                                    schemeModel222222222222222222222.setPlayerCacheKey(str15);
                                                    schemeModel222222222222222222222.setPlayerCacheCodeC(num);
                                                    schemeModel222222222222222222222.setKabrSpts(str16);
                                                    schemeModel222222222222222222222.setRtcHevcUrl(str17);
                                                    schemeModel222222222222222222222.setCommonShareInfo(jSONObject);
                                                    return schemeModel222222222222222222222;
                                                }
                                            }
                                        } catch (Exception e45) {
                                            e = e45;
                                            jSONObject = jSONObject14;
                                            jSONObject2 = jSONObject15;
                                            str12 = str45;
                                            str13 = str40;
                                            str2 = optString;
                                            str15 = optString21;
                                            jSONObject6 = parseJSONObject6;
                                            str4 = liveSource;
                                            str11 = str36;
                                        }
                                    }
                                    optJSONObject2 = jSONObject13.optJSONObject("hlReplay");
                                    jSONObject17 = jSONObject14;
                                    String str462222 = optString;
                                    String str472222 = optString;
                                    str43 = str37;
                                    jSONObject16 = parseJSONObject6;
                                    str42 = liveSource;
                                    SchemeModel schemeModel32222 = new SchemeModel(str462222, str27, liveSource, str29, str30, str31, str32, str33, str34, optString10, jSONObject15, parseJSONObject4, parseJSONObject5, parseJSONObject3, jSONObject16, optString3, optString4, parseJSONObject2, parseJSONObject7, optJSONObject, optJSONObject2, str45, str40, optString5, optString6, optString7, optString8, parseJSONObject8, optString20, optString2, optString9, parseJSONObject10);
                                    schemeModel32222.setPlayerCacheKey(optString21);
                                    num2 = num;
                                    schemeModel32222.setPlayerCacheCodeC(num2);
                                    str16 = str43;
                                    schemeModel32222.setKabrSpts(str16);
                                    str44 = str17;
                                    schemeModel32222.setRtcHevcUrl(str44);
                                    jSONObject = jSONObject17;
                                    schemeModel32222.setCommonShareInfo(jSONObject);
                                    return schemeModel32222;
                                } catch (Exception e46) {
                                    e = e46;
                                    jSONObject = jSONObject14;
                                    num2 = num;
                                    str16 = str37;
                                    str2 = optString;
                                    str11 = optString10;
                                    jSONObject2 = jSONObject15;
                                    str12 = str45;
                                    str13 = str40;
                                    str15 = optString21;
                                    str14 = optString2;
                                    str3 = str27;
                                    str5 = str29;
                                    str6 = str30;
                                    str7 = str31;
                                    str8 = str32;
                                    str9 = str33;
                                    str10 = str34;
                                    jSONObject7 = parseJSONObject2;
                                    jSONObject5 = parseJSONObject3;
                                    jSONObject3 = parseJSONObject4;
                                    jSONObject4 = parseJSONObject5;
                                    jSONObject12 = parseJSONObject7;
                                    jSONObject9 = parseJSONObject8;
                                    str18 = optString3;
                                    str19 = optString4;
                                    str25 = optString5;
                                    str24 = optString6;
                                    str23 = optString7;
                                    str22 = optString8;
                                    str21 = optString20;
                                    str20 = optString9;
                                    jSONObject8 = parseJSONObject10;
                                    jSONObject11 = optJSONObject;
                                    jSONObject6 = parseJSONObject6;
                                    str4 = liveSource;
                                    jSONObject10 = null;
                                    num = num2;
                                    e.printStackTrace();
                                    SchemeModel schemeModel2222222222222222222222 = new SchemeModel(str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, jSONObject2, jSONObject3, jSONObject4, jSONObject5, jSONObject6, str18, str19, jSONObject7, jSONObject12, jSONObject11, jSONObject10, str12, str13, str25, str24, str23, str22, jSONObject9, str21, str14, str20, jSONObject8);
                                    schemeModel2222222222222222222222.setPlayerCacheKey(str15);
                                    schemeModel2222222222222222222222.setPlayerCacheCodeC(num);
                                    schemeModel2222222222222222222222.setKabrSpts(str16);
                                    schemeModel2222222222222222222222.setRtcHevcUrl(str17);
                                    schemeModel2222222222222222222222.setCommonShareInfo(jSONObject);
                                    return schemeModel2222222222222222222222;
                                }
                                optString10 = str36;
                                optJSONObject = jSONObject13.optJSONObject("queryECLive");
                            } catch (Exception e47) {
                                e = e47;
                                num2 = num;
                                str2 = optString;
                                str15 = optString21;
                                jSONObject2 = parseJSONObject;
                                str11 = "";
                                str12 = str11;
                                str13 = str12;
                                str14 = optString2;
                                str3 = str27;
                                str5 = str29;
                                str6 = str30;
                                str7 = str31;
                                str8 = str32;
                                str9 = str33;
                                str10 = str34;
                                jSONObject7 = parseJSONObject2;
                                jSONObject5 = parseJSONObject3;
                                jSONObject3 = parseJSONObject4;
                                jSONObject4 = parseJSONObject5;
                                jSONObject12 = parseJSONObject7;
                                jSONObject9 = parseJSONObject8;
                                str18 = optString3;
                                str19 = optString4;
                                str25 = optString5;
                                str24 = optString6;
                                str23 = optString7;
                                str22 = optString8;
                                str21 = optString20;
                                str20 = optString9;
                                jSONObject8 = parseJSONObject10;
                                jSONObject6 = parseJSONObject6;
                                str4 = liveSource;
                                jSONObject = null;
                                str16 = null;
                            }
                        } catch (Exception e48) {
                            e = e48;
                            str2 = optString;
                            str15 = optString21;
                            jSONObject2 = parseJSONObject;
                            str11 = "";
                            str12 = str11;
                            str13 = str12;
                            str14 = optString2;
                            str3 = str27;
                            str5 = str29;
                            str6 = str30;
                            str7 = str31;
                            str8 = str32;
                            str9 = str33;
                            str10 = str34;
                            jSONObject7 = parseJSONObject2;
                            jSONObject5 = parseJSONObject3;
                            jSONObject3 = parseJSONObject4;
                            jSONObject4 = parseJSONObject5;
                            jSONObject12 = parseJSONObject7;
                            jSONObject9 = parseJSONObject8;
                            str18 = optString3;
                            str19 = optString4;
                            str25 = optString5;
                            str24 = optString6;
                            str23 = optString7;
                            str22 = optString8;
                            str21 = optString20;
                            str20 = optString9;
                            jSONObject8 = parseJSONObject10;
                            jSONObject6 = parseJSONObject6;
                            str4 = liveSource;
                            jSONObject = null;
                            str16 = null;
                            num = null;
                            jSONObject11 = null;
                            jSONObject10 = null;
                            e.printStackTrace();
                            SchemeModel schemeModel22222222222222222222222 = new SchemeModel(str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, jSONObject2, jSONObject3, jSONObject4, jSONObject5, jSONObject6, str18, str19, jSONObject7, jSONObject12, jSONObject11, jSONObject10, str12, str13, str25, str24, str23, str22, jSONObject9, str21, str14, str20, jSONObject8);
                            schemeModel22222222222222222222222.setPlayerCacheKey(str15);
                            schemeModel22222222222222222222222.setPlayerCacheCodeC(num);
                            schemeModel22222222222222222222222.setKabrSpts(str16);
                            schemeModel22222222222222222222222.setRtcHevcUrl(str17);
                            schemeModel22222222222222222222222.setCommonShareInfo(jSONObject);
                            return schemeModel22222222222222222222222;
                        }
                    } catch (Exception e49) {
                        e = e49;
                        str2 = optString;
                        jSONObject2 = parseJSONObject;
                        str11 = "";
                        str12 = str11;
                        str13 = str12;
                        str14 = optString2;
                        str3 = str27;
                        str5 = str29;
                        str6 = str30;
                        str7 = str31;
                        str8 = str32;
                        str9 = str33;
                        str10 = str34;
                        jSONObject7 = parseJSONObject2;
                        jSONObject5 = parseJSONObject3;
                        jSONObject3 = parseJSONObject4;
                        jSONObject4 = parseJSONObject5;
                        jSONObject12 = parseJSONObject7;
                        jSONObject9 = parseJSONObject8;
                        str18 = optString3;
                        str19 = optString4;
                        str25 = optString5;
                        str24 = optString6;
                        str23 = optString7;
                        str22 = optString8;
                        str21 = optString20;
                        str20 = optString9;
                        jSONObject8 = parseJSONObject10;
                        jSONObject6 = parseJSONObject6;
                        str4 = liveSource;
                        str15 = null;
                    }
                } catch (Exception e50) {
                    e = e50;
                    str2 = optString;
                    jSONObject2 = parseJSONObject;
                    str11 = "";
                    str12 = str11;
                    str13 = str12;
                    str14 = optString2;
                    str3 = str27;
                    str5 = str29;
                    str6 = str30;
                    str7 = str31;
                    str8 = str32;
                    str9 = str33;
                    str10 = str34;
                    jSONObject7 = parseJSONObject2;
                    jSONObject5 = parseJSONObject3;
                    jSONObject3 = parseJSONObject4;
                    jSONObject4 = parseJSONObject5;
                    jSONObject12 = parseJSONObject7;
                    jSONObject9 = parseJSONObject8;
                    str18 = optString3;
                    str19 = optString4;
                    str25 = optString5;
                    str24 = optString6;
                    str23 = optString7;
                    str22 = optString8;
                    str21 = optString20;
                    str20 = optString9;
                    jSONObject6 = parseJSONObject6;
                    str4 = liveSource;
                    str15 = null;
                    jSONObject = null;
                    str16 = null;
                    num = null;
                    jSONObject11 = null;
                    jSONObject10 = null;
                    jSONObject8 = null;
                    e.printStackTrace();
                    SchemeModel schemeModel222222222222222222222222 = new SchemeModel(str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, jSONObject2, jSONObject3, jSONObject4, jSONObject5, jSONObject6, str18, str19, jSONObject7, jSONObject12, jSONObject11, jSONObject10, str12, str13, str25, str24, str23, str22, jSONObject9, str21, str14, str20, jSONObject8);
                    schemeModel222222222222222222222222.setPlayerCacheKey(str15);
                    schemeModel222222222222222222222222.setPlayerCacheCodeC(num);
                    schemeModel222222222222222222222222.setKabrSpts(str16);
                    schemeModel222222222222222222222222.setRtcHevcUrl(str17);
                    schemeModel222222222222222222222222.setCommonShareInfo(jSONObject);
                    return schemeModel222222222222222222222222;
                }
            } catch (Exception e51) {
                e = e51;
                str2 = optString;
                jSONObject2 = parseJSONObject;
                str11 = "";
                str12 = str11;
                str13 = str12;
                str14 = optString2;
                str3 = str27;
                str5 = str29;
                str6 = str30;
                str7 = str31;
                str8 = str32;
                str9 = str33;
                str10 = str34;
                jSONObject7 = parseJSONObject2;
                jSONObject5 = parseJSONObject3;
                jSONObject3 = parseJSONObject4;
                jSONObject4 = parseJSONObject5;
                jSONObject12 = parseJSONObject7;
                jSONObject9 = parseJSONObject8;
                str18 = optString3;
                str19 = optString4;
                str25 = optString5;
                str24 = optString6;
                str23 = optString7;
                str22 = optString8;
                jSONObject6 = parseJSONObject6;
                str4 = liveSource;
                str15 = null;
                jSONObject = null;
                str16 = null;
                num = null;
                jSONObject11 = null;
                jSONObject10 = null;
                str21 = null;
                str20 = null;
                jSONObject8 = null;
                e.printStackTrace();
                SchemeModel schemeModel2222222222222222222222222 = new SchemeModel(str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, jSONObject2, jSONObject3, jSONObject4, jSONObject5, jSONObject6, str18, str19, jSONObject7, jSONObject12, jSONObject11, jSONObject10, str12, str13, str25, str24, str23, str22, jSONObject9, str21, str14, str20, jSONObject8);
                schemeModel2222222222222222222222222.setPlayerCacheKey(str15);
                schemeModel2222222222222222222222222.setPlayerCacheCodeC(num);
                schemeModel2222222222222222222222222.setKabrSpts(str16);
                schemeModel2222222222222222222222222.setRtcHevcUrl(str17);
                schemeModel2222222222222222222222222.setCommonShareInfo(jSONObject);
                return schemeModel2222222222222222222222222;
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

        public final void setBanQuestionFromSearchDialog(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048579, this, z) != null) {
                return;
            }
            IntentData.banQuestionFromSearchDialog = z;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bA\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\bH\b\u0086\b\u0018\u0000Bó\u0002\u0012\u0006\u0010%\u001a\u00020\u0001\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010'\u001a\u00020\u0001\u0012\b\b\u0002\u0010(\u001a\u00020\u0001\u0012\b\b\u0002\u0010)\u001a\u00020\u0001\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010-\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u0005¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J\u0010\u0010\u0002\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0003J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\f\u0010\u0003J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\r\u0010\u0003J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0007J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0007J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0003J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0007J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0007J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0003J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0003J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0003J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0003J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0003J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0003J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0007J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0003J\u0010\u0010\u001b\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0003J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0003J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0003J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0007J\u0010\u0010\u001f\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0003J\u0010\u0010 \u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b \u0010\u0003J\u0012\u0010!\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b!\u0010\u0003J\u0012\u0010\"\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\"\u0010\u0003J\u0012\u0010#\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b#\u0010\u0003J\u0012\u0010$\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b$\u0010\u0003J\u0088\u0003\u0010E\u001a\u00020\u00002\b\b\u0002\u0010%\u001a\u00020\u00012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010'\u001a\u00020\u00012\b\b\u0002\u0010(\u001a\u00020\u00012\b\b\u0002\u0010)\u001a\u00020\u00012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\bE\u0010FJ\u001a\u0010J\u001a\u00020I2\b\u0010H\u001a\u0004\u0018\u00010GHÖ\u0003¢\u0006\u0004\bJ\u0010KJ\u0010\u0010M\u001a\u00020LHÖ\u0001¢\u0006\u0004\bM\u0010NJ\r\u0010O\u001a\u00020\u0001¢\u0006\u0004\bO\u0010\u0003J\u0010\u0010P\u001a\u00020\u0001HÖ\u0001¢\u0006\u0004\bP\u0010\u0003R\u001b\u00104\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010Q\u001a\u0004\bR\u0010\u0003R\u001b\u0010<\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010Q\u001a\u0004\bS\u0010\u0003R$\u0010T\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010\u0007\"\u0004\bW\u0010XR\u0019\u0010(\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010Q\u001a\u0004\bY\u0010\u0003R\u001b\u0010/\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010U\u001a\u0004\bZ\u0010\u0007R\u001b\u00101\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010U\u001a\u0004\b[\u0010\u0007R\u001b\u00103\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010U\u001a\u0004\b\\\u0010\u0007R\u001b\u00100\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010U\u001a\u0004\b]\u0010\u0007R\u001b\u0010+\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010Q\u001a\u0004\b^\u0010\u0003R\u001b\u0010=\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010Q\u001a\u0004\b_\u0010\u0003R\u001b\u0010C\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010Q\u001a\u0004\b`\u0010\u0003R$\u00109\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010U\u001a\u0004\ba\u0010\u0007\"\u0004\bb\u0010XR$\u0010D\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010U\u001a\u0004\bc\u0010\u0007\"\u0004\bd\u0010XR\u001b\u0010B\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\bB\u0010Q\u001a\u0004\be\u0010\u0003R$\u00107\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010U\u001a\u0004\bf\u0010\u0007\"\u0004\bg\u0010XR$\u0010h\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bh\u0010Q\u001a\u0004\bi\u0010\u0003\"\u0004\bj\u0010kR$\u0010.\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010Q\u001a\u0004\bl\u0010\u0003\"\u0004\bm\u0010kR$\u00106\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u0010U\u001a\u0004\bn\u0010\u0007\"\u0004\bo\u0010XR\u0019\u0010)\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010Q\u001a\u0004\bp\u0010\u0003R$\u0010q\u001a\u0004\u0018\u00010L8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bq\u0010r\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR$\u0010w\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bw\u0010Q\u001a\u0004\bx\u0010\u0003\"\u0004\by\u0010kR$\u00102\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010U\u001a\u0004\bz\u0010\u0007\"\u0004\b{\u0010XR\u001b\u0010A\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010Q\u001a\u0004\b|\u0010\u0003R\u0019\u0010%\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010Q\u001a\u0004\b}\u0010\u0003R$\u0010&\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010Q\u001a\u0004\b~\u0010\u0003\"\u0004\b\u007f\u0010kR(\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0080\u0001\u0010Q\u001a\u0005\b\u0081\u0001\u0010\u0003\"\u0005\b\u0082\u0001\u0010kR\u001c\u0010>\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\r\n\u0004\b>\u0010Q\u001a\u0005\b\u0083\u0001\u0010\u0003R\u001c\u0010,\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\r\n\u0004\b,\u0010Q\u001a\u0005\b\u0084\u0001\u0010\u0003R&\u00108\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b8\u0010U\u001a\u0005\b\u0085\u0001\u0010\u0007\"\u0005\b\u0086\u0001\u0010XR&\u0010;\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b;\u0010Q\u001a\u0005\b\u0087\u0001\u0010\u0003\"\u0005\b\u0088\u0001\u0010kR\u001c\u0010@\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\r\n\u0004\b@\u0010U\u001a\u0005\b\u0089\u0001\u0010\u0007R&\u0010:\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b:\u0010Q\u001a\u0005\b\u008a\u0001\u0010\u0003\"\u0005\b\u008b\u0001\u0010kR\u001a\u0010'\u001a\u00020\u00018\u0006@\u0006¢\u0006\r\n\u0004\b'\u0010Q\u001a\u0005\b\u008c\u0001\u0010\u0003R\u001c\u0010*\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\r\n\u0004\b*\u0010Q\u001a\u0005\b\u008d\u0001\u0010\u0003R\u001c\u0010-\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\r\n\u0004\b-\u0010Q\u001a\u0005\b\u008e\u0001\u0010\u0003R&\u00105\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b5\u0010Q\u001a\u0005\b\u008f\u0001\u0010\u0003\"\u0005\b\u0090\u0001\u0010kR\u001c\u0010?\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\r\n\u0004\b?\u0010Q\u001a\u0005\b\u0091\u0001\u0010\u0003¨\u0006\u0094\u0001"}, d2 = {"Lcom/baidu/searchbox/live/frame/IntentData$SchemeModel;", "", "component1", "()Ljava/lang/String;", "component10", "Lorg/json/JSONObject;", "component11", "()Lorg/json/JSONObject;", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component4", "component5", "component6", "component7", "component8", "component9", "roomId", "roomType", "source", AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, "playUrl", "status", "format", "screen", MediaTrackConfig.AE_IMPORT_TEMPLATE, "liveBackScheme", "ext", "extRequest", "extLog", "query", "extParams", "askId", "templateId", "otherParams", "invokePop", "searchIntoLiveJson", "hlReplyIntoLive", "shareUid", "shareTag", "avcUrl", "hevcUrl", "rtcUrl", "title", "shareTaskInfo", "quic", "inviterId", "highlightUrl", "introduceTips", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)Lcom/baidu/searchbox/live/frame/IntentData$SchemeModel;", "", ImageViewerConfig.FROM_OTHER, "", "equals", "(Ljava/lang/Object;)Z", "", TTDownloadField.TT_HASHCODE, "()I", "toSchemeParams", "toString", "Ljava/lang/String;", "getAskId", "getAvcUrl", "commonShareInfo", "Lorg/json/JSONObject;", "getCommonShareInfo", "setCommonShareInfo", "(Lorg/json/JSONObject;)V", "getCover", "getExt", "getExtLog", "getExtParams", "getExtRequest", "getFormat", "getHevcUrl", "getHighlightUrl", "getHlReplyIntoLive", "setHlReplyIntoLive", "getIntroduceTips", "setIntroduceTips", "getInviterId", "getInvokePop", "setInvokePop", "kabrSpts", "getKabrSpts", "setKabrSpts", "(Ljava/lang/String;)V", "getLiveBackScheme", "setLiveBackScheme", "getOtherParams", "setOtherParams", "getPlayUrl", "playerCacheCodeC", "Ljava/lang/Integer;", "getPlayerCacheCodeC", "()Ljava/lang/Integer;", "setPlayerCacheCodeC", "(Ljava/lang/Integer;)V", "playerCacheKey", "getPlayerCacheKey", "setPlayerCacheKey", "getQuery", "setQuery", "getQuic", "getRoomId", "getRoomType", "setRoomType", "rtcHevcUrl", "getRtcHevcUrl", "setRtcHevcUrl", "getRtcUrl", "getScreen", "getSearchIntoLiveJson", "setSearchIntoLiveJson", "getShareTag", "setShareTag", "getShareTaskInfo", "getShareUid", "setShareUid", "getSource", "getStatus", "getTemplate", "getTemplateId", "setTemplateId", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
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
        public final String hevcUrl;
        public final String highlightUrl;
        public JSONObject hlReplyIntoLive;
        public JSONObject introduceTips;
        public final String inviterId;
        public JSONObject invokePop;
        public String kabrSpts;
        public String liveBackScheme;
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
            if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
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
            if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
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

        public final String getHevcUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
                return this.hevcUrl;
            }
            return (String) invokeV.objValue;
        }

        public final String getHighlightUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
                return this.highlightUrl;
            }
            return (String) invokeV.objValue;
        }

        public final JSONObject getHlReplyIntoLive() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
                return this.hlReplyIntoLive;
            }
            return (JSONObject) invokeV.objValue;
        }

        public final JSONObject getIntroduceTips() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
                return this.introduceTips;
            }
            return (JSONObject) invokeV.objValue;
        }

        public final String getInviterId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
                return this.inviterId;
            }
            return (String) invokeV.objValue;
        }

        public final JSONObject getInvokePop() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
                return this.invokePop;
            }
            return (JSONObject) invokeV.objValue;
        }

        public final String getKabrSpts() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
                return this.kabrSpts;
            }
            return (String) invokeV.objValue;
        }

        public final String getLiveBackScheme() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
                return this.liveBackScheme;
            }
            return (String) invokeV.objValue;
        }

        public final JSONObject getOtherParams() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
                return this.otherParams;
            }
            return (JSONObject) invokeV.objValue;
        }

        public final String getPlayUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
                return this.playUrl;
            }
            return (String) invokeV.objValue;
        }

        public final Integer getPlayerCacheCodeC() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
                return this.playerCacheCodeC;
            }
            return (Integer) invokeV.objValue;
        }

        public final String getPlayerCacheKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
                return this.playerCacheKey;
            }
            return (String) invokeV.objValue;
        }

        public final JSONObject getQuery() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
                return this.query;
            }
            return (JSONObject) invokeV.objValue;
        }

        public final String getQuic() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
                return this.quic;
            }
            return (String) invokeV.objValue;
        }

        public final String getRoomId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
                return this.roomId;
            }
            return (String) invokeV.objValue;
        }

        public final String getRoomType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
                return this.roomType;
            }
            return (String) invokeV.objValue;
        }

        public final String getRtcHevcUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
                return this.rtcHevcUrl;
            }
            return (String) invokeV.objValue;
        }

        public final String getRtcUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
                return this.rtcUrl;
            }
            return (String) invokeV.objValue;
        }

        public final String getScreen() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
                return this.screen;
            }
            return (String) invokeV.objValue;
        }

        public final JSONObject getSearchIntoLiveJson() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
                return this.searchIntoLiveJson;
            }
            return (JSONObject) invokeV.objValue;
        }

        public final String getShareTag() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
                return this.shareTag;
            }
            return (String) invokeV.objValue;
        }

        public final JSONObject getShareTaskInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
                return this.shareTaskInfo;
            }
            return (JSONObject) invokeV.objValue;
        }

        public final String getShareUid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
                return this.shareUid;
            }
            return (String) invokeV.objValue;
        }

        public final String getSource() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
                return this.source;
            }
            return (String) invokeV.objValue;
        }

        public final String getStatus() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
                return this.status;
            }
            return (String) invokeV.objValue;
        }

        public final String getTemplate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
                return this.template;
            }
            return (String) invokeV.objValue;
        }

        public final String getTemplateId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
                return this.templateId;
            }
            return (String) invokeV.objValue;
        }

        public final String getTitle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
                return this.title;
            }
            return (String) invokeV.objValue;
        }

        public final void setCommonShareInfo(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048648, this, jSONObject) == null) {
                this.commonShareInfo = jSONObject;
            }
        }

        public final void setHlReplyIntoLive(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048649, this, jSONObject) == null) {
                this.hlReplyIntoLive = jSONObject;
            }
        }

        public final void setIntroduceTips(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048650, this, jSONObject) == null) {
                this.introduceTips = jSONObject;
            }
        }

        public final void setInvokePop(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048651, this, jSONObject) == null) {
                this.invokePop = jSONObject;
            }
        }

        public final void setKabrSpts(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048652, this, str) == null) {
                this.kabrSpts = str;
            }
        }

        public final void setLiveBackScheme(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048653, this, str) == null) {
                this.liveBackScheme = str;
            }
        }

        public final void setOtherParams(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048654, this, jSONObject) == null) {
                this.otherParams = jSONObject;
            }
        }

        public final void setPlayerCacheCodeC(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048655, this, num) == null) {
                this.playerCacheCodeC = num;
            }
        }

        public final void setPlayerCacheKey(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048656, this, str) == null) {
                this.playerCacheKey = str;
            }
        }

        public final void setQuery(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048657, this, jSONObject) == null) {
                this.query = jSONObject;
            }
        }

        public final void setRoomType(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048658, this, str) == null) {
                this.roomType = str;
            }
        }

        public final void setRtcHevcUrl(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048659, this, str) == null) {
                this.rtcHevcUrl = str;
            }
        }

        public final void setSearchIntoLiveJson(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048660, this, jSONObject) == null) {
                this.searchIntoLiveJson = jSONObject;
            }
        }

        public final void setShareTag(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048661, this, str) == null) {
                this.shareTag = str;
            }
        }

        public final void setShareUid(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048662, this, str) == null) {
                this.shareUid = str;
            }
        }

        public final void setTemplateId(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048663, this, str) == null) {
                this.templateId = str;
            }
        }

        public final String toSchemeParams() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) {
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
                        jSONObject.putOpt(LivePreStartPlayServiceImpl.PARAM_KABR_SPTS, str12);
                    }
                    JSONObject jSONObject13 = this.commonShareInfo;
                    if (jSONObject13 != null) {
                        jSONObject.putOpt("commonShareInfo", jSONObject13);
                    }
                } catch (JSONException unused) {
                }
                String jSONObject14 = jSONObject.toString();
                Intrinsics.checkExpressionValueIsNotNull(jSONObject14, "json.toString()");
                return jSONObject14;
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
