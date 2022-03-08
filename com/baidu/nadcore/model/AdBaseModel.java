package com.baidu.nadcore.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.b0.s.b;
import c.a.b0.s.c;
import c.a.b0.s.e;
import c.a.b0.s.g;
import c.a.b0.s.i;
import c.a.b0.s.k;
import c.a.b0.s.p;
import c.a.b0.s.s;
import c.a.b0.s.t;
import c.a.b0.x.a;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.TiebaMainDatabaseHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.tachikoma.core.component.TKBase;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f35657b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final ParseError f35658c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f35659d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final List<MonitorUrl> f35660e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final i f35661f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public final b f35662g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public final AdOperator f35663h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public final t f35664i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    public final p f35665j;
    @Nullable
    public final List<k> k;
    @Nullable
    public final c l;
    @Nullable
    public g m;
    @Nullable
    public e n;
    public int o;
    @NonNull
    public List<String> p;
    public s q;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class STYLE {
        public static final /* synthetic */ STYLE[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final STYLE BIG_IMAGE;
        public static final STYLE FLOAT;
        public static final STYLE HIDDEN;
        public static final STYLE MAX;
        public static final STYLE PORTRAIT_VIDEO;
        public static final STYLE REWARD_VIDEO_LP;
        public static final STYLE REWARD_VIDEO_LP_IMPL;
        public static final STYLE SMALL_IMAGE;
        public static final STYLE THREE_IMAGE;
        public static final STYLE VIDEO;
        public transient /* synthetic */ FieldHolder $fh;
        public final String value;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1666764588, "Lcom/baidu/nadcore/model/AdBaseModel$STYLE;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1666764588, "Lcom/baidu/nadcore/model/AdBaseModel$STYLE;");
                    return;
                }
            }
            BIG_IMAGE = new STYLE("BIG_IMAGE", 0, "big_image");
            SMALL_IMAGE = new STYLE("SMALL_IMAGE", 1, "small_image");
            THREE_IMAGE = new STYLE("THREE_IMAGE", 2, "three_image");
            VIDEO = new STYLE(HlsPlaylistParser.TYPE_VIDEO, 3, "video");
            PORTRAIT_VIDEO = new STYLE("PORTRAIT_VIDEO", 4, "portrait_video");
            FLOAT = new STYLE("FLOAT", 5, ShaderParams.VALUE_TYPE_FLOAT);
            REWARD_VIDEO_LP = new STYLE("REWARD_VIDEO_LP", 6, "reward_video_lp");
            REWARD_VIDEO_LP_IMPL = new STYLE("REWARD_VIDEO_LP_IMPL", 7, "reward_video_lp_impl");
            MAX = new STYLE("MAX", 8, "max");
            STYLE style = new STYLE("HIDDEN", 9, TKBase.VISIBILITY_HIDDEN);
            HIDDEN = style;
            $VALUES = new STYLE[]{BIG_IMAGE, SMALL_IMAGE, THREE_IMAGE, VIDEO, PORTRAIT_VIDEO, FLOAT, REWARD_VIDEO_LP, REWARD_VIDEO_LP_IMPL, MAX, style};
        }

        public STYLE(String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.value = str2;
        }

        public static STYLE from(String str) {
            InterceptResult invokeL;
            STYLE[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                for (STYLE style : values()) {
                    if (style.value.equals(str)) {
                        return style;
                    }
                }
                throw new EnumConstantNotPresentException(STYLE.class, str);
            }
            return (STYLE) invokeL.objValue;
        }

        public static int getStyleCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? values().length : invokeV.intValue;
        }

        public static STYLE valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (STYLE) Enum.valueOf(STYLE.class, str) : (STYLE) invokeL.objValue;
        }

        public static STYLE[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? (STYLE[]) $VALUES.clone() : (STYLE[]) invokeV.objValue;
        }
    }

    public AdBaseModel(@NonNull i iVar, @NonNull JSONObject jSONObject) throws ParseError {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iVar, jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35660e = new ArrayList();
        this.p = new ArrayList();
        String str = iVar.f1921b;
        JSONObject optJSONObject = jSONObject.optJSONObject(GameGuideConfigInfo.KEY_CLOSE_INFO);
        this.f35662g = optJSONObject == null ? null : b.a(optJSONObject);
        this.f35661f = iVar;
        this.f35665j = p.a(jSONObject.optJSONObject(WriteActivityConfig.VIDEO_INFO));
        this.k = k.a(jSONObject.optJSONArray("prefetch_video"));
        this.l = c.b(jSONObject.optJSONObject(TiebaMainDatabaseHelper.TABLE_NAME_DOWNLOAD_INFO));
        this.m = g.a(jSONObject.optJSONObject("enhance"));
        this.n = e.a(jSONObject.optJSONObject(ThreadAchievementShareDialogView.THREAD_INTERACTION_VIEW_TYPE));
        JSONObject optJSONObject2 = jSONObject.optJSONObject("operate");
        AdOperator a = optJSONObject2 == null ? null : AdOperator.a(optJSONObject2);
        this.f35663h = a;
        this.f35659d = a != null;
        JSONObject optJSONObject3 = jSONObject.optJSONObject("app_info");
        t c2 = optJSONObject3 == null ? null : t.c(optJSONObject3);
        this.f35664i = (c2 == null || !c2.k) ? null : c2;
        JSONArray optJSONArray = jSONObject.optJSONArray("ad_monitor_url");
        int length = optJSONArray == null ? 0 : optJSONArray.length();
        for (int i4 = 0; i4 < length; i4++) {
            JSONObject optJSONObject4 = optJSONArray.optJSONObject(i4);
            if (optJSONObject4 != null) {
                String optString = optJSONObject4.optString("show_url");
                String optString2 = optJSONObject4.optString("click_url");
                if (!TextUtils.isEmpty(optString) || !TextUtils.isEmpty(optString2)) {
                    a.b(this.f35660e, new MonitorUrl(optString, optString2));
                }
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("tag_list");
        int length2 = optJSONArray2 == null ? 0 : optJSONArray2.length();
        for (int i5 = 0; i5 < length2; i5++) {
            JSONObject optJSONObject5 = optJSONArray2.optJSONObject(i5);
            if (optJSONObject5 != null) {
                String optString3 = optJSONObject5.optString("word");
                if (!TextUtils.isEmpty(optString3)) {
                    a.b(this.p, optString3);
                }
            }
        }
        p pVar = this.f35665j;
        if (pVar != null) {
            pVar.b(this);
        }
        this.f35658c = null;
    }

    public void a(@Nullable s sVar) {
        List<k> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, sVar) == null) {
            this.q = sVar;
            if (sVar == null || sVar.f1949c) {
                this.f35661f.b();
            }
            if ((sVar == null || sVar.f1950d) && (list = this.k) != null && list.size() > 0) {
                for (k kVar : this.k) {
                    kVar.b();
                }
            }
        }
    }
}
