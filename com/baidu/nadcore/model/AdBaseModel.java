package com.baidu.nadcore.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
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
import com.repackage.cn0;
import com.repackage.dn0;
import com.repackage.eg0;
import com.repackage.jm0;
import com.repackage.km0;
import com.repackage.kx0;
import com.repackage.mm0;
import com.repackage.om0;
import com.repackage.sm0;
import com.repackage.um0;
import com.repackage.zm0;
import com.tachikoma.core.component.TKBase;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    @Nullable
    public final ParseError c;
    public final boolean d;
    @NonNull
    public final List<MonitorUrl> e;
    @NonNull
    public final sm0 f;
    @Nullable
    public final jm0 g;
    @Nullable
    public final AdOperator h;
    @Nullable
    public final dn0 i;
    @Nullable
    public final zm0 j;
    @Nullable
    public final List<um0> k;
    @Nullable
    public final km0 l;
    @Nullable
    public om0 m;
    public int n;
    @NonNull
    public List<String> o;
    public cn0 p;
    public eg0 q;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
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

        public STYLE(String str, int i, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

    public AdBaseModel(@NonNull sm0 sm0Var, @NonNull JSONObject jSONObject) throws ParseError {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sm0Var, jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new ArrayList();
        this.o = new ArrayList();
        String str = sm0Var.b;
        JSONObject optJSONObject = jSONObject.optJSONObject(GameGuideConfigInfo.KEY_CLOSE_INFO);
        this.g = optJSONObject == null ? null : jm0.a(optJSONObject);
        this.f = sm0Var;
        this.j = zm0.b(jSONObject.optJSONObject(WriteActivityConfig.VIDEO_INFO));
        this.k = um0.a(jSONObject.optJSONArray("prefetch_video"));
        this.l = km0.b(jSONObject.optJSONObject(TiebaMainDatabaseHelper.TABLE_NAME_DOWNLOAD_INFO));
        this.m = om0.a(jSONObject.optJSONObject("enhance"));
        mm0.a(jSONObject.optJSONObject("interaction"));
        JSONObject optJSONObject2 = jSONObject.optJSONObject("operate");
        AdOperator a = optJSONObject2 == null ? null : AdOperator.a(optJSONObject2);
        this.h = a;
        this.d = a != null;
        JSONObject optJSONObject3 = jSONObject.optJSONObject("app_info");
        dn0 c = optJSONObject3 == null ? null : dn0.c(optJSONObject3);
        this.i = (c == null || !c.k) ? null : c;
        JSONArray optJSONArray = jSONObject.optJSONArray("ad_monitor_url");
        int length = optJSONArray == null ? 0 : optJSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject4 = optJSONArray.optJSONObject(i3);
            if (optJSONObject4 != null) {
                String optString = optJSONObject4.optString("show_url");
                String optString2 = optJSONObject4.optString("click_url");
                if (!TextUtils.isEmpty(optString) || !TextUtils.isEmpty(optString2)) {
                    kx0.b(this.e, new MonitorUrl(optString, optString2));
                }
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("tag_list");
        int length2 = optJSONArray2 == null ? 0 : optJSONArray2.length();
        for (int i4 = 0; i4 < length2; i4++) {
            JSONObject optJSONObject5 = optJSONArray2.optJSONObject(i4);
            if (optJSONObject5 != null) {
                String optString3 = optJSONObject5.optString("word");
                if (!TextUtils.isEmpty(optString3)) {
                    kx0.b(this.o, optString3);
                }
            }
        }
        zm0 zm0Var = this.j;
        if (zm0Var != null) {
            zm0Var.d(this);
        }
        this.c = null;
    }

    public void a(@Nullable cn0 cn0Var) {
        List<um0> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cn0Var) == null) {
            this.p = cn0Var;
            if (cn0Var == null || cn0Var.c) {
                this.f.b();
            }
            if ((cn0Var == null || cn0Var.d) && (list = this.k) != null && list.size() > 0) {
                for (um0 um0Var : this.k) {
                    um0Var.b();
                }
            }
        }
    }
}
